package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.p034f.PrecomputedTextCompat;
import androidx.core.p036h.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.InterfaceC0522b;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView, InterfaceC0522b, TintableCompoundDrawablesView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(TintContextWrapper.m1536a(context), attributeSet, OplusGLSurfaceView_13);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper.m1651a(attributeSet, OplusGLSurfaceView_13);
        this.mTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper.m1718a(attributeSet, OplusGLSurfaceView_13);
        this.mTextHelper.m1723b();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int OplusGLSurfaceView_13) {
        super.setTextAppearance(context, OplusGLSurfaceView_13);
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1714a(context, OplusGLSurfaceView_13);
        }
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

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.m1679a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(OplusGLSurfaceView_13);
        } else {
            TextViewCompat.m3054b(this, OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(OplusGLSurfaceView_13);
        } else {
            TextViewCompat.m3057c(this, OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.m3056c(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.m3058d(this);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int OplusGLSurfaceView_13) {
        TextViewCompat.m3059d(this, OplusGLSurfaceView_13);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.m3046a(this, callback));
    }

    public PrecomputedTextCompat.PlatformImplementations.kt_3 getTextMetricsParamsCompat() {
        return TextViewCompat.m3060e(this);
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat.PlatformImplementations.kt_3 aVar) {
        TextViewCompat.m3052a(this, aVar);
    }

    public void setPrecomputedText(PrecomputedTextCompat c0450c) {
        TextViewCompat.m3053a(this, c0450c);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                TextViewCompat.m3053a(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        AppCompatTextClassifierHelper c0349u;
        if (Build.VERSION.SDK_INT >= 28 || (c0349u = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c0349u.m1703a(textClassifier);
        }
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        AppCompatTextClassifierHelper c0349u;
        if (Build.VERSION.SDK_INT >= 28 || (c0349u = this.mTextClassifierHelper) == null) {
            return super.getTextClassifier();
        }
        return c0349u.m1702a();
    }

    public void setTextFuture(Future<PrecomputedTextCompat> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1710a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1710a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1710a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(OplusGLSurfaceView_13 != 0 ? AppCompatResources.m732b(context, OplusGLSurfaceView_13) : null, i2 != 0 ? AppCompatResources.m732b(context, i2) : null, i3 != 0 ? AppCompatResources.m732b(context, i3) : null, i4 != 0 ? AppCompatResources.m732b(context, i4) : null);
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1710a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1710a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(OplusGLSurfaceView_13 != 0 ? AppCompatResources.m732b(context, OplusGLSurfaceView_13) : null, i2 != 0 ? AppCompatResources.m732b(context, i2) : null, i3 != 0 ? AppCompatResources.m732b(context, i3) : null, i4 != 0 ? AppCompatResources.m732b(context, i4) : null);
        AppCompatTextHelper c0350v = this.mTextHelper;
        if (c0350v != null) {
            c0350v.m1710a();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.m1731j();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.m1715a(colorStateList);
        this.mTextHelper.m1723b();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.m1732k();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.m1716a(mode);
        this.mTextHelper.m1723b();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int OplusGLSurfaceView_13) {
        Typeface typefaceM2608a = (typeface == null || OplusGLSurfaceView_13 <= 0) ? null : TypefaceCompat.m2608a(getContext(), typeface, OplusGLSurfaceView_13);
        if (typefaceM2608a != null) {
            typeface = typefaceM2608a;
        }
        super.setTypeface(typeface, OplusGLSurfaceView_13);
    }
}
