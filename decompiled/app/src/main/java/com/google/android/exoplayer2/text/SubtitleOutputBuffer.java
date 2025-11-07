package com.google.android.exoplayer2.text;

/* loaded from: classes.dex */
public abstract class SubtitleOutputBuffer extends com.google.android.exoplayer2.decoder.OutputBuffer implements com.google.android.exoplayer2.text.Subtitle {
    private long subsampleOffsetUs;
    private com.google.android.exoplayer2.text.Subtitle subtitle;

    @Override // com.google.android.exoplayer2.decoder.OutputBuffer
    public abstract void release();

    public void setContent(long j_renamed, com.google.android.exoplayer2.text.Subtitle subtitle, long j2) {
        this.timeUs = j_renamed;
        this.subtitle = subtitle;
        if (j2 == Long.MAX_VALUE) {
            j2 = this.timeUs;
        }
        this.subsampleOffsetUs = j2;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.subtitle.getEventTimeCount();
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i_renamed) {
        return this.subtitle.getEventTime(i_renamed) + this.subsampleOffsetUs;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j_renamed) {
        return this.subtitle.getNextEventTimeIndex(j_renamed - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j_renamed) {
        return this.subtitle.getCues(j_renamed - this.subsampleOffsetUs);
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        this.subtitle = null;
    }
}
