package androidx.constraintlayout.widget;

/* compiled from: Constraints.java */
/* loaded from: classes.dex */
public class d_renamed extends android.view.ViewGroup {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.constraintlayout.widget.c_renamed f765a;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.constraintlayout.widget.d_renamed.a_renamed generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new androidx.constraintlayout.widget.d_renamed.a_renamed(getContext(), attributeSet);
    }

    /* compiled from: Constraints.java */
    public static class a_renamed extends androidx.constraintlayout.widget.ConstraintLayout.a_renamed {
        public float an_renamed;
        public boolean ao_renamed;
        public float ap_renamed;
        public float aq_renamed;
        public float ar_renamed;
        public float as_renamed;
        public float at_renamed;
        public float au_renamed;
        public float av_renamed;
        public float aw_renamed;
        public float ax_renamed;
        public float ay_renamed;
        public float az_renamed;

        public a_renamed(int i_renamed, int i2) {
            super(i_renamed, i2);
            this.an_renamed = 1.0f;
            this.ao_renamed = false;
            this.ap_renamed = 0.0f;
            this.aq_renamed = 0.0f;
            this.ar_renamed = 0.0f;
            this.as_renamed = 0.0f;
            this.at_renamed = 1.0f;
            this.au_renamed = 1.0f;
            this.av_renamed = 0.0f;
            this.aw_renamed = 0.0f;
            this.ax_renamed = 0.0f;
            this.ay_renamed = 0.0f;
            this.az_renamed = 0.0f;
        }

        public a_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.an_renamed = 1.0f;
            this.ao_renamed = false;
            this.ap_renamed = 0.0f;
            this.aq_renamed = 0.0f;
            this.ar_renamed = 0.0f;
            this.as_renamed = 0.0f;
            this.at_renamed = 1.0f;
            this.au_renamed = 1.0f;
            this.av_renamed = 0.0f;
            this.aw_renamed = 0.0f;
            this.ax_renamed = 0.0f;
            this.ay_renamed = 0.0f;
            this.az_renamed = 0.0f;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i_renamed = 0; i_renamed < indexCount; i_renamed++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i_renamed);
                if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_alpha) {
                    this.an_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.an_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_elevation) {
                    this.ap_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.ap_renamed);
                    this.ao_renamed = true;
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_rotationX) {
                    this.ar_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.ar_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_rotationY) {
                    this.as_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.as_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_rotation) {
                    this.aq_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.aq_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_scaleX) {
                    this.at_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.at_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_scaleY) {
                    this.au_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.au_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_transformPivotX) {
                    this.av_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.av_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_transformPivotY) {
                    this.aw_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.aw_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_translationX) {
                    this.ax_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.ax_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_translationY) {
                    this.ay_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.ay_renamed);
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_translationZ) {
                    this.ax_renamed = typedArrayObtainStyledAttributes.getFloat(index, this.az_renamed);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.constraintlayout.widget.d_renamed.a_renamed generateDefaultLayoutParams() {
        return new androidx.constraintlayout.widget.d_renamed.a_renamed(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new androidx.constraintlayout.widget.ConstraintLayout.a_renamed(layoutParams);
    }

    public androidx.constraintlayout.widget.c_renamed getConstraintSet() {
        if (this.f765a == null) {
            this.f765a = new androidx.constraintlayout.widget.c_renamed();
        }
        this.f765a.a_renamed(this);
        return this.f765a;
    }
}
