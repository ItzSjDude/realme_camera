package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
final class TsBinarySearchSeeker extends com.google.android.exoplayer2.extractor.BinarySearchSeeker {
    private static final int MINIMUM_SEARCH_RANGE_BYTES = 940;
    private static final long SEEK_TOLERANCE_US = 100000;
    private static final int TIMESTAMP_SEARCH_BYTES = 112800;

    public TsBinarySearchSeeker(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, long j_renamed, long j2, int i_renamed) {
        super(new com.google.android.exoplayer2.extractor.BinarySearchSeeker.DefaultSeekTimestampConverter(), new com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker.TsPcrSeeker(i_renamed, timestampAdjuster), j_renamed, 0L, j_renamed + 1, 0L, j2, 188L, MINIMUM_SEARCH_RANGE_BYTES);
    }

    private static final class TsPcrSeeker implements com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker {
        private final com.google.android.exoplayer2.util.ParsableByteArray packetBuffer = new com.google.android.exoplayer2.util.ParsableByteArray();
        private final int pcrPid;
        private final com.google.android.exoplayer2.util.TimestampAdjuster pcrTimestampAdjuster;

        public TsPcrSeeker(int i_renamed, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
            this.pcrPid = i_renamed;
            this.pcrTimestampAdjuster = timestampAdjuster;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult searchForTimestamp(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j_renamed, com.google.android.exoplayer2.extractor.BinarySearchSeeker.OutputFrameHolder outputFrameHolder) throws java.lang.InterruptedException, java.io.IOException {
            long position = extractorInput.getPosition();
            int iMin = (int) java.lang.Math.min(112800L, extractorInput.getLength() - position);
            this.packetBuffer.reset(iMin);
            extractorInput.peekFully(this.packetBuffer.data, 0, iMin);
            return searchForPcrValueInBuffer(this.packetBuffer, j_renamed, position);
        }

        private com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult searchForPcrValueInBuffer(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed, long j2) {
            int iFindSyncBytePosition;
            int iFindSyncBytePosition2;
            int iLimit = parsableByteArray.limit();
            long j3 = -1;
            long j4 = -1;
            long j5 = -9223372036854775807L;
            while (parsableByteArray.bytesLeft() >= 188 && (iFindSyncBytePosition2 = (iFindSyncBytePosition = com.google.android.exoplayer2.extractor.ts.TsUtil.findSyncBytePosition(parsableByteArray.data, parsableByteArray.getPosition(), iLimit)) + 188) <= iLimit) {
                long pcrFromPacket = com.google.android.exoplayer2.extractor.ts.TsUtil.readPcrFromPacket(parsableByteArray, iFindSyncBytePosition, this.pcrPid);
                if (pcrFromPacket != -9223372036854775807L) {
                    long jAdjustTsTimestamp = this.pcrTimestampAdjuster.adjustTsTimestamp(pcrFromPacket);
                    if (jAdjustTsTimestamp > j_renamed) {
                        if (j5 == -9223372036854775807L) {
                            return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.overestimatedResult(jAdjustTsTimestamp, j2);
                        }
                        return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.targetFoundResult(j2 + j4);
                    }
                    if (com.google.android.exoplayer2.extractor.ts.TsBinarySearchSeeker.SEEK_TOLERANCE_US + jAdjustTsTimestamp > j_renamed) {
                        return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.targetFoundResult(iFindSyncBytePosition + j2);
                    }
                    j4 = iFindSyncBytePosition;
                    j5 = jAdjustTsTimestamp;
                }
                parsableByteArray.setPosition(iFindSyncBytePosition2);
                j3 = iFindSyncBytePosition2;
            }
            if (j5 != -9223372036854775807L) {
                return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.underestimatedResult(j5, j2 + j3);
            }
            return com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
        }

        @Override // com.google.android.exoplayer2.extractor.BinarySearchSeeker.TimestampSeeker
        public void onSeekFinished() {
            this.packetBuffer.reset(com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY);
        }
    }
}
