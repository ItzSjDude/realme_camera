package a_renamed.a_renamed.b_renamed.b_renamed.a_renamed;

/* loaded from: classes.dex */
public abstract class a_renamed {
    public static final int KEY_IN = 258;
    public static final int KEY_INDEX = 513;
    public static final int KEY_OUT = 257;
    public static final java.lang.String fragmentHeader = "precision highp float;\n_renamed";
    public static final float[] m_renamed = a_renamed.a_renamed.b_renamed.f_renamed.r_renamed.a_renamed();
    public static final java.lang.String needReplaceHeader = "#extension GL_OES_standard_derivatives : enable";
    public static final java.lang.String vertexHeader = "uniform mat4 u_ModelViewProjectionMatrix;\nattribute vec4 a_Vertex;\nattribute vec4 a_TexCoord;\nattribute vec4 a_Distortion;\nattribute vec4 a_Delta;\n_renamed";

    /* renamed from: a_renamed, reason: collision with root package name */
    public co_renamed.polarr.renderer.entities.Context f15a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f16b;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f17c;
    public int d_renamed;
    public int e_renamed;
    public int f_renamed;
    public int g_renamed;
    public int h_renamed;
    public android.content.res.Resources i_renamed;
    public float[] j_renamed = java.util.Arrays.copyOf(m_renamed, 16);
    public int k_renamed = 0;
    public int l_renamed = 0;

    public a_renamed(co_renamed.polarr.renderer.entities.Context context, android.content.res.Resources resources) {
        this.i_renamed = resources;
        this.f15a = context;
        d_renamed();
    }

    public static int a_renamed(int i_renamed, java.lang.String str) {
        int iGlCreateShader = android.opengl.GLES20.glCreateShader(i_renamed);
        if (iGlCreateShader == 0) {
            return iGlCreateShader;
        }
        android.opengl.GLES20.glShaderSource(iGlCreateShader, str);
        android.opengl.GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        a_renamed(1, (java.lang.Object) ("Could not compile shader:" + i_renamed));
        a_renamed(1, (java.lang.Object) ("GLES20 Error:" + android.opengl.GLES20.glGetShaderInfoLog(iGlCreateShader)));
        android.opengl.GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static java.lang.String a_renamed(java.lang.String str) {
        return str.contains(needReplaceHeader) ? str.replace(fragmentHeader, "").replace(needReplaceHeader, "#extension GL_OES_standard_derivatives : enable\nprecision highp float;\n_renamed") : str;
    }

    public static void a_renamed(int i_renamed, java.lang.Object obj) {
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("base glError");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:14:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c_renamed(java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 35633(0x8b31, float:4.9932E-41)
            int r5 = a_renamed(r0, r5)
            r0 = 0
            if (r5 != 0) goto Lb
            return r0
        Lb:
            r1 = 35632(0x8b30, float:4.9931E-41)
            java.lang.String r6 = a_renamed(r6)
            int r6 = a_renamed(r1, r6)
            if (r6 != 0) goto L1e
            java.lang.String r5 = "hh"
            a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(r5)
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
            a_renamed(r2, r3)
            android.opengl.GLES20.glDeleteProgram(r1)
            goto L57
        L56:
            r0 = r1
        L57:
            if (r0 == 0) goto L5c
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.b_renamed(r0)
        L5c:
            android.opengl.GLES20.glDeleteShader(r5)
            android.opengl.GLES20.glDeleteShader(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed.c_renamed(java.lang.String, java.lang.String):int");
    }

    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(int i_renamed, int i2, int i3) {
        int[] iArr = {0};
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(1, iArr, 0, 6408, i_renamed, i2);
        return a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, i_renamed, i2);
    }

    public final void a_renamed() {
        g_renamed();
    }

    public final void a_renamed(int i_renamed) {
        this.l_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed, int i2) {
        android.opengl.GLES20.glActiveTexture(i2 + 33984);
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
    }

    public void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar) {
        if (dVar != null) {
            a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.a_renamed(dVar.f34a);
            dVar.f34a = 0;
        }
    }

    public void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, int i_renamed) {
        a_renamed(dVar.f34a, i_renamed);
    }

    public void a_renamed(java.lang.String str, float f_renamed) {
        android.opengl.GLES20.glUniform1f(android.opengl.GLES20.glGetUniformLocation(this.f16b, str), f_renamed);
    }

    public void a_renamed(java.lang.String str, float f_renamed, float f2) {
        android.opengl.GLES20.glUniform2f(android.opengl.GLES20.glGetUniformLocation(this.f16b, str), f_renamed, f2);
    }

    public void a_renamed(java.lang.String str, float f_renamed, float f2, float f3, float f4) {
        android.opengl.GLES20.glUniform4f(android.opengl.GLES20.glGetUniformLocation(this.f16b, str), f_renamed, f2, f3, f4);
    }

    public void a_renamed(java.lang.String str, int i_renamed) {
        android.opengl.GLES20.glUniform1i(android.opengl.GLES20.glGetUniformLocation(this.f16b, str), i_renamed);
    }

