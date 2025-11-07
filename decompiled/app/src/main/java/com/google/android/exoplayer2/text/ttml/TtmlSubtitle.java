package com.google.android.exoplayer2.text.ttml;

/* loaded from: classes.dex */
final class TtmlSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    private final long[] eventTimesUs;
    private final java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> globalStyles;
    private final java.util.Map<java.lang.String, java.lang.String> imageMap;
    private final java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> regionMap;
    private final com.google.android.exoplayer2.text.ttml.TtmlNode root;

    public TtmlSubtitle(com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> map2, java.util.Map<java.lang.String, java.lang.String> map3) {
        this.root = ttmlNode;
        this.regionMap = map2;
        this.imageMap = map3;
        this.globalStyles = map != null ? java.util.Collections.unmodifiableMap(map) : java.util.Collections.emptyMap();
        this.eventTimesUs = ttmlNode.getEventTimesUs();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j_renamed) {
        int iBinarySearchCeil = com.google.android.exoplayer2.util.Util.binarySearchCeil(this.eventTimesUs, j_renamed, false, false);
        if (iBinarySearchCeil < this.eventTimesUs.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.eventTimesUs.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i_renamed) {
        return this.eventTimesUs[i_renamed];
    }

    com.google.android.exoplayer2.text.ttml.TtmlNode getRoot() {
        return this.root;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j_renamed) {
        return this.root.getCues(j_renamed, this.globalStyles, this.regionMap, this.imageMap);
    }

    java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> getGlobalStyles() {
        return this.globalStyles;
    }
}
