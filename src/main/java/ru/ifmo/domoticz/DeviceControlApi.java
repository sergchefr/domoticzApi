package ru.ifmo.domoticz;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DeviceControlApi{
    private DomoticzApiBridge domoticz;
    private ObjectMapper objectMapper;



    public DeviceControlApi() {
        domoticz = DomoticzApiBridge.getInstance();
        objectMapper = new ObjectMapper();

    }

    public String getLightSwitches(){
        return domoticz.sendRequest("getlightswitches");
    }
}
