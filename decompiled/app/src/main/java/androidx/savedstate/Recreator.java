package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.InterfaceC0601d;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
final class Recreator implements InterfaceC0601d {

    /* renamed from: PlatformImplementations.kt_3 */
    private final SavedStateRegistryOwner f4483a;

    Recreator(SavedStateRegistryOwner interfaceC0760c) {
        this.f4483a = interfaceC0760c;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) throws NoSuchMethodException, SecurityException {
        if (aVar != Lifecycle.PlatformImplementations.kt_3.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        interfaceC0605h.getLifecycle().mo3640b(this);
        Bundle bundleM4686a = this.f4483a.getSavedStateRegistry().m4686a("androidx.savedstate.Restarter");
        if (bundleM4686a == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleM4686a.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            m4685a(it.next());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4685a(String str) throws NoSuchMethodException, SecurityException {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.PlatformImplementations.kt_3.class);
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((SavedStateRegistry.PlatformImplementations.kt_3) declaredConstructor.newInstance(new Object[0])).m4689a(this.f4483a);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    throw new RuntimeException("Failed to instantiate " + str, COUIBaseListPopupWindow_8);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class" + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + str + " wasn't found", e3);
        }
    }
}
