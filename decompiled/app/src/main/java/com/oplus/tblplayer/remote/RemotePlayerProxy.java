package com.oplus.tblplayer.remote;

import android.net.Uri;
import android.os.IBinder;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.tblplayer.AbstractMediaPlayer;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.misc.IMediaDataSource;
import com.oplus.tblplayer.misc.ITrackInfo;
import com.oplus.tblplayer.misc.MediaInfo;
import com.oplus.tblplayer.utils.LogUtil;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class RemotePlayerProxy extends AbstractMediaPlayer {
    private static final String TAG = "RemotePlayerProxy";
    private ArrayList<Pair<Integer, Object[]>> mPendingTaskStack;
    protected IBinder mRemotePlayer;
    protected RemoteSurfaceCache mSurfaceCache = new RemoteSurfaceCache(this);

    protected abstract <T> T execRemoteMethod(int OplusGLSurfaceView_13, T t, Object... objArr);

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getNetSpeed() {
        return 0L;
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    protected abstract boolean shouldInvoke();

    protected abstract boolean shouldPending();

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoSurfaceHolder(surfaceHolder);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setSurface(Surface surface) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoSurface(surface);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.clearVideoSurfaceView(surfaceView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVideoTextureView(TextureView textureView) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.setVideoTextureView(textureView);
        }
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void clearVideoTextureView(TextureView textureView) {
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.clearVideoTextureView(textureView);
        }
    }

    protected void updateSurface(Surface surface) {
        LogUtil.m25450d(TAG, "updateSurface: surface is " + surface);
        invokeRemoteMethod(35, surface);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        LogUtil.m25450d(TAG, "setDataSource: uri is " + uri);
        invokeRemoteMethod(2, uri);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        invokeRemoteMethod(3, uri, map);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IllegalStateException, IOException, IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        LogUtil.m25450d(TAG, "setDataSource: path is " + str);
        invokeRemoteMethod(1, str);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public String getDataSource() {
        return (String) invokeRemoteMethodNotPending(6, null, new Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void prepareAsync() throws IllegalStateException {
        LogUtil.m25450d(TAG, "prepareAsync");
        invokeRemoteMethod(7, new Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void start() throws IllegalStateException {
        LogUtil.m25450d(TAG, TtmlNode.START);
        invokeRemoteMethod(8, new Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void stop() throws IllegalStateException {
        LogUtil.m25450d(TAG, "stop");
        invokeRemoteMethod(9, new Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void pause() throws IllegalStateException {
        LogUtil.m25450d(TAG, VideoRecordMsgData.EVENT_PAUSE);
        invokeRemoteMethod(10, new Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        LogUtil.m25450d(TAG, "setScreenOnWhilePlaying");
        invokeRemoteMethod(29, Boolean.valueOf(z));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoWidth() {
        return ((Integer) invokeRemoteMethodNotPending(30, 0, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoHeight() {
        return ((Integer) invokeRemoteMethodNotPending(31, 0, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlaying() {
        return ((Boolean) invokeRemoteMethodNotPending(12, false, new Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isStop() {
        return ((Boolean) invokeRemoteMethodNotPending(38, false, new Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPause() {
        return ((Boolean) invokeRemoteMethodNotPending(37, false, new Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getPlaybackState() {
        return ((Integer) invokeRemoteMethodNotPending(42, 1, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void seekTo(long OplusGLSurfaceView_15) throws IllegalStateException {
        LogUtil.m25450d(TAG, "seekTo");
        invokeRemoteMethod(11, Long.valueOf(OplusGLSurfaceView_15));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getCurrentPosition() {
        LogUtil.m25450d(TAG, "getCurrentPosition");
        return ((Long) invokeRemoteMethodNotPending(14, 0L, new Object[0])).longValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getDuration() {
        LogUtil.m25450d(TAG, "getDuration");
        return ((Long) invokeRemoteMethodNotPending(15, 0L, new Object[0])).longValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public float getSpeed() {
        LogUtil.m25450d(TAG, "getSpeed");
        return ((Float) invokeRemoteMethodNotPending(39, Float.valueOf(1.0f), new Object[0])).floatValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getContentBufferedPosition() {
        return ((Long) invokeRemoteMethodNotPending(36, 0L, new Object[0])).longValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void release() {
        LogUtil.m25450d(TAG, "release");
        invokeRemoteMethod(16, new Object[0]);
        onRelease();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void reset() {
        LogUtil.m25450d(TAG, "reset");
        invokeRemoteMethod(17, new Object[0]);
        onRelease();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setVolume(float COUIBaseListPopupWindow_12) {
        invokeRemoteMethod(18, Float.valueOf(COUIBaseListPopupWindow_12));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getAudioSessionId() {
        return ((Integer) invokeRemoteMethodNotPending(20, 0, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public MediaInfo getMediaInfo() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isPlayable() {
        return ((Boolean) invokeRemoteMethodNotPending(13, true, new Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        super.setOnPreparedListener(onPreparedListener);
        setShouldNotify(1, 1);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        super.setOnCompletionListener(onCompletionListener);
        setShouldNotify(2, 2);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        super.setOnBufferingUpdateListener(onBufferingUpdateListener);
        setShouldNotify(4, 4);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        super.setOnSeekCompleteListener(onSeekCompleteListener);
        setShouldNotify(8, 8);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        super.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        setShouldNotify(16, 16);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        super.setOnErrorListener(onErrorListener);
        setShouldNotify(32, 32);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        super.setOnInfoListener(onInfoListener);
        setShouldNotify(64, 64);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        super.setOnTimedTextListener(onTimedTextListener);
        setShouldNotify(128, 128);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnPlaybackResultListener(IMediaPlayer.OnPlaybackResultListener onPlaybackResultListener) {
        super.setOnPlaybackResultListener(onPlaybackResultListener);
        setShouldNotify(256, 256);
    }

    @Override // com.oplus.tblplayer.AbstractMediaPlayer, com.oplus.tblplayer.IMediaPlayer
    public void setOnPlayerEventListener(IMediaPlayer.OnPlayerEventListener onPlayerEventListener) {
        super.setOnPlayerEventListener(onPlayerEventListener);
        setShouldNotify(512, 512);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setAudioStreamType(int OplusGLSurfaceView_13) {
        invokeRemoteMethod(19, Integer.valueOf(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setKeepInBackground(boolean z) {
        invokeRemoteMethod(23, Boolean.valueOf(z));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarNum() {
        return ((Integer) invokeRemoteMethodNotPending(24, 1, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public int getVideoSarDen() {
        return ((Integer) invokeRemoteMethodNotPending(25, 1, new Object[0])).intValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setWakeMode(int OplusGLSurfaceView_13) {
        invokeRemoteMethod(26, Integer.valueOf(OplusGLSurfaceView_13));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setLooping(boolean z) {
        invokeRemoteMethod(27, Boolean.valueOf(z));
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public boolean isLooping() {
        return ((Boolean) invokeRemoteMethodNotPending(28, false, new Object[0])).booleanValue();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public ITrackInfo[] getTrackInfo() {
        throw new UnsupportedOperationException();
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public void setNetworkType(int OplusGLSurfaceView_13) {
        invokeRemoteMethod(40, new Object[0]);
    }

    @Override // com.oplus.tblplayer.IMediaPlayer
    public long getBufferForPlaybackMs() {
        return ((Long) invokeRemoteMethodNotPending(28, 0L, new Object[0])).longValue();
    }

    private void setShouldNotify(int OplusGLSurfaceView_13, int i2) {
        invokeRemoteMethod(34, Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
    }

    protected Object invokeRemoteMethod(int OplusGLSurfaceView_13, Object... objArr) {
        if (shouldPending()) {
            insertPendingTaskStack(OplusGLSurfaceView_13, objArr);
        } else if (shouldInvoke()) {
            return execRemoteMethod(OplusGLSurfaceView_13, null, objArr);
        }
        return null;
    }

    protected <T> T invokeRemoteMethodNotPending(int OplusGLSurfaceView_13, T t, Object... objArr) {
        return shouldInvoke() ? (T) execRemoteMethod(OplusGLSurfaceView_13, t, objArr) : t;
    }

    protected synchronized void insertPendingTaskStack(int OplusGLSurfaceView_13, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("insertPendingTaskStack: need pending task method is ");
        sb.append(OplusGLSurfaceView_13 - 1);
        LogUtil.m25450d(TAG, sb.toString());
        if (this.mPendingTaskStack == null) {
            this.mPendingTaskStack = new ArrayList<>();
        }
        this.mPendingTaskStack.add(new Pair<>(Integer.valueOf(OplusGLSurfaceView_13), objArr));
    }

    protected synchronized boolean flushPendingTaskStack() {
        LogUtil.m25450d(TAG, "flushPendingTaskStack");
        if (this.mRemotePlayer != null && this.mPendingTaskStack != null) {
            Iterator<Pair<Integer, Object[]>> it = this.mPendingTaskStack.iterator();
            while (it.hasNext()) {
                Pair<Integer, Object[]> next = it.next();
                invokeRemoteMethod(((Integer) next.first).intValue(), (Object[]) next.second);
            }
            this.mPendingTaskStack = null;
        }
        return false;
    }

    protected void onRelease() {
        LogUtil.m25450d(TAG, "onRelease");
        resetListeners();
        RemoteSurfaceCache remoteSurfaceCache = this.mSurfaceCache;
        if (remoteSurfaceCache != null) {
            remoteSurfaceCache.release();
            this.mSurfaceCache = null;
        }
        ArrayList<Pair<Integer, Object[]>> arrayList = this.mPendingTaskStack;
        if (arrayList != null) {
            arrayList.clear();
            this.mPendingTaskStack = null;
        }
        this.mRemotePlayer = null;
    }
}
