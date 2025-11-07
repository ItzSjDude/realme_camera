package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes.dex */
public class ContentMetadataMutations {
    private final java.util.Map<java.lang.String, java.lang.Object> editedValues = new java.util.HashMap();
    private final java.util.List<java.lang.String> removedValues = new java.util.ArrayList();

    public com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations set(java.lang.String str, java.lang.String str2) {
        return checkAndSet(str, str2);
    }

    public com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations set(java.lang.String str, long j_renamed) {
        return checkAndSet(str, java.lang.Long.valueOf(j_renamed));
    }

    public com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations set(java.lang.String str, byte[] bArr) {
        return checkAndSet(str, java.util.Arrays.copyOf(bArr, bArr.length));
    }

    public com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations remove(java.lang.String str) {
        this.removedValues.add(str);
        this.editedValues.remove(str);
        return this;
    }

    public java.util.List<java.lang.String> getRemovedValues() {
        return java.util.Collections.unmodifiableList(new java.util.ArrayList(this.removedValues));
    }

    public java.util.Map<java.lang.String, java.lang.Object> getEditedValues() {
        java.util.HashMap map = new java.util.HashMap(this.editedValues);
        for (java.util.Map.Entry entry : map.entrySet()) {
            java.lang.Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(java.util.Arrays.copyOf(bArr, bArr.length));
            }
        }
        return java.util.Collections.unmodifiableMap(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations checkAndSet(java.lang.String str, java.lang.Object obj) {
        this.editedValues.put(com.google.android.exoplayer2.util.Assertions.checkNotNull(str), com.google.android.exoplayer2.util.Assertions.checkNotNull(obj));
        this.removedValues.remove(str);
        return this;
    }
}
