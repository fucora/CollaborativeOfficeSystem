package com.ycu.service;

import com.ycu.pojo.notice;
import com.ycu.status.systemResult;

import java.util.List;

public interface noticeService
{
    //发公告
    systemResult insertNotice(notice notice);

    //删除公告
    systemResult deleteNotice(String  nid);

    //编辑公告
    systemResult updateNotice(notice notice);

    //修改阅读等级
    systemResult UpdateNoticeRoot(String  nroot, String  nid);

    //查询所有公告(管理员)
    systemResult selectAllNotice();

    //增加阅读量
    systemResult InsertReadCount( String  nid);

    //查看公告(自己能看到的)
    systemResult selectNoticeById(String userId);

    //查看某个公告
    systemResult selectOneNotice(String id);
}
