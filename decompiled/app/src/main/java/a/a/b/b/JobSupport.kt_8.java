package a_renamed.a_renamed.b_renamed.b_renamed;

/* loaded from: classes.dex */
public class ba_renamed extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed {
    public static android.util.LruCache<java.util.Map<java.lang.String, java.lang.Object>, byte[]> q_renamed = new android.util.LruCache<>(10);
    public static final java.util.Map<java.lang.String, java.lang.String> r_renamed = new java.util.HashMap();
    public a_renamed.a_renamed.b_renamed.c_renamed.d_renamed s_renamed;
    public byte[] t_renamed;
    public java.util.Map<java.lang.String, java.lang.Float> u_renamed;
    public boolean v_renamed;

    static {
        r_renamed.put("hue_red", "hue");
        r_renamed.put("hue_orange", "hue");
        r_renamed.put("hue_yellow", "hue");
        r_renamed.put("hue_green", "hue");
        r_renamed.put("hue_aqua", "hue");
        r_renamed.put("hue_blue", "hue");
        r_renamed.put("hue_purple", "hue");
        r_renamed.put("hue_magenta", "hue");
        r_renamed.put("saturation_red", "saturation");
        r_renamed.put("saturation_orange", "saturation");
        r_renamed.put("saturation_yellow", "saturation");
        r_renamed.put("saturation_green", "saturation");
        r_renamed.put("saturation_aqua", "saturation");
        r_renamed.put("saturation_blue", "saturation");
        r_renamed.put("saturation_purple", "saturation");
        r_renamed.put("saturation_magenta", "saturation");
        r_renamed.put("luminance_red", "luminance");
        r_renamed.put("luminance_orange", "luminance");
        r_renamed.put("luminance_yellow", "luminance");
        r_renamed.put("luminance_green", "luminance");
        r_renamed.put("luminance_aqua", "luminance");
        r_renamed.put("luminance_blue", "luminance");
        r_renamed.put("luminance_purple", "luminance");
        r_renamed.put("luminance_magenta", "luminance");
    }

    public ba_renamed(android.content.res.Resources resources, co_renamed.polarr.renderer.entities.Context context) {
        super(resources, a_renamed.a_renamed.b_renamed.f_renamed.m_renamed.a_renamed("hsl"), context);
        this.u_renamed = new java.util.HashMap();
        java.util.Map<java.lang.String, java.lang.Float> map = this.u_renamed;
        java.lang.Float fValueOf = java.lang.Float.valueOf(0.0f);
        map.put("hue_red", fValueOf);
        this.u_renamed.put("hue_orange", fValueOf);
        this.u_renamed.put("hue_yellow", fValueOf);
        this.u_renamed.put("hue_green", fValueOf);
        this.u_renamed.put("hue_aqua", fValueOf);
        this.u_renamed.put("hue_blue", fValueOf);
        this.u_renamed.put("hue_purple", fValueOf);
        this.u_renamed.put("hue_magenta", fValueOf);
        this.u_renamed.put("saturation_red", fValueOf);
        this.u_renamed.put("saturation_orange", fValueOf);
        this.u_renamed.put("saturation_yellow", fValueOf);
        this.u_renamed.put("saturation_green", fValueOf);
        this.u_renamed.put("saturation_aqua", fValueOf);
        this.u_renamed.put("saturation_blue", fValueOf);
        this.u_renamed.put("saturation_purple", fValueOf);
        this.u_renamed.put("saturation_magenta", fValueOf);
        this.u_renamed.put("luminance_red", fValueOf);
        this.u_renamed.put("luminance_orange", fValueOf);
        this.u_renamed.put("luminance_yellow", fValueOf);
        this.u_renamed.put("luminance_green", fValueOf);
        this.u_renamed.put("luminance_aqua", fValueOf);
        this.u_renamed.put("luminance_blue", fValueOf);
        this.u_renamed.put("luminance_purple", fValueOf);
        this.u_renamed.put("luminance_magenta", fValueOf);
    }

