package com.liuxi.thirdparty;

import android.app.Application;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


/**
 * Created by liuxi on 2018/3/14.
 */

public class WeChatManager {

    private IWXAPI mAPi;
    private static WeChatManager mInstance = null;

    public static WeChatManager getInstance() {
        if (mInstance == null) {
            synchronized (WeChatManager.class) {
                if (mInstance == null) {
                    mInstance = new WeChatManager();
                }
            }
        }
        return mInstance;
    }

    private WeChatManager() {

    }

    public void register(Application context) {
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
