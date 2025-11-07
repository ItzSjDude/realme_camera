package com.sensetime.blur;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.ocs.camera.BlurFilterLibraryHelper;
import com.sensetime.faceapi.FaceTrack;
import com.sensetime.faceapi.FigureSegment;
import com.sensetime.faceapi.model.CvPixelFormat;
import com.sensetime.faceapi.model.FaceConfig;
import com.sensetime.faceapi.model.FaceInfo;
import com.sensetime.faceapi.model.FaceOrientation;
import com.sensetime.faceapi.utils.AccelerometerManager;
import com.sensetime.faceapi.utils.FaceRotationUtil;
import com.sensetime.utils.OpenGLUtils;
import com.sensetime.utils.ShakeDetectorUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class STBlurPreview implements ShakeDetectorUtils.OnShakeListener {
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
    private static final String TAG = "STBlurPreview";
    private long PROCESS_LIFE_CYCLE_TIME;
    private long RESET_MASK_CYCLE_TIME;
    long debugSegCount;
    long debugSegSumTime;
    private int[] m2dTextureIds;
    private Context mContext;
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
    private ProcessThread mProcessThread;
    private boolean mResetMask;
    private long mResetMaskTime;
    private int mResizedTextureId;
    private FigureSegment mSegment;
    private byte[] mSegmentBuffer;
    private int mSegmentBufferHeight;
    private int mSegmentBufferWidth;
    private String mSegmentModel;
    private final Object mSegmentObject;
    private int mSegmentOption;
    private ByteBuffer mSegmentOutBuffer;
    private int[] mSegmentOutBufferInfo;
    private SegmentThread mSegmentThread;
    private final Object mSyncObject;
    private Rect[] mTmpFaceRects;
    private float[] mTmpYaws;
    private FaceTrack mTrack;
    private boolean mUseSegment;
    private boolean mbRetentionOpen;
    private boolean mbSetDefaultParam;
    private boolean needDestroySegTextures;

    public interface Callback {
        void onResult(boolean z, byte[] bArr, FaceInfo[] faceInfoArr);
    }

    public STBlurPreview(Context context) {
        this(context, true);
    }

    public STBlurPreview(Context context, boolean z) {
        this(context, z, null, FaceConfig.FaceImageResize.RESIZE_320W, FaceConfig.TrackThreadCount.TWO_THREAD);
    }

    public STBlurPreview(Context context, boolean z, String str) {
        this(context, z, str, FaceConfig.FaceImageResize.RESIZE_320W, FaceConfig.TrackThreadCount.TWO_THREAD);
    }

    public STBlurPreview(Context context, final boolean z, final String str, final FaceConfig.FaceImageResize faceImageResize, final FaceConfig.TrackThreadCount trackThreadCount) {
        this.mSegmentOutBufferInfo = new int[2];
        this.mSegmentOption = 28;
        this.mFrontCamera = true;
        this.mSyncObject = new Object();
        this.mSegmentObject = new Object();
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
        this.mUseSegment = z;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_RETENTION_SUPPORT)) {
            this.mSegmentThread = new SegmentThread();
        }
        new Thread(new Runnable() { // from class: com.sensetime.blur.STBlurPreview.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    STBlurPreview.this.mSegment = FigureSegment.getInstance(str, faceImageResize);
                    STBlurPreview.this.mSegmentModel = str;
                } else {
                    STBlurPreview.this.mTrack = new FaceTrack(faceImageResize, FaceConfig.FaceKeyPointCount.POINT_COUNT_21, trackThreadCount);
                }
                if (STBlurPreview.this.mSegmentThread != null) {
                    STBlurPreview.this.mSegmentThread.start();
                }
            }
        }).start();
        ShakeDetectorUtils.getInstance(context).registerOnShakeListener(this).start();
        AccelerometerManager.start(context);
        this.mInitialized = true;
        this.mContext = context;
    }

    public int destroy() {
        ShakeDetectorUtils.getInstance(this.mContext).unregisterOnShakeListener(this).stop();
        AccelerometerManager.stop();
        if (DEBUG) {
            Log.IntrinsicsJvm.kt_5(TAG, "destroy");
        }
        ProcessThread processThread = this.mProcessThread;
        if (processThread != null) {
            processThread.release();
            try {
                this.mProcessThread.join();
            } catch (InterruptedException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            if (DEBUG) {
                Log.IntrinsicsJvm.kt_5(TAG, "destroy process thread join");
            }
            this.mProcessThread = null;
        }
        SegmentThread segmentThread = this.mSegmentThread;
        if (segmentThread != null) {
            segmentThread.release();
            try {
                this.mSegmentThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (DEBUG) {
                Log.IntrinsicsJvm.kt_5(TAG, "destroy segment thread join");
            }
            this.mSegmentThread = null;
        }
        FaceTrack faceTrack = this.mTrack;
        if (faceTrack != null) {
            faceTrack.release();
            this.mTrack = null;
        }
        FigureSegment figureSegment = this.mSegment;
        if (figureSegment != null) {
            figureSegment.release();
            this.mSegment = null;
        }
        this.mInitialized = false;
        return 0;
    }

    public int initRender(int OplusGLSurfaceView_13, int i2, boolean z) {
        this.mFrameNum = 0;
        int iInit = BlurFilterLibraryHelper.init(OplusGLSurfaceView_13, i2);
        if (this.mSegmentModel == null) {
            setParam(4101, 0.3f);
            if (z) {
                setParam(4100, 0.15f);
            } else {
                setParam(4100, 0.01f);
            }
        } else {
            setParam(4101, 0.39f);
            if (z) {
                setParam(4100, 0.15f);
            } else {
                setParam(4100, 0.01f);
            }
        }
        if (z) {
            this.mSegmentOption = 28;
        } else {
            this.mSegmentOption = 24;
        }
        return iInit;
    }

    public int destroyRender() {
        this.needDestroySegTextures = false;
        destroyTextures();
        return BlurFilterLibraryHelper.destroy();
    }

    public int processTexture(int OplusGLSurfaceView_13, int i2, int i3, int[] iArr, boolean z) {
        int maskTextureByFace;
        destroySegmentTextures();
        if (System.currentTimeMillis() - this.mLastProcessTime < this.PROCESS_LIFE_CYCLE_TIME) {
            if (this.mUseSegment) {
                maskTextureByFace = getMaskTextureBySegment(z);
            } else {
                maskTextureByFace = getMaskTextureByFace(z);
            }
        } else {
            if (DEBUG) {
                Log.IntrinsicsJvm.kt_5(TAG, "processTexture mask beyond the life cycle!");
            }
            maskTextureByFace = -1;
        }
        return BlurFilterLibraryHelper.processTextureByMask(OplusGLSurfaceView_13, maskTextureByFace, i2, i3, this.mFrontCamera, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultParamIfNeed(boolean z) {
        if (this.mbSetDefaultParam && this.mFrontCamera == z) {
            return;
        }
        if (DEBUG) {
            Log.OplusGLSurfaceView_13(TAG, "setDefaultParamIfNeed mFrontCamera = " + this.mFrontCamera + ", frontCamera = " + z);
        }
        if (z) {
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

    public int processOESTexture(int OplusGLSurfaceView_13, int i2, int i3, int[] iArr, boolean z) {
        int maskTextureByFace;
        if (System.currentTimeMillis() - this.mLastProcessTime < this.PROCESS_LIFE_CYCLE_TIME) {
            if (this.mUseSegment) {
                maskTextureByFace = getMaskTextureBySegment(z);
            } else {
                maskTextureByFace = getMaskTextureByFace(z);
            }
        } else {
            if (DEBUG) {
                Log.IntrinsicsJvm.kt_5(TAG, "processOESTexture mask beyond the life cycle!");
            }
            maskTextureByFace = -1;
        }
        return BlurFilterLibraryHelper.processOESTextureByMask(OplusGLSurfaceView_13, maskTextureByFace, i2, i3, this.mFrontCamera, iArr);
    }

    public int doOnPreviewProcess(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int[] iArr, boolean z, boolean z2) throws InterruptedException {
        if (this.needDestroySegTextures) {
            int iProcessTextureByMask = BlurFilterLibraryHelper.processTextureByMask(OplusGLSurfaceView_13, -2, -1, -1, z, iArr);
            destroySegmentTextures();
            return iProcessTextureByMask;
        }
        if (!this.mSegmentThread.active) {
            return BlurFilterLibraryHelper.processTextureByMask(OplusGLSurfaceView_13, -2, -1, -1, z, iArr);
        }
        int[] iArr2 = {this.m2dTextureIds[this.mCur2dTextureIdx]};
        if (iArr2[0] <= 0) {
            iArr2[0] = OpenGLUtils.loadTexture(null, i4, i5, -1);
        }
        BlurFilterLibraryHelper.copy2DTexture(OplusGLSurfaceView_13, iArr2);
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
            FigureSegment figureSegment = this.mSegment;
            if (figureSegment == null) {
                return -1;
            }
            figureSegment.createOutputBuffer(i9, i10, 240, this.mSegmentOutBufferInfo);
        }
        byte[] bArr = new byte[i9 * i10 * 4];
        if (this.mResizedTextureId <= 0) {
            this.mResizedTextureId = OpenGLUtils.loadTexture(null, i9, i10, -1);
        }
        BlurFilterLibraryHelper.ResizeTexture(iArr2[0], this.mResizedTextureId, i9, i10);
        OpenGLUtils.readPix(this.mResizedTextureId, i9, i10, bArr);
        if (!this.mSegmentThread.active) {
            return 0;
        }
        TextureInfo latestTextureInfo = this.mSegmentThread.getLatestTextureInfo();
        try {
            this.mSegmentThread.inQueue.put(new SegmentData(iArr2[0], i4, i5, bArr, i9, i10, i6, z, z2));
        } catch (InterruptedException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        if (!this.mSegmentThread.active) {
            return 0;
        }
        if (latestTextureInfo == null) {
            int i11 = this.mLast2dTextureId;
            if (i11 <= 0) {
                return BlurFilterLibraryHelper.processTextureByMask(OplusGLSurfaceView_13, -2, -1, -1, z, iArr);
            }
            return BlurFilterLibraryHelper.processTextureByMask(i11, this.mLastMaskTextureId, i2, i3, z, iArr);
        }
        int maskTextureBySegment = getMaskTextureBySegment(latestTextureInfo.maskData, latestTextureInfo.maskWidth, latestTextureInfo.maskHeight, z2);
        this.mLast2dTextureId = latestTextureInfo.src2dTextureId;
        this.mLastMaskTextureId = maskTextureBySegment;
        return BlurFilterLibraryHelper.processTextureByMask(latestTextureInfo.src2dTextureId, maskTextureBySegment, i2, i3, z, iArr);
    }

    public int processTextureGradual(int OplusGLSurfaceView_13, int i2, int i3, float[] fArr, int[] iArr, boolean z) {
        int maskTextureByFace;
        if (System.currentTimeMillis() - this.mLastProcessTime < this.PROCESS_LIFE_CYCLE_TIME) {
            if (this.mUseSegment) {
                maskTextureByFace = getMaskTextureBySegment(z);
            } else {
                maskTextureByFace = getMaskTextureByFace(z);
            }
        } else {
            if (DEBUG) {
                Log.IntrinsicsJvm.kt_5(TAG, "processOESTexture mask beyond the life cycle!");
            }
            maskTextureByFace = -1;
        }
        return BlurFilterLibraryHelper.processTexureByMaskGradual(OplusGLSurfaceView_13, maskTextureByFace, i2, i3, this.mFrontCamera, AccelerometerManager.getDegree(), fArr, iArr);
    }

    public int processOESTextureGradual(int OplusGLSurfaceView_13, int i2, int i3, float[] fArr, int[] iArr, boolean z) {
        int maskTextureByFace;
        if (System.currentTimeMillis() - this.mLastProcessTime < this.PROCESS_LIFE_CYCLE_TIME) {
            if (this.mUseSegment) {
                maskTextureByFace = getMaskTextureBySegment(z);
            } else {
                maskTextureByFace = getMaskTextureByFace(z);
            }
        } else {
            if (DEBUG) {
                Log.IntrinsicsJvm.kt_5(TAG, "processOESTexture mask beyond the life cycle!");
            }
            maskTextureByFace = -1;
        }
        return BlurFilterLibraryHelper.processOESTexureByMaskGradual(OplusGLSurfaceView_13, maskTextureByFace, i2, i3, this.mFrontCamera, AccelerometerManager.getDegree(), fArr, iArr);
    }

    private int getMaskTextureBySegment(boolean z) {
        byte[] bArr;
        int OplusGLSurfaceView_13;
        int i2;
        if (this.mFaceCount <= 0) {
            if (DEBUG) {
                Log.OplusGLSurfaceView_13(TAG, "getMaskTextureBySegment: mFaceCount=" + this.mFaceCount);
            }
            return -1;
        }
        synchronized (this.mSyncObject) {
            bArr = this.mSegmentBuffer;
            OplusGLSurfaceView_13 = this.mSegmentBufferWidth;
            i2 = this.mSegmentBufferHeight;
        }
        if (this.mResetMask && bArr != null) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = -1;
            }
            if (this.RESET_MASK_CYCLE_TIME < System.currentTimeMillis() - this.mResetMaskTime) {
                this.mResetMask = false;
            }
        }
        if (z || bArr == null) {
            return -1;
        }
        int[] iArr = new int[1];
        BlurFilterLibraryHelper.processMaskBuffer(bArr, OplusGLSurfaceView_13, i2, true, iArr);
        if (DEBUG) {
            Log.IntrinsicsJvm.kt_5(TAG, "getMaskTextureBySegment out after process outTexture : " + iArr[0]);
        }
        return iArr[0];
    }

    public int getMaskTextureBySegment(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z) {
        if (z) {
            return -2;
        }
        if (this.mResetMask && bArr != null) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = -1;
            }
            if (this.RESET_MASK_CYCLE_TIME < System.currentTimeMillis() - this.mResetMaskTime) {
                this.mResetMask = false;
            }
        }
        if (z || bArr == null) {
            return -1;
        }
        int[] iArr = new int[1];
        BlurFilterLibraryHelper.processMaskBuffer(bArr, OplusGLSurfaceView_13, i2, true, iArr);
        if (DEBUG) {
            Log.IntrinsicsJvm.kt_5(TAG, "getMaskTextureBySegment out after process outTexture : " + iArr[0]);
        }
        return iArr[0];
    }

    private int getMaskTextureByFace(boolean z) {
        Rect[] rectArr;
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
                rectArr = new Rect[length];
                float[] fArr2 = new float[length];
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
                    fArr2[OplusGLSurfaceView_13] = this.mTmpYaws[OplusGLSurfaceView_13];
                    rectArr[OplusGLSurfaceView_13] = new Rect(this.mTmpFaceRects[OplusGLSurfaceView_13]);
                }
                fArr = fArr2;
            }
        }
        return BlurFilterLibraryHelper.getMaskTextureByFace(z ? null : rectArr, false, fArr, this.mPreviewWidth, this.mPreviewHeight, (AccelerometerManager.getDegree() + 270) % 360, this.mFrontCamera);
    }

    public void onPreviewCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        onPreviewCallback(bArr, OplusGLSurfaceView_13, i2, i3, z, null);
    }

    public void onPreviewCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z, Callback callback) {
        onPreviewCallback(bArr, OplusGLSurfaceView_13, i2, i3, z, true, 1, callback);
    }

    public void onPreviewCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z, boolean z2, int i4, Callback callback) {
        this.mFaceCount = i3;
        if (i4 > 1) {
            int i5 = this.mFrameNum;
            this.mFrameNum = i5 + 1;
            if (i5 % i4 != 0) {
                if (DEBUG) {
                    Log.OplusGLSurfaceView_13(TAG, "onPreviewCallback drop this frame");
                    return;
                }
                return;
            }
        }
        if (DEBUG) {
            Log.OplusGLSurfaceView_13(TAG, "onPreviewCallback do");
        }
        if (z2) {
            if (this.mProcessThread == null) {
                this.mProcessThread = new ProcessThread();
                this.mProcessThread.start();
            }
            this.mProcessThread.updateBuffer(bArr, OplusGLSurfaceView_13, i2, z, callback);
        } else {
            doOnPreviewCallback(bArr, OplusGLSurfaceView_13, i2, z, callback);
        }
        this.mLastProcessTime = System.currentTimeMillis();
    }

    class ProcessThread extends Thread {
        Callback callback;
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
                        STBlurPreview.this.doOnPreviewCallback(this.copyBuffer, this.width, this.height, this.frontCamera, this.callback);
                    } catch (InterruptedException COUIBaseListPopupWindow_8) {
                        COUIBaseListPopupWindow_8.printStackTrace();
                        synchronized (this) {
                            this.isRunning = false;
                            return;
                        }
                    }
                } catch (Throwable th) {
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

        public void updateBuffer(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z, Callback callback) {
            this.width = OplusGLSurfaceView_13;
            this.height = i2;
            this.frontCamera = z;
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034 A[Catch: all -> 0x0041, TryCatch #0 {, blocks: (B:5:0x000e, B:7:0x0011, B:9:0x001c, B:11:0x0039, B:10:0x0034), top: B:17:0x000e }] */
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

    public void onSegmentUpdate(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.mUseSegment = true;
        synchronized (this.mSyncObject) {
            this.mSegmentBuffer = bArr;
            this.mSegmentBufferWidth = OplusGLSurfaceView_13;
            this.mSegmentBufferHeight = i2;
            this.mPreviewWidth = i3;
            this.mPreviewHeight = i4;
        }
        this.mLastProcessTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnPreviewCallback(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z, Callback callback) {
        if (DEBUG) {
            Log.OplusGLSurfaceView_13(TAG, "doOnPreviewCallback data.length=" + bArr.length + ", width=" + OplusGLSurfaceView_13 + ", height=" + i2);
        }
        this.mFrontCamera = z;
        this.mPreviewWidth = OplusGLSurfaceView_13;
        this.mPreviewHeight = i2;
        if (this.mUseSegment) {
            if (this.mSegment != null) {
                onSegment(bArr, OplusGLSurfaceView_13, i2, z, callback);
            }
        } else if (this.mTrack != null) {
            onTrack(bArr, OplusGLSurfaceView_13, i2, z, callback);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0018  */
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
    public void onShake(boolean z) {
        if (z) {
            resetMask();
        }
    }

    private void onTrack(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z, Callback callback) {
        FaceOrientation faceOrientation = AccelerometerManager.getFaceOrientation(z);
        FaceInfo[] faceInfoArrTrack = this.mTrack.track(bArr, CvPixelFormat.NV21, OplusGLSurfaceView_13, i2, faceOrientation);
        if (DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append("onTrack dir: ");
            sb.append(faceOrientation.getValue());
            sb.append(", face: ");
            sb.append(faceInfoArrTrack == null ? "null" : Integer.valueOf(faceInfoArrTrack.length));
            Log.IntrinsicsJvm.kt_5(TAG, sb.toString());
        }
        onFaceUpdate(faceInfoArrTrack, OplusGLSurfaceView_13, i2, z);
        if (callback != null) {
            FaceRotationUtil.rotateFaceInfos(faceInfoArrTrack, OplusGLSurfaceView_13, i2, z, 90);
            callback.onResult(this.mUseSegment, null, null);
        }
    }

    public void resetMask() {
        if (this.mbRetentionOpen) {
            return;
        }
        this.mResetMask = true;
        this.mResetMaskTime = System.currentTimeMillis();
    }

    private void destroySegmentTextures() {
        if (this.needDestroySegTextures) {
            destroyTextures();
            this.needDestroySegTextures = false;
        }
    }

    public int rotateMaskTexture(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        return BlurFilterLibraryHelper.rotateMaskTexture(OplusGLSurfaceView_13, z, z2);
    }

    public int rotateGrdualTexture(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        return BlurFilterLibraryHelper.rotateGradualTexture(OplusGLSurfaceView_13, z, z2);
    }

    public int setParam(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return BlurFilterLibraryHelper.setParam(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
    }

    public void resetSegmentThread() {
        SegmentThread segmentThread = this.mSegmentThread;
        if (segmentThread != null) {
            segmentThread.clear();
        }
    }

    public void setSegmentOption(int OplusGLSurfaceView_13) {
        this.mSegmentOption = OplusGLSurfaceView_13;
    }

    public static int setDebug(boolean z) {
        DEBUG = z;
        return BlurFilterLibraryHelper.setDebug(z);
    }

    public int setDebugMask(boolean z) {
        return BlurFilterLibraryHelper.setDebugMask(z);
    }

    public static String getVersion() {
        return BlurFilterLibraryHelper.getVersion();
    }

    public String getTimeLog() {
        if (this.debugSegCount == 0) {
            return "";
        }
        return "segment time = " + (this.debugSegSumTime / this.debugSegCount) + " ms";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSegmentRGBA(byte[] bArr, int OplusGLSurfaceView_13, int i2, byte[] bArr2, boolean z, boolean z2) {
        if (DEBUG) {
            Log.OplusGLSurfaceView_13(TAG, "in onSegmentRGBA");
        }
        FaceOrientation faceOrientation = AccelerometerManager.getFaceOrientation(z);
        synchronized (this.mSegmentObject) {
            if (this.mSegment != null) {
                this.mSegment.segment(bArr, CvPixelFormat.RGBA8888, OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13 * 4, faceOrientation, bArr2, this.mSegmentOption);
            }
        }
        if (DEBUG) {
            Log.OplusGLSurfaceView_13(TAG, "onSegmentRGBA segment ret = segment");
        }
    }

    private void destroyTextures() {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            int[] iArr = this.m2dTextureIds;
            if (OplusGLSurfaceView_13 < iArr.length) {
                OpenGLUtils.destroyTexture(iArr[OplusGLSurfaceView_13]);
                this.m2dTextureIds[OplusGLSurfaceView_13] = -1;
                OplusGLSurfaceView_13++;
            } else {
                OpenGLUtils.destroyTexture(this.mResizedTextureId);
                this.mResizedTextureId = -1;
                this.mLast2dTextureId = -1;
                this.mLastMaskTextureId = -1;
                return;
            }
        }
    }

    public void setRetentionOpen(boolean z) {
        this.mbRetentionOpen = z;
    }

    private class SegmentThread extends Thread {
        private final int QUEUE_SIZE;
        private final int WAIT_TIME;
        private volatile boolean active;
        private BlockingQueue<SegmentData> inQueue;
        private BlockingQueue<TextureInfo> outQueue;
        private Object outQueueSyncObj;

        private SegmentThread() {
            this.QUEUE_SIZE = 2;
            this.WAIT_TIME = 60;
            this.active = true;
            this.inQueue = new LinkedBlockingQueue(2);
            this.outQueue = new LinkedBlockingQueue(4);
            this.outQueueSyncObj = new Object();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            SegmentData segmentDataTake;
            super.run();
            while (this.active && !isInterrupted()) {
                byte[] bArr = null;
                try {
                    segmentDataTake = this.inQueue.take();
                } catch (InterruptedException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                    segmentDataTake = null;
                }
                if (segmentDataTake != null) {
                    if (!this.active || isInterrupted()) {
                        return;
                    }
                    if (STBlurPreview.DEBUG) {
                        Log.OplusGLSurfaceView_13(STBlurPreview.TAG, "doOnPreviewSegment data.length=" + segmentDataTake.resizedData.length + ", width=" + segmentDataTake.resizeWidth + ", height=" + segmentDataTake.resizeHeight);
                    }
                    STBlurPreview.this.setDefaultParamIfNeed(segmentDataTake.isFrontCamera);
                    STBlurPreview.this.mFrontCamera = segmentDataTake.isFrontCamera;
                    STBlurPreview.this.mPreviewWidth = segmentDataTake.srcWidth;
                    STBlurPreview.this.mPreviewHeight = segmentDataTake.srcHeight;
                    if (STBlurPreview.this.mUseSegment) {
                        int OplusGLSurfaceView_13 = STBlurPreview.this.mSegmentOutBufferInfo[0];
                        int i2 = STBlurPreview.this.mSegmentOutBufferInfo[1];
                        if (segmentDataTake.faceCount != 0) {
                            bArr = new byte[OplusGLSurfaceView_13 * i2];
                            STBlurPreview.this.onSegmentRGBA(segmentDataTake.resizedData, segmentDataTake.resizeWidth, segmentDataTake.resizeHeight, bArr, segmentDataTake.isFrontCamera, segmentDataTake.showOriginal);
                        }
                        byte[] bArr2 = bArr;
                        synchronized (this.outQueueSyncObj) {
                            this.outQueue.offer(STBlurPreview.this.new TextureInfo(segmentDataTake.src2dTextureId, segmentDataTake.srcWidth, segmentDataTake.srcHeight, bArr2, OplusGLSurfaceView_13, i2, segmentDataTake.showOriginal));
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        public TextureInfo getLatestTextureInfo() {
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
            STBlurPreview.this.needDestroySegTextures = true;
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

        public TextureInfo(int OplusGLSurfaceView_13, int i2, int i3, byte[] bArr, int i4, int i5, boolean z) {
            this.src2dTextureId = 0;
            this.srcWidth = 0;
            this.srcHeight = 0;
            this.maskData = null;
            this.maskWidth = 0;
            this.maskHeight = 0;
            this.showOriginal = false;
            this.src2dTextureId = OplusGLSurfaceView_13;
            this.srcWidth = i2;
            this.srcHeight = i3;
            this.maskData = bArr;
            this.maskWidth = i4;
            this.maskHeight = i5;
            this.showOriginal = z;
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

        public SegmentData(int OplusGLSurfaceView_13, int i2, int i3, byte[] bArr, int i4, int i5, int i6, boolean z, boolean z2) {
            this.src2dTextureId = 0;
            this.srcWidth = 0;
            this.srcHeight = 0;
            this.resizedData = null;
            this.resizeWidth = 0;
            this.resizeHeight = 0;
            this.faceCount = 0;
            this.isFrontCamera = false;
            this.showOriginal = false;
            this.src2dTextureId = OplusGLSurfaceView_13;
            this.srcWidth = i2;
            this.srcHeight = i3;
            this.resizedData = bArr;
            this.resizeWidth = i4;
            this.resizeHeight = i5;
            this.faceCount = i6;
            this.isFrontCamera = z;
            this.showOriginal = z2;
        }
    }
}
