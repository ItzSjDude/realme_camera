package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
final class DataMatrixSymbolInfo144 extends com.google.zxing.datamatrix.encoder.SymbolInfo {
    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getDataLengthForInterleavedBlock(int i_renamed) {
        return i_renamed <= 8 ? 156 : 155;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getInterleavedBlockCount() {
        return 10;
    }

    DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }
}
