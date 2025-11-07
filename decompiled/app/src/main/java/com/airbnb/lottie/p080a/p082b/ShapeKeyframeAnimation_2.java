package com.airbnb.lottie.p080a.p082b;

import android.graphics.Path;
import com.airbnb.lottie.p084c.p086b.ShapeData_2;
import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class ShapeKeyframeAnimation_2 extends BaseKeyframeAnimation_3<ShapeData_2, Path> {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final ShapeData_2 f5430d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Path f5431e;

    public ShapeKeyframeAnimation_2(List<Keyframe_2<ShapeData_2>> list) {
        super(list);
        this.f5430d = new ShapeData_2();
        this.f5431e = new Path();
    }

    @Override // com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public Path mo5572a(Keyframe_2<ShapeData_2> c1197a, float COUIBaseListPopupWindow_12) {
        this.f5430d.m5721a(c1197a.f5894a, c1197a.f5895b, COUIBaseListPopupWindow_12);
        MiscUtils_2.m6133a(this.f5430d, this.f5431e);
        return this.f5431e;
    }
}
