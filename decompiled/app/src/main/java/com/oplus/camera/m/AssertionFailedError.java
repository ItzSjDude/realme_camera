package com.oplus.camera.m_renamed;

/* compiled from: ImageSaverThread.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.camera.m_renamed.d_renamed {
    private static com.oplus.camera.m_renamed.b_renamed d_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.m_renamed.c_renamed f4875c = new com.oplus.camera.m_renamed.c_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.concurrent.ExecutorService f4874b = java.util.concurrent.Executors.newSingleThreadExecutor();

    @Override // com.oplus.camera.m_renamed.d_renamed
    protected void b_renamed() {
    }

    public void c_renamed() {
    }

    public static com.oplus.camera.m_renamed.b_renamed a_renamed() {
        com.oplus.camera.m_renamed.b_renamed bVar;
        synchronized (com.oplus.camera.m_renamed.b_renamed.class) {
            if (d_renamed == null) {
                d_renamed = new com.oplus.camera.m_renamed.b_renamed();
            }
            bVar = d_renamed;
        }
        return bVar;
    }

    private b_renamed() {
    }

    public boolean a_renamed(android.app.Activity activity, long j_renamed) {
        com.oplus.camera.m_renamed.c_renamed cVar = this.f4875c;
        if (cVar != null) {
            return cVar.a_renamed(activity, j_renamed);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:71:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:74:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:77:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:90:0x024f  */
    @Override // com.oplus.camera.m_renamed.d_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b_renamed(final com.oplus.camera.Storage.CameraPicture r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 643
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.m_renamed.b_renamed.b_renamed(com.oplus.camera.Storage$CameraPicture):void");
    }
}
