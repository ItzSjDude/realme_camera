package com.airbnb.lottie.p080a.p082b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.p091f.Utils_4;
import com.airbnb.lottie.p092g.Keyframe_2;

/* compiled from: PathKeyframe.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class PathKeyframe_2 extends Keyframe_2<PointF> {

    /* renamed from: OplusGLSurfaceView_15 */
    private Path f5422j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final Keyframe_2<PointF> f5423k;

    public PathKeyframe_2(LottieComposition c1136d, Keyframe_2<PointF> c1197a) {
        super(c1136d, c1197a.f5894a, c1197a.f5895b, c1197a.f5896c, c1197a.f5897d, c1197a.f5898e, c1197a.f5899f, c1197a.f5900g);
        this.f5423k = c1197a;
        m5605a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m5605a() {
        boolean z = (this.f5895b == 0 || this.f5894a == 0 || !((PointF) this.f5894a).equals(((PointF) this.f5895b).x, ((PointF) this.f5895b).y)) ? false : true;
        if (this.f5894a == 0 || this.f5895b == 0 || z) {
            return;
        }
        this.f5422j = Utils_4.m6144a((PointF) this.f5894a, (PointF) this.f5895b, this.f5423k.f5901h, this.f5423k.f5902i);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    Path m5606b() {
        return this.f5422j;
    }
}
