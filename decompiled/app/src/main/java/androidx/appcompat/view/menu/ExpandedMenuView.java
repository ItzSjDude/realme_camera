package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, MenuBuilder.IntrinsicsJvm.kt_4, MenuView {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int[] f1239a = {R.attr.background, R.attr.divider};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private MenuBuilder f1240b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f1241c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(context, attributeSet, f1239a, OplusGLSurfaceView_13, 0);
        if (c0322arM1541a.m1561g(0)) {
            setBackgroundDrawable(c0322arM1541a.m1546a(0));
        }
        if (c0322arM1541a.m1561g(1)) {
            setDivider(c0322arM1541a.m1546a(1));
        }
        c0322arM1541a.m1551b();
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder c0236h) {
        this.f1240b = c0236h;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.IntrinsicsJvm.kt_4
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo1087a(MenuItemImpl c0238j) {
        return this.f1240b.performItemAction(c0238j, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        mo1087a((MenuItemImpl) getAdapter().getItem(OplusGLSurfaceView_13));
    }

    public int getWindowAnimations() {
        return this.f1241c;
    }
}
