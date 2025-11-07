package com.oplus.camera;

/* compiled from: VibrateManager.java */
/* loaded from: classes2.dex */
public class ae_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f4099a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.os.LinearmotorVibrator f4100b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f4101c;
    private boolean d_renamed;
    private android.os.HandlerThread e_renamed;
    private android.os.Handler f_renamed;
    private com.oplus.os.WaveformEffect.Builder g_renamed = new com.oplus.os.WaveformEffect.Builder();

    @android.annotation.SuppressLint({"WrongConstant"})
    public ae_renamed(android.app.Activity activity, boolean z_renamed) {
        this.f4099a = null;
        this.f4100b = null;
        this.f4101c = false;
        this.d_renamed = false;
        this.e_renamed = null;
        this.f_renamed = null;
        this.f4099a = activity;
        this.f4100b = (com.oplus.os.LinearmotorVibrator) this.f4099a.getSystemService("linearmotor");
        this.f4101c = false;
        this.d_renamed = z_renamed;
        this.e_renamed = new android.os.HandlerThread("CameraVibrateManager");
        this.e_renamed.start();
        this.f_renamed = new android.os.Handler(this.e_renamed.getLooper()) { // from class: com.oplus.camera.ae_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                com.oplus.camera.e_renamed.a_renamed("VibrateManager", "handleMessage, message: " + message.what);
                if (message.what != 100) {
                    return;
                }
                com.oplus.camera.ae_renamed.this.f_renamed.removeCallbacksAndMessages(null);
                com.oplus.camera.ae_renamed.this.b_renamed(message.arg1);
            }
        };
    }

    public void a_renamed() {
        if (this.d_renamed) {
            this.f4101c = android.provider.Settings.System.getInt(this.f4099a.getContentResolver(), "haptic_feedback_enabled", 1) != 0;
        }
        com.oplus.camera.e_renamed.a_renamed("VibrateManager", "onResume, mbVibrateFeedbackEnabled: " + this.f4101c);
    }

    public void b_renamed() {
        android.os.HandlerThread handlerThread = this.e_renamed;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        android.os.Handler handler = this.f_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f_renamed = null;
        }
    }

    public boolean c_renamed() {
        return this.f4101c;
    }

    public void d_renamed() {
        a_renamed(68);
    }

    public void e_renamed() {
        a_renamed(1);
    }

    public void f_renamed() {
        a_renamed(0);
    }

    public void g_renamed() {
        a_renamed(69);
    }

    private void a_renamed(int i_renamed) {
        if (this.d_renamed && this.f4101c) {
            com.oplus.camera.e_renamed.a_renamed("VibrateManager", "vibrateWithEffect, effect: " + i_renamed);
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 100;
            messageObtain.arg1 = i_renamed;
            this.f_renamed.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(int i_renamed) {
        try {
            if (this.f4100b != null) {
                this.g_renamed.setEffectType(i_renamed);
                this.f4100b.vibrate(this.g_renamed.build());
            }
        } catch (java.lang.NoClassDefFoundError e_renamed) {
            e_renamed.printStackTrace();
        }
    }
}
