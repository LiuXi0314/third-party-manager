package com.liuxi.thirdparty.delegate;

/**
 * 微信代理
 * <p>
 * 用于注入参数或方法
 *
 * @Author liuxi
 * @Email xiaoxixizhizhi@gmail.com
 */
public interface WXDelegate {

    //微信key
    String APP_KEY();

    //应用授权作用域
    String SCOPE();

    // 未安装微信触发
    void wechatNotInstalled();

}
