package com.b_renamed.a_renamed;

/* compiled from: WavefrontLoaderO3d.java */
/* loaded from: classes.dex */
public class o_renamed {
    private static final java.lang.String g_renamed = "o_renamed";
    public java.nio.IntBuffer e_renamed;
    private java.nio.FloatBuffer h_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    com.b_renamed.a_renamed.o_renamed.b_renamed f2369a = new com.b_renamed.a_renamed.o_renamed.b_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f2370b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    public int f2371c = 0;
    public int d_renamed = 0;
    public java.util.List<com.b_renamed.a_renamed.o_renamed.a_renamed> f_renamed = new java.util.ArrayList();
    private boolean i_renamed = false;

    public void a_renamed(com.b_renamed.a_renamed.g_renamed gVar) {
        this.f2370b = gVar.f2351a.length / 3;
        this.f2371c = this.f2370b;
        this.d_renamed = gVar.f2353c.length / 3;
        int i_renamed = this.f2370b;
        if (i_renamed > 0) {
            this.h_renamed = a_renamed(i_renamed * 3);
        }
        int i2 = this.d_renamed;
        if (i2 > 0) {
            this.e_renamed = b_renamed(i2 * 3);
        }
    }

    public static java.nio.FloatBuffer a_renamed(int i_renamed) {
        return org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed(i_renamed * 4).asFloatBuffer();
    }

    public static java.nio.IntBuffer b_renamed(int i_renamed) {
        return org.andresoviedo.a_renamed.a_renamed.d_renamed.a_renamed(i_renamed * 4).asIntBuffer();
    }

    public java.nio.FloatBuffer a_renamed() {
        return this.h_renamed;
    }

    public java.nio.IntBuffer b_renamed() {
        return this.e_renamed;
    }

    public com.b_renamed.a_renamed.o_renamed.b_renamed c_renamed() {
        return this.f2369a;
    }

    public void b_renamed(com.b_renamed.a_renamed.g_renamed gVar) {
        int length = gVar.f2351a.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed += 3) {
            float f_renamed = gVar.f2351a[i_renamed + 0] * 0.5f;
            int i2 = i_renamed + 1;
            float f2 = gVar.f2351a[i2] * 0.5f;
            int i3 = i_renamed + 2;
            float f3 = (gVar.f2351a[i3] - 0.67f) * 0.5f;
            if (i_renamed == 0) {
                this.f2369a.a_renamed(f_renamed, f2, f3);
            } else {
                this.f2369a.b_renamed(f_renamed, f2, f3);
            }
            this.h_renamed.put(i_renamed, f_renamed).put(i2, f2).put(i3, f3);
        }
        int length2 = gVar.f2352b.length;
        for (int i4 = 0; i4 < length2; i4 = i4 + 1 + 1 + 1 + 1) {
            this.f_renamed.add(new com.b_renamed.a_renamed.o_renamed.a_renamed((gVar.f2352b[i4] & 255) / 255.0f, (gVar.f2352b[r4] & 255) / 255.0f, (gVar.f2352b[r5] & 255) / 255.0f, (gVar.f2352b[r6] & 255) / 255.0f));
        }
        int length3 = gVar.f2353c.length;
        for (int i5 = 0; i5 < length3; i5 += 3) {
            int i6 = gVar.f2353c[i5 + 0];
            int i7 = i5 + 1;
            int i8 = i5 + 2;
            this.e_renamed.put(i5, i6).put(i7, gVar.f2353c[i7]).put(i8, gVar.f2353c[i8]);
        }
        this.i_renamed = true;
    }

    /* compiled from: WavefrontLoaderO3d.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public float f2372a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public float f2373b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public float f2374c;
        public float d_renamed;

        public a_renamed() {
            this.f2372a = 0.0f;
            this.f2373b = 0.0f;
            this.f2374c = 0.0f;
            this.d_renamed = 1.0f;
        }

        public a_renamed(float f_renamed, float f2, float f3, float f4) {
            this.f2372a = 0.0f;
            this.f2373b = 0.0f;
            this.f2374c = 0.0f;
            this.d_renamed = 1.0f;
            this.f2372a = f_renamed;
            this.f2373b = f2;
            this.f2374c = f3;
            this.d_renamed = f4;
        }
    }

    /* compiled from: WavefrontLoaderO3d.java */
    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public float f2375a = 0.0f;

        /* renamed from: b_renamed, reason: collision with root package name */
        public float f2376b = 0.0f;

        /* renamed from: c_renamed, reason: collision with root package name */
        public float f2377c = 0.0f;
        public float d_renamed = 0.0f;
        public float e_renamed = 0.0f;
        public float f_renamed = 0.0f;

        public void a_renamed(float f_renamed, float f2, float f3) {
            this.f2376b = f_renamed;
            this.f2375a = f_renamed;
            this.f2377c = f2;
            this.d_renamed = f2;
            this.f_renamed = f3;
            this.e_renamed = f3;
        }

        public void b_renamed(float f_renamed, float f2, float f3) {
            if (f_renamed > this.f2376b) {
                this.f2376b = f_renamed;
            }
            if (f_renamed < this.f2375a) {
                this.f2375a = f_renamed;
            }
            if (f2 > this.f2377c) {
                this.f2377c = f2;
            }
            if (f2 < this.d_renamed) {
                this.d_renamed = f2;
            }
            if (f3 > this.f_renamed) {
                this.f_renamed = f3;
            }
            if (f3 < this.e_renamed) {
                this.e_renamed = f3;
            }
        }
    }
}
