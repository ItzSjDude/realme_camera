package com.coui.appcompat.widget.navigation;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import com.coui.appcompat.p099a.COUIOrientationUtil;

/* compiled from: COUINavigationMenuView.java */
/* renamed from: com.coui.appcompat.widget.navigation.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class COUINavigationMenuView extends ViewGroup implements MenuView {

    /* renamed from: PlatformImplementations.kt_3 */
    private View.OnClickListener f8402a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private COUINavigationItemView[] f8403b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ColorStateList f8404c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ColorStateList f8405d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f8406e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f8407f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f8408g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f8409h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f8410i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f8411j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f8412k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int[] f8413l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f8414m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f8415n;

    /* renamed from: o */
    private SparseArray<PlatformImplementations.kt_3> f8416o;

    /* renamed from: p */
    private COUINavigationPresenter f8417p;

    /* renamed from: q */
    private MenuBuilder f8418q;

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder c0236h) {
        this.f8418q = c0236h;
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13) - (this.f8412k * 2);
        int childCount = getChildCount();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f8407f, 1073741824);
        int i3 = size / (childCount == 0 ? 1 : childCount);
        int i4 = size - (i3 * childCount);
        for (int i5 = 0; i5 < childCount; i5++) {
            int[] iArr = this.f8413l;
            iArr[i5] = i3;
            if (i4 > 0) {
                iArr[i5] = iArr[i5] + 1;
                i4--;
            }
        }
        int measuredWidth = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                if (childCount == 1) {
                    int i7 = this.f8412k;
                    childAt.setPadding(i7, 0, i7, 0);
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f8413l[i6] + (this.f8412k * 2), 1073741824), iMakeMeasureSpec);
                } else if (i6 == 0) {
                    childAt.setPadding(m7971c() ? 0 : this.f8412k, 0, m7971c() ? this.f8412k : 0, 0);
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f8413l[i6] + this.f8412k, 1073741824), iMakeMeasureSpec);
                } else if (i6 == childCount - 1) {
                    childAt.setPadding(m7971c() ? this.f8412k : 0, 0, m7971c() ? 0 : this.f8412k, 0);
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f8413l[i6] + this.f8412k, 1073741824), iMakeMeasureSpec);
                } else {
                    childAt.setPadding(0, 0, 0, 0);
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f8413l[i6], 1073741824), iMakeMeasureSpec);
                }
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth, View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), 0), View.resolveSizeAndState(this.f8407f, iMakeMeasureSpec, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - OplusGLSurfaceView_13;
        int i6 = i4 - i2;
        int measuredWidth = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (m7971c()) {
                    int i8 = i5 - measuredWidth;
                    childAt.layout(i8 - childAt.getMeasuredWidth(), 0, i8, i6);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i6);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Deprecated
    public void setIconTintList(ColorStateList colorStateList) {
        this.f8405d = colorStateList;
        COUINavigationItemView[] c1495aArr = this.f8403b;
        if (c1495aArr == null) {
            return;
        }
        for (COUINavigationItemView c1495a : c1495aArr) {
            c1495a.setIconTintList(colorStateList);
        }
    }

    public ColorStateList getIconTintList() {
        return this.f8405d;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f8404c = colorStateList;
        COUINavigationItemView[] c1495aArr = this.f8403b;
        if (c1495aArr == null) {
            return;
        }
        for (COUINavigationItemView c1495a : c1495aArr) {
            c1495a.setTextColor(colorStateList);
        }
    }

    public void setItemLayoutType(int OplusGLSurfaceView_13) {
        this.f8406e = OplusGLSurfaceView_13;
        COUINavigationItemView[] c1495aArr = this.f8403b;
        if (c1495aArr == null) {
            return;
        }
        for (COUINavigationItemView c1495a : c1495aArr) {
            c1495a.setItemLayoutType(OplusGLSurfaceView_13);
        }
    }

    public int getItemLayoutType() {
        return this.f8406e;
    }

    public void setItemTextSize(int OplusGLSurfaceView_13) {
        this.f8411j = OplusGLSurfaceView_13;
        COUINavigationItemView[] c1495aArr = this.f8403b;
        if (c1495aArr == null) {
            return;
        }
        for (COUINavigationItemView c1495a : c1495aArr) {
            c1495a.setTextSize(OplusGLSurfaceView_13);
        }
    }

    public ColorStateList getItemTextColor() {
        return this.f8404c;
    }

    public void setItemBackgroundRes(int OplusGLSurfaceView_13) {
        this.f8410i = OplusGLSurfaceView_13;
        COUINavigationItemView[] c1495aArr = this.f8403b;
        if (c1495aArr == null) {
            return;
        }
        for (COUINavigationItemView c1495a : c1495aArr) {
            c1495a.setItemBackground(OplusGLSurfaceView_13);
        }
    }

    public int getItemBackgroundRes() {
        return this.f8410i;
    }

    public void setPresenter(COUINavigationPresenter cOUINavigationPresenter) {
        this.f8417p = cOUINavigationPresenter;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7972a() {
        int size = this.f8418q.getVisibleItems().size();
        if (size != 0) {
            removeAllViews();
        }
        if (size == 0) {
            this.f8408g = 0;
            this.f8409h = 0;
            this.f8403b = null;
            return;
        }
        this.f8403b = new COUINavigationItemView[size];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            MenuItemImpl c0238j = this.f8418q.getVisibleItems().get(OplusGLSurfaceView_13);
            if (OplusGLSurfaceView_13 >= 5) {
                break;
            }
            COUINavigationItemView newItem = getNewItem();
            this.f8403b[OplusGLSurfaceView_13] = newItem;
            newItem.setIconTintList(this.f8405d);
            newItem.setTextColor(this.f8404c);
            newItem.setTextSize(this.f8411j);
            newItem.setItemBackground(this.f8410i);
            newItem.initialize(c0238j, 0);
            newItem.setItemPosition(OplusGLSurfaceView_13);
            newItem.setOnClickListener(this.f8402a);
            PlatformImplementations.kt_3 aVar = this.f8416o.get(c0238j.getItemId());
            if (aVar != null) {
                newItem.m7970a(aVar.m7975a(), aVar.m7976b());
            }
            addView(newItem);
        }
        this.f8409h = Math.min(this.f8418q.getVisibleItems().size() - 1, this.f8409h);
        this.f8418q.getVisibleItems().get(this.f8409h).setChecked(true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7974b() {
        int size = this.f8418q.getVisibleItems().size();
        if (size != this.f8403b.length) {
            m7972a();
            return;
        }
        int OplusGLSurfaceView_13 = this.f8408g;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl c0238j = this.f8418q.getVisibleItems().get(i2);
            if (c0238j.isChecked()) {
                this.f8408g = c0238j.getItemId();
                this.f8409h = i2;
            }
        }
        if (OplusGLSurfaceView_13 != this.f8408g) {
            int i3 = Build.VERSION.SDK_INT;
        }
        if (this.f8403b == null) {
            return;
        }
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f8403b[i4] != null) {
                this.f8417p.m7959a(true);
                this.f8403b[i4].initialize(this.f8418q.getVisibleItems().get(i4), 0);
                this.f8417p.m7959a(false);
            }
        }
    }

    public int getSelectedItemId() {
        return this.f8408g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7973a(int OplusGLSurfaceView_13) {
        int size = this.f8418q.getVisibleItems().size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl c0238j = this.f8418q.getVisibleItems().get(i2);
            if (OplusGLSurfaceView_13 == c0238j.getItemId()) {
                this.f8408g = OplusGLSurfaceView_13;
                this.f8409h = i2;
                c0238j.setChecked(true);
                return;
            }
        }
    }

    public void setItemHeight(int OplusGLSurfaceView_13) {
        this.f8407f = OplusGLSurfaceView_13;
    }

    protected void setNeedTextAnim(boolean z) {
        this.f8414m = z;
    }

    private COUINavigationItemView getNewItem() {
        return new COUINavigationItemView(getContext(), this.f8406e);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m7971c() {
        return Build.VERSION.SDK_INT > 16 && getLayoutDirection() == 1;
    }

    /* compiled from: COUINavigationMenuView.java */
    /* renamed from: com.coui.appcompat.widget.navigation.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f8419a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f8420b;

        /* renamed from: PlatformImplementations.kt_3 */
        public int m7975a() {
            return this.f8419a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m7976b() {
            return this.f8420b;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int iM6434a = COUIOrientationUtil.m6434a(getContext());
        if (iM6434a != this.f8415n) {
            m7972a();
            this.f8415n = iM6434a;
        }
    }
}
