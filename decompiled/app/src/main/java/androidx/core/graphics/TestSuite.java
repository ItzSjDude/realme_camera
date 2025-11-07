package androidx.core.graphics;

/* compiled from: TypefaceCompatApi26Impl.java */
/* loaded from: classes.dex */
public class i_renamed extends androidx.core.graphics.g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected final java.lang.Class<?> f949a;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected final java.lang.reflect.Constructor<?> f950b;

    /* renamed from: c_renamed, reason: collision with root package name */
    protected final java.lang.reflect.Method f951c;
    protected final java.lang.reflect.Method d_renamed;
    protected final java.lang.reflect.Method e_renamed;
    protected final java.lang.reflect.Method f_renamed;
    protected final java.lang.reflect.Method g_renamed;

    public i_renamed() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.reflect.Method methodF;
        java.lang.reflect.Constructor<?> constructorA;
        java.lang.reflect.Method methodB;
        java.lang.reflect.Method methodC;
        java.lang.reflect.Method methodD;
        java.lang.reflect.Method methodE;
        java.lang.Class<?> cls = null;
        try {
            java.lang.Class<?> clsA = a_renamed();
            constructorA = a_renamed(clsA);
            methodB = b_renamed(clsA);
            methodC = c_renamed(clsA);
            methodD = d_renamed(clsA);
            methodE = e_renamed(clsA);
            methodF = f_renamed(clsA);
            cls = clsA;
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException e_renamed) {
            android.util.Log.e_renamed("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e_renamed.getClass().getName(), e_renamed);
            methodF = null;
            constructorA = null;
            methodB = null;
            methodC = null;
            methodD = null;
            methodE = null;
        }
        this.f949a = cls;
        this.f950b = constructorA;
        this.f951c = methodB;
        this.d_renamed = methodC;
        this.e_renamed = methodD;
        this.f_renamed = methodE;
        this.g_renamed = methodF;
    }

    private boolean b_renamed() {
        if (this.f951c == null) {
            android.util.Log.w_renamed("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f951c != null;
    }

    private java.lang.Object c_renamed() {
        try {
            return this.f950b.newInstance(new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    private boolean a_renamed(android.content.Context context, java.lang.Object obj, java.lang.String str, int i_renamed, int i2, int i3, android.graphics.fonts.FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((java.lang.Boolean) this.f951c.invoke(obj, context.getAssets(), str, 0, false, java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    private boolean a_renamed(java.lang.Object obj, java.nio.ByteBuffer byteBuffer, int i_renamed, int i2, int i3) {
        try {
            return ((java.lang.Boolean) this.d_renamed.invoke(obj, byteBuffer, java.lang.Integer.valueOf(i_renamed), null, java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3))).booleanValue();
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    protected android.graphics.Typeface a_renamed(java.lang.Object obj) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException, java.lang.NegativeArraySizeException {
        try {
            java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance(this.f949a, 1);
            java.lang.reflect.Array.set(objNewInstance, 0, obj);
            return (android.graphics.Typeface) this.g_renamed.invoke(null, objNewInstance, -1, -1);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    private boolean b_renamed(java.lang.Object obj) {
        try {
            return ((java.lang.Boolean) this.e_renamed.invoke(obj, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    private void c_renamed(java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        try {
            this.f_renamed.invoke(obj, new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
        }
    }

    @Override // androidx.core.graphics.g_renamed, androidx.core.graphics.l_renamed
    public android.graphics.Typeface a_renamed(android.content.Context context, androidx.core.a_renamed.a_renamed.c_renamed.b_renamed bVar, android.content.res.Resources resources, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (!b_renamed()) {
            return super.a_renamed(context, bVar, resources, i_renamed);
        }
        java.lang.Object objC = c_renamed();
        if (objC == null) {
            return null;
        }
        for (androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4 c0013c : bVar.a_renamed()) {
            if (!a_renamed(context, objC, c0013c.a_renamed(), c0013c.e_renamed(), c0013c.b_renamed(), c0013c.c_renamed() ? 1 : 0, android.graphics.fonts.FontVariationAxis.fromFontVariationSettings(c0013c.d_renamed()))) {
                c_renamed(objC);
                return null;
            }
        }
        if (b_renamed(objC)) {
            return a_renamed(objC);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:68:? A_renamed[Catch: IOException -> 0x0063, SYNTHETIC, TRY_LEAVE, TryCatch #2 {IOException -> 0x0063, blocks: (B_renamed:8:0x0014, B_renamed:11:0x0022, B_renamed:15:0x0045, B_renamed:25:0x0056, B_renamed:29:0x005f, B_renamed:28:0x005b, B_renamed:30:0x0062), top: B_renamed:59:0x0014, inners: #0 }] */
    @Override // androidx.core.graphics.g_renamed, androidx.core.graphics.l_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface a_renamed(android.content.Context r12, android.os.CancellationSignal r13, androidx.core.e_renamed.b_renamed.FontsContractCompat_3[] r14, int r15) throws java.lang.Throwable {
        /*
            r11 = this;
            int r0 = r14.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L6
            return r2
        L6:
            boolean r0 = r11.b_renamed()
            if (r0 != 0) goto L64
            androidx.core.e_renamed.b_renamed$b_renamed r11 = r11.a_renamed(r14, r15)
            android.content.ContentResolver r12 = r12.getContentResolver()
            android.net.Uri r14 = r11.a_renamed()     // Catch: java.io.IOException -> L63
            java.lang.String r15 = "r_renamed"
            android.os.ParcelFileDescriptor r12 = r12.openFileDescriptor(r14, r15, r13)     // Catch: java.io.IOException -> L63
            if (r12 != 0) goto L26
            if (r12 == 0) goto L25
            r12.close()     // Catch: java.io.IOException -> L63
        L25:
            return r2
        L26:
            android.graphics.Typeface$Builder r13 = new android.graphics.Typeface$Builder     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            java.io.FileDescriptor r14 = r12.getFileDescriptor()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            r13.<init>(r14)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            int r14 = r11.c_renamed()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface$Builder r13 = r13.setWeight(r14)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            boolean r11 = r11.d_renamed()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface$Builder r11 = r13.setItalic(r11)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface r11 = r11.build()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            if (r12 == 0) goto L48
            r12.close()     // Catch: java.io.IOException -> L63
        L48:
            return r11
        L49:
            r11 = move-exception
            r13 = r2
            goto L52
        L4c:
            r11 = move-exception
            throw r11     // Catch: java.lang.Throwable -> L4e
        L4e:
            r13 = move-exception
            r10 = r13
            r13 = r11
            r11 = r10
        L52:
            if (r12 == 0) goto L62
            if (r13 == 0) goto L5f
            r12.close()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L63
            goto L62
        L5a:
            r12 = move-exception
            r13.addSuppressed(r12)     // Catch: java.io.IOException -> L63
            goto L62
        L5f:
            r12.close()     // Catch: java.io.IOException -> L63
        L62:
            throw r11     // Catch: java.io.IOException -> L63
        L63:
            return r2
        L64:
            java.util.Map r12 = androidx.core.e_renamed.b_renamed.a_renamed(r12, r14, r13)
            java.lang.Object r13 = r11.c_renamed()
            if (r13 != 0) goto L6f
            return r2
        L6f:
            int r0 = r14.length
            r3 = 0
            r9 = r3
        L72:
            if (r9 >= r0) goto L9f
            r4 = r14[r9]
            android.net.Uri r5 = r4.a_renamed()
            java.lang.Object r5 = r12.get(r5)
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            if (r5 != 0) goto L83
            goto L9c
        L83:
            int r6 = r4.b_renamed()
            int r7 = r4.c_renamed()
            boolean r8 = r4.d_renamed()
            r3 = r11
            r4 = r13
            boolean r3 = r3.a_renamed(r4, r5, r6, r7, r8)
            if (r3 != 0) goto L9b
            r11.c_renamed(r13)
            return r2
        L9b:
            r3 = r1
        L9c:
            int r9 = r9 + 1
            goto L72
        L9f:
            if (r3 != 0) goto La5
            r11.c_renamed(r13)
            return r2
        La5:
            boolean r12 = r11.b_renamed(r13)
            if (r12 != 0) goto Lac
            return r2
        Lac:
            android.graphics.Typeface r11 = r11.a_renamed(r13)
            if (r11 != 0) goto Lb3
            return r2
        Lb3:
            android.graphics.Typeface r11 = android.graphics.Typeface.create(r11, r15)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.i_renamed.a_renamed(android.content.Context, android.os.CancellationSignal, androidx.core.e_renamed.b_renamed$b_renamed[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.graphics.l_renamed
    public android.graphics.Typeface a_renamed(android.content.Context context, android.content.res.Resources resources, int i_renamed, java.lang.String str, int i2) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (!b_renamed()) {
            return super.a_renamed(context, resources, i_renamed, str, i2);
        }
        java.lang.Object objC = c_renamed();
        if (objC == null) {
            return null;
        }
        if (!a_renamed(context, objC, str, 0, -1, -1, null)) {
            c_renamed(objC);
            return null;
        }
        if (b_renamed(objC)) {
            return a_renamed(objC);
        }
        return null;
    }

    protected java.lang.Class<?> a_renamed() throws java.lang.ClassNotFoundException {
        return java.lang.Class.forName("android.graphics.FontFamily");
    }

    protected java.lang.reflect.Constructor<?> a_renamed(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        return cls.getConstructor(new java.lang.Class[0]);
    }

    protected java.lang.reflect.Method b_renamed(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        return cls.getMethod("addFontFromAssetManager", android.content.res.AssetManager.class, java.lang.String.class, java.lang.Integer.TYPE, java.lang.Boolean.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE, java.lang.Integer.TYPE, android.graphics.fonts.FontVariationAxis[].class);
    }

    protected java.lang.reflect.Method c_renamed(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        return cls.getMethod("addFontFromBuffer", java.nio.ByteBuffer.class, java.lang.Integer.TYPE, android.graphics.fonts.FontVariationAxis[].class, java.lang.Integer.TYPE, java.lang.Integer.TYPE);
    }

    protected java.lang.reflect.Method d_renamed(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        return cls.getMethod("freeze", new java.lang.Class[0]);
    }

    protected java.lang.reflect.Method e_renamed(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException {
        return cls.getMethod("abortCreation", new java.lang.Class[0]);
    }

    protected java.lang.reflect.Method f_renamed(java.lang.Class<?> cls) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        java.lang.reflect.Method declaredMethod = android.graphics.Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", java.lang.reflect.Array.newInstance(cls, 1).getClass(), java.lang.Integer.TYPE, java.lang.Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
