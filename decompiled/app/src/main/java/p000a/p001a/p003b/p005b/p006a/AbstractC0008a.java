package p000a.p001a.p003b.p005b.p006a;

import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import java.nio.Buffer;
import java.util.Arrays;
import p000a.p001a.p003b.C0001a;
import p000a.p001a.p003b.p005b.C0025an;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p010f.C0113f;
import p000a.p001a.p003b.p010f.C0125r;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class AbstractC0008a {
    public static final int KEY_IN = 258;
    public static final int KEY_INDEX = 513;
    public static final int KEY_OUT = 257;
    public static final String fragmentHeader = "precision highp float;\OplusGLSurfaceView_11";

    /* renamed from: OplusGLSurfaceView_6 */
    public static final float[] f20m = C0125r.m596a();
    public static final String needReplaceHeader = "#extension GL_OES_standard_derivatives : enable";
    public static final String vertexHeader = "uniform mat4 u_ModelViewProjectionMatrix;\nattribute vec4 a_Vertex;\nattribute vec4 a_TexCoord;\nattribute vec4 a_Distortion;\nattribute vec4 a_Delta;\OplusGLSurfaceView_11";

    /* renamed from: PlatformImplementations.kt_3 */
    public Context f21a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f22b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f23c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int f24d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int f25e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int f26f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int f27g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public int f28h;

    /* renamed from: OplusGLSurfaceView_13 */
    public Resources f29i;

    /* renamed from: OplusGLSurfaceView_15 */
    public float[] f30j = Arrays.copyOf(f20m, 16);

    /* renamed from: OplusGLSurfaceView_5 */
    public int f31k = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    public int f32l = 0;

    public AbstractC0008a(Context context, Resources resources) {
        this.f29i = resources;
        this.f21a = context;
        mo49d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m25a(int OplusGLSurfaceView_13, String str) {
        int iGlCreateShader = GLES20.glCreateShader(OplusGLSurfaceView_13);
        if (iGlCreateShader == 0) {
            return iGlCreateShader;
        }
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        m27a(1, (Object) ("Could not compile shader:" + OplusGLSurfaceView_13));
        m27a(1, (Object) ("GLES20 Error:" + GLES20.glGetShaderInfoLog(iGlCreateShader)));
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m26a(String str) {
        return str.contains(needReplaceHeader) ? str.replace(fragmentHeader, "").replace(needReplaceHeader, "#extension GL_OES_standard_derivatives : enable\nprecision highp float;\OplusGLSurfaceView_11") : str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m27a(int OplusGLSurfaceView_13, Object obj) {
        C0001a.m11a("base glError");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int m28c(java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 35633(0x8b31, float:4.9932E-41)
            int r5 = m25a(r0, r5)
            r0 = 0
            if (r5 != 0) goto Lb
            return r0
        Lb:
            r1 = 35632(0x8b30, float:4.9931E-41)
            java.lang.String r6 = m26a(r6)
            int r6 = m25a(r1, r6)
            if (r6 != 0) goto L1e
            java.lang.String r5 = "hh"
            p000a.p001a.p003b.C0001a.m11a(r5)
            return r0
        L1e:
            int r1 = android.opengl.GLES20.glCreateProgram()
            if (r1 == 0) goto L56
            android.opengl.GLES20.glAttachShader(r1, r5)
            android.opengl.GLES20.glAttachShader(r1, r6)
            android.opengl.GLES20.glLinkProgram(r1)
            r2 = 1
            int[] r3 = new int[r2]
            r4 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r1, r4, r3, r0)
            r3 = r3[r0]
            if (r3 == r2) goto L56
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Could not link program:"
            r3.append(r4)
            java.lang.String r4 = android.opengl.GLES20.glGetProgramInfoLog(r1)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            m27a(r2, r3)
            android.opengl.GLES20.glDeleteProgram(r1)
            goto L57
        L56:
            r0 = r1
        L57:
            if (r0 == 0) goto L5c
            p000a.p001a.p003b.p007c.C0097g.m302b(r0)
        L5c:
            android.opengl.GLES20.glDeleteShader(r5)
            android.opengl.GLES20.glDeleteShader(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p001a.p003b.p005b.p006a.AbstractC0008a.m28c(java.lang.String, java.lang.String):int");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public C0094d m29a(int OplusGLSurfaceView_13, int i2, int i3) {
        int[] iArr = {0};
        C0113f.m480a(1, iArr, 0, 6408, OplusGLSurfaceView_13, i2);
        return C0113f.m486b(iArr[0], 6408, OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m30a() {
        mo52g();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m31a(int OplusGLSurfaceView_13) {
        this.f32l = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m32a(int OplusGLSurfaceView_13, int i2) {
        GLES20.glActiveTexture(i2 + 33984);
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m33a(C0094d c0094d) {
        if (c0094d != null) {
            C0113f.m476a(c0094d.f387a);
            c0094d.f387a = 0;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m34a(C0094d c0094d, int OplusGLSurfaceView_13) {
        m32a(c0094d.f387a, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m35a(String str, float COUIBaseListPopupWindow_12) {
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f22b, str), COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m36a(String str, float COUIBaseListPopupWindow_12, float f2) {
        GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f22b, str), COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m37a(String str, float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        GLES20.glUniform4f(GLES20.glGetUniformLocation(this.f22b, str), COUIBaseListPopupWindow_12, f2, f3, f4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m38a(String str, int OplusGLSurfaceView_13) {
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f22b, str), OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m39a(String str, String str2) {
        String str3;
        if (this.f21a.isOES && (this instanceof C0025an) && str2 != null) {
            str2 = str2.replace("uniform sampler2D texture;", "uniform samplerExternalOES texture;");
            str3 = "#extension GL_OES_EGL_image_external : require\OplusGLSurfaceView_11";
        } else {
            str3 = "";
        }
        this.f22b = m28c(vertexHeader + str, str3 + fragmentHeader + str2);
        this.f23c = GLES20.glGetAttribLocation(this.f22b, "a_Vertex");
        this.f24d = GLES20.glGetAttribLocation(this.f22b, "a_TexCoord");
        this.f25e = GLES20.glGetAttribLocation(this.f22b, "a_Distortion");
        this.f26f = GLES20.glGetAttribLocation(this.f22b, "a_Delta");
        this.f27g = GLES20.glGetUniformLocation(this.f22b, "u_ModelViewProjectionMatrix");
        this.f28h = GLES20.glGetUniformLocation(this.f22b, "texture");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m40a(String str, float[] fArr) {
        GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.f22b, str), 1, false, fArr, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m41a(String str, float[] fArr, int OplusGLSurfaceView_13, int i2) {
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.f22b, str), i2, fArr, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m42a(float[] fArr) {
        this.f30j = fArr;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final int m43b() {
        return this.f32l;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo44b(int OplusGLSurfaceView_13, int i2);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final void m45b(String str, String str2) {
        m39a(this.f21a.shaderUtil.m530a(this.f29i, str), this.f21a.shaderUtil.m530a(this.f29i, str2));
        C0001a.m11a("create program");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m46b(String str, float[] fArr, int OplusGLSurfaceView_13, int i2) {
        GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f22b, str), i2, fArr, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final int m47c() {
        return this.f31k;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final void m48c(int OplusGLSurfaceView_13, int i2) {
        mo44b(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo49d() {
    }

    public void draw() {
        mo51f();
        m55k();
        mo23j();
        mo50e();
        mo53h();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void mo50e() {
        GLES20.glActiveTexture(this.f31k + 33984);
        GLES20.glBindTexture((this.f21a.isOES && (this instanceof C0025an)) ? 36197 : 3553, m43b());
        GLES20.glUniform1i(this.f28h, this.f31k);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo51f() {
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16384);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public abstract void mo52g();

    public float[] getMatrix() {
        return this.f30j;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo53h() {
        int OplusGLSurfaceView_13 = this.f23c;
        if (OplusGLSurfaceView_13 >= 0) {
            GLES20.glEnableVertexAttribArray(OplusGLSurfaceView_13);
            GLES20.glVertexAttribPointer(this.f23c, 3, 5126, false, 0, (Buffer) this.f21a.mesh.mVerBuffer);
        }
        int i2 = this.f24d;
        if (i2 >= 0) {
            GLES20.glEnableVertexAttribArray(i2);
            GLES20.glVertexAttribPointer(this.f24d, 2, 5126, false, 0, (Buffer) this.f21a.mesh.mTexBuffer);
        }
        int i3 = this.f25e;
        if (i3 >= 0) {
            GLES20.glEnableVertexAttribArray(i3);
            GLES20.glVertexAttribPointer(this.f25e, 2, 5126, false, 0, (Buffer) this.f21a.mesh.mDistortionBuffer);
        }
        int i4 = this.f26f;
        if (i4 >= 0) {
            GLES20.glEnableVertexAttribArray(i4);
            GLES20.glVertexAttribPointer(this.f26f, 2, 5126, false, 0, (Buffer) this.f21a.mesh.mDeltaBuffer);
        }
        GLES20.glDrawElements(4, this.f21a.mesh.trianglesBuffer.capacity(), 5123, this.f21a.mesh.trianglesBuffer);
        int i5 = this.f23c;
        if (i5 >= 0) {
            GLES20.glDisableVertexAttribArray(i5);
        }
        int i6 = this.f24d;
        if (i6 >= 0) {
            GLES20.glDisableVertexAttribArray(i6);
        }
        int i7 = this.f25e;
        if (i7 >= 0) {
            GLES20.glDisableVertexAttribArray(i7);
        }
        int i8 = this.f26f;
        if (i8 >= 0) {
            GLES20.glDisableVertexAttribArray(i8);
        }
        C0001a.m11a("draw program");
        mo54i();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void mo54i() {
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void mo23j() {
        GLES20.glUniformMatrix4fv(this.f27g, 1, false, this.f30j, 0);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m55k() {
        GLES20.glUseProgram(this.f22b);
    }
}
