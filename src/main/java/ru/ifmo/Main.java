package ru.ifmo;

import ru.ifmo.domoticz.DomoticzApiClient;
import ru.ifmo.domoticz.apis.InfoApi;
import ru.ifmo.domoticz.pojo.PojoDevice;

public class Main {
    public static void main(String[] args) {
        DomoticzApiClient client = new DomoticzApiClient("src/main/resources/config.txt");
        System.out.println(client.getInfoApi().getDevice(58).getName());
    }
}