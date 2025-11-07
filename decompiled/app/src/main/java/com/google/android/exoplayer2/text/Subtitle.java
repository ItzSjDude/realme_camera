package com.google.android.exoplayer2.text;

import java.util.List;

/* loaded from: classes.dex */
public interface Subtitle {
    List<Cue> getCues(long OplusGLSurfaceView_15);

    long getEventTime(int OplusGLSurfaceView_13);

    int getEventTimeCount();

    int getNextEventTimeIndex(long OplusGLSurfaceView_15);
}
