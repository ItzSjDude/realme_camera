package com.oplus.tblplayer.managers;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.utils.CommonUtil;
import com.oplus.tblplayer.utils.LogUtil;

/* loaded from: classes2.dex */
public class SlowMotionManager {
    public static int INVALID_FPS = -1;
    private static int SLOW_MOTION_INTERNAL_MS = 10;
    private static int SLOW_MOTION_STATUS_NEED_STOP = 1;
    private static int SLOW_MOTION_STATUS_RUNNING = 0;
    private static int SLOW_MOTION_STATUS_STOPPED = 2;
    private static String TAG = "SlowMotionManager";
    private IMediaPlayer player;
    private long realDuration;
    private float realFps;
    private long slowDuration;
    private int slowFps;
    private float timesOfSlows;
    private SlowMotionInfo[] slowIfs = new SlowMotionInfo[2];
    private int slowInfoLen = 0;
    private boolean isHsr = false;
    private boolean isSlow = false;
    private int status = SLOW_MOTION_STATUS_STOPPED;
    private Handler handler = new Handler(getLooper());
    private Runnable updatePlaybackRateAction = new Runnable() { // from class: com.oplus.tblplayer.managers.-$$Lambda$SlowMotionManager$RmLAmIO488TjQvdrCKWrwWnRu7o
        @Override // java.lang.Runnable
        public final void run() {
            this.COUIBaseListPopupWindow_12$0.updatePlaybackRateTask();
        }
    };

    private class SlowMotionInfo {
        private long end;
        private long slowEnd;
        private long slowStart;
        private long start;

        public SlowMotionInfo() {
        }

        public SlowMotionInfo(long OplusGLSurfaceView_15, long j2, long j3, float COUIBaseListPopupWindow_12) {
            this.start = OplusGLSurfaceView_15;
            this.end = j2;
            this.slowStart = j3 + OplusGLSurfaceView_15;
            this.slowEnd = (long) (this.slowStart + ((j2 - OplusGLSurfaceView_15) * COUIBaseListPopupWindow_12));
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

        public long getDiff(long OplusGLSurfaceView_15, boolean z) {
            long j2;
            long j3;
            if (z) {
                long j4 = this.start;
                if (OplusGLSurfaceView_15 <= j4) {
                    return 0L;
                }
                if (OplusGLSurfaceView_15 > j4 && OplusGLSurfaceView_15 <= this.end) {
                    return OplusGLSurfaceView_15 - j4;
                }
                j2 = this.end;
                j3 = this.start;
            } else {
                long j5 = this.slowStart;
                if (OplusGLSurfaceView_15 < j5) {
                    return 0L;
                }
                if (OplusGLSurfaceView_15 > j5 && OplusGLSurfaceView_15 <= this.slowEnd) {
                    return OplusGLSurfaceView_15 - j5;
                }
                j2 = this.slowEnd;
                j3 = this.slowStart;
            }
            return j2 - j3;
        }

        public boolean isInside(long OplusGLSurfaceView_15, boolean z) {
            return z ? OplusGLSurfaceView_15 >= this.start && OplusGLSurfaceView_15 < this.end : OplusGLSurfaceView_15 >= this.slowStart && OplusGLSurfaceView_15 < this.slowEnd;
        }
    }

    public SlowMotionManager(IMediaPlayer iMediaPlayer, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        this.slowFps = OplusGLSurfaceView_13;
        this.realFps = COUIBaseListPopupWindow_12;
        this.player = iMediaPlayer;
    }

