package com.oplus.tblplayer.ffmpeg;

/* loaded from: classes2.dex */
public class FfmpegExtractorInput implements com.google.android.exoplayer2.extractor.ExtractorInput, java.io.Closeable {
    private static final long MAX_SKIP_BYTES = 262144;
    private static final java.lang.String TAG = "FfmpegExtractorInput";
    private static final long UNSET_VALUE = -1;
    private long currentPosition;
    private com.google.android.exoplayer2.upstream.DataSource dataSource;
    private com.google.android.exoplayer2.extractor.ExtractorInput extractorInput;
    private com.google.android.exoplayer2.extractor.ExtractorInput loadableInput;
    private android.net.Uri uri;

    public void setExtractorInput(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        if (this.loadableInput != extractorInput) {
            this.loadableInput = extractorInput;
            this.currentPosition = this.loadableInput.getPosition();
            updateFfmpegExtractorInput(this.currentPosition);
        }
    }

    private void updateLoadableExtractorInput(long j_renamed) {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.loadableInput;
        if (extractorInput != null) {
            com.oplus.tblplayer.utils.ReflectUtil.setField(extractorInput, java.lang.Long.TYPE, "position", java.lang.Long.valueOf(j_renamed));
        }
    }

    public long seekToReadPosition(long j_renamed) throws java.lang.InterruptedException, java.io.IOException {
        if (j_renamed > getLength() || j_renamed < 0) {
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.e_renamed(TAG, "Seek position is_renamed not valid");
            return -1L;
        }
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.extractorInput);
        if (maybeUpdateExtractorInput(j_renamed)) {
            this.currentPosition = this.extractorInput.getPosition();
            updateLoadableExtractorInput(this.currentPosition);
        }
        return this.extractorInput.getPosition();
    }

    private void updateFfmpegExtractorInput(long j_renamed) throws java.io.IOException {
        if (j_renamed != -1) {
            if (!getDataSourceFromInput(this.loadableInput)) {
                throw new java.io.IOException("Get data source failed.");
            }
            com.google.android.exoplayer2.util.Util.closeQuietly(this.dataSource);
            long jOpen = this.dataSource.open(new com.google.android.exoplayer2.upstream.DataSpec(this.uri, j_renamed, -1L, null));
            if (jOpen != -1) {
                jOpen += j_renamed;
            }
            com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "updateFfmpegExtractorInput: create new DefaultExtractorInput");
            this.extractorInput = new com.google.android.exoplayer2.extractor.DefaultExtractorInput(this.dataSource, j_renamed, jOpen);
        }
    }

    private boolean getDataSourceFromInput(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) {
        this.dataSource = null;
        if (extractorInput instanceof com.google.android.exoplayer2.extractor.DefaultExtractorInput) {
            this.dataSource = (com.google.android.exoplayer2.upstream.DataSource) com.oplus.tblplayer.utils.ReflectUtil.getField(extractorInput, com.google.android.exoplayer2.upstream.DataSource.class, "dataSource");
            this.uri = (android.net.Uri) com.oplus.tblplayer.utils.ReflectUtil.getField(this.dataSource, android.net.Uri.class, "lastOpenedUri");
        }
        return this.dataSource != null;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int read(byte[] bArr, int i_renamed, int i2) throws java.lang.InterruptedException, java.io.IOException {
        if (this.extractorInput == null) {
            throw new java.io.IOException("Extractor input is_renamed null.");
        }
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "readAt params: position = " + this.extractorInput.getPosition() + ", offset = " + i_renamed + ", size = " + i2);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.extractorInput);
        int i3 = this.extractorInput.read(bArr, i_renamed, i2);
        this.currentPosition = this.extractorInput.getPosition();
        updateLoadableExtractorInput(this.currentPosition);
        return i3;
    }

    protected final boolean skipInputUntilPosition(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, long j_renamed) throws java.lang.InterruptedException, java.io.IOException {
        long position = j_renamed - extractorInput.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        extractorInput.skipFully((int) position);
        return true;
    }

    private boolean maybeUpdateExtractorInput(long j_renamed) throws java.lang.InterruptedException, java.io.IOException {
        if (j_renamed < 0 || j_renamed == this.currentPosition) {
            return false;
        }
        if (skipInputUntilPosition(this.extractorInput, j_renamed)) {
            return true;
        }
        com.oplus.tblplayer.ffmpeg.FfmpegUtil.d_renamed(TAG, "maybeUpdateExtractorInput: will create new input");
        updateFfmpegExtractorInput(j_renamed);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.extractorInput = null;
        this.dataSource = null;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i_renamed, int i2, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.readFully(bArr, i_renamed, i2, z_renamed);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i_renamed, int i2) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.readFully(bArr, i_renamed, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0;
        }
        return extractorInput.skip(i_renamed);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.skipFully(i_renamed, z_renamed);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.skipFully(i_renamed);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i_renamed, int i2, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.peekFully(bArr, i_renamed, i2, z_renamed);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i_renamed, int i2) throws java.lang.InterruptedException, java.io.IOException {
        if (this.extractorInput == null) {
            return;
        }
        peekFully(bArr, i_renamed, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.advancePeekPosition(i_renamed, z_renamed);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.advancePeekPosition(i_renamed);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.resetPeekPosition();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0L;
        }
        return extractorInput.getPeekPosition();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0L;
        }
        return extractorInput.getPosition();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0L;
        }
        return extractorInput.getLength();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public <E_renamed extends java.lang.Throwable> void setRetryPosition(long j_renamed, E_renamed e_renamed) throws java.lang.Throwable {
        com.google.android.exoplayer2.extractor.ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.setRetryPosition(j_renamed, e_renamed);
    }
}
