package ru.ifmo.domoticz.instances;

import ru.ifmo.domoticz.apis.DeviceControlApi;
import ru.ifmo.domoticz.apis.InfoApi;
import ru.ifmo.domoticz.pojo.PojoDevice;

public class Switch extends Device {
    private DeviceControlApi deviceControlApi;
    private PojoDevice device;

    public Switch(PojoDevice device, InfoApi infoapi, DeviceControlApi deviceControlApi) {
        super(device, infoapi, deviceControlApi);
        this.deviceControlApi=deviceControlApi;
        this.device = device;
    }

    public void turnOn(){
        deviceControlApi.turnOn(device.getIdx());
    }

    public void turnOff(){
        deviceControlApi.turnOff(device.getIdx());
    }

    public void toggle(){
        deviceControlApi.toggle(device.getIdx());
    }

    public void stop(){
        deviceControlApi.stop(device.getIdx());
    }




}
