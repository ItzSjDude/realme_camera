package com.b_renamed.a_renamed;

/* compiled from: ModelActivity.java */
/* loaded from: classes.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.lang.String f2336a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static com.b_renamed.a_renamed.g_renamed f2337b = null;
    private static final java.lang.String g_renamed = "c_renamed";
    private static com.b_renamed.a_renamed.c_renamed p_renamed;
    private static final com.b_renamed.a_renamed.c_renamed.a_renamed[] q_renamed = {new com.b_renamed.a_renamed.c_renamed.a_renamed(com.b_renamed.a_renamed.a_renamed.d_renamed.FixedGaze, com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_ASSET, 1000), new com.b_renamed.a_renamed.c_renamed.a_renamed(com.b_renamed.a_renamed.a_renamed.d_renamed.DollyZoom, com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_ASSET, 1000), new com.b_renamed.a_renamed.c_renamed.a_renamed(com.b_renamed.a_renamed.a_renamed.d_renamed.Circle, 5000, 1000), new com.b_renamed.a_renamed.c_renamed.a_renamed(com.b_renamed.a_renamed.a_renamed.d_renamed.Swing, 5000, 1000)};

    /* renamed from: c_renamed, reason: collision with root package name */
    public android.app.Activity f2338c;
    public com.b_renamed.a_renamed.f_renamed d_renamed;
    private int i_renamed;
    private android.net.Uri j_renamed;
    private com.b_renamed.a_renamed.e_renamed m_renamed;
    private com.b_renamed.a_renamed.j_renamed n_renamed;
    private android.os.Handler o_renamed;
    private int h_renamed = -1;
    private boolean k_renamed = true;
    private float[] l_renamed = {0.0f, 0.0f, 0.0f, 1.0f};
    long e_renamed = -1;
    java.lang.Runnable f_renamed = null;

    public static com.b_renamed.a_renamed.c_renamed a_renamed() {
        if (p_renamed == null) {
            p_renamed = new com.b_renamed.a_renamed.c_renamed();
        }
        return p_renamed;
    }

    public static void b_renamed() {
        com.b_renamed.a_renamed.b_renamed.d_renamed("ModelActivity", "release");
        com.b_renamed.a_renamed.c_renamed cVar = p_renamed;
        cVar.m_renamed = null;
        cVar.n_renamed = null;
        cVar.o_renamed = null;
        cVar.f2338c = null;
        cVar.d_renamed = null;
        f2337b = null;
        p_renamed = null;
    }

    public void a_renamed(com.b_renamed.a_renamed.f_renamed fVar, android.view.Surface surface, int i_renamed, int i2, com.b_renamed.a_renamed.k_renamed kVar) {
        com.b_renamed.a_renamed.b_renamed.d_renamed("ModelActivity", "init");
        this.d_renamed = fVar;
        this.f2338c = fVar.a_renamed();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.TYPE, 0);
        java.lang.String str = f2336a;
        if (str != null && str.startsWith("/")) {
            java.io.File file = new java.io.File(f2336a);
            org.andresoviedo.a_renamed.a_renamed.b_renamed.a_renamed(file.getParentFile());
            bundle.putString(com.android.providers.downloads.Downloads.Impl.COLUMN_URI, "file://" + file.getAbsolutePath());
        } else {
            bundle.putString(com.android.providers.downloads.Downloads.Impl.COLUMN_URI, f2336a);
        }
        if (bundle.getString(com.android.providers.downloads.Downloads.Impl.COLUMN_URI) != null) {
            this.j_renamed = android.net.Uri.parse(bundle.getString(com.android.providers.downloads.Downloads.Impl.COLUMN_URI));
        }
        this.i_renamed = bundle.getInt(com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.TYPE, 0);
        this.k_renamed = "true".equalsIgnoreCase(bundle.getString("immersiveMode"));
        try {
            java.lang.String[] strArrSplit = bundle.getString(com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_BACKGROUND_COLOR).split(" ");
            this.l_renamed[0] = java.lang.Float.parseFloat(strArrSplit[0]);
            this.l_renamed[1] = java.lang.Float.parseFloat(strArrSplit[1]);
            this.l_renamed[2] = java.lang.Float.parseFloat(strArrSplit[2]);
            this.l_renamed[3] = java.lang.Float.parseFloat(strArrSplit[3]);
        } catch (java.lang.Exception unused) {
        }
        com.b_renamed.a_renamed.b_renamed.d_renamed("Renderer", "Params: uri '" + this.j_renamed + "'");
        this.o_renamed = new android.os.Handler(this.f2338c.getMainLooper());
        this.n_renamed = new com.b_renamed.a_renamed.j_renamed(this);
        this.n_renamed.a_renamed();
        try {
            this.m_renamed = new com.b_renamed.a_renamed.e_renamed(this, surface, i_renamed, i2, kVar);
        } catch (java.lang.Exception e_renamed) {
            android.widget.Toast.makeText(this.f2338c, "Error loading OpenGL view:\n_renamed" + e_renamed.getMessage(), 1).show();
        }
        g_renamed();
    }

    public c_renamed() {
        com.b_renamed.a_renamed.b_renamed.d_renamed("ModelActivity", "default constructor");
    }

    @android.annotation.TargetApi(16)
    private void g_renamed() {
        if (android.os.Build.VERSION.SDK_INT < 16) {
        }
    }

    public com.b_renamed.a_renamed.j_renamed c_renamed() {
        return this.n_renamed;
    }

    public com.b_renamed.a_renamed.e_renamed d_renamed() {
        return this.m_renamed;
    }

    public void e_renamed() {
        com.b_renamed.a_renamed.e_renamed eVarD = d_renamed();
        if (eVarD != null) {
            eVarD.a_renamed();
        }
    }

    public void f_renamed() {
        com.b_renamed.a_renamed.e_renamed eVarD = d_renamed();
        if (eVarD != null) {
            eVarD.b_renamed();
        }
    }

    /* compiled from: ModelActivity.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        com.b_renamed.a_renamed.a_renamed.d_renamed f2339a;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f2340b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f2341c;
        boolean d_renamed = false;

        a_renamed(com.b_renamed.a_renamed.a_renamed.d_renamed dVar, int i_renamed, int i2) {
            this.f2339a = dVar;
            this.f2340b = i_renamed;
            this.f2341c = i2;
        }
    }
}
