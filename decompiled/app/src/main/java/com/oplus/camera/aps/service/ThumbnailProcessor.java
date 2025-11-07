package com.oplus.camera.aps.service;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.hardware.camera2.CaptureResult;
import android.net.Uri;
import android.os.ConditionVariable;
import android.util.Size;
import com.oplus.camera.BaseSloganUtil;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Storage;
import com.oplus.camera.capmode.ContentOperatedCallback;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p141e.CameraRequestTag;
import com.oplus.camera.p141e.OneCamera;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.statistics.model.CaptureMsgData;
import com.oplus.camera.util.ThumbnailCacheUtil;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ThumbnailProcessor extends Thread {
    private static final String TAG = "ThumbnailProcessor";
    private static final float THUMBNAIL_SCALE_SIZE = 0.6f;
    public static final ConditionVariable THUMBNAIL_URI_CREATING_VARIABLE = new ConditionVariable();
    private final Object mLock = new Object();
    private ArrayList<DataRequest> mThumbNailQueue = new ArrayList<>();
    private ThumbnailProcessListener mThumbNailProcessListener = null;
    private volatile boolean mbDestroyed = false;
    private Map<Long, Storage.CameraPicture> mCameraPictures = new HashMap();
    private long mLastThumbnailIdentity = 0;
    private ApsService mApsService = null;
    private boolean mbProcessingThumbnail = false;

    public static class DataRequest {
        public byte[] mThumbData = null;
        public Bitmap mThumbBitmap = null;
        public String mCapMode = null;
        public Size mPreviewSize = null;
        public Size mPictureSize = null;
        public String mExif = null;
        public String mMirrorState = null;
        public String mRearMirrorState = null;
        public String mTitle = null;
        public long mDate = 0;
        public int mThumbOrientation = 0;
        public int mJpegOrientation = 0;
        public int mCameraId = 0;
        public int mLogicCameraId = 0;
        public ContentResolver mResolver = null;
        public long mTimeStamp = 0;
        public long mIdentity = 0;
        public boolean mbBurstShot = false;
        public boolean mbLockScreen = false;
        public int mRecBurstNum = 0;
        public String mCshotPath = "";
        public long mBurstShotFlagId = -1;
        public long mRequestHash = 0;
        public boolean mbUltraHighResolution = false;
        public boolean mbSuperClearPortrait = false;
        public boolean mbQuickJpeg = false;
        public boolean mbSupportQuickJpeg = false;
        public ContentOperatedCallback mContentOperatedCallback = null;
        public String mHeicCodecFormat = null;
        public CameraRequestTag.PlatformImplementations.kt_3 mRequestMode = null;
        public boolean mbWatchRequest = false;
        public ApsService mApsService = null;
        public OneCamera mOneCamera = null;
        public CaptureResult mResult = null;
        public boolean mbMakeupWatermark = false;
        public long mStickerCaptureTime = 0;
    }

    public interface ThumbnailProcessListener {
        void updateLastThumbnailView(Uri uri, ContentResolver contentResolver);

        void updateLastThumbnailView(boolean z);

        void updateQuickBitmap(Bitmap bitmap);

        void updateThumbnail(Thumbnail c3203e, ThumbnailItem thumbnailItem, ContentResolver contentResolver);
    }

    public ThumbnailProcessor() {
        setName(TAG);
        start();
    }

    public void setThumbNailProcessListener(ThumbnailProcessListener thumbnailProcessListener) {
        synchronized (this.mLock) {
            this.mThumbNailProcessListener = thumbnailProcessListener;
        }
    }

    public void setApsService(ApsService apsService) {
        this.mApsService = apsService;
    }

    public void addQueue(DataRequest dataRequest) {
        synchronized (this) {
            this.mThumbNailQueue.add(dataRequest);
            notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        DataRequest dataRequestRemove;
        while (true) {
            synchronized (this) {
                if (this.mbDestroyed) {
                    return;
                }
                if (this.mThumbNailQueue == null || this.mThumbNailQueue.isEmpty()) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    dataRequestRemove = this.mThumbNailQueue.remove(0);
                }
            }
            generateThumbnailAndUri(dataRequestRemove);
        }
    }

    private void generateThumbnailAndUri(DataRequest dataRequest) {
        Bitmap bitmapMo13018a;
        Bitmap bitmapM24372b;
        int OplusGLSurfaceView_13;
        int width;
        boolean z = true;
        this.mbProcessingThumbnail = !dataRequest.mbQuickJpeg;
        CameraLog.m12954a(TAG, "generateThumbnailAndUri, identity: " + dataRequest.mIdentity);
        if (dataRequest.mThumbData != null) {
            if (CameraCharacteristicsUtil.m12974a(dataRequest.mCameraId)) {
                bitmapMo13018a = Util.m24375b(dataRequest.mThumbData, dataRequest.mPreviewSize.getWidth(), dataRequest.mPreviewSize.getHeight(), 270, 2, false);
                if (bitmapMo13018a == null) {
                    CameraLog.m12967f(TAG, "generateThumbnailAndUri, bitmap is null");
                    return;
                }
                int i2 = dataRequest.mThumbOrientation;
                if (i2 != 0) {
                    if (i2 == 90) {
                        bitmapMo13018a = "off".equals(dataRequest.mMirrorState) ? Util.m24373b(Util.m24410c(bitmapMo13018a), 90) : Util.m24373b(bitmapMo13018a, -90);
                    } else if (i2 == 180) {
                        bitmapMo13018a = "off".equals(dataRequest.mMirrorState) ? Util.m24410c(Util.m24373b(bitmapMo13018a, 180)) : Util.m24373b(bitmapMo13018a, 180);
                    } else if (i2 == 270) {
                        bitmapMo13018a = "off".equals(dataRequest.mMirrorState) ? Util.m24373b(Util.m24410c(bitmapMo13018a), -90) : Util.m24373b(bitmapMo13018a, 90);
                    } else {
                        CameraLog.m12967f(TAG, "generateThumbnailAndUri, mOrientation: " + dataRequest.mThumbOrientation + " is wrong!!");
                    }
                } else if ("off".equals(dataRequest.mMirrorState)) {
                    bitmapMo13018a = Util.m24410c(bitmapMo13018a);
                }
            } else {
                bitmapMo13018a = Util.m24373b(Util.m24375b(dataRequest.mThumbData, dataRequest.mPreviewSize.getWidth(), dataRequest.mPreviewSize.getHeight(), 90, 2, false), dataRequest.mThumbOrientation);
                if (bitmapMo13018a != null && "on".equals(dataRequest.mRearMirrorState)) {
                    bitmapMo13018a = Util.m24410c(bitmapMo13018a);
                }
            }
        } else if (dataRequest.mThumbBitmap == null || dataRequest.mThumbBitmap.isRecycled()) {
            bitmapMo13018a = null;
        } else {
            if (dataRequest.mbQuickJpeg) {
                bitmapM24372b = dataRequest.mThumbBitmap;
            } else if (dataRequest.mbMakeupWatermark) {
                Size sizeM11680b = BaseSloganUtil.m11680b(new Size(dataRequest.mThumbBitmap.getWidth(), dataRequest.mThumbBitmap.getHeight()));
                if (90 == dataRequest.mThumbOrientation || 270 == dataRequest.mThumbOrientation) {
                    sizeM11680b = BaseSloganUtil.m11680b(new Size(dataRequest.mThumbBitmap.getHeight(), dataRequest.mThumbBitmap.getWidth()));
                }
                bitmapM24372b = Util.m24220a(dataRequest.mThumbBitmap, 0.6f, sizeM11680b, dataRequest.mThumbOrientation);
            } else {
                bitmapM24372b = Util.m24372b(dataRequest.mThumbBitmap, 0.6f);
            }
            Bitmap bitmap = bitmapM24372b;
            bitmapMo13018a = (dataRequest.mOneCamera == null || dataRequest.mResult == null) ? bitmap : dataRequest.mOneCamera.mo13018a(bitmap, dataRequest.mResult, dataRequest.mCameraId, dataRequest.mLogicCameraId, dataRequest.mJpegOrientation);
            if (CameraCharacteristicsUtil.m12974a(dataRequest.mCameraId)) {
                int i3 = dataRequest.mThumbOrientation;
                if (i3 != 0) {
                    if (i3 == 90) {
                        bitmapMo13018a = "on".equals(dataRequest.mMirrorState) ? Util.m24410c(Util.m24373b(bitmapMo13018a, 90)) : Util.m24373b(bitmapMo13018a, 90);
                    } else if (i3 == 180) {
                        bitmapMo13018a = "on".equals(dataRequest.mMirrorState) ? Util.m24410c(Util.m24373b(bitmapMo13018a, 180)) : Util.m24373b(bitmapMo13018a, 180);
                    } else if (i3 == 270) {
                        bitmapMo13018a = "on".equals(dataRequest.mMirrorState) ? Util.m24410c(Util.m24373b(bitmapMo13018a, -90)) : Util.m24373b(bitmapMo13018a, -90);
                    } else {
                        CameraLog.m12967f(TAG, "generateThumbnailAndUri, mOrientation: " + dataRequest.mThumbOrientation + " is wrong!!");
                    }
                } else if ("on".equals(dataRequest.mMirrorState)) {
                    bitmapMo13018a = Util.m24410c(bitmapMo13018a);
                }
            } else {
                bitmapMo13018a = Util.m24373b(bitmapMo13018a, dataRequest.mThumbOrientation);
                if ("on".equals(dataRequest.mRearMirrorState)) {
                    bitmapMo13018a = Util.m24410c(bitmapMo13018a);
                }
            }
        }
        if (bitmapMo13018a != null) {
            if (!dataRequest.mbQuickJpeg) {
                int i4 = -1;
                if (dataRequest.mPictureSize != null) {
                    if (dataRequest.mJpegOrientation % 180 == 0) {
                        i4 = -dataRequest.mPictureSize.getWidth();
                        width = dataRequest.mPictureSize.getHeight();
                    } else {
                        i4 = -dataRequest.mPictureSize.getHeight();
                        width = dataRequest.mPictureSize.getWidth();
                    }
                    OplusGLSurfaceView_13 = -width;
                } else {
                    OplusGLSurfaceView_13 = -1;
                }
                Storage.CameraPicture cameraPicture = new Storage.CameraPicture();
                cameraPicture.f12134g = dataRequest.mTitle;
                cameraPicture.f12139l = dataRequest.mDate;
                cameraPicture.f12136i = dataRequest.mCapMode;
                cameraPicture.f12146s = dataRequest.mCameraId;
                cameraPicture.f12135h = dataRequest.mHeicCodecFormat != null ? dataRequest.mHeicCodecFormat : CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
                if (CameraRequestTag.PlatformImplementations.kt_3.CAPTURE_RAW == cameraPicture.f12137j) {
                    cameraPicture.f12135h = "raw";
                }
                cameraPicture.f12142o = i4;
                cameraPicture.f12143p = OplusGLSurfaceView_13;
                cameraPicture.f12108F = dataRequest.mExif;
                cameraPicture.f12128a = dataRequest.mResolver;
                cameraPicture.f12141n = dataRequest.mRecBurstNum;
                cameraPicture.f12137j = dataRequest.mRequestMode;
                cameraPicture.f12140m = dataRequest.mBurstShotFlagId;
                cameraPicture.f12138k = dataRequest.mCshotPath;
                cameraPicture.f12107E = dataRequest.mbLockScreen;
                cameraPicture.f12120R = dataRequest.mbUltraHighResolution;
                cameraPicture.f12121S = dataRequest.mbSuperClearPortrait;
                cameraPicture.f12124V = dataRequest.mContentOperatedCallback;
                cameraPicture.f12130c = Storage.m11123b(cameraPicture);
                CameraLog.m12954a(TAG, "generateThumbnailAndUri, thumb uri: " + cameraPicture.f12130c + ", mbBurstShot: " + dataRequest.mbBurstShot);
                ThumbnailItem thumbnailItem = new ThumbnailItem();
                thumbnailItem.mUri = cameraPicture.f12130c;
                thumbnailItem.mResolver = cameraPicture.f12128a;
                thumbnailItem.mPictureFormat = dataRequest.mHeicCodecFormat != null ? dataRequest.mHeicCodecFormat : CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
                thumbnailItem.mJpegName = cameraPicture.f12134g;
                thumbnailItem.mOriginBitmap = dataRequest.mThumbBitmap;
                thumbnailItem.mOrientation = dataRequest.mJpegOrientation;
                thumbnailItem.mTimeStamp = dataRequest.mTimeStamp;
                thumbnailItem.mIdentity = dataRequest.mIdentity;
                thumbnailItem.mbBurstShot = dataRequest.mbBurstShot;
                thumbnailItem.mDate = cameraPicture.f12139l;
                thumbnailItem.mRequestHash = dataRequest.mRequestHash;
                thumbnailItem.mStickerCaptureTime = dataRequest.mStickerCaptureTime;
                thumbnailItem.mbLockScreen = dataRequest.mbLockScreen;
                thumbnailItem.mbMirror = "off".equals(dataRequest.mMirrorState);
                thumbnailItem.mbUltraHighResolution = cameraPicture.f12120R;
                thumbnailItem.mbWatchRequest = dataRequest.mbWatchRequest;
                Thumbnail c3203eM19276a = Thumbnail.m19276a(bitmapMo13018a, 0, 1, cameraPicture.f12130c, Storage.m11110a(String.valueOf(cameraPicture.f12139l), cameraPicture.f12135h), cameraPicture.f12139l);
                c3203eM19276a.m19289a(dataRequest.mbSupportQuickJpeg);
                c3203eM19276a.m19286a(dataRequest.mRequestHash);
                synchronized (this.mLock) {
                    if (this.mThumbNailProcessListener != null) {
                        this.mThumbNailProcessListener.updateThumbnail(c3203eM19276a, thumbnailItem, cameraPicture.f12128a);
                    } else {
                        z = false;
                    }
                }
                ApsService apsService = this.mApsService;
                if (apsService != null && !z) {
                    apsService.deleteThumbnailAndCache(thumbnailItem);
                }
                this.mLastThumbnailIdentity = thumbnailItem.mIdentity;
                if (dataRequest.mbSupportQuickJpeg) {
                    this.mCameraPictures.put(Long.valueOf(dataRequest.mIdentity), cameraPicture);
                }
                if (Storage.m11134c()) {
                    ThumbnailCacheUtil.m24610a().m24623b(cameraPicture.f12134g, bitmapMo13018a, false);
                } else {
                    ThumbnailCacheUtil.m24610a().m24619a(cameraPicture.f12134g, bitmapMo13018a, false);
                }
                THUMBNAIL_URI_CREATING_VARIABLE.open();
            } else if (this.mCameraPictures.get(Long.valueOf(dataRequest.mIdentity)) != null) {
                CameraLog.m12954a(TAG, "generateThumbnailAndUri, quick uri: " + this.mCameraPictures.get(Long.valueOf(dataRequest.mIdentity)).f12130c);
                synchronized (this.mLock) {
                    if (this.mThumbNailProcessListener != null && this.mLastThumbnailIdentity == dataRequest.mIdentity) {
                        this.mThumbNailProcessListener.updateQuickBitmap(bitmapMo13018a);
                    }
                }
                if (dataRequest.mApsService != null && dataRequest.mApsService.containThumbnailInfo(dataRequest.mIdentity)) {
                    Storage.CameraPicture cameraPicture2 = this.mCameraPictures.get(Long.valueOf(dataRequest.mIdentity));
                    if (Storage.m11134c()) {
                        ThumbnailCacheUtil.m24610a().m24623b(cameraPicture2.f12134g, bitmapMo13018a, true);
                    } else {
                        ThumbnailCacheUtil.m24610a().m24619a(cameraPicture2.f12134g, bitmapMo13018a, true);
                    }
                    Storage.m11132c(cameraPicture2);
                }
                this.mCameraPictures.remove(Long.valueOf(dataRequest.mIdentity));
            }
        }
        this.mbProcessingThumbnail = false;
        if (isEmpty() && this.mbDestroyed) {
            setThumbNailProcessListener(null);
        }
    }

    public boolean isEmpty() {
        StringBuilder sb = new StringBuilder();
        sb.append("isEmpty, isEmpty:");
        ArrayList<DataRequest> arrayList = this.mThumbNailQueue;
        sb.append(arrayList != null ? Boolean.valueOf(arrayList.isEmpty()) : "null");
        sb.append(", !mbProcessingThumbnail: ");
        sb.append(!this.mbProcessingThumbnail);
        CameraLog.m12954a(TAG, sb.toString());
        ArrayList<DataRequest> arrayList2 = this.mThumbNailQueue;
        return (arrayList2 == null || arrayList2.isEmpty()) && !this.mbProcessingThumbnail;
    }

    public void onDestroy() {
        CameraLog.m12954a(TAG, "onDestroy");
        this.mbDestroyed = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
