package ru.ifmo.domoticz.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PojoSwitch {
    @JsonProperty("DimmerLevels")
    private String dimmerLevels;

    @JsonProperty("IsDimmer")
    private boolean isDimmer;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("SubType")
    private String subType;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("idx")
    private int idx;

    // геттеры
    public String getDimmerLevels() { return dimmerLevels; }
    public boolean isDimmer() { return isDimmer; }
    public String getName() { return name; }
    public String getSubType() { return subType; }
    public String getType() { return type; }
    public int getIdx() { return idx; }
}
