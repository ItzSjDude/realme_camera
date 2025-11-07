package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    int getChildrenSkipCount(View view, int OplusGLSurfaceView_13) {
        return 0;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    int measureNullChild(int OplusGLSurfaceView_13) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = BadgeDrawable.TOP_START;
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(context, attributeSet, R.styleable.LinearLayoutCompat, OplusGLSurfaceView_13, 0);
        int iM1544a = c0322arM1541a.m1544a(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (iM1544a >= 0) {
            setOrientation(iM1544a);
        }
        int iM1544a2 = c0322arM1541a.m1544a(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (iM1544a2 >= 0) {
            setGravity(iM1544a2);
        }
        boolean zM1547a = c0322arM1541a.m1547a(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!zM1547a) {
            setBaselineAligned(zM1547a);
        }
        this.mWeightSum = c0322arM1541a.m1542a(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = c0322arM1541a.m1544a(R.styleable.f784xcaa77777, -1);
        this.mUseLargestChild = c0322arM1541a.m1547a(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(c0322arM1541a.m1546a(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = c0322arM1541a.m1544a(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = c0322arM1541a.m1556e(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        c0322arM1541a.m1551b();
    }

    public void setShowDividers(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = OplusGLSurfaceView_13;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int OplusGLSurfaceView_13) {
        this.mDividerPadding = OplusGLSurfaceView_13;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < virtualChildCount; OplusGLSurfaceView_13++) {
            View virtualChildAt = getVirtualChildAt(OplusGLSurfaceView_13);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(OplusGLSurfaceView_13)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((C0277a) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = virtualChildAt2.getBottom() + ((C0277a) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int OplusGLSurfaceView_13;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean zM1623a = ViewUtils_2.m1623a(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                C0277a c0277a = (C0277a) virtualChildAt.getLayoutParams();
                if (zM1623a) {
                    left2 = virtualChildAt.getRight() + c0277a.rightMargin;
                } else {
                    left2 = (virtualChildAt.getLeft() - c0277a.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, left2);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                C0277a c0277a2 = (C0277a) virtualChildAt2.getLayoutParams();
                if (zM1623a) {
                    left = virtualChildAt2.getLeft() - c0277a2.leftMargin;
                    OplusGLSurfaceView_13 = this.mDividerWidth;
                    right = left - OplusGLSurfaceView_13;
                } else {
                    right = virtualChildAt2.getRight() + c0277a2.rightMargin;
                }
            } else if (zM1623a) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                OplusGLSurfaceView_13 = this.mDividerWidth;
                right = left - OplusGLSurfaceView_13;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int OplusGLSurfaceView_13) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, OplusGLSurfaceView_13, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + OplusGLSurfaceView_13);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int OplusGLSurfaceView_13) {
        this.mDivider.setBounds(OplusGLSurfaceView_13, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + OplusGLSurfaceView_13, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int OplusGLSurfaceView_13;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to PlatformImplementations.kt_3 View that doesn't know how to get its baseline.");
        }
        int bottom = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (OplusGLSurfaceView_13 = this.mGravity & 112) != 48) {
            if (OplusGLSurfaceView_13 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (OplusGLSurfaceView_13 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return bottom + ((C0277a) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = OplusGLSurfaceView_13;
    }

    View getVirtualChildAt(int OplusGLSurfaceView_13) {
        return getChildAt(OplusGLSurfaceView_13);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public void setWeightSum(float COUIBaseListPopupWindow_12) {
        this.mWeightSum = Math.max(0.0f, COUIBaseListPopupWindow_12);
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(OplusGLSurfaceView_13, i2);
        } else {
            measureHorizontal(OplusGLSurfaceView_13, i2);
        }
    }

    protected boolean hasDividerBeforeChildAt(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (OplusGLSurfaceView_13 == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i2 = OplusGLSurfaceView_13 - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0343  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void measureVertical(int r35, int r36) {
        /*
            Method dump skipped, instructions count: 929
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.measureVertical(int, int):void");
    }

    private void forceUniformWidth(int OplusGLSurfaceView_13, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                C0277a c0277a = (C0277a) virtualChildAt.getLayoutParams();
                if (c0277a.width == -1) {
                    int i4 = c0277a.height;
                    c0277a.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, iMakeMeasureSpec, 0, i2, 0);
                    c0277a.height = i4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void measureHorizontal(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 1310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.measureHorizontal(int, int):void");
    }

    private void forceUniformHeight(int OplusGLSurfaceView_13, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                C0277a c0277a = (C0277a) virtualChildAt.getLayoutParams();
                if (c0277a.height == -1) {
                    int i4 = c0277a.width;
                    c0277a.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, iMakeMeasureSpec, 0);
                    c0277a.width = i4;
                }
            }
        }
    }

    void measureChildBeforeLayout(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(OplusGLSurfaceView_13, i2, i3, i4);
        } else {
            layoutHorizontal(OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void layoutVertical(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.mGravity
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L3b
            r0 = 80
            if (r1 == r0) goto L2f
            int r0 = r17.getPaddingTop()
            goto L47
        L2f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.mTotalLength
            int r0 = r0 - r1
            goto L47
        L3b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.mTotalLength
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L47:
            r1 = 0
            r12 = r1
        L49:
            if (r12 >= r10) goto Lcc
            android.view.View r13 = r6.getVirtualChildAt(r12)
            r14 = 1
            if (r13 != 0) goto L59
            int r1 = r6.measureNullChild(r12)
            int r0 = r0 + r1
            goto Lc8
        L59:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto Lc8
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.LinearLayoutCompat$PlatformImplementations.kt_3 r5 = (androidx.appcompat.widget.LinearLayoutCompat.C0277a) r5
            int r1 = r5.f1617h
            if (r1 >= 0) goto L75
            r1 = r11
        L75:
            int r2 = androidx.core.p036h.ViewCompat.m2885g(r17)
            int r1 = androidx.core.p036h.GravityCompat.m2773a(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L8e
            r2 = 5
            if (r1 == r2) goto L89
            int r1 = r5.leftMargin
            int r1 = r1 + r7
        L87:
            r2 = r1
            goto L9a
        L89:
            int r1 = r8 - r4
            int r2 = r5.rightMargin
            goto L98
        L8e:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            int r2 = r5.rightMargin
        L98:
            int r1 = r1 - r2
            goto L87
        L9a:
            boolean r1 = r6.hasDividerBeforeChildAt(r12)
            if (r1 == 0) goto La3
            int r1 = r6.mDividerHeight
            int r0 = r0 + r1
        La3:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.getLocationOffset(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.setChildFrame(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.getNextLocationOffset(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.getChildrenSkipCount(r13, r12)
            int r12 = r12 + r0
            r0 = r16
            r1 = 1
            goto Lc9
        Lc8:
            r1 = r14
        Lc9:
            int r12 = r12 + r1
            goto L49
        Lcc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.layoutVertical(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void layoutHorizontal(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.layoutHorizontal(int, int, int, int):void");
    }

    private void setChildFrame(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        view.layout(OplusGLSurfaceView_13, i2, i3 + OplusGLSurfaceView_13, i4 + i2);
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        if (this.mOrientation != OplusGLSurfaceView_13) {
            this.mOrientation = OplusGLSurfaceView_13;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int OplusGLSurfaceView_13) {
        if (this.mGravity != OplusGLSurfaceView_13) {
            if ((8388615 & OplusGLSurfaceView_13) == 0) {
                OplusGLSurfaceView_13 |= 8388611;
            }
            if ((OplusGLSurfaceView_13 & 112) == 0) {
                OplusGLSurfaceView_13 |= 48;
            }
            this.mGravity = OplusGLSurfaceView_13;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setHorizontalGravity(int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 & 8388615;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setVerticalGravity(int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public C0277a generateLayoutParams(AttributeSet attributeSet) {
        return new C0277a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public C0277a generateDefaultLayoutParams() {
        int OplusGLSurfaceView_13 = this.mOrientation;
        if (OplusGLSurfaceView_13 == 0) {
            return new C0277a(-2, -2);
        }
        if (OplusGLSurfaceView_13 == 1) {
            return new C0277a(-1, -2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public C0277a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0277a(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0277a;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    /* renamed from: androidx.appcompat.widget.LinearLayoutCompat$PlatformImplementations.kt_3 */
    public static class C0277a extends ViewGroup.MarginLayoutParams {

        /* renamed from: COUIBaseListPopupWindow_11 */
        public float f1616g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public int f1617h;

        public C0277a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1617h = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.f1616g = typedArrayObtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f1617h = typedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0277a(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f1617h = -1;
            this.f1616g = 0.0f;
        }

        public C0277a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1617h = -1;
        }
    }
}
