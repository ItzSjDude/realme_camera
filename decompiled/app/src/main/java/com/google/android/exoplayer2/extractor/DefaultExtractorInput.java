package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public final class DefaultExtractorInput implements com.google.android.exoplayer2.extractor.ExtractorInput {
    private static final int PEEK_MAX_FREE_SPACE = 524288;
    private static final int PEEK_MIN_FREE_SPACE_AFTER_RESIZE = 65536;
    private static final int SCRATCH_SPACE_SIZE = 4096;
    private final com.google.android.exoplayer2.upstream.DataSource dataSource;
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final long streamLength;
    private byte[] peekBuffer = new byte[65536];
    private final byte[] scratchSpace = new byte[4096];

    public DefaultExtractorInput(com.google.android.exoplayer2.upstream.DataSource dataSource, long j_renamed, long j2) {
        this.dataSource = dataSource;
        this.position = j_renamed;
        this.streamLength = j2;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int read(byte[] bArr, int i_renamed, int i2) throws java.lang.InterruptedException, java.io.IOException {
        int fromPeekBuffer = readFromPeekBuffer(bArr, i_renamed, i2);
        if (fromPeekBuffer == 0) {
            fromPeekBuffer = readFromDataSource(bArr, i_renamed, i2, 0, true);
        }
        commitBytesRead(fromPeekBuffer);
        return fromPeekBuffer;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i_renamed, int i2, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        int fromPeekBuffer = readFromPeekBuffer(bArr, i_renamed, i2);
        while (fromPeekBuffer < i2 && fromPeekBuffer != -1) {
            fromPeekBuffer = readFromDataSource(bArr, i_renamed, i2, fromPeekBuffer, z_renamed);
        }
        commitBytesRead(fromPeekBuffer);
        return fromPeekBuffer != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i_renamed, int i2) throws java.lang.InterruptedException, java.io.IOException {
        readFully(bArr, i_renamed, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        int iSkipFromPeekBuffer = skipFromPeekBuffer(i_renamed);
        if (iSkipFromPeekBuffer == 0) {
            byte[] bArr = this.scratchSpace;
            iSkipFromPeekBuffer = readFromDataSource(bArr, 0, java.lang.Math.min(i_renamed, bArr.length), 0, true);
        }
        commitBytesRead(iSkipFromPeekBuffer);
        return iSkipFromPeekBuffer;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        int iSkipFromPeekBuffer = skipFromPeekBuffer(i_renamed);
        while (iSkipFromPeekBuffer < i_renamed && iSkipFromPeekBuffer != -1) {
            iSkipFromPeekBuffer = readFromDataSource(this.scratchSpace, -iSkipFromPeekBuffer, java.lang.Math.min(i_renamed, this.scratchSpace.length + iSkipFromPeekBuffer), iSkipFromPeekBuffer, z_renamed);
        }
        commitBytesRead(iSkipFromPeekBuffer);
        return iSkipFromPeekBuffer != -1;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        skipFully(i_renamed, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i_renamed, int i2, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        if (!advancePeekPosition(i2, z_renamed)) {
            return false;
        }
        java.lang.System.arraycopy(this.peekBuffer, this.peekBufferPosition - i2, bArr, i_renamed, i2);
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i_renamed, int i2) throws java.lang.InterruptedException, java.io.IOException {
        peekFully(bArr, i_renamed, i2, false);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        ensureSpaceForPeek(i_renamed);
        int fromDataSource = this.peekBufferLength - this.peekBufferPosition;
        while (fromDataSource < i_renamed) {
            fromDataSource = readFromDataSource(this.peekBuffer, this.peekBufferPosition, i_renamed, fromDataSource, z_renamed);
            if (fromDataSource == -1) {
                return false;
            }
            this.peekBufferLength = this.peekBufferPosition + fromDataSource;
        }
        this.peekBufferPosition += i_renamed;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        advancePeekPosition(i_renamed, false);
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

    /* JADX INFO: Thrown type has an_renamed unknown type hierarchy: E_renamed extends java.lang.Throwable */
    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public <E_renamed extends java.lang.Throwable> void setRetryPosition(long j_renamed, E_renamed e_renamed) throws java.lang.Throwable {
        com.google.android.exoplayer2.util.Assertions.checkArgument(j_renamed >= 0);
        this.position = j_renamed;
        throw e_renamed;
    }

    private void ensureSpaceForPeek(int i_renamed) {
        int i2 = this.peekBufferPosition + i_renamed;
        byte[] bArr = this.peekBuffer;
        if (i2 > bArr.length) {
            this.peekBuffer = java.util.Arrays.copyOf(this.peekBuffer, com.google.android.exoplayer2.util.Util.constrainValue(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int skipFromPeekBuffer(int i_renamed) {
        int iMin = java.lang.Math.min(this.peekBufferLength, i_renamed);
        updatePeekBuffer(iMin);
        return iMin;
    }

    private int readFromPeekBuffer(byte[] bArr, int i_renamed, int i2) {
        int i3 = this.peekBufferLength;
        if (i3 == 0) {
            return 0;
        }
        int iMin = java.lang.Math.min(i3, i2);
        java.lang.System.arraycopy(this.peekBuffer, 0, bArr, i_renamed, iMin);
        updatePeekBuffer(iMin);
        return iMin;
    }

    private void updatePeekBuffer(int i_renamed) {
        this.peekBufferLength -= i_renamed;
        this.peekBufferPosition = 0;
        byte[] bArr = this.peekBuffer;
        int i2 = this.peekBufferLength;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[i2 + 65536];
        }
        java.lang.System.arraycopy(this.peekBuffer, i_renamed, bArr, 0, this.peekBufferLength);
        this.peekBuffer = bArr;
    }

    private int readFromDataSource(byte[] bArr, int i_renamed, int i2, int i3, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        if (java.lang.Thread.interrupted()) {
            throw new java.lang.InterruptedException();
        }
        int i4 = this.dataSource.read(bArr, i_renamed + i3, i2 - i3);
        if (i4 != -1) {
            return i3 + i4;
        }
        if (i3 == 0 && z_renamed) {
            return -1;
        }
        throw new java.io.EOFException();
    }

    private void commitBytesRead(int i_renamed) {
        if (i_renamed != -1) {
            this.position += i_renamed;
        }
    }
}
