package ru.ifmo.domoticz.instances;

import ru.ifmo.domoticz.apis.DeviceControlApi;
import ru.ifmo.domoticz.apis.InfoApi;
import ru.ifmo.domoticz.pojo.PojoDevice;

public class Device {
    private PojoDevice info;
    private InfoApi infoapi;
    private DeviceControlApi deviceControlApi;

    public Device(PojoDevice device, InfoApi infoapi, DeviceControlApi deviceControlApi){
        info = device;
        this.infoapi = infoapi;
        this.deviceControlApi = deviceControlApi;
    }

    public void update(){
        info = infoapi.getDevice(info.getIdx());
    }

    public PojoDevice getInfo(){
        return info;
    }




}
