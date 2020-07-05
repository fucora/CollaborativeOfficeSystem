package com.ycu.mapper;

import java.util.List;
import com.ycu.pojo.permission;
import org.apache.ibatis.annotations.*;

@Mapper
public interface permissionMapper
{
    //查询全部权限组
    @Select("select   rid ,  rname   ,  rdes    ,  rinclude  from permission")
    List<permission> selectAllpermission();
    //新增角色
   @Insert("insert into permission(rid,rname,rdes,rinclude) values(#{rid},#{rname},#{rdes},#{rinclude})")
   @Options(useGeneratedKeys=true, keyProperty="rid", keyColumn="rid")
    int insertPermission(permission permission);
    //修改角色描述和角色权限
    @Update("update permission set rname=#{rname},rdes=#{rdes},rinclude=#{rinclude} where rid=#{rid}")
    int updatePermission(permission permission);
    //删除角色
    @Delete("delete from permission where rid=#{id}")
    int deletePermission(@Param("id") String id);
   @Select("select rid from permission where rname like concat ('%',#{search},'%') ")
    String selectByLikeName(@Param("search") String name);

   //查询该用户角色
    @Select("select * from permission where rid=#{rid} ")
    permission selectPermissionByRid(@Param("rid") String rid);

    @Select("select * from permission where rname =#{rname} ")
    permission selectByName(@Param("rname") String name);

}
