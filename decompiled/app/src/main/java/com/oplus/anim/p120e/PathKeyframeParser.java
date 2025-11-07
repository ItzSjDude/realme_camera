package com.oplus.anim.p120e;

import android.util.JsonReader;
import android.util.JsonToken;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p111a.p113b.PathKeyframe;
import com.oplus.anim.p121f.Utils_2;
import java.io.IOException;

/* compiled from: PathKeyframeParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.w */
/* loaded from: classes2.dex */
class PathKeyframeParser {
    /* renamed from: PlatformImplementations.kt_3 */
    static PathKeyframe m9226a(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        return new PathKeyframe(c2272a, KeyframeParser.m9216a(jsonReader, c2272a, Utils_2.m9288a(), PathParser_4.f10362a, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
