package androidx.transition;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
class ad_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final android.util.Property<android.view.View, java.lang.Float> f1666a;

    /* renamed from: b_renamed, reason: collision with root package name */
    static final android.util.Property<android.view.View, android.graphics.Rect> f1667b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final androidx.transition.aj_renamed f1668c;

    static {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            f1668c = new androidx.transition.ai_renamed();
        } else if (android.os.Build.VERSION.SDK_INT >= 23) {
            f1668c = new androidx.transition.ah_renamed();
        } else if (android.os.Build.VERSION.SDK_INT >= 22) {
            f1668c = new androidx.transition.ag_renamed();
        } else if (android.os.Build.VERSION.SDK_INT >= 21) {
            f1668c = new androidx.transition.af_renamed();
        } else if (android.os.Build.VERSION.SDK_INT >= 19) {
            f1668c = new androidx.transition.ae_renamed();
        } else {
            f1668c = new androidx.transition.aj_renamed();
        }
        f1666a = new android.util.Property<android.view.View, java.lang.Float>(java.lang.Float.class, "translationAlpha") { // from class: androidx.transition.ad_renamed.1
            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public java.lang.Float get(android.view.View view) {
                return java.lang.Float.valueOf(androidx.transition.ad_renamed.c_renamed(view));
            }

            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public void set(android.view.View view, java.lang.Float f_renamed) {
                androidx.transition.ad_renamed.a_renamed(view, f_renamed.floatValue());
            }
        };
        f1667b = new android.util.Property<android.view.View, android.graphics.Rect>(android.graphics.Rect.class, "clipBounds") { // from class: androidx.transition.ad_renamed.2
            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public android.graphics.Rect get(android.view.View view) {
                return androidx.core.h_renamed.v_renamed.C_renamed(view);
            }

            @Override // android.util.Property
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public void set(android.view.View view, android.graphics.Rect rect) {
                androidx.core.h_renamed.v_renamed.a_renamed(view, rect);
            }
        };
    }

    static androidx.transition.ac_renamed a_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            return new androidx.transition.ab_renamed(view);
        }
        return androidx.transition.aa_renamed.d_renamed(view);
    }

    static androidx.transition.an_renamed b_renamed(android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 18) {
            return new androidx.transition.am_renamed(view);
        }
        return new androidx.transition.al_renamed(view.getWindowToken());
    }

    static void a_renamed(android.view.View view, float f_renamed) {
        f1668c.a_renamed(view, f_renamed);
    }

    static float c_renamed(android.view.View view) {
        return f1668c.a_renamed(view);
    }

    static void d_renamed(android.view.View view) {
        f1668c.b_renamed(view);
    }

    static void e_renamed(android.view.View view) {
        f1668c.c_renamed(view);
    }

    static void a_renamed(android.view.View view, int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        f1668c.a_renamed(view, i_renamed);
    }

    static void a_renamed(android.view.View view, android.graphics.Matrix matrix) {
        f1668c.a_renamed(view, matrix);
    }

    static void b_renamed(android.view.View view, android.graphics.Matrix matrix) {
        f1668c.b_renamed(view, matrix);
    }

    static void a_renamed(android.view.View view, int i_renamed, int i2, int i3, int i4) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        f1668c.a_renamed(view, i_renamed, i2, i3, i4);
    }
}
