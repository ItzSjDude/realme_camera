package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p027a.ContextCompat;
import androidx.core.p029b.p030a.SupportMenuItem;
import androidx.core.p036h.ActionProvider;

/* compiled from: ActionMenuItem.java */
/* renamed from: androidx.appcompat.view.menu.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class ActionMenuItem implements SupportMenuItem {

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f1260a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f1261b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f1262c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f1263d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CharSequence f1264e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CharSequence f1265f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Intent f1266g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private char f1267h;

    /* renamed from: OplusGLSurfaceView_15 */
    private char f1269j;

    /* renamed from: OplusGLSurfaceView_14 */
    private Drawable f1271l;

    /* renamed from: OplusGLSurfaceView_11 */
    private Context f1273n;

    /* renamed from: o */
    private MenuItem.OnMenuItemClickListener f1274o;

    /* renamed from: p */
    private CharSequence f1275p;

    /* renamed from: q */
    private CharSequence f1276q;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f1268i = 4096;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f1270k = 4096;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f1272m = 0;

    /* renamed from: r */
    private ColorStateList f1277r = null;

    /* renamed from: s */
    private PorterDuff.Mode f1278s = null;

    /* renamed from: t */
    private boolean f1279t = false;

    /* renamed from: u */
    private boolean f1280u = false;

    /* renamed from: v */
    private int f1281v = 16;

    @Override // androidx.core.p029b.p030a.SupportMenuItem
    /* renamed from: PlatformImplementations.kt_3 */
    public ActionProvider mo1099a() {
        return null;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean requiresActionButton() {
        return true;
    }

    public boolean requiresOverflow() {
        return false;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int OplusGLSurfaceView_13) {
    }

    public ActionMenuItem(Context context, int OplusGLSurfaceView_13, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1273n = context;
        this.f1260a = i2;
        this.f1261b = OplusGLSurfaceView_13;
        this.f1262c = i3;
        this.f1263d = i4;
        this.f1264e = charSequence;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1269j;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1270k;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1261b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1271l;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1266g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1260a;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1267h;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1268i;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1263d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1264e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1265f;
        return charSequence != null ? charSequence : this.f1264e;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1281v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1281v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1281v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f1281v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f1269j = Character.toLowerCase(c2);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int OplusGLSurfaceView_13) {
        this.f1269j = Character.toLowerCase(c2);
        this.f1270k = KeyEvent.normalizeMetaState(OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f1281v = (z ? 1 : 0) | (this.f1281v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f1281v = (z ? 2 : 0) | (this.f1281v & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f1281v = (z ? 16 : 0) | (this.f1281v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1271l = drawable;
        this.f1272m = 0;
        m1094b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int OplusGLSurfaceView_13) {
        this.f1272m = OplusGLSurfaceView_13;
        this.f1271l = ContextCompat.m2248a(this.f1273n, OplusGLSurfaceView_13);
        m1094b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1266g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f1267h = c2;
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int OplusGLSurfaceView_13) {
        this.f1267h = c2;
        this.f1268i = KeyEvent.normalizeMetaState(OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1274o = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f1267h = c2;
        this.f1269j = Character.toLowerCase(c3);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int OplusGLSurfaceView_13, int i2) {
        this.f1267h = c2;
        this.f1268i = KeyEvent.normalizeMetaState(OplusGLSurfaceView_13);
        this.f1269j = Character.toLowerCase(c3);
        this.f1270k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1264e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int OplusGLSurfaceView_13) {
        this.f1264e = this.f1273n.getResources().getString(OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1265f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.f1281v = (this.f1281v & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setActionView(int OplusGLSurfaceView_13) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem
    /* renamed from: PlatformImplementations.kt_3 */
    public SupportMenuItem mo1097a(ActionProvider abstractC0491b) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public SupportMenuItem setShowAsActionFlags(int OplusGLSurfaceView_13) {
        setShowAsAction(OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* renamed from: PlatformImplementations.kt_3 */
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f1275p = charSequence;
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1275p;
    }

    @Override // android.view.MenuItem
    /* renamed from: IntrinsicsJvm.kt_4 */
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f1276q = charSequence;
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1276q;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1277r = colorStateList;
        this.f1279t = true;
        m1094b();
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1277r;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1278s = mode;
        this.f1280u = true;
        m1094b();
        return this;
    }

    @Override // androidx.core.p029b.p030a.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1278s;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1094b() {
        if (this.f1271l != null) {
            if (this.f1279t || this.f1280u) {
                this.f1271l = DrawableCompat.m2581g(this.f1271l);
                this.f1271l = this.f1271l.mutate();
                if (this.f1279t) {
                    DrawableCompat.m2570a(this.f1271l, this.f1277r);
                }
                if (this.f1280u) {
                    DrawableCompat.m2573a(this.f1271l, this.f1278s);
                }
            }
        }
    }
}
