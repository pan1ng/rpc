package cn.pan.register;

import cn.pan.api.entity.URL;

public interface Register {
    /**
     * server注册
     * @param host
     */
    void register(URL host);

    /**
     * client向注册中心请求接口地址
     * @param interfaceName
     * @return
     */
    URL getURL(String interfaceName);
}
