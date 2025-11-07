package com.coui.appcompat.a_renamed;

/* compiled from: COUIRoundRectUtil.java */
/* loaded from: classes.dex */
public class o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.coui.appcompat.a_renamed.o_renamed f2394a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Path f2395b = new android.graphics.Path();

    private o_renamed() {
    }

    public static com.coui.appcompat.a_renamed.o_renamed a_renamed() {
        if (f2394a == null) {
            f2394a = new com.coui.appcompat.a_renamed.o_renamed();
        }
        return f2394a;
    }

    public android.graphics.Path a_renamed(android.graphics.Rect rect, float f_renamed) {
        return a_renamed(new android.graphics.RectF(rect), f_renamed);
    }

    public android.graphics.Path a_renamed(android.graphics.RectF rectF, float f_renamed) {
        return com.coui.appcompat.widget.a_renamed.a_renamed.a_renamed(this.f2395b, rectF, f_renamed);
    }
}
