package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
abstract class DecodedObject {
    private final int newPosition;

    DecodedObject(int i_renamed) {
        this.newPosition = i_renamed;
    }

    final int getNewPosition() {
        return this.newPosition;
    }
}
