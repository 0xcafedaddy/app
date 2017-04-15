package com.uflowertv.statistics.model;

import java.util.Date;

public class Special {
    private Integer id;

    private Date dt;

    private Integer platformid;

    private String zoneid;

    private String deviceid;

    private Integer zhuantiid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Integer getPlatformid() {
        return platformid;
    }

    public void setPlatformid(Integer platformid) {
        this.platformid = platformid;
    }

    public String getZoneid() {
        return zoneid;
    }

    public void setZoneid(String zoneid) {
        this.zoneid = zoneid == null ? null : zoneid.trim();
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid == null ? null : deviceid.trim();
    }

    public Integer getZhuantiid() {
        return zhuantiid;
    }

    public void setZhuantiid(Integer zhuantiid) {
        this.zhuantiid = zhuantiid;
    }
}