package com.airbnb.lottie.p089e;

import com.airbnb.lottie.p089e.p090a.JsonReader;
import java.io.IOException;

/* compiled from: IntegerParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.o */
/* loaded from: classes.dex */
public class IntegerParser_2 implements ValueParser_2<Integer> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final IntegerParser_2 f5796a = new IntegerParser_2();

    private IntegerParser_2() {
    }

    @Override // com.airbnb.lottie.p089e.ValueParser_2
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public Integer mo5948b(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils_3.m5990b(abstractC1149c) * COUIBaseListPopupWindow_12));
    }
}
