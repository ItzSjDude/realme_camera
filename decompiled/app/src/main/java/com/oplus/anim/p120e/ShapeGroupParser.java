package com.oplus.anim.p120e;

import android.util.JsonReader;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p115c.p117b.ShapeGroup;
import com.oplus.anim.p115c.p117b.ContentModel;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ShapeGroupParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.af */
/* loaded from: classes2.dex */
class ShapeGroupParser {
    /* renamed from: PlatformImplementations.kt_3 */
    static ShapeGroup m9164a(JsonReader jsonReader, EffectiveAnimationComposition c2272a) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 3324) {
                if (iHashCode != 3371) {
                    if (iHashCode == 3519 && strNextName.equals("nm")) {
                        c2 = 0;
                    }
                } else if (strNextName.equals("it")) {
                    c2 = 2;
                }
            } else if (strNextName.equals("hd")) {
                c2 = 1;
            }
            if (c2 == 0) {
                strNextString = jsonReader.nextString();
            } else if (c2 == 1) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c2 == 2) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    ContentModel interfaceC2330bM9190a = ContentModelParser.m9190a(jsonReader, c2272a);
                    if (interfaceC2330bM9190a != null) {
                        arrayList.add(interfaceC2330bM9190a);
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return new ShapeGroup(strNextString, arrayList, zNextBoolean);
    }
}
