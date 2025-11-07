package com.airbnb.lottie.p089e;

import android.graphics.PointF;
import com.airbnb.lottie.p084c.CubicCurveData_2;
import com.airbnb.lottie.p084c.p086b.ShapeData_2;
import com.airbnb.lottie.p089e.p090a.JsonReader;
import com.airbnb.lottie.p091f.MiscUtils_2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_8.ad */
/* loaded from: classes.dex */
public class ShapeDataParser_2 implements ValueParser_2<ShapeData_2> {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final ShapeDataParser_2 f5769a = new ShapeDataParser_2();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final JsonReader.PlatformImplementations.kt_3 f5770b = JsonReader.PlatformImplementations.kt_3.m5929a("IntrinsicsJvm.kt_3", "v", "OplusGLSurfaceView_13", "o");

    private ShapeDataParser_2() {
    }

    @Override // com.airbnb.lottie.p089e.ValueParser_2
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public ShapeData_2 mo5948b(JsonReader abstractC1149c, float COUIBaseListPopupWindow_12) throws IOException {
        if (abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.BEGIN_ARRAY) {
            abstractC1149c.mo5914a();
        }
        abstractC1149c.mo5917c();
        List<PointF> listM5989a = null;
        List<PointF> listM5989a2 = null;
        List<PointF> listM5989a3 = null;
        boolean zMo5924j = false;
        while (abstractC1149c.mo5919e()) {
            int iMo5912a = abstractC1149c.mo5912a(f5770b);
            if (iMo5912a == 0) {
                zMo5924j = abstractC1149c.mo5924j();
            } else if (iMo5912a == 1) {
                listM5989a = JsonUtils_3.m5989a(abstractC1149c, COUIBaseListPopupWindow_12);
            } else if (iMo5912a == 2) {
                listM5989a2 = JsonUtils_3.m5989a(abstractC1149c, COUIBaseListPopupWindow_12);
            } else if (iMo5912a == 3) {
                listM5989a3 = JsonUtils_3.m5989a(abstractC1149c, COUIBaseListPopupWindow_12);
            } else {
                abstractC1149c.mo5922h();
                abstractC1149c.mo5927m();
            }
        }
        abstractC1149c.mo5918d();
        if (abstractC1149c.mo5920f() == JsonReader.IntrinsicsJvm.kt_4.END_ARRAY) {
            abstractC1149c.mo5916b();
        }
        if (listM5989a == null || listM5989a2 == null || listM5989a3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listM5989a.isEmpty()) {
            return new ShapeData_2(new PointF(), false, Collections.emptyList());
        }
        int size = listM5989a.size();
        PointF pointF = listM5989a.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            PointF pointF2 = listM5989a.get(OplusGLSurfaceView_13);
            int i2 = OplusGLSurfaceView_13 - 1;
            arrayList.add(new CubicCurveData_2(MiscUtils_2.m6132a(listM5989a.get(i2), listM5989a3.get(i2)), MiscUtils_2.m6132a(pointF2, listM5989a2.get(OplusGLSurfaceView_13)), pointF2));
        }
        if (zMo5924j) {
            PointF pointF3 = listM5989a.get(0);
            int i3 = size - 1;
            arrayList.add(new CubicCurveData_2(MiscUtils_2.m6132a(listM5989a.get(i3), listM5989a3.get(i3)), MiscUtils_2.m6132a(pointF3, listM5989a2.get(0)), pointF3));
        }
        return new ShapeData_2(pointF, zMo5924j, arrayList);
    }
}
