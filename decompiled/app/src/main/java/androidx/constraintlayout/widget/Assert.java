package androidx.constraintlayout.widget;

/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public class a_renamed extends androidx.constraintlayout.widget.b_renamed {
    private int f_renamed;
    private int g_renamed;
    private androidx.constraintlayout.a_renamed.a_renamed.b_renamed h_renamed;

    public a_renamed(android.content.Context context) {
        super(context);
        super.setVisibility(8);
    }

    public int getType() {
        return this.f_renamed;
    }

    public void setType(int i_renamed) {
        this.f_renamed = i_renamed;
        this.g_renamed = i_renamed;
        if (android.os.Build.VERSION.SDK_INT < 17) {
            int i2 = this.f_renamed;
            if (i2 == 5) {
                this.g_renamed = 0;
            } else if (i2 == 6) {
                this.g_renamed = 1;
            }
        } else {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i3 = this.f_renamed;
                if (i3 == 5) {
                    this.g_renamed = 1;
                } else if (i3 == 6) {
                    this.g_renamed = 0;
                }
            } else {
                int i4 = this.f_renamed;
                if (i4 == 5) {
                    this.g_renamed = 0;
                } else if (i4 == 6) {
                    this.g_renamed = 1;
                }
            }
        }
        this.h_renamed.a_renamed(this.g_renamed);
    }

    @Override // androidx.constraintlayout.widget.b_renamed
    protected void a_renamed(android.util.AttributeSet attributeSet) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        super.a_renamed(attributeSet);
        this.h_renamed = new androidx.constraintlayout.a_renamed.a_renamed.b_renamed();
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i_renamed = 0; i_renamed < indexCount; i_renamed++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i_renamed);
                if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == androidx.constraintlayout.widget.R_renamed.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.h_renamed.a_renamed(typedArrayObtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.d_renamed = this.h_renamed;
        b_renamed();
    }

    public void setAllowsGoneWidget(boolean z_renamed) {
        this.h_renamed.a_renamed(z_renamed);
    }

    public boolean a_renamed() {
        return this.h_renamed.b_renamed();
    }
}
