package com.oplus.camera.aps.service;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import com.oplus.camera.p136a.ImageProductProcessor;
import com.oplus.camera.p172ui.control.Thumbnail;

/* loaded from: classes2.dex */
public class ThumbnailItem {
    public Bitmap mOriginBitmap;
    public Uri mUri = null;
    public ContentResolver mResolver = null;
    public String mPictureFormat = null;
    public String mJpegName = null;
    public Bitmap mThumbBitmap = null;
    public int mOrientation = 0;
    public long mTimeStamp = 0;
    public long mIdentity = 0;
    public boolean mbBurstShot = false;
    public ImageProductProcessor mProductProcessor = null;
    public long mDate = 0;
    public long mRequestHash = 0;
    public int mThumbnailWidth = 0;
    public boolean mbMirror = false;
    public boolean mbLockScreen = false;
    public boolean mbUltraHighResolution = false;
    public Thumbnail.IntrinsicsJvm.kt_4 mCameraUiUpdateThumbnail = null;
    public Thumbnail.IntrinsicsJvm.kt_4 mUpdateLastThumbTask = null;
    public boolean mbWatchRequest = false;
    public long mStickerCaptureTime = 0;

    public String toString() {
        return "mUri: " + this.mUri + ", mResolver: " + this.mResolver + ", mPictureFormat: " + this.mPictureFormat + ", mJpegName: " + this.mJpegName + ", mThumbBitmap: " + this.mThumbBitmap + ", mOrientation: " + this.mOrientation + ", mTimeStamp: " + this.mTimeStamp + ", mIdentity: " + this.mIdentity + ", mbBurstShot: " + this.mbBurstShot + ", mProductProcessor: " + this.mProductProcessor + ", mDate: " + this.mDate + ", mThumbnailWidth: " + this.mThumbnailWidth + ", mbLockScreen: " + this.mbLockScreen + ", mCameraUiUpdateThumbnail: " + this.mCameraUiUpdateThumbnail + ", mStickerCaptureTime: " + this.mStickerCaptureTime;
    }
}
