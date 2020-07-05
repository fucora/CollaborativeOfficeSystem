package com.ycu.service;

import com.ycu.pojo.project;
import com.ycu.status.systemResult;


import java.util.List;

public interface projectService
{
    //查看所有项目
    systemResult selectAllProject();


    //创建项目
    systemResult insertProject(project project);

    //编辑项目
    systemResult updateProject(project project);

    //删除项目
    systemResult deleteProject( String pid);

    //查看某个项目及任务
    systemResult selectProjectByid( String id);
}
