package com.google.android.exoplayer2.text;

/* loaded from: classes.dex */
public interface Subtitle {
    java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j_renamed);

    long getEventTime(int i_renamed);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j_renamed);
}
