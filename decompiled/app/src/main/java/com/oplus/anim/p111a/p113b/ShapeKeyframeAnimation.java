package com.oplus.anim.p111a.p113b;

import android.graphics.Path;
import com.oplus.anim.p115c.p117b.ShapeData;
import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p122g.Keyframe;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final ShapeData f10020c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Path f10021d;

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
        this.f10020c = new ShapeData();
        this.f10021d = new Path();
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public Path mo8844a(Keyframe<ShapeData> c2413c, float COUIBaseListPopupWindow_12) {
        this.f10020c.m9032a(c2413c.f10421a, c2413c.f10424d, COUIBaseListPopupWindow_12);
        MiscUtils.m9280a(this.f10020c, this.f10021d);
        return this.f10021d;
    }
}
