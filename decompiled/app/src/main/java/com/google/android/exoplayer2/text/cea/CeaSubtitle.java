package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class CeaSubtitle implements Subtitle {
    private final List<Cue> cues;

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long OplusGLSurfaceView_15) {
        return OplusGLSurfaceView_15 < 0 ? 0 : -1;
    }

    public CeaSubtitle(List<Cue> list) {
        this.cues = list;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int OplusGLSurfaceView_13) {
        Assertions.checkArgument(OplusGLSurfaceView_13 == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long OplusGLSurfaceView_15) {
        return OplusGLSurfaceView_15 >= 0 ? this.cues : Collections.emptyList();
    }
}
