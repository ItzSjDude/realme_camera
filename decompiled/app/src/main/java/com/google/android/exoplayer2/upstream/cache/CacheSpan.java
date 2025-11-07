package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public class CacheSpan implements java.lang.Comparable<com.google.android.exoplayer2.upstream.cache.CacheSpan> {
    public final java.io.File file;
    public final boolean isCached;
    public final java.lang.String key;
    public final long lastAccessTimestamp;
    public final long length;
    public final long position;

    public CacheSpan(java.lang.String str, long j_renamed, long j2) {
        this(str, j_renamed, j2, -9223372036854775807L, null);
    }

    public CacheSpan(java.lang.String str, long j_renamed, long j2, long j3, java.io.File file) {
        this.key = str;
        this.position = j_renamed;
        this.length = j2;
        this.isCached = file != null;
        this.file = file;
        this.lastAccessTimestamp = j3;
    }

    public boolean isOpenEnded() {
        return this.length == -1;
    }

    public boolean isHoleSpan() {
        return !this.isCached;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        if (!this.key.equals(cacheSpan.key)) {
            return this.key.compareTo(cacheSpan.key);
        }
        long j_renamed = this.position - cacheSpan.position;
        if (j_renamed == 0) {
            return 0;
        }
        return j_renamed < 0 ? -1 : 1;
    }
}
