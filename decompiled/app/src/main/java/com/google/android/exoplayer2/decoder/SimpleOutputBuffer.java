package com.google.android.exoplayer2.decoder;

/* loaded from: classes.dex */
public class SimpleOutputBuffer extends com.google.android.exoplayer2.decoder.OutputBuffer {
    public java.nio.ByteBuffer data;
    private final com.google.android.exoplayer2.decoder.SimpleDecoder<?, com.google.android.exoplayer2.decoder.SimpleOutputBuffer, ?> owner;

    public SimpleOutputBuffer(com.google.android.exoplayer2.decoder.SimpleDecoder<?, com.google.android.exoplayer2.decoder.SimpleOutputBuffer, ?> simpleDecoder) {
        this.owner = simpleDecoder;
    }

    public java.nio.ByteBuffer init(long j_renamed, int i_renamed) {
        this.timeUs = j_renamed;
        java.nio.ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null || byteBuffer.capacity() < i_renamed) {
            this.data = java.nio.ByteBuffer.allocateDirect(i_renamed).order(java.nio.ByteOrder.nativeOrder());
        }
        this.data.position(0);
        this.data.limit(i_renamed);
        return this.data;
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        java.nio.ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public void release() {
        this.owner.releaseOutputBuffer(this);
    }
}
