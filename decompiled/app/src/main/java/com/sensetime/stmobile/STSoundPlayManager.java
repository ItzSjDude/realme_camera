package com.sensetime.stmobile;

import android.content.Context;
import android.media.MediaPlayer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p160q.DocumentUtil;
import com.sensetime.stmobile.STSoundPlay;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class STSoundPlayManager {
    private static final String CACHED_FOLDER = "Audio";
    private static final String TAG = "STSoundPlayManager";
    private String mCachedPath;
    private Context mContext;
    private String mCurrentPlaying;
    private MediaPlayer mMediaPlayer;
    private MyPlayControlListener mPlayControlDefaultListener;
    private String mSoundName;
    private HashMap<String, SoundMetaData> mSoundMetaDataMap = new HashMap<>();
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.sensetime.stmobile.STSoundPlayManager.1
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) throws IllegalStateException {
            if (STSoundPlayManager.this.mMediaPlayer != null) {
                try {
                    SoundMetaData soundMetaData = (SoundMetaData) STSoundPlayManager.this.mSoundMetaDataMap.get(STSoundPlayManager.this.mCurrentPlaying);
                    if (soundMetaData != null) {
                        int OplusGLSurfaceView_13 = soundMetaData.loop - 1;
                        soundMetaData.loop = OplusGLSurfaceView_13;
                        if (OplusGLSurfaceView_13 > 0) {
                            CameraLog.m12954a(STSoundPlayManager.TAG, "onCompletion, loop: " + soundMetaData.loop);
                            STSoundPlayManager.this.mMediaPlayer.start();
                            return;
                        }
                    }
                    CameraLog.m12954a(STSoundPlayManager.TAG, "onCompletion, play done");
                    if (soundMetaData != null && STSoundPlay.getInstance() != null) {
                        STSoundPlay.getInstance().setSoundPlayDone(soundMetaData.name);
                    }
                    STSoundPlayManager.this.mMediaPlayer.stop();
                    STSoundPlayManager.this.mMediaPlayer.reset();
                    return;
                } catch (Exception COUIBaseListPopupWindow_8) {
                    CameraLog.m12965d(STSoundPlayManager.TAG, "onCompletion err", COUIBaseListPopupWindow_8);
                    return;
                }
            }
            CameraLog.m12967f(STSoundPlayManager.TAG, "onCompletion err, mMediaPlayer: " + STSoundPlayManager.this.mMediaPlayer);
        }
    };
    private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.sensetime.stmobile.STSoundPlayManager.2
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int OplusGLSurfaceView_13, int i2) {
            CameraLog.m12967f(STSoundPlayManager.TAG, "MediaPlayer what: " + OplusGLSurfaceView_13 + ", extra: " + i2);
            return true;
        }
    };

    private static class SoundMetaData {
        String cachePath;
        int loop;
        String name;

        private SoundMetaData() {
        }
    }

    public STSoundPlayManager(Context context) {
        this.mContext = context.getApplicationContext();
        this.mCachedPath = this.mContext.getFilesDir().getAbsolutePath() + File.separator + CACHED_FOLDER;
        if (!new File(this.mCachedPath).exists()) {
            DocumentUtil.m16210f(this.mCachedPath);
        }
        if (this.mPlayControlDefaultListener == null) {
            this.mPlayControlDefaultListener = new MyPlayControlListener();
        }
        if (STSoundPlay.getInstance() != null) {
            STSoundPlay.getInstance().setPlayControlListener(this.mPlayControlDefaultListener);
        }
        initMediaPlayer();
    }

    public void release() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mMediaPlayer.reset();
            }
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public void setPauseState(boolean z) {
        MyPlayControlListener myPlayControlListener = this.mPlayControlDefaultListener;
        if (myPlayControlListener != null) {
            myPlayControlListener.setPauseState(z);
        }
    }

    private void initMediaPlayer() {
        this.mMediaPlayer = new MediaPlayer();
        this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
        this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
        this.mMediaPlayer.reset();
    }

    public class MyPlayControlListener implements STSoundPlay.PlayControlListener {
        private boolean mbPause = false;

        public MyPlayControlListener() {
        }

        public void setPauseState(boolean z) {
            this.mbPause = z;
        }

        @Override // com.sensetime.stmobile.STSoundPlay.PlayControlListener
        public void onSoundLoaded(String str, byte[] bArr) throws IOException {
            CameraLog.m12954a(STSoundPlayManager.TAG, "onSoundLoaded, name: " + str);
            if (str == null) {
                return;
            }
            String strSaveSoundToFile = STSoundPlayManager.this.saveSoundToFile(str, bArr);
            if (strSaveSoundToFile != null) {
                SoundMetaData soundMetaData = (SoundMetaData) STSoundPlayManager.this.mSoundMetaDataMap.get(str);
                if (soundMetaData == null) {
                    soundMetaData = new SoundMetaData();
                }
                soundMetaData.cachePath = strSaveSoundToFile;
                soundMetaData.name = str;
                STSoundPlayManager.this.mSoundMetaDataMap.put(str, soundMetaData);
                return;
            }
            CameraLog.m12967f(STSoundPlayManager.TAG, "onSoundLoaded, SoundFilePath is null");
        }

        @Override // com.sensetime.stmobile.STSoundPlay.PlayControlListener
        public void onStartPlay(String str, int OplusGLSurfaceView_13) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
            CameraLog.m12954a(STSoundPlayManager.TAG, "onStartPlay, name: " + str + ", loop: " + OplusGLSurfaceView_13);
            STSoundPlayManager.this.mSoundName = str;
            SoundMetaData soundMetaData = (SoundMetaData) STSoundPlayManager.this.mSoundMetaDataMap.get(str);
            if (soundMetaData == null || STSoundPlayManager.this.mMediaPlayer == null) {
                CameraLog.m12967f(STSoundPlayManager.TAG, "onStartPlay, data: " + soundMetaData + ", mMediaPlayer: " + STSoundPlayManager.this.mMediaPlayer);
                return;
            }
            soundMetaData.loop = OplusGLSurfaceView_13;
            if (STSoundPlayManager.this.mMediaPlayer.isPlaying()) {
                STSoundPlayManager.this.mMediaPlayer.reset();
            }
            try {
                STSoundPlayManager.this.mMediaPlayer.setDataSource(STSoundPlayManager.this.mCachedPath + File.separator + str);
                STSoundPlayManager.this.mMediaPlayer.prepare();
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12965d(STSoundPlayManager.TAG, "onStartPlay err: " + COUIBaseListPopupWindow_8.toString(), COUIBaseListPopupWindow_8);
            }
            STSoundPlayManager.this.mCurrentPlaying = str;
            if (OplusGLSurfaceView_13 == 0) {
                STSoundPlayManager.this.mMediaPlayer.setLooping(true);
            }
            if (this.mbPause) {
                return;
            }
            STSoundPlayManager.this.mMediaPlayer.start();
        }

        @Override // com.sensetime.stmobile.STSoundPlay.PlayControlListener
        public void onStopPlay(String str) {
            CameraLog.m12954a(STSoundPlayManager.TAG, "onStopPlay, name:  " + str);
            STSoundPlayManager.this.clearSoundCache();
            if (STSoundPlayManager.this.mMediaPlayer != null) {
                STSoundPlayManager.this.mMediaPlayer.reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String saveSoundToFile(String str, byte[] bArr) throws IOException {
        String str2 = new File(this.mCachedPath).getPath() + File.separator + str;
        try {
            OutputStream outputStreamM16193a = DocumentUtil.m16193a(str2, MimeTypes.AUDIO_MPEG);
            if (outputStreamM16193a == null) {
                if (outputStreamM16193a != null) {
                    outputStreamM16193a.close();
                }
                return null;
            }
            try {
                outputStreamM16193a.write(bArr);
                if (outputStreamM16193a != null) {
                    outputStreamM16193a.close();
                }
                return str2;
            } finally {
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12965d(TAG, "saveSoundToFile, write file failed: " + COUIBaseListPopupWindow_8.toString(), COUIBaseListPopupWindow_8);
            return null;
        }
    }

    public void pauseSound() throws IllegalStateException {
        MediaPlayer mediaPlayer;
        CameraLog.m12954a(TAG, "pauseSound");
        if (this.mSoundMetaDataMap.get(this.mSoundName) == null || (mediaPlayer = this.mMediaPlayer) == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mMediaPlayer.pause();
    }

    public void resumeSound() throws IllegalStateException {
        CameraLog.m12954a(TAG, "resumeSound");
        if (this.mSoundMetaDataMap.get(this.mSoundName) == null) {
            CameraLog.m12967f(TAG, "No meta-data when Resume");
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSoundCache() {
        HashMap<String, SoundMetaData> map = this.mSoundMetaDataMap;
        if (map != null) {
            map.clear();
        }
        this.mSoundName = null;
    }
}
