package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class DecodedChar extends com.google.zxing.oned.rss.expanded.decoders.DecodedObject {
    static final char FNC1 = '$';
    private final char value;

    DecodedChar(int i_renamed, char c2) {
        super(i_renamed);
        this.value = c2;
    }

    char getValue() {
        return this.value;
    }

    boolean isFNC1() {
        return this.value == '$';
    }
}