    public static SlowMotionManager create(Context context, IMediaPlayer iMediaPlayer, String str, float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        if (!CommonUtil.isSlowMotionHsr(str) || OplusGLSurfaceView_13 <= 0 || OplusGLSurfaceView_15 <= 0) {
            LogUtil.m25452e(TAG, "title = " + str + ", realFps = " + COUIBaseListPopupWindow_12 + ", duration = " + OplusGLSurfaceView_15);
            return null;
        }
        SlowMotionManager slowMotionManager = new SlowMotionManager(iMediaPlayer, OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
        if (slowMotionManager.parseHsrInfo(str, OplusGLSurfaceView_15)) {
            return slowMotionManager;
        }
        return null;
    }

    public boolean parseHsrInfo(String str, long OplusGLSurfaceView_15) {
        if (this.realFps == INVALID_FPS) {
            String strSubstring = str.substring(str.indexOf(Constants.SLOW_MOTION_HSR_HEAD), str.indexOf(":"));
            LogUtil.m25450d(TAG, "parseHsrInfo: hsrPrefixTitle = " + strSubstring);
            String strSubstring2 = strSubstring.substring(Constants.SLOW_MOTION_HSR_HEAD.length());
            this.realFps = (float) Integer.parseInt(strSubstring2);
            LogUtil.m25450d(TAG, "Parse fps form title is " + strSubstring2 + ", realFps: " + this.realFps);
        }
        this.timesOfSlows = this.realFps / this.slowFps;
        LogUtil.m25450d(TAG, "timesOfSlows: " + this.timesOfSlows);
        String[] strArrSplit = str.substring(str.indexOf(":") + 1).split(",");
        long[] jArr = new long[4];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArrSplit.length && OplusGLSurfaceView_13 < 4; OplusGLSurfaceView_13++) {
            LogUtil.m25450d(TAG, "sHsrInfo[" + OplusGLSurfaceView_13 + "]: " + strArrSplit[OplusGLSurfaceView_13]);
            jArr[OplusGLSurfaceView_13] = Long.valueOf(strArrSplit[OplusGLSurfaceView_13]).longValue();
        }
        if (jArr[0] >= 0 && jArr[0] < OplusGLSurfaceView_15 && jArr[1] > jArr[0]) {
            long j2 = jArr[0];
            long j3 = jArr[1] > OplusGLSurfaceView_15 ? OplusGLSurfaceView_15 : jArr[1];
            SlowMotionInfo[] slowMotionInfoArr = this.slowIfs;
            int i2 = this.slowInfoLen;
            this.slowInfoLen = i2 + 1;
            slowMotionInfoArr[i2] = new SlowMotionInfo(j2, j3, 0L, this.timesOfSlows);
        }
        if (jArr[2] >= jArr[1] && jArr[2] < OplusGLSurfaceView_15 && jArr[3] > jArr[2]) {
            long j4 = jArr[2];
            long j5 = jArr[3] > OplusGLSurfaceView_15 ? OplusGLSurfaceView_15 : jArr[3];
            SlowMotionInfo[] slowMotionInfoArr2 = this.slowIfs;
            int i3 = this.slowInfoLen;
            this.slowInfoLen = i3 + 1;
            slowMotionInfoArr2[i3] = new SlowMotionInfo(j4, j5, this.slowIfs[0].getStart() + ((slowMotionInfoArr2[0].getSlowEnd() - this.slowIfs[0].getSlowStart()) - this.slowIfs[0].getEnd()), this.timesOfSlows);
        }
        LogUtil.m25450d(TAG, "slowInfoLen: " + this.slowInfoLen);
        this.realDuration = OplusGLSurfaceView_15;
        this.slowDuration = OplusGLSurfaceView_15;
        for (int i4 = 0; i4 < this.slowInfoLen; i4++) {
            this.slowDuration += ((this.slowIfs[i4].getSlowEnd() - this.slowIfs[i4].getSlowStart()) - this.slowIfs[i4].getEnd()) + this.slowIfs[i4].getStart();
        }
        LogUtil.m25450d(TAG, "realDuration: " + this.realDuration + ", slowDuration: " + this.slowDuration);
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

    public long adaptPosition(long OplusGLSurfaceView_15, boolean z) {
        long j2;
        if (!this.isHsr) {
            return OplusGLSurfaceView_15;
        }
        if (z && OplusGLSurfaceView_15 >= this.slowDuration) {
            return this.realDuration;
        }
        if (!z && OplusGLSurfaceView_15 >= this.realDuration) {
            return this.slowDuration;
        }
        long diff = 0;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.slowInfoLen; OplusGLSurfaceView_13++) {
            diff += this.slowIfs[OplusGLSurfaceView_13].getDiff(OplusGLSurfaceView_15, !z);
        }
        if (z) {
            long j3 = (long) (OplusGLSurfaceView_15 - (diff * (1.0f - (1.0f / this.timesOfSlows))));
            j2 = this.realDuration;
            if (j3 < j2) {
                return j3;
            }
        } else {
            long j4 = (long) (OplusGLSurfaceView_15 + (diff * (this.timesOfSlows - 1.0f)));
            j2 = this.slowDuration;
            if (j4 < j2) {
                return j4;
            }
        }
        return j2;
    }

    protected Looper getLooper() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    private boolean needToSlow(long OplusGLSurfaceView_15, boolean z) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.slowInfoLen; OplusGLSurfaceView_13++) {
            if (this.slowIfs[OplusGLSurfaceView_13].isInside(OplusGLSurfaceView_15, z)) {
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
            LogUtil.m25450d(TAG, "need to slow, pos: " + currentPosition);
            this.player.setVolume(0.0f);
            this.player.setPlaybackRate(1.0f / this.timesOfSlows);
            this.isSlow = true;
        } else if (this.isSlow && !needToSlow(currentPosition, false)) {
            LogUtil.m25450d(TAG, "need to real, pos: " + currentPosition);
            this.player.setVolume(1.0f);
            this.player.setPlaybackRate(1.0f);
            this.isSlow = false;
        }
        this.handler.postDelayed(this.updatePlaybackRateAction, SLOW_MOTION_INTERNAL_MS);
    }
}
