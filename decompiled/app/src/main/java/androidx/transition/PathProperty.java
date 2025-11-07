package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PathProperty.java */
/* renamed from: androidx.transition.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
class PathProperty<T> extends Property<T, Float> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Property<T, PointF> f4617a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PathMeasure f4618b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final float f4619c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final float[] f4620d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final PointF f4621e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f4622f;

    PathProperty(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f4620d = new float[2];
        this.f4621e = new PointF();
        this.f4617a = property;
        this.f4618b = new PathMeasure(path, false);
        this.f4619c = this.f4618b.getLength();
    }

    @Override // android.util.Property
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public Float get(T t) {
        return Float.valueOf(this.f4622f);
    }

    @Override // android.util.Property
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float COUIBaseListPopupWindow_12) {
        this.f4622f = COUIBaseListPopupWindow_12.floatValue();
        this.f4618b.getPosTan(this.f4619c * COUIBaseListPopupWindow_12.floatValue(), this.f4620d, null);
        PointF pointF = this.f4621e;
        float[] fArr = this.f4620d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f4617a.set(t, pointF);
    }
}
