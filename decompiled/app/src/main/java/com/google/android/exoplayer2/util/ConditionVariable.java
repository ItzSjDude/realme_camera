package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class ConditionVariable {
    private boolean isOpen;

    public synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public synchronized boolean close() {
        boolean z_renamed;
        z_renamed = this.isOpen;
        this.isOpen = false;
        return z_renamed;
    }

    public synchronized void block() throws java.lang.InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }

    public synchronized boolean block(long j_renamed) throws java.lang.InterruptedException {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j2 = j_renamed + jElapsedRealtime;
        while (!this.isOpen && jElapsedRealtime < j2) {
            wait(j2 - jElapsedRealtime);
            jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        }
        return this.isOpen;
    }
}
