package com.oplus.camera.p146gl;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.OpenGLUtils;
import com.oplus.camera.util.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: GLES20Canvas.java */
/* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class GLES20Canvas implements GLCanvas {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f13987a = "OplusGLSurfaceView_13";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final float[] f13988b = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final float[] f13989c = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: OplusGLSurfaceView_13 */
    private static final GLId f13990i = new GLES20IdImpl();

    /* renamed from: G */
    private int f13997G;

    /* renamed from: H */
    private int f13998H;

    /* renamed from: J */
    private int f14000J;

    /* renamed from: K */
    private int f14001K;

    /* renamed from: L */
    private int f14002L;

    /* renamed from: M */
    private int f14003M;

    /* renamed from: N */
    private int f14004N;

    /* renamed from: O */
    private int f14005O;

    /* renamed from: P */
    private int f14006P;

    /* renamed from: Q */
    private int f14007Q;

    /* renamed from: R */
    private int f14008R;

    /* renamed from: t */
    private BitmapTexture f14030t;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f14015d = 3;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f14016e = 4;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int f14017f = 5;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final int f14018g = 6;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final int f14019h = 7;

    /* renamed from: OplusGLSurfaceView_15 */
    private final float[] f14020j = new float[4];

    /* renamed from: OplusGLSurfaceView_5 */
    private final IntArray f14021k = new IntArray();

    /* renamed from: OplusGLSurfaceView_14 */
    private final IntArray f14022l = new IntArray();

    /* renamed from: OplusGLSurfaceView_6 */
    private final float[] f14023m = new float[32];

    /* renamed from: OplusGLSurfaceView_11 */
    private final float[] f14024n = new float[4];

    /* renamed from: o */
    private final RectF f14025o = new RectF();

    /* renamed from: p */
    private final RectF f14026p = new RectF();

    /* renamed from: q */
    private final Rect f14027q = new Rect();

    /* renamed from: r */
    private final float[] f14028r = new float[16];

    /* renamed from: s */
    private final int[] f14029s = new int[1];

    /* renamed from: u */
    private boolean f14031u = false;

    /* renamed from: v */
    private IntrinsicsJvm.kt_4[] f14032v = {new PlatformImplementations.kt_3("aPosition"), new IntrinsicsJvm.kt_3("uMatrix"), new IntrinsicsJvm.kt_3("uColor")};

    /* renamed from: w */
    private IntrinsicsJvm.kt_4[] f14033w = {new PlatformImplementations.kt_3("aPosition"), new IntrinsicsJvm.kt_3("uMatrix"), new IntrinsicsJvm.kt_3("uTextureMatrix"), new IntrinsicsJvm.kt_3("uTextureSampler"), new IntrinsicsJvm.kt_3("uAlpha")};

    /* renamed from: x */
    private IntrinsicsJvm.kt_4[] f14034x = {new PlatformImplementations.kt_3("aPosition"), new IntrinsicsJvm.kt_3("uMatrix"), new IntrinsicsJvm.kt_3("uTextureMatrix"), new IntrinsicsJvm.kt_3("uTextureSampler"), new IntrinsicsJvm.kt_3("uAlpha")};

    /* renamed from: y */
    private IntrinsicsJvm.kt_4[] f14035y = {new PlatformImplementations.kt_3("aPosition"), new IntrinsicsJvm.kt_3("uMatrix"), new IntrinsicsJvm.kt_3("uTextureMatrix"), new IntrinsicsJvm.kt_3("uTextureSampler"), new IntrinsicsJvm.kt_3("uAlpha"), new IntrinsicsJvm.kt_3("uTexLut")};

    /* renamed from: z */
    private IntrinsicsJvm.kt_4[] f14036z = {new PlatformImplementations.kt_3("aPosition"), new IntrinsicsJvm.kt_3("uMatrix"), new PlatformImplementations.kt_3("aTextureCoordinate"), new IntrinsicsJvm.kt_3("uTextureSampler"), new IntrinsicsJvm.kt_3("uAlpha")};

    /* renamed from: A */
    private IntrinsicsJvm.kt_4[] f13991A = {new PlatformImplementations.kt_3("aPosition"), new IntrinsicsJvm.kt_3("uMatrix"), new IntrinsicsJvm.kt_3("uTextureMatrix"), new IntrinsicsJvm.kt_3("uAlpha"), new IntrinsicsJvm.kt_3("uBlendingAlpha1"), new IntrinsicsJvm.kt_3("uBlendingAlpha2"), new IntrinsicsJvm.kt_3("uBlendingTexture1"), new IntrinsicsJvm.kt_3("uBlendingTexture2")};

    /* renamed from: B */
    private float[] f13992B = new float[128];

    /* renamed from: C */
    private float[] f13993C = new float[8];

    /* renamed from: D */
    private IntArray f13994D = new IntArray();

    /* renamed from: E */
    private int f13995E = 0;

    /* renamed from: F */
    private int f13996F = 0;

    /* renamed from: I */
    private float[] f13999I = new float[16];

    /* renamed from: S */
    private int f14009S = 0;

    /* renamed from: T */
    private int f14010T = 0;

    /* renamed from: U */
    private int f14011U = 0;

    /* renamed from: V */
    private int f14012V = 0;

    /* renamed from: W */
    private int[] f14013W = new int[1];

    /* renamed from: X */
    private ArrayList<RawTexture> f14014X = new ArrayList<>();

    public GLES20Canvas() {
        this.f14030t = null;
        Matrix.setIdentityM(this.f14028r, 0);
        Matrix.setIdentityM(this.f13992B, this.f13996F);
        this.f13993C[this.f13995E] = 1.0f;
        this.f14014X.add(null);
        this.f14008R = m14014a(m14005b(f13988b));
        int iM13989a = m13989a(35633, OpenGLUtils.m24590a(Util.m24472l(), R.raw.draw_vertex_shader));
        int iM13989a2 = m13989a(35633, OpenGLUtils.m24590a(Util.m24472l(), R.raw.texture_vertex_shader));
        int iM13989a3 = m13989a(35633, OpenGLUtils.m24590a(Util.m24472l(), R.raw.mesh_vertex_shader));
        int iM13989a4 = m13989a(35632, OpenGLUtils.m24590a(Util.m24472l(), R.raw.draw_fragment_shader));
        int iM13989a5 = m13989a(35632, OpenGLUtils.m24590a(Util.m24472l(), R.raw.texture_fragment_shader));
        int iM13989a6 = m13989a(35632, OpenGLUtils.m24590a(Util.m24472l(), R.raw.oes_texture_fragment_shader));
        int iM13989a7 = m13989a(35632, OpenGLUtils.m24590a(Util.m24472l(), R.raw.oes_lut_texture_fragment_shader));
        int iM13989a8 = m13989a(35632, OpenGLUtils.m24590a(Util.m24472l(), R.raw.texture_blending_fragment_shader));
        this.f14002L = m13988a(iM13989a, iM13989a4, this.f14032v);
        this.f14003M = m13988a(iM13989a2, iM13989a5, this.f14033w);
        this.f14004N = m13988a(iM13989a2, iM13989a6, this.f14034x);
        this.f14005O = m13988a(iM13989a2, iM13989a7, this.f14035y);
        this.f14006P = m13988a(iM13989a3, iM13989a5, this.f14036z);
        this.f14007Q = m13988a(iM13989a2, iM13989a8, this.f13991A);
        GLES20.glBlendFunc(1, 771);
        m14010i();
        if (this.f14030t == null) {
            this.f14030t = OpenGLUtils.m24597b(Util.m24472l(), R.raw.hlg_to_srgb_v8_1);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static FloatBuffer m14005b(float[] fArr) {
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return floatBufferAsFloatBuffer;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m13989a(int OplusGLSurfaceView_13, String str) {
        int iGlCreateShader = GLES20.glCreateShader(OplusGLSurfaceView_13);
        m14010i();
        GLES20.glShaderSource(iGlCreateShader, str);
        m14010i();
        GLES20.glCompileShader(iGlCreateShader);
        m14010i();
        return iGlCreateShader;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m13997a(BasicTexture abstractC2752c, RectF rectF) {
        int iMo13935f = abstractC2752c.mo13935f();
        int iMo13936g = abstractC2752c.mo13936g();
        int OplusGLSurfaceView_13 = 1;
        int i2 = 0;
        if (abstractC2752c.m13941l()) {
            iMo13935f--;
            iMo13936g--;
            i2 = 1;
        } else {
            OplusGLSurfaceView_13 = 0;
        }
        rectF.set(OplusGLSurfaceView_13, i2, iMo13935f, iMo13936g);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m13995a(RectF rectF, RectF rectF2, BasicTexture abstractC2752c) {
        int iMo13935f = abstractC2752c.mo13935f();
        int iMo13936g = abstractC2752c.mo13936g();
        int iM13937h = abstractC2752c.m13937h();
        int iM13938i = abstractC2752c.m13938i();
        float COUIBaseListPopupWindow_12 = iM13937h;
        rectF.left /= COUIBaseListPopupWindow_12;
        rectF.right /= COUIBaseListPopupWindow_12;
        float f2 = iM13938i;
        rectF.top /= f2;
        rectF.bottom /= f2;
        float f3 = iMo13935f / COUIBaseListPopupWindow_12;
        if (rectF.right > f3) {
            rectF2.right = rectF2.left + ((rectF2.width() * (f3 - rectF.left)) / rectF.width());
            rectF.right = f3;
        }
        float f4 = iMo13936g / f2;
        if (rectF.bottom > f4) {
            rectF2.bottom = rectF2.top + ((rectF2.height() * (f4 - rectF.top)) / rectF.height());
            rectF.bottom = f4;
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private static void m14011j() {
        String str;
        int iGlCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (iGlCheckFramebufferStatus != 36053) {
            switch (iGlCheckFramebufferStatus) {
                case 36054:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT";
                    break;
                case 36055:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT";
                    break;
                case 36057:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS";
                    break;
                case 36061:
                    str = "GL_FRAMEBUFFER_UNSUPPORTED";
                    break;
                default:
                    str = "";
                    break;
            }
            throw new RuntimeException(str + ":" + Integer.toHexString(iGlCheckFramebufferStatus));
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public static void m14010i() {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            Throwable th = new Throwable();
            CameraLog.m12965d(f13987a, "GL error: " + iGlGetError, th);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m13988a(int OplusGLSurfaceView_13, int i2, IntrinsicsJvm.kt_4[] bVarArr) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        m14010i();
        if (iGlCreateProgram == 0) {
            throw new RuntimeException("Cannot create GL program: " + GLES20.glGetError());
        }
        GLES20.glAttachShader(iGlCreateProgram, OplusGLSurfaceView_13);
        m14010i();
        GLES20.glAttachShader(iGlCreateProgram, i2);
        m14010i();
        GLES20.glLinkProgram(iGlCreateProgram);
        m14010i();
        int[] iArr = this.f14029s;
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        m14010i();
        if (iArr[0] != 1) {
            CameraLog.m12967f(f13987a, "Could not link program: " + GLES20.glGetProgramInfoLog(iGlCreateProgram));
            m14010i();
            GLES20.glDeleteProgram(iGlCreateProgram);
            m14010i();
            iGlCreateProgram = 0;
        }
        for (IntrinsicsJvm.kt_4 bVar : bVarArr) {
            bVar.mo14015a(iGlCreateProgram);
        }
        return iGlCreateProgram;
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13966a(int OplusGLSurfaceView_13, int i2) {
        this.f13997G = OplusGLSurfaceView_13;
        this.f13998H = i2;
        GLES20.glViewport(0, 0, this.f13997G, this.f13998H);
        m14010i();
        Matrix.setIdentityM(this.f13992B, this.f13996F);
        float COUIBaseListPopupWindow_12 = i2;
        Matrix.orthoM(this.f13999I, 0, 0.0f, OplusGLSurfaceView_13, 0.0f, COUIBaseListPopupWindow_12, -1.0f, 1.0f);
        if (m14013l() == null) {
            this.f14000J = OplusGLSurfaceView_13;
            this.f14001K = i2;
            Matrix.translateM(this.f13992B, this.f13996F, 0.0f, COUIBaseListPopupWindow_12, 0.0f);
            Matrix.scaleM(this.f13992B, this.f13996F, 1.0f, -1.0f, 1.0f);
        }
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13977a(float[] fArr) {
        GLES20.glClearColor(fArr[1], fArr[2], fArr[3], fArr[0]);
        m14010i();
        GLES20.glClear(16384);
        m14010i();
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: IntrinsicsJvm.kt_4 */
    public float mo13979b() {
        return this.f13993C[this.f13995E];
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13958a(float COUIBaseListPopupWindow_12) {
        this.f13993C[this.f13995E] = COUIBaseListPopupWindow_12;
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13976a(boolean z) {
        this.f14031u = z;
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13959a(float COUIBaseListPopupWindow_12, float f2) {
        int OplusGLSurfaceView_13 = this.f13996F;
        float[] fArr = this.f13992B;
        int i2 = OplusGLSurfaceView_13 + 12;
        fArr[i2] = fArr[i2] + (fArr[OplusGLSurfaceView_13 + 0] * COUIBaseListPopupWindow_12) + (fArr[OplusGLSurfaceView_13 + 4] * f2);
        int i3 = OplusGLSurfaceView_13 + 13;
        fArr[i3] = fArr[i3] + (fArr[OplusGLSurfaceView_13 + 1] * COUIBaseListPopupWindow_12) + (fArr[OplusGLSurfaceView_13 + 5] * f2);
        int i4 = OplusGLSurfaceView_13 + 14;
        fArr[i4] = fArr[i4] + (fArr[OplusGLSurfaceView_13 + 2] * COUIBaseListPopupWindow_12) + (fArr[OplusGLSurfaceView_13 + 6] * f2);
        int i5 = OplusGLSurfaceView_13 + 15;
        fArr[i5] = fArr[i5] + (fArr[OplusGLSurfaceView_13 + 3] * COUIBaseListPopupWindow_12) + (fArr[OplusGLSurfaceView_13 + 7] * f2);
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13960a(float COUIBaseListPopupWindow_12, float f2, float f3) {
        Matrix.scaleM(this.f13992B, this.f13996F, COUIBaseListPopupWindow_12, f2, f3);
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13961a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        if (COUIBaseListPopupWindow_12 == 0.0f) {
            return;
        }
        float[] fArr = this.f14023m;
        Matrix.setRotateM(fArr, 0, COUIBaseListPopupWindow_12, f2, f3, f4);
        float[] fArr2 = this.f13992B;
        int OplusGLSurfaceView_13 = this.f13996F;
        Matrix.multiplyMM(fArr, 16, fArr2, OplusGLSurfaceView_13, fArr, 0);
        System.arraycopy(fArr, 16, fArr2, OplusGLSurfaceView_13, 16);
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13982c() {
        mo13965a(-1);
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13965a(int OplusGLSurfaceView_13) {
        if ((OplusGLSurfaceView_13 & 1) == 1) {
            float fMo13979b = mo13979b();
            this.f13995E++;
            float[] fArr = this.f13993C;
            if (fArr.length <= this.f13995E) {
                this.f13993C = Arrays.copyOf(fArr, fArr.length * 2);
            }
            this.f13993C[this.f13995E] = fMo13979b;
        }
        if ((OplusGLSurfaceView_13 & 2) == 2) {
            int i2 = this.f13996F;
            this.f13996F = i2 + 16;
            float[] fArr2 = this.f13992B;
            if (fArr2.length <= this.f13996F) {
                this.f13992B = Arrays.copyOf(fArr2, fArr2.length * 2);
            }
            float[] fArr3 = this.f13992B;
            System.arraycopy(fArr3, i2, fArr3, this.f13996F, 16);
        }
        this.f13994D.m14102a(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo13985f() {
        int iM14101a = this.f13994D.m14101a();
        if ((iM14101a & 1) == 1) {
            this.f13995E--;
        }
        if ((iM14101a & 2) == 2) {
            this.f13996F -= 16;
        }
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13964a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, GLPaint c2761l) {
        m13993a(3, 4, 2, COUIBaseListPopupWindow_12, f2, f3 - COUIBaseListPopupWindow_12, f4 - f2, c2761l);
        this.f14012V++;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13993a(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, GLPaint c2761l) {
        m13992a(OplusGLSurfaceView_13, i2, i3, COUIBaseListPopupWindow_12, f2, f3, f4, c2761l.m14022a(), c2761l.m14025b());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13992a(int OplusGLSurfaceView_13, int i2, int i3, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, int i4, float f5) {
        m13991a(i2, i4, f5);
        m14004a(this.f14032v, OplusGLSurfaceView_13, i3, COUIBaseListPopupWindow_12, f2, f3, f4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13991a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
        GLES20.glUseProgram(this.f14002L);
        m14010i();
        if (COUIBaseListPopupWindow_12 > 0.0f) {
            GLES20.glLineWidth(COUIBaseListPopupWindow_12);
            m14010i();
        }
        float[] fArrM14008b = m14008b(i2);
        boolean z = fArrM14008b[3] < 1.0f;
        m14007b(z);
        if (z) {
            GLES20.glBlendColor(fArrM14008b[0], fArrM14008b[1], fArrM14008b[2], fArrM14008b[3]);
            m14010i();
        }
        GLES20.glUniform4fv(this.f14032v[2].f14037a, 1, fArrM14008b, 0);
        m14003a(this.f14032v, OplusGLSurfaceView_13);
        m14010i();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float[] m14008b(int OplusGLSurfaceView_13) {
        float fMo13979b = (((OplusGLSurfaceView_13 >>> 24) & 255) / 255.0f) * mo13979b();
        float[] fArr = this.f14024n;
        fArr[0] = (((OplusGLSurfaceView_13 >>> 16) & 255) / 255.0f) * fMo13979b;
        fArr[1] = (((OplusGLSurfaceView_13 >>> 8) & 255) / 255.0f) * fMo13979b;
        fArr[2] = ((OplusGLSurfaceView_13 & 255) / 255.0f) * fMo13979b;
        fArr[3] = fMo13979b;
        return fArr;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14007b(boolean z) {
        if (z) {
            GLES20.glEnable(3042);
            m14010i();
        } else {
            GLES20.glDisable(3042);
            m14010i();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14003a(IntrinsicsJvm.kt_4[] bVarArr, int OplusGLSurfaceView_13) {
        GLES20.glBindBuffer(34962, this.f14008R);
        m14010i();
        GLES20.glVertexAttribPointer(bVarArr[0].f14037a, 2, 5126, false, 8, OplusGLSurfaceView_13 * 8);
        m14010i();
        GLES20.glBindBuffer(34962, 0);
        m14010i();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14004a(IntrinsicsJvm.kt_4[] bVarArr, int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        m14002a(bVarArr, COUIBaseListPopupWindow_12, f2, f3, f4);
        int i3 = bVarArr[0].f14037a;
        GLES20.glEnableVertexAttribArray(i3);
        m14010i();
        GLES20.glDrawArrays(OplusGLSurfaceView_13, 0, i2);
        m14010i();
        GLES20.glDisableVertexAttribArray(i3);
        m14010i();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14002a(IntrinsicsJvm.kt_4[] bVarArr, float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        Matrix.translateM(this.f14023m, 0, this.f13992B, this.f13996F, COUIBaseListPopupWindow_12, f2, 0.0f);
        Matrix.scaleM(this.f14023m, 0, f3, f4, 1.0f);
        float[] fArr = this.f14023m;
        Matrix.multiplyMM(fArr, 16, this.f13999I, 0, fArr, 0);
        GLES20.glUniformMatrix4fv(bVarArr[1].f14037a, 1, false, this.f14023m, 16);
        m14010i();
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13963a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, int OplusGLSurfaceView_13) {
        m13992a(5, 0, 4, COUIBaseListPopupWindow_12, f2, f3, f4, OplusGLSurfaceView_13, 0.0f);
        this.f14011U++;
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13968a(BasicTexture abstractC2752c, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        m13997a(abstractC2752c, this.f14025o);
        this.f14026p.set(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13 + i3, i2 + i4);
        m13995a(this.f14025o, this.f14026p, abstractC2752c);
        m14006b(abstractC2752c, this.f14025o, this.f14026p);
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13971a(BasicTexture abstractC2752c, RectF rectF, RectF rectF2) {
        if (rectF2.width() <= 0.0f || rectF2.height() <= 0.0f) {
            return;
        }
        this.f14025o.set(rectF);
        this.f14026p.set(rectF2);
        m13995a(this.f14025o, this.f14026p, abstractC2752c);
        m14006b(abstractC2752c, this.f14025o, this.f14026p);
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13973a(BasicTexture abstractC2752c, float[] fArr, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        this.f14026p.set(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13 + i3, i2 + i4);
        m14001a(abstractC2752c, fArr, this.f14026p);
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13972a(BasicTexture abstractC2752c, BasicTexture abstractC2752c2, float COUIBaseListPopupWindow_12, float f2, float[] fArr, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        this.f14026p.set(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13 + i3, i2 + i4);
        m13998a(abstractC2752c, abstractC2752c2, COUIBaseListPopupWindow_12, f2, fArr, this.f14026p);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14006b(BasicTexture abstractC2752c, RectF rectF, RectF rectF2) {
        m13994a(rectF);
        m14001a(abstractC2752c, this.f14028r, rectF2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13994a(RectF rectF) {
        this.f14028r[0] = rectF.width();
        this.f14028r[5] = rectF.height();
        this.f14028r[12] = rectF.left;
        this.f14028r[13] = rectF.top;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14001a(BasicTexture abstractC2752c, float[] fArr, RectF rectF) {
        if (abstractC2752c == null) {
            return;
        }
        IntrinsicsJvm.kt_4[] bVarArrM14009c = m14009c(abstractC2752c);
        m14003a(bVarArrM14009c, 0);
        GLES20.glUniformMatrix4fv(bVarArrM14009c[2].f14037a, 1, false, fArr, 0);
        m14010i();
        if (abstractC2752c.mo13933d()) {
            mo13965a(2);
            mo13959a(0.0f, rectF.centerY());
            mo13960a(1.0f, -1.0f, 1.0f);
            mo13959a(0.0f, -rectF.centerY());
        }
        m14004a(bVarArrM14009c, 5, 4, rectF.left, rectF.top, rectF.width(), rectF.height());
        if (abstractC2752c.mo13933d()) {
            mo13985f();
        }
        this.f14010T++;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13998a(BasicTexture abstractC2752c, BasicTexture abstractC2752c2, float COUIBaseListPopupWindow_12, float f2, float[] fArr, RectF rectF) {
        if (abstractC2752c == null || abstractC2752c2 == null) {
            return;
        }
        IntrinsicsJvm.kt_4[] bVarArr = this.f13991A;
        int OplusGLSurfaceView_13 = this.f14007Q;
        GLES20.glViewport(0, 0, this.f13997G, this.f13998H);
        m14010i();
        GLES20.glUseProgram(OplusGLSurfaceView_13);
        m14010i();
        m14007b(!abstractC2752c.mo13954r() || mo13979b() < 0.95f);
        GLES20.glActiveTexture(33984);
        m14010i();
        abstractC2752c.mo13931b(this);
        GLES20.glBindTexture(abstractC2752c.mo13942m(), abstractC2752c.m13934e());
        m14010i();
        GLES20.glUniform1i(bVarArr[6].f14037a, 0);
        m14010i();
        GLES20.glActiveTexture(33985);
        m14010i();
        abstractC2752c2.mo13931b(this);
        GLES20.glBindTexture(abstractC2752c2.mo13942m(), abstractC2752c2.m13934e());
        m14010i();
        GLES20.glUniform1i(bVarArr[7].f14037a, 1);
        m14010i();
        GLES20.glUniform1f(bVarArr[3].f14037a, mo13979b());
        m14010i();
        GLES20.glUniform1f(bVarArr[4].f14037a, COUIBaseListPopupWindow_12);
        m14010i();
        GLES20.glUniform1f(bVarArr[5].f14037a, f2);
        m14010i();
        m14003a(bVarArr, 0);
        GLES20.glUniformMatrix4fv(bVarArr[2].f14037a, 1, false, fArr, 0);
        m14010i();
        if (abstractC2752c.mo13933d()) {
            mo13965a(2);
            mo13959a(0.0f, rectF.centerY());
            mo13960a(1.0f, -1.0f, 1.0f);
            mo13959a(0.0f, -rectF.centerY());
        }
        m14004a(bVarArr, 5, 4, rectF.left, rectF.top, rectF.width(), rectF.height());
        if (abstractC2752c.mo13933d()) {
            mo13985f();
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, 0);
        m14010i();
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, 0);
        m14010i();
        GLES20.glUseProgram(0);
        m14010i();
        this.f14010T++;
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13974a(BasicTexture abstractC2752c, float[] fArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, boolean z) {
        if (i3 <= 0 || i4 <= 0) {
            return;
        }
        this.f14027q.set(OplusGLSurfaceView_13, i2, i3 + OplusGLSurfaceView_13, i4 + i2);
        m14000a(abstractC2752c, fArr, this.f14027q, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14000a(BasicTexture abstractC2752c, float[] fArr, Rect rect, boolean z) {
        IntrinsicsJvm.kt_4[] bVarArrM14009c = m14009c(abstractC2752c);
        m14003a(bVarArrM14009c, 0);
        if (z) {
            GLES20.glEnable(3089);
        }
        GLES20.glUniformMatrix4fv(bVarArrM14009c[2].f14037a, 1, false, fArr, 0);
        m14010i();
        if (abstractC2752c.mo13933d()) {
            mo13965a(2);
            mo13959a(0.0f, rect.centerY());
            mo13960a(1.0f, -1.0f, 1.0f);
            mo13959a(0.0f, -rect.centerY());
        }
        GLES20.glScissor(rect.left, (this.f13998H - rect.height()) - rect.top, rect.width(), rect.height());
        m14004a(bVarArrM14009c, 5, 4, rect.left, rect.top, rect.width(), rect.height());
        if (abstractC2752c.mo13933d()) {
            mo13985f();
        }
        this.f14010T++;
        GLES20.glDisable(3089);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private IntrinsicsJvm.kt_4[] m14009c(BasicTexture abstractC2752c) {
        IntrinsicsJvm.kt_4[] bVarArr;
        int OplusGLSurfaceView_13;
        if (abstractC2752c.mo13942m() == 3553) {
            bVarArr = this.f14033w;
            OplusGLSurfaceView_13 = this.f14003M;
        } else if (m14012k()) {
            bVarArr = this.f14035y;
            OplusGLSurfaceView_13 = this.f14005O;
        } else {
            bVarArr = this.f14034x;
            OplusGLSurfaceView_13 = this.f14004N;
        }
        m13996a(abstractC2752c, OplusGLSurfaceView_13, bVarArr);
        return bVarArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13996a(BasicTexture abstractC2752c, int OplusGLSurfaceView_13, IntrinsicsJvm.kt_4[] bVarArr) {
        GLES20.glViewport(0, 0, this.f13997G, this.f13998H);
        m14010i();
        GLES20.glUseProgram(OplusGLSurfaceView_13);
        m14010i();
        m14007b(!abstractC2752c.mo13954r() || mo13979b() < 0.95f);
        GLES20.glActiveTexture(33984);
        m14010i();
        abstractC2752c.mo13931b(this);
        GLES20.glBindTexture(abstractC2752c.mo13942m(), abstractC2752c.m13934e());
        m14010i();
        GLES20.glUniform1i(bVarArr[3].f14037a, 0);
        m14010i();
        if (m14012k() && bVarArr.length > 5) {
            GLES20.glActiveTexture(33985);
            m14010i();
            this.f14030t.mo13931b(this);
            GLES20.glBindTexture(this.f14030t.mo13942m(), this.f14030t.m13934e());
            m14010i();
            GLES20.glUniform1i(bVarArr[5].f14037a, 1);
            m14010i();
        }
        GLES20.glUniform1f(bVarArr[4].f14037a, mo13979b());
        m14010i();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m14012k() {
        return this.f14031u && this.f14030t != null;
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo13978a(BasicTexture abstractC2752c) {
        boolean zM13943n = abstractC2752c.m13943n();
        if (zM13943n) {
            synchronized (this.f14021k) {
                this.f14021k.m14102a(abstractC2752c.m13934e());
            }
        }
        return zM13943n;
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo13986g() {
        synchronized (this.f14021k) {
            if (this.f14021k.m14103b() > 0) {
                f13990i.mo14019a(null, this.f14021k.m14103b(), this.f14021k.m14104c(), 0);
                this.f14021k.m14105d();
            }
            if (this.f14022l.m14103b() > 0) {
                f13990i.mo14021b(null, this.f14022l.m14103b(), this.f14022l.m14104c(), 0);
                this.f14022l.m14105d();
            }
        }
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo13987h() {
        m13999a(this.f14014X.remove(r0.size() - 1), m14013l());
        mo13985f();
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13975a(RawTexture c2768s) {
        mo13982c();
        RawTexture c2768sM14013l = m14013l();
        this.f14014X.add(c2768s);
        m13999a(c2768sM14013l, c2768s);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private RawTexture m14013l() {
        return this.f14014X.get(r1.size() - 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13999a(BasicTexture abstractC2752c, RawTexture c2768s) {
        if (abstractC2752c == null && c2768s != null) {
            GLES20.glGenFramebuffers(1, this.f14013W, 0);
            m14010i();
            GLES20.glBindFramebuffer(36160, this.f14013W[0]);
            m14010i();
        } else if (abstractC2752c != null && c2768s == null) {
            GLES20.glBindFramebuffer(36160, 0);
            m14010i();
            GLES20.glDeleteFramebuffers(1, this.f14013W, 0);
            m14010i();
        }
        if (c2768s == null) {
            mo13966a(this.f14000J, this.f14001K);
            return;
        }
        mo13966a(c2768s.mo13935f(), c2768s.mo13936g());
        if (!c2768s.m13943n()) {
            c2768s.m14193c(this);
        }
        GLES20.glFramebufferTexture2D(36160, 36064, c2768s.mo13942m(), c2768s.m13934e(), 0);
        m14010i();
        m14011j();
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13980b(BasicTexture abstractC2752c) {
        int iMo13942m = abstractC2752c.mo13942m();
        GLES20.glBindTexture(iMo13942m, abstractC2752c.m13934e());
        m14010i();
        GLES20.glTexParameteri(iMo13942m, 10242, 33071);
        m14010i();
        GLES20.glTexParameteri(iMo13942m, 10243, 33071);
        m14010i();
        GLES20.glTexParameterf(iMo13942m, 10241, 9729.0f);
        m14010i();
        GLES20.glTexParameterf(iMo13942m, 10240, 9729.0f);
        m14010i();
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13967a(BasicTexture abstractC2752c, int OplusGLSurfaceView_13, int i2) {
        int iMo13942m = abstractC2752c.mo13942m();
        GLES20.glBindTexture(iMo13942m, abstractC2752c.m13934e());
        m14010i();
        GLES20.glTexImage2D(iMo13942m, 0, OplusGLSurfaceView_13, abstractC2752c.m13937h(), abstractC2752c.m13938i(), 0, OplusGLSurfaceView_13, i2, null);
        m14010i();
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13981b(BasicTexture abstractC2752c, int OplusGLSurfaceView_13, int i2) {
        int iMo13942m = abstractC2752c.mo13942m();
        GLES20.glBindTexture(iMo13942m, abstractC2752c.m13934e());
        m14010i();
        GLES20.glTexSubImage2D(iMo13942m, 0, 0, 0, abstractC2752c.m13937h(), abstractC2752c.m13938i(), OplusGLSurfaceView_13, i2, null);
        m14010i();
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13970a(BasicTexture abstractC2752c, Bitmap bitmap) {
        int iMo13942m = abstractC2752c.mo13942m();
        GLES20.glBindTexture(iMo13942m, abstractC2752c.m13934e());
        m14010i();
        GLUtils.texImage2D(iMo13942m, 0, bitmap, 0);
        m14010i();
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13969a(BasicTexture abstractC2752c, int OplusGLSurfaceView_13, int i2, Bitmap bitmap, int i3, int i4) {
        int iMo13942m = abstractC2752c.mo13942m();
        GLES20.glBindTexture(iMo13942m, abstractC2752c.m13934e());
        m14010i();
        GLUtils.texSubImage2D(iMo13942m, 0, OplusGLSurfaceView_13, i2, bitmap, i3, i4);
        m14010i();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m14014a(FloatBuffer floatBuffer) {
        return m13990a(floatBuffer, 4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m13990a(Buffer buffer, int OplusGLSurfaceView_13) {
        f13990i.mo14018a(1, this.f14029s, 0);
        m14010i();
        int i2 = this.f14029s[0];
        GLES20.glBindBuffer(34962, i2);
        m14010i();
        GLES20.glBufferData(34962, buffer.capacity() * OplusGLSurfaceView_13, buffer, 35044);
        m14010i();
        return i2;
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public GLId mo13957a() {
        return f13990i;
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13962a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (COUIBaseListPopupWindow_12 == 0.0f || Math.abs(f7) < Float.MIN_VALUE) {
            return;
        }
        float[] fArr = this.f14023m;
        Matrix.setRotateM(fArr, 0, COUIBaseListPopupWindow_12, f2, f3, f4);
        Matrix.multiplyMM(fArr, 16, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, (-f5) / f7, (-f6) / f7, 0.0f, (-1.0f) / f7, 0.0f, 0.0f, 0.0f, 1.0f}, 0, fArr, 0);
        Matrix.multiplyMM(fArr, 0, this.f13992B, this.f13996F, fArr, 16);
        System.arraycopy(fArr, 0, this.f13992B, this.f13996F, 16);
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: IntrinsicsJvm.kt_5 */
    public int mo13983d() {
        return this.f13997G;
    }

    @Override // com.oplus.camera.p146gl.GLCanvas
    /* renamed from: COUIBaseListPopupWindow_8 */
    public int mo13984e() {
        return this.f13998H;
    }

    /* compiled from: GLES20Canvas.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_13$IntrinsicsJvm.kt_4 */
    private static abstract class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f14037a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        protected final String f14038b;

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void mo14015a(int OplusGLSurfaceView_13);

        public IntrinsicsJvm.kt_4(String str) {
            this.f14038b = str;
        }
    }

    /* compiled from: GLES20Canvas.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_13$IntrinsicsJvm.kt_3 */
    private static class IntrinsicsJvm.kt_3 extends IntrinsicsJvm.kt_4 {
        public IntrinsicsJvm.kt_3(String str) {
            super(str);
        }

        @Override // com.oplus.camera.p146gl.GLES20Canvas.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo14015a(int OplusGLSurfaceView_13) {
            this.f14037a = GLES20.glGetUniformLocation(OplusGLSurfaceView_13, this.f14038b);
            GLES20Canvas.m14010i();
        }
    }

    /* compiled from: GLES20Canvas.java */
    /* renamed from: com.oplus.camera.gl.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends IntrinsicsJvm.kt_4 {
        public PlatformImplementations.kt_3(String str) {
            super(str);
        }

        @Override // com.oplus.camera.p146gl.GLES20Canvas.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo14015a(int OplusGLSurfaceView_13) {
            this.f14037a = GLES20.glGetAttribLocation(OplusGLSurfaceView_13, this.f14038b);
            GLES20Canvas.m14010i();
        }
    }
}
