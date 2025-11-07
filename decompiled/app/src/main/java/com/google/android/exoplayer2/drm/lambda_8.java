package com.google.android.exoplayer2.drm;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$tzysvANfjWo6mXRxYD2fQMdks_4, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$tzysvANfjWo6mXRxYD2fQMdks_4 implements com.google.android.exoplayer2.util.EventDispatcher.Event {
    public static final /* synthetic */ com.google.android.exoplayer2.drm.$$Lambda$tzysvANfjWo6mXRxYD2fQMdks_4 INSTANCE = new com.google.android.exoplayer2.drm.$$Lambda$tzysvANfjWo6mXRxYD2fQMdks_4();

    private /* synthetic */ $$Lambda$tzysvANfjWo6mXRxYD2fQMdks_4() {
    }

    @Override // com.google.android.exoplayer2.util.EventDispatcher.Event
    public final void sendTo(java.lang.Object obj) {
        ((com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener) obj).onDrmKeysRestored();
    }
}
