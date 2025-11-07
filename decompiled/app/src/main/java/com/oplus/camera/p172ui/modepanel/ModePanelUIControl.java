package com.oplus.camera.p172ui.modepanel;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.modepanel.ModeTitle;

/* compiled from: ModePanelUIControl.java */
/* renamed from: com.oplus.camera.ui.modepanel.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class ModePanelUIControl {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f20594a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ViewGroup f20595b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20596c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PathInterpolator f20597d = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PathInterpolator f20598e = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ModeTitle f20599f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ModeTitle.PlatformImplementations.kt_3 f20600g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f20601h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f20602i = 0;

    public ModePanelUIControl(Activity activity, ViewGroup viewGroup) {
        this.f20594a = null;
        this.f20595b = null;
        this.f20596c = 0;
        this.f20594a = activity;
        this.f20595b = viewGroup;
        this.f20596c = this.f20594a.getResources().getDimensionPixelSize(R.dimen.headline_change_move_distance);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21946a(ModeTitle.PlatformImplementations.kt_3 aVar) {
        this.f20600g = aVar;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m21941f() throws Resources.NotFoundException {
        if (this.f20599f == null) {
            this.f20599f = new ModeTitle(this.f20594a, this.f20595b);
            this.f20599f.m21973a(this.f20601h, this.f20602i);
            this.f20599f.m21976a(this.f20600g);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21947a(String str) throws Resources.NotFoundException {
        m21941f();
        this.f20599f.m21977a(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21948a(boolean z) {
        ModeTitle viewOnClickListenerC3356n = this.f20599f;
        if (viewOnClickListenerC3356n != null) {
            viewOnClickListenerC3356n.m21978a(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21943a(int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        this.f20601h = OplusGLSurfaceView_13;
        this.f20602i = i2;
        ModeTitle viewOnClickListenerC3356n = this.f20599f;
        if (viewOnClickListenerC3356n != null) {
            viewOnClickListenerC3356n.m21973a(OplusGLSurfaceView_13, this.f20602i);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m21942a() {
        ModeTitle viewOnClickListenerC3356n = this.f20599f;
        return viewOnClickListenerC3356n != null ? viewOnClickListenerC3356n.m21972a() : "";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21949a(boolean z, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        m21941f();
        this.f20599f.m21975a(0, z, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21944a(Animation animation) throws Resources.NotFoundException {
        m21945a(animation, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21945a(Animation animation, boolean z) throws Resources.NotFoundException {
        m21941f();
        this.f20599f.m21974a(0, animation, z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21950b() throws Resources.NotFoundException {
        m21941f();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(this.f20597d);
        alphaAnimation.setDuration(250L);
        alphaAnimation.setStartOffset(150L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.f20596c, 0.0f);
        translateAnimation.setInterpolator(this.f20598e);
        translateAnimation.setDuration(400L);
        translateAnimation.setStartOffset(150L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        this.f20599f.m21974a(0, (Animation) animationSet, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21953b(boolean z, int OplusGLSurfaceView_13) {
        ModeTitle viewOnClickListenerC3356n = this.f20599f;
        if (viewOnClickListenerC3356n != null) {
            viewOnClickListenerC3356n.m21975a(8, z, OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21951b(Animation animation) {
        ModeTitle viewOnClickListenerC3356n = this.f20599f;
        if (viewOnClickListenerC3356n != null) {
            viewOnClickListenerC3356n.m21974a(8, animation, false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21954c() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(this.f20597d);
        alphaAnimation.setDuration(250L);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.f20596c);
        translateAnimation.setInterpolator(this.f20598e);
        translateAnimation.setDuration(400L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        ModeTitle viewOnClickListenerC3356n = this.f20599f;
        if (viewOnClickListenerC3356n != null) {
            viewOnClickListenerC3356n.m21974a(8, (Animation) animationSet, true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m21955d() {
        ModeTitle viewOnClickListenerC3356n = this.f20599f;
        if (viewOnClickListenerC3356n != null) {
            return viewOnClickListenerC3356n.m21980b();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m21956e() {
        ModeTitle viewOnClickListenerC3356n = this.f20599f;
        return viewOnClickListenerC3356n != null && viewOnClickListenerC3356n.m21981c();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m21952b(boolean z) {
        ModeTitle viewOnClickListenerC3356n = this.f20599f;
        if (viewOnClickListenerC3356n != null) {
            viewOnClickListenerC3356n.m21979b(z);
        }
    }
}
