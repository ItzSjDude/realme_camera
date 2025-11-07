package com.oplus.anim.p111a.p113b;

import android.graphics.Path;
import android.graphics.PointF;
import com.oplus.anim.EffectiveAnimationComposition;
import com.oplus.anim.p121f.Utils_2;
import com.oplus.anim.p122g.Keyframe;

/* compiled from: PathKeyframe.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class PathKeyframe extends Keyframe<PointF> {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Keyframe<PointF> f10012h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Path f10013i;

    public PathKeyframe(EffectiveAnimationComposition c2272a, Keyframe<PointF> c2413c) {
        super(c2272a, c2413c.f10421a, c2413c.f10424d, c2413c.f10422b, c2413c.f10423c, c2413c.f10425e);
        this.f10012h = c2413c;
        m8869a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m8869a() {
        boolean z = (this.f10424d == 0 || this.f10421a == 0 || !((PointF) this.f10421a).equals(((PointF) this.f10424d).x, ((PointF) this.f10424d).y)) ? false : true;
        if (this.f10424d == 0 || this.f10421a == 0 || z) {
            return;
        }
        this.f10013i = Utils_2.m9291a((PointF) this.f10421a, (PointF) this.f10424d, this.f10012h.f10426f, this.f10012h.f10427g);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    Path m8870b() {
        return this.f10013i;
    }
}
