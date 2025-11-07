package com.oplus.camera.p162s;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import com.oplus.camera.p172ui.widget.SlowVideoModeSeekBar;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StarVideoUI.java */
/* renamed from: com.oplus.camera.s.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
class StarVideoUI {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f15933a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SharedPreferences f15934b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CameraUIInterface f15935c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f15936d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private SlowVideoModeSeekBar f15937e = null;

    public StarVideoUI(Activity activity, SharedPreferences sharedPreferences, CameraUIInterface cameraUIInterface) {
        this.f15933a = null;
        this.f15934b = null;
        this.f15935c = null;
        this.f15933a = activity;
        this.f15934b = sharedPreferences;
        this.f15935c = cameraUIInterface;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16368a(int OplusGLSurfaceView_13) {
        this.f15936d = OplusGLSurfaceView_13;
        SlowVideoModeSeekBar c3519b = this.f15937e;
        if (c3519b != null) {
            c3519b.m24098a(OplusGLSurfaceView_13, true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16367a() throws Resources.NotFoundException {
        CameraUIInterface cameraUIInterface = this.f15935c;
        if (cameraUIInterface != null) {
            cameraUIInterface.mo18070a(R.string.camera_scene_star_video_mode_fixed_tips, -1, false, false, true);
            m16373b(false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16369a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        CameraUIInterface cameraUIInterface = this.f15935c;
        if (cameraUIInterface != null) {
            cameraUIInterface.mo18081a(OplusGLSurfaceView_15, OplusGLSurfaceView_13 * 1000, true, false, 0L);
            CameraLog.m12962c("StarVideoUI", "updateRecordingTime, recordingTime: " + OplusGLSurfaceView_15 + ", videoTimeSec: " + OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16372b() {
        Activity activity = this.f15933a;
        if (activity == null || this.f15935c == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.s.-$$Lambda$IntrinsicsJvm.kt_3$M-5x8FNBauq5dDRGjExSuKf2Aws
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.COUIBaseListPopupWindow_12$0.m16366f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public /* synthetic */ void m16366f() throws Resources.NotFoundException {
        m16375c(false);
        this.f15935c.mo18243m(true);
        this.f15935c.mo18215g(4);
        this.f15935c.mo18167b(4, true);
        this.f15935c.mo18077a(4, false);
        this.f15935c.mo18091a(new MainShutterButtonInfo(5, "button_color_inside_red", "button_shape_dial_rotate", 1));
        this.f15935c.mo18107a(true, false);
        m16369a(0, 0L);
        this.f15935c.mo18096a(Float.valueOf(0.1f), this.f15933a.getResources().getDimensionPixelSize(R.dimen.record_time_margin_top), true, true);
        this.f15935c.mo18067a(R.string.camera_scene_star_video_mode_fixed_tips);
        this.f15935c.mo18104a(m16363d(), DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private List<Integer> m16363d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.string.camera_scene_night_tips));
        arrayList.add(Integer.valueOf(R.string.camera_scene_night_light_collect_tips_oplus_r));
        arrayList.add(Integer.valueOf(R.string.camera_star_video_keep_battery_enough));
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16371a(final boolean z, final MainShutterButtonInfo c3200b, final boolean z2, final boolean z3) {
        CameraLog.m12962c("StarVideoUI", "hideRecordingUI");
        Activity activity = this.f15933a;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.s.-$$Lambda$IntrinsicsJvm.kt_3$MCjS81XJPLL4n_q-c5KWcxvQPr8
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.COUIBaseListPopupWindow_12$0.m16362b(z, c3200b, z3, z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m16362b(boolean z, MainShutterButtonInfo c3200b, boolean z2, boolean z3) throws Resources.NotFoundException {
        CameraUIInterface cameraUIInterface = this.f15935c;
        if (cameraUIInterface != null) {
            cameraUIInterface.mo18212f(z);
            this.f15935c.mo18245n();
            this.f15935c.mo18070a(R.string.camera_scene_star_video_mode_fixed_tips, -1, false, false, true);
            this.f15935c.mo18092a(c3200b, false);
            this.f15935c.mo18167b(0, true);
            if (z2) {
                this.f15935c.mo18077a(0, true);
            } else {
                this.f15935c.mo18286y(true);
            }
            this.f15935c.mo18036H();
            m16373b(false);
            if (z3) {
                this.f15935c.mo18155as();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16370a(final boolean z) {
        Activity activity = this.f15933a;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.s.-$$Lambda$IntrinsicsJvm.kt_3$ZiZt8qBKlXDRwGvV3Pe__IIp_OU
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m16364d(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m16364d(boolean z) {
        CameraUIInterface cameraUIInterface = this.f15935c;
        if (cameraUIInterface != null) {
            cameraUIInterface.mo18212f(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16373b(boolean z) throws Resources.NotFoundException {
        if (this.f15937e == null) {
            m16365e();
        }
        this.f15937e.m24097a(this.f15934b.getInt(CameraUIInterface.KEY_STAR_VIDEO_RECORD_TOTAL_TIME, 5400000));
        this.f15937e.m24098a(this.f15936d, false);
        RelativeLayout relativeLayoutMo18253p = this.f15935c.mo18253p();
        int dimensionPixelSize = this.f15933a.getResources().getDimensionPixelSize(R.dimen.star_video_time_seekbar_width);
        int dimensionPixelSize2 = this.f15933a.getResources().getDimensionPixelSize(R.dimen.star_video_time_seekbar_height);
        int height = relativeLayoutMo18253p.getHeight() - (this.f15933a.findViewById(R.id_renamed.control_panel_layout).getTop() - relativeLayoutMo18253p.getTop());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, height);
        this.f15937e.setLayoutParams(layoutParams);
        if (relativeLayoutMo18253p.indexOfChild(this.f15937e) < 0) {
            relativeLayoutMo18253p.addView(this.f15937e);
        }
        if (z) {
            Util.m24270a(this.f15937e, 0, (Animation.AnimationListener) null, 300L);
        } else {
            this.f15937e.setVisibility(0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16375c(boolean z) {
        SlowVideoModeSeekBar c3519b;
        CameraUIInterface cameraUIInterface = this.f15935c;
        if (cameraUIInterface == null || cameraUIInterface.mo18163b() == null || (c3519b = this.f15937e) == null) {
            return;
        }
        if (z) {
            Util.m24270a(c3519b, 8, (Animation.AnimationListener) null, 300L);
        } else {
            c3519b.setVisibility(8);
        }
        this.f15935c.mo18163b().removeView(this.f15937e);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m16365e() {
        this.f15937e = new SlowVideoModeSeekBar(this.f15933a);
        this.f15937e.setModeFrameChangeListener(new SlowVideoModeSeekBar.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.s.-$$Lambda$IntrinsicsJvm.kt_3$n7w2dmeCK4Zb0rbtS0w2EXg58L4
            @Override // com.oplus.camera.p172ui.widget.SlowVideoModeSeekBar.IntrinsicsJvm.kt_4
            public final void onSlowVideoFrameChange(int OplusGLSurfaceView_13) {
                this.COUIBaseListPopupWindow_12$0.m16361b(OplusGLSurfaceView_13);
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SlowVideoModeSeekBar.PlatformImplementations.kt_3(3600000, this.f15933a.getString(R.string.camera_star_video_record_time_60m)));
        arrayList.add(new SlowVideoModeSeekBar.PlatformImplementations.kt_3(5400000, this.f15933a.getString(R.string.camera_star_video_record_time_90m)));
        arrayList.add(new SlowVideoModeSeekBar.PlatformImplementations.kt_3(7200000, this.f15933a.getString(R.string.camera_star_video_record_time_120m)));
        arrayList.add(new SlowVideoModeSeekBar.PlatformImplementations.kt_3(14400000, this.f15933a.getString(R.string.camera_star_video_record_time_240m)));
        this.f15937e.setFrameList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m16361b(int OplusGLSurfaceView_13) {
        SharedPreferences sharedPreferences = this.f15934b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(CameraUIInterface.KEY_STAR_VIDEO_RECORD_TOTAL_TIME, OplusGLSurfaceView_13).apply();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16374c() {
        this.f15933a = null;
        this.f15934b = null;
        this.f15935c = null;
    }
}
