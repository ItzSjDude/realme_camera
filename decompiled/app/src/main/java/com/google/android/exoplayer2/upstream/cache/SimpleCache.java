package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public final class SimpleCache implements com.google.android.exoplayer2.upstream.cache.Cache {
    private static final java.lang.String TAG = "SimpleCache";
    private static boolean cacheFolderLockingDisabled;
    private static final java.util.HashSet<java.io.File> lockedCacheDirs = new java.util.HashSet<>();
    private final java.io.File cacheDir;
    private final com.google.android.exoplayer2.upstream.cache.CacheEvictor evictor;
    private final com.google.android.exoplayer2.upstream.cache.CachedContentIndex index;
    private final java.util.HashMap<java.lang.String, java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener>> listeners;
    private boolean released;
    private long totalSpace;

    public static synchronized boolean isCacheFolderLocked(java.io.File file) {
        return lockedCacheDirs.contains(file.getAbsoluteFile());
    }

    @java.lang.Deprecated
    public static synchronized void disableCacheFolderLocking() {
        cacheFolderLockingDisabled = true;
        lockedCacheDirs.clear();
    }

    public SimpleCache(java.io.File file, com.google.android.exoplayer2.upstream.cache.CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, null, false);
    }

    public SimpleCache(java.io.File file, com.google.android.exoplayer2.upstream.cache.CacheEvictor cacheEvictor, byte[] bArr) {
        this(file, cacheEvictor, bArr, bArr != null);
    }

    public SimpleCache(java.io.File file, com.google.android.exoplayer2.upstream.cache.CacheEvictor cacheEvictor, byte[] bArr, boolean z_renamed) {
        this(file, cacheEvictor, new com.google.android.exoplayer2.upstream.cache.CachedContentIndex(file, bArr, z_renamed));
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.android.exoplayer2.upstream.cache.SimpleCache$1] */
    SimpleCache(java.io.File file, com.google.android.exoplayer2.upstream.cache.CacheEvictor cacheEvictor, com.google.android.exoplayer2.upstream.cache.CachedContentIndex cachedContentIndex) {
        if (!lockFolder(file)) {
            throw new java.lang.IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.cacheDir = file;
        this.evictor = cacheEvictor;
        this.index = cachedContentIndex;
        this.listeners = new java.util.HashMap<>();
        final android.os.ConditionVariable conditionVariable = new android.os.ConditionVariable();
        new java.lang.Thread("SimpleCache.initialize()") { // from class: com.google.android.exoplayer2.upstream.cache.SimpleCache.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (com.google.android.exoplayer2.upstream.cache.SimpleCache.this) {
                    conditionVariable.open();
                    com.google.android.exoplayer2.upstream.cache.SimpleCache.this.initialize();
                    com.google.android.exoplayer2.upstream.cache.SimpleCache.this.evictor.onCacheInitialized();
                }
            }
        }.start();
        conditionVariable.block();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void release() {
        if (this.released) {
            return;
        }
        this.listeners.clear();
        removeStaleSpans();
        try {
            try {
                this.index.store();
                unlockFolder(this.cacheDir);
            } catch (java.lang.Throwable th) {
                unlockFolder(this.cacheDir);
                this.released = true;
                throw th;
            }
        } catch (com.google.android.exoplayer2.upstream.cache.Cache.CacheException e_renamed) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Storing index file failed", e_renamed);
            unlockFolder(this.cacheDir);
        }
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized java.util.NavigableSet<com.google.android.exoplayer2.upstream.cache.CacheSpan> addListener(java.lang.String str, com.google.android.exoplayer2.upstream.cache.Cache.Listener listener) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener> arrayList = this.listeners.get(str);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            this.listeners.put(str, arrayList);
        }
        arrayList.add(listener);
        return getCachedSpans(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeListener(java.lang.String str, com.google.android.exoplayer2.upstream.cache.Cache.Listener listener) {
        if (this.released) {
            return;
        }
        java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener> arrayList = this.listeners.get(str);
        if (arrayList != null) {
            arrayList.remove(listener);
            if (arrayList.isEmpty()) {
                this.listeners.remove(str);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized java.util.NavigableSet<com.google.android.exoplayer2.upstream.cache.CacheSpan> getCachedSpans(java.lang.String str) {
        java.util.TreeSet treeSet;
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = this.index.get(str);
        if (cachedContent == null || cachedContent.isEmpty()) {
            treeSet = new java.util.TreeSet();
        } else {
            treeSet = new java.util.TreeSet((java.util.Collection) cachedContent.getSpans());
        }
        return treeSet;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized java.util.Set<java.lang.String> getKeys() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        return new java.util.HashSet(this.index.getKeys());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCacheSpace() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        return this.totalSpace;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan startReadWrite(java.lang.String str, long j_renamed) throws java.lang.InterruptedException, com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpanStartReadWriteNonBlocking;
        while (true) {
            simpleCacheSpanStartReadWriteNonBlocking = startReadWriteNonBlocking(str, j_renamed);
            if (simpleCacheSpanStartReadWriteNonBlocking == null) {
                wait();
            }
        }
        return simpleCacheSpanStartReadWriteNonBlocking;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan startReadWriteNonBlocking(java.lang.String str, long j_renamed) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan span = getSpan(str, j_renamed);
        if (span.isCached) {
            try {
                com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan = this.index.get(str).touch(span);
                notifySpanTouched(span, simpleCacheSpan);
                return simpleCacheSpan;
            } catch (com.google.android.exoplayer2.upstream.cache.Cache.CacheException unused) {
                return span;
            }
        }
        com.google.android.exoplayer2.upstream.cache.CachedContent orAdd = this.index.getOrAdd(str);
        if (orAdd.isLocked()) {
            return null;
        }
        orAdd.setLocked(true);
        return span;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized java.io.File startFile(java.lang.String str, long j_renamed, long j2) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent;
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        cachedContent = this.index.get(str);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(cachedContent);
        com.google.android.exoplayer2.util.Assertions.checkState(cachedContent.isLocked());
        if (!this.cacheDir.exists()) {
            this.cacheDir.mkdirs();
            removeStaleSpans();
        }
        this.evictor.onStartFile(this, str, j_renamed, j2);
        return com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.getCacheFile(this.cacheDir, cachedContent.id_renamed, j_renamed, java.lang.System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void commitFile(java.io.File file) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        boolean z_renamed = true;
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpanCreateCacheEntry = com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.createCacheEntry(file, this.index);
        com.google.android.exoplayer2.util.Assertions.checkState(simpleCacheSpanCreateCacheEntry != null);
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = this.index.get(simpleCacheSpanCreateCacheEntry.key);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(cachedContent);
        com.google.android.exoplayer2.util.Assertions.checkState(cachedContent.isLocked());
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            long contentLength = com.google.android.exoplayer2.upstream.cache.ContentMetadataInternal.getContentLength(cachedContent.getMetadata());
            if (contentLength != -1) {
                if (simpleCacheSpanCreateCacheEntry.position + simpleCacheSpanCreateCacheEntry.length > contentLength) {
                    z_renamed = false;
                }
                com.google.android.exoplayer2.util.Assertions.checkState(z_renamed);
            }
            addSpan(simpleCacheSpanCreateCacheEntry);
            this.index.store();
            notifyAll();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void releaseHoleSpan(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = this.index.get(cacheSpan.key);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(cachedContent);
        com.google.android.exoplayer2.util.Assertions.checkState(cachedContent.isLocked());
        cachedContent.setLocked(false);
        this.index.maybeRemove(cachedContent.key);
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeSpan(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        removeSpanInternal(cacheSpan);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x001e  */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isCached(java.lang.String r4, long r5, long r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.released     // Catch: java.lang.Throwable -> L21
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L9
            r0 = r1
            goto La
        L9:
            r0 = r2
        La:
            com.google.android.exoplayer2.util.Assertions.checkState(r0)     // Catch: java.lang.Throwable -> L21
            com.google.android.exoplayer2.upstream.cache.CachedContentIndex r0 = r3.index     // Catch: java.lang.Throwable -> L21
            com.google.android.exoplayer2.upstream.cache.CachedContent r4 = r0.get(r4)     // Catch: java.lang.Throwable -> L21
            if (r4 == 0) goto L1e
            long r4 = r4.getCachedBytesLength(r5, r7)     // Catch: java.lang.Throwable -> L21
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 < 0) goto L1e
            goto L1f
        L1e:
            r1 = r2
        L1f:
            monitor-exit(r3)
            return r1
        L21:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.SimpleCache.isCached(java.lang.String, long, long):boolean");
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedLength(java.lang.String str, long j_renamed, long j2) {
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent;
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        cachedContent = this.index.get(str);
        return cachedContent != null ? cachedContent.getCachedBytesLength(j_renamed, j2) : -j2;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void setContentLength(java.lang.String str, long j_renamed) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations = new com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations();
        com.google.android.exoplayer2.upstream.cache.ContentMetadataInternal.setContentLength(contentMetadataMutations, j_renamed);
        applyContentMetadataMutations(str, contentMetadataMutations);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getContentLength(java.lang.String str) {
        return com.google.android.exoplayer2.upstream.cache.ContentMetadataInternal.getContentLength(getContentMetadata(str));
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void applyContentMetadataMutations(java.lang.String str, com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        this.index.applyContentMetadataMutations(str, contentMetadataMutations);
        this.index.store();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized com.google.android.exoplayer2.upstream.cache.ContentMetadata getContentMetadata(java.lang.String str) {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.released);
        return this.index.getContentMetadata(str);
    }

    private com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan getSpan(java.lang.String str, long j_renamed) throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan span;
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = this.index.get(str);
        if (cachedContent == null) {
            return com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.createOpenHole(str, j_renamed);
        }
        while (true) {
            span = cachedContent.getSpan(j_renamed);
            if (!span.isCached || span.file.exists()) {
                break;
            }
            removeStaleSpans();
        }
        return span;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialize() {
        if (!this.cacheDir.exists()) {
            this.cacheDir.mkdirs();
            return;
        }
        this.index.load();
        java.io.File[] fileArrListFiles = this.cacheDir.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (java.io.File file : fileArrListFiles) {
            if (!file.getName().equals(com.google.android.exoplayer2.upstream.cache.CachedContentIndex.FILE_NAME)) {
                com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpanCreateCacheEntry = file.length() > 0 ? com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.createCacheEntry(file, this.index) : null;
                if (simpleCacheSpanCreateCacheEntry != null) {
                    addSpan(simpleCacheSpanCreateCacheEntry);
                } else {
                    file.delete();
                }
            }
        }
        this.index.removeEmpty();
        try {
            this.index.store();
        } catch (com.google.android.exoplayer2.upstream.cache.Cache.CacheException e_renamed) {
            com.google.android.exoplayer2.util.Log.e_renamed(TAG, "Storing index file failed", e_renamed);
        }
    }

    private void addSpan(com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan) {
        this.index.getOrAdd(simpleCacheSpan.key).addSpan(simpleCacheSpan);
        this.totalSpace += simpleCacheSpan.length;
        notifySpanAdded(simpleCacheSpan);
    }

    private void removeSpanInternal(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = this.index.get(cacheSpan.key);
        if (cachedContent == null || !cachedContent.removeSpan(cacheSpan)) {
            return;
        }
        this.totalSpace -= cacheSpan.length;
        this.index.maybeRemove(cachedContent.key);
        notifySpanRemoved(cacheSpan);
    }

    private void removeStaleSpans() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.google.android.exoplayer2.upstream.cache.CachedContent> it = this.index.getAll().iterator();
        while (it.hasNext()) {
            java.util.Iterator<com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan> it2 = it.next().getSpans().iterator();
            while (it2.hasNext()) {
                com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan next = it2.next();
                if (!next.file.exists()) {
                    arrayList.add(next);
                }
            }
        }
        for (int i_renamed = 0; i_renamed < arrayList.size(); i_renamed++) {
            removeSpanInternal((com.google.android.exoplayer2.upstream.cache.CacheSpan) arrayList.get(i_renamed));
        }
    }

    private void notifySpanRemoved(com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener> arrayList = this.listeners.get(cacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanRemoved(this, cacheSpan);
            }
        }
        this.evictor.onSpanRemoved(this, cacheSpan);
    }

    private void notifySpanAdded(com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan) {
        java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener> arrayList = this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanAdded(this, simpleCacheSpan);
            }
        }
        this.evictor.onSpanAdded(this, simpleCacheSpan);
    }

    private void notifySpanTouched(com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan simpleCacheSpan, com.google.android.exoplayer2.upstream.cache.CacheSpan cacheSpan) {
        java.util.ArrayList<com.google.android.exoplayer2.upstream.cache.Cache.Listener> arrayList = this.listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanTouched(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.evictor.onSpanTouched(this, simpleCacheSpan, cacheSpan);
    }

    private static synchronized boolean lockFolder(java.io.File file) {
        if (cacheFolderLockingDisabled) {
            return true;
        }
        return lockedCacheDirs.add(file.getAbsoluteFile());
    }

    private static synchronized void unlockFolder(java.io.File file) {
        if (!cacheFolderLockingDisabled) {
            lockedCacheDirs.remove(file.getAbsoluteFile());
        }
    }
}
