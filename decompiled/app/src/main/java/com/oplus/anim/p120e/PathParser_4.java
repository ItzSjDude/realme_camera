package com.oplus.anim.p120e;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* compiled from: PathParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.x */
/* loaded from: classes2.dex */
public class PathParser_4 implements ValueParser<PointF> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final PathParser_4 f10362a = new PathParser_4();

    private PathParser_4() {
    }

    @Override // com.oplus.anim.p120e.ValueParser
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PointF mo9161b(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        return JsonUtils.m9210b(jsonReader, COUIBaseListPopupWindow_12);
    }
}
