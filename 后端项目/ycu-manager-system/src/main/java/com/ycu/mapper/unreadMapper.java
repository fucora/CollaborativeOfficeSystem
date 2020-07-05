package com.ycu.mapper;

import com.ycu.pojo.unread;
import org.apache.ibatis.annotations.*;

@Mapper
public interface unreadMapper
{
    //添加未读信息
    @Insert("insert into unread (unid,uname,ustatus) values(#{unid},#{uname},#{ustatus})")
    int insertNotification(unread unread);

    //查找当前未读公告的个数（根据个人）
   @Select(" select count(*) from unread where ustatus=0 and uname=#{uname}")
    int selectCountByPerson(@Param("uname") String uname);
    //修改阅读状态
@Select("update unread set ustatus=1  where uname=#{uname} and unid=#{unid}")
    void updateReadStatus(@Param("uname") String name,@Param("unid") String id);
    //删除公告时同时删除通知信息
      @Delete("delete from unread where unid=#{unid}")
    int deleteNotification(@Param("unid") String unid);
    //统计阅读数
    @Select("select count(*) from unread where unid=#{unid} and  ustatus=1 ")
    int selectReadCountByUnid(@Param("unid") int unid);

    //获取这条信息是否未读还是已读
    @Select("select ustatus from unread where uname=#{uname} and unid=#{unid}")
    Integer selectOneNoticeStatus(@Param("uname") String uname,@Param("unid") String unid);



}
