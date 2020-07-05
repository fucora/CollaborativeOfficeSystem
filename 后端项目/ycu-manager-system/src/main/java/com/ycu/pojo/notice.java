package com.ycu.pojo;

import lombok.Data;

@Data
public class notice
{//公告编号
    private Integer  nid;
    //阅读量
    private Integer  nreadcount;
    //发布者
    private String  ncreater;
    //阅读级别
    private Integer  nroot;
    //标题
    private String  ntitle;
    //发布日期
    private String   ntime;
    //公告内容
    private String ncontent;
  //是否是你本人
    private String yourname;
     public notice(){}

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getNreadcount() {
        return nreadcount;
    }

    public void setNreadcount(Integer nreadcount) {
        this.nreadcount = nreadcount;
    }

    public String getNcreater() {
        return ncreater;
    }

    public void setNcreater(String ncreater) {
        this.ncreater = ncreater;
    }

    public Integer getNroot() {
        return nroot;
    }

    public void setNroot(Integer nroot) {
        this.nroot = nroot;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }

    public String getNtime() {
        return ntime;
    }

    public void setNtime(String ntime) {
        this.ntime = ntime;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public String getYourname() {
        return yourname;
    }

    public void setYourname(String yourname) {
        this.yourname = yourname;
    }
}
