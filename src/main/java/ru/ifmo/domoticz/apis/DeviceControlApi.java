package ru.ifmo.domoticz.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Request;
import ru.ifmo.domoticz.DomoticzApiBridge;

public class DeviceControlApi{
    private DomoticzApiBridge domoticz;
    private ObjectMapper objectMapper;



    public DeviceControlApi() {
        domoticz = DomoticzApiBridge.getInstance();
        objectMapper = new ObjectMapper();
    }


    public void turnOn(int idx){
        Request requst = new DomoticzApiBridge.RequestBuilder()
                .commandName("switchlight")
                .parameter("idx",Integer.toString(idx))
                .parameter("switchcmd","On")
                .build();
        domoticz.sendRequest(requst);
    }

    public void turnOff(int idx){
        Request requst = new DomoticzApiBridge.RequestBuilder()
                .commandName("switchlight")
                .parameter("idx",Integer.toString(idx))
                .parameter("switchcmd","Off")
                .build();
        domoticz.sendRequest(requst);
    }

    public String toggle(int idx){
        Request requst = new DomoticzApiBridge.RequestBuilder()
                .commandName("switchlight")
                .parameter("idx",Integer.toString(idx))
                .parameter("switchcmd","Toggle")
                .build();
        return domoticz.sendRequest(requst);
    }

    public void stop(int idx){
        Request requst = new DomoticzApiBridge.RequestBuilder()
                .commandName("switchlight")
                .parameter("idx",Integer.toString(idx))
                .parameter("switchcmd","stop")
                .build();
        domoticz.sendRequest(requst);
    }


}
