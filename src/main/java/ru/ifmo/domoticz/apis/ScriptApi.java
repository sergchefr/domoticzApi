package ru.ifmo.domoticz.apis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import ru.ifmo.domoticz.DomoticzApiBridge;
import ru.ifmo.domoticz.pojo.PojoScript;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ScriptApi {
    private final DomoticzApiBridge domoticz;

    public ScriptApi() {
        domoticz = DomoticzApiBridge.getInstance();
    }

    public void enable(PojoScript script){
        DomoticzApiBridge.RequestBuilder requestBuilder = new DomoticzApiBridge.RequestBuilder();
        requestBuilder.commandName("events");

        String boundary = "WebKitFormBoundaryxDk18id5fNdrKtyo";
        MultipartBody body = new MultipartBody.Builder(boundary)
                .setType(MultipartBody.FORM)
                .addFormDataPart("evparam","create")
                .addFormDataPart("eventid","28")
                .addFormDataPart("name","street_lights")
                .addFormDataPart("interpreter","dzVents")
                .addFormDataPart("eventtype","All")
                .addFormDataPart("xml", script.getXmlstatement())
                .addFormDataPart("logicarray","undefined")
                .addFormDataPart("eventstatus","1")
                .build();



        Request request = new Request.Builder()
                .url(requestBuilder.build().url())
                .addHeader("Authorization",requestBuilder.build().header("Authorization"))
                .post(body).build();
        //System.out.println(requestBuilder.build().header("Authorization"));
        System.out.println(domoticz.sendRequest(request));
    }

    public ArrayList<PojoScript> getPojoScripts(){
        ArrayList<PojoScript> scripts = new ArrayList<>();
        DomoticzApiBridge.RequestBuilder requestBuilder = new DomoticzApiBridge.RequestBuilder();
        requestBuilder.commandName("events")
                .parameter("evparam","list");
        String response = domoticz.sendRequest(requestBuilder.build());

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response);
            JsonNode result = root.get("result");
            for (JsonNode jsonNode : result) {
                String id = jsonNode.get("id").asText();
                scripts.add(getScript(id));
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return scripts;
    }

    public PojoScript getScript(String id){
        try {
            DomoticzApiBridge.RequestBuilder requestBuilder = new DomoticzApiBridge.RequestBuilder();
            requestBuilder.commandName("events")
                    .parameter("evparam","load")
                    .parameter("event",id);
            String response = domoticz.sendRequest(requestBuilder.build());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            JsonNode result =root.get("result").get(0);
            //System.out.println(result.toPrettyString());
            return mapper.readValue(result.toPrettyString(),PojoScript.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
