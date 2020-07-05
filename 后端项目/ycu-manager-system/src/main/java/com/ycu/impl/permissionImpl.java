package com.ycu.impl;
import com.ycu.mapper.noticeMapper;

import com.ycu.pojo.*;

import com.ycu.service.permissionService;
import com.ycu.service.userService;
import com.ycu.status.systemResult;
import com.ycu.status.systemStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Component
public class permissionImpl  implements permissionService
{
    private static int anInt = 0;
    @Resource
    private com.ycu.mapper.permissionMapper permissionMapper;

    @Resource
    private userService userService;
    @Override
    public systemResult selectAllpermission() {

        List<permission>  list =permissionMapper.selectAllpermission();
        return list==null?(new systemResult(systemStatus.FAIL,null)):( new systemResult(systemStatus.SELECT_SUCCESS,list));
    }

    @Override
    @Transactional
    public systemResult insertPermission(permission permission) {
         String c=permission.getRinclude();
         StringBuilder builder=new StringBuilder();
        StringBuilder builder1=new StringBuilder();

         if(c.contains("a"))
         {
             builder.append("权限管理 ");
             builder1.append(" 各级人员权限  ");
         }
        if(c.contains("b"))
        {
            builder.append("用户管理 ");
            builder1.append(" 管理公司用户 ");
        }
        if(c.contains("c"))
        {
            builder.append("公告管理 ");
            builder1.append(" 发布普通和紧急公告 ");
        }
        if(c.contains("d"))
        {
            builder.append("项目管理");
            builder1.append(" 发布项目 ");
        }
        if(c.contains("e"))
        {
            builder.append("项目管理");
            builder1.append(" 发布项目及分配任务 ");
        }
        if(c.contains("f"))
        {
            builder.append("项目管理");
            builder1.append(" 执行任务 ");
        }
        if(c.contains("g"))
        {
            builder.append("公告管理");
            builder1.append(" 只查看公告 ");
        }
        permission.setRdes(builder1.toString());
        permission.setRinclude(builder.toString());
        anInt= permissionMapper.insertPermission(permission);
        System.out.println(permission.getRid());
        return anInt==0?(new systemResult(systemStatus.FAIL,null)):( new systemResult(systemStatus.SELECT_SUCCESS,permission.getRid()));

    }

    @Override
    //两个操作 修改用户的权限 修改角色权限 必须一起完成 所以添加事务性操作（要么一起成功，要么一起失败）
    @Transactional
    public systemResult updatePermission(permission permission) {
        //如果权限的角色id为空（无效请求，直接返回错误）
        if(StringUtils.isBlank((permission.getRid()+""))  || permission.getRid()==0)
        {
            return new systemResult(systemStatus.SELECT_BY_ID_FAIL,null);
        }
        String c=permission.getRinclude();
        StringBuilder builder=new StringBuilder();
        StringBuilder builder1=new StringBuilder();
        builder1.delete(0, builder1.length());
        //查找该等级下当前用户的人数
        List<user> users= userService.selectByRoot(permission.getRid()+"");
        //对该等级的成员进行修改等级
        for(user user: users)
        {
            userService.updateRootByName(c,user.getUname());
        }
        if(c.contains("a"))
        {
            builder.append(" 权限管理 ");
            builder1.append(" 各级人员权限  ");
        }
        if(c.contains("b"))
        {
            builder.append(" 用户管理 ");
            builder1.append(" 管理公司用户 ");
        }
        if(c.contains("c") && (!c.contains("g")))
        {
            builder.append(" 公告管理 ");
            builder1.append(" 发布普通和紧急公告 ");
        }
        if(c.contains("d") && (!c.contains("e")) && (!c.contains("f")))
        {
            builder.append(" 项目管理 ");
            builder1.append(" 发布项目 ");
        }
        if(c.contains("e") && (!c.contains("d")) && (!c.contains("f")))
        {
            builder.append(" 项目管理 ");
            builder1.append(" 发布项目及分配任务 ");
        }
        if(c.contains("f") && (!c.contains("e")) && (!c.contains("d")))
        {
            builder.append(" 项目管理 ");
            builder1.append(" 执行任务 ");
        }
        if(c.contains("g") && (!c.contains("c")))
        {
            builder.append(" 公告管理 ");
            builder1.append(" 只查看公告 ");
        }
        permission.setRdes(builder1.toString());
        permission.setRinclude(builder.toString());
        //修改权限，无论成功或失败都返回状态信息
        anInt= permissionMapper.updatePermission(permission);
        return anInt==1?(new systemResult(systemStatus.UPDATE_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));

    }

    @Override
    public systemResult deletePermission(String id) {
        anInt= permissionMapper.deletePermission(id);
        return anInt==1?(new systemResult(systemStatus.DELETE_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    public systemResult selectPermissionByRid(String rid) {
        permission permission=permissionMapper.selectPermissionByRid(rid);
        return permission==null?(new systemResult(systemStatus.FAIL,null)):(new systemResult(systemStatus.SELECT_SUCCESS,permission));
    }

    @Override
    @Transactional
    //得到用户究竟可以访问的阅读级别的内容
    public systemResult getReadPermission(int isRoot)
    {
        List<permission>  list =permissionMapper.selectAllpermission();
        for(permission permission:list)
        {
            //找到该用户角色
            if(permission.getRid()==isRoot)
            {
                if(permission.getRdes().contains("发布普通和紧急公告"))
                {
                  return new systemResult(systemStatus.SELECT_SUCCESS,"super");
                }
                else {
                    return new systemResult(systemStatus.SELECT_SUCCESS,"normal");

                }
            }
        }
        return new systemResult(systemStatus.SELECT_SUCCESS,"?");
    }
}
