package com.oplus.camera.p169t;

import android.content.Context;
import android.widget.TextView;

/* compiled from: StreetHelperTextView.java */
/* renamed from: com.oplus.camera.t.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class StreetHelperTextView extends TextView {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f16590a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f16591b;

    public StreetHelperTextView(Context context) {
        super(context);
        this.f16590a = 0;
        this.f16591b = false;
    }

    public void setVerticalDraw(boolean z) {
        this.f16591b = z;
    }
}
