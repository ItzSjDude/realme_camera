package androidx.core.a_renamed.a_renamed;

/* compiled from: ComplexColorCompat.java */
/* loaded from: classes.dex */
public final class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.graphics.Shader f782a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.content.res.ColorStateList f783b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f784c;

    private b_renamed(android.graphics.Shader shader, android.content.res.ColorStateList colorStateList, int i_renamed) {
        this.f782a = shader;
        this.f783b = colorStateList;
        this.f784c = i_renamed;
    }

    static androidx.core.a_renamed.a_renamed.b_renamed a_renamed(android.graphics.Shader shader) {
        return new androidx.core.a_renamed.a_renamed.b_renamed(shader, null, 0);
    }

    static androidx.core.a_renamed.a_renamed.b_renamed a_renamed(android.content.res.ColorStateList colorStateList) {
        return new androidx.core.a_renamed.a_renamed.b_renamed(null, colorStateList, colorStateList.getDefaultColor());
    }

    static androidx.core.a_renamed.a_renamed.b_renamed a_renamed(int i_renamed) {
        return new androidx.core.a_renamed.a_renamed.b_renamed(null, null, i_renamed);
    }

    public android.graphics.Shader a_renamed() {
        return this.f782a;
    }

    public int b_renamed() {
        return this.f784c;
    }

    public void b_renamed(int i_renamed) {
        this.f784c = i_renamed;
    }

    public boolean c_renamed() {
        return this.f782a != null;
    }

    public boolean d_renamed() {
        android.content.res.ColorStateList colorStateList;
        return this.f782a == null && (colorStateList = this.f783b) != null && colorStateList.isStateful();
    }

    public boolean a_renamed(int[] iArr) {
        if (d_renamed()) {
            android.content.res.ColorStateList colorStateList = this.f783b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f784c) {
                this.f784c = colorForState;
                return true;
            }
        }
        return false;
    }

    public boolean e_renamed() {
        return c_renamed() || this.f784c != 0;
    }

    public static androidx.core.a_renamed.a_renamed.b_renamed a_renamed(android.content.res.Resources resources, int i_renamed, android.content.res.Resources.Theme theme) {
        try {
            return b_renamed(resources, i_renamed, theme);
        } catch (java.lang.Exception e_renamed) {
            android.util.Log.e_renamed("ComplexColorCompat", "Failed to inflate ComplexColor.", e_renamed);
            return null;
        }
    }

    private static androidx.core.a_renamed.a_renamed.b_renamed b_renamed(android.content.res.Resources resources, int i_renamed, android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        int next;
        android.content.res.XmlResourceParser xml = resources.getXml(i_renamed);
        android.util.AttributeSet attributeSetAsAttributeSet = android.util.Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
        }
        java.lang.String name = xml.getName();
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
            return a_renamed(androidx.core.a_renamed.a_renamed.a_renamed.a_renamed(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (c2 == 1) {
            return a_renamed(androidx.core.a_renamed.a_renamed.d_renamed.a_renamed(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new org.xmlpull.v1.XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }
}
