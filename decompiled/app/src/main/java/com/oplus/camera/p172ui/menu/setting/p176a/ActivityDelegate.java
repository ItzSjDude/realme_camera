package com.oplus.camera.p172ui.menu.setting.p176a;

import android.app.Activity;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegate;
import com.oplus.camera.p172ui.menu.setting.ActivityConfig;

/* compiled from: ActivityDelegate.java */
/* renamed from: com.oplus.camera.ui.menu.setting.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ActivityDelegate {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Activity f19994a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ActivityConfig f19995b;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21283a() {
    }

    public ActivityDelegate(Activity activity) {
        this.f19994a = activity;
        this.f19995b = (ActivityConfig) this.f19994a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21285a(AppCompatDelegate abstractC0207e) {
        SystemUiDelegate.m21287a(this.f19994a, this.f19995b.mo21281c());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21286b(AppCompatDelegate abstractC0207e) {
        ActionBar abstractC0203aMo798a = abstractC0207e.mo798a();
        if (abstractC0203aMo798a != null) {
            abstractC0203aMo798a.mo880a(this.f19995b.mo21280a());
        }
        if (this.f19995b.mo21282h_()) {
            TitleDelegate.m21288a(this.f19994a);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21284a(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.f19994a.finish();
        }
    }
}
