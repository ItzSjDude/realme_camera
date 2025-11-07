package com.coui.appcompat.widget.keyboard;

/* compiled from: SecurityKeyboard.java */
/* loaded from: classes.dex */
public class a_renamed {
    private static float s_renamed = 1.8f;

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f2982a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f2983b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f2984c;
    private int d_renamed;
    private int e_renamed;
    private com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3[] f_renamed;
    private int[] g_renamed;
    private int h_renamed;
    private int i_renamed;
    private java.util.List<com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3> j_renamed;
    private java.util.List<com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3> k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private int o_renamed;
    private int p_renamed;
    private int[][] q_renamed;
    private int r_renamed;
    private java.util.ArrayList<com.coui.appcompat.widget.keyboard.a_renamed.b_renamed> t_renamed;
    private int u_renamed;

    /* compiled from: SecurityKeyboard.java */
    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f2988a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f2989b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f2990c;
        public int d_renamed;
        java.util.ArrayList<com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3> e_renamed = new java.util.ArrayList<>();
        public int f_renamed;
        public int g_renamed;
        private com.coui.appcompat.widget.keyboard.a_renamed h_renamed;

        public b_renamed(com.coui.appcompat.widget.keyboard.a_renamed aVar) {
            this.h_renamed = aVar;
        }

