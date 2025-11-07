package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
final class BitMatrixParser {
    private final com.google.zxing.common.BitMatrix bitMatrix;

    /* renamed from: mirror, reason: collision with root package name */
    private boolean f3156mirror;
    private com.google.zxing.qrcode.decoder.FormatInformation parsedFormatInfo;
    private com.google.zxing.qrcode.decoder.Version parsedVersion;

    BitMatrixParser(com.google.zxing.common.BitMatrix bitMatrix) throws com.google.zxing.FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        this.bitMatrix = bitMatrix;
    }

    com.google.zxing.qrcode.decoder.FormatInformation readFormatInformation() throws com.google.zxing.FormatException {
        com.google.zxing.qrcode.decoder.FormatInformation formatInformation = this.parsedFormatInfo;
        if (formatInformation != null) {
            return formatInformation;
        }
        int iCopyBit = 0;
        int iCopyBit2 = 0;
        for (int i_renamed = 0; i_renamed < 6; i_renamed++) {
            iCopyBit2 = copyBit(i_renamed, 8, iCopyBit2);
        }
        int iCopyBit3 = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, iCopyBit2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iCopyBit3 = copyBit(8, i2, iCopyBit3);
        }
        int height = this.bitMatrix.getHeight();
        int i3 = height - 7;
        for (int i4 = height - 1; i4 >= i3; i4--) {
            iCopyBit = copyBit(8, i4, iCopyBit);
        }
        for (int i5 = height - 8; i5 < height; i5++) {
            iCopyBit = copyBit(i5, 8, iCopyBit);
        }
        this.parsedFormatInfo = com.google.zxing.qrcode.decoder.FormatInformation.decodeFormatInformation(iCopyBit3, iCopyBit);
        com.google.zxing.qrcode.decoder.FormatInformation formatInformation2 = this.parsedFormatInfo;
        if (formatInformation2 != null) {
            return formatInformation2;
        }
        throw com.google.zxing.FormatException.getFormatInstance();
    }

    com.google.zxing.qrcode.decoder.Version readVersion() throws com.google.zxing.FormatException {
        com.google.zxing.qrcode.decoder.Version version = this.parsedVersion;
        if (version != null) {
            return version;
        }
        int height = this.bitMatrix.getHeight();
        int i_renamed = (height - 17) / 4;
        if (i_renamed <= 6) {
            return com.google.zxing.qrcode.decoder.Version.getVersionForNumber(i_renamed);
        }
        int i2 = height - 11;
        int iCopyBit = 0;
        int iCopyBit2 = 0;
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i4 = height - 9; i4 >= i2; i4--) {
                iCopyBit2 = copyBit(i4, i3, iCopyBit2);
            }
        }
        com.google.zxing.qrcode.decoder.Version versionDecodeVersionInformation = com.google.zxing.qrcode.decoder.Version.decodeVersionInformation(iCopyBit2);
        if (versionDecodeVersionInformation != null && versionDecodeVersionInformation.getDimensionForVersion() == height) {
            this.parsedVersion = versionDecodeVersionInformation;
            return versionDecodeVersionInformation;
        }
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = height - 9; i6 >= i2; i6--) {
                iCopyBit = copyBit(i5, i6, iCopyBit);
            }
        }
        com.google.zxing.qrcode.decoder.Version versionDecodeVersionInformation2 = com.google.zxing.qrcode.decoder.Version.decodeVersionInformation(iCopyBit);
        if (versionDecodeVersionInformation2 != null && versionDecodeVersionInformation2.getDimensionForVersion() == height) {
            this.parsedVersion = versionDecodeVersionInformation2;
            return versionDecodeVersionInformation2;
        }
        throw com.google.zxing.FormatException.getFormatInstance();
    }

    private int copyBit(int i_renamed, int i2, int i3) {
        return this.f3156mirror ? this.bitMatrix.get(i2, i_renamed) : this.bitMatrix.get(i_renamed, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    byte[] readCodewords() throws com.google.zxing.FormatException {
        com.google.zxing.qrcode.decoder.FormatInformation formatInformation = readFormatInformation();
        com.google.zxing.qrcode.decoder.Version version = readVersion();
        com.google.zxing.qrcode.decoder.DataMask dataMask = com.google.zxing.qrcode.decoder.DataMask.values()[formatInformation.getDataMask()];
        int height = this.bitMatrix.getHeight();
        dataMask.unmaskBitMatrix(this.bitMatrix, height);
        com.google.zxing.common.BitMatrix bitMatrixBuildFunctionPattern = version.buildFunctionPattern();
        byte[] bArr = new byte[version.getTotalCodewords()];
        int i_renamed = height - 1;
        boolean z_renamed = true;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = i_renamed;
        while (i5 > 0) {
            if (i5 == 6) {
                i5--;
            }
            int i6 = i4;
            int i7 = i3;
            int i8 = i2;
            int i9 = 0;
            while (i9 < height) {
                int i10 = z_renamed ? i_renamed - i9 : i9;
                int i11 = i6;
                int i12 = i7;
                int i13 = i8;
                for (int i14 = 0; i14 < 2; i14++) {
                    int i15 = i5 - i14;
                    if (!bitMatrixBuildFunctionPattern.get(i15, i10)) {
                        i12++;
                        int i16 = i11 << 1;
                        int i17 = this.bitMatrix.get(i15, i10) ? i16 | 1 : i16;
                        if (i12 == 8) {
                            bArr[i13] = (byte) i17;
                            i13++;
                            i12 = 0;
                            i11 = 0;
                        } else {
                            i11 = i17;
                        }
                    }
                }
                i9++;
                i8 = i13;
                i7 = i12;
                i6 = i11;
            }
            z_renamed = !z_renamed;
            i5 -= 2;
            i2 = i8;
            i3 = i7;
            i4 = i6;
        }
        if (i2 == version.getTotalCodewords()) {
            return bArr;
        }
        throw com.google.zxing.FormatException.getFormatInstance();
    }

    void remask() {
        if (this.parsedFormatInfo == null) {
            return;
        }
        com.google.zxing.qrcode.decoder.DataMask.values()[this.parsedFormatInfo.getDataMask()].unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
    }

    void setMirror(boolean z_renamed) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.f3156mirror = z_renamed;
    }

    void mirror() {
        int i_renamed = 0;
        while (i_renamed < this.bitMatrix.getWidth()) {
            int i2 = i_renamed + 1;
            for (int i3 = i2; i3 < this.bitMatrix.getHeight(); i3++) {
                if (this.bitMatrix.get(i_renamed, i3) != this.bitMatrix.get(i3, i_renamed)) {
                    this.bitMatrix.flip(i3, i_renamed);
                    this.bitMatrix.flip(i_renamed, i3);
                }
            }
            i_renamed = i2;
        }
    }
}
