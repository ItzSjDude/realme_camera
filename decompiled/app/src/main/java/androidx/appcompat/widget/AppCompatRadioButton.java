package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.core.p036h.TintableBackgroundView;
import androidx.core.widget.TintableCompoundButton;

/* compiled from: AppCompatRadioButton.java */
/* renamed from: androidx.appcompat.widget.q */
/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton implements TintableBackgroundView, TintableCompoundButton {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatCompoundButtonHelper mCompoundButtonHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(TintContextWrapper.m1536a(context), attributeSet, OplusGLSurfaceView_13);
        this.mCompoundButtonHelper = new AppCompatCompoundButtonHelper(this);
        this.mCompoundButtonHelper.m1659a(attributeSet, OplusGLSurfaceView_13);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper.m1651a(attributeSet, OplusGLSurfaceView_13);
        this.mTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper.m1718a(attributeSet, OplusGLSurfaceView_13);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        AppCompatCompoundButtonHelper c0336h = this.mCompoundButtonHelper;
        if (c0336h != null) {
            c0336h.m1661c();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int OplusGLSurfaceView_13) {
        setButtonDrawable(AppCompatResources.m732b(getContext(), OplusGLSurfaceView_13));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        AppCompatCompoundButtonHelper c0336h = this.mCompoundButtonHelper;
        return c0336h != null ? c0336h.m1655a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // androidx.core.widget.TintableCompoundButton
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        AppCompatCompoundButtonHelper c0336h = this.mCompoundButtonHelper;
        if (c0336h != null) {
            c0336h.m1657a(colorStateList);
        }
    }

    @Override // androidx.core.widget.TintableCompoundButton
    public ColorStateList getSupportButtonTintList() {
        AppCompatCompoundButtonHelper c0336h = this.mCompoundButtonHelper;
        if (c0336h != null) {
            return c0336h.m1656a();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCompoundButton
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        AppCompatCompoundButtonHelper c0336h = this.mCompoundButtonHelper;
        if (c0336h != null) {
            c0336h.m1658a(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        AppCompatCompoundButtonHelper c0336h = this.mCompoundButtonHelper;
        if (c0336h != null) {
            return c0336h.m1660b();
        }
        return null;
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

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1650a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int OplusGLSurfaceView_13) {
        super.setBackgroundResource(OplusGLSurfaceView_13);
        AppCompatBackgroundHelper c0333e = this.mBackgroundTintHelper;
        if (c0333e != null) {
            c0333e.m1647a(OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
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
}
