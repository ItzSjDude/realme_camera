package androidx.transition;

/* compiled from: RectEvaluator.java */
/* loaded from: classes.dex */
class j_renamed implements android.animation.TypeEvaluator<android.graphics.Rect> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Rect f1726a;

    j_renamed() {
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public android.graphics.Rect evaluate(float f_renamed, android.graphics.Rect rect, android.graphics.Rect rect2) {
        int i_renamed = rect.left + ((int) ((rect2.left - rect.left) * f_renamed));
        int i2 = rect.top + ((int) ((rect2.top - rect.top) * f_renamed));
        int i3 = rect.right + ((int) ((rect2.right - rect.right) * f_renamed));
        int i4 = rect.bottom + ((int) ((rect2.bottom - rect.bottom) * f_renamed));
        android.graphics.Rect rect3 = this.f1726a;
        if (rect3 == null) {
            return new android.graphics.Rect(i_renamed, i2, i3, i4);
        }
        rect3.set(i_renamed, i2, i3, i4);
        return this.f1726a;
    }
}
