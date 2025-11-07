package androidx.appcompat.widget;

/* compiled from: TintContextWrapper.java */
/* loaded from: classes.dex */
public class ao_renamed extends android.content.ContextWrapper {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.Object f570a = new java.lang.Object();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.util.ArrayList<java.lang.ref.WeakReference<androidx.appcompat.widget.ao_renamed>> f571b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.content.res.Resources f572c;
    private final android.content.res.Resources.Theme d_renamed;

    public static android.content.Context a_renamed(android.content.Context context) {
        if (!b_renamed(context)) {
            return context;
        }
        synchronized (f570a) {
            if (f571b == null) {
                f571b = new java.util.ArrayList<>();
            } else {
                for (int size = f571b.size() - 1; size >= 0; size--) {
                    java.lang.ref.WeakReference<androidx.appcompat.widget.ao_renamed> weakReference = f571b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f571b.remove(size);
                    }
                }
                for (int size2 = f571b.size() - 1; size2 >= 0; size2--) {
                    java.lang.ref.WeakReference<androidx.appcompat.widget.ao_renamed> weakReference2 = f571b.get(size2);
                    androidx.appcompat.widget.ao_renamed aoVar = weakReference2 != null ? weakReference2.get() : null;
                    if (aoVar != null && aoVar.getBaseContext() == context) {
                        return aoVar;
                    }
                }
            }
            androidx.appcompat.widget.ao_renamed aoVar2 = new androidx.appcompat.widget.ao_renamed(context);
            f571b.add(new java.lang.ref.WeakReference<>(aoVar2));
            return aoVar2;
        }
    }

    private static boolean b_renamed(android.content.Context context) {
        if ((context instanceof androidx.appcompat.widget.ao_renamed) || (context.getResources() instanceof androidx.appcompat.widget.aq_renamed) || (context.getResources() instanceof androidx.appcompat.widget.aw_renamed)) {
            return false;
        }
        return android.os.Build.VERSION.SDK_INT < 21 || androidx.appcompat.widget.aw_renamed.a_renamed();
    }

    private ao_renamed(android.content.Context context) {
        super(context);
        if (androidx.appcompat.widget.aw_renamed.a_renamed()) {
            this.f572c = new androidx.appcompat.widget.aw_renamed(this, context.getResources());
            this.d_renamed = this.f572c.newTheme();
            this.d_renamed.setTo(context.getTheme());
        } else {
            this.f572c = new androidx.appcompat.widget.aq_renamed(this, context.getResources());
            this.d_renamed = null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources.Theme getTheme() {
        android.content.res.Resources.Theme theme = this.d_renamed;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i_renamed) {
        android.content.res.Resources.Theme theme = this.d_renamed;
        if (theme == null) {
            super.setTheme(i_renamed);
        } else {
            theme.applyStyle(i_renamed, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources getResources() {
        return this.f572c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.res.AssetManager getAssets() {
        return this.f572c.getAssets();
    }
}
