package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p036h.ActionProvider;
import java.util.ArrayList;

/* loaded from: classes.dex */
class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.PlatformImplementations.kt_3 {

    /* renamed from: COUIBaseListPopupWindow_11 */
    C0259d f1502g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    C0260e f1503h;

    /* renamed from: OplusGLSurfaceView_13 */
    C0256a f1504i;

    /* renamed from: OplusGLSurfaceView_15 */
    RunnableC0258c f1505j;

    /* renamed from: OplusGLSurfaceView_5 */
    final C0261f f1506k;

    /* renamed from: OplusGLSurfaceView_14 */
    int f1507l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Drawable f1508m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f1509n;

    /* renamed from: o */
    private boolean f1510o;

    /* renamed from: p */
    private boolean f1511p;

    /* renamed from: q */
    private int f1512q;

    /* renamed from: r */
    private int f1513r;

    /* renamed from: s */
    private int f1514s;

    /* renamed from: t */
    private boolean f1515t;

    /* renamed from: u */
    private boolean f1516u;

    /* renamed from: v */
    private boolean f1517v;

    /* renamed from: w */
    private boolean f1518w;

    /* renamed from: x */
    private int f1519x;

    /* renamed from: y */
    private final SparseBooleanArray f1520y;

    /* renamed from: z */
    private C0257b f1521z;

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.f1520y = new SparseBooleanArray();
        this.f1506k = new C0261f();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder c0236h) {
        super.initForMenu(context, c0236h);
        Resources resources = context.getResources();
        ActionBarPolicy c0220aM1047a = ActionBarPolicy.m1047a(context);
        if (!this.f1511p) {
            this.f1510o = c0220aM1047a.m1049b();
        }
        if (!this.f1517v) {
            this.f1512q = c0220aM1047a.m1050c();
        }
        if (!this.f1515t) {
            this.f1514s = c0220aM1047a.m1048a();
        }
        int measuredWidth = this.f1512q;
        if (this.f1510o) {
            if (this.f1502g == null) {
                this.f1502g = new C0259d(this.f1294a);
                if (this.f1509n) {
                    this.f1502g.setImageDrawable(this.f1508m);
                    this.f1508m = null;
                    this.f1509n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1502g.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f1502g.getMeasuredWidth();
        } else {
            this.f1502g = null;
        }
        this.f1513r = measuredWidth;
        this.f1519x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1253a(Configuration configuration) {
        if (!this.f1515t) {
            this.f1514s = ActionBarPolicy.m1047a(this.f1295b).m1048a();
        }
        if (this.f1296c != null) {
            this.f1296c.onItemsChanged(true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1256a(boolean z) {
        this.f1510o = z;
        this.f1511p = true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m1258b(boolean z) {
        this.f1518w = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1254a(Drawable drawable) {
        C0259d c0259d = this.f1502g;
        if (c0259d != null) {
            c0259d.setImageDrawable(drawable);
        } else {
            this.f1509n = true;
            this.f1508m = drawable;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Drawable m1257b() {
        C0259d c0259d = this.f1502g;
        if (c0259d != null) {
            return c0259d.getDrawable();
        }
        if (this.f1509n) {
            return this.f1508m;
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    /* renamed from: PlatformImplementations.kt_3 */
    public MenuView mo1112a(ViewGroup viewGroup) {
        MenuView interfaceC0243o = this.f1299f;
        MenuView interfaceC0243oMo1112a = super.mo1112a(viewGroup);
        if (interfaceC0243o != interfaceC0243oMo1112a) {
            ((ActionMenuView) interfaceC0243oMo1112a).setPresenter(this);
        }
        return interfaceC0243oMo1112a;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    /* renamed from: PlatformImplementations.kt_3 */
    public View mo1110a(MenuItemImpl c0238j, View view, ViewGroup viewGroup) {
        View actionView = c0238j.getActionView();
        if (actionView == null || c0238j.m1183m()) {
            actionView = super.mo1110a(c0238j, view, viewGroup);
        }
        actionView.setVisibility(c0238j.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1115a(MenuItemImpl c0238j, MenuView.PlatformImplementations.kt_3 aVar) {
        aVar.initialize(c0238j, 0);
        ActionMenuItemView viewOnClickListenerC0230b = (ActionMenuItemView) aVar;
        viewOnClickListenerC0230b.setItemInvoker((ActionMenuView) this.f1299f);
        if (this.f1521z == null) {
            this.f1521z = new C0257b();
        }
        viewOnClickListenerC0230b.setPopupCallback(this.f1521z);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo1116a(int OplusGLSurfaceView_13, MenuItemImpl c0238j) {
        return c0238j.m1180j();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        super.updateMenuView(z);
        ((View) this.f1299f).requestLayout();
        boolean z2 = false;
        if (this.f1296c != null) {
            ArrayList<MenuItemImpl> actionItems = this.f1296c.getActionItems();
            int size = actionItems.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                ActionProvider abstractC0491bMo1099a = actionItems.get(OplusGLSurfaceView_13).mo1099a();
                if (abstractC0491bMo1099a != null) {
                    abstractC0491bMo1099a.m2768a(this);
                }
            }
        }
        ArrayList<MenuItemImpl> nonActionItems = this.f1296c != null ? this.f1296c.getNonActionItems() : null;
        if (this.f1510o && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f1502g == null) {
                this.f1502g = new C0259d(this.f1294a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1502g.getParent();
            if (viewGroup != this.f1299f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1502g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1299f;
                actionMenuView.addView(this.f1502g, actionMenuView.m1277c());
            }
        } else {
            C0259d c0259d = this.f1502g;
            if (c0259d != null && c0259d.getParent() == this.f1299f) {
                ((ViewGroup) this.f1299f).removeView(this.f1502g);
            }
        }
        ((ActionMenuView) this.f1299f).setOverflowReserved(this.f1510o);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo1117a(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        if (viewGroup.getChildAt(OplusGLSurfaceView_13) == this.f1502g) {
            return false;
        }
        return super.mo1117a(viewGroup, OplusGLSurfaceView_13);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuC0247s) {
        boolean z = false;
        if (!subMenuC0247s.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuC0247s2 = subMenuC0247s;
        while (subMenuC0247s2.getParentMenu() != this.f1296c) {
            subMenuC0247s2 = (SubMenuBuilder) subMenuC0247s2.getParentMenu();
        }
        View viewM1246a = m1246a(subMenuC0247s2.getItem());
        if (viewM1246a == null) {
            return false;
        }
        this.f1507l = subMenuC0247s.getItem().getItemId();
        int size = subMenuC0247s.size();
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            if (OplusGLSurfaceView_13 >= size) {
                break;
            }
            MenuItem item = subMenuC0247s.getItem(OplusGLSurfaceView_13);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            OplusGLSurfaceView_13++;
        }
        this.f1504i = new C0256a(this.f1295b, subMenuC0247s, viewM1246a);
        this.f1504i.m1207a(z);
        this.f1504i.m1202a();
        super.onSubMenuSelected(subMenuC0247s);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    private View m1246a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1299f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = viewGroup.getChildAt(OplusGLSurfaceView_13);
            if ((childAt instanceof MenuView.PlatformImplementations.kt_3) && ((MenuView.PlatformImplementations.kt_3) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m1260c() {
        if (!this.f1510o || m1264g() || this.f1296c == null || this.f1299f == null || this.f1505j != null || this.f1296c.getNonActionItems().isEmpty()) {
            return false;
        }
        this.f1505j = new RunnableC0258c(new C0260e(this.f1295b, this.f1296c, this.f1502g, true));
        ((View) this.f1299f).post(this.f1505j);
        super.onSubMenuSelected(null);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m1261d() {
        if (this.f1505j != null && this.f1299f != null) {
            ((View) this.f1299f).removeCallbacks(this.f1505j);
            this.f1505j = null;
            return true;
        }
        C0260e c0260e = this.f1503h;
        if (c0260e == null) {
            return false;
        }
        c0260e.m1211d();
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m1262e() {
        return m1263f() | m1261d();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m1263f() {
        C0256a c0256a = this.f1504i;
        if (c0256a == null) {
            return false;
        }
        c0256a.m1211d();
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m1264g() {
        C0260e c0260e = this.f1503h;
        return c0260e != null && c0260e.m1213f();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m1265h() {
        return this.f1505j != null || m1264g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v20 */
    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems;
        int size;
        int OplusGLSurfaceView_13;
        int iM1269a;
        boolean z;
        int i2;
        boolean z2;
        ActionMenuPresenter actionMenuPresenter = this;
        View view = null;
        ?? r3 = 0;
        if (actionMenuPresenter.f1296c != null) {
            visibleItems = actionMenuPresenter.f1296c.getVisibleItems();
            size = visibleItems.size();
        } else {
            visibleItems = null;
            size = 0;
        }
        int i3 = actionMenuPresenter.f1514s;
        int i4 = actionMenuPresenter.f1513r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f1299f;
        boolean z3 = false;
        int i5 = 0;
        int i6 = 0;
        int i7 = i3;
        for (int i8 = 0; i8 < size; i8++) {
            MenuItemImpl c0238j = visibleItems.get(i8);
            if (c0238j.requiresActionButton()) {
                i5++;
            } else if (c0238j.m1181k()) {
                i6++;
            } else {
                z3 = true;
            }
            if (actionMenuPresenter.f1518w && c0238j.isActionViewExpanded()) {
                i7 = 0;
            }
        }
        if (actionMenuPresenter.f1510o && (z3 || i6 + i5 > i7)) {
            i7--;
        }
        int i9 = i7 - i5;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f1520y;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f1516u) {
            int i10 = actionMenuPresenter.f1519x;
            iM1269a = i4 / i10;
            OplusGLSurfaceView_13 = i10 + ((i4 % i10) / iM1269a);
        } else {
            OplusGLSurfaceView_13 = 0;
            iM1269a = 0;
        }
        int i11 = 0;
        int i12 = i4;
        int i13 = 0;
        while (i13 < size) {
            MenuItemImpl c0238j2 = visibleItems.get(i13);
            if (c0238j2.requiresActionButton()) {
                View viewMo1110a = actionMenuPresenter.mo1110a(c0238j2, view, viewGroup);
                if (actionMenuPresenter.f1516u) {
                    iM1269a -= ActionMenuView.m1269a(viewMo1110a, OplusGLSurfaceView_13, iM1269a, iMakeMeasureSpec, r3);
                } else {
                    viewMo1110a.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewMo1110a.getMeasuredWidth();
                i12 -= measuredWidth;
                if (i11 != 0) {
                    measuredWidth = i11;
                }
                int groupId = c0238j2.getGroupId();
                if (groupId != 0) {
                    z2 = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z2 = true;
                }
                c0238j2.m1173d(z2);
                i11 = measuredWidth;
                z = r3;
                i2 = size;
            } else if (c0238j2.m1181k()) {
                int groupId2 = c0238j2.getGroupId();
                boolean z4 = sparseBooleanArray.get(groupId2);
                boolean z5 = (i9 > 0 || z4) && i12 > 0 && (!actionMenuPresenter.f1516u || iM1269a > 0);
                if (z5) {
                    boolean z6 = z5;
                    i2 = size;
                    View viewMo1110a2 = actionMenuPresenter.mo1110a(c0238j2, null, viewGroup);
                    if (actionMenuPresenter.f1516u) {
                        int iM1269a2 = ActionMenuView.m1269a(viewMo1110a2, OplusGLSurfaceView_13, iM1269a, iMakeMeasureSpec, 0);
                        iM1269a -= iM1269a2;
                        z6 = iM1269a2 == 0 ? false : z6;
                    } else {
                        viewMo1110a2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth2 = viewMo1110a2.getMeasuredWidth();
                    i12 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    z5 = z6 & (!actionMenuPresenter.f1516u ? i12 + i11 <= 0 : i12 < 0);
                } else {
                    i2 = size;
                }
                if (z5 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z4) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i14 = 0; i14 < i13; i14++) {
                        MenuItemImpl c0238j3 = visibleItems.get(i14);
                        if (c0238j3.getGroupId() == groupId2) {
                            if (c0238j3.m1180j()) {
                                i9++;
                            }
                            c0238j3.m1173d(false);
                        }
                    }
                }
                if (z5) {
                    i9--;
                }
                c0238j2.m1173d(z5);
                z = false;
            } else {
                z = r3;
                i2 = size;
                c0238j2.m1173d(z);
            }
            i13++;
            r3 = z;
            size = i2;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder c0236h, boolean z) {
        m1262e();
        super.onCloseMenu(c0236h, z);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.f1507l;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.openSubMenuId <= 0 || (menuItemFindItem = this.f1296c.findItem(savedState.openSubMenuId)) == null) {
                return;
            }
            onSubMenuSelected((SubMenuBuilder) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.core.p036h.ActionProvider.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo1259c(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
        } else if (this.f1296c != null) {
            this.f1296c.close(false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1255a(ActionMenuView actionMenuView) {
        this.f1299f = actionMenuView;
        actionMenuView.initialize(this.f1296c);
    }

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.ActionMenuPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        public int openSubMenuId;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$IntrinsicsJvm.kt_5 */
    private class C0259d extends AppCompatImageView implements ActionMenuView.InterfaceC0262a {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final float[] f1527b;

        @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0262a
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo1105b() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0262a
        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean mo1106c() {
            return false;
        }

        public C0259d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            this.f1527b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.m1605a(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this) { // from class: androidx.appcompat.widget.ActionMenuPresenter.IntrinsicsJvm.kt_5.1
                @Override // androidx.appcompat.widget.ForwardingListener
                /* renamed from: PlatformImplementations.kt_3 */
                public ShowableListMenu mo1107a() {
                    if (ActionMenuPresenter.this.f1503h == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.f1503h.m1209b();
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                /* renamed from: IntrinsicsJvm.kt_4 */
                public boolean mo1108b() {
                    ActionMenuPresenter.this.m1260c();
                    return true;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                /* renamed from: IntrinsicsJvm.kt_3 */
                public boolean mo1268c() {
                    if (ActionMenuPresenter.this.f1505j != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.m1261d();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.m1260c();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            boolean frame = super.setFrame(OplusGLSurfaceView_13, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.m2569a(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$COUIBaseListPopupWindow_8 */
    private class C0260e extends MenuPopupHelper {
        public C0260e(Context context, MenuBuilder c0236h, View view, boolean z) {
            super(context, c0236h, view, z, R.attr.actionOverflowMenuStyle);
            m1203a(8388613);
            m1206a(ActionMenuPresenter.this.f1506k);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        /* renamed from: COUIBaseListPopupWindow_8 */
        protected void mo1212e() {
            if (ActionMenuPresenter.this.f1296c != null) {
                ActionMenuPresenter.this.f1296c.close();
            }
            ActionMenuPresenter.this.f1503h = null;
            super.mo1212e();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$PlatformImplementations.kt_3 */
    private class C0256a extends MenuPopupHelper {
        public C0256a(Context context, SubMenuBuilder subMenuC0247s, View view) {
            super(context, subMenuC0247s, view, false, R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl) subMenuC0247s.getItem()).m1180j()) {
                m1204a(ActionMenuPresenter.this.f1502g == null ? (View) ActionMenuPresenter.this.f1299f : ActionMenuPresenter.this.f1502g);
            }
            m1206a(ActionMenuPresenter.this.f1506k);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        /* renamed from: COUIBaseListPopupWindow_8 */
        protected void mo1212e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f1504i = null;
            actionMenuPresenter.f1507l = 0;
            super.mo1212e();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$COUIBaseListPopupWindow_12 */
    private class C0261f implements MenuPresenter.PlatformImplementations.kt_3 {
        C0261f() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo862a(MenuBuilder c0236h) {
            if (c0236h == null) {
                return false;
            }
            ActionMenuPresenter.this.f1507l = ((SubMenuBuilder) c0236h).getItem().getItemId();
            MenuPresenter.PlatformImplementations.kt_3 aVarA = ActionMenuPresenter.this.m1111a();
            if (aVarA != null) {
                return aVarA.mo862a(c0236h);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo861a(MenuBuilder c0236h, boolean z) {
            if (c0236h instanceof SubMenuBuilder) {
                c0236h.getRootMenu().close(false);
            }
            MenuPresenter.PlatformImplementations.kt_3 aVarA = ActionMenuPresenter.this.m1111a();
            if (aVarA != null) {
                aVarA.mo861a(c0236h, z);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$IntrinsicsJvm.kt_3 */
    private class RunnableC0258c implements Runnable {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private C0260e f1525b;

        public RunnableC0258c(C0260e c0260e) {
            this.f1525b = c0260e;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.f1296c != null) {
                ActionMenuPresenter.this.f1296c.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.f1299f;
            if (view != null && view.getWindowToken() != null && this.f1525b.m1210c()) {
                ActionMenuPresenter.this.f1503h = this.f1525b;
            }
            ActionMenuPresenter.this.f1505j = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$IntrinsicsJvm.kt_4 */
    private class C0257b extends ActionMenuItemView.IntrinsicsJvm.kt_4 {
        C0257b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3 */
        public ShowableListMenu mo1109a() {
            if (ActionMenuPresenter.this.f1504i != null) {
                return ActionMenuPresenter.this.f1504i.m1209b();
            }
            return null;
        }
    }
}
