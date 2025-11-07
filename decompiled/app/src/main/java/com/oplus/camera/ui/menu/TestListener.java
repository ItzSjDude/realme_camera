package com.oplus.camera.ui.menu;

/* compiled from: PopUpWindowManager.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.oplus.camera.ui.menu.BasicOptionItemList f6441a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static boolean f6442b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.util.ArrayList<com.oplus.camera.ui.menu.f_renamed> f6443c;

    public static void a_renamed(com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList) {
        com.oplus.camera.e_renamed.a_renamed("PopUpWindowManager", "showPopUpWindow");
        if (basicOptionItemList != null) {
            com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList2 = f6441a;
            if (basicOptionItemList2 != null && basicOptionItemList2.getPopUpWindowState()) {
                f6442b = true;
                f6441a.f_renamed();
            }
            f6441a = basicOptionItemList;
            f6441a.d_renamed();
        }
    }

    public static boolean a_renamed() {
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = f6441a;
        if (basicOptionItemList != null) {
            return basicOptionItemList.getPopUpWindowState() || f6442b;
        }
        return false;
    }

    public static com.oplus.camera.ui.menu.BasicOptionItemList b_renamed() {
        return f6441a;
    }

    public static boolean c_renamed() {
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = f6441a;
        if (basicOptionItemList != null) {
            return basicOptionItemList.getPopUpWindowState();
        }
        return false;
    }

    public static void d_renamed() {
        a_renamed(true);
    }

    public static void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("PopUpWindowManager", "hidePopUpWindow");
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = f6441a;
        if (basicOptionItemList == null || !basicOptionItemList.isShown()) {
            return;
        }
        f6441a.a_renamed(z_renamed);
    }

    public static void e_renamed() {
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = f6441a;
        if (basicOptionItemList == null || !basicOptionItemList.getPopUpWindowState()) {
            return;
        }
        f6441a.f_renamed();
    }

    public static void a_renamed(boolean z_renamed, int i_renamed) {
        com.oplus.camera.ui.menu.BasicOptionItemList basicOptionItemList = f6441a;
        if (basicOptionItemList == null || !basicOptionItemList.getPopUpWindowState()) {
            return;
        }
        f6441a.a_renamed(z_renamed, true, i_renamed);
    }

    public static void f_renamed() {
        f6441a = null;
    }

    public static void a_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("PopUpWindowManager", "showPopUpWindowBegin, key: " + str);
        f6442b = true;
        java.util.ArrayList<com.oplus.camera.ui.menu.f_renamed> arrayList = f6443c;
        if (arrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.f_renamed> it = arrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.f_renamed next = it.next();
                if (next != null) {
                    next.a_renamed(str);
                }
            }
        }
    }

    public static void b_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("PopUpWindowManager", "showPopUpWindowEnd, key: " + str);
        f6442b = true;
        java.util.ArrayList<com.oplus.camera.ui.menu.f_renamed> arrayList = f6443c;
        if (arrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.f_renamed> it = arrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.f_renamed next = it.next();
                if (next != null) {
                    next.b_renamed(str);
                }
            }
        }
    }

    public static void a_renamed(java.lang.String str, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("PopUpWindowManager", "hidePopUpWindowBegin, key: " + str);
        java.util.ArrayList<com.oplus.camera.ui.menu.f_renamed> arrayList = f6443c;
        if (arrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.f_renamed> it = arrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.f_renamed next = it.next();
                if (next != null) {
                    next.a_renamed(str, z_renamed);
                }
            }
        }
        f6442b = false;
    }

    public static void c_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("PopUpWindowManager", "hidePopUpWindowEnd, key: " + str);
        java.util.ArrayList<com.oplus.camera.ui.menu.f_renamed> arrayList = f6443c;
        if (arrayList != null) {
            java.util.Iterator<com.oplus.camera.ui.menu.f_renamed> it = arrayList.iterator();
            while (it.hasNext()) {
                com.oplus.camera.ui.menu.f_renamed next = it.next();
                if (next != null) {
                    next.c_renamed(str);
                }
            }
        }
        f6442b = false;
    }

    public static void a_renamed(com.oplus.camera.ui.menu.f_renamed fVar) {
        if (fVar != null) {
            if (f6443c == null) {
                f6443c = new java.util.ArrayList<>();
            }
            if (f6443c.contains(fVar)) {
                return;
            }
            f6443c.add(fVar);
        }
    }

    public static void b_renamed(com.oplus.camera.ui.menu.f_renamed fVar) {
        java.util.ArrayList<com.oplus.camera.ui.menu.f_renamed> arrayList;
        if (fVar == null || (arrayList = f6443c) == null || !arrayList.contains(fVar)) {
            return;
        }
        f6443c.remove(fVar);
    }

    public static void g_renamed() {
        com.oplus.camera.e_renamed.a_renamed("PopUpWindowManager", "clearListener");
        f6442b = false;
        java.util.ArrayList<com.oplus.camera.ui.menu.f_renamed> arrayList = f6443c;
        if (arrayList != null) {
            arrayList.clear();
            f6443c = null;
        }
    }
}
