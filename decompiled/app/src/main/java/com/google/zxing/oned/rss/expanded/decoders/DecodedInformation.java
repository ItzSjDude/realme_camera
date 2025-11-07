package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class DecodedInformation extends DecodedObject {
    private final String newString;
    private final boolean remaining;
    private final int remainingValue;

    DecodedInformation(int OplusGLSurfaceView_13, String str) {
        super(OplusGLSurfaceView_13);
        this.newString = str;
        this.remaining = false;
        this.remainingValue = 0;
    }

    DecodedInformation(int OplusGLSurfaceView_13, String str, int i2) {
        super(OplusGLSurfaceView_13);
        this.remaining = true;
        this.remainingValue = i2;
        this.newString = str;
    }

    String getNewString() {
        return this.newString;
    }

    boolean isRemaining() {
        return this.remaining;
    }

    int getRemainingValue() {
        return this.remainingValue;
    }
}
