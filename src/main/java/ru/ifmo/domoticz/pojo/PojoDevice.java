package ru.ifmo.domoticz.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoDevice {

    @JsonProperty("AddjMulti")
    private double addjMulti;

    @JsonProperty("AddjMulti2")
    private double addjMulti2;

    @JsonProperty("AddjValue")
    private double addjValue;

    @JsonProperty("AddjValue2")
    private double addjValue2;

    @JsonProperty("BatteryLevel")
    private int batteryLevel;

    @JsonProperty("CustomImage")
    private int customImage;

    @JsonProperty("Data")
    private String data;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("DimmerType")
    private String dimmerType;

    @JsonProperty("Favorite")
    private int favorite;

    @JsonProperty("HardwareDisabled")
    private boolean hardwareDisabled;

    @JsonProperty("HardwareID")
    private int hardwareID;

    @JsonProperty("HardwareName")
    private String hardwareName;

    @JsonProperty("HardwareType")
    private String hardwareType;

    @JsonProperty("HardwareTypeVal")
    private int hardwareTypeVal;

    @JsonProperty("HaveDimmer")
    private boolean haveDimmer;

    @JsonProperty("HaveGroupCmd")
    private boolean haveGroupCmd;

    @JsonProperty("HaveTimeout")
    private boolean haveTimeout;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Image")
    private String image;

    @JsonProperty("IsSubDevice")
    private boolean isSubDevice;

    @JsonProperty("LastUpdate")
    private String lastUpdate;

    @JsonProperty("Level")
    private int level;

    @JsonProperty("LevelInt")
    private int levelInt;

    @JsonProperty("MaxDimLevel")
    private int maxDimLevel;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Notifications")
    private String notifications;

    @JsonProperty("PlanID")
    private String planID;

    @JsonProperty("PlanIDs")
    private List<Integer> planIDs;

    @JsonProperty("Protected")
    private boolean isProtected;

    @JsonProperty("ShowNotifications")
    private boolean showNotifications;

    @JsonProperty("SignalLevel")
    private String signalLevel;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("StrParam1")
    private String strParam1;

    @JsonProperty("StrParam2")
    private String strParam2;

    @JsonProperty("SubType")
    private String subType;

    @JsonProperty("SwitchType")
    private String switchType;

    @JsonProperty("SwitchTypeVal")
    private int switchTypeVal;

    @JsonProperty("Timers")
    private String timers;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("TypeImg")
    private String typeImg;

    @JsonProperty("Unit")
    private int unit;

    @JsonProperty("Used")
    private int used;

    @JsonProperty("UsedByCamera")
    private boolean usedByCamera;

    @JsonProperty("XOffset")
    private String xOffset;

    @JsonProperty("YOffset")
    private String yOffset;

    @JsonProperty("idx")
    private int idx;

    public double getAddjMulti() { return addjMulti; }
    public double getAddjMulti2() { return addjMulti2; }
    public double getAddjValue() { return addjValue; }
    public double getAddjValue2() { return addjValue2; }
    public int getBatteryLevel() { return batteryLevel; }
    public int getCustomImage() { return customImage; }
    public String getData() { return data; }
    public String getDescription() { return description; }
    public String getDimmerType() { return dimmerType; }
    public int getFavorite() { return favorite; }
    public boolean isHardwareDisabled() { return hardwareDisabled; }
    public int getHardwareID() { return hardwareID; }
    public String getHardwareName() { return hardwareName; }
    public String getHardwareType() { return hardwareType; }
    public int getHardwareTypeVal() { return hardwareTypeVal; }
    public boolean isHaveDimmer() { return haveDimmer; }
    public boolean isHaveGroupCmd() { return haveGroupCmd; }
    public boolean isHaveTimeout() { return haveTimeout; }
    public String getId() { return id; }
    public String getImage() { return image; }
    public boolean isSubDevice() { return isSubDevice; }
    public String getLastUpdate() { return lastUpdate; }
    public int getLevel() { return level; }
    public int getLevelInt() { return levelInt; }
    public int getMaxDimLevel() { return maxDimLevel; }
    public String getName() { return name; }
    public String getNotifications() { return notifications; }
    public String getPlanID() { return planID; }
    public List<Integer> getPlanIDs() { return planIDs; }
    public boolean isProtected() { return isProtected; }
    public boolean isShowNotifications() { return showNotifications; }
    public String getSignalLevel() { return signalLevel; }
    public String getStatus() { return status; }
    public String getStrParam1() { return strParam1; }
    public String getStrParam2() { return strParam2; }
    public String getSubType() { return subType; }
    public String getSwitchType() { return switchType; }
    public int getSwitchTypeVal() { return switchTypeVal; }
    public String getTimers() { return timers; }
    public String getType() { return type; }
    public String getTypeImg() { return typeImg; }
    public int getUnit() { return unit; }
    public int getUsed() { return used; }
    public boolean isUsedByCamera() { return usedByCamera; }
    public String getXOffset() { return xOffset; }
    public String getYOffset() { return yOffset; }
    public int getIdx() { return idx; }

    @Override
    public String toString() {
        return "PojoDevice{" +
                "addjMulti=" + addjMulti +
                ", addjMulti2=" + addjMulti2 +
                ", addjValue=" + addjValue +
                ", addjValue2=" + addjValue2 +
                ", batteryLevel=" + batteryLevel +
                ", customImage=" + customImage +
                ", data='" + data + '\'' +
                ", description='" + description + '\'' +
                ", dimmerType='" + dimmerType + '\'' +
                ", favorite=" + favorite +
                ", hardwareDisabled=" + hardwareDisabled +
                ", hardwareID=" + hardwareID +
                ", hardwareName='" + hardwareName + '\'' +
                ", hardwareType='" + hardwareType + '\'' +
                ", hardwareTypeVal=" + hardwareTypeVal +
                ", haveDimmer=" + haveDimmer +
                ", haveGroupCmd=" + haveGroupCmd +
                ", haveTimeout=" + haveTimeout +
                ", id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", isSubDevice=" + isSubDevice +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", level=" + level +
                ", levelInt=" + levelInt +
                ", maxDimLevel=" + maxDimLevel +
                ", name='" + name + '\'' +
                ", notifications='" + notifications + '\'' +
                ", planID='" + planID + '\'' +
                ", planIDs=" + planIDs +
                ", isProtected=" + isProtected +
                ", showNotifications=" + showNotifications +
                ", signalLevel='" + signalLevel + '\'' +
                ", status='" + status + '\'' +
                ", strParam1='" + strParam1 + '\'' +
                ", strParam2='" + strParam2 + '\'' +
                ", subType='" + subType + '\'' +
                ", switchType='" + switchType + '\'' +
                ", switchTypeVal=" + switchTypeVal +
                ", timers='" + timers + '\'' +
                ", type='" + type + '\'' +
                ", typeImg='" + typeImg + '\'' +
                ", unit=" + unit +
                ", used=" + used +
                ", usedByCamera=" + usedByCamera +
                ", xOffset='" + xOffset + '\'' +
                ", yOffset='" + yOffset + '\'' +
                ", idx='" + idx + '\'' +
                '}';
    }
}

