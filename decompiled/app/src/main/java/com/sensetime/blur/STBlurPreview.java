package com.sensetime.blur;

/* loaded from: classes2.dex */
public class STBlurPreview implements com.sensetime.utils.ShakeDetectorUtils.OnShakeListener {
    private static boolean DEBUG = false;
    private static final int RESIZE_RATIO = 4;
    private static final int SEGMENT_LENGTH = 240;
    public static final int ST_BLUR_PARAM_TYPE_LEVEL = 4097;
    public static final int ST_BLUR_PARAM_TYPE_MASK_EROSION_VALUE = 4101;
    public static final int ST_BLUR_PARAM_TYPE_MASK_MIN_AREA_SIZE = 4100;
    public static final int ST_BLUR_PARAM_TYPE_RECT_HEIGHT_SCALE = 4099;
    public static final int ST_BLUR_PARAM_TYPE_RECT_WIDTH_SCALE = 4098;
    public static final int ST_BUFFER_ERROR = -4;
    public static final int ST_INTERNAL_ERROR = -6;
    public static final int ST_OK = 0;
    public static final int ST_PARAM_ERROR = -1;
    public static final int ST_PROGRAM_ERROR = -3;
    public static final int ST_SHADER_ERROR = -2;
    public static final int ST_TEXTURE_ERROR = -5;
    private static final java.lang.String TAG = "STBlurPreview";
    private long PROCESS_LIFE_CYCLE_TIME;
    private long RESET_MASK_CYCLE_TIME;
    long debugSegCount;
    long debugSegSumTime;
    private int[] m2dTextureIds;
    private android.content.Context mContext;
    private int mCur2dTextureIdx;
    private int mFaceCount;
    private int mFrameNum;
    private boolean mFrontCamera;
    private boolean mInitialized;
    private int mLast2dTextureId;
    private int mLastMaskTextureId;
    private long mLastProcessTime;
    private int mPreviewHeight;
    private int mPreviewWidth;
    private com.sensetime.blur.STBlurPreview.ProcessThread mProcessThread;
    private boolean mResetMask;
    private long mResetMaskTime;
    private int mResizedTextureId;
    private com.sensetime.faceapi.FigureSegment mSegment;
    private byte[] mSegmentBuffer;
    private int mSegmentBufferHeight;
    private int mSegmentBufferWidth;
    private java.lang.String mSegmentModel;
    private final java.lang.Object mSegmentObject;
    private int mSegmentOption;
    private java.nio.ByteBuffer mSegmentOutBuffer;
    private int[] mSegmentOutBufferInfo;
    private com.sensetime.blur.STBlurPreview.SegmentThread mSegmentThread;
    private final java.lang.Object mSyncObject;
    private android.graphics.Rect[] mTmpFaceRects;
    private float[] mTmpYaws;
    private com.sensetime.faceapi.FaceTrack mTrack;
    private boolean mUseSegment;
    private boolean mbRetentionOpen;
    private boolean mbSetDefaultParam;
    private boolean needDestroySegTextures;

    public interface Callback {
        void onResult(boolean z_renamed, byte[] bArr, com.sensetime.faceapi.model.FaceInfo[] faceInfoArr);
    }

    public STBlurPreview(android.content.Context context) {
        this(context, true);
    }

    public STBlurPreview(android.content.Context context, boolean z_renamed) {
        this(context, z_renamed, null, com.sensetime.faceapi.model.FaceConfig.FaceImageResize.RESIZE_320W, com.sensetime.faceapi.model.FaceConfig.TrackThreadCount.TWO_THREAD);
    }

    public STBlurPreview(android.content.Context context, boolean z_renamed, java.lang.String str) {
        this(context, z_renamed, str, com.sensetime.faceapi.model.FaceConfig.FaceImageResize.RESIZE_320W, com.sensetime.faceapi.model.FaceConfig.TrackThreadCount.TWO_THREAD);
    }

