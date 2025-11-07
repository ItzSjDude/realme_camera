package com.google.android.exoplayer2.extractor.mkv;

/* loaded from: classes.dex */
interface EbmlReaderOutput {
    public static final int TYPE_BINARY = 4;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_MASTER = 1;
    public static final int TYPE_STRING = 3;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_UNSIGNED_INT = 2;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ElementType {
    }

    void binaryElement(int i_renamed, int i2, com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException;

    void endMasterElement(int i_renamed) throws com.google.android.exoplayer2.ParserException;

    void floatElement(int i_renamed, double d_renamed) throws com.google.android.exoplayer2.ParserException;

    int getElementType(int i_renamed);

    void integerElement(int i_renamed, long j_renamed) throws com.google.android.exoplayer2.ParserException;

    boolean isLevel1Element(int i_renamed);

    void startMasterElement(int i_renamed, long j_renamed, long j2) throws com.google.android.exoplayer2.ParserException;

    void stringElement(int i_renamed, java.lang.String str) throws com.google.android.exoplayer2.ParserException;
}
