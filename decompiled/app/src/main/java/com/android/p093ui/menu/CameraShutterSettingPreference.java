package com.android.p093ui.menu;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.Preference;
import androidx.viewpager2.widget.ViewPager2;
import com.coui.appcompat.widget.COUIPageIndicator;
import com.oplus.camera.R;

/* loaded from: classes.dex */
public class CameraShutterSettingPreference extends Preference {

    /* renamed from: PlatformImplementations.kt_3 */
    private static String f5970a = "CameraShutterSettingPreference";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private MultiplePageAdapter f5971b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ViewPager2 f5972c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private COUIPageIndicator f5973d;

    public CameraShutterSettingPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f5971b = null;
        this.f5972c = null;
        this.f5973d = null;
    }

    public CameraShutterSettingPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f5971b = null;
        this.f5972c = null;
        this.f5973d = null;
    }

    public CameraShutterSettingPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5971b = null;
        this.f5972c = null;
        this.f5973d = null;
    }

    public CameraShutterSettingPreference(Context context) {
        super(context);
        this.f5971b = null;
        this.f5972c = null;
        this.f5973d = null;
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        this.f5972c = (ViewPager2) c0668l.m4007a(R.id_renamed.view_pager);
        this.f5973d = (COUIPageIndicator) c0668l.m4007a(R.id_renamed.cpi);
        this.f5971b = new MultiplePageAdapter(m3800K());
        this.f5972c.setOrientation(0);
        this.f5972c.setAdapter(this.f5971b);
        this.f5973d.setDotsCount(this.f5971b.getItemCount());
        this.f5972c.m5044a(new ViewPager2.AbstractC0845e() { // from class: com.android.ui.menu.CameraShutterSettingPreference.1
            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageScrolled(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
                super.onPageScrolled(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, i2);
                CameraShutterSettingPreference.this.f5973d.m7404a(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, i2);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageSelected(int OplusGLSurfaceView_13) {
                super.onPageSelected(OplusGLSurfaceView_13);
                CameraShutterSettingPreference.this.f5973d.m7403a(OplusGLSurfaceView_13);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageScrollStateChanged(int OplusGLSurfaceView_13) {
                super.onPageScrollStateChanged(OplusGLSurfaceView_13);
                CameraShutterSettingPreference.this.f5973d.m7405b(OplusGLSurfaceView_13);
            }
        });
    }

    @Override // androidx.preference.Preference
    /* renamed from: P */
    public void mo3805P() {
        super.mo3805P();
        this.f5973d = null;
        this.f5971b = null;
        this.f5972c = null;
    }
}
