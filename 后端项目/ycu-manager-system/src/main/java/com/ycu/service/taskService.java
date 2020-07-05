package com.ycu.service;

import com.ycu.pojo.task;
import com.ycu.status.systemResult;

import java.util.List;

public interface taskService
{
    //创建任务
    systemResult insertTask(task task);

    //查看所有该项目中的任务
    systemResult selectTaskByPid(String pid);

    //改变任务状态
    systemResult updateTaskStatusById( String status,String tid);

    //编辑任务
    systemResult UpdateTask(task task);

    //删除任务
    systemResult deleteTask(String id);
     //取消任务
     systemResult cacelTask(task task);

     //提交任务总结
    systemResult submitTask(task task);

    //查找自己负责的任务
    systemResult queryMyJob(String name);
}
