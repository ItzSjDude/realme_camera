package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class CacheUtil {
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;
    public static final CacheKeyFactory DEFAULT_CACHE_KEY_FACTORY = new CacheKeyFactory() { // from class: com.google.android.exoplayer2.upstream.cache.-$$Lambda$u97poD-IIwob7OPYcVJkh9jokx0
        @Override // com.google.android.exoplayer2.upstream.cache.CacheKeyFactory
        public final String buildCacheKey(DataSpec dataSpec) {
            return CacheUtil.getKey(dataSpec);
        }
    };

    public static class CachingCounters {
        public volatile long alreadyCachedBytes;
        public volatile long contentLength = -1;
        public volatile long newlyCachedBytes;

        public long totalCachedBytes() {
            return this.alreadyCachedBytes + this.newlyCachedBytes;
        }
    }

    public static String generateKey(Uri uri) {
        return uri.toString();
    }

    public static String getKey(DataSpec dataSpec) {
        return dataSpec.key != null ? dataSpec.key : generateKey(dataSpec.uri);
    }

    public static void getCached(DataSpec dataSpec, Cache cache, CachingCounters cachingCounters) {
        String key = getKey(dataSpec);
        long OplusGLSurfaceView_15 = dataSpec.absoluteStreamPosition;
        long contentLength = dataSpec.length != -1 ? dataSpec.length : cache.getContentLength(key);
        cachingCounters.contentLength = contentLength;
        cachingCounters.alreadyCachedBytes = 0L;
        cachingCounters.newlyCachedBytes = 0L;
        long j2 = OplusGLSurfaceView_15;
        long j3 = contentLength;
        while (j3 != 0) {
            long cachedLength = cache.getCachedLength(key, j2, j3 != -1 ? j3 : Long.MAX_VALUE);
            if (cachedLength > 0) {
                cachingCounters.alreadyCachedBytes += cachedLength;
            } else {
                cachedLength = -cachedLength;
                if (cachedLength == Long.MAX_VALUE) {
                    return;
                }
            }
            j2 += cachedLength;
            if (j3 == -1) {
                cachedLength = 0;
            }
            j3 -= cachedLength;
        }
    }

    public static void cache(DataSpec dataSpec, Cache cache, DataSource dataSource, CachingCounters cachingCounters, AtomicBoolean atomicBoolean) throws InterruptedException, IOException {
        cache(dataSpec, cache, new CacheDataSource(cache, dataSource), new byte[131072], null, 0, cachingCounters, atomicBoolean, false);
    }

    public static void cache(DataSpec dataSpec, Cache cache, CacheDataSource cacheDataSource, byte[] bArr, PriorityTaskManager priorityTaskManager, int OplusGLSurfaceView_13, CachingCounters cachingCounters, AtomicBoolean atomicBoolean, boolean z) throws InterruptedException, IOException {
        long OplusGLSurfaceView_15;
        CachingCounters cachingCounters2 = cachingCounters;
        Assertions.checkNotNull(cacheDataSource);
        Assertions.checkNotNull(bArr);
        if (cachingCounters2 != null) {
            getCached(dataSpec, cache, cachingCounters2);
        } else {
            cachingCounters2 = new CachingCounters();
        }
        CachingCounters cachingCounters3 = cachingCounters2;
        String key = getKey(dataSpec);
        long j2 = dataSpec.absoluteStreamPosition;
        long contentLength = dataSpec.length != -1 ? dataSpec.length : cache.getContentLength(key);
        while (contentLength != 0) {
            throwExceptionIfInterruptedOrCancelled(atomicBoolean);
            long cachedLength = cache.getCachedLength(key, j2, contentLength != -1 ? contentLength : Long.MAX_VALUE);
            if (cachedLength > 0) {
                OplusGLSurfaceView_15 = cachedLength;
            } else {
                long j3 = -cachedLength;
                OplusGLSurfaceView_15 = j3;
                if (readAndDiscard(dataSpec, j2, j3, cacheDataSource, bArr, priorityTaskManager, OplusGLSurfaceView_13, cachingCounters3, atomicBoolean) < OplusGLSurfaceView_15) {
                    if (z && contentLength != -1) {
                        throw new EOFException();
                    }
                    return;
                }
            }
            j2 += OplusGLSurfaceView_15;
            if (contentLength == -1) {
                OplusGLSurfaceView_15 = 0;
            }
            contentLength -= OplusGLSurfaceView_15;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        if (r26.contentLength != (-1)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        r26.contentLength = r3.absoluteStreamPosition + r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long readAndDiscard(com.google.android.exoplayer2.upstream.DataSpec r17, long r18, long r20, com.google.android.exoplayer2.upstream.DataSource r22, byte[] r23, com.google.android.exoplayer2.util.PriorityTaskManager r24, int r25, com.google.android.exoplayer2.upstream.cache.CacheUtil.CachingCounters r26, java.util.concurrent.atomic.AtomicBoolean r27) throws java.lang.InterruptedException, java.io.IOException {
        /*
            r1 = r22
            r0 = r23
            r2 = r26
            r3 = r17
        L8:
            if (r24 == 0) goto Ld
            r24.proceed(r25)
        Ld:
            throwExceptionIfInterruptedOrCancelled(r27)     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L88
            com.google.android.exoplayer2.upstream.DataSpec r15 = new com.google.android.exoplayer2.upstream.DataSpec     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L88
            android.net.Uri r5 = r3.uri     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L88
            int r6 = r3.httpMethod     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L88
            byte[] r7 = r3.httpBody     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L88
            long r8 = r3.position     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L88
            long r8 = r8 + r18
            long r10 = r3.absoluteStreamPosition     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L88
            long r10 = r8 - r10
            r12 = -1
            java.lang.String r14 = r3.key     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L88
            int r4 = r3.flags     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L88
            r16 = r4 | 2
            r4 = r15
            r8 = r18
            r17 = r3
            r3 = r15
            r15 = r16
            r4.<init>(r5, r6, r7, r8, r10, r12, r14, r15)     // Catch: com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L80 java.lang.Throwable -> L83
            long r4 = r1.open(r3)     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            long r6 = r2.contentLength     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            r8 = -1
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L48
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 == 0) goto L48
            long r6 = r3.absoluteStreamPosition     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            long r6 = r6 + r4
            r2.contentLength = r6     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
        L48:
            r4 = 0
        L4a:
            int r6 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r6 == 0) goto L7c
            throwExceptionIfInterruptedOrCancelled(r27)     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            r6 = 0
            int r7 = (r20 > r8 ? 1 : (r20 == r8 ? 0 : -1))
            if (r7 == 0) goto L60
            int r7 = r0.length     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            long r10 = (long) r7     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            long r12 = r20 - r4
            long r10 = java.lang.Math.min(r10, r12)     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            int r7 = (int) r10     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            goto L61
        L60:
            int r7 = r0.length     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
        L61:
            int r6 = r1.read(r0, r6, r7)     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            r7 = -1
            if (r6 != r7) goto L74
            long r6 = r2.contentLength     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L7c
            long r6 = r3.absoluteStreamPosition     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            long r6 = r6 + r4
            r2.contentLength = r6     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            goto L7c
        L74:
            long r6 = (long) r6     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            long r4 = r4 + r6
            long r10 = r2.newlyCachedBytes     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            long r10 = r10 + r6
            r2.newlyCachedBytes = r10     // Catch: java.lang.Throwable -> L83 com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException -> L8a
            goto L4a
        L7c:
            com.google.android.exoplayer2.util.Util.closeQuietly(r22)
            return r4
        L80:
            r3 = r17
            goto L8a
        L83:
            r0 = move-exception
            com.google.android.exoplayer2.util.Util.closeQuietly(r22)
            throw r0
        L88:
            r17 = r3
        L8a:
            com.google.android.exoplayer2.util.Util.closeQuietly(r22)
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.CacheUtil.readAndDiscard(com.google.android.exoplayer2.upstream.DataSpec, long, long, com.google.android.exoplayer2.upstream.DataSource, byte[], com.google.android.exoplayer2.util.PriorityTaskManager, int, com.google.android.exoplayer2.upstream.cache.CacheUtil$CachingCounters, java.util.concurrent.atomic.AtomicBoolean):long");
    }

    public static void remove(Cache cache, String str) {
        Iterator<CacheSpan> it = cache.getCachedSpans(str).iterator();
        while (it.hasNext()) {
            try {
                cache.removeSpan(it.next());
            } catch (Cache.CacheException unused) {
            }
        }
    }

    private static void throwExceptionIfInterruptedOrCancelled(AtomicBoolean atomicBoolean) throws InterruptedException {
        if (Thread.interrupted() || (atomicBoolean != null && atomicBoolean.get())) {
            throw new InterruptedException();
        }
    }

    private CacheUtil() {
    }
}
