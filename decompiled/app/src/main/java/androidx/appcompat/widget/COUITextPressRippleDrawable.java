package androidx.appcompat.widget;

/* compiled from: AppCompatRatingBar.java */
/* loaded from: classes.dex */
public class r_renamed extends android.widget.RatingBar {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.appcompat.widget.p_renamed f634a;

    public r_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.ratingBarStyle);
    }

    public r_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f634a = new androidx.appcompat.widget.p_renamed(this);
        this.f634a.a_renamed(attributeSet, i_renamed);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i_renamed, int i2) {
        super.onMeasure(i_renamed, i2);
        android.graphics.Bitmap bitmapA = this.f634a.a_renamed();
        if (bitmapA != null) {
            setMeasuredDimension(android.view.View.resolveSizeAndState(bitmapA.getWidth() * getNumStars(), i_renamed, 0), getMeasuredHeight());
        }
    }
}
