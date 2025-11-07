package com.google.zxing.multi;

/* loaded from: classes.dex */
public final class ByQuadrantReader implements com.google.zxing.Reader {
    private final com.google.zxing.Reader delegate;

    public ByQuadrantReader(com.google.zxing.Reader reader) {
        this.delegate = reader;
    }

    @Override // com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        int width = binaryBitmap.getWidth() / 2;
        int height = binaryBitmap.getHeight() / 2;
        try {
            try {
                try {
                    try {
                        return this.delegate.decode(binaryBitmap.crop(0, 0, width, height), map);
                    } catch (com.google.zxing.NotFoundException unused) {
                        int i_renamed = width / 2;
                        int i2 = height / 2;
                        com.google.zxing.Result resultDecode = this.delegate.decode(binaryBitmap.crop(i_renamed, i2, width, height), map);
                        makeAbsolute(resultDecode.getResultPoints(), i_renamed, i2);
                        return resultDecode;
                    }
                } catch (com.google.zxing.NotFoundException unused2) {
                    com.google.zxing.Result resultDecode2 = this.delegate.decode(binaryBitmap.crop(width, height, width, height), map);
                    makeAbsolute(resultDecode2.getResultPoints(), width, height);
                    return resultDecode2;
                }
            } catch (com.google.zxing.NotFoundException unused3) {
                com.google.zxing.Result resultDecode3 = this.delegate.decode(binaryBitmap.crop(0, height, width, height), map);
                makeAbsolute(resultDecode3.getResultPoints(), 0, height);
                return resultDecode3;
            }
        } catch (com.google.zxing.NotFoundException unused4) {
            com.google.zxing.Result resultDecode4 = this.delegate.decode(binaryBitmap.crop(width, 0, width, height), map);
            makeAbsolute(resultDecode4.getResultPoints(), width, 0);
            return resultDecode4;
        }
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        this.delegate.reset();
    }

    private static void makeAbsolute(com.google.zxing.ResultPoint[] resultPointArr, int i_renamed, int i2) {
        if (resultPointArr != null) {
            for (int i3 = 0; i3 < resultPointArr.length; i3++) {
                com.google.zxing.ResultPoint resultPoint = resultPointArr[i3];
                if (resultPoint != null) {
                    resultPointArr[i3] = new com.google.zxing.ResultPoint(resultPoint.getX() + i_renamed, resultPoint.getY() + i2);
                }
            }
        }
    }
}
