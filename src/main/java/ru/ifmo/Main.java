package ru.ifmo;

import ru.ifmo.domoticz.DomoticzApiClient;
import ru.ifmo.domoticz.apis.InfoApi;
import ru.ifmo.domoticz.pojo.PojoDevice;

public class Main {
    public static void main(String[] args) {
        DomoticzApiClient client = DomoticzApiClient.getInstance();
        //System.out.println(client.getInfoApi().getDevice(1).getFavorite());
        System.out.println(client.getDevice(43).getInfo().getType());


    }
}