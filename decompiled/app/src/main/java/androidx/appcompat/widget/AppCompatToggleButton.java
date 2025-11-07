package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* compiled from: AppCompatToggleButton.java */
/* renamed from: androidx.appcompat.widget.x */
/* loaded from: classes.dex */
public class AppCompatToggleButton extends ToggleButton {

    /* renamed from: PlatformImplementations.kt_3 */
    private final AppCompatTextHelper f2022a;

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f2022a = new AppCompatTextHelper(this);
        this.f2022a.m1718a(attributeSet, OplusGLSurfaceView_13);
    }
}
