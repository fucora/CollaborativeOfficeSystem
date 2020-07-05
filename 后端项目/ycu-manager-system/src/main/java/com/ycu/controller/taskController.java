package com.ycu.controller;

import com.ycu.pojo.task;
import com.ycu.service.taskService;
import com.ycu.service.unreadService;
import com.ycu.status.systemResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class taskController
{
    @Resource
    private com.ycu.service.taskService taskService;
    @Resource
    private com.ycu.service.unreadService unreadService;

    @RequestMapping("/insertTask")
    public systemResult insertTask(@RequestBody task task){
        return  taskService.insertTask(task);
    }
    //查询该项目中的所有任务
    @RequestMapping("selectTaskByPid/{id}")
    public systemResult selectByID(@PathVariable("id") String id)
    {
        return taskService.selectTaskByPid(id);
    }
    @RequestMapping("/UpdateTaskStatus/{status}/{id}")
    public systemResult updateStatus(@PathVariable("id") String id,
                                     @PathVariable("status") String status)
    {
        return taskService.updateTaskStatusById(status,id);
    }
    @RequestMapping("/UpdateTask")
    public systemResult updateTask(@RequestBody task task)
    {
        return taskService.UpdateTask(task);
    }
    @RequestMapping("/deleteTask/{id}")
    public systemResult deleteTask(@PathVariable("id") String id)
    {
        return taskService.deleteTask(id);
    }

    @RequestMapping("/cacelTask")
    public systemResult cacelTask(@RequestBody task task)
    {
        return taskService.cacelTask(task);
    }
    @RequestMapping("/submitTask")
    public systemResult submitTask(@RequestBody task task)
    {
        return taskService.submitTask(task);
    }


    //查找自己负责的项目
    @RequestMapping("/querymyjob/{uname}")
    public systemResult querymyjob(@PathVariable("uname") String name)
    {
        return taskService.queryMyJob(name);
    }


    //用户未读消息框
    //judge为0 只返回未读公告个数 judge为1 +两个任务信息
    @RequestMapping("/queryReadCount/{name}/{judge}")
    public systemResult queryUnread(@PathVariable("name") String name,
                                    @PathVariable("judge") String judge)
    {
        return unreadService.queryUnread(name,judge);
    }



}
