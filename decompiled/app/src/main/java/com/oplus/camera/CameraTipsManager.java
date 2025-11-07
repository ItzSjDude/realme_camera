package com.oplus.camera;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.p044e.p045a.LocalBroadcastManager;
import androidx.preference.PreferenceManager;
import com.oplus.camera.util.Util;
import com.oplus.ocs.camera.BuildConfig;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/* compiled from: CameraTipsManager.java */
/* renamed from: com.oplus.camera.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class CameraTipsManager {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String f14377a = Util.m24249a("com.oplus.camera.OPEN_CAMERA_TIME", BuildConfig.FLAVOR, "b3Bwbw==");

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final String f14378b = Util.m24249a("com.oplus.camera.CLICK_ULTRA_WIDE", BuildConfig.FLAVOR, "b3Bwbw==");

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static volatile CameraTipsManager f14379c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Queue<Integer> f14380d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Context f14382f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private SharedPreferences f14383g;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f14381e = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f14384h = false;

    private CameraTipsManager() {
        this.f14380d = null;
        this.f14382f = null;
        this.f14383g = null;
        this.f14380d = new PriorityQueue(new Comparator<Integer>() { // from class: com.oplus.camera.OplusGLSurfaceView_15.1
            @Override // java.util.Comparator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public int compare(Integer num, Integer num2) {
                return num.intValue() - num2.intValue();
            }
        });
        this.f14382f = MyApplication.m11092d();
        this.f14383g = PreferenceManager.m3981a(this.f14382f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static CameraTipsManager m14374a() {
        if (f14379c == null) {
            synchronized (CameraTipsManager.class) {
                if (f14379c == null) {
                    f14379c = new CameraTipsManager();
                }
            }
        }
        return f14379c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14375a(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("CameraTipsManager", "addTipsToQueue, mTipsShown: " + this.f14381e + ", queueTag: " + OplusGLSurfaceView_13);
        if (this.f14381e != 0) {
            if (this.f14380d.contains(Integer.valueOf(OplusGLSurfaceView_13)) || this.f14381e == OplusGLSurfaceView_13) {
                return;
            }
            this.f14380d.add(Integer.valueOf(OplusGLSurfaceView_13));
            return;
        }
        m14377b(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14377b(int OplusGLSurfaceView_13) {
        this.f14381e = OplusGLSurfaceView_13;
        Intent intent = new Intent();
        intent.setAction("com.oplus.camera.TIPS_MANAGER_BR_ACTION");
        intent.putExtra("com.oplus.camera.TIPS_MANAGER_DATA", OplusGLSurfaceView_13);
        CameraLog.m12959b("CameraTipsManager", "sendShowTipsBroadcast, queueTag: " + OplusGLSurfaceView_13);
        LocalBroadcastManager.m3241a(Util.m24472l()).m3245a(intent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14376b() {
        CameraLog.m12959b("CameraTipsManager", "resetBroadcastState");
        this.f14381e = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14378c() {
        Queue<Integer> queue = this.f14380d;
        if (queue != null && !queue.isEmpty()) {
            Integer numPoll = this.f14380d.poll();
            m14377b(numPoll == null ? 0 : numPoll.intValue());
        } else {
            m14376b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m14379d() {
        int OplusGLSurfaceView_13 = this.f14383g.getInt("com.oplus.camera.OPEN_CAMERA_TIME", 0);
        CameraLog.m12959b("CameraTipsManager", "getOpenCameraTime, openCameraTime: " + OplusGLSurfaceView_13);
        return OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m14380e() {
        int OplusGLSurfaceView_13 = this.f14383g.getInt("com.oplus.camera.OPEN_CAMERA_TIME", 0) + 1;
        this.f14383g.edit().putInt("com.oplus.camera.OPEN_CAMERA_TIME", OplusGLSurfaceView_13).apply();
        CameraLog.m12959b("CameraTipsManager", "addOpenCameraTime, openCameraTime: " + OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m14381f() {
        boolean z = this.f14383g.getBoolean("com.oplus.camera.CLICK_ULTRA_WIDE", false);
        CameraLog.m12959b("CameraTipsManager", "hasClickedUltraWide, click: " + z);
        return z;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m14382g() {
        if (this.f14384h) {
            return;
        }
        this.f14384h = true;
        this.f14383g.edit().putBoolean("com.oplus.camera.CLICK_ULTRA_WIDE", true).apply();
    }
}
