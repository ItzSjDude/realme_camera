package androidx.core.p027a.p028a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import androidx.core.p035g.Preconditions;

/* compiled from: ResourcesCompat.java */
/* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public final class ResourcesCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static Drawable m2302a(Resources resources, int OplusGLSurfaceView_13, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(OplusGLSurfaceView_13, theme);
        }
        return resources.getDrawable(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static ColorStateList m2304b(Resources resources, int OplusGLSurfaceView_13, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(OplusGLSurfaceView_13, theme);
        }
        return resources.getColorStateList(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Typeface m2298a(Context context, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m2300a(context, OplusGLSurfaceView_13, new TypedValue(), 0, null, null, false);
    }

    /* compiled from: ResourcesCompat.java */
    /* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 {
        public abstract void onFontRetrievalFailed(int OplusGLSurfaceView_13);

        public abstract void onFontRetrieved(Typeface typeface);

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.1
                @Override // java.lang.Runnable
                public void run() {
                    PlatformImplementations.kt_3.this.onFontRetrieved(typeface);
                }
            });
        }

        public final void callbackFailAsync(final int OplusGLSurfaceView_13, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.2
                @Override // java.lang.Runnable
                public void run() {
                    PlatformImplementations.kt_3.this.onFontRetrievalFailed(OplusGLSurfaceView_13);
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m2303a(Context context, int OplusGLSurfaceView_13, PlatformImplementations.kt_3 aVar, Handler handler) throws Resources.NotFoundException {
        Preconditions.m2536a(aVar);
        if (context.isRestricted()) {
            aVar.callbackFailAsync(-4, handler);
        } else {
            m2300a(context, OplusGLSurfaceView_13, new TypedValue(), 0, aVar, handler, false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Typeface m2299a(Context context, int OplusGLSurfaceView_13, TypedValue typedValue, int i2, PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m2300a(context, OplusGLSurfaceView_13, typedValue, i2, aVar, null, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Typeface m2300a(Context context, int OplusGLSurfaceView_13, TypedValue typedValue, int i2, PlatformImplementations.kt_3 aVar, Handler handler, boolean z) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        resources.getValue(OplusGLSurfaceView_13, typedValue, true);
        Typeface typefaceM2301a = m2301a(context, resources, typedValue, OplusGLSurfaceView_13, i2, aVar, handler, z);
        if (typefaceM2301a != null || aVar != null) {
            return typefaceM2301a;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(OplusGLSurfaceView_13) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface m2301a(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, androidx.core.p027a.p028a.ResourcesCompat.PlatformImplementations.kt_3 r20, android.os.Handler r21, boolean r22) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto La9
            java.lang.CharSequence r1 = r1.string
            java.lang.String r12 = r1.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = 0
            r14 = -3
            if (r1 != 0) goto L28
            if (r9 == 0) goto L27
            r9.callbackFailAsync(r14, r10)
        L27:
            return r13
        L28:
            android.graphics.Typeface r1 = androidx.core.graphics.TypefaceCompat.m2611a(r0, r4, r5)
            if (r1 == 0) goto L34
            if (r9 == 0) goto L33
            r9.callbackSuccessAsync(r1, r10)
        L33:
            return r1
        L34:
            java.lang.String r1 = r12.toLowerCase()     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
            if (r1 == 0) goto L67
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
            androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 r2 = androidx.core.p027a.p028a.FontResourcesParserCompat.m2274a(r1, r0)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
            if (r2 != 0) goto L55
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.COUIBaseListPopupWindow_8(r11, r0)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
            if (r9 == 0) goto L54
            r9.callbackFailAsync(r14, r10)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
        L54:
            return r13
        L55:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.m2610a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
            return r0
        L67:
            r1 = r15
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.m2607a(r15, r0, r4, r12, r5)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
            if (r9 == 0) goto L77
            if (r0 == 0) goto L74
            r9.callbackSuccessAsync(r0, r10)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
            goto L77
        L74:
            r9.callbackFailAsync(r14, r10)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
        L77:
            return r0
        L78:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.COUIBaseListPopupWindow_8(r11, r1, r0)
            goto La3
        L8e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.COUIBaseListPopupWindow_8(r11, r1, r0)
        La3:
            if (r9 == 0) goto La8
            r9.callbackFailAsync(r14, r10)
        La8:
            return r13
        La9:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not PlatformImplementations.kt_3 Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.p027a.p028a.ResourcesCompat.m2301a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3, android.os.Handler, boolean):android.graphics.Typeface");
    }
}
