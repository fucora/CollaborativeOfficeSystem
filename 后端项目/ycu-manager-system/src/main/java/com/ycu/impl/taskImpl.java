package com.ycu.impl;


import com.ycu.pojo.task;
import com.ycu.service.taskService;
import com.ycu.status.systemResult;
import com.ycu.status.systemStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class taskImpl implements taskService

{
    private static int anInt = 0;
    @Resource
    private com.ycu.mapper.taskMapper taskMapper;
    @Override
    public systemResult insertTask(task task) {
        anInt= taskMapper.insertTask(task);
        return anInt==1?(new systemResult(systemStatus.INSERT_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    public systemResult selectTaskByPid(String pid) {
        List<task> tasks= taskMapper.selectTaskByPid(pid);
        if(tasks!=null)
        {
            return new systemResult(systemStatus.SELECT_SUCCESS,tasks);
        }
        return  new systemResult(systemStatus.SELECT_SUCCESS,null);

    }

    @Override
    public systemResult updateTaskStatusById(String status,String tid) {

        anInt= taskMapper.updateTaskStatusById(status,tid);
        return anInt==1?(new systemResult(systemStatus.UPDATE_TASK_STATUS_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    public systemResult UpdateTask(task task) {
        if(StringUtils.isBlank((task.getTid()+"")) ||task.getTid()==0)
        {
            return new systemResult(systemStatus.SELECT_BY_ID_FAIL,null);
        }
        anInt= taskMapper.UpdateTask(task);
        return anInt==1?(new systemResult(systemStatus.UPDATE_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    public systemResult deleteTask(String id) {

        anInt= taskMapper.deleteTask(id);
        return anInt==1?(new systemResult(systemStatus.DELETE_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    public systemResult cacelTask(task task) {
        anInt= taskMapper.cacelTask(task);
        return anInt==1?(new systemResult(systemStatus.DELETE_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    public systemResult submitTask(task task) {
        anInt= taskMapper.submitTask(task);
        return anInt==1?(new systemResult(systemStatus.DELETE_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    public systemResult queryMyJob(String name) {
        List<task> tasks= taskMapper.queryMyJob(name);
        if(tasks!=null)
        {
            return new systemResult(systemStatus.SELECT_SUCCESS,tasks);
        }
        return  new systemResult(systemStatus.SELECT_SUCCESS,null);
    }
}
