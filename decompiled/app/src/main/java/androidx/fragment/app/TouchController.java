package androidx.fragment.app;

/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
class l_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int[] f1177a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final androidx.fragment.app.n_renamed f1178b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final androidx.fragment.app.n_renamed f1179c;

    static {
        f1178b = android.os.Build.VERSION.SDK_INT >= 21 ? new androidx.fragment.app.m_renamed() : null;
        f1179c = a_renamed();
    }

    private static androidx.fragment.app.n_renamed a_renamed() {
        try {
            return (androidx.fragment.app.n_renamed) java.lang.Class.forName("androidx.transition.e_renamed").getDeclaredConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    static void a_renamed(androidx.fragment.app.i_renamed iVar, java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i_renamed, int i2, boolean z_renamed) {
        if (iVar.m_renamed < 1) {
            return;
        }
        android.util.SparseArray sparseArray = new android.util.SparseArray();
        for (int i3 = i_renamed; i3 < i2; i3++) {
            androidx.fragment.app.a_renamed aVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                b_renamed(aVar, (android.util.SparseArray<androidx.fragment.app.l_renamed.a_renamed>) sparseArray, z_renamed);
            } else {
                a_renamed(aVar, (android.util.SparseArray<androidx.fragment.app.l_renamed.a_renamed>) sparseArray, z_renamed);
            }
        }
        if (sparseArray.size() != 0) {
            android.view.View view = new android.view.View(iVar.n_renamed.j_renamed());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = sparseArray.keyAt(i4);
                androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMapA = a_renamed(iKeyAt, arrayList, arrayList2, i_renamed, i2);
                androidx.fragment.app.l_renamed.a_renamed aVar2 = (androidx.fragment.app.l_renamed.a_renamed) sparseArray.valueAt(i4);
                if (z_renamed) {
                    a_renamed(iVar, iKeyAt, aVar2, view, arrayMapA);
                } else {
                    b_renamed(iVar, iKeyAt, aVar2, view, arrayMapA);
                }
            }
        }
    }

    private static androidx.collection.ArrayMap<java.lang.String, java.lang.String> a_renamed(int i_renamed, java.util.ArrayList<androidx.fragment.app.a_renamed> arrayList, java.util.ArrayList<java.lang.Boolean> arrayList2, int i2, int i3) {
        java.util.ArrayList<java.lang.String> arrayList3;
        java.util.ArrayList<java.lang.String> arrayList4;
        androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap = new androidx.collection.ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.fragment.app.a_renamed aVar = arrayList.get(i4);
            if (aVar.b_renamed(i_renamed)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                if (aVar.r_renamed != null) {
                    int size = aVar.r_renamed.size();
                    if (zBooleanValue) {
                        arrayList3 = aVar.r_renamed;
                        arrayList4 = aVar.s_renamed;
                    } else {
                        java.util.ArrayList<java.lang.String> arrayList5 = aVar.r_renamed;
                        arrayList3 = aVar.s_renamed;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        java.lang.String str = arrayList4.get(i5);
                        java.lang.String str2 = arrayList3.get(i5);
                        java.lang.String strRemove = arrayMap.remove(str2);
                        if (strRemove != null) {
                            arrayMap.put(str, strRemove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    private static void a_renamed(androidx.fragment.app.i_renamed iVar, int i_renamed, androidx.fragment.app.l_renamed.a_renamed aVar, android.view.View view, androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap) {
        androidx.fragment.app.Fragment fragment;
        androidx.fragment.app.Fragment fragment2;
        androidx.fragment.app.n_renamed nVarA;
        java.lang.Object obj;
        android.view.ViewGroup viewGroup = iVar.o_renamed.a_renamed() ? (android.view.ViewGroup) iVar.o_renamed.a_renamed(i_renamed) : null;
        if (viewGroup == null || (nVarA = a_renamed((fragment2 = aVar.d_renamed), (fragment = aVar.f1190a))) == null) {
            return;
        }
        boolean z_renamed = aVar.f1191b;
        boolean z2 = aVar.e_renamed;
        java.util.ArrayList<android.view.View> arrayList = new java.util.ArrayList<>();
        java.util.ArrayList<android.view.View> arrayList2 = new java.util.ArrayList<>();
        java.lang.Object objA = a_renamed(nVarA, fragment, z_renamed);
        java.lang.Object objB = b_renamed(nVarA, fragment2, z2);
        java.lang.Object objA2 = a_renamed(nVarA, viewGroup, view, arrayMap, aVar, arrayList2, arrayList, objA, objB);
        if (objA == null && objA2 == null) {
            obj = objB;
            if (obj == null) {
                return;
            }
        } else {
            obj = objB;
        }
        java.util.ArrayList<android.view.View> arrayListA = a_renamed(nVarA, obj, fragment2, arrayList2, view);
        java.util.ArrayList<android.view.View> arrayListA2 = a_renamed(nVarA, objA, fragment, arrayList, view);
        a_renamed(arrayListA2, 4);
        java.lang.Object objA3 = a_renamed(nVarA, objA, obj, objA2, fragment, z_renamed);
        if (objA3 != null) {
            a_renamed(nVarA, obj, fragment2, arrayListA);
            java.util.ArrayList<java.lang.String> arrayListA3 = nVarA.a_renamed(arrayList);
            nVarA.a_renamed(objA3, objA, arrayListA2, obj, arrayListA, objA2, arrayList);
            nVarA.a_renamed(viewGroup, objA3);
            nVarA.a_renamed(viewGroup, arrayList2, arrayList, arrayListA3, arrayMap);
            a_renamed(arrayListA2, 0);
            nVarA.a_renamed(objA2, arrayList2, arrayList);
        }
    }

    private static void a_renamed(androidx.fragment.app.n_renamed nVar, java.lang.Object obj, androidx.fragment.app.Fragment fragment, final java.util.ArrayList<android.view.View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            nVar.b_renamed(obj, fragment.getView(), arrayList);
            androidx.core.h_renamed.r_renamed.a_renamed(fragment.mContainer, new java.lang.Runnable() { // from class: androidx.fragment.app.l_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    androidx.fragment.app.l_renamed.a_renamed((java.util.ArrayList<android.view.View>) arrayList, 4);
                }
            });
        }
    }

    private static void b_renamed(androidx.fragment.app.i_renamed iVar, int i_renamed, androidx.fragment.app.l_renamed.a_renamed aVar, android.view.View view, androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap) {
        androidx.fragment.app.Fragment fragment;
        androidx.fragment.app.Fragment fragment2;
        androidx.fragment.app.n_renamed nVarA;
        java.lang.Object obj;
        android.view.ViewGroup viewGroup = iVar.o_renamed.a_renamed() ? (android.view.ViewGroup) iVar.o_renamed.a_renamed(i_renamed) : null;
        if (viewGroup == null || (nVarA = a_renamed((fragment2 = aVar.d_renamed), (fragment = aVar.f1190a))) == null) {
            return;
        }
        boolean z_renamed = aVar.f1191b;
        boolean z2 = aVar.e_renamed;
        java.lang.Object objA = a_renamed(nVarA, fragment, z_renamed);
        java.lang.Object objB = b_renamed(nVarA, fragment2, z2);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList<android.view.View> arrayList2 = new java.util.ArrayList<>();
        java.lang.Object objB2 = b_renamed(nVarA, viewGroup, view, arrayMap, aVar, arrayList, arrayList2, objA, objB);
        if (objA == null && objB2 == null) {
            obj = objB;
            if (obj == null) {
                return;
            }
        } else {
            obj = objB;
        }
        java.util.ArrayList<android.view.View> arrayListA = a_renamed(nVarA, obj, fragment2, (java.util.ArrayList<android.view.View>) arrayList, view);
        java.lang.Object obj2 = (arrayListA == null || arrayListA.isEmpty()) ? null : obj;
        nVarA.b_renamed(objA, view);
        java.lang.Object objA2 = a_renamed(nVarA, objA, obj2, objB2, fragment, aVar.f1191b);
        if (objA2 != null) {
            java.util.ArrayList<android.view.View> arrayList3 = new java.util.ArrayList<>();
            nVarA.a_renamed(objA2, objA, arrayList3, obj2, arrayListA, objB2, arrayList2);
            a_renamed(nVarA, viewGroup, fragment, view, arrayList2, objA, arrayList3, obj2, arrayListA);
            nVarA.a_renamed((android.view.View) viewGroup, arrayList2, (java.util.Map<java.lang.String, java.lang.String>) arrayMap);
            nVarA.a_renamed(viewGroup, objA2);
            nVarA.a_renamed(viewGroup, arrayList2, (java.util.Map<java.lang.String, java.lang.String>) arrayMap);
        }
    }

    private static void a_renamed(final androidx.fragment.app.n_renamed nVar, android.view.ViewGroup viewGroup, final androidx.fragment.app.Fragment fragment, final android.view.View view, final java.util.ArrayList<android.view.View> arrayList, final java.lang.Object obj, final java.util.ArrayList<android.view.View> arrayList2, final java.lang.Object obj2, final java.util.ArrayList<android.view.View> arrayList3) {
        androidx.core.h_renamed.r_renamed.a_renamed(viewGroup, new java.lang.Runnable() { // from class: androidx.fragment.app.l_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                java.lang.Object obj3 = obj;
                if (obj3 != null) {
                    nVar.c_renamed(obj3, view);
                    arrayList2.addAll(androidx.fragment.app.l_renamed.a_renamed(nVar, obj, fragment, (java.util.ArrayList<android.view.View>) arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        java.util.ArrayList<android.view.View> arrayList4 = new java.util.ArrayList<>();
                        arrayList4.add(view);
                        nVar.b_renamed(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static androidx.fragment.app.n_renamed a_renamed(androidx.fragment.app.Fragment fragment, androidx.fragment.app.Fragment fragment2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (fragment != null) {
            java.lang.Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            java.lang.Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            java.lang.Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            java.lang.Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            java.lang.Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            java.lang.Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        androidx.fragment.app.n_renamed nVar = f1178b;
        if (nVar != null && a_renamed(nVar, arrayList)) {
            return f1178b;
        }
        androidx.fragment.app.n_renamed nVar2 = f1179c;
        if (nVar2 != null && a_renamed(nVar2, arrayList)) {
            return f1179c;
        }
        if (f1178b == null && f1179c == null) {
            return null;
        }
        throw new java.lang.IllegalArgumentException("Invalid Transition types");
    }

    private static boolean a_renamed(androidx.fragment.app.n_renamed nVar, java.util.List<java.lang.Object> list) {
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (!nVar.a_renamed(list.get(i_renamed))) {
                return false;
            }
        }
        return true;
    }

    private static java.lang.Object a_renamed(androidx.fragment.app.n_renamed nVar, androidx.fragment.app.Fragment fragment, androidx.fragment.app.Fragment fragment2, boolean z_renamed) {
        java.lang.Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z_renamed) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return nVar.c_renamed(nVar.b_renamed(sharedElementEnterTransition));
    }

    private static java.lang.Object a_renamed(androidx.fragment.app.n_renamed nVar, androidx.fragment.app.Fragment fragment, boolean z_renamed) {
        java.lang.Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z_renamed) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return nVar.b_renamed(enterTransition);
    }

    private static java.lang.Object b_renamed(androidx.fragment.app.n_renamed nVar, androidx.fragment.app.Fragment fragment, boolean z_renamed) {
        java.lang.Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z_renamed) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return nVar.b_renamed(exitTransition);
    }

    private static java.lang.Object a_renamed(final androidx.fragment.app.n_renamed nVar, android.view.ViewGroup viewGroup, android.view.View view, androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, androidx.fragment.app.l_renamed.a_renamed aVar, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2, java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Object obj3;
        final android.view.View view2;
        final android.graphics.Rect rect;
        final androidx.fragment.app.Fragment fragment = aVar.f1190a;
        final androidx.fragment.app.Fragment fragment2 = aVar.d_renamed;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z_renamed = aVar.f1191b;
        java.lang.Object objA = arrayMap.isEmpty() ? null : a_renamed(nVar, fragment, fragment2, z_renamed);
        androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMapB = b_renamed(nVar, arrayMap, objA, aVar);
        final androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMapA = a_renamed(nVar, arrayMap, objA, aVar);
        if (arrayMap.isEmpty()) {
            if (arrayMapB != null) {
                arrayMapB.clear();
            }
            if (arrayMapA != null) {
                arrayMapA.clear();
            }
            obj3 = null;
        } else {
            a_renamed(arrayList, arrayMapB, arrayMap.keySet());
            a_renamed(arrayList2, arrayMapA, arrayMap.values());
            obj3 = objA;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a_renamed(fragment, fragment2, z_renamed, arrayMapB, true);
        if (obj3 != null) {
            arrayList2.add(view);
            nVar.a_renamed(obj3, view, arrayList);
            a_renamed(nVar, obj3, obj2, arrayMapB, aVar.e_renamed, aVar.f_renamed);
            android.graphics.Rect rect2 = new android.graphics.Rect();
            android.view.View viewA = a_renamed(arrayMapA, aVar, obj, z_renamed);
            if (viewA != null) {
                nVar.a_renamed(obj, rect2);
            }
            rect = rect2;
            view2 = viewA;
        } else {
            view2 = null;
            rect = null;
        }
        androidx.core.h_renamed.r_renamed.a_renamed(viewGroup, new java.lang.Runnable() { // from class: androidx.fragment.app.l_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                androidx.fragment.app.l_renamed.a_renamed(fragment, fragment2, z_renamed, (androidx.collection.ArrayMap<java.lang.String, android.view.View>) arrayMapA, false);
                android.view.View view3 = view2;
                if (view3 != null) {
                    nVar.a_renamed(view3, rect);
                }
            }
        });
        return obj3;
    }

    private static void a_renamed(java.util.ArrayList<android.view.View> arrayList, androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap, java.util.Collection<java.lang.String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            android.view.View viewValueAt = arrayMap.valueAt(size);
            if (collection.contains(androidx.core.h_renamed.v_renamed.q_renamed(viewValueAt))) {
                arrayList.add(viewValueAt);
            }
        }
    }

    private static java.lang.Object b_renamed(final androidx.fragment.app.n_renamed nVar, android.view.ViewGroup viewGroup, final android.view.View view, final androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, final androidx.fragment.app.l_renamed.a_renamed aVar, final java.util.ArrayList<android.view.View> arrayList, final java.util.ArrayList<android.view.View> arrayList2, final java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Object objA;
        androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap2;
        java.lang.Object obj3;
        android.graphics.Rect rect;
        final androidx.fragment.app.Fragment fragment = aVar.f1190a;
        final androidx.fragment.app.Fragment fragment2 = aVar.d_renamed;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z_renamed = aVar.f1191b;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            objA = null;
        } else {
            objA = a_renamed(nVar, fragment, fragment2, z_renamed);
            arrayMap2 = arrayMap;
        }
        androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMapB = b_renamed(nVar, arrayMap2, objA, aVar);
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(arrayMapB.values());
            obj3 = objA;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a_renamed(fragment, fragment2, z_renamed, arrayMapB, true);
        if (obj3 != null) {
            rect = new android.graphics.Rect();
            nVar.a_renamed(obj3, view, arrayList);
            a_renamed(nVar, obj3, obj2, arrayMapB, aVar.e_renamed, aVar.f_renamed);
            if (obj != null) {
                nVar.a_renamed(obj, rect);
            }
        } else {
            rect = null;
        }
        final java.lang.Object obj4 = obj3;
        final android.graphics.Rect rect2 = rect;
        androidx.core.h_renamed.r_renamed.a_renamed(viewGroup, new java.lang.Runnable() { // from class: androidx.fragment.app.l_renamed.4
            @Override // java.lang.Runnable
            public void run() {
                androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMapA = androidx.fragment.app.l_renamed.a_renamed(nVar, (androidx.collection.ArrayMap<java.lang.String, java.lang.String>) arrayMap, obj4, aVar);
                if (arrayMapA != null) {
                    arrayList2.addAll(arrayMapA.values());
                    arrayList2.add(view);
                }
                androidx.fragment.app.l_renamed.a_renamed(fragment, fragment2, z_renamed, arrayMapA, false);
                java.lang.Object obj5 = obj4;
                if (obj5 != null) {
                    nVar.a_renamed(obj5, arrayList, arrayList2);
                    android.view.View viewA = androidx.fragment.app.l_renamed.a_renamed(arrayMapA, aVar, obj, z_renamed);
                    if (viewA != null) {
                        nVar.a_renamed(viewA, rect2);
                    }
                }
            }
        });
        return obj3;
    }

    private static androidx.collection.ArrayMap<java.lang.String, android.view.View> b_renamed(androidx.fragment.app.n_renamed nVar, androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, java.lang.Object obj, androidx.fragment.app.l_renamed.a_renamed aVar) {
        androidx.core.app.l_renamed exitTransitionCallback;
        java.util.ArrayList<java.lang.String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        androidx.fragment.app.Fragment fragment = aVar.d_renamed;
        androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap2 = new androidx.collection.ArrayMap<>();
        nVar.a_renamed((java.util.Map<java.lang.String, android.view.View>) arrayMap2, fragment.requireView());
        androidx.fragment.app.a_renamed aVar2 = aVar.f_renamed;
        if (aVar.e_renamed) {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar2.s_renamed;
        } else {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = aVar2.r_renamed;
        }
        arrayMap2.retainAll(arrayList);
        if (exitTransitionCallback != null) {
            exitTransitionCallback.a_renamed(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                java.lang.String str = arrayList.get(size);
                android.view.View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(androidx.core.h_renamed.v_renamed.q_renamed(view))) {
                    arrayMap.put(androidx.core.h_renamed.v_renamed.q_renamed(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    static androidx.collection.ArrayMap<java.lang.String, android.view.View> a_renamed(androidx.fragment.app.n_renamed nVar, androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, java.lang.Object obj, androidx.fragment.app.l_renamed.a_renamed aVar) {
        androidx.core.app.l_renamed enterTransitionCallback;
        java.util.ArrayList<java.lang.String> arrayList;
        java.lang.String strA;
        androidx.fragment.app.Fragment fragment = aVar.f1190a;
        android.view.View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap2 = new androidx.collection.ArrayMap<>();
        nVar.a_renamed((java.util.Map<java.lang.String, android.view.View>) arrayMap2, view);
        androidx.fragment.app.a_renamed aVar2 = aVar.f1192c;
        if (aVar.f1191b) {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = aVar2.r_renamed;
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = aVar2.s_renamed;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (enterTransitionCallback != null) {
            enterTransitionCallback.a_renamed(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                java.lang.String str = arrayList.get(size);
                android.view.View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    java.lang.String strA2 = a_renamed(arrayMap, str);
                    if (strA2 != null) {
                        arrayMap.remove(strA2);
                    }
                } else if (!str.equals(androidx.core.h_renamed.v_renamed.q_renamed(view2)) && (strA = a_renamed(arrayMap, str)) != null) {
                    arrayMap.put(strA, androidx.core.h_renamed.v_renamed.q_renamed(view2));
                }
            }
        } else {
            a_renamed(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static java.lang.String a_renamed(androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, java.lang.String str) {
        int size = arrayMap.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            if (str.equals(arrayMap.valueAt(i_renamed))) {
                return arrayMap.keyAt(i_renamed);
            }
        }
        return null;
    }

    static android.view.View a_renamed(androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap, androidx.fragment.app.l_renamed.a_renamed aVar, java.lang.Object obj, boolean z_renamed) {
        java.lang.String str;
        androidx.fragment.app.a_renamed aVar2 = aVar.f1192c;
        if (obj == null || arrayMap == null || aVar2.r_renamed == null || aVar2.r_renamed.isEmpty()) {
            return null;
        }
        if (z_renamed) {
            str = aVar2.r_renamed.get(0);
        } else {
            str = aVar2.s_renamed.get(0);
        }
        return arrayMap.get(str);
    }

    private static void a_renamed(androidx.fragment.app.n_renamed nVar, java.lang.Object obj, java.lang.Object obj2, androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap, boolean z_renamed, androidx.fragment.app.a_renamed aVar) {
        java.lang.String str;
        if (aVar.r_renamed == null || aVar.r_renamed.isEmpty()) {
            return;
        }
        if (z_renamed) {
            str = aVar.s_renamed.get(0);
        } else {
            str = aVar.r_renamed.get(0);
        }
        android.view.View view = arrayMap.get(str);
        nVar.a_renamed(obj, view);
        if (obj2 != null) {
            nVar.a_renamed(obj2, view);
        }
    }

    private static void a_renamed(androidx.collection.ArrayMap<java.lang.String, java.lang.String> arrayMap, androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    static void a_renamed(androidx.fragment.app.Fragment fragment, androidx.fragment.app.Fragment fragment2, boolean z_renamed, androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap, boolean z2) {
        androidx.core.app.l_renamed enterTransitionCallback;
        if (z_renamed) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                arrayList2.add(arrayMap.keyAt(i_renamed));
                arrayList.add(arrayMap.valueAt(i_renamed));
            }
            if (z2) {
                enterTransitionCallback.a_renamed(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.b_renamed(arrayList2, arrayList, null);
            }
        }
    }

    static java.util.ArrayList<android.view.View> a_renamed(androidx.fragment.app.n_renamed nVar, java.lang.Object obj, androidx.fragment.app.Fragment fragment, java.util.ArrayList<android.view.View> arrayList, android.view.View view) {
        if (obj == null) {
            return null;
        }
        java.util.ArrayList<android.view.View> arrayList2 = new java.util.ArrayList<>();
        android.view.View view2 = fragment.getView();
        if (view2 != null) {
            nVar.a_renamed(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        nVar.a_renamed(obj, arrayList2);
        return arrayList2;
    }

    static void a_renamed(java.util.ArrayList<android.view.View> arrayList, int i_renamed) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i_renamed);
        }
    }

    private static java.lang.Object a_renamed(androidx.fragment.app.n_renamed nVar, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, androidx.fragment.app.Fragment fragment, boolean z_renamed) {
        boolean allowEnterTransitionOverlap;
        if (obj == null || obj2 == null || fragment == null) {
            allowEnterTransitionOverlap = true;
        } else if (z_renamed) {
            allowEnterTransitionOverlap = fragment.getAllowReturnTransitionOverlap();
        } else {
            allowEnterTransitionOverlap = fragment.getAllowEnterTransitionOverlap();
        }
        if (allowEnterTransitionOverlap) {
            return nVar.a_renamed(obj2, obj, obj3);
        }
        return nVar.b_renamed(obj2, obj, obj3);
    }

    public static void a_renamed(androidx.fragment.app.a_renamed aVar, android.util.SparseArray<androidx.fragment.app.l_renamed.a_renamed> sparseArray, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        int size = aVar.d_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            a_renamed(aVar, aVar.d_renamed.get(i_renamed), sparseArray, false, z_renamed);
        }
    }

    public static void b_renamed(androidx.fragment.app.a_renamed aVar, android.util.SparseArray<androidx.fragment.app.l_renamed.a_renamed> sparseArray, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        if (aVar.f1130a.o_renamed.a_renamed()) {
            for (int size = aVar.d_renamed.size() - 1; size >= 0; size--) {
                a_renamed(aVar, aVar.d_renamed.get(size), sparseArray, true, z_renamed);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:55:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:56:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:64:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:65:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:69:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:70:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a_renamed(androidx.fragment.app.a_renamed r16, androidx.fragment.app.k_renamed.a_renamed r17, android.util.SparseArray<androidx.fragment.app.l_renamed.a_renamed> r18, boolean r19, boolean r20) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.l_renamed.a_renamed(androidx.fragment.app.a_renamed, androidx.fragment.app.k_renamed$a_renamed, android.util.SparseArray, boolean, boolean):void");
    }

    private static androidx.fragment.app.l_renamed.a_renamed a_renamed(androidx.fragment.app.l_renamed.a_renamed aVar, android.util.SparseArray<androidx.fragment.app.l_renamed.a_renamed> sparseArray, int i_renamed) {
        if (aVar != null) {
            return aVar;
        }
        androidx.fragment.app.l_renamed.a_renamed aVar2 = new androidx.fragment.app.l_renamed.a_renamed();
        sparseArray.put(i_renamed, aVar2);
        return aVar2;
    }

    /* compiled from: FragmentTransition.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public androidx.fragment.app.Fragment f1190a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public boolean f1191b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public androidx.fragment.app.a_renamed f1192c;
        public androidx.fragment.app.Fragment d_renamed;
        public boolean e_renamed;
        public androidx.fragment.app.a_renamed f_renamed;

        a_renamed() {
        }
    }
}
