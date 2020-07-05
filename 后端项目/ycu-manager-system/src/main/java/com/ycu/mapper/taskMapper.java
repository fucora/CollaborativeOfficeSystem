package com.ycu.mapper;

import com.ycu.pojo.task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface  taskMapper
{

    //创建任务
    @Insert("insert into task (tname,tcreater,tputer,tendtime,tworktime,tstatus,tpid, tcontent,ttype,tpri, treason,tquit) values" +
            "(#{tname},#{tcreater},#{tputer},#{tendtime},#{tworktime},#{tstatus},#{tpid},#{tcontent},#{ttype},#{tpri},#{treason},#{tquit})")
    int insertTask(task task);

    //查看所有该项目中的任务
    @Select("select *  from task where tpid=#{tpid}")
    List<task> selectTaskByPid(@Param("tpid") String pid);

   //改变任务状态
    @Update("update task set tstatus=#{tstatus}  where tid=#{tid}")
    int updateTaskStatusById(@Param("tstatus") String status,@Param("tid") String tid);

    //编辑任务
    @Update("update task set tname=#{tname},tputer=#{tputer}," +
            "tendtime=#{tendtime},tworktime=#{tworktime}, tcontent=#{tcontent}," +
            " ttype=#{ttype},tpri=#{tpri} where tid=#{tid} ")
    int UpdateTask(task task);
    //删除任务
    @Delete("delete from task where tid=#{tid}")
    int deleteTask(@Param("tid") String id);

    //如果删除项目，项目中的任务必须删除
    @Delete("delete from task where tpid=#{id}")
    int deleteTaskByProject(@Param("id") String id);


    //取消任务
    @Update("update task set tstatus=#{tstatus},treason=#{treason},tquit=#{tquit} where tid=#{tid}")
    int cacelTask(task task);

    @Update("update task set tstatus=#{tstatus},tsum=#{tsum} where tid=#{tid}")
    int submitTask(task task);

    @Select("select * from task where tputer=#{name}")
    List<task> queryMyJob(@Param("name") String name);


    //查看新的任务个数
    @Select("select count(*) from task where tputer=#{tputer} and  tstatus=0")
    int selectNewTask(@Param("tputer") String name);

    //查看进行的任务个数
    @Select("select count(*) from task where tputer=#{tputer} and  tstatus=1")
    int selectCarryTask(@Param("tputer") String name);
}
