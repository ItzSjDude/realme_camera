package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p036h.ViewCompat;
import java.lang.reflect.InvocationTargetException;

/* compiled from: AppCompatSeekBarHelper.java */
/* renamed from: androidx.appcompat.widget.t */
/* loaded from: classes.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private final SeekBar f1982a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Drawable f1983b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ColorStateList f1984c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PorterDuff.Mode f1985d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f1986e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f1987f;

    AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.f1984c = null;
        this.f1985d = null;
        this.f1986e = false;
        this.f1987f = false;
        this.f1982a = seekBar;
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    /* renamed from: PlatformImplementations.kt_3 */
    void mo1696a(AttributeSet attributeSet, int OplusGLSurfaceView_13) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.mo1696a(attributeSet, OplusGLSurfaceView_13);
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(this.f1982a.getContext(), attributeSet, R.styleable.AppCompatSeekBar, OplusGLSurfaceView_13, 0);
        Drawable drawableM1550b = c0322arM1541a.m1550b(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableM1550b != null) {
            this.f1982a.setThumb(drawableM1550b);
        }
        m1699a(c0322arM1541a.m1546a(R.styleable.AppCompatSeekBar_tickMark));
        if (c0322arM1541a.m1561g(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1985d = DrawableUtils.m1394a(c0322arM1541a.m1544a(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f1985d);
            this.f1987f = true;
        }
        if (c0322arM1541a.m1561g(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f1984c = c0322arM1541a.m1557e(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f1986e = true;
        }
        c0322arM1541a.m1551b();
        m1697d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1699a(Drawable drawable) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Drawable drawable2 = this.f1983b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1983b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1982a);
            DrawableCompat.m2576b(drawable, ViewCompat.m2885g(this.f1982a));
            if (drawable.isStateful()) {
                drawable.setState(this.f1982a.getDrawableState());
            }
            m1697d();
        }
        this.f1982a.invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m1697d() {
        if (this.f1983b != null) {
            if (this.f1986e || this.f1987f) {
                this.f1983b = DrawableCompat.m2581g(this.f1983b.mutate());
                if (this.f1986e) {
                    DrawableCompat.m2570a(this.f1983b, this.f1984c);
                }
                if (this.f1987f) {
                    DrawableCompat.m2573a(this.f1983b, this.f1985d);
                }
                if (this.f1983b.isStateful()) {
                    this.f1983b.setState(this.f1982a.getDrawableState());
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m1700b() {
        Drawable drawable = this.f1983b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m1701c() {
        Drawable drawable = this.f1983b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1982a.getDrawableState())) {
            this.f1982a.invalidateDrawable(drawable);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1698a(Canvas canvas) {
        if (this.f1983b != null) {
            int max = this.f1982a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1983b.getIntrinsicWidth();
                int intrinsicHeight = this.f1983b.getIntrinsicHeight();
                int OplusGLSurfaceView_13 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1983b.setBounds(-OplusGLSurfaceView_13, -i2, OplusGLSurfaceView_13, i2);
                float width = ((this.f1982a.getWidth() - this.f1982a.getPaddingLeft()) - this.f1982a.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f1982a.getPaddingLeft(), this.f1982a.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f1983b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