        public b_renamed(android.content.res.Resources resources, com.coui.appcompat.widget.keyboard.a_renamed aVar, android.content.res.XmlResourceParser xmlResourceParser) {
            this.h_renamed = aVar;
            android.content.res.TypedArray typedArrayObtainAttributes = resources.obtainAttributes(android.util.Xml.asAttributeSet(xmlResourceParser), coui.support.appcompat.R_renamed.styleable.SecurityKeyboard);
            this.f2988a = com.coui.appcompat.widget.keyboard.a_renamed.a_renamed(typedArrayObtainAttributes, coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_couiKeyWidth, aVar.l_renamed, aVar.f2983b);
            this.f2989b = com.coui.appcompat.widget.keyboard.a_renamed.a_renamed(typedArrayObtainAttributes, coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_couiKeyHeight, aVar.m_renamed, aVar.f2984c);
            this.f2990c = com.coui.appcompat.widget.keyboard.a_renamed.a_renamed(typedArrayObtainAttributes, coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_couiHorizontalGap, aVar.l_renamed, aVar.f2982a);
            this.d_renamed = com.coui.appcompat.widget.keyboard.a_renamed.a_renamed(typedArrayObtainAttributes, coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_couiVerticalGap, aVar.m_renamed, aVar.d_renamed);
            typedArrayObtainAttributes.recycle();
            android.content.res.TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(android.util.Xml.asAttributeSet(xmlResourceParser), coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Row);
            this.f_renamed = typedArrayObtainAttributes2.getInt(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Row_couiRowEdgeFlags, 0);
            this.g_renamed = typedArrayObtainAttributes2.getResourceId(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Row_couiKeyboardMode, 0);
        }
    }

    /* compiled from: SecurityKeyboard.java */
    /* renamed from: com.coui.appcompat.widget.keyboard.a_renamed$a_renamed, reason: collision with other inner class name */
    public static class SecurityKeyboard_3 {
        private static final int[] u_renamed = {android.R_renamed.attr.state_checkable, android.R_renamed.attr.state_checked};
        private static final int[] v_renamed = {android.R_renamed.attr.state_pressed, android.R_renamed.attr.state_checkable, android.R_renamed.attr.state_checked};
        private static final int[] w_renamed = {android.R_renamed.attr.state_checkable};
        private static final int[] x_renamed = {android.R_renamed.attr.state_pressed, android.R_renamed.attr.state_checkable};
        private static final int[] y_renamed = new int[0];
        private static final int[] z_renamed = {android.R_renamed.attr.state_pressed};

        /* renamed from: a_renamed, reason: collision with root package name */
        public int[] f2985a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public java.lang.CharSequence f2986b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public android.graphics.drawable.Drawable f2987c;
        public android.graphics.drawable.Drawable d_renamed;
        public int e_renamed;
        public int f_renamed;
        public int g_renamed;
        public boolean h_renamed;
        public int i_renamed;
        public int j_renamed;
        public boolean k_renamed;
        public boolean l_renamed;
        public java.lang.CharSequence m_renamed;
        public java.lang.CharSequence n_renamed;
        public java.lang.CharSequence o_renamed;
        public int p_renamed;
        public boolean q_renamed;
        public int r_renamed;
        public boolean s_renamed;
        private com.coui.appcompat.widget.keyboard.a_renamed t_renamed;

        public SecurityKeyboard_3(com.coui.appcompat.widget.keyboard.a_renamed.b_renamed bVar) {
            this.o_renamed = null;
            this.t_renamed = bVar.h_renamed;
            this.f_renamed = bVar.f2989b;
            this.e_renamed = bVar.f2988a;
            this.g_renamed = bVar.f2990c;
            this.p_renamed = bVar.f_renamed;
        }

        public SecurityKeyboard_3(android.content.res.Resources resources, com.coui.appcompat.widget.keyboard.a_renamed.b_renamed bVar, int i_renamed, int i2, android.content.res.XmlResourceParser xmlResourceParser) {
            this(bVar);
            this.i_renamed = i_renamed;
            this.j_renamed = i2;
            android.content.res.TypedArray typedArrayObtainAttributes = resources.obtainAttributes(android.util.Xml.asAttributeSet(xmlResourceParser), coui.support.appcompat.R_renamed.styleable.SecurityKeyboard);
            this.e_renamed = com.coui.appcompat.widget.keyboard.a_renamed.a_renamed(typedArrayObtainAttributes, coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_couiKeyWidth, this.t_renamed.l_renamed, bVar.f2988a);
            this.f_renamed = com.coui.appcompat.widget.keyboard.a_renamed.a_renamed(typedArrayObtainAttributes, coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_couiKeyHeight, this.t_renamed.m_renamed, bVar.f2989b);
            this.g_renamed = com.coui.appcompat.widget.keyboard.a_renamed.a_renamed(typedArrayObtainAttributes, coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_couiHorizontalGap, this.t_renamed.l_renamed, bVar.f2990c);
            typedArrayObtainAttributes.recycle();
            android.content.res.TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(android.util.Xml.asAttributeSet(xmlResourceParser), coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key);
            this.i_renamed += this.g_renamed;
            android.util.TypedValue typedValue = new android.util.TypedValue();
            typedArrayObtainAttributes2.getValue(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiCodes, typedValue);
            if (typedValue.type == 16 || typedValue.type == 17) {
                this.f2985a = new int[]{typedValue.data};
            } else if (typedValue.type == 3) {
                this.f2985a = a_renamed(typedValue.string.toString());
            }
            this.d_renamed = typedArrayObtainAttributes2.getDrawable(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiIconPreview);
            android.graphics.drawable.Drawable drawable = this.d_renamed;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.d_renamed.getIntrinsicHeight());
            }
            this.n_renamed = typedArrayObtainAttributes2.getText(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiPopupCharacters);
            this.r_renamed = typedArrayObtainAttributes2.getResourceId(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiPopupKeyboard, 0);
            this.s_renamed = typedArrayObtainAttributes2.getBoolean(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiIsRepeatable, false);
            this.q_renamed = typedArrayObtainAttributes2.getBoolean(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiIsModifier, false);
            this.h_renamed = typedArrayObtainAttributes2.getBoolean(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiIsSticky, false);
            this.p_renamed = typedArrayObtainAttributes2.getInt(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiKeyEdgeFlags, 0);
            this.p_renamed = bVar.f_renamed | this.p_renamed;
            this.f2987c = typedArrayObtainAttributes2.getDrawable(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiKeyIcon);
            android.graphics.drawable.Drawable drawable2 = this.f2987c;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f2987c.getIntrinsicHeight());
            }
            this.f2986b = typedArrayObtainAttributes2.getText(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiKeyLabel);
            this.m_renamed = typedArrayObtainAttributes2.getText(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiKeyOutputText);
            this.o_renamed = typedArrayObtainAttributes2.getText(coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_Key_couiKeyAnnounce);
            if (this.f2985a == null && !android.text.TextUtils.isEmpty(this.f2986b)) {
                this.f2985a = new int[]{this.f2986b.charAt(0)};
            }
            typedArrayObtainAttributes2.recycle();
        }

        public void a_renamed() {
            this.k_renamed = !this.k_renamed;
            android.graphics.drawable.Drawable drawable = this.f2987c;
            if (drawable != null) {
                drawable.setState(b_renamed());
            }
        }

        public void a_renamed(boolean z2) {
            this.k_renamed = !this.k_renamed;
            if (this.h_renamed && z2) {
                this.l_renamed = !this.l_renamed;
            }
            android.graphics.drawable.Drawable drawable = this.f2987c;
            if (drawable != null) {
                drawable.setState(b_renamed());
            }
        }

        int[] a_renamed(java.lang.String str) {
            int i_renamed;
            int i2 = 0;
            if (str.length() > 0) {
                i_renamed = 1;
                int iIndexOf = 0;
                while (true) {
                    iIndexOf = str.indexOf(",", iIndexOf + 1);
                    if (iIndexOf <= 0) {
                        break;
                    }
                    i_renamed++;
                }
            } else {
                i_renamed = 0;
            }
            int[] iArr = new int[i_renamed];
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreTokens()) {
                int i3 = i2 + 1;
                try {
                    iArr[i2] = java.lang.Integer.parseInt(stringTokenizer.nextToken());
                } catch (java.lang.NumberFormatException unused) {
                    android.util.Log.e_renamed("SecurityKeyboard", "Error parsing keycodes " + str);
                }
                i2 = i3;
            }
            return iArr;
        }

        public boolean a_renamed(int i_renamed, int i2) {
            int i3;
            boolean z2 = (this.p_renamed & 1) > 0;
            boolean z3 = (this.p_renamed & 2) > 0;
            boolean z4 = (this.p_renamed & 4) > 0;
            boolean z5 = (this.p_renamed & 8) > 0;
            int i4 = this.i_renamed;
            if (i_renamed >= i4 || (z2 && i_renamed <= i4 + this.e_renamed)) {
                int i5 = this.i_renamed;
                if ((i_renamed < this.e_renamed + i5 || (z3 && i_renamed >= i5)) && (i2 >= (i3 = this.j_renamed) || (z4 && i2 <= i3 + this.f_renamed))) {
                    int i6 = this.j_renamed;
                    if (i2 < this.f_renamed + i6 || (z5 && i2 >= i6)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int b_renamed(int i_renamed, int i2) {
            int i3 = (this.i_renamed + (this.e_renamed / 2)) - i_renamed;
            int i4 = (this.j_renamed + (this.f_renamed / 2)) - i2;
            return (i3 * i3) + (i4 * i4);
        }

        public int[] b_renamed() {
            int[] iArr = y_renamed;
            if (this.l_renamed) {
                if (this.k_renamed) {
                    return v_renamed;
                }
                return u_renamed;
            }
            if (!this.h_renamed) {
                return this.k_renamed ? z_renamed : iArr;
            }
            if (this.k_renamed) {
                return x_renamed;
            }
            return w_renamed;
        }
    }

    public a_renamed(android.content.Context context, int i_renamed) {
        this(context, i_renamed, 0);
    }

    public a_renamed(android.content.Context context, int i_renamed, int i2) {
        this.e_renamed = 0;
        this.f_renamed = new com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3[]{null, null};
        this.g_renamed = new int[]{-1, -1};
        this.t_renamed = new java.util.ArrayList<>();
        this.u_renamed = 0;
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.l_renamed = displayMetrics.widthPixels;
        this.m_renamed = displayMetrics.heightPixels;
        this.f2982a = 0;
        this.f2983b = this.l_renamed / 10;
        this.d_renamed = 0;
        this.f2984c = this.f2983b;
        this.j_renamed = new java.util.ArrayList();
        this.k_renamed = new java.util.ArrayList();
        this.n_renamed = i2;
        a_renamed(context, context.getResources().getXml(i_renamed));
        b_renamed(context);
    }

    public a_renamed(android.content.Context context, int i_renamed, java.lang.CharSequence charSequence, int i2, int i3) {
        this(context, i_renamed);
        this.i_renamed = 0;
        com.coui.appcompat.widget.keyboard.a_renamed.b_renamed bVar = new com.coui.appcompat.widget.keyboard.a_renamed.b_renamed(this);
        bVar.f2989b = this.f2984c;
        bVar.f2988a = this.f2983b;
        bVar.f2990c = this.f2982a;
        bVar.d_renamed = this.d_renamed;
        bVar.f_renamed = 12;
        i2 = i2 == -1 ? Integer.MAX_VALUE : i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            char cCharAt = charSequence.charAt(i7);
            if (i5 >= i2 || this.f2983b + i6 + i3 > this.l_renamed) {
                i4 += this.d_renamed + this.f2984c;
                i5 = 0;
                i6 = 0;
            }
            com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a = new com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3(bVar);
            c0060a.i_renamed = i6;
            c0060a.j_renamed = i4;
            c0060a.f2986b = java.lang.String.valueOf(cCharAt);
            c0060a.f2985a = new int[]{cCharAt};
            i5++;
            i6 += c0060a.e_renamed + c0060a.g_renamed;
            this.j_renamed.add(c0060a);
            bVar.e_renamed.add(c0060a);
            if (i6 > this.i_renamed) {
                this.i_renamed = i6;
            }
        }
        this.h_renamed = i4 + this.f2984c;
        this.t_renamed.add(bVar);
    }

    public java.util.List<com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3> a_renamed() {
        return this.j_renamed;
    }

    public int b_renamed() {
        return this.h_renamed;
    }

    public int c_renamed() {
        return this.i_renamed;
    }

    public void a_renamed(int i_renamed) {
        for (com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a : this.f_renamed) {
            if (c0060a != null) {
                if (i_renamed == 1 || i_renamed == 2) {
                    c0060a.l_renamed = true;
                } else if (i_renamed == 0) {
                    c0060a.l_renamed = false;
                }
            }
        }
        this.e_renamed = i_renamed;
    }

    public int d_renamed() {
        return this.e_renamed;
    }

    private void f_renamed() {
        this.o_renamed = ((c_renamed() + 10) - 1) / 10;
        this.p_renamed = ((b_renamed() + 5) - 1) / 5;
        this.q_renamed = new int[50][];
        int[] iArr = new int[this.j_renamed.size()];
        int i_renamed = this.o_renamed * 10;
        int i2 = this.p_renamed * 5;
        int i3 = 0;
        while (i3 < i_renamed) {
            int i4 = 0;
            while (i4 < i2) {
                int i5 = 0;
                for (int i6 = 0; i6 < this.j_renamed.size(); i6++) {
                    com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a = this.j_renamed.get(i6);
                    if (c0060a.b_renamed(i3, i4) < this.r_renamed || c0060a.b_renamed((this.o_renamed + i3) - 1, i4) < this.r_renamed || c0060a.b_renamed((this.o_renamed + i3) - 1, (this.p_renamed + i4) - 1) < this.r_renamed || c0060a.b_renamed(i3, (this.p_renamed + i4) - 1) < this.r_renamed) {
                        iArr[i5] = i6;
                        i5++;
                    }
                }
                int[] iArr2 = new int[i5];
                java.lang.System.arraycopy(iArr, 0, iArr2, 0, i5);
                int[][] iArr3 = this.q_renamed;
                int i7 = this.p_renamed;
                iArr3[((i4 / i7) * 10) + (i3 / this.o_renamed)] = iArr2;
                i4 += i7;
            }
            i3 += this.o_renamed;
        }
    }

    public int[] a_renamed(int i_renamed, int i2) {
        int i3;
        if (this.q_renamed == null) {
            f_renamed();
        }
        if (i_renamed >= 0 && i_renamed < c_renamed() && i2 >= 0 && i2 < b_renamed() && (i3 = ((i2 / this.p_renamed) * 10) + (i_renamed / this.o_renamed)) < 50) {
            return this.q_renamed[i3];
        }
        return new int[0];
    }

    protected com.coui.appcompat.widget.keyboard.a_renamed.b_renamed a_renamed(android.content.res.Resources resources, android.content.res.XmlResourceParser xmlResourceParser) {
        return new com.coui.appcompat.widget.keyboard.a_renamed.b_renamed(resources, this, xmlResourceParser);
    }

    protected com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 a_renamed(android.content.res.Resources resources, com.coui.appcompat.widget.keyboard.a_renamed.b_renamed bVar, int i_renamed, int i2, android.content.res.XmlResourceParser xmlResourceParser) {
        return new com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3(resources, bVar, i_renamed, i2, xmlResourceParser);
    }

    private void a_renamed(android.content.Context context, android.content.res.XmlResourceParser xmlResourceParser) {
        android.content.res.Resources resources = context.getResources();
        com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a = null;
        com.coui.appcompat.widget.keyboard.a_renamed.b_renamed bVarA = null;
        boolean z_renamed = false;
        int i_renamed = 0;
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
                        java.lang.String name = xmlResourceParser.getName();
                        if ("Row".equals(name)) {
                            bVarA = a_renamed(resources, xmlResourceParser);
                            this.t_renamed.add(bVarA);
                            if ((bVarA.g_renamed == 0 || bVarA.g_renamed == this.n_renamed) ? false : true) {
                                break;
                            }
                            i3 = 0;
                            i2 = 1;
                        } else if ("Key".equals(name)) {
                            com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060aA = a_renamed(resources, bVarA, i3, i_renamed, xmlResourceParser);
                            this.j_renamed.add(c0060aA);
                            if (c0060aA.f2985a[0] == -1) {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= this.f_renamed.length) {
                                        break;
                                    }
                                    if (this.f_renamed[i4] == null) {
                                        this.f_renamed[i4] = c0060aA;
                                        this.g_renamed[i4] = this.j_renamed.size() - 1;
                                        break;
                                    }
                                    i4++;
                                }
                                this.k_renamed.add(c0060aA);
                            } else if (c0060aA.f2985a[0] == -6) {
                                this.k_renamed.add(c0060aA);
                            }
                            bVarA.e_renamed.add(c0060aA);
                            c0060a = c0060aA;
                            z_renamed = true;
                        } else if ("Keyboard".equals(name)) {
                            b_renamed(resources, xmlResourceParser);
                        }
                    } else if (next == 3) {
                        if (z_renamed) {
                            i3 += c0060a.g_renamed + c0060a.e_renamed;
                            if (i3 > this.i_renamed) {
                                this.i_renamed = i3;
                            }
                            z_renamed = false;
                        } else if (i2 != 0) {
                            i_renamed = i_renamed + bVarA.d_renamed + bVarA.f2989b;
                            i2 = 0;
                        }
                    }
                } catch (java.lang.Exception e_renamed) {
                    android.util.Log.e_renamed("SecurityKeyboard", "Parse error:" + e_renamed);
                    e_renamed.printStackTrace();
                }
            }
            a_renamed(xmlResourceParser);
            i2 = 0;
        }
        this.h_renamed = i_renamed - this.d_renamed;
    }

    private void a_renamed(android.content.res.XmlResourceParser xmlResourceParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
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

    private void b_renamed(android.content.res.Resources resources, android.content.res.XmlResourceParser xmlResourceParser) {
        android.content.res.TypedArray typedArrayObtainAttributes = resources.obtainAttributes(android.util.Xml.asAttributeSet(xmlResourceParser), coui.support.appcompat.R_renamed.styleable.SecurityKeyboard);
        int i_renamed = coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_couiKeyWidth;
        int i2 = this.l_renamed;
        this.f2983b = a_renamed(typedArrayObtainAttributes, i_renamed, i2, i2 / 10);
        this.f2984c = a_renamed(typedArrayObtainAttributes, coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_couiKeyHeight, this.m_renamed, 50);
        this.f2982a = a_renamed(typedArrayObtainAttributes, coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_couiHorizontalGap, this.l_renamed, 0);
        this.d_renamed = a_renamed(typedArrayObtainAttributes, coui.support.appcompat.R_renamed.styleable.SecurityKeyboard_couiVerticalGap, this.m_renamed, 0);
        this.r_renamed = (int) (this.f2983b * s_renamed);
        int i3 = this.r_renamed;
        this.r_renamed = i3 * i3;
        typedArrayObtainAttributes.recycle();
    }

    static int a_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2, int i3) {
        android.util.TypedValue typedValuePeekValue = typedArray.peekValue(i_renamed);
        if (typedValuePeekValue == null) {
            return i3;
        }
        if (typedValuePeekValue.type == 5) {
            return typedArray.getDimensionPixelOffset(i_renamed, i3);
        }
        return typedValuePeekValue.type == 6 ? java.lang.Math.round(typedArray.getFraction(i_renamed, i2, i2, i3)) : i3;
    }

    public int e_renamed() {
        return this.u_renamed;
    }

    public static float a_renamed(android.content.Context context) {
        int i_renamed;
        float f_renamed;
        float f2;
        int identifier = context.getResources().getIdentifier("config_lidControlsDisplayFold", "bool", "android");
        if (identifier > 0 && context.getResources().getBoolean(identifier)) {
            f_renamed = android.util.DisplayMetrics.DENSITY_DEVICE_STABLE;
            f2 = context.getResources().getDisplayMetrics().densityDpi;
        } else {
            if (context.getResources().getConfiguration().orientation == 1) {
                i_renamed = context.getResources().getDisplayMetrics().widthPixels;
            } else {
                i_renamed = context.getResources().getDisplayMetrics().heightPixels;
            }
            f_renamed = i_renamed / 360.0f;
            f2 = context.getResources().getDisplayMetrics().densityDpi / 160.0f;
        }
        return f_renamed / f2;
    }

    public void b_renamed(android.content.Context context) {
        float fA_renamed = a_renamed(context);
        int size = this.t_renamed.size();
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < size) {
            com.coui.appcompat.widget.keyboard.a_renamed.b_renamed bVar = this.t_renamed.get(i_renamed);
            int size2 = bVar.e_renamed.size();
            bVar.d_renamed = (int) (bVar.d_renamed * fA_renamed);
            bVar.f2990c = (int) (bVar.f2990c * fA_renamed);
            bVar.f2989b = (int) (bVar.f2989b * fA_renamed);
            bVar.f2988a = (int) (bVar.f2988a * fA_renamed);
            int i3 = 0;
            int i4 = i2;
            for (int i5 = 0; i5 < size2; i5++) {
                com.coui.appcompat.widget.keyboard.a_renamed.SecurityKeyboard_3 c0060a = bVar.e_renamed.get(i5);
                c0060a.g_renamed = (int) (c0060a.g_renamed * fA_renamed);
                int i6 = i3 + c0060a.g_renamed;
                c0060a.i_renamed = i6;
                c0060a.j_renamed = (int) (c0060a.j_renamed * fA_renamed);
                c0060a.e_renamed = (int) (c0060a.e_renamed * fA_renamed);
                c0060a.f_renamed = (int) (c0060a.f_renamed * fA_renamed);
                i3 = i6 + c0060a.e_renamed;
                if (i3 > i4) {
                    i4 = i3;
                }
            }
            i_renamed++;
            i2 = i4;
        }
        this.i_renamed = i2;
        this.h_renamed = (int) (this.h_renamed * fA_renamed);
    }
}
