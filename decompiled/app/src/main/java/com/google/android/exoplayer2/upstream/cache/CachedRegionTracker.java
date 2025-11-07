package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class CachedRegionTracker implements Cache.Listener {
    public static final int CACHED_TO_END = -2;
    public static final int NOT_CACHED = -1;
    private static final String TAG = "CachedRegionTracker";
    private final Cache cache;
    private final String cacheKey;
    private final ChunkIndex chunkIndex;
    private final TreeSet<Region> regions = new TreeSet<>();
    private final Region lookupRegion = new Region(0, 0);

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    public CachedRegionTracker(Cache cache, String str, ChunkIndex chunkIndex) {
        this.cache = cache;
        this.cacheKey = str;
        this.chunkIndex = chunkIndex;
        synchronized (this) {
            Iterator<CacheSpan> itDescendingIterator = cache.addListener(str, this).descendingIterator();
            while (itDescendingIterator.hasNext()) {
                mergeSpan(itDescendingIterator.next());
            }
        }
    }

    public void release() {
        this.cache.removeListener(this.cacheKey, this);
    }

    public synchronized int getRegionEndTimeMs(long OplusGLSurfaceView_15) {
        this.lookupRegion.startOffset = OplusGLSurfaceView_15;
        Region regionFloor = this.regions.floor(this.lookupRegion);
        if (regionFloor != null && OplusGLSurfaceView_15 <= regionFloor.endOffset && regionFloor.endOffsetIndex != -1) {
            int OplusGLSurfaceView_13 = regionFloor.endOffsetIndex;
            if (OplusGLSurfaceView_13 == this.chunkIndex.length - 1) {
                if (regionFloor.endOffset == this.chunkIndex.offsets[OplusGLSurfaceView_13] + this.chunkIndex.sizes[OplusGLSurfaceView_13]) {
                    return -2;
                }
            }
            return (int) ((this.chunkIndex.timesUs[OplusGLSurfaceView_13] + ((this.chunkIndex.durationsUs[OplusGLSurfaceView_13] * (regionFloor.endOffset - this.chunkIndex.offsets[OplusGLSurfaceView_13])) / this.chunkIndex.sizes[OplusGLSurfaceView_13])) / 1000);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        mergeSpan(cacheSpan);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public synchronized void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        Region region = new Region(cacheSpan.position, cacheSpan.position + cacheSpan.length);
        Region regionFloor = this.regions.floor(region);
        if (regionFloor == null) {
            Log.m8320e(TAG, "Removed PlatformImplementations.kt_3 span we were not aware of");
            return;
        }
        this.regions.remove(regionFloor);
        if (regionFloor.startOffset < region.startOffset) {
            Region region2 = new Region(regionFloor.startOffset, region.startOffset);
            int iBinarySearch = Arrays.binarySearch(this.chunkIndex.offsets, region2.endOffset);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            region2.endOffsetIndex = iBinarySearch;
            this.regions.add(region2);
        }
        if (regionFloor.endOffset > region.endOffset) {
            Region region3 = new Region(region.endOffset + 1, regionFloor.endOffset);
            region3.endOffsetIndex = regionFloor.endOffsetIndex;
            this.regions.add(region3);
        }
    }

    private void mergeSpan(CacheSpan cacheSpan) {
        Region region = new Region(cacheSpan.position, cacheSpan.position + cacheSpan.length);
        Region regionFloor = this.regions.floor(region);
        Region regionCeiling = this.regions.ceiling(region);
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
            int OplusGLSurfaceView_13 = regionFloor.endOffsetIndex;
            while (OplusGLSurfaceView_13 < this.chunkIndex.length - 1) {
                int i2 = OplusGLSurfaceView_13 + 1;
                if (this.chunkIndex.offsets[i2] > regionFloor.endOffset) {
                    break;
                } else {
                    OplusGLSurfaceView_13 = i2;
                }
            }
            regionFloor.endOffsetIndex = OplusGLSurfaceView_13;
            return;
        }
        int iBinarySearch = Arrays.binarySearch(this.chunkIndex.offsets, region.endOffset);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        region.endOffsetIndex = iBinarySearch;
        this.regions.add(region);
    }

    private boolean regionsConnect(Region region, Region region2) {
        return (region == null || region2 == null || region.endOffset != region2.startOffset) ? false : true;
    }

    private static class Region implements Comparable<Region> {
        public long endOffset;
        public int endOffsetIndex;
        public long startOffset;

        public Region(long OplusGLSurfaceView_15, long j2) {
            this.startOffset = OplusGLSurfaceView_15;
            this.endOffset = j2;
        }

        @Override // java.lang.Comparable
        public int compareTo(Region region) {
            long OplusGLSurfaceView_15 = this.startOffset;
            long j2 = region.startOffset;
            if (OplusGLSurfaceView_15 < j2) {
                return -1;
            }
            return OplusGLSurfaceView_15 == j2 ? 0 : 1;
        }
    }
}
