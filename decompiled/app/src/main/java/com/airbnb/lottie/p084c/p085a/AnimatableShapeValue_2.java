package com.airbnb.lottie.p084c.p085a;

import android.graphics.Path;
import com.airbnb.lottie.p080a.p082b.BaseKeyframeAnimation_3;
import com.airbnb.lottie.p080a.p082b.ShapeKeyframeAnimation_2;
import com.airbnb.lottie.p084c.p086b.ShapeData_2;
import com.airbnb.lottie.p092g.Keyframe_2;
import java.util.List;

/* compiled from: AnimatableShapeValue.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class AnimatableShapeValue_2 extends BaseAnimatableValue_2<ShapeData_2, Path> {
    @Override // com.airbnb.lottie.p084c.p085a.BaseAnimatableValue_2, com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* bridge */ /* synthetic */ boolean mo5648b() {
        return super.mo5648b();
    }

    @Override // com.airbnb.lottie.p084c.p085a.BaseAnimatableValue_2, com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* bridge */ /* synthetic */ List mo5649c() {
        return super.mo5649c();
    }

    @Override // com.airbnb.lottie.p084c.p085a.BaseAnimatableValue_2
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public AnimatableShapeValue_2(List<Keyframe_2<ShapeData_2>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.p084c.p085a.AnimatableValue_2
    /* renamed from: PlatformImplementations.kt_3 */
    public BaseKeyframeAnimation_3<ShapeData_2, Path> mo5647a() {
        return new ShapeKeyframeAnimation_2(this.f5495a);
    }
}
