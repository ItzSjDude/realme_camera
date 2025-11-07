package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import com.google.android.exoplayer2.text.Cue;

/* loaded from: classes.dex */
final class Cea708Cue extends Cue implements Comparable<Cea708Cue> {
    public static final int PRIORITY_UNSET = -1;
    public final int priority;

    public Cea708Cue(CharSequence charSequence, Layout.Alignment alignment, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
        super(charSequence, alignment, COUIBaseListPopupWindow_12, OplusGLSurfaceView_13, i2, f2, i3, f3, z, i4);
        this.priority = i5;
    }

    @Override // java.lang.Comparable
    public int compareTo(Cea708Cue cea708Cue) {
        int OplusGLSurfaceView_13 = cea708Cue.priority;
        int i2 = this.priority;
        if (OplusGLSurfaceView_13 < i2) {
            return -1;
        }
        return OplusGLSurfaceView_13 > i2 ? 1 : 0;
    }
}
