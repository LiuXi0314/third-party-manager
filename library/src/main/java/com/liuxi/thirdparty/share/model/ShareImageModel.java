package com.liuxi.thirdparty.share.model;

import android.graphics.Bitmap;

/**
 * 分享单张图片
 *
 * @Author liuxi
 * @Email xiaoxixizhizhi@gmail.com
 */
public class ShareImageModel extends ShareModel {

    private Bitmap imageBitmap;


    public ShareImageModel() {

    }

    public ShareImageModel(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }

    @Override
    public ModelType getModelType() {
        return ModelType.Image;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }


}
