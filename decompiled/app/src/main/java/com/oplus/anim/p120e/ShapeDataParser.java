package com.oplus.anim.p120e;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.oplus.anim.p115c.CubicCurveData;
import com.oplus.anim.p115c.p117b.ShapeData;
import com.oplus.anim.p121f.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser.java */
/* renamed from: com.oplus.anim.COUIBaseListPopupWindow_8.ad */
/* loaded from: classes2.dex */
public class ShapeDataParser implements ValueParser<ShapeData> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final ShapeDataParser f10353a = new ShapeDataParser();

    private ShapeDataParser() {
    }

    @Override // com.oplus.anim.p120e.ValueParser
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public ShapeData mo9161b(JsonReader jsonReader, float COUIBaseListPopupWindow_12) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listM9208a = null;
        List<PointF> listM9208a2 = null;
        List<PointF> listM9208a3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            char c2 = 65535;
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 99) {
                if (iHashCode != 105) {
                    if (iHashCode != 111) {
                        if (iHashCode == 118 && strNextName.equals("v")) {
                            c2 = 1;
                        }
                    } else if (strNextName.equals("o")) {
                        c2 = 3;
                    }
                } else if (strNextName.equals("OplusGLSurfaceView_13")) {
                    c2 = 2;
                }
            } else if (strNextName.equals("IntrinsicsJvm.kt_3")) {
                c2 = 0;
            }
            if (c2 == 0) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if (c2 == 1) {
                listM9208a = JsonUtils.m9208a(jsonReader, COUIBaseListPopupWindow_12);
            } else if (c2 == 2) {
                listM9208a2 = JsonUtils.m9208a(jsonReader, COUIBaseListPopupWindow_12);
            } else if (c2 == 3) {
                listM9208a3 = JsonUtils.m9208a(jsonReader, COUIBaseListPopupWindow_12);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (listM9208a == null || listM9208a2 == null || listM9208a3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listM9208a.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.emptyList());
        }
        int size = listM9208a.size();
        PointF pointF = listM9208a.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            PointF pointF2 = listM9208a.get(OplusGLSurfaceView_13);
            int i2 = OplusGLSurfaceView_13 - 1;
            arrayList.add(new CubicCurveData(MiscUtils.m9279a(listM9208a.get(i2), listM9208a3.get(i2)), MiscUtils.m9279a(pointF2, listM9208a2.get(OplusGLSurfaceView_13)), pointF2));
        }
        if (zNextBoolean) {
            PointF pointF3 = listM9208a.get(0);
            int i3 = size - 1;
            arrayList.add(new CubicCurveData(MiscUtils.m9279a(listM9208a.get(i3), listM9208a3.get(i3)), MiscUtils.m9279a(pointF3, listM9208a2.get(0)), pointF3));
        }
        return new ShapeData(pointF, zNextBoolean, arrayList);
    }
}
