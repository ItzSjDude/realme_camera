package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p029b.p030a.SupportMenuItem;
import androidx.core.p036h.ActionProvider;

/* compiled from: MenuItemImpl.java */
/* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public final class MenuItemImpl implements SupportMenuItem {

    /* renamed from: A */
    private View f1366A;

    /* renamed from: B */
    private ActionProvider f1367B;

    /* renamed from: C */
    private MenuItem.OnActionExpandListener f1368C;

    /* renamed from: E */
    private ContextMenu.ContextMenuInfo f1370E;

    /* renamed from: PlatformImplementations.kt_3 */
    MenuBuilder f1371a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f1372b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f1373c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f1374d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f1375e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CharSequence f1376f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CharSequence f1377g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Intent f1378h;

    /* renamed from: OplusGLSurfaceView_13 */
    private char f1379i;

    /* renamed from: OplusGLSurfaceView_5 */
    private char f1381k;

    /* renamed from: OplusGLSurfaceView_6 */
    private Drawable f1383m;

    /* renamed from: o */
    private SubMenuBuilder f1385o;

    /* renamed from: p */
    private Runnable f1386p;

    /* renamed from: q */
    private MenuItem.OnMenuItemClickListener f1387q;

    /* renamed from: r */
    private CharSequence f1388r;

    /* renamed from: s */
    private CharSequence f1389s;

    /* renamed from: z */
    private int f1396z;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f1380j = 4096;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f1382l = 4096;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f1384n = 0;

    /* renamed from: t */
    private ColorStateList f1390t = null;

    /* renamed from: u */
    private PorterDuff.Mode f1391u = null;

    /* renamed from: v */
    private boolean f1392v = false;

    /* renamed from: w */
    private boolean f1393w = false;

    /* renamed from: x */
    private boolean f1394x = false;

    /* renamed from: y */
    private int f1395y = 16;

    /* renamed from: D */
    private boolean f1369D = false;

    MenuItemImpl(MenuBuilder c0236h, int OplusGLSurfaceView_13, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1396z = 0;
        this.f1371a = c0236h;
        this.f1372b = i2;
        this.f1373c = OplusGLSurfaceView_13;
        this.f1374d = i3;
        this.f1375e = i4;
        this.f1376f = charSequence;
        this.f1396z = i5;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m1169b() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1387q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder c0236h = this.f1371a;
        if (c0236h.dispatchMenuItemSelected(c0236h, this)) {
            return true;
        }
        Runnable runnable = this.f1386p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1378h != null) {
            try {
                this.f1371a.getContext().startActivity(this.f1378h);
                return true;
            } catch (ActivityNotFoundException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("MenuItemImpl", "Can't find activity to handle intent; ignoring", COUIBaseListPopupWindow_8);
            }
        }
        ActionProvider abstractC0491b = this.f1367B;
        return abstractC0491b != null && abstractC0491b.mo1188b();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1395y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1395y |= 16;
        } else {
            this.f1395y &= -17;
        }
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1373c;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1372b;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1374d;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m1170c() {
        return this.f1375e;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1378h;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1378h = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1381k;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f1381k == c2) {
            return this;
        }
        this.f1381k = Character.toLowerCase(c2);
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int OplusGLSurfaceView_13) {
        if (this.f1381k == c2 && this.f1382l == OplusGLSurfaceView_13) {
            return this;
        }
        this.f1381k = Character.toLowerCase(c2);
        this.f1382l = KeyEvent.normalizeMetaState(OplusGLSurfaceView_13);
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1382l;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1379i;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1380j;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.f1379i == c2) {
            return this;
        }
        this.f1379i = c2;
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int OplusGLSurfaceView_13) {
        if (this.f1379i == c2 && this.f1380j == OplusGLSurfaceView_13) {
            return this;
        }
        this.f1379i = c2;
        this.f1380j = KeyEvent.normalizeMetaState(OplusGLSurfaceView_13);
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f1379i = c2;
        this.f1381k = Character.toLowerCase(c3);
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int OplusGLSurfaceView_13, int i2) {
        this.f1379i = c2;
        this.f1380j = KeyEvent.normalizeMetaState(OplusGLSurfaceView_13);
        this.f1381k = Character.toLowerCase(c3);
        this.f1382l = KeyEvent.normalizeMetaState(i2);
        this.f1371a.onItemsChanged(false);
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    char m1172d() {
        return this.f1371a.isQwertyMode() ? this.f1381k : this.f1379i;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    String m1174e() {
        char cM1172d = m1172d();
        if (cM1172d == 0) {
            return "";
        }
        Resources resources = this.f1371a.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f1371a.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        int OplusGLSurfaceView_13 = this.f1371a.isQwertyMode() ? this.f1382l : this.f1380j;
        m1160a(sb, OplusGLSurfaceView_13, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        m1160a(sb, OplusGLSurfaceView_13, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        m1160a(sb, OplusGLSurfaceView_13, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        m1160a(sb, OplusGLSurfaceView_13, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        m1160a(sb, OplusGLSurfaceView_13, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        m1160a(sb, OplusGLSurfaceView_13, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (cM1172d == '\IntrinsicsJvm.kt_4') {
            sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        } else if (cM1172d == '\OplusGLSurfaceView_11') {
            sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
        } else if (cM1172d == ' ') {
            sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        } else {
            sb.append(cM1172d);
        }
        return sb.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m1160a(StringBuilder sb, int OplusGLSurfaceView_13, int i2, String str) {
        if ((OplusGLSurfaceView_13 & i2) == i2) {
            sb.append(str);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean m1176f() {
        return this.f1371a.isShortcutsVisible() && m1172d() != 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1385o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1385o != null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1165a(SubMenuBuilder subMenuC0247s) {
        this.f1385o = subMenuC0247s;
        subMenuC0247s.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1376f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    CharSequence m1163a(MenuView.PlatformImplementations.kt_3 aVar) {
        if (aVar != null && aVar.prefersCondensedTitle()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1376f = charSequence;
        this.f1371a.onItemsChanged(false);
        SubMenuBuilder subMenuC0247s = this.f1385o;
        if (subMenuC0247s != null) {
            subMenuC0247s.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int OplusGLSurfaceView_13) {
        return setTitle(this.f1371a.getContext().getString(OplusGLSurfaceView_13));
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1377g;
        if (charSequence == null) {
            charSequence = this.f1376f;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1377g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1376f;
        }
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1383m;
        if (drawable != null) {
            return m1159a(drawable);
        }
        if (this.f1384n == 0) {
            return null;
        }
        Drawable drawableM732b = AppCompatResources.m732b(this.f1371a.getContext(), this.f1384n);
        this.f1384n = 0;
        this.f1383m = drawableM732b;
        return m1159a(drawableM732b);
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1384n = 0;
        this.f1383m = drawable;
        this.f1394x = true;
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int OplusGLSurfaceView_13) {
        this.f1383m = null;
        this.f1384n = OplusGLSurfaceView_13;
        this.f1394x = true;
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1390t = colorStateList;
        this.f1392v = true;
        this.f1394x = true;
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1390t;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1391u = mode;
        this.f1393w = true;
        this.f1394x = true;
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1391u;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m1159a(Drawable drawable) {
        if (drawable != null && this.f1394x && (this.f1392v || this.f1393w)) {
            drawable = DrawableCompat.m2581g(drawable).mutate();
            if (this.f1392v) {
                DrawableCompat.m2570a(drawable, this.f1390t);
            }
            if (this.f1393w) {
                DrawableCompat.m2573a(drawable, this.f1391u);
            }
            this.f1394x = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1395y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int OplusGLSurfaceView_13 = this.f1395y;
        this.f1395y = (z ? 1 : 0) | (OplusGLSurfaceView_13 & (-2));
        if (OplusGLSurfaceView_13 != this.f1395y) {
            this.f1371a.onItemsChanged(false);
        }
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1166a(boolean z) {
        this.f1395y = (z ? 4 : 0) | (this.f1395y & (-5));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m1177g() {
        return (this.f1395y & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1395y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.f1395y & 4) != 0) {
            this.f1371a.setExclusiveItemChecked(this);
        } else {
            m1168b(z);
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m1168b(boolean z) {
        int OplusGLSurfaceView_13 = this.f1395y;
        this.f1395y = (z ? 2 : 0) | (OplusGLSurfaceView_13 & (-3));
        if (OplusGLSurfaceView_13 != this.f1395y) {
            this.f1371a.onItemsChanged(false);
        }
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        ActionProvider abstractC0491b = this.f1367B;
        return (abstractC0491b == null || !abstractC0491b.mo1192d()) ? (this.f1395y & 8) == 0 : (this.f1395y & 8) == 0 && this.f1367B.mo1193e();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean m1171c(boolean z) {
        int OplusGLSurfaceView_13 = this.f1395y;
        this.f1395y = (z ? 0 : 8) | (OplusGLSurfaceView_13 & (-9));
        return OplusGLSurfaceView_13 != this.f1395y;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m1171c(z)) {
            this.f1371a.onItemVisibleChanged(this);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1387q = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f1376f;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1164a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1370E = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1370E;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m1178h() {
        this.f1371a.onItemActionRequestChanged(this);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m1179i() {
        return this.f1371a.getOptionalIconsVisible();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m1180j() {
        return (this.f1395y & 32) == 32;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m1181k() {
        return (this.f1396z & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.f1396z & 2) == 2;
    }

    public boolean requiresOverflow() {
        return (requiresActionButton() || m1181k()) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m1173d(boolean z) {
        if (z) {
            this.f1395y |= 32;
        } else {
            this.f1395y &= -33;
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m1182l() {
        return (this.f1396z & 4) == 4;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1396z = OplusGLSurfaceView_13;
        this.f1371a.onItemActionRequestChanged(this);
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(View view) {
        int OplusGLSurfaceView_13;
        this.f1366A = view;
        this.f1367B = null;
        if (view != null && view.getId() == -1 && (OplusGLSurfaceView_13 = this.f1372b) > 0) {
            view.setId(OplusGLSurfaceView_13);
        }
        this.f1371a.onItemActionRequestChanged(this);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(int OplusGLSurfaceView_13) {
        Context context = this.f1371a.getContext();
        setActionView(LayoutInflater.from(context).inflate(OplusGLSurfaceView_13, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        View view = this.f1366A;
        if (view != null) {
            return view;
        }
        ActionProvider abstractC0491b = this.f1367B;
        if (abstractC0491b == null) {
            return null;
        }
        this.f1366A = abstractC0491b.mo1190a(this);
        return this.f1366A;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem
    /* renamed from: PlatformImplementations.kt_3 */
    public ActionProvider mo1099a() {
        return this.f1367B;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem
    /* renamed from: PlatformImplementations.kt_3 */
    public SupportMenuItem mo1097a(ActionProvider abstractC0491b) {
        ActionProvider abstractC0491b2 = this.f1367B;
        if (abstractC0491b2 != null) {
            abstractC0491b2.m2770f();
        }
        this.f1366A = null;
        this.f1367B = abstractC0491b;
        this.f1371a.onItemsChanged(true);
        ActionProvider abstractC0491b3 = this.f1367B;
        if (abstractC0491b3 != null) {
            abstractC0491b3.mo1191a(new ActionProvider.IntrinsicsJvm.kt_4() { // from class: androidx.appcompat.view.menu.OplusGLSurfaceView_15.1
                @Override // androidx.core.p036h.ActionProvider.IntrinsicsJvm.kt_4
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo1184a(boolean z) {
                    MenuItemImpl.this.f1371a.onItemVisibleChanged(MenuItemImpl.this);
                }
            });
        }
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setShowAsActionFlags(int OplusGLSurfaceView_13) {
        setShowAsAction(OplusGLSurfaceView_13);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        if (!m1183m()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1368C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1371a.expandItemActionView(this);
        }
        return false;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1396z & 8) == 0) {
            return false;
        }
        if (this.f1366A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1368C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1371a.collapseItemActionView(this);
        }
        return false;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m1183m() {
        ActionProvider abstractC0491b;
        if ((this.f1396z & 8) == 0) {
            return false;
        }
        if (this.f1366A == null && (abstractC0491b = this.f1367B) != null) {
            this.f1366A = abstractC0491b.mo1190a(this);
        }
        return this.f1366A != null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m1175e(boolean z) {
        this.f1369D = z;
        this.f1371a.onItemsChanged(false);
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1369D;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1368C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f1388r = charSequence;
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1388r;
    }

    @Override // android.view.MenuItem
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f1389s = charSequence;
        this.f1371a.onItemsChanged(false);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1389s;
    }
}
