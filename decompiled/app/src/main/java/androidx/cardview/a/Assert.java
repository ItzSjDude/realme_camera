package androidx.cardview.a_renamed;

/* compiled from: CardView.java */
/* loaded from: classes.dex */
public class a_renamed extends android.widget.FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {android.R_renamed.attr.colorBackground};
    private static final androidx.cardview.a_renamed.f_renamed IMPL;
    private final androidx.cardview.a_renamed.e_renamed mCardViewDelegate;
    private boolean mCompatPadding;
    final android.graphics.Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final android.graphics.Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    @Override // android.view.View
    public void setPadding(int i_renamed, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i_renamed, int i2, int i3, int i4) {
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            IMPL = new androidx.cardview.a_renamed.c_renamed();
        } else if (android.os.Build.VERSION.SDK_INT >= 17) {
            IMPL = new androidx.cardview.a_renamed.b_renamed();
        } else {
            IMPL = new androidx.cardview.a_renamed.d_renamed();
        }
        IMPL.a_renamed();
    }

    public a_renamed(android.content.Context context) {
        this(context, null);
    }

    public a_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.cardview.R_renamed.attr.cardViewStyle);
    }

    public a_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) throws android.content.res.Resources.NotFoundException {
        int color;
        android.content.res.ColorStateList colorStateListValueOf;
        super(context, attributeSet, i_renamed);
        this.mContentPadding = new android.graphics.Rect();
        this.mShadowBounds = new android.graphics.Rect();
        this.mCardViewDelegate = new androidx.cardview.a_renamed.e_renamed() { // from class: androidx.cardview.a_renamed.a_renamed.1

            /* renamed from: b_renamed, reason: collision with root package name */
            private android.graphics.drawable.Drawable f692b;

            @Override // androidx.cardview.a_renamed.e_renamed
            public void a_renamed(android.graphics.drawable.Drawable drawable) {
                this.f692b = drawable;
                androidx.cardview.a_renamed.a_renamed.this.setBackgroundDrawable(drawable);
            }

            @Override // androidx.cardview.a_renamed.e_renamed
            public boolean a_renamed() {
                return androidx.cardview.a_renamed.a_renamed.this.getUseCompatPadding();
            }

            @Override // androidx.cardview.a_renamed.e_renamed
            public boolean b_renamed() {
                return androidx.cardview.a_renamed.a_renamed.this.getPreventCornerOverlap();
            }

            @Override // androidx.cardview.a_renamed.e_renamed
            public void a_renamed(int i2, int i3, int i4, int i5) {
                androidx.cardview.a_renamed.a_renamed.this.mShadowBounds.set(i2, i3, i4, i5);
                androidx.cardview.a_renamed.a_renamed aVar = androidx.cardview.a_renamed.a_renamed.this;
                androidx.cardview.a_renamed.a_renamed.super.setPadding(i2 + aVar.mContentPadding.left, i3 + androidx.cardview.a_renamed.a_renamed.this.mContentPadding.top, i4 + androidx.cardview.a_renamed.a_renamed.this.mContentPadding.right, i5 + androidx.cardview.a_renamed.a_renamed.this.mContentPadding.bottom);
            }

            @Override // androidx.cardview.a_renamed.e_renamed
            public void a_renamed(int i2, int i3) {
                if (i2 > androidx.cardview.a_renamed.a_renamed.this.mUserSetMinWidth) {
                    androidx.cardview.a_renamed.a_renamed.super.setMinimumWidth(i2);
                }
                if (i3 > androidx.cardview.a_renamed.a_renamed.this.mUserSetMinHeight) {
                    androidx.cardview.a_renamed.a_renamed.super.setMinimumHeight(i3);
                }
            }

            @Override // androidx.cardview.a_renamed.e_renamed
            public android.graphics.drawable.Drawable c_renamed() {
                return this.f692b;
            }

            @Override // androidx.cardview.a_renamed.e_renamed
            public android.view.View d_renamed() {
                return androidx.cardview.a_renamed.a_renamed.this;
            }
        };
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.cardview.R_renamed.styleable.CardView, i_renamed, androidx.cardview.R_renamed.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(androidx.cardview.R_renamed.styleable.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(androidx.cardview.R_renamed.styleable.CardView_cardBackgroundColor);
        } else {
            android.content.res.TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            android.graphics.Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(androidx.cardview.R_renamed.color.cardview_light_background);
            } else {
                color = getResources().getColor(androidx.cardview.R_renamed.color.cardview_dark_background);
            }
            colorStateListValueOf = android.content.res.ColorStateList.valueOf(color);
        }
        android.content.res.ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R_renamed.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R_renamed.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R_renamed.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R_renamed.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R_renamed.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R_renamed.styleable.CardView_contentPadding, 0);
        this.mContentPadding.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R_renamed.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.mContentPadding.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R_renamed.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.mContentPadding.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R_renamed.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.mContentPadding.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R_renamed.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f_renamed = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R_renamed.styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R_renamed.styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        IMPL.a_renamed(this.mCardViewDelegate, context, colorStateList, dimension, dimension2, f_renamed);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void setUseCompatPadding(boolean z_renamed) {
        if (this.mCompatPadding != z_renamed) {
            this.mCompatPadding = z_renamed;
            IMPL.g_renamed(this.mCardViewDelegate);
        }
    }

    public void setContentPadding(int i_renamed, int i2, int i3, int i4) {
        this.mContentPadding.set(i_renamed, i2, i3, i4);
        IMPL.f_renamed(this.mCardViewDelegate);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        if (!(IMPL instanceof androidx.cardview.a_renamed.c_renamed)) {
            int mode = android.view.View.MeasureSpec.getMode(i_renamed);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i_renamed = android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.max((int) java.lang.Math.ceil(IMPL.b_renamed(this.mCardViewDelegate)), android.view.View.MeasureSpec.getSize(i_renamed)), mode);
            }
            int mode2 = android.view.View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.max((int) java.lang.Math.ceil(IMPL.c_renamed(this.mCardViewDelegate)), android.view.View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(i_renamed, i2);
            return;
        }
        super.onMeasure(i_renamed, i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i_renamed) {
        this.mUserSetMinWidth = i_renamed;
        super.setMinimumWidth(i_renamed);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i_renamed) {
        this.mUserSetMinHeight = i_renamed;
        super.setMinimumHeight(i_renamed);
    }

    public void setCardBackgroundColor(int i_renamed) {
        IMPL.a_renamed(this.mCardViewDelegate, android.content.res.ColorStateList.valueOf(i_renamed));
    }

    public void setCardBackgroundColor(android.content.res.ColorStateList colorStateList) {
        IMPL.a_renamed(this.mCardViewDelegate, colorStateList);
    }

    public android.content.res.ColorStateList getCardBackgroundColor() {
        return IMPL.i_renamed(this.mCardViewDelegate);
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public void setRadius(float f_renamed) {
        IMPL.a_renamed(this.mCardViewDelegate, f_renamed);
    }

    public float getRadius() {
        return IMPL.d_renamed(this.mCardViewDelegate);
    }

    public void setCardElevation(float f_renamed) {
        IMPL.c_renamed(this.mCardViewDelegate, f_renamed);
    }

    public float getCardElevation() {
        return IMPL.e_renamed(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f_renamed) {
        IMPL.b_renamed(this.mCardViewDelegate, f_renamed);
    }

    public float getMaxCardElevation() {
        return IMPL.a_renamed(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public void setPreventCornerOverlap(boolean z_renamed) {
        if (z_renamed != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z_renamed;
            IMPL.h_renamed(this.mCardViewDelegate);
        }
    }
}
