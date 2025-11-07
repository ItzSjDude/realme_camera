package androidx.core.graphics.drawable;

/* compiled from: WrappedDrawableState.java */
/* loaded from: classes.dex */
final class f_renamed extends android.graphics.drawable.Drawable.ConstantState {

    /* renamed from: a_renamed, reason: collision with root package name */
    int f934a;

    /* renamed from: b_renamed, reason: collision with root package name */
    android.graphics.drawable.Drawable.ConstantState f935b;

    /* renamed from: c_renamed, reason: collision with root package name */
    android.content.res.ColorStateList f936c;
    android.graphics.PorterDuff.Mode d_renamed;

    f_renamed(androidx.core.graphics.drawable.f_renamed fVar) {
        this.f936c = null;
        this.d_renamed = androidx.core.graphics.drawable.d_renamed.f931a;
        if (fVar != null) {
            this.f934a = fVar.f934a;
            this.f935b = fVar.f935b;
            this.f936c = fVar.f936c;
            this.d_renamed = fVar.d_renamed;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public android.graphics.drawable.Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return new androidx.core.graphics.drawable.e_renamed(this, resources);
        }
        return new androidx.core.graphics.drawable.d_renamed(this, resources);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i_renamed = this.f934a;
        android.graphics.drawable.Drawable.ConstantState constantState = this.f935b;
        return (constantState != null ? constantState.getChangingConfigurations() : 0) | i_renamed;
    }

    boolean a_renamed() {
        return this.f935b != null;
    }
}
