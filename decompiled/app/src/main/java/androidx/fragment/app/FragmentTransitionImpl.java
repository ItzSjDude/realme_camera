package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.ViewGroupCompat;
import androidx.core.p036h.OneShotPreDrawListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransitionImpl.java */
@SuppressLint({"UnknownNullness"})
/* renamed from: androidx.fragment.app.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public abstract class FragmentTransitionImpl {
    /* renamed from: PlatformImplementations.kt_3 */
    public abstract Object mo3578a(Object obj, Object obj2, Object obj3);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3579a(ViewGroup viewGroup, Object obj);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3580a(Object obj, Rect rect);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3581a(Object obj, View view);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3582a(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3583a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3584a(Object obj, ArrayList<View> arrayList);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3585a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract boolean mo3586a(Object obj);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract Object mo3587b(Object obj);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract Object mo3588b(Object obj, Object obj2, Object obj3);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo3589b(Object obj, View view);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo3590b(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract void mo3591b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract Object mo3592c(Object obj);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract void mo3593c(Object obj, View view);

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m3599a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    ArrayList<String> m3598a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            View view = arrayList.get(OplusGLSurfaceView_13);
            arrayList2.add(ViewCompat.m2898q(view));
            ViewCompat.m2859a(view, (String) null);
        }
        return arrayList2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3600a(View view, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            View view2 = arrayList.get(OplusGLSurfaceView_13);
            String strM2898q = ViewCompat.m2898q(view2);
            arrayList4.add(strM2898q);
            if (strM2898q != null) {
                ViewCompat.m2859a(view2, (String) null);
                String str = map.get(strM2898q);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i2))) {
                        ViewCompat.m2859a(arrayList2.get(i2), strM2898q);
                        break;
                    }
                    i2++;
                }
            }
        }
        OneShotPreDrawListener.m2819a(view, new Runnable() { // from class: androidx.fragment.app.OplusGLSurfaceView_11.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < size; i3++) {
                    ViewCompat.m2859a((View) arrayList2.get(i3), (String) arrayList3.get(i3));
                    ViewCompat.m2859a((View) arrayList.get(i3), (String) arrayList4.get(i3));
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3603a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (ViewGroupCompat.m2935a(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                    m3603a(arrayList, viewGroup.getChildAt(OplusGLSurfaceView_13));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3604a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String strM2898q = ViewCompat.m2898q(view);
            if (strM2898q != null) {
                map.put(strM2898q, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                    m3604a(map, viewGroup.getChildAt(OplusGLSurfaceView_13));
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3601a(View view, final ArrayList<View> arrayList, final Map<String, String> map) {
        OneShotPreDrawListener.m2819a(view, new Runnable() { // from class: androidx.fragment.app.OplusGLSurfaceView_11.2
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    View view2 = (View) arrayList.get(OplusGLSurfaceView_13);
                    String strM2898q = ViewCompat.m2898q(view2);
                    if (strM2898q != null) {
                        ViewCompat.m2859a(view2, FragmentTransitionImpl.m3594a((Map<String, String>) map, strM2898q));
                    }
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3602a(ViewGroup viewGroup, final ArrayList<View> arrayList, final Map<String, String> map) {
        OneShotPreDrawListener.m2819a(viewGroup, new Runnable() { // from class: androidx.fragment.app.OplusGLSurfaceView_11.3
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    View view = (View) arrayList.get(OplusGLSurfaceView_13);
                    ViewCompat.m2859a(view, (String) map.get(ViewCompat.m2898q(view)));
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected static void m3595a(List<View> list, View view) {
        int size = list.size();
        if (m3597a(list, view, size)) {
            return;
        }
        list.add(view);
        for (int OplusGLSurfaceView_13 = size; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            View view2 = list.get(OplusGLSurfaceView_13);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!m3597a(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m3597a(List<View> list, View view, int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected static boolean m3596a(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static String m3594a(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
