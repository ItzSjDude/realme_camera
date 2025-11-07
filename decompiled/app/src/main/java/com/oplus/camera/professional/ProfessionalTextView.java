package com.oplus.camera.professional;

import android.content.Context;
import android.widget.TextView;

/* compiled from: ProfessionalTextView.java */
/* renamed from: com.oplus.camera.professional.w */
/* loaded from: classes2.dex */
public class ProfessionalTextView extends TextView {

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f15810a = 3;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f15811b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f15812c;

    public ProfessionalTextView(Context context) {
        super(context);
        this.f15811b = 0;
        this.f15812c = false;
    }

    public void setVerticalDraw(boolean z) {
        this.f15812c = z;
    }
}
