package com.meicam.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class NvsMediaFileConvertor {
    public static final String CONVERTOR_CUSTOM_AUDIO_CHANNEL = "custom-audio-channel";
    public static final String CONVERTOR_CUSTOM_AUDIO_PCM_FILE = "custom-audio-pcm-file";
    public static final String CONVERTOR_CUSTOM_AUDIO_SAMPLE_RATE = "custom-audio-sample-rate";
    public static final String CONVERTOR_CUSTOM_VIDEO_HEIGHT = "custom-video-height";
    public static final String CONVERTOR_DETECTED_AUDIO_MUTE_FACTOR = "detected_audio_mute";
    public static final String CONVERTOR_DISABLE_HARDWARE_VIDEO_DECODER = "disable_hardware_video_decoder";
    public static final int CONVERTOR_ERROR_CODE_CANCEL = 1;
    public static final int CONVERTOR_ERROR_CODE_NO_ERROR = 0;
    public static final int CONVERTOR_ERROR_UNKNOWN = 65535;
    public static final int CONVERTOR_ERROR_VIDEO_DECODER_ERROR = 4;
    public static final int CONVERTOR_ERROR_VIDEO_DECODING_ERROR = 5;
    public static final int CONVERTOR_ERROR_VIDEO_ENCODER_SETUP_ERROR = 2;
    public static final int CONVERTOR_ERROR_VIDEO_ENCODING_ERROR = 3;
    public static final String CONVERTOR_NO_AUDIO = "convertor-no-audio";
    public static final String CONVERTOR_NO_VIDEO = "convertor-no-video";
    private final String TAG = "NvsMediaFileConvertor";
    private AtomicReference<MeidaFileConvertorCallback> m_callback = new AtomicReference<>(null);
    private AtomicReference<Handler> mCallbackHanlder = new AtomicReference<>(null);
    private long m_contextInterface = nativeInit();

    public interface MeidaFileConvertorCallback {
        void notifyAudioMuteRage(long OplusGLSurfaceView_15, long j2, long j3);

        void onFinish(long OplusGLSurfaceView_15, String str, String str2, int OplusGLSurfaceView_13);

        void onProgress(long OplusGLSurfaceView_15, float COUIBaseListPopupWindow_12);
    }

    private native void nativeCancelTask(long OplusGLSurfaceView_15, long j2);

    private native void nativeClose(long OplusGLSurfaceView_15);

    private native long nativeConvertMeidaFile(long OplusGLSurfaceView_15, String str, String str2, boolean z, long j2, long j3, Hashtable<String, Object> hashtable);

    private native long nativeInit();

    protected void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public void release() {
        if (isReleased()) {
            return;
        }
        synchronized (this) {
            nativeClose(this.m_contextInterface);
            this.m_callback.set(null);
            this.m_contextInterface = 0L;
        }
    }

    public boolean isReleased() {
        return this.m_contextInterface == 0;
    }

    public void setMeidaFileConvertorCallback(MeidaFileConvertorCallback meidaFileConvertorCallback, Handler handler) {
        this.m_callback.set(meidaFileConvertorCallback);
        this.mCallbackHanlder.set(handler);
        if (meidaFileConvertorCallback == null || handler != null) {
            return;
        }
        this.mCallbackHanlder.set(new Handler(Looper.getMainLooper()));
    }

    public void setMeidaFileConvertorCallback(MeidaFileConvertorCallback meidaFileConvertorCallback, boolean z) {
        this.m_callback.set(meidaFileConvertorCallback);
        if (meidaFileConvertorCallback == null || !z) {
            return;
        }
        this.mCallbackHanlder.set(new Handler(Looper.getMainLooper()));
    }

    public long convertMeidaFile(String str, String str2, boolean z, long OplusGLSurfaceView_15, long j2, Hashtable<String, Object> hashtable) {
        long jNativeConvertMeidaFile;
        synchronized (this) {
            jNativeConvertMeidaFile = nativeConvertMeidaFile(this.m_contextInterface, str, str2, z, OplusGLSurfaceView_15, j2, hashtable);
        }
        return jNativeConvertMeidaFile;
    }

    public void cancelTask(long OplusGLSurfaceView_15) {
        if (isReleased()) {
            return;
        }
        synchronized (this) {
            nativeCancelTask(this.m_contextInterface, OplusGLSurfaceView_15);
        }
    }

    protected void notifyProgress(final long OplusGLSurfaceView_15, final float COUIBaseListPopupWindow_12) {
        final MeidaFileConvertorCallback meidaFileConvertorCallback = this.m_callback.get();
        Handler handler = this.mCallbackHanlder.get();
        if (meidaFileConvertorCallback != null) {
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.meicam.sdk.NvsMediaFileConvertor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        meidaFileConvertorCallback.onProgress(OplusGLSurfaceView_15, COUIBaseListPopupWindow_12);
                    }
                });
            } else {
                meidaFileConvertorCallback.onProgress(OplusGLSurfaceView_15, COUIBaseListPopupWindow_12);
            }
        }
    }

    protected void notifyFinish(final long OplusGLSurfaceView_15, final String str, final String str2, final int OplusGLSurfaceView_13) {
        final MeidaFileConvertorCallback meidaFileConvertorCallback = this.m_callback.get();
        Handler handler = this.mCallbackHanlder.get();
        if (meidaFileConvertorCallback != null) {
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.meicam.sdk.NvsMediaFileConvertor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        meidaFileConvertorCallback.onFinish(OplusGLSurfaceView_15, str, str2, OplusGLSurfaceView_13);
                    }
                });
            } else {
                meidaFileConvertorCallback.onFinish(OplusGLSurfaceView_15, str, str2, OplusGLSurfaceView_13);
            }
        }
    }

    protected void notifyAudioMuteRage(final long OplusGLSurfaceView_15, final long j2, final long j3) {
        final MeidaFileConvertorCallback meidaFileConvertorCallback = this.m_callback.get();
        Handler handler = this.mCallbackHanlder.get();
        if (meidaFileConvertorCallback != null) {
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.meicam.sdk.NvsMediaFileConvertor.3
                    @Override // java.lang.Runnable
                    public void run() {
                        meidaFileConvertorCallback.notifyAudioMuteRage(OplusGLSurfaceView_15, j2, j3);
                    }
                });
            } else {
                meidaFileConvertorCallback.notifyAudioMuteRage(OplusGLSurfaceView_15, j2, j3);
            }
        }
    }
}
