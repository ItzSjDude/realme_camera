package com.oplus.anim.p115c.p117b;

import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.ContentGroup;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class ShapeGroup implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f10195a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final List<ContentModel> f10196b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final boolean f10197c;

    public ShapeGroup(String str, List<ContentModel> list, boolean z) {
        this.f10195a = str;
        this.f10196b = list;
        this.f10197c = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m9040a() {
        return this.f10195a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<ContentModel> m9041b() {
        return this.f10196b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m9042c() {
        return this.f10197c;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("ShapeGroup to ContentGroup, layer = " + abstractC2347a);
        }
        return new ContentGroup(c2309b, abstractC2347a, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f10195a + "' Shapes: " + Arrays.toString(this.f10196b.toArray()) + '}';
    }
}
