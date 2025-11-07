package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class OneDReader implements Reader {
    public abstract Result decodeRow(int OplusGLSurfaceView_13, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException COUIBaseListPopupWindow_8) {
            if ((map != null && map.containsKey(DecodeHintType.TRY_HARDER)) && binaryBitmap.isRotateSupported()) {
                BinaryBitmap binaryBitmapRotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
                Result resultDoDecode = this.doDecode(binaryBitmapRotateCounterClockwise, map);
                Map<ResultMetadataType, Object> resultMetadata = resultDoDecode.getResultMetadata();
                int iIntValue = 270;
                if (resultMetadata != null && resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                    iIntValue = (((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
                }
                resultDoDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(iIntValue));
                ResultPoint[] resultPoints = resultDoDecode.getResultPoints();
                if (resultPoints != null) {
                    int height = binaryBitmapRotateCounterClockwise.getHeight();
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < resultPoints.length; OplusGLSurfaceView_13++) {
                        resultPoints[OplusGLSurfaceView_13] = new ResultPoint((height - resultPoints[OplusGLSurfaceView_13].getY()) - 1.0f, resultPoints[OplusGLSurfaceView_13].getX());
                    }
                }
                return resultDoDecode;
            }
            throw COUIBaseListPopupWindow_8;
        }
    }

    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        int i4;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        int i5 = 0;
        int i6 = 1;
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int iMax = Math.max(1, height >> (z ? 8 : 5));
        int i7 = z ? height : 15;
        int i8 = height / 2;
        Map<DecodeHintType, ?> map2 = map;
        int i9 = 0;
        while (i9 < i7) {
            int i10 = i9 + 1;
            int i11 = i10 / 2;
            if (((i9 & 1) == 0 ? i6 : i5) == 0) {
                i11 = -i11;
            }
            int i12 = (i11 * iMax) + i8;
            if (i12 < 0 || i12 >= height) {
                break;
            }
            try {
                bitArray = binaryBitmap.getBlackRow(i12, bitArray);
                Map<DecodeHintType, ?> map3 = map2;
                int i13 = i5;
                while (i13 < 2) {
                    if (i13 == i6) {
                        bitArray.reverse();
                        if (map3 != null && map3.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                            EnumMap enumMap = new EnumMap(DecodeHintType.class);
                            enumMap.putAll(map3);
                            enumMap.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                            map3 = enumMap;
                        }
                    }
                    try {
                        Result resultDecodeRow = decodeRow(i12, bitArray, map3);
                        if (i13 == i6) {
                            try {
                                resultDecodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                ResultPoint[] resultPoints = resultDecodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    float COUIBaseListPopupWindow_12 = width;
                                    i3 = width;
                                    try {
                                        resultPoints[0] = new ResultPoint((COUIBaseListPopupWindow_12 - resultPoints[i5].getX()) - 1.0f, resultPoints[i5].getY());
                                        i4 = 1;
                                    } catch (ReaderException unused) {
                                        i4 = 1;
                                        i13++;
                                        i6 = i4;
                                        width = i3;
                                        i5 = 0;
                                    }
                                    try {
                                        resultPoints[1] = new ResultPoint((COUIBaseListPopupWindow_12 - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                    } catch (ReaderException unused2) {
                                        continue;
                                        i13++;
                                        i6 = i4;
                                        width = i3;
                                        i5 = 0;
                                    }
                                }
                            } catch (ReaderException unused3) {
                                i3 = width;
                            }
                        }
                        return resultDecodeRow;
                    } catch (ReaderException unused4) {
                        i3 = width;
                        i4 = i6;
                    }
                }
                OplusGLSurfaceView_13 = width;
                i2 = i6;
                map2 = map3;
            } catch (NotFoundException unused5) {
                OplusGLSurfaceView_13 = width;
                i2 = i6;
            }
            i9 = i10;
            i6 = i2;
            width = OplusGLSurfaceView_13;
            i5 = 0;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void recordPattern(BitArray bitArray, int OplusGLSurfaceView_13, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (OplusGLSurfaceView_13 >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = !bitArray.get(OplusGLSurfaceView_13);
        int i2 = 0;
        while (OplusGLSurfaceView_13 < size) {
            if (bitArray.get(OplusGLSurfaceView_13) == z) {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            } else {
                iArr[i2] = iArr[i2] + 1;
            }
            OplusGLSurfaceView_13++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || OplusGLSurfaceView_13 != size) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    protected static void recordPatternInReverse(BitArray bitArray, int OplusGLSurfaceView_13, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z = bitArray.get(OplusGLSurfaceView_13);
        while (OplusGLSurfaceView_13 > 0 && length >= 0) {
            OplusGLSurfaceView_13--;
            if (bitArray.get(OplusGLSurfaceView_13) != z) {
                length--;
                z = !z;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, OplusGLSurfaceView_13 + 1, iArr);
    }

    protected static float patternMatchVariance(int[] iArr, int[] iArr2, float COUIBaseListPopupWindow_12) {
        int length = iArr.length;
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            OplusGLSurfaceView_13 += iArr[i3];
            i2 += iArr2[i3];
        }
        if (OplusGLSurfaceView_13 < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = OplusGLSurfaceView_13;
        float f3 = f2 / i2;
        float f4 = COUIBaseListPopupWindow_12 * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
