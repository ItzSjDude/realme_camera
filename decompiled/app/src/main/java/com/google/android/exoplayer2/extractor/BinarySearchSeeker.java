package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class BinarySearchSeeker {
    private static final long MAX_SKIP_BYTES = 262144;
    private final int minimumSearchRange;
    protected final BinarySearchSeekMap seekMap;
    protected SeekOperationParams seekOperationParams;
    protected final TimestampSeeker timestampSeeker;

    public static final class DefaultSeekTimestampConverter implements SeekTimestampConverter {
        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
        public long timeUsToTargetTime(long OplusGLSurfaceView_15) {
            return OplusGLSurfaceView_15;
        }
    }

    protected interface SeekTimestampConverter {
        long timeUsToTargetTime(long OplusGLSurfaceView_15);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public interface TimestampSeeker {
        default void onSeekFinished() {
        }

        TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long OplusGLSurfaceView_15, OutputFrameHolder outputFrameHolder) throws InterruptedException, IOException;
    }

    protected void onSeekOperationFinished(boolean z, long OplusGLSurfaceView_15) {
    }

    public static final class OutputFrameHolder {
        public ByteBuffer byteBuffer;
        public long timeUs = 0;

        public OutputFrameHolder(ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
        }
    }

    protected BinarySearchSeeker(SeekTimestampConverter seekTimestampConverter, TimestampSeeker timestampSeeker, long OplusGLSurfaceView_15, long j2, long j3, long j4, long j5, long j6, int OplusGLSurfaceView_13) {
        this.timestampSeeker = timestampSeeker;
        this.minimumSearchRange = OplusGLSurfaceView_13;
        this.seekMap = new BinarySearchSeekMap(seekTimestampConverter, OplusGLSurfaceView_15, j2, j3, j4, j5, j6);
    }

    public final SeekMap getSeekMap() {
        return this.seekMap;
    }

    public final void setSeekTargetUs(long OplusGLSurfaceView_15) {
        SeekOperationParams seekOperationParams = this.seekOperationParams;
        if (seekOperationParams == null || seekOperationParams.getSeekTimeUs() != OplusGLSurfaceView_15) {
            this.seekOperationParams = createSeekParamsForTargetTimeUs(OplusGLSurfaceView_15);
        }
    }

    public final boolean isSeeking() {
        return this.seekOperationParams != null;
    }

    public int handlePendingSeek(ExtractorInput extractorInput, PositionHolder positionHolder, OutputFrameHolder outputFrameHolder) throws InterruptedException, IOException {
        TimestampSeeker timestampSeeker = (TimestampSeeker) Assertions.checkNotNull(this.timestampSeeker);
        while (true) {
            SeekOperationParams seekOperationParams = (SeekOperationParams) Assertions.checkNotNull(this.seekOperationParams);
            long floorBytePosition = seekOperationParams.getFloorBytePosition();
            long ceilingBytePosition = seekOperationParams.getCeilingBytePosition();
            long nextSearchBytePosition = seekOperationParams.getNextSearchBytePosition();
            if (ceilingBytePosition - floorBytePosition <= this.minimumSearchRange) {
                markSeekOperationFinished(false, floorBytePosition);
                return seekToPosition(extractorInput, floorBytePosition, positionHolder);
            }
            if (!skipInputUntilPosition(extractorInput, nextSearchBytePosition)) {
                return seekToPosition(extractorInput, nextSearchBytePosition, positionHolder);
            }
            extractorInput.resetPeekPosition();
            TimestampSearchResult timestampSearchResultSearchForTimestamp = timestampSeeker.searchForTimestamp(extractorInput, seekOperationParams.getTargetTimePosition(), outputFrameHolder);
            int OplusGLSurfaceView_13 = timestampSearchResultSearchForTimestamp.type;
            if (OplusGLSurfaceView_13 == -3) {
                markSeekOperationFinished(false, nextSearchBytePosition);
                return seekToPosition(extractorInput, nextSearchBytePosition, positionHolder);
            }
            if (OplusGLSurfaceView_13 == -2) {
                seekOperationParams.updateSeekFloor(timestampSearchResultSearchForTimestamp.timestampToUpdate, timestampSearchResultSearchForTimestamp.bytePositionToUpdate);
            } else {
                if (OplusGLSurfaceView_13 != -1) {
                    if (OplusGLSurfaceView_13 == 0) {
                        markSeekOperationFinished(true, timestampSearchResultSearchForTimestamp.bytePositionToUpdate);
                        skipInputUntilPosition(extractorInput, timestampSearchResultSearchForTimestamp.bytePositionToUpdate);
                        return seekToPosition(extractorInput, timestampSearchResultSearchForTimestamp.bytePositionToUpdate, positionHolder);
                    }
                    throw new IllegalStateException("Invalid case");
                }
                seekOperationParams.updateSeekCeiling(timestampSearchResultSearchForTimestamp.timestampToUpdate, timestampSearchResultSearchForTimestamp.bytePositionToUpdate);
            }
        }
    }

    protected SeekOperationParams createSeekParamsForTargetTimeUs(long OplusGLSurfaceView_15) {
        return new SeekOperationParams(OplusGLSurfaceView_15, this.seekMap.timeUsToTargetTime(OplusGLSurfaceView_15), this.seekMap.floorTimePosition, this.seekMap.ceilingTimePosition, this.seekMap.floorBytePosition, this.seekMap.ceilingBytePosition, this.seekMap.approxBytesPerFrame);
    }

    protected final void markSeekOperationFinished(boolean z, long OplusGLSurfaceView_15) {
        this.seekOperationParams = null;
        this.timestampSeeker.onSeekFinished();
        onSeekOperationFinished(z, OplusGLSurfaceView_15);
    }

    protected final boolean skipInputUntilPosition(ExtractorInput extractorInput, long OplusGLSurfaceView_15) throws InterruptedException, IOException {
        long position = OplusGLSurfaceView_15 - extractorInput.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        extractorInput.skipFully((int) position);
        return true;
    }

    protected final int seekToPosition(ExtractorInput extractorInput, long OplusGLSurfaceView_15, PositionHolder positionHolder) {
        if (OplusGLSurfaceView_15 == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.position = OplusGLSurfaceView_15;
        return 1;
    }

    protected static class SeekOperationParams {
        private final long approxBytesPerFrame;
        private long ceilingBytePosition;
        private long ceilingTimePosition;
        private long floorBytePosition;
        private long floorTimePosition;
        private long nextSearchBytePosition;
        private final long seekTimeUs;
        private final long targetTimePosition;

        protected static long calculateNextSearchBytePosition(long OplusGLSurfaceView_15, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((OplusGLSurfaceView_15 - j2) * ((j5 - j4) / (j3 - j2)));
            return Util.constrainValue(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }

        protected SeekOperationParams(long OplusGLSurfaceView_15, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.seekTimeUs = OplusGLSurfaceView_15;
            this.targetTimePosition = j2;
            this.floorTimePosition = j3;
            this.ceilingTimePosition = j4;
            this.floorBytePosition = j5;
            this.ceilingBytePosition = j6;
            this.approxBytesPerFrame = j7;
            this.nextSearchBytePosition = calculateNextSearchBytePosition(j2, j3, j4, j5, j6, j7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getFloorBytePosition() {
            return this.floorBytePosition;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getCeilingBytePosition() {
            return this.ceilingBytePosition;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getTargetTimePosition() {
            return this.targetTimePosition;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getSeekTimeUs() {
            return this.seekTimeUs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateSeekFloor(long OplusGLSurfaceView_15, long j2) {
            this.floorTimePosition = OplusGLSurfaceView_15;
            this.floorBytePosition = j2;
            updateNextSearchBytePosition();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateSeekCeiling(long OplusGLSurfaceView_15, long j2) {
            this.ceilingTimePosition = OplusGLSurfaceView_15;
            this.ceilingBytePosition = j2;
            updateNextSearchBytePosition();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getNextSearchBytePosition() {
            return this.nextSearchBytePosition;
        }

        private void updateNextSearchBytePosition() {
            this.nextSearchBytePosition = calculateNextSearchBytePosition(this.targetTimePosition, this.floorTimePosition, this.ceilingTimePosition, this.floorBytePosition, this.ceilingBytePosition, this.approxBytesPerFrame);
        }
    }

    public static final class TimestampSearchResult {
        public static final TimestampSearchResult NO_TIMESTAMP_IN_RANGE_RESULT = new TimestampSearchResult(-3, -9223372036854775807L, -1);
        public static final int TYPE_NO_TIMESTAMP = -3;
        public static final int TYPE_POSITION_OVERESTIMATED = -1;
        public static final int TYPE_POSITION_UNDERESTIMATED = -2;
        public static final int TYPE_TARGET_TIMESTAMP_FOUND = 0;
        private final long bytePositionToUpdate;
        private final long timestampToUpdate;
        private final int type;

        private TimestampSearchResult(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) {
            this.type = OplusGLSurfaceView_13;
            this.timestampToUpdate = OplusGLSurfaceView_15;
            this.bytePositionToUpdate = j2;
        }

        public static TimestampSearchResult overestimatedResult(long OplusGLSurfaceView_15, long j2) {
            return new TimestampSearchResult(-1, OplusGLSurfaceView_15, j2);
        }

        public static TimestampSearchResult underestimatedResult(long OplusGLSurfaceView_15, long j2) {
            return new TimestampSearchResult(-2, OplusGLSurfaceView_15, j2);
        }

        public static TimestampSearchResult targetFoundResult(long OplusGLSurfaceView_15) {
            return new TimestampSearchResult(0, -9223372036854775807L, OplusGLSurfaceView_15);
        }
    }

    public static class BinarySearchSeekMap implements SeekMap {
        private final long approxBytesPerFrame;
        private final long ceilingBytePosition;
        private final long ceilingTimePosition;
        private final long durationUs;
        private final long floorBytePosition;
        private final long floorTimePosition;
        private final SeekTimestampConverter seekTimestampConverter;

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        public BinarySearchSeekMap(SeekTimestampConverter seekTimestampConverter, long OplusGLSurfaceView_15, long j2, long j3, long j4, long j5, long j6) {
            this.seekTimestampConverter = seekTimestampConverter;
            this.durationUs = OplusGLSurfaceView_15;
            this.floorTimePosition = j2;
            this.ceilingTimePosition = j3;
            this.floorBytePosition = j4;
            this.ceilingBytePosition = j5;
            this.approxBytesPerFrame = j6;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long OplusGLSurfaceView_15) {
            return new SeekMap.SeekPoints(new SeekPoint(OplusGLSurfaceView_15, SeekOperationParams.calculateNextSearchBytePosition(this.seekTimestampConverter.timeUsToTargetTime(OplusGLSurfaceView_15), this.floorTimePosition, this.ceilingTimePosition, this.floorBytePosition, this.ceilingBytePosition, this.approxBytesPerFrame)));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        public long timeUsToTargetTime(long OplusGLSurfaceView_15) {
            return this.seekTimestampConverter.timeUsToTargetTime(OplusGLSurfaceView_15);
        }
    }
}
