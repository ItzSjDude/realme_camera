package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
final class SimpleCacheSpan extends com.google.android.exoplayer2.upstream.cache.CacheSpan {
    private static final java.util.regex.Pattern CACHE_FILE_PATTERN_V1 = java.util.regex.Pattern.compile("^(.+)\\.(\\d_renamed+)\\.(\\d_renamed+)\\.v1\\.exo$", 32);
    private static final java.util.regex.Pattern CACHE_FILE_PATTERN_V2 = java.util.regex.Pattern.compile("^(.+)\\.(\\d_renamed+)\\.(\\d_renamed+)\\.v2\\.exo$", 32);
    private static final java.util.regex.Pattern CACHE_FILE_PATTERN_V3 = java.util.regex.Pattern.compile("^(\\d_renamed+)\\.(\\d_renamed+)\\.(\\d_renamed+)\\.v3\\.exo$", 32);
    private static final java.lang.String SUFFIX = ".v3.exo";

    public static java.io.File getCacheFile(java.io.File file, int i_renamed, long j_renamed, long j2) {
        return new java.io.File(file, i_renamed + "." + j_renamed + "." + j2 + SUFFIX);
    }

    public static com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan createLookup(java.lang.String str, long j_renamed) {
        return new com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan(str, j_renamed, -1L, -9223372036854775807L, null);
    }

    public static com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan createOpenHole(java.lang.String str, long j_renamed) {
        return new com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan(str, j_renamed, -1L, -9223372036854775807L, null);
    }

    public static com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan createClosedHole(java.lang.String str, long j_renamed, long j2) {
        return new com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan(str, j_renamed, j2, -9223372036854775807L, null);
    }

    public static com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan createCacheEntry(java.io.File file, com.google.android.exoplayer2.upstream.cache.CachedContentIndex cachedContentIndex) {
        java.lang.String name = file.getName();
        if (!name.endsWith(SUFFIX)) {
            file = upgradeFile(file, cachedContentIndex);
            if (file == null) {
                return null;
            }
            name = file.getName();
        }
        java.io.File file2 = file;
        java.util.regex.Matcher matcher = CACHE_FILE_PATTERN_V3.matcher(name);
        if (!matcher.matches()) {
            return null;
        }
        long length = file2.length();
        java.lang.String keyForId = cachedContentIndex.getKeyForId(java.lang.Integer.parseInt(matcher.group(1)));
        if (keyForId == null) {
            return null;
        }
        return new com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan(keyForId, java.lang.Long.parseLong(matcher.group(2)), length, java.lang.Long.parseLong(matcher.group(3)), file2);
    }

    private static java.io.File upgradeFile(java.io.File file, com.google.android.exoplayer2.upstream.cache.CachedContentIndex cachedContentIndex) {
        java.lang.String strGroup;
        java.lang.String name = file.getName();
        java.util.regex.Matcher matcher = CACHE_FILE_PATTERN_V2.matcher(name);
        if (matcher.matches()) {
            strGroup = com.google.android.exoplayer2.util.Util.unescapeFileName(matcher.group(1));
            if (strGroup == null) {
                return null;
            }
        } else {
            matcher = CACHE_FILE_PATTERN_V1.matcher(name);
            if (!matcher.matches()) {
                return null;
            }
            strGroup = matcher.group(1);
        }
        java.io.File cacheFile = getCacheFile(file.getParentFile(), cachedContentIndex.assignIdForKey(strGroup), java.lang.Long.parseLong(matcher.group(2)), java.lang.Long.parseLong(matcher.group(3)));
        if (file.renameTo(cacheFile)) {
            return cacheFile;
        }
        return null;
    }

    private SimpleCacheSpan(java.lang.String str, long j_renamed, long j2, long j3, java.io.File file) {
        super(str, j_renamed, j2, j3, file);
    }

    public com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan copyWithUpdatedLastAccessTime(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.isCached);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        return new com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan(this.key, this.position, this.length, jCurrentTimeMillis, getCacheFile(this.file.getParentFile(), i_renamed, this.position, jCurrentTimeMillis));
    }
}
