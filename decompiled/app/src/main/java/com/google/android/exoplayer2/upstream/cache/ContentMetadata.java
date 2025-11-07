package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public interface ContentMetadata {
    public static final java.lang.String INTERNAL_METADATA_NAME_PREFIX = "exo_";

    boolean contains(java.lang.String str);

    long get(java.lang.String str, long j_renamed);

    java.lang.String get(java.lang.String str, java.lang.String str2);

    byte[] get(java.lang.String str, byte[] bArr);
}
