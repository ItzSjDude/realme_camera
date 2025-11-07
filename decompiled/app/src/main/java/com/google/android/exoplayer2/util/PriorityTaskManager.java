package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
public final class PriorityTaskManager {
    private final Object lock = new Object();
    private final PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
    private int highestPriority = Integer.MIN_VALUE;

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int OplusGLSurfaceView_13, int i2) {
            super("Priority too low [priority=" + OplusGLSurfaceView_13 + ", highest=" + i2 + "]");
        }
    }

    public void add(int OplusGLSurfaceView_13) {
        synchronized (this.lock) {
            this.queue.add(Integer.valueOf(OplusGLSurfaceView_13));
            this.highestPriority = Math.max(this.highestPriority, OplusGLSurfaceView_13);
        }
    }

    public void proceed(int OplusGLSurfaceView_13) throws InterruptedException {
        synchronized (this.lock) {
            while (this.highestPriority != OplusGLSurfaceView_13) {
                this.lock.wait();
            }
        }
    }

    public boolean proceedNonBlocking(int OplusGLSurfaceView_13) {
        boolean z;
        synchronized (this.lock) {
            z = this.highestPriority == OplusGLSurfaceView_13;
        }
        return z;
    }

    public void proceedOrThrow(int OplusGLSurfaceView_13) throws PriorityTooLowException {
        synchronized (this.lock) {
            if (this.highestPriority != OplusGLSurfaceView_13) {
                throw new PriorityTooLowException(OplusGLSurfaceView_13, this.highestPriority);
            }
        }
    }

    public void remove(int OplusGLSurfaceView_13) {
        synchronized (this.lock) {
            this.queue.remove(Integer.valueOf(OplusGLSurfaceView_13));
            this.highestPriority = this.queue.isEmpty() ? Integer.MIN_VALUE : ((Integer) Util.castNonNull(this.queue.peek())).intValue();
            this.lock.notifyAll();
        }
    }
}
