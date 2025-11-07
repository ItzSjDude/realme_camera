package com.oplus.camera;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.MotorManager;
import android.os.Process;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;

/* compiled from: CameraMotorManager.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class CameraMotorManager extends BroadcastReceiver {

    /* renamed from: PlatformImplementations.kt_3 */
    private static CameraMotorManager f13746a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private WeakReference<MotorManager> f13747b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f13748c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f13749d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f13750e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f13751f = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Runnable f13752g = null;

    /* renamed from: PlatformImplementations.kt_3 */
    public static CameraMotorManager m13703a(Context context) {
        CameraMotorManager c2725g;
        synchronized (CameraMotorManager.class) {
            if (f13746a == null) {
                f13746a = new CameraMotorManager();
                f13746a.m13704b(context);
            }
            c2725g = f13746a;
        }
        return c2725g;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m13704b(Context context) {
        if (context != null && this.f13747b == null && Util.m24459h("oplus.software.motor_support")) {
            CameraLog.m12954a("CameraMotorManager", "initMotorManager, support hardware motor.");
            this.f13747b = new WeakReference<>((MotorManager) context.getSystemService(MotorManager.class));
            this.f13750e = Util.m24459h("oplus.software.motor.backcamera");
            this.f13749d = Util.m24459h("oplus.software.motor.backflash");
            this.f13751f = true;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m13709a() {
        return this.f13749d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m13712b() {
        return this.f13750e;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m13713c() {
        return this.f13751f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13707a(Activity activity) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("oplus.intent.action.MOTOR_UPED");
        activity.registerReceiver(this, intentFilter);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13711b(Activity activity) {
        activity.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Runnable runnable;
        String action = intent.getAction();
        if (((action.hashCode() == -904839729 && action.equals("oplus.intent.action.MOTOR_UPED")) ? (char) 0 : (char) 65535) == 0 && (runnable = this.f13752g) != null) {
            runnable.run();
            this.f13752g = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean m13705h() {
        WeakReference<MotorManager> weakReference = this.f13747b;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m13714d() {
        return !m13705h() || this.f13747b.get().getMotorStateBySystemApp() == 10;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13708a(Runnable runnable) {
        this.f13752g = runnable;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public synchronized void m13715e() {
        if (this.f13748c && m13705h()) {
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MOTOR_DOWN_DELAY);
            if (configIntValue < 0) {
                configIntValue = 1000;
            }
            CameraLog.m12954a("CameraMotorManager", "downMotorByPrivacyApp, motorDelay: " + configIntValue);
            this.f13747b.get().downMotorByPrivacyApp("motor_force_by_camera", configIntValue);
            this.f13748c = false;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public synchronized void m13716f() {
        if (this.f13748c && m13705h()) {
            CameraLog.m12954a("CameraMotorManager", "downMotorBySystemApp");
            this.f13747b.get().downMotorBySystemApp("motor_force_by_camera");
            this.f13748c = false;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public synchronized void m13717g() {
        if (!this.f13748c && m13705h()) {
            int motorStateBySystemApp = this.f13747b.get().getMotorStateBySystemApp();
            CameraLog.m12954a("CameraMotorManager", "upMotorBySystemApp, motorState: " + motorStateBySystemApp);
            if (10 == motorStateBySystemApp) {
                this.f13747b.get().upMotorBySystemApp("motor_force_by_camera");
                this.f13748c = true;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m13706a(int OplusGLSurfaceView_13) {
        MotorManager motorManager;
        if (m13705h() && (motorManager = this.f13747b.get()) != null) {
            int motorStateBySystemApp = motorManager.getMotorStateBySystemApp();
            CameraLog.m12954a("CameraMotorManager", "breathLedLoopEffect, motorState: " + motorStateBySystemApp);
            if (10 == motorStateBySystemApp) {
                motorManager.breathLedLoopEffect(OplusGLSurfaceView_13);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13710b(int OplusGLSurfaceView_13) {
        PrintWriter printWriter;
        LocalSocket localSocket = new LocalSocket();
        try {
            localSocket.connect(new LocalSocketAddress("motor_socket"));
            localSocket.setSoTimeout(1000);
            printWriter = new PrintWriter(localSocket.getOutputStream());
        } catch (IOException COUIBaseListPopupWindow_8) {
            CameraLog.m12963c("CameraMotorManager", "sendSocketToMotorManager, local socket connect", COUIBaseListPopupWindow_8);
            printWriter = null;
        }
        if (printWriter != null) {
            printWriter.print(("1," + Process.myPid() + ",com.oplus.camera," + OplusGLSurfaceView_13).toCharArray());
            printWriter.flush();
            printWriter.close();
        }
        try {
            localSocket.close();
        } catch (IOException e2) {
            CameraLog.m12965d("CameraMotorManager", "sendSocketToMotorManager, local socket close", e2);
        }
    }
}
