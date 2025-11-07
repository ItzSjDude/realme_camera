package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.p018b.p019a.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p036h.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;

/* compiled from: DropDownListView.java */
/* renamed from: androidx.appcompat.widget.ab */
/* loaded from: classes.dex */
class DropDownListView extends ListView {

    /* renamed from: PlatformImplementations.kt_3 */
    IntrinsicsJvm.kt_4 f1720a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Rect f1721b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f1722c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f1723d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f1724e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f1725f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f1726g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Field f1727h;

    /* renamed from: OplusGLSurfaceView_13 */
    private PlatformImplementations.kt_3 f1728i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f1729j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f1730k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f1731l;

    /* renamed from: OplusGLSurfaceView_6 */
    private ViewPropertyAnimatorCompat f1732m;

    /* renamed from: OplusGLSurfaceView_11 */
    private ListViewAutoScrollHelper f1733n;

    DropDownListView(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f1721b = new Rect();
        this.f1722c = 0;
        this.f1723d = 0;
        this.f1724e = 0;
        this.f1725f = 0;
        this.f1730k = z;
        setCacheColorHint(0);
        try {
            this.f1727h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1727h.setAccessible(true);
        } catch (NoSuchFieldException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1730k && this.f1729j) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1730k || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1730k || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1730k || super.hasFocus();
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.f1728i = drawable != null ? new PlatformImplementations.kt_3(drawable) : null;
        super.setSelector(this.f1728i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1722c = rect.left;
        this.f1723d = rect.top;
        this.f1724e = rect.right;
        this.f1725f = rect.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f1720a != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m1399a();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        m1402a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1726g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        IntrinsicsJvm.kt_4 bVar = this.f1720a;
        if (bVar != null) {
            bVar.m1411a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int mo1408a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
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
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(OplusGLSurfaceView_13, iMakeMeasureSpec);
            view.forceLayout();
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

    private void setSelectorEnabled(boolean z) {
        PlatformImplementations.kt_3 aVar = this.f1728i;
        if (aVar != null) {
            aVar.m1410a(z);
        }
    }

    /* compiled from: DropDownListView.java */
    /* renamed from: androidx.appcompat.widget.ab$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 extends DrawableWrapper {

        /* renamed from: PlatformImplementations.kt_3 */
        private boolean f1734a;

        PlatformImplementations.kt_3(Drawable drawable) {
            super(drawable);
            this.f1734a = true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m1410a(boolean z) {
            this.f1734a = z;
        }

        @Override // androidx.appcompat.p018b.p019a.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1734a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.p018b.p019a.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1734a) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.p018b.p019a.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspot(float COUIBaseListPopupWindow_12, float f2) {
            if (this.f1734a) {
                super.setHotspot(COUIBaseListPopupWindow_12, f2);
            }
        }

        @Override // androidx.appcompat.p018b.p019a.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspotBounds(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            if (this.f1734a) {
                super.setHotspotBounds(OplusGLSurfaceView_13, i2, i3, i4);
            }
        }

        @Override // androidx.appcompat.p018b.p019a.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f1734a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1720a == null) {
            this.f1720a = new IntrinsicsJvm.kt_4();
            this.f1720a.m1412b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                m1399a();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f1720a = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo1409a(android.view.MotionEvent r8, int r9) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = r1
            r3 = r2
            goto L46
        L11:
            r9 = r1
            r3 = r9
            goto L46
        L14:
            r3 = r2
            goto L17
        L16:
            r3 = r1
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r2
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.m1404a(r3, r5, r4, r9)
            if (r0 != r2) goto Le
            r7.m1403a(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.m1405b()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.COUIBaseListPopupWindow_12 r9 = r7.f1733n
            if (r9 != 0) goto L5a
            androidx.core.widget.COUIBaseListPopupWindow_12 r9 = new androidx.core.widget.COUIBaseListPopupWindow_12
            r9.<init>(r7)
            r7.f1733n = r9
        L5a:
            androidx.core.widget.COUIBaseListPopupWindow_12 r9 = r7.f1733n
            r9.m3004a(r2)
            androidx.core.widget.COUIBaseListPopupWindow_12 r9 = r7.f1733n
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.COUIBaseListPopupWindow_12 r7 = r7.f1733n
            if (r7 == 0) goto L6c
            r7.m3004a(r1)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.mo1409a(android.view.MotionEvent, int):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1403a(View view, int OplusGLSurfaceView_13) {
        performItemClick(view, OplusGLSurfaceView_13, getItemIdAtPosition(OplusGLSurfaceView_13));
    }

    void setListSelectionHidden(boolean z) {
        this.f1729j = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1399a() {
        Drawable selector = getSelector();
        if (selector != null && m1407c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1402a(Canvas canvas) {
        Drawable selector;
        if (this.f1721b.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1721b);
        selector.draw(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1401a(int OplusGLSurfaceView_13, View view, float COUIBaseListPopupWindow_12, float f2) throws IllegalAccessException, IllegalArgumentException {
        m1400a(OplusGLSurfaceView_13, view);
        Drawable selector = getSelector();
        if (selector == null || OplusGLSurfaceView_13 == -1) {
            return;
        }
        DrawableCompat.m2567a(selector, COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1400a(int OplusGLSurfaceView_13, View view) throws IllegalAccessException, IllegalArgumentException {
        Drawable selector = getSelector();
        boolean z = (selector == null || OplusGLSurfaceView_13 == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        m1406b(OplusGLSurfaceView_13, view);
        if (z) {
            Rect rect = this.f1721b;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            DrawableCompat.m2567a(selector, fExactCenterX, fExactCenterY);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1406b(int OplusGLSurfaceView_13, View view) throws IllegalAccessException, IllegalArgumentException {
        Rect rect = this.f1721b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1722c;
        rect.top -= this.f1723d;
        rect.right += this.f1724e;
        rect.bottom += this.f1725f;
        try {
            boolean z = this.f1727h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1727h.set(this, Boolean.valueOf(!z));
                if (OplusGLSurfaceView_13 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1405b() {
        this.f1731l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1726g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat c0517z = this.f1732m;
        if (c0517z != null) {
            c0517z.m2953b();
            this.f1732m = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1404a(View view, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, float f2) throws IllegalAccessException, IllegalArgumentException {
        View childAt;
        this.f1731l = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(COUIBaseListPopupWindow_12, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.f1726g;
        if (i2 != -1 && (childAt = getChildAt(i2 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1726g = OplusGLSurfaceView_13;
        float left = COUIBaseListPopupWindow_12 - view.getLeft();
        float top = f2 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m1401a(OplusGLSurfaceView_13, view, COUIBaseListPopupWindow_12, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m1407c() {
        return this.f1731l;
    }

    /* compiled from: DropDownListView.java */
    /* renamed from: androidx.appcompat.widget.ab$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements Runnable {
        IntrinsicsJvm.kt_4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView c0306ab = DropDownListView.this;
            c0306ab.f1720a = null;
            c0306ab.drawableStateChanged();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m1411a() {
            DropDownListView c0306ab = DropDownListView.this;
            c0306ab.f1720a = null;
            c0306ab.removeCallbacks(this);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m1412b() {
            DropDownListView.this.post(this);
        }
    }
}
