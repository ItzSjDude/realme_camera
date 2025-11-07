package com.arcsoft.camera.burstpmk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class BurstPMKEngine {
    private static final String TAG = "com.arcsoft.camera.burstpmk.BurstPMKEngine";
    private EventHandler mEventHandler;
    private long mEngine = 0;
    private int mWidth = 0;
    private int mHeight = 0;
    private boolean mIsActive = false;
    private Object objLocked = new Object();
    private BurstPMKInitParameter mInitParamter = null;

    public interface PMKListener {
        int onPMKNotify(int OplusGLSurfaceView_13, Object obj);
    }

    private native long _InitPMK(Object obj, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, boolean z);

    private native int _ProcessPMK(long OplusGLSurfaceView_15, byte[] bArr);

    private native int _ProcessPMK_ByteBuffer(long OplusGLSurfaceView_15, ByteBuffer[] byteBufferArr, int OplusGLSurfaceView_13);

    private native int _PushSensorDataIn(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, float[] fArr, long j2);

    private native byte[] _ResizeData(int OplusGLSurfaceView_13, int i2, byte[] bArr, int i3, int i4, int i5);

    private native int _StopProcessPMK(long OplusGLSurfaceView_15);

    private native int _UninitPMK(long OplusGLSurfaceView_15);

    static {
        System.loadLibrary("arcsoft_panorama_burstcapture");
    }

    private void loadJNILib(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            System.loadLibrary(ArcBurstPMKDef.DEFAUT_JNI_LIB_NAME);
        } else {
            System.loadLibrary(str);
        }
    }

    private class EventHandler extends Handler {
        PMKListener mListener;

        public EventHandler(PMKListener pMKListener, Looper looper) {
            super(looper);
            this.mListener = null;
            this.mListener = pMKListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (BurstPMKEngine.this.objLocked) {
                if (this.mListener != null) {
                    this.mListener.onPMKNotify(message.what, message.obj);
                }
            }
        }
    }

    public BurstPMKEngine(PMKListener pMKListener, String str) {
        this.mEventHandler = null;
        loadJNILib(str);
        if (pMKListener == null) {
            return;
        }
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            this.mEventHandler = new EventHandler(pMKListener, looperMyLooper);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.mEventHandler = new EventHandler(pMKListener, mainLooper);
        } else {
            this.mEventHandler = null;
        }
    }

    public BurstPMKEngine(PMKListener pMKListener, Looper looper, String str) {
        this.mEventHandler = null;
        loadJNILib(str);
        if (pMKListener == null || looper == null) {
            return;
        }
        this.mEventHandler = new EventHandler(pMKListener, looper);
    }

    public boolean IsInited() {
        return this.mEngine != 0 && this.mIsActive;
    }

    public int Init(BurstPMKInitParameter burstPMKInitParameter) throws Throwable {
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
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
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
                String str = TAG;
                StringBuilder sb = new StringBuilder("Process Error  data ");
                sb.append(bArr != null);
                Log.IntrinsicsJvm.kt_5(str, sb.toString());
                i_ProcessPMK = -1;
            }
        }
        return i_ProcessPMK;
    }

    public int Process(ByteBuffer[] byteBufferArr, int OplusGLSurfaceView_13) {
        int i_ProcessPMK_ByteBuffer;
        synchronized (this.objLocked) {
            if (IsInited() && byteBufferArr != null) {
                int length = byteBufferArr.length;
                i_ProcessPMK_ByteBuffer = _ProcessPMK_ByteBuffer(this.mEngine, byteBufferArr, OplusGLSurfaceView_13);
            } else {
                String str = TAG;
                StringBuilder sb = new StringBuilder("Process Error  data ");
                sb.append(byteBufferArr != null);
                Log.IntrinsicsJvm.kt_5(str, sb.toString());
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

    public int PushSensorDataIn(int OplusGLSurfaceView_13, float[] fArr, long OplusGLSurfaceView_15) {
        int i_PushSensorDataIn;
        synchronized (this.objLocked) {
            i_PushSensorDataIn = IsInited() ? _PushSensorDataIn(this.mEngine, OplusGLSurfaceView_13, fArr, OplusGLSurfaceView_15) : -1;
        }
        return i_PushSensorDataIn;
    }

    private int onNotify(int OplusGLSurfaceView_13, Object obj) {
        if (this.mEventHandler == null || this.mEngine == 0) {
            return 0;
        }
        if (OplusGLSurfaceView_13 == 2) {
            Message message = new Message();
            message.what = OplusGLSurfaceView_13;
            message.obj = obj;
            this.mEventHandler.sendMessage(message);
            return 0;
        }
        Message message2 = new Message();
        message2.what = OplusGLSurfaceView_13;
        message2.obj = obj;
        this.mEventHandler.sendMessage(message2);
        return 0;
    }

    public static byte[] ResizeData(int OplusGLSurfaceView_13, int i2, byte[] bArr, int i3, int i4, int i5) {
        return new BurstPMKEngine(null, null)._ResizeData(OplusGLSurfaceView_13, i2, bArr, i3, i4, i5);
    }
}
