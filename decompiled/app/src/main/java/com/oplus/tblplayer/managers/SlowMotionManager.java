package com.oplus.tblplayer.managers;

/* loaded from: classes2.dex */
public class SlowMotionManager {
    public static int INVALID_FPS = -1;
    private static int SLOW_MOTION_INTERNAL_MS = 10;
    private static int SLOW_MOTION_STATUS_NEED_STOP = 1;
    private static int SLOW_MOTION_STATUS_RUNNING = 0;
    private static int SLOW_MOTION_STATUS_STOPPED = 2;
    private static java.lang.String TAG = "SlowMotionManager";
    private com.oplus.tblplayer.IMediaPlayer player;
    private long realDuration;
    private float realFps;
    private long slowDuration;
    private int slowFps;
    private float timesOfSlows;
    private com.oplus.tblplayer.managers.SlowMotionManager.SlowMotionInfo[] slowIfs = new com.oplus.tblplayer.managers.SlowMotionManager.SlowMotionInfo[2];
    private int slowInfoLen = 0;
    private boolean isHsr = false;
    private boolean isSlow = false;
    private int status = SLOW_MOTION_STATUS_STOPPED;
    private android.os.Handler handler = new android.os.Handler(getLooper());
    private java.lang.Runnable updatePlaybackRateAction = new java.lang.Runnable() { // from class: com.oplus.tblplayer.managers.-$$Lambda$SlowMotionManager$RmLAmIO488TjQvdrCKWrwWnRu7o
        @Override // java.lang.Runnable
        public final void run() {
            this.f_renamed$0.updatePlaybackRateTask();
        }
    };

    private class SlowMotionInfo {
        private long end;
        private long slowEnd;
        private long slowStart;
        private long start;

        public SlowMotionInfo() {
        }

        public SlowMotionInfo(long j_renamed, long j2, long j3, float f_renamed) {
            this.start = j_renamed;
            this.end = j2;
            this.slowStart = j3 + j_renamed;
            this.slowEnd = (long) (this.slowStart + ((j2 - j_renamed) * f_renamed));
        }

        public long getStart() {
            return this.start;
        }

        public long getEnd() {
            return this.end;
        }

        public long getSlowStart() {
            return this.slowStart;
        }

        public long getSlowEnd() {
            return this.slowEnd;
        }

        public long getDiff(long j_renamed, boolean z_renamed) {
            long j2;
            long j3;
            if (z_renamed) {
                long j4 = this.start;
                if (j_renamed <= j4) {
                    return 0L;
                }
                if (j_renamed > j4 && j_renamed <= this.end) {
                    return j_renamed - j4;
                }
                j2 = this.end;
                j3 = this.start;
            } else {
                long j5 = this.slowStart;
                if (j_renamed < j5) {
                    return 0L;
                }
                if (j_renamed > j5 && j_renamed <= this.slowEnd) {
                    return j_renamed - j5;
                }
                j2 = this.slowEnd;
                j3 = this.slowStart;
            }
            return j2 - j3;
        }

        public boolean isInside(long j_renamed, boolean z_renamed) {
            return z_renamed ? j_renamed >= this.start && j_renamed < this.end : j_renamed >= this.slowStart && j_renamed < this.slowEnd;
        }
    }

    public SlowMotionManager(com.oplus.tblplayer.IMediaPlayer iMediaPlayer, int i_renamed, float f_renamed) {
        this.slowFps = i_renamed;
        this.realFps = f_renamed;
        this.player = iMediaPlayer;
    }

    public static com.oplus.tblplayer.managers.SlowMotionManager create(android.content.Context context, com.oplus.tblplayer.IMediaPlayer iMediaPlayer, java.lang.String str, float f_renamed, int i_renamed, long j_renamed) {
        if (!com.oplus.tblplayer.utils.CommonUtil.isSlowMotionHsr(str) || i_renamed <= 0 || j_renamed <= 0) {
            com.oplus.tblplayer.utils.LogUtil.e_renamed(TAG, "title = " + str + ", realFps = " + f_renamed + ", duration = " + j_renamed);
            return null;
        }
        com.oplus.tblplayer.managers.SlowMotionManager slowMotionManager = new com.oplus.tblplayer.managers.SlowMotionManager(iMediaPlayer, i_renamed, f_renamed);
        if (slowMotionManager.parseHsrInfo(str, j_renamed)) {
            return slowMotionManager;
        }
        return null;
    }

