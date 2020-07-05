package com.ycu.DTO;

import lombok.Data;

@Data
public class notificationDTO
{
    //未读公告个数
    private int unreadNoticeCount;
    //新的任务个数
    private int unreadNewTaskCount;
    //正在执行的任务
    private int unreadCarryTaskCount;

}
