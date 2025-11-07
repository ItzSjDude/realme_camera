package com.oplus.camera.ui.widget;

/* compiled from: SuperColorToolTips.java */
/* loaded from: classes2.dex */
public class c_renamed extends com.coui.appcompat.widget.s_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7263a = "c_renamed";

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7264b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f7265c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;

    public c_renamed(android.content.Context context) {
        super(context);
        this.f7264b = -1;
        this.e_renamed = -1;
        this.f_renamed = -1;
        this.g_renamed = 0;
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(android.view.View view, int i_renamed, int i2, int i3) {
        if (this.e_renamed > 0 || this.f_renamed > 0) {
            if (this.e_renamed - getHeight() > this.g_renamed) {
                super.showAtLocation(view, 49, 0, this.e_renamed - getHeight());
                return;
            } else {
                super.showAtLocation(view, 49, 0, this.f_renamed);
                return;
            }
        }
        int i4 = this.f7264b;
        if (i4 >= 0) {
            super.showAtLocation(view, i_renamed, i2, i4);
        } else {
            super.showAtLocation(view, i_renamed, i2 + this.f7265c, i3 + this.d_renamed);
        }
    }

    public void a_renamed(int i_renamed, int i2, int i3) {
        this.e_renamed = i_renamed;
        this.f_renamed = i2;
        this.g_renamed = i3;
    }

    public void b_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed, int i2) {
        this.f7265c = i_renamed;
        this.d_renamed = i2;
    }

    public void a_renamed() throws java.lang.NoSuchFieldException {
        int childCount;
        try {
            java.lang.reflect.Field declaredField = com.coui.appcompat.widget.s_renamed.class.getDeclaredField("g_renamed");
            declaredField.setAccessible(true);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) declaredField.get(this);
            if (viewGroup != null) {
                java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
                arrayDeque.offer(viewGroup);
                while (!arrayDeque.isEmpty()) {
                    android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) arrayDeque.poll();
                    if (viewGroup2 != null && (childCount = viewGroup2.getChildCount()) > 0) {
                        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                            android.view.View childAt = viewGroup2.getChildAt(i_renamed);
                            if (childAt instanceof android.widget.ImageView) {
                                childAt.setVisibility(8);
                            } else if (childAt instanceof android.widget.ScrollView) {
                                android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                if (layoutParams instanceof android.widget.FrameLayout.LayoutParams) {
                                    ((android.widget.FrameLayout.LayoutParams) layoutParams).rightMargin = ((android.widget.FrameLayout.LayoutParams) layoutParams).leftMargin;
                                    ((android.widget.FrameLayout.LayoutParams) layoutParams).setMarginEnd(((android.widget.FrameLayout.LayoutParams) layoutParams).getMarginStart());
                                }
                            } else if (childAt instanceof android.view.ViewGroup) {
                                arrayDeque.offer((android.view.ViewGroup) childAt);
                            }
                        }
                    }
                }
                viewGroup.requestLayout();
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
    }
}
