package com.ycu.pojo;

import lombok.Data;

@Data
public class task
{
    private  int  tid  ;
    //创建者（项目经理）
    private  String    tcreater;
    //预计工时
    private  int  tworktime;
    //状态 0：未开始 1：已开始
    private  int   tstatus;
    //项目外键
    private  int   tpid   ;
    //任务名称
    private String  tname   ;
    //员工（实施者）
    private String   tputer   ;
    //截止日期
    private String   tendtime;
     //任务总结
    private String tsum;



     //任务内容
    private String tcontent;
    //任务类型
    private String ttype;
    //任务优先级
    private String tpri;
    //任务取消原因
    private String treason;
    //任务取消者
    private String tquit;


    public  task(){}
}
