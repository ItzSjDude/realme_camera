package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
public class SymbolInfo {
    static final com.google.zxing.datamatrix.encoder.SymbolInfo[] PROD_SYMBOLS;
    private static com.google.zxing.datamatrix.encoder.SymbolInfo[] symbols;
    private final int dataCapacity;
    private final int dataRegions;
    private final int errorCodewords;
    public final int matrixHeight;
    public final int matrixWidth;
    private final boolean rectangular;
    private final int rsBlockData;
    private final int rsBlockError;

    static {
        com.google.zxing.datamatrix.encoder.SymbolInfo[] symbolInfoArr = {new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 3, 5, 8, 8, 1), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 5, 7, 10, 10, 1), new com.google.zxing.datamatrix.encoder.SymbolInfo(true, 5, 7, 16, 6, 1), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 8, 10, 12, 12, 1), new com.google.zxing.datamatrix.encoder.SymbolInfo(true, 10, 11, 14, 6, 2), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 12, 12, 14, 14, 1), new com.google.zxing.datamatrix.encoder.SymbolInfo(true, 16, 14, 24, 10, 1), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 18, 14, 16, 16, 1), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 22, 18, 18, 18, 1), new com.google.zxing.datamatrix.encoder.SymbolInfo(true, 22, 18, 16, 10, 2), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 30, 20, 20, 20, 1), new com.google.zxing.datamatrix.encoder.SymbolInfo(true, 32, 24, 16, 14, 2), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 36, 24, 22, 22, 1), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 44, 28, 24, 24, 1), new com.google.zxing.datamatrix.encoder.SymbolInfo(true, 49, 28, 22, 14, 2), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 62, 36, 14, 14, 4), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 86, 42, 16, 16, 4), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 114, 48, 18, 18, 4), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 144, 56, 20, 20, 4), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 174, 68, 22, 22, 4), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 696, 272, 22, 22, 16, 174, 68), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68), new com.google.zxing.datamatrix.encoder.SymbolInfo(false, 1304, com.android.providers.downloads.Downloads.Impl.STATUS_HTTP_EXCEPTION, 20, 20, 36, 163, 62), new com.google.zxing.datamatrix.encoder.DataMatrixSymbolInfo144()};
        PROD_SYMBOLS = symbolInfoArr;
        symbols = symbolInfoArr;
    }

    public static void overrideSymbolSet(com.google.zxing.datamatrix.encoder.SymbolInfo[] symbolInfoArr) {
        symbols = symbolInfoArr;
    }

    public SymbolInfo(boolean z_renamed, int i_renamed, int i2, int i3, int i4, int i5) {
        this(z_renamed, i_renamed, i2, i3, i4, i5, i_renamed, i2);
    }

    SymbolInfo(boolean z_renamed, int i_renamed, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.rectangular = z_renamed;
        this.dataCapacity = i_renamed;
        this.errorCodewords = i2;
        this.matrixWidth = i3;
        this.matrixHeight = i4;
        this.dataRegions = i5;
        this.rsBlockData = i6;
        this.rsBlockError = i7;
    }

    public static com.google.zxing.datamatrix.encoder.SymbolInfo lookup(int i_renamed) {
        return lookup(i_renamed, com.google.zxing.datamatrix.encoder.SymbolShapeHint.FORCE_NONE, true);
    }

    public static com.google.zxing.datamatrix.encoder.SymbolInfo lookup(int i_renamed, com.google.zxing.datamatrix.encoder.SymbolShapeHint symbolShapeHint) {
        return lookup(i_renamed, symbolShapeHint, true);
    }

    public static com.google.zxing.datamatrix.encoder.SymbolInfo lookup(int i_renamed, boolean z_renamed, boolean z2) {
        return lookup(i_renamed, z_renamed ? com.google.zxing.datamatrix.encoder.SymbolShapeHint.FORCE_NONE : com.google.zxing.datamatrix.encoder.SymbolShapeHint.FORCE_SQUARE, z2);
    }

    private static com.google.zxing.datamatrix.encoder.SymbolInfo lookup(int i_renamed, com.google.zxing.datamatrix.encoder.SymbolShapeHint symbolShapeHint, boolean z_renamed) {
        return lookup(i_renamed, symbolShapeHint, null, null, z_renamed);
    }

    public static com.google.zxing.datamatrix.encoder.SymbolInfo lookup(int i_renamed, com.google.zxing.datamatrix.encoder.SymbolShapeHint symbolShapeHint, com.google.zxing.Dimension dimension, com.google.zxing.Dimension dimension2, boolean z_renamed) {
        for (com.google.zxing.datamatrix.encoder.SymbolInfo symbolInfo : symbols) {
            if (!(symbolShapeHint == com.google.zxing.datamatrix.encoder.SymbolShapeHint.FORCE_SQUARE && symbolInfo.rectangular) && ((symbolShapeHint != com.google.zxing.datamatrix.encoder.SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.rectangular) && ((dimension == null || (symbolInfo.getSymbolWidth() >= dimension.getWidth() && symbolInfo.getSymbolHeight() >= dimension.getHeight())) && ((dimension2 == null || (symbolInfo.getSymbolWidth() <= dimension2.getWidth() && symbolInfo.getSymbolHeight() <= dimension2.getHeight())) && i_renamed <= symbolInfo.dataCapacity)))) {
                return symbolInfo;
            }
        }
        if (z_renamed) {
            throw new java.lang.IllegalArgumentException("Can't_renamed find a_renamed symbol arrangement that matches the message. Data codewords: ".concat(java.lang.String.valueOf(i_renamed)));
        }
        return null;
    }

    private int getHorizontalDataRegions() {
        int i_renamed = this.dataRegions;
        int i2 = 1;
        if (i_renamed != 1) {
            i2 = 2;
            if (i_renamed != 2 && i_renamed != 4) {
                if (i_renamed == 16) {
                    return 4;
                }
                if (i_renamed == 36) {
                    return 6;
                }
                throw new java.lang.IllegalStateException("Cannot handle this number of_renamed data regions");
            }
        }
        return i2;
    }

    private int getVerticalDataRegions() {
        int i_renamed = this.dataRegions;
        if (i_renamed == 1 || i_renamed == 2) {
            return 1;
        }
        if (i_renamed == 4) {
            return 2;
        }
        if (i_renamed == 16) {
            return 4;
        }
        if (i_renamed == 36) {
            return 6;
        }
        throw new java.lang.IllegalStateException("Cannot handle this number of_renamed data regions");
    }

    public final int getSymbolDataWidth() {
        return getHorizontalDataRegions() * this.matrixWidth;
    }

    public final int getSymbolDataHeight() {
        return getVerticalDataRegions() * this.matrixHeight;
    }

    public final int getSymbolWidth() {
        return getSymbolDataWidth() + (getHorizontalDataRegions() << 1);
    }

    public final int getSymbolHeight() {
        return getSymbolDataHeight() + (getVerticalDataRegions() << 1);
    }

    public int getCodewordCount() {
        return this.dataCapacity + this.errorCodewords;
    }

    public int getInterleavedBlockCount() {
        return this.dataCapacity / this.rsBlockData;
    }

    public final int getDataCapacity() {
        return this.dataCapacity;
    }

    public final int getErrorCodewords() {
        return this.errorCodewords;
    }

    public int getDataLengthForInterleavedBlock(int i_renamed) {
        return this.rsBlockData;
    }

    public final int getErrorLengthForInterleavedBlock(int i_renamed) {
        return this.rsBlockError;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.rectangular ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.matrixWidth);
        sb.append('x_renamed');
        sb.append(this.matrixHeight);
        sb.append(", symbol size ");
        sb.append(getSymbolWidth());
        sb.append('x_renamed');
        sb.append(getSymbolHeight());
        sb.append(", symbol data size ");
        sb.append(getSymbolDataWidth());
        sb.append('x_renamed');
        sb.append(getSymbolDataHeight());
        sb.append(", codewords ");
        sb.append(this.dataCapacity);
        sb.append('+');
        sb.append(this.errorCodewords);
        return sb.toString();
    }
}
