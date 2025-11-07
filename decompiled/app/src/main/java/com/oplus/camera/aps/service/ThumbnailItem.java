package com.oplus.camera.aps.service;

/* loaded from: classes2.dex */
public class ThumbnailItem {
    public android.graphics.Bitmap mOriginBitmap;
    public android.net.Uri mUri = null;
    public android.content.ContentResolver mResolver = null;
    public java.lang.String mPictureFormat = null;
    public java.lang.String mJpegName = null;
    public android.graphics.Bitmap mThumbBitmap = null;
    public int mOrientation = 0;
    public long mTimeStamp = 0;
    public long mIdentity = 0;
    public boolean mbBurstShot = false;
    public com.oplus.camera.a_renamed.b_renamed mProductProcessor = null;
    public long mDate = 0;
    public long mRequestHash = 0;
    public int mThumbnailWidth = 0;
    public boolean mbMirror = false;
    public boolean mbLockScreen = false;
    public boolean mbUltraHighResolution = false;
    public com.oplus.camera.ui.control.e_renamed.b_renamed mCameraUiUpdateThumbnail = null;
    public com.oplus.camera.ui.control.e_renamed.b_renamed mUpdateLastThumbTask = null;
    public boolean mbWatchRequest = false;
    public long mStickerCaptureTime = 0;

    public java.lang.String toString() {
        return "mUri: " + this.mUri + ", mResolver: " + this.mResolver + ", mPictureFormat: " + this.mPictureFormat + ", mJpegName: " + this.mJpegName + ", mThumbBitmap: " + this.mThumbBitmap + ", mOrientation: " + this.mOrientation + ", mTimeStamp: " + this.mTimeStamp + ", mIdentity: " + this.mIdentity + ", mbBurstShot: " + this.mbBurstShot + ", mProductProcessor: " + this.mProductProcessor + ", mDate: " + this.mDate + ", mThumbnailWidth: " + this.mThumbnailWidth + ", mbLockScreen: " + this.mbLockScreen + ", mCameraUiUpdateThumbnail: " + this.mCameraUiUpdateThumbnail + ", mStickerCaptureTime: " + this.mStickerCaptureTime;
    }
}
