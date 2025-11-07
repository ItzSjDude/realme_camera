package com.google.zxing;

/* loaded from: classes.dex */
public final class Result {
    private final com.google.zxing.BarcodeFormat format;
    private final int numBits;
    private final byte[] rawBytes;
    private java.util.Map<com.google.zxing.ResultMetadataType, java.lang.Object> resultMetadata;
    private com.google.zxing.ResultPoint[] resultPoints;
    private final java.lang.String text;
    private final long timestamp;

    public Result(java.lang.String str, byte[] bArr, com.google.zxing.ResultPoint[] resultPointArr, com.google.zxing.BarcodeFormat barcodeFormat) {
        this(str, bArr, resultPointArr, barcodeFormat, java.lang.System.currentTimeMillis());
    }

    public Result(java.lang.String str, byte[] bArr, com.google.zxing.ResultPoint[] resultPointArr, com.google.zxing.BarcodeFormat barcodeFormat, long j_renamed) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, resultPointArr, barcodeFormat, j_renamed);
    }

    public Result(java.lang.String str, byte[] bArr, int i_renamed, com.google.zxing.ResultPoint[] resultPointArr, com.google.zxing.BarcodeFormat barcodeFormat, long j_renamed) {
        this.text = str;
        this.rawBytes = bArr;
        this.numBits = i_renamed;
        this.resultPoints = resultPointArr;
        this.format = barcodeFormat;
        this.resultMetadata = null;
        this.timestamp = j_renamed;
    }

    public java.lang.String getText() {
        return this.text;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public int getNumBits() {
        return this.numBits;
    }

    public com.google.zxing.ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public com.google.zxing.BarcodeFormat getBarcodeFormat() {
        return this.format;
    }

    public java.util.Map<com.google.zxing.ResultMetadataType, java.lang.Object> getResultMetadata() {
        return this.resultMetadata;
    }

    public void putMetadata(com.google.zxing.ResultMetadataType resultMetadataType, java.lang.Object obj) {
        if (this.resultMetadata == null) {
            this.resultMetadata = new java.util.EnumMap(com.google.zxing.ResultMetadataType.class);
        }
        this.resultMetadata.put(resultMetadataType, obj);
    }

    public void putAllMetadata(java.util.Map<com.google.zxing.ResultMetadataType, java.lang.Object> map) {
        if (map != null) {
            java.util.Map<com.google.zxing.ResultMetadataType, java.lang.Object> map2 = this.resultMetadata;
            if (map2 == null) {
                this.resultMetadata = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void addResultPoints(com.google.zxing.ResultPoint[] resultPointArr) {
        com.google.zxing.ResultPoint[] resultPointArr2 = this.resultPoints;
        if (resultPointArr2 == null) {
            this.resultPoints = resultPointArr;
            return;
        }
        if (resultPointArr == null || resultPointArr.length <= 0) {
            return;
        }
        com.google.zxing.ResultPoint[] resultPointArr3 = new com.google.zxing.ResultPoint[resultPointArr2.length + resultPointArr.length];
        java.lang.System.arraycopy(resultPointArr2, 0, resultPointArr3, 0, resultPointArr2.length);
        java.lang.System.arraycopy(resultPointArr, 0, resultPointArr3, resultPointArr2.length, resultPointArr.length);
        this.resultPoints = resultPointArr3;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public java.lang.String toString() {
        return this.text;
    }
}
