package com.oplus.anim;

import android.graphics.Rect;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.oplus.anim.p115c.Font;
import com.oplus.anim.p115c.FontCharacter;
import com.oplus.anim.p115c.Marker;
import com.oplus.anim.p115c.p118c.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: EffectiveAnimationComposition.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class EffectiveAnimationComposition {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Map<String, List<Layer>> f9850c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Map<String, EffectiveImageAsset> f9851d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Map<String, Font> f9852e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private List<Marker> f9853f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private SparseArrayCompat<FontCharacter> f9854g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private LongSparseArray<Layer> f9855h;

    /* renamed from: OplusGLSurfaceView_13 */
    private List<Layer> f9856i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Rect f9857j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f9858k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f9859l;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f9860m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f9861n;

    /* renamed from: PlatformImplementations.kt_3 */
    private final PerformanceTracker f9848a = new PerformanceTracker();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final HashSet<String> f9849b = new HashSet<>();

    /* renamed from: o */
    private int f9862o = 0;

    /* renamed from: p */
    private float f9863p = 3.0f;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8784a(Rect rect, float COUIBaseListPopupWindow_12, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, EffectiveImageAsset> map2, SparseArrayCompat<FontCharacter> sparseArrayCompat, Map<String, Font> map3, List<Marker> list2, float f4) {
        this.f9857j = rect;
        this.f9858k = COUIBaseListPopupWindow_12;
        this.f9859l = f2;
        this.f9860m = f3;
        this.f9856i = list;
        this.f9855h = longSparseArray;
        this.f9850c = map;
        this.f9851d = map2;
        this.f9854g = sparseArrayCompat;
        this.f9852e = map3;
        this.f9853f = list2;
        this.f9863p = f4;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8785a(String str) {
        Log.w("EffectiveAnimation", str);
        this.f9849b.add(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8786a(boolean z) {
        this.f9861n = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8783a(int OplusGLSurfaceView_13) {
        this.f9862o += OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m8787a() {
        return this.f9861n;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m8788b() {
        return this.f9862o;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8790b(boolean z) {
        this.f9848a.m9353a(z);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public PerformanceTracker m8792c() {
        return this.f9848a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Layer m8782a(long OplusGLSurfaceView_15) {
        return this.f9855h.get(OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Rect m8793d() {
        return this.f9857j;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public float m8794e() {
        return (long) ((m8802m() / this.f9860m) * 1000.0f);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public float m8795f() {
        return this.f9858k;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public float m8796g() {
        return this.f9859l;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public float m8797h() {
        return this.f9860m;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public List<Layer> m8798i() {
        return this.f9856i;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<Layer> m8789b(String str) {
        return this.f9850c.get(str);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public SparseArrayCompat<FontCharacter> m8799j() {
        return this.f9854g;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public Map<String, Font> m8800k() {
        return this.f9852e;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Marker m8791c(String str) {
        this.f9853f.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f9853f.size(); OplusGLSurfaceView_13++) {
            Marker c2359h = this.f9853f.get(OplusGLSurfaceView_13);
            if (str.equals(c2359h.f10314a)) {
                return c2359h;
            }
        }
        return null;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public Map<String, EffectiveImageAsset> m8801l() {
        return this.f9851d;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public float m8802m() {
        return this.f9859l - this.f9858k;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public float m8803n() {
        return this.f9863p;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EffectiveAnimationComposition:\OplusGLSurfaceView_11");
        Iterator<Layer> it = this.f9856i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().m9093a("\t"));
        }
        return sb.toString();
    }
}