    public final void a_renamed(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        if (this.f15a.isOES && (this instanceof a_renamed.a_renamed.b_renamed.b_renamed.an_renamed) && str2 != null) {
            str2 = str2.replace("uniform sampler2D texture;", "uniform samplerExternalOES texture;");
            str3 = "#extension GL_OES_EGL_image_external : require\n_renamed";
        } else {
            str3 = "";
        }
        this.f16b = c_renamed(vertexHeader + str, str3 + fragmentHeader + str2);
        this.f17c = android.opengl.GLES20.glGetAttribLocation(this.f16b, "a_Vertex");
        this.d_renamed = android.opengl.GLES20.glGetAttribLocation(this.f16b, "a_TexCoord");
        this.e_renamed = android.opengl.GLES20.glGetAttribLocation(this.f16b, "a_Distortion");
        this.f_renamed = android.opengl.GLES20.glGetAttribLocation(this.f16b, "a_Delta");
        this.g_renamed = android.opengl.GLES20.glGetUniformLocation(this.f16b, "u_ModelViewProjectionMatrix");
        this.h_renamed = android.opengl.GLES20.glGetUniformLocation(this.f16b, "texture");
    }

    public void a_renamed(java.lang.String str, float[] fArr) {
        android.opengl.GLES20.glUniformMatrix3fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, str), 1, false, fArr, 0);
    }

    public void a_renamed(java.lang.String str, float[] fArr, int i_renamed, int i2) {
        android.opengl.GLES20.glUniform2fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, str), i2, fArr, i_renamed);
    }

    public void a_renamed(float[] fArr) {
        this.j_renamed = fArr;
    }

    public final int b_renamed() {
        return this.l_renamed;
    }

    public abstract void b_renamed(int i_renamed, int i2);

    public final void b_renamed(java.lang.String str, java.lang.String str2) {
        a_renamed(this.f15a.shaderUtil.a_renamed(this.i_renamed, str), this.f15a.shaderUtil.a_renamed(this.i_renamed, str2));
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("create program");
    }

    public void b_renamed(java.lang.String str, float[] fArr, int i_renamed, int i2) {
        android.opengl.GLES20.glUniform4fv(android.opengl.GLES20.glGetUniformLocation(this.f16b, str), i2, fArr, i_renamed);
    }

    public final int c_renamed() {
        return this.k_renamed;
    }

    public final void c_renamed(int i_renamed, int i2) {
        b_renamed(i_renamed, i2);
    }

    public void d_renamed() {
    }

    public void draw() {
        f_renamed();
        k_renamed();
        j_renamed();
        e_renamed();
        h_renamed();
    }

    public void e_renamed() {
        android.opengl.GLES20.glActiveTexture(this.k_renamed + 33984);
        android.opengl.GLES20.glBindTexture((this.f15a.isOES && (this instanceof a_renamed.a_renamed.b_renamed.b_renamed.an_renamed)) ? 36197 : 3553, b_renamed());
        android.opengl.GLES20.glUniform1i(this.h_renamed, this.k_renamed);
    }

    public void f_renamed() {
        android.opengl.GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        android.opengl.GLES20.glClear(16384);
    }

    public abstract void g_renamed();

    public float[] getMatrix() {
        return this.j_renamed;
    }

    public void h_renamed() {
        int i_renamed = this.f17c;
        if (i_renamed >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i_renamed);
            android.opengl.GLES20.glVertexAttribPointer(this.f17c, 3, 5126, false, 0, (java.nio.Buffer) this.f15a.mesh.mVerBuffer);
        }
        int i2 = this.d_renamed;
        if (i2 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i2);
            android.opengl.GLES20.glVertexAttribPointer(this.d_renamed, 2, 5126, false, 0, (java.nio.Buffer) this.f15a.mesh.mTexBuffer);
        }
        int i3 = this.e_renamed;
        if (i3 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i3);
            android.opengl.GLES20.glVertexAttribPointer(this.e_renamed, 2, 5126, false, 0, (java.nio.Buffer) this.f15a.mesh.mDistortionBuffer);
        }
        int i4 = this.f_renamed;
        if (i4 >= 0) {
            android.opengl.GLES20.glEnableVertexAttribArray(i4);
            android.opengl.GLES20.glVertexAttribPointer(this.f_renamed, 2, 5126, false, 0, (java.nio.Buffer) this.f15a.mesh.mDeltaBuffer);
        }
        android.opengl.GLES20.glDrawElements(4, this.f15a.mesh.trianglesBuffer.capacity(), 5123, this.f15a.mesh.trianglesBuffer);
        int i5 = this.f17c;
        if (i5 >= 0) {
            android.opengl.GLES20.glDisableVertexAttribArray(i5);
        }
        int i6 = this.d_renamed;
        if (i6 >= 0) {
            android.opengl.GLES20.glDisableVertexAttribArray(i6);
        }
        int i7 = this.e_renamed;
        if (i7 >= 0) {
            android.opengl.GLES20.glDisableVertexAttribArray(i7);
        }
        int i8 = this.f_renamed;
        if (i8 >= 0) {
            android.opengl.GLES20.glDisableVertexAttribArray(i8);
        }
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("draw program");
        i_renamed();
    }

    public void i_renamed() {
    }

    public void j_renamed() {
        android.opengl.GLES20.glUniformMatrix4fv(this.g_renamed, 1, false, this.j_renamed, 0);
    }

    public void k_renamed() {
        android.opengl.GLES20.glUseProgram(this.f16b);
    }
}
