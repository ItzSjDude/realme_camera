package com.oplus.anim.a_renamed;

/* compiled from: LPaint.java */
/* loaded from: classes2.dex */
public class a_renamed extends android.graphics.Paint {
    @Override // android.graphics.Paint
    public void setTextLocales(android.os.LocaleList localeList) {
    }

    public a_renamed() {
    }

    public a_renamed(int i_renamed) {
        super(i_renamed);
    }

    public a_renamed(android.graphics.PorterDuff.Mode mode) {
        setXfermode(new android.graphics.PorterDuffXfermode(mode));
    }

    public a_renamed(int i_renamed, android.graphics.PorterDuff.Mode mode) {
        super(i_renamed);
        setXfermode(new android.graphics.PorterDuffXfermode(mode));
    }
}
