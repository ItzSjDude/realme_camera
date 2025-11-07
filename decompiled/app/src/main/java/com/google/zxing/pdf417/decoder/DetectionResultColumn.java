package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* loaded from: classes.dex */
class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final BoundingBox boundingBox;
    private final Codeword[] codewords;

    DetectionResultColumn(BoundingBox boundingBox) {
        this.boundingBox = new BoundingBox(boundingBox);
        this.codewords = new Codeword[(boundingBox.getMaxY() - boundingBox.getMinY()) + 1];
    }

    final Codeword getCodewordNearby(int OplusGLSurfaceView_13) {
        Codeword codeword;
        Codeword codeword2;
        Codeword codeword3 = getCodeword(OplusGLSurfaceView_13);
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iImageRowToCodewordIndex = imageRowToCodewordIndex(OplusGLSurfaceView_13) - i2;
            if (iImageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[iImageRowToCodewordIndex]) != null) {
                return codeword2;
            }
            int iImageRowToCodewordIndex2 = imageRowToCodewordIndex(OplusGLSurfaceView_13) + i2;
            Codeword[] codewordArr = this.codewords;
            if (iImageRowToCodewordIndex2 < codewordArr.length && (codeword = codewordArr[iImageRowToCodewordIndex2]) != null) {
                return codeword;
            }
        }
        return null;
    }

    final int imageRowToCodewordIndex(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 - this.boundingBox.getMinY();
    }

    final void setCodeword(int OplusGLSurfaceView_13, Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(OplusGLSurfaceView_13)] = codeword;
    }

    final Codeword getCodeword(int OplusGLSurfaceView_13) {
        return this.codewords[imageRowToCodewordIndex(OplusGLSurfaceView_13)];
    }

    final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    final Codeword[] getCodewords() {
        return this.codewords;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        Throwable th = null;
        try {
            int OplusGLSurfaceView_13 = 0;
            for (Codeword codeword : this.codewords) {
                if (codeword == null) {
                    formatter.format("%3d:    |   %OplusGLSurfaceView_11", Integer.valueOf(OplusGLSurfaceView_13));
                    OplusGLSurfaceView_13++;
                } else {
                    formatter.format("%3d: %3d|%3d%OplusGLSurfaceView_11", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                    OplusGLSurfaceView_13++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
            } else {
                formatter.close();
            }
            throw th2;
        }
    }
}
