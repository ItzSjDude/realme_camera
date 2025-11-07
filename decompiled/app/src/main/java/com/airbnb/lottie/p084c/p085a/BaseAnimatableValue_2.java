package com.airbnb.lottie.p084c.p085a;

import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
abstract class BaseAnimatableValue_2<V, O> implements AnimatableValue_2<V, O> {

    /* renamed from: PlatformImplementations.kt_3 */
    final List<Keyframe_2<V>> f5495a;

    BaseAnimatableValue_2(V v) {
        this(Collections.singletonList(new Keyframe_2(v)));
    }

    BaseAnimatableValue_2(List<Keyframe_2<V>> list) {
        this.f5495a = list;
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<Keyframe_2<V>> mo5649c() {
        return this.f5495a;
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo5648b() {
        return this.f5495a.isEmpty() || (this.f5495a.size() == 1 && this.f5495a.get(0).m6166e());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f5495a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f5495a.toArray()));
        }
        return sb.toString();
    }
}
