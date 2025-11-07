package com.oplus.camera.sticker.ui;

/* loaded from: classes2.dex */
public class StickerPageView extends androidx.viewpager.widget.ViewPager {
    private com.oplus.camera.sticker.ui.g_renamed d_renamed;
    private android.graphics.Rect e_renamed;
    private boolean f_renamed;
    private float g_renamed;
    private int h_renamed;

    public StickerPageView(android.content.Context context) {
        this(context, null);
    }

    public StickerPageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d_renamed = null;
        this.e_renamed = new android.graphics.Rect();
        this.f_renamed = true;
        this.g_renamed = 0.0f;
        this.h_renamed = 0;
    }

    public void setStickerCategoryInterface(com.oplus.camera.sticker.ui.g_renamed gVar) {
        this.d_renamed = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.oplus.camera.sticker.ui.g_renamed gVar = this.d_renamed;
        if (gVar == null || gVar.a_renamed()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g_renamed = motionEvent.getX();
            this.h_renamed = getCurrentItem();
            com.oplus.camera.sticker.ui.g_renamed gVar = this.d_renamed;
            if (gVar != null) {
                gVar.b_renamed();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            f_renamed();
        } else if (action == 2) {
            float x_renamed = motionEvent.getX();
            float f_renamed = x_renamed - this.g_renamed;
            if (getAdapter().a_renamed() > 1) {
                int i_renamed = this.h_renamed;
                if (i_renamed == 0) {
                    if (this.f_renamed && f_renamed > 10.0f) {
                        b_renamed(x_renamed);
                    } else if (!this.f_renamed) {
                        this.g_renamed = x_renamed;
                        int i2 = (int) (f_renamed * 0.5f);
                        if (getLeft() + i2 >= this.e_renamed.left) {
                            layout(getLeft() + i2, getTop(), getRight() + i2, getBottom());
                        }
                    }
                } else if (i_renamed == getAdapter().a_renamed() - 1) {
                    if (this.f_renamed && f_renamed < -10.0f) {
                        b_renamed(x_renamed);
                    } else if (!this.f_renamed) {
                        this.g_renamed = x_renamed;
                        int i3 = (int) (f_renamed * 0.5f);
                        if (getRight() + i3 <= this.e_renamed.right) {
                            layout(getLeft() + i3, getTop(), getRight() + i3, getBottom());
                        }
                    }
                } else {
                    this.f_renamed = true;
                }
            } else if (this.f_renamed && (f_renamed > 10.0f || f_renamed < -10.0f)) {
                b_renamed(x_renamed);
            } else if (!this.f_renamed) {
                this.g_renamed = x_renamed;
                int i4 = (int) (f_renamed * 0.5f);
                if (getLeft() + i4 >= this.e_renamed.left) {
                    layout(getLeft() + i4, getTop(), getRight() + i4, getBottom());
                }
                if (getRight() + i4 <= this.e_renamed.right) {
                    layout(getLeft() + i4, getTop(), getRight() + i4, getBottom());
                }
            }
            if (!this.f_renamed) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void b_renamed(float f_renamed) {
        this.g_renamed = f_renamed;
        if (this.e_renamed.isEmpty()) {
            this.e_renamed.set(getLeft(), getTop(), getRight(), getBottom());
        }
        this.f_renamed = false;
    }

    private void f_renamed() {
        if (this.e_renamed.isEmpty()) {
            return;
        }
        g_renamed();
    }

    private void g_renamed() {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(getLeft(), this.e_renamed.left, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        startAnimation(translateAnimation);
        layout(this.e_renamed.left, this.e_renamed.top, this.e_renamed.right, this.e_renamed.bottom);
        this.e_renamed.setEmpty();
        this.f_renamed = true;
    }
}