    public static float[][] a_renamed(java.lang.String str, java.util.Map<java.lang.String, java.lang.Float> map) {
        return new float[][]{new float[]{0.0f, 30.0f, 60.0f, 90.0f, 180.0f, 240.0f, 270.0f, 300.0f, 360.0f}, new float[]{((map.get(str + "_red").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_orange").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_yellow").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_green").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_aqua").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_blue").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_purple").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_magenta").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_red").floatValue() / 2.0f) + 0.5f) * 255.0f}};
    }

    public final void a_renamed(java.lang.String str, float f_renamed, boolean z_renamed) {
        if (z_renamed || this.u_renamed.get(str).floatValue() != f_renamed) {
            this.u_renamed.put(str, java.lang.Float.valueOf(f_renamed));
            java.lang.String str2 = r_renamed.get(str);
            char c2 = 65535;
            int iHashCode = str2.hashCode();
            int i_renamed = 2;
            if (iHashCode != -230491182) {
                if (iHashCode != 103672) {
                    if (iHashCode == 1178092792 && str2.equals("luminance")) {
                        c2 = 2;
                    }
                } else if (str2.equals("hue")) {
                    c2 = 0;
                }
            } else if (str2.equals("saturation")) {
                c2 = 1;
            }
            if (c2 == 0) {
                i_renamed = 0;
            } else if (c2 == 1) {
                i_renamed = 1;
            } else if (c2 != 2) {
                return;
            }
            float[][] fArrA = a_renamed(str2, this.u_renamed);
            a_renamed.a_renamed.b_renamed.d_renamed.b_renamed bVar = new a_renamed.a_renamed.b_renamed.d_renamed.b_renamed(fArrA[0], fArrA[1]);
            for (int i2 = 0; i2 <= 359; i2++) {
                this.t_renamed[(i2 * 3) + i_renamed] = (byte) a_renamed.a_renamed.b_renamed.f_renamed.p_renamed.a_renamed(bVar.a_renamed(i2), 0.0d, 255.0d);
            }
        }
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed
    public void a_renamed(java.lang.String str, java.lang.Object obj) {
        this.v_renamed = true;
        synchronized (this.t_renamed) {
            if (obj instanceof java.lang.Integer) {
                a_renamed(str, ((java.lang.Integer) obj).intValue(), false);
            } else {
                a_renamed(str, ((java.lang.Float) obj).floatValue(), false);
            }
        }
    }

    public boolean a_renamed(java.util.Map<java.lang.String, java.lang.Object> map) {
        byte[] bArr = q_renamed.get(map);
        if (bArr == null || bArr.length != this.t_renamed.length) {
            return false;
        }
        this.v_renamed = true;
        this.t_renamed = bArr;
        return true;
    }

    public void b_renamed(java.util.Map<java.lang.String, java.lang.Object> map) {
        android.util.LruCache<java.util.Map<java.lang.String, java.lang.Object>, byte[]> lruCache = q_renamed;
        byte[] bArr = this.t_renamed;
        lruCache.put(map, java.util.Arrays.copyOf(bArr, bArr.length));
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void g_renamed() {
        super.g_renamed();
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.c_renamed(iArr[0]);
        this.t_renamed = new byte[com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT];
        this.s_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6407, 360, 1);
        android.opengl.GLES20.glBindTexture(3553, this.s_renamed.f34a);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed();
        android.opengl.GLES20.glBindTexture(3553, 0);
        this.v_renamed = true;
        for (java.lang.String str : this.u_renamed.keySet()) {
            a_renamed(str, ((java.lang.Float) a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(str, this.f15a.renderStates)).floatValue(), true);
        }
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed, a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed
    public void j_renamed() {
        super.j_renamed();
        if (this.v_renamed) {
            synchronized (this.t_renamed) {
                java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(this.t_renamed.length);
                byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
                byteBufferAllocateDirect.put(this.t_renamed);
                byteBufferAllocateDirect.position(0);
                android.opengl.GLES20.glBindTexture(3553, this.s_renamed.f34a);
                android.opengl.GLES20.glPixelStorei(3317, 4);
                android.opengl.GLES20.glTexImage2D(3553, 0, this.s_renamed.d_renamed, this.s_renamed.f35b, this.s_renamed.f36c, 0, this.s_renamed.d_renamed, 5121, byteBufferAllocateDirect);
                android.opengl.GLES20.glBindTexture(3553, 0);
            }
            this.v_renamed = false;
        }
        int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(this.f16b, "map");
        android.opengl.GLES20.glActiveTexture(33985);
        android.opengl.GLES20.glBindTexture(3553, this.s_renamed.f34a);
        android.opengl.GLES20.glUniform1i(iGlGetUniformLocation, 1);
    }

    @Override // a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.b_renamed
    public boolean l_renamed() {
        java.util.Map<java.lang.String, java.lang.Float> map = this.u_renamed;
        if (map == null) {
            return true;
        }
        java.util.Iterator<java.lang.Float> it = map.values().iterator();
        while (it.hasNext()) {
            if (it.next().floatValue() != 0.0f) {
                return false;
            }
        }
        return true;
    }

    public void m_renamed() {
        n_renamed();
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.c_renamed(iArr[0]);
        this.t_renamed = new byte[com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT];
        this.s_renamed = a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed(iArr[0], 6407, 360, 1);
        android.opengl.GLES20.glBindTexture(3553, this.s_renamed.f34a);
        a_renamed.a_renamed.b_renamed.f_renamed.f_renamed.b_renamed();
        android.opengl.GLES20.glBindTexture(3553, 0);
        this.v_renamed = true;
        for (java.lang.String str : this.u_renamed.keySet()) {
            java.lang.Object objA = a_renamed.a_renamed.b_renamed.f_renamed.a_renamed(str, this.f15a.renderStates);
            if (objA != null && (objA instanceof java.lang.Float)) {
                a_renamed(str, ((java.lang.Float) objA).floatValue(), true);
            }
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
