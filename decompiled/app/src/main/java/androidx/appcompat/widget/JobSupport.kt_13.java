package androidx.appcompat.widget;

/* compiled from: VectorEnabledTintResources.java */
/* loaded from: classes.dex */
public class aw_renamed extends android.content.res.Resources {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static boolean f596a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.ref.WeakReference<android.content.Context> f597b;

    public static boolean a_renamed() {
        return b_renamed() && android.os.Build.VERSION.SDK_INT <= 20;
    }

    public aw_renamed(android.content.Context context, android.content.res.Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f597b = new java.lang.ref.WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawable(int i_renamed) throws android.content.res.Resources.NotFoundException {
        android.content.Context context = this.f597b.get();
        if (context != null) {
            return androidx.appcompat.widget.ah_renamed.a_renamed().a_renamed(context, this, i_renamed);
        }
        return super.getDrawable(i_renamed);
    }

    final android.graphics.drawable.Drawable a_renamed(int i_renamed) {
        return super.getDrawable(i_renamed);
    }

    public static boolean b_renamed() {
        return f596a;
    }
}
