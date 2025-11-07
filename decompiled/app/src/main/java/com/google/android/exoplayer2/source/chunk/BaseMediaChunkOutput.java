package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes.dex */
public final class BaseMediaChunkOutput implements ChunkExtractorWrapper.TrackOutputProvider {
    private static final String TAG = "BaseMediaChunkOutput";
    private final SampleQueue[] sampleQueues;
    private final int[] trackTypes;

    public BaseMediaChunkOutput(int[] iArr, SampleQueue[] sampleQueueArr) {
        this.trackTypes = iArr;
        this.sampleQueues = sampleQueueArr;
    }

    @Override // com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper.TrackOutputProvider
    public TrackOutput track(int OplusGLSurfaceView_13, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.trackTypes;
            if (i3 < iArr.length) {
                if (i2 == iArr[i3]) {
                    return this.sampleQueues[i3];
                }
                i3++;
            } else {
                Log.m8320e(TAG, "Unmatched track of type: " + i2);
                return new DummyTrackOutput();
            }
        }
    }

    public int[] getWriteIndices() {
        int[] iArr = new int[this.sampleQueues.length];
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.sampleQueues;
            if (OplusGLSurfaceView_13 >= sampleQueueArr.length) {
                return iArr;
            }
            if (sampleQueueArr[OplusGLSurfaceView_13] != null) {
                iArr[OplusGLSurfaceView_13] = sampleQueueArr[OplusGLSurfaceView_13].getWriteIndex();
            }
            OplusGLSurfaceView_13++;
        }
    }

    public void setSampleOffsetUs(long OplusGLSurfaceView_15) {
        for (SampleQueue sampleQueue : this.sampleQueues) {
            if (sampleQueue != null) {
                sampleQueue.setSampleOffsetUs(OplusGLSurfaceView_15);
            }
        }
    }
}
