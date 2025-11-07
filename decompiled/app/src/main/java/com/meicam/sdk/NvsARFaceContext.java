package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsARFaceContext {
    public static final int OBJECT_TRACKING_TYPE_ANIMAL = 1;
    public static final int OBJECT_TRACKING_TYPE_FACE = 0;
    private long m_contextInterface;
    com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback m_callbackinternal = null;
    com.meicam.sdk.NvsARFaceContext.NvsARFaceContextCallback m_callback = null;
    com.meicam.sdk.NvsARFaceContext.NvsARFaceContextErrorCallback m_errorCallback = null;
    android.os.Handler mainHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    public interface NvsARFaceContextCallback {
        void notifyFaceItemLoadingBegin(java.lang.String str);

        void notifyFaceItemLoadingFinish();
    }

    public interface NvsARFaceContextErrorCallback {
        void notifyFaceItemLoadingFailed(java.lang.String str, int i_renamed);
    }

    private interface NvsARFaceContextInternalCallback {
        void notifyFaceItemLoadingBegin(java.lang.String str);

        void notifyFaceItemLoadingFailed(java.lang.String str, int i_renamed);

        void notifyFaceItemLoadingFinish();
    }

    private native void nativeCleanup(long j_renamed);

    private native boolean nativeIsObjectTracking(long j_renamed, int i_renamed);

    private native void nativeSetARFaceCallback(long j_renamed, com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback nvsARFaceContextInternalCallback);

    private native void nativeSetDualBufferInputUsed(long j_renamed, boolean z_renamed);

    public boolean isFaceTracking() {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsObjectTracking(this.m_contextInterface, 0);
    }

    public boolean isObjectTracking(int i_renamed) {
        com.meicam.sdk.NvsUtils.checkFunctionInMainThread();
        return nativeIsObjectTracking(this.m_contextInterface, i_renamed);
    }

    public void setContextCallback(com.meicam.sdk.NvsARFaceContext.NvsARFaceContextCallback nvsARFaceContextCallback) {
        this.m_callback = nvsARFaceContextCallback;
        if (this.m_callback != null) {
            if (this.m_callbackinternal != null) {
                return;
            } else {
                this.m_callbackinternal = new com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback() { // from class: com.meicam.sdk.NvsARFaceContext.1
                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingBegin(final java.lang.String str) {
                        com.meicam.sdk.NvsARFaceContext.this.mainHandler.post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (com.meicam.sdk.NvsARFaceContext.this.m_callback != null) {
                                    com.meicam.sdk.NvsARFaceContext.this.m_callback.notifyFaceItemLoadingBegin(str);
                                }
                            }
                        });
                    }

                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingFinish() {
                        com.meicam.sdk.NvsARFaceContext.this.mainHandler.post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (com.meicam.sdk.NvsARFaceContext.this.m_callback != null) {
                                    com.meicam.sdk.NvsARFaceContext.this.m_callback.notifyFaceItemLoadingFinish();
                                }
                            }
                        });
                    }

                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingFailed(final java.lang.String str, final int i_renamed) {
                        com.meicam.sdk.NvsARFaceContext.this.mainHandler.post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (com.meicam.sdk.NvsARFaceContext.this.m_errorCallback != null) {
                                    com.meicam.sdk.NvsARFaceContext.this.m_errorCallback.notifyFaceItemLoadingFailed(str, i_renamed);
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

    public void setContextErrorCallback(com.meicam.sdk.NvsARFaceContext.NvsARFaceContextErrorCallback nvsARFaceContextErrorCallback) {
        this.m_errorCallback = nvsARFaceContextErrorCallback;
        if (this.m_errorCallback != null) {
            if (this.m_callbackinternal != null) {
                return;
            } else {
                this.m_callbackinternal = new com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback() { // from class: com.meicam.sdk.NvsARFaceContext.2
                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingBegin(final java.lang.String str) {
                        com.meicam.sdk.NvsARFaceContext.this.mainHandler.post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (com.meicam.sdk.NvsARFaceContext.this.m_callback != null) {
                                    com.meicam.sdk.NvsARFaceContext.this.m_callback.notifyFaceItemLoadingBegin(str);
                                }
                            }
                        });
                    }

                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingFinish() {
                        com.meicam.sdk.NvsARFaceContext.this.mainHandler.post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (com.meicam.sdk.NvsARFaceContext.this.m_callback != null) {
                                    com.meicam.sdk.NvsARFaceContext.this.m_callback.notifyFaceItemLoadingFinish();
                                }
                            }
                        });
                    }

                    @Override // com.meicam.sdk.NvsARFaceContext.NvsARFaceContextInternalCallback
                    public void notifyFaceItemLoadingFailed(final java.lang.String str, final int i_renamed) {
                        com.meicam.sdk.NvsARFaceContext.this.mainHandler.post(new java.lang.Runnable() { // from class: com.meicam.sdk.NvsARFaceContext.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (com.meicam.sdk.NvsARFaceContext.this.m_errorCallback != null) {
                                    com.meicam.sdk.NvsARFaceContext.this.m_errorCallback.notifyFaceItemLoadingFailed(str, i_renamed);
                                }
                            }
                        });
                    }
                };
            }
        }
        nativeSetARFaceCallback(this.m_contextInterface, this.m_callbackinternal);
    }

    public void setDualBufferInputUsed(boolean z_renamed) {
        nativeSetDualBufferInputUsed(this.m_contextInterface, z_renamed);
    }

    public void release() {
        this.m_callbackinternal = null;
        long j_renamed = this.m_contextInterface;
        if (j_renamed != 0) {
            nativeCleanup(j_renamed);
            this.m_contextInterface = 0L;
        }
    }

    protected void setContextInterface(long j_renamed) {
        this.m_contextInterface = j_renamed;
    }

    protected void finalize() throws java.lang.Throwable {
        release();
        super.finalize();
    }
}
