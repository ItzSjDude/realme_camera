package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.ViewPropertyAnimatorCompat;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CharSequence f1458g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CharSequence f1459h;

    /* renamed from: OplusGLSurfaceView_13 */
    private View f1460i;

    /* renamed from: OplusGLSurfaceView_15 */
    private View f1461j;

    /* renamed from: OplusGLSurfaceView_5 */
    private LinearLayout f1462k;

    /* renamed from: OplusGLSurfaceView_14 */
    private TextView f1463l;

    /* renamed from: OplusGLSurfaceView_6 */
    private TextView f1464m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f1465n;

    /* renamed from: o */
    private int f1466o;

    /* renamed from: p */
    private boolean f1467p;

    /* renamed from: q */
    private int f1468q;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    /* renamed from: PlatformImplementations.kt_3 */
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat mo1218a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        return super.mo1218a(OplusGLSurfaceView_13, OplusGLSurfaceView_15);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int OplusGLSurfaceView_13) {
        super.setVisibility(OplusGLSurfaceView_13);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(context, attributeSet, R.styleable.ActionMode, OplusGLSurfaceView_13, 0);
        ViewCompat.m2850a(this, c0322arM1541a.m1546a(R.styleable.ActionMode_background));
        this.f1465n = c0322arM1541a.m1560g(R.styleable.ActionMode_titleTextStyle, 0);
        this.f1466o = c0322arM1541a.m1560g(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f1709e = c0322arM1541a.m1558f(R.styleable.ActionMode_height, 0);
        this.f1468q = c0322arM1541a.m1560g(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        c0322arM1541a.m1551b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1708d != null) {
            this.f1708d.m1261d();
            this.f1708d.m1263f();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int OplusGLSurfaceView_13) {
        this.f1709e = OplusGLSurfaceView_13;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1461j;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1461j = view;
        if (view != null && (linearLayout = this.f1462k) != null) {
            removeView(linearLayout);
            this.f1462k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1458g = charSequence;
        m1217e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1459h = charSequence;
        m1217e();
    }

    public CharSequence getTitle() {
        return this.f1458g;
    }

    public CharSequence getSubtitle() {
        return this.f1459h;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m1217e() {
        if (this.f1462k == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            this.f1462k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1463l = (TextView) this.f1462k.findViewById(R.id_renamed.action_bar_title);
            this.f1464m = (TextView) this.f1462k.findViewById(R.id_renamed.action_bar_subtitle);
            if (this.f1465n != 0) {
                this.f1463l.setTextAppearance(getContext(), this.f1465n);
            }
            if (this.f1466o != 0) {
                this.f1464m.setTextAppearance(getContext(), this.f1466o);
            }
        }
        this.f1463l.setText(this.f1458g);
        this.f1464m.setText(this.f1459h);
        boolean z = !TextUtils.isEmpty(this.f1458g);
        boolean z2 = !TextUtils.isEmpty(this.f1459h);
        int OplusGLSurfaceView_13 = 0;
        this.f1464m.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.f1462k;
        if (!z && !z2) {
            OplusGLSurfaceView_13 = 8;
        }
        linearLayout.setVisibility(OplusGLSurfaceView_13);
        if (this.f1462k.getParent() == null) {
            addView(this.f1462k);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1219a(final ActionMode abstractC0221b) {
        View view = this.f1460i;
        if (view == null) {
            this.f1460i = LayoutInflater.from(getContext()).inflate(this.f1468q, (ViewGroup) this, false);
            addView(this.f1460i);
        } else if (view.getParent() == null) {
            addView(this.f1460i);
        }
        this.f1460i.findViewById(R.id_renamed.action_mode_close_button).setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                abstractC0221b.mo973c();
            }
        });
        MenuBuilder c0236h = (MenuBuilder) abstractC0221b.mo970b();
        if (this.f1708d != null) {
            this.f1708d.m1262e();
        }
        this.f1708d = new ActionMenuPresenter(getContext());
        this.f1708d.m1256a(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        c0236h.addMenuPresenter(this.f1708d, this.f1706b);
        this.f1707c = (ActionMenuView) this.f1708d.mo1112a(this);
        ViewCompat.m2850a(this.f1707c, (Drawable) null);
        addView(this.f1707c, layoutParams);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1221b() {
        if (this.f1460i == null) {
            m1222c();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m1222c() {
        removeAllViews();
        this.f1461j = null;
        this.f1707c = null;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo1220a() {
        if (this.f1708d != null) {
            return this.f1708d.m1260c();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        if (View.MeasureSpec.getMode(OplusGLSurfaceView_13) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int size2 = this.f1709e > 0 ? this.f1709e : View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f1460i;
        if (view != null) {
            int iA = m1390a(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1460i.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        if (this.f1707c != null && this.f1707c.getParent() == this) {
            paddingLeft = m1390a(this.f1707c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f1462k;
        if (linearLayout != null && this.f1461j == null) {
            if (this.f1467p) {
                this.f1462k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f1462k.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f1462k.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = m1390a(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f1461j;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i3 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (layoutParams.width >= 0) {
                paddingLeft = Math.min(layoutParams.width, paddingLeft);
            }
            int i4 = layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824;
            if (layoutParams.height >= 0) {
                iMin = Math.min(layoutParams.height, iMin);
            }
            this.f1461j.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i3), View.MeasureSpec.makeMeasureSpec(iMin, i4));
        }
        if (this.f1709e <= 0) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                int measuredHeight = getChildAt(i6).getMeasuredHeight() + paddingTop;
                if (measuredHeight > i5) {
                    i5 = measuredHeight;
                }
            }
            setMeasuredDimension(size, i5);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int iA;
        boolean zM1623a = ViewUtils_2.m1623a(this);
        int paddingRight = zM1623a ? (i3 - OplusGLSurfaceView_13) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1460i;
        if (view == null || view.getVisibility() == 8) {
            iA = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1460i.getLayoutParams();
            int i5 = zM1623a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zM1623a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iA2 = m1387a(paddingRight, i5, zM1623a);
            iA = m1387a(iA2 + m1391a(this.f1460i, iA2, paddingTop, paddingTop2, zM1623a), i6, zM1623a);
        }
        LinearLayout linearLayout = this.f1462k;
        if (linearLayout != null && this.f1461j == null && linearLayout.getVisibility() != 8) {
            iA += m1391a(this.f1462k, iA, paddingTop, paddingTop2, zM1623a);
        }
        int i7 = iA;
        View view2 = this.f1461j;
        if (view2 != null) {
            m1391a(view2, i7, paddingTop, paddingTop2, zM1623a);
        }
        int paddingLeft = zM1623a ? getPaddingLeft() : (i3 - OplusGLSurfaceView_13) - getPaddingRight();
        if (this.f1707c != null) {
            m1391a(this.f1707c, paddingLeft, paddingTop, paddingTop2, !zM1623a);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1458g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1467p) {
            requestLayout();
        }
        this.f1467p = z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m1223d() {
        return this.f1467p;
    }
}
