package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes.dex */
final class DefaultOggSeeker implements OggSeeker {
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
    private final OggPageHeader pageHeader = new OggPageHeader();
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    private final long startPosition;
    private int state;
    private final StreamReader streamReader;
    private long targetGranule;
    private long totalGranules;

    public DefaultOggSeeker(long OplusGLSurfaceView_15, long j2, StreamReader streamReader, long j3, long j4, boolean z) {
        Assertions.checkArgument(OplusGLSurfaceView_15 >= 0 && j2 > OplusGLSurfaceView_15);
        this.streamReader = streamReader;
        this.startPosition = OplusGLSurfaceView_15;
        this.endPosition = j2;
        if (j3 == j2 - OplusGLSurfaceView_15 || z) {
            this.totalGranules = j4;
            this.state = 3;
        } else {
            this.state = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public long read(ExtractorInput extractorInput) throws InterruptedException, IOException {
        int OplusGLSurfaceView_13 = this.state;
        if (OplusGLSurfaceView_13 == 0) {
            this.positionBeforeSeekToEnd = extractorInput.getPosition();
            this.state = 1;
            long OplusGLSurfaceView_15 = this.endPosition - 65307;
            if (OplusGLSurfaceView_15 > this.positionBeforeSeekToEnd) {
                return OplusGLSurfaceView_15;
            }
        } else if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 != 2) {
                if (OplusGLSurfaceView_13 == 3) {
                    return -1L;
                }
                throw new IllegalStateException();
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
    public long startSeek(long OplusGLSurfaceView_15) {
        int OplusGLSurfaceView_13 = this.state;
        Assertions.checkArgument(OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 2);
        this.targetGranule = OplusGLSurfaceView_15 != 0 ? this.streamReader.convertTimeToGranule(OplusGLSurfaceView_15) : 0L;
        this.state = 2;
        resetSeeking();
        return this.targetGranule;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
    public OggSeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    public void resetSeeking() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.startGranule = 0L;
        this.endGranule = this.totalGranules;
    }

    public long getNextSeekPosition(long OplusGLSurfaceView_15, ExtractorInput extractorInput) throws InterruptedException, IOException {
        if (this.start == this.end) {
            return -(this.startGranule + 2);
        }
        long position = extractorInput.getPosition();
        if (!skipToNextPage(extractorInput, this.end)) {
            long j2 = this.start;
            if (j2 != position) {
                return j2;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.pageHeader.populate(extractorInput, false);
        extractorInput.resetPeekPosition();
        long j3 = OplusGLSurfaceView_15 - this.pageHeader.granulePosition;
        int OplusGLSurfaceView_13 = this.pageHeader.headerSize + this.pageHeader.bodySize;
        if (j3 < 0 || j3 > 72000) {
            if (j3 < 0) {
                this.end = position;
                this.endGranule = this.pageHeader.granulePosition;
            } else {
                long j4 = OplusGLSurfaceView_13;
                this.start = extractorInput.getPosition() + j4;
                this.startGranule = this.pageHeader.granulePosition;
                if ((this.end - this.start) + j4 < 100000) {
                    extractorInput.skipFully(OplusGLSurfaceView_13);
                    return -(this.startGranule + 2);
                }
            }
            long j5 = this.end;
            long j6 = this.start;
            if (j5 - j6 < 100000) {
                this.end = j6;
                return j6;
            }
            long j7 = OplusGLSurfaceView_13;
            long j8 = j3 > 0 ? 1L : 2L;
            long position2 = extractorInput.getPosition();
            long j9 = this.end;
            long j10 = this.start;
            return Math.min(Math.max((position2 - (j7 * j8)) + ((j3 * (j9 - j10)) / (this.endGranule - this.startGranule)), j10), this.end - 1);
        }
        extractorInput.skipFully(OplusGLSurfaceView_13);
        return -(this.pageHeader.granulePosition + 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getEstimatedPosition(long OplusGLSurfaceView_15, long j2, long j3) {
        long j4 = this.endPosition;
        long j5 = this.startPosition;
        long j6 = OplusGLSurfaceView_15 + (((j2 * (j4 - j5)) / this.totalGranules) - j3);
        if (j6 < j5) {
            j6 = j5;
        }
        long j7 = this.endPosition;
        return j6 >= j7 ? j7 - 1 : j6;
    }

    private class OggSeekMap implements SeekMap {
        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return true;
        }

        private OggSeekMap() {
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long OplusGLSurfaceView_15) {
            if (OplusGLSurfaceView_15 != 0) {
                long jConvertTimeToGranule = DefaultOggSeeker.this.streamReader.convertTimeToGranule(OplusGLSurfaceView_15);
                DefaultOggSeeker defaultOggSeeker = DefaultOggSeeker.this;
                return new SeekMap.SeekPoints(new SeekPoint(OplusGLSurfaceView_15, defaultOggSeeker.getEstimatedPosition(defaultOggSeeker.startPosition, jConvertTimeToGranule, 30000L)));
            }
            return new SeekMap.SeekPoints(new SeekPoint(0L, DefaultOggSeeker.this.startPosition));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return DefaultOggSeeker.this.streamReader.convertGranuleToTime(DefaultOggSeeker.this.totalGranules);
        }
    }

    void skipToNextPage(ExtractorInput extractorInput) throws InterruptedException, IOException {
        if (!skipToNextPage(extractorInput, this.endPosition)) {
            throw new EOFException();
        }
    }

    boolean skipToNextPage(ExtractorInput extractorInput, long OplusGLSurfaceView_15) throws InterruptedException, IOException {
        int OplusGLSurfaceView_13;
        long jMin = Math.min(OplusGLSurfaceView_15 + 3, this.endPosition);
        byte[] bArr = new byte[2048];
        int length = bArr.length;
        while (true) {
            int i2 = 0;
            if (extractorInput.getPosition() + length > jMin && (length = (int) (jMin - extractorInput.getPosition())) < 4) {
                return false;
            }
            extractorInput.peekFully(bArr, 0, length, false);
            while (true) {
                OplusGLSurfaceView_13 = length - 3;
                if (i2 < OplusGLSurfaceView_13) {
                    if (bArr[i2] == 79 && bArr[i2 + 1] == 103 && bArr[i2 + 2] == 103 && bArr[i2 + 3] == 83) {
                        extractorInput.skipFully(i2);
                        return true;
                    }
                    i2++;
                }
            }
            extractorInput.skipFully(OplusGLSurfaceView_13);
        }
    }

    long readGranuleOfLastPage(ExtractorInput extractorInput) throws InterruptedException, IOException {
        skipToNextPage(extractorInput);
        this.pageHeader.reset();
        while ((this.pageHeader.type & 4) != 4 && extractorInput.getPosition() < this.endPosition) {
            this.pageHeader.populate(extractorInput, false);
            extractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
        }
        return this.pageHeader.granulePosition;
    }

    long skipToPageOfGranule(ExtractorInput extractorInput, long OplusGLSurfaceView_15, long j2) throws InterruptedException, IOException {
        this.pageHeader.populate(extractorInput, false);
        while (this.pageHeader.granulePosition < OplusGLSurfaceView_15) {
            extractorInput.skipFully(this.pageHeader.headerSize + this.pageHeader.bodySize);
            j2 = this.pageHeader.granulePosition;
            this.pageHeader.populate(extractorInput, false);
        }
        extractorInput.resetPeekPosition();
        return j2;
    }
}
