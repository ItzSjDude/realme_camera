package com.oplus.camera.screen;

/* compiled from: LayoutUtil.java */
/* loaded from: classes2.dex */
public class d_renamed {
    public static void a_renamed(android.view.View view) {
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.removeRule(10);
        layoutParams.removeRule(9);
        layoutParams.removeRule(11);
        layoutParams.removeRule(20);
        layoutParams.removeRule(21);
        layoutParams.removeRule(12);
        layoutParams.removeRule(13);
        layoutParams.removeRule(14);
        layoutParams.removeRule(15);
        layoutParams.removeRule(2);
        layoutParams.removeRule(3);
        layoutParams.removeRule(16);
        layoutParams.removeRule(0);
        layoutParams.removeRule(17);
        layoutParams.removeRule(1);
        layoutParams.setMargins(0, 0, 0, 0);
        if (layoutParams.getMarginStart() != 0) {
            layoutParams.setMarginStart(0);
        }
        if (layoutParams.getMarginEnd() != 0) {
            layoutParams.setMarginEnd(0);
        }
    }

    public static void a_renamed(android.view.View view, com.oplus.camera.screen.c_renamed cVar) {
        boolean z_renamed;
        if (cVar.g_renamed) {
            a_renamed(view);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) view.getLayoutParams();
        if (cVar.f5363a != null) {
            int i_renamed = 0;
            z_renamed = false;
            while (i_renamed < cVar.f5363a.length) {
                int i2 = cVar.f5363a[i_renamed];
                if (i2 == 20 || i2 == 21) {
                    z_renamed = true;
                }
                int i3 = i_renamed + 1;
                int i4 = cVar.f5363a[i3];
                if (i4 == 0) {
                    layoutParams.addRule(i2);
                } else {
                    layoutParams.addRule(i2, i4);
                }
                i_renamed = i3 + 1;
            }
        } else {
            z_renamed = false;
        }
        if (cVar.f5364b != null) {
            if (z_renamed) {
                layoutParams.setMargins(cVar.f5364b[0], cVar.f5364b[1], cVar.f5364b[2], cVar.f5364b[3]);
                layoutParams.setMarginStart(cVar.f5364b[0]);
                layoutParams.setMarginEnd(cVar.f5364b[2]);
            } else {
                layoutParams.setMargins(cVar.f5364b[0], cVar.f5364b[1], cVar.f5364b[2], cVar.f5364b[3]);
                layoutParams.setMarginStart(Integer.MIN_VALUE);
                layoutParams.setMarginEnd(Integer.MIN_VALUE);
            }
        }
        if (cVar.f5365c != null) {
            layoutParams.width = cVar.f5365c[0];
            layoutParams.height = cVar.f5365c[1];
        }
        if (cVar.e_renamed != null) {
            view.setPivotX(cVar.e_renamed[0]);
            view.setPivotY(cVar.e_renamed[1]);
        }
        view.setRotation(cVar.d_renamed);
        if (cVar.f_renamed != null) {
            cVar.f_renamed.call(view);
        }
    }
}
