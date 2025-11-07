package androidx.fragment.app;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.OneShotPreDrawListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransition.java */
/* renamed from: androidx.fragment.app.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
class FragmentTransition {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int[] f3535a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final FragmentTransitionImpl f3536b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final FragmentTransitionImpl f3537c;

    static {
        f3536b = Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null;
        f3537c = m3552a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static FragmentTransitionImpl m3552a() {
        try {
            return (FragmentTransitionImpl) Class.forName("androidx.transition.COUIBaseListPopupWindow_8").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m3565a(FragmentManagerImpl layoutInflaterFactory2C0587i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int OplusGLSurfaceView_13, int i2, boolean z) {
        if (layoutInflaterFactory2C0587i.f3456m < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = OplusGLSurfaceView_13; i3 < i2; i3++) {
            BackStackRecord c0579a = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                m3575b(c0579a, (SparseArray<PlatformImplementations.kt_3>) sparseArray, z);
            } else {
                m3562a(c0579a, (SparseArray<PlatformImplementations.kt_3>) sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(layoutInflaterFactory2C0587i.f3457n.m3386j());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = sparseArray.keyAt(i4);
                ArrayMap<String, String> arrayMapM3549a = m3549a(iKeyAt, arrayList, arrayList2, OplusGLSurfaceView_13, i2);
                PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) sparseArray.valueAt(i4);
                if (z) {
                    m3564a(layoutInflaterFactory2C0587i, iKeyAt, aVar, view, arrayMapM3549a);
                } else {
                    m3576b(layoutInflaterFactory2C0587i, iKeyAt, aVar, view, arrayMapM3549a);
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static ArrayMap<String, String> m3549a(int OplusGLSurfaceView_13, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            BackStackRecord c0579a = arrayList.get(i4);
            if (c0579a.m3323b(OplusGLSurfaceView_13)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                if (c0579a.f3523r != null) {
                    int size = c0579a.f3523r.size();
                    if (zBooleanValue) {
                        arrayList3 = c0579a.f3523r;
                        arrayList4 = c0579a.f3524s;
                    } else {
                        ArrayList<String> arrayList5 = c0579a.f3523r;
                        arrayList3 = c0579a.f3524s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String strRemove = arrayMap.remove(str2);
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

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m3564a(FragmentManagerImpl layoutInflaterFactory2C0587i, int OplusGLSurfaceView_13, PlatformImplementations.kt_3 aVar, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl abstractC0592nM3553a;
        Object obj;
        ViewGroup viewGroup = layoutInflaterFactory2C0587i.f3458o.mo3292a() ? (ViewGroup) layoutInflaterFactory2C0587i.f3458o.mo3291a(OplusGLSurfaceView_13) : null;
        if (viewGroup == null || (abstractC0592nM3553a = m3553a((fragment2 = aVar.f3569d), (fragment = aVar.f3566a))) == null) {
            return;
        }
        boolean z = aVar.f3567b;
        boolean z2 = aVar.f3570e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objM3556a = m3556a(abstractC0592nM3553a, fragment, z);
        Object objM3574b = m3574b(abstractC0592nM3553a, fragment2, z2);
        Object objM3554a = m3554a(abstractC0592nM3553a, viewGroup, view, arrayMap, aVar, arrayList2, arrayList, objM3556a, objM3574b);
        if (objM3556a == null && objM3554a == null) {
            obj = objM3574b;
            if (obj == null) {
                return;
            }
        } else {
            obj = objM3574b;
        }
        ArrayList<View> arrayListM3559a = m3559a(abstractC0592nM3553a, obj, fragment2, arrayList2, view);
        ArrayList<View> arrayListM3559a2 = m3559a(abstractC0592nM3553a, objM3556a, fragment, arrayList, view);
        m3569a(arrayListM3559a2, 4);
        Object objM3557a = m3557a(abstractC0592nM3553a, objM3556a, obj, objM3554a, fragment, z);
        if (objM3557a != null) {
            m3567a(abstractC0592nM3553a, obj, fragment2, arrayListM3559a);
            ArrayList<String> arrayListM3598a = abstractC0592nM3553a.m3598a(arrayList);
            abstractC0592nM3553a.mo3583a(objM3557a, objM3556a, arrayListM3559a2, obj, arrayListM3559a, objM3554a, arrayList);
            abstractC0592nM3553a.mo3579a(viewGroup, objM3557a);
            abstractC0592nM3553a.m3600a(viewGroup, arrayList2, arrayList, arrayListM3598a, arrayMap);
            m3569a(arrayListM3559a2, 0);
            abstractC0592nM3553a.mo3585a(objM3554a, arrayList2, arrayList);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m3567a(FragmentTransitionImpl abstractC0592n, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            abstractC0592n.mo3590b(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.m2819a(fragment.mContainer, new Runnable() { // from class: androidx.fragment.app.OplusGLSurfaceView_14.1
                @Override // java.lang.Runnable
                public void run() {
                    FragmentTransition.m3569a((ArrayList<View>) arrayList, 4);
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m3576b(FragmentManagerImpl layoutInflaterFactory2C0587i, int OplusGLSurfaceView_13, PlatformImplementations.kt_3 aVar, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl abstractC0592nM3553a;
        Object obj;
        ViewGroup viewGroup = layoutInflaterFactory2C0587i.f3458o.mo3292a() ? (ViewGroup) layoutInflaterFactory2C0587i.f3458o.mo3291a(OplusGLSurfaceView_13) : null;
        if (viewGroup == null || (abstractC0592nM3553a = m3553a((fragment2 = aVar.f3569d), (fragment = aVar.f3566a))) == null) {
            return;
        }
        boolean z = aVar.f3567b;
        boolean z2 = aVar.f3570e;
        Object objM3556a = m3556a(abstractC0592nM3553a, fragment, z);
        Object objM3574b = m3574b(abstractC0592nM3553a, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objM3573b = m3573b(abstractC0592nM3553a, viewGroup, view, arrayMap, aVar, arrayList, arrayList2, objM3556a, objM3574b);
        if (objM3556a == null && objM3573b == null) {
            obj = objM3574b;
            if (obj == null) {
                return;
            }
        } else {
            obj = objM3574b;
        }
        ArrayList<View> arrayListM3559a = m3559a(abstractC0592nM3553a, obj, fragment2, (ArrayList<View>) arrayList, view);
        Object obj2 = (arrayListM3559a == null || arrayListM3559a.isEmpty()) ? null : obj;
        abstractC0592nM3553a.mo3589b(objM3556a, view);
        Object objM3557a = m3557a(abstractC0592nM3553a, objM3556a, obj2, objM3573b, fragment, aVar.f3567b);
        if (objM3557a != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            abstractC0592nM3553a.mo3583a(objM3557a, objM3556a, arrayList3, obj2, arrayListM3559a, objM3573b, arrayList2);
            m3566a(abstractC0592nM3553a, viewGroup, fragment, view, arrayList2, objM3556a, arrayList3, obj2, arrayListM3559a);
            abstractC0592nM3553a.m3601a((View) viewGroup, arrayList2, (Map<String, String>) arrayMap);
            abstractC0592nM3553a.mo3579a(viewGroup, objM3557a);
            abstractC0592nM3553a.m3602a(viewGroup, arrayList2, (Map<String, String>) arrayMap);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m3566a(final FragmentTransitionImpl abstractC0592n, ViewGroup viewGroup, final Fragment fragment, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        OneShotPreDrawListener.m2819a(viewGroup, new Runnable() { // from class: androidx.fragment.app.OplusGLSurfaceView_14.2
            @Override // java.lang.Runnable
            public void run() {
                Object obj3 = obj;
                if (obj3 != null) {
                    abstractC0592n.mo3593c(obj3, view);
                    arrayList2.addAll(FragmentTransition.m3559a(abstractC0592n, obj, fragment, (ArrayList<View>) arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        abstractC0592n.mo3591b(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static FragmentTransitionImpl m3553a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl abstractC0592n = f3536b;
        if (abstractC0592n != null && m3571a(abstractC0592n, arrayList)) {
            return f3536b;
        }
        FragmentTransitionImpl abstractC0592n2 = f3537c;
        if (abstractC0592n2 != null && m3571a(abstractC0592n2, arrayList)) {
            return f3537c;
        }
        if (f3536b == null && f3537c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m3571a(FragmentTransitionImpl abstractC0592n, List<Object> list) {
        int size = list.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            if (!abstractC0592n.mo3586a(list.get(OplusGLSurfaceView_13))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Object m3555a(FragmentTransitionImpl abstractC0592n, Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return abstractC0592n.mo3592c(abstractC0592n.mo3587b(sharedElementEnterTransition));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Object m3556a(FragmentTransitionImpl abstractC0592n, Fragment fragment, boolean z) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return abstractC0592n.mo3587b(enterTransition);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Object m3574b(FragmentTransitionImpl abstractC0592n, Fragment fragment, boolean z) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return abstractC0592n.mo3587b(exitTransition);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Object m3554a(final FragmentTransitionImpl abstractC0592n, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, PlatformImplementations.kt_3 aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final View view2;
        final Rect rect;
        final Fragment fragment = aVar.f3566a;
        final Fragment fragment2 = aVar.f3569d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = aVar.f3567b;
        Object objM3555a = arrayMap.isEmpty() ? null : m3555a(abstractC0592n, fragment, fragment2, z);
        ArrayMap<String, View> arrayMapM3572b = m3572b(abstractC0592n, arrayMap, objM3555a, aVar);
        final ArrayMap<String, View> arrayMapM3550a = m3550a(abstractC0592n, arrayMap, objM3555a, aVar);
        if (arrayMap.isEmpty()) {
            if (arrayMapM3572b != null) {
                arrayMapM3572b.clear();
            }
            if (arrayMapM3550a != null) {
                arrayMapM3550a.clear();
            }
            obj3 = null;
        } else {
            m3570a(arrayList, arrayMapM3572b, arrayMap.keySet());
            m3570a(arrayList2, arrayMapM3550a, arrayMap.values());
            obj3 = objM3555a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m3561a(fragment, fragment2, z, arrayMapM3572b, true);
        if (obj3 != null) {
            arrayList2.add(view);
            abstractC0592n.mo3582a(obj3, view, arrayList);
            m3568a(abstractC0592n, obj3, obj2, arrayMapM3572b, aVar.f3570e, aVar.f3571f);
            Rect rect2 = new Rect();
            View viewM3548a = m3548a(arrayMapM3550a, aVar, obj, z);
            if (viewM3548a != null) {
                abstractC0592n.mo3580a(obj, rect2);
            }
            rect = rect2;
            view2 = viewM3548a;
        } else {
            view2 = null;
            rect = null;
        }
        OneShotPreDrawListener.m2819a(viewGroup, new Runnable() { // from class: androidx.fragment.app.OplusGLSurfaceView_14.3
            @Override // java.lang.Runnable
            public void run() {
                FragmentTransition.m3561a(fragment, fragment2, z, (ArrayMap<String, View>) arrayMapM3550a, false);
                View view3 = view2;
                if (view3 != null) {
                    abstractC0592n.m3599a(view3, rect);
                }
            }
        });
        return obj3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m3570a(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View viewValueAt = arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.m2898q(viewValueAt))) {
                arrayList.add(viewValueAt);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Object m3573b(final FragmentTransitionImpl abstractC0592n, ViewGroup viewGroup, final View view, final ArrayMap<String, String> arrayMap, final PlatformImplementations.kt_3 aVar, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object objM3555a;
        ArrayMap<String, String> arrayMap2;
        Object obj3;
        Rect rect;
        final Fragment fragment = aVar.f3566a;
        final Fragment fragment2 = aVar.f3569d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = aVar.f3567b;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            objM3555a = null;
        } else {
            objM3555a = m3555a(abstractC0592n, fragment, fragment2, z);
            arrayMap2 = arrayMap;
        }
        ArrayMap<String, View> arrayMapM3572b = m3572b(abstractC0592n, arrayMap2, objM3555a, aVar);
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(arrayMapM3572b.values());
            obj3 = objM3555a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m3561a(fragment, fragment2, z, arrayMapM3572b, true);
        if (obj3 != null) {
            rect = new Rect();
            abstractC0592n.mo3582a(obj3, view, arrayList);
            m3568a(abstractC0592n, obj3, obj2, arrayMapM3572b, aVar.f3570e, aVar.f3571f);
            if (obj != null) {
                abstractC0592n.mo3580a(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        final Rect rect2 = rect;
        OneShotPreDrawListener.m2819a(viewGroup, new Runnable() { // from class: androidx.fragment.app.OplusGLSurfaceView_14.4
            @Override // java.lang.Runnable
            public void run() {
                ArrayMap<String, View> arrayMapM3550a = FragmentTransition.m3550a(abstractC0592n, (ArrayMap<String, String>) arrayMap, obj4, aVar);
                if (arrayMapM3550a != null) {
                    arrayList2.addAll(arrayMapM3550a.values());
                    arrayList2.add(view);
                }
                FragmentTransition.m3561a(fragment, fragment2, z, arrayMapM3550a, false);
                Object obj5 = obj4;
                if (obj5 != null) {
                    abstractC0592n.mo3585a(obj5, arrayList, arrayList2);
                    View viewM3548a = FragmentTransition.m3548a(arrayMapM3550a, aVar, obj, z);
                    if (viewM3548a != null) {
                        abstractC0592n.m3599a(viewM3548a, rect2);
                    }
                }
            }
        });
        return obj3;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static ArrayMap<String, View> m3572b(FragmentTransitionImpl abstractC0592n, ArrayMap<String, String> arrayMap, Object obj, PlatformImplementations.kt_3 aVar) {
        SharedElementCallback exitTransitionCallback;
        ArrayList<String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = aVar.f3569d;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        abstractC0592n.m3604a((Map<String, View>) arrayMap2, fragment.requireView());
        BackStackRecord c0579a = aVar.f3571f;
        if (aVar.f3570e) {
            exitTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = c0579a.f3524s;
        } else {
            exitTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = c0579a.f3523r;
        }
        arrayMap2.retainAll(arrayList);
        if (exitTransitionCallback != null) {
            exitTransitionCallback.m2438a(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.m2898q(view))) {
                    arrayMap.put(ViewCompat.m2898q(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static ArrayMap<String, View> m3550a(FragmentTransitionImpl abstractC0592n, ArrayMap<String, String> arrayMap, Object obj, PlatformImplementations.kt_3 aVar) {
        SharedElementCallback enterTransitionCallback;
        ArrayList<String> arrayList;
        String strM3558a;
        Fragment fragment = aVar.f3566a;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        abstractC0592n.m3604a((Map<String, View>) arrayMap2, view);
        BackStackRecord c0579a = aVar.f3568c;
        if (aVar.f3567b) {
            enterTransitionCallback = fragment.getExitTransitionCallback();
            arrayList = c0579a.f3523r;
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
            arrayList = c0579a.f3524s;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (enterTransitionCallback != null) {
            enterTransitionCallback.m2438a(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String strM3558a2 = m3558a(arrayMap, str);
                    if (strM3558a2 != null) {
                        arrayMap.remove(strM3558a2);
                    }
                } else if (!str.equals(ViewCompat.m2898q(view2)) && (strM3558a = m3558a(arrayMap, str)) != null) {
                    arrayMap.put(strM3558a, ViewCompat.m2898q(view2));
                }
            }
        } else {
            m3560a(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m3558a(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            if (str.equals(arrayMap.valueAt(OplusGLSurfaceView_13))) {
                return arrayMap.keyAt(OplusGLSurfaceView_13);
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static View m3548a(ArrayMap<String, View> arrayMap, PlatformImplementations.kt_3 aVar, Object obj, boolean z) {
        String str;
        BackStackRecord c0579a = aVar.f3568c;
        if (obj == null || arrayMap == null || c0579a.f3523r == null || c0579a.f3523r.isEmpty()) {
            return null;
        }
        if (z) {
            str = c0579a.f3523r.get(0);
        } else {
            str = c0579a.f3524s.get(0);
        }
        return arrayMap.get(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m3568a(FragmentTransitionImpl abstractC0592n, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord c0579a) {
        String str;
        if (c0579a.f3523r == null || c0579a.f3523r.isEmpty()) {
            return;
        }
        if (z) {
            str = c0579a.f3524s.get(0);
        } else {
            str = c0579a.f3523r.get(0);
        }
        View view = arrayMap.get(str);
        abstractC0592n.mo3581a(obj, view);
        if (obj2 != null) {
            abstractC0592n.mo3581a(obj2, view);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m3560a(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m3561a(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                arrayList2.add(arrayMap.keyAt(OplusGLSurfaceView_13));
                arrayList.add(arrayMap.valueAt(OplusGLSurfaceView_13));
            }
            if (z2) {
                enterTransitionCallback.m2437a(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.m2439b(arrayList2, arrayList, null);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static ArrayList<View> m3559a(FragmentTransitionImpl abstractC0592n, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            abstractC0592n.m3603a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        abstractC0592n.mo3584a(obj, arrayList2);
        return arrayList2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m3569a(ArrayList<View> arrayList, int OplusGLSurfaceView_13) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Object m3557a(FragmentTransitionImpl abstractC0592n, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean allowEnterTransitionOverlap;
        if (obj == null || obj2 == null || fragment == null) {
            allowEnterTransitionOverlap = true;
        } else if (z) {
            allowEnterTransitionOverlap = fragment.getAllowReturnTransitionOverlap();
        } else {
            allowEnterTransitionOverlap = fragment.getAllowEnterTransitionOverlap();
        }
        if (allowEnterTransitionOverlap) {
            return abstractC0592n.mo3578a(obj2, obj, obj3);
        }
        return abstractC0592n.mo3588b(obj2, obj, obj3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3562a(BackStackRecord c0579a, SparseArray<PlatformImplementations.kt_3> sparseArray, boolean z) throws Resources.NotFoundException {
        int size = c0579a.f3509d.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            m3563a(c0579a, c0579a.f3509d.get(OplusGLSurfaceView_13), sparseArray, false, z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m3575b(BackStackRecord c0579a, SparseArray<PlatformImplementations.kt_3> sparseArray, boolean z) throws Resources.NotFoundException {
        if (c0579a.f3412a.f3458o.mo3292a()) {
            for (int size = c0579a.f3509d.size() - 1; size >= 0; size--) {
                m3563a(c0579a, c0579a.f3509d.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0099  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void m3563a(androidx.fragment.app.BackStackRecord r16, androidx.fragment.app.FragmentTransaction.PlatformImplementations.kt_3 r17, android.util.SparseArray<androidx.fragment.app.FragmentTransition.PlatformImplementations.kt_3> r18, boolean r19, boolean r20) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentTransition.m3563a(androidx.fragment.app.PlatformImplementations.kt_3, androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3, android.util.SparseArray, boolean, boolean):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static PlatformImplementations.kt_3 m3551a(PlatformImplementations.kt_3 aVar, SparseArray<PlatformImplementations.kt_3> sparseArray, int OplusGLSurfaceView_13) {
        if (aVar != null) {
            return aVar;
        }
        PlatformImplementations.kt_3 aVar2 = new PlatformImplementations.kt_3();
        sparseArray.put(OplusGLSurfaceView_13, aVar2);
        return aVar2;
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: androidx.fragment.app.OplusGLSurfaceView_14$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public Fragment f3566a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean f3567b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public BackStackRecord f3568c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public Fragment f3569d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean f3570e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public BackStackRecord f3571f;

        PlatformImplementations.kt_3() {
        }
    }
}
