package com.google.android.exoplayer2.source;

/* loaded from: classes.dex */
public class CompositeSequenceableLoader implements com.google.android.exoplayer2.source.SequenceableLoader {
    protected final com.google.android.exoplayer2.source.SequenceableLoader[] loaders;

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getLargestQueuedTimeUsByType(int i_renamed) {
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextKeyFramePositionUs(long j_renamed) {
        return 0L;
    }

    public CompositeSequenceableLoader(com.google.android.exoplayer2.source.SequenceableLoader[] sequenceableLoaderArr) {
        this.loaders = sequenceableLoaderArr;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (com.google.android.exoplayer2.source.SequenceableLoader sequenceableLoader : this.loaders) {
            long bufferedPositionUs = sequenceableLoader.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                jMin = java.lang.Math.min(jMin, bufferedPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (com.google.android.exoplayer2.source.SequenceableLoader sequenceableLoader : this.loaders) {
            long nextLoadPositionUs = sequenceableLoader.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                jMin = java.lang.Math.min(jMin, nextLoadPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long j_renamed) {
        for (com.google.android.exoplayer2.source.SequenceableLoader sequenceableLoader : this.loaders) {
            sequenceableLoader.reevaluateBuffer(j_renamed);
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j_renamed) {
        boolean zContinueLoading;
        boolean z_renamed = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            zContinueLoading = false;
            for (com.google.android.exoplayer2.source.SequenceableLoader sequenceableLoader : this.loaders) {
                long nextLoadPositionUs2 = sequenceableLoader.getNextLoadPositionUs();
                boolean z2 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= j_renamed;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z2) {
                    zContinueLoading |= sequenceableLoader.continueLoading(j_renamed);
                }
            }
            z_renamed |= zContinueLoading;
        } while (zContinueLoading);
        return z_renamed;
    }
}
