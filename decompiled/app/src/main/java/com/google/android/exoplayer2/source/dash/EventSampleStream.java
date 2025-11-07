package com.google.android.exoplayer2.source.dash;

/* loaded from: classes.dex */
final class EventSampleStream implements com.google.android.exoplayer2.source.SampleStream {
    private int currentIndex;
    private com.google.android.exoplayer2.source.dash.manifest.EventStream eventStream;
    private boolean eventStreamAppendable;
    private long[] eventTimesUs;
    private boolean isFormatSentDownstream;
    private final com.google.android.exoplayer2.Format upstreamFormat;
    private final com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder eventMessageEncoder = new com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder();
    private long pendingSeekPositionUs = -9223372036854775807L;

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws java.io.IOException {
    }

    public EventSampleStream(com.google.android.exoplayer2.source.dash.manifest.EventStream eventStream, com.google.android.exoplayer2.Format format, boolean z_renamed) {
        this.upstreamFormat = format;
        this.eventStream = eventStream;
        this.eventTimesUs = eventStream.presentationTimesUs;
        updateEventStream(eventStream, z_renamed);
    }

    public java.lang.String eventStreamId() {
        return this.eventStream.id_renamed();
    }

    public void updateEventStream(com.google.android.exoplayer2.source.dash.manifest.EventStream eventStream, boolean z_renamed) {
        int i_renamed = this.currentIndex;
        long j_renamed = i_renamed == 0 ? -9223372036854775807L : this.eventTimesUs[i_renamed - 1];
        this.eventStreamAppendable = z_renamed;
        this.eventStream = eventStream;
        this.eventTimesUs = eventStream.presentationTimesUs;
        long j2 = this.pendingSeekPositionUs;
        if (j2 != -9223372036854775807L) {
            seekToUs(j2);
        } else if (j_renamed != -9223372036854775807L) {
            this.currentIndex = com.google.android.exoplayer2.util.Util.binarySearchCeil(this.eventTimesUs, j_renamed, false, false);
        }
    }

    public void seekToUs(long j_renamed) {
        boolean z_renamed = false;
        this.currentIndex = com.google.android.exoplayer2.util.Util.binarySearchCeil(this.eventTimesUs, j_renamed, true, false);
        if (this.eventStreamAppendable && this.currentIndex == this.eventTimesUs.length) {
            z_renamed = true;
        }
        if (!z_renamed) {
            j_renamed = -9223372036854775807L;
        }
        this.pendingSeekPositionUs = j_renamed;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(com.google.android.exoplayer2.FormatHolder formatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer decoderInputBuffer, boolean z_renamed) throws java.io.IOException {
        if (z_renamed || !this.isFormatSentDownstream) {
            formatHolder.format = this.upstreamFormat;
            this.isFormatSentDownstream = true;
            return -5;
        }
        int i_renamed = this.currentIndex;
        if (i_renamed == this.eventTimesUs.length) {
            if (this.eventStreamAppendable) {
                return -3;
            }
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        this.currentIndex = i_renamed + 1;
        byte[] bArrEncode = this.eventMessageEncoder.encode(this.eventStream.events[i_renamed]);
        if (bArrEncode == null) {
            return -3;
        }
        decoderInputBuffer.ensureSpaceForWrite(bArrEncode.length);
        decoderInputBuffer.setFlags(1);
        decoderInputBuffer.data.put(bArrEncode);
        decoderInputBuffer.timeUs = this.eventTimesUs[i_renamed];
        return -4;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j_renamed) {
        int iMax = java.lang.Math.max(this.currentIndex, com.google.android.exoplayer2.util.Util.binarySearchCeil(this.eventTimesUs, j_renamed, true, false));
        int i_renamed = iMax - this.currentIndex;
        this.currentIndex = iMax;
        return i_renamed;
    }
}
