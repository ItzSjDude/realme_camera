package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes.dex */
final class WebvttSubtitle implements com.google.android.exoplayer2.text.Subtitle {
    private final long[] cueTimesUs;
    private final java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCue> cues;
    private final int numCues;
    private final long[] sortedCueTimesUs;

    public WebvttSubtitle(java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCue> list) {
        this.cues = list;
        this.numCues = list.size();
        this.cueTimesUs = new long[this.numCues * 2];
        for (int i_renamed = 0; i_renamed < this.numCues; i_renamed++) {
            com.google.android.exoplayer2.text.webvtt.WebvttCue webvttCue = list.get(i_renamed);
            int i2 = i_renamed * 2;
            this.cueTimesUs[i2] = webvttCue.startTime;
            this.cueTimesUs[i2 + 1] = webvttCue.endTime;
        }
        long[] jArr = this.cueTimesUs;
        this.sortedCueTimesUs = java.util.Arrays.copyOf(jArr, jArr.length);
        java.util.Arrays.sort(this.sortedCueTimesUs);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j_renamed) {
        int iBinarySearchCeil = com.google.android.exoplayer2.util.Util.binarySearchCeil(this.sortedCueTimesUs, j_renamed, false, false);
        if (iBinarySearchCeil < this.sortedCueTimesUs.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.sortedCueTimesUs.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i_renamed) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed >= 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed < this.sortedCueTimesUs.length);
        return this.sortedCueTimesUs[i_renamed];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public java.util.List<com.google.android.exoplayer2.text.Cue> getCues(long j_renamed) {
        android.text.SpannableStringBuilder spannableStringBuilder = null;
        com.google.android.exoplayer2.text.webvtt.WebvttCue webvttCue = null;
        java.util.ArrayList arrayList = null;
        for (int i_renamed = 0; i_renamed < this.numCues; i_renamed++) {
            long[] jArr = this.cueTimesUs;
            int i2 = i_renamed * 2;
            if (jArr[i2] <= j_renamed && j_renamed < jArr[i2 + 1]) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                com.google.android.exoplayer2.text.webvtt.WebvttCue webvttCue2 = this.cues.get(i_renamed);
                if (!webvttCue2.isNormalCue()) {
                    arrayList.add(webvttCue2);
                } else if (webvttCue == null) {
                    webvttCue = webvttCue2;
                } else if (spannableStringBuilder == null) {
                    spannableStringBuilder = new android.text.SpannableStringBuilder();
                    spannableStringBuilder.append(webvttCue.text).append((java.lang.CharSequence) "\n_renamed").append(webvttCue2.text);
                } else {
                    spannableStringBuilder.append((java.lang.CharSequence) "\n_renamed").append(webvttCue2.text);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new com.google.android.exoplayer2.text.webvtt.WebvttCue(spannableStringBuilder));
        } else if (webvttCue != null) {
            arrayList.add(webvttCue);
        }
        return arrayList != null ? arrayList : java.util.Collections.emptyList();
    }
}
