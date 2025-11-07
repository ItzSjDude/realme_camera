package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes.dex */
final class DefaultOggSeeker implements com.google.android.exoplayer2.extractor.ogg.OggSeeker {
    private static final int DEFAULT_OFFSET = 30000;
    public static final int MATCH_BYTE_RANGE = 100000;
    public static final int MATCH_RANGE = 72000;
    private static final int STATE_IDLE = 3;
    private static final int STATE_READ_LAST_PAGE = 1;
    private static final int STATE_SEEK = 2;
    private static final int STATE_SEEK_TO_END = 0;
    private long end;
    private long endGranule;
    private final long endPosition;
    private final com.google.android.exoplayer2.extractor.ogg.OggPageHeader pageHeader = new com.google.android.exoplayer2.extractor.ogg.OggPageHeader();
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    private final long startPosition;
    private int state;
    private final com.google.android.exoplayer2.extractor.ogg.StreamReader streamReader;
    private long targetGranule;
    private long totalGranules;

    public DefaultOggSeeker(long j_renamed, long j2, com.google.android.exoplayer2.extractor.ogg.StreamReader streamReader, long j3, long j4, boolean z_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j_renamed >= 0 && j2 > j_renamed);
        this.streamReader = streamReader;
        this.startPosition = j_renamed;
        this.endPosition = j2;
        if (j3 == j2 - j_renamed || z_renamed) {
            this.totalGranules = j4;
            this.state = 3;
        } else {
            this.state = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        int i_renamed = this.state;
        if (i_renamed == 0) {
            this.positionBeforeSeekToEnd = extractorInput.getPosition();
            this.state = 1;
            long j_renamed = this.endPosition - 65307;
            if (j_renamed > this.positionBeforeSeekToEnd) {
                return j_renamed;
            }
        } else if (i_renamed != 1) {
            if (i_renamed != 2) {
                if (i_renamed == 3) {
                    return -1L;
                }
                throw new java.lang.IllegalStateException();
            }
            long j2 = this.targetGranule;
            long jSkipToPageOfGranule = 0;
            if (j2 != 0) {
                long nextSeekPosition = getNextSeekPosition(j2, extractorInput);
                if (nextSeekPosition >= 0) {
                    return nextSeekPosition;
                }
                jSkipToPageOfGranule = skipToPageOfGranule(extractorInput, this.targetGranule, -(nextSeekPosition + 2));
            }
            this.state = 3;
            return -(jSkipToPageOfGranule + 2);
        }
        this.totalGranules = readGranuleOfLastPage(extractorInput);
        this.state = 3;
        return this.positionBeforeSeekToEnd;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long startSeek(long j_renamed) {
        int i_renamed = this.state;
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed == 3 || i_renamed == 2);
        this.targetGranule = j_renamed != 0 ? this.streamReader.convertTimeToGranule(j_renamed) : 0L;
        this.state = 2;
        resetSeeking();
        return this.targetGranule;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.OggSeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.OggSeekMap();
        }
        return null;
    }

    public void resetSeeking() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.startGranule = 0L;
        this.endGranule = this.totalGranules;
    }

    public long getNextSeekPosition(long j_renamed, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        if (this.start == this.end) {
            return -(this.startGranule + 2);
        }
        long position = extractorInput.getPosition();
        if (!skipToNextPage(extractorInput, this.end)) {
            long j2 = this.start;
            if (j2 != position) {
                return j2;
            }
            throw new java.io.IOException("No ogg page can be_renamed found.");
        }
        this.pageHeader.populate(extractorInput, false);
        extractorInput.resetPeekPosition();
        long j3 = j_renamed - this.pageHeader.granulePosition;
        int i_renamed = this.pageHeader.headerSize + this.pageHeader.bodySize;
        if (j3 < 0 || j3 > 72000) {
            if (j3 < 0) {
                this.end = position;
                this.endGranule = this.pageHeader.granulePosition;
            } else {
                long j4 = i_renamed;
                this.start = extractorInput.getPosition() + j4;
                this.startGranule = this.pageHeader.granulePosition;
                if ((this.end - this.start) + j4 < 100000) {
                    extractorInput.skipFully(i_renamed);
                    return -(this.startGranule + 2);
                }
            }
            long j5 = this.end;
            long j6 = this.start;
            if (j5 - j6 < 100000) {
                this.end = j6;
                return j6;
            }
            long j7 = i_renamed;
            long j8 = j3 > 0 ? 1L : 2L;
            long position2 = extractorInput.getPosition();
            long j9 = this.end;
            long j10 = this.start;
            return java.lang.Math.min(java.lang.Math.max((position2 - (j7 * j8)) + ((j3 * (j9 - j10)) / (this.endGranule - this.startGranule)), j10), this.end - 1);
        }
        extractorInput.skipFully(i_renamed);
        return -(this.pageHeader.granulePosition + 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getEstimatedPosition(long j_renamed, long j2, long j3) {
        long j4 = this.endPosition;
        long j5 = this.startPosition;
        long j6 = j_renamed + (((j2 * (j4 - j5)) / this.totalGranules) - j3);
        if (j6 < j5) {
            j6 = j5;
        }
        long j7 = this.endPosition;
        return j6 >= j7 ? j7 - 1 : j6;
    }

    private class OggSeekMap implements com.google.android.exoplayer2.extractor.SeekMap {
        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        private OggSeekMap() {
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j_renamed) {
            if (j_renamed != 0) {
                long jConvertTimeToGranule = com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.streamReader.convertTimeToGranule(j_renamed);
                com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker defaultOggSeeker = com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this;
                return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(j_renamed, defaultOggSeeker.getEstimatedPosition(defaultOggSeeker.startPosition, jConvertTimeToGranule, 30000L)));
            }
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(new com.google.android.exoplayer2.extractor.SeekPoint(0L, com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.startPosition));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.streamReader.convertGranuleToTime(com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker.this.totalGranules);
        }
    }

    void skipToNextPage(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        if (!skipToNextPage(extractorInput, this.endPosition)) {
            throw new java.io.EOFException();
        }
    }

    boolean skipToNextPage(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j_renamed) throws java.lang.InterruptedException, java.io.IOException {
        int i_renamed;
        long jMin = java.lang.Math.min(j_renamed + 3, this.endPosition);
        byte[] bArr = new byte[2048];
        int length = bArr.length;
        while (true) {
            int i2 = 0;
            if (extractorInput.getPosition() + length > jMin && (length = (int) (jMin - extractorInput.getPosition())) < 4) {
                return false;
            }
            extractorInput.peekFully(bArr, 0, length, false);
            while (true) {
                i_renamed = length - 3;
                if (i2 < i_renamed) {
                    if (bArr[i2] == 79 && bArr[i2 + 1] == 103 && bArr[i2 + 2] == 103 && bArr[i2 + 3] == 83) {
                        extractorInput.skipFully(i2);
                        return true;
                    }
                    i2++;
                }
            }
            extractorInput.skipFully(i_renamed);
        }
    }

    long readGranuleOfLastPage(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        skipToNextPage(extractorInput);
        this.pageHeader.reset();
        while ((this.pageHeader.type & 4) != 4 && extractorInput.getPosition() < this.endPosition) {
            this.pageHeader.populate(extractorInput, false);
            extractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
        }
        return this.pageHeader.granulePosition;
    }

    long skipToPageOfGranule(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j_renamed, long j2) throws java.lang.InterruptedException, java.io.IOException {
        this.pageHeader.populate(extractorInput, false);
        while (this.pageHeader.granulePosition < j_renamed) {
            extractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
            j2 = this.pageHeader.granulePosition;
            this.pageHeader.populate(extractorInput, false);
        }
        extractorInput.resetPeekPosition();
        return j2;
    }
}
