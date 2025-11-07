package androidx.constraintlayout.widget;

/* compiled from: Placeholder.java */
/* loaded from: classes.dex */
public class f_renamed extends android.view.View {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f766a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.view.View f767b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f768c;

    public void setEmptyVisibility(int i_renamed) {
        this.f768c = i_renamed;
    }

    public int getEmptyVisibility() {
        return this.f768c;
    }

    public android.view.View getContent() {
        return this.f767b;
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            android.graphics.Paint paint = new android.graphics.Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(android.graphics.Paint.Align.CENTER);
            paint.setTypeface(android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, 0));
            android.graphics.Rect rect = new android.graphics.Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(android.graphics.Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void a_renamed(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        if (this.f766a == -1 && !isInEditMode()) {
            setVisibility(this.f768c);
        }
        this.f767b = constraintLayout.findViewById(this.f766a);
        android.view.View view = this.f767b;
        if (view != null) {
            ((androidx.constraintlayout.widget.ConstraintLayout.a_renamed) view.getLayoutParams()).aa_renamed = true;
            this.f767b.setVisibility(0);
            setVisibility(0);
        }
    }

    public void setContentId(int i_renamed) {
        android.view.View viewFindViewById;
        if (this.f766a == i_renamed) {
            return;
        }
        android.view.View view = this.f767b;
        if (view != null) {
            view.setVisibility(0);
            ((androidx.constraintlayout.widget.ConstraintLayout.a_renamed) this.f767b.getLayoutParams()).aa_renamed = false;
            this.f767b = null;
        }
        this.f766a = i_renamed;
        if (i_renamed == -1 || (viewFindViewById = ((android.view.View) getParent()).findViewById(i_renamed)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void b_renamed(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        if (this.f767b == null) {
            return;
        }
        androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) getLayoutParams();
        androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar2 = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) this.f767b.getLayoutParams();
        aVar2.al_renamed.e_renamed(0);
        aVar.al_renamed.j_renamed(aVar2.al_renamed.q_renamed());
        aVar.al_renamed.k_renamed(aVar2.al_renamed.s_renamed());
        aVar2.al_renamed.e_renamed(8);
    }
}
