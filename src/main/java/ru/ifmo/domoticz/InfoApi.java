package ru.ifmo.domoticz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.ifmo.domoticz.pojo.PojoDMversion;
import ru.ifmo.domoticz.pojo.PojoDevice;
import ru.ifmo.domoticz.pojo.PojoUser;

public class InfoApi {
    private DomoticzApiBridge domoticz;
    private ObjectMapper objectMapper;


    public InfoApi() {
        domoticz = DomoticzApiBridge.getInstance();
        objectMapper = new ObjectMapper();
    }

    public PojoDMversion getVersion(){
        try {
            String json = domoticz.sendRequest("getversion");
            PojoDMversion version =objectMapper.readValue(json, PojoDMversion.class);
            return version;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
            //TODO сделать правильные исключения
        }
    }

    public PojoUser[] getUsers(){
        try {
            String json = domoticz.sendRequest("getusers");
            JsonNode root = objectMapper.readTree(json);
            JsonNode resnode = root.get("result");
            return objectMapper.treeToValue(resnode, PojoUser[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public PojoUser getUser(String name){
        PojoUser[] userarray = getUsers();
        for (PojoUser pojoUser : userarray) {
            if(pojoUser.getUsername().equals(name)){
                return pojoUser;
            }
        }
        return null;
        //TODO rewrite to exceptions
    }

    public PojoUser getUser(int idx){
        PojoUser[] userarray = getUsers();
        for (PojoUser pojoUser : userarray) {
            if(pojoUser.getIdx()==idx){
                return pojoUser;
            }
        }
        return null;
        //TODO rewrite to exceptions
    }

    public String getSettings(){
        return domoticz.sendRequest("getsettings");
        //TODO pojo/map
    }

    //TODO getLog

    //TODO addLogMessage

    public PojoDevice[] getDevices(){
        try {
            String json = domoticz.sendRequest("getdevices");
            JsonNode root = objectMapper.readTree(json);
            JsonNode resnode = root.get("result");
            return objectMapper.treeToValue(resnode, PojoDevice[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public PojoDevice getDevice(String name){
        for (PojoDevice device : getDevices()) {
            if(device.getName().equals(name)) return device;
        }
        return null;
    }

    public PojoDevice getDevice(int idx){
        for (PojoDevice device : getDevices()) {
            if(device.getIdx()==idx) return device;
        }
        return null;
    }

    //TODO device list

    public String getDeviceList(){
        return domoticz.sendRequest("devices_list");
    }

    public String getServerTime(){
        return domoticz.sendRequest("getServerTime");
    }

    public String getSunriseSet(){
        return domoticz.sendRequest("getSunRiseSet");
    }

    //TODO sendNotification

    //TODO allowNewHardware

}
