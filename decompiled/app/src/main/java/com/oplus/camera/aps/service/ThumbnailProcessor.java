package com.oplus.camera.aps.service;

/* loaded from: classes2.dex */
public class ThumbnailProcessor extends java.lang.Thread {
    private static final java.lang.String TAG = "ThumbnailProcessor";
    private static final float THUMBNAIL_SCALE_SIZE = 0.6f;
    public static final android.os.ConditionVariable THUMBNAIL_URI_CREATING_VARIABLE = new android.os.ConditionVariable();
    private final java.lang.Object mLock = new java.lang.Object();
    private java.util.ArrayList<com.oplus.camera.aps.service.ThumbnailProcessor.DataRequest> mThumbNailQueue = new java.util.ArrayList<>();
    private com.oplus.camera.aps.service.ThumbnailProcessor.ThumbnailProcessListener mThumbNailProcessListener = null;
    private volatile boolean mbDestroyed = false;
    private java.util.Map<java.lang.Long, com.oplus.camera.Storage.CameraPicture> mCameraPictures = new java.util.HashMap();
    private long mLastThumbnailIdentity = 0;
    private com.oplus.camera.aps.service.ApsService mApsService = null;
    private boolean mbProcessingThumbnail = false;

    public static class DataRequest {
        public byte[] mThumbData = null;
        public android.graphics.Bitmap mThumbBitmap = null;
        public java.lang.String mCapMode = null;
        public android.util.Size mPreviewSize = null;
        public android.util.Size mPictureSize = null;
        public java.lang.String mExif = null;
        public java.lang.String mMirrorState = null;
        public java.lang.String mRearMirrorState = null;
        public java.lang.String mTitle = null;
        public long mDate = 0;
        public int mThumbOrientation = 0;
        public int mJpegOrientation = 0;
        public int mCameraId = 0;
        public int mLogicCameraId = 0;
        public android.content.ContentResolver mResolver = null;
        public long mTimeStamp = 0;
        public long mIdentity = 0;
        public boolean mbBurstShot = false;
        public boolean mbLockScreen = false;
        public int mRecBurstNum = 0;
        public java.lang.String mCshotPath = "";
        public long mBurstShotFlagId = -1;
        public long mRequestHash = 0;
        public boolean mbUltraHighResolution = false;
        public boolean mbSuperClearPortrait = false;
        public boolean mbQuickJpeg = false;
        public boolean mbSupportQuickJpeg = false;
        public com.oplus.camera.capmode.f_renamed mContentOperatedCallback = null;
        public java.lang.String mHeicCodecFormat = null;
        public com.oplus.camera.e_renamed.c_renamed.a_renamed mRequestMode = null;
        public boolean mbWatchRequest = false;
        public com.oplus.camera.aps.service.ApsService mApsService = null;
        public com.oplus.camera.e_renamed.d_renamed mOneCamera = null;
        public android.hardware.camera2.CaptureResult mResult = null;
        public boolean mbMakeupWatermark = false;
        public long mStickerCaptureTime = 0;
    }

    public interface ThumbnailProcessListener {
        void updateLastThumbnailView(android.net.Uri uri, android.content.ContentResolver contentResolver);

        void updateLastThumbnailView(boolean z_renamed);

        void updateQuickBitmap(android.graphics.Bitmap bitmap);

        void updateThumbnail(com.oplus.camera.ui.control.e_renamed eVar, com.oplus.camera.aps.service.ThumbnailItem thumbnailItem, android.content.ContentResolver contentResolver);
    }

    public ThumbnailProcessor() {
        setName(TAG);
        start();
    }

    public void setThumbNailProcessListener(com.oplus.camera.aps.service.ThumbnailProcessor.ThumbnailProcessListener thumbnailProcessListener) {
        synchronized (this.mLock) {
            this.mThumbNailProcessListener = thumbnailProcessListener;
        }
    }

    public void setApsService(com.oplus.camera.aps.service.ApsService apsService) {
        this.mApsService = apsService;
    }

