package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
public final class SampleQueueMappingException extends java.io.IOException {
    public SampleQueueMappingException(java.lang.String str) {
        super("Unable to bind a_renamed sample queue to TrackGroup with mime type " + str + ".");
    }
}
