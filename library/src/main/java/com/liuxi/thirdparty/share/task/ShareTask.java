package com.liuxi.thirdparty.share.task;

import android.app.Activity;
import com.liuxi.thirdparty.share.model.ShareImageModel;
import com.liuxi.thirdparty.share.model.ShareLinkModel;
import com.liuxi.thirdparty.share.model.ShareModel;

import java.lang.ref.WeakReference;


/**
 * 分享任务Base
 * Created by liuxi on 2018/3/22.
 */

public abstract class ShareTask {

    public ShareTask(WeakReference<Activity> activity) {
        mActivity = activity;
    }

    protected WeakReference<Activity> mActivity;

    public void share(ShareModel model) {

        if (model.getModelType() == null) return;

        switch (model.getModelType()) {
            case Link:
                share(((ShareLinkModel) model));
                break;

            case Image:
                share(((ShareImageModel) model));
                break;

        }
    }

    /**
     * 分享链接
     *
     * @param model
     */
    abstract void share(ShareLinkModel model);

    /**
     * 分享单张图片
     *
     * @param model
     */
    abstract void share(ShareImageModel model);


}
