package com.p094b.p095a;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.p094b.p095a.p096a.AnimConfig;
import com.p094b.p095a.p096a.AnimationManager;
import com.p094b.p095a.p096a.CircleAnimator;
import com.p094b.p095a.p096a.DollyZoomAnimator;
import com.p094b.p095a.p096a.FixedGazeAnimator;
import com.p094b.p095a.p096a.SwingAnimator;
import com.p094b.p095a.p096a.AnimID;
import com.p094b.p095a.p096a.IAnimator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.andresoviedo.android_3d_model_engine.p230b.Camera;
import org.andresoviedo.android_3d_model_engine.p230b.Object3DData;
import org.andresoviedo.android_3d_model_engine.p231c.O3DModelLoaderTask;
import org.andresoviedo.android_3d_model_engine.p231c.LoadListener;
import org.andresoviedo.p225a.p226a.ContentUtils;

/* compiled from: SceneLoader.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class SceneLoader implements LoadListener {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static float[] f6209c = {1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: PlatformImplementations.kt_3 */
    protected final ModelActivity f6212a;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Camera f6216f;

    /* renamed from: y */
    private long f6235y;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private List<Object3DData> f6214d = new ArrayList();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f6215e = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f6217g = true;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f6218h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f6219i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f6220j = false;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f6221k = false;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f6222l = true;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f6223m = true;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f6224n = false;

    /* renamed from: o */
    private boolean f6225o = false;

    /* renamed from: p */
    private boolean f6226p = false;

    /* renamed from: q */
    private boolean f6227q = false;

    /* renamed from: r */
    private boolean f6228r = false;

    /* renamed from: s */
    private boolean f6229s = false;

    /* renamed from: t */
    private boolean f6230t = false;

    /* renamed from: u */
    private boolean f6231u = false;

    /* renamed from: v */
    private boolean f6232v = false;

    /* renamed from: w */
    private Object3DData f6233w = null;

    /* renamed from: x */
    private final float[] f6234x = {0.0f, 0.0f, 6.0f, 1.0f};

    /* renamed from: z */
    private float f6236z = -0.0094f;

    /* renamed from: A */
    private float f6210A = -6.8E-4f;

    /* renamed from: B */
    private float f6211B = -0.07f;

    /* renamed from: IntrinsicsJvm.kt_4 */
    Set<AnimationManager> f6213b = new HashSet();

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6324a(String str) {
    }

    /* renamed from: r */
    private void m6327r() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6331a(float COUIBaseListPopupWindow_12, float f2) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6337b(float COUIBaseListPopupWindow_12, float f2) {
    }

    public SceneLoader(ModelActivity c1232c) {
        this.f6212a = c1232c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6330a() {
        this.f6216f = new Camera(-0.0f, 0.0f, -5.0f, -0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.42f, 0.42f, 0.42f, -0.42f);
        this.f6216f.m26181a(true);
        this.f6235y = SystemClock.uptimeMillis();
        if (ModelActivity.f6104b != null) {
            new O3DModelLoaderTask(this.f6212a.f6108c, m6325a(ModelActivity.f6104b), this).execute(new Void[0]);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Camera m6336b() {
        return this.f6216f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6332a(AnimationManager c1224e) {
        this.f6213b.add(c1224e);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6338b(AnimationManager c1224e) {
        this.f6213b.remove(c1224e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public IAnimator m6328a(AnimID enumC1223d, boolean z) {
        return m6329a(enumC1223d, z, null);
    }

    /* compiled from: SceneLoader.java */
    /* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.OplusGLSurfaceView_15$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f6237a = new int[AnimID.values().length];

        static {
            try {
                f6237a[AnimID.DollyZoom.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6237a[AnimID.FixedGaze.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6237a[AnimID.Circle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6237a[AnimID.Swing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6237a[AnimID.None.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public IAnimator m6329a(AnimID enumC1223d, boolean z, AnimConfig c1220a) {
        if (enumC1223d == null) {
            return null;
        }
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f6237a[enumC1223d.ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            this.f6216f = new Camera(-0.0f, 0.0f, -5.0f, -0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.42f, 0.42f, 0.42f, -0.42f);
            if (c1220a == null) {
                return new DollyZoomAnimator(this.f6216f, z);
            }
            return new DollyZoomAnimator(this.f6216f, z, c1220a);
        }
        if (OplusGLSurfaceView_13 == 2) {
            if (z) {
                this.f6216f = new Camera(2.0f, -0.5f, -5.0f, -0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.26f, 0.26f, 0.26f, -0.26f);
            } else {
                this.f6216f = new Camera(0.5f, 2.0f, -5.0f, 0.0f, -0.0f, 3.0f, 0.0f, 1.0f, 0.0f, -0.26f, 0.26f, 0.26f, -0.26f);
            }
            if (c1220a == null) {
                return new FixedGazeAnimator(this.f6216f, z);
            }
            return new FixedGazeAnimator(this.f6216f, z, c1220a);
        }
        if (OplusGLSurfaceView_13 == 3) {
            this.f6216f = new Camera(-0.0f, 0.0f, -7.0f, -0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.26f, 0.26f, 0.26f, -0.26f);
            if (c1220a == null) {
                return new CircleAnimator(this.f6216f, z);
            }
            return new CircleAnimator(this.f6216f, z, c1220a);
        }
        if (OplusGLSurfaceView_13 == 4) {
            this.f6216f = new Camera(-0.0f, 0.0f, -7.0f, -0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.3f, 0.3f, 0.3f, -0.3f);
            if (c1220a == null) {
                return new SwingAnimator(this.f6216f, z);
            }
            return new SwingAnimator(this.f6216f, z, c1220a);
        }
        throw new RuntimeException("Invalid AnimID:" + enumC1223d);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m6339c() {
        m6326q();
        this.f6216f.m26183b();
        if (!this.f6214d.isEmpty()) {
            Iterator<AnimationManager> it = this.f6213b.iterator();
            while (it.hasNext()) {
                if (it.next().m6264b()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: q */
    private void m6326q() {
        if (this.f6224n) {
            long jUptimeMillis = SystemClock.uptimeMillis() % DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    synchronized void m6335a(Object3DData c4060g) {
        ArrayList arrayList = new ArrayList(this.f6214d);
        arrayList.add(c4060g);
        this.f6214d = arrayList;
        m6327r();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public synchronized List<Object3DData> m6340d() {
        return this.f6214d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m6341e() {
        return this.f6218h;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m6342f() {
        return this.f6219i;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m6343g() {
        return this.f6226p;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m6344h() {
        return this.f6232v;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m6345i() {
        return this.f6222l;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m6346j() {
        return this.f6223m;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m6347k() {
        return this.f6225o;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m6348l() {
        return this.f6228r;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m6349m() {
        return this.f6230t;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m6350n() {
        return this.f6231u;
    }

    /* renamed from: o */
    public boolean m6351o() {
        return this.f6217g;
    }

    @Override // org.andresoviedo.android_3d_model_engine.p231c.LoadListener
    /* renamed from: p */
    public void mo6352p() {
        ContentUtils.m26074a(this.f6212a.f6108c);
    }

    @Override // org.andresoviedo.android_3d_model_engine.p231c.LoadListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6334a(List<Object3DData> list) {
        Iterator<Object3DData> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().m26249q() == null) {
                Log.m6274a("LoaderTask", "no texture loaded... ");
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object3DData c4060g : list) {
            m6335a(c4060g);
            arrayList.addAll(c4060g.m26215M());
        }
        if (!arrayList.isEmpty()) {
            m6324a(arrayList.toString());
        }
        m6324a("Build complete (" + ((SystemClock.uptimeMillis() - this.f6235y) + " ms") + ")");
        ContentUtils.m26074a((Context) null);
        if (this.f6212a.m6285d() != null) {
            this.f6212a.m6285d().m6311c();
        }
    }

    @Override // org.andresoviedo.android_3d_model_engine.p231c.LoadListener
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo6333a(Exception exc) {
        Log.m6275a("SceneLoader", exc.getMessage(), exc);
        m6324a("There was PlatformImplementations.kt_3 problem building the model: " + exc.getMessage());
        ContentUtils.m26074a((Context) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private O3DPHOTO_MODEL[] m6325a(O3DPHOTO_MODEL c1236g) {
        Log.m6278d("SceneLoader", "faces of input model:" + c1236g.f6192c.length);
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < c1236g.f6192c.length; i3 += 3) {
            int i4 = c1236g.f6192c[i3];
            int i5 = c1236g.f6192c[i3 + 1];
            int i6 = c1236g.f6192c[i3 + 2];
            if ((c1236g.f6191b[(i4 * 4) + 3] & 255) == 255 && (c1236g.f6191b[(i5 * 4) + 3] & 255) == 255 && (c1236g.f6191b[(i6 * 4) + 3] & 255) == 255) {
                i2++;
            } else {
                OplusGLSurfaceView_13++;
            }
        }
        if (OplusGLSurfaceView_13 == 0 || i2 == 0) {
            Log.m6278d("SceneLoader", "only one modelfaces of front model:" + OplusGLSurfaceView_13 + "faces of back model:" + i2);
            return new O3DPHOTO_MODEL[]{c1236g};
        }
        O3DPHOTO_MODEL c1236g2 = new O3DPHOTO_MODEL(c1236g);
        O3DPHOTO_MODEL c1236g3 = new O3DPHOTO_MODEL(c1236g);
        byte[] bArr = c1236g.f6197h;
        c1236g2.f6197h = bArr;
        c1236g3.f6197h = bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("faces of front model:");
        int i7 = OplusGLSurfaceView_13 * 3;
        sb.append(i7);
        sb.append("faces of back model:");
        int i8 = i2 * 3;
        sb.append(i8);
        Log.m6278d("SceneLoader", sb.toString());
        c1236g3.f6192c = new int[i7];
        c1236g2.f6192c = new int[i8];
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < c1236g.f6192c.length; i11 += 3) {
            int i12 = c1236g.f6192c[i11];
            int i13 = c1236g.f6192c[i11 + 1];
            int i14 = c1236g.f6192c[i11 + 2];
            if ((c1236g.f6191b[(i12 * 4) + 3] & 255) == 255 && (c1236g.f6191b[(i13 * 4) + 3] & 255) == 255 && (c1236g.f6191b[(i14 * 4) + 3] & 255) == 255) {
                int i15 = i10 + 1;
                c1236g2.f6192c[i10] = i12;
                int i16 = i15 + 1;
                c1236g2.f6192c[i15] = i13;
                c1236g2.f6192c[i16] = i14;
                i10 = i16 + 1;
            } else {
                int i17 = i9 + 1;
                c1236g3.f6192c[i9] = i12;
                int i18 = i17 + 1;
                c1236g3.f6192c[i17] = i13;
                c1236g3.f6192c[i18] = i14;
                i9 = i18 + 1;
            }
        }
        return new O3DPHOTO_MODEL[]{c1236g2, c1236g3};
    }
}
