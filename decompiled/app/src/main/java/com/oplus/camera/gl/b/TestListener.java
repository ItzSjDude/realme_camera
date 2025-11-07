package com.oplus.camera.gl_renamed.b_renamed;

/* compiled from: SqureOesDrawer.java */
/* loaded from: classes2.dex */
public class g_renamed extends com.oplus.camera.gl_renamed.b_renamed.a_renamed implements com.oplus.camera.gl_renamed.b_renamed.d_renamed {
    private static final float[] k_renamed = {-1.0f, 1.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 0.0f};
    private static final float[] l_renamed = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private boolean i_renamed = false;
    private int[] j_renamed = new int[1];

    @Override // com.oplus.camera.gl_renamed.b_renamed.d_renamed
    public void e__renamed() {
        this.f4599a = a_renamed(a_renamed(35633, "#version 300 es_renamed                                                      \nuniform mat4 mvp_matrix;                                     \nlayout(location = 0) in_renamed vec4 a_position;                     \nlayout(location = 1) in_renamed vec4 a_texture_coord;                \nout vec2 v_texture_coord;                                    \nvoid main()                                                  \n_renamed{                                                            \n_renamed    gl_Position = a_position;                                \n_renamed    v_texture_coord = (mvp_matrix * a_texture_coord).xy;     \n_renamed}                                                            \n_renamed"), a_renamed(35632, "#version 300 es_renamed                                                      \n_renamed#extension GL_OES_EGL_image_external_essl3 : require         \nprecision mediump float;                                     \nuniform samplerExternalOES uTextureSampler;                  \nuniform sampler2D uTextureSampler2D;                         \nuniform int uCameraId;                                       \nin vec2 v_texture_coord;                                     \nlayout(location = 0) out vec4 out_color;                     \nvoid main()                                                  \n_renamed{                                                            \n_renamed    out_color = texture(uTextureSampler, v_texture_coord);   \n_renamed}                                                            \n_renamed"));
        this.f4600b = a_renamed(a_renamed(35633, "#version 300 es_renamed                                                      \nuniform mat4 mvp_matrix;                                     \nlayout(location = 0) in_renamed vec4 a_position;                     \nlayout(location = 1) in_renamed vec4 a_texture_coord;                \nout vec2 v_texture_coord;                                    \nvoid main()                                                  \n_renamed{                                                            \n_renamed    gl_Position = a_position;                                \n_renamed    v_texture_coord = (mvp_matrix * a_texture_coord).xy;     \n_renamed}                                                            \n_renamed"), a_renamed(35632, "#version 300 es_renamed                                                      \n_renamed#extension GL_OES_EGL_image_external_essl3 : require         \nprecision mediump float;                                     \nuniform sampler2D uTextureSampler2D;                         \nin vec2 v_texture_coord;                                     \nlayout(location = 0) out vec4 out_color;                     \nvoid main()                                                  \n_renamed{                                                            \n_renamed    out_color = texture(uTextureSampler2D, v_texture_coord); \n_renamed}                                                            \n_renamed"));
        this.f4601c = android.opengl.GLES32.glGetUniformLocation(this.f4599a, "mvp_matrix");
        this.e_renamed = android.opengl.GLES32.glGetUniformLocation(this.f4599a, "uTextureSampler");
        a_renamed();
        this.d_renamed = android.opengl.GLES32.glGetUniformLocation(this.f4600b, "mvp_matrix");
        this.f_renamed = android.opengl.GLES32.glGetUniformLocation(this.f4600b, "uTextureSampler2D");
        a_renamed();
    }

    @Override // com.oplus.camera.gl_renamed.b_renamed.d_renamed
    public int a_renamed(int i_renamed, int i2, android.util.Size size, android.util.Size size2, int i3, boolean z_renamed, boolean z2, com.oplus.camera.gl_renamed.b_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.s_renamed sVar) {
        return b_renamed(i_renamed, i2, size, size2, i3, z_renamed, z2, hVar, sVar);
    }

