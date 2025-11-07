package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R;

/* compiled from: AppCompatRatingBar.java */
/* renamed from: androidx.appcompat.widget.r */
/* loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {

    /* renamed from: PlatformImplementations.kt_3 */
    private final AppCompatProgressBarHelper f1980a;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f1980a = new AppCompatProgressBarHelper(this);
        this.f1980a.mo1696a(attributeSet, OplusGLSurfaceView_13);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        Bitmap bitmapM1695a = this.f1980a.m1695a();
        if (bitmapM1695a != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapM1695a.getWidth() * getNumStars(), OplusGLSurfaceView_13, 0), getMeasuredHeight());
        }
    }
}
