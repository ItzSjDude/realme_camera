package com.oplus.camera.p172ui.menu.levelcontrol;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: CameraImageButton.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class CameraImageButton extends ImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private Paint f19665a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Drawable f19666b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Drawable f19667c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Drawable f19668d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f19669e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f19670f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f19671g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f19672h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f19673i;

    /* renamed from: OplusGLSurfaceView_15 */
    private long f19674j;

    /* renamed from: OplusGLSurfaceView_5 */
    private long f19675k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f19676l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f19677m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f19678n;

    /* renamed from: o */
    private boolean f19679o;

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        return false;
    }

    public void setNormalShape(boolean z) {
        this.f19678n = z;
    }

    public void setBaseShape(boolean z) {
        this.f19679o = z;
    }

    public CameraImageButton(Context context) {
        super(context);
        this.f19666b = null;
        this.f19667c = null;
        this.f19668d = null;
        this.f19669e = 0;
        this.f19670f = "";
        this.f19671g = 0;
        this.f19672h = 0;
        this.f19673i = 0;
        this.f19674j = 0L;
        this.f19675k = 0L;
        this.f19676l = 0.0f;
        this.f19677m = false;
        this.f19678n = false;
        this.f19679o = false;
        m20840a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20840a() {
        Resources resources = getContext().getResources();
        this.f19676l = (resources.getDimensionPixelSize(R.dimen.level_pop_text_circle_diameter) / 2) + resources.getDimensionPixelSize(R.dimen.level_pop_text_circle_margin_right);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20841a(String str) {
        if (str == null) {
            return;
        }
        if (this.f19665a == null) {
            Resources resources = getContext().getResources();
            this.f19665a = new Paint(1);
            this.f19665a.setTextSize(resources.getDimensionPixelSize(R.dimen.menu_tool_item_text_size));
            this.f19665a.setColor(-1);
            this.f19665a.setShadowLayer(resources.getDimensionPixelSize(R.dimen.level_pop_text_shadow_radius), 0.0f, resources.getDimensionPixelSize(R.dimen.level_pop_text_shadow_offset_y), resources.getColor(R.color.level_pop_text_shadow_color));
            this.f19665a.setTypeface(Util.m24473l(getContext()));
        }
        this.f19670f = str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20844a(boolean z, String str, Drawable drawable) {
        if (z) {
            m20841a(str);
            this.f19666b = drawable;
            this.f19669e = 0;
        } else {
            if (drawable != null) {
                this.f19667c = drawable;
            }
            this.f19669e = 1;
        }
        invalidate();
    }

    public void setPopdownButtonImage(Drawable drawable) {
        if (this.f19668d == null) {
            this.f19668d = drawable;
        }
        this.f19669e = 2;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        int OplusGLSurfaceView_13 = this.f19669e;
        if (OplusGLSurfaceView_13 == 0) {
            m20842b();
            canvas.rotate(-this.f19671g, this.f19678n ? getWidth() / 2 : getWidth() - this.f19676l, this.f19678n ? getHeight() / 2 : getHeight() - this.f19676l);
            Drawable drawable2 = this.f19666b;
            if (drawable2 != null) {
                if (this.f19679o) {
                    int width = (getWidth() - this.f19666b.getIntrinsicWidth()) / 2;
                    int height = (getHeight() - this.f19666b.getIntrinsicHeight()) / 2;
                    Drawable drawable3 = this.f19666b;
                    drawable3.setBounds(width, height, drawable3.getIntrinsicWidth() + width, this.f19666b.getIntrinsicWidth() + height);
                } else {
                    drawable2.setBounds(0, 0, getWidth(), getHeight());
                }
                this.f19666b.draw(canvas);
            }
            if (this.f19665a != null) {
                canvas.drawText(this.f19670f, getWidth() - (this.f19676l + (this.f19665a.measureText(this.f19670f) / 2.0f)), (getHeight() - this.f19676l) + ((Math.abs(this.f19665a.ascent()) - this.f19665a.descent()) / 2.0f), this.f19665a);
                return;
            }
            return;
        }
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2 && (drawable = this.f19668d) != null) {
                if (this.f19679o) {
                    int width2 = (getWidth() - this.f19666b.getIntrinsicWidth()) / 2;
                    int height2 = (getHeight() - this.f19666b.getIntrinsicHeight()) / 2;
                    Drawable drawable4 = this.f19668d;
                    drawable4.setBounds(width2, height2, drawable4.getIntrinsicWidth() + width2, this.f19668d.getIntrinsicWidth() + height2);
                } else {
                    drawable.setBounds(0, 0, getWidth(), getHeight());
                }
                this.f19668d.draw(canvas);
                return;
            }
            return;
        }
        m20842b();
        canvas.rotate(-this.f19671g, this.f19678n ? getWidth() / 2 : getWidth() - this.f19676l, this.f19678n ? getHeight() / 2 : getHeight() - this.f19676l);
        Drawable drawable5 = this.f19667c;
        if (drawable5 != null) {
            if (this.f19679o) {
                int width3 = (getWidth() - this.f19666b.getIntrinsicWidth()) / 2;
                int height3 = (getHeight() - this.f19666b.getIntrinsicHeight()) / 2;
                Drawable drawable6 = this.f19667c;
                drawable6.setBounds(width3, height3, drawable6.getIntrinsicWidth() + width3, this.f19667c.getIntrinsicWidth() + height3);
            } else {
                drawable5.setBounds(0, 0, getWidth(), getHeight());
            }
            this.f19667c.draw(canvas);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m20842b() {
        int OplusGLSurfaceView_13;
        if (this.f19671g != this.f19673i) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f19675k) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.f19674j);
                int i3 = this.f19672h;
                if (!this.f19677m) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 360) / 1000);
                if (i4 >= 0) {
                    OplusGLSurfaceView_13 = i4 % 360;
                } else {
                    OplusGLSurfaceView_13 = (i4 % 360) + 360;
                }
                this.f19671g = OplusGLSurfaceView_13;
                invalidate();
                return;
            }
            this.f19671g = this.f19673i;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20843a(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (this.f19669e == 2) {
            z = false;
        }
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % 360;
        } else {
            i2 = (OplusGLSurfaceView_13 % 360) + 360;
        }
        if (i2 == this.f19673i) {
            return;
        }
        this.f19673i = i2;
        if (z) {
            this.f19672h = this.f19671g;
            this.f19674j = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f19673i - this.f19671g;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f19677m = i3 >= 0;
            this.f19675k = this.f19674j + ((Math.abs(i3) * 1000) / 360);
            invalidate();
            return;
        }
        this.f19671g = this.f19673i;
    }
}
