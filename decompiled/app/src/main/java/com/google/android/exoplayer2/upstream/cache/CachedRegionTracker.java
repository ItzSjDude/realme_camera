package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public final class CachedRegionTracker implements com.google.android.exoplayer2.upstream.cache.Cache.Listener {
    public static final int CACHED_TO_END = -2;
    public static final int NOT_CACHED = -1;
    private static final java.lang.String TAG = "CachedRegionTracker";
    private final com.google.android.exoplayer2.upstream.cache.Cache cache;
    private final java.lang.String cacheKey;
    private final com.google.android.exoplayer2.extractor.ChunkIndex chunkIndex;
    private final java.util.TreeSet<com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region> regions = new java.util.TreeSet<>();
    private final com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region lookupRegion = new com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region(0, 0);

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan2) {
    }

    public CachedRegionTracker(com.google.android.exoplayer2.upstream.cache.Cache cache, java.lang.String str, com.google.android.exoplayer2.extractor.ChunkIndex chunkIndex) {
        this.cache = cache;
        this.cacheKey = str;
        this.chunkIndex = chunkIndex;
        synchronized (this) {
            java.util.Iterator<com.google.android.exoplayer2.upstream.cache.CacheSpan> itDescendingIterator = cache.addListener(str, this).descendingIterator();
            while (itDescendingIterator.hasNext()) {
                mergeSpan(itDescendingIterator.next());
            }
        }
    }

    public void release() {
        this.cache.removeListener(this.cacheKey, this);
    }

    public synchronized int getRegionEndTimeMs(long j_renamed) {
        this.lookupRegion.startOffset = j_renamed;
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region regionFloor = this.regions.floor(this.lookupRegion);
        if (regionFloor != null && j_renamed <= regionFloor.endOffset && regionFloor.endOffsetIndex != -1) {
            int i_renamed = regionFloor.endOffsetIndex;
            if (i_renamed == this.chunkIndex.length - 1) {
                if (regionFloor.endOffset == this.chunkIndex.offsets[i_renamed] + this.chunkIndex.sizes[i_renamed]) {
                    return -2;
                }
            }
            return (int) ((this.chunkIndex.timesUs[i_renamed] + ((this.chunkIndex.durationsUs[i_renamed] * (regionFloor.endOffset - this.chunkIndex.offsets[i_renamed])) / this.chunkIndex.sizes[i_renamed])) / 1000);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanAdded(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        mergeSpan(cacheSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanRemoved(com.google.android.exoplayer2.upstream.cache.Cache cache, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region = new com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region(cacheSpan.position, cacheSpan.position + cacheSpan.length);
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region regionFloor = this.regions.floor(region);
        if (regionFloor == null) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Removed a_renamed span we were not aware of_renamed");
            return;
        }
        this.regions.remove(regionFloor);
        if (regionFloor.startOffset < region.startOffset) {
            com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region2 = new com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region(regionFloor.startOffset, region.startOffset);
            int iBinarySearch = java.util.Arrays.binarySearch(this.chunkIndex.offsets, region2.endOffset);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            region2.endOffsetIndex = iBinarySearch;
            this.regions.add(region2);
        }
        if (regionFloor.endOffset > region.endOffset) {
            com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region3 = new com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region(region.endOffset + 1, regionFloor.endOffset);
            region3.endOffsetIndex = regionFloor.endOffsetIndex;
            this.regions.add(region3);
        }
    }

    private void mergeSpan(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region = new com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region(cacheSpan.position, cacheSpan.position + cacheSpan.length);
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region regionFloor = this.regions.floor(region);
        com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region regionCeiling = this.regions.ceiling(region);
        boolean zRegionsConnect = regionsConnect(regionFloor, region);
        if (regionsConnect(region, regionCeiling)) {
            if (zRegionsConnect) {
                regionFloor.endOffset = regionCeiling.endOffset;
                regionFloor.endOffsetIndex = regionCeiling.endOffsetIndex;
            } else {
                region.endOffset = regionCeiling.endOffset;
                region.endOffsetIndex = regionCeiling.endOffsetIndex;
                this.regions.add(region);
            }
            this.regions.remove(regionCeiling);
            return;
        }
        if (zRegionsConnect) {
            regionFloor.endOffset = region.endOffset;
            int i_renamed = regionFloor.endOffsetIndex;
            while (i_renamed < this.chunkIndex.length - 1) {
                int i2 = i_renamed + 1;
                if (this.chunkIndex.offsets[i2] > regionFloor.endOffset) {
                    break;
                } else {
                    i_renamed = i2;
                }
            }
            regionFloor.endOffsetIndex = i_renamed;
            return;
        }
        int iBinarySearch = java.util.Arrays.binarySearch(this.chunkIndex.offsets, region.endOffset);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        region.endOffsetIndex = iBinarySearch;
        this.regions.add(region);
    }

    private boolean regionsConnect(com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region, com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region2) {
        return (region == null || region2 == null || region.endOffset != region2.startOffset) ? false : true;
    }

    private static class Region implements java.lang.Comparable<com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region> {
        public long endOffset;
        public int endOffsetIndex;
        public long startOffset;

        public Region(long j_renamed, long j2) {
            this.startOffset = j_renamed;
            this.endOffset = j2;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.upstream.cache.CachedRegionTracker.Region region) {
            long j_renamed = this.startOffset;
            long j2 = region.startOffset;
            if (j_renamed < j2) {
                return -1;
            }
            return j_renamed == j2 ? 0 : 1;
        }
    }
}
