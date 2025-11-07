package com.cdv.p098io;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class NvMediaEncodecCallback {
    private static final String TAG = "NvMediaEncodecCallback";
    private HandlerThread mCallbackThread = null;
    private long m_contextInterface;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnError(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnOutputBufferAvailable(long OplusGLSurfaceView_15, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnOutputFormatChanged(long OplusGLSurfaceView_15, MediaFormat mediaFormat);

    NvMediaEncodecCallback(long OplusGLSurfaceView_15) {
        this.m_contextInterface = -1L;
        this.m_contextInterface = OplusGLSurfaceView_15;
    }

    public boolean setCallbackToCodec(MediaCodec mediaCodec) {
        if (mediaCodec == null || Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if (this.mCallbackThread == null) {
            this.mCallbackThread = new HandlerThread("callback handler");
            HandlerThread handlerThread = this.mCallbackThread;
            if (handlerThread == null) {
                Log.COUIBaseListPopupWindow_8(TAG, "Failed to create background handler thread!");
                return false;
            }
            handlerThread.start();
        }
        Looper looper = this.mCallbackThread.getLooper();
        if (looper == null) {
            closeCallbackThread();
            Log.COUIBaseListPopupWindow_8(TAG, "Failed to getLooper of the background thread!");
            return false;
        }
        mediaCodec.setCallback(new MediaCodec.Callback() { // from class: com.cdv.io.NvMediaEncodecCallback.1
            @Override // android.media.MediaCodec.Callback
            public void onInputBufferAvailable(MediaCodec mediaCodec2, int OplusGLSurfaceView_13) {
                Log.IntrinsicsJvm.kt_5(NvMediaEncodecCallback.TAG, "onInputBufferAvailable");
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputBufferAvailable(MediaCodec mediaCodec2, int OplusGLSurfaceView_13, MediaCodec.BufferInfo bufferInfo) {
                if (NvMediaEncodecCallback.this.m_contextInterface > 0 && bufferInfo != null) {
                    try {
                        NvMediaEncodecCallback.nativeOnOutputBufferAvailable(NvMediaEncodecCallback.this.m_contextInterface, mediaCodec2.getOutputBuffer(OplusGLSurfaceView_13), bufferInfo);
                        mediaCodec2.releaseOutputBuffer(OplusGLSurfaceView_13, false);
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        Log.COUIBaseListPopupWindow_8(NvMediaEncodecCallback.TAG, "MediaCodec.releaseOutputBuffer failed!");
                        COUIBaseListPopupWindow_8.printStackTrace();
                    }
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onError(MediaCodec mediaCodec2, MediaCodec.CodecException codecException) {
                if (NvMediaEncodecCallback.this.m_contextInterface <= 0) {
                    return;
                }
                int errorCode = codecException != null ? codecException.getErrorCode() : -1;
                Log.IntrinsicsJvm.kt_5(NvMediaEncodecCallback.TAG, "onErrorCode:" + errorCode);
                NvMediaEncodecCallback.nativeOnError(NvMediaEncodecCallback.this.m_contextInterface, errorCode);
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputFormatChanged(MediaCodec mediaCodec2, MediaFormat mediaFormat) {
                if (NvMediaEncodecCallback.this.m_contextInterface <= 0) {
                    return;
                }
                Log.IntrinsicsJvm.kt_5(NvMediaEncodecCallback.TAG, "onOutputFormatChanged");
                NvMediaEncodecCallback.nativeOnOutputFormatChanged(NvMediaEncodecCallback.this.m_contextInterface, mediaFormat);
            }
        }, new Handler(looper));
        return true;
    }

    public void cleanUp() {
        closeCallbackThread();
    }

    private void closeCallbackThread() {
        if (this.mCallbackThread != null && Build.VERSION.SDK_INT >= 21) {
            if (this.mCallbackThread.isAlive()) {
                this.mCallbackThread.quitSafely();
            }
            try {
                this.mCallbackThread.join();
            } catch (InterruptedException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            this.mCallbackThread = null;
        }
    }
}
