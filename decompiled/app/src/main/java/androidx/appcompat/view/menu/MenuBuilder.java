package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.p027a.ContextCompat;
import androidx.core.p029b.p030a.SupportMenu;
import androidx.core.p036h.ActionProvider;
import androidx.core.p036h.ViewConfigurationCompat;
import com.meicam.sdk.NvsMediaFileConvertor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuBuilder.java */
/* renamed from: androidx.appcompat.view.menu.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class MenuBuilder implements SupportMenu {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    private PlatformImplementations.kt_3 mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private MenuItemImpl mExpandedItem;
    private SparseArray<Parcelable> mFrozenViewStates;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mOverrideVisibleItems;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private int mDefaultShowAsAction = 0;
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private boolean mStructureChangedWhileDispatchPrevented = false;
    private boolean mOptionalIconsVisible = false;
    private boolean mIsClosing = false;
    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList<>();
    private boolean mGroupDividerEnabled = false;
    private ArrayList<MenuItemImpl> mItems = new ArrayList<>();
    private ArrayList<MenuItemImpl> mVisibleItems = new ArrayList<>();
    private boolean mIsVisibleItemsStale = true;
    private ArrayList<MenuItemImpl> mActionItems = new ArrayList<>();
    private ArrayList<MenuItemImpl> mNonActionItems = new ArrayList<>();
    private boolean mIsActionItemsStale = true;

    /* compiled from: MenuBuilder.java */
    /* renamed from: androidx.appcompat.view.menu.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        boolean onMenuItemSelected(MenuBuilder c0236h, MenuItem menuItem);

        void onMenuModeChange(MenuBuilder c0236h);
    }

    /* compiled from: MenuBuilder.java */
    /* renamed from: androidx.appcompat.view.menu.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo1087a(MenuItemImpl c0238j);
    }

    protected String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    public MenuBuilder(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        setShortcutsVisibleInner(true);
    }

    public MenuBuilder setDefaultShowAsAction(int OplusGLSurfaceView_13) {
        this.mDefaultShowAsAction = OplusGLSurfaceView_13;
        return this;
    }

    public void addMenuPresenter(MenuPresenter interfaceC0242n) {
        addMenuPresenter(interfaceC0242n, this.mContext);
    }

    public void addMenuPresenter(MenuPresenter interfaceC0242n, Context context) {
        this.mPresenters.add(new WeakReference<>(interfaceC0242n));
        interfaceC0242n.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    public void removeMenuPresenter(MenuPresenter interfaceC0242n) {
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter interfaceC0242n2 = next.get();
            if (interfaceC0242n2 == null || interfaceC0242n2 == interfaceC0242n) {
                this.mPresenters.remove(next);
            }
        }
    }

    private void dispatchPresenterUpdate(boolean z) {
        if (this.mPresenters.isEmpty()) {
            return;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter interfaceC0242n = next.get();
            if (interfaceC0242n == null) {
                this.mPresenters.remove(next);
            } else {
                interfaceC0242n.updateMenuView(z);
            }
        }
        startDispatchingItemsChanged();
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenuC0247s, MenuPresenter interfaceC0242n) {
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        boolean zOnSubMenuSelected = interfaceC0242n != null ? interfaceC0242n.onSubMenuSelected(subMenuC0247s) : false;
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter interfaceC0242n2 = next.get();
            if (interfaceC0242n2 == null) {
                this.mPresenters.remove(next);
            } else if (!zOnSubMenuSelected) {
                zOnSubMenuSelected = interfaceC0242n2.onSubMenuSelected(subMenuC0247s);
            }
        }
        return zOnSubMenuSelected;
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        Parcelable parcelableOnSaveInstanceState;
        if (this.mPresenters.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter interfaceC0242n = next.get();
            if (interfaceC0242n == null) {
                this.mPresenters.remove(next);
            } else {
                int id_renamed = interfaceC0242n.getId();
                if (id_renamed > 0 && (parcelableOnSaveInstanceState = interfaceC0242n.onSaveInstanceState()) != null) {
                    sparseArray.put(id_renamed, parcelableOnSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray(PRESENTER_KEY, sparseArray);
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(PRESENTER_KEY);
        if (sparseParcelableArray == null || this.mPresenters.isEmpty()) {
            return;
        }
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter interfaceC0242n = next.get();
            if (interfaceC0242n == null) {
                this.mPresenters.remove(next);
            } else {
                int id_renamed = interfaceC0242n.getId();
                if (id_renamed > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id_renamed)) != null) {
                    interfaceC0242n.onRestoreInstanceState(parcelable);
                }
            }
        }
    }

    public void savePresenterStates(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void restorePresenterStates(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            MenuItem item = getItem(OplusGLSurfaceView_13);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int size = size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            MenuItem item = getItem(OplusGLSurfaceView_13);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
            }
        }
        int i2 = bundle.getInt(EXPANDED_ACTION_VIEW_ID);
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void setCallback(PlatformImplementations.kt_3 aVar) {
        this.mCallback = aVar;
    }

    protected MenuItem addInternal(int OplusGLSurfaceView_13, int i2, int i3, CharSequence charSequence) {
        int ordering = getOrdering(i3);
        MenuItemImpl c0238jCreateNewMenuItem = createNewMenuItem(OplusGLSurfaceView_13, i2, i3, ordering, charSequence, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.mCurrentMenuInfo;
        if (contextMenuInfo != null) {
            c0238jCreateNewMenuItem.m1164a(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.mItems;
        arrayList.add(findInsertIndex(arrayList, ordering), c0238jCreateNewMenuItem);
        onItemsChanged(true);
        return c0238jCreateNewMenuItem;
    }

    private MenuItemImpl createNewMenuItem(int OplusGLSurfaceView_13, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new MenuItemImpl(this, OplusGLSurfaceView_13, i2, i3, i4, charSequence, i5);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int OplusGLSurfaceView_13) {
        return addInternal(0, 0, 0, this.mResources.getString(OplusGLSurfaceView_13));
    }

    @Override // android.view.Menu
    public MenuItem add(int OplusGLSurfaceView_13, int i2, int i3, CharSequence charSequence) {
        return addInternal(OplusGLSurfaceView_13, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return addInternal(OplusGLSurfaceView_13, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int OplusGLSurfaceView_13) {
        return addSubMenu(0, 0, 0, this.mResources.getString(OplusGLSurfaceView_13));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int OplusGLSurfaceView_13, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl c0238j = (MenuItemImpl) addInternal(OplusGLSurfaceView_13, i2, i3, charSequence);
        SubMenuBuilder subMenuC0247s = new SubMenuBuilder(this.mContext, this, c0238j);
        c0238j.m1165a(subMenuC0247s);
        return subMenuC0247s;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return addSubMenu(OplusGLSurfaceView_13, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.mGroupDividerEnabled = z;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int OplusGLSurfaceView_13, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(OplusGLSurfaceView_13);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(OplusGLSurfaceView_13, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public void removeItem(int OplusGLSurfaceView_13) {
        removeItemAtInt(findItemIndex(OplusGLSurfaceView_13), true);
    }

    @Override // android.view.Menu
    public void removeGroup(int OplusGLSurfaceView_13) {
        int iFindGroupIndex = findGroupIndex(OplusGLSurfaceView_13);
        if (iFindGroupIndex >= 0) {
            int size = this.mItems.size() - iFindGroupIndex;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.mItems.get(iFindGroupIndex).getGroupId() != OplusGLSurfaceView_13) {
                    break;
                }
                removeItemAtInt(iFindGroupIndex, false);
                i2 = i3;
            }
            onItemsChanged(true);
        }
    }

    private void removeItemAtInt(int OplusGLSurfaceView_13, boolean z) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= this.mItems.size()) {
            return;
        }
        this.mItems.remove(OplusGLSurfaceView_13);
        if (z) {
            onItemsChanged(true);
        }
    }

    public void removeItemAt(int OplusGLSurfaceView_13) {
        removeItemAtInt(OplusGLSurfaceView_13, true);
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl c0238j = this.mExpandedItem;
        if (c0238j != null) {
            collapseItemActionView(c0238j);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    void setExclusiveItemChecked(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.mItems.size();
        stopDispatchingItemsChanged();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            MenuItemImpl c0238j = this.mItems.get(OplusGLSurfaceView_13);
            if (c0238j.getGroupId() == groupId && c0238j.m1177g() && c0238j.isCheckable()) {
                c0238j.m1168b(c0238j == menuItem);
            }
        }
        startDispatchingItemsChanged();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl c0238j = this.mItems.get(i2);
            if (c0238j.getGroupId() == OplusGLSurfaceView_13) {
                c0238j.m1166a(z2);
                c0238j.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int OplusGLSurfaceView_13, boolean z) {
        int size = this.mItems.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl c0238j = this.mItems.get(i2);
            if (c0238j.getGroupId() == OplusGLSurfaceView_13 && c0238j.m1171c(z)) {
                z2 = true;
            }
        }
        if (z2) {
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int OplusGLSurfaceView_13, boolean z) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl c0238j = this.mItems.get(i2);
            if (c0238j.getGroupId() == OplusGLSurfaceView_13) {
                c0238j.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        int size = size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            if (this.mItems.get(OplusGLSurfaceView_13).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int OplusGLSurfaceView_13) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl c0238j = this.mItems.get(i2);
            if (c0238j.getItemId() == OplusGLSurfaceView_13) {
                return c0238j;
            }
            if (c0238j.hasSubMenu() && (menuItemFindItem = c0238j.getSubMenu().findItem(OplusGLSurfaceView_13)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public int findItemIndex(int OplusGLSurfaceView_13) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mItems.get(i2).getItemId() == OplusGLSurfaceView_13) {
                return i2;
            }
        }
        return -1;
    }

    public int findGroupIndex(int OplusGLSurfaceView_13) {
        return findGroupIndex(OplusGLSurfaceView_13, 0);
    }

    public int findGroupIndex(int OplusGLSurfaceView_13, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.mItems.get(i2).getGroupId() == OplusGLSurfaceView_13) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public int size() {
        return this.mItems.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int OplusGLSurfaceView_13) {
        return this.mItems.get(OplusGLSurfaceView_13);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        return findItemWithShortcutForKey(OplusGLSurfaceView_13, keyEvent) != null;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.mQwertyMode = z;
        onItemsChanged(false);
    }

    private static int getOrdering(int OplusGLSurfaceView_13) {
        int i2 = ((-65536) & OplusGLSurfaceView_13) >> 16;
        if (i2 >= 0) {
            int[] iArr = sCategoryToOrder;
            if (i2 < iArr.length) {
                return (OplusGLSurfaceView_13 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain PlatformImplementations.kt_3 valid category.");
    }

    boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    public void setShortcutsVisible(boolean z) {
        if (this.mShortcutsVisible == z) {
            return;
        }
        setShortcutsVisibleInner(z);
        onItemsChanged(false);
    }

    private void setShortcutsVisibleInner(boolean z) {
        this.mShortcutsVisible = z && this.mResources.getConfiguration().keyboard != 1 && ViewConfigurationCompat.m2933c(ViewConfiguration.get(this.mContext), this.mContext);
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    Resources getResources() {
        return this.mResources;
    }

    public Context getContext() {
        return this.mContext;
    }

    boolean dispatchMenuItemSelected(MenuBuilder c0236h, MenuItem menuItem) {
        PlatformImplementations.kt_3 aVar = this.mCallback;
        return aVar != null && aVar.onMenuItemSelected(c0236h, menuItem);
    }

    public void changeMenuMode() {
        PlatformImplementations.kt_3 aVar = this.mCallback;
        if (aVar != null) {
            aVar.onMenuModeChange(this);
        }
    }

    private static int findInsertIndex(ArrayList<MenuItemImpl> arrayList, int OplusGLSurfaceView_13) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).m1170c() <= OplusGLSurfaceView_13) {
                return size + 1;
            }
        }
        return 0;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int OplusGLSurfaceView_13, KeyEvent keyEvent, int i2) {
        MenuItemImpl c0238jFindItemWithShortcutForKey = findItemWithShortcutForKey(OplusGLSurfaceView_13, keyEvent);
        boolean zPerformItemAction = c0238jFindItemWithShortcutForKey != null ? performItemAction(c0238jFindItemWithShortcutForKey, i2) : false;
        if ((i2 & 2) != 0) {
            close(true);
        }
        return zPerformItemAction;
    }

    void findItemsWithShortcutForKey(List<MenuItemImpl> list, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        boolean zIsQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || OplusGLSurfaceView_13 == 67) {
            int size = this.mItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItemImpl c0238j = this.mItems.get(i2);
                if (c0238j.hasSubMenu()) {
                    ((MenuBuilder) c0238j.getSubMenu()).findItemsWithShortcutForKey(list, OplusGLSurfaceView_13, keyEvent);
                }
                char alphabeticShortcut = zIsQwertyMode ? c0238j.getAlphabeticShortcut() : c0238j.getNumericShortcut();
                if (((modifiers & 69647) == ((zIsQwertyMode ? c0238j.getAlphabeticModifiers() : c0238j.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (zIsQwertyMode && alphabeticShortcut == '\IntrinsicsJvm.kt_4' && OplusGLSurfaceView_13 == 67)) && c0238j.isEnabled())) {
                    list.add(c0238j);
                }
            }
        }
    }

    MenuItemImpl findItemWithShortcutForKey(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<MenuItemImpl> arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, OplusGLSurfaceView_13, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zIsQwertyMode = isQwertyMode();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl c0238j = arrayList.get(i2);
            if (zIsQwertyMode) {
                numericShortcut = c0238j.getAlphabeticShortcut();
            } else {
                numericShortcut = c0238j.getNumericShortcut();
            }
            if ((numericShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((numericShortcut == keyData.meta[2] && (metaState & 2) != 0) || (zIsQwertyMode && numericShortcut == '\IntrinsicsJvm.kt_4' && OplusGLSurfaceView_13 == 67))) {
                return c0238j;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int OplusGLSurfaceView_13, int i2) {
        return performItemAction(findItem(OplusGLSurfaceView_13), i2);
    }

    public boolean performItemAction(MenuItem menuItem, int OplusGLSurfaceView_13) {
        return performItemAction(menuItem, null, OplusGLSurfaceView_13);
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter interfaceC0242n, int OplusGLSurfaceView_13) {
        MenuItemImpl c0238j = (MenuItemImpl) menuItem;
        if (c0238j == null || !c0238j.isEnabled()) {
            return false;
        }
        boolean zM1169b = c0238j.m1169b();
        ActionProvider abstractC0491bMo1099a = c0238j.mo1099a();
        boolean z = abstractC0491bMo1099a != null && abstractC0491bMo1099a.mo1189c();
        if (c0238j.m1183m()) {
            zM1169b |= c0238j.expandActionView();
            if (zM1169b) {
                close(true);
            }
        } else if (c0238j.hasSubMenu() || z) {
            if ((OplusGLSurfaceView_13 & 4) == 0) {
                close(false);
            }
            if (!c0238j.hasSubMenu()) {
                c0238j.m1165a(new SubMenuBuilder(getContext(), this, c0238j));
            }
            SubMenuBuilder subMenuC0247s = (SubMenuBuilder) c0238j.getSubMenu();
            if (z) {
                abstractC0491bMo1099a.mo1187a(subMenuC0247s);
            }
            zM1169b |= dispatchSubMenuSelected(subMenuC0247s, interfaceC0242n);
            if (!zM1169b) {
                close(true);
            }
        } else if ((OplusGLSurfaceView_13 & 1) == 0) {
            close(true);
        }
        return zM1169b;
    }

    public final void close(boolean z) {
        if (this.mIsClosing) {
            return;
        }
        this.mIsClosing = true;
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter interfaceC0242n = next.get();
            if (interfaceC0242n == null) {
                this.mPresenters.remove(next);
            } else {
                interfaceC0242n.onCloseMenu(this, z);
            }
        }
        this.mIsClosing = false;
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }

    public void onItemsChanged(boolean z) {
        if (!this.mPreventDispatchingItemsChanged) {
            if (z) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }
            dispatchPresenterUpdate(z);
            return;
        }
        this.mItemsChangedWhileDispatchPrevented = true;
        if (z) {
            this.mStructureChangedWhileDispatchPrevented = true;
        }
    }

    public void stopDispatchingItemsChanged() {
        if (this.mPreventDispatchingItemsChanged) {
            return;
        }
        this.mPreventDispatchingItemsChanged = true;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    void onItemVisibleChanged(MenuItemImpl c0238j) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    void onItemActionRequestChanged(MenuItemImpl c0238j) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!this.mIsVisibleItemsStale) {
            return this.mVisibleItems;
        }
        this.mVisibleItems.clear();
        int size = this.mItems.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            MenuItemImpl c0238j = this.mItems.get(OplusGLSurfaceView_13);
            if (c0238j.isVisible()) {
                this.mVisibleItems.add(c0238j);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (this.mIsActionItemsStale) {
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            boolean zFlagActionItems = false;
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter interfaceC0242n = next.get();
                if (interfaceC0242n == null) {
                    this.mPresenters.remove(next);
                } else {
                    zFlagActionItems |= interfaceC0242n.flagActionItems();
                }
            }
            if (zFlagActionItems) {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                int size = visibleItems.size();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    MenuItemImpl c0238j = visibleItems.get(OplusGLSurfaceView_13);
                    if (c0238j.m1180j()) {
                        this.mActionItems.add(c0238j);
                    } else {
                        this.mNonActionItems.add(c0238j);
                    }
                }
            } else {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                this.mNonActionItems.addAll(getVisibleItems());
            }
            this.mIsActionItemsStale = false;
        }
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    private void setHeaderInternal(int OplusGLSurfaceView_13, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (OplusGLSurfaceView_13 > 0) {
                this.mHeaderTitle = resources.getText(OplusGLSurfaceView_13);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i2 > 0) {
                this.mHeaderIcon = ContextCompat.m2248a(getContext(), i2);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    protected MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        setHeaderInternal(0, charSequence, 0, null, null);
        return this;
    }

    protected MenuBuilder setHeaderTitleInt(int OplusGLSurfaceView_13) {
        setHeaderInternal(OplusGLSurfaceView_13, null, 0, null, null);
        return this;
    }

    protected MenuBuilder setHeaderIconInt(Drawable drawable) {
        setHeaderInternal(0, null, 0, drawable, null);
        return this;
    }

    protected MenuBuilder setHeaderIconInt(int OplusGLSurfaceView_13) {
        setHeaderInternal(0, null, OplusGLSurfaceView_13, null, null);
        return this;
    }

    protected MenuBuilder setHeaderViewInt(View view) {
        setHeaderInternal(0, null, 0, null, view);
        return this;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mCurrentMenuInfo = contextMenuInfo;
    }

    public void setOptionalIconsVisible(boolean z) {
        this.mOptionalIconsVisible = z;
    }

    boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    public boolean expandItemActionView(MenuItemImpl c0238j) {
        boolean zExpandItemActionView = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter interfaceC0242n = next.get();
            if (interfaceC0242n == null) {
                this.mPresenters.remove(next);
            } else {
                zExpandItemActionView = interfaceC0242n.expandItemActionView(this, c0238j);
                if (zExpandItemActionView) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (zExpandItemActionView) {
            this.mExpandedItem = c0238j;
        }
        return zExpandItemActionView;
    }

    public boolean collapseItemActionView(MenuItemImpl c0238j) {
        boolean zCollapseItemActionView = false;
        if (!this.mPresenters.isEmpty() && this.mExpandedItem == c0238j) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter interfaceC0242n = next.get();
                if (interfaceC0242n == null) {
                    this.mPresenters.remove(next);
                } else {
                    zCollapseItemActionView = interfaceC0242n.collapseItemActionView(this, c0238j);
                    if (zCollapseItemActionView) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (zCollapseItemActionView) {
                this.mExpandedItem = null;
            }
        }
        return zCollapseItemActionView;
    }

    public MenuItemImpl getExpandedItem() {
        return this.mExpandedItem;
    }

    public void setOverrideVisibleItems(boolean z) {
        this.mOverrideVisibleItems = z;
    }
}
