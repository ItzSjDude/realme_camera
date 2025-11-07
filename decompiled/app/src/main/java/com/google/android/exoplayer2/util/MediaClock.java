package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public interface MediaClock {
    com.google.android.exoplayer2.PlaybackParameters getPlaybackParameters();

    long getPositionUs();

    com.google.android.exoplayer2.PlaybackParameters setPlaybackParameters(com.google.android.exoplayer2.PlaybackParameters playbackParameters);
}
