package com.google.zxing.aztec;

/* loaded from: classes.dex */
public final class AztecDetectorResult extends com.google.zxing.common.DetectorResult {
    private final boolean compact;
    private final int nbDatablocks;
    private final int nbLayers;

    public AztecDetectorResult(com.google.zxing.common.BitMatrix bitMatrix, com.google.zxing.ResultPoint[] resultPointArr, boolean z_renamed, int i_renamed, int i2) {
        super(bitMatrix, resultPointArr);
        this.compact = z_renamed;
        this.nbDatablocks = i_renamed;
        this.nbLayers = i2;
    }

    public int getNbLayers() {
        return this.nbLayers;
    }

    public int getNbDatablocks() {
        return this.nbDatablocks;
    }

    public boolean isCompact() {
        return this.compact;
    }
}
