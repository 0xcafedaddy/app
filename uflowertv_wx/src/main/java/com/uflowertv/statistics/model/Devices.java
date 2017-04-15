package com.uflowertv.statistics.model;

public class Devices extends DevicesKey {
    private String model;

    private String swversion;

    private String devicesystem;

    private String builddevice;

    private String buildid;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getSwversion() {
        return swversion;
    }

    public void setSwversion(String swversion) {
        this.swversion = swversion == null ? null : swversion.trim();
    }

    public String getDevicesystem() {
        return devicesystem;
    }

    public void setDevicesystem(String devicesystem) {
        this.devicesystem = devicesystem == null ? null : devicesystem.trim();
    }

    public String getBuilddevice() {
        return builddevice;
    }

    public void setBuilddevice(String builddevice) {
        this.builddevice = builddevice == null ? null : builddevice.trim();
    }

    public String getBuildid() {
        return buildid;
    }

    public void setBuildid(String buildid) {
        this.buildid = buildid == null ? null : buildid.trim();
    }
}