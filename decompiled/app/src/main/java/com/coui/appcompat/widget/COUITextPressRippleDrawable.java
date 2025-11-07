package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import com.coui.appcompat.p099a.COUIStateListUtil;
import coui.support.appcompat.R;

/* compiled from: COUITextPressRippleDrawable.java */
/* renamed from: com.coui.appcompat.widget.r */
/* loaded from: classes.dex */
public class COUITextPressRippleDrawable extends RippleDrawable {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int f8648a = Color.parseColor("#00000000");

    public COUITextPressRippleDrawable(Context context) throws Resources.NotFoundException {
        super(COUIStateListUtil.m6465a(context.getResources().getColor(R.color.text_ripple_bg_color), f8648a), new ColorDrawable(f8648a), new COUITextPressMaskDrawable());
        m8114a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8114a(Context context) throws Resources.NotFoundException {
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.text_ripple_bg_padding_horizontal);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.text_ripple_bg_padding_vertical);
        setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
    }
}
