package com.google.android.exoplayer2.text.cea;

/* loaded from: classes.dex */
final class Cea708Cue extends com.google.android.exoplayer2.text.Cue implements java.lang.Comparable<com.google.android.exoplayer2.text.cea.Cea708Cue> {
    public static final int PRIORITY_UNSET = -1;
    public final int priority;

    public Cea708Cue(java.lang.CharSequence charSequence, android.text.Layout.Alignment alignment, float f_renamed, int i_renamed, int i2, float f2, int i3, float f3, boolean z_renamed, int i4, int i5) {
        super(charSequence, alignment, f_renamed, i_renamed, i2, f2, i3, f3, z_renamed, i4);
        this.priority = i5;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.android.exoplayer2.text.cea.Cea708Cue cea708Cue) {
        int i_renamed = cea708Cue.priority;
        int i2 = this.priority;
        if (i_renamed < i2) {
            return -1;
        }
        return i_renamed > i2 ? 1 : 0;
    }
}
