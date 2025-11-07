package androidx.core.app;

/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public class h_renamed {

    /* compiled from: NotificationCompat.java */
    public static class d_renamed {
        java.lang.String A_renamed;
        android.os.Bundle B_renamed;
        android.app.Notification E_renamed;
        android.widget.RemoteViews F_renamed;
        android.widget.RemoteViews G_renamed;
        android.widget.RemoteViews H_renamed;
        java.lang.String I_renamed;
        java.lang.String K_renamed;
        long L_renamed;
        boolean N_renamed;
        androidx.core.app.h_renamed.c_renamed O_renamed;
        boolean Q_renamed;

        @java.lang.Deprecated
        public java.util.ArrayList<java.lang.String> R_renamed;

        /* renamed from: a_renamed, reason: collision with root package name */
        public android.content.Context f835a;
        java.lang.CharSequence d_renamed;
        java.lang.CharSequence e_renamed;
        android.app.PendingIntent f_renamed;
        android.app.PendingIntent g_renamed;
        android.widget.RemoteViews h_renamed;
        android.graphics.Bitmap i_renamed;
        java.lang.CharSequence j_renamed;
        int k_renamed;
        int l_renamed;
        boolean n_renamed;
        androidx.core.app.h_renamed.e_renamed o_renamed;
        java.lang.CharSequence p_renamed;
        java.lang.CharSequence[] q_renamed;
        int r_renamed;
        int s_renamed;
        boolean t_renamed;
        java.lang.String u_renamed;
        boolean v_renamed;
        java.lang.String w_renamed;
        boolean y_renamed;
        boolean z_renamed;

        /* renamed from: b_renamed, reason: collision with root package name */
        public java.util.ArrayList<androidx.core.app.h_renamed.a_renamed> f836b = new java.util.ArrayList<>();

        /* renamed from: c_renamed, reason: collision with root package name */
        java.util.ArrayList<androidx.core.app.h_renamed.a_renamed> f837c = new java.util.ArrayList<>();
        boolean m_renamed = true;
        boolean x_renamed = false;
        int C_renamed = 0;
        int D_renamed = 0;
        int J_renamed = 0;
        int M_renamed = 0;
        android.app.Notification P_renamed = new android.app.Notification();

        public d_renamed(android.content.Context context, java.lang.String str) {
            this.f835a = context;
            this.I_renamed = str;
            this.P_renamed.when = java.lang.System.currentTimeMillis();
            this.P_renamed.audioStreamType = -1;
            this.l_renamed = 0;
            this.R_renamed = new java.util.ArrayList<>();
            this.N_renamed = true;
        }

        public androidx.core.app.h_renamed.d_renamed a_renamed(long j_renamed) {
            this.P_renamed.when = j_renamed;
            return this;
        }

        public androidx.core.app.h_renamed.d_renamed a_renamed(int i_renamed) {
            this.P_renamed.icon = i_renamed;
            return this;
        }

        public androidx.core.app.h_renamed.d_renamed a_renamed(java.lang.CharSequence charSequence) {
            this.e_renamed = c_renamed(charSequence);
            return this;
        }

        public androidx.core.app.h_renamed.d_renamed a_renamed(android.app.PendingIntent pendingIntent) {
            this.f_renamed = pendingIntent;
            return this;
        }

        public androidx.core.app.h_renamed.d_renamed b_renamed(java.lang.CharSequence charSequence) {
            this.P_renamed.tickerText = c_renamed(charSequence);
            return this;
        }

        public androidx.core.app.h_renamed.d_renamed a_renamed(boolean z_renamed) {
            a_renamed(2, z_renamed);
            return this;
        }

        public androidx.core.app.h_renamed.d_renamed b_renamed(boolean z_renamed) {
            a_renamed(16, z_renamed);
            return this;
        }

        public androidx.core.app.h_renamed.d_renamed a_renamed(java.lang.String str) {
            this.A_renamed = str;
            return this;
        }

        public androidx.core.app.h_renamed.d_renamed b_renamed(int i_renamed) {
            android.app.Notification notification = this.P_renamed;
            notification.defaults = i_renamed;
            if ((i_renamed & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        private void a_renamed(int i_renamed, boolean z_renamed) {
            if (z_renamed) {
                android.app.Notification notification = this.P_renamed;
                notification.flags = i_renamed | notification.flags;
            } else {
                android.app.Notification notification2 = this.P_renamed;
                notification2.flags = (~i_renamed) & notification2.flags;
            }
        }

        public androidx.core.app.h_renamed.d_renamed c_renamed(int i_renamed) {
            this.l_renamed = i_renamed;
            return this;
        }

        public android.os.Bundle a_renamed() {
            if (this.B_renamed == null) {
                this.B_renamed = new android.os.Bundle();
            }
            return this.B_renamed;
        }

        public androidx.core.app.h_renamed.d_renamed a_renamed(androidx.core.app.h_renamed.e_renamed eVar) {
            if (this.o_renamed != eVar) {
                this.o_renamed = eVar;
                androidx.core.app.h_renamed.e_renamed eVar2 = this.o_renamed;
                if (eVar2 != null) {
                    eVar2.a_renamed(this);
                }
            }
            return this;
        }

        public android.app.Notification b_renamed() {
            return new androidx.core.app.i_renamed(this).b_renamed();
        }

        protected static java.lang.CharSequence c_renamed(java.lang.CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }
    }

    /* compiled from: NotificationCompat.java */
    public static abstract class e_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        protected androidx.core.app.h_renamed.d_renamed f838a;

        /* renamed from: b_renamed, reason: collision with root package name */
        java.lang.CharSequence f839b;

        /* renamed from: c_renamed, reason: collision with root package name */
        java.lang.CharSequence f840c;
        boolean d_renamed = false;

        public void a_renamed(android.os.Bundle bundle) {
        }

        public void a_renamed(androidx.core.app.g_renamed gVar) {
        }

        public android.widget.RemoteViews b_renamed(androidx.core.app.g_renamed gVar) {
            return null;
        }

        public android.widget.RemoteViews c_renamed(androidx.core.app.g_renamed gVar) {
            return null;
        }

        public android.widget.RemoteViews d_renamed(androidx.core.app.g_renamed gVar) {
            return null;
        }

        public void a_renamed(androidx.core.app.h_renamed.d_renamed dVar) {
            if (this.f838a != dVar) {
                this.f838a = dVar;
                androidx.core.app.h_renamed.d_renamed dVar2 = this.f838a;
                if (dVar2 != null) {
                    dVar2.a_renamed(this);
                }
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    public static class b_renamed extends androidx.core.app.h_renamed.e_renamed {
        private java.lang.CharSequence e_renamed;

        public androidx.core.app.h_renamed.b_renamed a_renamed(java.lang.CharSequence charSequence) {
            this.f839b = androidx.core.app.h_renamed.d_renamed.c_renamed(charSequence);
            return this;
        }

        @Override // androidx.core.app.h_renamed.e_renamed
        public void a_renamed(androidx.core.app.g_renamed gVar) {
            if (android.os.Build.VERSION.SDK_INT >= 16) {
                android.app.Notification.BigTextStyle bigTextStyleBigText = new android.app.Notification.BigTextStyle(gVar.a_renamed()).setBigContentTitle(this.f839b).bigText(this.e_renamed);
                if (this.d_renamed) {
                    bigTextStyleBigText.setSummaryText(this.f840c);
                }
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.os.Bundle f829a;

        /* renamed from: b_renamed, reason: collision with root package name */
        boolean f830b;

        /* renamed from: c_renamed, reason: collision with root package name */
        @java.lang.Deprecated
        public int f831c;
        public java.lang.CharSequence d_renamed;
        public android.app.PendingIntent e_renamed;
        private androidx.core.graphics.drawable.IconCompat f_renamed;
        private final androidx.core.app.k_renamed[] g_renamed;
        private final androidx.core.app.k_renamed[] h_renamed;
        private boolean i_renamed;
        private final int j_renamed;
        private final boolean k_renamed;

        public androidx.core.graphics.drawable.IconCompat a_renamed() {
            int i_renamed;
            if (this.f_renamed == null && (i_renamed = this.f831c) != 0) {
                this.f_renamed = androidx.core.graphics.drawable.IconCompat.a_renamed(null, "", i_renamed);
            }
            return this.f_renamed;
        }

        public java.lang.CharSequence b_renamed() {
            return this.d_renamed;
        }

        public android.app.PendingIntent c_renamed() {
            return this.e_renamed;
        }

        public android.os.Bundle d_renamed() {
            return this.f829a;
        }

        public boolean e_renamed() {
            return this.i_renamed;
        }

        public androidx.core.app.k_renamed[] f_renamed() {
            return this.g_renamed;
        }

        public int g_renamed() {
            return this.j_renamed;
        }

        public boolean h_renamed() {
            return this.k_renamed;
        }

        public androidx.core.app.k_renamed[] i_renamed() {
            return this.h_renamed;
        }

        public boolean j_renamed() {
            return this.f830b;
        }
    }

    /* compiled from: NotificationCompat.java */
    public static final class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private android.app.PendingIntent f832a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private android.app.PendingIntent f833b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private androidx.core.graphics.drawable.IconCompat f834c;
        private int d_renamed;
        private int e_renamed;
        private int f_renamed;

        public android.app.PendingIntent a_renamed() {
            return this.f832a;
        }

        public android.app.PendingIntent b_renamed() {
            return this.f833b;
        }

        public androidx.core.graphics.drawable.IconCompat c_renamed() {
            return this.f834c;
        }

        public int d_renamed() {
            return this.d_renamed;
        }

        public int e_renamed() {
            return this.e_renamed;
        }

        public boolean f_renamed() {
            return (this.f_renamed & 1) != 0;
        }

        public boolean g_renamed() {
            return (this.f_renamed & 2) != 0;
        }

        public static android.app.Notification.BubbleMetadata a_renamed(androidx.core.app.h_renamed.c_renamed cVar) {
            if (cVar == null) {
                return null;
            }
            android.app.Notification.BubbleMetadata.Builder suppressNotification = new android.app.Notification.BubbleMetadata.Builder().setAutoExpandBubble(cVar.f_renamed()).setDeleteIntent(cVar.b_renamed()).setIcon(cVar.c_renamed().d_renamed()).setIntent(cVar.a_renamed()).setSuppressNotification(cVar.g_renamed());
            if (cVar.d_renamed() != 0) {
                suppressNotification.setDesiredHeight(cVar.d_renamed());
            }
            if (cVar.e_renamed() != 0) {
                suppressNotification.setDesiredHeightResId(cVar.e_renamed());
            }
            return suppressNotification.build();
        }
    }

    public static android.os.Bundle a_renamed(android.app.Notification notification) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            return androidx.core.app.j_renamed.a_renamed(notification);
        }
        return null;
    }
}
