package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: PlatformImplementations.kt_3 */
    final ArrayDeque<OnBackPressedCallback> f721a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Runnable f722b;

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f721a = new ArrayDeque<>();
        this.f722b = runnable;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    Cancellable m716a(OnBackPressedCallback abstractC0175c) {
        this.f721a.add(abstractC0175c);
        C0172a c0172a = new C0172a(abstractC0175c);
        abstractC0175c.m723a(c0172a);
        return c0172a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m718a(LifecycleOwner interfaceC0605h, OnBackPressedCallback abstractC0175c) {
        Lifecycle lifecycle = interfaceC0605h.getLifecycle();
        if (lifecycle.mo3638a() == Lifecycle.IntrinsicsJvm.kt_4.DESTROYED) {
            return;
        }
        abstractC0175c.m723a(new LifecycleOnBackPressedCancellable(lifecycle, abstractC0175c));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m717a() {
        Iterator<OnBackPressedCallback> itDescendingIterator = this.f721a.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            OnBackPressedCallback next = itDescendingIterator.next();
            if (next.m725a()) {
                next.mo728c();
                return;
            }
        }
        Runnable runnable = this.f722b;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: androidx.activity.OnBackPressedDispatcher$PlatformImplementations.kt_3 */
    private class C0172a implements Cancellable {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final OnBackPressedCallback f728b;

        C0172a(OnBackPressedCallback abstractC0175c) {
            this.f728b = abstractC0175c;
        }

        @Override // androidx.activity.Cancellable
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo719a() {
            OnBackPressedDispatcher.this.f721a.remove(this.f728b);
            this.f728b.m727b(this);
        }
    }

    private class LifecycleOnBackPressedCancellable implements Cancellable, LifecycleEventObserver {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Lifecycle f724b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final OnBackPressedCallback f725c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private Cancellable f726d;

        LifecycleOnBackPressedCancellable(Lifecycle abstractC0602e, OnBackPressedCallback abstractC0175c) {
            this.f724b = abstractC0602e;
            this.f725c = abstractC0175c;
            abstractC0602e.mo3639a(this);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
            if (aVar == Lifecycle.PlatformImplementations.kt_3.ON_START) {
                this.f726d = OnBackPressedDispatcher.this.m716a(this.f725c);
                return;
            }
            if (aVar == Lifecycle.PlatformImplementations.kt_3.ON_STOP) {
                Cancellable interfaceC0173a = this.f726d;
                if (interfaceC0173a != null) {
                    interfaceC0173a.mo719a();
                    return;
                }
                return;
            }
            if (aVar == Lifecycle.PlatformImplementations.kt_3.ON_DESTROY) {
                mo719a();
            }
        }

        @Override // androidx.activity.Cancellable
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo719a() {
            this.f724b.mo3640b(this);
            this.f725c.m727b(this);
            Cancellable interfaceC0173a = this.f726d;
            if (interfaceC0173a != null) {
                interfaceC0173a.mo719a();
                this.f726d = null;
            }
        }
    }
}
