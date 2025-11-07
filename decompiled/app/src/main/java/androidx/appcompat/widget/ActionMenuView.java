package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.LinearLayoutCompat;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.IntrinsicsJvm.kt_4, MenuView {

    /* renamed from: PlatformImplementations.kt_3 */
    MenuBuilder.PlatformImplementations.kt_3 f1532a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    InterfaceC0266e f1533b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private MenuBuilder f1534c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Context f1535d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f1536e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f1537f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ActionMenuPresenter f1538g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private MenuPresenter.PlatformImplementations.kt_3 f1539h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f1540i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f1541j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f1542k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f1543l;

    /* renamed from: androidx.appcompat.widget.ActionMenuView$PlatformImplementations.kt_3 */
    public interface InterfaceC0262a {
        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo1105b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean mo1106c();
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$COUIBaseListPopupWindow_8 */
    public interface InterfaceC0266e {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo1284a(MenuItem menuItem);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float COUIBaseListPopupWindow_12 = context.getResources().getDisplayMetrics().density;
        this.f1542k = (int) (56.0f * COUIBaseListPopupWindow_12);
        this.f1543l = (int) (COUIBaseListPopupWindow_12 * 4.0f);
        this.f1535d = context;
        this.f1536e = 0;
    }

    public void setPopupTheme(int OplusGLSurfaceView_13) {
        if (this.f1536e != OplusGLSurfaceView_13) {
            this.f1536e = OplusGLSurfaceView_13;
            if (OplusGLSurfaceView_13 == 0) {
                this.f1535d = getContext();
            } else {
                this.f1535d = new ContextThemeWrapper(getContext(), OplusGLSurfaceView_13);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1536e;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1538g = actionMenuPresenter;
        this.f1538g.m1255a(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f1538g;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.f1538g.m1264g()) {
                this.f1538g.m1261d();
                this.f1538g.m1260c();
            }
        }
    }

    public void setOnMenuItemClickListener(InterfaceC0266e interfaceC0266e) {
        this.f1533b = interfaceC0266e;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        MenuBuilder c0236h;
        boolean z = this.f1540i;
        this.f1540i = View.MeasureSpec.getMode(OplusGLSurfaceView_13) == 1073741824;
        if (z != this.f1540i) {
            this.f1541j = 0;
        }
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        if (this.f1540i && (c0236h = this.f1534c) != null && size != this.f1541j) {
            this.f1541j = size;
            c0236h.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (this.f1540i && childCount > 0) {
            m1270a(OplusGLSurfaceView_13, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            C0264c c0264c = (C0264c) getChildAt(i3).getLayoutParams();
            c0264c.rightMargin = 0;
            c0264c.leftMargin = 0;
        }
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x023d A[ADDED_TO_REGION, LOOP:5: B:138:0x023d->B:143:0x025b, LOOP_START, PHI: r13
      0x023d: PHI (r13v4 int) = (r13v3 int), (r13v5 int) binds: [B:137:0x023b, B:143:0x025b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0263  */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m1270a(int r30, int r31) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.m1270a(int, int):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m1269a(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        C0264c c0264c = (C0264c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView viewOnClickListenerC0230b = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = viewOnClickListenerC0230b != null && viewOnClickListenerC0230b.m1104a();
        int i5 = 2;
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * OplusGLSurfaceView_13, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / OplusGLSurfaceView_13;
            if (measuredWidth % OplusGLSurfaceView_13 != 0) {
                i6++;
            }
            if (!z || i6 >= 2) {
                i5 = i6;
            }
        }
        c0264c.f1547d = !c0264c.f1544a && z;
        c0264c.f1545b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(OplusGLSurfaceView_13 * i5, 1073741824), iMakeMeasureSpec);
        return i5;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int paddingLeft;
        if (!this.f1540i) {
            super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - OplusGLSurfaceView_13;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zM1623a = ViewUtils_2.m1623a(this);
        int measuredWidth = paddingRight;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                C0264c c0264c = (C0264c) childAt.getLayoutParams();
                if (c0264c.f1544a) {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    if (m1275a(i11)) {
                        measuredWidth2 += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zM1623a) {
                        paddingLeft = getPaddingLeft() + c0264c.leftMargin;
                        width = paddingLeft + measuredWidth2;
                    } else {
                        width = (getWidth() - getPaddingRight()) - c0264c.rightMargin;
                        paddingLeft = width - measuredWidth2;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    measuredWidth -= measuredWidth2;
                    i9 = 1;
                } else {
                    measuredWidth -= (childAt.getMeasuredWidth() + c0264c.leftMargin) + c0264c.rightMargin;
                    m1275a(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth3 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth3 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth3 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        if (i15 > 0) {
            i6 = measuredWidth / i15;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int iMax = Math.max(i5, i6);
        if (zM1623a) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                C0264c c0264c2 = (C0264c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !c0264c2.f1544a) {
                    int i16 = width2 - c0264c2.rightMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth4, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth4 + c0264c2.leftMargin) + iMax);
                }
                i5++;
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            C0264c c0264c3 = (C0264c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !c0264c3.f1544a) {
                int i18 = paddingLeft2 + c0264c3.leftMargin;
                int measuredWidth5 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth5, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth5 + c0264c3.rightMargin + iMax;
            }
            i5++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo1283i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1538g.m1254a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1538g.m1257b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m1274a() {
        return this.f1537f;
    }

    public void setOverflowReserved(boolean z) {
        this.f1537f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public C0264c generateDefaultLayoutParams() {
        C0264c c0264c = new C0264c(-2, -2);
        c0264c.f1617h = 16;
        return c0264c;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public C0264c generateLayoutParams(AttributeSet attributeSet) {
        return new C0264c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public C0264c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            C0264c c0264c = layoutParams instanceof C0264c ? new C0264c((C0264c) layoutParams) : new C0264c(layoutParams);
            if (c0264c.f1617h <= 0) {
                c0264c.f1617h = 16;
            }
            return c0264c;
        }
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0264c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public C0264c m1277c() {
        C0264c c0264cGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        c0264cGenerateDefaultLayoutParams.f1544a = true;
        return c0264cGenerateDefaultLayoutParams;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo1087a(MenuItemImpl c0238j) {
        return this.f1534c.performItemAction(c0238j, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder c0236h) {
        this.f1534c = c0236h;
    }

    public Menu getMenu() {
        if (this.f1534c == null) {
            Context context = getContext();
            this.f1534c = new MenuBuilder(context);
            this.f1534c.setCallback(new C0265d());
            this.f1538g = new ActionMenuPresenter(context);
            this.f1538g.m1256a(true);
            ActionMenuPresenter actionMenuPresenter = this.f1538g;
            MenuPresenter.PlatformImplementations.kt_3 c0263b = this.f1539h;
            if (c0263b == null) {
                c0263b = new C0263b();
            }
            actionMenuPresenter.setCallback(c0263b);
            this.f1534c.addMenuPresenter(this.f1538g, this.f1535d);
            this.f1538g.m1255a(this);
        }
        return this.f1534c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1273a(MenuPresenter.PlatformImplementations.kt_3 aVar, MenuBuilder.PlatformImplementations.kt_3 aVar2) {
        this.f1539h = aVar;
        this.f1532a = aVar2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public MenuBuilder m1278d() {
        return this.f1534c;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo1279e() {
        ActionMenuPresenter actionMenuPresenter = this.f1538g;
        return actionMenuPresenter != null && actionMenuPresenter.m1260c();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m1280f() {
        ActionMenuPresenter actionMenuPresenter = this.f1538g;
        return actionMenuPresenter != null && actionMenuPresenter.m1261d();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m1281g() {
        ActionMenuPresenter actionMenuPresenter = this.f1538g;
        return actionMenuPresenter != null && actionMenuPresenter.m1264g();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m1282h() {
        ActionMenuPresenter actionMenuPresenter = this.f1538g;
        return actionMenuPresenter != null && actionMenuPresenter.m1265h();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void mo1283i() {
        ActionMenuPresenter actionMenuPresenter = this.f1538g;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m1262e();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m1275a(int OplusGLSurfaceView_13) {
        boolean zMo1106c = false;
        if (OplusGLSurfaceView_13 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(OplusGLSurfaceView_13 - 1);
        KeyEvent.Callback childAt2 = getChildAt(OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 < getChildCount() && (childAt instanceof InterfaceC0262a)) {
            zMo1106c = false | ((InterfaceC0262a) childAt).mo1106c();
        }
        return (OplusGLSurfaceView_13 <= 0 || !(childAt2 instanceof InterfaceC0262a)) ? zMo1106c : zMo1106c | ((InterfaceC0262a) childAt2).mo1105b();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1538g.m1258b(z);
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$IntrinsicsJvm.kt_5 */
    private class C0265d implements MenuBuilder.PlatformImplementations.kt_3 {
        C0265d() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
        public boolean onMenuItemSelected(MenuBuilder c0236h, MenuItem menuItem) {
            return ActionMenuView.this.f1533b != null && ActionMenuView.this.f1533b.mo1284a(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
        public void onMenuModeChange(MenuBuilder c0236h) {
            if (ActionMenuView.this.f1532a != null) {
                ActionMenuView.this.f1532a.onMenuModeChange(c0236h);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$IntrinsicsJvm.kt_4 */
    private static class C0263b implements MenuPresenter.PlatformImplementations.kt_3 {
        @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo861a(MenuBuilder c0236h, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo862a(MenuBuilder c0236h) {
            return false;
        }

        C0263b() {
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$IntrinsicsJvm.kt_3 */
    public static class C0264c extends LinearLayoutCompat.C0277a {

        /* renamed from: PlatformImplementations.kt_3 */
        @ViewDebug.ExportedProperty
        public boolean f1544a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        @ViewDebug.ExportedProperty
        public int f1545b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        @ViewDebug.ExportedProperty
        public int f1546c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        @ViewDebug.ExportedProperty
        public boolean f1547d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        @ViewDebug.ExportedProperty
        public boolean f1548e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        boolean f1549f;

        public C0264c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0264c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0264c(C0264c c0264c) {
            super(c0264c);
            this.f1544a = c0264c.f1544a;
        }

        public C0264c(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f1544a = false;
        }
    }
}
