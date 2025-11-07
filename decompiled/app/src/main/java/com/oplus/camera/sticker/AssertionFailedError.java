package com.oplus.camera.sticker;

/* compiled from: MaterailInfo.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.Object f5426a = new java.lang.Object();

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.sensetime.stmobile.STMobileStickerNative f5427b = new com.sensetime.stmobile.STMobileStickerNative();

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.sensetime.stmobile.model.STHumanAction f5428c = null;
    private com.sensetime.stmobile.model.STHumanAction d_renamed = null;
    private java.util.LinkedHashMap<java.lang.Long, com.sensetime.stmobile.model.STHumanAction> e_renamed = null;
    private long f_renamed = 0;
    private com.oplus.camera.gl_renamed.s_renamed g_renamed = null;
    private int h_renamed = -1;
    private android.util.Size i_renamed = null;
    private float j_renamed = 1.0f;
    private float k_renamed = 1.0f;
    private boolean l_renamed = false;

    public com.sensetime.stmobile.STMobileStickerNative a_renamed() {
        return this.f5427b;
    }

    public void a_renamed(com.sensetime.stmobile.model.STHumanAction sTHumanAction) {
        this.f5428c = sTHumanAction;
    }

    public void b_renamed(com.sensetime.stmobile.model.STHumanAction sTHumanAction) {
        synchronized (this.f5426a) {
            if (this.e_renamed != null && !this.e_renamed.isEmpty() && this.l_renamed) {
                java.util.Iterator<java.lang.Long> it = this.e_renamed.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    java.lang.Long next = it.next();
                    if (this.e_renamed.get(next) == null) {
                        this.e_renamed.put(next, sTHumanAction);
                        com.oplus.camera.e_renamed.a_renamed("MaterialInfo", "setPreviewSTHumanActionForCheck, timeStamp: " + next);
                        break;
                    }
                }
            }
        }
    }

    public void a_renamed(float f_renamed) {
        this.j_renamed = f_renamed;
    }

    public com.sensetime.stmobile.model.STHumanAction b_renamed(float f_renamed) {
        return com.sensetime.stmobile.model.STHumanAction.humanActionResize(f_renamed / this.j_renamed, this.f5428c);
    }

    public void a_renamed(long j_renamed) {
        this.f_renamed = j_renamed;
    }

    public long b_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(com.oplus.camera.gl_renamed.s_renamed sVar) {
        this.g_renamed = sVar;
    }

    public com.oplus.camera.gl_renamed.s_renamed c_renamed() {
        return this.g_renamed;
    }
}
