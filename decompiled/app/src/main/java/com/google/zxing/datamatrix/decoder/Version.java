package com.google.zxing.datamatrix.decoder;

/* loaded from: classes.dex */
public final class Version {
    private static final com.google.zxing.datamatrix.decoder.Version[] VERSIONS = buildVersions();
    private final int dataRegionSizeColumns;
    private final int dataRegionSizeRows;
    private final com.google.zxing.datamatrix.decoder.Version.ECBlocks ecBlocks;
    private final int symbolSizeColumns;
    private final int symbolSizeRows;
    private final int totalCodewords;
    private final int versionNumber;

    private Version(int i_renamed, int i2, int i3, int i4, int i5, com.google.zxing.datamatrix.decoder.Version.ECBlocks eCBlocks) {
        this.versionNumber = i_renamed;
        this.symbolSizeRows = i2;
        this.symbolSizeColumns = i3;
        this.dataRegionSizeRows = i4;
        this.dataRegionSizeColumns = i5;
        this.ecBlocks = eCBlocks;
        int eCCodewords = eCBlocks.getECCodewords();
        int count = 0;
        for (com.google.zxing.datamatrix.decoder.Version.ECB ecb : eCBlocks.getECBlocks()) {
            count += ecb.getCount() * (ecb.getDataCodewords() + eCCodewords);
        }
        this.totalCodewords = count;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public int getSymbolSizeRows() {
        return this.symbolSizeRows;
    }

    public int getSymbolSizeColumns() {
        return this.symbolSizeColumns;
    }

    public int getDataRegionSizeRows() {
        return this.dataRegionSizeRows;
    }

    public int getDataRegionSizeColumns() {
        return this.dataRegionSizeColumns;
    }

    public int getTotalCodewords() {
        return this.totalCodewords;
    }

    com.google.zxing.datamatrix.decoder.Version.ECBlocks getECBlocks() {
        return this.ecBlocks;
    }

    public static com.google.zxing.datamatrix.decoder.Version getVersionForDimensions(int i_renamed, int i2) throws com.google.zxing.FormatException {
        if ((i_renamed & 1) != 0 || (i2 & 1) != 0) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        for (com.google.zxing.datamatrix.decoder.Version version : VERSIONS) {
            if (version.symbolSizeRows == i_renamed && version.symbolSizeColumns == i2) {
                return version;
            }
        }
        throw com.google.zxing.FormatException.getFormatInstance();
    }

    static final class ECBlocks {
        private final com.google.zxing.datamatrix.decoder.Version.ECB[] ecBlocks;
        private final int ecCodewords;

        private ECBlocks(int i_renamed, com.google.zxing.datamatrix.decoder.Version.ECB ecb) {
            this.ecCodewords = i_renamed;
            this.ecBlocks = new com.google.zxing.datamatrix.decoder.Version.ECB[]{ecb};
        }

        private ECBlocks(int i_renamed, com.google.zxing.datamatrix.decoder.Version.ECB ecb, com.google.zxing.datamatrix.decoder.Version.ECB ecb2) {
            this.ecCodewords = i_renamed;
            this.ecBlocks = new com.google.zxing.datamatrix.decoder.Version.ECB[]{ecb, ecb2};
        }

        int getECCodewords() {
            return this.ecCodewords;
        }

        com.google.zxing.datamatrix.decoder.Version.ECB[] getECBlocks() {
            return this.ecBlocks;
        }
    }

    static final class ECB {
        private final int count;
        private final int dataCodewords;

        private ECB(int i_renamed, int i2) {
            this.count = i_renamed;
            this.dataCodewords = i2;
        }

        int getCount() {
            return this.count;
        }

        int getDataCodewords() {
            return this.dataCodewords;
        }
    }

    public java.lang.String toString() {
        return java.lang.String.valueOf(this.versionNumber);
    }

    private static com.google.zxing.datamatrix.decoder.Version[] buildVersions() {
        int i_renamed = 1;
        int i2 = 5;
        int i3 = 8;
        int i4 = 7;
        com.google.zxing.datamatrix.decoder.Version version = new com.google.zxing.datamatrix.decoder.Version(3, 14, 14, 12, 12, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(10, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, i3)));
        int i5 = 2;
        int i6 = 12;
        int i7 = 18;
        com.google.zxing.datamatrix.decoder.Version version2 = new com.google.zxing.datamatrix.decoder.Version(5, 18, 18, 16, 16, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(14, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, i7)));
        int i8 = 4;
        com.google.zxing.datamatrix.decoder.Version version3 = new com.google.zxing.datamatrix.decoder.Version(7, 22, 22, 20, 20, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(20, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 30)));
        int i9 = 6;
        com.google.zxing.datamatrix.decoder.Version.ECB ecb = new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 36);
        com.google.zxing.datamatrix.decoder.Version.ECB ecb2 = new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 44);
        com.google.zxing.datamatrix.decoder.Version.ECB ecb3 = new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 62);
        com.google.zxing.datamatrix.decoder.Version.ECB ecb4 = new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 86);
        com.google.zxing.datamatrix.decoder.Version.ECB ecb5 = new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 114);
        com.google.zxing.datamatrix.decoder.Version.ECB ecb6 = new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 144);
        int i10 = 56;
        com.google.zxing.datamatrix.decoder.Version.ECB ecb7 = new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 174);
        com.google.zxing.datamatrix.decoder.Version version4 = new com.google.zxing.datamatrix.decoder.Version(15, 52, 52, 24, 24, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(42, new com.google.zxing.datamatrix.decoder.Version.ECB(i5, 102)));
        com.google.zxing.datamatrix.decoder.Version.ECB ecb8 = new com.google.zxing.datamatrix.decoder.Version.ECB(i8, 92);
        com.google.zxing.datamatrix.decoder.Version.ECB ecb9 = new com.google.zxing.datamatrix.decoder.Version.ECB(i8, 114);
        com.google.zxing.datamatrix.decoder.Version.ECB ecb10 = new com.google.zxing.datamatrix.decoder.Version.ECB(i8, 174);
        com.google.zxing.datamatrix.decoder.Version.ECB ecb11 = new com.google.zxing.datamatrix.decoder.Version.ECB(i9, 175);
        return new com.google.zxing.datamatrix.decoder.Version[]{new com.google.zxing.datamatrix.decoder.Version(1, 10, 10, 8, 8, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(i2, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 3))), new com.google.zxing.datamatrix.decoder.Version(2, 12, 12, 10, 10, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(i4, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, i2))), version, new com.google.zxing.datamatrix.decoder.Version(4, 16, 16, 14, 14, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(i6, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, i6))), version2, new com.google.zxing.datamatrix.decoder.Version(6, 20, 20, 18, 18, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(i7, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 22))), version3, new com.google.zxing.datamatrix.decoder.Version(8, 24, 24, 22, 22, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(24, ecb)), new com.google.zxing.datamatrix.decoder.Version(9, 26, 26, 24, 24, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(28, ecb2)), new com.google.zxing.datamatrix.decoder.Version(10, 32, 32, 14, 14, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(36, ecb3)), new com.google.zxing.datamatrix.decoder.Version(11, 36, 36, 16, 16, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(42, ecb4)), new com.google.zxing.datamatrix.decoder.Version(12, 40, 40, 18, 18, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(48, ecb5)), new com.google.zxing.datamatrix.decoder.Version(13, 44, 44, 20, 20, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(i10, ecb6)), new com.google.zxing.datamatrix.decoder.Version(14, 48, 48, 22, 22, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(68, ecb7)), version4, new com.google.zxing.datamatrix.decoder.Version(16, 64, 64, 14, 14, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(i10, new com.google.zxing.datamatrix.decoder.Version.ECB(i5, 140))), new com.google.zxing.datamatrix.decoder.Version(17, 72, 72, 16, 16, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(36, ecb8)), new com.google.zxing.datamatrix.decoder.Version(18, 80, 80, 18, 18, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(48, ecb9)), new com.google.zxing.datamatrix.decoder.Version(19, 88, 88, 20, 20, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(i10, new com.google.zxing.datamatrix.decoder.Version.ECB(i8, 144))), new com.google.zxing.datamatrix.decoder.Version(20, 96, 96, 22, 22, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(68, ecb10)), new com.google.zxing.datamatrix.decoder.Version(21, 104, 104, 24, 24, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(i10, new com.google.zxing.datamatrix.decoder.Version.ECB(i9, 136))), new com.google.zxing.datamatrix.decoder.Version(22, 120, 120, 18, 18, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(68, ecb11)), new com.google.zxing.datamatrix.decoder.Version(23, 132, 132, 20, 20, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(62, new com.google.zxing.datamatrix.decoder.Version.ECB(i3, 163))), new com.google.zxing.datamatrix.decoder.Version(24, 144, 144, 22, 22, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(62, new com.google.zxing.datamatrix.decoder.Version.ECB(i3, 156), new com.google.zxing.datamatrix.decoder.Version.ECB(i5, 155))), new com.google.zxing.datamatrix.decoder.Version(25, 8, 18, 6, 16, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(i4, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, i2))), new com.google.zxing.datamatrix.decoder.Version(26, 8, 32, 6, 14, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(11, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 10))), new com.google.zxing.datamatrix.decoder.Version(27, 12, 26, 10, 24, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(14, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 16))), new com.google.zxing.datamatrix.decoder.Version(28, 12, 36, 10, 16, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(i7, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 22))), new com.google.zxing.datamatrix.decoder.Version(29, 16, 36, 14, 16, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(24, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 32))), new com.google.zxing.datamatrix.decoder.Version(30, 16, 48, 14, 22, new com.google.zxing.datamatrix.decoder.Version.ECBlocks(28, new com.google.zxing.datamatrix.decoder.Version.ECB(i_renamed, 49)))};
    }
}
