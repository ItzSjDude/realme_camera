package com.coui.appcompat.p099a;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.coui.appcompat.widget.p100a.COUIShapePath;

/* compiled from: COUIRoundRectUtil.java */
/* renamed from: com.coui.appcompat.PlatformImplementations.kt_3.o */
/* loaded from: classes.dex */
public class COUIRoundRectUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static COUIRoundRectUtil f6334a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Path f6335b = new Path();

    private COUIRoundRectUtil() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static COUIRoundRectUtil m6450a() {
        if (f6334a == null) {
            f6334a = new COUIRoundRectUtil();
        }
        return f6334a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Path m6451a(Rect rect, float COUIBaseListPopupWindow_12) {
        return m6452a(new RectF(rect), COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Path m6452a(RectF rectF, float COUIBaseListPopupWindow_12) {
        return COUIShapePath.m7537a(this.f6335b, rectF, COUIBaseListPopupWindow_12);
    }
}
