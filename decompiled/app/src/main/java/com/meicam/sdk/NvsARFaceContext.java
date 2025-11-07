package com.meicam.sdk;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public class NvsARFaceContext {
    public static final int OBJECT_TRACKING_TYPE_ANIMAL = 1;
    public static final int OBJECT_TRACKING_TYPE_FACE = 0;
    private long m_contextInterface;
    NvsARFaceContextInternalCallback m_callbackinternal = null;
    NvsARFaceContextCallback m_callback = null;
    NvsARFaceContextErrorCallback m_errorCallback = null;
    Handler mainHandler = new Handler(Looper.getMainLooper());

    public interface NvsARFaceContextCallback {
        void notifyFaceItemLoadingBegin(String str);

        void notifyFaceItemLoadingFinish();
    }

    public interface NvsARFaceContextErrorCallback {
        void notifyFaceItemLoadingFailed(String str, int OplusGLSurfaceView_13);
    }

    private interface NvsARFaceContextInternalCallback {
        void notifyFaceItemLoadingBegin(String str);

        void notifyFaceItemLoadingFailed(String str, int OplusGLSurfaceView_13);

        void notifyFaceItemLoadingFinish();
    }

    private native void nativeCleanup(long OplusGLSurfaceView_15);

    private native boolean nativeIsObjectTracking(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13);

    private native void nativeSetARFaceCallback(long OplusGLSurfaceView_15, NvsARFaceContextInternalCallback nvsARFaceContextInternalCallback);

    private native void nativeSetDualBufferInputUsed(long OplusGLSurfaceView_15, boolean z);

    public boolean isFaceTracking() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsObjectTracking(this.m_contextInterface, 0);
    }

    public boolean isObjectTracking(int OplusGLSurfaceView_13) {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsObjectTracking(this.m_contextInterface, OplusGLSurfaceView_13);
    }

    public void setContextCallback(NvsARFaceContextCallback nvsARFaceContextCallback) {
        this.m_callback = nvsARFaceContextCallback;
        if (this.m_callback != null) {
            if (this.m_callbackinternal != null) {
                return;
            } else {
                this.m_callbackinternal = new NvsARFaceContextInternalCallback() { // from class: com.meicam.sdk.NvsARFaceContext.1
                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingBegin(final String str) {
                        NvsARFaceContext.this.mainHandler.post(new Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NvsARFaceContext.this.m_callback != null) {
                                    NvsARFaceContext.this.m_callback.notifyFaceItemLoadingBegin(str);
                                }
                            }
                        });
                    }

                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingFinish() {
                        NvsARFaceContext.this.mainHandler.post(new Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NvsARFaceContext.this.m_callback != null) {
                                    NvsARFaceContext.this.m_callback.notifyFaceItemLoadingFinish();
                                }
                            }
                        });
                    }

                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingFailed(final String str, final int OplusGLSurfaceView_13) {
                        NvsARFaceContext.this.mainHandler.post(new Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NvsARFaceContext.this.m_errorCallback != null) {
                                    NvsARFaceContext.this.m_errorCallback.notifyFaceItemLoadingFailed(str, OplusGLSurfaceView_13);
                                }
                            }
                        });
                    }
                };
            }
        } else {
            this.m_callbackinternal = null;
        }
        nativeSetARFaceCallback(this.m_contextInterface, this.m_callbackinternal);
    }

    public void setContextErrorCallback(NvsARFaceContextErrorCallback nvsARFaceContextErrorCallback) {
        this.m_errorCallback = nvsARFaceContextErrorCallback;
        if (this.m_errorCallback != null) {
            if (this.m_callbackinternal != null) {
                return;
            } else {
                this.m_callbackinternal = new NvsARFaceContextInternalCallback() { // from class: com.meicam.sdk.NvsARFaceContext.2
                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingBegin(final String str) {
                        NvsARFaceContext.this.mainHandler.post(new Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NvsARFaceContext.this.m_callback != null) {
                                    NvsARFaceContext.this.m_callback.notifyFaceItemLoadingBegin(str);
                                }
                            }
                        });
                    }

                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingFinish() {
                        NvsARFaceContext.this.mainHandler.post(new Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NvsARFaceContext.this.m_callback != null) {
                                    NvsARFaceContext.this.m_callback.notifyFaceItemLoadingFinish();
                                }
                            }
                        });
                    }

                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingFailed(final String str, final int OplusGLSurfaceView_13) {
                        NvsARFaceContext.this.mainHandler.post(new Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NvsARFaceContext.this.m_errorCallback != null) {
                                    NvsARFaceContext.this.m_errorCallback.notifyFaceItemLoadingFailed(str, OplusGLSurfaceView_13);
                                }
                            }
                        });
                    }
                };
            }
        }
        nativeSetARFaceCallback(this.m_contextInterface, this.m_callbackinternal);
    }

    public void setDualBufferInputUsed(boolean z) {
        nativeSetDualBufferInputUsed(this.m_contextInterface, z);
    }

    public void release() {
        this.m_callbackinternal = null;
        long OplusGLSurfaceView_15 = this.m_contextInterface;
        if (OplusGLSurfaceView_15 != 0) {
            nativeCleanup(OplusGLSurfaceView_15);
            this.m_contextInterface = 0L;
        }
    }

    protected void setContextInterface(long OplusGLSurfaceView_15) {
        this.m_contextInterface = OplusGLSurfaceView_15;
    }

    protected void finalize() throws Throwable {
        release();
        super.finalize();
    }
}
