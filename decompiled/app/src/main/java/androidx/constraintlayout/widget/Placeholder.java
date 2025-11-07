package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: Placeholder.java */
/* renamed from: androidx.constraintlayout.widget.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class Placeholder extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f2656a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private View f2657b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f2658c;

    public void setEmptyVisibility(int OplusGLSurfaceView_13) {
        this.f2658c = OplusGLSurfaceView_13;
    }

    public int getEmptyVisibility() {
        return this.f2658c;
    }

    public View getContent() {
        return this.f2657b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2207a(ConstraintLayout constraintLayout) {
        if (this.f2656a == -1 && !isInEditMode()) {
            setVisibility(this.f2658c);
        }
        this.f2657b = constraintLayout.findViewById(this.f2656a);
        View view = this.f2657b;
        if (view != null) {
            ((ConstraintLayout.C0398a) view.getLayoutParams()).f2480aa = true;
            this.f2657b.setVisibility(0);
            setVisibility(0);
        }
    }

    public void setContentId(int OplusGLSurfaceView_13) {
        View viewFindViewById;
        if (this.f2656a == OplusGLSurfaceView_13) {
            return;
        }
        View view = this.f2657b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.C0398a) this.f2657b.getLayoutParams()).f2480aa = false;
            this.f2657b = null;
        }
        this.f2656a = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 == -1 || (viewFindViewById = ((View) getParent()).findViewById(OplusGLSurfaceView_13)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2208b(ConstraintLayout constraintLayout) {
        if (this.f2657b == null) {
            return;
        }
        ConstraintLayout.C0398a c0398a = (ConstraintLayout.C0398a) getLayoutParams();
        ConstraintLayout.C0398a c0398a2 = (ConstraintLayout.C0398a) this.f2657b.getLayoutParams();
        c0398a2.f2491al.m1988e(0);
        c0398a.f2491al.m2000j(c0398a2.f2491al.m2013q());
        c0398a.f2491al.m2002k(c0398a2.f2491al.m2017s());
        c0398a2.f2491al.m1988e(8);
    }
}
