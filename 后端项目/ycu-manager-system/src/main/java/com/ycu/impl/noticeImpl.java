package com.ycu.impl;

import com.ycu.mapper.noticeMapper;
import com.ycu.mapper.unreadMapper;
import com.ycu.mapper.userMapper;
import com.ycu.pojo.notice;
import com.ycu.pojo.project;
import com.ycu.pojo.unread;
import com.ycu.pojo.user;
import com.ycu.service.noticeService;
import com.ycu.status.systemResult;
import com.ycu.status.systemStatus;
import com.zhenzi.sms.ZhenziSmsClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class noticeImpl implements noticeService
{
    private static int anInt = 0;
    @Resource
    private com.ycu.mapper.noticeMapper noticeMapper;

    @Resource
    private com.ycu.mapper.unreadMapper unreadMapper;
    @Resource
    private com.ycu.mapper.userMapper userMapper;

    @Override
    @Transactional
    public systemResult insertNotice(notice notice) {
        //添加公告到数据库
        anInt=noticeMapper.insertNotice(notice);
        //获取当前权限的所有成员
       List<user> users=userMapper.selectByRoot(notice.getNroot()+"");
       unread unread=new unread();
        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "103343", "4ae28a90-d1ed-4963-ba94-6d9c4cf9f1e2");
      //遍历每个当前权限的成员，进行添加未读信息提示，通知所有级别成员
        for(user user:users)
       {
           if(!notice.getNcreater().equals(user.getUname())) {
               unread.setUnid(notice.getNid());
               unread.setUname(user.getUname());
               unread.setUstatus(0);
               unreadMapper.insertNotification(unread);
           }
           if(notice.getNtitle().indexOf("紧急") != -1 )
           {
               try {
                   String s= "尊敬的"+user.getUname()+"，当前有紧急公告，标题是:\" "+notice.getNtitle()+"\" 请及时查看！ 验证码 2500";
                   String result = client.send(user.getUbrith(),s,"dfee_dfdw_xdfd_dfdfd");
                   System.out.println(result);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }
        return anInt==1?(new systemResult(systemStatus.INSERT_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    @Transactional
    public systemResult deleteNotice(String nid) {

        anInt=noticeMapper.deleteNotice(nid);
        unreadMapper.deleteNotification(nid);
        return anInt==1?(new systemResult(systemStatus.DELETE_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    public systemResult updateNotice(notice notice) {
        if(StringUtils.isBlank((notice.getNid()+"")) ||notice.getNid()==0)
        {
            return new systemResult(systemStatus.SELECT_BY_ID_FAIL,null);
        }

        anInt=noticeMapper.uodateNotice(notice);
        return anInt==1?(new systemResult(systemStatus.UPDATE_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));

    }

    @Override
    public systemResult UpdateNoticeRoot(String nroot, String nid) {
        anInt=noticeMapper.UpdateNoticeRoot(nroot,nid);
        return anInt==1?(new systemResult(systemStatus.UPDATE_ROOT_SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    @Transactional
    public systemResult selectAllNotice() {
       List<notice> notices=noticeMapper.selectAllNotice();
       for(notice notice:notices)
       {
           notice.setNreadcount(unreadMapper.selectReadCountByUnid(notice.getNid()));
       }
        return notices==null?(new systemResult(systemStatus.FAIL,null)):( new systemResult(systemStatus.SELECT_SUCCESS,notices));
    }

    @Override
    public systemResult InsertReadCount(String nid) {
        anInt=noticeMapper.InsertReadCount(nid);
        return anInt==1?(new systemResult(systemStatus.SUCCESS,null)):( new systemResult(systemStatus.FAIL,null));
    }

    @Override
    public systemResult selectNoticeById(String userId) {
     List<notice> notices=noticeMapper.selectNoticeByid(userId);
     return notices==null ?(new systemResult(systemStatus.SUCCESS,null)):(new systemResult(systemStatus.SUCCESS,notices));
    }

    @Override
    public systemResult selectOneNotice(String id) {
        notice notice=noticeMapper.selectOneNotice(id);
        return notice==null ?(new systemResult(systemStatus.FAIL,null)):(new systemResult(systemStatus.SELECT_SUCCESS,notice));

    }
}
