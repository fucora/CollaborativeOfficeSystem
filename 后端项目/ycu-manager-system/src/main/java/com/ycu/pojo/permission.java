package com.ycu.pojo;

import lombok.Data;

@Data
public class permission
{
    //角色编号
    private int rid;
    //角色名称
    private String   rname ;
    //角色描述
    private String    rdes   ;
    //包含权限
    private String   rinclude;
   public permission(){}
    public permission(int rid, String rname, String rdes, String rinclude) {
        this.rid = rid;
        this.rname = rname;
        this.rdes = rdes;
        this.rinclude = rinclude;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdes() {
        return rdes;
    }

    public void setRdes(String rdes) {
        this.rdes = rdes;
    }

    public String getRinclude() {
        return rinclude;
    }

    public void setRinclude(String rinclude) {
        this.rinclude = rinclude;
    }
}
