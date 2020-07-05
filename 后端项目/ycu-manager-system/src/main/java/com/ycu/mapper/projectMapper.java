package com.ycu.mapper;


import com.ycu.pojo.project;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface projectMapper
{
    //查看所有项目
    @Select("select pid,ptitle,pdes,pcreater,pcharger,ptime from project")
    List<project> selectAllProject();


    //创建项目
    @Insert("insert into project (pid,ptitle,pdes,pcreater,pcharger,ptime) values" +
            "(#{pid},#{ptitle},#{pdes},#{pcreater},#{pcharger},#{ptime})")
      int insertProject(project project);

    //编辑项目
    @Update("update project set ptitle=#{ptitle},pcharger=#{pcharger}," +
            "pdes=#{pdes} where pid=#{pid}")
    int updateProject(project project);

    //删除项目
    @Delete("delete from project where pid=#{pid}")
    int deleteProject(@Param("pid") String pid);

    //查询某个项目
    @Select("select * from project where pid=#{id}")
    project selectProjectById(@Param("id") String id);




}
