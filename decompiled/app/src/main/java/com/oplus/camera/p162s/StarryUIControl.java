package com.oplus.camera.p162s;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.MainShutterButtonInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StarryUIControl.java */
/* renamed from: com.oplus.camera.s.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class StarryUIControl {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Activity f15949d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CameraUIInterface f15951f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private PlatformImplementations.kt_3 f15953h;

    /* renamed from: PlatformImplementations.kt_3 */
    private long f15946a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private long f15947b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f15948c = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ArrayList f15952g = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Handler f15950e = new IntrinsicsJvm.kt_4();

    /* compiled from: StarryUIControl.java */
    /* renamed from: com.oplus.camera.s.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo16384a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo16385b();
    }

    public StarryUIControl(Activity activity, CameraUIInterface cameraUIInterface, PlatformImplementations.kt_3 aVar) {
        this.f15953h = null;
        this.f15949d = activity;
        this.f15951f = cameraUIInterface;
        this.f15953h = aVar;
    }

    /* compiled from: StarryUIControl.java */
    /* renamed from: com.oplus.camera.s.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends Handler {
        private IntrinsicsJvm.kt_4() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                StarryUIControl.this.m16395e();
                return;
            }
            if (OplusGLSurfaceView_13 == 2) {
                StarryUIControl.this.m16397f();
                return;
            }
            if (OplusGLSurfaceView_13 != 3) {
                if (OplusGLSurfaceView_13 != 4) {
                    return;
                }
                StarryUIControl.this.m16391b((MainShutterButtonInfo) message.obj, message.arg1 == 1);
            } else {
                StarryUIControl.this.m16398g();
                StarryUIControl c2923e = StarryUIControl.this;
                c2923e.m16389b(c2923e.f15946a);
                StarryUIControl.this.m16399h();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16401a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            this.f15951f.mo18070a(R.string.camera_scene_starry_mode_fixed_tips_oplus_r, -1, false, false, true);
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            this.f15951f.mo18108a(true, true, false);
            this.f15951f.mo18104a(m16394d(), DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private List<Integer> m16394d() {
        ArrayList arrayList = this.f15952g;
        if (arrayList != null) {
            return arrayList;
        }
        this.f15952g = new ArrayList();
        this.f15952g.add(Integer.valueOf(R.string.camera_scene_night_tips));
        this.f15952g.add(Integer.valueOf(R.string.camera_scene_night_light_collect_tips_oplus_r));
        this.f15952g.add(Integer.valueOf(R.string.camera_scene_night_image_optimizing_tips_oplus_r));
        return this.f15952g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16402a(long OplusGLSurfaceView_15) {
        this.f15948c = false;
        this.f15946a = OplusGLSurfaceView_15;
        this.f15950e.removeMessages(1);
        this.f15950e.sendEmptyMessage(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16389b(long OplusGLSurfaceView_15) {
        MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
        c3200b.m19227a("button_color_inside_none");
        c3200b.m19226a(7);
        this.f15951f.mo18221h((int) OplusGLSurfaceView_15);
        this.f15951f.mo18091a(c3200b);
        this.f15951f.mo18107a(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m16395e() {
        this.f15947b -= 1000;
        this.f15951f.mo18082a(this.f15947b, false);
        if (this.f15947b > 0) {
            this.f15950e.sendEmptyMessageDelayed(1, 1000L);
        } else {
            this.f15950e.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m16397f() {
        CameraLog.m12954a("StarryUIControl", "doOnCountDownEnd");
        if (!this.f15948c) {
            MainShutterButtonInfo c3200b = new MainShutterButtonInfo();
            c3200b.m19227a("button_color_inside_none");
            c3200b.m19226a(4);
            this.f15951f.mo18091a(c3200b);
            this.f15951f.mo18217g(true);
            return;
        }
        this.f15953h.mo16384a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m16398g() {
        this.f15951f.mo18193d(4);
        this.f15951f.mo18215g(4);
        this.f15951f.mo18167b(4, true);
        this.f15951f.mo18209f(4);
        this.f15951f.mo18077a(4, false);
        if (this.f15953h.mo16385b()) {
            return;
        }
        this.f15951f.mo18286y(false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16400a() {
        this.f15950e.removeCallbacksAndMessages(null);
        this.f15951f.mo18217g(true);
        this.f15951f.mo18067a(R.string.camera_scene_starry_mode_fixed_tips_oplus_r);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16403a(MainShutterButtonInfo c3200b, boolean z) {
        this.f15946a = 0L;
        this.f15950e.removeMessages(1);
        Message messageObtainMessage = this.f15950e.obtainMessage(4);
        messageObtainMessage.arg1 = z ? 1 : 0;
        messageObtainMessage.obj = c3200b;
        this.f15950e.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16391b(MainShutterButtonInfo c3200b, boolean z) {
        this.f15951f.mo18245n();
        this.f15951f.mo18070a(R.string.camera_scene_starry_mode_fixed_tips_oplus_r, -1, false, false, true);
        this.f15951f.mo18200d(true, true);
        this.f15951f.mo18092a(c3200b, false);
        this.f15951f.mo18217g(true);
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STAR_VIDEO)) {
            this.f15951f.mo18193d(0);
        }
        this.f15951f.mo18167b(0, true);
        this.f15951f.mo18215g(0);
        this.f15951f.mo18209f(0);
        if (z) {
            this.f15951f.mo18155as();
        }
        if (this.f15953h.mo16385b()) {
            this.f15951f.mo18077a(0, true);
        } else {
            this.f15951f.mo18286y(true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m16404b() {
        this.f15948c = true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m16405c() {
        this.f15949d = null;
        this.f15951f = null;
        this.f15950e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m16399h() {
        this.f15951f.mo18226i(this.f15949d.getResources().getDimensionPixelOffset(R.dimen.night_countdown_time_margin_top));
        this.f15951f.mo18082a(this.f15946a, false);
        this.f15947b = this.f15946a;
        this.f15950e.sendEmptyMessageDelayed(1, 1000L);
    }
}
