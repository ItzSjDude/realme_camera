package androidx.appcompat.view.menu;

/* compiled from: MenuBuilder.java */
/* loaded from: classes.dex */
public class h_renamed implements androidx.core.b_renamed.a_renamed.a_renamed {
    private static final java.lang.String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final java.lang.String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final java.lang.String PRESENTER_KEY = "android:menu:presenters";
    private static final java.lang.String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    private androidx.appcompat.view.menu.h_renamed.a_renamed mCallback;
    private final android.content.Context mContext;
    private android.view.ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private androidx.appcompat.view.menu.j_renamed mExpandedItem;
    private android.util.SparseArray<android.os.Parcelable> mFrozenViewStates;
    android.graphics.drawable.Drawable mHeaderIcon;
    java.lang.CharSequence mHeaderTitle;
    android.view.View mHeaderView;
    private boolean mOverrideVisibleItems;
    private boolean mQwertyMode;
    private final android.content.res.Resources mResources;
    private boolean mShortcutsVisible;
    private int mDefaultShowAsAction = 0;
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private boolean mStructureChangedWhileDispatchPrevented = false;
    private boolean mOptionalIconsVisible = false;
    private boolean mIsClosing = false;
    private java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> mTempShortcutItemList = new java.util.ArrayList<>();
    private java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed>> mPresenters = new java.util.concurrent.CopyOnWriteArrayList<>();
    private boolean mGroupDividerEnabled = false;
    private java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> mItems = new java.util.ArrayList<>();
    private java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> mVisibleItems = new java.util.ArrayList<>();
    private boolean mIsVisibleItemsStale = true;
    private java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> mActionItems = new java.util.ArrayList<>();
    private java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> mNonActionItems = new java.util.ArrayList<>();
    private boolean mIsActionItemsStale = true;

    /* compiled from: MenuBuilder.java */
    public interface a_renamed {
        boolean onMenuItemSelected(androidx.appcompat.view.menu.h_renamed hVar, android.view.MenuItem menuItem);

        void onMenuModeChange(androidx.appcompat.view.menu.h_renamed hVar);
    }

    /* compiled from: MenuBuilder.java */
    public interface b_renamed {
        boolean a_renamed(androidx.appcompat.view.menu.j_renamed jVar);
    }

    protected java.lang.String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public androidx.appcompat.view.menu.h_renamed getRootMenu() {
        return this;
    }

    public h_renamed(android.content.Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        setShortcutsVisibleInner(true);
    }

    public androidx.appcompat.view.menu.h_renamed setDefaultShowAsAction(int i_renamed) {
        this.mDefaultShowAsAction = i_renamed;
        return this;
    }

    public void addMenuPresenter(androidx.appcompat.view.menu.n_renamed nVar) {
        addMenuPresenter(nVar, this.mContext);
    }

    public void addMenuPresenter(androidx.appcompat.view.menu.n_renamed nVar, android.content.Context context) {
        this.mPresenters.add(new java.lang.ref.WeakReference<>(nVar));
        nVar.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    public void removeMenuPresenter(androidx.appcompat.view.menu.n_renamed nVar) {
        java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed> next = it.next();
            androidx.appcompat.view.menu.n_renamed nVar2 = next.get();
            if (nVar2 == null || nVar2 == nVar) {
                this.mPresenters.remove(next);
            }
        }
    }

