package androidx.core.h_renamed.a_renamed;

/* compiled from: AccessibilityNodeProviderCompat.java */
/* loaded from: classes.dex */
public class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f968a;

    public androidx.core.h_renamed.a_renamed.d_renamed a_renamed(int i_renamed) {
        return null;
    }

    public java.util.List<androidx.core.h_renamed.a_renamed.d_renamed> a_renamed(java.lang.String str, int i_renamed) {
        return null;
    }

    public boolean a_renamed(int i_renamed, int i2, android.os.Bundle bundle) {
        return false;
    }

    public androidx.core.h_renamed.a_renamed.d_renamed b_renamed(int i_renamed) {
        return null;
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    static class a_renamed extends android.view.accessibility.AccessibilityNodeProvider {

        /* renamed from: a_renamed, reason: collision with root package name */
        final androidx.core.h_renamed.a_renamed.e_renamed f969a;

        a_renamed(androidx.core.h_renamed.a_renamed.e_renamed eVar) {
            this.f969a = eVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int i_renamed) {
            androidx.core.h_renamed.a_renamed.d_renamed dVarA = this.f969a.a_renamed(i_renamed);
            if (dVarA == null) {
                return null;
            }
            return dVarA.a_renamed();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public java.util.List<android.view.accessibility.AccessibilityNodeInfo> findAccessibilityNodeInfosByText(java.lang.String str, int i_renamed) {
            java.util.List<androidx.core.h_renamed.a_renamed.d_renamed> listA = this.f969a.a_renamed(str, i_renamed);
            if (listA == null) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int size = listA.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(listA.get(i2).a_renamed());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i_renamed, int i2, android.os.Bundle bundle) {
            return this.f969a.a_renamed(i_renamed, i2, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    static class b_renamed extends androidx.core.h_renamed.a_renamed.e_renamed.a_renamed {
        b_renamed(androidx.core.h_renamed.a_renamed.e_renamed eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public android.view.accessibility.AccessibilityNodeInfo findFocus(int i_renamed) {
            androidx.core.h_renamed.a_renamed.d_renamed dVarB = this.f969a.b_renamed(i_renamed);
            if (dVarB == null) {
                return null;
            }
            return dVarB.a_renamed();
        }
    }

    public e_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            this.f968a = new androidx.core.h_renamed.a_renamed.e_renamed.b_renamed(this);
        } else if (android.os.Build.VERSION.SDK_INT >= 16) {
            this.f968a = new androidx.core.h_renamed.a_renamed.e_renamed.a_renamed(this);
        } else {
            this.f968a = null;
        }
    }

    public e_renamed(java.lang.Object obj) {
        this.f968a = obj;
    }

    public java.lang.Object a_renamed() {
        return this.f968a;
    }
}
