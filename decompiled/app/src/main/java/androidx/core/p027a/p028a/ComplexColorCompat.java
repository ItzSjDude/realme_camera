package androidx.core.p027a.p028a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ComplexColorCompat.java */
/* renamed from: androidx.core.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public final class ComplexColorCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Shader f2688a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ColorStateList f2689b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f2690c;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, int OplusGLSurfaceView_13) {
        this.f2688a = shader;
        this.f2689b = colorStateList;
        this.f2690c = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static ComplexColorCompat m2264a(Shader shader) {
        return new ComplexColorCompat(shader, null, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static ComplexColorCompat m2262a(ColorStateList colorStateList) {
        return new ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static ComplexColorCompat m2261a(int OplusGLSurfaceView_13) {
        return new ComplexColorCompat(null, null, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Shader m2266a() {
        return this.f2688a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m2268b() {
        return this.f2690c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m2269b(int OplusGLSurfaceView_13) {
        this.f2690c = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m2270c() {
        return this.f2688a != null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m2271d() {
        ColorStateList colorStateList;
        return this.f2688a == null && (colorStateList = this.f2689b) != null && colorStateList.isStateful();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m2267a(int[] iArr) {
        if (m2271d()) {
            ColorStateList colorStateList = this.f2689b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f2690c) {
                this.f2690c = colorForState;
                return true;
            }
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m2272e() {
        return m2270c() || this.f2690c != 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ComplexColorCompat m2263a(Resources resources, int OplusGLSurfaceView_13, Resources.Theme theme) {
        try {
            return m2265b(resources, OplusGLSurfaceView_13, theme);
        } catch (Exception COUIBaseListPopupWindow_8) {
            Log.COUIBaseListPopupWindow_8("ComplexColorCompat", "Failed to inflate ComplexColor.", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ComplexColorCompat m2265b(Resources resources, int OplusGLSurfaceView_13, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(OplusGLSurfaceView_13);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        char c2 = 65535;
        int iHashCode = name.hashCode();
        if (iHashCode != 89650992) {
            if (iHashCode == 1191572447 && name.equals("selector")) {
                c2 = 0;
            }
        } else if (name.equals("gradient")) {
            c2 = 1;
        }
        if (c2 == 0) {
            return m2262a(ColorStateListInflaterCompat.m2258a(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (c2 == 1) {
            return m2264a(GradientColorInflaterCompat.m2292a(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }
}
