package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.core.p027a.p028a.ResourcesCompat;

/* compiled from: TintTypedArray.java */
/* renamed from: androidx.appcompat.widget.ar */
/* loaded from: classes.dex */
public class TintTypedArray {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f1874a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final TypedArray f1875b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private TypedValue f1876c;

    /* renamed from: PlatformImplementations.kt_3 */
    public static TintTypedArray m1540a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static TintTypedArray m1541a(Context context, AttributeSet attributeSet, int[] iArr, int OplusGLSurfaceView_13, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, OplusGLSurfaceView_13, i2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static TintTypedArray m1539a(Context context, int OplusGLSurfaceView_13, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(OplusGLSurfaceView_13, iArr));
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f1874a = context;
        this.f1875b = typedArray;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Drawable m1546a(int OplusGLSurfaceView_13) {
        int resourceId;
        if (this.f1875b.hasValue(OplusGLSurfaceView_13) && (resourceId = this.f1875b.getResourceId(OplusGLSurfaceView_13, 0)) != 0) {
            return AppCompatResources.m732b(this.f1874a, resourceId);
        }
        return this.f1875b.getDrawable(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Drawable m1550b(int OplusGLSurfaceView_13) {
        int resourceId;
        if (!this.f1875b.hasValue(OplusGLSurfaceView_13) || (resourceId = this.f1875b.getResourceId(OplusGLSurfaceView_13, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.m1666b().m1669a(this.f1874a, resourceId, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface m1545a(int OplusGLSurfaceView_13, int i2, ResourcesCompat.PlatformImplementations.kt_3 aVar) {
        int resourceId = this.f1875b.getResourceId(OplusGLSurfaceView_13, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1876c == null) {
            this.f1876c = new TypedValue();
        }
        return ResourcesCompat.m2299a(this.f1874a, resourceId, this.f1876c, i2, aVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m1543a() {
        return this.f1875b.length();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public CharSequence m1553c(int OplusGLSurfaceView_13) {
        return this.f1875b.getText(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m1555d(int OplusGLSurfaceView_13) {
        return this.f1875b.getString(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m1547a(int OplusGLSurfaceView_13, boolean z) {
        return this.f1875b.getBoolean(OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m1544a(int OplusGLSurfaceView_13, int i2) {
        return this.f1875b.getInt(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float m1542a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return this.f1875b.getFloat(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m1549b(int OplusGLSurfaceView_13, int i2) {
        return this.f1875b.getColor(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public ColorStateList m1557e(int OplusGLSurfaceView_13) {
        int resourceId;
        ColorStateList colorStateListM729a;
        return (!this.f1875b.hasValue(OplusGLSurfaceView_13) || (resourceId = this.f1875b.getResourceId(OplusGLSurfaceView_13, 0)) == 0 || (colorStateListM729a = AppCompatResources.m729a(this.f1874a, resourceId)) == null) ? this.f1875b.getColorStateList(OplusGLSurfaceView_13) : colorStateListM729a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m1552c(int OplusGLSurfaceView_13, int i2) {
        return this.f1875b.getInteger(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m1548b(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        return this.f1875b.getDimension(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m1554d(int OplusGLSurfaceView_13, int i2) {
        return this.f1875b.getDimensionPixelOffset(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m1556e(int OplusGLSurfaceView_13, int i2) {
        return this.f1875b.getDimensionPixelSize(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m1558f(int OplusGLSurfaceView_13, int i2) {
        return this.f1875b.getLayoutDimension(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m1560g(int OplusGLSurfaceView_13, int i2) {
        return this.f1875b.getResourceId(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public CharSequence[] m1559f(int OplusGLSurfaceView_13) {
        return this.f1875b.getTextArray(OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m1561g(int OplusGLSurfaceView_13) {
        return this.f1875b.hasValue(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1551b() {
        this.f1875b.recycle();
    }
}
