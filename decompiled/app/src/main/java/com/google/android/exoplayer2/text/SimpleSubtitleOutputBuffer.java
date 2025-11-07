package com.google.android.exoplayer2.text;

/* loaded from: classes.dex */
final class SimpleSubtitleOutputBuffer extends com.google.android.exoplayer2.text.SubtitleOutputBuffer {
    private final com.google.android.exoplayer2.text.SimpleSubtitleDecoder owner;

    public SimpleSubtitleOutputBuffer(com.google.android.exoplayer2.text.SimpleSubtitleDecoder simpleSubtitleDecoder) {
        this.owner = simpleSubtitleDecoder;
    }

    @Override // com.google.android.exoplayer2.text.SubtitleOutputBuffer, com.google.android.exoplayer2.decoder.OutputBuffer
    public final void release() {
        this.owner.releaseOutputBuffer((com.google.android.exoplayer2.text.SubtitleOutputBuffer) this);
    }
}
