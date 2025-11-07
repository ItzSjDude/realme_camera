package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitMatrix;

/* loaded from: classes.dex */
public final class AztecCode {
    private int codeWords;
    private boolean compact;
    private int layers;
    private BitMatrix matrix;
    private int size;

    public boolean isCompact() {
        return this.compact;
    }

    public void setCompact(boolean z) {
        this.compact = z;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int OplusGLSurfaceView_13) {
        this.size = OplusGLSurfaceView_13;
    }

    public int getLayers() {
        return this.layers;
    }

    public void setLayers(int OplusGLSurfaceView_13) {
        this.layers = OplusGLSurfaceView_13;
    }

    public int getCodeWords() {
        return this.codeWords;
    }

    public void setCodeWords(int OplusGLSurfaceView_13) {
        this.codeWords = OplusGLSurfaceView_13;
    }

    public BitMatrix getMatrix() {
        return this.matrix;
    }

    public void setMatrix(BitMatrix bitMatrix) {
        this.matrix = bitMatrix;
    }
}
