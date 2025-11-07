package com.oplus.camera;

/* compiled from: CameraMotorManager.java */
/* loaded from: classes2.dex */
public class g_renamed extends android.content.BroadcastReceiver {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.oplus.camera.g_renamed f4535a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.ref.WeakReference<android.os.MotorManager> f4536b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f4537c = false;
    private boolean d_renamed = false;
    private boolean e_renamed = false;
    private boolean f_renamed = false;
    private java.lang.Runnable g_renamed = null;

    public static com.oplus.camera.g_renamed a_renamed(android.content.Context context) {
        com.oplus.camera.g_renamed gVar;
        synchronized (com.oplus.camera.g_renamed.class) {
            if (f4535a == null) {
                f4535a = new com.oplus.camera.g_renamed();
                f4535a.b_renamed(context);
            }
            gVar = f4535a;
        }
        return gVar;
    }

    private void b_renamed(android.content.Context context) {
        if (context != null && this.f4536b == null && com.oplus.camera.util.Util.h_renamed("oplus.software.motor_support")) {
            com.oplus.camera.e_renamed.a_renamed("CameraMotorManager", "initMotorManager, support hardware motor.");
            this.f4536b = new java.lang.ref.WeakReference<>((android.os.MotorManager) context.getSystemService(android.os.MotorManager.class));
            this.e_renamed = com.oplus.camera.util.Util.h_renamed("oplus.software.motor.backcamera");
            this.d_renamed = com.oplus.camera.util.Util.h_renamed("oplus.software.motor.backflash");
            this.f_renamed = true;
        }
    }

    public boolean a_renamed() {
        return this.d_renamed;
    }

    public boolean b_renamed() {
        return this.e_renamed;
    }

    public boolean c_renamed() {
        return this.f_renamed;
    }

    public void a_renamed(android.app.Activity activity) {
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("oplus.intent.action.MOTOR_UPED");
        activity.registerReceiver(this, intentFilter);
    }

    public void b_renamed(android.app.Activity activity) {
        activity.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        java.lang.Runnable runnable;
        java.lang.String action = intent.getAction();
        if (((action.hashCode() == -904839729 && action.equals("oplus.intent.action.MOTOR_UPED")) ? (char) 0 : (char) 65535) == 0 && (runnable = this.g_renamed) != null) {
            runnable.run();
            this.g_renamed = null;
        }
    }

    private boolean h_renamed() {
        java.lang.ref.WeakReference<android.os.MotorManager> weakReference = this.f4536b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public boolean d_renamed() {
        return !h_renamed() || this.f4536b.get().getMotorStateBySystemApp() == 10;
    }

    public void a_renamed(java.lang.Runnable runnable) {
        this.g_renamed = runnable;
    }

    public synchronized void e_renamed() {
        if (this.f4537c && h_renamed()) {
            int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MOTOR_DOWN_DELAY);
            if (configIntValue < 0) {
                configIntValue = 1000;
            }
            com.oplus.camera.e_renamed.a_renamed("CameraMotorManager", "downMotorByPrivacyApp, motorDelay: " + configIntValue);
            this.f4536b.get().downMotorByPrivacyApp("motor_force_by_camera", configIntValue);
            this.f4537c = false;
        }
    }

    public synchronized void f_renamed() {
        if (this.f4537c && h_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("CameraMotorManager", "downMotorBySystemApp");
            this.f4536b.get().downMotorBySystemApp("motor_force_by_camera");
            this.f4537c = false;
        }
    }

    public synchronized void g_renamed() {
        if (!this.f4537c && h_renamed()) {
            int motorStateBySystemApp = this.f4536b.get().getMotorStateBySystemApp();
            com.oplus.camera.e_renamed.a_renamed("CameraMotorManager", "upMotorBySystemApp, motorState: " + motorStateBySystemApp);
            if (10 == motorStateBySystemApp) {
                this.f4536b.get().upMotorBySystemApp("motor_force_by_camera");
                this.f4537c = true;
            }
        }
    }

    public synchronized void a_renamed(int i_renamed) {
        android.os.MotorManager motorManager;
        if (h_renamed() && (motorManager = this.f4536b.get()) != null) {
            int motorStateBySystemApp = motorManager.getMotorStateBySystemApp();
            com.oplus.camera.e_renamed.a_renamed("CameraMotorManager", "breathLedLoopEffect, motorState: " + motorStateBySystemApp);
            if (10 == motorStateBySystemApp) {
                motorManager.breathLedLoopEffect(i_renamed);
            }
        }
    }

    public void b_renamed(int i_renamed) {
        java.io.PrintWriter printWriter;
        android.net.LocalSocket localSocket = new android.net.LocalSocket();
        try {
            localSocket.connect(new android.net.LocalSocketAddress("motor_socket"));
            localSocket.setSoTimeout(1000);
            printWriter = new java.io.PrintWriter(localSocket.getOutputStream());
        } catch (java.io.IOException e_renamed) {
            com.oplus.camera.e_renamed.c_renamed("CameraMotorManager", "sendSocketToMotorManager, local socket connect", e_renamed);
            printWriter = null;
        }
        if (printWriter != null) {
            printWriter.print(("1," + android.os.Process.myPid() + ",com.oplus.camera," + i_renamed).toCharArray());
            printWriter.flush();
            printWriter.close();
        }
        try {
            localSocket.close();
        } catch (java.io.IOException e2) {
            com.oplus.camera.e_renamed.d_renamed("CameraMotorManager", "sendSocketToMotorManager, local socket close", e2);
        }
    }
}
