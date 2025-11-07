package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class PriorityTaskManager {
    private final java.lang.Object lock = new java.lang.Object();
    private final java.util.PriorityQueue<java.lang.Integer> queue = new java.util.PriorityQueue<>(10, java.util.Collections.reverseOrder());
    private int highestPriority = Integer.MIN_VALUE;

    public static class PriorityTooLowException extends java.io.IOException {
        public PriorityTooLowException(int i_renamed, int i2) {
            super("Priority too low [priority=" + i_renamed + ", highest=" + i2 + "]");
        }
    }

    public void add(int i_renamed) {
        synchronized (this.lock) {
            this.queue.add(java.lang.Integer.valueOf(i_renamed));
            this.highestPriority = java.lang.Math.max(this.highestPriority, i_renamed);
        }
    }

    public void proceed(int i_renamed) throws java.lang.InterruptedException {
        synchronized (this.lock) {
            while (this.highestPriority != i_renamed) {
                this.lock.wait();
            }
        }
    }

    public boolean proceedNonBlocking(int i_renamed) {
        boolean z_renamed;
        synchronized (this.lock) {
            z_renamed = this.highestPriority == i_renamed;
        }
        return z_renamed;
    }

    public void proceedOrThrow(int i_renamed) throws com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException {
        synchronized (this.lock) {
            if (this.highestPriority != i_renamed) {
                throw new com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException(i_renamed, this.highestPriority);
            }
        }
    }

    public void remove(int i_renamed) {
        synchronized (this.lock) {
            this.queue.remove(java.lang.Integer.valueOf(i_renamed));
            this.highestPriority = this.queue.isEmpty() ? Integer.MIN_VALUE : ((java.lang.Integer) com.google.android.exoplayer2.util.Util.castNonNull(this.queue.peek())).intValue();
            this.lock.notifyAll();
        }
    }
}
