package com.oplus.camera.p172ui.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.coui.appcompat.widget.COUIToolTips;
import java.lang.reflect.Field;
import java.util.ArrayDeque;

/* compiled from: SuperColorToolTips.java */
/* renamed from: com.oplus.camera.ui.widget.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class SuperColorToolTips extends COUIToolTips {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f22793a = "IntrinsicsJvm.kt_3";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f22794b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f22795c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f22796d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f22797e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f22798f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22799g;

    public SuperColorToolTips(Context context) {
        super(context);
        this.f22794b = -1;
        this.f22797e = -1;
        this.f22798f = -1;
        this.f22799g = 0;
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int OplusGLSurfaceView_13, int i2, int i3) {
        if (this.f22797e > 0 || this.f22798f > 0) {
            if (this.f22797e - getHeight() > this.f22799g) {
                super.showAtLocation(view, 49, 0, this.f22797e - getHeight());
                return;
            } else {
                super.showAtLocation(view, 49, 0, this.f22798f);
                return;
            }
        }
        int i4 = this.f22794b;
        if (i4 >= 0) {
            super.showAtLocation(view, OplusGLSurfaceView_13, i2, i4);
        } else {
            super.showAtLocation(view, OplusGLSurfaceView_13, i2 + this.f22795c, i3 + this.f22796d);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24103a(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f22797e = OplusGLSurfaceView_13;
        this.f22798f = i2;
        this.f22799g = i3;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24104b(int OplusGLSurfaceView_13) {
        this.f22796d = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24102a(int OplusGLSurfaceView_13, int i2) {
        this.f22795c = OplusGLSurfaceView_13;
        this.f22796d = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24101a() throws NoSuchFieldException {
        int childCount;
        try {
            Field declaredField = COUIToolTips.class.getDeclaredField("COUIBaseListPopupWindow_11");
            declaredField.setAccessible(true);
            ViewGroup viewGroup = (ViewGroup) declaredField.get(this);
            if (viewGroup != null) {
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.offer(viewGroup);
                while (!arrayDeque.isEmpty()) {
                    ViewGroup viewGroup2 = (ViewGroup) arrayDeque.poll();
                    if (viewGroup2 != null && (childCount = viewGroup2.getChildCount()) > 0) {
                        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                            View childAt = viewGroup2.getChildAt(OplusGLSurfaceView_13);
                            if (childAt instanceof ImageView) {
                                childAt.setVisibility(8);
                            } else if (childAt instanceof ScrollView) {
                                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                                if (layoutParams instanceof FrameLayout.LayoutParams) {
                                    ((FrameLayout.LayoutParams) layoutParams).rightMargin = ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                                    ((FrameLayout.LayoutParams) layoutParams).setMarginEnd(((FrameLayout.LayoutParams) layoutParams).getMarginStart());
                                }
                            } else if (childAt instanceof ViewGroup) {
                                arrayDeque.offer((ViewGroup) childAt);
                            }
                        }
                    }
                }
                viewGroup.requestLayout();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }
}
