package com.oplus.camera.p146gl.p148b;

import android.opengl.GLES20;
import android.opengl.GLES32;
import android.util.Size;
import com.oplus.camera.util.Util;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: FboDrawer.java */
/* renamed from: com.oplus.camera.gl.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class FboDrawer extends BaseDrawer implements IFboDrawer {

    /* renamed from: OplusGLSurfaceView_13 */
    private static final float[] f13927i = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};

    /* renamed from: OplusGLSurfaceView_15 */
    private static final float[] f13928j = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: OplusGLSurfaceView_5 */
    private int f13929k = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f13930l = 0;

    @Override // com.oplus.camera.p146gl.p148b.IFboDrawer
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13874b() {
        this.f13929k = m13870a(m13871a(35633, "#version 300 es                                                      \nlayout(location = 0) in vec4 a_position;                     \nlayout(location = 1) in vec4 a_texture_coord;                \nout vec2 v_texture_coord;                                    \nvoid main()                                                  \OplusGLSurfaceView_11{                                                            \OplusGLSurfaceView_11    gl_Position = a_position;                                \OplusGLSurfaceView_11    v_texture_coord = a_texture_coord.xy;                    \OplusGLSurfaceView_11}                                                            \OplusGLSurfaceView_11"), m13871a(35632, "#version 300 es                                                      \nprecision mediump float;                                     \nuniform sampler2D uTextureSampler;                           \nin vec2 v_texture_coord;                                     \nlayout(location = 0) out vec4 out_color;                     \nvoid main()                                                  \OplusGLSurfaceView_11{                                                            \OplusGLSurfaceView_11    out_color = texture(uTextureSampler, v_texture_coord);   \OplusGLSurfaceView_11}\OplusGLSurfaceView_11"));
        this.f13930l = GLES32.glGetUniformLocation(this.f13929k, "uTextureSampler");
    }

    @Override // com.oplus.camera.p146gl.p148b.IFboDrawer
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo13873a(int OplusGLSurfaceView_13, int i2, int i3, Size size, Size size2, int i4, boolean z, SubSurfacePositionContainer c2751h) {
        int i5;
        int iM13903b;
        int iM13905c;
        int iM13898a = c2751h.m13898a();
        int iM13917k = c2751h.m13917k();
        int iM24451g = Util.m24451g();
        if (-1 == iM24451g) {
            iM13903b = c2751h.m13903b() - c2751h.m13917k();
            iM13905c = c2751h.m13905c();
        } else if (iM24451g == 0) {
            iM13903b = c2751h.m13903b() - c2751h.m13917k();
            iM13905c = (c2751h.m13905c() / 2) - Util.m24185M();
        } else {
            i5 = 0;
            GLES32.glUseProgram(this.f13929k);
            GLES32.glActiveTexture(33984);
            GLES32.glViewport(c2751h.m13914h(), i5, iM13898a, iM13917k);
            GLES32.glBindTexture(3553, OplusGLSurfaceView_13);
            GLES32.glUniform1i(this.f13930l, 0);
            m13868a();
            FloatBuffer floatBufferA = m13872a(f13927i);
            FloatBuffer floatBufferA2 = m13872a(f13928j);
            floatBufferA.position(0);
            floatBufferA2.position(0);
            GLES32.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) floatBufferA);
            GLES32.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) floatBufferA2);
            GLES32.glEnableVertexAttribArray(0);
            GLES32.glEnableVertexAttribArray(1);
            GLES32.glDrawArrays(5, 0, 4);
            m13868a();
            GLES32.glDisableVertexAttribArray(0);
            GLES32.glDisableVertexAttribArray(1);
            GLES32.glBindTexture(3553, 0);
            GLES32.glUseProgram(0);
            m13868a();
            return 0;
        }
        i5 = iM13903b - iM13905c;
        GLES32.glUseProgram(this.f13929k);
        GLES32.glActiveTexture(33984);
        GLES32.glViewport(c2751h.m13914h(), i5, iM13898a, iM13917k);
        GLES32.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES32.glUniform1i(this.f13930l, 0);
        m13868a();
        FloatBuffer floatBufferA3 = m13872a(f13927i);
        FloatBuffer floatBufferA22 = m13872a(f13928j);
        floatBufferA3.position(0);
        floatBufferA22.position(0);
        GLES32.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) floatBufferA3);
        GLES32.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) floatBufferA22);
        GLES32.glEnableVertexAttribArray(0);
        GLES32.glEnableVertexAttribArray(1);
        GLES32.glDrawArrays(5, 0, 4);
        m13868a();
        GLES32.glDisableVertexAttribArray(0);
        GLES32.glDisableVertexAttribArray(1);
        GLES32.glBindTexture(3553, 0);
        GLES32.glUseProgram(0);
        m13868a();
        return 0;
    }

    @Override // com.oplus.camera.p146gl.p148b.IFboDrawer
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo13875c() {
        GLES20.glDeleteProgram(this.f13929k);
        this.f13929k = 0;
        this.f13921c = 0;
        this.f13923e = 0;
        this.f13930l = 0;
    }
}
