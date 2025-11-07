package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class ButtonBarLayout extends android.widget.LinearLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f473a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f474b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f475c;

    public ButtonBarLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f474b = -1;
        this.f475c = 0;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R_renamed.styleable.ButtonBarLayout);
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, androidx.appcompat.R_renamed.styleable.ButtonBarLayout, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        }
        this.f473a = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R_renamed.styleable.ButtonBarLayout_allowStacking, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z_renamed) {
        if (this.f473a != z_renamed) {
            this.f473a = z_renamed;
            if (!this.f473a && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        int iMakeMeasureSpec;
        boolean z_renamed;
        int size = android.view.View.MeasureSpec.getSize(i_renamed);
        int paddingBottom = 0;
        if (this.f473a) {
            if (size > this.f474b && a_renamed()) {
                setStacked(false);
            }
            this.f474b = size;
        }
        if (a_renamed() || android.view.View.MeasureSpec.getMode(i_renamed) != 1073741824) {
            iMakeMeasureSpec = i_renamed;
            z_renamed = false;
        } else {
            iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z_renamed = true;
        }
        super.onMeasure(iMakeMeasureSpec, i2);
        if (this.f473a && !a_renamed()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                setStacked(true);
                z_renamed = true;
            }
        }
        if (z_renamed) {
            super.onMeasure(i_renamed, i2);
        }
        int iA = a_renamed(0);
        if (iA >= 0) {
            android.view.View childAt = getChildAt(iA);
            android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (a_renamed()) {
                int iA2 = a_renamed(iA + 1);
                if (iA2 >= 0) {
                    paddingTop += getChildAt(iA2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (androidx.core.h_renamed.v_renamed.m_renamed(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
        }
    }

    private int a_renamed(int i_renamed) {
        int childCount = getChildCount();
        while (i_renamed < childCount) {
            if (getChildAt(i_renamed).getVisibility() == 0) {
                return i_renamed;
            }
            i_renamed++;
        }
        return -1;
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return java.lang.Math.max(this.f475c, super.getMinimumHeight());
    }

    private void setStacked(boolean z_renamed) {
        setOrientation(z_renamed ? 1 : 0);
        setGravity(z_renamed ? 5 : 80);
        android.view.View viewFindViewById = findViewById(androidx.appcompat.R_renamed.id_renamed.spacer);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(z_renamed ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    private boolean a_renamed() {
        return getOrientation() == 1;
    }
}
