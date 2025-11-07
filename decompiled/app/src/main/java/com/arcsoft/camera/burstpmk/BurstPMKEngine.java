package com.arcsoft.camera.burstpmk;

/* loaded from: classes.dex */
public class BurstPMKEngine {
    private static final java.lang.String TAG = "com.arcsoft.camera.burstpmk.BurstPMKEngine";
    private com.arcsoft.camera.burstpmk.BurstPMKEngine.EventHandler mEventHandler;
    private long mEngine = 0;
    private int mWidth = 0;
    private int mHeight = 0;
    private boolean mIsActive = false;
    private java.lang.Object objLocked = new java.lang.Object();
    private com.arcsoft.camera.burstpmk.BurstPMKInitParameter mInitParamter = null;

    public interface PMKListener {
        int onPMKNotify(int i_renamed, java.lang.Object obj);
    }

    private native long _InitPMK(java.lang.Object obj, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, boolean z_renamed);

    private native int _ProcessPMK(long j_renamed, byte[] bArr);

    private native int _ProcessPMK_ByteBuffer(long j_renamed, java.nio.ByteBuffer[] byteBufferArr, int i_renamed);

    private native int _PushSensorDataIn(long j_renamed, int i_renamed, float[] fArr, long j2);

    private native byte[] _ResizeData(int i_renamed, int i2, byte[] bArr, int i3, int i4, int i5);

    private native int _StopProcessPMK(long j_renamed);

    private native int _UninitPMK(long j_renamed);

    static {
        java.lang.System.loadLibrary("arcsoft_panorama_burstcapture");
    }

