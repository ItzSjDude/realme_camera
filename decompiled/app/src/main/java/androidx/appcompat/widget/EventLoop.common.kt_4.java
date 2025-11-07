package androidx.appcompat.widget;

/* compiled from: TintResources.java */
/* loaded from: classes.dex */
class aq_renamed extends androidx.appcompat.widget.ai_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.ref.WeakReference<android.content.Context> f576a;

    public aq_renamed(android.content.Context context, android.content.res.Resources resources) {
        super(resources);
        this.f576a = new java.lang.ref.WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.ai_renamed, android.content.res.Resources
    public android.graphics.drawable.Drawable getDrawable(int i_renamed) throws android.content.res.Resources.NotFoundException {
        android.graphics.drawable.Drawable drawable = super.getDrawable(i_renamed);
        android.content.Context context = this.f576a.get();
        if (drawable != null && context != null) {
            androidx.appcompat.widget.ah_renamed.a_renamed().a_renamed(context, i_renamed, drawable);
        }
        return drawable;
    }
}
