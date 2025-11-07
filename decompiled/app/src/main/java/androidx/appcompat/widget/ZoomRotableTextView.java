package androidx.appcompat.widget;

/* compiled from: ResourceManagerInternal.java */
/* loaded from: classes.dex */
public final class ah_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private static androidx.appcompat.widget.ah_renamed f548b;
    private java.util.WeakHashMap<android.content.Context, androidx.collection.SparseArrayCompat<android.content.res.ColorStateList>> d_renamed;
    private androidx.collection.ArrayMap<java.lang.String, androidx.appcompat.widget.ah_renamed.d_renamed> e_renamed;
    private androidx.collection.SparseArrayCompat<java.lang.String> f_renamed;
    private final java.util.WeakHashMap<android.content.Context, androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>>> g_renamed = new java.util.WeakHashMap<>(0);
    private android.util.TypedValue h_renamed;
    private boolean i_renamed;
    private androidx.appcompat.widget.ah_renamed.e_renamed j_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.graphics.PorterDuff.Mode f547a = android.graphics.PorterDuff.Mode.SRC_IN;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final androidx.appcompat.widget.ah_renamed.c_renamed f549c = new androidx.appcompat.widget.ah_renamed.c_renamed(6);

    /* compiled from: ResourceManagerInternal.java */
    private interface d_renamed {
        android.graphics.drawable.Drawable a_renamed(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme);
    }

    /* compiled from: ResourceManagerInternal.java */
    interface e_renamed {
        android.content.res.ColorStateList a_renamed(android.content.Context context, int i_renamed);

        android.graphics.PorterDuff.Mode a_renamed(int i_renamed);

        android.graphics.drawable.Drawable a_renamed(androidx.appcompat.widget.ah_renamed ahVar, android.content.Context context, int i_renamed);

        boolean a_renamed(android.content.Context context, int i_renamed, android.graphics.drawable.Drawable drawable);

        boolean b_renamed(android.content.Context context, int i_renamed, android.graphics.drawable.Drawable drawable);
    }

    public static synchronized androidx.appcompat.widget.ah_renamed a_renamed() {
        if (f548b == null) {
            f548b = new androidx.appcompat.widget.ah_renamed();
            a_renamed(f548b);
        }
        return f548b;
    }

    private static void a_renamed(androidx.appcompat.widget.ah_renamed ahVar) {
        if (android.os.Build.VERSION.SDK_INT < 24) {
            ahVar.a_renamed("vector", new androidx.appcompat.widget.ah_renamed.f_renamed());
            ahVar.a_renamed("animated-vector", new androidx.appcompat.widget.ah_renamed.b_renamed());
            ahVar.a_renamed("animated-selector", new androidx.appcompat.widget.ah_renamed.a_renamed());
        }
    }

    public synchronized void a_renamed(androidx.appcompat.widget.ah_renamed.e_renamed eVar) {
        this.j_renamed = eVar;
    }

    public synchronized android.graphics.drawable.Drawable a_renamed(android.content.Context context, int i_renamed) {
        return a_renamed(context, i_renamed, false);
    }

    synchronized android.graphics.drawable.Drawable a_renamed(android.content.Context context, int i_renamed, boolean z_renamed) {
        android.graphics.drawable.Drawable drawableD;
        b_renamed(context);
        drawableD = d_renamed(context, i_renamed);
        if (drawableD == null) {
            drawableD = c_renamed(context, i_renamed);
        }
        if (drawableD == null) {
            drawableD = androidx.core.a_renamed.a_renamed.a_renamed(context, i_renamed);
        }
        if (drawableD != null) {
            drawableD = a_renamed(context, i_renamed, z_renamed, drawableD);
        }
        if (drawableD != null) {
            androidx.appcompat.widget.aa_renamed.b_renamed(drawableD);
        }
        return drawableD;
    }

    public synchronized void a_renamed(android.content.Context context) {
        androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>> longSparseArray = this.g_renamed.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    private static long a_renamed(android.util.TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private android.graphics.drawable.Drawable c_renamed(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (this.h_renamed == null) {
            this.h_renamed = new android.util.TypedValue();
        }
        android.util.TypedValue typedValue = this.h_renamed;
        context.getResources().getValue(i_renamed, typedValue, true);
        long jA = a_renamed(typedValue);
        android.graphics.drawable.Drawable drawableA = a_renamed(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        androidx.appcompat.widget.ah_renamed.e_renamed eVar = this.j_renamed;
        android.graphics.drawable.Drawable drawableA2 = eVar == null ? null : eVar.a_renamed(this, context, i_renamed);
        if (drawableA2 != null) {
            drawableA2.setChangingConfigurations(typedValue.changingConfigurations);
            a_renamed(context, jA, drawableA2);
        }
        return drawableA2;
    }

    private android.graphics.drawable.Drawable a_renamed(android.content.Context context, int i_renamed, boolean z_renamed, android.graphics.drawable.Drawable drawable) {
        android.content.res.ColorStateList colorStateListB = b_renamed(context, i_renamed);
        if (colorStateListB != null) {
            if (androidx.appcompat.widget.aa_renamed.c_renamed(drawable)) {
                drawable = drawable.mutate();
            }
            android.graphics.drawable.Drawable drawableG = androidx.core.graphics.drawable.a_renamed.g_renamed(drawable);
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawableG, colorStateListB);
            android.graphics.PorterDuff.Mode modeA = a_renamed(i_renamed);
            if (modeA == null) {
                return drawableG;
            }
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawableG, modeA);
            return drawableG;
        }
        androidx.appcompat.widget.ah_renamed.e_renamed eVar = this.j_renamed;
        if ((eVar == null || !eVar.a_renamed(context, i_renamed, drawable)) && !a_renamed(context, i_renamed, drawable) && z_renamed) {
            return null;
        }
        return drawable;
    }

    private android.graphics.drawable.Drawable d_renamed(android.content.Context context, int i_renamed) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        int next;
        androidx.collection.ArrayMap<java.lang.String, androidx.appcompat.widget.ah_renamed.d_renamed> arrayMap = this.e_renamed;
        if (arrayMap == null || arrayMap.isEmpty()) {
            return null;
        }
        androidx.collection.SparseArrayCompat<java.lang.String> sparseArrayCompat = this.f_renamed;
        if (sparseArrayCompat != null) {
            java.lang.String str = sparseArrayCompat.get(i_renamed);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.e_renamed.get(str) == null)) {
                return null;
            }
        } else {
            this.f_renamed = new androidx.collection.SparseArrayCompat<>();
        }
        if (this.h_renamed == null) {
            this.h_renamed = new android.util.TypedValue();
        }
        android.util.TypedValue typedValue = this.h_renamed;
        android.content.res.Resources resources = context.getResources();
        resources.getValue(i_renamed, typedValue, true);
        long jA = a_renamed(typedValue);
        android.graphics.drawable.Drawable drawableA = a_renamed(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                android.content.res.XmlResourceParser xml = resources.getXml(i_renamed);
                android.util.AttributeSet attributeSetAsAttributeSet = android.util.Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
                }
                java.lang.String name = xml.getName();
                this.f_renamed.append(i_renamed, name);
                androidx.appcompat.widget.ah_renamed.d_renamed dVar = this.e_renamed.get(name);
                if (dVar != null) {
                    drawableA = dVar.a_renamed(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableA != null) {
                    drawableA.setChangingConfigurations(typedValue.changingConfigurations);
                    a_renamed(context, jA, drawableA);
                }
            } catch (java.lang.Exception e2) {
                android.util.Log.e_renamed("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (drawableA == null) {
            this.f_renamed.append(i_renamed, "appcompat_skip_skip");
        }
        return drawableA;
    }

    private synchronized android.graphics.drawable.Drawable a_renamed(android.content.Context context, long j_renamed) {
        androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>> longSparseArray = this.g_renamed.get(context);
        if (longSparseArray == null) {
            return null;
        }
        java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState> weakReference = longSparseArray.get(j_renamed);
        if (weakReference != null) {
            android.graphics.drawable.Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.delete(j_renamed);
        }
        return null;
    }

    private synchronized boolean a_renamed(android.content.Context context, long j_renamed, android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable.ConstantState>> longSparseArray = this.g_renamed.get(context);
        if (longSparseArray == null) {
            longSparseArray = new androidx.collection.LongSparseArray<>();
            this.g_renamed.put(context, longSparseArray);
        }
        longSparseArray.put(j_renamed, new java.lang.ref.WeakReference<>(constantState));
        return true;
    }

    synchronized android.graphics.drawable.Drawable a_renamed(android.content.Context context, androidx.appcompat.widget.aw_renamed awVar, int i_renamed) {
        android.graphics.drawable.Drawable drawableD = d_renamed(context, i_renamed);
        if (drawableD == null) {
            drawableD = awVar.a_renamed(i_renamed);
        }
        if (drawableD == null) {
            return null;
        }
        return a_renamed(context, i_renamed, false, drawableD);
    }

    boolean a_renamed(android.content.Context context, int i_renamed, android.graphics.drawable.Drawable drawable) {
        androidx.appcompat.widget.ah_renamed.e_renamed eVar = this.j_renamed;
        return eVar != null && eVar.b_renamed(context, i_renamed, drawable);
    }

    private void a_renamed(java.lang.String str, androidx.appcompat.widget.ah_renamed.d_renamed dVar) {
        if (this.e_renamed == null) {
            this.e_renamed = new androidx.collection.ArrayMap<>();
        }
        this.e_renamed.put(str, dVar);
    }

    android.graphics.PorterDuff.Mode a_renamed(int i_renamed) {
        androidx.appcompat.widget.ah_renamed.e_renamed eVar = this.j_renamed;
        if (eVar == null) {
            return null;
        }
        return eVar.a_renamed(i_renamed);
    }

    synchronized android.content.res.ColorStateList b_renamed(android.content.Context context, int i_renamed) {
        android.content.res.ColorStateList colorStateListE;
        colorStateListE = e_renamed(context, i_renamed);
        if (colorStateListE == null) {
            colorStateListE = this.j_renamed == null ? null : this.j_renamed.a_renamed(context, i_renamed);
            if (colorStateListE != null) {
                a_renamed(context, i_renamed, colorStateListE);
            }
        }
        return colorStateListE;
    }

    private android.content.res.ColorStateList e_renamed(android.content.Context context, int i_renamed) {
        androidx.collection.SparseArrayCompat<android.content.res.ColorStateList> sparseArrayCompat;
        java.util.WeakHashMap<android.content.Context, androidx.collection.SparseArrayCompat<android.content.res.ColorStateList>> weakHashMap = this.d_renamed;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return sparseArrayCompat.get(i_renamed);
    }

    private void a_renamed(android.content.Context context, int i_renamed, android.content.res.ColorStateList colorStateList) {
        if (this.d_renamed == null) {
            this.d_renamed = new java.util.WeakHashMap<>();
        }
        androidx.collection.SparseArrayCompat<android.content.res.ColorStateList> sparseArrayCompat = this.d_renamed.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new androidx.collection.SparseArrayCompat<>();
            this.d_renamed.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i_renamed, colorStateList);
    }

    /* compiled from: ResourceManagerInternal.java */
    private static class c_renamed extends androidx.collection.LruCache<java.lang.Integer, android.graphics.PorterDuffColorFilter> {
        public c_renamed(int i_renamed) {
            super(i_renamed);
        }

        android.graphics.PorterDuffColorFilter a_renamed(int i_renamed, android.graphics.PorterDuff.Mode mode) {
            return get(java.lang.Integer.valueOf(b_renamed(i_renamed, mode)));
        }

        android.graphics.PorterDuffColorFilter a_renamed(int i_renamed, android.graphics.PorterDuff.Mode mode, android.graphics.PorterDuffColorFilter porterDuffColorFilter) {
            return put(java.lang.Integer.valueOf(b_renamed(i_renamed, mode)), porterDuffColorFilter);
        }

        private static int b_renamed(int i_renamed, android.graphics.PorterDuff.Mode mode) {
            return ((i_renamed + 31) * 31) + mode.hashCode();
        }
    }

    static void a_renamed(android.graphics.drawable.Drawable drawable, androidx.appcompat.widget.ap_renamed apVar, int[] iArr) {
        if (androidx.appcompat.widget.aa_renamed.c_renamed(drawable) && drawable.mutate() != drawable) {
            android.util.Log.d_renamed("ResourceManagerInternal", "Mutated drawable is_renamed not the same instance as_renamed the input.");
            return;
        }
        if (apVar.d_renamed || apVar.f575c) {
            drawable.setColorFilter(a_renamed(apVar.d_renamed ? apVar.f573a : null, apVar.f575c ? apVar.f574b : f547a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (android.os.Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    private static android.graphics.PorterDuffColorFilter a_renamed(android.content.res.ColorStateList colorStateList, android.graphics.PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a_renamed(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized android.graphics.PorterDuffColorFilter a_renamed(int i_renamed, android.graphics.PorterDuff.Mode mode) {
        android.graphics.PorterDuffColorFilter porterDuffColorFilterA;
        porterDuffColorFilterA = f549c.a_renamed(i_renamed, mode);
        if (porterDuffColorFilterA == null) {
            porterDuffColorFilterA = new android.graphics.PorterDuffColorFilter(i_renamed, mode);
            f549c.a_renamed(i_renamed, mode, porterDuffColorFilterA);
        }
        return porterDuffColorFilterA;
    }

    private void b_renamed(android.content.Context context) {
        if (this.i_renamed) {
            return;
        }
        this.i_renamed = true;
        android.graphics.drawable.Drawable drawableA = a_renamed(context, androidx.appcompat.resources.R_renamed.drawable.abc_vector_test);
        if (drawableA == null || !a_renamed(drawableA)) {
            this.i_renamed = false;
            throw new java.lang.IllegalStateException("This app has been built with an_renamed incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static boolean a_renamed(android.graphics.drawable.Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.a_renamed.a_renamed.i_renamed) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* compiled from: ResourceManagerInternal.java */
    private static class f_renamed implements androidx.appcompat.widget.ah_renamed.d_renamed {
        f_renamed() {
        }

        @Override // androidx.appcompat.widget.ah_renamed.d_renamed
        public android.graphics.drawable.Drawable a_renamed(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) {
            try {
                return androidx.vectordrawable.a_renamed.a_renamed.i_renamed.a_renamed(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.e_renamed("VdcInflateDelegate", "Exception while inflating <vector>", e_renamed);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    private static class b_renamed implements androidx.appcompat.widget.ah_renamed.d_renamed {
        b_renamed() {
        }

        @Override // androidx.appcompat.widget.ah_renamed.d_renamed
        public android.graphics.drawable.Drawable a_renamed(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) {
            try {
                return androidx.vectordrawable.a_renamed.a_renamed.c_renamed.a_renamed(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.e_renamed("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e_renamed);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    static class a_renamed implements androidx.appcompat.widget.ah_renamed.d_renamed {
        a_renamed() {
        }

        @Override // androidx.appcompat.widget.ah_renamed.d_renamed
        public android.graphics.drawable.Drawable a_renamed(android.content.Context context, org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.content.res.Resources.Theme theme) {
            try {
                return androidx.appcompat.b_renamed.a_renamed.a_renamed.a_renamed(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.e_renamed("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e_renamed);
                return null;
            }
        }
    }
}
