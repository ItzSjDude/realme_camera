package androidx.savedstate;

@android.annotation.SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
final class Recreator implements androidx.lifecycle.d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.savedstate.c_renamed f1646a;

    Recreator(androidx.savedstate.c_renamed cVar) {
        this.f1646a = cVar;
    }

    @Override // androidx.lifecycle.f_renamed
    public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        if (aVar != androidx.lifecycle.e_renamed.a_renamed.ON_CREATE) {
            throw new java.lang.AssertionError("Next event must be_renamed ON_CREATE");
        }
        hVar.getLifecycle().b_renamed(this);
        android.os.Bundle bundleA = this.f1646a.getSavedStateRegistry().a_renamed("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        java.util.ArrayList<java.lang.String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new java.lang.IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of_renamed strings by_renamed the key \"classes_to_restore\"");
        }
        java.util.Iterator<java.lang.String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            a_renamed(it.next());
        }
    }

    private void a_renamed(java.lang.String str) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        try {
            java.lang.Class<? extends U_renamed> clsAsSubclass = java.lang.Class.forName(str, false, androidx.savedstate.Recreator.class.getClassLoader()).asSubclass(androidx.savedstate.a_renamed.SavedStateRegistry_2.class);
            try {
                java.lang.reflect.Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new java.lang.Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((androidx.savedstate.a_renamed.SavedStateRegistry_2) declaredConstructor.newInstance(new java.lang.Object[0])).a_renamed(this.f1646a);
                } catch (java.lang.Exception e_renamed) {
                    throw new java.lang.RuntimeException("Failed to instantiate " + str, e_renamed);
                }
            } catch (java.lang.NoSuchMethodException e2) {
                throw new java.lang.IllegalStateException("Class" + clsAsSubclass.getSimpleName() + " must have default constructor in_renamed order to be_renamed automatically recreated", e2);
            }
        } catch (java.lang.ClassNotFoundException e3) {
            throw new java.lang.RuntimeException("Class " + str + " wasn't_renamed found", e3);
        }
    }
}
