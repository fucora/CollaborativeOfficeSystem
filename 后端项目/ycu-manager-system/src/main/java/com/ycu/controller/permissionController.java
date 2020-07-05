package com.ycu.controller;

import com.ycu.pojo.permission;
import com.ycu.service.noticeService;
import com.ycu.service.permissionService;
import com.ycu.status.systemResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class permissionController

{ @Resource
   private com.ycu.service.permissionService permissionService;

    @RequestMapping("/insertPermission")
    public systemResult  insertPermission(@RequestBody permission permission)
    {
        return permissionService.insertPermission(permission);
    }

    @RequestMapping("/queryAllPermission")
    public systemResult queryAllPermission()
    {
        return permissionService.selectAllpermission();
    }

    @RequestMapping("/updatePermission")
    public systemResult updatePermission(@RequestBody permission permission)
    {
        return permissionService.updatePermission(permission);
    }
    @RequestMapping("/deletePermission/{id}")
    public systemResult deletePermission(@PathVariable("id") String id)
    {
        return permissionService.deletePermission(id);
    }

    @RequestMapping("/queryPermission/{id}")
    public  systemResult selectPER(@PathVariable("id") String id)
    {
        return permissionService.selectPermissionByRid(id);
    }
    //获取用户想要的阅读级别
    @RequestMapping("/getReadPermission/{id}")
    public systemResult getReadPer(@PathVariable int id)
    {
        return permissionService.getReadPermission(id);
    }
}
