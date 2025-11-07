package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: Constraints.java */
/* renamed from: androidx.constraintlayout.widget.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class Constraints extends ViewGroup {

    /* renamed from: PlatformImplementations.kt_3 */
    ConstraintSet f2642a;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PlatformImplementations.kt_3 generateLayoutParams(AttributeSet attributeSet) {
        return new PlatformImplementations.kt_3(getContext(), attributeSet);
    }

    /* compiled from: Constraints.java */
    /* renamed from: androidx.constraintlayout.widget.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 extends ConstraintLayout.C0398a {

        /* renamed from: an */
        public float f2643an;

        /* renamed from: ao */
        public boolean f2644ao;

        /* renamed from: ap */
        public float f2645ap;

        /* renamed from: aq */
        public float f2646aq;

        /* renamed from: ar */
        public float f2647ar;

        /* renamed from: as */
        public float f2648as;

        /* renamed from: at */
        public float f2649at;

        /* renamed from: au */
        public float f2650au;

        /* renamed from: av */
        public float f2651av;

        /* renamed from: aw */
        public float f2652aw;

        /* renamed from: ax */
        public float f2653ax;

        /* renamed from: ay */
        public float f2654ay;

        /* renamed from: az */
        public float f2655az;

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f2643an = 1.0f;
            this.f2644ao = false;
            this.f2645ap = 0.0f;
            this.f2646aq = 0.0f;
            this.f2647ar = 0.0f;
            this.f2648as = 0.0f;
            this.f2649at = 1.0f;
            this.f2650au = 1.0f;
            this.f2651av = 0.0f;
            this.f2652aw = 0.0f;
            this.f2653ax = 0.0f;
            this.f2654ay = 0.0f;
            this.f2655az = 0.0f;
        }

        public PlatformImplementations.kt_3(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2643an = 1.0f;
            this.f2644ao = false;
            this.f2645ap = 0.0f;
            this.f2646aq = 0.0f;
            this.f2647ar = 0.0f;
            this.f2648as = 0.0f;
            this.f2649at = 1.0f;
            this.f2650au = 1.0f;
            this.f2651av = 0.0f;
            this.f2652aw = 0.0f;
            this.f2653ax = 0.0f;
            this.f2654ay = 0.0f;
            this.f2655az = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < indexCount; OplusGLSurfaceView_13++) {
                int index = typedArrayObtainStyledAttributes.getIndex(OplusGLSurfaceView_13);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.f2643an = typedArrayObtainStyledAttributes.getFloat(index, this.f2643an);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    this.f2645ap = typedArrayObtainStyledAttributes.getFloat(index, this.f2645ap);
                    this.f2644ao = true;
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.f2647ar = typedArrayObtainStyledAttributes.getFloat(index, this.f2647ar);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.f2648as = typedArrayObtainStyledAttributes.getFloat(index, this.f2648as);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.f2646aq = typedArrayObtainStyledAttributes.getFloat(index, this.f2646aq);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.f2649at = typedArrayObtainStyledAttributes.getFloat(index, this.f2649at);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.f2650au = typedArrayObtainStyledAttributes.getFloat(index, this.f2650au);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.f2651av = typedArrayObtainStyledAttributes.getFloat(index, this.f2651av);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.f2652aw = typedArrayObtainStyledAttributes.getFloat(index, this.f2652aw);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.f2653ax = typedArrayObtainStyledAttributes.getFloat(index, this.f2653ax);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.f2654ay = typedArrayObtainStyledAttributes.getFloat(index, this.f2654ay);
                } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                    this.f2653ax = typedArrayObtainStyledAttributes.getFloat(index, this.f2655az);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PlatformImplementations.kt_3 generateDefaultLayoutParams() {
        return new PlatformImplementations.kt_3(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.C0398a(layoutParams);
    }

    public ConstraintSet getConstraintSet() {
        if (this.f2642a == null) {
            this.f2642a = new ConstraintSet();
        }
        this.f2642a.m2193a(this);
        return this.f2642a;
    }
}
