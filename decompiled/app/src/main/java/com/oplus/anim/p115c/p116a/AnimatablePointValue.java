package com.oplus.anim.p115c.p116a;

import android.graphics.PointF;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.PointKeyframeAnimation;
import com.oplus.anim.p121f.OplusLog;
import com.oplus.anim.p122g.Keyframe;
import java.util.List;

/* compiled from: AnimatablePointValue.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
    @Override // com.oplus.anim.p115c.p116a.BaseAnimatableValue, com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* bridge */ /* synthetic */ boolean mo8958b() {
        return super.mo8958b();
    }

    @Override // com.oplus.anim.p115c.p116a.BaseAnimatableValue, com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* bridge */ /* synthetic */ List mo8959c() {
        return super.mo8959c();
    }

    @Override // com.oplus.anim.p115c.p116a.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatablePointValue(List<Keyframe<PointF>> list) {
        super((List) list);
    }

    @Override // com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation<PointF, PointF> mo8957a() {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("AnimatablePointValue create PointKeyframeAnimation, keyframes is :" + toString());
        }
        return new PointKeyframeAnimation(this.f10117a);
    }
}
