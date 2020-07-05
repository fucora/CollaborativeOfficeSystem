package com.ycu.pojo;

import lombok.Data;


public class user
{
    private String  unumber;
private String uname;
private  int uage;
private String ubrith;
private String  uaddr;
private int usex;

private  String upassword;
private String uisRoot;
private String uisShow;

    public String getUnumber() {
        return unumber;
    }

    public void setUnumber(String unumber) {
        this.unumber = unumber;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getUbrith() {
        return ubrith;
    }

    public void setUbrith(String ubrith) {
        this.ubrith = ubrith;
    }

    public String getUaddr() {
        return uaddr;
    }

    public void setUaddr(String uaddr) {
        this.uaddr = uaddr;
    }

    public int getUsex() {
        return usex;
    }

    public void setUsex(int usex) {
        this.usex = usex;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public void setUisRoot(String uisRoot) {
        this.uisRoot = uisRoot;
    }

    public String getUisShow() {
        return uisShow;
    }

    public void setUisShow(String uisShow) {
        this.uisShow = uisShow;
    }

    public String getUisRoot()
    {
        return uisRoot;
    }
    public user (){}
}
