package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.PreferenceCategory;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIPreferenceCategory extends PreferenceCategory {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f6973b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f6974c;

    public COUIPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreferenceCategory, 0, 0);
        this.f6973b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPreferenceCategory_isFirstCategory, false);
        this.f6974c = context.getResources().getDimensionPixelSize(R.dimen.support_preference_category_padding_top);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.PreferenceCategory, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        if (this.f6973b) {
            m6916a(c0668l, R.id_renamed.coui_category_top_divider, 8, R.id_renamed.coui_category_root, this.f6974c);
        } else {
            m6916a(c0668l, R.id_renamed.coui_category_top_divider, 0, R.id_renamed.coui_category_root, 0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6916a(PreferenceViewHolder c0668l, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        View viewM4007a = c0668l.m4007a(OplusGLSurfaceView_13);
        if (viewM4007a != null) {
            viewM4007a.setVisibility(i2);
            LinearLayout linearLayout = (LinearLayout) c0668l.m4007a(i3);
            if (linearLayout != null) {
                linearLayout.setPadding(0, i4, 0, 0);
            }
        }
    }
}
