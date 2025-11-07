package com.google.android.exoplayer2.text.ssa;

/* loaded from: classes.dex */
final class SsaSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    private final long[] cueTimesUs;
    private final com.google.android.exoplayer2.text.Cue[] cues;

    public SsaSubtitle(com.google.android.exoplayer2.text.Cue[] cueArr, long[] jArr) {
        this.cues = cueArr;
        this.cueTimesUs = jArr;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j_renamed) {
        int iBinarySearchCeil = com.google.android.exoplayer2.util.Util.binarySearchCeil(this.cueTimesUs, j_renamed, false, false);
        if (iBinarySearchCeil < this.cueTimesUs.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.cueTimesUs.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed >= 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed < this.cueTimesUs.length);
        return this.cueTimesUs[i_renamed];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j_renamed) {
        int iBinarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(this.cueTimesUs, j_renamed, true, false);
        if (iBinarySearchFloor != -1) {
            com.google.android.exoplayer2.text.Cue[] cueArr = this.cues;
            if (cueArr[iBinarySearchFloor] != null) {
                return java.util.Collections.singletonList(cueArr[iBinarySearchFloor]);
            }
        }
        return java.util.Collections.emptyList();
    }
}
