package com.ycu.mapper;

import com.ycu.pojo.notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface noticeMapper
{
    //发公告
    @Insert("insert into notice (nid,ntitle,ncreater,ntime,nroot,ncontent) values(#{nid},#{ntitle},#{ncreater},#{" +
            "ntime},#{nroot},#{ncontent})")
    int insertNotice(notice notice);

    //删除公告
    @Delete("delete from notice  where nid=#{nid}")
    int deleteNotice(@Param("nid") String  nid);

    //编辑公告
    @Update("update notice  set ntitle=#{ntitle},ncontent=#{ncontent}, nroot=#{nroot} where nid=#{nid}")
    int uodateNotice(notice notice);

    //修改阅读等级
    @Update("update notice set nroot=#{nroot} where nid=#{nid}")
    int UpdateNoticeRoot(@Param("nroot") String  nroot,@Param("nid") String  nid);

    //查询所有公告
    @Select("select nid,ntitle,ncreater,ntime,nreadcount,nroot,ncontent from notice")
    List<notice> selectAllNotice();

    //增加阅读量
    @Update("update notice set nroot=nroot+1 where nid=#{nid}")
    int InsertReadCount(@Param("nid") String  nid);

    //用户根据自己的权限查看属于自己的公告
    @Select("select * from notice where nroot=#{nroot} ")
    List<notice> selectNoticeByid(@Param("nroot") String id);


   @Select("select * from notice where nid=#{id}")
    //查询某个公告
    notice selectOneNotice(@Param("id") String id);
}
