package com.sensetime.stmobile;

/* loaded from: classes2.dex */
public class STSoundPlayManager {
    private static final java.lang.String CACHED_FOLDER = "Audio";
    private static final java.lang.String TAG = "STSoundPlayManager";
    private java.lang.String mCachedPath;
    private android.content.Context mContext;
    private java.lang.String mCurrentPlaying;
    private android.media.MediaPlayer mMediaPlayer;
    private com.sensetime.stmobile.STSoundPlayManager.MyPlayControlListener mPlayControlDefaultListener;
    private java.lang.String mSoundName;
    private java.util.HashMap<java.lang.String, com.sensetime.stmobile.STSoundPlayManager.SoundMetaData> mSoundMetaDataMap = new java.util.HashMap<>();
    private android.media.MediaPlayer.OnCompletionListener mCompletionListener = new android.media.MediaPlayer.OnCompletionListener() { // from class: com.sensetime.stmobile.STSoundPlayManager.1
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(android.media.MediaPlayer mediaPlayer) throws java.lang.IllegalStateException {
            if (com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer != null) {
                try {
                    com.sensetime.stmobile.STSoundPlayManager.SoundMetaData soundMetaData = (com.sensetime.stmobile.STSoundPlayManager.SoundMetaData) com.sensetime.stmobile.STSoundPlayManager.this.mSoundMetaDataMap.get(com.sensetime.stmobile.STSoundPlayManager.this.mCurrentPlaying);
                    if (soundMetaData != null) {
                        int i_renamed = soundMetaData.loop - 1;
                        soundMetaData.loop = i_renamed;
                        if (i_renamed > 0) {
                            com.oplus.camera.e_renamed.a_renamed(com.sensetime.stmobile.STSoundPlayManager.TAG, "onCompletion, loop: " + soundMetaData.loop);
                            com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer.start();
                            return;
                        }
                    }
                    com.oplus.camera.e_renamed.a_renamed(com.sensetime.stmobile.STSoundPlayManager.TAG, "onCompletion, play done");
                    if (soundMetaData != null && com.sensetime.stmobile.STSoundPlay.getInstance() != null) {
                        com.sensetime.stmobile.STSoundPlay.getInstance().setSoundPlayDone(soundMetaData.name);
                    }
                    com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer.stop();
                    com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer.reset();
                    return;
                } catch (java.lang.Exception e_renamed) {
                    com.oplus.camera.e_renamed.d_renamed(com.sensetime.stmobile.STSoundPlayManager.TAG, "onCompletion err", e_renamed);
                    return;
                }
            }
            com.oplus.camera.e_renamed.f_renamed(com.sensetime.stmobile.STSoundPlayManager.TAG, "onCompletion err, mMediaPlayer: " + com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer);
        }
    };
    private android.media.MediaPlayer.OnErrorListener mErrorListener = new android.media.MediaPlayer.OnErrorListener() { // from class: com.sensetime.stmobile.STSoundPlayManager.2
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(android.media.MediaPlayer mediaPlayer, int i_renamed, int i2) {
            com.oplus.camera.e_renamed.f_renamed(com.sensetime.stmobile.STSoundPlayManager.TAG, "MediaPlayer what: " + i_renamed + ", extra: " + i2);
            return true;
        }
    };

    private static class SoundMetaData {
        java.lang.String cachePath;
        int loop;
        java.lang.String name;

        private SoundMetaData() {
        }
    }

    public STSoundPlayManager(android.content.Context context) {
        this.mContext = context.getApplicationContext();
        this.mCachedPath = this.mContext.getFilesDir().getAbsolutePath() + java.io.File.separator + CACHED_FOLDER;
        if (!new java.io.File(this.mCachedPath).exists()) {
            com.oplus.camera.q_renamed.a_renamed.f_renamed(this.mCachedPath);
        }
        if (this.mPlayControlDefaultListener == null) {
            this.mPlayControlDefaultListener = new com.sensetime.stmobile.STSoundPlayManager.MyPlayControlListener();
        }
        if (com.sensetime.stmobile.STSoundPlay.getInstance() != null) {
            com.sensetime.stmobile.STSoundPlay.getInstance().setPlayControlListener(this.mPlayControlDefaultListener);
        }
        initMediaPlayer();
    }

    public void release() {
        android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mMediaPlayer.reset();
            }
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public void setPauseState(boolean z_renamed) {
        com.sensetime.stmobile.STSoundPlayManager.MyPlayControlListener myPlayControlListener = this.mPlayControlDefaultListener;
        if (myPlayControlListener != null) {
            myPlayControlListener.setPauseState(z_renamed);
        }
    }

    private void initMediaPlayer() {
        this.mMediaPlayer = new android.media.MediaPlayer();
        this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
        this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
        this.mMediaPlayer.reset();
    }

    public class MyPlayControlListener implements com.sensetime.stmobile.STSoundPlay.PlayControlListener {
        private boolean mbPause = false;

        public MyPlayControlListener() {
        }

        public void setPauseState(boolean z_renamed) {
            this.mbPause = z_renamed;
        }

