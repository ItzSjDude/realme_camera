package com.oplus.camera.screen;

import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: LayoutUtil.java */
/* renamed from: com.oplus.camera.screen.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class LayoutUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16634a(View view) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
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

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16635a(View view, LayoutItem c2949c) {
        boolean z;
        if (c2949c.f16024g) {
            m16634a(view);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (c2949c.f16018a != null) {
            int OplusGLSurfaceView_13 = 0;
            z = false;
            while (OplusGLSurfaceView_13 < c2949c.f16018a.length) {
                int i2 = c2949c.f16018a[OplusGLSurfaceView_13];
                if (i2 == 20 || i2 == 21) {
                    z = true;
                }
                int i3 = OplusGLSurfaceView_13 + 1;
                int i4 = c2949c.f16018a[i3];
                if (i4 == 0) {
                    layoutParams.addRule(i2);
                } else {
                    layoutParams.addRule(i2, i4);
                }
                OplusGLSurfaceView_13 = i3 + 1;
            }
        } else {
            z = false;
        }
        if (c2949c.f16019b != null) {
            if (z) {
                layoutParams.setMargins(c2949c.f16019b[0], c2949c.f16019b[1], c2949c.f16019b[2], c2949c.f16019b[3]);
                layoutParams.setMarginStart(c2949c.f16019b[0]);
                layoutParams.setMarginEnd(c2949c.f16019b[2]);
            } else {
                layoutParams.setMargins(c2949c.f16019b[0], c2949c.f16019b[1], c2949c.f16019b[2], c2949c.f16019b[3]);
                layoutParams.setMarginStart(Integer.MIN_VALUE);
                layoutParams.setMarginEnd(Integer.MIN_VALUE);
            }
        }
        if (c2949c.f16020c != null) {
            layoutParams.width = c2949c.f16020c[0];
            layoutParams.height = c2949c.f16020c[1];
        }
        if (c2949c.f16022e != null) {
            view.setPivotX(c2949c.f16022e[0]);
            view.setPivotY(c2949c.f16022e[1]);
        }
        view.setRotation(c2949c.f16021d);
        if (c2949c.f16023f != null) {
            c2949c.f16023f.call(view);
        }
    }
}
