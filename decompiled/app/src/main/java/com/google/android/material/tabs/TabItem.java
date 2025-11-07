package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.C1694R;

/* loaded from: classes.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray c0322arM1540a = TintTypedArray.m1540a(context, attributeSet, C1694R.styleable.TabItem);
        this.text = c0322arM1540a.m1553c(C1694R.styleable.TabItem_android_text);
        this.icon = c0322arM1540a.m1546a(C1694R.styleable.TabItem_android_icon);
        this.customLayout = c0322arM1540a.m1560g(C1694R.styleable.TabItem_android_layout, 0);
        c0322arM1540a.m1551b();
    }
}
