package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.p027a.p028a.FontResourcesParserCompat;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: TypefaceCompatApi21Impl.java */
/* renamed from: androidx.core.graphics.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Class<?> f2976a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Constructor<?> f2977b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Method f2978c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Method f2979d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static boolean f2980e;

    TypefaceCompatApi21Impl() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m2616a() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f2980e) {
            return;
        }
        f2980e = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("TypefaceCompatApi21Impl", COUIBaseListPopupWindow_8.getClass().getName(), COUIBaseListPopupWindow_8);
            method = null;
            cls = null;
            method2 = null;
        }
        f2977b = constructor;
        f2976a = cls;
        f2978c = method2;
        f2979d = method;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private File m2615a(ParcelFileDescriptor parcelFileDescriptor) throws ErrnoException {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Object m2618b() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        m2616a();
        try {
            return f2977b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException COUIBaseListPopupWindow_8) {
            throw new RuntimeException(COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Typeface m2614a(Object obj) throws NoSuchMethodException, ClassNotFoundException, SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        m2616a();
        try {
            Object objNewInstance = Array.newInstance(f2976a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f2979d.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException COUIBaseListPopupWindow_8) {
            throw new RuntimeException(COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m2617a(Object obj, String str, int OplusGLSurfaceView_13, boolean z) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        m2616a();
        try {
            return ((Boolean) f2978c.invoke(obj, str, Integer.valueOf(OplusGLSurfaceView_13), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException COUIBaseListPopupWindow_8) {
            throw new RuntimeException(COUIBaseListPopupWindow_8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0061 A[Catch: all -> 0x0065, Throwable -> 0x0068, TryCatch #2 {all -> 0x0065, blocks: (B:11:0x0020, B:13:0x0026, B:16:0x002d, B:20:0x0037, B:22:0x0044, B:33:0x0058, B:38:0x0064, B:37:0x0061, B:36:0x005d), top: B:58:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[Catch: IOException -> 0x007f, SYNTHETIC, TRY_LEAVE, TryCatch #5 {IOException -> 0x007f, blocks: (B:6:0x000e, B:9:0x001c, B:18:0x0033, B:24:0x0049, B:47:0x0072, B:51:0x007b, B:50:0x0077, B:52:0x007e), top: B:61:0x000e, inners: #6 }] */
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface mo2619a(android.content.Context r5, android.os.CancellationSignal r6, androidx.core.p033e.FontsContractCompat.IntrinsicsJvm.kt_4[] r7, int r8) throws java.lang.Throwable {
        /*
            r4 = this;
            int r0 = r7.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L6
            return r1
        L6:
            androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 r7 = r4.mo2641a(r7, r8)
            android.content.ContentResolver r8 = r5.getContentResolver()
            android.net.Uri r7 = r7.m2470a()     // Catch: java.io.IOException -> L7f
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r6 = r8.openFileDescriptor(r7, r0, r6)     // Catch: java.io.IOException -> L7f
            if (r6 != 0) goto L20
            if (r6 == 0) goto L1f
            r6.close()     // Catch: java.io.IOException -> L7f
        L1f:
            return r1
        L20:
            java.io.File r7 = r4.m2615a(r6)     // Catch: java.lang.Throwable -> L65 java.lang.Throwable -> L68
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
            android.graphics.Typeface r4 = super.mo2640a(r5, r7)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L50
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi21Impl.mo2619a(android.content.Context, android.os.CancellationSignal, androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface mo2620a(Context context, FontResourcesParserCompat.IntrinsicsJvm.kt_4 bVar, Resources resources, int OplusGLSurfaceView_13) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Object objM2618b = m2618b();
        for (FontResourcesParserCompat.IntrinsicsJvm.kt_3 cVar : bVar.m2281a()) {
            File fileM2649a = TypefaceCompatUtil.m2649a(context);
            if (fileM2649a == null) {
                return null;
            }
            try {
                if (!TypefaceCompatUtil.m2654a(fileM2649a, resources, cVar.m2287f())) {
                    return null;
                }
                if (!m2617a(objM2618b, fileM2649a.getPath(), cVar.m2283b(), cVar.m2284c())) {
                    return null;
                }
                fileM2649a.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileM2649a.delete();
            }
        }
        return m2614a(objM2618b);
    }
}
