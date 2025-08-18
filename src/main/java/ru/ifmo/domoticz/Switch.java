package ru.ifmo.domoticz;

import ru.ifmo.domoticz.pojo.PojoDevice;

public class Switch extends Device{


    public Switch(PojoDevice device, InfoApi infoapi, DeviceControlApi deviceControlApi) {
        super(device, infoapi, deviceControlApi);
    }


}
