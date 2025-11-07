package com.oplus.anim.p111a.p112a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.oplus.anim.p115c.p117b.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class MergePathsContent implements GreedyContent, PathContent {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f9939d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final MergePaths f9941f;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Path f9936a = new Path();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Path f9937b = new Path();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Path f9938c = new Path();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final List<PathContent> f9940e = new ArrayList();

    public MergePathsContent(MergePaths c2336h) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.f9939d = c2336h.m9007a();
        this.f9941f = c2336h;
    }

    @Override // com.oplus.anim.p111a.p112a.GreedyContent
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8829a(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content interfaceC2276cPrevious = listIterator.previous();
            if (interfaceC2276cPrevious instanceof PathContent) {
                this.f9940e.add((PathContent) interfaceC2276cPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo8811a(List<Content> list, List<Content> list2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f9940e.size(); OplusGLSurfaceView_13++) {
            this.f9940e.get(OplusGLSurfaceView_13).mo8811a(list, list2);
        }
    }

    @Override // com.oplus.anim.p111a.p112a.PathContent
    /* renamed from: COUIBaseListPopupWindow_8 */
    public Path mo8821e() {
        this.f9938c.reset();
        if (this.f9941f.m9009c()) {
            return this.f9938c;
        }
        int OplusGLSurfaceView_13 = COUIBaseListPopupWindow_2.f9942a[this.f9941f.m9008b().ordinal()];
        if (OplusGLSurfaceView_13 == 1) {
            m8830a();
        } else if (OplusGLSurfaceView_13 == 2) {
            m8831a(Path.Op.UNION);
        } else if (OplusGLSurfaceView_13 == 3) {
            m8831a(Path.Op.REVERSE_DIFFERENCE);
        } else if (OplusGLSurfaceView_13 == 4) {
            m8831a(Path.Op.INTERSECT);
        } else if (OplusGLSurfaceView_13 == 5) {
            m8831a(Path.Op.XOR);
        }
        return this.f9938c;
    }

    /* compiled from: MergePathsContent.java */
    /* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_14$1, reason: invalid class name */
    static /* synthetic */ class COUIBaseListPopupWindow_2 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f9942a = new int[MergePaths.PlatformImplementations.kt_3.values().length];

        static {
            try {
                f9942a[MergePaths.PlatformImplementations.kt_3.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9942a[MergePaths.PlatformImplementations.kt_3.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9942a[MergePaths.PlatformImplementations.kt_3.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9942a[MergePaths.PlatformImplementations.kt_3.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9942a[MergePaths.PlatformImplementations.kt_3.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.oplus.anim.p111a.p112a.Content
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo8816b() {
        return this.f9939d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8830a() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f9940e.size(); OplusGLSurfaceView_13++) {
            this.f9938c.addPath(this.f9940e.get(OplusGLSurfaceView_13).mo8821e());
        }
    }

    @TargetApi(19)
    /* renamed from: PlatformImplementations.kt_3 */
    private void m8831a(Path.Op op) {
        this.f9937b.reset();
        this.f9936a.reset();
        for (int size = this.f9940e.size() - 1; size >= 1; size--) {
            PathContent interfaceC2286m = this.f9940e.get(size);
            if (interfaceC2286m instanceof ContentGroup) {
                ContentGroup c2277d = (ContentGroup) interfaceC2286m;
                List<PathContent> listM8819c = c2277d.m8819c();
                for (int size2 = listM8819c.size() - 1; size2 >= 0; size2--) {
                    Path pathMo8821e = listM8819c.get(size2).mo8821e();
                    pathMo8821e.transform(c2277d.m8820d());
                    this.f9937b.addPath(pathMo8821e);
                }
            } else {
                this.f9937b.addPath(interfaceC2286m.mo8821e());
            }
        }
        PathContent interfaceC2286m2 = this.f9940e.get(0);
        if (interfaceC2286m2 instanceof ContentGroup) {
            ContentGroup c2277d2 = (ContentGroup) interfaceC2286m2;
            List<PathContent> listM8819c2 = c2277d2.m8819c();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM8819c2.size(); OplusGLSurfaceView_13++) {
                Path pathMo8821e2 = listM8819c2.get(OplusGLSurfaceView_13).mo8821e();
                pathMo8821e2.transform(c2277d2.m8820d());
                this.f9936a.addPath(pathMo8821e2);
            }
        } else {
            this.f9936a.set(interfaceC2286m2.mo8821e());
        }
        this.f9938c.op(this.f9936a, this.f9937b, op);
    }
}
