package com.coui.appcompat.a_renamed;

/* compiled from: COUIViewMarginUtil.java */
/* loaded from: classes.dex */
public class y_renamed {
    public static int a_renamed(android.view.View view, int i_renamed) {
        if (view != null) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
                if (i_renamed == 0) {
                    return ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                }
                if (i_renamed == 1) {
                    return ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                }
                if (i_renamed == 2) {
                    return ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                if (i_renamed != 3) {
                    return 0;
                }
                return ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }
        }
        return 0;
    }

    public static void a_renamed(android.view.View view, int i_renamed, int i2) {
        if (view != null) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
                if (i_renamed == 0) {
                    ((android.view.ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i2;
                } else if (i_renamed == 1) {
                    ((android.view.ViewGroup.MarginLayoutParams) layoutParams).topMargin = i2;
                } else if (i_renamed == 2) {
                    ((android.view.ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i2;
                } else if (i_renamed == 3) {
                    ((android.view.ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i2;
                }
                view.setLayoutParams(layoutParams);
            }
        }
    }
}
