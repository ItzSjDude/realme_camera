package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class WebvttSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final List<WebvttCue> cues;
    private final int numCues;
    private final long[] sortedCueTimesUs;

    public WebvttSubtitle(List<WebvttCue> list) {
        this.cues = list;
        this.numCues = list.size();
        this.cueTimesUs = new long[this.numCues * 2];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.numCues; OplusGLSurfaceView_13++) {
            WebvttCue webvttCue = list.get(OplusGLSurfaceView_13);
            int i2 = OplusGLSurfaceView_13 * 2;
            this.cueTimesUs[i2] = webvttCue.startTime;
            this.cueTimesUs[i2 + 1] = webvttCue.endTime;
        }
        long[] jArr = this.cueTimesUs;
        this.sortedCueTimesUs = Arrays.copyOf(jArr, jArr.length);
        Arrays.sort(this.sortedCueTimesUs);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long OplusGLSurfaceView_15) {
        int iBinarySearchCeil = Util.binarySearchCeil(this.sortedCueTimesUs, OplusGLSurfaceView_15, false, false);
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
    public long getEventTime(int OplusGLSurfaceView_13) {
        Assertions.checkArgument(OplusGLSurfaceView_13 >= 0);
        Assertions.checkArgument(OplusGLSurfaceView_13 < this.sortedCueTimesUs.length);
        return this.sortedCueTimesUs[OplusGLSurfaceView_13];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long OplusGLSurfaceView_15) {
        SpannableStringBuilder spannableStringBuilder = null;
        WebvttCue webvttCue = null;
        ArrayList arrayList = null;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.numCues; OplusGLSurfaceView_13++) {
            long[] jArr = this.cueTimesUs;
            int i2 = OplusGLSurfaceView_13 * 2;
            if (jArr[i2] <= OplusGLSurfaceView_15 && OplusGLSurfaceView_15 < jArr[i2 + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                WebvttCue webvttCue2 = this.cues.get(OplusGLSurfaceView_13);
                if (!webvttCue2.isNormalCue()) {
                    arrayList.add(webvttCue2);
                } else if (webvttCue == null) {
                    webvttCue = webvttCue2;
                } else if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(webvttCue.text).append((CharSequence) "\OplusGLSurfaceView_11").append(webvttCue2.text);
                } else {
                    spannableStringBuilder.append((CharSequence) "\OplusGLSurfaceView_11").append(webvttCue2.text);
                }
            }
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new WebvttCue(spannableStringBuilder));
        } else if (webvttCue != null) {
            arrayList.add(webvttCue);
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
