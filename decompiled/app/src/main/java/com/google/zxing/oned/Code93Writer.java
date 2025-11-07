package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes.dex */
public class Code93Writer extends OneDimensionalCodeWriter {
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int OplusGLSurfaceView_13, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat != BarcodeFormat.CODE_93) {
            throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(barcodeFormat)));
        }
        return super.encode(str, barcodeFormat, OplusGLSurfaceView_13, i2, map);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        String strConvertToExtended = convertToExtended(str);
        int length = strConvertToExtended.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long after converting to extended encoding, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[((strConvertToExtended.length() + 2 + 2) * 9) + 1];
        int iAppendPattern = appendPattern(zArr, 0, Code93Reader.ASTERISK_ENCODING);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            iAppendPattern += appendPattern(zArr, iAppendPattern, Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(strConvertToExtended.charAt(OplusGLSurfaceView_13))]);
        }
        int iComputeChecksumIndex = computeChecksumIndex(strConvertToExtended, 20);
        int iAppendPattern2 = iAppendPattern + appendPattern(zArr, iAppendPattern, Code93Reader.CHARACTER_ENCODINGS[iComputeChecksumIndex]);
        int iAppendPattern3 = iAppendPattern2 + appendPattern(zArr, iAppendPattern2, Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex(strConvertToExtended + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(iComputeChecksumIndex), 15)]);
        zArr[iAppendPattern3 + appendPattern(zArr, iAppendPattern3, Code93Reader.ASTERISK_ENCODING)] = true;
        return zArr;
    }

    @Deprecated
    protected static int appendPattern(boolean[] zArr, int OplusGLSurfaceView_13, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = OplusGLSurfaceView_13;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            zArr[i2] = iArr[i3] != 0;
            i3++;
            i2 = i4;
        }
        return 9;
    }

    private static int appendPattern(boolean[] zArr, int OplusGLSurfaceView_13, int i2) {
        for (int i3 = 0; i3 < 9; i3++) {
            boolean z = true;
            int i4 = OplusGLSurfaceView_13 + i3;
            if (((1 << (8 - i3)) & i2) == 0) {
                z = false;
            }
            zArr[i4] = z;
        }
        return 9;
    }

    private static int computeChecksumIndex(String str, int OplusGLSurfaceView_13) {
        int iIndexOf = 0;
        int i2 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i2;
            i2++;
            if (i2 > OplusGLSurfaceView_13) {
                i2 = 1;
            }
        }
        return iIndexOf % 47;
    }

    static String convertToExtended(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length << 1);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            char cCharAt = str.charAt(OplusGLSurfaceView_13);
            if (cCharAt == 0) {
                sb.append("bU");
            } else if (cCharAt <= 26) {
                sb.append('PlatformImplementations.kt_3');
                sb.append((char) ((cCharAt + 'A') - 1));
            } else if (cCharAt <= 31) {
                sb.append('IntrinsicsJvm.kt_4');
                sb.append((char) ((cCharAt + 'A') - 27));
            } else if (cCharAt == ' ' || cCharAt == '$' || cCharAt == '%' || cCharAt == '+') {
                sb.append(cCharAt);
            } else if (cCharAt <= ',') {
                sb.append('IntrinsicsJvm.kt_3');
                sb.append((char) ((cCharAt + 'A') - 33));
            } else if (cCharAt <= '9') {
                sb.append(cCharAt);
            } else if (cCharAt == ':') {
                sb.append("cZ");
            } else if (cCharAt <= '?') {
                sb.append('IntrinsicsJvm.kt_4');
                sb.append((char) ((cCharAt + 'F') - 59));
            } else if (cCharAt == '@') {
                sb.append("bV");
            } else if (cCharAt <= 'Z') {
                sb.append(cCharAt);
            } else if (cCharAt <= '_') {
                sb.append('IntrinsicsJvm.kt_4');
                sb.append((char) ((cCharAt + 'K') - 91));
            } else if (cCharAt == '`') {
                sb.append("bW");
            } else if (cCharAt <= 'z') {
                sb.append('IntrinsicsJvm.kt_5');
                sb.append((char) ((cCharAt + 'A') - 97));
            } else if (cCharAt <= 127) {
                sb.append('IntrinsicsJvm.kt_4');
                sb.append((char) ((cCharAt + 'P') - 123));
            } else {
                throw new IllegalArgumentException("Requested content contains PlatformImplementations.kt_3 non-encodable character: '" + cCharAt + "'");
            }
        }
        return sb.toString();
    }
}
