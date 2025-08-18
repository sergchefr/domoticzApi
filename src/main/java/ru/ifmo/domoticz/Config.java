package ru.ifmo.domoticz;

public class Config {
    private String ip;
    private String login;
    private String password;

    private volatile static Config instance;

    private Config() {
        ip = "192.168.1.42:8080";
        login = "java";
        password = "aC5981757";
    }

    public String getIp() {
        return ip;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static Config getInstance() {
        if(instance==null){
            synchronized (Config.class){
                if(instance==null){
                    instance = new Config();
                }
            }
        }
        return instance;
    }
}
