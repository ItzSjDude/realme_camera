package com.oplus.camera.photo3d.p159ui;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.photo3d.p159ui.MenuSwitcher;
import com.oplus.camera.photo3d.p159ui.SceneMenu;
import com.oplus.camera.util.Util;

/* compiled from: ThreeDPhotoUIControl.java */
/* renamed from: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class ThreeDPhotoUIControl {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final CameraUIInterface f15321b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private SceneMenu f15322c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final CameraInterface f15323d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final RelativeLayout f15324e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RotateImageView f15325f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f15326g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private MenuSwitcher f15327h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final Activity f15328i;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f15331l;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f15329j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f15330k = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Handler f15320a = new IntrinsicsJvm.kt_4(Looper.getMainLooper());

    /* compiled from: ThreeDPhotoUIControl.java */
    /* renamed from: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15223a(SceneItem c2873d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m15302a(boolean z) {
        return z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m15309c(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 > 0;
    }

    public ThreeDPhotoUIControl(Activity activity, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface) throws Resources.NotFoundException {
        this.f15328i = activity;
        this.f15323d = interfaceC2646a;
        this.f15321b = cameraUIInterface;
        this.f15324e = (RelativeLayout) this.f15321b.mo18163b();
        m15304a(activity, interfaceC2646a);
        m15316i();
        m15327a();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private MenuSwitcher m15316i() {
        this.f15327h = new MenuSwitcher(this.f15328i, this.f15324e);
        this.f15327h.m15272a(this.f15323d.mo10591u());
        this.f15327h.m15273a(new MenuSwitcher.PlatformImplementations.kt_3() { // from class: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_11.1
            @Override // com.oplus.camera.photo3d.p159ui.MenuSwitcher.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo15276a() {
                ThreeDPhotoUIControl.this.f15322c.m15290a(true);
                ThreeDPhotoUIControl.this.f15321b.mo18232j(true, true);
                ThreeDPhotoUIControl.this.f15323d.mo10479a((AnimatorListenerAdapter) null, true, true);
            }
        });
        return this.f15327h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15304a(Activity activity, CameraInterface interfaceC2646a) {
        this.f15322c = new SceneMenu(activity, interfaceC2646a.mo10590t());
        this.f15322c.m15289a(new SceneMenu.PlatformImplementations.kt_3() { // from class: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_11.2
            @Override // com.oplus.camera.photo3d.p159ui.SceneMenu.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo15295a(SceneItem c2873d) {
                CameraLog.m12959b("ThreeDPhotoUIControl", "onMenuItemClick, item: " + c2873d.m15277a());
                if (ThreeDPhotoUIControl.this.f15326g != null) {
                    ThreeDPhotoUIControl.this.f15326g.mo15223a(c2873d);
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15327a() throws Resources.NotFoundException {
        this.f15325f = new RotateImageView(this.f15328i);
        this.f15325f.setId(R.id_renamed.long_exposure_parameter_bottom_guide_entry);
        this.f15325f.setImageResource(R.drawable.professional_guide_tip);
        int dimensionPixelSize = this.f15328i.getResources().getDimensionPixelSize(R.dimen.long_exposure_bottom_guide_entry_size);
        int settingMenuPanelHeight = Util.getSettingMenuPanelHeight() + this.f15328i.getResources().getDimensionPixelSize(R.dimen.long_exposure_bottom_guide_entry_margin_top);
        int dimensionPixelSize2 = this.f15328i.getResources().getDimensionPixelSize(R.dimen.long_exposure_bottom_guide_entry_margin_end);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.addRule(10);
        layoutParams.addRule(21);
        layoutParams.setMargins(0, settingMenuPanelHeight, 0, 0);
        layoutParams.setMarginEnd(dimensionPixelSize2);
        this.f15325f.setLayoutParams(layoutParams);
        this.f15325f.setVisibility(0);
        this.f15325f.m18348a(this.f15323d.mo10591u(), false);
        this.f15325f.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_11.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreeDPhotoUIControl.this.f15321b == null || ThreeDPhotoUIControl.this.f15323d == null || ThreeDPhotoUIControl.this.f15323d.mo10450F()) {
                    return;
                }
                ThreeDPhotoUIControl.this.f15321b.mo18234k(9);
            }
        });
        this.f15325f.m18348a(this.f15323d.mo10591u(), false);
        this.f15321b.mo18087a((View) this.f15325f, ApsConstant.CAPTURE_MODE_3D_PHOTO, 2, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15328a(int OplusGLSurfaceView_13) {
        this.f15320a.obtainMessage(107, OplusGLSurfaceView_13, 0).sendToTarget();
    }

    /* compiled from: ThreeDPhotoUIControl.java */
    /* renamed from: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends Handler {
        public IntrinsicsJvm.kt_4(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    ThreeDPhotoUIControl.this.m15319j();
                    break;
                case 101:
                    ThreeDPhotoUIControl.this.m15322l();
                    break;
                case 102:
                    ThreeDPhotoUIControl.this.m15323m();
                    break;
                case 103:
                    ThreeDPhotoUIControl.this.m15324n();
                    break;
                case 104:
                    ThreeDPhotoUIControl.this.f15327h.m15274a(ThreeDPhotoUIControl.this.m15309c(message.arg1), ThreeDPhotoUIControl.this.m15309c(message.arg2));
                    break;
                case 105:
                    ThreeDPhotoUIControl.this.f15327h.m15275b(ThreeDPhotoUIControl.this.m15309c(message.arg1), ThreeDPhotoUIControl.this.m15309c(message.arg2));
                    break;
                case 106:
                    ThreeDPhotoUIControl.this.f15322c.m15293b(false);
                    break;
                case 107:
                    ThreeDPhotoUIControl.this.f15327h.m15272a(message.arg1);
                    ThreeDPhotoUIControl.this.f15325f.m18348a(message.arg1, true);
                    break;
                case 108:
                    ThreeDPhotoUIControl c2876g = ThreeDPhotoUIControl.this;
                    c2876g.m15311d(c2876g.m15309c(message.arg1), ThreeDPhotoUIControl.this.m15309c(message.arg2));
                    break;
                case 110:
                    ThreeDPhotoUIControl.this.m15325o();
                    break;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15332b() {
        this.f15320a.sendEmptyMessage(100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m15319j() {
        if (!this.f15331l) {
            this.f15321b.mo18070a(R.string.camera_3d_photo_capture_suggestion, -1, true, false, false);
            this.f15331l = true;
        }
        m15320k();
        this.f15321b.mo18070a(R.string.camera_3d_photo_preview_hint, -1, false, false, true);
        this.f15327h.m15274a(false, false);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m15320k() {
        SharedPreferences sharedPreferencesMo10590t = this.f15323d.mo10590t();
        if (sharedPreferencesMo10590t.getBoolean("key_show_3d_guide", true)) {
            this.f15321b.mo18234k(9);
            sharedPreferencesMo10590t.edit().putBoolean("key_show_3d_guide", false).apply();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15333b(int OplusGLSurfaceView_13) {
        this.f15329j = OplusGLSurfaceView_13;
        this.f15320a.sendEmptyMessage(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public void m15322l() {
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
        c3200b.m19227a("button_color_inside_none");
        c3200b.m19226a(13);
        this.f15321b.mo18221h(this.f15329j);
        this.f15321b.mo18091a(c3200b);
        this.f15321b.mo18107a(false, false);
        this.f15321b.mo18226i(this.f15328i.getResources().getDimensionPixelOffset(R.dimen.night_countdown_time_margin_top));
        this.f15321b.mo18082a(this.f15329j, false);
        this.f15330k = this.f15329j;
        this.f15320a.removeMessages(110);
        this.f15320a.sendEmptyMessageDelayed(110, 1000L);
        this.f15321b.mo18215g(4);
        this.f15321b.mo18209f(4);
        this.f15321b.mo18077a(4, false);
        this.f15321b.mo18232j(true, true);
        this.f15323d.mo10479a((AnimatorListenerAdapter) null, true, true);
        this.f15321b.mo18067a(R.string.camera_3d_photo_preview_hint);
        this.f15322c.m15293b(false);
        this.f15327h.m15275b(true, true);
        this.f15325f.setVisibility(8);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15335c() {
        this.f15320a.sendEmptyMessage(102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m15323m() {
        if (this.f15330k > 0) {
            this.f15321b.mo18217g(false);
            this.f15320a.removeMessages(110);
        }
        this.f15329j = 0;
        this.f15330k = 0;
        this.f15321b.mo18091a(new MainShutterButtonInfo(1, "button_color_inside_none", "button_shape_ring_none", 0));
        this.f15321b.mo18200d(true, true);
        this.f15321b.mo18067a(R.string.camera_3d_photo_process_hint);
        this.f15321b.mo18070a(R.string.camera_3d_photo_preview_hint, -1, false, false, true);
        this.f15321b.mo18215g(0);
        this.f15321b.mo18209f(0);
        this.f15321b.mo18077a(0, false);
        this.f15321b.mo18240l(true, false);
        this.f15323d.mo10492a(true, false);
        this.f15327h.m15274a(false, false);
        this.f15325f.setVisibility(0);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15337d() {
        this.f15320a.sendEmptyMessage(103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public void m15324n() {
        this.f15322c.m15293b(false);
        this.f15327h.m15275b(false, false);
        this.f15321b.mo18203e(9, true);
        this.f15320a.removeCallbacksAndMessages(null);
        this.f15330k = 0;
        this.f15329j = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15330a(boolean z, boolean z2) {
        this.f15320a.obtainMessage(108, m15302a(z), m15302a(z2)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m15311d(boolean z, boolean z2) {
        if (!z) {
            this.f15327h.m15275b(true, false);
            this.f15325f.setVisibility(8);
            this.f15322c.m15293b(false);
        } else {
            if (z2) {
                return;
            }
            this.f15327h.m15274a(false, false);
            this.f15325f.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m15325o() {
        this.f15330k -= 1000;
        this.f15321b.mo18082a(this.f15330k, false);
        if (this.f15330k > 0) {
            this.f15320a.sendEmptyMessageDelayed(110, 1000L);
        } else {
            m15326p();
        }
    }

    /* renamed from: p */
    private void m15326p() {
        if (this.f15329j > 0) {
            MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
            c3200b.m19227a("button_color_inside_none");
            c3200b.m19226a(4);
            this.f15321b.mo18091a(c3200b);
            this.f15321b.mo18217g(true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m15338e() {
        return this.f15322c.m15291a();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m15339f() {
        return this.f15325f.getVisibility() == 0;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m15340g() {
        this.f15320a.sendEmptyMessage(106);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m15331a(MotionEvent motionEvent) {
        CameraLog.m12954a("ThreeDPhotoUIControl", "onSingleTapUp");
        if (!m15338e()) {
            return false;
        }
        Rect rect = new Rect();
        this.f15321b.mo18253p().getHitRect(rect);
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        m15340g();
        this.f15327h.m15274a(true, true);
        this.f15321b.mo18240l(true, true);
        this.f15323d.mo10492a(true, true);
        this.f15323d.mo10563d(true);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15334b(boolean z, boolean z2) {
        this.f15320a.obtainMessage(104, m15302a(z), m15302a(z2)).sendToTarget();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15336c(boolean z, boolean z2) {
        this.f15320a.obtainMessage(105, m15302a(z), m15302a(z2)).sendToTarget();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15329a(PlatformImplementations.kt_3 aVar) {
        this.f15326g = aVar;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m15341h() {
        m15337d();
        this.f15326g = null;
        RotateImageView rotateImageView = this.f15325f;
        if (rotateImageView != null) {
            rotateImageView.setOnClickListener(null);
        }
        MenuSwitcher c2872c = this.f15327h;
        if (c2872c != null) {
            c2872c.m15271a();
        }
        SceneMenu c2874e = this.f15322c;
        if (c2874e != null) {
            c2874e.m15292b();
        }
    }
}
