package com.ycu.controller;

import com.ycu.pojo.project;
import com.ycu.service.projectService;
import com.ycu.status.systemResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class projectController
{
    @Resource
    private com.ycu.service.projectService projectService;
    @RequestMapping("/queryAllproject")
    public systemResult queryAll ()
    {
        return projectService.selectAllProject();
    }

    @RequestMapping("/insertProject")
    public systemResult insertProject(@RequestBody project project)
    {
        return projectService.insertProject(project);
    }

    @RequestMapping("/updateProject")
    public systemResult updateProject(@RequestBody project project)
    {
        return projectService.updateProject(project);
    }


    @RequestMapping("/deleteProject/{id}")
    public systemResult deleteProject(@PathVariable("id") String id)
    {
        return projectService.deleteProject(id);
    }

    //查看项目及任务
    @RequestMapping("/queryProjectById/{id}")
    public systemResult queryOne(@PathVariable("id") String id)
    {
        return projectService.selectProjectByid(id);
    }



}
