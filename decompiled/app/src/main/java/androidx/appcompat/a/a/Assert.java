package androidx.appcompat.a_renamed.a_renamed;

/* compiled from: AppCompatResources.java */
@android.annotation.SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.ThreadLocal<android.util.TypedValue> f196a = new java.lang.ThreadLocal<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.util.WeakHashMap<android.content.Context, android.util.SparseArray<androidx.appcompat.a_renamed.a_renamed.a_renamed.AppCompatResources_2>> f197b = new java.util.WeakHashMap<>(0);

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.lang.Object f198c = new java.lang.Object();

    public static android.content.res.ColorStateList a_renamed(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i_renamed);
        }
        android.content.res.ColorStateList colorStateListD = d_renamed(context, i_renamed);
        if (colorStateListD != null) {
            return colorStateListD;
        }
        android.content.res.ColorStateList colorStateListC = c_renamed(context, i_renamed);
        if (colorStateListC != null) {
            a_renamed(context, i_renamed, colorStateListC);
            return colorStateListC;
        }
        return androidx.core.a_renamed.a_renamed.b_renamed(context, i_renamed);
    }

    public static android.graphics.drawable.Drawable b_renamed(android.content.Context context, int i_renamed) {
        return androidx.appcompat.widget.ah_renamed.a_renamed().a_renamed(context, i_renamed);
    }

    private static android.content.res.ColorStateList c_renamed(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (e_renamed(context, i_renamed)) {
            return null;
        }
        android.content.res.Resources resources = context.getResources();
        try {
            return androidx.core.a_renamed.a_renamed.a_renamed.a_renamed(resources, resources.getXml(i_renamed), context.getTheme());
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e_renamed);
            return null;
        }
    }

    private static android.content.res.ColorStateList d_renamed(android.content.Context context, int i_renamed) {
        androidx.appcompat.a_renamed.a_renamed.a_renamed.AppCompatResources_2 c0001a;
        synchronized (f198c) {
            android.util.SparseArray<androidx.appcompat.a_renamed.a_renamed.a_renamed.AppCompatResources_2> sparseArray = f197b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0001a = sparseArray.get(i_renamed)) != null) {
                if (c0001a.f200b.equals(context.getResources().getConfiguration())) {
                    return c0001a.f199a;
                }
                sparseArray.remove(i_renamed);
            }
            return null;
        }
    }

    private static void a_renamed(android.content.Context context, int i_renamed, android.content.res.ColorStateList colorStateList) {
        synchronized (f198c) {
            android.util.SparseArray<androidx.appcompat.a_renamed.a_renamed.a_renamed.AppCompatResources_2> sparseArray = f197b.get(context);
            if (sparseArray == null) {
                sparseArray = new android.util.SparseArray<>();
                f197b.put(context, sparseArray);
            }
            sparseArray.append(i_renamed, new androidx.appcompat.a_renamed.a_renamed.a_renamed.AppCompatResources_2(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static boolean e_renamed(android.content.Context context, int i_renamed) throws android.content.res.Resources.NotFoundException {
        android.content.res.Resources resources = context.getResources();
        android.util.TypedValue typedValueA = a_renamed();
        resources.getValue(i_renamed, typedValueA, true);
        return typedValueA.type >= 28 && typedValueA.type <= 31;
    }

    private static android.util.TypedValue a_renamed() {
        android.util.TypedValue typedValue = f196a.get();
        if (typedValue != null) {
            return typedValue;
        }
        android.util.TypedValue typedValue2 = new android.util.TypedValue();
        f196a.set(typedValue2);
        return typedValue2;
    }

    /* compiled from: AppCompatResources.java */
    /* renamed from: androidx.appcompat.a_renamed.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static class AppCompatResources_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.content.res.ColorStateList f199a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final android.content.res.Configuration f200b;

        AppCompatResources_2(android.content.res.ColorStateList colorStateList, android.content.res.Configuration configuration) {
            this.f199a = colorStateList;
            this.f200b = configuration;
        }
    }
}
