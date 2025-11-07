package com.oplus.camera.professional;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.oplus.camera.R;

/* compiled from: HSAutoImageView.java */
/* renamed from: com.oplus.camera.professional.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class HSAutoImageView extends ImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f15393a;

    public HSAutoImageView(Context context) {
        this(context, null);
    }

    public HSAutoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15393a = false;
        m15395a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15395a() {
        setImageResource(R.drawable.hs_autoview_auto);
        setContentDescription(getContext().getResources().getString(R.string.camera_description_professional_auto));
    }

    public void setAuto(boolean z) {
        if (this.f15393a == z) {
            return;
        }
        this.f15393a = z;
        setImageResource(z ? R.drawable.hs_autoview_auto : R.drawable.hs_autoview_normal);
        invalidate();
    }
}
