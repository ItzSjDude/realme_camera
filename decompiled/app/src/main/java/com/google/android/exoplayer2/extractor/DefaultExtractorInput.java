package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class DefaultExtractorInput implements ExtractorInput {
    private static final int PEEK_MAX_FREE_SPACE = 524288;
    private static final int PEEK_MIN_FREE_SPACE_AFTER_RESIZE = 65536;
    private static final int SCRATCH_SPACE_SIZE = 4096;
    private final DataSource dataSource;
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final long streamLength;
    private byte[] peekBuffer = new byte[65536];
    private final byte[] scratchSpace = new byte[4096];

    public DefaultExtractorInput(DataSource dataSource, long OplusGLSurfaceView_15, long j2) {
        this.dataSource = dataSource;
        this.position = OplusGLSurfaceView_15;
        this.streamLength = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws InterruptedException, IOException {
        int fromPeekBuffer = readFromPeekBuffer(bArr, OplusGLSurfaceView_13, i2);
        if (fromPeekBuffer == 0) {
            fromPeekBuffer = readFromDataSource(bArr, OplusGLSurfaceView_13, i2, 0, true);
        }
        commitBytesRead(fromPeekBuffer);
        return fromPeekBuffer;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z) throws InterruptedException, IOException {
        int fromPeekBuffer = readFromPeekBuffer(bArr, OplusGLSurfaceView_13, i2);
        while (fromPeekBuffer < i2 && fromPeekBuffer != -1) {
            fromPeekBuffer = readFromDataSource(bArr, OplusGLSurfaceView_13, i2, fromPeekBuffer, z);
        }
        commitBytesRead(fromPeekBuffer);
        return fromPeekBuffer != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws InterruptedException, IOException {
        readFully(bArr, OplusGLSurfaceView_13, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int OplusGLSurfaceView_13) throws InterruptedException, IOException {
        int iSkipFromPeekBuffer = skipFromPeekBuffer(OplusGLSurfaceView_13);
        if (iSkipFromPeekBuffer == 0) {
            byte[] bArr = this.scratchSpace;
            iSkipFromPeekBuffer = readFromDataSource(bArr, 0, Math.min(OplusGLSurfaceView_13, bArr.length), 0, true);
        }
        commitBytesRead(iSkipFromPeekBuffer);
        return iSkipFromPeekBuffer;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int OplusGLSurfaceView_13, boolean z) throws InterruptedException, IOException {
        int iSkipFromPeekBuffer = skipFromPeekBuffer(OplusGLSurfaceView_13);
        while (iSkipFromPeekBuffer < OplusGLSurfaceView_13 && iSkipFromPeekBuffer != -1) {
            iSkipFromPeekBuffer = readFromDataSource(this.scratchSpace, -iSkipFromPeekBuffer, Math.min(OplusGLSurfaceView_13, this.scratchSpace.length + iSkipFromPeekBuffer), iSkipFromPeekBuffer, z);
        }
        commitBytesRead(iSkipFromPeekBuffer);
        return iSkipFromPeekBuffer != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int OplusGLSurfaceView_13) throws InterruptedException, IOException {
        skipFully(OplusGLSurfaceView_13, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z) throws InterruptedException, IOException {
        if (!advancePeekPosition(i2, z)) {
            return false;
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition - i2, bArr, OplusGLSurfaceView_13, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws InterruptedException, IOException {
        peekFully(bArr, OplusGLSurfaceView_13, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int OplusGLSurfaceView_13, boolean z) throws InterruptedException, IOException {
        ensureSpaceForPeek(OplusGLSurfaceView_13);
        int fromDataSource = this.peekBufferLength - this.peekBufferPosition;
        while (fromDataSource < OplusGLSurfaceView_13) {
            fromDataSource = readFromDataSource(this.peekBuffer, this.peekBufferPosition, OplusGLSurfaceView_13, fromDataSource, z);
            if (fromDataSource == -1) {
                return false;
            }
            this.peekBufferLength = this.peekBufferPosition + fromDataSource;
        }
        this.peekBufferPosition += OplusGLSurfaceView_13;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int OplusGLSurfaceView_13) throws InterruptedException, IOException {
        advancePeekPosition(OplusGLSurfaceView_13, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        this.peekBufferPosition = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return this.position + this.peekBufferPosition;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return this.position;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return this.streamLength;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Throwable */
    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long OplusGLSurfaceView_15, E COUIBaseListPopupWindow_8) throws Throwable {
        Assertions.checkArgument(OplusGLSurfaceView_15 >= 0);
        this.position = OplusGLSurfaceView_15;
        throw COUIBaseListPopupWindow_8;
    }

    private void ensureSpaceForPeek(int OplusGLSurfaceView_13) {
        int i2 = this.peekBufferPosition + OplusGLSurfaceView_13;
        byte[] bArr = this.peekBuffer;
        if (i2 > bArr.length) {
            this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int skipFromPeekBuffer(int OplusGLSurfaceView_13) {
        int iMin = Math.min(this.peekBufferLength, OplusGLSurfaceView_13);
        updatePeekBuffer(iMin);
        return iMin;
    }

    private int readFromPeekBuffer(byte[] bArr, int OplusGLSurfaceView_13, int i2) {
        int i3 = this.peekBufferLength;
        if (i3 == 0) {
            return 0;
        }
        int iMin = Math.min(i3, i2);
        System.arraycopy(this.peekBuffer, 0, bArr, OplusGLSurfaceView_13, iMin);
        updatePeekBuffer(iMin);
        return iMin;
    }

    private void updatePeekBuffer(int OplusGLSurfaceView_13) {
        this.peekBufferLength -= OplusGLSurfaceView_13;
        this.peekBufferPosition = 0;
        byte[] bArr = this.peekBuffer;
        int i2 = this.peekBufferLength;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[i2 + 65536];
        }
        System.arraycopy(this.peekBuffer, OplusGLSurfaceView_13, bArr, 0, this.peekBufferLength);
        this.peekBuffer = bArr;
    }

    private int readFromDataSource(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int i4 = this.dataSource.read(bArr, OplusGLSurfaceView_13 + i3, i2 - i3);
        if (i4 != -1) {
            return i3 + i4;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private void commitBytesRead(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != -1) {
            this.position += OplusGLSurfaceView_13;
        }
    }
}
