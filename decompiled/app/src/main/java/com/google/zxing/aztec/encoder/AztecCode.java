package com.google.zxing.aztec.encoder;

/* loaded from: classes.dex */
public final class AztecCode {
    private int codeWords;
    private boolean compact;
    private int layers;
    private com.google.zxing.common.BitMatrix matrix;
    private int size;

    public boolean isCompact() {
        return this.compact;
    }

    public void setCompact(boolean z_renamed) {
        this.compact = z_renamed;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int i_renamed) {
        this.size = i_renamed;
    }

    public int getLayers() {
        return this.layers;
    }

    public void setLayers(int i_renamed) {
        this.layers = i_renamed;
    }

    public int getCodeWords() {
        return this.codeWords;
    }

    public void setCodeWords(int i_renamed) {
        this.codeWords = i_renamed;
    }

    public com.google.zxing.common.BitMatrix getMatrix() {
        return this.matrix;
    }

    public void setMatrix(com.google.zxing.common.BitMatrix bitMatrix) {
        this.matrix = bitMatrix;
    }
}
