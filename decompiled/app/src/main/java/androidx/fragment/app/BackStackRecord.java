package androidx.fragment.app;

import android.util.Log;
import androidx.core.p035g.LogWriter;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: BackStackRecord.java */
/* renamed from: androidx.fragment.app.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
final class BackStackRecord extends FragmentTransaction implements FragmentManagerImpl.COUIBaseListPopupWindow_8 {

    /* renamed from: PlatformImplementations.kt_3 */
    final FragmentManagerImpl f3412a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean f3413b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f3414c = -1;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3414c >= 0) {
            sb.append(" #");
            sb.append(this.f3414c);
        }
        if (this.f3518m != null) {
            sb.append(" ");
            sb.append(this.f3518m);
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3315a(String str, PrintWriter printWriter) {
        m3316a(str, printWriter, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3316a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3518m);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3414c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3413b);
            if (this.f3514i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3514i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f3515j));
            }
            if (this.f3510e != 0 || this.f3511f != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3510e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3511f));
            }
            if (this.f3512g != 0 || this.f3513h != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3512g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3513h));
            }
            if (this.f3519n != 0 || this.f3520o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3519n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3520o);
            }
            if (this.f3521p != 0 || this.f3522q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3521p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3522q);
            }
        }
        if (this.f3509d.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f3509d.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            FragmentTransaction.PlatformImplementations.kt_3 aVar = this.f3509d.get(OplusGLSurfaceView_13);
            switch (aVar.f3527a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f3527a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(OplusGLSurfaceView_13);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f3528b);
            if (z) {
                if (aVar.f3529c != 0 || aVar.f3530d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f3529c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f3530d));
                }
                if (aVar.f3531e != 0 || aVar.f3532f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f3531e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f3532f));
                }
            }
        }
    }

    public BackStackRecord(FragmentManagerImpl layoutInflaterFactory2C0587i) {
        this.f3412a = layoutInflaterFactory2C0587i;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    /* renamed from: PlatformImplementations.kt_3 */
    void mo3313a(int OplusGLSurfaceView_13, Fragment fragment, String str, int i2) {
        super.mo3313a(OplusGLSurfaceView_13, fragment, str, i2);
        fragment.mFragmentManager = this.f3412a;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    /* renamed from: PlatformImplementations.kt_3 */
    public FragmentTransaction mo3309a(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.f3412a) {
            throw new IllegalStateException("Cannot remove Fragment attached to PlatformImplementations.kt_3 different FragmentManager. Fragment " + fragment.toString() + " is already attached to PlatformImplementations.kt_3 FragmentManager.");
        }
        return super.mo3309a(fragment);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    /* renamed from: IntrinsicsJvm.kt_4 */
    public FragmentTransaction mo3321b(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.f3412a) {
            throw new IllegalStateException("Cannot detach Fragment attached to PlatformImplementations.kt_3 different FragmentManager. Fragment " + fragment.toString() + " is already attached to PlatformImplementations.kt_3 FragmentManager.");
        }
        return super.mo3321b(fragment);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    /* renamed from: PlatformImplementations.kt_3 */
    public FragmentTransaction mo3310a(Fragment fragment, Lifecycle.IntrinsicsJvm.kt_4 bVar) {
        if (fragment.mFragmentManager != this.f3412a) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f3412a);
        }
        if (!bVar.isAtLeast(Lifecycle.IntrinsicsJvm.kt_4.CREATED)) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + Lifecycle.IntrinsicsJvm.kt_4.CREATED);
        }
        return super.mo3310a(fragment, bVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3312a(int OplusGLSurfaceView_13) {
        if (this.f3516k) {
            if (FragmentManagerImpl.f3438b) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + OplusGLSurfaceView_13);
            }
            int size = this.f3509d.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.PlatformImplementations.kt_3 aVar = this.f3509d.get(i2);
                if (aVar.f3528b != null) {
                    aVar.f3528b.mBackStackNesting += OplusGLSurfaceView_13;
                    if (FragmentManagerImpl.f3438b) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f3528b + " to " + aVar.f3528b.mBackStackNesting);
                    }
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3311a() {
        if (this.f3526u != null) {
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3526u.size(); OplusGLSurfaceView_13++) {
                this.f3526u.get(OplusGLSurfaceView_13).run();
            }
            this.f3526u = null;
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo3319b() {
        return m3307a(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    /* renamed from: IntrinsicsJvm.kt_3 */
    public int mo3324c() {
        return m3307a(true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo3325d() {
        m3547i();
        this.f3412a.m3477b((FragmentManagerImpl.COUIBaseListPopupWindow_8) this, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m3307a(boolean z) {
        if (this.f3413b) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.f3438b) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
            m3315a("  ", printWriter);
            printWriter.close();
        }
        this.f3413b = true;
        if (this.f3516k) {
            this.f3414c = this.f3412a.m3445a(this);
        } else {
            this.f3414c = -1;
        }
        this.f3412a.m3461a(this, z);
        return this.f3414c;
    }

    @Override // androidx.fragment.app.FragmentManagerImpl.COUIBaseListPopupWindow_8
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo3318a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManagerImpl.f3438b) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.f3516k) {
            return true;
        }
        this.f3412a.m3476b(this);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m3323b(int OplusGLSurfaceView_13) {
        int size = this.f3509d.size();
        for (int i2 = 0; i2 < size; i2++) {
            FragmentTransaction.PlatformImplementations.kt_3 aVar = this.f3509d.get(i2);
            int i3 = aVar.f3528b != null ? aVar.f3528b.mContainerId : 0;
            if (i3 != 0 && i3 == OplusGLSurfaceView_13) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m3317a(ArrayList<BackStackRecord> arrayList, int OplusGLSurfaceView_13, int i2) {
        if (i2 == OplusGLSurfaceView_13) {
            return false;
        }
        int size = this.f3509d.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            FragmentTransaction.PlatformImplementations.kt_3 aVar = this.f3509d.get(i4);
            int i5 = aVar.f3528b != null ? aVar.f3528b.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = OplusGLSurfaceView_13; i6 < i2; i6++) {
                    BackStackRecord c0579a = arrayList.get(i6);
                    int size2 = c0579a.f3509d.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        FragmentTransaction.PlatformImplementations.kt_3 aVar2 = c0579a.f3509d.get(i7);
                        if ((aVar2.f3528b != null ? aVar2.f3528b.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    void m3326e() {
        int size = this.f3509d.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            FragmentTransaction.PlatformImplementations.kt_3 aVar = this.f3509d.get(OplusGLSurfaceView_13);
            Fragment fragment = aVar.f3528b;
            if (fragment != null) {
                fragment.setNextTransition(this.f3514i, this.f3515j);
            }
            switch (aVar.f3527a) {
                case 1:
                    fragment.setNextAnim(aVar.f3529c);
                    this.f3412a.m3458a(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3527a);
                case 3:
                    fragment.setNextAnim(aVar.f3530d);
                    this.f3412a.m3505m(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f3530d);
                    this.f3412a.m3507n(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f3529c);
                    this.f3412a.m3509o(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f3530d);
                    this.f3412a.m3511p(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f3529c);
                    this.f3412a.m3513q(fragment);
                    break;
                case 8:
                    this.f3412a.m3519t(fragment);
                    break;
                case 9:
                    this.f3412a.m3519t(null);
                    break;
                case 10:
                    this.f3412a.m3457a(fragment, aVar.f3534h);
                    break;
            }
            if (!this.f3525t && aVar.f3527a != 1 && fragment != null) {
                this.f3412a.m3499j(fragment);
            }
        }
        if (this.f3525t) {
            return;
        }
        FragmentManagerImpl layoutInflaterFactory2C0587i = this.f3412a;
        layoutInflaterFactory2C0587i.m3449a(layoutInflaterFactory2C0587i.f3456m, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m3322b(boolean z) {
        for (int size = this.f3509d.size() - 1; size >= 0; size--) {
            FragmentTransaction.PlatformImplementations.kt_3 aVar = this.f3509d.get(size);
            Fragment fragment = aVar.f3528b;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManagerImpl.m3437d(this.f3514i), this.f3515j);
            }
            switch (aVar.f3527a) {
                case 1:
                    fragment.setNextAnim(aVar.f3532f);
                    this.f3412a.m3505m(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f3527a);
                case 3:
                    fragment.setNextAnim(aVar.f3531e);
                    this.f3412a.m3458a(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f3531e);
                    this.f3412a.m3509o(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f3532f);
                    this.f3412a.m3507n(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f3531e);
                    this.f3412a.m3513q(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f3532f);
                    this.f3412a.m3511p(fragment);
                    break;
                case 8:
                    this.f3412a.m3519t(null);
                    break;
                case 9:
                    this.f3412a.m3519t(fragment);
                    break;
                case 10:
                    this.f3412a.m3457a(fragment, aVar.f3533g);
                    break;
            }
            if (!this.f3525t && aVar.f3527a != 3 && fragment != null) {
                this.f3412a.m3499j(fragment);
            }
        }
        if (this.f3525t || !z) {
            return;
        }
        FragmentManagerImpl layoutInflaterFactory2C0587i = this.f3412a;
        layoutInflaterFactory2C0587i.m3449a(layoutInflaterFactory2C0587i.f3456m, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.fragment.app.Fragment m3308a(java.util.ArrayList<androidx.fragment.app.Fragment> r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r4 = r18
            r3 = 0
        L7:
            java.util.ArrayList<androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3> r5 = r0.f3509d
            int r5 = r5.size()
            if (r3 >= r5) goto Lc0
            java.util.ArrayList<androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3> r5 = r0.f3509d
            java.lang.Object r5 = r5.get(r3)
            androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3 r5 = (androidx.fragment.app.FragmentTransaction.PlatformImplementations.kt_3) r5
            int r6 = r5.f3527a
            r7 = 0
            r8 = 1
            if (r6 == r8) goto Lb8
            r9 = 2
            r10 = 3
            r11 = 9
            if (r6 == r9) goto L5a
            if (r6 == r10) goto L41
            r9 = 6
            if (r6 == r9) goto L41
            r7 = 7
            if (r6 == r7) goto Lb8
            r7 = 8
            if (r6 == r7) goto L31
            goto Lbd
        L31:
            java.util.ArrayList<androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3> r6 = r0.f3509d
            androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3 r7 = new androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3
            r7.<init>(r11, r4)
            r6.add(r3, r7)
            int r3 = r3 + 1
            androidx.fragment.app.Fragment r4 = r5.f3528b
            goto Lbd
        L41:
            androidx.fragment.app.Fragment r6 = r5.f3528b
            r1.remove(r6)
            androidx.fragment.app.Fragment r6 = r5.f3528b
            if (r6 != r4) goto Lbd
            java.util.ArrayList<androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3> r4 = r0.f3509d
            androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3 r6 = new androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3
            androidx.fragment.app.Fragment r5 = r5.f3528b
            r6.<init>(r11, r5)
            r4.add(r3, r6)
            int r3 = r3 + 1
            r4 = r7
            goto Lbd
        L5a:
            androidx.fragment.app.Fragment r6 = r5.f3528b
            int r9 = r6.mContainerId
            int r12 = r17.size()
            int r12 = r12 - r8
            r13 = r4
            r4 = r3
            r3 = 0
        L66:
            if (r12 < 0) goto La6
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.mContainerId
            if (r15 != r9) goto La3
            if (r14 != r6) goto L76
            r3 = r8
            goto La3
        L76:
            if (r14 != r13) goto L85
            java.util.ArrayList<androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3> r13 = r0.f3509d
            androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3 r15 = new androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3
            r15.<init>(r11, r14)
            r13.add(r4, r15)
            int r4 = r4 + 1
            r13 = r7
        L85:
            androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3 r15 = new androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3
            r15.<init>(r10, r14)
            int r2 = r5.f3529c
            r15.f3529c = r2
            int r2 = r5.f3531e
            r15.f3531e = r2
            int r2 = r5.f3530d
            r15.f3530d = r2
            int r2 = r5.f3532f
            r15.f3532f = r2
            java.util.ArrayList<androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3> r2 = r0.f3509d
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r8
        La3:
            int r12 = r12 + (-1)
            goto L66
        La6:
            if (r3 == 0) goto Lb0
            java.util.ArrayList<androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3> r2 = r0.f3509d
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lb5
        Lb0:
            r5.f3527a = r8
            r1.add(r6)
        Lb5:
            r3 = r4
            r4 = r13
            goto Lbd
        Lb8:
            androidx.fragment.app.Fragment r2 = r5.f3528b
            r1.add(r2)
        Lbd:
            int r3 = r3 + r8
            goto L7
        Lc0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.BackStackRecord.m3308a(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.fragment.app.Fragment m3320b(java.util.ArrayList<androidx.fragment.app.Fragment> r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3> r0 = r5.f3509d
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList<androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3> r2 = r5.f3509d
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3 r2 = (androidx.fragment.app.FragmentTransaction.PlatformImplementations.kt_3) r2
            int r3 = r2.f3527a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 r3 = r2.f3533g
            r2.f3534h = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.f3528b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.f3528b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.f3528b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.BackStackRecord.m3320b(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean m3327f() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3509d.size(); OplusGLSurfaceView_13++) {
            if (m3306b(this.f3509d.get(OplusGLSurfaceView_13))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3314a(Fragment.InterfaceC0574c interfaceC0574c) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3509d.size(); OplusGLSurfaceView_13++) {
            FragmentTransaction.PlatformImplementations.kt_3 aVar = this.f3509d.get(OplusGLSurfaceView_13);
            if (m3306b(aVar)) {
                aVar.f3528b.setOnStartEnterTransitionListener(interfaceC0574c);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m3306b(FragmentTransaction.PlatformImplementations.kt_3 aVar) {
        Fragment fragment = aVar.f3528b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public String m3328g() {
        return this.f3518m;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo3329h() {
        return this.f3509d.isEmpty();
    }
}
