package com.oplus.camera.p172ui.menu;

import com.oplus.camera.CameraLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PopUpWindowManager.java */
/* renamed from: com.oplus.camera.ui.menu.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class PopUpWindowManager {

    /* renamed from: PlatformImplementations.kt_3 */
    private static BasicOptionItemList f19368a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean f19369b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static ArrayList<PopUpWindowAnimationListener> f19370c;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m20700a(BasicOptionItemList basicOptionItemList) {
        CameraLog.m12954a("PopUpWindowManager", "showPopUpWindow");
        if (basicOptionItemList != null) {
            BasicOptionItemList basicOptionItemList2 = f19368a;
            if (basicOptionItemList2 != null && basicOptionItemList2.getPopUpWindowState()) {
                f19369b = true;
                f19368a.mo20295f();
            }
            f19368a = basicOptionItemList;
            f19368a.m20293d();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m20706a() {
        BasicOptionItemList basicOptionItemList = f19368a;
        if (basicOptionItemList != null) {
            return basicOptionItemList.getPopUpWindowState() || f19369b;
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static BasicOptionItemList m20707b() {
        return f19368a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m20711c() {
        BasicOptionItemList basicOptionItemList = f19368a;
        if (basicOptionItemList != null) {
            return basicOptionItemList.getPopUpWindowState();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m20712d() {
        m20704a(true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m20704a(boolean z) {
        CameraLog.m12954a("PopUpWindowManager", "hidePopUpWindow");
        BasicOptionItemList basicOptionItemList = f19368a;
        if (basicOptionItemList == null || !basicOptionItemList.isShown()) {
            return;
        }
        f19368a.m20283a(z);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m20713e() {
        BasicOptionItemList basicOptionItemList = f19368a;
        if (basicOptionItemList == null || !basicOptionItemList.getPopUpWindowState()) {
            return;
        }
        f19368a.mo20295f();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m20705a(boolean z, int OplusGLSurfaceView_13) {
        BasicOptionItemList basicOptionItemList = f19368a;
        if (basicOptionItemList == null || !basicOptionItemList.getPopUpWindowState()) {
            return;
        }
        f19368a.mo20285a(z, true, OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static void m20714f() {
        f19368a = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m20702a(String str) {
        CameraLog.m12954a("PopUpWindowManager", "showPopUpWindowBegin, key: " + str);
        f19369b = true;
        ArrayList<PopUpWindowAnimationListener> arrayList = f19370c;
        if (arrayList != null) {
            Iterator<PopUpWindowAnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                PopUpWindowAnimationListener next = it.next();
                if (next != null) {
                    next.mo10885a(str);
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m20709b(String str) {
        CameraLog.m12954a("PopUpWindowManager", "showPopUpWindowEnd, key: " + str);
        f19369b = true;
        ArrayList<PopUpWindowAnimationListener> arrayList = f19370c;
        if (arrayList != null) {
            Iterator<PopUpWindowAnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                PopUpWindowAnimationListener next = it.next();
                if (next != null) {
                    next.mo10887b(str);
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m20703a(String str, boolean z) {
        CameraLog.m12954a("PopUpWindowManager", "hidePopUpWindowBegin, key: " + str);
        ArrayList<PopUpWindowAnimationListener> arrayList = f19370c;
        if (arrayList != null) {
            Iterator<PopUpWindowAnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                PopUpWindowAnimationListener next = it.next();
                if (next != null) {
                    next.mo10886a(str, z);
                }
            }
        }
        f19369b = false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m20710c(String str) {
        CameraLog.m12954a("PopUpWindowManager", "hidePopUpWindowEnd, key: " + str);
        ArrayList<PopUpWindowAnimationListener> arrayList = f19370c;
        if (arrayList != null) {
            Iterator<PopUpWindowAnimationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                PopUpWindowAnimationListener next = it.next();
                if (next != null) {
                    next.mo10888c(str);
                }
            }
        }
        f19369b = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m20701a(PopUpWindowAnimationListener interfaceC3244f) {
        if (interfaceC3244f != null) {
            if (f19370c == null) {
                f19370c = new ArrayList<>();
            }
            if (f19370c.contains(interfaceC3244f)) {
                return;
            }
            f19370c.add(interfaceC3244f);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m20708b(PopUpWindowAnimationListener interfaceC3244f) {
        ArrayList<PopUpWindowAnimationListener> arrayList;
        if (interfaceC3244f == null || (arrayList = f19370c) == null || !arrayList.contains(interfaceC3244f)) {
            return;
        }
        f19370c.remove(interfaceC3244f);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static void m20715g() {
        CameraLog.m12954a("PopUpWindowManager", "clearListener");
        f19369b = false;
        ArrayList<PopUpWindowAnimationListener> arrayList = f19370c;
        if (arrayList != null) {
            arrayList.clear();
            f19370c = null;
        }
    }
}
