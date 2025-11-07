package com.oplus.anim.p115c.p117b;

import android.graphics.Paint;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.p111a.p112a.StrokeContent;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p116a.AnimatableColorValue;
import com.oplus.anim.p115c.p116a.AnimatableFloatValue;
import com.oplus.anim.p115c.p116a.AnimatableIntegerValue;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;
import java.util.List;

/* compiled from: ShapeStroke.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.p */
/* loaded from: classes2.dex */
public class ShapeStroke implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f10202a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AnimatableFloatValue f10203b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final List<AnimatableFloatValue> f10204c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final AnimatableColorValue f10205d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final AnimatableIntegerValue f10206e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final AnimatableFloatValue f10207f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final PlatformImplementations.kt_3 f10208g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final IntrinsicsJvm.kt_4 f10209h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final float f10210i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final boolean f10211j;

    public ShapeStroke(String str, AnimatableFloatValue c2315b, List<AnimatableFloatValue> list, AnimatableColorValue c2314a, AnimatableIntegerValue c2317d, AnimatableFloatValue c2315b2, PlatformImplementations.kt_3 aVar, IntrinsicsJvm.kt_4 bVar, float COUIBaseListPopupWindow_12, boolean z) {
        this.f10202a = str;
        this.f10203b = c2315b;
        this.f10204c = list;
        this.f10205d = c2314a;
        this.f10206e = c2317d;
        this.f10207f = c2315b2;
        this.f10208g = aVar;
        this.f10209h = bVar;
        this.f10210i = COUIBaseListPopupWindow_12;
        this.f10211j = z;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (OplusLog.f10388d) {
            OplusLog.m9286b("ShapeStroke to StrokeContent, layer = " + abstractC2347a);
        }
        return new StrokeContent(c2309b, abstractC2347a, this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m9046a() {
        return this.f10202a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AnimatableColorValue m9047b() {
        return this.f10205d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public AnimatableIntegerValue m9048c() {
        return this.f10206e;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public AnimatableFloatValue m9049d() {
        return this.f10207f;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public List<AnimatableFloatValue> m9050e() {
        return this.f10204c;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public AnimatableFloatValue m9051f() {
        return this.f10203b;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public PlatformImplementations.kt_3 m9052g() {
        return this.f10208g;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public IntrinsicsJvm.kt_4 m9053h() {
        return this.f10209h;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public float m9054i() {
        return this.f10210i;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m9055j() {
        return this.f10211j;
    }

    /* compiled from: ShapeStroke.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.p$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f10212a[ordinal()];
            if (OplusGLSurfaceView_13 == 1) {
                return Paint.Cap.BUTT;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.SQUARE;
        }
    }

    /* compiled from: ShapeStroke.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.p$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f10212a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        static final /* synthetic */ int[] f10213b = new int[IntrinsicsJvm.kt_4.values().length];

        static {
            try {
                f10213b[IntrinsicsJvm.kt_4.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10213b[IntrinsicsJvm.kt_4.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10213b[IntrinsicsJvm.kt_4.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f10212a = new int[PlatformImplementations.kt_3.values().length];
            try {
                f10212a[PlatformImplementations.kt_3.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10212a[PlatformImplementations.kt_3.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10212a[PlatformImplementations.kt_3.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: ShapeStroke.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.p$IntrinsicsJvm.kt_4 */
    public enum IntrinsicsJvm.kt_4 {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f10213b[ordinal()];
            if (OplusGLSurfaceView_13 == 1) {
                return Paint.Join.BEVEL;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return Paint.Join.MITER;
            }
            if (OplusGLSurfaceView_13 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }
}
