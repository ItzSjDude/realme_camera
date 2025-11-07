package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.p029b.p030a.SupportMenu;
import androidx.core.p036h.ActionProvider;
import androidx.core.p036h.MenuItemCompat;
import com.meicam.sdk.NvsMediaFileConvertor;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater.java */
/* renamed from: androidx.appcompat.view.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {

    /* renamed from: PlatformImplementations.kt_3 */
    static final Class<?>[] f1188a = {Context.class};

    /* renamed from: IntrinsicsJvm.kt_4 */
    static final Class<?>[] f1189b = f1188a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final Object[] f1190c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    final Object[] f1191d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    Context f1192e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Object f1193f;

    public SupportMenuInflater(Context context) {
        super(context);
        this.f1192e = context;
        this.f1190c = new Object[]{context};
        this.f1191d = this.f1190c;
    }

    @Override // android.view.MenuInflater
    public void inflate(int OplusGLSurfaceView_13, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(OplusGLSurfaceView_13, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f1192e.getResources().getLayout(OplusGLSurfaceView_13);
                    m1066a(layout, Xml.asAttributeSet(layout), menu);
                } catch (XmlPullParserException COUIBaseListPopupWindow_8) {
                    throw new InflateException("Error inflating menu XML", COUIBaseListPopupWindow_8);
                }
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1066a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        int next = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (next == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (next != 2) {
                if (next == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name2.equals("group")) {
                        bVar.m1071a();
                    } else if (name2.equals("item")) {
                        if (!bVar.m1076d()) {
                            if (bVar.f1203a != null && bVar.f1203a.mo1189c()) {
                                bVar.m1075c();
                            } else {
                                bVar.m1073b();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.m1072a(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.m1074b(attributeSet);
                } else if (name3.equals("menu")) {
                    m1066a(xmlPullParser, attributeSet, bVar.m1075c());
                } else {
                    z2 = true;
                    str = name3;
                }
            }
            next = xmlPullParser.next();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Object m1067a() {
        if (this.f1193f == null) {
            this.f1193f = m1065a(this.f1192e);
        }
        return this.f1193f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Object m1065a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m1065a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: androidx.appcompat.view.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 implements MenuItem.OnMenuItemClickListener {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final Class<?>[] f1194a = {MenuItem.class};

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Object f1195b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Method f1196c;

        public PlatformImplementations.kt_3(Object obj, String str) {
            this.f1195b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1196c = cls.getMethod(str, f1194a);
            } catch (Exception COUIBaseListPopupWindow_8) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(COUIBaseListPopupWindow_8);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                if (this.f1196c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1196c.invoke(this.f1195b, menuItem)).booleanValue();
                }
                this.f1196c.invoke(this.f1195b, menuItem);
                return true;
            } catch (Exception COUIBaseListPopupWindow_8) {
                throw new RuntimeException(COUIBaseListPopupWindow_8);
            }
        }
    }

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: androidx.appcompat.view.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 {

        /* renamed from: A */
        private String f1197A;

        /* renamed from: B */
        private String f1198B;

        /* renamed from: C */
        private CharSequence f1199C;

        /* renamed from: D */
        private CharSequence f1200D;

        /* renamed from: E */
        private ColorStateList f1201E = null;

        /* renamed from: F */
        private PorterDuff.Mode f1202F = null;

        /* renamed from: PlatformImplementations.kt_3 */
        ActionProvider f1203a;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Menu f1205c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f1206d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f1207e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f1208f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int f1209g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private boolean f1210h;

        /* renamed from: OplusGLSurfaceView_13 */
        private boolean f1211i;

        /* renamed from: OplusGLSurfaceView_15 */
        private boolean f1212j;

        /* renamed from: OplusGLSurfaceView_5 */
        private int f1213k;

        /* renamed from: OplusGLSurfaceView_14 */
        private int f1214l;

        /* renamed from: OplusGLSurfaceView_6 */
        private CharSequence f1215m;

        /* renamed from: OplusGLSurfaceView_11 */
        private CharSequence f1216n;

        /* renamed from: o */
        private int f1217o;

        /* renamed from: p */
        private char f1218p;

        /* renamed from: q */
        private int f1219q;

        /* renamed from: r */
        private char f1220r;

        /* renamed from: s */
        private int f1221s;

        /* renamed from: t */
        private int f1222t;

        /* renamed from: u */
        private boolean f1223u;

        /* renamed from: v */
        private boolean f1224v;

        /* renamed from: w */
        private boolean f1225w;

        /* renamed from: x */
        private int f1226x;

        /* renamed from: y */
        private int f1227y;

        /* renamed from: z */
        private String f1228z;

        public IntrinsicsJvm.kt_4(Menu menu) {
            this.f1205c = menu;
            m1071a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m1071a() {
            this.f1206d = 0;
            this.f1207e = 0;
            this.f1208f = 0;
            this.f1209g = 0;
            this.f1210h = true;
            this.f1211i = true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m1072a(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = SupportMenuInflater.this.f1192e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f1206d = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f1207e = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f1208f = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f1209g = typedArrayObtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f1210h = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f1211i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m1074b(AttributeSet attributeSet) {
            TintTypedArray c0322arM1540a = TintTypedArray.m1540a(SupportMenuInflater.this.f1192e, attributeSet, R.styleable.MenuItem);
            this.f1213k = c0322arM1540a.m1560g(R.styleable.MenuItem_android_id, 0);
            this.f1214l = (c0322arM1540a.m1544a(R.styleable.MenuItem_android_menuCategory, this.f1207e) & (-65536)) | (c0322arM1540a.m1544a(R.styleable.MenuItem_android_orderInCategory, this.f1208f) & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN);
            this.f1215m = c0322arM1540a.m1553c(R.styleable.MenuItem_android_title);
            this.f1216n = c0322arM1540a.m1553c(R.styleable.MenuItem_android_titleCondensed);
            this.f1217o = c0322arM1540a.m1560g(R.styleable.MenuItem_android_icon, 0);
            this.f1218p = m1068a(c0322arM1540a.m1555d(R.styleable.MenuItem_android_alphabeticShortcut));
            this.f1219q = c0322arM1540a.m1544a(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.f1220r = m1068a(c0322arM1540a.m1555d(R.styleable.MenuItem_android_numericShortcut));
            this.f1221s = c0322arM1540a.m1544a(R.styleable.MenuItem_numericModifiers, 4096);
            if (c0322arM1540a.m1561g(R.styleable.MenuItem_android_checkable)) {
                this.f1222t = c0322arM1540a.m1547a(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1222t = this.f1209g;
            }
            this.f1223u = c0322arM1540a.m1547a(R.styleable.MenuItem_android_checked, false);
            this.f1224v = c0322arM1540a.m1547a(R.styleable.MenuItem_android_visible, this.f1210h);
            this.f1225w = c0322arM1540a.m1547a(R.styleable.MenuItem_android_enabled, this.f1211i);
            this.f1226x = c0322arM1540a.m1544a(R.styleable.MenuItem_showAsAction, -1);
            this.f1198B = c0322arM1540a.m1555d(R.styleable.MenuItem_android_onClick);
            this.f1227y = c0322arM1540a.m1560g(R.styleable.MenuItem_actionLayout, 0);
            this.f1228z = c0322arM1540a.m1555d(R.styleable.MenuItem_actionViewClass);
            this.f1197A = c0322arM1540a.m1555d(R.styleable.MenuItem_actionProviderClass);
            boolean z = this.f1197A != null;
            if (z && this.f1227y == 0 && this.f1228z == null) {
                this.f1203a = (ActionProvider) m1069a(this.f1197A, SupportMenuInflater.f1189b, SupportMenuInflater.this.f1191d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1203a = null;
            }
            this.f1199C = c0322arM1540a.m1553c(R.styleable.MenuItem_contentDescription);
            this.f1200D = c0322arM1540a.m1553c(R.styleable.MenuItem_tooltipText);
            if (c0322arM1540a.m1561g(R.styleable.MenuItem_iconTintMode)) {
                this.f1202F = DrawableUtils.m1394a(c0322arM1540a.m1544a(R.styleable.MenuItem_iconTintMode, -1), this.f1202F);
            } else {
                this.f1202F = null;
            }
            if (c0322arM1540a.m1561g(R.styleable.MenuItem_iconTint)) {
                this.f1201E = c0322arM1540a.m1557e(R.styleable.MenuItem_iconTint);
            } else {
                this.f1201E = null;
            }
            c0322arM1540a.m1551b();
            this.f1212j = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private char m1068a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m1070a(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            boolean z = false;
            menuItem.setChecked(this.f1223u).setVisible(this.f1224v).setEnabled(this.f1225w).setCheckable(this.f1222t >= 1).setTitleCondensed(this.f1216n).setIcon(this.f1217o);
            int OplusGLSurfaceView_13 = this.f1226x;
            if (OplusGLSurfaceView_13 >= 0) {
                menuItem.setShowAsAction(OplusGLSurfaceView_13);
            }
            if (this.f1198B != null) {
                if (SupportMenuInflater.this.f1192e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within PlatformImplementations.kt_3 restricted context");
                }
                menuItem.setOnMenuItemClickListener(new PlatformImplementations.kt_3(SupportMenuInflater.this.m1067a(), this.f1198B));
            }
            boolean z2 = menuItem instanceof MenuItemImpl;
            if (z2) {
            }
            if (this.f1222t >= 2) {
                if (z2) {
                    ((MenuItemImpl) menuItem).m1166a(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).m1185a(true);
                }
            }
            String str = this.f1228z;
            if (str != null) {
                menuItem.setActionView((View) m1069a(str, SupportMenuInflater.f1188a, SupportMenuInflater.this.f1190c));
                z = true;
            }
            int i2 = this.f1227y;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider abstractC0491b = this.f1203a;
            if (abstractC0491b != null) {
                MenuItemCompat.m2787a(menuItem, abstractC0491b);
            }
            MenuItemCompat.m2791a(menuItem, this.f1199C);
            MenuItemCompat.m2793b(menuItem, this.f1200D);
            MenuItemCompat.m2792b(menuItem, this.f1218p, this.f1219q);
            MenuItemCompat.m2788a(menuItem, this.f1220r, this.f1221s);
            PorterDuff.Mode mode = this.f1202F;
            if (mode != null) {
                MenuItemCompat.m2790a(menuItem, mode);
            }
            ColorStateList colorStateList = this.f1201E;
            if (colorStateList != null) {
                MenuItemCompat.m2789a(menuItem, colorStateList);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m1073b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f1212j = true;
            m1070a(this.f1205c.add(this.f1206d, this.f1213k, this.f1214l, this.f1215m));
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public SubMenu m1075c() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f1212j = true;
            SubMenu subMenuAddSubMenu = this.f1205c.addSubMenu(this.f1206d, this.f1213k, this.f1214l, this.f1215m);
            m1070a(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean m1076d() {
            return this.f1212j;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private <T> T m1069a(String str, Class<?>[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.f1192e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception COUIBaseListPopupWindow_8) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, COUIBaseListPopupWindow_8);
                return null;
            }
        }
    }
}
