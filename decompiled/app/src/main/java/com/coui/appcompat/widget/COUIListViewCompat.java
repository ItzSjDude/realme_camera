package com.coui.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.p018b.p019a.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Field;

/* compiled from: COUIListViewCompat.java */
/* renamed from: com.coui.appcompat.widget.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class COUIListViewCompat extends ListView {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final int[] f8115f = {0};

    /* renamed from: PlatformImplementations.kt_3 */
    final Rect f8116a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f8117b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f8118c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    int f8119d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    int f8120e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Field f8121g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private PlatformImplementations.kt_3 f8122h;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected boolean mo7797c() {
        return false;
    }

    public COUIListViewCompat(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f8116a = new Rect();
        this.f8117b = 0;
        this.f8118c = 0;
        this.f8119d = 0;
        this.f8120e = 0;
        try {
            this.f8121g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f8121g.setAccessible(true);
        } catch (NoSuchFieldException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.f8122h = drawable != null ? new PlatformImplementations.kt_3(drawable) : null;
        super.setSelector(this.f8122h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f8117b = rect.left;
        this.f8118c = rect.top;
        this.f8119d = rect.right;
        this.f8120e = rect.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m7791a();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        m7794a(canvas);
        super.dispatchDraw(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m7791a() {
        Drawable selector = getSelector();
        if (selector == null || !m7796b()) {
            return;
        }
        selector.setState(getDrawableState());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean m7796b() {
        return mo7797c() && isPressed();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m7794a(Canvas canvas) {
        Drawable selector;
        if (this.f8116a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f8116a);
        selector.draw(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m7793a(int OplusGLSurfaceView_13, View view, float COUIBaseListPopupWindow_12, float f2) throws IllegalAccessException, IllegalArgumentException {
        m7792a(OplusGLSurfaceView_13, view);
        Drawable selector = getSelector();
        if (selector == null || OplusGLSurfaceView_13 == -1) {
            return;
        }
        DrawableCompat.m2567a(selector, COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m7792a(int OplusGLSurfaceView_13, View view) throws IllegalAccessException, IllegalArgumentException {
        Drawable selector = getSelector();
        boolean z = (selector == null || OplusGLSurfaceView_13 == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        m7795b(OplusGLSurfaceView_13, view);
        if (z) {
            Rect rect = this.f8116a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            DrawableCompat.m2567a(selector, fExactCenterX, fExactCenterY);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m7795b(int OplusGLSurfaceView_13, View view) throws IllegalAccessException, IllegalArgumentException {
        Rect rect = this.f8116a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f8117b;
        rect.top -= this.f8118c;
        rect.right += this.f8119d;
        rect.bottom += this.f8120e;
        try {
            boolean z = this.f8121g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f8121g.set(this, Boolean.valueOf(!z));
                if (OplusGLSurfaceView_13 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m7790a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        int iMakeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int measuredHeight = i6;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        View view = null;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && layoutParams.height > 0) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(OplusGLSurfaceView_13, iMakeMeasureSpec);
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i7 <= i5 || i9 <= 0 || measuredHeight == i4) ? i4 : i9;
            }
            if (i5 >= 0 && i7 >= i5) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    protected void setSelectorEnabled(boolean z) {
        PlatformImplementations.kt_3 aVar = this.f8122h;
        if (aVar != null) {
            aVar.m7798a(z);
        }
    }

    /* compiled from: COUIListViewCompat.java */
    /* renamed from: com.coui.appcompat.widget.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends DrawableWrapper {

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean f8123a;

        public PlatformImplementations.kt_3(Drawable drawable) {
            super(drawable);
            this.f8123a = true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m7798a(boolean z) {
            this.f8123a = z;
        }

        @Override // androidx.appcompat.p018b.p019a.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f8123a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.p018b.p019a.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f8123a) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.p018b.p019a.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f8123a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }
}
