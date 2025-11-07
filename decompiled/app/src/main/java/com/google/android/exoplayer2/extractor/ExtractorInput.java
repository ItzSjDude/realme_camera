package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public interface ExtractorInput {
    void advancePeekPosition(int i_renamed) throws java.lang.InterruptedException, java.io.IOException;

    boolean advancePeekPosition(int i_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException;

    long getLength();

    long getPeekPosition();

    long getPosition();

    void peekFully(byte[] bArr, int i_renamed, int i2) throws java.lang.InterruptedException, java.io.IOException;

    boolean peekFully(byte[] bArr, int i_renamed, int i2, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException;

    int read(byte[] bArr, int i_renamed, int i2) throws java.lang.InterruptedException, java.io.IOException;

    void readFully(byte[] bArr, int i_renamed, int i2) throws java.lang.InterruptedException, java.io.IOException;

    boolean readFully(byte[] bArr, int i_renamed, int i2, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException;

    void resetPeekPosition();

    <E_renamed extends java.lang.Throwable> void setRetryPosition(long j_renamed, E_renamed e_renamed) throws java.lang.Throwable;

    int skip(int i_renamed) throws java.lang.InterruptedException, java.io.IOException;

    void skipFully(int i_renamed) throws java.lang.InterruptedException, java.io.IOException;

    boolean skipFully(int i_renamed, boolean z_renamed) throws java.lang.InterruptedException, java.io.IOException;
}
