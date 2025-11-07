package com.oplus.anim.p111a;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;

/* compiled from: LPaint.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class LPaint extends Paint {
    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public LPaint() {
    }

    public LPaint(int OplusGLSurfaceView_13) {
        super(OplusGLSurfaceView_13);
    }

    public LPaint(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public LPaint(int OplusGLSurfaceView_13, PorterDuff.Mode mode) {
        super(OplusGLSurfaceView_13);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