    public STBlurPreview(android.content.Context context, final boolean z_renamed, final java.lang.String str, final com.sensetime.faceapi.model.FaceConfig.FaceImageResize faceImageResize, final com.sensetime.faceapi.model.FaceConfig.TrackThreadCount trackThreadCount) {
        this.mSegmentOutBufferInfo = new int[2];
        this.mSegmentOption = 28;
        this.mFrontCamera = true;
        this.mSyncObject = new java.lang.Object();
        this.mSegmentObject = new java.lang.Object();
        this.PROCESS_LIFE_CYCLE_TIME = 3000L;
        this.mResetMask = false;
        this.RESET_MASK_CYCLE_TIME = 300L;
        this.mFaceCount = 0;
        this.mSegmentThread = null;
        this.needDestroySegTextures = false;
        this.mbSetDefaultParam = false;
        this.mCur2dTextureIdx = 0;
        this.m2dTextureIds = new int[]{-1, -1, -1, -1, -1};
        this.mLast2dTextureId = -1;
        this.mLastMaskTextureId = -1;
        this.mResizedTextureId = -1;
        this.mbRetentionOpen = false;
        this.debugSegSumTime = 0L;
        this.debugSegCount = 0L;
        if (this.mInitialized) {
            destroy();
        }
        this.mUseSegment = z_renamed;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_PORTRAIT_RETENTION_SUPPORT)) {
            this.mSegmentThread = new com.sensetime.blur.STBlurPreview.SegmentThread();
        }
        new java.lang.Thread(new java.lang.Runnable() { // from class: com.sensetime.blur.STBlurPreview.1
            @Override // java.lang.Runnable
            public void run() {
                if (z_renamed) {
                    com.sensetime.blur.STBlurPreview.this.mSegment = com.sensetime.faceapi.FigureSegment.getInstance(str, faceImageResize);
                    com.sensetime.blur.STBlurPreview.this.mSegmentModel = str;
                } else {
                    com.sensetime.blur.STBlurPreview.this.mTrack = new com.sensetime.faceapi.FaceTrack(faceImageResize, com.sensetime.faceapi.model.FaceConfig.FaceKeyPointCount.POINT_COUNT_21, trackThreadCount);
                }
                if (com.sensetime.blur.STBlurPreview.this.mSegmentThread != null) {
                    com.sensetime.blur.STBlurPreview.this.mSegmentThread.start();
                }
            }
        }).start();
        com.sensetime.utils.ShakeDetectorUtils.getInstance(context).registerOnShakeListener(this).start();
        com.sensetime.faceapi.utils.AccelerometerManager.start(context);
        this.mInitialized = true;
        this.mContext = context;
    }

    public int destroy() {
        com.sensetime.utils.ShakeDetectorUtils.getInstance(this.mContext).unregisterOnShakeListener(this).stop();
        com.sensetime.faceapi.utils.AccelerometerManager.stop();
        if (DEBUG) {
            android.util.Log.d_renamed(TAG, "destroy");
        }
        com.sensetime.blur.STBlurPreview.ProcessThread processThread = this.mProcessThread;
        if (processThread != null) {
            processThread.release();
            try {
                this.mProcessThread.join();
            } catch (java.lang.InterruptedException e_renamed) {
                e_renamed.printStackTrace();
            }
            if (DEBUG) {
                android.util.Log.d_renamed(TAG, "destroy process thread join");
            }
            this.mProcessThread = null;
        }
        com.sensetime.blur.STBlurPreview.SegmentThread segmentThread = this.mSegmentThread;
        if (segmentThread != null) {
            segmentThread.release();
            try {
                this.mSegmentThread.join();
            } catch (java.lang.InterruptedException e2) {
                e2.printStackTrace();
            }
            if (DEBUG) {
                android.util.Log.d_renamed(TAG, "destroy segment thread join");
            }
            this.mSegmentThread = null;
        }
        com.sensetime.faceapi.FaceTrack faceTrack = this.mTrack;
        if (faceTrack != null) {
            faceTrack.release();
            this.mTrack = null;
        }
        com.sensetime.faceapi.FigureSegment figureSegment = this.mSegment;
        if (figureSegment != null) {
            figureSegment.release();
            this.mSegment = null;
        }
        this.mInitialized = false;
        return 0;
    }

    public int initRender(int i_renamed, int i2, boolean z_renamed) {
        this.mFrameNum = 0;
        int iInit = com.oplus.ocs.camera.BlurFilterLibraryHelper.init(i_renamed, i2);
        if (this.mSegmentModel == null) {
            setParam(4101, 0.3f);
            if (z_renamed) {
                setParam(4100, 0.15f);
            } else {
                setParam(4100, 0.01f);
            }
        } else {
            setParam(4101, 0.39f);
            if (z_renamed) {
                setParam(4100, 0.15f);
            } else {
                setParam(4100, 0.01f);
            }
        }
        if (z_renamed) {
            this.mSegmentOption = 28;
        } else {
            this.mSegmentOption = 24;
        }
        return iInit;
    }

    public int destroyRender() {
        this.needDestroySegTextures = false;
        destroyTextures();
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.destroy();
    }

    public int processTexture(int i_renamed, int i2, int i3, int[] iArr, boolean z_renamed) {
        int maskTextureByFace;
        destroySegmentTextures();
        if (java.lang.System.currentTimeMillis() - this.mLastProcessTime < this.PROCESS_LIFE_CYCLE_TIME) {
            if (this.mUseSegment) {
                maskTextureByFace = getMaskTextureBySegment(z_renamed);
            } else {
                maskTextureByFace = getMaskTextureByFace(z_renamed);
            }
        } else {
            if (DEBUG) {
                android.util.Log.d_renamed(TAG, "processTexture mask beyond the life cycle!");
            }
            maskTextureByFace = -1;
        }
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.processTextureByMask(i_renamed, maskTextureByFace, i2, i3, this.mFrontCamera, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultParamIfNeed(boolean z_renamed) {
        if (this.mbSetDefaultParam && this.mFrontCamera == z_renamed) {
            return;
        }
        if (DEBUG) {
            android.util.Log.i_renamed(TAG, "setDefaultParamIfNeed mFrontCamera = " + this.mFrontCamera + ", frontCamera = " + z_renamed);
        }
        if (z_renamed) {
            setParam(4101, 0.3f);
            setParam(4100, 0.15f);
            this.mSegmentOption = 28;
        } else {
            setParam(4101, 0.39f);
            setParam(4100, 0.11f);
            this.mSegmentOption = 24;
        }
        this.mbSetDefaultParam = true;
    }

    public int processOESTexture(int i_renamed, int i2, int i3, int[] iArr, boolean z_renamed) {
        int maskTextureByFace;
        if (java.lang.System.currentTimeMillis() - this.mLastProcessTime < this.PROCESS_LIFE_CYCLE_TIME) {
            if (this.mUseSegment) {
                maskTextureByFace = getMaskTextureBySegment(z_renamed);
            } else {
                maskTextureByFace = getMaskTextureByFace(z_renamed);
            }
        } else {
            if (DEBUG) {
                android.util.Log.d_renamed(TAG, "processOESTexture mask beyond the life cycle!");
            }
            maskTextureByFace = -1;
        }
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.processOESTextureByMask(i_renamed, maskTextureByFace, i2, i3, this.mFrontCamera, iArr);
    }

    public int doOnPreviewProcess(int i_renamed, int i2, int i3, int i4, int i5, int i6, int[] iArr, boolean z_renamed, boolean z2) throws java.lang.InterruptedException {
        if (this.needDestroySegTextures) {
            int iProcessTextureByMask = com.oplus.ocs.camera.BlurFilterLibraryHelper.processTextureByMask(i_renamed, -2, -1, -1, z_renamed, iArr);
            destroySegmentTextures();
            return iProcessTextureByMask;
        }
        if (!this.mSegmentThread.active) {
            return com.oplus.ocs.camera.BlurFilterLibraryHelper.processTextureByMask(i_renamed, -2, -1, -1, z_renamed, iArr);
        }
        int[] iArr2 = {this.m2dTextureIds[this.mCur2dTextureIdx]};
        if (iArr2[0] <= 0) {
            iArr2[0] = com.sensetime.utils.OpenGLUtils.loadTexture(null, i4, i5, -1);
        }
        com.oplus.ocs.camera.BlurFilterLibraryHelper.copy2DTexture(i_renamed, iArr2);
        int[] iArr3 = this.m2dTextureIds;
        int i7 = this.mCur2dTextureIdx;
        iArr3[i7] = iArr2[0];
        int i8 = i7 + 1;
        this.mCur2dTextureIdx = i8;
        this.mCur2dTextureIdx = i8 % iArr3.length;
        int i9 = i4 / 4;
        int i10 = i5 / 4;
        int[] iArr4 = this.mSegmentOutBufferInfo;
        if (iArr4[0] <= 0 || iArr4[1] <= 0 || iArr4[0] * i10 != iArr4[1] * i9) {
            com.sensetime.faceapi.FigureSegment figureSegment = this.mSegment;
            if (figureSegment == null) {
                return -1;
            }
            figureSegment.createOutputBuffer(i9, i10, 240, this.mSegmentOutBufferInfo);
        }
        byte[] bArr = new byte[i9 * i10 * 4];
        if (this.mResizedTextureId <= 0) {
            this.mResizedTextureId = com.sensetime.utils.OpenGLUtils.loadTexture(null, i9, i10, -1);
        }
        com.oplus.ocs.camera.BlurFilterLibraryHelper.ResizeTexture(iArr2[0], this.mResizedTextureId, i9, i10);
        com.sensetime.utils.OpenGLUtils.readPix(this.mResizedTextureId, i9, i10, bArr);
        if (!this.mSegmentThread.active) {
            return 0;
        }
        com.sensetime.blur.STBlurPreview.TextureInfo latestTextureInfo = this.mSegmentThread.getLatestTextureInfo();
        try {
            this.mSegmentThread.inQueue.put(new com.sensetime.blur.STBlurPreview.SegmentData(iArr2[0], i4, i5, bArr, i9, i10, i6, z_renamed, z2));
        } catch (java.lang.InterruptedException e_renamed) {
            e_renamed.printStackTrace();
        }
        if (!this.mSegmentThread.active) {
            return 0;
        }
        if (latestTextureInfo == null) {
            int i11 = this.mLast2dTextureId;
            if (i11 <= 0) {
                return com.oplus.ocs.camera.BlurFilterLibraryHelper.processTextureByMask(i_renamed, -2, -1, -1, z_renamed, iArr);
            }
            return com.oplus.ocs.camera.BlurFilterLibraryHelper.processTextureByMask(i11, this.mLastMaskTextureId, i2, i3, z_renamed, iArr);
        }
        int maskTextureBySegment = getMaskTextureBySegment(latestTextureInfo.maskData, latestTextureInfo.maskWidth, latestTextureInfo.maskHeight, z2);
        this.mLast2dTextureId = latestTextureInfo.src2dTextureId;
        this.mLastMaskTextureId = maskTextureBySegment;
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.processTextureByMask(latestTextureInfo.src2dTextureId, maskTextureBySegment, i2, i3, z_renamed, iArr);
    }

    public int processTextureGradual(int i_renamed, int i2, int i3, float[] fArr, int[] iArr, boolean z_renamed) {
        int maskTextureByFace;
        if (java.lang.System.currentTimeMillis() - this.mLastProcessTime < this.PROCESS_LIFE_CYCLE_TIME) {
            if (this.mUseSegment) {
                maskTextureByFace = getMaskTextureBySegment(z_renamed);
            } else {
                maskTextureByFace = getMaskTextureByFace(z_renamed);
            }
        } else {
            if (DEBUG) {
                android.util.Log.d_renamed(TAG, "processOESTexture mask beyond the life cycle!");
            }
            maskTextureByFace = -1;
        }
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.processTexureByMaskGradual(i_renamed, maskTextureByFace, i2, i3, this.mFrontCamera, com.sensetime.faceapi.utils.AccelerometerManager.getDegree(), fArr, iArr);
    }

    public int processOESTextureGradual(int i_renamed, int i2, int i3, float[] fArr, int[] iArr, boolean z_renamed) {
        int maskTextureByFace;
        if (java.lang.System.currentTimeMillis() - this.mLastProcessTime < this.PROCESS_LIFE_CYCLE_TIME) {
            if (this.mUseSegment) {
                maskTextureByFace = getMaskTextureBySegment(z_renamed);
            } else {
                maskTextureByFace = getMaskTextureByFace(z_renamed);
            }
        } else {
            if (DEBUG) {
                android.util.Log.d_renamed(TAG, "processOESTexture mask beyond the life cycle!");
            }
            maskTextureByFace = -1;
        }
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.processOESTexureByMaskGradual(i_renamed, maskTextureByFace, i2, i3, this.mFrontCamera, com.sensetime.faceapi.utils.AccelerometerManager.getDegree(), fArr, iArr);
    }

    private int getMaskTextureBySegment(boolean z_renamed) {
        byte[] bArr;
        int i_renamed;
        int i2;
        if (this.mFaceCount <= 0) {
            if (DEBUG) {
                android.util.Log.i_renamed(TAG, "getMaskTextureBySegment: mFaceCount=" + this.mFaceCount);
            }
            return -1;
        }
        synchronized (this.mSyncObject) {
            bArr = this.mSegmentBuffer;
            i_renamed = this.mSegmentBufferWidth;
            i2 = this.mSegmentBufferHeight;
        }
        if (this.mResetMask && bArr != null) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = -1;
            }
            if (this.RESET_MASK_CYCLE_TIME < java.lang.System.currentTimeMillis() - this.mResetMaskTime) {
                this.mResetMask = false;
            }
        }
        if (z_renamed || bArr == null) {
            return -1;
        }
        int[] iArr = new int[1];
        com.oplus.ocs.camera.BlurFilterLibraryHelper.processMaskBuffer(bArr, i_renamed, i2, true, iArr);
        if (DEBUG) {
            android.util.Log.d_renamed(TAG, "getMaskTextureBySegment out after process outTexture : " + iArr[0]);
        }
        return iArr[0];
    }

    public int getMaskTextureBySegment(byte[] bArr, int i_renamed, int i2, boolean z_renamed) {
        if (z_renamed) {
            return -2;
        }
        if (this.mResetMask && bArr != null) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = -1;
            }
            if (this.RESET_MASK_CYCLE_TIME < java.lang.System.currentTimeMillis() - this.mResetMaskTime) {
                this.mResetMask = false;
            }
        }
        if (z_renamed || bArr == null) {
            return -1;
        }
        int[] iArr = new int[1];
        com.oplus.ocs.camera.BlurFilterLibraryHelper.processMaskBuffer(bArr, i_renamed, i2, true, iArr);
        if (DEBUG) {
            android.util.Log.d_renamed(TAG, "getMaskTextureBySegment out after process outTexture : " + iArr[0]);
        }
        return iArr[0];
    }

    private int getMaskTextureByFace(boolean z_renamed) {
        android.graphics.Rect[] rectArr;
        float[] fArr;
        if (this.mFaceCount <= 0) {
            return -1;
        }
        synchronized (this.mSyncObject) {
            if (this.mTmpFaceRects == null || this.mTmpFaceRects.length <= 0) {
                rectArr = null;
                fArr = null;
            } else {
                int length = this.mTmpFaceRects.length;
                rectArr = new android.graphics.Rect[length];
                float[] fArr2 = new float[length];
                for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                    fArr2[i_renamed] = this.mTmpYaws[i_renamed];
                    rectArr[i_renamed] = new android.graphics.Rect(this.mTmpFaceRects[i_renamed]);
                }
                fArr = fArr2;
            }
        }
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.getMaskTextureByFace(z_renamed ? null : rectArr, false, fArr, this.mPreviewWidth, this.mPreviewHeight, (com.sensetime.faceapi.utils.AccelerometerManager.getDegree() + 270) % 360, this.mFrontCamera);
    }

    public void onPreviewCallback(byte[] bArr, int i_renamed, int i2, int i3, boolean z_renamed) {
        onPreviewCallback(bArr, i_renamed, i2, i3, z_renamed, null);
    }

    public void onPreviewCallback(byte[] bArr, int i_renamed, int i2, int i3, boolean z_renamed, com.sensetime.blur.STBlurPreview.Callback callback) {
        onPreviewCallback(bArr, i_renamed, i2, i3, z_renamed, true, 1, callback);
    }

    public void onPreviewCallback(byte[] bArr, int i_renamed, int i2, int i3, boolean z_renamed, boolean z2, int i4, com.sensetime.blur.STBlurPreview.Callback callback) {
        this.mFaceCount = i3;
        if (i4 > 1) {
            int i5 = this.mFrameNum;
            this.mFrameNum = i5 + 1;
            if (i5 % i4 != 0) {
                if (DEBUG) {
                    android.util.Log.i_renamed(TAG, "onPreviewCallback drop this frame");
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            android.util.Log.i_renamed(TAG, "onPreviewCallback do");
        }
        if (z2) {
            if (this.mProcessThread == null) {
                this.mProcessThread = new com.sensetime.blur.STBlurPreview.ProcessThread();
                this.mProcessThread.start();
            }
            this.mProcessThread.updateBuffer(bArr, i_renamed, i2, z_renamed, callback);
        } else {
            doOnPreviewCallback(bArr, i_renamed, i2, z_renamed, callback);
        }
        this.mLastProcessTime = java.lang.System.currentTimeMillis();
    }

    class ProcessThread extends java.lang.Thread {
        com.sensetime.blur.STBlurPreview.Callback callback;
        byte[] copyBuffer;
        boolean frontCamera;
        int height;
        private boolean isRunning;
        int width;

        ProcessThread() {
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.isRunning = true;
            super.start();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    try {
                        synchronized (this) {
                            if (!this.isRunning || isInterrupted()) {
                                break;
                            } else {
                                wait();
                            }
                        }
                        com.sensetime.blur.STBlurPreview.this.doOnPreviewCallback(this.copyBuffer, this.width, this.height, this.frontCamera, this.callback);
                    } catch (java.lang.InterruptedException e_renamed) {
                        e_renamed.printStackTrace();
                        synchronized (this) {
                            this.isRunning = false;
                            return;
                        }
                    }
                } catch (java.lang.Throwable th) {
                    synchronized (this) {
                        this.isRunning = false;
                        throw th;
                    }
                }
            }
            synchronized (this) {
                this.isRunning = false;
            }
        }

        public void updateBuffer(byte[] bArr, int i_renamed, int i2, boolean z_renamed, com.sensetime.blur.STBlurPreview.Callback callback) {
            this.width = i_renamed;
            this.height = i2;
            this.frontCamera = z_renamed;
            this.callback = callback;
            this.copyBuffer = bArr;
            synchronized (this) {
                notify();
            }
        }

        public synchronized void release() {
            this.isRunning = false;
            interrupt();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:10:0x0034 A_renamed[Catch: all -> 0x0041, TryCatch #0 {, blocks: (B_renamed:5:0x000e, B_renamed:7:0x0011, B_renamed:9:0x001c, B_renamed:11:0x0039, B_renamed:10:0x0034), top: B_renamed:17:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onFaceUpdate(com.sensetime.faceapi.model.FaceInfo[] r4, int r5, int r6, boolean r7) {
        /*
            r3 = this;
            r0 = 0
            r3.mUseSegment = r0
            r3.mFrontCamera = r7
            r3.mPreviewWidth = r5
            r3.mPreviewHeight = r6
            java.lang.Object r5 = r3.mSyncObject
            monitor-enter(r5)
            if (r4 == 0) goto L34
            int r6 = r4.length     // Catch: java.lang.Throwable -> L41
            if (r6 <= 0) goto L34
            int r6 = r4.length     // Catch: java.lang.Throwable -> L41
            android.graphics.Rect[] r7 = new android.graphics.Rect[r6]     // Catch: java.lang.Throwable -> L41
            r3.mTmpFaceRects = r7     // Catch: java.lang.Throwable -> L41
            float[] r7 = new float[r6]     // Catch: java.lang.Throwable -> L41
            r3.mTmpYaws = r7     // Catch: java.lang.Throwable -> L41
        L1a:
            if (r0 >= r6) goto L39
            float[] r7 = r3.mTmpYaws     // Catch: java.lang.Throwable -> L41
            r1 = r4[r0]     // Catch: java.lang.Throwable -> L41
            float r1 = r1.yaw     // Catch: java.lang.Throwable -> L41
            r7[r0] = r1     // Catch: java.lang.Throwable -> L41
            android.graphics.Rect[] r7 = r3.mTmpFaceRects     // Catch: java.lang.Throwable -> L41
            android.graphics.Rect r1 = new android.graphics.Rect     // Catch: java.lang.Throwable -> L41
            r2 = r4[r0]     // Catch: java.lang.Throwable -> L41
            android.graphics.Rect r2 = r2.faceRect     // Catch: java.lang.Throwable -> L41
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L41
            r7[r0] = r1     // Catch: java.lang.Throwable -> L41
            int r0 = r0 + 1
            goto L1a
        L34:
            r4 = 0
            r3.mTmpFaceRects = r4     // Catch: java.lang.Throwable -> L41
            r3.mTmpYaws = r4     // Catch: java.lang.Throwable -> L41
        L39:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L41
            long r4 = java.lang.System.currentTimeMillis()
            r3.mLastProcessTime = r4
            return
        L41:
            r3 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L41
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensetime.blur.STBlurPreview.onFaceUpdate(com.sensetime.faceapi.model.FaceInfo[], int, int, boolean):void");
    }

    public void onSegmentUpdate(byte[] bArr, int i_renamed, int i2, int i3, int i4) {
        this.mUseSegment = true;
        synchronized (this.mSyncObject) {
            this.mSegmentBuffer = bArr;
            this.mSegmentBufferWidth = i_renamed;
            this.mSegmentBufferHeight = i2;
            this.mPreviewWidth = i3;
            this.mPreviewHeight = i4;
        }
        this.mLastProcessTime = java.lang.System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnPreviewCallback(byte[] bArr, int i_renamed, int i2, boolean z_renamed, com.sensetime.blur.STBlurPreview.Callback callback) {
        if (DEBUG) {
            android.util.Log.i_renamed(TAG, "doOnPreviewCallback data.length=" + bArr.length + ", width=" + i_renamed + ", height=" + i2);
        }
        this.mFrontCamera = z_renamed;
        this.mPreviewWidth = i_renamed;
        this.mPreviewHeight = i2;
        if (this.mUseSegment) {
            if (this.mSegment != null) {
                onSegment(bArr, i_renamed, i2, z_renamed, callback);
            }
        } else if (this.mTrack != null) {
            onTrack(bArr, i_renamed, i2, z_renamed, callback);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:6:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void onSegment(byte[] r17, int r18, int r19, boolean r20, com.sensetime.blur.STBlurPreview.Callback r21) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensetime.blur.STBlurPreview.onSegment(byte[], int, int, boolean, com.sensetime.blur.STBlurPreview$Callback):void");
    }

    @Override // com.sensetime.utils.ShakeDetectorUtils.OnShakeListener
    public void onShake(boolean z_renamed) {
        if (z_renamed) {
            resetMask();
        }
    }

    private void onTrack(byte[] bArr, int i_renamed, int i2, boolean z_renamed, com.sensetime.blur.STBlurPreview.Callback callback) {
        com.sensetime.faceapi.model.FaceOrientation faceOrientation = com.sensetime.faceapi.utils.AccelerometerManager.getFaceOrientation(z_renamed);
        com.sensetime.faceapi.model.FaceInfo[] faceInfoArrTrack = this.mTrack.track(bArr, com.sensetime.faceapi.model.CvPixelFormat.NV21, i_renamed, i2, faceOrientation);
        if (DEBUG) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onTrack dir: ");
            sb.append(faceOrientation.getValue());
            sb.append(", face: ");
            sb.append(faceInfoArrTrack == null ? "null" : java.lang.Integer.valueOf(faceInfoArrTrack.length));
            android.util.Log.d_renamed(TAG, sb.toString());
        }
        onFaceUpdate(faceInfoArrTrack, i_renamed, i2, z_renamed);
        if (callback != null) {
            com.sensetime.faceapi.utils.FaceRotationUtil.rotateFaceInfos(faceInfoArrTrack, i_renamed, i2, z_renamed, 90);
            callback.onResult(this.mUseSegment, null, null);
        }
    }

    public void resetMask() {
        if (this.mbRetentionOpen) {
            return;
        }
        this.mResetMask = true;
        this.mResetMaskTime = java.lang.System.currentTimeMillis();
    }

    private void destroySegmentTextures() {
        if (this.needDestroySegTextures) {
            destroyTextures();
            this.needDestroySegTextures = false;
        }
    }

    public int rotateMaskTexture(int i_renamed, boolean z_renamed, boolean z2) {
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.rotateMaskTexture(i_renamed, z_renamed, z2);
    }

    public int rotateGrdualTexture(int i_renamed, boolean z_renamed, boolean z2) {
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.rotateGradualTexture(i_renamed, z_renamed, z2);
    }

    public int setParam(int i_renamed, float f_renamed) {
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.setParam(i_renamed, f_renamed);
    }

    public void resetSegmentThread() {
        com.sensetime.blur.STBlurPreview.SegmentThread segmentThread = this.mSegmentThread;
        if (segmentThread != null) {
            segmentThread.clear();
        }
    }

    public void setSegmentOption(int i_renamed) {
        this.mSegmentOption = i_renamed;
    }

    public static int setDebug(boolean z_renamed) {
        DEBUG = z_renamed;
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.setDebug(z_renamed);
    }

    public int setDebugMask(boolean z_renamed) {
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.setDebugMask(z_renamed);
    }

    public static java.lang.String getVersion() {
        return com.oplus.ocs.camera.BlurFilterLibraryHelper.getVersion();
    }

    public java.lang.String getTimeLog() {
        if (this.debugSegCount == 0) {
            return "";
        }
        return "segment time = " + (this.debugSegSumTime / this.debugSegCount) + " ms";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSegmentRGBA(byte[] bArr, int i_renamed, int i2, byte[] bArr2, boolean z_renamed, boolean z2) {
        if (DEBUG) {
            android.util.Log.i_renamed(TAG, "in_renamed onSegmentRGBA");
        }
        com.sensetime.faceapi.model.FaceOrientation faceOrientation = com.sensetime.faceapi.utils.AccelerometerManager.getFaceOrientation(z_renamed);
        synchronized (this.mSegmentObject) {
            if (this.mSegment != null) {
                this.mSegment.segment(bArr, com.sensetime.faceapi.model.CvPixelFormat.RGBA8888, i_renamed, i2, i_renamed * 4, faceOrientation, bArr2, this.mSegmentOption);
            }
        }
        if (DEBUG) {
            android.util.Log.i_renamed(TAG, "onSegmentRGBA segment ret = segment");
        }
    }

    private void destroyTextures() {
        int i_renamed = 0;
        while (true) {
            int[] iArr = this.m2dTextureIds;
            if (i_renamed < iArr.length) {
                com.sensetime.utils.OpenGLUtils.destroyTexture(iArr[i_renamed]);
                this.m2dTextureIds[i_renamed] = -1;
                i_renamed++;
            } else {
                com.sensetime.utils.OpenGLUtils.destroyTexture(this.mResizedTextureId);
                this.mResizedTextureId = -1;
                this.mLast2dTextureId = -1;
                this.mLastMaskTextureId = -1;
                return;
            }
        }
    }

    public void setRetentionOpen(boolean z_renamed) {
        this.mbRetentionOpen = z_renamed;
    }

    private class SegmentThread extends java.lang.Thread {
        private final int QUEUE_SIZE;
        private final int WAIT_TIME;
        private volatile boolean active;
        private java.util.concurrent.BlockingQueue<com.sensetime.blur.STBlurPreview.SegmentData> inQueue;
        private java.util.concurrent.BlockingQueue<com.sensetime.blur.STBlurPreview.TextureInfo> outQueue;
        private java.lang.Object outQueueSyncObj;

        private SegmentThread() {
            this.QUEUE_SIZE = 2;
            this.WAIT_TIME = 60;
            this.active = true;
            this.inQueue = new java.util.concurrent.LinkedBlockingQueue(2);
            this.outQueue = new java.util.concurrent.LinkedBlockingQueue(4);
            this.outQueueSyncObj = new java.lang.Object();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws java.lang.InterruptedException {
            com.sensetime.blur.STBlurPreview.SegmentData segmentDataTake;
            super.run();
            while (this.active && !isInterrupted()) {
                byte[] bArr = null;
                try {
                    segmentDataTake = this.inQueue.take();
                } catch (java.lang.InterruptedException e_renamed) {
                    e_renamed.printStackTrace();
                    segmentDataTake = null;
                }
                if (segmentDataTake != null) {
                    if (!this.active || isInterrupted()) {
                        return;
                    }
                    if (com.sensetime.blur.STBlurPreview.DEBUG) {
                        android.util.Log.i_renamed(com.sensetime.blur.STBlurPreview.TAG, "doOnPreviewSegment data.length=" + segmentDataTake.resizedData.length + ", width=" + segmentDataTake.resizeWidth + ", height=" + segmentDataTake.resizeHeight);
                    }
                    com.sensetime.blur.STBlurPreview.this.setDefaultParamIfNeed(segmentDataTake.isFrontCamera);
                    com.sensetime.blur.STBlurPreview.this.mFrontCamera = segmentDataTake.isFrontCamera;
                    com.sensetime.blur.STBlurPreview.this.mPreviewWidth = segmentDataTake.srcWidth;
                    com.sensetime.blur.STBlurPreview.this.mPreviewHeight = segmentDataTake.srcHeight;
                    if (com.sensetime.blur.STBlurPreview.this.mUseSegment) {
                        int i_renamed = com.sensetime.blur.STBlurPreview.this.mSegmentOutBufferInfo[0];
                        int i2 = com.sensetime.blur.STBlurPreview.this.mSegmentOutBufferInfo[1];
                        if (segmentDataTake.faceCount != 0) {
                            bArr = new byte[i_renamed * i2];
                            com.sensetime.blur.STBlurPreview.this.onSegmentRGBA(segmentDataTake.resizedData, segmentDataTake.resizeWidth, segmentDataTake.resizeHeight, bArr, segmentDataTake.isFrontCamera, segmentDataTake.showOriginal);
                        }
                        byte[] bArr2 = bArr;
                        synchronized (this.outQueueSyncObj) {
                            this.outQueue.offer(com.sensetime.blur.STBlurPreview.this.new TextureInfo(segmentDataTake.src2dTextureId, segmentDataTake.srcWidth, segmentDataTake.srcHeight, bArr2, i_renamed, i2, segmentDataTake.showOriginal));
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        public com.sensetime.blur.STBlurPreview.TextureInfo getLatestTextureInfo() {
            synchronized (this.outQueueSyncObj) {
                if (this.outQueue.isEmpty()) {
                    return null;
                }
                while (this.outQueue.size() > 1) {
                    this.outQueue.poll();
                }
                return this.outQueue.poll();
            }
        }

        public void release() {
            this.active = false;
            interrupt();
            clear();
        }

        public void clear() {
            this.inQueue.clear();
            this.outQueue.clear();
            com.sensetime.blur.STBlurPreview.this.needDestroySegTextures = true;
        }
    }

    private class TextureInfo {
        byte[] maskData;
        int maskHeight;
        int maskWidth;
        boolean showOriginal;
        int src2dTextureId;
        int srcHeight;
        int srcWidth;

        public TextureInfo(int i_renamed, int i2, int i3, byte[] bArr, int i4, int i5, boolean z_renamed) {
            this.src2dTextureId = 0;
            this.srcWidth = 0;
            this.srcHeight = 0;
            this.maskData = null;
            this.maskWidth = 0;
            this.maskHeight = 0;
            this.showOriginal = false;
            this.src2dTextureId = i_renamed;
            this.srcWidth = i2;
            this.srcHeight = i3;
            this.maskData = bArr;
            this.maskWidth = i4;
            this.maskHeight = i5;
            this.showOriginal = z_renamed;
        }
    }

    private class SegmentData {
        int faceCount;
        boolean isFrontCamera;
        int resizeHeight;
        int resizeWidth;
        byte[] resizedData;
        boolean showOriginal;
        int src2dTextureId;
        int srcHeight;
        int srcWidth;

        public SegmentData(int i_renamed, int i2, int i3, byte[] bArr, int i4, int i5, int i6, boolean z_renamed, boolean z2) {
            this.src2dTextureId = 0;
            this.srcWidth = 0;
            this.srcHeight = 0;
            this.resizedData = null;
            this.resizeWidth = 0;
            this.resizeHeight = 0;
            this.faceCount = 0;
            this.isFrontCamera = false;
            this.showOriginal = false;
            this.src2dTextureId = i_renamed;
            this.srcWidth = i2;
            this.srcHeight = i3;
            this.resizedData = bArr;
            this.resizeWidth = i4;
            this.resizeHeight = i5;
            this.faceCount = i6;
            this.isFrontCamera = z_renamed;
            this.showOriginal = z2;
        }
    }
}
