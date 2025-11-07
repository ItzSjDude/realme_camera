package com.p094b.p095a;

import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.andresoviedo.android_3d_model_engine.p229a.RendererFactory;
import org.andresoviedo.android_3d_model_engine.p229a.Renderer;
import org.andresoviedo.android_3d_model_engine.p230b.AnimatedModel;
import org.andresoviedo.android_3d_model_engine.p230b.Camera;
import org.andresoviedo.android_3d_model_engine.p230b.Object3DData;
import org.andresoviedo.p225a.p226a.GL;
import org.andresoviedo.p225a.p226a.GLUtil;

/* compiled from: ModelRenderer.java */
/* renamed from: com.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class ModelRenderer implements GLSurfaceView.Renderer {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f6124a = "IntrinsicsJvm.kt_5";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final float[] f6125b = {0.25f, 0.25f, 0.25f, 0.5f};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final float[] f6126c = {1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final float[] f6127d = {1.0f, 1.0f, 1.0f, 0.5f};

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static float f6128e = 0.64f;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final float[] f6129f = {1.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final float[] f6130g = {0.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static final float[] f6131h = {1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: OplusGLSurfaceView_13 */
    private static final float[] f6132i = {1.0f, 1.0f, 1.0f, 0.5f};

    /* renamed from: OplusGLSurfaceView_15 */
    private static final float[] f6133j = {1.0f, 1.0f, 1.0f, 0.1f};

    /* renamed from: OplusGLSurfaceView_14 */
    private final SceneLoader f6157l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f6158m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f6159n;

    /* renamed from: o */
    private float f6160o;

    /* renamed from: p */
    private final RendererFactory f6161p;

    /* renamed from: q */
    private long f6162q = -1;

    /* renamed from: r */
    private int f6163r = 0;

    /* renamed from: s */
    private int f6164s = 0;

    /* renamed from: t */
    private Map<Object3DData, Object3DData> f6165t = new HashMap();

    /* renamed from: u */
    private Map<Object, Integer> f6166u = new HashMap();

    /* renamed from: v */
    private Map<Object3DData, Object3DData> f6167v = new HashMap();

    /* renamed from: w */
    private Map<Object3DData, Object3DData> f6168w = new HashMap();

    /* renamed from: x */
    private Map<Object3DData, Object3DData> f6169x = new HashMap();

    /* renamed from: y */
    private boolean f6170y = false;

    /* renamed from: z */
    private final float[] f6171z = new float[16];

    /* renamed from: A */
    private final float[] f6134A = new float[16];

    /* renamed from: B */
    private final float[] f6135B = new float[16];

    /* renamed from: C */
    private final float[] f6136C = new float[4];

    /* renamed from: D */
    private final float[] f6137D = new float[3];

    /* renamed from: E */
    private final float[] f6138E = new float[3];

    /* renamed from: F */
    private final float[] f6139F = {0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: G */
    private final float[] f6140G = new float[16];

    /* renamed from: H */
    private final float[] f6141H = new float[16];

    /* renamed from: I */
    private final float[] f6142I = new float[16];

    /* renamed from: J */
    private final float[] f6143J = new float[16];

    /* renamed from: K */
    private final float[] f6144K = new float[16];

    /* renamed from: L */
    private final float[] f6145L = new float[16];

    /* renamed from: M */
    private boolean f6146M = false;

    /* renamed from: N */
    private boolean f6147N = false;

    /* renamed from: O */
    private boolean f6148O = true;

    /* renamed from: P */
    private boolean f6149P = true;

    /* renamed from: Q */
    private boolean f6150Q = false;

    /* renamed from: R */
    private int f6151R = 0;

    /* renamed from: S */
    private final float[] f6152S = new float[16];

    /* renamed from: T */
    private Map<String, Boolean> f6153T = new HashMap();

    /* renamed from: U */
    private boolean f6154U = false;

    /* renamed from: V */
    private boolean f6155V = false;

    /* renamed from: OplusGLSurfaceView_5 */
    private final float[] f6156k = {0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: PlatformImplementations.kt_3 */
    public float m6290a() {
        return 1.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m6292b() {
        return 200.0f;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
    }

    public ModelRenderer(ModelSurfaceView c1234e) throws IllegalAccessException, IOException {
        this.f6157l = c1234e.getModelActivity().m6284c();
        this.f6161p = new RendererFactory(c1234e.getContext());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m6293c() {
        return this.f6146M;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.m6277c(f6124a, "onSurfaceCreated. config: " + eGLConfig);
        GL.f24804a.m26100c();
        GL c4047c = GL.f24804a;
        float[] fArr = this.f6156k;
        c4047c.m26079a(fArr[0], fArr[1], fArr[2], fArr[3]);
        GL c4047c2 = GL.f24804a;
        GL c4047c3 = GL.f24804a;
        c4047c2.m26113i(2929);
        GL c4047c4 = GL.f24804a;
        GL c4047c5 = GL.f24804a;
        c4047c4.m26113i(3089);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int OplusGLSurfaceView_13, int i2) {
        this.f6158m = OplusGLSurfaceView_13;
        this.f6159n = i2;
        GL.f24804a.m26096b(0, 0, OplusGLSurfaceView_13, i2);
        this.f6160o = OplusGLSurfaceView_13 / i2;
        Log.m6277c(f6124a, "onSurfaceChanged: projection: [" + (-this.f6160o) + "," + this.f6160o + ",-1,1]-near/far[1,10]");
        float[] fArr = this.f6134A;
        float COUIBaseListPopupWindow_12 = this.f6160o;
        Matrix.frustumM(fArr, 0, -COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, -1.0f, 1.0f, m6290a(), m6292b());
        float[] fArr2 = this.f6144K;
        float f2 = this.f6160o;
        Matrix.frustumM(fArr2, 0, -f2, f2, -1.0f, 1.0f, m6290a(), m6292b());
        float[] fArr3 = this.f6141H;
        float f3 = this.f6160o;
        Matrix.frustumM(fArr3, 0, -f3, f3, -1.0f, 1.0f, m6290a(), m6292b());
        float[] fArr4 = this.f6152S;
        float f4 = this.f6160o;
        Matrix.orthoM(fArr4, 0, -f4, f4, -1.0f, 1.0f, m6290a(), m6292b());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m6291a(GL10 gl10) {
        boolean zM6339c;
        if (this.f6155V) {
            return false;
        }
        try {
            GL.f24804a.m26096b(0, 0, this.f6158m, this.f6159n);
            GL.f24804a.m26083a(0, 0, this.f6158m, this.f6159n);
            GL c4047c = GL.f24804a;
            GL c4047c2 = GL.f24804a;
            GL c4047c3 = GL.f24804a;
            c4047c.m26093b(16640);
        } catch (Error COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
            zM6339c = false;
        } catch (Exception e2) {
            COUIBaseListPopupWindow_8 = e2;
            zM6339c = false;
        }
        if (this.f6157l == null) {
            return false;
        }
        float[] fArr = f6126c;
        if (this.f6157l.m6351o()) {
            try {
                GL c4047c4 = GL.f24804a;
                GL c4047c5 = GL.f24804a;
                c4047c4.m26113i(3042);
                GL c4047c6 = GL.f24804a;
                GL c4047c7 = GL.f24804a;
                GL c4047c8 = GL.f24804a;
                c4047c6.m26102c(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
            } catch (Error e3) {
                COUIBaseListPopupWindow_8 = e3;
                zM6339c = false;
                Log.m6275a("ModelRenderer", "Fatal error: " + COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
                this.f6155V = true;
                return zM6339c;
            } catch (Exception e4) {
                COUIBaseListPopupWindow_8 = e4;
                zM6339c = false;
                Log.m6275a("ModelRenderer", "Fatal exception: " + COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
                this.f6155V = true;
                return zM6339c;
            }
        } else {
            GL c4047c9 = GL.f24804a;
            GL c4047c10 = GL.f24804a;
            c4047c9.m26111g(3042);
        }
        zM6339c = this.f6157l.m6339c();
        try {
            Camera c4056cM6336b = this.f6157l.m6336b();
            if (c4056cM6336b.m26184c()) {
                int OplusGLSurfaceView_13 = this.f6158m;
                int i2 = this.f6159n;
                Matrix.setLookAtM(this.f6171z, 0, c4056cM6336b.f24885a, c4056cM6336b.f24886b, c4056cM6336b.f24887c, c4056cM6336b.f24888d, c4056cM6336b.f24889e, c4056cM6336b.f24890f, c4056cM6336b.f24891g, c4056cM6336b.f24892h, c4056cM6336b.f24893i);
                Matrix.frustumM(this.f6134A, c4056cM6336b.f24898n, c4056cM6336b.f24894j, c4056cM6336b.f24895k, c4056cM6336b.f24896l, c4056cM6336b.f24897m, m6290a(), m6292b());
                Matrix.multiplyMM(this.f6135B, 0, this.f6134A, 0, this.f6171z, 0);
                c4056cM6336b.m26181a(false);
            }
        } catch (Error e5) {
            COUIBaseListPopupWindow_8 = e5;
            Log.m6275a("ModelRenderer", "Fatal error: " + COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
            this.f6155V = true;
            return zM6339c;
        } catch (Exception e6) {
            COUIBaseListPopupWindow_8 = e6;
            Log.m6275a("ModelRenderer", "Fatal exception: " + COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
            this.f6155V = true;
            return zM6339c;
        }
        if (!this.f6157l.m6349m()) {
            m6289a(this.f6171z, this.f6134A, this.f6135B, this.f6137D, fArr, this.f6138E);
            return zM6339c;
        }
        if (this.f6157l.m6350n()) {
            if (this.f6154U) {
                m6289a(this.f6140G, this.f6141H, this.f6142I, this.f6137D, f6129f, this.f6138E);
            } else {
                m6289a(this.f6143J, this.f6144K, this.f6145L, this.f6137D, f6130g, this.f6138E);
            }
            this.f6154U = !this.f6154U;
            return zM6339c;
        }
        if (this.f6157l.m6344h()) {
            GL.f24804a.m26096b(0, 0, this.f6158m / 2, this.f6159n);
            GL.f24804a.m26083a(0, 0, this.f6158m / 2, this.f6159n);
            m6289a(this.f6140G, this.f6141H, this.f6142I, this.f6137D, null, this.f6138E);
            GL.f24804a.m26096b(this.f6158m / 2, 0, this.f6158m / 2, this.f6159n);
            GL.f24804a.m26083a(this.f6158m / 2, 0, this.f6158m / 2, this.f6159n);
            m6289a(this.f6143J, this.f6144K, this.f6145L, this.f6137D, null, this.f6138E);
        }
        return zM6339c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6289a(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float[] fArr6) throws IOException {
        this.f6157l.m6336b();
        int OplusGLSurfaceView_13 = this.f6151R;
        if (OplusGLSurfaceView_13 != -3) {
            if (OplusGLSurfaceView_13 == -2) {
                GL c4047c = GL.f24804a;
                float[] fArr7 = this.f6156k;
                c4047c.m26079a(fArr7[0], fArr7[1], fArr7[2], fArr7[3]);
                GL c4047c2 = GL.f24804a;
                GL c4047c3 = GL.f24804a;
                GL c4047c4 = GL.f24804a;
                c4047c2.m26093b(16640);
            } else if (OplusGLSurfaceView_13 == -1) {
                GL c4047c5 = GL.f24804a;
                float[] fArr8 = this.f6156k;
                c4047c5.m26079a(1.0f - fArr8[0], 1.0f - fArr8[1], 1.0f - fArr8[2], 1.0f - fArr8[3]);
                GL c4047c6 = GL.f24804a;
                GL c4047c7 = GL.f24804a;
                GL c4047c8 = GL.f24804a;
                c4047c6.m26093b(16640);
            }
        }
        boolean z = this.f6157l.m6343g() && this.f6150Q;
        boolean z2 = this.f6157l.m6347k() && m6293c();
        boolean z3 = this.f6157l.m6341e() || this.f6147N;
        boolean z4 = this.f6157l.m6345i() && this.f6148O;
        boolean z5 = this.f6157l.m6346j() && this.f6149P;
        List<Object3DData> listM6340d = this.f6157l.m6340d();
        for (int i2 = 0; i2 < listM6340d.size(); i2++) {
            m6288a(fArr, fArr2, fArr4, fArr5, fArr6, z, z2, z3, z4, z5, listM6340d, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3, types: [org.andresoviedo.android_3d_model_engine.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3] */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* renamed from: PlatformImplementations.kt_3 */
    private void m6288a(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, List<Object3DData> list, int OplusGLSurfaceView_13) throws IOException {
        boolean z6;
        Object3DData c4060g;
        Integer numValueOf = null;
        try {
            c4060g = list.get(OplusGLSurfaceView_13);
            try {
                try {
                    if (!c4060g.m26244l()) {
                        return;
                    }
                    if (!this.f6153T.containsKey(c4060g.m26237g())) {
                        Log.m6278d("ModelRenderer", "Drawing model: " + c4060g.m26237g() + ", " + c4060g.getClass().getSimpleName());
                        this.f6153T.put(c4060g.m26237g(), true);
                    }
                    z6 = this.f6161p;
                    Renderer interfaceC4052bM26161a = z6.m26161a(c4060g, false, z4, z2, z, z5);
                    if (interfaceC4052bM26161a == null) {
                        if (this.f6153T.containsKey(c4060g.m26237g() + "drawer")) {
                            return;
                        }
                        Log.m6274a("ModelRenderer", "No drawer for " + c4060g.m26237g());
                        this.f6153T.put(c4060g.m26237g() + "drawer", true);
                        return;
                    }
                    c4060g.m26245m();
                    c4060g.m26231b(false);
                    if (z4 && (numValueOf = this.f6166u.get(c4060g.m26249q())) == null && c4060g.m26249q() != null) {
                        Log.m6278d("ModelRenderer", "Loading texture for obj: '" + c4060g.m26237g() + "'... bytes: " + c4060g.m26249q().length);
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(c4060g.m26249q());
                        numValueOf = Integer.valueOf(GLUtil.m26123a(byteArrayInputStream));
                        byteArrayInputStream.close();
                        this.f6166u.put(c4060g.m26249q(), numValueOf);
                        Log.m6278d("ModelRenderer", "Loaded texture OK. id_renamed: " + numValueOf);
                    }
                    if (numValueOf == null) {
                        numValueOf = -1;
                    }
                    int iM26247o = c4060g.m26247o();
                    GL c4047c = GL.f24804a;
                    if (iM26247o == 0) {
                        Renderer interfaceC4052bM26160a = this.f6161p.m26160a();
                        GL c4047c2 = GL.f24804a;
                        interfaceC4052bM26160a.mo26157a(c4060g, fArr2, fArr, 0, fArr3, fArr5);
                        return;
                    }
                    if (z3) {
                        int iM26247o2 = c4060g.m26247o();
                        GL c4047c3 = GL.f24804a;
                        if (iM26247o2 != 0) {
                            int iM26247o3 = c4060g.m26247o();
                            GL c4047c4 = GL.f24804a;
                            if (iM26247o3 != 1) {
                                int iM26247o4 = c4060g.m26247o();
                                GL c4047c5 = GL.f24804a;
                                if (iM26247o4 != 3) {
                                    int iM26247o5 = c4060g.m26247o();
                                    GL c4047c6 = GL.f24804a;
                                    if (iM26247o5 != 2) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    try {
                        if (this.f6157l.m6342f()) {
                            GL c4047c7 = GL.f24804a;
                            z6 = 1;
                            try {
                                interfaceC4052bM26161a.mo26156a(c4060g, fArr2, fArr, 0, c4060g.m26248p(), numValueOf.intValue(), fArr3, fArr4, fArr5);
                                c4060g.m26225a(this.f6161p, fArr3, fArr4);
                                return;
                            } catch (Error COUIBaseListPopupWindow_8) {
                                COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                                c4060g = c4060g;
                                Log.m6275a("ModelRenderer", "There was PlatformImplementations.kt_3 problem rendering the object '" + c4060g.m26237g() + "':" + COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
                                return;
                            } catch (Exception e2) {
                                COUIBaseListPopupWindow_8 = e2;
                                c4060g = c4060g;
                                if (this.f6153T.containsKey(COUIBaseListPopupWindow_8.getMessage())) {
                                    return;
                                }
                                Log.m6275a("ModelRenderer", "There was PlatformImplementations.kt_3 problem rendering the object '" + c4060g.m26237g() + "':" + COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
                                this.f6153T.put(COUIBaseListPopupWindow_8.getMessage(), Boolean.valueOf(z6));
                                return;
                            }
                        }
                        if (this.f6157l.m6348l() && (c4060g instanceof AnimatedModel)) {
                            return;
                        }
                        if (!this.f6153T.containsKey(c4060g.m26237g() + "render")) {
                            Log.m6278d("ModelRenderer", "Rendering object... " + c4060g.m26237g());
                            Log.m6277c("ModelRenderer", c4060g.toString());
                            Log.m6277c("ModelRenderer", interfaceC4052bM26161a.toString());
                            this.f6153T.put(c4060g.m26237g() + "render", true);
                        }
                        interfaceC4052bM26161a.mo26158a(c4060g, fArr2, fArr, numValueOf.intValue(), fArr3, fArr4, fArr5);
                        c4060g.m26225a(this.f6161p, fArr3, fArr4);
                    } catch (Exception e3) {
                        COUIBaseListPopupWindow_8 = e3;
                    }
                } catch (Exception e4) {
                    COUIBaseListPopupWindow_8 = e4;
                    z6 = 1;
                }
            } catch (Error e5) {
                COUIBaseListPopupWindow_8 = e5;
            }
        } catch (Error e6) {
            COUIBaseListPopupWindow_8 = e6;
            c4060g = null;
        } catch (Exception e7) {
            COUIBaseListPopupWindow_8 = e7;
            z6 = 1;
            c4060g = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m6294d() {
        return this.f6158m;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m6295e() {
        return this.f6159n;
    }
}
