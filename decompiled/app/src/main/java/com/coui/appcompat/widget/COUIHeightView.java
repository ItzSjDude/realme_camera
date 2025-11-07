package com.coui.appcompat.widget;

/* loaded from: classes.dex */
public class COUIHeightView {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.View f2733a;

    public void setHeight(int i_renamed) {
        android.view.View view = this.f2733a;
        if (view != null) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i_renamed;
            this.f2733a.setLayoutParams(layoutParams);
        }
    }

    public int getHeight() {
        android.view.View view = this.f2733a;
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }
}
