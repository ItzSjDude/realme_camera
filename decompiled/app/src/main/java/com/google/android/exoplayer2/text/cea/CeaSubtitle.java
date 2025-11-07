package com.google.android.exoplayer2.text.cea;

/* loaded from: classes.dex */
final class CeaSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    private final java.util.List<com.google.android.exoplayer2.text.Cue> cues;

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j_renamed) {
        return j_renamed < 0 ? 0 : -1;
    }

    public CeaSubtitle(java.util.List<com.google.android.exoplayer2.text.Cue> list) {
        this.cues = list;
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
