package com.airbnb.lottie.e_renamed.a_renamed;

/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public abstract class c_renamed implements java.io.Closeable {
    private static final java.lang.String[] g_renamed = new java.lang.String[128];

    /* renamed from: a_renamed, reason: collision with root package name */
    int f2167a;

    /* renamed from: b_renamed, reason: collision with root package name */
    int[] f2168b = new int[32];

    /* renamed from: c_renamed, reason: collision with root package name */
    java.lang.String[] f2169c = new java.lang.String[32];
    int[] d_renamed = new int[32];
    boolean e_renamed;
    boolean f_renamed;

    /* compiled from: JsonReader.java */
    public enum b_renamed {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public abstract int a_renamed(com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed aVar) throws java.io.IOException;

    public abstract void a_renamed() throws java.io.IOException;

    public abstract void b_renamed() throws java.io.IOException;

    public abstract void c_renamed() throws java.io.IOException;

    public abstract void d_renamed() throws java.io.IOException;

    public abstract boolean e_renamed() throws java.io.IOException;

    public abstract com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed f_renamed() throws java.io.IOException;

    public abstract java.lang.String g_renamed() throws java.io.IOException;

    public abstract void h_renamed() throws java.io.IOException;

    public abstract java.lang.String i_renamed() throws java.io.IOException;

    public abstract boolean j_renamed() throws java.io.IOException;

    public abstract double k_renamed() throws java.io.IOException;

    public abstract int l_renamed() throws java.io.IOException;

    public abstract void m_renamed() throws java.io.IOException;

    static {
        for (int i_renamed = 0; i_renamed <= 31; i_renamed++) {
            g_renamed[i_renamed] = java.lang.String.format("\\u_renamed%04x", java.lang.Integer.valueOf(i_renamed));
        }
        java.lang.String[] strArr = g_renamed;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t_renamed";
        strArr[8] = "\\b_renamed";
        strArr[10] = "\\n_renamed";
        strArr[13] = "\\r_renamed";
        strArr[12] = "\\f_renamed";
    }

    public static com.airbnb.lottie.e_renamed.a_renamed.c_renamed a_renamed(okio.BufferedSource bufferedSource) {
        return new com.airbnb.lottie.e_renamed.a_renamed.e_renamed(bufferedSource);
    }

    c_renamed() {
    }

    final void a_renamed(int i_renamed) {
        int i2 = this.f2167a;
        int[] iArr = this.f2168b;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                throw new com.airbnb.lottie.e_renamed.a_renamed.a_renamed("Nesting too deep at_renamed " + n_renamed());
            }
            this.f2168b = java.util.Arrays.copyOf(iArr, iArr.length * 2);
            java.lang.String[] strArr = this.f2169c;
            this.f2169c = (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.d_renamed;
            this.d_renamed = java.util.Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f2168b;
        int i3 = this.f2167a;
        this.f2167a = i3 + 1;
        iArr3[i3] = i_renamed;
    }

    final com.airbnb.lottie.e_renamed.a_renamed.b_renamed a_renamed(java.lang.String str) throws com.airbnb.lottie.e_renamed.a_renamed.b_renamed {
        throw new com.airbnb.lottie.e_renamed.a_renamed.b_renamed(str + " at_renamed path " + n_renamed());
    }

    public final java.lang.String n_renamed() {
        return com.airbnb.lottie.e_renamed.a_renamed.d_renamed.a_renamed(this.f2167a, this.f2168b, this.f2169c, this.d_renamed);
    }

    /* compiled from: JsonReader.java */
    public static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final java.lang.String[] f2170a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final okio.Options f2171b;

        private a_renamed(java.lang.String[] strArr, okio.Options options) {
            this.f2170a = strArr;
            this.f2171b = options;
        }

        public static com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed a_renamed(java.lang.String... strArr) {
            try {
                okio.ByteString[] byteStringArr = new okio.ByteString[strArr.length];
                okio.Buffer buffer = new okio.Buffer();
                for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
                    com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed(buffer, strArr[i_renamed]);
                    buffer.readByte();
                    byteStringArr[i_renamed] = buffer.readByteString();
                }
                return new com.airbnb.lottie.e_renamed.a_renamed.c_renamed.a_renamed((java.lang.String[]) strArr.clone(), okio.Options.of_renamed(byteStringArr));
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.AssertionError(e_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b_renamed(okio.BufferedSink r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.e_renamed.a_renamed.c_renamed.g_renamed
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r8, r4, r3)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e_renamed.a_renamed.c_renamed.b_renamed(okio.BufferedSink, java.lang.String):void");
    }
}
