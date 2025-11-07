package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes.dex */
public final class EventStream {
    public final com.google.android.exoplayer2.metadata.emsg.EventMessage[] events;
    public final long[] presentationTimesUs;
    public final java.lang.String schemeIdUri;
    public final long timescale;
    public final java.lang.String value;

    public EventStream(java.lang.String str, java.lang.String str2, long j_renamed, long[] jArr, com.google.android.exoplayer2.metadata.emsg.EventMessage[] eventMessageArr) {
        this.schemeIdUri = str;
        this.value = str2;
        this.timescale = j_renamed;
        this.presentationTimesUs = jArr;
        this.events = eventMessageArr;
    }

    public java.lang.String id_renamed() {
        return this.schemeIdUri + "/" + this.value;
    }
}
