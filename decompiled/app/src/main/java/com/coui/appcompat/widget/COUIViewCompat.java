package com.coui.appcompat.widget;

/* compiled from: COUIViewCompat.java */
/* loaded from: classes.dex */
public class t_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final com.coui.appcompat.widget.t_renamed.d_renamed f3104a;

    /* compiled from: COUIViewCompat.java */
    interface d_renamed {
        int a_renamed(android.view.View view);

        void a_renamed(android.view.View view, int i_renamed);

        int b_renamed(android.view.View view);

        boolean c_renamed(android.view.View view);
    }

    /* compiled from: COUIViewCompat.java */
    static class a_renamed implements com.coui.appcompat.widget.t_renamed.d_renamed {
        @Override // com.coui.appcompat.widget.t_renamed.d_renamed
        public int a_renamed(android.view.View view) {
            return 0;
        }

        @Override // com.coui.appcompat.widget.t_renamed.d_renamed
        public void a_renamed(android.view.View view, int i_renamed) {
        }

        @Override // com.coui.appcompat.widget.t_renamed.d_renamed
        public boolean c_renamed(android.view.View view) {
            return true;
        }

        a_renamed() {
        }

        @Override // com.coui.appcompat.widget.t_renamed.d_renamed
        @android.annotation.SuppressLint({"NewApi"})
        public int b_renamed(android.view.View view) {
            return view.getLayoutDirection();
        }
    }

    /* compiled from: COUIViewCompat.java */
    static class b_renamed extends com.coui.appcompat.widget.t_renamed.a_renamed {
        @Override // com.coui.appcompat.widget.t_renamed.a_renamed, com.coui.appcompat.widget.t_renamed.d_renamed
        public boolean c_renamed(android.view.View view) {
            return true;
        }

        b_renamed() {
        }

        @Override // com.coui.appcompat.widget.t_renamed.a_renamed, com.coui.appcompat.widget.t_renamed.d_renamed
        @android.annotation.SuppressLint({"NewApi"})
        public int a_renamed(android.view.View view) {
            return view.getTextAlignment();
        }

        @Override // com.coui.appcompat.widget.t_renamed.a_renamed, com.coui.appcompat.widget.t_renamed.d_renamed
        @android.annotation.SuppressLint({"NewApi"})
        public void a_renamed(android.view.View view, int i_renamed) {
            view.setTextAlignment(i_renamed);
        }
    }

    /* compiled from: COUIViewCompat.java */
    static class c_renamed extends com.coui.appcompat.widget.t_renamed.b_renamed {
        @Override // com.coui.appcompat.widget.t_renamed.a_renamed, com.coui.appcompat.widget.t_renamed.d_renamed
        public int b_renamed(android.view.View view) {
            return 2;
        }

        c_renamed() {
        }
    }

    static {
        int i_renamed = android.os.Build.VERSION.SDK_INT;
        if (i_renamed >= 17) {
            f3104a = new com.coui.appcompat.widget.t_renamed.c_renamed();
        } else if (i_renamed >= 16) {
            f3104a = new com.coui.appcompat.widget.t_renamed.b_renamed();
        } else {
            f3104a = new com.coui.appcompat.widget.t_renamed.a_renamed();
        }
    }

    public static int a_renamed(android.view.View view) {
        return f3104a.a_renamed(view);
    }

    public static void a_renamed(android.view.View view, int i_renamed) {
        f3104a.a_renamed(view, i_renamed);
    }

    public static int b_renamed(android.view.View view) {
        return f3104a.b_renamed(view);
    }

    public static boolean c_renamed(android.view.View view) {
        return f3104a.c_renamed(view);
    }
}
