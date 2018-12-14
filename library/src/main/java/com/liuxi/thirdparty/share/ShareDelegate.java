package com.liuxi.thirdparty.share;

import android.graphics.Bitmap;

/**
 * 分享参数，以及事件
 *
 * @Author liuxi
 * @Email xiaoxixizhizhi@gmail.com
 */
public interface ShareDelegate {

    /**
     * 未安装微信触发
     */
    void wechatNotInstalled();

    /**
     * 分享默认图标
     */
    Bitmap defaultImageResId();



}
