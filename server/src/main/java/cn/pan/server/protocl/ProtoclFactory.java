package cn.pan.server.protocl;

import cn.pan.server.protocl.socket.TcpProtocl;

public class ProtoclFactory {

    private static TcpProtocl tcpProtocl = new TcpProtocl();

    public static Protocl getProtocl(ProtoclType protoclType) {
        switch (protoclType) {
            case NETTY:
            case HTTP: return null;
            case TCP:
            default: return tcpProtocl;
        }
    }
}
