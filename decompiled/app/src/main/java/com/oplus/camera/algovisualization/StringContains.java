package com.oplus.camera.algovisualization;

/* compiled from: VisualizationStatePreferenceHelper.java */
/* loaded from: classes2.dex */
public class j_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f4167a = "state";

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.String f4168b = "visualizationState";

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String f4169c = "pictureState";
    private final java.lang.String d_renamed = "currentTime";
    private final java.lang.String e_renamed = "showInfo";
    private android.content.SharedPreferences f_renamed;
    private android.content.SharedPreferences.Editor g_renamed;

    public j_renamed(android.app.Activity activity) {
        this.f_renamed = activity.getApplicationContext().getSharedPreferences("showInfo", 0);
        this.g_renamed = this.f_renamed.edit();
    }

    public boolean a_renamed() {
        return this.f_renamed.getBoolean("state", false);
    }

    public boolean b_renamed() {
        return this.f_renamed.getBoolean("visualizationState", false);
    }

    public boolean c_renamed() {
        return this.f_renamed.getBoolean("pictureState", false);
    }

    public long d_renamed() {
        return this.f_renamed.getLong("currentTime", 0L);
    }

    public void a_renamed(boolean z_renamed) {
        this.g_renamed.putBoolean("state", z_renamed);
        this.g_renamed.apply();
    }

    public void b_renamed(boolean z_renamed) {
        this.g_renamed.putBoolean("visualizationState", z_renamed);
        this.g_renamed.apply();
    }

    public void c_renamed(boolean z_renamed) {
        this.g_renamed.putBoolean("pictureState", z_renamed);
        this.g_renamed.apply();
    }
}
