package com.google.zxing.oned;

/* loaded from: classes.dex */
public class Code93Writer extends com.google.zxing.oned.OneDimensionalCodeWriter {
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        if (barcodeFormat != com.google.zxing.BarcodeFormat.CODE_93) {
            throw new java.lang.IllegalArgumentException("Can only encode CODE_93, but got ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        return super.encode(str, barcodeFormat, i_renamed, i2, map);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        java.lang.String strConvertToExtended = convertToExtended(str);
        int length = strConvertToExtended.length();
        if (length > 80) {
            throw new java.lang.IllegalArgumentException("Requested contents should be_renamed less than 80 digits long after converting to extended encoding, but got ".concat(java.lang.String.valueOf(length)));
        }
        boolean[] zArr = new boolean[((strConvertToExtended.length() + 2 + 2) * 9) + 1];
        int iAppendPattern = appendPattern(zArr, 0, com.google.zxing.oned.Code93Reader.ASTERISK_ENCODING);
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            iAppendPattern += appendPattern(zArr, iAppendPattern, com.google.zxing.oned.Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(strConvertToExtended.charAt(i_renamed))]);
        }
        int iComputeChecksumIndex = computeChecksumIndex(strConvertToExtended, 20);
        int iAppendPattern2 = iAppendPattern + appendPattern(zArr, iAppendPattern, com.google.zxing.oned.Code93Reader.CHARACTER_ENCODINGS[iComputeChecksumIndex]);
        int iAppendPattern3 = iAppendPattern2 + appendPattern(zArr, iAppendPattern2, com.google.zxing.oned.Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex(strConvertToExtended + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(iComputeChecksumIndex), 15)]);
        zArr[iAppendPattern3 + appendPattern(zArr, iAppendPattern3, com.google.zxing.oned.Code93Reader.ASTERISK_ENCODING)] = true;
        return zArr;
    }

    @java.lang.Deprecated
    protected static int appendPattern(boolean[] zArr, int i_renamed, int[] iArr, boolean z_renamed) {
        int length = iArr.length;
        int i2 = i_renamed;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            zArr[i2] = iArr[i3] != 0;
            i3++;
            i2 = i4;
        }
        return 9;
    }

    private static int appendPattern(boolean[] zArr, int i_renamed, int i2) {
        for (int i3 = 0; i3 < 9; i3++) {
            boolean z_renamed = true;
            int i4 = i_renamed + i3;
            if (((1 << (8 - i3)) & i2) == 0) {
                z_renamed = false;
            }
            zArr[i4] = z_renamed;
        }
        return 9;
    }

    private static int computeChecksumIndex(java.lang.String str, int i_renamed) {
        int iIndexOf = 0;
        int i2 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i2;
            i2++;
            if (i2 > i_renamed) {
                i2 = 1;
            }
        }
        return iIndexOf % 47;
    }

    static java.lang.String convertToExtended(java.lang.String str) {
        int length = str.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length << 1);
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            char cCharAt = str.charAt(i_renamed);
            if (cCharAt == 0) {
                sb.append("bU_renamed");
            } else if (cCharAt <= 26) {
                sb.append('a_renamed');
                sb.append((char) ((cCharAt + 'A_renamed') - 1));
            } else if (cCharAt <= 31) {
                sb.append('b_renamed');
                sb.append((char) ((cCharAt + 'A_renamed') - 27));
            } else if (cCharAt == ' ' || cCharAt == '$' || cCharAt == '%' || cCharAt == '+') {
                sb.append(cCharAt);
            } else if (cCharAt <= ',') {
                sb.append('c_renamed');
                sb.append((char) ((cCharAt + 'A_renamed') - 33));
            } else if (cCharAt <= '9') {
                sb.append(cCharAt);
            } else if (cCharAt == ':') {
                sb.append("cZ_renamed");
            } else if (cCharAt <= '?') {
                sb.append('b_renamed');
                sb.append((char) ((cCharAt + 'F_renamed') - 59));
            } else if (cCharAt == '@') {
                sb.append("bV_renamed");
            } else if (cCharAt <= 'Z_renamed') {
                sb.append(cCharAt);
            } else if (cCharAt <= '_') {
                sb.append('b_renamed');
                sb.append((char) ((cCharAt + 'K_renamed') - 91));
            } else if (cCharAt == '`') {
                sb.append("bW_renamed");
            } else if (cCharAt <= 'z_renamed') {
                sb.append('d_renamed');
                sb.append((char) ((cCharAt + 'A_renamed') - 97));
            } else if (cCharAt <= 127) {
                sb.append('b_renamed');
                sb.append((char) ((cCharAt + 'P_renamed') - 123));
            } else {
                throw new java.lang.IllegalArgumentException("Requested content contains a_renamed non-encodable character: '" + cCharAt + "'");
            }
        }
        return sb.toString();
    }
}
