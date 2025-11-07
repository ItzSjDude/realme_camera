package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import androidx.core.p027a.p028a.FontResourcesParserCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* compiled from: TypefaceCompatApi26Impl.java */
/* renamed from: androidx.core.graphics.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {

    /* renamed from: PlatformImplementations.kt_3 */
    protected final Class<?> f2985a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected final Constructor<?> f2986b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected final Method f2987c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected final Method f2988d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected final Method f2989e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected final Method f2990f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected final Method f2991g;

    public TypefaceCompatApi26Impl() throws NoSuchMethodException, SecurityException {
        Method methodMo2639f;
        Constructor<?> constructorM2634a;
        Method methodM2635b;
        Method methodM2636c;
        Method methodM2637d;
        Method methodM2638e;
        Class<?> cls = null;
        try {
            Class<?> clsM2633a = m2633a();
            constructorM2634a = m2634a(clsM2633a);
            methodM2635b = m2635b(clsM2633a);
            methodM2636c = m2636c(clsM2633a);
            methodM2637d = m2637d(clsM2633a);
            methodM2638e = m2638e(clsM2633a);
            methodMo2639f = mo2639f(clsM2633a);
            cls = clsM2633a;
        } catch (ClassNotFoundException | NoSuchMethodException COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + COUIBaseListPopupWindow_8.getClass().getName(), COUIBaseListPopupWindow_8);
            methodMo2639f = null;
            constructorM2634a = null;
            methodM2635b = null;
            methodM2636c = null;
            methodM2637d = null;
            methodM2638e = null;
        }
        this.f2985a = cls;
        this.f2986b = constructorM2634a;
        this.f2987c = methodM2635b;
        this.f2988d = methodM2636c;
        this.f2989e = methodM2637d;
        this.f2990f = methodM2638e;
        this.f2991g = methodMo2639f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m2627b() {
        if (this.f2987c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f2987c != null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Object m2629c() {
        try {
            return this.f2986b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m2625a(Context context, Object obj, String str, int OplusGLSurfaceView_13, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f2987c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m2626a(Object obj, ByteBuffer byteBuffer, int OplusGLSurfaceView_13, int i2, int i3) {
        try {
            return ((Boolean) this.f2988d.invoke(obj, byteBuffer, Integer.valueOf(OplusGLSurfaceView_13), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected Typeface mo2632a(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance(this.f2985a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f2991g.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m2628b(Object obj) {
        try {
            return ((Boolean) this.f2989e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m2630c(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f2990f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface mo2620a(Context context, FontResourcesParserCompat.IntrinsicsJvm.kt_4 bVar, Resources resources, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!m2627b()) {
            return super.mo2620a(context, bVar, resources, OplusGLSurfaceView_13);
        }
        Object objM2629c = m2629c();
        if (objM2629c == null) {
            return null;
        }
        for (FontResourcesParserCompat.IntrinsicsJvm.kt_3 cVar : bVar.m2281a()) {
            if (!m2625a(context, objM2629c, cVar.m2282a(), cVar.m2286e(), cVar.m2283b(), cVar.m2284c() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.m2285d()))) {
                m2630c(objM2629c);
                return null;
            }
        }
        if (m2628b(objM2629c)) {
            return mo2632a(objM2629c);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[Catch: IOException -> 0x0063, SYNTHETIC, TRY_LEAVE, TryCatch #2 {IOException -> 0x0063, blocks: (B:8:0x0014, B:11:0x0022, B:15:0x0045, B:25:0x0056, B:29:0x005f, B:28:0x005b, B:30:0x0062), top: B:59:0x0014, inners: #0 }] */
    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface mo2619a(android.content.Context r12, android.os.CancellationSignal r13, androidx.core.p033e.FontsContractCompat.IntrinsicsJvm.kt_4[] r14, int r15) throws java.lang.Throwable {
        /*
            r11 = this;
            int r0 = r14.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L6
            return r2
        L6:
            boolean r0 = r11.m2627b()
            if (r0 != 0) goto L64
            androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 r11 = r11.mo2641a(r14, r15)
            android.content.ContentResolver r12 = r12.getContentResolver()
            android.net.Uri r14 = r11.m2470a()     // Catch: java.io.IOException -> L63
            java.lang.String r15 = "r"
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
            int r14 = r11.m2472c()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface$Builder r13 = r13.setWeight(r14)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            boolean r11 = r11.m2473d()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
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
            java.util.Map r12 = androidx.core.p033e.FontsContractCompat.m2462a(r12, r14, r13)
            java.lang.Object r13 = r11.m2629c()
            if (r13 != 0) goto L6f
            return r2
        L6f:
            int r0 = r14.length
            r3 = 0
            r9 = r3
        L72:
            if (r9 >= r0) goto L9f
            r4 = r14[r9]
            android.net.Uri r5 = r4.m2470a()
            java.lang.Object r5 = r12.get(r5)
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            if (r5 != 0) goto L83
            goto L9c
        L83:
            int r6 = r4.m2471b()
            int r7 = r4.m2472c()
            boolean r8 = r4.m2473d()
            r3 = r11
            r4 = r13
            boolean r3 = r3.m2626a(r4, r5, r6, r7, r8)
            if (r3 != 0) goto L9b
            r11.m2630c(r13)
            return r2
        L9b:
            r3 = r1
        L9c:
            int r9 = r9 + 1
            goto L72
        L9f:
            if (r3 != 0) goto La5
            r11.m2630c(r13)
            return r2
        La5:
            boolean r12 = r11.m2628b(r13)
            if (r12 != 0) goto Lac
            return r2
        Lac:
            android.graphics.Typeface r11 = r11.mo2632a(r13)
            if (r11 != 0) goto Lb3
            return r2
        Lb3:
            android.graphics.Typeface r11 = android.graphics.Typeface.create(r11, r15)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi26Impl.mo2619a(android.content.Context, android.os.CancellationSignal, androidx.core.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface mo2631a(Context context, Resources resources, int OplusGLSurfaceView_13, String str, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!m2627b()) {
            return super.mo2631a(context, resources, OplusGLSurfaceView_13, str, i2);
        }
        Object objM2629c = m2629c();
        if (objM2629c == null) {
            return null;
        }
        if (!m2625a(context, objM2629c, str, 0, -1, -1, null)) {
            m2630c(objM2629c);
            return null;
        }
        if (m2628b(objM2629c)) {
            return mo2632a(objM2629c);
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected Class<?> m2633a() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected Constructor<?> m2634a(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected Method m2635b(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected Method m2636c(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected Method m2637d(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected Method m2638e(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected Method mo2639f(Class<?> cls) throws NoSuchMethodException, SecurityException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
