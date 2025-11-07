package androidx.appcompat.widget;

/* compiled from: ActionBarBackgroundDrawable.java */
/* loaded from: classes.dex */
class b_renamed extends android.graphics.drawable.Drawable {

    /* renamed from: a_renamed, reason: collision with root package name */
    final androidx.appcompat.widget.ActionBarContainer f599a;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i_renamed) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }

    public b_renamed(androidx.appcompat.widget.ActionBarContainer actionBarContainer) {
        this.f599a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (this.f599a.d_renamed) {
            if (this.f599a.f421c != null) {
                this.f599a.f421c.draw(canvas);
            }
        } else {
            if (this.f599a.f419a != null) {
                this.f599a.f419a.draw(canvas);
            }
            if (this.f599a.f420b == null || !this.f599a.e_renamed) {
                return;
            }
            this.f599a.f420b.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(android.graphics.Outline outline) {
        if (this.f599a.d_renamed) {
            if (this.f599a.f421c != null) {
                this.f599a.f421c.getOutline(outline);
            }
        } else if (this.f599a.f419a != null) {
            this.f599a.f419a.getOutline(outline);
        }
    }
}
