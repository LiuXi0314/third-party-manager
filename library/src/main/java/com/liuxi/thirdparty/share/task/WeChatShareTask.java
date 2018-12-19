package com.liuxi.thirdparty.share.task;

import android.app.Activity;
import android.graphics.Bitmap;
import com.liuxi.thirdparty.TPManager;
import com.liuxi.thirdparty.helper.WeChatHelper;
import com.liuxi.thirdparty.share.model.ShareImageModel;
import com.liuxi.thirdparty.share.model.ShareLinkModel;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;

import java.lang.ref.WeakReference;


/**
 * 微信分享实现类
 * Created by liuxi on 2018/3/22.
 */

public class WeChatShareTask extends ShareTask {

    private boolean isFriend;

    public WeChatShareTask(WeakReference<Activity> activity, boolean isFriend) {
        super(activity);
        this.isFriend = isFriend;
    }

    @Override
    void share(ShareLinkModel linkModel) {

        IWXAPI iwxapi = WeChatHelper.getInstance().getAPi();
        if (iwxapi != null && !iwxapi.isWXAppInstalled()) {
            TPManager.get().getWeChatDelegate().wechatNotInstalled();
            return;
        }

        WXWebpageObject webPage = new WXWebpageObject();
        webPage.webpageUrl = linkModel.url;

        final WXMediaMessage message = new WXMediaMessage();
        message.mediaObject = webPage;
        message.title = linkModel.title;
        message.description = linkModel.description;
        Bitmap bitmap = null;
        if (linkModel.icon != null) {
            bitmap = linkModel.icon;
        }
        if (bitmap != null) {
            message.setThumbImage(bitmap);
        }
        send(message);

    }

    @Override
    void share(ShareImageModel model) {
        if (model == null) return;

        IWXAPI iwxapi = WeChatHelper.getInstance().getAPi();
        if (iwxapi != null && !iwxapi.isWXAppInstalled()) {
            TPManager.get().getWeChatDelegate().wechatNotInstalled();
            return;
        }
        WXImageObject shareObject = new WXImageObject(model.getImageBitmap());
        WXMediaMessage mediaMessage = new WXMediaMessage();
        mediaMessage.mediaObject = shareObject;
        send(mediaMessage);

    }


    private void send(WXMediaMessage message) {
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("image");
        req.message = message;
        req.scene = isFriend ? SendMessageToWX.Req.WXSceneSession : SendMessageToWX.Req.WXSceneTimeline;//好友／朋友圈
        WeChatHelper.getInstance().getAPi().sendReq(req);
    }


    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }


}
