package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsMediaFileConvertor {
    public static final java.lang.String CONVERTOR_CUSTOM_AUDIO_CHANNEL = "custom-audio-channel";
    public static final java.lang.String CONVERTOR_CUSTOM_AUDIO_PCM_FILE = "custom-audio-pcm-file";
    public static final java.lang.String CONVERTOR_CUSTOM_AUDIO_SAMPLE_RATE = "custom-audio-sample-rate";
    public static final java.lang.String CONVERTOR_CUSTOM_VIDEO_HEIGHT = "custom-video-height";
    public static final java.lang.String CONVERTOR_DETECTED_AUDIO_MUTE_FACTOR = "detected_audio_mute";
    public static final java.lang.String CONVERTOR_DISABLE_HARDWARE_VIDEO_DECODER = "disable_hardware_video_decoder";
    public static final int CONVERTOR_ERROR_CODE_CANCEL = 1;
    public static final int CONVERTOR_ERROR_CODE_NO_ERROR = 0;
    public static final int CONVERTOR_ERROR_UNKNOWN = 65535;
    public static final int CONVERTOR_ERROR_VIDEO_DECODER_ERROR = 4;
    public static final int CONVERTOR_ERROR_VIDEO_DECODING_ERROR = 5;
    public static final int CONVERTOR_ERROR_VIDEO_ENCODER_SETUP_ERROR = 2;
    public static final int CONVERTOR_ERROR_VIDEO_ENCODING_ERROR = 3;
    public static final java.lang.String CONVERTOR_NO_AUDIO = "convertor-no-audio";
    public static final java.lang.String CONVERTOR_NO_VIDEO = "convertor-no-video";
    private final java.lang.String TAG = "NvsMediaFileConvertor";
    private java.util.concurrent.atomic.AtomicReference<com.meicam.sdk.NvsMediaFileConvertor.MeidaFileConvertorCallback> m_callback = new java.util.concurrent.atomic.AtomicReference<>(null);
    private java.util.concurrent.atomic.AtomicReference<android.os.Handler> mCallbackHanlder = new java.util.concurrent.atomic.AtomicReference<>(null);
    private long m_contextInterface = nativeInit();

    public interface MeidaFileConvertorCallback {
        void notifyAudioMuteRage(long j_renamed, long j2, long j3);

        void onFinish(long j_renamed, java.lang.String str, java.lang.String str2, int i_renamed);

        void onProgress(long j_renamed, float f_renamed);
    }

    private native void nativeCancelTask(long j_renamed, long j2);

    private native void nativeClose(long j_renamed);

    private native long nativeConvertMeidaFile(long j_renamed, java.lang.String str, java.lang.String str2, boolean z_renamed, long j2, long j3, java.util.Hashtable<java.lang.String, java.lang.Object> hashtable);

    private native long nativeInit();

    protected void finalize() throws java.lang.Throwable {
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

    public void setMeidaFileConvertorCallback(com.meicam.sdk.NvsMediaFileConvertor.MeidaFileConvertorCallback meidaFileConvertorCallback, android.os.Handler handler) {
        this.m_callback.set(meidaFileConvertorCallback);
        this.mCallbackHanlder.set(handler);
        if (meidaFileConvertorCallback == null || handler != null) {
            return;
        }
        this.mCallbackHanlder.set(new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    public void setMeidaFileConvertorCallback(com.meicam.sdk.NvsMediaFileConvertor.MeidaFileConvertorCallback meidaFileConvertorCallback, boolean z_renamed) {
        this.m_callback.set(meidaFileConvertorCallback);
        if (meidaFileConvertorCallback == null || !z_renamed) {
            return;
        }
        this.mCallbackHanlder.set(new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    public long convertMeidaFile(java.lang.String str, java.lang.String str2, boolean z_renamed, long j_renamed, long j2, java.util.Hashtable<java.lang.String, java.lang.Object> hashtable) {
        long jNativeConvertMeidaFile;
        synchronized (this) {
            jNativeConvertMeidaFile = nativeConvertMeidaFile(this.m_contextInterface, str, str2, z_renamed, j_renamed, j2, hashtable);
        }
        return jNativeConvertMeidaFile;
    }

    public void cancelTask(long j_renamed) {
        if (isReleased()) {
            return;
        }
        synchronized (this) {
            nativeCancelTask(this.m_contextInterface, j_renamed);
        }
    }

    protected void notifyProgress(final long j_renamed, final float f_renamed) {
        final com.meicam.sdk.NvsMediaFileConvertor.MeidaFileConvertorCallback meidaFileConvertorCallback = this.m_callback.get();
        android.os.Handler handler = this.mCallbackHanlder.get();
        if (meidaFileConvertorCallback != null) {
            if (handler != null) {
                handler.post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsMediaFileConvertor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        meidaFileConvertorCallback.onProgress(j_renamed, f_renamed);
                    }
                });
            } else {
                meidaFileConvertorCallback.onProgress(j_renamed, f_renamed);
            }
        }
    }

    protected void notifyFinish(final long j_renamed, final java.lang.String str, final java.lang.String str2, final int i_renamed) {
        final com.meicam.sdk.NvsMediaFileConvertor.MeidaFileConvertorCallback meidaFileConvertorCallback = this.m_callback.get();
        android.os.Handler handler = this.mCallbackHanlder.get();
        if (meidaFileConvertorCallback != null) {
            if (handler != null) {
                handler.post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsMediaFileConvertor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        meidaFileConvertorCallback.onFinish(j_renamed, str, str2, i_renamed);
                    }
                });
            } else {
                meidaFileConvertorCallback.onFinish(j_renamed, str, str2, i_renamed);
            }
        }
    }

    protected void notifyAudioMuteRage(final long j_renamed, final long j2, final long j3) {
        final com.meicam.sdk.NvsMediaFileConvertor.MeidaFileConvertorCallback meidaFileConvertorCallback = this.m_callback.get();
        android.os.Handler handler = this.mCallbackHanlder.get();
        if (meidaFileConvertorCallback != null) {
            if (handler != null) {
                handler.post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsMediaFileConvertor.3
                    @Override // java.lang.Runnable
                    public void run() {
                        meidaFileConvertorCallback.notifyAudioMuteRage(j_renamed, j2, j3);
                    }
                });
            } else {
                meidaFileConvertorCallback.notifyAudioMuteRage(j_renamed, j2, j3);
            }
        }
    }
}
