package com.coui.appcompat.p099a;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: COUIViewMarginUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.y */
/* loaded from: classes.dex */
public class COUIViewMarginUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static int m6502a(View view, int OplusGLSurfaceView_13) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                if (OplusGLSurfaceView_13 == 0) {
                    return ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                }
                if (OplusGLSurfaceView_13 == 1) {
                    return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                }
                if (OplusGLSurfaceView_13 == 2) {
                    return ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                if (OplusGLSurfaceView_13 != 3) {
                    return 0;
                }
                return ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m6503a(View view, int OplusGLSurfaceView_13, int i2) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                if (OplusGLSurfaceView_13 == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i2;
                } else if (OplusGLSurfaceView_13 == 1) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i2;
                } else if (OplusGLSurfaceView_13 == 2) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i2;
                } else if (OplusGLSurfaceView_13 == 3) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i2;
                }
                view.setLayoutParams(layoutParams);
            }
        }
    }
}
