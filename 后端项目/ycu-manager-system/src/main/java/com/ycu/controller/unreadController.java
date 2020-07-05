package com.ycu.controller;

import com.ycu.service.unreadService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class unreadController
{
    @Resource
    private com.ycu.service.unreadService unreadService;

    @RequestMapping("/updateUnreadStatus/{name}/{id}")
    public void updateStatus(@PathVariable("name") String name,
                            @PathVariable("id") String id)
    {
     unreadService.updateReadStatus(name,id);
    }
    @RequestMapping("/selectStatus/{uname}/{unid}")
    public Integer selectStatus(@PathVariable("uname") String uname,
                            @PathVariable("unid") String unid)
    {
        return unreadService.selectOneNoticeStatus(uname,unid);
    }
}
