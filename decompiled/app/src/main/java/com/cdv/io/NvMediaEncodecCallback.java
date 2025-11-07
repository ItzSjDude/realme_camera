package com.cdv.io;

/* loaded from: classes.dex */
public class NvMediaEncodecCallback {
    private static final java.lang.String TAG = "NvMediaEncodecCallback";
    private android.os.HandlerThread mCallbackThread = null;
    private long m_contextInterface;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnError(long j_renamed, int i_renamed);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnOutputBufferAvailable(long j_renamed, java.nio.ByteBuffer byteBuffer, android.media.MediaCodec.BufferInfo bufferInfo);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnOutputFormatChanged(long j_renamed, android.media.MediaFormat mediaFormat);

    NvMediaEncodecCallback(long j_renamed) {
        this.m_contextInterface = -1L;
        this.m_contextInterface = j_renamed;
    }

    public boolean setCallbackToCodec(android.media.MediaCodec mediaCodec) {
        if (mediaCodec == null || android.os.Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if (this.mCallbackThread == null) {
            this.mCallbackThread = new android.os.HandlerThread("callback handler");
            android.os.HandlerThread handlerThread = this.mCallbackThread;
            if (handlerThread == null) {
                android.util.Log.e_renamed(TAG, "Failed to create background handler thread!");
                return false;
            }
            handlerThread.start();
        }
        android.os.Looper looper = this.mCallbackThread.getLooper();
        if (looper == null) {
            closeCallbackThread();
            android.util.Log.e_renamed(TAG, "Failed to getLooper of_renamed the background thread!");
            return false;
        }
        mediaCodec.setCallback(new android.media.MediaCodec.Callback() { // from class: com.cdv.io.NvMediaEncodecCallback.1
            @Override // android.media.MediaCodec.Callback
            public void onInputBufferAvailable(android.media.MediaCodec mediaCodec2, int i_renamed) {
                android.util.Log.d_renamed(com.cdv.io.NvMediaEncodecCallback.TAG, "onInputBufferAvailable");
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputBufferAvailable(android.media.MediaCodec mediaCodec2, int i_renamed, android.media.MediaCodec.BufferInfo bufferInfo) {
                if (com.cdv.io.NvMediaEncodecCallback.this.m_contextInterface > 0 && bufferInfo != null) {
                    try {
                        com.cdv.io.NvMediaEncodecCallback.nativeOnOutputBufferAvailable(com.cdv.io.NvMediaEncodecCallback.this.m_contextInterface, mediaCodec2.getOutputBuffer(i_renamed), bufferInfo);
                        mediaCodec2.releaseOutputBuffer(i_renamed, false);
                    } catch (java.lang.Exception e_renamed) {
                        android.util.Log.e_renamed(com.cdv.io.NvMediaEncodecCallback.TAG, "MediaCodec.releaseOutputBuffer failed!");
                        e_renamed.printStackTrace();
                    }
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onError(android.media.MediaCodec mediaCodec2, android.media.MediaCodec.CodecException codecException) {
                if (com.cdv.io.NvMediaEncodecCallback.this.m_contextInterface <= 0) {
                    return;
                }
                int errorCode = codecException != null ? codecException.getErrorCode() : -1;
                android.util.Log.d_renamed(com.cdv.io.NvMediaEncodecCallback.TAG, "onErrorCode:" + errorCode);
                com.cdv.io.NvMediaEncodecCallback.nativeOnError(com.cdv.io.NvMediaEncodecCallback.this.m_contextInterface, errorCode);
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputFormatChanged(android.media.MediaCodec mediaCodec2, android.media.MediaFormat mediaFormat) {
                if (com.cdv.io.NvMediaEncodecCallback.this.m_contextInterface <= 0) {
                    return;
                }
                android.util.Log.d_renamed(com.cdv.io.NvMediaEncodecCallback.TAG, "onOutputFormatChanged");
                com.cdv.io.NvMediaEncodecCallback.nativeOnOutputFormatChanged(com.cdv.io.NvMediaEncodecCallback.this.m_contextInterface, mediaFormat);
            }
        }, new android.os.Handler(looper));
        return true;
    }

    public void cleanUp() {
        closeCallbackThread();
    }

    private void closeCallbackThread() {
        if (this.mCallbackThread != null && android.os.Build.VERSION.SDK_INT >= 21) {
            if (this.mCallbackThread.isAlive()) {
                this.mCallbackThread.quitSafely();
            }
            try {
                this.mCallbackThread.join();
            } catch (java.lang.InterruptedException e_renamed) {
                e_renamed.printStackTrace();
            }
            this.mCallbackThread = null;
        }
    }
}
