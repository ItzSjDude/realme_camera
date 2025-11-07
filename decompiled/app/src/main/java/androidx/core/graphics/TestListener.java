package androidx.core.graphics;

/* compiled from: TypefaceCompatApi21Impl.java */
/* loaded from: classes.dex */
class g_renamed extends androidx.core.graphics.l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.Class<?> f943a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.reflect.Constructor<?> f944b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f945c;
    private static java.lang.reflect.Method d_renamed;
    private static boolean e_renamed;

    g_renamed() {
    }

    private static void a_renamed() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
        java.lang.reflect.Method method;
        java.lang.Class<?> cls;
        java.lang.reflect.Method method2;
        if (e_renamed) {
            return;
        }
        e_renamed = true;
        java.lang.reflect.Constructor<?> constructor = null;
        try {
            cls = java.lang.Class.forName("android.graphics.FontFamily");
            java.lang.reflect.Constructor<?> constructor2 = cls.getConstructor(new java.lang.Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", java.lang.String.class, java.lang.Integer.TYPE, java.lang.Boolean.TYPE);
            method = android.graphics.Typeface.class.getMethod("createFromFamiliesWithDefault", java.lang.reflect.Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException e2) {
            android.util.Log.e_renamed("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f944b = constructor;
        f943a = cls;
        f945c = method2;
        d_renamed = method;
    }

    private java.io.File a_renamed(android.os.ParcelFileDescriptor parcelFileDescriptor) throws android.system.ErrnoException {
        try {
            java.lang.String str = android.system.Os.readlink("/proc/self/fd_renamed/" + parcelFileDescriptor.getFd());
            if (android.system.OsConstants.S_ISREG(android.system.Os.stat(str).st_mode)) {
                return new java.io.File(str);
            }
        } catch (android.system.ErrnoException unused) {
        }
        return null;
    }

    private static java.lang.Object b_renamed() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
        a_renamed();
        try {
            return f944b.newInstance(new java.lang.Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    private static android.graphics.Typeface a_renamed(java.lang.Object obj) throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException, java.lang.NegativeArraySizeException {
        a_renamed();
        try {
            java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance(f943a, 1);
            java.lang.reflect.Array.set(objNewInstance, 0, obj);
            return (android.graphics.Typeface) d_renamed.invoke(null, objNewInstance);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    private static boolean a_renamed(java.lang.Object obj, java.lang.String str, int i_renamed, boolean z_renamed) throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
        a_renamed();
        try {
            return ((java.lang.Boolean) f945c.invoke(obj, str, java.lang.Integer.valueOf(i_renamed), java.lang.Boolean.valueOf(z_renamed))).booleanValue();
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:37:0x0061 A_renamed[Catch: all -> 0x0065, Throwable -> 0x0068, TryCatch #2 {all -> 0x0065, blocks: (B_renamed:11:0x0020, B_renamed:13:0x0026, B_renamed:16:0x002d, B_renamed:20:0x0037, B_renamed:22:0x0044, B_renamed:33:0x0058, B_renamed:38:0x0064, B_renamed:37:0x0061, B_renamed:36:0x005d), top: B_renamed:58:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:46:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:56:0x0058 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:68:? A_renamed[Catch: IOException -> 0x007f, SYNTHETIC, TRY_LEAVE, TryCatch #5 {IOException -> 0x007f, blocks: (B_renamed:6:0x000e, B_renamed:9:0x001c, B_renamed:18:0x0033, B_renamed:24:0x0049, B_renamed:47:0x0072, B_renamed:51:0x007b, B_renamed:50:0x0077, B_renamed:52:0x007e), top: B_renamed:61:0x000e, inners: #6 }] */
    @Override // androidx.core.graphics.l_renamed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface a_renamed(android.content.Context r5, android.os.CancellationSignal r6, androidx.core.e_renamed.b_renamed.FontsContractCompat_3[] r7, int r8) throws java.lang.Throwable {
        /*
            r4 = this;
            int r0 = r7.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L6
            return r1
        L6:
            androidx.core.e_renamed.b_renamed$b_renamed r7 = r4.a_renamed(r7, r8)
            android.content.ContentResolver r8 = r5.getContentResolver()
            android.net.Uri r7 = r7.a_renamed()     // Catch: java.io.IOException -> L7f
            java.lang.String r0 = "r_renamed"
            android.os.ParcelFileDescriptor r6 = r8.openFileDescriptor(r7, r0, r6)     // Catch: java.io.IOException -> L7f
            if (r6 != 0) goto L20
            if (r6 == 0) goto L1f
            r6.close()     // Catch: java.io.IOException -> L7f
        L1f:
            return r1
        L20:
            java.io.File r7 = r4.a_renamed(r6)     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L68
            if (r7 == 0) goto L37
            boolean r8 = r7.canRead()     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L68
            if (r8 != 0) goto L2d
            goto L37
        L2d:
            android.graphics.Typeface r4 = android.graphics.Typeface.createFromFile(r7)     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L68
            if (r6 == 0) goto L36
            r6.close()     // Catch: java.io.IOException -> L7f
        L36:
            return r4
        L37:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L68
            java.io.FileDescriptor r8 = r6.getFileDescriptor()     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L68
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L68
            android.graphics.Typeface r4 = super.a_renamed(r5, r7)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L50
            r7.close()     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L68
            if (r6 == 0) goto L4c
            r6.close()     // Catch: java.io.IOException -> L7f
        L4c:
            return r4
        L4d:
            r4 = move-exception
            r5 = r1
            goto L56
        L50:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L52
        L52:
            r5 = move-exception
            r3 = r5
            r5 = r4
            r4 = r3
        L56:
            if (r5 == 0) goto L61
            r7.close()     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L65
            goto L64
        L5c:
            r7 = move-exception
            r5.addSuppressed(r7)     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L68
            goto L64
        L61:
            r7.close()     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L68
        L64:
            throw r4     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L68
        L65:
            r4 = move-exception
            r5 = r1
            goto L6e
        L68:
            r4 = move-exception
            throw r4     // Catch: java.lang.Throwable -> L6a
        L6a:
            r5 = move-exception
            r3 = r5
            r5 = r4
            r4 = r3
        L6e:
            if (r6 == 0) goto L7e
            if (r5 == 0) goto L7b
            r6.close()     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L7f
            goto L7e
        L76:
            r6 = move-exception
            r5.addSuppressed(r6)     // Catch: java.io.IOException -> L7f
            goto L7e
        L7b:
            r6.close()     // Catch: java.io.IOException -> L7f
        L7e:
            throw r4     // Catch: java.io.IOException -> L7f
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.g_renamed.a_renamed(android.content.Context, android.os.CancellationSignal, androidx.core.e_renamed.b_renamed$b_renamed[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.graphics.l_renamed
    public android.graphics.Typeface a_renamed(android.content.Context context, androidx.core.a_renamed.a_renamed.c_renamed.b_renamed bVar, android.content.res.Resources resources, int i_renamed) throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
        java.lang.Object objB = b_renamed();
        for (androidx.core.a_renamed.a_renamed.c_renamed.FontResourcesParserCompat_4 c0013c : bVar.a_renamed()) {
            java.io.File fileA = androidx.core.graphics.m_renamed.a_renamed(context);
            if (fileA == null) {
                return null;
            }
            try {
                if (!androidx.core.graphics.m_renamed.a_renamed(fileA, resources, c0013c.f_renamed())) {
                    return null;
                }
                if (!a_renamed(objB, fileA.getPath(), c0013c.b_renamed(), c0013c.c_renamed())) {
                    return null;
                }
                fileA.delete();
            } catch (java.lang.RuntimeException unused) {
                return null;
            } finally {
                fileA.delete();
            }
        }
        return a_renamed(objB);
    }
}
