package io.github.vinchauhan.gigaspaces.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(value = "gigaspaces")
public class GigaspaceConfigProperties {

    @NotNull
    /**
     * Type of transmission , unicast, multicast
     */
    private String transmission;
    private String host="localhost";
    private int port=4174;
    private String locators="localhost:4174";
    private String spaceUrl;
    private String space="demo";

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getLocators() {
        return locators;
    }

    public String getSpaceUrl() {
        if(this.spaceUrl != null) {
            return spaceUrl;
        }
        if(getTransmission().equalsIgnoreCase("unicast")) {
            return "jini://"+getHost()+"/*/"+getSpace();
        } else {
            return "jini://*/*/"+getSpace()+"?locators="+getLocators();
        }
    }

    public void setSpaceUrl(String spaceUrl) {
        this.spaceUrl = spaceUrl;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public void setLocators(String locators) {
        this.locators = locators;
    }

    @Override
    public String toString() {
        return "GigaspaceConfigProperties{" +
                "transmission='" + transmission + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", locators='" + locators + '\'' +
                '}';
    }
}
