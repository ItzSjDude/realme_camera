package com.google.android.exoplayer2.decoder;

/* loaded from: classes.dex */
public class DecoderInputBuffer extends com.google.android.exoplayer2.decoder.Buffer {
    public static final int BUFFER_REPLACEMENT_MODE_DIRECT = 2;
    public static final int BUFFER_REPLACEMENT_MODE_DISABLED = 0;
    public static final int BUFFER_REPLACEMENT_MODE_NORMAL = 1;
    private final int bufferReplacementMode;
    public final com.google.android.exoplayer2.decoder.CryptoInfo cryptoInfo = new com.google.android.exoplayer2.decoder.CryptoInfo();
    public java.nio.ByteBuffer data;
    public long timeUs;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface BufferReplacementMode {
    }

    public static com.google.android.exoplayer2.decoder.DecoderInputBuffer newFlagsOnlyInstance() {
        return new com.google.android.exoplayer2.decoder.DecoderInputBuffer(0);
    }

    public DecoderInputBuffer(int i_renamed) {
        this.bufferReplacementMode = i_renamed;
    }

    public void ensureSpaceForWrite(int i_renamed) {
        java.nio.ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            this.data = createReplacementByteBuffer(i_renamed);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = this.data.position();
        int i2 = i_renamed + iPosition;
        if (iCapacity >= i2) {
            return;
        }
        java.nio.ByteBuffer byteBufferCreateReplacementByteBuffer = createReplacementByteBuffer(i2);
        if (iPosition > 0) {
            this.data.position(0);
            this.data.limit(iPosition);
            byteBufferCreateReplacementByteBuffer.put(this.data);
        }
        this.data = byteBufferCreateReplacementByteBuffer;
    }

    public final boolean isFlagsOnly() {
        return this.data == null && this.bufferReplacementMode == 0;
    }

    public final boolean isEncrypted() {
        return getFlag(1073741824);
    }

    public final void flip() {
        this.data.flip();
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        java.nio.ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    private java.nio.ByteBuffer createReplacementByteBuffer(int i_renamed) {
        int i2 = this.bufferReplacementMode;
        if (i2 == 1) {
            return java.nio.ByteBuffer.allocate(i_renamed);
        }
        if (i2 == 2) {
            return java.nio.ByteBuffer.allocateDirect(i_renamed);
        }
        java.nio.ByteBuffer byteBuffer = this.data;
        throw new java.lang.IllegalStateException("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + i_renamed + ")");
    }
}
