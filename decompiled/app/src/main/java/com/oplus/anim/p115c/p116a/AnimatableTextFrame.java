package com.oplus.anim.p115c.p116a;

import com.oplus.anim.p111a.p113b.TextKeyframeAnimation;
import com.oplus.anim.p115c.DocumentData;
import com.oplus.anim.p121f.OplusLog;
import com.oplus.anim.p122g.Keyframe;
import java.util.List;

/* compiled from: AnimatableTextFrame.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class AnimatableTextFrame extends BaseAnimatableValue<DocumentData, DocumentData> {
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

    public AnimatableTextFrame(List<Keyframe<DocumentData>> list) {
        super((List) list);
    }

    @Override // com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: IntrinsicsJvm.kt_5, reason: merged with bridge method [inline-methods] */
    public TextKeyframeAnimation mo8957a() {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("AnimatableTextFrame create TextKeyframeAnimation, keyframes is :" + toString());
        }
        return new TextKeyframeAnimation(this.f10117a);
    }
}
