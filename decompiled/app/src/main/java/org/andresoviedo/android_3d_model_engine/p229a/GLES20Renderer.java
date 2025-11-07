package org.andresoviedo.android_3d_model_engine.p229a;

import android.opengl.Matrix;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.andresoviedo.android_3d_model_engine.p230b.AnimatedModel;
import org.andresoviedo.android_3d_model_engine.p230b.Element;
import org.andresoviedo.android_3d_model_engine.p230b.Object3DData;
import org.andresoviedo.p225a.p226a.GL;
import org.andresoviedo.p225a.p226a.GLUtil;

/* compiled from: GLES20Renderer.java */
/* renamed from: org.andresoviedo.android_3d_model_engine.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
class GLES20Renderer implements Renderer {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final float[] f24861a = {1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final float[] f24862b = {1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: OplusGLSurfaceView_5 */
    private static Map<Object, Object> f24863k = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final String f24864c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Set<String> f24865d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f24866e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private long f24867f = -1;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private double f24868g = -1.0d;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f24869h = true;

    /* renamed from: OplusGLSurfaceView_13 */
    private Map<Object, Integer> f24870i = new HashMap();

    /* renamed from: OplusGLSurfaceView_15 */
    private final SparseArray<String> f24871j = new SparseArray<>();

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26139a(AnimatedModel c4054a) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static GLES20Renderer m26133a(String str, String str2, String str3) {
        HashSet hashSet = new HashSet();
        m26138a(hashSet, str2, "u_MMatrix");
        m26138a(hashSet, str2, "a_Position");
        m26138a(hashSet, str2, "a_Normal");
        m26138a(hashSet, str2, "a_Color");
        m26138a(hashSet, str2, "a_TexCoordinate");
        m26138a(hashSet, str2, "u_LightPos");
        m26138a(hashSet, str2, "in_jointIndices");
        m26138a(hashSet, str2, "in_weights");
        m26138a(hashSet, str3, "u_TextureCube");
        return new GLES20Renderer(str, str2, str3, hashSet);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m26138a(Set<String> set, String str, String str2) {
        if (str.contains(str2)) {
            set.add(str2);
        }
    }

    private GLES20Renderer(String str, String str2, String str3, Set<String> set) {
        this.f24864c = str;
        this.f24865d = set;
        Log.OplusGLSurfaceView_13("GLES20Renderer", "Compiling 3D Drawer... " + str);
        GL c4047c = GL.f24804a;
        int iM26122a = GLUtil.m26122a(35633, str2);
        GL c4047c2 = GL.f24804a;
        this.f24866e = GLUtil.m26121a(iM26122a, GLUtil.m26122a(35632, str3), (String[]) set.toArray(new String[0]));
        f24863k.clear();
        Log.IntrinsicsJvm.kt_5("GLES20Renderer", "Compiled 3D Drawer (" + str + ") with id_renamed " + this.f24866e);
    }

    @Override // org.andresoviedo.android_3d_model_engine.p229a.Renderer
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo26157a(Object3DData c4060g, float[] fArr, float[] fArr2, int OplusGLSurfaceView_13, float[] fArr3, float[] fArr4) {
        mo26156a(c4060g, fArr, fArr2, c4060g.m26247o(), c4060g.m26248p(), OplusGLSurfaceView_13, fArr3, null, fArr4);
    }

    @Override // org.andresoviedo.android_3d_model_engine.p229a.Renderer
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo26158a(Object3DData c4060g, float[] fArr, float[] fArr2, int OplusGLSurfaceView_13, float[] fArr3, float[] fArr4, float[] fArr5) {
        mo26156a(c4060g, fArr, fArr2, c4060g.m26247o(), c4060g.m26248p(), OplusGLSurfaceView_13, fArr3, fArr4, fArr5);
    }

    @Override // org.andresoviedo.android_3d_model_engine.p229a.Renderer
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo26156a(Object3DData c4060g, float[] fArr, float[] fArr2, int OplusGLSurfaceView_13, int i2, int i3, float[] fArr3, float[] fArr4, float[] fArr5) {
        int iM26132a;
        int iM26132a2;
        int i4;
        int i5;
        int i6;
        if (this.f24864c != f24863k.get(c4060g.m26237g())) {
            Log.IntrinsicsJvm.kt_5("GLES20Renderer", "Rendering with shader: " + this.f24864c + "vert... obj: " + c4060g);
            f24863k.put(c4060g.m26237g(), this.f24864c);
        }
        GL.f24804a.m26118o(this.f24866e);
        if (GLUtil.m26125a("glUseProgram")) {
            return;
        }
        float[] fArrM26205C = c4060g.m26205C();
        if (m26144a()) {
            m26150c(c4060g.m26205C(), "u_MMatrix");
        }
        m26150c(fArr2, "u_VMatrix");
        m26150c(fArr, "u_PMatrix");
        float[] fArr6 = new float[16];
        float[] fArr7 = new float[16];
        Matrix.multiplyMM(fArr7, 0, fArr2, 0, fArrM26205C, 0);
        Matrix.multiplyMM(fArr6, 0, fArr, 0, fArr7, 0);
        m26150c(fArr6, "u_MVPMatrix");
        int iM26132a3 = m26132a("a_Position", c4060g.m26209G(), 3);
        int iM26132a4 = -1;
        int iM26132a5 = m26152d() ? m26132a("a_Normal", c4060g.m26210H(), 3) : -1;
        if (m26151c()) {
            iM26132a = m26132a("a_Color", c4060g.m26213K(), 4);
        } else {
            m26147b(c4060g.m26246n() != null ? c4060g.m26246n() : f24861a, "vColor");
            iM26132a = -1;
        }
        if (c4060g.f24941a) {
            m26140a(c4060g);
        }
        m26147b(fArr4 != null ? fArr4 : f24862b, "vColorMask");
        if (i3 == -1 || !m26154f()) {
            iM26132a2 = -1;
        } else {
            m26146b(i3);
            iM26132a2 = m26132a("a_TexCoordinate", c4060g.m26211I(), 2);
        }
        if (i3 != -1 && m26148b()) {
            m26149c(i3);
        }
        if (fArr3 != null && m26153e()) {
            m26143a(fArr3, "u_LightPos");
            m26143a(fArr5, "u_cameraPos");
        }
        if (m26155g() && (c4060g instanceof AnimatedModel)) {
            AnimatedModel c4054a = (AnimatedModel) c4060g;
            iM26132a4 = m26132a("in_weights", c4054a.m26166c(), 3);
            int iM26132a6 = m26132a("in_jointIndices", c4054a.m26164b(), 3);
            m26150c(c4054a.m26163a(), "u_BindShapeMatrix");
            m26139a(c4054a);
            i4 = OplusGLSurfaceView_13;
            i6 = iM26132a6;
            i5 = i2;
        } else {
            i4 = OplusGLSurfaceView_13;
            i5 = i2;
            i6 = -1;
        }
        m26141a(c4060g, i4, i5);
        m26134a(iM26132a3);
        m26134a(iM26132a);
        m26134a(iM26132a5);
        m26134a(iM26132a2);
        m26134a(iM26132a4);
        m26134a(i6);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m26132a(String str, FloatBuffer floatBuffer, int OplusGLSurfaceView_13) {
        int iM26078a = GL.f24804a.m26078a(this.f24866e, str);
        GLUtil.m26125a("glGetAttribLocation");
        GL.f24804a.m26114j(iM26078a);
        GLUtil.m26125a("glEnableVertexAttribArray");
        floatBuffer.position(0);
        GL c4047c = GL.f24804a;
        GL c4047c2 = GL.f24804a;
        c4047c.m26085a(iM26078a, OplusGLSurfaceView_13, 5126, false, 0, floatBuffer);
        GLUtil.m26125a("glVertexAttribPointer");
        return iM26078a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26143a(float[] fArr, String str) {
        int iM26092b = GL.f24804a.m26092b(this.f24866e, str);
        GLUtil.m26125a("glGetUniformLocation");
        GL.f24804a.m26088a(iM26092b, 1, fArr, 0);
        GLUtil.m26125a("glUniform3fv");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m26147b(float[] fArr, String str) {
        int iM26092b = GL.f24804a.m26092b(this.f24866e, str);
        GLUtil.m26125a("glGetUniformLocation");
        GL.f24804a.m26097b(iM26092b, 1, fArr, 0);
        GLUtil.m26125a("glUniform4fv");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m26150c(float[] fArr, String str) {
        int iM26092b = GL.f24804a.m26092b(this.f24866e, str);
        GLUtil.m26125a("glGetUniformLocation");
        GL.f24804a.m26087a(iM26092b, 1, false, fArr, 0);
        GLUtil.m26125a("glUniformMatrix4fv");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26134a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != -1) {
            GL.f24804a.m26112h(OplusGLSurfaceView_13);
            GLUtil.m26125a("glDisableVertexAttribArray");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m26144a() {
        return this.f24865d.contains("u_MMatrix");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m26148b() {
        return this.f24865d.contains("u_TextureCube");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m26151c() {
        return this.f24865d.contains("a_Color");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m26152d() {
        return this.f24865d.contains("a_Normal");
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m26153e() {
        return this.f24865d.contains("u_LightPos");
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m26154f() {
        return this.f24865d.contains("a_TexCoordinate");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m26146b(int OplusGLSurfaceView_13) {
        int iM26092b = GL.f24804a.m26092b(this.f24866e, "u_Texture");
        GLUtil.m26125a("glGetUniformLocation");
        GL c4047c = GL.f24804a;
        GL c4047c2 = GL.f24804a;
        c4047c.m26080a(33984);
        GLUtil.m26125a("glActiveTexture");
        GL c4047c3 = GL.f24804a;
        GL c4047c4 = GL.f24804a;
        c4047c3.m26094b(3553, OplusGLSurfaceView_13);
        GLUtil.m26125a("glBindTexture");
        GL c4047c5 = GL.f24804a;
        GL c4047c6 = GL.f24804a;
        GL c4047c7 = GL.f24804a;
        GL c4047c8 = GL.f24804a;
        c4047c5.m26095b(3553, 10241, 9729);
        GL c4047c9 = GL.f24804a;
        GL c4047c10 = GL.f24804a;
        GL c4047c11 = GL.f24804a;
        GL c4047c12 = GL.f24804a;
        c4047c9.m26095b(3553, 10240, 9729);
        GL c4047c13 = GL.f24804a;
        GL c4047c14 = GL.f24804a;
        GL c4047c15 = GL.f24804a;
        GL c4047c16 = GL.f24804a;
        c4047c13.m26095b(3553, 10242, 33071);
        GL c4047c17 = GL.f24804a;
        GL c4047c18 = GL.f24804a;
        GL c4047c19 = GL.f24804a;
        GL c4047c20 = GL.f24804a;
        c4047c17.m26095b(3553, 10243, 33071);
        GL.f24804a.m26107d(iM26092b, 0);
        GLUtil.m26125a("glUniform1i");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m26149c(int OplusGLSurfaceView_13) {
        int iM26092b = GL.f24804a.m26092b(this.f24866e, "u_TextureCube");
        GLUtil.m26125a("glGetUniformLocation");
        GL c4047c = GL.f24804a;
        GL c4047c2 = GL.f24804a;
        c4047c.m26080a(33984);
        GLUtil.m26125a("glActiveTexture");
        GL c4047c3 = GL.f24804a;
        GL c4047c4 = GL.f24804a;
        c4047c3.m26094b(34067, OplusGLSurfaceView_13);
        GLUtil.m26125a("glBindTexture");
        GL.f24804a.m26107d(iM26092b, 0);
        GLUtil.m26125a("glUniform1i");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m26155g() {
        return this.f24865d.contains("in_jointIndices") && this.f24865d.contains("in_weights");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26141a(Object3DData c4060g, int OplusGLSurfaceView_13, int i2) {
        FloatBuffer floatBufferM26209G;
        Buffer bufferM26207E;
        int i3;
        if (c4060g.m26241i()) {
            bufferM26207E = null;
            floatBufferM26209G = c4060g.m26209G();
            i3 = -1;
        } else {
            floatBufferM26209G = c4060g.m26209G();
            if (this.f24869h) {
                bufferM26207E = c4060g.m26206D();
                GL c4047c = GL.f24804a;
                i3 = 5125;
            } else {
                bufferM26207E = c4060g.m26207E();
                GL c4047c2 = GL.f24804a;
                i3 = 5123;
            }
        }
        Buffer buffer = bufferM26207E;
        int i4 = i3;
        floatBufferM26209G.position(0);
        List<int[]> listM26212J = c4060g.m26212J();
        if (listM26212J != null) {
            if (c4060g.m26241i()) {
                m26136a(OplusGLSurfaceView_13, listM26212J);
                return;
            } else {
                m26137a(buffer, i4, listM26212J);
                return;
            }
        }
        if (c4060g.m26241i()) {
            m26135a(OplusGLSurfaceView_13, i2, floatBufferM26209G.capacity() / 3);
        } else {
            m26142a(c4060g, OplusGLSurfaceView_13, i2, buffer, i4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26135a(int OplusGLSurfaceView_13, int i2, int i3) {
        int i4 = 0;
        if (i2 > 0) {
            while (i4 < i3) {
                GL.f24804a.m26082a(OplusGLSurfaceView_13, i4, i2);
                GLUtil.m26125a("glDrawArrays");
                i4 += i2;
            }
            return;
        }
        if (this.f24868g >= 0.0d) {
            double dUptimeMillis = ((SystemClock.uptimeMillis() % 10000) / 10000.0f) * 6.283185307179586d;
            if (this.f24868g == 0.0d) {
                this.f24868g = dUptimeMillis;
            }
            i3 = (int) (((Math.sin((dUptimeMillis - this.f24868g) + 4.71238898038469d) + 1.0d) / 2.0d) * i3);
        }
        GL.f24804a.m26082a(OplusGLSurfaceView_13, 0, i3);
        GLUtil.m26125a("glDrawArrays");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26142a(Object3DData c4060g, int OplusGLSurfaceView_13, int i2, Buffer buffer, int i3) {
        float[] fArrM26246n;
        if (i2 <= 0) {
            if (this.f24864c != f24863k.get(c4060g.m26216N())) {
                Log.OplusGLSurfaceView_13("GLES20Renderer", "Rendering elements... obj: " + c4060g.m26237g() + ", total:" + c4060g.m26216N().size());
                f24863k.put(c4060g.m26216N(), this.f24864c);
            }
            for (int i4 = 0; i4 < c4060g.m26216N().size(); i4++) {
                Element c4058e = c4060g.m26216N().get(i4);
                IntBuffer intBufferM26196a = c4058e.m26196a();
                if (this.f24864c != f24863k.get(c4058e)) {
                    Log.v("GLES20Renderer", "Rendering element " + i4 + "....  " + c4058e);
                }
                if (c4058e.m26198b() != null) {
                    if (!m26151c()) {
                        if (c4058e.m26198b().m26201c() != null) {
                            fArrM26246n = c4058e.m26198b().m26201c();
                        } else {
                            fArrM26246n = c4060g.m26246n() != null ? c4060g.m26246n() : f24861a;
                        }
                        m26147b(fArrM26246n, "vColor");
                    }
                    if (c4058e.m26198b().m26200b() != -1 && m26154f()) {
                        m26146b(c4058e.m26198b().m26200b());
                    }
                }
                intBufferM26196a.position(0);
                GL.f24804a.m26084a(OplusGLSurfaceView_13, intBufferM26196a.capacity(), i3, intBufferM26196a);
                GLUtil.m26125a("glDrawElements");
                if (this.f24869h && GLUtil.m26125a("glDrawElements")) {
                    this.f24869h = false;
                }
                if (this.f24864c != f24863k.get(c4058e)) {
                    Log.v("GLES20Renderer", "Rendering element " + i4 + " finished");
                    f24863k.put(c4058e, this.f24864c);
                }
            }
            return;
        }
        int i5 = 0;
        while (i5 < buffer.capacity()) {
            buffer.position(i5);
            GL.f24804a.m26084a(OplusGLSurfaceView_13, i2, i3, buffer);
            GLUtil.m26125a("glDrawElements");
            i5 += i2;
        }
        if (this.f24869h && GLUtil.m26125a("glDrawElements")) {
            this.f24869h = false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26137a(Buffer buffer, int OplusGLSurfaceView_13, List<int[]> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            int[] iArr = list.get(i2);
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = iArr[2];
            buffer.position(i4);
            GL.f24804a.m26084a(i3, i5, OplusGLSurfaceView_13, buffer);
            GLUtil.m26125a("glDrawElements");
            if (this.f24869h && GLUtil.m26125a("glDrawElements")) {
                this.f24869h = false;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26136a(int OplusGLSurfaceView_13, List<int[]> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            int[] iArr = list.get(i2);
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = iArr[2];
            GL c4047c = GL.f24804a;
            if (OplusGLSurfaceView_13 == 2 && iArr[2] > 3) {
                for (int i6 = 0; i6 < iArr[2] - 2; i6++) {
                    GL.f24804a.m26082a(OplusGLSurfaceView_13, iArr[1] + i6, 3);
                    GLUtil.m26125a("glDrawArrays");
                }
            } else {
                GL.f24804a.m26082a(OplusGLSurfaceView_13, iArr[1], iArr[2]);
                GLUtil.m26125a("glDrawArrays");
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m26140a(Object3DData c4060g) {
        int iM26078a = GL.f24804a.m26078a(this.f24866e, "a_Layer");
        m26145a("glGetAttribLocation");
        GL.f24804a.m26114j(iM26078a);
        m26145a("glEnableVertexAttribArray");
        c4060g.m26208F().position(0);
        GL c4047c = GL.f24804a;
        GL c4047c2 = GL.f24804a;
        c4047c.m26085a(iM26078a, 1, 5126, false, 0, c4060g.m26208F());
        m26145a("glVertexAttribPointer");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m26145a(String str) {
        return GLUtil.m26125a(str);
    }

    public String toString() {
        return "GLES20Renderer{id_renamed='" + this.f24864c + "', features=" + this.f24865d + '}';
    }
}
