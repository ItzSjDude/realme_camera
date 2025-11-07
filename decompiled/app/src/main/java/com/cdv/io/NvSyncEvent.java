package com.cdv.io;

/* loaded from: classes.dex */
public class NvSyncEvent {
    private boolean m_manualReset;
    private volatile boolean m_signaled = false;

    public NvSyncEvent(boolean z_renamed) {
        this.m_manualReset = false;
        this.m_manualReset = z_renamed;
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

    public boolean waitEvent(long j_renamed) {
        boolean z_renamed;
        if (j_renamed == 0) {
            synchronized (this) {
                z_renamed = this.m_signaled;
            }
            return z_renamed;
        }
        if (j_renamed > 0) {
            return waitEventWithTimeout(j_renamed);
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
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed("SyncEvent", "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            return false;
        }
    }

    private boolean waitEventWithTimeout(long j_renamed) {
        try {
            synchronized (this) {
                if (this.m_signaled) {
                    if (!this.m_manualReset) {
                        this.m_signaled = false;
                    }
                    return true;
                }
                long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                while (!this.m_signaled) {
                    wait(j_renamed);
                    long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                    long j2 = jElapsedRealtime2 - jElapsedRealtime;
                    if (j2 >= j_renamed) {
                        return false;
                    }
                    j_renamed -= j2;
                    jElapsedRealtime = jElapsedRealtime2;
                }
                if (!this.m_manualReset) {
                    this.m_signaled = false;
                }
                return true;
            }
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed("SyncEvent", "" + e_renamed.getMessage());
            e_renamed.printStackTrace();
            return false;
        }
    }
}
