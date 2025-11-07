package com.oplus.camera.algovisualization;

import android.app.Activity;
import android.content.SharedPreferences;

/* compiled from: VisualizationStatePreferenceHelper.java */
/* renamed from: com.oplus.camera.algovisualization.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class VisualizationStatePreferenceHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f12534a = "state";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f12535b = "visualizationState";

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f12536c = "pictureState";

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f12537d = "currentTime";

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final String f12538e = "showInfo";

    /* renamed from: COUIBaseListPopupWindow_12 */
    private SharedPreferences f12539f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private SharedPreferences.Editor f12540g;

    public VisualizationStatePreferenceHelper(Activity activity) {
        this.f12539f = activity.getApplicationContext().getSharedPreferences("showInfo", 0);
        this.f12540g = this.f12539f.edit();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m11637a() {
        return this.f12539f.getBoolean("state", false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m11639b() {
        return this.f12539f.getBoolean("visualizationState", false);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m11641c() {
        return this.f12539f.getBoolean("pictureState", false);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public long m11642d() {
        return this.f12539f.getLong("currentTime", 0L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11636a(boolean z) {
        this.f12540g.putBoolean("state", z);
        this.f12540g.apply();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11638b(boolean z) {
        this.f12540g.putBoolean("visualizationState", z);
        this.f12540g.apply();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11640c(boolean z) {
        this.f12540g.putBoolean("pictureState", z);
        this.f12540g.apply();
    }
}
