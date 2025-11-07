package com.b_renamed.a_renamed;

/* compiled from: SurfaceListener.java */
/* loaded from: classes.dex */
public interface k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.lang.String f2364a = "k_renamed";

    void a_renamed(android.view.Surface surface);

    void a_renamed(com.b_renamed.a_renamed.a_renamed.e_renamed eVar);

    void b_renamed(android.view.Surface surface);

    void b_renamed(com.b_renamed.a_renamed.a_renamed.e_renamed eVar);

    void c_renamed(com.b_renamed.a_renamed.a_renamed.e_renamed eVar);

    default boolean a_renamed(long j_renamed) throws java.lang.InterruptedException {
        if (j_renamed <= 0) {
            return true;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - j_renamed;
        if (jCurrentTimeMillis <= 0 || jCurrentTimeMillis >= 33) {
            return true;
        }
        try {
            java.lang.Thread.sleep(33 - jCurrentTimeMillis);
            return true;
        } catch (java.lang.InterruptedException e_renamed) {
            com.b_renamed.a_renamed.b_renamed.a_renamed(f2364a, "onFrameRenderFinished InterruptedException e_renamed : " + e_renamed);
            return true;
        }
    }
}
