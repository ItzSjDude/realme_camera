package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.core.p036h.GravityCompat;
import androidx.core.p036h.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CascadingMenuPopup.java */
/* renamed from: androidx.appcompat.view.menu.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener, MenuPresenter {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final int f1307g = R.layout.abc_cascading_menu_item_layout;

    /* renamed from: A */
    private PopupWindow.OnDismissListener f1308A;

    /* renamed from: PlatformImplementations.kt_3 */
    final Handler f1309a;

    /* renamed from: IntrinsicsJvm.kt_5 */
    View f1312d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    ViewTreeObserver f1313e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean f1314f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Context f1315h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final int f1316i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final int f1317j;

    /* renamed from: OplusGLSurfaceView_5 */
    private final int f1318k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final boolean f1319l;

    /* renamed from: r */
    private View f1325r;

    /* renamed from: t */
    private boolean f1327t;

    /* renamed from: u */
    private boolean f1328u;

    /* renamed from: v */
    private int f1329v;

    /* renamed from: w */
    private int f1330w;

    /* renamed from: y */
    private boolean f1332y;

    /* renamed from: z */
    private MenuPresenter.PlatformImplementations.kt_3 f1333z;

    /* renamed from: OplusGLSurfaceView_6 */
    private final List<MenuBuilder> f1320m = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_4 */
    final List<PlatformImplementations.kt_3> f1310b = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_3 */
    final ViewTreeObserver.OnGlobalLayoutListener f1311c = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.COUIBaseListPopupWindow_8.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!CascadingMenuPopup.this.mo1142c() || CascadingMenuPopup.this.f1310b.size() <= 0 || CascadingMenuPopup.this.f1310b.get(0).f1341a.m1443i()) {
                return;
            }
            View view = CascadingMenuPopup.this.f1312d;
            if (view == null || !view.isShown()) {
                CascadingMenuPopup.this.mo1137b();
                return;
            }
            Iterator<PlatformImplementations.kt_3> it = CascadingMenuPopup.this.f1310b.iterator();
            while (it.hasNext()) {
                it.next().f1341a.mo1136a_();
            }
        }
    };

    /* renamed from: OplusGLSurfaceView_11 */
    private final View.OnAttachStateChangeListener f1321n = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.COUIBaseListPopupWindow_8.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (CascadingMenuPopup.this.f1313e != null) {
                if (!CascadingMenuPopup.this.f1313e.isAlive()) {
                    CascadingMenuPopup.this.f1313e = view.getViewTreeObserver();
                }
                CascadingMenuPopup.this.f1313e.removeGlobalOnLayoutListener(CascadingMenuPopup.this.f1311c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: o */
    private final MenuItemHoverListener f1322o = new MenuItemHoverListener() { // from class: androidx.appcompat.view.menu.COUIBaseListPopupWindow_8.3
        @Override // androidx.appcompat.widget.MenuItemHoverListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo1144a(MenuBuilder c0236h, MenuItem menuItem) {
            CascadingMenuPopup.this.f1309a.removeCallbacksAndMessages(c0236h);
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo1145b(final MenuBuilder c0236h, final MenuItem menuItem) {
            CascadingMenuPopup.this.f1309a.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.f1310b.size();
            int OplusGLSurfaceView_13 = 0;
            while (true) {
                if (OplusGLSurfaceView_13 >= size) {
                    OplusGLSurfaceView_13 = -1;
                    break;
                } else if (c0236h == CascadingMenuPopup.this.f1310b.get(OplusGLSurfaceView_13).f1342b) {
                    break;
                } else {
                    OplusGLSurfaceView_13++;
                }
            }
            if (OplusGLSurfaceView_13 == -1) {
                return;
            }
            int i2 = OplusGLSurfaceView_13 + 1;
            final PlatformImplementations.kt_3 aVar = i2 < CascadingMenuPopup.this.f1310b.size() ? CascadingMenuPopup.this.f1310b.get(i2) : null;
            CascadingMenuPopup.this.f1309a.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.COUIBaseListPopupWindow_8.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        CascadingMenuPopup.this.f1314f = true;
                        aVar.f1342b.close(false);
                        CascadingMenuPopup.this.f1314f = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        c0236h.performItemAction(menuItem, 4);
                    }
                }
            }, c0236h, SystemClock.uptimeMillis() + 200);
        }
    };

    /* renamed from: p */
    private int f1323p = 0;

    /* renamed from: q */
    private int f1324q = 0;

    /* renamed from: x */
    private boolean f1331x = false;

    /* renamed from: s */
    private int f1326s = m1130h();

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean mo1143e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    public CascadingMenuPopup(Context context, View view, int OplusGLSurfaceView_13, int i2, boolean z) {
        this.f1315h = context;
        this.f1325r = view;
        this.f1317j = OplusGLSurfaceView_13;
        this.f1318k = i2;
        this.f1319l = z;
        Resources resources = context.getResources();
        this.f1316i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f1309a = new Handler();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1135a(boolean z) {
        this.f1331x = z;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private MenuPopupWindow m1129g() {
        MenuPopupWindow c0311ag = new MenuPopupWindow(this.f1315h, null, this.f1317j, this.f1318k);
        c0311ag.m1453a(this.f1322o);
        c0311ag.m1428a((AdapterView.OnItemClickListener) this);
        c0311ag.m1429a((PopupWindow.OnDismissListener) this);
        c0311ag.m1432b(this.f1325r);
        c0311ag.m1439f(this.f1324q);
        c0311ag.m1430a(true);
        c0311ag.m1442i(2);
        return c0311ag;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: a_ */
    public void mo1136a_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (mo1142c()) {
            return;
        }
        Iterator<MenuBuilder> it = this.f1320m.iterator();
        while (it.hasNext()) {
            m1126c(it.next());
        }
        this.f1320m.clear();
        this.f1312d = this.f1325r;
        if (this.f1312d != null) {
            boolean z = this.f1313e == null;
            this.f1313e = this.f1312d.getViewTreeObserver();
            if (z) {
                this.f1313e.addOnGlobalLayoutListener(this.f1311c);
            }
            this.f1312d.addOnAttachStateChangeListener(this.f1321n);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1137b() {
        int size = this.f1310b.size();
        if (size > 0) {
            PlatformImplementations.kt_3[] aVarArr = (PlatformImplementations.kt_3[]) this.f1310b.toArray(new PlatformImplementations.kt_3[size]);
            for (int OplusGLSurfaceView_13 = size - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
                PlatformImplementations.kt_3 aVar = aVarArr[OplusGLSurfaceView_13];
                if (aVar.f1341a.mo1142c()) {
                    aVar.f1341a.mo1137b();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || OplusGLSurfaceView_13 != 82) {
            return false;
        }
        mo1137b();
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int m1130h() {
        return ViewCompat.m2885g(this.f1325r) == 1 ? 0 : 1;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m1127d(int OplusGLSurfaceView_13) {
        List<PlatformImplementations.kt_3> list = this.f1310b;
        ListView listViewM1146a = list.get(list.size() - 1).m1146a();
        int[] iArr = new int[2];
        listViewM1146a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1312d.getWindowVisibleDisplayFrame(rect);
        return this.f1326s == 1 ? (iArr[0] + listViewM1146a.getWidth()) + OplusGLSurfaceView_13 > rect.right ? 0 : 1 : iArr[0] - OplusGLSurfaceView_13 < 0 ? 1 : 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1134a(MenuBuilder c0236h) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        c0236h.addMenuPresenter(this, this.f1315h);
        if (mo1142c()) {
            m1126c(c0236h);
        } else {
            this.f1320m.add(c0236h);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m1126c(MenuBuilder c0236h) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        PlatformImplementations.kt_3 aVar;
        View viewM1125a;
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1315h);
        MenuAdapter c0235g = new MenuAdapter(c0236h, layoutInflaterFrom, this.f1319l, f1307g);
        if (!mo1142c() && this.f1331x) {
            c0235g.m1155a(true);
        } else if (mo1142c()) {
            c0235g.m1155a(MenuPopup.m1197b(c0236h));
        }
        int iA = m1195a(c0235g, null, this.f1315h, this.f1316i);
        MenuPopupWindow c0311agM1129g = m1129g();
        c0311agM1129g.mo1311a((ListAdapter) c0235g);
        c0311agM1129g.m1441h(iA);
        c0311agM1129g.m1439f(this.f1324q);
        if (this.f1310b.size() > 0) {
            List<PlatformImplementations.kt_3> list = this.f1310b;
            aVar = list.get(list.size() - 1);
            viewM1125a = m1125a(aVar, c0236h);
        } else {
            aVar = null;
            viewM1125a = null;
        }
        if (viewM1125a != null) {
            c0311agM1129g.m1456c(false);
            c0311agM1129g.m1454a((Object) null);
            int iM1127d = m1127d(iA);
            boolean z = iM1127d == 1;
            this.f1326s = iM1127d;
            if (Build.VERSION.SDK_INT >= 26) {
                c0311agM1129g.m1432b(viewM1125a);
                i2 = 0;
                OplusGLSurfaceView_13 = 0;
            } else {
                int[] iArr = new int[2];
                this.f1325r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewM1125a.getLocationOnScreen(iArr2);
                if ((this.f1324q & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1325r.getWidth();
                    iArr2[0] = iArr2[0] + viewM1125a.getWidth();
                }
                OplusGLSurfaceView_13 = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.f1324q & 5) == 5) {
                if (!z) {
                    iA = viewM1125a.getWidth();
                    i3 = OplusGLSurfaceView_13 - iA;
                }
                i3 = OplusGLSurfaceView_13 + iA;
            } else {
                if (z) {
                    iA = viewM1125a.getWidth();
                    i3 = OplusGLSurfaceView_13 + iA;
                }
                i3 = OplusGLSurfaceView_13 - iA;
            }
            c0311agM1129g.m1431b(i3);
            c0311agM1129g.m1433b(true);
            c0311agM1129g.m1425a(i2);
        } else {
            if (this.f1327t) {
                c0311agM1129g.m1431b(this.f1329v);
            }
            if (this.f1328u) {
                c0311agM1129g.m1425a(this.f1330w);
            }
            c0311agM1129g.m1426a(m1199f());
        }
        this.f1310b.add(new PlatformImplementations.kt_3(c0311agM1129g, c0236h, this.f1326s));
        c0311agM1129g.mo1136a_();
        ListView listViewB_ = c0311agM1129g.mo1140b_();
        listViewB_.setOnKeyListener(this);
        if (aVar == null && this.f1332y && c0236h.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewB_, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id_renamed.title);
            frameLayout.setEnabled(false);
            textView.setText(c0236h.getHeaderTitle());
            listViewB_.addHeaderView(frameLayout, null, false);
            c0311agM1129g.mo1136a_();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private MenuItem m1124a(MenuBuilder c0236h, MenuBuilder c0236h2) {
        int size = c0236h.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            MenuItem item = c0236h.getItem(OplusGLSurfaceView_13);
            if (item.hasSubMenu() && c0236h2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private View m1125a(PlatformImplementations.kt_3 aVar, MenuBuilder c0236h) {
        MenuAdapter c0235g;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemM1124a = m1124a(aVar.f1342b, c0236h);
        if (menuItemM1124a == null) {
            return null;
        }
        ListView listViewM1146a = aVar.m1146a();
        ListAdapter adapter = listViewM1146a.getAdapter();
        int OplusGLSurfaceView_13 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            c0235g = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
        } else {
            c0235g = (MenuAdapter) adapter;
            headersCount = 0;
        }
        int count = c0235g.getCount();
        while (true) {
            if (OplusGLSurfaceView_13 >= count) {
                OplusGLSurfaceView_13 = -1;
                break;
            }
            if (menuItemM1124a == c0235g.getItem(OplusGLSurfaceView_13)) {
                break;
            }
            OplusGLSurfaceView_13++;
        }
        if (OplusGLSurfaceView_13 != -1 && (firstVisiblePosition = (OplusGLSurfaceView_13 + headersCount) - listViewM1146a.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewM1146a.getChildCount()) {
            return listViewM1146a.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo1142c() {
        return this.f1310b.size() > 0 && this.f1310b.get(0).f1341a.mo1142c();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        PlatformImplementations.kt_3 aVar;
        int size = this.f1310b.size();
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            if (OplusGLSurfaceView_13 >= size) {
                aVar = null;
                break;
            }
            aVar = this.f1310b.get(OplusGLSurfaceView_13);
            if (!aVar.f1341a.mo1142c()) {
                break;
            } else {
                OplusGLSurfaceView_13++;
            }
        }
        if (aVar != null) {
            aVar.f1342b.close(false);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        Iterator<PlatformImplementations.kt_3> it = this.f1310b.iterator();
        while (it.hasNext()) {
            m1196a(it.next().m1146a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.PlatformImplementations.kt_3 aVar) {
        this.f1333z = aVar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuC0247s) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (PlatformImplementations.kt_3 aVar : this.f1310b) {
            if (subMenuC0247s == aVar.f1342b) {
                aVar.m1146a().requestFocus();
                return true;
            }
        }
        if (!subMenuC0247s.hasVisibleItems()) {
            return false;
        }
        mo1134a(subMenuC0247s);
        MenuPresenter.PlatformImplementations.kt_3 aVar2 = this.f1333z;
        if (aVar2 != null) {
            aVar2.mo862a(subMenuC0247s);
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m1128d(MenuBuilder c0236h) {
        int size = this.f1310b.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            if (c0236h == this.f1310b.get(OplusGLSurfaceView_13).f1342b) {
                return OplusGLSurfaceView_13;
            }
        }
        return -1;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder c0236h, boolean z) {
        int iM1128d = m1128d(c0236h);
        if (iM1128d < 0) {
            return;
        }
        int OplusGLSurfaceView_13 = iM1128d + 1;
        if (OplusGLSurfaceView_13 < this.f1310b.size()) {
            this.f1310b.get(OplusGLSurfaceView_13).f1342b.close(false);
        }
        PlatformImplementations.kt_3 aVarRemove = this.f1310b.remove(iM1128d);
        aVarRemove.f1342b.removeMenuPresenter(this);
        if (this.f1314f) {
            aVarRemove.f1341a.m1455b((Object) null);
            aVarRemove.f1341a.m1437e(0);
        }
        aVarRemove.f1341a.mo1137b();
        int size = this.f1310b.size();
        if (size > 0) {
            this.f1326s = this.f1310b.get(size - 1).f1343c;
        } else {
            this.f1326s = m1130h();
        }
        if (size != 0) {
            if (z) {
                this.f1310b.get(0).f1342b.close(false);
                return;
            }
            return;
        }
        mo1137b();
        MenuPresenter.PlatformImplementations.kt_3 aVar = this.f1333z;
        if (aVar != null) {
            aVar.mo861a(c0236h, true);
        }
        ViewTreeObserver viewTreeObserver = this.f1313e;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f1313e.removeGlobalOnLayoutListener(this.f1311c);
            }
            this.f1313e = null;
        }
        this.f1312d.removeOnAttachStateChangeListener(this.f1321n);
        this.f1308A.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1131a(int OplusGLSurfaceView_13) {
        if (this.f1323p != OplusGLSurfaceView_13) {
            this.f1323p = OplusGLSurfaceView_13;
            this.f1324q = GravityCompat.m2773a(OplusGLSurfaceView_13, ViewCompat.m2885g(this.f1325r));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1132a(View view) {
        if (this.f1325r != view) {
            this.f1325r = view;
            this.f1324q = GravityCompat.m2773a(this.f1323p, ViewCompat.m2885g(this.f1325r));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1133a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1308A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    /* renamed from: b_ */
    public ListView mo1140b_() {
        if (this.f1310b.isEmpty()) {
            return null;
        }
        return this.f1310b.get(r1.size() - 1).m1146a();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1138b(int OplusGLSurfaceView_13) {
        this.f1327t = true;
        this.f1329v = OplusGLSurfaceView_13;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo1141c(int OplusGLSurfaceView_13) {
        this.f1328u = true;
        this.f1330w = OplusGLSurfaceView_13;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1139b(boolean z) {
        this.f1332y = z;
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: androidx.appcompat.view.menu.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final MenuPopupWindow f1341a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final MenuBuilder f1342b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public final int f1343c;

        public PlatformImplementations.kt_3(MenuPopupWindow c0311ag, MenuBuilder c0236h, int OplusGLSurfaceView_13) {
            this.f1341a = c0311ag;
            this.f1342b = c0236h;
            this.f1343c = OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public ListView m1146a() {
            return this.f1341a.mo1140b_();
        }
    }
}
