package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.OnBackPressedDispatcher;
import androidx.collection.ArraySet;
import androidx.core.p035g.DebugUtils;
import androidx.core.p035g.LogWriter;
import androidx.core.p036h.OneShotPreDrawListener;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentManagerImpl.java */
/* renamed from: androidx.fragment.app.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
final class FragmentManagerImpl extends FragmentManager implements LayoutInflater.Factory2 {

    /* renamed from: D */
    static final Interpolator f3436D = new DecelerateInterpolator(2.5f);

    /* renamed from: E */
    static final Interpolator f3437E = new DecelerateInterpolator(1.5f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    static boolean f3438b;

    /* renamed from: B */
    ArrayList<COUIBaseListPopupWindow_11> f3440B;

    /* renamed from: F */
    private OnBackPressedDispatcher f3442F;

    /* renamed from: I */
    private FragmentManagerViewModel f3445I;

    /* renamed from: IntrinsicsJvm.kt_3 */
    ArrayList<COUIBaseListPopupWindow_8> f3446c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean f3447d;

    /* renamed from: COUIBaseListPopupWindow_10 */
    ArrayList<BackStackRecord> f3451h;

    /* renamed from: OplusGLSurfaceView_13 */
    ArrayList<Fragment> f3452i;

    /* renamed from: OplusGLSurfaceView_15 */
    ArrayList<BackStackRecord> f3453j;

    /* renamed from: OplusGLSurfaceView_5 */
    ArrayList<Integer> f3454k;

    /* renamed from: OplusGLSurfaceView_14 */
    ArrayList<FragmentManager.IntrinsicsJvm.kt_4> f3455l;

    /* renamed from: OplusGLSurfaceView_11 */
    FragmentHostCallback f3457n;

    /* renamed from: o */
    FragmentContainer f3458o;

    /* renamed from: p */
    Fragment f3459p;

    /* renamed from: q */
    Fragment f3460q;

    /* renamed from: r */
    boolean f3461r;

    /* renamed from: s */
    boolean f3462s;

    /* renamed from: t */
    boolean f3463t;

    /* renamed from: u */
    boolean f3464u;

    /* renamed from: v */
    boolean f3465v;

    /* renamed from: w */
    ArrayList<BackStackRecord> f3466w;

    /* renamed from: x */
    ArrayList<Boolean> f3467x;

    /* renamed from: y */
    ArrayList<Fragment> f3468y;

    /* renamed from: COUIBaseListPopupWindow_8 */
    int f3448e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    final ArrayList<Fragment> f3449f = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_11 */
    final HashMap<String, Fragment> f3450g = new HashMap<>();

    /* renamed from: G */
    private final OnBackPressedCallback f3443G = new OnBackPressedCallback(false) { // from class: androidx.fragment.app.OplusGLSurfaceView_13.1
        @Override // androidx.activity.OnBackPressedCallback
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo728c() {
            FragmentManagerImpl.this.m3493h();
        }
    };

    /* renamed from: H */
    private final CopyOnWriteArrayList<IntrinsicsJvm.kt_3> f3444H = new CopyOnWriteArrayList<>();

    /* renamed from: OplusGLSurfaceView_6 */
    int f3456m = 0;

    /* renamed from: z */
    Bundle f3469z = null;

    /* renamed from: A */
    SparseArray<Parcelable> f3439A = null;

    /* renamed from: C */
    Runnable f3441C = new Runnable() { // from class: androidx.fragment.app.OplusGLSurfaceView_13.2
        @Override // java.lang.Runnable
        public void run() {
            FragmentManagerImpl.this.m3503l();
        }
    };

    /* compiled from: FragmentManagerImpl.java */
    /* renamed from: androidx.fragment.app.OplusGLSurfaceView_13$IntrinsicsJvm.kt_5 */
    static class IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        public static final int[] f3494a = {R.attr.name, R.attr.id_renamed, R.attr.tag};
    }

    /* compiled from: FragmentManagerImpl.java */
    /* renamed from: androidx.fragment.app.OplusGLSurfaceView_13$COUIBaseListPopupWindow_8 */
    interface COUIBaseListPopupWindow_8 {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo3318a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m3431b(int OplusGLSurfaceView_13, boolean z) {
        if (OplusGLSurfaceView_13 == 4097) {
            return z ? 1 : 2;
        }
        if (OplusGLSurfaceView_13 == 4099) {
            return z ? 5 : 6;
        }
        if (OplusGLSurfaceView_13 != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static int m3437d(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 4097) {
            return 8194;
        }
        if (OplusGLSurfaceView_13 != 4099) {
            return OplusGLSurfaceView_13 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* renamed from: C */
    LayoutInflater.Factory2 m3444C() {
        return this;
    }

    FragmentManagerImpl() {
    }

    /* compiled from: FragmentManagerImpl.java */
    /* renamed from: androidx.fragment.app.OplusGLSurfaceView_13$IntrinsicsJvm.kt_3 */
    private static final class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final FragmentManager.PlatformImplementations.kt_3 f3492a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final boolean f3493b;

        IntrinsicsJvm.kt_3(FragmentManager.PlatformImplementations.kt_3 aVar, boolean z) {
            this.f3492a = aVar;
            this.f3493b = z;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3427a(RuntimeException runtimeException) {
        Log.COUIBaseListPopupWindow_8("FragmentManager", runtimeException.getMessage());
        Log.COUIBaseListPopupWindow_8("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        FragmentHostCallback abstractC0585g = this.f3457n;
        if (abstractC0585g != null) {
            try {
                abstractC0585g.mo3345a("  ", (FileDescriptor) null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.COUIBaseListPopupWindow_8("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            mo3394a("  ", (FileDescriptor) null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.COUIBaseListPopupWindow_8("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: PlatformImplementations.kt_3 */
    public FragmentTransaction mo3389a() {
        return new BackStackRecord(this);
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo3395b() throws Resources.NotFoundException {
        boolean zM3503l = m3503l();
        m3419G();
        return zM3503l;
    }

    /* renamed from: D */
    private void m3416D() {
        ArrayList<COUIBaseListPopupWindow_8> arrayList = this.f3446c;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f3443G.m724a(true);
        } else {
            this.f3443G.m724a(m3496i() > 0 && m3467a(this.f3459p));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m3467a(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManagerImpl layoutInflaterFactory2C0587i = fragment.mFragmentManager;
        return fragment == layoutInflaterFactory2C0587i.m3442A() && m3467a(layoutInflaterFactory2C0587i.f3459p);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    void m3493h() {
        m3503l();
        if (this.f3443G.m725a()) {
            mo3396c();
        } else {
            this.f3442F.m717a();
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo3396c() {
        m3417E();
        return m3430a((String) null, -1, 0);
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3390a(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("Bad id_renamed: " + OplusGLSurfaceView_13);
        }
        m3461a((COUIBaseListPopupWindow_8) new COUIBaseListPopupWindow_12(null, OplusGLSurfaceView_13, i2), false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m3430a(String str, int OplusGLSurfaceView_13, int i2) {
        m3503l();
        m3435c(true);
        Fragment fragment = this.f3460q;
        if (fragment != null && OplusGLSurfaceView_13 < 0 && str == null && fragment.getChildFragmentManager().mo3396c()) {
            return true;
        }
        boolean zM3468a = m3468a(this.f3466w, this.f3467x, str, OplusGLSurfaceView_13, i2);
        if (zM3468a) {
            this.f3447d = true;
            try {
                m3433b(this.f3466w, this.f3467x);
            } finally {
                m3418F();
            }
        }
        m3416D();
        m3504m();
        m3421I();
        return zM3468a;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m3496i() {
        ArrayList<BackStackRecord> arrayList = this.f3451h;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3451a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            m3427a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Fragment m3446a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.f3450g.get(string);
        if (fragment == null) {
            m3427a(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id_renamed " + string));
        }
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: IntrinsicsJvm.kt_5 */
    public List<Fragment> mo3397d() {
        List<Fragment> list;
        if (this.f3449f.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3449f) {
            list = (List) this.f3449f.clone();
        }
        return list;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    ViewModelStore m3471b(Fragment fragment) {
        return this.f3445I.m3537e(fragment);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    FragmentManagerViewModel m3480c(Fragment fragment) {
        return this.f3445I.m3536d(fragment);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m3484d(Fragment fragment) {
        if (mo3400g()) {
            if (f3438b) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.f3445I.m3531a(fragment) && f3438b) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    void m3487e(Fragment fragment) {
        if (mo3400g()) {
            if (f3438b) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.f3445I.m3535c(fragment) && f3438b) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo3398e() {
        return this.f3464u;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f3459p;
        if (fragment != null) {
            DebugUtils.m2527a(fragment, sb);
        } else {
            DebugUtils.m2527a(this.f3457n, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3394a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.f3450g.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.f3450g.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.f3449f.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size5; OplusGLSurfaceView_13++) {
                Fragment fragment2 = this.f3449f.get(OplusGLSurfaceView_13);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(OplusGLSurfaceView_13);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.f3452i;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                Fragment fragment3 = this.f3452i.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<BackStackRecord> arrayList2 = this.f3451h;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                BackStackRecord c0579a = this.f3451h.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(c0579a.toString());
                c0579a.m3315a(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.f3453j != null && (size2 = this.f3453j.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    Object obj = (BackStackRecord) this.f3453j.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.f3454k != null && this.f3454k.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f3454k.toArray()));
            }
        }
        ArrayList<COUIBaseListPopupWindow_8> arrayList3 = this.f3446c;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                Object obj2 = (COUIBaseListPopupWindow_8) this.f3446c.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3457n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3458o);
        if (this.f3459p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3459p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3456m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3462s);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3463t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3464u);
        if (this.f3461r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3461r);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static PlatformImplementations.kt_3 m3424a(float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f3436D);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(f3437E);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new PlatformImplementations.kt_3(animationSet);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static PlatformImplementations.kt_3 m3423a(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(f3437E);
        alphaAnimation.setDuration(220L);
        return new PlatformImplementations.kt_3(alphaAnimation);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    PlatformImplementations.kt_3 m3447a(Fragment fragment, int OplusGLSurfaceView_13, boolean z, int i2) throws Resources.NotFoundException {
        int iM3431b;
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        if (fragment.mContainer != null && fragment.mContainer.getLayoutTransition() != null) {
            return null;
        }
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(OplusGLSurfaceView_13, z, nextAnim);
        if (animationOnCreateAnimation != null) {
            return new PlatformImplementations.kt_3(animationOnCreateAnimation);
        }
        Animator animatorOnCreateAnimator = fragment.onCreateAnimator(OplusGLSurfaceView_13, z, nextAnim);
        if (animatorOnCreateAnimator != null) {
            return new PlatformImplementations.kt_3(animatorOnCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean zEquals = "anim".equals(this.f3457n.m3386j().getResources().getResourceTypeName(nextAnim));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f3457n.m3386j(), nextAnim);
                    if (animationLoadAnimation != null) {
                        return new PlatformImplementations.kt_3(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(this.f3457n.m3386j(), nextAnim);
                    if (animatorLoadAnimator != null) {
                        return new PlatformImplementations.kt_3(animatorLoadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (zEquals) {
                        throw e3;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this.f3457n.m3386j(), nextAnim);
                    if (animationLoadAnimation2 != null) {
                        return new PlatformImplementations.kt_3(animationLoadAnimation2);
                    }
                }
            }
        }
        if (OplusGLSurfaceView_13 == 0 || (iM3431b = m3431b(OplusGLSurfaceView_13, z)) < 0) {
            return null;
        }
        switch (iM3431b) {
            case 1:
                return m3424a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return m3424a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return m3424a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return m3424a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return m3423a(0.0f, 1.0f);
            case 6:
                return m3423a(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f3457n.mo3352f()) {
                    i2 = this.f3457n.mo3353g();
                }
                if (i2 == 0) {
                }
                return null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m3489f(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.f3447d) {
                this.f3465v = true;
            } else {
                fragment.mDeferStart = false;
                m3453a(fragment, this.f3456m, 0, 0, false);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m3463a(int OplusGLSurfaceView_13) {
        return this.f3456m >= OplusGLSurfaceView_13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:279:? A[RETURN, SYNTHETIC] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m3453a(androidx.fragment.app.Fragment r19, int r20, int r21, int r22, boolean r23) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManagerImpl.m3453a(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3426a(final Fragment fragment, PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(OplusGLSurfaceView_13);
        if (aVar.f3485a != null) {
            IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(aVar.f3485a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            bVar.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.OplusGLSurfaceView_13.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() { // from class: androidx.fragment.app.OplusGLSurfaceView_13.3.1
                        @Override // java.lang.Runnable
                        public void run() throws Resources.NotFoundException {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway(null);
                                FragmentManagerImpl.this.m3453a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            fragment.mView.startAnimation(bVar);
            return;
        }
        Animator animator = aVar.f3486b;
        fragment.setAnimator(aVar.f3486b);
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.OplusGLSurfaceView_13.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) throws Resources.NotFoundException {
                viewGroup.endViewTransition(view);
                Animator animator3 = fragment.getAnimator();
                fragment.setAnimator(null);
                if (animator3 == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                FragmentManagerImpl layoutInflaterFactory2C0587i = FragmentManagerImpl.this;
                Fragment fragment2 = fragment;
                layoutInflaterFactory2C0587i.m3453a(fragment2, fragment2.getStateAfterAnimating(), 0, 0, false);
            }
        });
        animator.setTarget(fragment.mView);
        animator.start();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    void m3491g(Fragment fragment) throws Resources.NotFoundException {
        m3453a(fragment, this.f3456m, 0, 0, false);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    void m3494h(Fragment fragment) {
        if (!fragment.mFromLayout || fragment.mPerformedCreateView) {
            return;
        }
        fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
        if (fragment.mView != null) {
            fragment.mInnerView = fragment.mView;
            fragment.mView.setSaveFromParentEnabled(false);
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
            m3456a(fragment, fragment.mView, fragment.mSavedFragmentState, false);
            return;
        }
        fragment.mInnerView = null;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    void m3497i(final Fragment fragment) throws Resources.NotFoundException {
        if (fragment.mView != null) {
            PlatformImplementations.kt_3 aVarM3447a = m3447a(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (aVarM3447a != null && aVarM3447a.f3486b != null) {
                aVarM3447a.f3486b.setTarget(fragment.mView);
                if (fragment.mHidden) {
                    if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    } else {
                        final ViewGroup viewGroup = fragment.mContainer;
                        final View view = fragment.mView;
                        viewGroup.startViewTransition(view);
                        aVarM3447a.f3486b.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.OplusGLSurfaceView_13.5
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view);
                                animator.removeListener(this);
                                if (fragment.mView == null || !fragment.mHidden) {
                                    return;
                                }
                                fragment.mView.setVisibility(8);
                            }
                        });
                    }
                } else {
                    fragment.mView.setVisibility(0);
                }
                aVarM3447a.f3486b.start();
            } else {
                if (aVarM3447a != null) {
                    fragment.mView.startAnimation(aVarM3447a.f3485a);
                    aVarM3447a.f3485a.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            }
        }
        if (fragment.mAdded && m3441w(fragment)) {
            this.f3461r = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    void m3499j(Fragment fragment) throws Resources.NotFoundException {
        if (fragment == null) {
            return;
        }
        if (!this.f3450g.containsKey(fragment.mWho)) {
            if (f3438b) {
                Log.v("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f3456m + "since it is not added to " + this);
                return;
            }
            return;
        }
        int iMin = this.f3456m;
        if (fragment.mRemoving) {
            if (fragment.isInBackStack()) {
                iMin = Math.min(iMin, 1);
            } else {
                iMin = Math.min(iMin, 0);
            }
        }
        m3453a(fragment, iMin, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
        if (fragment.mView != null) {
            Fragment fragmentM3439u = m3439u(fragment);
            if (fragmentM3439u != null) {
                View view = fragmentM3439u.mView;
                ViewGroup viewGroup = fragment.mContainer;
                int iIndexOfChild = viewGroup.indexOfChild(view);
                int iIndexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                if (iIndexOfChild2 < iIndexOfChild) {
                    viewGroup.removeViewAt(iIndexOfChild2);
                    viewGroup.addView(fragment.mView, iIndexOfChild);
                }
            }
            if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                if (fragment.mPostponedAlpha > 0.0f) {
                    fragment.mView.setAlpha(fragment.mPostponedAlpha);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                PlatformImplementations.kt_3 aVarM3447a = m3447a(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                if (aVarM3447a != null) {
                    if (aVarM3447a.f3485a != null) {
                        fragment.mView.startAnimation(aVarM3447a.f3485a);
                    } else {
                        aVarM3447a.f3486b.setTarget(fragment.mView);
                        aVarM3447a.f3486b.start();
                    }
                }
            }
        }
        if (fragment.mHiddenChanged) {
            m3497i(fragment);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3449a(int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        FragmentHostCallback abstractC0585g;
        if (this.f3457n == null && OplusGLSurfaceView_13 != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || OplusGLSurfaceView_13 != this.f3456m) {
            this.f3456m = OplusGLSurfaceView_13;
            int size = this.f3449f.size();
            for (int i2 = 0; i2 < size; i2++) {
                m3499j(this.f3449f.get(i2));
            }
            for (Fragment fragment : this.f3450g.values()) {
                if (fragment != null && (fragment.mRemoving || fragment.mDetached)) {
                    if (!fragment.mIsNewlyAdded) {
                        m3499j(fragment);
                    }
                }
            }
            m3498j();
            if (this.f3461r && (abstractC0585g = this.f3457n) != null && this.f3456m == 4) {
                abstractC0585g.mo3351e();
                this.f3461r = false;
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    void m3498j() {
        for (Fragment fragment : this.f3450g.values()) {
            if (fragment != null) {
                m3489f(fragment);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    void m3501k(Fragment fragment) {
        if (this.f3450g.get(fragment.mWho) != null) {
            return;
        }
        this.f3450g.put(fragment.mWho, fragment);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                m3484d(fragment);
            } else {
                m3487e(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (f3438b) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    void m3502l(Fragment fragment) {
        if (this.f3450g.get(fragment.mWho) == null) {
            return;
        }
        if (f3438b) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
        for (Fragment fragment2 : this.f3450g.values()) {
            if (fragment2 != null && fragment.mWho.equals(fragment2.mTargetWho)) {
                fragment2.mTarget = fragment;
                fragment2.mTargetWho = null;
            }
        }
        this.f3450g.put(fragment.mWho, null);
        m3487e(fragment);
        if (fragment.mTargetWho != null) {
            fragment.mTarget = this.f3450g.get(fragment.mTargetWho);
        }
        fragment.initState();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3458a(Fragment fragment, boolean z) throws Resources.NotFoundException {
        if (f3438b) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m3501k(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (this.f3449f.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f3449f) {
            this.f3449f.add(fragment);
        }
        fragment.mAdded = true;
        fragment.mRemoving = false;
        if (fragment.mView == null) {
            fragment.mHiddenChanged = false;
        }
        if (m3441w(fragment)) {
            this.f3461r = true;
        }
        if (z) {
            m3491g(fragment);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m3505m(Fragment fragment) {
        if (f3438b) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.f3449f) {
                this.f3449f.remove(fragment);
            }
            if (m3441w(fragment)) {
                this.f3461r = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m3507n(Fragment fragment) {
        if (f3438b) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
    }

    /* renamed from: o */
    public void m3509o(Fragment fragment) {
        if (f3438b) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    /* renamed from: p */
    public void m3511p(Fragment fragment) {
        if (f3438b) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (f3438b) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.f3449f) {
                this.f3449f.remove(fragment);
            }
            if (m3441w(fragment)) {
                this.f3461r = true;
            }
            fragment.mAdded = false;
        }
    }

    /* renamed from: q */
    public void m3513q(Fragment fragment) {
        if (f3438b) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (this.f3449f.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (f3438b) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            synchronized (this.f3449f) {
                this.f3449f.add(fragment);
            }
            fragment.mAdded = true;
            if (m3441w(fragment)) {
                this.f3461r = true;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Fragment m3469b(int OplusGLSurfaceView_13) {
        for (int size = this.f3449f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f3449f.get(size);
            if (fragment != null && fragment.mFragmentId == OplusGLSurfaceView_13) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.f3450g.values()) {
            if (fragment2 != null && fragment2.mFragmentId == OplusGLSurfaceView_13) {
                return fragment2;
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: PlatformImplementations.kt_3 */
    public Fragment mo3388a(String str) {
        if (str != null) {
            for (int size = this.f3449f.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f3449f.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment fragment2 : this.f3450g.values()) {
            if (fragment2 != null && str.equals(fragment2.mTag)) {
                return fragment2;
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Fragment m3470b(String str) {
        Fragment fragmentFindFragmentByWho;
        for (Fragment fragment : this.f3450g.values()) {
            if (fragment != null && (fragmentFindFragmentByWho = fragment.findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    /* renamed from: E */
    private void m3417E() {
        if (mo3400g()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean mo3400g() {
        return this.f3462s || this.f3463t;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3461a(COUIBaseListPopupWindow_8 eVar, boolean z) {
        if (!z) {
            m3417E();
        }
        synchronized (this) {
            if (!this.f3464u && this.f3457n != null) {
                if (this.f3446c == null) {
                    this.f3446c = new ArrayList<>();
                }
                this.f3446c.add(eVar);
                m3500k();
                return;
            }
            if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    void m3500k() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.f3440B == null || this.f3440B.isEmpty()) ? false : true;
            if (this.f3446c != null && this.f3446c.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.f3457n.m3387k().removeCallbacks(this.f3441C);
                this.f3457n.m3387k().post(this.f3441C);
                m3416D();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m3445a(BackStackRecord c0579a) {
        synchronized (this) {
            if (this.f3454k != null && this.f3454k.size() > 0) {
                int iIntValue = this.f3454k.remove(this.f3454k.size() - 1).intValue();
                if (f3438b) {
                    Log.v("FragmentManager", "Adding back stack index " + iIntValue + " with " + c0579a);
                }
                this.f3453j.set(iIntValue, c0579a);
                return iIntValue;
            }
            if (this.f3453j == null) {
                this.f3453j = new ArrayList<>();
            }
            int size = this.f3453j.size();
            if (f3438b) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0579a);
            }
            this.f3453j.add(c0579a);
            return size;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3448a(int OplusGLSurfaceView_13, BackStackRecord c0579a) {
        synchronized (this) {
            if (this.f3453j == null) {
                this.f3453j = new ArrayList<>();
            }
            int size = this.f3453j.size();
            if (OplusGLSurfaceView_13 < size) {
                if (f3438b) {
                    Log.v("FragmentManager", "Setting back stack index " + OplusGLSurfaceView_13 + " to " + c0579a);
                }
                this.f3453j.set(OplusGLSurfaceView_13, c0579a);
            } else {
                while (size < OplusGLSurfaceView_13) {
                    this.f3453j.add(null);
                    if (this.f3454k == null) {
                        this.f3454k = new ArrayList<>();
                    }
                    if (f3438b) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f3454k.add(Integer.valueOf(size));
                    size++;
                }
                if (f3438b) {
                    Log.v("FragmentManager", "Adding back stack index " + OplusGLSurfaceView_13 + " with " + c0579a);
                }
                this.f3453j.add(c0579a);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m3481c(int OplusGLSurfaceView_13) {
        synchronized (this) {
            this.f3453j.set(OplusGLSurfaceView_13, null);
            if (this.f3454k == null) {
                this.f3454k = new ArrayList<>();
            }
            if (f3438b) {
                Log.v("FragmentManager", "Freeing back stack index " + OplusGLSurfaceView_13);
            }
            this.f3454k.add(Integer.valueOf(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3435c(boolean z) {
        if (this.f3447d) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f3457n == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.f3457n.m3387k().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            m3417E();
        }
        if (this.f3466w == null) {
            this.f3466w = new ArrayList<>();
            this.f3467x = new ArrayList<>();
        }
        this.f3447d = true;
        try {
            m3428a((ArrayList<BackStackRecord>) null, (ArrayList<Boolean>) null);
        } finally {
            this.f3447d = false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3477b(COUIBaseListPopupWindow_8 eVar, boolean z) {
        if (z && (this.f3457n == null || this.f3464u)) {
            return;
        }
        m3435c(z);
        if (eVar.mo3318a(this.f3466w, this.f3467x)) {
            this.f3447d = true;
            try {
                m3433b(this.f3466w, this.f3467x);
            } finally {
                m3418F();
            }
        }
        m3416D();
        m3504m();
        m3421I();
    }

    /* renamed from: F */
    private void m3418F() {
        this.f3447d = false;
        this.f3467x.clear();
        this.f3466w.clear();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m3503l() {
        m3435c(true);
        boolean z = false;
        while (m3436c(this.f3466w, this.f3467x)) {
            this.f3447d = true;
            try {
                m3433b(this.f3466w, this.f3467x);
                m3418F();
                z = true;
            } catch (Throwable th) {
                m3418F();
                throw th;
            }
        }
        m3416D();
        m3504m();
        m3421I();
        return z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3428a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) throws Resources.NotFoundException {
        int iIndexOf;
        int iIndexOf2;
        ArrayList<COUIBaseListPopupWindow_11> arrayList3 = this.f3440B;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < size) {
            COUIBaseListPopupWindow_11 gVar = this.f3440B.get(OplusGLSurfaceView_13);
            if (arrayList != null && !gVar.f3499a && (iIndexOf2 = arrayList.indexOf(gVar.f3500b)) != -1 && arrayList2.get(iIndexOf2).booleanValue()) {
                this.f3440B.remove(OplusGLSurfaceView_13);
                OplusGLSurfaceView_13--;
                size--;
                gVar.m3528e();
            } else if (gVar.m3526c() || (arrayList != null && gVar.f3500b.m3317a(arrayList, 0, arrayList.size()))) {
                this.f3440B.remove(OplusGLSurfaceView_13);
                OplusGLSurfaceView_13--;
                size--;
                if (arrayList != null && !gVar.f3499a && (iIndexOf = arrayList.indexOf(gVar.f3500b)) != -1 && arrayList2.get(iIndexOf).booleanValue()) {
                    gVar.m3528e();
                } else {
                    gVar.m3527d();
                }
            }
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m3433b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) throws Resources.NotFoundException {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        m3428a(arrayList, arrayList2);
        int size = arrayList.size();
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        while (OplusGLSurfaceView_13 < size) {
            if (!arrayList.get(OplusGLSurfaceView_13).f3525t) {
                if (i2 != OplusGLSurfaceView_13) {
                    m3429a(arrayList, arrayList2, i2, OplusGLSurfaceView_13);
                }
                i2 = OplusGLSurfaceView_13 + 1;
                if (arrayList2.get(OplusGLSurfaceView_13).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).f3525t) {
                        i2++;
                    }
                }
                m3429a(arrayList, arrayList2, OplusGLSurfaceView_13, i2);
                OplusGLSurfaceView_13 = i2 - 1;
            }
            OplusGLSurfaceView_13++;
        }
        if (i2 != size) {
            m3429a(arrayList, arrayList2, i2, size);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3429a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        int i3;
        int i4 = OplusGLSurfaceView_13;
        boolean z = arrayList.get(i4).f3525t;
        ArrayList<Fragment> arrayList3 = this.f3468y;
        if (arrayList3 == null) {
            this.f3468y = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.f3468y.addAll(this.f3449f);
        Fragment fragmentM3442A = m3442A();
        boolean z2 = false;
        for (int i5 = i4; i5 < i2; i5++) {
            BackStackRecord c0579a = arrayList.get(i5);
            if (!arrayList2.get(i5).booleanValue()) {
                fragmentM3442A = c0579a.m3308a(this.f3468y, fragmentM3442A);
            } else {
                fragmentM3442A = c0579a.m3320b(this.f3468y, fragmentM3442A);
            }
            z2 = z2 || c0579a.f3516k;
        }
        this.f3468y.clear();
        if (!z) {
            FragmentTransition.m3565a(this, arrayList, arrayList2, OplusGLSurfaceView_13, i2, false);
        }
        m3434b(arrayList, arrayList2, OplusGLSurfaceView_13, i2);
        if (z) {
            ArraySet<Fragment> arraySet = new ArraySet<>();
            m3432b(arraySet);
            int iM3422a = m3422a(arrayList, arrayList2, OplusGLSurfaceView_13, i2, arraySet);
            m3425a(arraySet);
            i3 = iM3422a;
        } else {
            i3 = i2;
        }
        if (i3 != i4 && z) {
            FragmentTransition.m3565a(this, arrayList, arrayList2, OplusGLSurfaceView_13, i3, true);
            m3449a(this.f3456m, true);
        }
        while (i4 < i2) {
            BackStackRecord c0579a2 = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue() && c0579a2.f3414c >= 0) {
                m3481c(c0579a2.f3414c);
                c0579a2.f3414c = -1;
            }
            c0579a2.m3311a();
            i4++;
        }
        if (z2) {
            m3506n();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3425a(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            Fragment fragmentValueAt = arraySet.valueAt(OplusGLSurfaceView_13);
            if (!fragmentValueAt.mAdded) {
                View viewRequireView = fragmentValueAt.requireView();
                fragmentValueAt.mPostponedAlpha = viewRequireView.getAlpha();
                viewRequireView.setAlpha(0.0f);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m3422a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int OplusGLSurfaceView_13, int i2, ArraySet<Fragment> arraySet) throws Resources.NotFoundException {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= OplusGLSurfaceView_13; i4--) {
            BackStackRecord c0579a = arrayList.get(i4);
            boolean zBooleanValue = arrayList2.get(i4).booleanValue();
            if (c0579a.m3327f() && !c0579a.m3317a(arrayList, i4 + 1, i2)) {
                if (this.f3440B == null) {
                    this.f3440B = new ArrayList<>();
                }
                COUIBaseListPopupWindow_11 gVar = new COUIBaseListPopupWindow_11(c0579a, zBooleanValue);
                this.f3440B.add(gVar);
                c0579a.m3314a(gVar);
                if (zBooleanValue) {
                    c0579a.m3326e();
                } else {
                    c0579a.m3322b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, c0579a);
                }
                m3432b(arraySet);
            }
        }
        return i3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3459a(BackStackRecord c0579a, boolean z, boolean z2, boolean z3) throws Resources.NotFoundException {
        if (z) {
            c0579a.m3322b(z3);
        } else {
            c0579a.m3326e();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c0579a);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            FragmentTransition.m3565a(this, (ArrayList<BackStackRecord>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            m3449a(this.f3456m, true);
        }
        for (Fragment fragment : this.f3450g.values()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && c0579a.m3323b(fragment.mContainerId)) {
                if (fragment.mPostponedAlpha > 0.0f) {
                    fragment.mView.setAlpha(fragment.mPostponedAlpha);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    /* renamed from: u */
    private Fragment m3439u(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup != null && view != null) {
            for (int iIndexOf = this.f3449f.indexOf(fragment) - 1; iIndexOf >= 0; iIndexOf--) {
                Fragment fragment2 = this.f3449f.get(iIndexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m3434b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int OplusGLSurfaceView_13, int i2) {
        while (OplusGLSurfaceView_13 < i2) {
            BackStackRecord c0579a = arrayList.get(OplusGLSurfaceView_13);
            if (arrayList2.get(OplusGLSurfaceView_13).booleanValue()) {
                c0579a.m3312a(-1);
                c0579a.m3322b(OplusGLSurfaceView_13 == i2 + (-1));
            } else {
                c0579a.m3312a(1);
                c0579a.m3326e();
            }
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m3432b(ArraySet<Fragment> arraySet) throws Resources.NotFoundException {
        int OplusGLSurfaceView_13 = this.f3456m;
        if (OplusGLSurfaceView_13 < 1) {
            return;
        }
        int iMin = Math.min(OplusGLSurfaceView_13, 3);
        int size = this.f3449f.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f3449f.get(i2);
            if (fragment.mState < iMin) {
                m3453a(fragment, iMin, fragment.getNextAnim(), fragment.getNextTransition(), false);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    arraySet.add(fragment);
                }
            }
        }
    }

    /* renamed from: G */
    private void m3419G() throws Resources.NotFoundException {
        if (this.f3440B != null) {
            while (!this.f3440B.isEmpty()) {
                this.f3440B.remove(0).m3527d();
            }
        }
    }

    /* renamed from: H */
    private void m3420H() throws Resources.NotFoundException {
        for (Fragment fragment : this.f3450g.values()) {
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    View animatingAway = fragment.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragment.setAnimatingAway(null);
                    m3453a(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m3436c(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.f3446c != null && this.f3446c.size() != 0) {
                int size = this.f3446c.size();
                boolean zMo3318a = false;
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    zMo3318a |= this.f3446c.get(OplusGLSurfaceView_13).mo3318a(arrayList, arrayList2);
                }
                this.f3446c.clear();
                this.f3457n.m3387k().removeCallbacks(this.f3441C);
                return zMo3318a;
            }
            return false;
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    void m3504m() {
        if (this.f3465v) {
            this.f3465v = false;
            m3498j();
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    void m3506n() {
        if (this.f3455l != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3455l.size(); OplusGLSurfaceView_13++) {
                this.f3455l.get(OplusGLSurfaceView_13).m3415a();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m3476b(BackStackRecord c0579a) {
        if (this.f3451h == null) {
            this.f3451h = new ArrayList<>();
        }
        this.f3451h.add(c0579a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m3468a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int OplusGLSurfaceView_13, int i2) {
        int size;
        ArrayList<BackStackRecord> arrayList3 = this.f3451h;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && OplusGLSurfaceView_13 < 0 && (i2 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.f3451h.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || OplusGLSurfaceView_13 >= 0) {
                size = this.f3451h.size() - 1;
                while (size >= 0) {
                    BackStackRecord c0579a = this.f3451h.get(size);
                    if ((str != null && str.equals(c0579a.m3328g())) || (OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 == c0579a.f3414c)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        BackStackRecord c0579a2 = this.f3451h.get(size);
                        if (str == null || !str.equals(c0579a2.m3328g())) {
                            if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 != c0579a2.f3414c) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.f3451h.size() - 1) {
                return false;
            }
            for (int size3 = this.f3451h.size() - 1; size3 > size; size3--) {
                arrayList.add(this.f3451h.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* renamed from: r */
    void m3515r(Fragment fragment) {
        if (fragment.mInnerView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.f3439A;
        if (sparseArray == null) {
            this.f3439A = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.mInnerView.saveHierarchyState(this.f3439A);
        if (this.f3439A.size() > 0) {
            fragment.mSavedViewState = this.f3439A;
            this.f3439A = null;
        }
    }

    /* renamed from: s */
    Bundle m3516s(Fragment fragment) {
        Bundle bundle;
        if (this.f3469z == null) {
            this.f3469z = new Bundle();
        }
        fragment.performSaveInstanceState(this.f3469z);
        m3485d(fragment, this.f3469z, false);
        if (this.f3469z.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f3469z;
            this.f3469z = null;
        }
        if (fragment.mView != null) {
            m3515r(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* renamed from: o */
    Parcelable m3508o() {
        ArrayList<String> arrayList;
        int size;
        m3419G();
        m3420H();
        m3503l();
        this.f3462s = true;
        BackStackState[] backStackStateArr = null;
        if (this.f3450g.isEmpty()) {
            return null;
        }
        ArrayList<FragmentState> arrayList2 = new ArrayList<>(this.f3450g.size());
        boolean z = false;
        for (Fragment fragment : this.f3450g.values()) {
            if (fragment != null) {
                if (fragment.mFragmentManager != this) {
                    m3427a(new IllegalStateException("Failure saving state: active " + fragment + " was removed from the FragmentManager"));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                arrayList2.add(fragmentState);
                if (fragment.mState > 0 && fragmentState.mSavedFragmentState == null) {
                    fragmentState.mSavedFragmentState = m3516s(fragment);
                    if (fragment.mTargetWho != null) {
                        Fragment fragment2 = this.f3450g.get(fragment.mTargetWho);
                        if (fragment2 == null) {
                            m3427a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTargetWho));
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        m3451a(fragmentState.mSavedFragmentState, "android:target_state", fragment2);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                } else {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                }
                if (f3438b) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState);
                }
                z = true;
            }
        }
        if (!z) {
            if (f3438b) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.f3449f.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            Iterator<Fragment> it = this.f3449f.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (next.mFragmentManager != this) {
                    m3427a(new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                }
                if (f3438b) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<BackStackRecord> arrayList3 = this.f3451h;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                backStackStateArr[OplusGLSurfaceView_13] = new BackStackState(this.f3451h.get(OplusGLSurfaceView_13));
                if (f3438b) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + OplusGLSurfaceView_13 + ": " + this.f3451h.get(OplusGLSurfaceView_13));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.mActive = arrayList2;
        fragmentManagerState.mAdded = arrayList;
        fragmentManagerState.mBackStack = backStackStateArr;
        Fragment fragment3 = this.f3460q;
        if (fragment3 != null) {
            fragmentManagerState.mPrimaryNavActiveWho = fragment3.mWho;
        }
        fragmentManagerState.mNextFragmentIndex = this.f3448e;
        return fragmentManagerState;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3452a(Parcelable parcelable) {
        FragmentState next;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        for (Fragment fragment : this.f3445I.m3534c()) {
            if (f3438b) {
                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
            }
            Iterator<FragmentState> it = fragmentManagerState.mActive.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (next.mWho.equals(fragment.mWho)) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            if (next == null) {
                if (f3438b) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                }
                m3453a(fragment, 1, 0, 0, false);
                fragment.mRemoving = true;
                m3453a(fragment, 0, 0, 0, false);
            } else {
                next.mInstance = fragment;
                fragment.mSavedViewState = null;
                fragment.mBackStackNesting = 0;
                fragment.mInLayout = false;
                fragment.mAdded = false;
                fragment.mTargetWho = fragment.mTarget != null ? fragment.mTarget.mWho : null;
                fragment.mTarget = null;
                if (next.mSavedFragmentState != null) {
                    next.mSavedFragmentState.setClassLoader(this.f3457n.m3386j().getClassLoader());
                    fragment.mSavedViewState = next.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                    fragment.mSavedFragmentState = next.mSavedFragmentState;
                }
            }
        }
        this.f3450g.clear();
        Iterator<FragmentState> it2 = fragmentManagerState.mActive.iterator();
        while (it2.hasNext()) {
            FragmentState next2 = it2.next();
            if (next2 != null) {
                Fragment fragmentInstantiate = next2.instantiate(this.f3457n.m3386j().getClassLoader(), mo3399f());
                fragmentInstantiate.mFragmentManager = this;
                if (f3438b) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentInstantiate.mWho + "): " + fragmentInstantiate);
                }
                this.f3450g.put(fragmentInstantiate.mWho, fragmentInstantiate);
                next2.mInstance = null;
            }
        }
        this.f3449f.clear();
        if (fragmentManagerState.mAdded != null) {
            Iterator<String> it3 = fragmentManagerState.mAdded.iterator();
            while (it3.hasNext()) {
                String next3 = it3.next();
                Fragment fragment2 = this.f3450g.get(next3);
                if (fragment2 == null) {
                    m3427a(new IllegalStateException("No instantiated fragment for (" + next3 + ")"));
                }
                fragment2.mAdded = true;
                if (f3438b) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + next3 + "): " + fragment2);
                }
                if (this.f3449f.contains(fragment2)) {
                    throw new IllegalStateException("Already added " + fragment2);
                }
                synchronized (this.f3449f) {
                    this.f3449f.add(fragment2);
                }
            }
        }
        if (fragmentManagerState.mBackStack != null) {
            this.f3451h = new ArrayList<>(fragmentManagerState.mBackStack.length);
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < fragmentManagerState.mBackStack.length; OplusGLSurfaceView_13++) {
                BackStackRecord c0579aInstantiate = fragmentManagerState.mBackStack[OplusGLSurfaceView_13].instantiate(this);
                if (f3438b) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + OplusGLSurfaceView_13 + " (index " + c0579aInstantiate.f3414c + "): " + c0579aInstantiate);
                    PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                    c0579aInstantiate.m3316a("  ", printWriter, false);
                    printWriter.close();
                }
                this.f3451h.add(c0579aInstantiate);
                if (c0579aInstantiate.f3414c >= 0) {
                    m3448a(c0579aInstantiate.f3414c, c0579aInstantiate);
                }
            }
        } else {
            this.f3451h = null;
        }
        if (fragmentManagerState.mPrimaryNavActiveWho != null) {
            this.f3460q = this.f3450g.get(fragmentManagerState.mPrimaryNavActiveWho);
            m3440v(this.f3460q);
        }
        this.f3448e = fragmentManagerState.mNextFragmentIndex;
    }

    /* renamed from: I */
    private void m3421I() {
        this.f3450g.values().removeAll(Collections.singleton(null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m3460a(FragmentHostCallback abstractC0585g, FragmentContainer abstractC0582d, Fragment fragment) {
        if (this.f3457n != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f3457n = abstractC0585g;
        this.f3458o = abstractC0582d;
        this.f3459p = fragment;
        if (this.f3459p != null) {
            m3416D();
        }
        if (abstractC0585g instanceof OnBackPressedDispatcherOwner) {
            OnBackPressedDispatcherOwner interfaceC0176d = (OnBackPressedDispatcherOwner) abstractC0585g;
            this.f3442F = interfaceC0176d.mo721b();
            Fragment fragment2 = interfaceC0176d;
            if (fragment != null) {
                fragment2 = fragment;
            }
            this.f3442F.m718a(fragment2, this.f3443G);
        }
        if (fragment != null) {
            this.f3445I = fragment.mFragmentManager.m3480c(fragment);
        } else if (abstractC0585g instanceof ViewModelStoreOwner) {
            this.f3445I = FragmentManagerViewModel.m3529a(((ViewModelStoreOwner) abstractC0585g).getViewModelStore());
        } else {
            this.f3445I = new FragmentManagerViewModel(false);
        }
    }

    /* renamed from: p */
    public void m3510p() {
        this.f3462s = false;
        this.f3463t = false;
        int size = this.f3449f.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            Fragment fragment = this.f3449f.get(OplusGLSurfaceView_13);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    /* renamed from: q */
    public void m3512q() {
        this.f3462s = false;
        this.f3463t = false;
        m3438e(1);
    }

    /* renamed from: r */
    public void m3514r() {
        this.f3462s = false;
        this.f3463t = false;
        m3438e(2);
    }

    /* renamed from: s */
    public void m3517s() {
        this.f3462s = false;
        this.f3463t = false;
        m3438e(3);
    }

    /* renamed from: t */
    public void m3518t() {
        this.f3462s = false;
        this.f3463t = false;
        m3438e(4);
    }

    /* renamed from: u */
    public void m3520u() {
        m3438e(3);
    }

    /* renamed from: v */
    public void m3521v() {
        this.f3463t = true;
        m3438e(2);
    }

    /* renamed from: w */
    public void m3522w() {
        m3438e(1);
    }

    /* renamed from: x */
    public void m3523x() {
        this.f3464u = true;
        m3503l();
        m3438e(0);
        this.f3457n = null;
        this.f3458o = null;
        this.f3459p = null;
        if (this.f3442F != null) {
            this.f3443G.m726b();
            this.f3442F = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m3438e(int OplusGLSurfaceView_13) {
        try {
            this.f3447d = true;
            m3449a(OplusGLSurfaceView_13, false);
            this.f3447d = false;
            m3503l();
        } catch (Throwable th) {
            this.f3447d = false;
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3462a(boolean z) {
        for (int size = this.f3449f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f3449f.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3478b(boolean z) {
        for (int size = this.f3449f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f3449f.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3450a(Configuration configuration) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3449f.size(); OplusGLSurfaceView_13++) {
            Fragment fragment = this.f3449f.get(OplusGLSurfaceView_13);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    /* renamed from: y */
    public void m3524y() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3449f.size(); OplusGLSurfaceView_13++) {
            Fragment fragment = this.f3449f.get(OplusGLSurfaceView_13);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3465a(Menu menu, MenuInflater menuInflater) {
        if (this.f3456m < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3449f.size(); OplusGLSurfaceView_13++) {
            Fragment fragment = this.f3449f.get(OplusGLSurfaceView_13);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f3452i != null) {
            for (int i2 = 0; i2 < this.f3452i.size(); i2++) {
                Fragment fragment2 = this.f3452i.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f3452i = arrayList;
        return z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3464a(Menu menu) {
        if (this.f3456m < 1) {
            return false;
        }
        boolean z = false;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3449f.size(); OplusGLSurfaceView_13++) {
            Fragment fragment = this.f3449f.get(OplusGLSurfaceView_13);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m3466a(MenuItem menuItem) {
        if (this.f3456m < 1) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3449f.size(); OplusGLSurfaceView_13++) {
            Fragment fragment = this.f3449f.get(OplusGLSurfaceView_13);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m3479b(MenuItem menuItem) {
        if (this.f3456m < 1) {
            return false;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3449f.size(); OplusGLSurfaceView_13++) {
            Fragment fragment = this.f3449f.get(OplusGLSurfaceView_13);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3472b(Menu menu) {
        if (this.f3456m < 1) {
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3449f.size(); OplusGLSurfaceView_13++) {
            Fragment fragment = this.f3449f.get(OplusGLSurfaceView_13);
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    /* renamed from: t */
    public void m3519t(Fragment fragment) {
        if (fragment != null && (this.f3450g.get(fragment.mWho) != fragment || (fragment.mHost != null && fragment.getFragmentManager() != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        Fragment fragment2 = this.f3460q;
        this.f3460q = fragment;
        m3440v(fragment2);
        m3440v(this.f3460q);
    }

    /* renamed from: v */
    private void m3440v(Fragment fragment) {
        if (fragment == null || this.f3450g.get(fragment.mWho) != fragment) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    /* renamed from: z */
    void m3525z() {
        m3416D();
        m3440v(this.f3460q);
    }

    /* renamed from: A */
    public Fragment m3442A() {
        return this.f3460q;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3457a(Fragment fragment, Lifecycle.IntrinsicsJvm.kt_4 bVar) {
        if (this.f3450g.get(fragment.mWho) != fragment || (fragment.mHost != null && fragment.getFragmentManager() != this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = bVar;
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: COUIBaseListPopupWindow_12 */
    public FragmentFactory mo3399f() {
        if (super.mo3399f() == f3434a) {
            Fragment fragment = this.f3459p;
            if (fragment != null) {
                return fragment.mFragmentManager.mo3399f();
            }
            m3391a(new FragmentFactory() { // from class: androidx.fragment.app.OplusGLSurfaceView_13.6
                @Override // androidx.fragment.app.FragmentFactory
                /* renamed from: IntrinsicsJvm.kt_3 */
                public Fragment mo3384c(ClassLoader classLoader, String str) {
                    return FragmentManagerImpl.this.f3457n.m3355a(FragmentManagerImpl.this.f3457n.m3386j(), str, (Bundle) null);
                }
            });
        }
        return super.mo3399f();
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3393a(FragmentManager.PlatformImplementations.kt_3 aVar, boolean z) {
        this.f3444H.add(new IntrinsicsJvm.kt_3(aVar, z));
    }

    @Override // androidx.fragment.app.FragmentManager
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3392a(FragmentManager.PlatformImplementations.kt_3 aVar) {
        synchronized (this.f3444H) {
            int OplusGLSurfaceView_13 = 0;
            int size = this.f3444H.size();
            while (true) {
                if (OplusGLSurfaceView_13 >= size) {
                    break;
                }
                if (this.f3444H.get(OplusGLSurfaceView_13).f3492a == aVar) {
                    this.f3444H.remove(OplusGLSurfaceView_13);
                    break;
                }
                OplusGLSurfaceView_13++;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3454a(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3454a(fragment, context, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3402a(this, fragment, context);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m3473b(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3473b(fragment, context, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3406b(this, fragment, context);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3455a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3455a(fragment, bundle, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3403a(this, fragment, bundle);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m3474b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3474b(fragment, bundle, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3407b(this, fragment, bundle);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m3482c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3482c(fragment, bundle, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3409c(this, fragment, bundle);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3456a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3456a(fragment, view, bundle, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.mo3404a(this, fragment, view, bundle);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m3475b(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3475b(fragment, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3401a(this, fragment);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m3483c(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3483c(fragment, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3405b(this, fragment);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m3486d(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3486d(fragment, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3408c(this, fragment);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    void m3488e(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3488e(fragment, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3410d(this, fragment);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m3485d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3485d(fragment, bundle, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3411d(this, fragment, bundle);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    void m3490f(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3490f(fragment, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3412e(this, fragment);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    void m3492g(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3492g(fragment, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3413f(this, fragment);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    void m3495h(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f3459p;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m3495h(fragment, true);
            }
        }
        Iterator<IntrinsicsJvm.kt_3> it = this.f3444H.iterator();
        while (it.hasNext()) {
            IntrinsicsJvm.kt_3 next = it.next();
            if (!z || next.f3493b) {
                next.f3492a.m3414g(this, fragment);
            }
        }
    }

    /* renamed from: B */
    boolean m3443B() {
        boolean zM3441w = false;
        for (Fragment fragment : this.f3450g.values()) {
            if (fragment != null) {
                zM3441w = m3441w(fragment);
            }
            if (zM3441w) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: w */
    private boolean m3441w(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.m3443B();
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, IntrinsicsJvm.kt_5.f3494a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (str2 == null || !FragmentFactory.m3381a(context.getClassLoader(), str2)) {
            return null;
        }
        int id_renamed = view != null ? view.getId() : 0;
        if (id_renamed == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id_renamed, android:tag, or have PlatformImplementations.kt_3 parent with an id_renamed for " + str2);
        }
        Fragment fragmentM3469b = resourceId != -1 ? m3469b(resourceId) : null;
        if (fragmentM3469b == null && string != null) {
            fragmentM3469b = mo3388a(string);
        }
        if (fragmentM3469b == null && id_renamed != -1) {
            fragmentM3469b = m3469b(id_renamed);
        }
        if (f3438b) {
            Log.v("FragmentManager", "onCreateView: id_renamed=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + fragmentM3469b);
        }
        if (fragmentM3469b == null) {
            Fragment fragmentMo3384c = mo3399f().mo3384c(context.getClassLoader(), str2);
            fragmentMo3384c.mFromLayout = true;
            fragmentMo3384c.mFragmentId = resourceId != 0 ? resourceId : id_renamed;
            fragmentMo3384c.mContainerId = id_renamed;
            fragmentMo3384c.mTag = string;
            fragmentMo3384c.mInLayout = true;
            fragmentMo3384c.mFragmentManager = this;
            FragmentHostCallback abstractC0585g = this.f3457n;
            fragmentMo3384c.mHost = abstractC0585g;
            fragmentMo3384c.onInflate(abstractC0585g.m3386j(), attributeSet, fragmentMo3384c.mSavedFragmentState);
            m3458a(fragmentMo3384c, true);
            fragment = fragmentMo3384c;
        } else {
            if (fragmentM3469b.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id_renamed 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id_renamed 0x" + Integer.toHexString(id_renamed) + " with another fragment for " + str2);
            }
            fragmentM3469b.mInLayout = true;
            FragmentHostCallback abstractC0585g2 = this.f3457n;
            fragmentM3469b.mHost = abstractC0585g2;
            fragmentM3469b.onInflate(abstractC0585g2.m3386j(), attributeSet, fragmentM3469b.mSavedFragmentState);
            fragment = fragmentM3469b;
        }
        if (this.f3456m < 1 && fragment.mFromLayout) {
            m3453a(fragment, 1, 0, 0, false);
        } else {
            m3491g(fragment);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + str2 + " did not create PlatformImplementations.kt_3 view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string);
        }
        return fragment.mView;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* compiled from: FragmentManagerImpl.java */
    /* renamed from: androidx.fragment.app.OplusGLSurfaceView_13$COUIBaseListPopupWindow_12 */
    private class COUIBaseListPopupWindow_12 implements COUIBaseListPopupWindow_8 {

        /* renamed from: PlatformImplementations.kt_3 */
        final String f3495a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final int f3496b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final int f3497c;

        COUIBaseListPopupWindow_12(String str, int OplusGLSurfaceView_13, int i2) {
            this.f3495a = str;
            this.f3496b = OplusGLSurfaceView_13;
            this.f3497c = i2;
        }

        @Override // androidx.fragment.app.FragmentManagerImpl.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo3318a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            if (FragmentManagerImpl.this.f3460q == null || this.f3496b >= 0 || this.f3495a != null || !FragmentManagerImpl.this.f3460q.getChildFragmentManager().mo3396c()) {
                return FragmentManagerImpl.this.m3468a(arrayList, arrayList2, this.f3495a, this.f3496b, this.f3497c);
            }
            return false;
        }
    }

    /* compiled from: FragmentManagerImpl.java */
    /* renamed from: androidx.fragment.app.OplusGLSurfaceView_13$COUIBaseListPopupWindow_11 */
    static class COUIBaseListPopupWindow_11 implements Fragment.InterfaceC0574c {

        /* renamed from: PlatformImplementations.kt_3 */
        final boolean f3499a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final BackStackRecord f3500b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f3501c;

        COUIBaseListPopupWindow_11(BackStackRecord c0579a, boolean z) {
            this.f3499a = z;
            this.f3500b = c0579a;
        }

        @Override // androidx.fragment.app.Fragment.InterfaceC0574c
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo3296a() {
            this.f3501c--;
            if (this.f3501c != 0) {
                return;
            }
            this.f3500b.f3412a.m3500k();
        }

        @Override // androidx.fragment.app.Fragment.InterfaceC0574c
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo3297b() {
            this.f3501c++;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean m3526c() {
            return this.f3501c == 0;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m3527d() throws Resources.NotFoundException {
            boolean z = this.f3501c > 0;
            FragmentManagerImpl layoutInflaterFactory2C0587i = this.f3500b.f3412a;
            int size = layoutInflaterFactory2C0587i.f3449f.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                Fragment fragment = layoutInflaterFactory2C0587i.f3449f.get(OplusGLSurfaceView_13);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            this.f3500b.f3412a.m3459a(this.f3500b, this.f3499a, !z, true);
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public void m3528e() throws Resources.NotFoundException {
            this.f3500b.f3412a.m3459a(this.f3500b, this.f3499a, false, false);
        }
    }

    /* compiled from: FragmentManagerImpl.java */
    /* renamed from: androidx.fragment.app.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final Animation f3485a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final Animator f3486b;

        PlatformImplementations.kt_3(Animation animation) {
            this.f3485a = animation;
            this.f3486b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        PlatformImplementations.kt_3(Animator animator) {
            this.f3485a = null;
            this.f3486b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentManagerImpl.java */
    /* renamed from: androidx.fragment.app.OplusGLSurfaceView_13$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 extends AnimationSet implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        private final ViewGroup f3487a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final View f3488b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f3489c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f3490d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f3491e;

        IntrinsicsJvm.kt_4(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f3491e = true;
            this.f3487a = viewGroup;
            this.f3488b = view;
            addAnimation(animation);
            this.f3487a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long OplusGLSurfaceView_15, Transformation transformation) {
            this.f3491e = true;
            if (this.f3489c) {
                return !this.f3490d;
            }
            if (!super.getTransformation(OplusGLSurfaceView_15, transformation)) {
                this.f3489c = true;
                OneShotPreDrawListener.m2819a(this.f3487a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long OplusGLSurfaceView_15, Transformation transformation, float COUIBaseListPopupWindow_12) {
            this.f3491e = true;
            if (this.f3489c) {
                return !this.f3490d;
            }
            if (!super.getTransformation(OplusGLSurfaceView_15, transformation, COUIBaseListPopupWindow_12)) {
                this.f3489c = true;
                OneShotPreDrawListener.m2819a(this.f3487a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f3489c && this.f3491e) {
                this.f3491e = false;
                this.f3487a.post(this);
            } else {
                this.f3487a.endViewTransition(this.f3488b);
                this.f3490d = true;
            }
        }
    }
}
