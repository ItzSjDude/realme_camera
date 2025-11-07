package com.coui.appcompat.a_renamed;

/* compiled from: COUITextViewCompatUtil.java */
/* loaded from: classes.dex */
public class s_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f2403a = "s_renamed";

    public static void a_renamed(android.widget.TextView textView) {
        if (textView == null) {
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            textView.setBackground(new com.coui.appcompat.widget.r_renamed(textView.getContext()));
        } else {
            textView.setBackground(textView.getContext().getDrawable(coui.support.appcompat.R_renamed.drawable.text_ripple_bg));
        }
    }
}
