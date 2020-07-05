package com.ycu.service;

import com.ycu.pojo.user;


import java.util.List;

public interface userService
{
    //查询用户
    List<user> selectAllUser();
    //删除用户
    int  deleteUser( String  id);
    //增加用户
    void inseertUser(user userOne);
    //修改用户
    int UpdateUser(user userOne);
    user selectUser( String name,String password);
    List<user> selectByRoot( String uisroot);
    void updateRootByName( String s,String s1);
    //查找可以承担项目的负责人
    List<String> selectProjectUser();

    List<String> selectStaff();
    //修改个人信息
    user  updateUserInfo(user user);
    //修改密码
    user updatePsssword(user user);
}
