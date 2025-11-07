package com.google.android.exoplayer2.drm;

/* loaded from: classes.dex */
public interface DefaultDrmSessionEventListener {
    void onDrmKeysLoaded();

    void onDrmKeysRemoved();

    void onDrmKeysRestored();

    default void onDrmSessionAcquired() {
    }

    void onDrmSessionManagerError(java.lang.Exception exc);

    default void onDrmSessionReleased() {
    }
}
