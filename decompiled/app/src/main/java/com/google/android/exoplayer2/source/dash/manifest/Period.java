package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes.dex */
public class Period {
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> adaptationSets;
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> eventStreams;
    public final java.lang.String id_renamed;
    public final long startMs;

    public Period(java.lang.String str, long j_renamed, java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list) {
        this(str, j_renamed, list, java.util.Collections.emptyList());
    }

    public Period(java.lang.String str, long j_renamed, java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> list2) {
        this.id_renamed = str;
        this.startMs = j_renamed;
        this.adaptationSets = java.util.Collections.unmodifiableList(list);
        this.eventStreams = java.util.Collections.unmodifiableList(list2);
    }

    public int getAdaptationSetIndex(int i_renamed) {
        int size = this.adaptationSets.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.adaptationSets.get(i2).type == i_renamed) {
                return i2;
            }
        }
        return -1;
    }
}