    public boolean parseHsrInfo(java.lang.String str, long j_renamed) {
        if (this.realFps == INVALID_FPS) {
            java.lang.String strSubstring = str.substring(str.indexOf(com.oplus.tblplayer.Constants.SLOW_MOTION_HSR_HEAD), str.indexOf(":"));
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "parseHsrInfo: hsrPrefixTitle = " + strSubstring);
            java.lang.String strSubstring2 = strSubstring.substring(com.oplus.tblplayer.Constants.SLOW_MOTION_HSR_HEAD.length());
            this.realFps = (float) java.lang.Integer.parseInt(strSubstring2);
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "Parse fps form title is_renamed " + strSubstring2 + ", realFps: " + this.realFps);
        }
        this.timesOfSlows = this.realFps / this.slowFps;
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "timesOfSlows: " + this.timesOfSlows);
        java.lang.String[] strArrSplit = str.substring(str.indexOf(":") + 1).split(",");
        long[] jArr = new long[4];
        for (int i_renamed = 0; i_renamed < strArrSplit.length && i_renamed < 4; i_renamed++) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "sHsrInfo[" + i_renamed + "]: " + strArrSplit[i_renamed]);
            jArr[i_renamed] = java.lang.Long.valueOf(strArrSplit[i_renamed]).longValue();
        }
        if (jArr[0] >= 0 && jArr[0] < j_renamed && jArr[1] > jArr[0]) {
            long j2 = jArr[0];
            long j3 = jArr[1] > j_renamed ? j_renamed : jArr[1];
            com.oplus.tblplayer.managers.SlowMotionManager.SlowMotionInfo[] slowMotionInfoArr = this.slowIfs;
            int i2 = this.slowInfoLen;
            this.slowInfoLen = i2 + 1;
            slowMotionInfoArr[i2] = new com.oplus.tblplayer.managers.SlowMotionManager.SlowMotionInfo(j2, j3, 0L, this.timesOfSlows);
        }
        if (jArr[2] >= jArr[1] && jArr[2] < j_renamed && jArr[3] > jArr[2]) {
            long j4 = jArr[2];
            long j5 = jArr[3] > j_renamed ? j_renamed : jArr[3];
            com.oplus.tblplayer.managers.SlowMotionManager.SlowMotionInfo[] slowMotionInfoArr2 = this.slowIfs;
            int i3 = this.slowInfoLen;
            this.slowInfoLen = i3 + 1;
            slowMotionInfoArr2[i3] = new com.oplus.tblplayer.managers.SlowMotionManager.SlowMotionInfo(j4, j5, this.slowIfs[0].getStart() + ((slowMotionInfoArr2[0].getSlowEnd() - this.slowIfs[0].getSlowStart()) - this.slowIfs[0].getEnd()), this.timesOfSlows);
        }
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "slowInfoLen: " + this.slowInfoLen);
        this.realDuration = j_renamed;
        this.slowDuration = j_renamed;
        for (int i4 = 0; i4 < this.slowInfoLen; i4++) {
            this.slowDuration += ((this.slowIfs[i4].getSlowEnd() - this.slowIfs[i4].getSlowStart()) - this.slowIfs[i4].getEnd()) + this.slowIfs[i4].getStart();
        }
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "realDuration: " + this.realDuration + ", slowDuration: " + this.slowDuration);
        this.isHsr = this.slowInfoLen > 0;
        return this.isHsr;
    }

    public void start() {
        if (this.isHsr) {
            if (this.status != SLOW_MOTION_STATUS_STOPPED) {
                this.status = SLOW_MOTION_STATUS_RUNNING;
            } else {
                this.status = SLOW_MOTION_STATUS_RUNNING;
                this.handler.postDelayed(this.updatePlaybackRateAction, SLOW_MOTION_INTERNAL_MS);
            }
        }
    }

    public void stop() {
        if (this.isHsr) {
            this.status = SLOW_MOTION_STATUS_NEED_STOP;
        }
    }

    public long adaptPosition(long j_renamed, boolean z_renamed) {
        long j2;
        if (!this.isHsr) {
            return j_renamed;
        }
        if (z_renamed && j_renamed >= this.slowDuration) {
            return this.realDuration;
        }
        if (!z_renamed && j_renamed >= this.realDuration) {
            return this.slowDuration;
        }
        long diff = 0;
        for (int i_renamed = 0; i_renamed < this.slowInfoLen; i_renamed++) {
            diff += this.slowIfs[i_renamed].getDiff(j_renamed, !z_renamed);
        }
        if (z_renamed) {
            long j3 = (long) (j_renamed - (diff * (1.0f - (1.0f / this.timesOfSlows))));
            j2 = this.realDuration;
            if (j3 < j2) {
                return j3;
            }
        } else {
            long j4 = (long) (j_renamed + (diff * (this.timesOfSlows - 1.0f)));
            j2 = this.slowDuration;
            if (j4 < j2) {
                return j4;
            }
        }
        return j2;
    }

    protected android.os.Looper getLooper() {
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : android.os.Looper.getMainLooper();
    }

    private boolean needToSlow(long j_renamed, boolean z_renamed) {
        for (int i_renamed = 0; i_renamed < this.slowInfoLen; i_renamed++) {
            if (this.slowIfs[i_renamed].isInside(j_renamed, z_renamed)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaybackRateTask() {
        if (this.status == SLOW_MOTION_STATUS_NEED_STOP) {
            if (this.isSlow) {
                this.player.setVolume(0.0f);
                this.player.setPlaybackRate(1.0f / this.timesOfSlows);
                this.isSlow = false;
            }
            this.status = SLOW_MOTION_STATUS_STOPPED;
            return;
        }
        long currentPosition = this.player.getCurrentPosition();
        if (!this.isSlow && needToSlow(currentPosition, false)) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "need to slow, pos: " + currentPosition);
            this.player.setVolume(0.0f);
            this.player.setPlaybackRate(1.0f / this.timesOfSlows);
            this.isSlow = true;
        } else if (this.isSlow && !needToSlow(currentPosition, false)) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "need to real, pos: " + currentPosition);
            this.player.setVolume(1.0f);
            this.player.setPlaybackRate(1.0f);
            this.isSlow = false;
        }
        this.handler.postDelayed(this.updatePlaybackRateAction, SLOW_MOTION_INTERNAL_MS);
    }
}
