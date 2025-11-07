package com.google.android.exoplayer2.text.dvb;

/* loaded from: classes.dex */
final class DvbSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    private final java.util.List<com.google.android.exoplayer2.text.Cue> cues;

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i_renamed) {
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j_renamed) {
        return -1;
    }

    public DvbSubtitle(java.util.List<com.google.android.exoplayer2.text.Cue> list) {
        this.cues = list;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j_renamed) {
        return this.cues;
    }
}