    private void dispatchPresenterUpdate(boolean z_renamed) {
        if (this.mPresenters.isEmpty()) {
            return;
        }
        stopDispatchingItemsChanged();
        java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed> next = it.next();
            androidx.appcompat.view.menu.n_renamed nVar = next.get();
            if (nVar == null) {
                this.mPresenters.remove(next);
            } else {
                nVar.updateMenuView(z_renamed);
            }
        }
        startDispatchingItemsChanged();
    }

    private boolean dispatchSubMenuSelected(androidx.appcompat.view.menu.s_renamed sVar, androidx.appcompat.view.menu.n_renamed nVar) {
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        boolean zOnSubMenuSelected = nVar != null ? nVar.onSubMenuSelected(sVar) : false;
        java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed> next = it.next();
            androidx.appcompat.view.menu.n_renamed nVar2 = next.get();
            if (nVar2 == null) {
                this.mPresenters.remove(next);
            } else if (!zOnSubMenuSelected) {
                zOnSubMenuSelected = nVar2.onSubMenuSelected(sVar);
            }
        }
        return zOnSubMenuSelected;
    }

    private void dispatchSaveInstanceState(android.os.Bundle bundle) {
        android.os.Parcelable parcelableOnSaveInstanceState;
        if (this.mPresenters.isEmpty()) {
            return;
        }
        android.util.SparseArray<? extends android.os.Parcelable> sparseArray = new android.util.SparseArray<>();
        java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed> next = it.next();
            androidx.appcompat.view.menu.n_renamed nVar = next.get();
            if (nVar == null) {
                this.mPresenters.remove(next);
            } else {
                int id_renamed = nVar.getId();
                if (id_renamed > 0 && (parcelableOnSaveInstanceState = nVar.onSaveInstanceState()) != null) {
                    sparseArray.put(id_renamed, parcelableOnSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray(PRESENTER_KEY, sparseArray);
    }

    private void dispatchRestoreInstanceState(android.os.Bundle bundle) {
        android.os.Parcelable parcelable;
        android.util.SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(PRESENTER_KEY);
        if (sparseParcelableArray == null || this.mPresenters.isEmpty()) {
            return;
        }
        java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed> next = it.next();
            androidx.appcompat.view.menu.n_renamed nVar = next.get();
            if (nVar == null) {
                this.mPresenters.remove(next);
            } else {
                int id_renamed = nVar.getId();
                if (id_renamed > 0 && (parcelable = (android.os.Parcelable) sparseParcelableArray.get(id_renamed)) != null) {
                    nVar.onRestoreInstanceState(parcelable);
                }
            }
        }
    }

    public void savePresenterStates(android.os.Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void restorePresenterStates(android.os.Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(android.os.Bundle bundle) {
        int size = size();
        android.util.SparseArray<? extends android.os.Parcelable> sparseArray = null;
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.view.MenuItem item = getItem(i_renamed);
            android.view.View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new android.util.SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((androidx.appcompat.view.menu.s_renamed) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void restoreActionViewStates(android.os.Bundle bundle) {
        android.view.MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        android.util.SparseArray<android.os.Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int size = size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.view.MenuItem item = getItem(i_renamed);
            android.view.View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((androidx.appcompat.view.menu.s_renamed) item.getSubMenu()).restoreActionViewStates(bundle);
            }
        }
        int i2 = bundle.getInt(EXPANDED_ACTION_VIEW_ID);
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void setCallback(androidx.appcompat.view.menu.h_renamed.a_renamed aVar) {
        this.mCallback = aVar;
    }

    protected android.view.MenuItem addInternal(int i_renamed, int i2, int i3, java.lang.CharSequence charSequence) {
        int ordering = getOrdering(i3);
        androidx.appcompat.view.menu.j_renamed jVarCreateNewMenuItem = createNewMenuItem(i_renamed, i2, i3, ordering, charSequence, this.mDefaultShowAsAction);
        android.view.ContextMenu.ContextMenuInfo contextMenuInfo = this.mCurrentMenuInfo;
        if (contextMenuInfo != null) {
            jVarCreateNewMenuItem.a_renamed(contextMenuInfo);
        }
        java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> arrayList = this.mItems;
        arrayList.add(findInsertIndex(arrayList, ordering), jVarCreateNewMenuItem);
        onItemsChanged(true);
        return jVarCreateNewMenuItem;
    }

    private androidx.appcompat.view.menu.j_renamed createNewMenuItem(int i_renamed, int i2, int i3, int i4, java.lang.CharSequence charSequence, int i5) {
        return new androidx.appcompat.view.menu.j_renamed(this, i_renamed, i2, i3, i4, charSequence, i5);
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(java.lang.CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(int i_renamed) {
        return addInternal(0, 0, 0, this.mResources.getString(i_renamed));
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(int i_renamed, int i2, int i3, java.lang.CharSequence charSequence) {
        return addInternal(i_renamed, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public android.view.MenuItem add(int i_renamed, int i2, int i3, int i4) {
        return addInternal(i_renamed, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(java.lang.CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(int i_renamed) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i_renamed));
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(int i_renamed, int i2, int i3, java.lang.CharSequence charSequence) {
        androidx.appcompat.view.menu.j_renamed jVar = (androidx.appcompat.view.menu.j_renamed) addInternal(i_renamed, i2, i3, charSequence);
        androidx.appcompat.view.menu.s_renamed sVar = new androidx.appcompat.view.menu.s_renamed(this.mContext, this, jVar);
        jVar.a_renamed(sVar);
        return sVar;
    }

    @Override // android.view.Menu
    public android.view.SubMenu addSubMenu(int i_renamed, int i2, int i3, int i4) {
        return addSubMenu(i_renamed, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z_renamed) {
        this.mGroupDividerEnabled = z_renamed;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i_renamed, int i2, int i3, android.content.ComponentName componentName, android.content.Intent[] intentArr, android.content.Intent intent, int i4, android.view.MenuItem[] menuItemArr) {
        android.content.pm.PackageManager packageManager = this.mContext.getPackageManager();
        java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i_renamed);
        }
        for (int i5 = 0; i5 < size; i5++) {
            android.content.pm.ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i5);
            android.content.Intent intent2 = new android.content.Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new android.content.ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            android.view.MenuItem intent3 = add(i_renamed, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public void removeItem(int i_renamed) {
        removeItemAtInt(findItemIndex(i_renamed), true);
    }

    @Override // android.view.Menu
    public void removeGroup(int i_renamed) {
        int iFindGroupIndex = findGroupIndex(i_renamed);
        if (iFindGroupIndex >= 0) {
            int size = this.mItems.size() - iFindGroupIndex;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.mItems.get(iFindGroupIndex).getGroupId() != i_renamed) {
                    break;
                }
                removeItemAtInt(iFindGroupIndex, false);
                i2 = i3;
            }
            onItemsChanged(true);
        }
    }

    private void removeItemAtInt(int i_renamed, boolean z_renamed) {
        if (i_renamed < 0 || i_renamed >= this.mItems.size()) {
            return;
        }
        this.mItems.remove(i_renamed);
        if (z_renamed) {
            onItemsChanged(true);
        }
    }

    public void removeItemAt(int i_renamed) {
        removeItemAtInt(i_renamed, true);
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
        androidx.appcompat.view.menu.j_renamed jVar = this.mExpandedItem;
        if (jVar != null) {
            collapseItemActionView(jVar);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    void setExclusiveItemChecked(android.view.MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.mItems.size();
        stopDispatchingItemsChanged();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.appcompat.view.menu.j_renamed jVar = this.mItems.get(i_renamed);
            if (jVar.getGroupId() == groupId && jVar.g_renamed() && jVar.isCheckable()) {
                jVar.b_renamed(jVar == menuItem);
            }
        }
        startDispatchingItemsChanged();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i_renamed, boolean z_renamed, boolean z2) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.appcompat.view.menu.j_renamed jVar = this.mItems.get(i2);
            if (jVar.getGroupId() == i_renamed) {
                jVar.a_renamed(z2);
                jVar.setCheckable(z_renamed);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i_renamed, boolean z_renamed) {
        int size = this.mItems.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            androidx.appcompat.view.menu.j_renamed jVar = this.mItems.get(i2);
            if (jVar.getGroupId() == i_renamed && jVar.c_renamed(z_renamed)) {
                z2 = true;
            }
        }
        if (z2) {
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i_renamed, boolean z_renamed) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.appcompat.view.menu.j_renamed jVar = this.mItems.get(i2);
            if (jVar.getGroupId() == i_renamed) {
                jVar.setEnabled(z_renamed);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        int size = size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (this.mItems.get(i_renamed).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public android.view.MenuItem findItem(int i_renamed) {
        android.view.MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.appcompat.view.menu.j_renamed jVar = this.mItems.get(i2);
            if (jVar.getItemId() == i_renamed) {
                return jVar;
            }
            if (jVar.hasSubMenu() && (menuItemFindItem = jVar.getSubMenu().findItem(i_renamed)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i_renamed) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mItems.get(i2).getItemId() == i_renamed) {
                return i2;
            }
        }
        return -1;
    }

    public int findGroupIndex(int i_renamed) {
        return findGroupIndex(i_renamed, 0);
    }

    public int findGroupIndex(int i_renamed, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.mItems.get(i2).getGroupId() == i_renamed) {
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
    public android.view.MenuItem getItem(int i_renamed) {
        return this.mItems.get(i_renamed);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i_renamed, android.view.KeyEvent keyEvent) {
        return findItemWithShortcutForKey(i_renamed, keyEvent) != null;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z_renamed) {
        this.mQwertyMode = z_renamed;
        onItemsChanged(false);
    }

    private static int getOrdering(int i_renamed) {
        int i2 = ((-65536) & i_renamed) >> 16;
        if (i2 >= 0) {
            int[] iArr = sCategoryToOrder;
            if (i2 < iArr.length) {
                return (i_renamed & com.meicam.sdk.NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN) | (iArr[i2] << 16);
            }
        }
        throw new java.lang.IllegalArgumentException("order does not contain a_renamed valid category.");
    }

    boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    public void setShortcutsVisible(boolean z_renamed) {
        if (this.mShortcutsVisible == z_renamed) {
            return;
        }
        setShortcutsVisibleInner(z_renamed);
        onItemsChanged(false);
    }

    private void setShortcutsVisibleInner(boolean z_renamed) {
        this.mShortcutsVisible = z_renamed && this.mResources.getConfiguration().keyboard != 1 && androidx.core.h_renamed.w_renamed.c_renamed(android.view.ViewConfiguration.get(this.mContext), this.mContext);
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    android.content.res.Resources getResources() {
        return this.mResources;
    }

    public android.content.Context getContext() {
        return this.mContext;
    }

    boolean dispatchMenuItemSelected(androidx.appcompat.view.menu.h_renamed hVar, android.view.MenuItem menuItem) {
        androidx.appcompat.view.menu.h_renamed.a_renamed aVar = this.mCallback;
        return aVar != null && aVar.onMenuItemSelected(hVar, menuItem);
    }

    public void changeMenuMode() {
        androidx.appcompat.view.menu.h_renamed.a_renamed aVar = this.mCallback;
        if (aVar != null) {
            aVar.onMenuModeChange(this);
        }
    }

    private static int findInsertIndex(java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> arrayList, int i_renamed) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c_renamed() <= i_renamed) {
                return size + 1;
            }
        }
        return 0;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i_renamed, android.view.KeyEvent keyEvent, int i2) {
        androidx.appcompat.view.menu.j_renamed jVarFindItemWithShortcutForKey = findItemWithShortcutForKey(i_renamed, keyEvent);
        boolean zPerformItemAction = jVarFindItemWithShortcutForKey != null ? performItemAction(jVarFindItemWithShortcutForKey, i2) : false;
        if ((i2 & 2) != 0) {
            close(true);
        }
        return zPerformItemAction;
    }

    void findItemsWithShortcutForKey(java.util.List<androidx.appcompat.view.menu.j_renamed> list, int i_renamed, android.view.KeyEvent keyEvent) {
        boolean zIsQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        android.view.KeyCharacterMap.KeyData keyData = new android.view.KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i_renamed == 67) {
            int size = this.mItems.size();
            for (int i2 = 0; i2 < size; i2++) {
                androidx.appcompat.view.menu.j_renamed jVar = this.mItems.get(i2);
                if (jVar.hasSubMenu()) {
                    ((androidx.appcompat.view.menu.h_renamed) jVar.getSubMenu()).findItemsWithShortcutForKey(list, i_renamed, keyEvent);
                }
                char alphabeticShortcut = zIsQwertyMode ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
                if (((modifiers & 69647) == ((zIsQwertyMode ? jVar.getAlphabeticModifiers() : jVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (zIsQwertyMode && alphabeticShortcut == '\b_renamed' && i_renamed == 67)) && jVar.isEnabled())) {
                    list.add(jVar);
                }
            }
        }
    }

    androidx.appcompat.view.menu.j_renamed findItemWithShortcutForKey(int i_renamed, android.view.KeyEvent keyEvent) {
        char numericShortcut;
        java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, i_renamed, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        android.view.KeyCharacterMap.KeyData keyData = new android.view.KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zIsQwertyMode = isQwertyMode();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.appcompat.view.menu.j_renamed jVar = arrayList.get(i2);
            if (zIsQwertyMode) {
                numericShortcut = jVar.getAlphabeticShortcut();
            } else {
                numericShortcut = jVar.getNumericShortcut();
            }
            if ((numericShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((numericShortcut == keyData.meta[2] && (metaState & 2) != 0) || (zIsQwertyMode && numericShortcut == '\b_renamed' && i_renamed == 67))) {
                return jVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i_renamed, int i2) {
        return performItemAction(findItem(i_renamed), i2);
    }

    public boolean performItemAction(android.view.MenuItem menuItem, int i_renamed) {
        return performItemAction(menuItem, null, i_renamed);
    }

    public boolean performItemAction(android.view.MenuItem menuItem, androidx.appcompat.view.menu.n_renamed nVar, int i_renamed) {
        androidx.appcompat.view.menu.j_renamed jVar = (androidx.appcompat.view.menu.j_renamed) menuItem;
        if (jVar == null || !jVar.isEnabled()) {
            return false;
        }
        boolean zB = jVar.b_renamed();
        androidx.core.h_renamed.b_renamed bVarA = jVar.a_renamed();
        boolean z_renamed = bVarA != null && bVarA.c_renamed();
        if (jVar.m_renamed()) {
            zB |= jVar.expandActionView();
            if (zB) {
                close(true);
            }
        } else if (jVar.hasSubMenu() || z_renamed) {
            if ((i_renamed & 4) == 0) {
                close(false);
            }
            if (!jVar.hasSubMenu()) {
                jVar.a_renamed(new androidx.appcompat.view.menu.s_renamed(getContext(), this, jVar));
            }
            androidx.appcompat.view.menu.s_renamed sVar = (androidx.appcompat.view.menu.s_renamed) jVar.getSubMenu();
            if (z_renamed) {
                bVarA.a_renamed(sVar);
            }
            zB |= dispatchSubMenuSelected(sVar, nVar);
            if (!zB) {
                close(true);
            }
        } else if ((i_renamed & 1) == 0) {
            close(true);
        }
        return zB;
    }

    public final void close(boolean z_renamed) {
        if (this.mIsClosing) {
            return;
        }
        this.mIsClosing = true;
        java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed> next = it.next();
            androidx.appcompat.view.menu.n_renamed nVar = next.get();
            if (nVar == null) {
                this.mPresenters.remove(next);
            } else {
                nVar.onCloseMenu(this, z_renamed);
            }
        }
        this.mIsClosing = false;
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }

    public void onItemsChanged(boolean z_renamed) {
        if (!this.mPreventDispatchingItemsChanged) {
            if (z_renamed) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }
            dispatchPresenterUpdate(z_renamed);
            return;
        }
        this.mItemsChangedWhileDispatchPrevented = true;
        if (z_renamed) {
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

    void onItemVisibleChanged(androidx.appcompat.view.menu.j_renamed jVar) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    void onItemActionRequestChanged(androidx.appcompat.view.menu.j_renamed jVar) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    public java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> getVisibleItems() {
        if (!this.mIsVisibleItemsStale) {
            return this.mVisibleItems;
        }
        this.mVisibleItems.clear();
        int size = this.mItems.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.appcompat.view.menu.j_renamed jVar = this.mItems.get(i_renamed);
            if (jVar.isVisible()) {
                this.mVisibleItems.add(jVar);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    }

    public void flagActionItems() {
        java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> visibleItems = getVisibleItems();
        if (this.mIsActionItemsStale) {
            java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed>> it = this.mPresenters.iterator();
            boolean zFlagActionItems = false;
            while (it.hasNext()) {
                java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed> next = it.next();
                androidx.appcompat.view.menu.n_renamed nVar = next.get();
                if (nVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    zFlagActionItems |= nVar.flagActionItems();
                }
            }
            if (zFlagActionItems) {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                int size = visibleItems.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    androidx.appcompat.view.menu.j_renamed jVar = visibleItems.get(i_renamed);
                    if (jVar.j_renamed()) {
                        this.mActionItems.add(jVar);
                    } else {
                        this.mNonActionItems.add(jVar);
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

    public java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    public java.util.ArrayList<androidx.appcompat.view.menu.j_renamed> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    private void setHeaderInternal(int i_renamed, java.lang.CharSequence charSequence, int i2, android.graphics.drawable.Drawable drawable, android.view.View view) {
        android.content.res.Resources resources = getResources();
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (i_renamed > 0) {
                this.mHeaderTitle = resources.getText(i_renamed);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i2 > 0) {
                this.mHeaderIcon = androidx.core.a_renamed.a_renamed.a_renamed(getContext(), i2);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    protected androidx.appcompat.view.menu.h_renamed setHeaderTitleInt(java.lang.CharSequence charSequence) {
        setHeaderInternal(0, charSequence, 0, null, null);
        return this;
    }

    protected androidx.appcompat.view.menu.h_renamed setHeaderTitleInt(int i_renamed) {
        setHeaderInternal(i_renamed, null, 0, null, null);
        return this;
    }

    protected androidx.appcompat.view.menu.h_renamed setHeaderIconInt(android.graphics.drawable.Drawable drawable) {
        setHeaderInternal(0, null, 0, drawable, null);
        return this;
    }

    protected androidx.appcompat.view.menu.h_renamed setHeaderIconInt(int i_renamed) {
        setHeaderInternal(0, null, i_renamed, null, null);
        return this;
    }

    protected androidx.appcompat.view.menu.h_renamed setHeaderViewInt(android.view.View view) {
        setHeaderInternal(0, null, 0, null, view);
        return this;
    }

    public java.lang.CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public android.graphics.drawable.Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public android.view.View getHeaderView() {
        return this.mHeaderView;
    }

    public void setCurrentMenuInfo(android.view.ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mCurrentMenuInfo = contextMenuInfo;
    }

    public void setOptionalIconsVisible(boolean z_renamed) {
        this.mOptionalIconsVisible = z_renamed;
    }

    boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    public boolean expandItemActionView(androidx.appcompat.view.menu.j_renamed jVar) {
        boolean zExpandItemActionView = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed> next = it.next();
            androidx.appcompat.view.menu.n_renamed nVar = next.get();
            if (nVar == null) {
                this.mPresenters.remove(next);
            } else {
                zExpandItemActionView = nVar.expandItemActionView(this, jVar);
                if (zExpandItemActionView) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (zExpandItemActionView) {
            this.mExpandedItem = jVar;
        }
        return zExpandItemActionView;
    }

    public boolean collapseItemActionView(androidx.appcompat.view.menu.j_renamed jVar) {
        boolean zCollapseItemActionView = false;
        if (!this.mPresenters.isEmpty() && this.mExpandedItem == jVar) {
            stopDispatchingItemsChanged();
            java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                java.lang.ref.WeakReference<androidx.appcompat.view.menu.n_renamed> next = it.next();
                androidx.appcompat.view.menu.n_renamed nVar = next.get();
                if (nVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    zCollapseItemActionView = nVar.collapseItemActionView(this, jVar);
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

    public androidx.appcompat.view.menu.j_renamed getExpandedItem() {
        return this.mExpandedItem;
    }

    public void setOverrideVisibleItems(boolean z_renamed) {
        this.mOverrideVisibleItems = z_renamed;
    }
}
