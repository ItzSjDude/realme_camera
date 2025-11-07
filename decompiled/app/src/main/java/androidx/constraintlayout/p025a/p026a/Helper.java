package androidx.constraintlayout.p025a.p026a;

import java.util.Arrays;

/* compiled from: Helper.java */
/* renamed from: androidx.constraintlayout.PlatformImplementations.kt_3.PlatformImplementations.kt_3.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class Helper extends ConstraintWidget {

    /* renamed from: ai */
    protected ConstraintWidget[] f2330ai = new ConstraintWidget[4];

    /* renamed from: aj */
    protected int f2331aj = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2060b(ConstraintWidget c0379f) {
        int OplusGLSurfaceView_13 = this.f2331aj + 1;
        ConstraintWidget[] c0379fArr = this.f2330ai;
        if (OplusGLSurfaceView_13 > c0379fArr.length) {
            this.f2330ai = (ConstraintWidget[]) Arrays.copyOf(c0379fArr, c0379fArr.length * 2);
        }
        ConstraintWidget[] c0379fArr2 = this.f2330ai;
        int i2 = this.f2331aj;
        c0379fArr2[i2] = c0379f;
        this.f2331aj = i2 + 1;
    }

    /* renamed from: K */
    public void m2059K() {
        this.f2331aj = 0;
    }
}
