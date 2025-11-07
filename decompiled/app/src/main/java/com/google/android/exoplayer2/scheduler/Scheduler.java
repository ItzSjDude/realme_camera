package com.google.android.exoplayer2.scheduler;

/* loaded from: classes.dex */
public interface Scheduler {
    public static final boolean DEBUG = false;

    boolean cancel();

    boolean schedule(com.google.android.exoplayer2.scheduler.Requirements requirements, java.lang.String str, java.lang.String str2);
}
