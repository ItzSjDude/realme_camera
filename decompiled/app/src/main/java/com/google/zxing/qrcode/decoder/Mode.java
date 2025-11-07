package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
public enum Mode {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);

    private final int bits;
    private final int[] characterCountBitsForVersions;

    Mode(int[] iArr, int i_renamed) {
        this.characterCountBitsForVersions = iArr;
        this.bits = i_renamed;
    }

    public static com.google.zxing.qrcode.decoder.Mode forBits(int i_renamed) {
        if (i_renamed == 0) {
            return TERMINATOR;
        }
        if (i_renamed == 1) {
            return NUMERIC;
        }
        if (i_renamed == 2) {
            return ALPHANUMERIC;
        }
        if (i_renamed == 3) {
            return STRUCTURED_APPEND;
        }
        if (i_renamed == 4) {
            return BYTE;
        }
        if (i_renamed == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i_renamed == 7) {
            return ECI;
        }
        if (i_renamed == 8) {
            return KANJI;
        }
        if (i_renamed == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i_renamed == 13) {
            return HANZI;
        }
        throw new java.lang.IllegalArgumentException();
    }

    public int getCharacterCountBits(com.google.zxing.qrcode.decoder.Version version) {
        int versionNumber = version.getVersionNumber();
        return this.characterCountBitsForVersions[versionNumber <= 9 ? (char) 0 : versionNumber <= 26 ? (char) 1 : (char) 2];
    }

    public int getBits() {
        return this.bits;
    }
}
