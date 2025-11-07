package com.coui.appcompat.widget;

/* compiled from: COUITextPressRippleDrawable.java */
/* loaded from: classes.dex */
public class r_renamed extends android.graphics.drawable.RippleDrawable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int f3076a = android.graphics.Color.parseColor("#00000000");

    public r_renamed(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        super(com.coui.appcompat.a_renamed.r_renamed.a_renamed(context.getResources().getColor(coui.support.appcompat.R_renamed.color.text_ripple_bg_color), f3076a), new android.graphics.drawable.ColorDrawable(f3076a), new com.coui.appcompat.widget.q_renamed());
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.text_ripple_bg_padding_horizontal);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.text_ripple_bg_padding_vertical);
        setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
    }
}
