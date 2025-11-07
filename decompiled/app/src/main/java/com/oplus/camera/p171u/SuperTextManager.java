package com.oplus.camera.p171u;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p172ui.CameraUIListener;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: SuperTextManager.java */
/* renamed from: com.oplus.camera.u.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class SuperTextManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f17080a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CameraUIListener f17081b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ISuperText f17083d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private HandlerThread f17085f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Handler f17086g;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private DetectResult f17082c = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Object f17084e = new Object();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f17087h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private Map<Long, DetectResult> f17088i = new LinkedHashMap<Long, DetectResult>() { // from class: com.oplus.camera.u.IntrinsicsJvm.kt_5.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Long, DetectResult> entry) {
            return size() > 5;
        }
    };

    public SuperTextManager(Activity activity, CameraUIListener cameraUIListener) {
        this.f17080a = null;
        this.f17081b = null;
        this.f17083d = null;
        this.f17085f = null;
        this.f17086g = null;
        this.f17080a = activity;
        this.f17081b = cameraUIListener;
        this.f17083d = SuperTextEngine.m17970d();
        this.f17085f = new HandlerThread("SuperTextManager");
        this.f17085f.start();
        this.f17086g = new Handler(this.f17085f.getLooper()) { // from class: com.oplus.camera.u.IntrinsicsJvm.kt_5.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                CameraLog.m12954a("SuperTextManager", "handleMessage, what: " + message.what);
                int OplusGLSurfaceView_13 = message.what;
                if (OplusGLSurfaceView_13 != 101) {
                    if (OplusGLSurfaceView_13 != 102) {
                        return;
                    }
                    SuperTextManager.this.m17985b((byte[]) message.obj, message.arg1, message.arg2, message.getData().getLong("timestamp"));
                    return;
                }
                Bundle data = message.getData();
                int i2 = data.getInt("width");
                int i3 = data.getInt("height");
                int i4 = data.getInt("orientation");
                long OplusGLSurfaceView_15 = data.getLong("timestamp");
                if (i2 <= 0 || i3 <= 0) {
                    return;
                }
                SuperTextManager.this.m17973a(i2, i3, i4, OplusGLSurfaceView_15);
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17980a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != this.f17083d.mo17963b()) {
            this.f17083d.mo17959a(OplusGLSurfaceView_13);
            m17987d();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m17978a() {
        return this.f17083d.mo17963b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17984b() {
        CameraLog.m12954a("SuperTextManager", "init, mSuperTextEngine: " + this.f17083d);
        if (this.f17083d != null) {
            m17981a(false);
            this.f17083d.mo17960a(CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT_CPU_PROCESS));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m17986c() {
        ISuperText interfaceC3078b = this.f17083d;
        if (interfaceC3078b != null) {
            return interfaceC3078b.mo17961a();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17981a(boolean z) {
        this.f17083d.mo17964b(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public DetectResult m17979a(long OplusGLSurfaceView_15) {
        synchronized (this.f17084e) {
            if (this.f17088i.size() <= 0) {
                return new DetectResult();
            }
            int OplusGLSurfaceView_13 = 0;
            long j2 = 0;
            DetectResult c3077a = null;
            Iterator<Long> it = this.f17088i.keySet().iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                DetectResult c3077a2 = this.f17088i.get(Long.valueOf(jLongValue));
                if (c3077a2 != null && c3077a2.m17956c()) {
                    OplusGLSurfaceView_13++;
                    j2 = jLongValue;
                    c3077a = c3077a2;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getProperDetectResultByTimestamp, time diff: ");
            long j3 = OplusGLSurfaceView_15 - j2;
            sb.append(j3);
            sb.append(", availableCount: ");
            sb.append(OplusGLSurfaceView_13);
            sb.append(", availableResult: ");
            sb.append(c3077a);
            CameraLog.m12954a("SuperTextManager", sb.toString());
            if (OplusGLSurfaceView_13 >= 2 && c3077a != null && c3077a.m17956c() && j3 <= 500) {
                return c3077a;
            }
            m17987d();
            return new DetectResult();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17987d() {
        synchronized (this.f17084e) {
            this.f17088i.clear();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17974a(long OplusGLSurfaceView_15, DetectResult c3077a) {
        synchronized (this.f17084e) {
            this.f17088i.put(Long.valueOf(System.currentTimeMillis()), c3077a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m17973a(int OplusGLSurfaceView_13, int i2, int i3, long OplusGLSurfaceView_15) {
        if (m17986c()) {
            return;
        }
        DetectResult c3077aMo17957a = this.f17083d.mo17957a(OplusGLSurfaceView_13, i2, i3, true);
        if (m17986c() || this.f17081b == null) {
            return;
        }
        if (m17977g()) {
            m17975a(c3077aMo17957a);
            this.f17081b.mo10686a(c3077aMo17957a);
        } else {
            this.f17081b.mo10686a((DetectResult) null);
        }
        m17974a(OplusGLSurfaceView_15, c3077aMo17957a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17982a(byte[] bArr, int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) {
        if (this.f17087h) {
            return;
        }
        Message messageObtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putLong("timestamp", OplusGLSurfaceView_15);
        messageObtain.what = 102;
        messageObtain.obj = bArr;
        messageObtain.arg1 = OplusGLSurfaceView_13;
        messageObtain.arg2 = i2;
        messageObtain.setData(bundle);
        this.f17086g.sendMessage(messageObtain);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17985b(byte[] bArr, int OplusGLSurfaceView_13, int i2, long OplusGLSurfaceView_15) {
        ISuperText interfaceC3078b;
        this.f17087h = true;
        if (!m17986c() && (interfaceC3078b = this.f17083d) != null && this.f17081b != null) {
            DetectResult c3077aMo17958a = interfaceC3078b.mo17958a(bArr, OplusGLSurfaceView_13, i2, m17978a());
            if (!m17986c()) {
                if (m17977g()) {
                    m17975a(c3077aMo17958a);
                    this.f17081b.mo10686a(c3077aMo17958a);
                } else {
                    this.f17081b.mo10686a((DetectResult) null);
                }
                m17974a(OplusGLSurfaceView_15, c3077aMo17958a);
            }
        }
        this.f17087h = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m17983a(int OplusGLSurfaceView_13, int i2, int i3, int i4, long OplusGLSurfaceView_15) {
        ISuperText interfaceC3078b = this.f17083d;
        if (interfaceC3078b == null || !interfaceC3078b.mo17962a(OplusGLSurfaceView_13, i2, i3, i4)) {
            return false;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 101;
        Bundle bundle = new Bundle();
        bundle.putInt("width", i2);
        bundle.putInt("height", i3);
        bundle.putInt("orientation", i4);
        bundle.putLong("timestamp", OplusGLSurfaceView_15);
        messageObtain.setData(bundle);
        this.f17086g.sendMessage(messageObtain);
        CameraLog.m12954a("SuperTextManager", "setOesTextureId, sendMsg");
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m17988e() {
        this.f17083d.mo17965c();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m17989f() {
        HandlerThread handlerThread = this.f17085f;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        Handler handler = this.f17086g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f17086g = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17975a(DetectResult c3077a) {
        if (c3077a == null || this.f17082c == null || !c3077a.m17956c() || !this.f17082c.m17956c()) {
            this.f17082c = c3077a;
            return;
        }
        PointF[] pointFArrM17955b = c3077a.m17955b();
        PointF[] pointFArrM17955b2 = this.f17082c.m17955b();
        boolean[] zArr = new boolean[pointFArrM17955b2.length];
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < zArr.length; i2++) {
            zArr[i2] = false;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= pointFArrM17955b.length) {
                break;
            }
            int i6 = 0;
            while (true) {
                if (i6 >= pointFArrM17955b2.length) {
                    z = false;
                    break;
                } else {
                    if (m17972a(pointFArrM17955b[i3], pointFArrM17955b2[i6]) <= 1.0E-4f) {
                        pointFArrM17955b[i3] = pointFArrM17955b2[i6];
                        i4++;
                        zArr[i6] = true;
                        break;
                    }
                    i6++;
                }
            }
            if (!z) {
                i5 = i3;
            }
            i3++;
        }
        if (i4 == pointFArrM17955b.length - 1) {
            while (true) {
                if (OplusGLSurfaceView_13 >= pointFArrM17955b2.length) {
                    break;
                }
                if (zArr[OplusGLSurfaceView_13]) {
                    OplusGLSurfaceView_13++;
                } else if (m17972a(pointFArrM17955b[i5], pointFArrM17955b2[OplusGLSurfaceView_13]) <= 0.01f) {
                    pointFArrM17955b[i5] = pointFArrM17955b2[OplusGLSurfaceView_13];
                    CameraLog.m12954a("SuperTextManager", "optimisedResult, 3 points are reusable then reuse the fourth one");
                }
            }
        }
        this.f17082c = c3077a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m17972a(PointF pointF, PointF pointF2) {
        float COUIBaseListPopupWindow_12 = ((pointF.x - pointF2.x) * (pointF.x - pointF2.x)) + ((pointF.y - pointF2.y) * (pointF.y - pointF2.y));
        CameraLog.m12954a("SuperTextManager", "calcDiff, result: " + new BigDecimal(COUIBaseListPopupWindow_12) + ", p1: " + pointF + ", p2: " + pointF2);
        return COUIBaseListPopupWindow_12;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m17977g() {
        synchronized (this.f17084e) {
            if (this.f17088i.size() < 5) {
                return true;
            }
            int OplusGLSurfaceView_13 = 0;
            for (DetectResult c3077a : this.f17088i.values()) {
                if (c3077a != null && c3077a.m17956c()) {
                    OplusGLSurfaceView_13++;
                }
            }
            return OplusGLSurfaceView_13 >= 3;
        }
    }
}
