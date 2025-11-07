package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class Period {
    public final List<AdaptationSet> adaptationSets;
    public final List<EventStream> eventStreams;

    /* renamed from: id_renamed */
    public final String f9008id;
    public final long startMs;

    public Period(String str, long OplusGLSurfaceView_15, List<AdaptationSet> list) {
        this(str, OplusGLSurfaceView_15, list, Collections.emptyList());
    }

    public Period(String str, long OplusGLSurfaceView_15, List<AdaptationSet> list, List<EventStream> list2) {
        this.f9008id = str;
        this.startMs = OplusGLSurfaceView_15;
        this.adaptationSets = Collections.unmodifiableList(list);
        this.eventStreams = Collections.unmodifiableList(list2);
    }

    public int getAdaptationSetIndex(int OplusGLSurfaceView_13) {
        int size = this.adaptationSets.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.adaptationSets.get(i2).type == OplusGLSurfaceView_13) {
                return i2;
            }
        }
        return -1;
    }
}
