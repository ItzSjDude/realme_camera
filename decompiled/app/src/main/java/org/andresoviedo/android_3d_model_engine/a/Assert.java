package org.andresoviedo.android_3d_model_engine.a_renamed;

/* compiled from: GLES20Renderer.java */
/* loaded from: classes2.dex */
class a_renamed implements org.andresoviedo.android_3d_model_engine.a_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final float[] f7961a = {1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final float[] f7962b = {1.0f, 1.0f, 1.0f, 1.0f};
    private static java.util.Map<java.lang.Object, java.lang.Object> k_renamed = new java.util.HashMap();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.lang.String f7963c;
    private final java.util.Set<java.lang.String> d_renamed;
    private final int e_renamed;
    private long f_renamed = -1;
    private double g_renamed = -1.0d;
    private boolean h_renamed = true;
    private java.util.Map<java.lang.Object, java.lang.Integer> i_renamed = new java.util.HashMap();
    private final android.util.SparseArray<java.lang.String> j_renamed = new android.util.SparseArray<>();

    private void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.a_renamed aVar) {
    }

    static org.andresoviedo.android_3d_model_engine.a_renamed.a_renamed a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.HashSet hashSet = new java.util.HashSet();
        a_renamed(hashSet, str2, "u_MMatrix");
        a_renamed(hashSet, str2, "a_Position");
        a_renamed(hashSet, str2, "a_Normal");
        a_renamed(hashSet, str2, "a_Color");
        a_renamed(hashSet, str2, "a_TexCoordinate");
        a_renamed(hashSet, str2, "u_LightPos");
        a_renamed(hashSet, str2, "in_jointIndices");
        a_renamed(hashSet, str2, "in_weights");
        a_renamed(hashSet, str3, "u_TextureCube");
        return new org.andresoviedo.android_3d_model_engine.a_renamed.a_renamed(str, str2, str3, hashSet);
    }

    private static void a_renamed(java.util.Set<java.lang.String> set, java.lang.String str, java.lang.String str2) {
        if (str.contains(str2)) {
            set.add(str2);
        }
    }

    private a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Set<java.lang.String> set) {
        this.f7963c = str;
        this.d_renamed = set;
        android.util.Log.i_renamed("GLES20Renderer", "Compiling 3D Drawer... " + str);
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        int iA = org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed(35633, str2);
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        this.e_renamed = org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed(iA, org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed(35632, str3), (java.lang.String[]) set.toArray(new java.lang.String[0]));
        k_renamed.clear();
        android.util.Log.d_renamed("GLES20Renderer", "Compiled 3D Drawer (" + str + ") with id_renamed " + this.e_renamed);
    }

    @Override // org.andresoviedo.android_3d_model_engine.a_renamed.b_renamed
    public void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar, float[] fArr, float[] fArr2, int i_renamed, float[] fArr3, float[] fArr4) {
        a_renamed(gVar, fArr, fArr2, gVar.o_renamed(), gVar.p_renamed(), i_renamed, fArr3, null, fArr4);
    }

    @Override // org.andresoviedo.android_3d_model_engine.a_renamed.b_renamed
    public void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar, float[] fArr, float[] fArr2, int i_renamed, float[] fArr3, float[] fArr4, float[] fArr5) {
        a_renamed(gVar, fArr, fArr2, gVar.o_renamed(), gVar.p_renamed(), i_renamed, fArr3, fArr4, fArr5);
    }

    @Override // org.andresoviedo.android_3d_model_engine.a_renamed.b_renamed
    public void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar, float[] fArr, float[] fArr2, int i_renamed, int i2, int i3, float[] fArr3, float[] fArr4, float[] fArr5) {
        int iA;
        int iA2;
        int i4;
        int i5;
        int i6;
        if (this.f7963c != k_renamed.get(gVar.g_renamed())) {
            android.util.Log.d_renamed("GLES20Renderer", "Rendering with shader: " + this.f7963c + "vert... obj: " + gVar);
            k_renamed.put(gVar.g_renamed(), this.f7963c);
        }
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.o_renamed(this.e_renamed);
        if (org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glUseProgram")) {
            return;
        }
        float[] fArrC = gVar.C_renamed();
        if (a_renamed()) {
            c_renamed(gVar.C_renamed(), "u_MMatrix");
        }
        c_renamed(fArr2, "u_VMatrix");
        c_renamed(fArr, "u_PMatrix");
        float[] fArr6 = new float[16];
        float[] fArr7 = new float[16];
        android.opengl.Matrix.multiplyMM(fArr7, 0, fArr2, 0, fArrC, 0);
        android.opengl.Matrix.multiplyMM(fArr6, 0, fArr, 0, fArr7, 0);
        c_renamed(fArr6, "u_MVPMatrix");
        int iA3 = a_renamed("a_Position", gVar.G_renamed(), 3);
        int iA4 = -1;
        int iA5 = d_renamed() ? a_renamed("a_Normal", gVar.H_renamed(), 3) : -1;
        if (c_renamed()) {
            iA = a_renamed("a_Color", gVar.K_renamed(), 4);
        } else {
            b_renamed(gVar.n_renamed() != null ? gVar.n_renamed() : f7961a, "vColor");
            iA = -1;
        }
        if (gVar.f7982a) {
            a_renamed(gVar);
        }
        b_renamed(fArr4 != null ? fArr4 : f7962b, "vColorMask");
        if (i3 == -1 || !f_renamed()) {
            iA2 = -1;
        } else {
            b_renamed(i3);
            iA2 = a_renamed("a_TexCoordinate", gVar.I_renamed(), 2);
        }
        if (i3 != -1 && b_renamed()) {
            c_renamed(i3);
        }
        if (fArr3 != null && e_renamed()) {
            a_renamed(fArr3, "u_LightPos");
            a_renamed(fArr5, "u_cameraPos");
        }
        if (g_renamed() && (gVar instanceof org.andresoviedo.android_3d_model_engine.b_renamed.a_renamed)) {
            org.andresoviedo.android_3d_model_engine.b_renamed.a_renamed aVar = (org.andresoviedo.android_3d_model_engine.b_renamed.a_renamed) gVar;
            iA4 = a_renamed("in_weights", aVar.c_renamed(), 3);
            int iA6 = a_renamed("in_jointIndices", aVar.b_renamed(), 3);
            c_renamed(aVar.a_renamed(), "u_BindShapeMatrix");
            a_renamed(aVar);
            i4 = i_renamed;
            i6 = iA6;
            i5 = i2;
        } else {
            i4 = i_renamed;
            i5 = i2;
            i6 = -1;
        }
        a_renamed(gVar, i4, i5);
        a_renamed(iA3);
        a_renamed(iA);
        a_renamed(iA5);
        a_renamed(iA2);
        a_renamed(iA4);
        a_renamed(i6);
    }

    private int a_renamed(java.lang.String str, java.nio.FloatBuffer floatBuffer, int i_renamed) {
        int iA = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(this.e_renamed, str);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glGetAttribLocation");
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.j_renamed(iA);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glEnableVertexAttribArray");
        floatBuffer.position(0);
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar.a_renamed(iA, i_renamed, 5126, false, 0, floatBuffer);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glVertexAttribPointer");
        return iA;
    }

    private void a_renamed(float[] fArr, java.lang.String str) {
        int iB = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed(this.e_renamed, str);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glGetUniformLocation");
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(iB, 1, fArr, 0);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glUniform3fv");
    }

    private void b_renamed(float[] fArr, java.lang.String str) {
        int iB = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed(this.e_renamed, str);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glGetUniformLocation");
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed(iB, 1, fArr, 0);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glUniform4fv");
    }

    private void c_renamed(float[] fArr, java.lang.String str) {
        int iB = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed(this.e_renamed, str);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glGetUniformLocation");
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(iB, 1, false, fArr, 0);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glUniformMatrix4fv");
    }

    private void a_renamed(int i_renamed) {
        if (i_renamed != -1) {
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.h_renamed(i_renamed);
            org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glDisableVertexAttribArray");
        }
    }

    private boolean a_renamed() {
        return this.d_renamed.contains("u_MMatrix");
    }

    private boolean b_renamed() {
        return this.d_renamed.contains("u_TextureCube");
    }

    private boolean c_renamed() {
        return this.d_renamed.contains("a_Color");
    }

    private boolean d_renamed() {
        return this.d_renamed.contains("a_Normal");
    }

    private boolean e_renamed() {
        return this.d_renamed.contains("u_LightPos");
    }

    private boolean f_renamed() {
        return this.d_renamed.contains("a_TexCoordinate");
    }

    private void b_renamed(int i_renamed) {
        int iB = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed(this.e_renamed, "u_Texture");
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glGetUniformLocation");
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar.a_renamed(33984);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glActiveTexture");
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar3 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar4 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar3.b_renamed(3553, i_renamed);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glBindTexture");
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar5 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar6 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar7 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar8 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar5.b_renamed(3553, 10241, 9729);
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar9 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar10 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar11 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar12 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar9.b_renamed(3553, 10240, 9729);
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar13 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar14 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar15 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar16 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar13.b_renamed(3553, 10242, 33071);
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar17 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar18 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar19 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar20 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar17.b_renamed(3553, 10243, 33071);
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.d_renamed(iB, 0);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glUniform1i");
    }

    private void c_renamed(int i_renamed) {
        int iB = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed(this.e_renamed, "u_TextureCube");
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glGetUniformLocation");
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar.a_renamed(33984);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glActiveTexture");
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar3 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar4 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar3.b_renamed(34067, i_renamed);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glBindTexture");
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.d_renamed(iB, 0);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glUniform1i");
    }

    private boolean g_renamed() {
        return this.d_renamed.contains("in_jointIndices") && this.d_renamed.contains("in_weights");
    }

    private void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar, int i_renamed, int i2) {
        java.nio.FloatBuffer floatBufferG;
        java.nio.Buffer bufferE;
        int i3;
        if (gVar.i_renamed()) {
            bufferE = null;
            floatBufferG = gVar.G_renamed();
            i3 = -1;
        } else {
            floatBufferG = gVar.G_renamed();
            if (this.h_renamed) {
                bufferE = gVar.D_renamed();
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                i3 = 5125;
            } else {
                bufferE = gVar.E_renamed();
                org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
                i3 = 5123;
            }
        }
        java.nio.Buffer buffer = bufferE;
        int i4 = i3;
        floatBufferG.position(0);
        java.util.List<int[]> listJ = gVar.J_renamed();
        if (listJ != null) {
            if (gVar.i_renamed()) {
                a_renamed(i_renamed, listJ);
                return;
            } else {
                a_renamed(buffer, i4, listJ);
                return;
            }
        }
        if (gVar.i_renamed()) {
            a_renamed(i_renamed, i2, floatBufferG.capacity() / 3);
        } else {
            a_renamed(gVar, i_renamed, i2, buffer, i4);
        }
    }

    private void a_renamed(int i_renamed, int i2, int i3) {
        int i4 = 0;
        if (i2 > 0) {
            while (i4 < i3) {
                org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(i_renamed, i4, i2);
                org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glDrawArrays");
                i4 += i2;
            }
            return;
        }
        if (this.g_renamed >= 0.0d) {
            double dUptimeMillis = ((android.os.SystemClock.uptimeMillis() % 10000) / 10000.0f) * 6.283185307179586d;
            if (this.g_renamed == 0.0d) {
                this.g_renamed = dUptimeMillis;
            }
            i3 = (int) (((java.lang.Math.sin((dUptimeMillis - this.g_renamed) + 4.71238898038469d) + 1.0d) / 2.0d) * i3);
        }
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(i_renamed, 0, i3);
        org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glDrawArrays");
    }

    private void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar, int i_renamed, int i2, java.nio.Buffer buffer, int i3) {
        float[] fArrN;
        if (i2 <= 0) {
            if (this.f7963c != k_renamed.get(gVar.N_renamed())) {
                android.util.Log.i_renamed("GLES20Renderer", "Rendering elements... obj: " + gVar.g_renamed() + ", total:" + gVar.N_renamed().size());
                k_renamed.put(gVar.N_renamed(), this.f7963c);
            }
            for (int i4 = 0; i4 < gVar.N_renamed().size(); i4++) {
                org.andresoviedo.android_3d_model_engine.b_renamed.e_renamed eVar = gVar.N_renamed().get(i4);
                java.nio.IntBuffer intBufferA = eVar.a_renamed();
                if (this.f7963c != k_renamed.get(eVar)) {
                    android.util.Log.v_renamed("GLES20Renderer", "Rendering element " + i4 + "....  " + eVar);
                }
                if (eVar.b_renamed() != null) {
                    if (!c_renamed()) {
                        if (eVar.b_renamed().c_renamed() != null) {
                            fArrN = eVar.b_renamed().c_renamed();
                        } else {
                            fArrN = gVar.n_renamed() != null ? gVar.n_renamed() : f7961a;
                        }
                        b_renamed(fArrN, "vColor");
                    }
                    if (eVar.b_renamed().b_renamed() != -1 && f_renamed()) {
                        b_renamed(eVar.b_renamed().b_renamed());
                    }
                }
                intBufferA.position(0);
                org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(i_renamed, intBufferA.capacity(), i3, intBufferA);
                org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glDrawElements");
                if (this.h_renamed && org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glDrawElements")) {
                    this.h_renamed = false;
                }
                if (this.f7963c != k_renamed.get(eVar)) {
                    android.util.Log.v_renamed("GLES20Renderer", "Rendering element " + i4 + " finished");
                    k_renamed.put(eVar, this.f7963c);
                }
            }
            return;
        }
        int i5 = 0;
        while (i5 < buffer.capacity()) {
            buffer.position(i5);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(i_renamed, i2, i3, buffer);
            org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glDrawElements");
            i5 += i2;
        }
        if (this.h_renamed && org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glDrawElements")) {
            this.h_renamed = false;
        }
    }

    private void a_renamed(java.nio.Buffer buffer, int i_renamed, java.util.List<int[]> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            int[] iArr = list.get(i2);
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = iArr[2];
            buffer.position(i4);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(i3, i5, i_renamed, buffer);
            org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glDrawElements");
            if (this.h_renamed && org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glDrawElements")) {
                this.h_renamed = false;
            }
        }
    }

    private void a_renamed(int i_renamed, java.util.List<int[]> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            int[] iArr = list.get(i2);
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = iArr[2];
            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
            if (i_renamed == 2 && iArr[2] > 3) {
                for (int i6 = 0; i6 < iArr[2] - 2; i6++) {
                    org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(i_renamed, iArr[1] + i6, 3);
                    org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glDrawArrays");
                }
            } else {
                org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(i_renamed, iArr[1], iArr[2]);
                org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed("glDrawArrays");
            }
        }
    }

    private void a_renamed(org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed gVar) {
        int iA = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(this.e_renamed, "a_Layer");
        a_renamed("glGetAttribLocation");
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.j_renamed(iA);
        a_renamed("glEnableVertexAttribArray");
        gVar.F_renamed().position(0);
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar.a_renamed(iA, 1, 5126, false, 0, gVar.F_renamed());
        a_renamed("glVertexAttribPointer");
    }

    private boolean a_renamed(java.lang.String str) {
        return org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed(str);
    }

    public java.lang.String toString() {
        return "GLES20Renderer{id_renamed='" + this.f7963c + "', features=" + this.d_renamed + '}';
    }
}
