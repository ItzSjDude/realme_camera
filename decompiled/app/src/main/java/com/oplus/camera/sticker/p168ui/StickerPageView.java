package com.oplus.camera.sticker.p168ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class StickerPageView extends ViewPager {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private StickerCategoryInterface f16299d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Rect f16300e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f16301f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f16302g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f16303h;

    public StickerPageView(Context context) {
        this(context, null);
    }

    public StickerPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16299d = null;
        this.f16300e = new Rect();
        this.f16301f = true;
        this.f16302g = 0.0f;
        this.f16303h = 0;
    }

    public void setStickerCategoryInterface(StickerCategoryInterface interfaceC3014g) {
        this.f16299d = interfaceC3014g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        StickerCategoryInterface interfaceC3014g = this.f16299d;
        if (interfaceC3014g == null || interfaceC3014g.mo17079a()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f16302g = motionEvent.getX();
            this.f16303h = getCurrentItem();
            StickerCategoryInterface interfaceC3014g = this.f16299d;
            if (interfaceC3014g != null) {
                interfaceC3014g.mo17080b();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            m17002f();
        } else if (action == 2) {
            float x = motionEvent.getX();
            float COUIBaseListPopupWindow_12 = x - this.f16302g;
            if (getAdapter().mo5000a() > 1) {
                int OplusGLSurfaceView_13 = this.f16303h;
                if (OplusGLSurfaceView_13 == 0) {
                    if (this.f16301f && COUIBaseListPopupWindow_12 > 10.0f) {
                        m17001b(x);
                    } else if (!this.f16301f) {
                        this.f16302g = x;
                        int i2 = (int) (COUIBaseListPopupWindow_12 * 0.5f);
                        if (getLeft() + i2 >= this.f16300e.left) {
                            layout(getLeft() + i2, getTop(), getRight() + i2, getBottom());
                        }
                    }
                } else if (OplusGLSurfaceView_13 == getAdapter().mo5000a() - 1) {
                    if (this.f16301f && COUIBaseListPopupWindow_12 < -10.0f) {
                        m17001b(x);
                    } else if (!this.f16301f) {
                        this.f16302g = x;
                        int i3 = (int) (COUIBaseListPopupWindow_12 * 0.5f);
                        if (getRight() + i3 <= this.f16300e.right) {
                            layout(getLeft() + i3, getTop(), getRight() + i3, getBottom());
                        }
                    }
                } else {
                    this.f16301f = true;
                }
            } else if (this.f16301f && (COUIBaseListPopupWindow_12 > 10.0f || COUIBaseListPopupWindow_12 < -10.0f)) {
                m17001b(x);
            } else if (!this.f16301f) {
                this.f16302g = x;
                int i4 = (int) (COUIBaseListPopupWindow_12 * 0.5f);
                if (getLeft() + i4 >= this.f16300e.left) {
                    layout(getLeft() + i4, getTop(), getRight() + i4, getBottom());
                }
                if (getRight() + i4 <= this.f16300e.right) {
                    layout(getLeft() + i4, getTop(), getRight() + i4, getBottom());
                }
            }
            if (!this.f16301f) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17001b(float COUIBaseListPopupWindow_12) {
        this.f16302g = COUIBaseListPopupWindow_12;
        if (this.f16300e.isEmpty()) {
            this.f16300e.set(getLeft(), getTop(), getRight(), getBottom());
        }
        this.f16301f = false;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m17002f() {
        if (this.f16300e.isEmpty()) {
            return;
        }
        m17003g();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m17003g() {
        TranslateAnimation translateAnimation = new TranslateAnimation(getLeft(), this.f16300e.left, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        startAnimation(translateAnimation);
        layout(this.f16300e.left, this.f16300e.top, this.f16300e.right, this.f16300e.bottom);
        this.f16300e.setEmpty();
        this.f16301f = true;
    }
}
