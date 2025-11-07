package com.coui.appcompat.widget;

/* compiled from: COUIViewTreeObserverCompat.java */
/* loaded from: classes.dex */
public class u_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final com.coui.appcompat.widget.u_renamed.c_renamed f3119a;

    /* compiled from: COUIViewTreeObserverCompat.java */
    interface c_renamed {
        void a_renamed(android.view.ViewTreeObserver viewTreeObserver, android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener);
    }

    /* compiled from: COUIViewTreeObserverCompat.java */
    static class a_renamed implements com.coui.appcompat.widget.u_renamed.c_renamed {
        a_renamed() {
        }

        @Override // com.coui.appcompat.widget.u_renamed.c_renamed
        public void a_renamed(android.view.ViewTreeObserver viewTreeObserver, android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    /* compiled from: COUIViewTreeObserverCompat.java */
    static class b_renamed extends com.coui.appcompat.widget.u_renamed.a_renamed {
        b_renamed() {
        }

        @Override // com.coui.appcompat.widget.u_renamed.a_renamed, com.coui.appcompat.widget.u_renamed.c_renamed
        public void a_renamed(android.view.ViewTreeObserver viewTreeObserver, android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            f3119a = new com.coui.appcompat.widget.u_renamed.b_renamed();
        } else {
            f3119a = new com.coui.appcompat.widget.u_renamed.a_renamed();
        }
    }

    public static void a_renamed(android.view.ViewTreeObserver viewTreeObserver, android.view.ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        f3119a.a_renamed(viewTreeObserver, onGlobalLayoutListener);
    }
}
