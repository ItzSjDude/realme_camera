package com.oplus.camera.p172ui.modepanel;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.core.p036h.ViewCompat;
import com.google.android.material.badge.BadgeDrawable;
import com.oplus.camera.CameraLog;
import com.oplus.camera.DimenConstants;
import com.oplus.camera.R;
import com.oplus.camera.screen.ScreenModeManager;
import java.lang.ref.WeakReference;

/* compiled from: FloatViewContainer.java */
/* renamed from: com.oplus.camera.ui.modepanel.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class FloatViewContainer {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Activity f20534c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ScreenModeManager f20537f;

    /* renamed from: PlatformImplementations.kt_3 */
    private FloatView f20532a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private WeakReference<FrameLayout> f20533b = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f20535d = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f20536e = 0.0f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f20538g = 0;

    protected FloatViewContainer(Activity activity, ScreenModeManager c2953g) {
        this.f20534c = null;
        this.f20537f = null;
        this.f20534c = activity;
        this.f20537f = c2953g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected int m21826a() {
        FloatView c3346d = this.f20532a;
        if (c3346d != null) {
            return c3346d.getModeId();
        }
        return -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m21830a(ModeInfo c3353k, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        synchronized (this) {
            if (1 != OplusGLSurfaceView_13 && 2 != OplusGLSurfaceView_13) {
                CameraLog.m12967f("FloatViewContainer", "add, can't add float view, invalid type: " + OplusGLSurfaceView_13);
                return;
            }
            m21823a(m21825j());
            if (m21824i() == null) {
                return;
            }
            if (this.f20532a != null) {
                return;
            }
            this.f20532a = new FloatView(this.f20534c);
            boolean z = 1 == this.f20534c.getResources().getConfiguration().getLayoutDirection();
            this.f20532a.setRotation(this.f20537f.mo16411a().mo16570k());
            int[] iArr = {i2, i3};
            int[] iArrA = this.f20537f.mo16411a().mo16531a(i2, i3);
            this.f20532a.setLayoutParams(m21822a(OplusGLSurfaceView_13, iArrA[0], iArrA[1], c3353k.m21919a(), z, i4));
            this.f20532a.m21817a(this.f20538g, this.f20537f.mo16411a().mo16570k());
            this.f20532a.m21819a(c3353k, OplusGLSurfaceView_13);
            m21824i().addView(this.f20532a);
            this.f20532a.m21816a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m21831b() {
        FloatView c3346d = this.f20532a;
        if (c3346d == null) {
            return;
        }
        c3346d.setVisibility(8);
        FrameLayout frameLayoutM21824i = m21824i();
        if (ViewCompat.m2826D(this.f20532a) && frameLayoutM21824i != null) {
            frameLayoutM21824i.removeView(this.f20532a);
            this.f20533b = null;
        }
        this.f20532a = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21823a(FrameLayout frameLayout) {
        if (frameLayout == null || this.f20532a == null) {
            this.f20533b = new WeakReference<>(frameLayout);
            return;
        }
        if (m21824i() != null && this.f20532a.getParent() == m21824i()) {
            m21824i().removeView(this.f20532a);
        }
        this.f20533b = new WeakReference<>(frameLayout);
        frameLayout.addView(this.f20532a);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private FrameLayout m21824i() {
        WeakReference<FrameLayout> weakReference = this.f20533b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private FrameLayout.LayoutParams m21822a(int OplusGLSurfaceView_13, int i2, int i3, String str, boolean z, int i4) throws Resources.NotFoundException {
        FrameLayout.LayoutParams layoutParams;
        int dimensionPixelSize = this.f20534c.getResources().getDimensionPixelSize(R.dimen.float_view_width);
        int dimensionPixelSize2 = this.f20534c.getResources().getDimensionPixelSize(R.dimen.float_view_height);
        if (1 == OplusGLSurfaceView_13) {
            layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            this.f20532a.setTag(R.id_renamed.tag_float_view_measure_width, Integer.valueOf(((int) this.f20532a.m21812a(str, 1)) + (DimenConstants.m14489g() * 2)));
        } else {
            layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
            this.f20532a.setTag(R.id_renamed.tag_float_view_measure_width, Integer.valueOf(i4));
        }
        layoutParams.gravity = BadgeDrawable.TOP_START;
        layoutParams.setLayoutDirection(z ? 1 : 0);
        if (1 != OplusGLSurfaceView_13) {
            if (2 == OplusGLSurfaceView_13) {
                i2 = (int) (i2 - ((Math.max(i4, DimenConstants.m14486d()) - (this.f20532a.m21812a(str, 2) + (DimenConstants.m14489g() * 2))) / 2.0f));
                i3 = (int) (i3 - ((DimenConstants.m14487e() - DimenConstants.m14481a()) / 2.0f));
            } else {
                i2 = 0;
                i3 = 0;
            }
        }
        int[] iArrA = this.f20537f.mo16411a().mo16532a(i2 + this.f20534c.getResources().getDimensionPixelSize(R.dimen.float_view_container_left_margin_offset), i3 + this.f20534c.getResources().getDimensionPixelSize(R.dimen.float_view_container_top_margin_offset), dimensionPixelSize, dimensionPixelSize2);
        int i5 = iArrA[0];
        int i6 = iArrA[1];
        if (z) {
            layoutParams.topMargin = i6;
            layoutParams.setMarginStart(i5);
        } else {
            layoutParams.setMargins(i5, i6, 0, 0);
        }
        return layoutParams;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private FrameLayout m21825j() {
        Activity activity = this.f20534c;
        if (activity == null) {
            return null;
        }
        try {
            return (FrameLayout) activity.getWindow().getDecorView();
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("FloatViewContainer", "getActivityRoot error.", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected boolean m21832c() {
        FloatView c3346d = this.f20532a;
        if (c3346d != null) {
            return c3346d.isShown();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected boolean m21833d() {
        FloatView c3346d = this.f20532a;
        if (c3346d != null) {
            return c3346d.m21821c();
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void m21834e() {
        FloatView c3346d = this.f20532a;
        if (c3346d != null) {
            c3346d.m21814a();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void m21835f() {
        FloatView c3346d = this.f20532a;
        if (c3346d != null) {
            c3346d.m21820b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m21829a(MotionEvent motionEvent) {
        float COUIBaseListPopupWindow_12;
        if (motionEvent.getAction() == 0) {
            this.f20535d = motionEvent.getRawX();
            this.f20536e = motionEvent.getRawY();
            return;
        }
        float f2 = 0.0f;
        if (2 == motionEvent.getAction()) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            f2 = rawX - this.f20535d;
            COUIBaseListPopupWindow_12 = rawY - this.f20536e;
            this.f20535d = rawX;
            this.f20536e = rawY;
        } else {
            COUIBaseListPopupWindow_12 = 0.0f;
        }
        FloatView c3346d = this.f20532a;
        if (c3346d != null) {
            c3346d.m21815a(f2, COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected Rect m21836g() {
        FloatView c3346d = this.f20532a;
        if (c3346d != null) {
            return c3346d.getFloatLocation();
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected float m21837h() {
        FloatView c3346d = this.f20532a;
        if (c3346d != null) {
            return c3346d.getTextTranslationY();
        }
        return 0.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m21828a(Rect rect, int OplusGLSurfaceView_13) {
        FloatView c3346d;
        if (rect == null || (c3346d = this.f20532a) == null) {
            CameraLog.m12967f("FloatViewContainer", "adsorpt, params invalid, targetRect: " + rect + ", mFloatView: " + this.f20532a);
            return;
        }
        c3346d.m21818a(rect, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21827a(int OplusGLSurfaceView_13) {
        this.f20538g = OplusGLSurfaceView_13;
        FloatView c3346d = this.f20532a;
        if (c3346d != null) {
            c3346d.m21817a(this.f20538g, this.f20537f.mo16411a().mo16570k());
            if (this.f20532a.getVisibility() == 0) {
                this.f20532a.setVisibility(4);
                this.f20532a = null;
            }
        }
        DimenConstants.m14483a(this.f20534c, OplusGLSurfaceView_13);
    }
}
