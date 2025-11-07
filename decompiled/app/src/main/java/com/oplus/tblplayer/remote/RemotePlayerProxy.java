package com.oplus.tblplayer.remote;

/* loaded from: classes2.dex */
public abstract class RemotePlayerProxy extends com.oplus.tblplayer.AbstractMediaPlayer {
    private static final java.lang.String TAG = "RemotePlayerProxy";
    private java.util.ArrayList<android.util.Pair<java.lang.Integer, java.lang.Object[]>> mPendingTaskStack;
    protected android.os.IBinder mRemotePlayer;
    protected com.oplus.tblplayer.remote.RemoteSurfaceCache mSurfaceCache = new com.oplus.tblplayer.remote.RemoteSurfaceCache(this);

    protected abstract <T_renamed> T_renamed execRemoteMethod(int i_renamed, T_renamed t_renamed, java.lang.Object... objArr);

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getNetSpeed() {
        return 0L;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLogEnabled(boolean z_renamed) {
    }

    protected abstract boolean shouldInvoke();

    protected abstract boolean shouldPending();

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDisplay(android.view.SurfaceHolder surfaceHolder) {
        com.oplus.tblplayer.remote.RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoSurfaceHolder(surfaceHolder);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setSurface(android.view.Surface surface) {
        com.oplus.tblplayer.remote.RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoSurface(surface);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoSurfaceView(android.view.SurfaceView surfaceView) {
        com.oplus.tblplayer.remote.RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoSurfaceView(android.view.SurfaceView surfaceView) {
        com.oplus.tblplayer.remote.RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.clearVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoTextureView(android.view.TextureView textureView) {
        com.oplus.tblplayer.remote.RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoTextureView(textureView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoTextureView(android.view.TextureView textureView) {
        com.oplus.tblplayer.remote.RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.clearVideoTextureView(textureView);
        }
    }

    protected void updateSurface(android.view.Surface surface) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "updateSurface: surface is_renamed " + surface);
        invokeRemoteMethod(35, surface);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(android.net.Uri uri) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setDataSource: uri is_renamed " + uri);
        invokeRemoteMethod(2, uri);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        invokeRemoteMethod(3, uri, map);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(java.io.FileDescriptor fileDescriptor) throws java.lang.IllegalStateException, java.io.IOException, java.lang.IllegalArgumentException {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(java.lang.String str) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setDataSource: path is_renamed " + str);
        invokeRemoteMethod(1, str);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(com.oplus.tblplayer.misc.IMediaDataSource iMediaDataSource) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public java.lang.String getDataSource() {
        return (java.lang.String) invokeRemoteMethodNotPending(6, null, new java.lang.Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void prepareAsync() throws java.lang.IllegalStateException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "prepareAsync");
        invokeRemoteMethod(7, new java.lang.Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void start() throws java.lang.IllegalStateException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, com.google.android.exoplayer2.text.ttml.TtmlNode.START);
        invokeRemoteMethod(8, new java.lang.Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void stop() throws java.lang.IllegalStateException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "stop");
        invokeRemoteMethod(9, new java.lang.Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void pause() throws java.lang.IllegalStateException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, com.oplus.camera.statistics.model.VideoRecordMsgData.EVENT_PAUSE);
        invokeRemoteMethod(10, new java.lang.Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z_renamed) {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "setScreenOnWhilePlaying");
        invokeRemoteMethod(29, java.lang.Boolean.valueOf(z_renamed));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoWidth() {
        return ((java.lang.Integer) invokeRemoteMethodNotPending(30, 0, new java.lang.Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoHeight() {
        return ((java.lang.Integer) invokeRemoteMethodNotPending(31, 0, new java.lang.Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlaying() {
        return ((java.lang.Boolean) invokeRemoteMethodNotPending(12, false, new java.lang.Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isStop() {
        return ((java.lang.Boolean) invokeRemoteMethodNotPending(38, false, new java.lang.Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPause() {
        return ((java.lang.Boolean) invokeRemoteMethodNotPending(37, false, new java.lang.Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getPlaybackState() {
        return ((java.lang.Integer) invokeRemoteMethodNotPending(42, 1, new java.lang.Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void seekTo(long j_renamed) throws java.lang.IllegalStateException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "seekTo");
        invokeRemoteMethod(11, java.lang.Long.valueOf(j_renamed));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getCurrentPosition() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "getCurrentPosition");
        return ((java.lang.Long) invokeRemoteMethodNotPending(14, 0L, new java.lang.Object[0])).longValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getDuration() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "getDuration");
        return ((java.lang.Long) invokeRemoteMethodNotPending(15, 0L, new java.lang.Object[0])).longValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public float getSpeed() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "getSpeed");
        return ((java.lang.Float) invokeRemoteMethodNotPending(39, java.lang.Float.valueOf(1.0f), new java.lang.Object[0])).floatValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getContentBufferedPosition() {
        return ((java.lang.Long) invokeRemoteMethodNotPending(36, 0L, new java.lang.Object[0])).longValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void release() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "release");
        invokeRemoteMethod(16, new java.lang.Object[0]);
        onRelease();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void reset() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "reset");
        invokeRemoteMethod(17, new java.lang.Object[0]);
        onRelease();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVolume(float f_renamed) {
        invokeRemoteMethod(18, java.lang.Float.valueOf(f_renamed));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getAudioSessionId() {
        return ((java.lang.Integer) invokeRemoteMethodNotPending(20, 0, new java.lang.Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public com.oplus.tblplayer.misc.MediaInfo getMediaInfo() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlayable() {
        return ((java.lang.Boolean) invokeRemoteMethodNotPending(13, true, new java.lang.Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnPreparedListener(com.oplus.tblplayer.IMediaPlayer.OnPreparedListener onPreparedListener) {
        super.setOnPreparedListener(onPreparedListener);
        setShouldNotify(1, 1);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnCompletionListener(com.oplus.tblplayer.IMediaPlayer.OnCompletionListener onCompletionListener) {
        super.setOnCompletionListener(onCompletionListener);
        setShouldNotify(2, 2);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnBufferingUpdateListener(com.oplus.tblplayer.IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        super.setOnBufferingUpdateListener(onBufferingUpdateListener);
        setShouldNotify(4, 4);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnSeekCompleteListener(com.oplus.tblplayer.IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        super.setOnSeekCompleteListener(onSeekCompleteListener);
        setShouldNotify(8, 8);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnVideoSizeChangedListener(com.oplus.tblplayer.IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        super.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        setShouldNotify(16, 16);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnErrorListener(com.oplus.tblplayer.IMediaPlayer.OnErrorListener onErrorListener) {
        super.setOnErrorListener(onErrorListener);
        setShouldNotify(32, 32);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnInfoListener(com.oplus.tblplayer.IMediaPlayer.OnInfoListener onInfoListener) {
        super.setOnInfoListener(onInfoListener);
        setShouldNotify(64, 64);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnTimedTextListener(com.oplus.tblplayer.IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        super.setOnTimedTextListener(onTimedTextListener);
        setShouldNotify(128, 128);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnPlaybackResultListener(com.oplus.tblplayer.IMediaPlayer.OnPlaybackResultListener onPlaybackResultListener) {
        super.setOnPlaybackResultListener(onPlaybackResultListener);
        setShouldNotify(256, 256);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnPlayerEventListener(com.oplus.tblplayer.IMediaPlayer.OnPlayerEventListener onPlayerEventListener) {
        super.setOnPlayerEventListener(onPlayerEventListener);
        setShouldNotify(512, 512);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setAudioStreamType(int i_renamed) {
        invokeRemoteMethod(19, java.lang.Integer.valueOf(i_renamed));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setKeepInBackground(boolean z_renamed) {
        invokeRemoteMethod(23, java.lang.Boolean.valueOf(z_renamed));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarNum() {
        return ((java.lang.Integer) invokeRemoteMethodNotPending(24, 1, new java.lang.Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarDen() {
        return ((java.lang.Integer) invokeRemoteMethodNotPending(25, 1, new java.lang.Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setWakeMode(int i_renamed) {
        invokeRemoteMethod(26, java.lang.Integer.valueOf(i_renamed));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLooping(boolean z_renamed) {
        invokeRemoteMethod(27, java.lang.Boolean.valueOf(z_renamed));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isLooping() {
        return ((java.lang.Boolean) invokeRemoteMethodNotPending(28, false, new java.lang.Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public com.oplus.tblplayer.misc.ITrackInfo[] getTrackInfo() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setNetworkType(int i_renamed) {
        invokeRemoteMethod(40, new java.lang.Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getBufferForPlaybackMs() {
        return ((java.lang.Long) invokeRemoteMethodNotPending(28, 0L, new java.lang.Object[0])).longValue();
    }

    private void setShouldNotify(int i_renamed, int i2) {
        invokeRemoteMethod(34, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
    }

    protected java.lang.Object invokeRemoteMethod(int i_renamed, java.lang.Object... objArr) {
        if (shouldPending()) {
            insertPendingTaskStack(i_renamed, objArr);
        } else if (shouldInvoke()) {
            return execRemoteMethod(i_renamed, null, objArr);
        }
        return null;
    }

    protected <T_renamed> T_renamed invokeRemoteMethodNotPending(int i_renamed, T_renamed t_renamed, java.lang.Object... objArr) {
        return shouldInvoke() ? (T_renamed) execRemoteMethod(i_renamed, t_renamed, objArr) : t_renamed;
    }

    protected synchronized void insertPendingTaskStack(int i_renamed, java.lang.Object... objArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("insertPendingTaskStack: need pending task method is_renamed ");
        sb.append(i_renamed - 1);
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, sb.toString());
        if (this.mPendingTaskStack == null) {
            this.mPendingTaskStack = new java.util.ArrayList<>();
        }
        this.mPendingTaskStack.add(new android.util.Pair<>(java.lang.Integer.valueOf(i_renamed), objArr));
    }

    protected synchronized boolean flushPendingTaskStack() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "flushPendingTaskStack");
        if (this.mRemotePlayer != null && this.mPendingTaskStack != null) {
            java.util.Iterator<android.util.Pair<java.lang.Integer, java.lang.Object[]>> it = this.mPendingTaskStack.iterator();
            while (it.hasNext()) {
                android.util.Pair<java.lang.Integer, java.lang.Object[]> next = it.next();
                invokeRemoteMethod(((java.lang.Integer) next.first).intValue(), (java.lang.Object[]) next.second);
            }
            this.mPendingTaskStack = null;
        }
        return false;
    }

    protected void onRelease() {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "onRelease");
        resetListeners();
        com.oplus.tblplayer.remote.RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.release();
            this.mSurfaceCache = null;
        }
        java.util.ArrayList<android.util.Pair<java.lang.Integer, java.lang.Object[]>> arrayList = this.mPendingTaskStack;
        if (arrayList != null) {
            arrayList.clear();
            this.mPendingTaskStack = null;
        }
        this.mRemotePlayer = null;
    }
}
