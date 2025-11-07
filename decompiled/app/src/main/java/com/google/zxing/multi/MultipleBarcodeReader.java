package com.google.zxing.multi;

/* loaded from: classes.dex */
public interface MultipleBarcodeReader {
    com.google.zxing.Result[] decodeMultiple(com.google.zxing.BinaryBitmap binaryBitmap) throws com.google.zxing.NotFoundException;

    com.google.zxing.Result[] decodeMultiple(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException;
}
