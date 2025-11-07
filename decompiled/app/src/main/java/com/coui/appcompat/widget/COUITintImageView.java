package com.coui.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.TintTypedArray;
import com.coui.appcompat.p099a.COUITintManager;

/* loaded from: classes.dex */
public class COUITintImageView extends AppCompatImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int[] f7868a = {R.attr.background, R.attr.src};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final COUITintManager f7869b;

    public COUITintImageView(Context context) {
        this(context, null);
    }

    public COUITintImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUITintImageView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(getContext(), attributeSet, f7868a, OplusGLSurfaceView_13, 0);
        if (c0322arM1541a.m1543a() > 0) {
            if (c0322arM1541a.m1561g(0)) {
                setBackgroundDrawable(c0322arM1541a.m1546a(0));
            }
            if (c0322arM1541a.m1561g(1)) {
                setImageDrawable(c0322arM1541a.m1546a(1));
            }
        }
        c0322arM1541a.m1551b();
        this.f7869b = COUITintManager.m6488a(context);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int OplusGLSurfaceView_13) {
        setImageDrawable(this.f7869b.m6491a(OplusGLSurfaceView_13));
    }
}
