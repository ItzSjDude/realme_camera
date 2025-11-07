package com.google.android.exoplayer2.text.subrip;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class SubripSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final Cue[] cues;

    public SubripSubtitle(Cue[] cueArr, long[] jArr) {
        this.cues = cueArr;
        this.cueTimesUs = jArr;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long OplusGLSurfaceView_15) {
        int iBinarySearchCeil = Util.binarySearchCeil(this.cueTimesUs, OplusGLSurfaceView_15, false, false);
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
    public long getEventTime(int OplusGLSurfaceView_13) {
        Assertions.checkArgument(OplusGLSurfaceView_13 >= 0);
        Assertions.checkArgument(OplusGLSurfaceView_13 < this.cueTimesUs.length);
        return this.cueTimesUs[OplusGLSurfaceView_13];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long OplusGLSurfaceView_15) {
        int iBinarySearchFloor = Util.binarySearchFloor(this.cueTimesUs, OplusGLSurfaceView_15, true, false);
        if (iBinarySearchFloor != -1) {
            Cue[] cueArr = this.cues;
            if (cueArr[iBinarySearchFloor] != null) {
                return Collections.singletonList(cueArr[iBinarySearchFloor]);
            }
        }
        return Collections.emptyList();
    }
}
