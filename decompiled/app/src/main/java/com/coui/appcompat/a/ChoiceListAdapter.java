package com.coui.appcompat.a_renamed;

/* compiled from: COUITintManager.java */
/* loaded from: classes.dex */
public final class v_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final boolean f2410a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final android.graphics.PorterDuff.Mode f2411b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.util.WeakHashMap<android.content.Context, com.coui.appcompat.a_renamed.v_renamed> f2412c;
    private static final com.coui.appcompat.a_renamed.v_renamed.a_renamed d_renamed;
    private final java.lang.ref.WeakReference<android.content.Context> e_renamed;
    private android.util.SparseArray<android.content.res.ColorStateList> f_renamed;

    final android.graphics.PorterDuff.Mode b_renamed(int i_renamed) {
        return null;
    }

    static {
        f2410a = android.os.Build.VERSION.SDK_INT < 21;
        f2411b = android.graphics.PorterDuff.Mode.SRC_IN;
        f2412c = new java.util.WeakHashMap<>();
        d_renamed = new com.coui.appcompat.a_renamed.v_renamed.a_renamed(6);
    }

    public static com.coui.appcompat.a_renamed.v_renamed a_renamed(android.content.Context context) {
        com.coui.appcompat.a_renamed.v_renamed vVar = f2412c.get(context);
        if (vVar != null) {
            return vVar;
        }
        com.coui.appcompat.a_renamed.v_renamed vVar2 = new com.coui.appcompat.a_renamed.v_renamed(context);
        f2412c.put(context, vVar2);
        return vVar2;
    }

    private v_renamed(android.content.Context context) {
        this.e_renamed = new java.lang.ref.WeakReference<>(context);
    }

    public android.graphics.drawable.Drawable a_renamed(int i_renamed) {
        return a_renamed(i_renamed, false);
    }

    public android.graphics.drawable.Drawable a_renamed(int i_renamed, boolean z_renamed) {
        android.content.Context context = this.e_renamed.get();
        android.graphics.drawable.Drawable drawableG = null;
        if (context == null) {
            return null;
        }
        android.graphics.drawable.Drawable drawableA = androidx.core.a_renamed.a_renamed.a_renamed(context, i_renamed);
        if (drawableA == null) {
            return drawableA;
        }
        if (android.os.Build.VERSION.SDK_INT >= 8) {
            drawableA = drawableA.mutate();
        }
        android.content.res.ColorStateList colorStateListC = c_renamed(i_renamed);
        if (colorStateListC != null) {
            drawableG = androidx.core.graphics.drawable.a_renamed.g_renamed(drawableA);
            androidx.core.graphics.drawable.a_renamed.a_renamed(drawableG, colorStateListC);
            android.graphics.PorterDuff.Mode modeB = b_renamed(i_renamed);
            if (modeB != null) {
                androidx.core.graphics.drawable.a_renamed.a_renamed(drawableG, modeB);
            }
        } else if (a_renamed(i_renamed, drawableA) || !z_renamed) {
            return drawableA;
        }
        return drawableG;
    }

    public final boolean a_renamed(int i_renamed, android.graphics.drawable.Drawable drawable) {
        if (this.e_renamed.get() == null) {
        }
        return false;
    }

    public final android.content.res.ColorStateList c_renamed(int i_renamed) {
        android.content.Context context = this.e_renamed.get();
        if (context == null) {
            return null;
        }
        android.util.SparseArray<android.content.res.ColorStateList> sparseArray = this.f_renamed;
        android.content.res.ColorStateList colorStateListB = sparseArray != null ? sparseArray.get(i_renamed) : null;
        if (colorStateListB == null) {
            if (i_renamed == coui.support.appcompat.R_renamed.drawable.coui_back_arrow_normal) {
                colorStateListB = b_renamed(context);
            }
            if (colorStateListB != null) {
                if (this.f_renamed == null) {
                    this.f_renamed = new android.util.SparseArray<>();
                }
                this.f_renamed.append(i_renamed, colorStateListB);
            }
        }
        return colorStateListB;
    }

    private android.content.res.ColorStateList b_renamed(android.content.Context context) {
        return new android.content.res.ColorStateList(new int[][]{com.coui.appcompat.a_renamed.u_renamed.f2407a, com.coui.appcompat.a_renamed.u_renamed.d_renamed, com.coui.appcompat.a_renamed.u_renamed.g_renamed}, new int[]{com.coui.appcompat.a_renamed.u_renamed.c_renamed(context, coui.support.appcompat.R_renamed.attr.couiTintControlDisabled), com.coui.appcompat.a_renamed.u_renamed.a_renamed(context, coui.support.appcompat.R_renamed.attr.couiTintControlPressed), com.coui.appcompat.a_renamed.u_renamed.a_renamed(context, coui.support.appcompat.R_renamed.attr.couiTintControlNormal)});
    }

    /* compiled from: COUITintManager.java */
    private static class a_renamed extends androidx.collection.LruCache<java.lang.Integer, android.graphics.PorterDuffColorFilter> {
        public a_renamed(int i_renamed) {
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

    private static void a_renamed(android.graphics.drawable.Drawable drawable, int i_renamed, android.graphics.PorterDuff.Mode mode) {
        if (mode == null) {
            mode = f2411b;
        }
        android.graphics.PorterDuffColorFilter porterDuffColorFilterA = d_renamed.a_renamed(i_renamed, mode);
        if (porterDuffColorFilterA == null) {
            porterDuffColorFilterA = new android.graphics.PorterDuffColorFilter(i_renamed, mode);
            d_renamed.a_renamed(i_renamed, mode, porterDuffColorFilterA);
        }
        drawable.setColorFilter(porterDuffColorFilterA);
    }
}
