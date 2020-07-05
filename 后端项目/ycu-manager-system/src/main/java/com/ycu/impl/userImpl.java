package com.ycu.impl;

import com.ycu.mapper.permissionMapper;
import com.ycu.mapper.userMapper;
import com.ycu.pojo.permission;
import com.ycu.pojo.user;
import com.ycu.service.userService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class userImpl  implements userService
{
    private static  String reserveRoot(String s)
    {
        StringBuilder builder1=new StringBuilder();
        if(s.contains("各级人员权限"))
        {
            builder1.append("a");
        }
        if(s.contains("管理公司用户"))
        {
            builder1.append("b");
        }
        if(s.contains("发布普通和紧急公告"))
        {
            builder1.append("c");
        }
        if(s.contains("发布项目") &&s.contains("发布项目及分配任务"))
        {
            builder1.append("e");
        }
      else if (s.contains("发布项目"))
        {
            builder1.append("d");
        }
        if(s.contains("执行任务"))
        {
            builder1.append("f");
        }
        if(s.contains("只查看公告"))
        {
            builder1.append("g");
        }
        return builder1.toString();
    }
    private static final String ProjectName="项目经理";
    private static final String StaffName="普通员工";
    @Resource
    private userMapper userMapper;

    @Resource
    private com.ycu.mapper.permissionMapper permissionMapper;

    @Override
    public List<user> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public int deleteUser(String id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public void inseertUser(user userOne)
    {
        permission permission=permissionMapper.selectByName(userOne.getUisRoot());
         userOne.setUisRoot(permission.getRid()+"");
         String s=permission.getRdes();

        userOne.setUisShow(reserveRoot(s));
         userMapper.insertUser(userOne);

    }

    @Override
    public int UpdateUser(user userOne) {
        permission permission=permissionMapper.selectByName(userOne.getUisRoot());
        userOne.setUisRoot(permission.getRid()+"");
        String s=permission.getRdes();
        userOne.setUisShow(reserveRoot(s));
        return userMapper.UpdateUser(userOne);
    }

    @Override
    public user selectUser(String name, String password) {
        return userMapper.selectUser(name,password);
    }

    @Override
    public List<user> selectByRoot(String uisroot) {
        return userMapper.selectByRoot(uisroot);
    }

    @Override
    public void updateRootByName(String s, String s1) {
      userMapper.updateRootByName(s,s1);
    }

    @Override
    public List<String> selectProjectUser() {

        String  id=permissionMapper.selectByLikeName(ProjectName);
        return userMapper.selectProjectUser(id);
    }

    @Override
    public List<String> selectStaff() {
        String  id=permissionMapper.selectByLikeName(StaffName);
        return userMapper.selectProjectUser(id);
    }

    @Override
    @Transactional
    public user  updateUserInfo(user user) {
     userMapper.updateUserInfo(user);
     return userMapper.selectUserByname(user.getUname());
    }

    @Override
    @Transactional
    public user updatePsssword(user user) {
       userMapper.updatePsssword(user);
        return userMapper.selectUserByname(user.getUname());
    }
}