    private void loadJNILib(java.lang.String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            java.lang.System.loadLibrary(com.arcsoft.camera.burstpmk.ArcBurstPMKDef.DEFAUT_JNI_LIB_NAME);
        } else {
            java.lang.System.loadLibrary(str);
        }
    }

    private class EventHandler extends android.os.Handler {
        com.arcsoft.camera.burstpmk.BurstPMKEngine.PMKListener mListener;

        public EventHandler(com.arcsoft.camera.burstpmk.BurstPMKEngine.PMKListener pMKListener, android.os.Looper looper) {
            super(looper);
            this.mListener = null;
            this.mListener = pMKListener;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            synchronized (com.arcsoft.camera.burstpmk.BurstPMKEngine.this.objLocked) {
                if (this.mListener != null) {
                    this.mListener.onPMKNotify(message.what, message.obj);
                }
            }
        }
    }

    public BurstPMKEngine(com.arcsoft.camera.burstpmk.BurstPMKEngine.PMKListener pMKListener, java.lang.String str) {
        this.mEventHandler = null;
        loadJNILib(str);
        if (pMKListener == null) {
            return;
        }
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        if (looperMyLooper != null) {
            this.mEventHandler = new com.arcsoft.camera.burstpmk.BurstPMKEngine.EventHandler(pMKListener, looperMyLooper);
            return;
        }
        android.os.Looper mainLooper = android.os.Looper.getMainLooper();
        if (mainLooper != null) {
            this.mEventHandler = new com.arcsoft.camera.burstpmk.BurstPMKEngine.EventHandler(pMKListener, mainLooper);
        } else {
            this.mEventHandler = null;
        }
    }

    public BurstPMKEngine(com.arcsoft.camera.burstpmk.BurstPMKEngine.PMKListener pMKListener, android.os.Looper looper, java.lang.String str) {
        this.mEventHandler = null;
        loadJNILib(str);
        if (pMKListener == null || looper == null) {
            return;
        }
        this.mEventHandler = new com.arcsoft.camera.burstpmk.BurstPMKEngine.EventHandler(pMKListener, looper);
    }

    public boolean IsInited() {
        return this.mEngine != 0 && this.mIsActive;
    }

    public int Init(com.arcsoft.camera.burstpmk.BurstPMKInitParameter burstPMKInitParameter) throws java.lang.Throwable {
        Uninit();
        if (burstPMKInitParameter == null) {
            return 2;
        }
        synchronized (this.objLocked) {
            try {
                try {
                    this.mInitParamter = burstPMKInitParameter;
                    this.mEngine = _InitPMK(this, this.mInitParamter.deviceDirection, this.mInitParamter.deviceOrientation, this.mInitParamter.sensorOrientation, this.mInitParamter.getImageFormat(), this.mInitParamter.getFullImageWidth(), this.mInitParamter.getFullImageHeight(), this.mInitParamter.getSmallImageWidth(), this.mInitParamter.getSmallImageHeight(), this.mInitParamter.getBufferSize(), this.mInitParamter.maxfullResultLength, this.mInitParamter.thumbnailResultWidthH, this.mInitParamter.thumbnailResultHeightH, this.mInitParamter.thumbnailResultWidthV, this.mInitParamter.thumbnailResultHeightV, this.mInitParamter.resultImageRotated);
                    this.mIsActive = this.mEngine != 0;
                    return this.mIsActive ? 0 : -1;
                } catch (java.lang.Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    public void Uninit() {
        synchronized (this.objLocked) {
            if (this.mEngine != 0) {
                this.mIsActive = false;
                this.mEventHandler = null;
                _UninitPMK(this.mEngine);
                this.mEngine = 0L;
            }
        }
    }

    public int Process(byte[] bArr) {
        int i_ProcessPMK;
        synchronized (this.objLocked) {
            if (IsInited() && bArr != null) {
                int length = bArr.length;
                i_ProcessPMK = _ProcessPMK(this.mEngine, bArr);
            } else {
                java.lang.String str = TAG;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Process Error  data ");
                sb.append(bArr != null);
                android.util.Log.d_renamed(str, sb.toString());
                i_ProcessPMK = -1;
            }
        }
        return i_ProcessPMK;
    }

    public int Process(java.nio.ByteBuffer[] byteBufferArr, int i_renamed) {
        int i_ProcessPMK_ByteBuffer;
        synchronized (this.objLocked) {
            if (IsInited() && byteBufferArr != null) {
                int length = byteBufferArr.length;
                i_ProcessPMK_ByteBuffer = _ProcessPMK_ByteBuffer(this.mEngine, byteBufferArr, i_renamed);
            } else {
                java.lang.String str = TAG;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Process Error  data ");
                sb.append(byteBufferArr != null);
                android.util.Log.d_renamed(str, sb.toString());
                i_ProcessPMK_ByteBuffer = -1;
            }
        }
        return i_ProcessPMK_ByteBuffer;
    }

    public int StopProcessing() {
        int i_StopProcessPMK;
        synchronized (this.objLocked) {
            if (IsInited()) {
                this.mIsActive = false;
                i_StopProcessPMK = _StopProcessPMK(this.mEngine);
            } else {
                i_StopProcessPMK = -1;
            }
        }
        return i_StopProcessPMK;
    }

    public int PushSensorDataIn(int i_renamed, float[] fArr, long j_renamed) {
        int i_PushSensorDataIn;
        synchronized (this.objLocked) {
            i_PushSensorDataIn = IsInited() ? _PushSensorDataIn(this.mEngine, i_renamed, fArr, j_renamed) : -1;
        }
        return i_PushSensorDataIn;
    }

    private int onNotify(int i_renamed, java.lang.Object obj) {
        if (this.mEventHandler == null || this.mEngine == 0) {
            return 0;
        }
        if (i_renamed == 2) {
            android.os.Message message = new android.os.Message();
            message.what = i_renamed;
            message.obj = obj;
            this.mEventHandler.sendMessage(message);
            return 0;
        }
        android.os.Message message2 = new android.os.Message();
        message2.what = i_renamed;
        message2.obj = obj;
        this.mEventHandler.sendMessage(message2);
        return 0;
    }

    public static byte[] ResizeData(int i_renamed, int i2, byte[] bArr, int i3, int i4, int i5) {
        return new com.arcsoft.camera.burstpmk.BurstPMKEngine(null, null)._ResizeData(i_renamed, i2, bArr, i3, i4, i5);
    }
}
