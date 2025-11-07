package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public class DefaultControlDispatcher implements com.google.android.exoplayer2.ControlDispatcher {
    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetPlayWhenReady(com.google.android.exoplayer2.Player player, boolean z_renamed) {
        player.setPlayWhenReady(z_renamed);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSeekTo(com.google.android.exoplayer2.Player player, int i_renamed, long j_renamed) {
        player.seekTo(i_renamed, j_renamed);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetRepeatMode(com.google.android.exoplayer2.Player player, int i_renamed) {
        player.setRepeatMode(i_renamed);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchSetShuffleModeEnabled(com.google.android.exoplayer2.Player player, boolean z_renamed) {
        player.setShuffleModeEnabled(z_renamed);
        return true;
    }

    @Override // com.google.android.exoplayer2.ControlDispatcher
    public boolean dispatchStop(com.google.android.exoplayer2.Player player, boolean z_renamed) {
        player.stop(z_renamed);
        return true;
    }
}
