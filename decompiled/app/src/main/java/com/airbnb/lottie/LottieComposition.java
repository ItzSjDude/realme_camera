package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.p084c.Font_2;
import com.airbnb.lottie.p084c.FontCharacter_2;
import com.airbnb.lottie.p084c.Marker_2;
import com.airbnb.lottie.p084c.p087c.Layer_4;
import com.airbnb.lottie.p091f.Logger_3;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: LottieComposition.java */
/* renamed from: com.airbnb.lottie.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class LottieComposition {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Map<String, List<Layer_4>> f5711c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Map<String, LottieImageAsset> f5712d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Map<String, Font_2> f5713e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private List<Marker_2> f5714f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private SparseArrayCompat<FontCharacter_2> f5715g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private LongSparseArray<Layer_4> f5716h;

    /* renamed from: OplusGLSurfaceView_13 */
    private List<Layer_4> f5717i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Rect f5718j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f5719k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f5720l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f5721m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f5722n;

    /* renamed from: PlatformImplementations.kt_3 */
    private final PerformanceTracker_3 f5709a = new PerformanceTracker_3();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final HashSet<String> f5710b = new HashSet<>();

    /* renamed from: o */
    private int f5723o = 0;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5842a(Rect rect, float COUIBaseListPopupWindow_12, float f2, float f3, List<Layer_4> list, LongSparseArray<Layer_4> longSparseArray, Map<String, List<Layer_4>> map, Map<String, LottieImageAsset> map2, SparseArrayCompat<FontCharacter_2> sparseArrayCompat, Map<String, Font_2> map3, List<Marker_2> list2) {
        this.f5718j = rect;
        this.f5719k = COUIBaseListPopupWindow_12;
        this.f5720l = f2;
        this.f5721m = f3;
        this.f5717i = list;
        this.f5716h = longSparseArray;
        this.f5711c = map;
        this.f5712d = map2;
        this.f5715g = sparseArrayCompat;
        this.f5713e = map3;
        this.f5714f = list2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5843a(String str) {
        Logger_3.m6100b(str);
        this.f5710b.add(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5844a(boolean z) {
        this.f5722n = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5841a(int OplusGLSurfaceView_13) {
        this.f5723o += OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m5845a() {
        return this.f5722n;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m5846b() {
        return this.f5723o;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5848b(boolean z) {
        this.f5709a.m6194a(z);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public PerformanceTracker_3 m5850c() {
        return this.f5709a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Layer_4 m5840a(long OplusGLSurfaceView_15) {
        return this.f5716h.get(OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Rect m5851d() {
        return this.f5718j;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public float m5852e() {
        return (long) ((m5860m() / this.f5721m) * 1000.0f);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public float m5853f() {
        return this.f5719k;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public float m5854g() {
        return this.f5720l;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public float m5855h() {
        return this.f5721m;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public List<Layer_4> m5856i() {
        return this.f5717i;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<Layer_4> m5847b(String str) {
        return this.f5711c.get(str);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public SparseArrayCompat<FontCharacter_2> m5857j() {
        return this.f5715g;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public Map<String, Font_2> m5858k() {
        return this.f5713e;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Marker_2 m5849c(String str) {
        int size = this.f5714f.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            Marker_2 c1134h = this.f5714f.get(OplusGLSurfaceView_13);
            if (c1134h.m5837a(str)) {
                return c1134h;
            }
        }
        return null;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public Map<String, LottieImageAsset> m5859l() {
        return this.f5712d;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public float m5860m() {
        return this.f5720l - this.f5719k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\OplusGLSurfaceView_11");
        Iterator<Layer_4> it = this.f5717i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().m5786a("\t"));
        }
        return sb.toString();
    }
}
