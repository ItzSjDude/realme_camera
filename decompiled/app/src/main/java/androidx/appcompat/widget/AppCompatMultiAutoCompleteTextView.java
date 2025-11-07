package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.core.p036h.TintableBackgroundView;

/* compiled from: AppCompatMultiAutoCompleteTextView.java */
/* renamed from: androidx.appcompat.widget.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int[] f1972a = {R.attr.popupBackground};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AppCompatBackgroundHelper f1973b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final AppCompatTextHelper f1974c;

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(TintContextWrapper.m1536a(context), attributeSet, OplusGLSurfaceView_13);
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(getContext(), attributeSet, f1972a, OplusGLSurfaceView_13, 0);
        if (c0322arM1541a.m1561g(0)) {
            setDropDownBackgroundDrawable(c0322arM1541a.m1546a(0));
        }
        c0322arM1541a.m1551b();
        this.f1973b = new AppCompatBackgroundHelper(this);
        this.f1973b.m1651a(attributeSet, OplusGLSurfaceView_13);
        this.f1974c = new AppCompatTextHelper(this);
        this.f1974c.m1718a(attributeSet, OplusGLSurfaceView_13);
        this.f1974c.m1723b();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int OplusGLSurfaceView_13) {
        setDropDownBackgroundDrawable(AppCompatResources.m732b(getContext(), OplusGLSurfaceView_13));
    }

    @Override // android.view.View
    public void setBackgroundResource(int OplusGLSurfaceView_13) {
        super.setBackgroundResource(OplusGLSurfaceView_13);
        AppCompatBackgroundHelper c0333e = this.f1973b;
        if (c0333e != null) {
            c0333e.m1647a(OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper c0333e = this.f1973b;
        if (c0333e != null) {
            c0333e.m1650a(drawable);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper c0333e = this.f1973b;
        if (c0333e != null) {
            c0333e.m1648a(colorStateList);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper c0333e = this.f1973b;
        if (c0333e != null) {
            return c0333e.m1646a();
        }
        return null;
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper c0333e = this.f1973b;
        if (c0333e != null) {
            c0333e.m1649a(mode);
        }
    }

    @Override // androidx.core.p036h.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper c0333e = this.f1973b;
        if (c0333e != null) {
            return c0333e.m1652b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper c0333e = this.f1973b;
        if (c0333e != null) {
            c0333e.m1654c();
        }
        AppCompatTextHelper c0350v = this.f1974c;
        if (c0350v != null) {
            c0350v.m1723b();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int OplusGLSurfaceView_13) {
        super.setTextAppearance(context, OplusGLSurfaceView_13);
        AppCompatTextHelper c0350v = this.f1974c;
        if (c0350v != null) {
            c0350v.m1714a(context, OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.m1679a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
