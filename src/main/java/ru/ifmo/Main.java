package ru.ifmo;

import ru.ifmo.domoticz.DeviceControlApi;
import ru.ifmo.domoticz.InfoApi;
import ru.ifmo.domoticz.pojo.PojoDevice;

public class Main {
    public static void main(String[] args) {
        InfoApi infoApi = new InfoApi();
        DeviceControlApi deviceControlApi = new DeviceControlApi();


        for (PojoDevice device : infoApi.getDevices()) {
            System.out.println(device);

        }
        //System.out.println(infoApi.getDevice(30));
    }
}