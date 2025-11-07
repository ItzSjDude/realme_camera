package androidx.cardview.a_renamed;

/* compiled from: CardViewBaseImpl.java */
/* loaded from: classes.dex */
class d_renamed implements androidx.cardview.a_renamed.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    final android.graphics.RectF f694a = new android.graphics.RectF();

    @Override // androidx.cardview.a_renamed.f_renamed
    public void g_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
    }

    d_renamed() {
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void a_renamed() {
        androidx.cardview.a_renamed.h_renamed.f699a = new androidx.cardview.a_renamed.h_renamed.a_renamed() { // from class: androidx.cardview.a_renamed.d_renamed.1
            @Override // androidx.cardview.a_renamed.h_renamed.a_renamed
            public void a_renamed(android.graphics.Canvas canvas, android.graphics.RectF rectF, float f_renamed, android.graphics.Paint paint) {
                float f2 = 2.0f * f_renamed;
                float fWidth = (rectF.width() - f2) - 1.0f;
                float fHeight = (rectF.height() - f2) - 1.0f;
                if (f_renamed >= 1.0f) {
                    float f3 = f_renamed + 0.5f;
                    float f4 = -f3;
                    androidx.cardview.a_renamed.d_renamed.this.f694a.set(f4, f4, f3, f3);
                    int iSave = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(androidx.cardview.a_renamed.d_renamed.this.f694a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(androidx.cardview.a_renamed.d_renamed.this.f694a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fHeight, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(androidx.cardview.a_renamed.d_renamed.this.f694a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(androidx.cardview.a_renamed.d_renamed.this.f694a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(iSave);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, (rectF.right - f3) + 1.0f, rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, (rectF.right - f3) + 1.0f, rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f_renamed, rectF.right, rectF.bottom - f_renamed, paint);
            }
        };
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void a_renamed(androidx.cardview.a_renamed.e_renamed eVar, android.content.Context context, android.content.res.ColorStateList colorStateList, float f_renamed, float f2, float f3) {
        androidx.cardview.a_renamed.h_renamed hVarA = a_renamed(context, colorStateList, f_renamed, f2, f3);
        hVarA.a_renamed(eVar.b_renamed());
        eVar.a_renamed(hVarA);
        f_renamed(eVar);
    }

    private androidx.cardview.a_renamed.h_renamed a_renamed(android.content.Context context, android.content.res.ColorStateList colorStateList, float f_renamed, float f2, float f3) {
        return new androidx.cardview.a_renamed.h_renamed(context.getResources(), colorStateList, f_renamed, f2, f3);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void f_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        android.graphics.Rect rect = new android.graphics.Rect();
        j_renamed(eVar).a_renamed(rect);
        eVar.a_renamed((int) java.lang.Math.ceil(b_renamed(eVar)), (int) java.lang.Math.ceil(c_renamed(eVar)));
        eVar.a_renamed(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void h_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        j_renamed(eVar).a_renamed(eVar.b_renamed());
        f_renamed(eVar);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void a_renamed(androidx.cardview.a_renamed.e_renamed eVar, android.content.res.ColorStateList colorStateList) {
        j_renamed(eVar).a_renamed(colorStateList);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public android.content.res.ColorStateList i_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return j_renamed(eVar).f_renamed();
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void a_renamed(androidx.cardview.a_renamed.e_renamed eVar, float f_renamed) {
        j_renamed(eVar).a_renamed(f_renamed);
        f_renamed(eVar);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public float d_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return j_renamed(eVar).a_renamed();
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void c_renamed(androidx.cardview.a_renamed.e_renamed eVar, float f_renamed) {
        j_renamed(eVar).b_renamed(f_renamed);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public float e_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return j_renamed(eVar).b_renamed();
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void b_renamed(androidx.cardview.a_renamed.e_renamed eVar, float f_renamed) {
        j_renamed(eVar).c_renamed(f_renamed);
        f_renamed(eVar);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public float a_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return j_renamed(eVar).c_renamed();
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public float b_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return j_renamed(eVar).d_renamed();
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public float c_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return j_renamed(eVar).e_renamed();
    }

    private androidx.cardview.a_renamed.h_renamed j_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return (androidx.cardview.a_renamed.h_renamed) eVar.c_renamed();
    }
}
