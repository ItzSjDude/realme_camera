package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class BlockParsedResult {
    private final com.google.zxing.oned.rss.expanded.decoders.DecodedInformation decodedInformation;
    private final boolean finished;

    BlockParsedResult(boolean z_renamed) {
        this(null, z_renamed);
    }

    BlockParsedResult(com.google.zxing.oned.rss.expanded.decoders.DecodedInformation decodedInformation, boolean z_renamed) {
        this.finished = z_renamed;
        this.decodedInformation = decodedInformation;
    }

    com.google.zxing.oned.rss.expanded.decoders.DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }

    boolean isFinished() {
        return this.finished;
    }
}