    @Override // com.oplus.camera.gl_renamed.b_renamed.d_renamed
    public void b_renamed() {
        android.opengl.GLES20.glDeleteProgram(this.f4599a);
        this.f4599a = 0;
        this.f4600b = 0;
        this.f4601c = 0;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 0;
        int[] iArr = this.j_renamed;
        if (iArr[0] > 0) {
            android.opengl.GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            this.j_renamed[0] = 0;
        }
    }

    public int b_renamed(int i_renamed, int i2, android.util.Size size, android.util.Size size2, int i3, boolean z_renamed, boolean z2, com.oplus.camera.gl_renamed.b_renamed.h_renamed hVar, com.oplus.camera.gl_renamed.s_renamed sVar) {
        java.nio.FloatBuffer floatBufferA = a_renamed(k_renamed);
        if (!this.i_renamed) {
            com.oplus.camera.e_renamed.b_renamed("SqureOesDrawer", "multiDrawPreview, createFrameBuffer, subOneCameraTex: " + i_renamed + ", mainOneCameraTex: " + i2 + ", multiVideoType: " + i3 + ", mainOneCameraFirstDraw: " + z_renamed + ", isDrawTexture2D: " + z2 + ", DrawMainImageWidth: " + hVar.f_renamed() + ", DrawMainImageHeight: " + hVar.g_renamed() + ", DrawSubImageWidth: " + hVar.i_renamed() + ", DrawSubImageHeight: " + hVar.j_renamed() + ", fboHeight: " + hVar.k_renamed() + ", fboWidth: " + hVar.l_renamed() + ", outRawTexture: " + sVar + ", mainOneCameraSize: " + size2 + ", subOneCameraSize: " + size);
            int[] iArr = this.j_renamed;
            if (iArr[0] > 0) {
                android.opengl.GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
                this.j_renamed[0] = 0;
            }
            a_renamed(this.j_renamed, new int[]{sVar.e_renamed()}, hVar.l_renamed(), hVar.k_renamed());
            this.i_renamed = true;
        }
        android.opengl.GLES20.glBindFramebuffer(36160, this.j_renamed[0]);
        android.opengl.GLES32.glActiveTexture(33984);
        if (z_renamed) {
            android.opengl.GLES32.glViewport(0, 0, hVar.f_renamed(), hVar.g_renamed());
            android.opengl.GLES20.glBindBuffer(34962, 0);
            android.opengl.GLES32.glUseProgram(this.f4599a);
            android.opengl.GLES32.glBindTexture(36197, i2);
            android.opengl.GLES32.glUniform1i(this.e_renamed, 0);
            android.opengl.GLES32.glUniformMatrix4fv(this.f4601c, 1, false, this.g_renamed, 0);
            a_renamed();
        } else {
            android.opengl.GLES32.glViewport(0, 0, hVar.i_renamed(), hVar.j_renamed());
            android.opengl.GLES20.glBindBuffer(34962, 0);
            if (z2) {
                android.opengl.GLES32.glUseProgram(this.f4600b);
                android.opengl.GLES32.glBindTexture(3553, i_renamed);
                android.opengl.GLES32.glUniform1i(this.f_renamed, 0);
                android.opengl.GLES32.glUniformMatrix4fv(this.d_renamed, 1, false, this.h_renamed, 0);
                a_renamed();
            } else {
                android.opengl.GLES32.glUseProgram(this.f4599a);
                android.opengl.GLES32.glBindTexture(36197, i_renamed);
                android.opengl.GLES32.glUniform1i(this.e_renamed, 0);
                android.opengl.GLES32.glUniformMatrix4fv(this.f4601c, 1, false, this.h_renamed, 0);
                a_renamed();
            }
        }
        a_renamed(floatBufferA, 16, i3, true);
        a_renamed(hVar, i3, z_renamed);
        if (z_renamed) {
            if (z2) {
                android.opengl.GLES32.glUseProgram(this.f4600b);
                android.opengl.GLES32.glBindTexture(3553, i_renamed);
                android.opengl.GLES32.glUniform1i(this.f_renamed, 0);
                android.opengl.GLES32.glUniformMatrix4fv(this.d_renamed, 1, false, this.h_renamed, 0);
                a_renamed();
            } else {
                android.opengl.GLES32.glUseProgram(this.f4599a);
                android.opengl.GLES32.glBindTexture(36197, i_renamed);
                android.opengl.GLES32.glUniform1i(this.e_renamed, 0);
                android.opengl.GLES32.glUniformMatrix4fv(this.f4601c, 1, false, this.h_renamed, 0);
                a_renamed();
            }
            android.opengl.GLES32.glUniformMatrix4fv(this.f4601c, 1, false, this.h_renamed, 0);
        } else {
            android.opengl.GLES32.glUseProgram(this.f4599a);
            android.opengl.GLES32.glBindTexture(36197, i2);
            android.opengl.GLES32.glUniform1i(this.e_renamed, 0);
            android.opengl.GLES32.glUniformMatrix4fv(this.f4601c, 1, false, this.g_renamed, 0);
            a_renamed();
        }
        a_renamed(floatBufferA, 16, i3, false);
        android.opengl.GLES32.glUseProgram(0);
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        a_renamed();
        return sVar.e_renamed();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:14:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(java.nio.FloatBuffer r9, int r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = 1
            if (r0 != r11) goto Lb
            if (r12 != 0) goto Lb
            r9 = 200(0xc8, float:2.8E-43)
            java.nio.FloatBuffer r9 = r8.a_renamed(r9)
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.gl_renamed.b_renamed.g_renamed.a_renamed(java.nio.FloatBuffer, int, int, boolean):void");
    }

    public void a_renamed(com.oplus.camera.gl_renamed.b_renamed.h_renamed hVar, int i_renamed, boolean z_renamed) {
        int iC;
        int iF = hVar.f_renamed();
        int iG = hVar.g_renamed();
        int i2 = hVar.i_renamed();
        int iJ = hVar.j_renamed();
        if (i_renamed == 0) {
            android.opengl.GLES32.glViewport(0, iG, iF, iG);
            return;
        }
        if (i_renamed == 1 || i_renamed == 2) {
            if (!z_renamed) {
                i2 = iF;
                iF = i2;
                iJ = iG;
                iG = iJ;
            }
            if (-1 == hVar.d_renamed() || -1 == hVar.e_renamed()) {
                android.opengl.GLES32.glViewport(iF - i2, iG - iJ, i2, iJ);
                return;
            }
            int iD = hVar.d_renamed();
            if (com.oplus.camera.util.Util.t_renamed()) {
                iC = (iG - hVar.e_renamed()) - iJ;
            } else {
                iC = ((-hVar.e_renamed()) - iJ) + iG + hVar.c_renamed();
            }
            android.opengl.GLES32.glViewport(iD, iC, i2, iJ);
        }
    }

    @Override // com.oplus.camera.gl_renamed.b_renamed.d_renamed
    public void a_renamed(boolean z_renamed) {
        this.i_renamed = z_renamed;
    }

    private java.nio.FloatBuffer a_renamed(int i_renamed) {
        float[] fArr = new float[(i_renamed * 4) + 8];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.5f;
        fArr[3] = 0.5f;
        for (int i2 = 0; i2 <= i_renamed; i2++) {
            double d_renamed = ((i2 * 3.141592653589793d) * 2.0d) / i_renamed;
            float fCos = (float) java.lang.Math.cos(d_renamed);
            float fSin = (float) java.lang.Math.sin(d_renamed);
            int i3 = i2 * 4;
            fArr[i3 + 4] = fCos;
            fArr[i3 + 5] = fSin;
            fArr[i3 + 6] = (fCos * 0.5f) + 0.5f;
            fArr[i3 + 7] = (fSin * 0.5f) + 0.5f;
        }
        return a_renamed(fArr);
    }
}
