package com.google.android.material.tabs;

/* loaded from: classes.dex */
public class TabItem extends android.view.View {
    public final int customLayout;
    public final android.graphics.drawable.Drawable icon;
    public final java.lang.CharSequence text;

    public TabItem(android.content.Context context) {
        this(context, null);
    }

    public TabItem(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(context, attributeSet, com.google.android.material.R_renamed.styleable.TabItem);
        this.text = arVarA.c_renamed(com.google.android.material.R_renamed.styleable.TabItem_android_text);
        this.icon = arVarA.a_renamed(com.google.android.material.R_renamed.styleable.TabItem_android_icon);
        this.customLayout = arVarA.g_renamed(com.google.android.material.R_renamed.styleable.TabItem_android_layout, 0);
        arVarA.b_renamed();
    }
}
