package com.coui.appcompat.widget.toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.ActionMenuItemView;
import coui.support.appcompat.R;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class COUIActionMenuItemView extends ActionMenuItemView {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f8750e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f8751f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f8752g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f8753h;

    public COUIActionMenuItemView(Context context) {
        this(context, null);
    }

    public COUIActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIActionMenuItemView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f8750e = context.getResources().getDimensionPixelSize(R.dimen.coui_toolbar_menu_bg_padding_horizontal);
        this.f8751f = context.getResources().getDimensionPixelSize(R.dimen.coui_toolbar_menu_bg_padding_vertical);
        this.f8753h = context.getResources().getDimensionPixelSize(R.dimen.coui_toolbar_text_menu_bg_padding_horizontal);
        this.f8752g = context.getResources().getDimensionPixelSize(R.dimen.coui_toolbar_text_menu_bg_padding_vertical);
    }

    @Override // androidx.appcompat.view.menu.ActionMenuItemView, androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public void initialize(MenuItemImpl c0238j, int OplusGLSurfaceView_13) {
        super.initialize(c0238j, OplusGLSurfaceView_13);
        boolean z = c0238j.getIcon() == null;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = z ? -2 : -1;
        setLayoutParams(layoutParams);
        setBackgroundResource(z ? R.drawable.coui_toolbar_text_menu_bg : R.drawable.coui_toolbar_menu_bg);
        if (!z) {
            int i2 = this.f8750e;
            int i3 = this.f8751f;
            setPadding(i2, i3, i2, i3);
        } else {
            int i4 = this.f8753h;
            int i5 = this.f8752g;
            setPadding(i4, i5, i4, i5);
        }
    }
}