        @Override // com.sensetime.stmobile.STSoundPlay.PlayControlListener
        public void onSoundLoaded(java.lang.String str, byte[] bArr) throws java.io.IOException {
            com.oplus.camera.e_renamed.a_renamed(com.sensetime.stmobile.STSoundPlayManager.TAG, "onSoundLoaded, name: " + str);
            if (str == null) {
                return;
            }
            java.lang.String strSaveSoundToFile = com.sensetime.stmobile.STSoundPlayManager.this.saveSoundToFile(str, bArr);
            if (strSaveSoundToFile != null) {
                com.sensetime.stmobile.STSoundPlayManager.SoundMetaData soundMetaData = (com.sensetime.stmobile.STSoundPlayManager.SoundMetaData) com.sensetime.stmobile.STSoundPlayManager.this.mSoundMetaDataMap.get(str);
                if (soundMetaData == null) {
                    soundMetaData = new com.sensetime.stmobile.STSoundPlayManager.SoundMetaData();
                }
                soundMetaData.cachePath = strSaveSoundToFile;
                soundMetaData.name = str;
                com.sensetime.stmobile.STSoundPlayManager.this.mSoundMetaDataMap.put(str, soundMetaData);
                return;
            }
            com.oplus.camera.e_renamed.f_renamed(com.sensetime.stmobile.STSoundPlayManager.TAG, "onSoundLoaded, SoundFilePath is_renamed null");
        }

        @Override // com.sensetime.stmobile.STSoundPlay.PlayControlListener
        public void onStartPlay(java.lang.String str, int i_renamed) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
            com.oplus.camera.e_renamed.a_renamed(com.sensetime.stmobile.STSoundPlayManager.TAG, "onStartPlay, name: " + str + ", loop: " + i_renamed);
            com.sensetime.stmobile.STSoundPlayManager.this.mSoundName = str;
            com.sensetime.stmobile.STSoundPlayManager.SoundMetaData soundMetaData = (com.sensetime.stmobile.STSoundPlayManager.SoundMetaData) com.sensetime.stmobile.STSoundPlayManager.this.mSoundMetaDataMap.get(str);
            if (soundMetaData == null || com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer == null) {
                com.oplus.camera.e_renamed.f_renamed(com.sensetime.stmobile.STSoundPlayManager.TAG, "onStartPlay, data: " + soundMetaData + ", mMediaPlayer: " + com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer);
                return;
            }
            soundMetaData.loop = i_renamed;
            if (com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer.isPlaying()) {
                com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer.reset();
            }
            try {
                com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer.setDataSource(com.sensetime.stmobile.STSoundPlayManager.this.mCachedPath + java.io.File.separator + str);
                com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer.prepare();
            } catch (java.lang.Exception e_renamed) {
                com.oplus.camera.e_renamed.d_renamed(com.sensetime.stmobile.STSoundPlayManager.TAG, "onStartPlay err: " + e_renamed.toString(), e_renamed);
            }
            com.sensetime.stmobile.STSoundPlayManager.this.mCurrentPlaying = str;
            if (i_renamed == 0) {
                com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer.setLooping(true);
            }
            if (this.mbPause) {
                return;
            }
            com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer.start();
        }

        @Override // com.sensetime.stmobile.STSoundPlay.PlayControlListener
        public void onStopPlay(java.lang.String str) {
            com.oplus.camera.e_renamed.a_renamed(com.sensetime.stmobile.STSoundPlayManager.TAG, "onStopPlay, name:  " + str);
            com.sensetime.stmobile.STSoundPlayManager.this.clearSoundCache();
            if (com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer != null) {
                com.sensetime.stmobile.STSoundPlayManager.this.mMediaPlayer.reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String saveSoundToFile(java.lang.String str, byte[] bArr) throws java.io.IOException {
        java.lang.String str2 = new java.io.File(this.mCachedPath).getPath() + java.io.File.separator + str;
        try {
            java.io.OutputStream outputStreamA = com.oplus.camera.q_renamed.a_renamed.a_renamed(str2, com.google.android.exoplayer2.util.MimeTypes.AUDIO_MPEG);
            if (outputStreamA == null) {
                if (outputStreamA != null) {
                    outputStreamA.close();
                }
                return null;
            }
            try {
                outputStreamA.write(bArr);
                if (outputStreamA != null) {
                    outputStreamA.close();
                }
                return str2;
            } finally {
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.d_renamed(TAG, "saveSoundToFile, write file failed: " + e_renamed.toString(), e_renamed);
            return null;
        }
    }

    public void pauseSound() throws java.lang.IllegalStateException {
        android.media.MediaPlayer mediaPlayer;
        com.oplus.camera.e_renamed.a_renamed(TAG, "pauseSound");
        if (this.mSoundMetaDataMap.get(this.mSoundName) == null || (mediaPlayer = this.mMediaPlayer) == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mMediaPlayer.pause();
    }

    public void resumeSound() throws java.lang.IllegalStateException {
        com.oplus.camera.e_renamed.a_renamed(TAG, "resumeSound");
        if (this.mSoundMetaDataMap.get(this.mSoundName) == null) {
            com.oplus.camera.e_renamed.f_renamed(TAG, "No meta-data when Resume");
            return;
        }
        android.media.MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSoundCache() {
        java.util.HashMap<java.lang.String, com.sensetime.stmobile.STSoundPlayManager.SoundMetaData> map = this.mSoundMetaDataMap;
        if (map != null) {
            map.clear();
        }
        this.mSoundName = null;
    }
}
