package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
class CachedContentIndex {
    public static final java.lang.String FILE_NAME = "cached_content_index.exi";
    private static final int FLAG_ENCRYPTED_INDEX = 1;
    private static final int VERSION = 2;
    private final com.google.android.exoplayer2.util.AtomicFile atomicFile;
    private com.google.android.exoplayer2.util.ReusableBufferedOutputStream bufferedOutputStream;
    private boolean changed;
    private final javax.crypto.Cipher cipher;
    private final boolean encrypt;
    private final android.util.SparseArray<java.lang.String> idToKey;
    private final java.util.HashMap<java.lang.String, com.google.android.exoplayer2.upstream.cache.CachedContent> keyToContent;
    private final android.util.SparseBooleanArray removedIds;
    private final javax.crypto.spec.SecretKeySpec secretKeySpec;

    public CachedContentIndex(java.io.File file) {
        this(file, null);
    }

    public CachedContentIndex(java.io.File file, byte[] bArr) {
        this(file, bArr, bArr != null);
    }

    public CachedContentIndex(java.io.File file, byte[] bArr, boolean z_renamed) {
        this.encrypt = z_renamed;
        if (bArr != null) {
            com.google.android.exoplayer2.util.Assertions.checkArgument(bArr.length == 16);
            try {
                this.cipher = getCipher();
                this.secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr, "AES");
            } catch (java.security.NoSuchAlgorithmException | javax.crypto.NoSuchPaddingException e_renamed) {
                throw new java.lang.IllegalStateException(e_renamed);
            }
        } else {
            com.google.android.exoplayer2.util.Assertions.checkState(!z_renamed);
            this.cipher = null;
            this.secretKeySpec = null;
        }
        this.keyToContent = new java.util.HashMap<>();
        this.idToKey = new android.util.SparseArray<>();
        this.removedIds = new android.util.SparseBooleanArray();
        this.atomicFile = new com.google.android.exoplayer2.util.AtomicFile(new java.io.File(file, FILE_NAME));
    }

    public void load() {
        com.google.android.exoplayer2.util.Assertions.checkState(!this.changed);
        if (readFile()) {
            return;
        }
        this.atomicFile.delete();
        this.keyToContent.clear();
        this.idToKey.clear();
    }

    public void store() throws com.google.android.exoplayer2.upstream.cache.Cache.CacheException {
        if (this.changed) {
            writeFile();
            this.changed = false;
            int size = this.removedIds.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.idToKey.remove(this.removedIds.keyAt(i_renamed));
            }
            this.removedIds.clear();
        }
    }

    public com.google.android.exoplayer2.upstream.cache.CachedContent getOrAdd(java.lang.String str) {
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = this.keyToContent.get(str);
        return cachedContent == null ? addNew(str) : cachedContent;
    }

    public com.google.android.exoplayer2.upstream.cache.CachedContent get(java.lang.String str) {
        return this.keyToContent.get(str);
    }

    public java.util.Collection<com.google.android.exoplayer2.upstream.cache.CachedContent> getAll() {
        return this.keyToContent.values();
    }

    public int assignIdForKey(java.lang.String str) {
        return getOrAdd(str).id_renamed;
    }

    public java.lang.String getKeyForId(int i_renamed) {
        return this.idToKey.get(i_renamed);
    }

    public void maybeRemove(java.lang.String str) {
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = this.keyToContent.get(str);
        if (cachedContent == null || !cachedContent.isEmpty() || cachedContent.isLocked()) {
            return;
        }
        this.keyToContent.remove(str);
        this.changed = true;
        this.idToKey.put(cachedContent.id_renamed, null);
        this.removedIds.put(cachedContent.id_renamed, true);
    }

    public void removeEmpty() {
        java.lang.String[] strArr = new java.lang.String[this.keyToContent.size()];
        this.keyToContent.keySet().toArray(strArr);
        for (java.lang.String str : strArr) {
            maybeRemove(str);
        }
    }

    public java.util.Set<java.lang.String> getKeys() {
        return this.keyToContent.keySet();
    }

    public void applyContentMetadataMutations(java.lang.String str, com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) {
        if (getOrAdd(str).applyMetadataMutations(contentMetadataMutations)) {
            this.changed = true;
        }
    }

    public com.google.android.exoplayer2.upstream.cache.ContentMetadata getContentMetadata(java.lang.String str) {
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = get(str);
        return cachedContent != null ? cachedContent.getMetadata() : com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata.EMPTY;
    }

    private boolean readFile() throws java.lang.Throwable {
        java.io.DataInputStream dataInputStream;
        try {
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(this.atomicFile.openRead());
            dataInputStream = new java.io.DataInputStream(bufferedInputStream);
            try {
                int i_renamed = dataInputStream.readInt();
                if (i_renamed >= 0 && i_renamed <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.cipher != null) {
                            byte[] bArr = new byte[16];
                            dataInputStream.readFully(bArr);
                            try {
                                this.cipher.init(2, this.secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr));
                                dataInputStream = new java.io.DataInputStream(new javax.crypto.CipherInputStream(bufferedInputStream, this.cipher));
                            } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException e_renamed) {
                                throw new java.lang.IllegalStateException(e_renamed);
                            }
                        } else {
                            com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream);
                            return false;
                        }
                    } else if (this.encrypt) {
                        this.changed = true;
                    }
                    int i2 = dataInputStream.readInt();
                    int iHeaderHashCode = 0;
                    for (int i3 = 0; i3 < i2; i3++) {
                        com.google.android.exoplayer2.upstream.cache.CachedContent fromStream = com.google.android.exoplayer2.upstream.cache.CachedContent.readFromStream(i_renamed, dataInputStream);
                        add(fromStream);
                        iHeaderHashCode += fromStream.headerHashCode(i_renamed);
                    }
                    int i4 = dataInputStream.readInt();
                    boolean z_renamed = dataInputStream.read() == -1;
                    if (i4 == iHeaderHashCode && z_renamed) {
                        com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream);
                        return true;
                    }
                    com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream);
                    return false;
                }
                com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream);
                return false;
            } catch (java.io.IOException unused) {
                if (dataInputStream != null) {
                    com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream);
                }
                return false;
            } catch (java.lang.Throwable th) {
                th = th;
                if (dataInputStream != null) {
                    com.google.android.exoplayer2.util.Util.closeQuietly(dataInputStream);
                }
                throw th;
            }
        } catch (java.io.IOException unused2) {
            dataInputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            dataInputStream = null;
        }
    }

    private void writeFile() throws java.lang.Throwable {
        java.io.DataOutputStream dataOutputStream;
        try {
            try {
                java.io.OutputStream outputStreamStartWrite = this.atomicFile.startWrite();
                if (this.bufferedOutputStream == null) {
                    this.bufferedOutputStream = new com.google.android.exoplayer2.util.ReusableBufferedOutputStream(outputStreamStartWrite);
                } else {
                    this.bufferedOutputStream.reset(outputStreamStartWrite);
                }
                dataOutputStream = new java.io.DataOutputStream(this.bufferedOutputStream);
            } catch (java.lang.Throwable th) {
                th = th;
                dataOutputStream = null;
            }
        } catch (java.io.IOException e_renamed) {
            e_renamed = e_renamed;
        }
        try {
            dataOutputStream.writeInt(2);
            int iHeaderHashCode = 0;
            dataOutputStream.writeInt(this.encrypt ? 1 : 0);
            if (this.encrypt) {
                byte[] bArr = new byte[16];
                new java.util.Random().nextBytes(bArr);
                dataOutputStream.write(bArr);
                try {
                    this.cipher.init(1, this.secretKeySpec, new javax.crypto.spec.IvParameterSpec(bArr));
                    dataOutputStream.flush();
                    dataOutputStream = new java.io.DataOutputStream(new javax.crypto.CipherOutputStream(this.bufferedOutputStream, this.cipher));
                } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException e2) {
                    throw new java.lang.IllegalStateException(e2);
                }
            }
            dataOutputStream.writeInt(this.keyToContent.size());
            for (com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent : this.keyToContent.values()) {
                cachedContent.writeToStream(dataOutputStream);
                iHeaderHashCode += cachedContent.headerHashCode(2);
            }
            dataOutputStream.writeInt(iHeaderHashCode);
            this.atomicFile.endWrite(dataOutputStream);
            com.google.android.exoplayer2.util.Util.closeQuietly((java.io.Closeable) null);
        } catch (java.io.IOException e3) {
            e_renamed = e3;
            throw new com.google.android.exoplayer2.upstream.cache.Cache.CacheException(e_renamed);
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.google.android.exoplayer2.util.Util.closeQuietly(dataOutputStream);
            throw th;
        }
    }

    private com.google.android.exoplayer2.upstream.cache.CachedContent addNew(java.lang.String str) {
        com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent = new com.google.android.exoplayer2.upstream.cache.CachedContent(getNewId(this.idToKey), str);
        add(cachedContent);
        this.changed = true;
        return cachedContent;
    }

    private void add(com.google.android.exoplayer2.upstream.cache.CachedContent cachedContent) {
        this.keyToContent.put(cachedContent.key, cachedContent);
        this.idToKey.put(cachedContent.id_renamed, cachedContent.key);
    }

    private static javax.crypto.Cipher getCipher() throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException {
        if (com.google.android.exoplayer2.util.Util.SDK_INT == 18) {
            try {
                return javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (java.lang.Throwable unused) {
            }
        }
        return javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public static int getNewId(android.util.SparseArray<java.lang.String> sparseArray) {
        int size = sparseArray.size();
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            iKeyAt = 0;
            while (iKeyAt < size && iKeyAt == sparseArray.keyAt(iKeyAt)) {
                iKeyAt++;
            }
        }
        return iKeyAt;
    }
}
