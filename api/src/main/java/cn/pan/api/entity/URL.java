package cn.pan.api.entity;

import java.io.Serializable;

public class URL implements Serializable {

    private String interfaceName;
    private String host;
    private Integer port;

    public URL() {

    }

    public URL(String interfaceName, String host, int port) {
        this.interfaceName = interfaceName;
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
}
