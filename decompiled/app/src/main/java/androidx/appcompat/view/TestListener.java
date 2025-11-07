package androidx.appcompat.view;

/* compiled from: SupportMenuInflater.java */
/* loaded from: classes.dex */
public class g_renamed extends android.view.MenuInflater {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final java.lang.Class<?>[] f335a = {android.content.Context.class};

    /* renamed from: b_renamed, reason: collision with root package name */
    static final java.lang.Class<?>[] f336b = f335a;

    /* renamed from: c_renamed, reason: collision with root package name */
    final java.lang.Object[] f337c;
    final java.lang.Object[] d_renamed;
    android.content.Context e_renamed;
    private java.lang.Object f_renamed;

    public g_renamed(android.content.Context context) {
        super(context);
        this.e_renamed = context;
        this.f337c = new java.lang.Object[]{context};
        this.d_renamed = this.f337c;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i_renamed, android.view.Menu menu) {
        if (!(menu instanceof androidx.core.b_renamed.a_renamed.a_renamed)) {
            super.inflate(i_renamed, menu);
            return;
        }
        android.content.res.XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.e_renamed.getResources().getLayout(i_renamed);
                    a_renamed(layout, android.util.Xml.asAttributeSet(layout), menu);
                } catch (org.xmlpull.v1.XmlPullParserException e_renamed) {
                    throw new android.view.InflateException("Error inflating menu XML", e_renamed);
                }
            } catch (java.io.IOException e2) {
                throw new android.view.InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }

    private void a_renamed(org.xmlpull.v1.XmlPullParser xmlPullParser, android.util.AttributeSet attributeSet, android.view.Menu menu) throws org.xmlpull.v1.XmlPullParserException, java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        androidx.appcompat.view.g_renamed.b_renamed bVar = new androidx.appcompat.view.g_renamed.b_renamed(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                java.lang.String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new java.lang.RuntimeException("Expecting menu, got " + name);
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        int next = eventType;
        java.lang.String str = null;
        boolean z_renamed = false;
        boolean z2 = false;
        while (!z_renamed) {
            if (next == 1) {
                throw new java.lang.RuntimeException("Unexpected end of_renamed document");
            }
            if (next != 2) {
                if (next == 3) {
                    java.lang.String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name2.equals("group")) {
                        bVar.a_renamed();
                    } else if (name2.equals("item")) {
                        if (!bVar.d_renamed()) {
                            if (bVar.f341a != null && bVar.f341a.c_renamed()) {
                                bVar.c_renamed();
                            } else {
                                bVar.b_renamed();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z_renamed = true;
                    }
                }
            } else if (!z2) {
                java.lang.String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.a_renamed(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.b_renamed(attributeSet);
                } else if (name3.equals("menu")) {
                    a_renamed(xmlPullParser, attributeSet, bVar.c_renamed());
                } else {
                    z2 = true;
                    str = name3;
                }
            }
            next = xmlPullParser.next();
        }
    }

    java.lang.Object a_renamed() {
        if (this.f_renamed == null) {
            this.f_renamed = a_renamed(this.e_renamed);
        }
        return this.f_renamed;
    }

    private java.lang.Object a_renamed(java.lang.Object obj) {
        return (!(obj instanceof android.app.Activity) && (obj instanceof android.content.ContextWrapper)) ? a_renamed(((android.content.ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* compiled from: SupportMenuInflater.java */
    private static class a_renamed implements android.view.MenuItem.OnMenuItemClickListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final java.lang.Class<?>[] f338a = {android.view.MenuItem.class};

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.Object f339b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.lang.reflect.Method f340c;

        public a_renamed(java.lang.Object obj, java.lang.String str) {
            this.f339b = obj;
            java.lang.Class<?> cls = obj.getClass();
            try {
                this.f340c = cls.getMethod(str, f338a);
            } catch (java.lang.Exception e_renamed) {
                android.view.InflateException inflateException = new android.view.InflateException("Couldn't_renamed resolve menu item onClick handler " + str + " in_renamed class " + cls.getName());
                inflateException.initCause(e_renamed);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(android.view.MenuItem menuItem) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            try {
                if (this.f340c.getReturnType() == java.lang.Boolean.TYPE) {
                    return ((java.lang.Boolean) this.f340c.invoke(this.f339b, menuItem)).booleanValue();
                }
                this.f340c.invoke(this.f339b, menuItem);
                return true;
            } catch (java.lang.Exception e_renamed) {
                throw new java.lang.RuntimeException(e_renamed);
            }
        }
    }

    /* compiled from: SupportMenuInflater.java */
    private class b_renamed {
        private java.lang.String A_renamed;
        private java.lang.String B_renamed;
        private java.lang.CharSequence C_renamed;
        private java.lang.CharSequence D_renamed;
        private android.content.res.ColorStateList E_renamed = null;
        private android.graphics.PorterDuff.Mode F_renamed = null;

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.core.h_renamed.b_renamed f341a;

        /* renamed from: c_renamed, reason: collision with root package name */
        private android.view.Menu f343c;
        private int d_renamed;
        private int e_renamed;
        private int f_renamed;
        private int g_renamed;
        private boolean h_renamed;
        private boolean i_renamed;
        private boolean j_renamed;
        private int k_renamed;
        private int l_renamed;
        private java.lang.CharSequence m_renamed;
        private java.lang.CharSequence n_renamed;
        private int o_renamed;
        private char p_renamed;
        private int q_renamed;
        private char r_renamed;
        private int s_renamed;
        private int t_renamed;
        private boolean u_renamed;
        private boolean v_renamed;
        private boolean w_renamed;
        private int x_renamed;
        private int y_renamed;
        private java.lang.String z_renamed;

        public b_renamed(android.view.Menu menu) {
            this.f343c = menu;
            a_renamed();
        }

        public void a_renamed() {
            this.d_renamed = 0;
            this.e_renamed = 0;
            this.f_renamed = 0;
            this.g_renamed = 0;
            this.h_renamed = true;
            this.i_renamed = true;
        }

        public void a_renamed(android.util.AttributeSet attributeSet) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = androidx.appcompat.view.g_renamed.this.e_renamed.obtainStyledAttributes(attributeSet, androidx.appcompat.R_renamed.styleable.MenuGroup);
            this.d_renamed = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.MenuGroup_android_id, 0);
            this.e_renamed = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.R_renamed.styleable.MenuGroup_android_menuCategory, 0);
            this.f_renamed = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.R_renamed.styleable.MenuGroup_android_orderInCategory, 0);
            this.g_renamed = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.R_renamed.styleable.MenuGroup_android_checkableBehavior, 0);
            this.h_renamed = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R_renamed.styleable.MenuGroup_android_visible, true);
            this.i_renamed = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R_renamed.styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void b_renamed(android.util.AttributeSet attributeSet) {
            androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(androidx.appcompat.view.g_renamed.this.e_renamed, attributeSet, androidx.appcompat.R_renamed.styleable.MenuItem);
            this.k_renamed = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_id, 0);
            this.l_renamed = (arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_menuCategory, this.e_renamed) & (-65536)) | (arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_orderInCategory, this.f_renamed) & com.meicam.sdk.NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN);
            this.m_renamed = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_title);
            this.n_renamed = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_titleCondensed);
            this.o_renamed = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_icon, 0);
            this.p_renamed = a_renamed(arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_alphabeticShortcut));
            this.q_renamed = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_alphabeticModifiers, 4096);
            this.r_renamed = a_renamed(arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_numericShortcut));
            this.s_renamed = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_numericModifiers, 4096);
            if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_checkable)) {
                this.t_renamed = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.t_renamed = this.g_renamed;
            }
            this.u_renamed = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_checked, false);
            this.v_renamed = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_visible, this.h_renamed);
            this.w_renamed = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_enabled, this.i_renamed);
            this.x_renamed = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_showAsAction, -1);
            this.B_renamed = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_android_onClick);
            this.y_renamed = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_actionLayout, 0);
            this.z_renamed = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_actionViewClass);
            this.A_renamed = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_actionProviderClass);
            boolean z_renamed = this.A_renamed != null;
            if (z_renamed && this.y_renamed == 0 && this.z_renamed == null) {
                this.f341a = (androidx.core.h_renamed.b_renamed) a_renamed(this.A_renamed, androidx.appcompat.view.g_renamed.f336b, androidx.appcompat.view.g_renamed.this.d_renamed);
            } else {
                if (z_renamed) {
                    android.util.Log.w_renamed("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f341a = null;
            }
            this.C_renamed = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_contentDescription);
            this.D_renamed = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_tooltipText);
            if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_iconTintMode)) {
                this.F_renamed = androidx.appcompat.widget.aa_renamed.a_renamed(arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_iconTintMode, -1), this.F_renamed);
            } else {
                this.F_renamed = null;
            }
            if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_iconTint)) {
                this.E_renamed = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.MenuItem_iconTint);
            } else {
                this.E_renamed = null;
            }
            arVarA.b_renamed();
            this.j_renamed = false;
        }

        private char a_renamed(java.lang.String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private void a_renamed(android.view.MenuItem menuItem) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            boolean z_renamed = false;
            menuItem.setChecked(this.u_renamed).setVisible(this.v_renamed).setEnabled(this.w_renamed).setCheckable(this.t_renamed >= 1).setTitleCondensed(this.n_renamed).setIcon(this.o_renamed);
            int i_renamed = this.x_renamed;
            if (i_renamed >= 0) {
                menuItem.setShowAsAction(i_renamed);
            }
            if (this.B_renamed != null) {
                if (androidx.appcompat.view.g_renamed.this.e_renamed.isRestricted()) {
                    throw new java.lang.IllegalStateException("The android:onClick attribute cannot be_renamed used within a_renamed restricted context");
                }
                menuItem.setOnMenuItemClickListener(new androidx.appcompat.view.g_renamed.a_renamed(androidx.appcompat.view.g_renamed.this.a_renamed(), this.B_renamed));
            }
            boolean z2 = menuItem instanceof androidx.appcompat.view.menu.j_renamed;
            if (z2) {
            }
            if (this.t_renamed >= 2) {
                if (z2) {
                    ((androidx.appcompat.view.menu.j_renamed) menuItem).a_renamed(true);
                } else if (menuItem instanceof androidx.appcompat.view.menu.k_renamed) {
                    ((androidx.appcompat.view.menu.k_renamed) menuItem).a_renamed(true);
                }
            }
            java.lang.String str = this.z_renamed;
            if (str != null) {
                menuItem.setActionView((android.view.View) a_renamed(str, androidx.appcompat.view.g_renamed.f335a, androidx.appcompat.view.g_renamed.this.f337c));
                z_renamed = true;
            }
            int i2 = this.y_renamed;
            if (i2 > 0) {
                if (!z_renamed) {
                    menuItem.setActionView(i2);
                } else {
                    android.util.Log.w_renamed("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            androidx.core.h_renamed.b_renamed bVar = this.f341a;
            if (bVar != null) {
                androidx.core.h_renamed.g_renamed.a_renamed(menuItem, bVar);
            }
            androidx.core.h_renamed.g_renamed.a_renamed(menuItem, this.C_renamed);
            androidx.core.h_renamed.g_renamed.b_renamed(menuItem, this.D_renamed);
            androidx.core.h_renamed.g_renamed.b_renamed(menuItem, this.p_renamed, this.q_renamed);
            androidx.core.h_renamed.g_renamed.a_renamed(menuItem, this.r_renamed, this.s_renamed);
            android.graphics.PorterDuff.Mode mode = this.F_renamed;
            if (mode != null) {
                androidx.core.h_renamed.g_renamed.a_renamed(menuItem, mode);
            }
            android.content.res.ColorStateList colorStateList = this.E_renamed;
            if (colorStateList != null) {
                androidx.core.h_renamed.g_renamed.a_renamed(menuItem, colorStateList);
            }
        }

        public void b_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            this.j_renamed = true;
            a_renamed(this.f343c.add(this.d_renamed, this.k_renamed, this.l_renamed, this.m_renamed));
        }

        public android.view.SubMenu c_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            this.j_renamed = true;
            android.view.SubMenu subMenuAddSubMenu = this.f343c.addSubMenu(this.d_renamed, this.k_renamed, this.l_renamed, this.m_renamed);
            a_renamed(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d_renamed() {
            return this.j_renamed;
        }

        private <T_renamed> T_renamed a_renamed(java.lang.String str, java.lang.Class<?>[] clsArr, java.lang.Object[] objArr) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
            try {
                java.lang.reflect.Constructor<?> constructor = java.lang.Class.forName(str, false, androidx.appcompat.view.g_renamed.this.e_renamed.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T_renamed) constructor.newInstance(objArr);
            } catch (java.lang.Exception e_renamed) {
                android.util.Log.w_renamed("SupportMenuInflater", "Cannot instantiate class: " + str, e_renamed);
                return null;
            }
        }
    }
}
