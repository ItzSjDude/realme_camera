package com.oplus.camera.p146gl.p148b;

import android.opengl.GLES20;
import android.opengl.GLES32;
import android.util.Size;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p146gl.RawTexture;
import com.oplus.camera.util.Util;
import java.nio.FloatBuffer;

/* compiled from: SqureOesDrawer.java */
/* renamed from: com.oplus.camera.gl.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class SqureOesDrawer extends BaseDrawer implements IOesDrawer {

    /* renamed from: OplusGLSurfaceView_5 */
    private static final float[] f13946k = {-1.0f, 1.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 0.0f};

    /* renamed from: OplusGLSurfaceView_14 */
    private static final float[] f13947l = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f13948i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private int[] f13949j = new int[1];

    @Override // com.oplus.camera.p146gl.p148b.IOesDrawer
    /* renamed from: e_ */
    public void mo13879e_() {
        this.f13919a = m13870a(m13871a(35633, "#version 300 es                                                      \nuniform mat4 mvp_matrix;                                     \nlayout(location = 0) in vec4 a_position;                     \nlayout(location = 1) in vec4 a_texture_coord;                \nout vec2 v_texture_coord;                                    \nvoid main()                                                  \OplusGLSurfaceView_11{                                                            \OplusGLSurfaceView_11    gl_Position = a_position;                                \OplusGLSurfaceView_11    v_texture_coord = (mvp_matrix * a_texture_coord).xy;     \OplusGLSurfaceView_11}                                                            \OplusGLSurfaceView_11"), m13871a(35632, "#version 300 es                                                      \OplusGLSurfaceView_11#extension GL_OES_EGL_image_external_essl3 : require         \nprecision mediump float;                                     \nuniform samplerExternalOES uTextureSampler;                  \nuniform sampler2D uTextureSampler2D;                         \nuniform int uCameraId;                                       \nin vec2 v_texture_coord;                                     \nlayout(location = 0) out vec4 out_color;                     \nvoid main()                                                  \OplusGLSurfaceView_11{                                                            \OplusGLSurfaceView_11    out_color = texture(uTextureSampler, v_texture_coord);   \OplusGLSurfaceView_11}                                                            \OplusGLSurfaceView_11"));
        this.f13920b = m13870a(m13871a(35633, "#version 300 es                                                      \nuniform mat4 mvp_matrix;                                     \nlayout(location = 0) in vec4 a_position;                     \nlayout(location = 1) in vec4 a_texture_coord;                \nout vec2 v_texture_coord;                                    \nvoid main()                                                  \OplusGLSurfaceView_11{                                                            \OplusGLSurfaceView_11    gl_Position = a_position;                                \OplusGLSurfaceView_11    v_texture_coord = (mvp_matrix * a_texture_coord).xy;     \OplusGLSurfaceView_11}                                                            \OplusGLSurfaceView_11"), m13871a(35632, "#version 300 es                                                      \OplusGLSurfaceView_11#extension GL_OES_EGL_image_external_essl3 : require         \nprecision mediump float;                                     \nuniform sampler2D uTextureSampler2D;                         \nin vec2 v_texture_coord;                                     \nlayout(location = 0) out vec4 out_color;                     \nvoid main()                                                  \OplusGLSurfaceView_11{                                                            \OplusGLSurfaceView_11    out_color = texture(uTextureSampler2D, v_texture_coord); \OplusGLSurfaceView_11}                                                            \OplusGLSurfaceView_11"));
        this.f13921c = GLES32.glGetUniformLocation(this.f13919a, "mvp_matrix");
        this.f13923e = GLES32.glGetUniformLocation(this.f13919a, "uTextureSampler");
        m13868a();
        this.f13922d = GLES32.glGetUniformLocation(this.f13920b, "mvp_matrix");
        this.f13924f = GLES32.glGetUniformLocation(this.f13920b, "uTextureSampler2D");
        m13868a();
    }

    @Override // com.oplus.camera.p146gl.p148b.IOesDrawer
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo13876a(int OplusGLSurfaceView_13, int i2, Size size, Size size2, int i3, boolean z, boolean z2, SubSurfacePositionContainer c2751h, RawTexture c2768s) {
        return m13897b(OplusGLSurfaceView_13, i2, size, size2, i3, z, z2, c2751h, c2768s);
    }

    @Override // com.oplus.camera.p146gl.p148b.IOesDrawer
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo13878b() {
        GLES20.glDeleteProgram(this.f13919a);
        this.f13919a = 0;
        this.f13920b = 0;
        this.f13921c = 0;
        this.f13922d = 0;
        this.f13923e = 0;
        this.f13924f = 0;
        int[] iArr = this.f13949j;
        if (iArr[0] > 0) {
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            this.f13949j[0] = 0;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m13897b(int OplusGLSurfaceView_13, int i2, Size size, Size size2, int i3, boolean z, boolean z2, SubSurfacePositionContainer c2751h, RawTexture c2768s) {
        FloatBuffer floatBufferA = m13872a(f13946k);
        if (!this.f13948i) {
            CameraLog.m12959b("SqureOesDrawer", "multiDrawPreview, createFrameBuffer, subOneCameraTex: " + OplusGLSurfaceView_13 + ", mainOneCameraTex: " + i2 + ", multiVideoType: " + i3 + ", mainOneCameraFirstDraw: " + z + ", isDrawTexture2D: " + z2 + ", DrawMainImageWidth: " + c2751h.m13911f() + ", DrawMainImageHeight: " + c2751h.m13913g() + ", DrawSubImageWidth: " + c2751h.m13915i() + ", DrawSubImageHeight: " + c2751h.m13916j() + ", fboHeight: " + c2751h.m13917k() + ", fboWidth: " + c2751h.m13918l() + ", outRawTexture: " + c2768s + ", mainOneCameraSize: " + size2 + ", subOneCameraSize: " + size);
            int[] iArr = this.f13949j;
            if (iArr[0] > 0) {
                GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
                this.f13949j[0] = 0;
            }
            m13869a(this.f13949j, new int[]{c2768s.m13934e()}, c2751h.m13918l(), c2751h.m13917k());
            this.f13948i = true;
        }
        GLES20.glBindFramebuffer(36160, this.f13949j[0]);
        GLES32.glActiveTexture(33984);
        if (z) {
            GLES32.glViewport(0, 0, c2751h.m13911f(), c2751h.m13913g());
            GLES20.glBindBuffer(34962, 0);
            GLES32.glUseProgram(this.f13919a);
            GLES32.glBindTexture(36197, i2);
            GLES32.glUniform1i(this.f13923e, 0);
            GLES32.glUniformMatrix4fv(this.f13921c, 1, false, this.f13925g, 0);
            m13868a();
        } else {
            GLES32.glViewport(0, 0, c2751h.m13915i(), c2751h.m13916j());
            GLES20.glBindBuffer(34962, 0);
            if (z2) {
                GLES32.glUseProgram(this.f13920b);
                GLES32.glBindTexture(3553, OplusGLSurfaceView_13);
                GLES32.glUniform1i(this.f13924f, 0);
                GLES32.glUniformMatrix4fv(this.f13922d, 1, false, this.f13926h, 0);
                m13868a();
            } else {
                GLES32.glUseProgram(this.f13919a);
                GLES32.glBindTexture(36197, OplusGLSurfaceView_13);
                GLES32.glUniform1i(this.f13923e, 0);
                GLES32.glUniformMatrix4fv(this.f13921c, 1, false, this.f13926h, 0);
                m13868a();
            }
        }
        m13895a(floatBufferA, 16, i3, true);
        m13896a(c2751h, i3, z);
        if (z) {
            if (z2) {
                GLES32.glUseProgram(this.f13920b);
                GLES32.glBindTexture(3553, OplusGLSurfaceView_13);
                GLES32.glUniform1i(this.f13924f, 0);
                GLES32.glUniformMatrix4fv(this.f13922d, 1, false, this.f13926h, 0);
                m13868a();
            } else {
                GLES32.glUseProgram(this.f13919a);
                GLES32.glBindTexture(36197, OplusGLSurfaceView_13);
                GLES32.glUniform1i(this.f13923e, 0);
                GLES32.glUniformMatrix4fv(this.f13921c, 1, false, this.f13926h, 0);
                m13868a();
            }
            GLES32.glUniformMatrix4fv(this.f13921c, 1, false, this.f13926h, 0);
        } else {
            GLES32.glUseProgram(this.f13919a);
            GLES32.glBindTexture(36197, i2);
            GLES32.glUniform1i(this.f13923e, 0);
            GLES32.glUniformMatrix4fv(this.f13921c, 1, false, this.f13925g, 0);
            m13868a();
        }
        m13895a(floatBufferA, 16, i3, false);
        GLES32.glUseProgram(0);
        GLES20.glBindFramebuffer(36160, 0);
        m13868a();
        return c2768s.m13934e();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m13895a(java.nio.FloatBuffer r9, int r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = 1
            if (r0 != r11) goto Lb
            if (r12 != 0) goto Lb
            r9 = 200(0xc8, float:2.8E-43)
            java.nio.FloatBuffer r9 = r8.m13894a(r9)
        Lb:
            r8 = 0
            r9.position(r8)
            r1 = 0
            r2 = 2
            r3 = 5126(0x1406, float:7.183E-42)
            r4 = 0
            r5 = r10
            r6 = r9
            android.opengl.GLES32.glVertexAttribPointer(r1, r2, r3, r4, r5, r6)
            r7 = 2
            r9.position(r7)
            r1 = 1
            android.opengl.GLES32.glVertexAttribPointer(r1, r2, r3, r4, r5, r6)
            android.opengl.GLES32.glEnableVertexAttribArray(r8)
            android.opengl.GLES32.glEnableVertexAttribArray(r0)
            r9 = 4
            r10 = 5
            if (r11 == 0) goto L3d
            if (r11 == r0) goto L30
            if (r11 == r7) goto L3d
            goto L40
        L30:
            if (r12 == 0) goto L36
            android.opengl.GLES32.glDrawArrays(r10, r8, r9)
            goto L40
        L36:
            r9 = 6
            r10 = 202(0xca, float:2.83E-43)
            android.opengl.GLES32.glDrawArrays(r9, r8, r10)
            goto L40
        L3d:
            android.opengl.GLES32.glDrawArrays(r10, r8, r9)
        L40:
            android.opengl.GLES32.glDisableVertexAttribArray(r8)
            android.opengl.GLES32.glDisableVertexAttribArray(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p146gl.p148b.SqureOesDrawer.m13895a(java.nio.FloatBuffer, int, int, boolean):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13896a(SubSurfacePositionContainer c2751h, int OplusGLSurfaceView_13, boolean z) {
        int iM13905c;
        int iM13911f = c2751h.m13911f();
        int iM13913g = c2751h.m13913g();
        int iM13915i = c2751h.m13915i();
        int iM13916j = c2751h.m13916j();
        if (OplusGLSurfaceView_13 == 0) {
            GLES32.glViewport(0, iM13913g, iM13911f, iM13913g);
            return;
        }
        if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) {
            if (!z) {
                iM13915i = iM13911f;
                iM13911f = iM13915i;
                iM13916j = iM13913g;
                iM13913g = iM13916j;
            }
            if (-1 == c2751h.m13907d() || -1 == c2751h.m13909e()) {
                GLES32.glViewport(iM13911f - iM13915i, iM13913g - iM13916j, iM13915i, iM13916j);
                return;
            }
            int iM13907d = c2751h.m13907d();
            if (Util.m24495t()) {
                iM13905c = (iM13913g - c2751h.m13909e()) - iM13916j;
            } else {
                iM13905c = ((-c2751h.m13909e()) - iM13916j) + iM13913g + c2751h.m13905c();
            }
            GLES32.glViewport(iM13907d, iM13905c, iM13915i, iM13916j);
        }
    }

    @Override // com.oplus.camera.p146gl.p148b.IOesDrawer
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo13877a(boolean z) {
        this.f13948i = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private FloatBuffer m13894a(int OplusGLSurfaceView_13) {
        float[] fArr = new float[(OplusGLSurfaceView_13 * 4) + 8];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.5f;
        fArr[3] = 0.5f;
        for (int i2 = 0; i2 <= OplusGLSurfaceView_13; i2++) {
            double IntrinsicsJvm.kt_5 = ((i2 * 3.141592653589793d) * 2.0d) / OplusGLSurfaceView_13;
            float fCos = (float) Math.cos(IntrinsicsJvm.kt_5);
            float fSin = (float) Math.sin(IntrinsicsJvm.kt_5);
            int i3 = i2 * 4;
            fArr[i3 + 4] = fCos;
            fArr[i3 + 5] = fSin;
            fArr[i3 + 6] = (fCos * 0.5f) + 0.5f;
            fArr[i3 + 7] = (fSin * 0.5f) + 0.5f;
        }
        return m13872a(fArr);
    }
}
