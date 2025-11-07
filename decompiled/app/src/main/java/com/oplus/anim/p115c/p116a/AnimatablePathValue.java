package com.oplus.anim.p115c.p116a;

import android.graphics.PointF;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.PathKeyframeAnimation;
import com.oplus.anim.p111a.p113b.PointKeyframeAnimation;
import com.oplus.anim.p121f.OplusLog;
import com.oplus.anim.p122g.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: AnimatablePathValue.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<Keyframe<PointF>> f10101a;

    public AnimatablePathValue() {
        this.f10101a = Collections.singletonList(new Keyframe(new PointF(0.0f, 0.0f)));
    }

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.f10101a = list;
    }

    @Override // com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<Keyframe<PointF>> mo8959c() {
        return this.f10101a;
    }

    @Override // com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo8958b() {
        return this.f10101a.size() == 1 && this.f10101a.get(0).m9330e();
    }

    @Override // com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation<PointF, PointF> mo8957a() {
        if (this.f10101a.get(0).m9330e()) {
            if (OplusLog.f10388d) {
                OplusLog.m9286b("AnimatablePathValue.create PointKeyframeAnimation, keyframes is :" + toString());
            }
            return new PointKeyframeAnimation(this.f10101a);
        }
        if (OplusLog.f10388d) {
            OplusLog.m9286b("AnimatablePathValue.create PathKeyframeAnimation, keyframes is :" + toString());
        }
        return new PathKeyframeAnimation(this.f10101a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f10101a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f10101a.toArray()));
        }
        return sb.toString();
    }
}
