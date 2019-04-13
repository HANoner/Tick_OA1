package com.qianfeng.vo;

import java.util.List;

/**
 * @author feng
 * @create 2019-04-13 下午 3:41
 */
public class VMenuList {
    public  Integer tid;
    public String title;
    public String aurl;
    public String tname;

    public List<VMenuList> vlist;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getAurl() {
        return aurl;
    }

    public void setAurl(String aurl) {
        this.aurl = aurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }


    public List<VMenuList> getVlist() {
        return vlist;
    }

    public void setVlist(List<VMenuList> vlist) {
        this.vlist = vlist;
    }

}
