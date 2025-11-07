package com.oplus.anim.p120e;

import android.util.JsonReader;
import java.io.IOException;

/* compiled from: IntegerParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.p */
/* loaded from: classes2.dex */
public class IntegerParser implements ValueParser<Integer> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final IntegerParser f10358a = new IntegerParser();

    private IntegerParser() {
    }

    @Override // com.oplus.anim.p120e.ValueParser
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public Integer mo9161b(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils.m9209b(jsonReader) * COUIBaseListPopupWindow_12));
    }
}
