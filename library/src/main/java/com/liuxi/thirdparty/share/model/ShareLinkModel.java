package com.liuxi.thirdparty.share.model;

import android.graphics.Bitmap;

/**
 * @Author liuxi
 * @Email xiaoxixizhizhi@gmail.com
 */
public class ShareLinkModel extends ShareModel {

    public String title;//标题
    public String url;//链接
    public String description;//描述
    public Bitmap icon;//分享icon,未设置时默认使用ShareDelegate.defaultImageResId()

    public ShareLinkModel() {

    }

    public ShareLinkModel(String title, String url, String description, Bitmap icon) {
        this.title = title;
        this.url = url;
        this.description = description;
        this.icon = icon;
    }

    @Override
    public ModelType getModelType() {
        return ModelType.Link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

}
