package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class CurrentParsingState {
    private int position = 0;
    private com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState.State encoding = com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState.State.NUMERIC;

    private enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    CurrentParsingState() {
    }

    int getPosition() {
        return this.position;
    }

    void setPosition(int i_renamed) {
        this.position = i_renamed;
    }

    void incrementPosition(int i_renamed) {
        this.position += i_renamed;
    }

    boolean isAlpha() {
        return this.encoding == com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState.State.ALPHA;
    }

    boolean isNumeric() {
        return this.encoding == com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState.State.NUMERIC;
    }

    boolean isIsoIec646() {
        return this.encoding == com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState.State.ISO_IEC_646;
    }

    void setNumeric() {
        this.encoding = com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState.State.NUMERIC;
    }

    void setAlpha() {
        this.encoding = com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState.State.ALPHA;
    }

    void setIsoIec646() {
        this.encoding = com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState.State.ISO_IEC_646;
    }
}
