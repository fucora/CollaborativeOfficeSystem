package com.ycu.impl;

import com.ycu.DTO.notificationDTO;
import com.ycu.mapper.taskMapper;
import com.ycu.mapper.unreadMapper;
import com.ycu.service.unreadService;
import com.ycu.status.systemResult;
import com.ycu.status.systemStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class unreadImpl implements unreadService
{
    @Resource
    private com.ycu.mapper.taskMapper taskMapper;
    @Resource
    private com.ycu.mapper.unreadMapper unreadMapper;

    @Override
    @Transactional
    public systemResult queryUnread(String name, String judge) {
        notificationDTO notificationDTO = new notificationDTO();


        if(judge=="0")
        {
            notificationDTO.setUnreadNoticeCount(unreadMapper.selectCountByPerson(name));
        }
        else {
            notificationDTO.setUnreadNoticeCount(unreadMapper.selectCountByPerson(name));
           notificationDTO.setUnreadNewTaskCount(taskMapper.selectNewTask(name));
         notificationDTO.setUnreadCarryTaskCount(taskMapper.selectCarryTask(name));
        }

        return  new systemResult(systemStatus.SELECT_SUCCESS,notificationDTO);
    }

    @Override
    public void updateReadStatus(String name, String id) {
        unreadMapper.updateReadStatus(name,id);
    }

    @Override
    public Integer selectOneNoticeStatus(String uname, String unid) {
        try {
            return unreadMapper.selectOneNoticeStatus(uname,unid);
        }
      catch (Exception e)
      {
          return 1;
      }
    }
}
