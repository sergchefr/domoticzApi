package ru.ifmo;

import ru.ifmo.domoticz.*;
import ru.ifmo.domoticz.DomoticzApiClient;
import ru.ifmo.domoticz.instances.Switch;

public class Main {
    public static void main(String[] args) {
        Config.init("C:\\Users\\Сергей\\IdeaProjects\\domoiticz api\\src\\main\\config.txt");
        DomoticzApiClient domoticzApiClient = new DomoticzApiClient();
        Switch garageLights = domoticzApiClient.getSwitch("Podval_garage_lights");
    }
}