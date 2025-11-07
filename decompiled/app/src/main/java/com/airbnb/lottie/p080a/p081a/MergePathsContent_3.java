package com.airbnb.lottie.p080a.p081a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.p084c.p086b.MergePaths_3;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class MergePathsContent_3 implements GreedyContent_2, PathContent_2 {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f5346d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final MergePaths_3 f5348f;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f5343a = new Path();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Path f5344b = new Path();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Path f5345c = new Path();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final List<PathContent_2> f5347e = new ArrayList();

    public MergePathsContent_3(MergePaths_3 c1111h) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.f5346d = c1111h.m5696a();
        this.f5348f = c1111h;
    }

    @Override // com.airbnb.lottie.p080a.p081a.GreedyContent_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5556a(ListIterator<Content_2> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content_2 interfaceC1051cPrevious = listIterator.previous();
            if (interfaceC1051cPrevious instanceof PathContent_2) {
                this.f5347e.add((PathContent_2) interfaceC1051cPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5535a(List<Content_2> list, List<Content_2> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5347e.size(); OplusGLSurfaceView_13++) {
            this.f5347e.get(OplusGLSurfaceView_13).mo5535a(list, list2);
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.PathContent_2
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo5546e() {
        this.f5345c.reset();
        if (this.f5348f.m5698c()) {
            return this.f5345c;
        }
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f5349a[this.f5348f.m5697b().ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            m5557a();
        } else if (OplusGLSurfaceView_13 == 2) {
            m5558a(Path.Op.UNION);
        } else if (OplusGLSurfaceView_13 == 3) {
            m5558a(Path.Op.REVERSE_DIFFERENCE);
        } else if (OplusGLSurfaceView_13 == 4) {
            m5558a(Path.Op.INTERSECT);
        } else if (OplusGLSurfaceView_13 == 5) {
            m5558a(Path.Op.XOR);
        }
        return this.f5345c;
    }

    /* compiled from: MergePathsContent.java */
    /* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_14$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f5349a = new int[MergePaths_3.PlatformImplementations.kt_3.values().length];

        static {
            try {
                f5349a[MergePaths_3.PlatformImplementations.kt_3.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5349a[MergePaths_3.PlatformImplementations.kt_3.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5349a[MergePaths_3.PlatformImplementations.kt_3.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5349a[MergePaths_3.PlatformImplementations.kt_3.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5349a[MergePaths_3.PlatformImplementations.kt_3.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.airbnb.lottie.p080a.p081a.Content_2
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo5540b() {
        return this.f5346d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5557a() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f5347e.size(); OplusGLSurfaceView_13++) {
            this.f5345c.addPath(this.f5347e.get(OplusGLSurfaceView_13).mo5546e());
        }
    }

    @TargetApi(19)
    /* renamed from: PlatformImplementations.kt_3 */
    private void m5558a(Path.Op op) {
        this.f5344b.reset();
        this.f5343a.reset();
        for (int size = this.f5347e.size() - 1; size >= 1; size--) {
            PathContent_2 interfaceC1061m = this.f5347e.get(size);
            if (interfaceC1061m instanceof ContentGroup_2) {
                ContentGroup_2 c1052d = (ContentGroup_2) interfaceC1061m;
                List<PathContent_2> listM5544c = c1052d.m5544c();
                for (int size2 = listM5544c.size() - 1; size2 >= 0; size2--) {
                    Path pathMo5546e = listM5544c.get(size2).mo5546e();
                    pathMo5546e.transform(c1052d.m5545d());
                    this.f5344b.addPath(pathMo5546e);
                }
            } else {
                this.f5344b.addPath(interfaceC1061m.mo5546e());
            }
        }
        PathContent_2 interfaceC1061m2 = this.f5347e.get(0);
        if (interfaceC1061m2 instanceof ContentGroup_2) {
            ContentGroup_2 c1052d2 = (ContentGroup_2) interfaceC1061m2;
            List<PathContent_2> listM5544c2 = c1052d2.m5544c();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM5544c2.size(); OplusGLSurfaceView_13++) {
                Path pathMo5546e2 = listM5544c2.get(OplusGLSurfaceView_13).mo5546e();
                pathMo5546e2.transform(c1052d2.m5545d());
                this.f5343a.addPath(pathMo5546e2);
            }
        } else {
            this.f5343a.set(interfaceC1061m2.mo5546e());
        }
        this.f5345c.op(this.f5343a, this.f5344b, op);
    }
}
