package com.liuxi.thirdparty;

import android.app.Activity;
import android.app.Application;
import com.liuxi.thirdparty.config.WeChatConfig;
import com.liuxi.thirdparty.model.ShareModel;
import com.liuxi.thirdparty.share.Platform;
import com.liuxi.thirdparty.share.ShareDelegate;
import com.liuxi.thirdparty.share.task.WeChatShareTask;

import java.lang.ref.WeakReference;


/**
 * 第三方功能管理器
 * Created by liuxi on 2018/3/13.
 */

public class TPManager {

    private static TPManager mInstance;
    private ShareDelegate mShareDelegate;
    private WeChatConfig mWeChatDelegate;
    private Application mApplication;

    public static TPManager get() {
        if (mInstance == null) {
            synchronized (TPManager.class) {
                if (mInstance == null) {
                    mInstance = new TPManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 在Application中注册
     *
     * @param app
     */
    public void register(Application app) {
        mApplication = app;
        WeChatManager.getInstance().register(app);
    }

    public Application getApplication() {
        return mApplication;
    }

    public ShareDelegate getShareDelegate() {
        return mShareDelegate;
    }

    public WeChatConfig getWeChatDelegate() {
        return mWeChatDelegate;
    }

    /**
     * 注入微信参数
     * 使用微信授权/分享等功能时必须调用
     *
     * @param delegate
     */
    public void inject(WeChatConfig delegate) {
        mWeChatDelegate = delegate;
    }

    /**
     * 注入分享参数
     * 使用分享功能时推荐调用
     *
     * @param delegate
     */
    public void inject(ShareDelegate delegate) {
        mShareDelegate = delegate;
    }

    private TPManager() {
    }

    /**
     * 分享
     *
     * @param activity
     * @param platform
     */
    public static void share(WeakReference<Activity> activity, Platform platform, ShareModel shareModel) {

        switch (platform) {
            case WeChat_FRIEND:
                new WeChatShareTask(activity, true).share(shareModel);
                break;

            case WeChat_TIMELINE:
                new WeChatShareTask(activity, false).share(shareModel);
                break;
        }

    }

}
