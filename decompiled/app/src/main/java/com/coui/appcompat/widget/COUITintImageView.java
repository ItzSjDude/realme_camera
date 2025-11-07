package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUITintImageView extends androidx.appcompat.widget.AppCompatImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int[] f2850a = {android.R_renamed.attr.background, android.R_renamed.attr.src};

    /* renamed from: b_renamed, reason: collision with root package name */
    private final com.coui.appcompat.a_renamed.v_renamed f2851b;

    public COUITintImageView(android.content.Context context) {
        this(context, null);
    }

    public COUITintImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUITintImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(getContext(), attributeSet, f2850a, i_renamed, 0);
        if (arVarA.a_renamed() > 0) {
            if (arVarA.g_renamed(0)) {
                setBackgroundDrawable(arVarA.a_renamed(0));
            }
            if (arVarA.g_renamed(1)) {
                setImageDrawable(arVarA.a_renamed(1));
            }
        }
        arVarA.b_renamed();
        this.f2851b = com.coui.appcompat.a_renamed.v_renamed.a_renamed(context);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i_renamed) {
        setImageDrawable(this.f2851b.a_renamed(i_renamed));
    }
}
