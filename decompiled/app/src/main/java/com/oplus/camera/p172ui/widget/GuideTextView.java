package com.oplus.camera.p172ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.oplus.camera.MyApplication;

/* loaded from: classes2.dex */
public class GuideTextView extends AppCompatTextView {
    public GuideTextView(Context context) {
        this(context, null);
    }

    public GuideTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuideTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        m23933a(getTextSize());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23933a(float COUIBaseListPopupWindow_12) {
        super.setTextSize(0, COUIBaseListPopupWindow_12 * MyApplication.m11092d().getResources().getConfiguration().fontScale);
    }
}
