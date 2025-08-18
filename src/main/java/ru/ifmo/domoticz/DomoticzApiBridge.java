package ru.ifmo.domoticz;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Base64;
import java.util.LinkedList;

public class DomoticzApiBridge {
    private OkHttpClient conn;
    private volatile static DomoticzApiBridge instance;

    public DomoticzApiBridge(){
        conn= new OkHttpClient();
    }

    public String sendRequest(Request request){
        try(Response response = conn.newCall(request).execute()){
            if(!response.isSuccessful()) throw new IOException(response.code() + " " + response.message());

            return response.body().string();
        }catch (IOException e){
            e.printStackTrace();
            return "ошибка получения ответа";
        }
    }

    public String sendRequest(String strCommand){
        Request request = new DomoticzApiBridge.RequestBuilder().commandName(strCommand).build();
        return sendRequest(request);
    }

    public static class RequestBuilder{
        private String ip;
        private String login;
        private String password;
        private LinkedList<String> parameters;
        private String comname;
        private Config config;

        public RequestBuilder() {
            parameters = new LinkedList<>();
            config = Config.getInstance();
            ip = config.getIp();
            login = config.getLogin();
            password = config.getPassword();
        }

        public RequestBuilder ip (String ip){
            this.ip = ip;
            return this;
        }

        public RequestBuilder login (String login){
            this.login = login;
            return this;
        }

        public RequestBuilder password (String password){
            this.password = password;
            return this;
        }

        public RequestBuilder parameter(String name, String value){
            parameters.addLast(name+"="+value);
            return this;
        }
        
        public RequestBuilder commandName(String name){
            comname = name;
            return this;
        }

        public Request build(){
            String encodedLogin = Base64.getEncoder().encodeToString((login+":"+password).getBytes());
            StringBuilder urlBuilder = new StringBuilder();
            urlBuilder.append("http://")
                    .append(ip)
                    .append("/json.htm?type=command&param=")
                    .append(comname);
            for (String s : parameters) {
                urlBuilder.append("&").append(s);
            }
            return new Request.Builder()
                    .url(urlBuilder.toString())
                    .header("Authorization", "Basic "+encodedLogin)
                    .build();
        }


    }

    public static DomoticzApiBridge getInstance() {
        if(instance==null){
            synchronized (DomoticzApiBridge.class){
                if(instance==null){
                    instance = new DomoticzApiBridge();
                }
            }
        }
        return instance;
    }
}
