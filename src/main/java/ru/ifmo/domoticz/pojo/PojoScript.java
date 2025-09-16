package ru.ifmo.domoticz.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PojoScript {
    @JsonProperty("eventstatus")
    private int eventStatus;

    @JsonProperty("id")
    private int id;

    @JsonProperty("interpreter")
    private String interpreter;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("xmlstatement")
    private String xmlstatement;


    public int getEventStatus() {
        return eventStatus;
    }

    public int getId() {
        return id;
    }

    public String getInterpreter() {
        return interpreter;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getXmlstatement() {
        xmlstatement = xmlstatement.replace("\\\\","\\");
        return xmlstatement;
    }
}
