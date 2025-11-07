package androidx.constraintlayout.widget;

/* compiled from: Guideline.java */
/* loaded from: classes.dex */
public class e_renamed extends android.view.View {
    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i_renamed) {
    }

    public e_renamed(android.content.Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i_renamed) {
        androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) getLayoutParams();
        aVar.f752a = i_renamed;
        setLayoutParams(aVar);
    }

    public void setGuidelineEnd(int i_renamed) {
        androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) getLayoutParams();
        aVar.f753b = i_renamed;
        setLayoutParams(aVar);
    }

    public void setGuidelinePercent(float f_renamed) {
        androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) getLayoutParams();
        aVar.f754c = f_renamed;
        setLayoutParams(aVar);
    }
}
