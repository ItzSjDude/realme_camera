package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R;
import androidx.core.p036h.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.InterfaceC0522b;

/* compiled from: AppCompatButton.java */
/* renamed from: androidx.appcompat.widget.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class AppCompatButton extends Button implements TintableBackgroundView, InterfaceC0522b {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(TintContextWrapper.m1536a(context), attributeSet, OplusGLSurfaceView_13);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper.m1651a(attributeSet, OplusGLSurfaceView_13);
        this.mTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper.m1718a(attributeSet, OplusGLSurfaceView_13);
        this.mTextHelper.m1723b();
    }

    @Override // android.view.View
    public void setBackgroundResource(int OplusGLSurfaceView_13) {
        super.setBackgroundResource(OplusGLSurfaceView_13);
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1647a(OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1650a(drawable);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1648a(colorStateList);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            return c0333e.m1646a();
        }
        return null;
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1649a(mode);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            return c0333e.m1652b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1654c();
        }
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1723b();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int OplusGLSurfaceView_13) {
        super.setTextAppearance(context, OplusGLSurfaceView_13);
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1714a(context, OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1721a(z, OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        if (f3166d) {
            super.setTextSize(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
            return;
        }
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1712a(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int OplusGLSurfaceView_13, int i2, int i3) {
        super.onTextChanged(charSequence, OplusGLSurfaceView_13, i2, i3);
        if (this.mTextHelper == null || f3166d || !this.mTextHelper.m1725d()) {
            return;
        }
        this.mTextHelper.m1724c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int OplusGLSurfaceView_13) {
        if (f3166d) {
            super.setAutoSizeTextTypeWithDefaults(OplusGLSurfaceView_13);
            return;
        }
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1711a(OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int OplusGLSurfaceView_13, int i2, int i3, int i4) throws IllegalArgumentException {
        if (f3166d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(OplusGLSurfaceView_13, i2, i3, i4);
            return;
        }
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1713a(OplusGLSurfaceView_13, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int OplusGLSurfaceView_13) throws IllegalArgumentException {
        if (f3166d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, OplusGLSurfaceView_13);
            return;
        }
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1722a(iArr, OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (f3166d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            return c0350v.m1726e();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (f3166d) {
            return super.getAutoSizeStepGranularity();
        }
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            return c0350v.m1727f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (f3166d) {
            return super.getAutoSizeMinTextSize();
        }
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            return c0350v.m1728g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (f3166d) {
            return super.getAutoSizeMaxTextSize();
        }
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            return c0350v.m1729h();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (f3166d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            return c0350v.m1730i();
        }
        return new int[0];
    }

    public void setSupportAllCaps(boolean z) {
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1720a(z);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.m3046a(this, callback));
    }
}
