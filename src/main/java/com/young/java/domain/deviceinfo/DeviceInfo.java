package com.young.java.domain.deviceinfo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2015/12/31.
 */
@XStreamAlias("DeviceInfo")
public class DeviceInfo {

    private String deviceName;
    private String deviceID;
    private String deviceDescription;
    private String deviceLocation;
    private String systemContact;
    private String model;
    private String serialNumber;
    private String macAddress;
    private String firmwareVersion;
    private String firmwareReleasedDate;
    private String encoderVersion;
    private String encoderReleasedDate;
    private String bootVersion;
    private String bootReleasedDate;
    private String hardwareVersion;
    private String deviceType;
    private String telecontrolID;
    private String supportBeep;
    private String supportVideoLoss;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    public String getSystemContact() {
        return systemContact;
    }

    public void setSystemContact(String systemContact) {
        this.systemContact = systemContact;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getFirmwareReleasedDate() {
        return firmwareReleasedDate;
    }

    public void setFirmwareReleasedDate(String firmwareReleasedDate) {
        this.firmwareReleasedDate = firmwareReleasedDate;
    }

    public String getEncoderVersion() {
        return encoderVersion;
    }

    public void setEncoderVersion(String encoderVersion) {
        this.encoderVersion = encoderVersion;
    }

    public String getEncoderReleasedDate() {
        return encoderReleasedDate;
    }

    public void setEncoderReleasedDate(String encoderReleasedDate) {
        this.encoderReleasedDate = encoderReleasedDate;
    }

    public String getBootVersion() {
        return bootVersion;
    }

    public void setBootVersion(String bootVersion) {
        this.bootVersion = bootVersion;
    }

    public String getBootReleasedDate() {
        return bootReleasedDate;
    }

    public void setBootReleasedDate(String bootReleasedDate) {
        this.bootReleasedDate = bootReleasedDate;
    }

    public String getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getTelecontrolID() {
        return telecontrolID;
    }

    public void setTelecontrolID(String telecontrolID) {
        this.telecontrolID = telecontrolID;
    }

    public String getSupportBeep() {
        return supportBeep;
    }

    public void setSupportBeep(String supportBeep) {
        this.supportBeep = supportBeep;
    }

    public String getSupportVideoLoss() {
        return supportVideoLoss;
    }

    public void setSupportVideoLoss(String supportVideoLoss) {
        this.supportVideoLoss = supportVideoLoss;
    }


}
