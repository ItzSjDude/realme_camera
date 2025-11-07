package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public final class DefaultContentMetadata implements com.google.android.exoplayer2.upstream.cache.ContentMetadata {
    public static final com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata EMPTY = new com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata(java.util.Collections.emptyMap());
    private static final int MAX_VALUE_LENGTH = 10485760;
    private int hashCode;
    private final java.util.Map<java.lang.String, byte[]> metadata;

    public static com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata readFromStream(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        int i_renamed = dataInputStream.readInt();
        java.util.HashMap map = new java.util.HashMap();
        for (int i2 = 0; i2 < i_renamed; i2++) {
            java.lang.String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 < 0 || i3 > MAX_VALUE_LENGTH) {
                throw new java.io.IOException("Invalid value size: " + i3);
            }
            byte[] bArr = new byte[i3];
            dataInputStream.readFully(bArr);
            map.put(utf, bArr);
        }
        return new com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata(map);
    }

    private DefaultContentMetadata(java.util.Map<java.lang.String, byte[]> map) {
        this.metadata = java.util.Collections.unmodifiableMap(map);
    }

    public com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata copyWithMutationsApplied(com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) {
        java.util.Map<java.lang.String, byte[]> mapApplyMutations = applyMutations(this.metadata, contentMetadataMutations);
        return isMetadataEqual(mapApplyMutations) ? this : new com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata(mapApplyMutations);
    }

    public void writeToStream(java.io.DataOutputStream dataOutputStream) throws java.io.IOException {
        dataOutputStream.writeInt(this.metadata.size());
        for (java.util.Map.Entry<java.lang.String, byte[]> entry : this.metadata.entrySet()) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final byte[] get(java.lang.String str, byte[] bArr) {
        if (!this.metadata.containsKey(str)) {
            return bArr;
        }
        byte[] bArr2 = this.metadata.get(str);
        return java.util.Arrays.copyOf(bArr2, bArr2.length);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final java.lang.String get(java.lang.String str, java.lang.String str2) {
        return this.metadata.containsKey(str) ? new java.lang.String(this.metadata.get(str), java.nio.charset.Charset.forName("UTF-8")) : str2;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final long get(java.lang.String str, long j_renamed) {
        return this.metadata.containsKey(str) ? java.nio.ByteBuffer.wrap(this.metadata.get(str)).getLong() : j_renamed;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.ContentMetadata
    public final boolean contains(java.lang.String str) {
        return this.metadata.containsKey(str);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return isMetadataEqual(((com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata) obj).metadata);
    }

    private boolean isMetadataEqual(java.util.Map<java.lang.String, byte[]> map) {
        if (this.metadata.size() != map.size()) {
            return false;
        }
        for (java.util.Map.Entry<java.lang.String, byte[]> entry : this.metadata.entrySet()) {
            if (!java.util.Arrays.equals(entry.getValue(), map.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            int iHashCode = 0;
            for (java.util.Map.Entry<java.lang.String, byte[]> entry : this.metadata.entrySet()) {
                iHashCode += java.util.Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.hashCode = iHashCode;
        }
        return this.hashCode;
    }

    private static java.util.Map<java.lang.String, byte[]> applyMutations(java.util.Map<java.lang.String, byte[]> map, com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations contentMetadataMutations) {
        java.util.HashMap map2 = new java.util.HashMap(map);
        removeValues(map2, contentMetadataMutations.getRemovedValues());
        addValues(map2, contentMetadataMutations.getEditedValues());
        return map2;
    }

    private static void removeValues(java.util.HashMap<java.lang.String, byte[]> map, java.util.List<java.lang.String> list) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            map.remove(list.get(i_renamed));
        }
    }

    private static void addValues(java.util.HashMap<java.lang.String, byte[]> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        for (java.lang.String str : map2.keySet()) {
            byte[] bytes = getBytes(map2.get(str));
            if (bytes.length > MAX_VALUE_LENGTH) {
                throw new java.lang.IllegalArgumentException("The size of_renamed " + str + " (" + bytes.length + ") is_renamed greater than maximum allowed: " + MAX_VALUE_LENGTH);
            }
            map.put(str, bytes);
        }
    }

    private static byte[] getBytes(java.lang.Object obj) {
        if (obj instanceof java.lang.Long) {
            return java.nio.ByteBuffer.allocate(8).putLong(((java.lang.Long) obj).longValue()).array();
        }
        if (obj instanceof java.lang.String) {
            return ((java.lang.String) obj).getBytes(java.nio.charset.Charset.forName("UTF-8"));
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new java.lang.IllegalArgumentException();
    }
}
