package androidx.fragment.app;

/* compiled from: FragmentTransitionImpl.java */
@android.annotation.SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public abstract class n_renamed {
    public abstract java.lang.Object a_renamed(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3);

    public abstract void a_renamed(android.view.ViewGroup viewGroup, java.lang.Object obj);

    public abstract void a_renamed(java.lang.Object obj, android.graphics.Rect rect);

    public abstract void a_renamed(java.lang.Object obj, android.view.View view);

    public abstract void a_renamed(java.lang.Object obj, android.view.View view, java.util.ArrayList<android.view.View> arrayList);

    public abstract void a_renamed(java.lang.Object obj, java.lang.Object obj2, java.util.ArrayList<android.view.View> arrayList, java.lang.Object obj3, java.util.ArrayList<android.view.View> arrayList2, java.lang.Object obj4, java.util.ArrayList<android.view.View> arrayList3);

    public abstract void a_renamed(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList);

    public abstract void a_renamed(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2);

    public abstract boolean a_renamed(java.lang.Object obj);

    public abstract java.lang.Object b_renamed(java.lang.Object obj);

    public abstract java.lang.Object b_renamed(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3);

    public abstract void b_renamed(java.lang.Object obj, android.view.View view);

    public abstract void b_renamed(java.lang.Object obj, android.view.View view, java.util.ArrayList<android.view.View> arrayList);

    public abstract void b_renamed(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2);

    public abstract java.lang.Object c_renamed(java.lang.Object obj);

    public abstract void c_renamed(java.lang.Object obj, android.view.View view);

    protected void a_renamed(android.view.View view, android.graphics.Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    java.util.ArrayList<java.lang.String> a_renamed(java.util.ArrayList<android.view.View> arrayList) {
        java.util.ArrayList<java.lang.String> arrayList2 = new java.util.ArrayList<>();
        int size = arrayList.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.view.View view = arrayList.get(i_renamed);
            arrayList2.add(androidx.core.h_renamed.v_renamed.q_renamed(view));
            androidx.core.h_renamed.v_renamed.a_renamed(view, (java.lang.String) null);
        }
        return arrayList2;
    }

    void a_renamed(android.view.View view, final java.util.ArrayList<android.view.View> arrayList, final java.util.ArrayList<android.view.View> arrayList2, final java.util.ArrayList<java.lang.String> arrayList3, java.util.Map<java.lang.String, java.lang.String> map) {
        final int size = arrayList2.size();
        final java.util.ArrayList arrayList4 = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            android.view.View view2 = arrayList.get(i_renamed);
            java.lang.String strQ = androidx.core.h_renamed.v_renamed.q_renamed(view2);
            arrayList4.add(strQ);
            if (strQ != null) {
                androidx.core.h_renamed.v_renamed.a_renamed(view2, (java.lang.String) null);
                java.lang.String str = map.get(strQ);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i2))) {
                        androidx.core.h_renamed.v_renamed.a_renamed(arrayList2.get(i2), strQ);
                        break;
                    }
                    i2++;
                }
            }
        }
        androidx.core.h_renamed.r_renamed.a_renamed(view, new java.lang.Runnable() { // from class: androidx.fragment.app.n_renamed.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < size; i3++) {
                    androidx.core.h_renamed.v_renamed.a_renamed((android.view.View) arrayList2.get(i3), (java.lang.String) arrayList3.get(i3));
                    androidx.core.h_renamed.v_renamed.a_renamed((android.view.View) arrayList.get(i3), (java.lang.String) arrayList4.get(i3));
                }
            }
        });
    }

    void a_renamed(java.util.ArrayList<android.view.View> arrayList, android.view.View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                if (androidx.core.h_renamed.x_renamed.a_renamed(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                    a_renamed(arrayList, viewGroup.getChildAt(i_renamed));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    void a_renamed(java.util.Map<java.lang.String, android.view.View> map, android.view.View view) {
        if (view.getVisibility() == 0) {
            java.lang.String strQ = androidx.core.h_renamed.v_renamed.q_renamed(view);
            if (strQ != null) {
                map.put(strQ, view);
            }
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
                    a_renamed(map, viewGroup.getChildAt(i_renamed));
                }
            }
        }
    }

    void a_renamed(android.view.View view, final java.util.ArrayList<android.view.View> arrayList, final java.util.Map<java.lang.String, java.lang.String> map) {
        androidx.core.h_renamed.r_renamed.a_renamed(view, new java.lang.Runnable() { // from class: androidx.fragment.app.n_renamed.2
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    android.view.View view2 = (android.view.View) arrayList.get(i_renamed);
                    java.lang.String strQ = androidx.core.h_renamed.v_renamed.q_renamed(view2);
                    if (strQ != null) {
                        androidx.core.h_renamed.v_renamed.a_renamed(view2, androidx.fragment.app.n_renamed.a_renamed((java.util.Map<java.lang.String, java.lang.String>) map, strQ));
                    }
                }
            }
        });
    }

    void a_renamed(android.view.ViewGroup viewGroup, final java.util.ArrayList<android.view.View> arrayList, final java.util.Map<java.lang.String, java.lang.String> map) {
        androidx.core.h_renamed.r_renamed.a_renamed(viewGroup, new java.lang.Runnable() { // from class: androidx.fragment.app.n_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    android.view.View view = (android.view.View) arrayList.get(i_renamed);
                    androidx.core.h_renamed.v_renamed.a_renamed(view, (java.lang.String) map.get(androidx.core.h_renamed.v_renamed.q_renamed(view)));
                }
            }
        });
    }

    protected static void a_renamed(java.util.List<android.view.View> list, android.view.View view) {
        int size = list.size();
        if (a_renamed(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i_renamed = size; i_renamed < list.size(); i_renamed++) {
            android.view.View view2 = list.get(i_renamed);
            if (view2 instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    android.view.View childAt = viewGroup.getChildAt(i2);
                    if (!a_renamed(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean a_renamed(java.util.List<android.view.View> list, android.view.View view, int i_renamed) {
        for (int i2 = 0; i2 < i_renamed; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    protected static boolean a_renamed(java.util.List list) {
        return list == null || list.isEmpty();
    }

    static java.lang.String a_renamed(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
