package com.coui.appcompat.widget.keyboard;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import coui.support.appcompat.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SecurityKeyboard.java */
/* renamed from: com.coui.appcompat.widget.keyboard.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class SecurityKeyboard {

    /* renamed from: s */
    private static float f8288s = 1.8f;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f8289a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f8290b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f8291c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f8292d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f8293e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PlatformImplementations.kt_3[] f8294f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int[] f8295g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f8296h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f8297i;

    /* renamed from: OplusGLSurfaceView_15 */
    private List<PlatformImplementations.kt_3> f8298j;

    /* renamed from: OplusGLSurfaceView_5 */
    private List<PlatformImplementations.kt_3> f8299k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f8300l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f8301m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f8302n;

    /* renamed from: o */
    private int f8303o;

    /* renamed from: p */
    private int f8304p;

    /* renamed from: q */
    private int[][] f8305q;

    /* renamed from: r */
    private int f8306r;

    /* renamed from: t */
    private ArrayList<IntrinsicsJvm.kt_4> f8307t;

    /* renamed from: u */
    private int f8308u;

    /* compiled from: SecurityKeyboard.java */
    /* renamed from: com.coui.appcompat.widget.keyboard.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f8335a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f8336b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f8337c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f8338d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        ArrayList<PlatformImplementations.kt_3> f8339e = new ArrayList<>();

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f8340f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int f8341g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private SecurityKeyboard f8342h;

        public IntrinsicsJvm.kt_4(SecurityKeyboard c1486a) {
            this.f8342h = c1486a;
        }

        public IntrinsicsJvm.kt_4(Resources resources, SecurityKeyboard c1486a, XmlResourceParser xmlResourceParser) {
            this.f8342h = c1486a;
            TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.SecurityKeyboard);
            this.f8335a = SecurityKeyboard.m7921a(typedArrayObtainAttributes, R.styleable.SecurityKeyboard_couiKeyWidth, c1486a.f8300l, c1486a.f8290b);
            this.f8336b = SecurityKeyboard.m7921a(typedArrayObtainAttributes, R.styleable.SecurityKeyboard_couiKeyHeight, c1486a.f8301m, c1486a.f8291c);
            this.f8337c = SecurityKeyboard.m7921a(typedArrayObtainAttributes, R.styleable.SecurityKeyboard_couiHorizontalGap, c1486a.f8300l, c1486a.f8289a);
            this.f8338d = SecurityKeyboard.m7921a(typedArrayObtainAttributes, R.styleable.SecurityKeyboard_couiVerticalGap, c1486a.f8301m, c1486a.f8292d);
            typedArrayObtainAttributes.recycle();
            TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.SecurityKeyboard_Row);
            this.f8340f = typedArrayObtainAttributes2.getInt(R.styleable.SecurityKeyboard_Row_couiRowEdgeFlags, 0);
            this.f8341g = typedArrayObtainAttributes2.getResourceId(R.styleable.SecurityKeyboard_Row_couiKeyboardMode, 0);
        }
    }

    /* compiled from: SecurityKeyboard.java */
    /* renamed from: com.coui.appcompat.widget.keyboard.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: u */
        private static final int[] f8309u = {android.R.attr.state_checkable, android.R.attr.state_checked};

        /* renamed from: v */
        private static final int[] f8310v = {android.R.attr.state_pressed, android.R.attr.state_checkable, android.R.attr.state_checked};

        /* renamed from: w */
        private static final int[] f8311w = {android.R.attr.state_checkable};

        /* renamed from: x */
        private static final int[] f8312x = {android.R.attr.state_pressed, android.R.attr.state_checkable};

        /* renamed from: y */
        private static final int[] f8313y = new int[0];

        /* renamed from: z */
        private static final int[] f8314z = {android.R.attr.state_pressed};

        /* renamed from: PlatformImplementations.kt_3 */
        public int[] f8315a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public CharSequence f8316b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public Drawable f8317c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public Drawable f8318d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f8319e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f8320f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int f8321g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean f8322h;

        /* renamed from: OplusGLSurfaceView_13 */
        public int f8323i;

        /* renamed from: OplusGLSurfaceView_15 */
        public int f8324j;

        /* renamed from: OplusGLSurfaceView_5 */
        public boolean f8325k;

        /* renamed from: OplusGLSurfaceView_14 */
        public boolean f8326l;

        /* renamed from: OplusGLSurfaceView_6 */
        public CharSequence f8327m;

        /* renamed from: OplusGLSurfaceView_11 */
        public CharSequence f8328n;

        /* renamed from: o */
        public CharSequence f8329o;

        /* renamed from: p */
        public int f8330p;

        /* renamed from: q */
        public boolean f8331q;

        /* renamed from: r */
        public int f8332r;

        /* renamed from: s */
        public boolean f8333s;

        /* renamed from: t */
        private SecurityKeyboard f8334t;

        public PlatformImplementations.kt_3(IntrinsicsJvm.kt_4 bVar) {
            this.f8329o = null;
            this.f8334t = bVar.f8342h;
            this.f8320f = bVar.f8336b;
            this.f8319e = bVar.f8335a;
            this.f8321g = bVar.f8337c;
            this.f8330p = bVar.f8340f;
        }

        public PlatformImplementations.kt_3(Resources resources, IntrinsicsJvm.kt_4 bVar, int OplusGLSurfaceView_13, int i2, XmlResourceParser xmlResourceParser) {
            this(bVar);
            this.f8323i = OplusGLSurfaceView_13;
            this.f8324j = i2;
            TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.SecurityKeyboard);
            this.f8319e = SecurityKeyboard.m7921a(typedArrayObtainAttributes, R.styleable.SecurityKeyboard_couiKeyWidth, this.f8334t.f8300l, bVar.f8335a);
            this.f8320f = SecurityKeyboard.m7921a(typedArrayObtainAttributes, R.styleable.SecurityKeyboard_couiKeyHeight, this.f8334t.f8301m, bVar.f8336b);
            this.f8321g = SecurityKeyboard.m7921a(typedArrayObtainAttributes, R.styleable.SecurityKeyboard_couiHorizontalGap, this.f8334t.f8300l, bVar.f8337c);
            typedArrayObtainAttributes.recycle();
            TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.SecurityKeyboard_Key);
            this.f8323i += this.f8321g;
            TypedValue typedValue = new TypedValue();
            typedArrayObtainAttributes2.getValue(R.styleable.SecurityKeyboard_Key_couiCodes, typedValue);
            if (typedValue.type == 16 || typedValue.type == 17) {
                this.f8315a = new int[]{typedValue.data};
            } else if (typedValue.type == 3) {
                this.f8315a = m7945a(typedValue.string.toString());
            }
            this.f8318d = typedArrayObtainAttributes2.getDrawable(R.styleable.SecurityKeyboard_Key_couiIconPreview);
            Drawable drawable = this.f8318d;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f8318d.getIntrinsicHeight());
            }
            this.f8328n = typedArrayObtainAttributes2.getText(R.styleable.SecurityKeyboard_Key_couiPopupCharacters);
            this.f8332r = typedArrayObtainAttributes2.getResourceId(R.styleable.SecurityKeyboard_Key_couiPopupKeyboard, 0);
            this.f8333s = typedArrayObtainAttributes2.getBoolean(R.styleable.SecurityKeyboard_Key_couiIsRepeatable, false);
            this.f8331q = typedArrayObtainAttributes2.getBoolean(R.styleable.SecurityKeyboard_Key_couiIsModifier, false);
            this.f8322h = typedArrayObtainAttributes2.getBoolean(R.styleable.SecurityKeyboard_Key_couiIsSticky, false);
            this.f8330p = typedArrayObtainAttributes2.getInt(R.styleable.SecurityKeyboard_Key_couiKeyEdgeFlags, 0);
            this.f8330p = bVar.f8340f | this.f8330p;
            this.f8317c = typedArrayObtainAttributes2.getDrawable(R.styleable.SecurityKeyboard_Key_couiKeyIcon);
            Drawable drawable2 = this.f8317c;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f8317c.getIntrinsicHeight());
            }
            this.f8316b = typedArrayObtainAttributes2.getText(R.styleable.SecurityKeyboard_Key_couiKeyLabel);
            this.f8327m = typedArrayObtainAttributes2.getText(R.styleable.SecurityKeyboard_Key_couiKeyOutputText);
            this.f8329o = typedArrayObtainAttributes2.getText(R.styleable.SecurityKeyboard_Key_couiKeyAnnounce);
            if (this.f8315a == null && !TextUtils.isEmpty(this.f8316b)) {
                this.f8315a = new int[]{this.f8316b.charAt(0)};
            }
            typedArrayObtainAttributes2.recycle();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7942a() {
            this.f8325k = !this.f8325k;
            Drawable drawable = this.f8317c;
            if (drawable != null) {
                drawable.setState(m7947b());
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7943a(boolean z) {
            this.f8325k = !this.f8325k;
            if (this.f8322h && z) {
                this.f8326l = !this.f8326l;
            }
            Drawable drawable = this.f8317c;
            if (drawable != null) {
                drawable.setState(m7947b());
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int[] m7945a(String str) {
            int OplusGLSurfaceView_13;
            int i2 = 0;
            if (str.length() > 0) {
                OplusGLSurfaceView_13 = 1;
                int iIndexOf = 0;
                while (true) {
                    iIndexOf = str.indexOf(",", iIndexOf + 1);
                    if (iIndexOf <= 0) {
                        break;
                    }
                    OplusGLSurfaceView_13++;
                }
            } else {
                OplusGLSurfaceView_13 = 0;
            }
            int[] iArr = new int[OplusGLSurfaceView_13];
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreTokens()) {
                int i3 = i2 + 1;
                try {
                    iArr[i2] = Integer.parseInt(stringTokenizer.nextToken());
                } catch (NumberFormatException unused) {
                    Log.COUIBaseListPopupWindow_8("SecurityKeyboard", "Error parsing keycodes " + str);
                }
                i2 = i3;
            }
            return iArr;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m7944a(int OplusGLSurfaceView_13, int i2) {
            int i3;
            boolean z = (this.f8330p & 1) > 0;
            boolean z2 = (this.f8330p & 2) > 0;
            boolean z3 = (this.f8330p & 4) > 0;
            boolean z4 = (this.f8330p & 8) > 0;
            int i4 = this.f8323i;
            if (OplusGLSurfaceView_13 >= i4 || (z && OplusGLSurfaceView_13 <= i4 + this.f8319e)) {
                int i5 = this.f8323i;
                if ((OplusGLSurfaceView_13 < this.f8319e + i5 || (z2 && OplusGLSurfaceView_13 >= i5)) && (i2 >= (i3 = this.f8324j) || (z3 && i2 <= i3 + this.f8320f))) {
                    int i6 = this.f8324j;
                    if (i2 < this.f8320f + i6 || (z4 && i2 >= i6)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m7946b(int OplusGLSurfaceView_13, int i2) {
            int i3 = (this.f8323i + (this.f8319e / 2)) - OplusGLSurfaceView_13;
            int i4 = (this.f8324j + (this.f8320f / 2)) - i2;
            return (i3 * i3) + (i4 * i4);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int[] m7947b() {
            int[] iArr = f8313y;
            if (this.f8326l) {
                if (this.f8325k) {
                    return f8310v;
                }
                return f8309u;
            }
            if (!this.f8322h) {
                return this.f8325k ? f8314z : iArr;
            }
            if (this.f8325k) {
                return f8312x;
            }
            return f8311w;
        }
    }

    public SecurityKeyboard(Context context, int OplusGLSurfaceView_13) {
        this(context, OplusGLSurfaceView_13, 0);
    }

    public SecurityKeyboard(Context context, int OplusGLSurfaceView_13, int i2) {
        this.f8293e = 0;
        this.f8294f = new PlatformImplementations.kt_3[]{null, null};
        this.f8295g = new int[]{-1, -1};
        this.f8307t = new ArrayList<>();
        this.f8308u = 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f8300l = displayMetrics.widthPixels;
        this.f8301m = displayMetrics.heightPixels;
        this.f8289a = 0;
        this.f8290b = this.f8300l / 10;
        this.f8292d = 0;
        this.f8291c = this.f8290b;
        this.f8298j = new ArrayList();
        this.f8299k = new ArrayList();
        this.f8302n = i2;
        m7923a(context, context.getResources().getXml(OplusGLSurfaceView_13));
        m7938b(context);
    }

    public SecurityKeyboard(Context context, int OplusGLSurfaceView_13, CharSequence charSequence, int i2, int i3) {
        this(context, OplusGLSurfaceView_13);
        this.f8297i = 0;
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(this);
        bVar.f8336b = this.f8291c;
        bVar.f8335a = this.f8290b;
        bVar.f8337c = this.f8289a;
        bVar.f8338d = this.f8292d;
        bVar.f8340f = 12;
        i2 = i2 == -1 ? Integer.MAX_VALUE : i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (i5 >= i2 || this.f8290b + i6 + i3 > this.f8300l) {
                i4 += this.f8292d + this.f8291c;
                i5 = 0;
                i6 = 0;
            }
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(bVar);
            aVar.f8323i = i6;
            aVar.f8324j = i4;
            aVar.f8316b = String.valueOf(cCharAt);
            aVar.f8315a = new int[]{cCharAt};
            i5++;
            i6 += aVar.f8319e + aVar.f8321g;
            this.f8298j.add(aVar);
            bVar.f8339e.add(aVar);
            if (i6 > this.f8297i) {
                this.f8297i = i6;
            }
        }
        this.f8296h = i4 + this.f8291c;
        this.f8307t.add(bVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<PlatformImplementations.kt_3> m7934a() {
        return this.f8298j;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m7937b() {
        return this.f8296h;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m7939c() {
        return this.f8297i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7935a(int OplusGLSurfaceView_13) {
        for (PlatformImplementations.kt_3 aVar : this.f8294f) {
            if (aVar != null) {
                if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) {
                    aVar.f8326l = true;
                } else if (OplusGLSurfaceView_13 == 0) {
                    aVar.f8326l = false;
                }
            }
        }
        this.f8293e = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m7940d() {
        return this.f8293e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m7931f() {
        this.f8303o = ((m7939c() + 10) - 1) / 10;
        this.f8304p = ((m7937b() + 5) - 1) / 5;
        this.f8305q = new int[50][];
        int[] iArr = new int[this.f8298j.size()];
        int OplusGLSurfaceView_13 = this.f8303o * 10;
        int i2 = this.f8304p * 5;
        int i3 = 0;
        while (i3 < OplusGLSurfaceView_13) {
            int i4 = 0;
            while (i4 < i2) {
                int i5 = 0;
                for (int i6 = 0; i6 < this.f8298j.size(); i6++) {
                    PlatformImplementations.kt_3 aVar = this.f8298j.get(i6);
                    if (aVar.m7946b(i3, i4) < this.f8306r || aVar.m7946b((this.f8303o + i3) - 1, i4) < this.f8306r || aVar.m7946b((this.f8303o + i3) - 1, (this.f8304p + i4) - 1) < this.f8306r || aVar.m7946b(i3, (this.f8304p + i4) - 1) < this.f8306r) {
                        iArr[i5] = i6;
                        i5++;
                    }
                }
                int[] iArr2 = new int[i5];
                System.arraycopy(iArr, 0, iArr2, 0, i5);
                int[][] iArr3 = this.f8305q;
                int i7 = this.f8304p;
                iArr3[((i4 / i7) * 10) + (i3 / this.f8303o)] = iArr2;
                i4 += i7;
            }
            i3 += this.f8303o;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int[] m7936a(int OplusGLSurfaceView_13, int i2) {
        int i3;
        if (this.f8305q == null) {
            m7931f();
        }
        if (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < m7939c() && i2 >= 0 && i2 < m7937b() && (i3 = ((i2 / this.f8304p) * 10) + (OplusGLSurfaceView_13 / this.f8303o)) < 50) {
            return this.f8305q[i3];
        }
        return new int[0];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected IntrinsicsJvm.kt_4 m7933a(Resources resources, XmlResourceParser xmlResourceParser) {
        return new IntrinsicsJvm.kt_4(resources, this, xmlResourceParser);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected PlatformImplementations.kt_3 m7932a(Resources resources, IntrinsicsJvm.kt_4 bVar, int OplusGLSurfaceView_13, int i2, XmlResourceParser xmlResourceParser) {
        return new PlatformImplementations.kt_3(resources, bVar, OplusGLSurfaceView_13, i2, xmlResourceParser);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7923a(Context context, XmlResourceParser xmlResourceParser) {
        Resources resources = context.getResources();
        PlatformImplementations.kt_3 aVar = null;
        IntrinsicsJvm.kt_4 bVarM7933a = null;
        boolean z = false;
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        loop0: while (true) {
            int i3 = i2;
            while (true) {
                try {
                    int next = xmlResourceParser.next();
                    if (next == 1) {
                        break loop0;
                    }
                    if (next == 2) {
                        String name = xmlResourceParser.getName();
                        if ("Row".equals(name)) {
                            bVarM7933a = m7933a(resources, xmlResourceParser);
                            this.f8307t.add(bVarM7933a);
                            if ((bVarM7933a.f8341g == 0 || bVarM7933a.f8341g == this.f8302n) ? false : true) {
                                break;
                            }
                            i3 = 0;
                            i2 = 1;
                        } else if ("Key".equals(name)) {
                            PlatformImplementations.kt_3 aVarM7932a = m7932a(resources, bVarM7933a, i3, OplusGLSurfaceView_13, xmlResourceParser);
                            this.f8298j.add(aVarM7932a);
                            if (aVarM7932a.f8315a[0] == -1) {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= this.f8294f.length) {
                                        break;
                                    }
                                    if (this.f8294f[i4] == null) {
                                        this.f8294f[i4] = aVarM7932a;
                                        this.f8295g[i4] = this.f8298j.size() - 1;
                                        break;
                                    }
                                    i4++;
                                }
                                this.f8299k.add(aVarM7932a);
                            } else if (aVarM7932a.f8315a[0] == -6) {
                                this.f8299k.add(aVarM7932a);
                            }
                            bVarM7933a.f8339e.add(aVarM7932a);
                            aVar = aVarM7932a;
                            z = true;
                        } else if ("Keyboard".equals(name)) {
                            m7926b(resources, xmlResourceParser);
                        }
                    } else if (next == 3) {
                        if (z) {
                            i3 += aVar.f8321g + aVar.f8319e;
                            if (i3 > this.f8297i) {
                                this.f8297i = i3;
                            }
                            z = false;
                        } else if (i2 != 0) {
                            OplusGLSurfaceView_13 = OplusGLSurfaceView_13 + bVarM7933a.f8338d + bVarM7933a.f8336b;
                            i2 = 0;
                        }
                    }
                } catch (Exception COUIBaseListPopupWindow_8) {
                    Log.COUIBaseListPopupWindow_8("SecurityKeyboard", "Parse error:" + COUIBaseListPopupWindow_8);
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
            m7924a(xmlResourceParser);
            i2 = 0;
        }
        this.f8296h = OplusGLSurfaceView_13 - this.f8292d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7924a(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlResourceParser.getName().equals("Row")) {
                return;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7926b(Resources resources, XmlResourceParser xmlResourceParser) {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.SecurityKeyboard);
        int OplusGLSurfaceView_13 = R.styleable.SecurityKeyboard_couiKeyWidth;
        int i2 = this.f8300l;
        this.f8290b = m7921a(typedArrayObtainAttributes, OplusGLSurfaceView_13, i2, i2 / 10);
        this.f8291c = m7921a(typedArrayObtainAttributes, R.styleable.SecurityKeyboard_couiKeyHeight, this.f8301m, 50);
        this.f8289a = m7921a(typedArrayObtainAttributes, R.styleable.SecurityKeyboard_couiHorizontalGap, this.f8300l, 0);
        this.f8292d = m7921a(typedArrayObtainAttributes, R.styleable.SecurityKeyboard_couiVerticalGap, this.f8301m, 0);
        this.f8306r = (int) (this.f8290b * f8288s);
        int i3 = this.f8306r;
        this.f8306r = i3 * i3;
        typedArrayObtainAttributes.recycle();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m7921a(TypedArray typedArray, int OplusGLSurfaceView_13, int i2, int i3) {
        TypedValue typedValuePeekValue = typedArray.peekValue(OplusGLSurfaceView_13);
        if (typedValuePeekValue == null) {
            return i3;
        }
        if (typedValuePeekValue.type == 5) {
            return typedArray.getDimensionPixelOffset(OplusGLSurfaceView_13, i3);
        }
        return typedValuePeekValue.type == 6 ? Math.round(typedArray.getFraction(OplusGLSurfaceView_13, i2, i2, i3)) : i3;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m7941e() {
        return this.f8308u;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static float m7920a(Context context) {
        int OplusGLSurfaceView_13;
        float COUIBaseListPopupWindow_12;
        float f2;
        int identifier = context.getResources().getIdentifier("config_lidControlsDisplayFold", "bool", "android");
        if (identifier > 0 && context.getResources().getBoolean(identifier)) {
            COUIBaseListPopupWindow_12 = DisplayMetrics.DENSITY_DEVICE_STABLE;
            f2 = context.getResources().getDisplayMetrics().densityDpi;
        } else {
            if (context.getResources().getConfiguration().orientation == 1) {
                OplusGLSurfaceView_13 = context.getResources().getDisplayMetrics().widthPixels;
            } else {
                OplusGLSurfaceView_13 = context.getResources().getDisplayMetrics().heightPixels;
            }
            COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13 / 360.0f;
            f2 = context.getResources().getDisplayMetrics().densityDpi / 160.0f;
        }
        return COUIBaseListPopupWindow_12 / f2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7938b(Context context) {
        float fM7920a = m7920a(context);
        int size = this.f8307t.size();
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        while (OplusGLSurfaceView_13 < size) {
            IntrinsicsJvm.kt_4 bVar = this.f8307t.get(OplusGLSurfaceView_13);
            int size2 = bVar.f8339e.size();
            bVar.f8338d = (int) (bVar.f8338d * fM7920a);
            bVar.f8337c = (int) (bVar.f8337c * fM7920a);
            bVar.f8336b = (int) (bVar.f8336b * fM7920a);
            bVar.f8335a = (int) (bVar.f8335a * fM7920a);
            int i3 = 0;
            int i4 = i2;
            for (int i5 = 0; i5 < size2; i5++) {
                PlatformImplementations.kt_3 aVar = bVar.f8339e.get(i5);
                aVar.f8321g = (int) (aVar.f8321g * fM7920a);
                int i6 = i3 + aVar.f8321g;
                aVar.f8323i = i6;
                aVar.f8324j = (int) (aVar.f8324j * fM7920a);
                aVar.f8319e = (int) (aVar.f8319e * fM7920a);
                aVar.f8320f = (int) (aVar.f8320f * fM7920a);
                i3 = i6 + aVar.f8319e;
                if (i3 > i4) {
                    i4 = i3;
                }
            }
            OplusGLSurfaceView_13++;
            i2 = i4;
        }
        this.f8297i = i2;
        this.f8296h = (int) (this.f8296h * fM7920a);
    }
}
