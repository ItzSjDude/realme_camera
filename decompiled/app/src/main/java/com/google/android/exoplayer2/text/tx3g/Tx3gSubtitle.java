package com.google.android.exoplayer2.text.tx3g;

/* loaded from: classes.dex */
final class Tx3gSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    public static final com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle EMPTY = new com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle();
    private final java.util.List<com.google.android.exoplayer2.text.Cue> cues;

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j_renamed) {
        return j_renamed < 0 ? 0 : -1;
    }

    public Tx3gSubtitle(com.google.android.exoplayer2.text.Cue cue) {
        this.cues = java.util.Collections.singletonList(cue);
    }

    private Tx3gSubtitle() {
        this.cues = java.util.Collections.emptyList();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j_renamed) {
        return j_renamed >= 0 ? this.cues : java.util.Collections.emptyList();
    }
}
