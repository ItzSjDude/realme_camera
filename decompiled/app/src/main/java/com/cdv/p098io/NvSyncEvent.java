package com.cdv.p098io;

import android.os.SystemClock;
import android.util.Log;

/* loaded from: classes.dex */
public class NvSyncEvent {
    private boolean m_manualReset;
    private volatile boolean m_signaled = false;

    public NvSyncEvent(boolean z) {
        this.m_manualReset = false;
        this.m_manualReset = z;
    }

    public void setEvent() {
        synchronized (this) {
            if (!this.m_signaled) {
                this.m_signaled = true;
                notifyAll();
            }
        }
    }

    public void resetEvent() {
        synchronized (this) {
            this.m_signaled = false;
        }
    }

    public boolean waitEvent(long OplusGLSurfaceView_15) {
        boolean z;
        if (OplusGLSurfaceView_15 == 0) {
            synchronized (this) {
                z = this.m_signaled;
            }
            return z;
        }
        if (OplusGLSurfaceView_15 > 0) {
            return waitEventWithTimeout(OplusGLSurfaceView_15);
        }
        try {
            synchronized (this) {
                while (!this.m_signaled) {
                    wait();
                }
                if (!this.m_manualReset) {
                    this.m_signaled = false;
                }
            }
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("SyncEvent", "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    private boolean waitEventWithTimeout(long OplusGLSurfaceView_15) {
        try {
            synchronized (this) {
                if (this.m_signaled) {
                    if (!this.m_manualReset) {
                        this.m_signaled = false;
                    }
                    return true;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                while (!this.m_signaled) {
                    wait(OplusGLSurfaceView_15);
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    long j2 = jElapsedRealtime2 - jElapsedRealtime;
                    if (j2 >= OplusGLSurfaceView_15) {
                        return false;
                    }
                    OplusGLSurfaceView_15 -= j2;
                    jElapsedRealtime = jElapsedRealtime2;
                }
                if (!this.m_manualReset) {
                    this.m_signaled = false;
                }
                return true;
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("SyncEvent", "" + COUIBaseListPopupWindow_8.getMessage());
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }
}
