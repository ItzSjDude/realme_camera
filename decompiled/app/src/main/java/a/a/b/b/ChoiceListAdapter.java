package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class v_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.util.Map<java.lang.String, java.lang.Object>, int[]> q_renamed = new android.util.LruCache<>(10);
    public static java.util.List<java.lang.String> r_renamed = new java.util.ArrayList();
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed s_renamed;
    public int[] t_renamed;
    public java.util.Map<java.lang.String, float[][]> u_renamed;
    public boolean v_renamed;

    static {
        r_renamed.add("curves_red");
        r_renamed.add("curves_green");
        r_renamed.add("curves_blue");
        r_renamed.add("curves_all");
    }

    public v_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("curves"), context);
        this.u_renamed = new java.util.HashMap();
        this.u_renamed.put("curves_red", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        this.u_renamed.put("curves_green", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        this.u_renamed.put("curves_blue", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        this.u_renamed.put("curves_all", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
    }

    public static int a_renamed(a_renamed.a_renamed.b_renamed.d_renamed.a_renamed aVar, int i_renamed, float f_renamed) {
        float fA_renamed = aVar.a_renamed(i_renamed);
        return fA_renamed == -1.0f ? (int) f_renamed : (int) java.lang.Math.round(a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(fA_renamed, 0.0d, 255.0d));
    }

    public static float[][] a_renamed(float[][] fArr) {
        float[][] fArr2 = {new float[fArr.length], new float[fArr.length]};
        int i_renamed = 0;
        for (float[] fArr3 : fArr) {
            fArr2[0][i_renamed] = fArr3[0];
            fArr2[1][i_renamed] = fArr3[1];
            i_renamed++;
        }
        return fArr2;
    }

    public static int b_renamed(int i_renamed, int i2, int i3) {
        int i4 = 0;
        int i5 = 3;
        while (i5 >= 0) {
            i4 += (i5 == i2 ? i3 & 255 : (i_renamed >> (i5 * 8)) & 255) << (i5 * 8);
            i5--;
        }
        return i4;
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed
    public void a_renamed(java.lang.String str, java.lang.Object obj) {
        this.v_renamed = true;
        synchronized (this.t_renamed) {
            a_renamed(str, (float[][]) obj, false);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    public final void a_renamed(java.lang.String str, float[][] fArr, boolean z_renamed) {
        if (z_renamed || !(this.u_renamed.get(str) == fArr || java.util.Arrays.deepEquals(this.u_renamed.get(str), fArr))) {
            this.u_renamed.put(str, fArr);
            char c2 = 65535;
            int i_renamed = 2;
            switch (str.hashCode()) {
                case -1917275032:
                    if (str.equals("curves_green")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1829931962:
                    if (str.equals("curves_all")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1829915850:
                    if (str.equals("curves_red")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -893285803:
                    if (str.equals("curves_blue")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                i_renamed = 0;
            } else if (c2 == 1) {
                i_renamed = 1;
            } else if (c2 != 2) {
                if (c2 != 3) {
                    return;
                } else {
                    i_renamed = 3;
                }
            }
            try {
                float[][] fArrA = a_renamed(fArr);
                a_renamed.a_renamed.b_renamed.d_renamed.a_renamed aVar = new a_renamed.a_renamed.b_renamed.d_renamed.a_renamed(fArrA[0], fArrA[1], null, null);
                int iA = (int) fArrA[1][0];
                for (int i2 = 0; i2 <= 255; i2++) {
                    iA = a_renamed(aVar, i2, iA);
                    this.t_renamed[i2] = b_renamed(this.t_renamed[i2], i_renamed, iA);
                }
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
            }
        }
    }

    public boolean a_renamed(java.util.Map<java.lang.String, java.lang.Object> map) {
        int[] iArr = q_renamed.get(map);
        if (iArr == null || iArr.length != this.t_renamed.length) {
            return false;
        }
        this.v_renamed = true;
        this.t_renamed = iArr;
        return true;
    }

    public void b_renamed(java.util.Map<java.lang.String, java.lang.Object> map) {
        android.util.LruCache<java.util.Map<java.lang.String, java.lang.Object>, int[]> lruCache = q_renamed;
        int[] iArr = this.t_renamed;
        lruCache.put(map, java.util.Arrays.copyOf(iArr, iArr.length));
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void g_renamed() {
        super.g_renamed();
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.c_renamed(iArr[0]);
        this.t_renamed = new int[256];
        this.s_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, 256, 1);
        android.opengl.GLES20.glBindTexture(3553, this.s_renamed.f34a);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed();
        android.opengl.GLES20.glBindTexture(3553, 0);
        this.v_renamed = true;
        for (java.lang.String str : this.u_renamed.keySet()) {
            a_renamed(str, (float[][]) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(str, this.f15a.renderStates), true);
        }
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        if (this.v_renamed) {
            synchronized (this.t_renamed) {
                java.nio.IntBuffer intBufferAsIntBuffer = java.nio.ByteBuffer.allocateDirect(this.t_renamed.length * 4).order(java.nio.ByteOrder.nativeOrder()).asIntBuffer();
                intBufferAsIntBuffer.put(this.t_renamed);
                intBufferAsIntBuffer.position(0);
                android.opengl.GLES20.glBindTexture(3553, this.s_renamed.f34a);
                android.opengl.GLES20.glPixelStorei(3317, 8);
                android.opengl.GLES20.glTexImage2D(3553, 0, this.s_renamed.d_renamed, this.s_renamed.f35b, this.s_renamed.f36c, 0, this.s_renamed.d_renamed, 5121, intBufferAsIntBuffer);
                android.opengl.GLES20.glBindTexture(3553, 0);
                android.opengl.GLES20.glPixelStorei(3317, 4);
                this.v_renamed = false;
            }
        }
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "map");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.s_renamed.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed
    public boolean l_renamed() {
        java.util.Map<java.lang.String, float[][]> map = this.u_renamed;
        if (map != null) {
            for (float[][] fArr : map.values()) {
                if (fArr.length != 2) {
                    return false;
                }
                float[] fArr2 = fArr[0];
                if (fArr2[0] == 0.0f && fArr2[1] == 0.0f) {
                    float[] fArr3 = fArr[1];
                    if (fArr3[0] != 255.0f || fArr3[1] != 255.0f) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    public void m_renamed() {
        n_renamed();
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        this.t_renamed = new int[256];
        this.s_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6408, 256, 1);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.c_renamed(iArr[0]);
        this.v_renamed = true;
        android.opengl.GLES20.glBindTexture(3553, this.s_renamed.f34a);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed();
        android.opengl.GLES20.glBindTexture(3553, 0);
        for (java.lang.String str : this.u_renamed.keySet()) {
            a_renamed(str, (float[][]) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(str, this.f15a.renderStates), true);
        }
    }

    public void n_renamed() {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = this.s_renamed;
        if (dVar != null) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.a_renamed(dVar);
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.e_renamed(this.s_renamed.f34a);
        }
    }
}
