package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;

/* compiled from: AppCompatCompoundButtonHelper.java */
/* renamed from: androidx.appcompat.widget.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
class AppCompatCompoundButtonHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private final CompoundButton f1953a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ColorStateList f1954b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PorterDuff.Mode f1955c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f1956d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f1957e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f1958f;

    AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.f1953a = compoundButton;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1659a(AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        boolean z;
        int resourceId;
        int resourceId2;
        TypedArray typedArrayObtainStyledAttributes = this.f1953a.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, OplusGLSurfaceView_13, 0);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonCompat) || (resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CompoundButton_buttonCompat, 0)) == 0) {
                z = false;
            } else {
                try {
                    this.f1953a.setButtonDrawable(AppCompatResources.m732b(this.f1953a.getContext(), resourceId2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (!z && typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.f1953a.setButtonDrawable(AppCompatResources.m732b(this.f1953a.getContext(), resourceId));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.m3031a(this.f1953a, typedArrayObtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.m3032a(this.f1953a, DrawableUtils.m1394a(typedArrayObtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1657a(ColorStateList colorStateList) {
        this.f1954b = colorStateList;
        this.f1956d = true;
        m1662d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    ColorStateList m1656a() {
        return this.f1954b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1658a(PorterDuff.Mode mode) {
        this.f1955c = mode;
        this.f1957e = true;
        m1662d();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    PorterDuff.Mode m1660b() {
        return this.f1955c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m1661c() {
        if (this.f1958f) {
            this.f1958f = false;
        } else {
            this.f1958f = true;
            m1662d();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m1662d() {
        Drawable drawableM3033b = CompoundButtonCompat.m3033b(this.f1953a);
        if (drawableM3033b != null) {
            if (this.f1956d || this.f1957e) {
                Drawable drawableMutate = DrawableCompat.m2581g(drawableM3033b).mutate();
                if (this.f1956d) {
                    DrawableCompat.m2570a(drawableMutate, this.f1954b);
                }
                if (this.f1957e) {
                    DrawableCompat.m2573a(drawableMutate, this.f1955c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f1953a.getDrawableState());
                }
                this.f1953a.setButtonDrawable(drawableMutate);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m1655a(int OplusGLSurfaceView_13) {
        Drawable drawableM3033b;
        return (Build.VERSION.SDK_INT >= 17 || (drawableM3033b = CompoundButtonCompat.m3033b(this.f1953a)) == null) ? OplusGLSurfaceView_13 : OplusGLSurfaceView_13 + drawableM3033b.getIntrinsicWidth();
    }
}
