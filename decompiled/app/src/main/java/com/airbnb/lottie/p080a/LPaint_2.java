package com.airbnb.lottie.p080a;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;

/* compiled from: LPaint.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class LPaint_2 extends Paint {
    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public LPaint_2() {
    }

    public LPaint_2(int OplusGLSurfaceView_13) {
        super(OplusGLSurfaceView_13);
    }

    public LPaint_2(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public LPaint_2(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
        super(OplusGLSurfaceView_13);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
