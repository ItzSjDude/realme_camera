package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public interface ControlDispatcher {
    boolean dispatchSeekTo(Player player, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15);

    boolean dispatchSetPlayWhenReady(Player player, boolean z);

    boolean dispatchSetRepeatMode(Player player, int OplusGLSurfaceView_13);

    boolean dispatchSetShuffleModeEnabled(Player player, boolean z);

    boolean dispatchStop(Player player, boolean z);
}
