package com.ycu.mapper;


import com.ycu.pojo.user;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userMapper
{

    @Select("SELECT * FROM user ")
    List<user>  selectAllUser();

    @Delete("DELETE FROM USER WHERE UNUMBER = #{id}")
    int deleteUser(@Param("id") String  id);

    @Insert("INSERT INTO USER (unumber,uname,uage,ubrith,uaddr,usex,upassword,uisRoot,uisShow) VALUES( #{unumber},#{uname},#{uage},#{ubrith},#{uaddr},#{usex},#{upassword},#{uisRoot},#{uisShow}) ")
    void insertUser(user userOne);

    @Update("UPDATE USER SET UNAME=#{uname},UAGE=#{uage},UBRITH=#{ubrith},UADDR=#{uaddr},USEX=#{usex},uisRoot=#{uisRoot},uisShow=#{uisShow} WHERE UNUMBER=#{unumber}")
    int UpdateUser(user userOne);
    //query by uname and upassowrd
    @Select("select * from user where uname=#{name} and upassword=#{password}")
    user selectUser(@Param("name") String name, @Param("password") String password);
     //查询当前角色所有的成员
    @Select("select * from user where uisRoot=#{uisRoot}")
    List<user> selectByRoot(@Param("uisRoot") String  uisroot);

    //修改角色权限
    @Update("update user set uisShow=#{uisShow} where uname=#{uname}")
    void updateRootByName(@Param("uisShow") String s,@Param("uname") String s1);
     //项目负责人
    @Select("select uname from user where uisRoot=#{uisRoot} ")
    List<String> selectProjectUser(@Param("uisRoot") String uisRoot);

    //修改个人信息
    @Update("update user set uage=#{uage},ubrith=#{ubrith},uaddr=#{uaddr},usex=#{usex} where uname=#{uname}")
    int updateUserInfo(user user);
    //查询信息（用于返回user）
    @Select("select * from user where uname=#{uname}")
    user selectUserByname(@Param("uname") String name);

    //修改密码
    @Update("update user set upassword=#{upassword} where uname=#{uname}")
    int updatePsssword(user user);
}
