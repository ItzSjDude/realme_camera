package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final com.google.zxing.pdf417.decoder.BoundingBox boundingBox;
    private final com.google.zxing.pdf417.decoder.Codeword[] codewords;

    DetectionResultColumn(com.google.zxing.pdf417.decoder.BoundingBox boundingBox) {
        this.boundingBox = new com.google.zxing.pdf417.decoder.BoundingBox(boundingBox);
        this.codewords = new com.google.zxing.pdf417.decoder.Codeword[(boundingBox.getMaxY() - boundingBox.getMinY()) + 1];
    }

    final com.google.zxing.pdf417.decoder.Codeword getCodewordNearby(int i_renamed) {
        com.google.zxing.pdf417.decoder.Codeword codeword;
        com.google.zxing.pdf417.decoder.Codeword codeword2;
        com.google.zxing.pdf417.decoder.Codeword codeword3 = getCodeword(i_renamed);
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iImageRowToCodewordIndex = imageRowToCodewordIndex(i_renamed) - i2;
            if (iImageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[iImageRowToCodewordIndex]) != null) {
                return codeword2;
            }
            int iImageRowToCodewordIndex2 = imageRowToCodewordIndex(i_renamed) + i2;
            com.google.zxing.pdf417.decoder.Codeword[] codewordArr = this.codewords;
            if (iImageRowToCodewordIndex2 < codewordArr.length && (codeword = codewordArr[iImageRowToCodewordIndex2]) != null) {
                return codeword;
            }
        }
        return null;
    }

    final int imageRowToCodewordIndex(int i_renamed) {
        return i_renamed - this.boundingBox.getMinY();
    }

    final void setCodeword(int i_renamed, com.google.zxing.pdf417.decoder.Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(i_renamed)] = codeword;
    }

    final com.google.zxing.pdf417.decoder.Codeword getCodeword(int i_renamed) {
        return this.codewords[imageRowToCodewordIndex(i_renamed)];
    }

    final com.google.zxing.pdf417.decoder.BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    final com.google.zxing.pdf417.decoder.Codeword[] getCodewords() {
        return this.codewords;
    }

    public java.lang.String toString() {
        java.util.Formatter formatter = new java.util.Formatter();
        java.lang.Throwable th = null;
        try {
            int i_renamed = 0;
            for (com.google.zxing.pdf417.decoder.Codeword codeword : this.codewords) {
                if (codeword == null) {
                    formatter.format("%3d:    |   %n_renamed", java.lang.Integer.valueOf(i_renamed));
                    i_renamed++;
                } else {
                    formatter.format("%3d: %3d|%3d%n_renamed", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(codeword.getRowNumber()), java.lang.Integer.valueOf(codeword.getValue()));
                    i_renamed++;
                }
            }
            java.lang.String string = formatter.toString();
            formatter.close();
            return string;
        } catch (java.lang.Throwable th2) {
            if (0 != 0) {
                try {
                    formatter.close();
                } catch (java.lang.Throwable th3) {
                    th.addSuppressed(th3);
                }
            } else {
                formatter.close();
            }
            throw th2;
        }
    }
}
