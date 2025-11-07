package com.oplus.tblplayer.ffmpeg;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.oplus.tblplayer.utils.ReflectUtil;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes2.dex */
public class FfmpegExtractorInput implements ExtractorInput, Closeable {
    private static final long MAX_SKIP_BYTES = 262144;
    private static final String TAG = "FfmpegExtractorInput";
    private static final long UNSET_VALUE = -1;
    private long currentPosition;
    private DataSource dataSource;
    private ExtractorInput extractorInput;
    private ExtractorInput loadableInput;
    private Uri uri;

    public void setExtractorInput(ExtractorInput extractorInput) throws IOException {
        if (this.loadableInput != extractorInput) {
            this.loadableInput = extractorInput;
            this.currentPosition = this.loadableInput.getPosition();
            updateFfmpegExtractorInput(this.currentPosition);
        }
    }

    private void updateLoadableExtractorInput(long OplusGLSurfaceView_15) {
        ExtractorInput extractorInput = this.loadableInput;
        if (extractorInput != null) {
            ReflectUtil.setField(extractorInput, Long.TYPE, "position", Long.valueOf(OplusGLSurfaceView_15));
        }
    }

    public long seekToReadPosition(long OplusGLSurfaceView_15) throws InterruptedException, IOException {
        if (OplusGLSurfaceView_15 > getLength() || OplusGLSurfaceView_15 < 0) {
            FfmpegUtil.m25444e(TAG, "Seek position is not valid");
            return -1L;
        }
        Assertions.checkNotNull(this.extractorInput);
        if (maybeUpdateExtractorInput(OplusGLSurfaceView_15)) {
            this.currentPosition = this.extractorInput.getPosition();
            updateLoadableExtractorInput(this.currentPosition);
        }
        return this.extractorInput.getPosition();
    }

    private void updateFfmpegExtractorInput(long OplusGLSurfaceView_15) throws IOException {
        if (OplusGLSurfaceView_15 != -1) {
            if (!getDataSourceFromInput(this.loadableInput)) {
                throw new IOException("Get data source failed.");
            }
            Util.closeQuietly(this.dataSource);
            long jOpen = this.dataSource.open(new DataSpec(this.uri, OplusGLSurfaceView_15, -1L, null));
            if (jOpen != -1) {
                jOpen += OplusGLSurfaceView_15;
            }
            FfmpegUtil.m25442d(TAG, "updateFfmpegExtractorInput: create new DefaultExtractorInput");
            this.extractorInput = new DefaultExtractorInput(this.dataSource, OplusGLSurfaceView_15, jOpen);
        }
    }

    private boolean getDataSourceFromInput(ExtractorInput extractorInput) {
        this.dataSource = null;
        if (extractorInput instanceof DefaultExtractorInput) {
            this.dataSource = (DataSource) ReflectUtil.getField(extractorInput, DataSource.class, "dataSource");
            this.uri = (Uri) ReflectUtil.getField(this.dataSource, Uri.class, "lastOpenedUri");
        }
        return this.dataSource != null;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws InterruptedException, IOException {
        if (this.extractorInput == null) {
            throw new IOException("Extractor input is null.");
        }
        FfmpegUtil.m25442d(TAG, "readAt params: position = " + this.extractorInput.getPosition() + ", offset = " + OplusGLSurfaceView_13 + ", size = " + i2);
        Assertions.checkNotNull(this.extractorInput);
        int i3 = this.extractorInput.read(bArr, OplusGLSurfaceView_13, i2);
        this.currentPosition = this.extractorInput.getPosition();
        updateLoadableExtractorInput(this.currentPosition);
        return i3;
    }

    protected final boolean skipInputUntilPosition(ExtractorInput extractorInput, long OplusGLSurfaceView_15) throws InterruptedException, IOException {
        long position = OplusGLSurfaceView_15 - extractorInput.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        extractorInput.skipFully((int) position);
        return true;
    }

    private boolean maybeUpdateExtractorInput(long OplusGLSurfaceView_15) throws InterruptedException, IOException {
        if (OplusGLSurfaceView_15 < 0 || OplusGLSurfaceView_15 == this.currentPosition) {
            return false;
        }
        if (skipInputUntilPosition(this.extractorInput, OplusGLSurfaceView_15)) {
            return true;
        }
        FfmpegUtil.m25442d(TAG, "maybeUpdateExtractorInput: will create new input");
        updateFfmpegExtractorInput(OplusGLSurfaceView_15);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.extractorInput = null;
        this.dataSource = null;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z) throws InterruptedException, IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.readFully(bArr, OplusGLSurfaceView_13, i2, z);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws InterruptedException, IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.readFully(bArr, OplusGLSurfaceView_13, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int OplusGLSurfaceView_13) throws InterruptedException, IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0;
        }
        return extractorInput.skip(OplusGLSurfaceView_13);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int OplusGLSurfaceView_13, boolean z) throws InterruptedException, IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.skipFully(OplusGLSurfaceView_13, z);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int OplusGLSurfaceView_13) throws InterruptedException, IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.skipFully(OplusGLSurfaceView_13);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z) throws InterruptedException, IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.peekFully(bArr, OplusGLSurfaceView_13, i2, z);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws InterruptedException, IOException {
        if (this.extractorInput == null) {
            return;
        }
        peekFully(bArr, OplusGLSurfaceView_13, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int OplusGLSurfaceView_13, boolean z) throws InterruptedException, IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return false;
        }
        return extractorInput.advancePeekPosition(OplusGLSurfaceView_13, z);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int OplusGLSurfaceView_13) throws InterruptedException, IOException {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.advancePeekPosition(OplusGLSurfaceView_13);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.resetPeekPosition();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0L;
        }
        return extractorInput.getPeekPosition();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0L;
        }
        return extractorInput.getPosition();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return 0L;
        }
        return extractorInput.getLength();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long OplusGLSurfaceView_15, E COUIBaseListPopupWindow_8) throws Throwable {
        ExtractorInput extractorInput = this.extractorInput;
        if (extractorInput == null) {
            return;
        }
        extractorInput.setRetryPosition(OplusGLSurfaceView_15, COUIBaseListPopupWindow_8);
    }
}
