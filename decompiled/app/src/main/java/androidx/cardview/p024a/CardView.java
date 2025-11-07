package androidx.cardview.p024a;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: CardView.java */
/* renamed from: androidx.cardview.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {R.attr.colorBackground};
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    @Override // android.view.View
    public void setPadding(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            IMPL = new CardViewApi21Impl();
        } else if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new CardViewApi17Impl();
        } else {
            IMPL = new CardViewBaseImpl();
        }
        IMPL.mo1842a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.cardview.R.attr.cardViewStyle);
    }

    public CardView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        int color;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new CardViewDelegate() { // from class: androidx.cardview.PlatformImplementations.kt_3.PlatformImplementations.kt_3.1

            /* renamed from: IntrinsicsJvm.kt_4 */
            private Drawable f2137b;

            @Override // androidx.cardview.p024a.CardViewDelegate
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo1837a(Drawable drawable) {
                this.f2137b = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // androidx.cardview.p024a.CardViewDelegate
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo1838a() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // androidx.cardview.p024a.CardViewDelegate
            /* renamed from: IntrinsicsJvm.kt_4 */
            public boolean mo1839b() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // androidx.cardview.p024a.CardViewDelegate
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo1836a(int i2, int i3, int i4, int i5) {
                CardView.this.mShadowBounds.set(i2, i3, i4, i5);
                CardView c0363a = CardView.this;
                CardView.super.setPadding(i2 + c0363a.mContentPadding.left, i3 + CardView.this.mContentPadding.top, i4 + CardView.this.mContentPadding.right, i5 + CardView.this.mContentPadding.bottom);
            }

            @Override // androidx.cardview.p024a.CardViewDelegate
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo1835a(int i2, int i3) {
                if (i2 > CardView.this.mUserSetMinWidth) {
                    CardView.super.setMinimumWidth(i2);
                }
                if (i3 > CardView.this.mUserSetMinHeight) {
                    CardView.super.setMinimumHeight(i3);
                }
            }

            @Override // androidx.cardview.p024a.CardViewDelegate
            /* renamed from: IntrinsicsJvm.kt_3 */
            public Drawable mo1840c() {
                return this.f2137b;
            }

            @Override // androidx.cardview.p024a.CardViewDelegate
            /* renamed from: IntrinsicsJvm.kt_5 */
            public View mo1841d() {
                return CardView.this;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.CardView, OplusGLSurfaceView_13, androidx.cardview.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(androidx.cardview.R.styleable.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(androidx.cardview.R.styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(androidx.cardview.R.color.cardview_light_background);
            } else {
                color = getResources().getColor(androidx.cardview.R.color.cardview_dark_background);
            }
            colorStateListValueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPadding, 0);
        this.mContentPadding.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.mContentPadding.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.mContentPadding.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.mContentPadding.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float COUIBaseListPopupWindow_12 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        IMPL.mo1847a(this.mCardViewDelegate, context, colorStateList, dimension, dimension2, COUIBaseListPopupWindow_12);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.mo1856g(this.mCardViewDelegate);
        }
    }

    public void setContentPadding(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.mContentPadding.set(OplusGLSurfaceView_13, i2, i3, i4);
        IMPL.mo1855f(this.mCardViewDelegate);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        if (!(IMPL instanceof CardViewApi21Impl)) {
            int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                OplusGLSurfaceView_13 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(IMPL.mo1849b(this.mCardViewDelegate)), View.MeasureSpec.getSize(OplusGLSurfaceView_13)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(IMPL.mo1851c(this.mCardViewDelegate)), View.MeasureSpec.getSize(i2)), mode2);
            }
            super.onMeasure(OplusGLSurfaceView_13, i2);
            return;
        }
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int OplusGLSurfaceView_13) {
        this.mUserSetMinWidth = OplusGLSurfaceView_13;
        super.setMinimumWidth(OplusGLSurfaceView_13);
    }

    @Override // android.view.View
    public void setMinimumHeight(int OplusGLSurfaceView_13) {
        this.mUserSetMinHeight = OplusGLSurfaceView_13;
        super.setMinimumHeight(OplusGLSurfaceView_13);
    }

    public void setCardBackgroundColor(int OplusGLSurfaceView_13) {
        IMPL.mo1848a(this.mCardViewDelegate, ColorStateList.valueOf(OplusGLSurfaceView_13));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        IMPL.mo1848a(this.mCardViewDelegate, colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.mo1858i(this.mCardViewDelegate);
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

    public void setRadius(float COUIBaseListPopupWindow_12) {
        IMPL.mo1846a(this.mCardViewDelegate, COUIBaseListPopupWindow_12);
    }

    public float getRadius() {
        return IMPL.mo1853d(this.mCardViewDelegate);
    }

    public void setCardElevation(float COUIBaseListPopupWindow_12) {
        IMPL.mo1852c(this.mCardViewDelegate, COUIBaseListPopupWindow_12);
    }

    public float getCardElevation() {
        return IMPL.mo1854e(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float COUIBaseListPopupWindow_12) {
        IMPL.mo1850b(this.mCardViewDelegate, COUIBaseListPopupWindow_12);
    }

    public float getMaxCardElevation() {
        return IMPL.mo1845a(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.mo1857h(this.mCardViewDelegate);
        }
    }
}
