package com.oplus.anim.p115c.p116a;

import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.ScaleKeyframeAnimation;
import com.oplus.anim.p121f.OplusLog;
import com.oplus.anim.p122g.Keyframe;
import com.oplus.anim.p122g.ScaleXY;
import java.util.List;

/* compiled from: AnimatableScaleValue.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class AnimatableScaleValue extends BaseAnimatableValue<ScaleXY, ScaleXY> {
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

    AnimatableScaleValue() {
        this(new ScaleXY(1.0f, 1.0f));
    }

    public AnimatableScaleValue(ScaleXY c2414d) {
        super(c2414d);
    }

    public AnimatableScaleValue(List<Keyframe<ScaleXY>> list) {
        super((List) list);
    }

    @Override // com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation<ScaleXY, ScaleXY> mo8957a() {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("AnimatableScaleValue create ScaleKeyframeAnimation, keyframes is :" + toString());
        }
        return new ScaleKeyframeAnimation(this.f10117a);
    }
}
