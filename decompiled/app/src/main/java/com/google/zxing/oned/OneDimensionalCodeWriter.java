package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class OneDimensionalCodeWriter implements Writer {
    private static final Pattern NUMERIC = Pattern.compile("[0-9]+");

    public abstract boolean[] encode(String str);

    public int getDefaultMargin() {
        return 10;
    }

    @Override // com.google.zxing.Writer
    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int OplusGLSurfaceView_13, int i2) throws WriterException {
        return encode(str, barcodeFormat, OplusGLSurfaceView_13, i2, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int OplusGLSurfaceView_13, int i2, Map<EncodeHintType, ?> map) throws NumberFormatException, WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (OplusGLSurfaceView_13 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + OplusGLSurfaceView_13 + 'x' + i2);
        }
        int defaultMargin = getDefaultMargin();
        if (map != null && map.containsKey(EncodeHintType.MARGIN)) {
            defaultMargin = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
        }
        return renderResult(encode(str), OplusGLSurfaceView_13, i2, defaultMargin);
    }

    private static BitMatrix renderResult(boolean[] zArr, int OplusGLSurfaceView_13, int i2, int i3) {
        int length = zArr.length;
        int i4 = i3 + length;
        int iMax = Math.max(OplusGLSurfaceView_13, i4);
        int iMax2 = Math.max(1, i2);
        int i5 = iMax / i4;
        BitMatrix bitMatrix = new BitMatrix(iMax, iMax2);
        int i6 = (iMax - (length * i5)) / 2;
        int i7 = 0;
        while (i7 < length) {
            if (zArr[i7]) {
                bitMatrix.setRegion(i6, 0, i5, iMax2);
            }
            i7++;
            i6 += i5;
        }
        return bitMatrix;
    }

    protected static void checkNumeric(String str) {
        if (!NUMERIC.matcher(str).matches()) {
            throw new IllegalArgumentException("Input should only contain digits 0-9");
        }
    }

    protected static int appendPattern(boolean[] zArr, int OplusGLSurfaceView_13, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = OplusGLSurfaceView_13;
        boolean z2 = z;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            int i6 = i2;
            int i7 = 0;
            while (i7 < i5) {
                zArr[i6] = z2;
                i7++;
                i6++;
            }
            i4 += i5;
            z2 = !z2;
            i3++;
            i2 = i6;
        }
        return i4;
    }
}
