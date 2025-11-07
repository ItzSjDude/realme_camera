package com.oplus.camera.timelapsepro.p170a;

import android.app.Activity;
import android.content.res.Resources;
import com.oplus.camera.CameraLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProParameter.java */
/* renamed from: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public abstract class ProParameter {

    /* renamed from: PlatformImplementations.kt_3 */
    protected final Resources f16711a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected final int f16712b;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f16716f;

    /* renamed from: OplusGLSurfaceView_14 */
    private IntrinsicsJvm.kt_4 f16722l;

    /* renamed from: OplusGLSurfaceView_6 */
    private PlatformImplementations.kt_3 f16723m;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private long f16717g = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f16715e = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16718h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f16719i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f16720j = true;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f16721k = true;

    /* renamed from: OplusGLSurfaceView_11 */
    private long f16724n = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected List<String> f16713c = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected List<String> f16714d = new ArrayList();

    /* compiled from: ProParameter.java */
    /* renamed from: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17393a();
    }

    /* compiled from: ProParameter.java */
    /* renamed from: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        void onValueChange(int OplusGLSurfaceView_13, int i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17436a(String str) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo17437a() {
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract int mo17439c();

    /* renamed from: IntrinsicsJvm.kt_5 */
    public abstract String mo17440d();

    /* renamed from: COUIBaseListPopupWindow_8 */
    public abstract String mo17441e();

    /* renamed from: OplusGLSurfaceView_14 */
    public int mo17456l() {
        return -1;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean mo17457m() {
        return false;
    }

    public ProParameter(Activity activity, String str, int OplusGLSurfaceView_13) {
        this.f16716f = str;
        this.f16712b = OplusGLSurfaceView_13;
        this.f16711a = activity.getResources();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public String m17450f() {
        return this.f16716f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17446a(boolean z) {
        this.f16720j = z;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m17451g() {
        return this.f16720j;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m17452h() {
        return this.f16721k;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17447b(boolean z) {
        this.f16721k = z;
        m17449d(false);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m17453i() {
        return this.f16719i;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17448c(boolean z) {
        this.f16719i = z;
        m17449d(false);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public List<String> m17454j() {
        return this.f16713c;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public List<String> m17455k() {
        return this.f16714d;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public int m17458n() {
        return this.f16715e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17435a(int OplusGLSurfaceView_13) {
        if (!m17451g() || !m17453i() || this.f16722l == null || 100 >= System.currentTimeMillis() - this.f16717g || this.f16718h == OplusGLSurfaceView_13) {
            return;
        }
        this.f16717g = System.currentTimeMillis();
        this.f16718h = OplusGLSurfaceView_13;
        this.f16722l.onValueChange(this.f16712b, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo17438b() {
        m17446a(true);
    }

    /* renamed from: o */
    public List<? extends ScaleDataWrapper> m17459o() {
        List<String> list = this.f16714d;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (final String str : this.f16714d) {
            arrayList.add(new ScaleDataWrapper() { // from class: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.1
                @Override // com.oplus.camera.timelapsepro.p170a.ScaleDataWrapper
                /* renamed from: f_ */
                public String mo17462f_() {
                    if (ProParameter.this.m17443b(str)) {
                        return str.substring(0, r2.length() - 1);
                    }
                    return str;
                }

                @Override // com.oplus.camera.timelapsepro.p170a.ScaleDataWrapper
                /* renamed from: g_ */
                public String mo17463g_() {
                    if (ProParameter.this.m17443b(str)) {
                        return str.substring(r2.length() - 1);
                    }
                    return super.mo17463g_();
                }

                @Override // com.oplus.camera.timelapsepro.p170a.ScaleDataWrapper
                /* renamed from: IntrinsicsJvm.kt_3 */
                public String mo17461c() {
                    return str;
                }
            });
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m17443b(String str) {
        return !Character.isDigit(str.charAt(str.length() - 1));
    }

    /* renamed from: p */
    protected void m17460p() {
        m17449d(true);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17449d(boolean z) {
        if (this.f16723m != null) {
            if (z) {
                if (100 > System.currentTimeMillis() - this.f16724n) {
                    return;
                } else {
                    this.f16724n = System.currentTimeMillis();
                }
            }
            this.f16723m.mo17393a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17445a(IntrinsicsJvm.kt_4 bVar) {
        CameraLog.m12954a("ProParameter", "setValueChangedCallback, " + getClass().getSimpleName() + " callback: " + bVar);
        this.f16722l = bVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17444a(PlatformImplementations.kt_3 aVar) {
        CameraLog.m12954a("ProParameter", "setOnUpdateCallback, " + getClass().getSimpleName() + " onUpdateCallback: " + aVar);
        this.f16723m = aVar;
    }

    public String toString() {
        return "ProParameter{mPreKey='" + this.f16716f + "', mValueList=" + this.f16713c + ", mNameList=" + this.f16714d + ", mCurrentPosition=" + this.f16715e + ", mLastPosition=" + this.f16718h + ", mbSelect=" + this.f16719i + ", mbAuto=" + this.f16720j + '}';
    }
}
