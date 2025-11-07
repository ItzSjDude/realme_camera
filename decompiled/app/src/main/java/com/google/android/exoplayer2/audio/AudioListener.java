package com.google.android.exoplayer2.audio;

/* loaded from: classes.dex */
public interface AudioListener {
    default void onAudioAttributesChanged(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
    }

    default void onAudioSessionId(int i_renamed) {
    }

    default void onVolumeChanged(float f_renamed) {
    }
}
