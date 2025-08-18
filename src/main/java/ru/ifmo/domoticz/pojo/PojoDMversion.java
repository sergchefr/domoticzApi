package ru.ifmo.domoticz.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoDMversion {

    private final String domoticzUpdateURL;
    private final boolean haveUpdate;
    private final int revision;
    private final String systemName;
    private final boolean useUpdate;
    private final String buildTime;
    private final String dzventsVersion;
    private final String hash;
    private final String pythonVersion;
    private final String version;

    @JsonCreator
    public PojoDMversion(
            @JsonProperty("DomoticzUpdateURL") String domoticzUpdateURL,
            @JsonProperty("HaveUpdate") boolean haveUpdate,
            @JsonProperty("Revision") int revision,
            @JsonProperty("SystemName") String systemName,
            @JsonProperty("UseUpdate") boolean useUpdate,
            @JsonProperty("build_time") String buildTime,
            @JsonProperty("dzvents_version") String dzventsVersion,
            @JsonProperty("hash") String hash,
            @JsonProperty("python_version") String pythonVersion,
            @JsonProperty("version") String version
    ) {
        this.domoticzUpdateURL = domoticzUpdateURL;
        this.haveUpdate = haveUpdate;
        this.revision = revision;
        this.systemName = systemName;
        this.useUpdate = useUpdate;
        this.buildTime = buildTime;
        this.dzventsVersion = dzventsVersion;
        this.hash = hash;
        this.pythonVersion = pythonVersion;
        this.version = version;
    }

    public String getDomoticzUpdateURL() { return domoticzUpdateURL; }
    public boolean isHaveUpdate() { return haveUpdate; }
    public int getRevision() { return revision; }
    public String getSystemName() { return systemName; }
    public boolean isUseUpdate() { return useUpdate; }
    public String getBuildTime() { return buildTime; }
    public String getDzventsVersion() { return dzventsVersion; }
    public String getHash() { return hash; }
    public String getPythonVersion() { return pythonVersion; }
    public String getVersion() { return version; }

    @Override
    public String toString() {
        return "PojoDMversion{" +
                "domoticzUpdateURL='" + domoticzUpdateURL + '\'' +
                ", haveUpdate=" + haveUpdate +
                ", revision=" + revision +
                ", systemName='" + systemName + '\'' +
                ", useUpdate=" + useUpdate +
                ", buildTime=" + buildTime +
                ", dzventsVersion='" + dzventsVersion + '\'' +
                ", hash='" + hash + '\'' +
                ", pythonVersion='" + pythonVersion + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
