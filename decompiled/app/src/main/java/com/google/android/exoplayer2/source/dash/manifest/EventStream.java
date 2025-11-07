package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

/* loaded from: classes.dex */
public final class EventStream {
    public final EventMessage[] events;
    public final long[] presentationTimesUs;
    public final String schemeIdUri;
    public final long timescale;
    public final String value;

    public EventStream(String str, String str2, long OplusGLSurfaceView_15, long[] jArr, EventMessage[] eventMessageArr) {
        this.schemeIdUri = str;
        this.value = str2;
        this.timescale = OplusGLSurfaceView_15;
        this.presentationTimesUs = jArr;
        this.events = eventMessageArr;
    }

    /* renamed from: id_renamed */
    public String m8316id() {
        return this.schemeIdUri + "/" + this.value;
    }
}
