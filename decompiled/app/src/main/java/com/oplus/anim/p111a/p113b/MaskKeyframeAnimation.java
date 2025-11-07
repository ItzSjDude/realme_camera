package com.oplus.anim.p111a.p113b;

import android.graphics.Path;
import com.oplus.anim.p115c.p117b.Mask;
import com.oplus.anim.p115c.p117b.ShapeData;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class MaskKeyframeAnimation {

    /* renamed from: PlatformImplementations.kt_3 */
    private final List<BaseKeyframeAnimation<ShapeData, Path>> f10009a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final List<BaseKeyframeAnimation<Integer, Integer>> f10010b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final List<Mask> f10011c;

    public MaskKeyframeAnimation(List<Mask> list) {
        this.f10011c = list;
        this.f10009a = new ArrayList(list.size());
        this.f10010b = new ArrayList(list.size());
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            this.f10009a.add(list.get(OplusGLSurfaceView_13).m9004b().mo8957a());
            this.f10010b.add(list.get(OplusGLSurfaceView_13).m9005c().mo8957a());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<Mask> m8866a() {
        return this.f10011c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<BaseKeyframeAnimation<ShapeData, Path>> m8867b() {
        return this.f10009a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<BaseKeyframeAnimation<Integer, Integer>> m8868c() {
        return this.f10010b;
    }
}
