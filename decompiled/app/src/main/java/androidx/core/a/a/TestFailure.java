package androidx.core.a_renamed.a_renamed;

/* compiled from: ResourcesCompat.java */
/* loaded from: classes.dex */
public final class f_renamed {
    public static android.graphics.drawable.Drawable a_renamed(android.content.res.Resources resources, int i_renamed, android.content.res.Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i_renamed, theme);
        }
        return resources.getDrawable(i_renamed);
    }

    public static android.content.res.ColorStateList b_renamed(android.content.res.Resources resources, int i_renamed, android.content.res.Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i_renamed, theme);
        }
        return resources.getColorStateList(i_renamed);
    }

    public static android.graphics.Typeface a_renamed(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a_renamed(context, i_renamed, new android.util.TypedValue(), 0, null, null, false);
    }

    /* compiled from: ResourcesCompat.java */
    public static abstract class a_renamed {
        public abstract void onFontRetrievalFailed(int i_renamed);

        public abstract void onFontRetrieved(android.graphics.Typeface typeface);

        public final void callbackSuccessAsync(final android.graphics.Typeface typeface, android.os.Handler handler) {
            if (handler == null) {
                handler = new android.os.Handler(android.os.Looper.getMainLooper());
            }
            handler.post(new java.lang.Runnable() { // from class: androidx.core.a_renamed.a_renamed.f_renamed.a_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    androidx.core.a_renamed.a_renamed.f_renamed.a_renamed.this.onFontRetrieved(typeface);
                }
            });
        }

        public final void callbackFailAsync(final int i_renamed, android.os.Handler handler) {
            if (handler == null) {
                handler = new android.os.Handler(android.os.Looper.getMainLooper());
            }
            handler.post(new java.lang.Runnable() { // from class: androidx.core.a_renamed.a_renamed.f_renamed.a_renamed.2
                @Override // java.lang.Runnable
                public void run() {
                    androidx.core.a_renamed.a_renamed.f_renamed.a_renamed.this.onFontRetrievalFailed(i_renamed);
                }
            });
        }
    }

    public static void a_renamed(android.content.Context context, int i_renamed, androidx.core.a_renamed.a_renamed.f_renamed.a_renamed aVar, android.os.Handler handler) throws android.content.res.Resources.NotFoundException {
        androidx.core.g_renamed.f_renamed.a_renamed(aVar);
        if (context.isRestricted()) {
            aVar.callbackFailAsync(-4, handler);
        } else {
            a_renamed(context, i_renamed, new android.util.TypedValue(), 0, aVar, handler, false);
        }
    }

    public static android.graphics.Typeface a_renamed(android.content.Context context, int i_renamed, android.util.TypedValue typedValue, int i2, androidx.core.a_renamed.a_renamed.f_renamed.a_renamed aVar) throws android.content.res.Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a_renamed(context, i_renamed, typedValue, i2, aVar, null, true);
    }

    private static android.graphics.Typeface a_renamed(android.content.Context context, int i_renamed, android.util.TypedValue typedValue, int i2, androidx.core.a_renamed.a_renamed.f_renamed.a_renamed aVar, android.os.Handler handler, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = context.getResources();
        resources.getValue(i_renamed, typedValue, true);
        android.graphics.Typeface typefaceA = a_renamed(context, resources, typedValue, i_renamed, i2, aVar, handler, z_renamed);
        if (typefaceA != null || aVar != null) {
            return typefaceA;
        }
        throw new android.content.res.Resources.NotFoundException("Font resource ID_renamed #0x" + java.lang.Integer.toHexString(i_renamed) + " could not be_renamed retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface a_renamed(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, androidx.core.a_renamed.a_renamed.f_renamed.a_renamed r20, android.os.Handler r21, boolean r22) {
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
            android.graphics.Typeface r1 = androidx.core.graphics.f_renamed.a_renamed(r0, r4, r5)
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
            androidx.core.a_renamed.a_renamed.c_renamed$a_renamed r2 = androidx.core.a_renamed.a_renamed.c_renamed.a_renamed(r1, r0)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
            if (r2 != 0) goto L55
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e_renamed(r11, r0)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
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
            android.graphics.Typeface r0 = androidx.core.graphics.f_renamed.a_renamed(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
            return r0
        L67:
            r1 = r15
            android.graphics.Typeface r0 = androidx.core.graphics.f_renamed.a_renamed(r15, r0, r4, r12, r5)     // Catch: java.io.IOException -> L78 org.xmlpull.v1.XmlPullParserException -> L8e
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
            android.util.Log.e_renamed(r11, r1, r0)
            goto La3
        L8e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e_renamed(r11, r1, r0)
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
            java.lang.String r0 = ") is_renamed not a_renamed Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.a_renamed.a_renamed.f_renamed.a_renamed(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.a_renamed.a_renamed.f_renamed$a_renamed, android.os.Handler, boolean):android.graphics.Typeface");
    }
}
