package com.oplus.anim.p111a.p112a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.L;
import com.oplus.anim.p111a.p113b.BaseKeyframeAnimation;
import com.oplus.anim.p111a.p113b.TransformKeyframeAnimation;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.KeyPathElement;
import com.oplus.anim.p115c.p116a.AnimatableTransform;
import com.oplus.anim.p115c.p117b.ShapeGroup;
import com.oplus.anim.p115c.p117b.ContentModel;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.PlatformImplementations.kt_3, KeyPathElement {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Matrix f9881a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Path f9882b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final RectF f9883c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f9884d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final boolean f9885e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final List<Content> f9886f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final EffectiveAnimationDrawable f9887g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private List<PathContent> f9888h;

    /* renamed from: OplusGLSurfaceView_13 */
    private TransformKeyframeAnimation f9889i;

    public ContentGroup(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, ShapeGroup c2342n) {
        this(c2309b, abstractC2347a, c2342n.m9040a(), c2342n.m9042c(), m8818a(c2309b, abstractC2347a, c2342n.m9041b()), m8817a(c2342n.m9041b()));
    }

    ContentGroup(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, String str, boolean z, List<Content> list, AnimatableTransform c2325l) {
        this.f9881a = new Matrix();
        this.f9882b = new Path();
        this.f9883c = new RectF();
        this.f9884d = str;
        this.f9887g = c2309b;
        this.f9885e = z;
        this.f9886f = list;
        if (OplusLog.f10388d) {
            OplusLog.m9286b("ContentGroup::name = " + str + this);
        }
        if (c2325l != null) {
            this.f9889i = c2325l.m8972j();
            this.f9889i.m8882a(abstractC2347a);
            this.f9889i.m8881a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content interfaceC2276c = list.get(size);
            if (interfaceC2276c instanceof GreedyContent) {
                arrayList.add((GreedyContent) interfaceC2276c);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).mo8829a(list.listIterator(list.size()));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static List<Content> m8818a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        if (OplusLog.f10388d) {
            OplusLog.m9286b("ContentGroup::contentsFromModels()::contentModels.size() = " + list.size());
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            Content interfaceC2276cMo8962a = list.get(OplusGLSurfaceView_13).mo8962a(c2309b, abstractC2347a);
            if (OplusLog.f10388d) {
                OplusLog.m9286b("ContentGroup::contentsFromModels()::content + " + OplusGLSurfaceView_13);
            }
            if (interfaceC2276cMo8962a != null) {
                if (OplusLog.f10388d) {
                    OplusLog.m9286b("ContentGroup::contentsFromModels()::content = " + interfaceC2276cMo8962a.toString());
                }
                arrayList.add(interfaceC2276cMo8962a);
            }
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static AnimatableTransform m8817a(List<ContentModel> list) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            ContentModel interfaceC2330b = list.get(OplusGLSurfaceView_13);
            if (interfaceC2330b instanceof AnimatableTransform) {
                if (OplusLog.f10388d) {
                    OplusLog.m9286b("ContentGroup::findTransform()::contentModel = " + interfaceC2330b);
                }
                return (AnimatableTransform) interfaceC2330b;
            }
        }
        return null;
    }

    @Override // com.oplus.anim.p111a.p113b.BaseKeyframeAnimation.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8806a() {
        this.f9887g.invalidateSelf();
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9884d;
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8811a(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f9886f.size());
        arrayList.addAll(list);
        for (int size = this.f9886f.size() - 1; size >= 0; size--) {
            Content interfaceC2276c = this.f9886f.get(size);
            interfaceC2276c.mo8811a(arrayList, this.f9886f.subList(0, size));
            arrayList.add(interfaceC2276c);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    List<PathContent> m8819c() {
        if (this.f9888h == null) {
            this.f9888h = new ArrayList();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f9886f.size(); OplusGLSurfaceView_13++) {
                Content interfaceC2276c = this.f9886f.get(OplusGLSurfaceView_13);
                if (interfaceC2276c instanceof PathContent) {
                    this.f9888h.add((PathContent) interfaceC2276c);
                }
            }
        }
        return this.f9888h;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    Matrix m8820d() {
        TransformKeyframeAnimation c2307o = this.f9889i;
        if (c2307o != null) {
            return c2307o.m8887d();
        }
        this.f9881a.reset();
        return this.f9881a;
    }

    @Override // com.oplus.anim.p111a.p112a.PathContent
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo8821e() {
        this.f9881a.reset();
        TransformKeyframeAnimation c2307o = this.f9889i;
        if (c2307o != null) {
            this.f9881a.set(c2307o.m8887d());
        }
        this.f9882b.reset();
        if (this.f9885e) {
            return this.f9882b;
        }
        for (int size = this.f9886f.size() - 1; size >= 0; size--) {
            Content interfaceC2276c = this.f9886f.get(size);
            if (interfaceC2276c instanceof PathContent) {
                this.f9882b.addPath(((PathContent) interfaceC2276c).mo8821e(), this.f9881a);
            }
        }
        return this.f9882b;
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8807a(Canvas canvas, Matrix matrix, int OplusGLSurfaceView_13) {
        if (this.f9885e) {
            return;
        }
        L.m9349c("ContentGroup#draw");
        this.f9881a.set(matrix);
        TransformKeyframeAnimation c2307o = this.f9889i;
        if (c2307o != null) {
            this.f9881a.preConcat(c2307o.m8887d());
            OplusGLSurfaceView_13 = (int) (((((this.f9889i.m8879a() == null ? 100 : this.f9889i.m8879a().mo8854g().intValue()) / 100.0f) * OplusGLSurfaceView_13) / 255.0f) * 255.0f);
        }
        for (int size = this.f9886f.size() - 1; size >= 0; size--) {
            Content interfaceC2276c = this.f9886f.get(size);
            if (interfaceC2276c instanceof DrawingContent) {
                if (OplusLog.f10385a) {
                    OplusLog.m9286b("ContentGroup::draw() content = " + ((DrawingContent) interfaceC2276c).mo8816b());
                }
                ((DrawingContent) interfaceC2276c).mo8807a(canvas, this.f9881a, OplusGLSurfaceView_13);
            }
        }
        L.m9350d("ContentGroup#draw");
    }

    @Override // com.oplus.anim.p111a.p112a.DrawingContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8808a(RectF rectF, Matrix matrix, boolean z) {
        this.f9881a.set(matrix);
        TransformKeyframeAnimation c2307o = this.f9889i;
        if (c2307o != null) {
            this.f9881a.preConcat(c2307o.m8887d());
        }
        this.f9883c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f9886f.size() - 1; size >= 0; size--) {
            Content interfaceC2276c = this.f9886f.get(size);
            if (interfaceC2276c instanceof DrawingContent) {
                ((DrawingContent) interfaceC2276c).mo8808a(this.f9883c, this.f9881a, z);
                rectF.union(this.f9883c);
            }
        }
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8809a(KeyPath c2357f, int OplusGLSurfaceView_13, List<KeyPath> list, KeyPath c2357f2) {
        if (OplusLog.f10387c) {
            OplusLog.m9286b("ContentGroup::resolveChildKeyPath()");
        }
        if (c2357f.m9138a(mo8816b(), OplusGLSurfaceView_13)) {
            if (!"__container".equals(mo8816b())) {
                c2357f2 = c2357f2.m9136a(mo8816b());
                if (c2357f.m9140c(mo8816b(), OplusGLSurfaceView_13)) {
                    if (OplusLog.f10387c) {
                        OplusLog.m9286b("ContentGroup::resolveChildKeyPath():name = " + mo8816b());
                    }
                    list.add(c2357f2.m9135a(this));
                }
            }
            if (c2357f.m9141d(mo8816b(), OplusGLSurfaceView_13)) {
                int iM9139b = OplusGLSurfaceView_13 + c2357f.m9139b(mo8816b(), OplusGLSurfaceView_13);
                for (int i2 = 0; i2 < this.f9886f.size(); i2++) {
                    Content interfaceC2276c = this.f9886f.get(i2);
                    if (OplusLog.f10387c) {
                        OplusLog.m9286b("ContentGroup::resolveChildKeyPath()");
                    }
                    if (interfaceC2276c instanceof KeyPathElement) {
                        KeyPathElement interfaceC2358g = (KeyPathElement) interfaceC2276c;
                        if (OplusLog.f10387c) {
                            OplusLog.m9286b("ContentGroup::resolveChildKeyPath()");
                        }
                        interfaceC2358g.mo8809a(c2357f, iM9139b, list, c2357f2);
                    }
                }
            }
        }
    }

    @Override // com.oplus.anim.p115c.KeyPathElement
    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void mo8810a(T t, EffectiveValueCallback<T> c2412b) {
        TransformKeyframeAnimation c2307o = this.f9889i;
        if (c2307o != null) {
            c2307o.m8883a(t, c2412b);
        }
    }
}
