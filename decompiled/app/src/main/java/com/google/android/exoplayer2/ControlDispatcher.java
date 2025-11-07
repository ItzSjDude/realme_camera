package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public interface ControlDispatcher {
    boolean dispatchSeekTo(com.google.android.exoplayer2.Player player, int i_renamed, long j_renamed);

    boolean dispatchSetPlayWhenReady(com.google.android.exoplayer2.Player player, boolean z_renamed);

    boolean dispatchSetRepeatMode(com.google.android.exoplayer2.Player player, int i_renamed);

    boolean dispatchSetShuffleModeEnabled(com.google.android.exoplayer2.Player player, boolean z_renamed);

    boolean dispatchStop(com.google.android.exoplayer2.Player player, boolean z_renamed);
}
