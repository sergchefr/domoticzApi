package ru.ifmo.domoticz;

import ru.ifmo.domoticz.apis.DeviceControlApi;
import ru.ifmo.domoticz.apis.InfoApi;
import ru.ifmo.domoticz.instances.Device;
import ru.ifmo.domoticz.instances.Switch;
import ru.ifmo.domoticz.pojo.PojoDevice;
import ru.ifmo.domoticz.pojo.PojoSwitch;

import java.util.HashMap;

public class DomoticzApiClient {
    private DeviceControlApi deviceControlApi;
    private InfoApi infoApi;
    private HashMap<Integer, Device> devices;
    private HashMap<Integer, Switch> switches;
    private HashMap<String, Integer> nameToIdx;

    public DomoticzApiClient(String configPath) {
        Config.init(configPath);
        deviceControlApi = new DeviceControlApi();
        infoApi = new InfoApi();
        update();
    }

    public void update(){
        PojoDevice[] devarr = infoApi.getDevices();
        devices = new HashMap<>();
        nameToIdx = new HashMap<>();
        for (PojoDevice pojoDevice : devarr) {
            devices.put(pojoDevice.getIdx(),new Device(pojoDevice,infoApi,deviceControlApi));
            nameToIdx.put(pojoDevice.getName(),pojoDevice.getIdx());
        }

        PojoSwitch[] swarr = infoApi.getLightSwitches();
        switches = new HashMap<>();
        for (PojoSwitch pojoDevice : swarr) {
            switches.put(pojoDevice.getIdx(), new Switch(devices.get(pojoDevice.getIdx()).getInfo(), infoApi,deviceControlApi));
        }
    }

    public Device getDevice(int idx){
        return devices.get(idx);
    }

    public Device getDevice(String name){
        Integer idx = nameToIdx.get(name);
        if(idx==null) return null;
        return devices.get(idx);
    }

    public Switch getSwitch(int idx){
        return switches.get(idx);
    }

    public Switch getSwitch(String name){
        Integer idx = nameToIdx.get(name);
        if(idx==null) return null;
        return switches.get(idx);
    }

    public DeviceControlApi getDeviceControlApi(){
        return deviceControlApi;
    }

    public InfoApi getInfoApi(){
        return infoApi;
    }
}
