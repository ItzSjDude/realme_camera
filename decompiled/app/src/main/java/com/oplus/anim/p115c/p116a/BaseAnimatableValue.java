package com.oplus.anim.p115c.p116a;

import com.oplus.anim.p122g.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {

    /* renamed from: PlatformImplementations.kt_3 */
    final List<Keyframe<V>> f10117a;

    BaseAnimatableValue(V v) {
        this(Collections.singletonList(new Keyframe(v)));
    }

    BaseAnimatableValue(List<Keyframe<V>> list) {
        this.f10117a = list;
    }

    @Override // com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<Keyframe<V>> mo8959c() {
        return this.f10117a;
    }

    @Override // com.oplus.anim.p115c.p116a.AnimatableValue
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo8958b() {
        return this.f10117a.isEmpty() || (this.f10117a.size() == 1 && this.f10117a.get(0).m9330e());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f10117a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f10117a.toArray()));
        }
        return sb.toString();
    }
}
