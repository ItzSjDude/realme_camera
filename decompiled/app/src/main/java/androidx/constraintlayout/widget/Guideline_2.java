package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: Guideline.java */
/* renamed from: androidx.constraintlayout.widget.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class Guideline_2 extends View {
    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
    }

    public Guideline_2(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int OplusGLSurfaceView_13) {
        ConstraintLayout.C0398a c0398a = (ConstraintLayout.C0398a) getLayoutParams();
        c0398a.f2479a = OplusGLSurfaceView_13;
        setLayoutParams(c0398a);
    }

    public void setGuidelineEnd(int OplusGLSurfaceView_13) {
        ConstraintLayout.C0398a c0398a = (ConstraintLayout.C0398a) getLayoutParams();
        c0398a.f2493b = OplusGLSurfaceView_13;
        setLayoutParams(c0398a);
    }

    public void setGuidelinePercent(float COUIBaseListPopupWindow_12) {
        ConstraintLayout.C0398a c0398a = (ConstraintLayout.C0398a) getLayoutParams();
        c0398a.f2494c = COUIBaseListPopupWindow_12;
        setLayoutParams(c0398a);
    }
}
