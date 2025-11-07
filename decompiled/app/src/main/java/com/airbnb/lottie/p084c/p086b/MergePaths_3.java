package com.airbnb.lottie.p084c.p086b;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.p080a.p081a.MergePathsContent_3;
import com.airbnb.lottie.p080a.p081a.Content_2;
import com.airbnb.lottie.p084c.p087c.BaseLayer_3;
import com.airbnb.lottie.p091f.Logger_3;

/* compiled from: MergePaths.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class MergePaths_3 implements ContentModel_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f5541a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PlatformImplementations.kt_3 f5542b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final boolean f5543c;

    /* compiled from: MergePaths.java */
    /* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
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

    public MergePaths_3(String str, PlatformImplementations.kt_3 aVar, boolean z) {
        this.f5541a = str;
        this.f5542b = aVar;
        this.f5543c = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m5696a() {
        return this.f5541a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public PlatformImplementations.kt_3 m5697b() {
        return this.f5542b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m5698c() {
        return this.f5543c;
    }

    @Override // com.airbnb.lottie.p084c.p086b.ContentModel_2
    /* renamed from: PlatformImplementations.kt_3 */
    public Content_2 mo5651a(LottieDrawable c1187f, BaseLayer_3 abstractC1122a) {
        if (!c1187f.m6044a()) {
            Logger_3.m6100b("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new MergePathsContent_3(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.f5542b + '}';
    }
}
