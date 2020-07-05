package com.ycu.service;

import com.ycu.status.systemResult;

public interface unreadService {
  systemResult queryUnread(String name ,String judge);
  //员工已阅读
    void  updateReadStatus( String name, String id);
    Integer selectOneNoticeStatus(String uname, String unid);

}
