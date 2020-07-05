package com.ycu.controller;

import com.ycu.pojo.notice;
import com.ycu.status.systemResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class noticeController
{

    @Resource
    private com.ycu.service.noticeService noticeService;

 @RequestMapping("/insertNotice")
 public systemResult insertNotice(@RequestBody notice notice)
 {
 return noticeService.insertNotice(notice);
 }

 @RequestMapping("/deleteNotice/{id}")
    public systemResult deleteNotice(@PathVariable("id") String id)
 {
     return noticeService.deleteNotice(id);
 }

 @RequestMapping("/updateNotice")
    public systemResult updateNotice(@RequestBody notice notice)
 {
     return noticeService.updateNotice(notice);
 }


 @RequestMapping("/updateNoticeRoot/{nroot}/{nid}")
    public systemResult updateNoticeRoot(@PathVariable("nroot") String nroot,@PathVariable("nid") String nid)
 {
     return noticeService.UpdateNoticeRoot(nroot,nid);
 }

 @RequestMapping("/queryAllNotice")
    public  systemResult queryAllNotice()
 {
     return noticeService.selectAllNotice();
 }

 @RequestMapping("/insertReadCount/{nid}")
    public systemResult insertCount( @PathVariable("nid") String nid)
 {
     return noticeService.InsertReadCount(nid);
 }
@RequestMapping("/queryNoticeById/{id}")
    public systemResult queryByid(@PathVariable("id") String id)
{
    return noticeService.selectNoticeById(id);
}

@RequestMapping("/queryOneNotice/{id}")
    public systemResult queryOne(@PathVariable("id") String id)
{
    return noticeService.selectOneNotice(id);
}
}
