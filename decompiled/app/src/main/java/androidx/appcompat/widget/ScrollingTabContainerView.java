package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;

/* compiled from: ScrollingTabContainerView.java */
/* renamed from: androidx.appcompat.widget.ak */
/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: OplusGLSurfaceView_15 */
    private static final Interpolator f1815j = new DecelerateInterpolator();

    /* renamed from: PlatformImplementations.kt_3 */
    Runnable f1816a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    LinearLayoutCompat f1817b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f1818c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    int f1819d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private IntrinsicsJvm.kt_4 f1820e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Spinner f1821f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f1822g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f1823h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f1824i;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f1817b.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f1818c = (int) (View.MeasureSpec.getSize(OplusGLSurfaceView_13) * 0.4f);
            } else {
                this.f1818c = View.MeasureSpec.getSize(OplusGLSurfaceView_13) / 2;
            }
            this.f1818c = Math.min(this.f1818c, this.f1819d);
        } else {
            this.f1818c = -1;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1823h, 1073741824);
        if (!z && this.f1822g) {
            this.f1817b.measure(0, iMakeMeasureSpec);
            if (this.f1817b.getMeasuredWidth() > View.MeasureSpec.getSize(OplusGLSurfaceView_13)) {
                m1498b();
            } else {
                m1499c();
            }
        } else {
            m1499c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(OplusGLSurfaceView_13, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f1824i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m1497a() {
        Spinner spinner = this.f1821f;
        return spinner != null && spinner.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.f1822g = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1498b() {
        if (m1497a()) {
            return;
        }
        if (this.f1821f == null) {
            this.f1821f = m1500d();
        }
        removeView(this.f1817b);
        addView(this.f1821f, new ViewGroup.LayoutParams(-2, -1));
        if (this.f1821f.getAdapter() == null) {
            this.f1821f.setAdapter((SpinnerAdapter) new PlatformImplementations.kt_3());
        }
        Runnable runnable = this.f1816a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f1816a = null;
        }
        this.f1821f.setSelection(this.f1824i);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m1499c() {
        if (!m1497a()) {
            return false;
        }
        removeView(this.f1821f);
        addView(this.f1817b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1821f.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int OplusGLSurfaceView_13) {
        this.f1824i = OplusGLSurfaceView_13;
        int childCount = this.f1817b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f1817b.getChildAt(i2);
            boolean z = i2 == OplusGLSurfaceView_13;
            childAt.setSelected(z);
            if (z) {
                m1502a(OplusGLSurfaceView_13);
            }
            i2++;
        }
        Spinner spinner = this.f1821f;
        if (spinner == null || OplusGLSurfaceView_13 < 0) {
            return;
        }
        spinner.setSelection(OplusGLSurfaceView_13);
    }

    public void setContentHeight(int OplusGLSurfaceView_13) {
        this.f1823h = OplusGLSurfaceView_13;
        requestLayout();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Spinner m1500d() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.C0277a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy c0220aM1047a = ActionBarPolicy.m1047a(getContext());
        setContentHeight(c0220aM1047a.m1052e());
        this.f1819d = c0220aM1047a.m1054g();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1502a(int OplusGLSurfaceView_13) {
        final View childAt = this.f1817b.getChildAt(OplusGLSurfaceView_13);
        Runnable runnable = this.f1816a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f1816a = new Runnable() { // from class: androidx.appcompat.widget.ak.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f1816a = null;
            }
        };
        post(this.f1816a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1816a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1816a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    IntrinsicsJvm.kt_3 m1501a(ActionBar.IntrinsicsJvm.kt_3 cVar, boolean z) {
        IntrinsicsJvm.kt_3 cVar2 = new IntrinsicsJvm.kt_3(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1823h));
        } else {
            cVar2.setFocusable(true);
            if (this.f1820e == null) {
                this.f1820e = new IntrinsicsJvm.kt_4();
            }
            cVar2.setOnClickListener(this.f1820e);
        }
        return cVar2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        ((IntrinsicsJvm.kt_3) view).m1505b().m898d();
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: androidx.appcompat.widget.ak$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 extends LinearLayout {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final int[] f1830b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private ActionBar.IntrinsicsJvm.kt_3 f1831c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private TextView f1832d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private ImageView f1833e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private View f1834f;

        public IntrinsicsJvm.kt_3(Context context, ActionBar.IntrinsicsJvm.kt_3 cVar, boolean z) {
            super(context, null, R.attr.actionBarTabStyle);
            this.f1830b = new int[]{android.R.attr.background};
            this.f1831c = cVar;
            TintTypedArray c0322arM1541a = TintTypedArray.m1541a(context, null, this.f1830b, R.attr.actionBarTabStyle, 0);
            if (c0322arM1541a.m1561g(0)) {
                setBackgroundDrawable(c0322arM1541a.m1546a(0));
            }
            c0322arM1541a.m1551b();
            if (z) {
                setGravity(8388627);
            }
            m1503a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m1504a(ActionBar.IntrinsicsJvm.kt_3 cVar) {
            this.f1831c = cVar;
            m1503a();
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int OplusGLSurfaceView_13, int i2) {
            super.onMeasure(OplusGLSurfaceView_13, i2);
            if (ScrollingTabContainerView.this.f1818c <= 0 || getMeasuredWidth() <= ScrollingTabContainerView.this.f1818c) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ScrollingTabContainerView.this.f1818c, 1073741824), i2);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m1503a() {
            ActionBar.IntrinsicsJvm.kt_3 cVar = this.f1831c;
            View viewM897c = cVar.m897c();
            if (viewM897c != null) {
                ViewParent parent = viewM897c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewM897c);
                    }
                    addView(viewM897c);
                }
                this.f1834f = viewM897c;
                TextView textView = this.f1832d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1833e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1833e.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f1834f;
            if (view != null) {
                removeView(view);
                this.f1834f = null;
            }
            Drawable drawableM895a = cVar.m895a();
            CharSequence charSequenceM896b = cVar.m896b();
            if (drawableM895a != null) {
                if (this.f1833e == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1833e = appCompatImageView;
                }
                this.f1833e.setImageDrawable(drawableM895a);
                this.f1833e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1833e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1833e.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequenceM896b);
            if (z) {
                if (this.f1832d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f1832d = appCompatTextView;
                }
                this.f1832d.setText(charSequenceM896b);
                this.f1832d.setVisibility(0);
            } else {
                TextView textView2 = this.f1832d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1832d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1833e;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.m899e());
            }
            TooltipCompat.m1605a(this, z ? null : cVar.m899e());
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public ActionBar.IntrinsicsJvm.kt_3 m1505b() {
            return this.f1831c;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: androidx.appcompat.widget.ak$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13;
        }

        PlatformImplementations.kt_3() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f1817b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int OplusGLSurfaceView_13) {
            return ((IntrinsicsJvm.kt_3) ScrollingTabContainerView.this.f1817b.getChildAt(OplusGLSurfaceView_13)).m1505b();
        }

        @Override // android.widget.Adapter
        public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.m1501a((ActionBar.IntrinsicsJvm.kt_3) getItem(OplusGLSurfaceView_13), true);
            }
            ((IntrinsicsJvm.kt_3) view).m1504a((ActionBar.IntrinsicsJvm.kt_3) getItem(OplusGLSurfaceView_13));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    /* renamed from: androidx.appcompat.widget.ak$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements View.OnClickListener {
        IntrinsicsJvm.kt_4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((IntrinsicsJvm.kt_3) view).m1505b().m898d();
            int childCount = ScrollingTabContainerView.this.f1817b.getChildCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                View childAt = ScrollingTabContainerView.this.f1817b.getChildAt(OplusGLSurfaceView_13);
                childAt.setSelected(childAt == view);
            }
        }
    }
}
