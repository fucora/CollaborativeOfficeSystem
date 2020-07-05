package com.ycu.service;

import com.ycu.pojo.permission;
import com.ycu.status.systemResult;


import java.util.List;

public interface  permissionService
{
    //查询全部权限组
    systemResult selectAllpermission();

    //新增角色
    systemResult insertPermission(permission permission);

    //修改角色描述和角色权限

    systemResult updatePermission(permission permission);

    //删除角色
    systemResult deletePermission (String id);

    //查询该用户什么权限
    systemResult selectPermissionByRid( String rid);

    //用户究竟可以查看什么级别的内容
    systemResult getReadPermission(int isRoot);
}
