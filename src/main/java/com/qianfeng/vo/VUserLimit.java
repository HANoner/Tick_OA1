package com.qianfeng.vo;

import java.util.List;

/**
 * @author feng
 * @create 2019-04-15 下午 4:44
 */
public class VUserLimit {
    private  Integer id;
    private  String no;
    private  String name;
    private  Integer flag;
    private  Integer parentid;
    private List<VUserLimit> rid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public List<VUserLimit> getRid() {
        return rid;
    }

    public void setRid(List<VUserLimit> rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return parentid;
    }

    public void setPid(Integer pid) {
        this.parentid = pid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

}
