package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class IgnoreWindowInsetsFrameLayout extends FrameLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f7912a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f7913b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f7914c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f7915d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f7916e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f7917f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f7918g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f7919h;

    public IgnoreWindowInsetsFrameLayout(Context context) {
        super(context);
        this.f7912a = true;
        this.f7913b = true;
        this.f7914c = true;
        this.f7915d = true;
    }

    public IgnoreWindowInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7912a = true;
        this.f7913b = true;
        this.f7914c = true;
        this.f7915d = true;
        m7522a(attributeSet);
    }

    public IgnoreWindowInsetsFrameLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f7912a = true;
        this.f7913b = true;
        this.f7914c = true;
        this.f7915d = true;
        m7522a(attributeSet);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7522a(AttributeSet attributeSet) {
        if (getContext() != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.IgnoreWindowInsetsFrameLayout);
            this.f7912a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.f24535x39e9749f, true);
            this.f7913b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.f24537xd051f9bd, true);
            this.f7914c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.f24536x39b8084, true);
            this.f7915d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.f24534x54e1a8c3, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        setPadding(this.f7912a ? 0 : Math.max(0, windowInsets.getSystemWindowInsetLeft() + this.f7916e), this.f7913b ? 0 : Math.max(0, windowInsets.getSystemWindowInsetTop() + this.f7917f), this.f7914c ? 0 : Math.max(0, windowInsets.getSystemWindowInsetRight() + this.f7918g), this.f7915d ? 0 : Math.max(0, windowInsets.getSystemWindowInsetBottom() + this.f7919h));
        this.f7916e = 0;
        this.f7917f = 0;
        this.f7918g = 0;
        this.f7919h = 0;
        return windowInsets.consumeSystemWindowInsets();
    }

    public void setIgnoreWindowInsetsLeft(boolean z) {
        this.f7912a = z;
    }

    public void setIgnoreWindowInsetsTop(boolean z) {
        this.f7913b = z;
    }

    public void setIgnoreWindowInsetsRight(boolean z) {
        this.f7914c = z;
    }

    public void setIgnoreWindowInsetsBottom(boolean z) {
        this.f7915d = z;
    }

    public void setWindowInsetsLeftOffset(int OplusGLSurfaceView_13) {
        this.f7916e = OplusGLSurfaceView_13;
    }

    public void setWindowInsetsTopOffset(int OplusGLSurfaceView_13) {
        this.f7917f = OplusGLSurfaceView_13;
    }

    public void setWindowInsetsRightOffset(int OplusGLSurfaceView_13) {
        this.f7918g = OplusGLSurfaceView_13;
    }

    public void setWindowInsetsBottomOffset(int OplusGLSurfaceView_13) {
        this.f7919h = OplusGLSurfaceView_13;
    }
}
