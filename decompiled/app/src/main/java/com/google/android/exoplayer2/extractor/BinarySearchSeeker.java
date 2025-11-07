package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public abstract class BinarySearchSeeker {
    private static final long MAX_SKIP_BYTES = 262144;
    private final int minimumSearchRange;
    protected final com.google.android.exoplayer2.extractor.BinarySearchSeeker.BinarySearchSeekMap seekMap;
    protected com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams seekOperationParams;
    protected final com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker timestampSeeker;

    public static final class DefaultSeekTimestampConverter implements com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter {
        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter
        public long timeUsToTargetTime(long j_renamed) {
            return j_renamed;
        }
    }

    protected interface SeekTimestampConverter {
        long timeUsToTargetTime(long j_renamed);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public interface TimestampSeeker {
        default void onSeekFinished() {
        }

        com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult searchForTimestamp(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j_renamed, com.google.android.exoplayer2.extractor.BinarySearchSeeker.OutputFrameHolder outputFrameHolder) throws java.lang.InterruptedException, java.io.IOException;
    }

    protected void onSeekOperationFinished(boolean z_renamed, long j_renamed) {
    }

    public static final class OutputFrameHolder {
        public java.nio.ByteBuffer byteBuffer;
        public long timeUs = 0;

        public OutputFrameHolder(java.nio.ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
        }
    }

    protected BinarySearchSeeker(com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter seekTimestampConverter, com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker timestampSeeker, long j_renamed, long j2, long j3, long j4, long j5, long j6, int i_renamed) {
        this.timestampSeeker = timestampSeeker;
        this.minimumSearchRange = i_renamed;
        this.seekMap = new com.google.android.exoplayer2.extractor.BinarySearchSeeker.BinarySearchSeekMap(seekTimestampConverter, j_renamed, j2, j3, j4, j5, j6);
    }

    public final com.google.android.exoplayer2.extractor.SeekMap getSeekMap() {
        return this.seekMap;
    }

    public final void setSeekTargetUs(long j_renamed) {
        com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams seekOperationParams = this.seekOperationParams;
        if (seekOperationParams == null || seekOperationParams.getSeekTimeUs() != j_renamed) {
            this.seekOperationParams = createSeekParamsForTargetTimeUs(j_renamed);
        }
    }

    public final boolean isSeeking() {
        return this.seekOperationParams != null;
    }

    public int handlePendingSeek(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder, com.google.android.exoplayer2.extractor.BinarySearchSeeker.OutputFrameHolder outputFrameHolder) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker timestampSeeker = (com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.timestampSeeker);
        while (true) {
            com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams seekOperationParams = (com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.seekOperationParams);
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
            com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult timestampSearchResultSearchForTimestamp = timestampSeeker.searchForTimestamp(extractorInput, seekOperationParams.getTargetTimePosition(), outputFrameHolder);
            int i_renamed = timestampSearchResultSearchForTimestamp.type;
            if (i_renamed == -3) {
                markSeekOperationFinished(false, nextSearchBytePosition);
                return seekToPosition(extractorInput, nextSearchBytePosition, positionHolder);
            }
            if (i_renamed == -2) {
                seekOperationParams.updateSeekFloor(timestampSearchResultSearchForTimestamp.timestampToUpdate, timestampSearchResultSearchForTimestamp.bytePositionToUpdate);
            } else {
                if (i_renamed != -1) {
                    if (i_renamed == 0) {
                        markSeekOperationFinished(true, timestampSearchResultSearchForTimestamp.bytePositionToUpdate);
                        skipInputUntilPosition(extractorInput, timestampSearchResultSearchForTimestamp.bytePositionToUpdate);
                        return seekToPosition(extractorInput, timestampSearchResultSearchForTimestamp.bytePositionToUpdate, positionHolder);
                    }
                    throw new java.lang.IllegalStateException("Invalid case");
                }
                seekOperationParams.updateSeekCeiling(timestampSearchResultSearchForTimestamp.timestampToUpdate, timestampSearchResultSearchForTimestamp.bytePositionToUpdate);
            }
        }
    }

    protected com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams createSeekParamsForTargetTimeUs(long j_renamed) {
        return new com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams(j_renamed, this.seekMap.timeUsToTargetTime(j_renamed), this.seekMap.floorTimePosition, this.seekMap.ceilingTimePosition, this.seekMap.floorBytePosition, this.seekMap.ceilingBytePosition, this.seekMap.approxBytesPerFrame);
    }

    protected final void markSeekOperationFinished(boolean z_renamed, long j_renamed) {
        this.seekOperationParams = null;
        this.timestampSeeker.onSeekFinished();
        onSeekOperationFinished(z_renamed, j_renamed);
    }

    protected final boolean skipInputUntilPosition(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j_renamed) throws java.lang.InterruptedException, java.io.IOException {
        long position = j_renamed - extractorInput.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        extractorInput.skipFully((int) position);
        return true;
    }

    protected final int seekToPosition(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j_renamed, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) {
        if (j_renamed == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.position = j_renamed;
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

        protected static long calculateNextSearchBytePosition(long j_renamed, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j_renamed - j2) * ((j5 - j4) / (j3 - j2)));
            return com.google.android.exoplayer2.util.Util.constrainValue(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }

        protected SeekOperationParams(long j_renamed, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.seekTimeUs = j_renamed;
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
        public void updateSeekFloor(long j_renamed, long j2) {
            this.floorTimePosition = j_renamed;
            this.floorBytePosition = j2;
            updateNextSearchBytePosition();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateSeekCeiling(long j_renamed, long j2) {
            this.ceilingTimePosition = j_renamed;
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
        public static final com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult NO_TIMESTAMP_IN_RANGE_RESULT = new com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult(-3, -9223372036854775807L, -1);
        public static final int TYPE_NO_TIMESTAMP = -3;
        public static final int TYPE_POSITION_OVERESTIMATED = -1;
        public static final int TYPE_POSITION_UNDERESTIMATED = -2;
        public static final int TYPE_TARGET_TIMESTAMP_FOUND = 0;
        private final long bytePositionToUpdate;
        private final long timestampToUpdate;
        private final int type;

        private TimestampSearchResult(int i_renamed, long j_renamed, long j2) {
            this.type = i_renamed;
            this.timestampToUpdate = j_renamed;
            this.bytePositionToUpdate = j2;
        }

        public static com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult overestimatedResult(long j_renamed, long j2) {
            return new com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult(-1, j_renamed, j2);
        }

        public static com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult underestimatedResult(long j_renamed, long j2) {
            return new com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult(-2, j_renamed, j2);
        }

        public static com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult targetFoundResult(long j_renamed) {
            return new com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult(0, -9223372036854775807L, j_renamed);
        }
    }

    public static class BinarySearchSeekMap implements com.google.android.exoplayer2.extractor.SeekMap {
        private final long approxBytesPerFrame;
        private final long ceilingBytePosition;
        private final long ceilingTimePosition;
        private final long durationUs;
        private final long floorBytePosition;
        private final long floorTimePosition;
        private final com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter seekTimestampConverter;

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        public BinarySearchSeekMap(com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekTimestampConverter seekTimestampConverter, long j_renamed, long j2, long j3, long j4, long j5, long j6) {
            this.seekTimestampConverter = seekTimestampConverter;
            this.durationUs = j_renamed;
            this.floorTimePosition = j2;
            this.ceilingTimePosition = j3;
            this.floorBytePosition = j4;
            this.ceilingBytePosition = j5;
            this.approxBytesPerFrame = j6;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(j_renamed, com.google.android.exoplayer2.extractor.BinarySearchSeeker.SeekOperationParams.calculateNextSearchBytePosition(this.seekTimestampConverter.timeUsToTargetTime(j_renamed), this.floorTimePosition, this.ceilingTimePosition, this.floorBytePosition, this.ceilingBytePosition, this.approxBytesPerFrame)));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        public long timeUsToTargetTime(long j_renamed) {
            return this.seekTimestampConverter.timeUsToTargetTime(j_renamed);
        }
    }
}
