package com.airbnb.lottie.p080a.p082b;

import android.graphics.Path;
import com.airbnb.lottie.p084c.p086b.Mask_3;
import com.airbnb.lottie.p084c.p086b.ShapeData_2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class MaskKeyframeAnimation_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<BaseKeyframeAnimation_3<ShapeData_2, Path>> f5419a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final List<BaseKeyframeAnimation_3<Integer, Integer>> f5420b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final List<Mask_3> f5421c;

    public MaskKeyframeAnimation_2(List<Mask_3> list) {
        this.f5421c = list;
        this.f5419a = new ArrayList(list.size());
        this.f5420b = new ArrayList(list.size());
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            this.f5419a.add(list.get(OplusGLSurfaceView_13).m5693b().mo5647a());
            this.f5420b.add(list.get(OplusGLSurfaceView_13).m5694c().mo5647a());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<Mask_3> m5602a() {
        return this.f5421c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<BaseKeyframeAnimation_3<ShapeData_2, Path>> m5603b() {
        return this.f5419a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<BaseKeyframeAnimation_3<Integer, Integer>> m5604c() {
        return this.f5420b;
    }
}