    public void addQueue(com.oplus.camera.aps.service.ThumbnailProcessor.DataRequest dataRequest) {
        synchronized (this) {
            this.mThumbNailQueue.add(dataRequest);
            notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        com.oplus.camera.aps.service.ThumbnailProcessor.DataRequest dataRequestRemove;
        while (true) {
            synchronized (this) {
                if (this.mbDestroyed) {
                    return;
                }
                if (this.mThumbNailQueue == null || this.mThumbNailQueue.isEmpty()) {
                    try {
                        wait();
                    } catch (java.lang.InterruptedException unused) {
                    }
                } else {
                    dataRequestRemove = this.mThumbNailQueue.remove(0);
                }
            }
            generateThumbnailAndUri(dataRequestRemove);
        }
    }

    private void generateThumbnailAndUri(com.oplus.camera.aps.service.ThumbnailProcessor.DataRequest dataRequest) {
        android.graphics.Bitmap bitmapA;
        android.graphics.Bitmap bitmapB;
        int i_renamed;
        int width;
        boolean z_renamed = true;
        this.mbProcessingThumbnail = !dataRequest.mbQuickJpeg;
        com.oplus.camera.e_renamed.a_renamed(TAG, "generateThumbnailAndUri, identity: " + dataRequest.mIdentity);
        if (dataRequest.mThumbData != null) {
            if (com.oplus.camera.e_renamed.a_renamed.a_renamed(dataRequest.mCameraId)) {
                bitmapA = com.oplus.camera.util.Util.b_renamed(dataRequest.mThumbData, dataRequest.mPreviewSize.getWidth(), dataRequest.mPreviewSize.getHeight(), 270, 2, false);
                if (bitmapA == null) {
                    com.oplus.camera.e_renamed.f_renamed(TAG, "generateThumbnailAndUri, bitmap is_renamed null");
                    return;
                }
                int i2 = dataRequest.mThumbOrientation;
                if (i2 != 0) {
                    if (i2 == 90) {
                        bitmapA = "off".equals(dataRequest.mMirrorState) ? com.oplus.camera.util.Util.b_renamed(com.oplus.camera.util.Util.c_renamed(bitmapA), 90) : com.oplus.camera.util.Util.b_renamed(bitmapA, -90);
                    } else if (i2 == 180) {
                        bitmapA = "off".equals(dataRequest.mMirrorState) ? com.oplus.camera.util.Util.c_renamed(com.oplus.camera.util.Util.b_renamed(bitmapA, 180)) : com.oplus.camera.util.Util.b_renamed(bitmapA, 180);
                    } else if (i2 == 270) {
                        bitmapA = "off".equals(dataRequest.mMirrorState) ? com.oplus.camera.util.Util.b_renamed(com.oplus.camera.util.Util.c_renamed(bitmapA), -90) : com.oplus.camera.util.Util.b_renamed(bitmapA, 90);
                    } else {
                        com.oplus.camera.e_renamed.f_renamed(TAG, "generateThumbnailAndUri, mOrientation: " + dataRequest.mThumbOrientation + " is_renamed wrong!!");
                    }
                } else if ("off".equals(dataRequest.mMirrorState)) {
                    bitmapA = com.oplus.camera.util.Util.c_renamed(bitmapA);
                }
            } else {
                bitmapA = com.oplus.camera.util.Util.b_renamed(com.oplus.camera.util.Util.b_renamed(dataRequest.mThumbData, dataRequest.mPreviewSize.getWidth(), dataRequest.mPreviewSize.getHeight(), 90, 2, false), dataRequest.mThumbOrientation);
                if (bitmapA != null && "on_renamed".equals(dataRequest.mRearMirrorState)) {
                    bitmapA = com.oplus.camera.util.Util.c_renamed(bitmapA);
                }
            }
        } else if (dataRequest.mThumbBitmap == null || dataRequest.mThumbBitmap.isRecycled()) {
            bitmapA = null;
        } else {
            if (dataRequest.mbQuickJpeg) {
                bitmapB = dataRequest.mThumbBitmap;
            } else if (dataRequest.mbMakeupWatermark) {
                android.util.Size sizeB = com.oplus.camera.c_renamed.b_renamed(new android.util.Size(dataRequest.mThumbBitmap.getWidth(), dataRequest.mThumbBitmap.getHeight()));
                if (90 == dataRequest.mThumbOrientation || 270 == dataRequest.mThumbOrientation) {
                    sizeB = com.oplus.camera.c_renamed.b_renamed(new android.util.Size(dataRequest.mThumbBitmap.getHeight(), dataRequest.mThumbBitmap.getWidth()));
                }
                bitmapB = com.oplus.camera.util.Util.a_renamed(dataRequest.mThumbBitmap, 0.6f, sizeB, dataRequest.mThumbOrientation);
            } else {
                bitmapB = com.oplus.camera.util.Util.b_renamed(dataRequest.mThumbBitmap, 0.6f);
            }
            android.graphics.Bitmap bitmap = bitmapB;
            bitmapA = (dataRequest.mOneCamera == null || dataRequest.mResult == null) ? bitmap : dataRequest.mOneCamera.a_renamed(bitmap, dataRequest.mResult, dataRequest.mCameraId, dataRequest.mLogicCameraId, dataRequest.mJpegOrientation);
            if (com.oplus.camera.e_renamed.a_renamed.a_renamed(dataRequest.mCameraId)) {
                int i3 = dataRequest.mThumbOrientation;
                if (i3 != 0) {
                    if (i3 == 90) {
                        bitmapA = "on_renamed".equals(dataRequest.mMirrorState) ? com.oplus.camera.util.Util.c_renamed(com.oplus.camera.util.Util.b_renamed(bitmapA, 90)) : com.oplus.camera.util.Util.b_renamed(bitmapA, 90);
                    } else if (i3 == 180) {
                        bitmapA = "on_renamed".equals(dataRequest.mMirrorState) ? com.oplus.camera.util.Util.c_renamed(com.oplus.camera.util.Util.b_renamed(bitmapA, 180)) : com.oplus.camera.util.Util.b_renamed(bitmapA, 180);
                    } else if (i3 == 270) {
                        bitmapA = "on_renamed".equals(dataRequest.mMirrorState) ? com.oplus.camera.util.Util.c_renamed(com.oplus.camera.util.Util.b_renamed(bitmapA, -90)) : com.oplus.camera.util.Util.b_renamed(bitmapA, -90);
                    } else {
                        com.oplus.camera.e_renamed.f_renamed(TAG, "generateThumbnailAndUri, mOrientation: " + dataRequest.mThumbOrientation + " is_renamed wrong!!");
                    }
                } else if ("on_renamed".equals(dataRequest.mMirrorState)) {
                    bitmapA = com.oplus.camera.util.Util.c_renamed(bitmapA);
                }
            } else {
                bitmapA = com.oplus.camera.util.Util.b_renamed(bitmapA, dataRequest.mThumbOrientation);
                if ("on_renamed".equals(dataRequest.mRearMirrorState)) {
                    bitmapA = com.oplus.camera.util.Util.c_renamed(bitmapA);
                }
            }
        }
        if (bitmapA != null) {
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
                    i_renamed = -width;
                } else {
                    i_renamed = -1;
                }
                com.oplus.camera.Storage.CameraPicture cameraPicture = new com.oplus.camera.Storage.CameraPicture();
                cameraPicture.g_renamed = dataRequest.mTitle;
                cameraPicture.l_renamed = dataRequest.mDate;
                cameraPicture.i_renamed = dataRequest.mCapMode;
                cameraPicture.s_renamed = dataRequest.mCameraId;
                cameraPicture.h_renamed = dataRequest.mHeicCodecFormat != null ? dataRequest.mHeicCodecFormat : com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
                if (com.oplus.camera.e_renamed.c_renamed.a_renamed.CAPTURE_RAW == cameraPicture.j_renamed) {
                    cameraPicture.h_renamed = "raw";
                }
                cameraPicture.o_renamed = i4;
                cameraPicture.p_renamed = i_renamed;
                cameraPicture.F_renamed = dataRequest.mExif;
                cameraPicture.f4066a = dataRequest.mResolver;
                cameraPicture.n_renamed = dataRequest.mRecBurstNum;
                cameraPicture.j_renamed = dataRequest.mRequestMode;
                cameraPicture.m_renamed = dataRequest.mBurstShotFlagId;
                cameraPicture.k_renamed = dataRequest.mCshotPath;
                cameraPicture.E_renamed = dataRequest.mbLockScreen;
                cameraPicture.R_renamed = dataRequest.mbUltraHighResolution;
                cameraPicture.S_renamed = dataRequest.mbSuperClearPortrait;
                cameraPicture.V_renamed = dataRequest.mContentOperatedCallback;
                cameraPicture.f4068c = com.oplus.camera.Storage.b_renamed(cameraPicture);
                com.oplus.camera.e_renamed.a_renamed(TAG, "generateThumbnailAndUri, thumb uri: " + cameraPicture.f4068c + ", mbBurstShot: " + dataRequest.mbBurstShot);
                com.oplus.camera.aps.service.ThumbnailItem thumbnailItem = new com.oplus.camera.aps.service.ThumbnailItem();
                thumbnailItem.mUri = cameraPicture.f4068c;
                thumbnailItem.mResolver = cameraPicture.f4066a;
                thumbnailItem.mPictureFormat = dataRequest.mHeicCodecFormat != null ? dataRequest.mHeicCodecFormat : com.oplus.camera.statistics.model.CaptureMsgData.TYPE_PHOTO_FORMAT_JPEG;
                thumbnailItem.mJpegName = cameraPicture.g_renamed;
                thumbnailItem.mOriginBitmap = dataRequest.mThumbBitmap;
                thumbnailItem.mOrientation = dataRequest.mJpegOrientation;
                thumbnailItem.mTimeStamp = dataRequest.mTimeStamp;
                thumbnailItem.mIdentity = dataRequest.mIdentity;
                thumbnailItem.mbBurstShot = dataRequest.mbBurstShot;
                thumbnailItem.mDate = cameraPicture.l_renamed;
                thumbnailItem.mRequestHash = dataRequest.mRequestHash;
                thumbnailItem.mStickerCaptureTime = dataRequest.mStickerCaptureTime;
                thumbnailItem.mbLockScreen = dataRequest.mbLockScreen;
                thumbnailItem.mbMirror = "off".equals(dataRequest.mMirrorState);
                thumbnailItem.mbUltraHighResolution = cameraPicture.R_renamed;
                thumbnailItem.mbWatchRequest = dataRequest.mbWatchRequest;
                com.oplus.camera.ui.control.e_renamed eVarA = com.oplus.camera.ui.control.e_renamed.a_renamed(bitmapA, 0, 1, cameraPicture.f4068c, com.oplus.camera.Storage.a_renamed(java.lang.String.valueOf(cameraPicture.l_renamed), cameraPicture.h_renamed), cameraPicture.l_renamed);
                eVarA.a_renamed(dataRequest.mbSupportQuickJpeg);
                eVarA.a_renamed(dataRequest.mRequestHash);
                synchronized (this.mLock) {
                    if (this.mThumbNailProcessListener != null) {
                        this.mThumbNailProcessListener.updateThumbnail(eVarA, thumbnailItem, cameraPicture.f4066a);
                    } else {
                        z_renamed = false;
                    }
                }
                com.oplus.camera.aps.service.ApsService apsService = this.mApsService;
                if (apsService != null && !z_renamed) {
                    apsService.deleteThumbnailAndCache(thumbnailItem);
                }
                this.mLastThumbnailIdentity = thumbnailItem.mIdentity;
                if (dataRequest.mbSupportQuickJpeg) {
                    this.mCameraPictures.put(java.lang.Long.valueOf(dataRequest.mIdentity), cameraPicture);
                }
                if (com.oplus.camera.Storage.c_renamed()) {
                    com.oplus.camera.util.n_renamed.a_renamed().b_renamed(cameraPicture.g_renamed, bitmapA, false);
                } else {
                    com.oplus.camera.util.n_renamed.a_renamed().a_renamed(cameraPicture.g_renamed, bitmapA, false);
                }
                THUMBNAIL_URI_CREATING_VARIABLE.open();
            } else if (this.mCameraPictures.get(java.lang.Long.valueOf(dataRequest.mIdentity)) != null) {
                com.oplus.camera.e_renamed.a_renamed(TAG, "generateThumbnailAndUri, quick uri: " + this.mCameraPictures.get(java.lang.Long.valueOf(dataRequest.mIdentity)).f4068c);
                synchronized (this.mLock) {
                    if (this.mThumbNailProcessListener != null && this.mLastThumbnailIdentity == dataRequest.mIdentity) {
                        this.mThumbNailProcessListener.updateQuickBitmap(bitmapA);
                    }
                }
                if (dataRequest.mApsService != null && dataRequest.mApsService.containThumbnailInfo(dataRequest.mIdentity)) {
                    com.oplus.camera.Storage.CameraPicture cameraPicture2 = this.mCameraPictures.get(java.lang.Long.valueOf(dataRequest.mIdentity));
                    if (com.oplus.camera.Storage.c_renamed()) {
                        com.oplus.camera.util.n_renamed.a_renamed().b_renamed(cameraPicture2.g_renamed, bitmapA, true);
                    } else {
                        com.oplus.camera.util.n_renamed.a_renamed().a_renamed(cameraPicture2.g_renamed, bitmapA, true);
                    }
                    com.oplus.camera.Storage.c_renamed(cameraPicture2);
                }
                this.mCameraPictures.remove(java.lang.Long.valueOf(dataRequest.mIdentity));
            }
        }
        this.mbProcessingThumbnail = false;
        if (isEmpty() && this.mbDestroyed) {
            setThumbNailProcessListener(null);
        }
    }

    public boolean isEmpty() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("isEmpty, isEmpty:");
        java.util.ArrayList<com.oplus.camera.aps.service.ThumbnailProcessor.DataRequest> arrayList = this.mThumbNailQueue;
        sb.append(arrayList != null ? java.lang.Boolean.valueOf(arrayList.isEmpty()) : "null");
        sb.append(", !mbProcessingThumbnail: ");
        sb.append(!this.mbProcessingThumbnail);
        com.oplus.camera.e_renamed.a_renamed(TAG, sb.toString());
        java.util.ArrayList<com.oplus.camera.aps.service.ThumbnailProcessor.DataRequest> arrayList2 = this.mThumbNailQueue;
        return (arrayList2 == null || arrayList2.isEmpty()) && !this.mbProcessingThumbnail;
    }

    public void onDestroy() {
        com.oplus.camera.e_renamed.a_renamed(TAG, "onDestroy");
        this.mbDestroyed = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
