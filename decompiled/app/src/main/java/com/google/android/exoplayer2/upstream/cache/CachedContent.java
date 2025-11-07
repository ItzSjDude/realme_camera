package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
final class CachedContent {
    private static final int VERSION_MAX = Integer.MAX_VALUE;
    private static final int VERSION_METADATA_INTRODUCED = 2;
    public final int id_renamed;
    public final java.lang.String key;
    private boolean locked;
    private com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata metadata = com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata.EMPTY;
    private final java.util.TreeSet<com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan> cachedSpans = new java.util.TreeSet<>();

    public static com.google.android.exoplayer2.upstream.cache.CachedContent readFromStream(int i_renamed, java.io.DataInputStream dataInputStream) throws java.io.IOException {
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = new com.google.android.exoplayer2.upstream.cache.CachedContent(dataInputStream.readInt(), dataInputStream.readUTF());
        if (i_renamed < 2) {
            long j_renamed = dataInputStream.readLong();
            com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations = new com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations();
            com.google.android.exoplayer2.upstream.cache.ContentMetadataInternal.setContentLength(contentMetadataMutations, j_renamed);
            cachedContent.applyMetadataMutations(contentMetadataMutations);
        } else {
            cachedContent.metadata = com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata.readFromStream(dataInputStream);
        }
        return cachedContent;
    }

    public CachedContent(int i_renamed, java.lang.String str) {
        this.id_renamed = i_renamed;
        this.key = str;
    }

    public void writeToStream(java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
        dataOutputStream.writeInt(this.id_renamed);
        dataOutputStream.writeUTF(this.key);
        this.metadata.writeToStream(dataOutputStream);
    }

    public com.google.android.exoplayer2.upstream.cache.ContentMetadata getMetadata() {
        return this.metadata;
    }

    public boolean applyMetadataMutations(com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) {
        this.metadata = this.metadata.copyWithMutationsApplied(contentMetadataMutations);
        return !this.metadata.equals(r0);
    }

    public boolean isLocked() {
        return this.locked;
    }

    public void setLocked(boolean z_renamed) {
        this.locked = z_renamed;
    }

    public void addSpan(com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan) {
        this.cachedSpans.add(simpleCacheSpan);
    }

    public java.util.TreeSet<com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan> getSpans() {
        return this.cachedSpans;
    }

    public com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan getSpan(long j_renamed) {
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpanCreateLookup = com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.createLookup(this.key, j_renamed);
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpanFloor = this.cachedSpans.floor(simpleCacheSpanCreateLookup);
        if (simpleCacheSpanFloor != null && simpleCacheSpanFloor.position + simpleCacheSpanFloor.length > j_renamed) {
            return simpleCacheSpanFloor;
        }
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpanCeiling = this.cachedSpans.ceiling(simpleCacheSpanCreateLookup);
        if (simpleCacheSpanCeiling == null) {
            return com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.createOpenHole(this.key, j_renamed);
        }
        return com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.createClosedHole(this.key, j_renamed, simpleCacheSpanCeiling.position - j_renamed);
    }

    public long getCachedBytesLength(long j_renamed, long j2) {
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan span = getSpan(j_renamed);
        if (span.isHoleSpan()) {
            return -java.lang.Math.min(span.isOpenEnded() ? Long.MAX_VALUE : span.length, j2);
        }
        long j3 = j_renamed + j2;
        long jMax = span.position + span.length;
        if (jMax < j3) {
            for (com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan : this.cachedSpans.tailSet(span, false)) {
                if (simpleCacheSpan.position > jMax) {
                    break;
                }
                jMax = java.lang.Math.max(jMax, simpleCacheSpan.position + simpleCacheSpan.length);
                if (jMax >= j3) {
                    break;
                }
            }
        }
        return java.lang.Math.min(jMax - j_renamed, j2);
    }

    public com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan touch(com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpanCopyWithUpdatedLastAccessTime = simpleCacheSpan.copyWithUpdatedLastAccessTime(this.id_renamed);
        if (!simpleCacheSpan.file.renameTo(simpleCacheSpanCopyWithUpdatedLastAccessTime.file)) {
            throw new com.google.android.exoplayer2.upstream.cache.Cache.CacheException("Renaming of_renamed " + simpleCacheSpan.file + " to " + simpleCacheSpanCopyWithUpdatedLastAccessTime.file + " failed.");
        }
        com.google.android.exoplayer2.util.Assertions.checkState(this.cachedSpans.remove(simpleCacheSpan));
        this.cachedSpans.add(simpleCacheSpanCopyWithUpdatedLastAccessTime);
        return simpleCacheSpanCopyWithUpdatedLastAccessTime;
    }

    public boolean isEmpty() {
        return this.cachedSpans.isEmpty();
    }

    public boolean removeSpan(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        if (!this.cachedSpans.remove(cacheSpan)) {
            return false;
        }
        cacheSpan.file.delete();
        return true;
    }

    public int headerHashCode(int i_renamed) {
        int i2;
        int iHashCode;
        int iHashCode2 = (this.id_renamed * 31) + this.key.hashCode();
        if (i_renamed < 2) {
            long contentLength = com.google.android.exoplayer2.upstream.cache.ContentMetadataInternal.getContentLength(this.metadata);
            i2 = iHashCode2 * 31;
            iHashCode = (int) (contentLength ^ (contentLength >>> 32));
        } else {
            i2 = iHashCode2 * 31;
            iHashCode = this.metadata.hashCode();
        }
        return i2 + iHashCode;
    }

    public int hashCode() {
        return (headerHashCode(Integer.MAX_VALUE) * 31) + this.cachedSpans.hashCode();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = (com.google.android.exoplayer2.upstream.cache.CachedContent) obj;
        return this.id_renamed == cachedContent.id_renamed && this.key.equals(cachedContent.key) && this.cachedSpans.equals(cachedContent.cachedSpans) && this.metadata.equals(cachedContent.metadata);
    }
}
