package androidx.transition;

/* compiled from: PathProperty.java */
/* loaded from: classes.dex */
class h_renamed<T_renamed> extends android.util.Property<T_renamed, java.lang.Float> {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.util.Property<T_renamed, android.graphics.PointF> f1723a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.graphics.PathMeasure f1724b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final float f1725c;
    private final float[] d_renamed;
    private final android.graphics.PointF e_renamed;
    private float f_renamed;

    h_renamed(android.util.Property<T_renamed, android.graphics.PointF> property, android.graphics.Path path) {
        super(java.lang.Float.class, property.getName());
        this.d_renamed = new float[2];
        this.e_renamed = new android.graphics.PointF();
        this.f1723a = property;
        this.f1724b = new android.graphics.PathMeasure(path, false);
        this.f1725c = this.f1724b.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public java.lang.Float get(T_renamed t_renamed) {
        return java.lang.Float.valueOf(this.f_renamed);
    }

    @Override // android.util.Property
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void set(T_renamed t_renamed, java.lang.Float f_renamed) {
        this.f_renamed = f_renamed.floatValue();
        this.f1724b.getPosTan(this.f1725c * f_renamed.floatValue(), this.d_renamed, null);
        android.graphics.PointF pointF = this.e_renamed;
        float[] fArr = this.d_renamed;
        pointF.x_renamed = fArr[0];
        pointF.y_renamed = fArr[1];
        this.f1723a.set(t_renamed, pointF);
    }
}
