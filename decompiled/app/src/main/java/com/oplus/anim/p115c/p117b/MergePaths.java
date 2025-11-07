package com.oplus.anim.p115c.p117b;

import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.L;
import com.oplus.anim.p111a.p112a.MergePathsContent;
import com.oplus.anim.p111a.p112a.Content;
import com.oplus.anim.p115c.p118c.BaseLayer;
import com.oplus.anim.p121f.OplusLog;

/* compiled from: MergePaths.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class MergePaths implements ContentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f10163a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PlatformImplementations.kt_3 f10164b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final boolean f10165c;

    public MergePaths(String str, PlatformImplementations.kt_3 aVar, boolean z) {
        this.f10163a = str;
        this.f10164b = aVar;
        this.f10165c = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m9007a() {
        return this.f10163a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PlatformImplementations.kt_3 m9008b() {
        return this.f10164b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m9009c() {
        return this.f10165c;
    }

    @Override // com.oplus.anim.p115c.p117b.ContentModel
    /* renamed from: PlatformImplementations.kt_3 */
    public Content mo8962a(EffectiveAnimationDrawable c2309b, BaseLayer abstractC2347a) {
        if (!c2309b.m8907a()) {
            L.m9348b("Animation contains merge paths but they are disabled.");
            return null;
        }
        if (OplusLog.f10388d) {
            OplusLog.m9286b("MergePaths to MergePathsContent, layer = " + abstractC2347a);
        }
        return new MergePathsContent(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.f10164b + '}';
    }

    /* compiled from: MergePaths.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static PlatformImplementations.kt_3 forId(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 1) {
                return MERGE;
            }
            if (OplusGLSurfaceView_13 == 2) {
                return ADD;
            }
            if (OplusGLSurfaceView_13 == 3) {
                return SUBTRACT;
            }
            if (OplusGLSurfaceView_13 == 4) {
                return INTERSECT;
            }
            if (OplusGLSurfaceView_13 == 5) {
                return EXCLUDE_INTERSECTIONS;
            }
            return MERGE;
        }
    }
}
