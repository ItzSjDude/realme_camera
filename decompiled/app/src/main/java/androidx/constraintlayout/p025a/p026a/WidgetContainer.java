package androidx.constraintlayout.p025a.p026a;

import androidx.constraintlayout.p025a.Cache;
import java.util.ArrayList;

/* compiled from: WidgetContainer.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.q */
/* loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {

    /* renamed from: az */
    protected ArrayList<ConstraintWidget> f2359az = new ArrayList<>();

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo1994g() {
        this.f2359az.clear();
        super.mo1994g();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2091b(ConstraintWidget c0379f) {
        this.f2359az.add(c0379f);
        if (c0379f.m2003l() != null) {
            ((WidgetContainer) c0379f.m2003l()).m2092c(c0379f);
        }
        c0379f.m1967a((ConstraintWidget) this);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m2092c(ConstraintWidget c0379f) {
        this.f2359az.remove(c0379f);
        c0379f.m1967a((ConstraintWidget) null);
    }

    /* renamed from: T */
    public ConstraintWidgetContainer m2089T() {
        ConstraintWidget c0379fM2003l = m2003l();
        ConstraintWidgetContainer c0380g = this instanceof ConstraintWidgetContainer ? (ConstraintWidgetContainer) this : null;
        while (c0379fM2003l != null) {
            ConstraintWidget c0379fM2003l2 = c0379fM2003l.m2003l();
            if (c0379fM2003l instanceof ConstraintWidgetContainer) {
                c0380g = (ConstraintWidgetContainer) c0379fM2003l;
            }
            c0379fM2003l = c0379fM2003l2;
        }
        return c0380g;
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1974b(int OplusGLSurfaceView_13, int i2) {
        super.mo1974b(OplusGLSurfaceView_13, i2);
        int size = this.f2359az.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f2359az.get(i3).mo1974b(m2023w(), m2024x());
        }
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: E */
    public void mo1953E() {
        super.mo1953E();
        ArrayList<ConstraintWidget> arrayList = this.f2359az;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            ConstraintWidget c0379f = this.f2359az.get(OplusGLSurfaceView_13);
            c0379f.mo1974b(m2021u(), m2022v());
            if (!(c0379f instanceof ConstraintWidgetContainer)) {
                c0379f.mo1953E();
            }
        }
    }

    /* renamed from: N */
    public void mo2033N() {
        mo1953E();
        ArrayList<ConstraintWidget> arrayList = this.f2359az;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            ConstraintWidget c0379f = this.f2359az.get(OplusGLSurfaceView_13);
            if (c0379f instanceof WidgetContainer) {
                ((WidgetContainer) c0379f).mo2033N();
            }
        }
    }

    @Override // androidx.constraintlayout.p025a.p026a.ConstraintWidget
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1969a(Cache c0392c) {
        super.mo1969a(c0392c);
        int size = this.f2359az.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            this.f2359az.get(OplusGLSurfaceView_13).mo1969a(c0392c);
        }
    }

    /* renamed from: U */
    public void m2090U() {
        this.f2359az.clear();
    }
}
