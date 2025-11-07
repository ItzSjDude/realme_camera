package com.google.zxing.multi;

/* loaded from: classes.dex */
public final class GenericMultipleBarcodeReader implements com.google.zxing.multi.MultipleBarcodeReader {
    static final com.google.zxing.Result[] EMPTY_RESULT_ARRAY = new com.google.zxing.Result[0];
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final com.google.zxing.Reader delegate;

    public GenericMultipleBarcodeReader(com.google.zxing.Reader reader) {
        this.delegate = reader;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public com.google.zxing.Result[] decodeMultiple(com.google.zxing.BinaryBitmap binaryBitmap) throws com.google.zxing.NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public com.google.zxing.Result[] decodeMultiple(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        return (com.google.zxing.Result[]) arrayList.toArray(EMPTY_RESULT_ARRAY);
    }

    private void doDecodeMultiple(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map, java.util.List<com.google.zxing.Result> list, int i_renamed, int i2, int i3) {
        boolean z_renamed;
        float f_renamed;
        int i4;
        int i5;
        if (i3 > 4) {
            return;
        }
        try {
            com.google.zxing.Result resultDecode = this.delegate.decode(binaryBitmap, map);
            java.util.Iterator<com.google.zxing.Result> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getText().equals(resultDecode.getText())) {
                        z_renamed = true;
                        break;
                    }
                } else {
                    z_renamed = false;
                    break;
                }
            }
            if (!z_renamed) {
                list.add(translateResultPoints(resultDecode, i_renamed, i2));
            }
            com.google.zxing.ResultPoint[] resultPoints = resultDecode.getResultPoints();
            if (resultPoints == null || resultPoints.length == 0) {
                return;
            }
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = height;
            float f5 = width;
            for (com.google.zxing.ResultPoint resultPoint : resultPoints) {
                if (resultPoint != null) {
                    float x_renamed = resultPoint.getX();
                    float y_renamed = resultPoint.getY();
                    if (x_renamed < f5) {
                        f5 = x_renamed;
                    }
                    if (y_renamed < f4) {
                        f4 = y_renamed;
                    }
                    if (x_renamed > f2) {
                        f2 = x_renamed;
                    }
                    if (y_renamed > f3) {
                        f3 = y_renamed;
                    }
                }
            }
            if (f5 > 100.0f) {
                f_renamed = f4;
                i4 = height;
                i5 = width;
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f5, height), map, list, i_renamed, i2, i3 + 1);
            } else {
                f_renamed = f4;
                i4 = height;
                i5 = width;
            }
            if (f_renamed > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(0, 0, i5, (int) f_renamed), map, list, i_renamed, i2, i3 + 1);
            }
            if (f2 < i5 - 100) {
                int i6 = (int) f2;
                doDecodeMultiple(binaryBitmap.crop(i6, 0, i5 - i6, i4), map, list, i_renamed + i6, i2, i3 + 1);
            }
            if (f3 < i4 - 100) {
                int i7 = (int) f3;
                doDecodeMultiple(binaryBitmap.crop(0, i7, i5, i4 - i7), map, list, i_renamed, i2 + i7, i3 + 1);
            }
        } catch (com.google.zxing.ReaderException unused) {
        }
    }

    private static com.google.zxing.Result translateResultPoints(com.google.zxing.Result result, int i_renamed, int i2) {
        com.google.zxing.ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        com.google.zxing.ResultPoint[] resultPointArr = new com.google.zxing.ResultPoint[resultPoints.length];
        for (int i3 = 0; i3 < resultPoints.length; i3++) {
            com.google.zxing.ResultPoint resultPoint = resultPoints[i3];
            if (resultPoint != null) {
                resultPointArr[i3] = new com.google.zxing.ResultPoint(resultPoint.getX() + i_renamed, resultPoint.getY() + i2);
            }
        }
        com.google.zxing.Result result2 = new com.google.zxing.Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }
}
