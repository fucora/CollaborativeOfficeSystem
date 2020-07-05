package com.ycu.impl;


import com.ycu.DTO.protaskDTO;
import com.ycu.mapper.noticeMapper;
import com.ycu.mapper.taskMapper;
import com.ycu.pojo.notice;
import com.ycu.pojo.project;
import com.ycu.pojo.task;
import com.ycu.service.projectService;

import com.ycu.status.systemResult;
import com.ycu.status.systemStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class projectImpl implements projectService
{
    private static int anInt = 0;
    @Resource
    private com.ycu.mapper.projectMapper projectMapper;

    @Resource
    private taskMapper taskMapperr;

    @Override
    public systemResult selectAllProject() {

       List<project> projects= projectMapper.selectAllProject();
        return projects==null?(new systemResult(systemStatus.FAIL,null)):( new systemResult(systemStatus.SELECT_SUCCESS,projects));
    }

    @Override
    public systemResult insertProject(project project) {

        anInt= projectMapper.insertProject(project);
        return anInt==1?(new systemResult(systemStatus.INSERT_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    public systemResult updateProject(project project) {

         if(StringUtils.isBlank((project.getPid()+""))  || project.getPid()==0)
        {
            return new systemResult(systemStatus.SELECT_BY_ID_FAIL,null);
        }
        anInt= projectMapper.updateProject(project);
        return anInt==1?(new systemResult(systemStatus.UPDATE_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));

    }

    @Override
    @Transactional
    //如果项目和项目中的任务都删除了，再成功返回
    public systemResult deleteProject(String pid) {
        anInt= projectMapper.deleteProject(pid);
        int anInt1=taskMapperr.deleteTaskByProject(pid);
        return (anInt==1 && anInt1==1)?(new systemResult(systemStatus.DELETE_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));

    }

    @Override
    @Transactional
    public systemResult selectProjectByid(String id) {
       project project=projectMapper.selectProjectById(id);
       if(project!=null)
       {
           List<task> tasks=taskMapperr.selectTaskByPid((project.getPid()+""));
          if(tasks!=null)
          {
              return new systemResult(systemStatus.SELECT_SUCCESS,new protaskDTO(project,tasks));
          }
           return new systemResult(systemStatus.SELECT_SUCCESS,project);
       }

         return new systemResult(systemStatus.FAIL,null);
    }
}
