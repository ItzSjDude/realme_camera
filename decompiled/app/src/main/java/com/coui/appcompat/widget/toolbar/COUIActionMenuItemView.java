package com.coui.appcompat.widget.toolbar;

@android.annotation.SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class COUIActionMenuItemView extends androidx.appcompat.view.menu.b_renamed {
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private int h_renamed;

    public COUIActionMenuItemView(android.content.Context context) {
        this(context, null);
    }

    public COUIActionMenuItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIActionMenuItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.e_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_toolbar_menu_bg_padding_horizontal);
        this.f_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_toolbar_menu_bg_padding_vertical);
        this.h_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_toolbar_text_menu_bg_padding_horizontal);
        this.g_renamed = context.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_toolbar_text_menu_bg_padding_vertical);
    }

    @Override // androidx.appcompat.view.menu.b_renamed, androidx.appcompat.view.menu.o_renamed.a_renamed
    public void initialize(androidx.appcompat.view.menu.j_renamed jVar, int i_renamed) {
        super.initialize(jVar, i_renamed);
        boolean z_renamed = jVar.getIcon() == null;
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = z_renamed ? -2 : -1;
        setLayoutParams(layoutParams);
        setBackgroundResource(z_renamed ? coui.support.appcompat.R_renamed.drawable.coui_toolbar_text_menu_bg : coui.support.appcompat.R_renamed.drawable.coui_toolbar_menu_bg);
        if (!z_renamed) {
            int i2 = this.e_renamed;
            int i3 = this.f_renamed;
            setPadding(i2, i3, i2, i3);
        } else {
            int i4 = this.h_renamed;
            int i5 = this.g_renamed;
            setPadding(i4, i5, i4, i5);
        }
    }
}
