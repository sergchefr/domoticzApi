package ru.ifmo.domoticz.pojo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoUser {

    private final String enabled;
    private final String password;
    private final int remoteSharing;
    private final int rights;
    private final int tabsEnabled;
    private final String username;
    private final int idx;

    @JsonCreator
    public PojoUser(
            @JsonProperty("Enabled") String enabled,
            @JsonProperty("Password") String password,
            @JsonProperty("RemoteSharing") int remoteSharing,
            @JsonProperty("Rights") int rights,
            @JsonProperty("TabsEnabled") int tabsEnabled,
            @JsonProperty("Username") String username,
            @JsonProperty("idx") int idx
    ) {
        this.enabled = enabled;
        this.password = password;
        this.remoteSharing = remoteSharing;
        this.rights = rights;
        this.tabsEnabled = tabsEnabled;
        this.username = username;
        this.idx = idx;
    }

    public String getEnabled() {
        return enabled;
    }

    public String getPassword() {
        return password;
    }

    public int getRemoteSharing() {
        return remoteSharing;
    }

    public int getRights() {
        return rights;
    }

    public int getTabsEnabled() {
        return tabsEnabled;
    }

    public String getUsername() {
        return username;
    }

    public int getIdx() {
        return idx;
    }

    @Override
    public String toString() {
        return "PojoUser{" +
                "enabled='" + enabled + '\'' +
                ", password='" + password + '\'' +
                ", remoteSharing=" + remoteSharing +
                ", rights=" + rights +
                ", tabsEnabled=" + tabsEnabled +
                ", username='" + username + '\'' +
                ", idx='" + idx + '\'' +
                '}';
    }
}
