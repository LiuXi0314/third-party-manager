package com.liuxi.thirdparty.helper;

import android.app.Application;
import com.liuxi.thirdparty.TPManager;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


/**
 * 微信工具类
 * Created by liuxi on 2018/3/14.
 */

public class WeChatHelper {

    private IWXAPI mAPi;
    private static WeChatHelper mInstance = null;

    public static WeChatHelper getInstance() {
        if (mInstance == null) {
            synchronized (WeChatHelper.class) {
                if (mInstance == null) {
                    mInstance = new WeChatHelper();
                }
            }
        }
        return mInstance;
    }

    private WeChatHelper() {

    }

    public void register(Application context) {

        if (TPManager.get().getWeChatDelegate() == null) {
            return;
        }

        if (mAPi != null) {
            return;
        }

        mAPi = WXAPIFactory.createWXAPI(context, TPManager.get().getWeChatDelegate().APP_KEY(), false);
        mAPi.registerApp(TPManager.get().getWeChatDelegate().APP_KEY());
    }

    public IWXAPI getAPi() {
        if (mAPi == null) {
            register(TPManager.get().getApplication());
        }
        return mAPi;
    }

}
