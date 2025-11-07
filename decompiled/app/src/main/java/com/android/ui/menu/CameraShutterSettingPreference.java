package com.android.ui.menu;

/* loaded from: classes.dex */
public class CameraShutterSettingPreference extends androidx.preference.Preference {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.String f2293a = "CameraShutterSettingPreference";

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.android.ui.menu.b_renamed f2294b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.viewpager2.widget.ViewPager2 f2295c;
    private com.coui.appcompat.widget.COUIPageIndicator d_renamed;

    public CameraShutterSettingPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.f2294b = null;
        this.f2295c = null;
        this.d_renamed = null;
    }

    public CameraShutterSettingPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f2294b = null;
        this.f2295c = null;
        this.d_renamed = null;
    }

    public CameraShutterSettingPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2294b = null;
        this.f2295c = null;
        this.d_renamed = null;
    }

    public CameraShutterSettingPreference(android.content.Context context) {
        super(context);
        this.f2294b = null;
        this.f2295c = null;
        this.d_renamed = null;
    }

    @Override // androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        super.a_renamed(lVar);
        this.f2295c = (androidx.viewpager2.widget.ViewPager2) lVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.view_pager);
        this.d_renamed = (com.coui.appcompat.widget.COUIPageIndicator) lVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.cpi);
        this.f2294b = new com.android.ui.menu.b_renamed(K_renamed());
        this.f2295c.setOrientation(0);
        this.f2295c.setAdapter(this.f2294b);
        this.d_renamed.setDotsCount(this.f2294b.getItemCount());
        this.f2295c.a_renamed(new androidx.viewpager2.widget.ViewPager2.e_renamed() { // from class: com.android.ui.menu.CameraShutterSettingPreference.1
            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
            public void onPageScrolled(int i_renamed, float f_renamed, int i2) {
                super.onPageScrolled(i_renamed, f_renamed, i2);
                com.android.ui.menu.CameraShutterSettingPreference.this.d_renamed.a_renamed(i_renamed, f_renamed, i2);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
            public void onPageSelected(int i_renamed) {
                super.onPageSelected(i_renamed);
                com.android.ui.menu.CameraShutterSettingPreference.this.d_renamed.a_renamed(i_renamed);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.e_renamed
            public void onPageScrollStateChanged(int i_renamed) {
                super.onPageScrollStateChanged(i_renamed);
                com.android.ui.menu.CameraShutterSettingPreference.this.d_renamed.b_renamed(i_renamed);
            }
        });
    }

    @Override // androidx.preference.Preference
    public void P_renamed() {
        super.P_renamed();
        this.d_renamed = null;
        this.f2294b = null;
        this.f2295c = null;
    }
}
