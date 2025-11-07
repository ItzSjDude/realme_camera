package androidx.appcompat.widget;

/* compiled from: TintTypedArray.java */
/* loaded from: classes.dex */
public class ar_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f577a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.content.res.TypedArray f578b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.util.TypedValue f579c;

    public static androidx.appcompat.widget.ar_renamed a_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int[] iArr) {
        return new androidx.appcompat.widget.ar_renamed(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static androidx.appcompat.widget.ar_renamed a_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int[] iArr, int i_renamed, int i2) {
        return new androidx.appcompat.widget.ar_renamed(context, context.obtainStyledAttributes(attributeSet, iArr, i_renamed, i2));
    }

    public static androidx.appcompat.widget.ar_renamed a_renamed(android.content.Context context, int i_renamed, int[] iArr) {
        return new androidx.appcompat.widget.ar_renamed(context, context.obtainStyledAttributes(i_renamed, iArr));
    }

    private ar_renamed(android.content.Context context, android.content.res.TypedArray typedArray) {
        this.f577a = context;
        this.f578b = typedArray;
    }

    public android.graphics.drawable.Drawable a_renamed(int i_renamed) {
        int resourceId;
        if (this.f578b.hasValue(i_renamed) && (resourceId = this.f578b.getResourceId(i_renamed, 0)) != 0) {
            return androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(this.f577a, resourceId);
        }
        return this.f578b.getDrawable(i_renamed);
    }

    public android.graphics.drawable.Drawable b_renamed(int i_renamed) {
        int resourceId;
        if (!this.f578b.hasValue(i_renamed) || (resourceId = this.f578b.getResourceId(i_renamed, 0)) == 0) {
            return null;
        }
        return androidx.appcompat.widget.i_renamed.b_renamed().a_renamed(this.f577a, resourceId, true);
    }

    public android.graphics.Typeface a_renamed(int i_renamed, int i2, androidx.core.a_renamed.a_renamed.f_renamed.a_renamed aVar) {
        int resourceId = this.f578b.getResourceId(i_renamed, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f579c == null) {
            this.f579c = new android.util.TypedValue();
        }
        return androidx.core.a_renamed.a_renamed.f_renamed.a_renamed(this.f577a, resourceId, this.f579c, i2, aVar);
    }

    public int a_renamed() {
        return this.f578b.length();
    }

    public java.lang.CharSequence c_renamed(int i_renamed) {
        return this.f578b.getText(i_renamed);
    }

    public java.lang.String d_renamed(int i_renamed) {
        return this.f578b.getString(i_renamed);
    }

    public boolean a_renamed(int i_renamed, boolean z_renamed) {
        return this.f578b.getBoolean(i_renamed, z_renamed);
    }

    public int a_renamed(int i_renamed, int i2) {
        return this.f578b.getInt(i_renamed, i2);
    }

    public float a_renamed(int i_renamed, float f_renamed) {
        return this.f578b.getFloat(i_renamed, f_renamed);
    }

    public int b_renamed(int i_renamed, int i2) {
        return this.f578b.getColor(i_renamed, i2);
    }

    public android.content.res.ColorStateList e_renamed(int i_renamed) {
        int resourceId;
        android.content.res.ColorStateList colorStateListA;
        return (!this.f578b.hasValue(i_renamed) || (resourceId = this.f578b.getResourceId(i_renamed, 0)) == 0 || (colorStateListA = androidx.appcompat.a_renamed.a_renamed.a_renamed.a_renamed(this.f577a, resourceId)) == null) ? this.f578b.getColorStateList(i_renamed) : colorStateListA;
    }

    public int c_renamed(int i_renamed, int i2) {
        return this.f578b.getInteger(i_renamed, i2);
    }

    public float b_renamed(int i_renamed, float f_renamed) {
        return this.f578b.getDimension(i_renamed, f_renamed);
    }

    public int d_renamed(int i_renamed, int i2) {
        return this.f578b.getDimensionPixelOffset(i_renamed, i2);
    }

    public int e_renamed(int i_renamed, int i2) {
        return this.f578b.getDimensionPixelSize(i_renamed, i2);
    }

    public int f_renamed(int i_renamed, int i2) {
        return this.f578b.getLayoutDimension(i_renamed, i2);
    }

    public int g_renamed(int i_renamed, int i2) {
        return this.f578b.getResourceId(i_renamed, i2);
    }

    public java.lang.CharSequence[] f_renamed(int i_renamed) {
        return this.f578b.getTextArray(i_renamed);
    }

    public boolean g_renamed(int i_renamed) {
        return this.f578b.hasValue(i_renamed);
    }

    public void b_renamed() {
        this.f578b.recycle();
    }
}
