package com.ycu.pojo;

import lombok.Data;

@Data
public class project
{
    //项目标题
    private String   ptitle;
    //项目描述
    private String   pdes ;
    //项目负责人
    private String   pcharger;
    //发布时间
    private String  ptime;
    private int  pid    ;
    //项目发布者
    private String   pcreater;

    public project(){}
    public project(String ptitle, String pdes, String pcharger, String ptime, int pid, String  pcreater) {
        this.ptitle = ptitle;
        this.pdes = pdes;
        this.pcharger = pcharger;
        this.ptime = ptime;
        this.pid = pid;
        this.pcreater = pcreater;
    }
}
