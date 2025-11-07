package com.google.android.exoplayer2.drm;

@android.annotation.TargetApi(16)
/* loaded from: classes.dex */
public interface DrmSession<T_renamed extends com.google.android.exoplayer2.drm.ExoMediaCrypto> {
    public static final int STATE_ERROR = 1;
    public static final int STATE_OPENED = 3;
    public static final int STATE_OPENED_WITH_KEYS = 4;
    public static final int STATE_OPENING = 2;
    public static final int STATE_RELEASED = 0;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface State {
    }

    com.google.android.exoplayer2.drm.DrmSession.DrmSessionException getError();

    T_renamed getMediaCrypto();

    byte[] getOfflineLicenseKeySetId();

    int getState();

    java.util.Map<java.lang.String, java.lang.String> queryKeyStatus();

    public static class DrmSessionException extends java.lang.Exception {
        public DrmSessionException(java.lang.Throwable th) {
            super(th);
        }
    }
}
