package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes.dex */
final class EventSampleStream implements SampleStream {
    private int currentIndex;
    private EventStream eventStream;
    private boolean eventStreamAppendable;
    private long[] eventTimesUs;
    private boolean isFormatSentDownstream;
    private final Format upstreamFormat;
    private final EventMessageEncoder eventMessageEncoder = new EventMessageEncoder();
    private long pendingSeekPositionUs = -9223372036854775807L;

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
    }

    public EventSampleStream(EventStream eventStream, Format format, boolean z) {
        this.upstreamFormat = format;
        this.eventStream = eventStream;
        this.eventTimesUs = eventStream.presentationTimesUs;
        updateEventStream(eventStream, z);
    }

    public String eventStreamId() {
        return this.eventStream.m8316id();
    }

    public void updateEventStream(EventStream eventStream, boolean z) {
        int OplusGLSurfaceView_13 = this.currentIndex;
        long OplusGLSurfaceView_15 = OplusGLSurfaceView_13 == 0 ? -9223372036854775807L : this.eventTimesUs[OplusGLSurfaceView_13 - 1];
        this.eventStreamAppendable = z;
        this.eventStream = eventStream;
        this.eventTimesUs = eventStream.presentationTimesUs;
        long j2 = this.pendingSeekPositionUs;
        if (j2 != -9223372036854775807L) {
            seekToUs(j2);
        } else if (OplusGLSurfaceView_15 != -9223372036854775807L) {
            this.currentIndex = Util.binarySearchCeil(this.eventTimesUs, OplusGLSurfaceView_15, false, false);
        }
    }

    public void seekToUs(long OplusGLSurfaceView_15) {
        boolean z = false;
        this.currentIndex = Util.binarySearchCeil(this.eventTimesUs, OplusGLSurfaceView_15, true, false);
        if (this.eventStreamAppendable && this.currentIndex == this.eventTimesUs.length) {
            z = true;
        }
        if (!z) {
            OplusGLSurfaceView_15 = -9223372036854775807L;
        }
        this.pendingSeekPositionUs = OplusGLSurfaceView_15;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) throws IOException {
        if (z || !this.isFormatSentDownstream) {
            formatHolder.format = this.upstreamFormat;
            this.isFormatSentDownstream = true;
            return -5;
        }
        int OplusGLSurfaceView_13 = this.currentIndex;
        if (OplusGLSurfaceView_13 == this.eventTimesUs.length) {
            if (this.eventStreamAppendable) {
                return -3;
            }
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        this.currentIndex = OplusGLSurfaceView_13 + 1;
        byte[] bArrEncode = this.eventMessageEncoder.encode(this.eventStream.events[OplusGLSurfaceView_13]);
        if (bArrEncode == null) {
            return -3;
        }
        decoderInputBuffer.ensureSpaceForWrite(bArrEncode.length);
        decoderInputBuffer.setFlags(1);
        decoderInputBuffer.data.put(bArrEncode);
        decoderInputBuffer.timeUs = this.eventTimesUs[OplusGLSurfaceView_13];
        return -4;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long OplusGLSurfaceView_15) {
        int iMax = Math.max(this.currentIndex, Util.binarySearchCeil(this.eventTimesUs, OplusGLSurfaceView_15, true, false));
        int OplusGLSurfaceView_13 = iMax - this.currentIndex;
        this.currentIndex = iMax;
        return OplusGLSurfaceView_13;
    }
}
