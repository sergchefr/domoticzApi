package ru.ifmo.domoticz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Config {
    private String ip;
    private String login;
    private String password;
    private HashMap<String, String> data;

    private volatile static Config instance;

    private Config(String filePath) {
        data = new HashMap<>();
        try {
            Files.lines(Paths.get(filePath)).forEach(string -> {
                String[] s = string.split(":");
                if(s.length!=2) System.err.println("Error while reading Config line: "+string);
                data.put(s[0],s[1]);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(data.containsKey("ip")&&data.containsKey("port")){
            ip = data.get("ip")+":"+data.get("port");
        }else{
            throw new RuntimeException("Config must have ip and port parameters");
        }

        if(data.containsKey("login")&&data.containsKey("password")){
            login = "java";
            password = "aC5981757";
        }else{
            throw new RuntimeException("Config must have login and password parameter");
        }
    }

    private Config(String ip, String login, String password){
        this.ip = ip;
        this.login = login;
        this.password = password;
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
        if(instance==null) throw new RuntimeException("Config had not been initialised before it's call");
        return instance;
    }

    public static void init(String filepath){
        if(instance==null){
            synchronized (Config.class){
                if(instance==null){
                    instance = new Config(filepath);
                }
            }
        }
    }
    public static void init(String ipport, String login, String password){
        if(instance==null){
            synchronized (Config.class){
                if(instance==null){
                    instance = new Config(ipport,login,password);
                }
            }
        }
    }
}
