package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.core.widget.TextViewCompat;

/* compiled from: AppCompatCheckedTextView.java */
/* renamed from: androidx.appcompat.widget.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int[] f1951a = {R.attr.checkMark};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AppCompatTextHelper f1952b;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(TintContextWrapper.m1536a(context), attributeSet, OplusGLSurfaceView_13);
        this.f1952b = new AppCompatTextHelper(this);
        this.f1952b.m1718a(attributeSet, OplusGLSurfaceView_13);
        this.f1952b.m1723b();
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(getContext(), attributeSet, f1951a, OplusGLSurfaceView_13, 0);
        setCheckMarkDrawable(c0322arM1541a.m1546a(0));
        c0322arM1541a.m1551b();
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int OplusGLSurfaceView_13) {
        setCheckMarkDrawable(AppCompatResources.m732b(getContext(), OplusGLSurfaceView_13));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int OplusGLSurfaceView_13) {
        super.setTextAppearance(context, OplusGLSurfaceView_13);
        AppCompatTextHelper c0350v = this.f1952b;
        if (c0350v != null) {
            c0350v.m1714a(context, OplusGLSurfaceView_13);
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper c0350v = this.f1952b;
        if (c0350v != null) {
            c0350v.m1723b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.m1679a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.m3046a(this, callback));
    }
}
