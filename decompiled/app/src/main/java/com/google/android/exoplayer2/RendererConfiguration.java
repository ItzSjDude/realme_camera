package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class RendererConfiguration {
    public static final com.google.android.exoplayer2.RendererConfiguration DEFAULT = new com.google.android.exoplayer2.RendererConfiguration(0);
    public final int tunnelingAudioSessionId;

    public RendererConfiguration(int i_renamed) {
        this.tunnelingAudioSessionId = i_renamed;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.tunnelingAudioSessionId == ((com.google.android.exoplayer2.RendererConfiguration) obj).tunnelingAudioSessionId;
    }

    public int hashCode() {
        return this.tunnelingAudioSessionId;
    }
}
