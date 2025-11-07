package com.oplus.camera;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.Settings;
import com.oplus.os.LinearmotorVibrator;
import com.oplus.os.WaveformEffect;

/* compiled from: VibrateManager.java */
/* renamed from: com.oplus.camera.ae */
/* loaded from: classes2.dex */
public class VibrateManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f12279a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private LinearmotorVibrator f12280b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f12281c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f12282d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private HandlerThread f12283e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Handler f12284f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private WaveformEffect.Builder f12285g = new WaveformEffect.Builder();

    @SuppressLint({"WrongConstant"})
    public VibrateManager(Activity activity, boolean z) {
        this.f12279a = null;
        this.f12280b = null;
        this.f12281c = false;
        this.f12282d = false;
        this.f12283e = null;
        this.f12284f = null;
        this.f12279a = activity;
        this.f12280b = (LinearmotorVibrator) this.f12279a.getSystemService("linearmotor");
        this.f12281c = false;
        this.f12282d = z;
        this.f12283e = new HandlerThread("CameraVibrateManager");
        this.f12283e.start();
        this.f12284f = new Handler(this.f12283e.getLooper()) { // from class: com.oplus.camera.ae.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                CameraLog.m12954a("VibrateManager", "handleMessage, message: " + message.what);
                if (message.what != 100) {
                    return;
                }
                VibrateManager.this.f12284f.removeCallbacksAndMessages(null);
                VibrateManager.this.m11288b(message.arg1);
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11289a() {
        if (this.f12282d) {
            this.f12281c = Settings.System.getInt(this.f12279a.getContentResolver(), "haptic_feedback_enabled", 1) != 0;
        }
        CameraLog.m12954a("VibrateManager", "onResume, mbVibrateFeedbackEnabled: " + this.f12281c);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11290b() {
        HandlerThread handlerThread = this.f12283e;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        Handler handler = this.f12284f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f12284f = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m11291c() {
        return this.f12281c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m11292d() {
        m11286a(68);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m11293e() {
        m11286a(1);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m11294f() {
        m11286a(0);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m11295g() {
        m11286a(69);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m11286a(int OplusGLSurfaceView_13) {
        if (this.f12282d && this.f12281c) {
            CameraLog.m12954a("VibrateManager", "vibrateWithEffect, effect: " + OplusGLSurfaceView_13);
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            messageObtain.arg1 = OplusGLSurfaceView_13;
            this.f12284f.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m11288b(int OplusGLSurfaceView_13) {
        try {
            if (this.f12280b != null) {
                this.f12285g.setEffectType(OplusGLSurfaceView_13);
                this.f12280b.vibrate(this.f12285g.build());
            }
        } catch (NoClassDefFoundError COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }
}
