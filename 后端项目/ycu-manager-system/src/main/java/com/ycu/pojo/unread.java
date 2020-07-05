package com.ycu.pojo;

import lombok.Data;

@Data
public class unread
{

    private int uid;
    //公告id
    private int unid;
    //阅读者姓名
    private String uname;
    //阅读状态
    private int ustatus;
}
