package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.core.p029b.p030a.SupportMenuItem;
import androidx.core.p036h.ActionProvider;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MenuItemWrapperICS.java */
/* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final SupportMenuItem f1398b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Method f1399c;

    public MenuItemWrapperICS(Context context, SupportMenuItem interfaceMenuItemC0441b) {
        super(context);
        if (interfaceMenuItemC0441b == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f1398b = interfaceMenuItemC0441b;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1398b.getItemId();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1398b.getGroupId();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1398b.getOrder();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1398b.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int OplusGLSurfaceView_13) {
        this.f1398b.setTitle(OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1398b.getTitle();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1398b.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f1398b.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1398b.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int OplusGLSurfaceView_13) {
        this.f1398b.setIcon(OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1398b.getIcon();
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1398b.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1398b.getIntent();
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.f1398b.setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int OplusGLSurfaceView_13, int i2) {
        this.f1398b.setShortcut(c2, c3, OplusGLSurfaceView_13, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f1398b.setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int OplusGLSurfaceView_13) {
        this.f1398b.setNumericShortcut(c2, OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1398b.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1398b.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f1398b.setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int OplusGLSurfaceView_13) {
        this.f1398b.setAlphabeticShortcut(c2, OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1398b.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1398b.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f1398b.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f1398b.isCheckable();
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f1398b.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f1398b.isChecked();
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.f1398b.setVisible(z);
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f1398b.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f1398b.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f1398b.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1398b.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return m1120a(this.f1398b.getSubMenu());
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1398b.setOnMenuItemClickListener(onMenuItemClickListener != null ? new COUIBaseListPopupWindow_8(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1398b.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int OplusGLSurfaceView_13) {
        this.f1398b.setShowAsAction(OplusGLSurfaceView_13);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int OplusGLSurfaceView_13) {
        this.f1398b.setShowAsActionFlags(OplusGLSurfaceView_13);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new IntrinsicsJvm.kt_3(view);
        }
        this.f1398b.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int OplusGLSurfaceView_13) {
        this.f1398b.setActionView(OplusGLSurfaceView_13);
        View actionView = this.f1398b.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f1398b.setActionView(new IntrinsicsJvm.kt_3(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f1398b.getActionView();
        return actionView instanceof IntrinsicsJvm.kt_3 ? ((IntrinsicsJvm.kt_3) actionView).m1194c() : actionView;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ActionProvider aVar;
        if (Build.VERSION.SDK_INT >= 16) {
            aVar = new IntrinsicsJvm.kt_4(this.f1304a, actionProvider);
        } else {
            aVar = new PlatformImplementations.kt_3(this.f1304a, actionProvider);
        }
        SupportMenuItem interfaceMenuItemC0441b = this.f1398b;
        if (actionProvider == null) {
            aVar = null;
        }
        interfaceMenuItemC0441b.mo1097a(aVar);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        ActionProvider abstractC0491bMo1099a = this.f1398b.mo1099a();
        if (abstractC0491bMo1099a instanceof PlatformImplementations.kt_3) {
            return ((PlatformImplementations.kt_3) abstractC0491bMo1099a).f1400a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f1398b.expandActionView();
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f1398b.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1398b.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1398b.setOnActionExpandListener(onActionExpandListener != null ? new IntrinsicsJvm.kt_5(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f1398b.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1398b.getContentDescription();
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f1398b.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1398b.getTooltipText();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1398b.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1398b.getIconTintList();
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1398b.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1398b.getIconTintMode();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1185a(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.f1399c == null) {
                this.f1399c = this.f1398b.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f1399c.invoke(this.f1398b, Boolean.valueOf(z));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_5$COUIBaseListPopupWindow_8 */
    private class COUIBaseListPopupWindow_8 implements MenuItem.OnMenuItemClickListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final MenuItem.OnMenuItemClickListener f1408b;

        COUIBaseListPopupWindow_8(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f1408b = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f1408b.onMenuItemClick(MenuItemWrapperICS.this.m1119a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_5$IntrinsicsJvm.kt_5 */
    private class IntrinsicsJvm.kt_5 implements MenuItem.OnActionExpandListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final MenuItem.OnActionExpandListener f1406b;

        IntrinsicsJvm.kt_5(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f1406b = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f1406b.onMenuItemActionExpand(MenuItemWrapperICS.this.m1119a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f1406b.onMenuItemActionCollapse(MenuItemWrapperICS.this.m1119a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_5$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends ActionProvider {

        /* renamed from: PlatformImplementations.kt_3 */
        final ActionProvider f1400a;

        PlatformImplementations.kt_3(Context context, ActionProvider actionProvider) {
            super(context);
            this.f1400a = actionProvider;
        }

        @Override // androidx.core.p036h.ActionProvider
        /* renamed from: PlatformImplementations.kt_3 */
        public View mo1186a() {
            return this.f1400a.onCreateActionView();
        }

        @Override // androidx.core.p036h.ActionProvider
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo1188b() {
            return this.f1400a.onPerformDefaultAction();
        }

        @Override // androidx.core.p036h.ActionProvider
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo1189c() {
            return this.f1400a.hasSubMenu();
        }

        @Override // androidx.core.p036h.ActionProvider
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1187a(SubMenu subMenu) {
            this.f1400a.onPrepareSubMenu(MenuItemWrapperICS.this.m1120a(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_5$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends PlatformImplementations.kt_3 implements ActionProvider.VisibilityListener {

        /* renamed from: IntrinsicsJvm.kt_5 */
        private ActionProvider.IntrinsicsJvm.kt_4 f1403d;

        IntrinsicsJvm.kt_4(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.p036h.ActionProvider
        /* renamed from: PlatformImplementations.kt_3 */
        public View mo1190a(MenuItem menuItem) {
            return this.f1400a.onCreateActionView(menuItem);
        }

        @Override // androidx.core.p036h.ActionProvider
        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean mo1192d() {
            return this.f1400a.overridesItemVisibility();
        }

        @Override // androidx.core.p036h.ActionProvider
        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean mo1193e() {
            return this.f1400a.isVisible();
        }

        @Override // androidx.core.p036h.ActionProvider
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1191a(ActionProvider.IntrinsicsJvm.kt_4 bVar) {
            this.f1403d = bVar;
            ActionProvider actionProvider = this.f1400a;
            if (bVar == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            ActionProvider.IntrinsicsJvm.kt_4 bVar = this.f1403d;
            if (bVar != null) {
                bVar.mo1184a(z);
            }
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: androidx.appcompat.view.menu.OplusGLSurfaceView_5$IntrinsicsJvm.kt_3 */
    static class IntrinsicsJvm.kt_3 extends FrameLayout implements CollapsibleActionView {

        /* renamed from: PlatformImplementations.kt_3 */
        final CollapsibleActionView f1404a;

        /* JADX WARN: Multi-variable type inference failed */
        IntrinsicsJvm.kt_3(View view) {
            super(view.getContext());
            this.f1404a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1058a() {
            this.f1404a.onActionViewExpanded();
        }

        @Override // androidx.appcompat.view.CollapsibleActionView
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo1059b() {
            this.f1404a.onActionViewCollapsed();
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        View m1194c() {
            return (View) this.f1404a;
        }
    }
}
