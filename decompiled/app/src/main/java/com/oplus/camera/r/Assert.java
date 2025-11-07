package com.oplus.camera.r_renamed;

/* compiled from: SLVBaseMode.java */
/* loaded from: classes2.dex */
public abstract class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected android.app.Activity f5304a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected com.oplus.camera.ui.CameraUIInterface f5305b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.oplus.camera.r_renamed.a_renamed.SLVBaseMode_2 f5306c = null;

    /* compiled from: SLVBaseMode.java */
    /* renamed from: com.oplus.camera.r_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface SLVBaseMode_2 {
        void a_renamed(java.lang.String str);

        void b_renamed(java.lang.String str);
    }

    abstract int a_renamed();

    protected java.lang.String a_renamed(java.lang.String str) {
        return "";
    }

    public boolean a_renamed(int i_renamed, android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str) {
        return false;
    }

    public boolean b_renamed() {
        return false;
    }

    public int c_renamed() {
        return Integer.MAX_VALUE;
    }

    public void d_renamed() {
    }

    public a_renamed(android.app.Activity activity, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.f5304a = activity;
        this.f5305b = cameraUIInterface;
        com.oplus.camera.e_renamed.a_renamed("SLVBaseMode", " enter");
    }

    public com.oplus.camera.ui.control.b_renamed a_renamed(int i_renamed) {
        com.oplus.camera.ui.control.b_renamed bVar;
        if (i_renamed == 1) {
            bVar = new com.oplus.camera.ui.control.b_renamed(6, "button_color_inside_red", "button_shape_dial_still", 1);
        } else {
            if (i_renamed != 2) {
                if (i_renamed != 3) {
                    return null;
                }
                com.oplus.camera.ui.control.b_renamed bVar2 = new com.oplus.camera.ui.control.b_renamed();
                bVar2.a_renamed("button_color_inside_none");
                bVar2.a_renamed(4);
                return bVar2;
            }
            bVar = new com.oplus.camera.ui.control.b_renamed(5, "button_color_inside_red", "button_shape_dial_still", 1);
        }
        return bVar;
    }

    public void a_renamed(com.oplus.camera.r_renamed.a_renamed.SLVBaseMode_2 interfaceC0110a) {
        this.f5306c = interfaceC0110a;
    }

    public void e_renamed() {
        this.f5304a = null;
        this.f5305b = null;
        this.f5306c = null;
        com.oplus.camera.e_renamed.a_renamed("SLVBaseMode", "exit");
    }
}
