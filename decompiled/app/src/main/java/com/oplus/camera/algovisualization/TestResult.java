package com.oplus.camera.algovisualization;

/* compiled from: NetworkAuthenticationUtils.java */
/* loaded from: classes2.dex */
public class h_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.toolbar.COUIToolbar f4163c;
    private android.content.Context d_renamed;
    private java.lang.String e_renamed;
    private java.lang.String f_renamed;
    private java.lang.String g_renamed;
    private java.lang.String h_renamed;
    private java.lang.String i_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final int f4161a = 8;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final long f4162b = com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
    private long[] j_renamed = new long[8];

    public h_renamed(com.coui.appcompat.widget.toolbar.COUIToolbar cOUIToolbar, android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this.f4163c = null;
        this.d_renamed = null;
        this.e_renamed = "";
        this.f_renamed = "";
        this.g_renamed = "";
        this.h_renamed = "";
        this.i_renamed = "";
        this.f4163c = cOUIToolbar;
        this.d_renamed = context;
        this.e_renamed = str;
        this.f_renamed = str2;
        this.g_renamed = str3;
        this.h_renamed = str4;
        this.i_renamed = str5;
    }

    public void a_renamed() {
        this.f4163c.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.algovisualization.h_renamed.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                java.lang.System.arraycopy(com.oplus.camera.algovisualization.h_renamed.this.j_renamed, 1, com.oplus.camera.algovisualization.h_renamed.this.j_renamed, 0, com.oplus.camera.algovisualization.h_renamed.this.j_renamed.length - 1);
                com.oplus.camera.algovisualization.h_renamed.this.j_renamed[com.oplus.camera.algovisualization.h_renamed.this.j_renamed.length - 1] = android.os.SystemClock.uptimeMillis();
                if (com.oplus.camera.algovisualization.h_renamed.this.j_renamed[0] >= android.os.SystemClock.uptimeMillis() - com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    android.content.SharedPreferences sharedPreferences = com.oplus.camera.algovisualization.h_renamed.this.d_renamed.getSharedPreferences(com.oplus.camera.algovisualization.h_renamed.this.e_renamed, 0);
                    if (sharedPreferences.getBoolean(com.oplus.camera.algovisualization.h_renamed.this.f_renamed, false)) {
                        android.widget.Toast.makeText(com.oplus.camera.algovisualization.h_renamed.this.d_renamed, com.oplus.camera.algovisualization.h_renamed.this.h_renamed, 0).show();
                    } else {
                        new com.oplus.camera.ui.menu.a_renamed(com.oplus.camera.algovisualization.h_renamed.this.d_renamed, sharedPreferences, com.oplus.camera.algovisualization.h_renamed.this.f_renamed, com.oplus.camera.algovisualization.h_renamed.this.i_renamed, com.oplus.camera.algovisualization.h_renamed.this.g_renamed).show();
                    }
                    com.oplus.camera.algovisualization.h_renamed.this.j_renamed = new long[8];
                }
            }
        });
    }
}
