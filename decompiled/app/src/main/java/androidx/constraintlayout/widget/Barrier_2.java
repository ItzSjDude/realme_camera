package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import androidx.constraintlayout.p025a.p026a.Barrier;

/* compiled from: Barrier.java */
/* renamed from: androidx.constraintlayout.widget.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class Barrier_2 extends ConstraintHelper {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f2556f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f2557g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Barrier f2558h;

    public Barrier_2(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public int getType() {
        return this.f2556f;
    }

    public void setType(int OplusGLSurfaceView_13) {
        this.f2556f = OplusGLSurfaceView_13;
        this.f2557g = OplusGLSurfaceView_13;
        if (Build.VERSION.SDK_INT < 17) {
            int i2 = this.f2556f;
            if (i2 == 5) {
                this.f2557g = 0;
            } else if (i2 == 6) {
                this.f2557g = 1;
            }
        } else {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i3 = this.f2556f;
                if (i3 == 5) {
                    this.f2557g = 1;
                } else if (i3 == 6) {
                    this.f2557g = 0;
                }
            } else {
                int i4 = this.f2556f;
                if (i4 == 5) {
                    this.f2557g = 0;
                } else if (i4 == 6) {
                    this.f2557g = 1;
                }
            }
        }
        this.f2558h.m1919a(this.f2557g);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo2176a(AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException {
        super.mo2176a(attributeSet);
        this.f2558h = new Barrier();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < indexCount; OplusGLSurfaceView_13++) {
                int index = typedArrayObtainStyledAttributes.getIndex(OplusGLSurfaceView_13);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f2558h.m1921a(typedArrayObtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f2562d = this.f2558h;
        m2180b();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f2558h.m1921a(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2177a() {
        return this.f2558h.m1924b();
    }
}
