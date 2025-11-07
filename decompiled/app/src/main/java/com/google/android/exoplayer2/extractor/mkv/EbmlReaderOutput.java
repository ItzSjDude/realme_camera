package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
interface EbmlReaderOutput {
    public static final int TYPE_BINARY = 4;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_MASTER = 1;
    public static final int TYPE_STRING = 3;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_UNSIGNED_INT = 2;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ElementType {
    }

    void binaryElement(int OplusGLSurfaceView_13, int i2, ExtractorInput extractorInput) throws InterruptedException, IOException;

    void endMasterElement(int OplusGLSurfaceView_13) throws ParserException;

    void floatElement(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) throws ParserException;

    int getElementType(int OplusGLSurfaceView_13);

    void integerElement(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) throws ParserException;

    boolean isLevel1Element(int OplusGLSurfaceView_13);

    void startMasterElement(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2) throws ParserException;

    void stringElement(int OplusGLSurfaceView_13, String str) throws ParserException;
}
