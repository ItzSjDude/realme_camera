package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* compiled from: NotificationCompat.java */
/* renamed from: androidx.core.app.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class NotificationCompat {

    /* compiled from: NotificationCompat.java */
    /* renamed from: androidx.core.app.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_5 */
    public static class IntrinsicsJvm.kt_5 {

        /* renamed from: A */
        String f2767A;

        /* renamed from: B */
        Bundle f2768B;

        /* renamed from: E */
        Notification f2771E;

        /* renamed from: F */
        RemoteViews f2772F;

        /* renamed from: G */
        RemoteViews f2773G;

        /* renamed from: H */
        RemoteViews f2774H;

        /* renamed from: I */
        String f2775I;

        /* renamed from: K */
        String f2777K;

        /* renamed from: L */
        long f2778L;

        /* renamed from: N */
        boolean f2780N;

        /* renamed from: O */
        IntrinsicsJvm.kt_3 f2781O;

        /* renamed from: Q */
        boolean f2783Q;

        /* renamed from: R */
        @Deprecated
        public ArrayList<String> f2784R;

        /* renamed from: PlatformImplementations.kt_3 */
        public Context f2785a;

        /* renamed from: IntrinsicsJvm.kt_5 */
        CharSequence f2788d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        CharSequence f2789e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        PendingIntent f2790f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        PendingIntent f2791g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        RemoteViews f2792h;

        /* renamed from: OplusGLSurfaceView_13 */
        Bitmap f2793i;

        /* renamed from: OplusGLSurfaceView_15 */
        CharSequence f2794j;

        /* renamed from: OplusGLSurfaceView_5 */
        int f2795k;

        /* renamed from: OplusGLSurfaceView_14 */
        int f2796l;

        /* renamed from: OplusGLSurfaceView_11 */
        boolean f2798n;

        /* renamed from: o */
        COUIBaseListPopupWindow_8 f2799o;

        /* renamed from: p */
        CharSequence f2800p;

        /* renamed from: q */
        CharSequence[] f2801q;

        /* renamed from: r */
        int f2802r;

        /* renamed from: s */
        int f2803s;

        /* renamed from: t */
        boolean f2804t;

        /* renamed from: u */
        String f2805u;

        /* renamed from: v */
        boolean f2806v;

        /* renamed from: w */
        String f2807w;

        /* renamed from: y */
        boolean f2809y;

        /* renamed from: z */
        boolean f2810z;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public ArrayList<PlatformImplementations.kt_3> f2786b = new ArrayList<>();

        /* renamed from: IntrinsicsJvm.kt_3 */
        ArrayList<PlatformImplementations.kt_3> f2787c = new ArrayList<>();

        /* renamed from: OplusGLSurfaceView_6 */
        boolean f2797m = true;

        /* renamed from: x */
        boolean f2808x = false;

        /* renamed from: C */
        int f2769C = 0;

        /* renamed from: D */
        int f2770D = 0;

        /* renamed from: J */
        int f2776J = 0;

        /* renamed from: M */
        int f2779M = 0;

        /* renamed from: P */
        Notification f2782P = new Notification();

        public IntrinsicsJvm.kt_5(Context context, String str) {
            this.f2785a = context;
            this.f2775I = str;
            this.f2782P.when = System.currentTimeMillis();
            this.f2782P.audioStreamType = -1;
            this.f2796l = 0;
            this.f2784R = new ArrayList<>();
            this.f2780N = true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_5 m2402a(long OplusGLSurfaceView_15) {
            this.f2782P.when = OplusGLSurfaceView_15;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_5 m2401a(int OplusGLSurfaceView_13) {
            this.f2782P.icon = OplusGLSurfaceView_13;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_5 m2405a(CharSequence charSequence) {
            this.f2789e = m2399c(charSequence);
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_5 m2403a(PendingIntent pendingIntent) {
            this.f2790f = pendingIntent;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public IntrinsicsJvm.kt_5 m2410b(CharSequence charSequence) {
            this.f2782P.tickerText = m2399c(charSequence);
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_5 m2407a(boolean z) {
            m2398a(2, z);
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public IntrinsicsJvm.kt_5 m2411b(boolean z) {
            m2398a(16, z);
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_5 m2406a(String str) {
            this.f2767A = str;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public IntrinsicsJvm.kt_5 m2409b(int OplusGLSurfaceView_13) {
            Notification notification = this.f2782P;
            notification.defaults = OplusGLSurfaceView_13;
            if ((OplusGLSurfaceView_13 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m2398a(int OplusGLSurfaceView_13, boolean z) {
            if (z) {
                Notification notification = this.f2782P;
                notification.flags = OplusGLSurfaceView_13 | notification.flags;
            } else {
                Notification notification2 = this.f2782P;
                notification2.flags = (~OplusGLSurfaceView_13) & notification2.flags;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public IntrinsicsJvm.kt_5 m2412c(int OplusGLSurfaceView_13) {
            this.f2796l = OplusGLSurfaceView_13;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public Bundle m2400a() {
            if (this.f2768B == null) {
                this.f2768B = new Bundle();
            }
            return this.f2768B;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_5 m2404a(COUIBaseListPopupWindow_8 eVar) {
            if (this.f2799o != eVar) {
                this.f2799o = eVar;
                COUIBaseListPopupWindow_8 eVar2 = this.f2799o;
                if (eVar2 != null) {
                    eVar2.m2414a(this);
                }
            }
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public Notification m2408b() {
            return new NotificationCompatBuilder(this).m2420b();
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        protected static CharSequence m2399c(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: androidx.core.app.COUIBaseListPopupWindow_10$COUIBaseListPopupWindow_8 */
    public static abstract class COUIBaseListPopupWindow_8 {

        /* renamed from: PlatformImplementations.kt_3 */
        protected IntrinsicsJvm.kt_5 f2811a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        CharSequence f2812b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        CharSequence f2813c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean f2814d = false;

        /* renamed from: PlatformImplementations.kt_3 */
        public void m2413a(Bundle bundle) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void mo2389a(NotificationBuilderWithBuilderAccessor interfaceC0433g) {
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public RemoteViews m2415b(NotificationBuilderWithBuilderAccessor interfaceC0433g) {
            return null;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public RemoteViews m2416c(NotificationBuilderWithBuilderAccessor interfaceC0433g) {
            return null;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public RemoteViews m2417d(NotificationBuilderWithBuilderAccessor interfaceC0433g) {
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m2414a(IntrinsicsJvm.kt_5 dVar) {
            if (this.f2811a != dVar) {
                this.f2811a = dVar;
                IntrinsicsJvm.kt_5 dVar2 = this.f2811a;
                if (dVar2 != null) {
                    dVar2.m2404a(this);
                }
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: androidx.core.app.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 extends COUIBaseListPopupWindow_8 {

        /* renamed from: COUIBaseListPopupWindow_8 */
        private CharSequence f2760e;

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_4 m2388a(CharSequence charSequence) {
            this.f2812b = IntrinsicsJvm.kt_5.m2399c(charSequence);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.COUIBaseListPopupWindow_8
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo2389a(NotificationBuilderWithBuilderAccessor interfaceC0433g) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(interfaceC0433g.mo2376a()).setBigContentTitle(this.f2812b).bigText(this.f2760e);
                if (this.f2814d) {
                    bigTextStyleBigText.setSummaryText(this.f2813c);
                }
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: androidx.core.app.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final Bundle f2749a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean f2750b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        @Deprecated
        public int f2751c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public CharSequence f2752d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public PendingIntent f2753e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private IconCompat f2754f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private final RemoteInput[] f2755g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private final RemoteInput[] f2756h;

        /* renamed from: OplusGLSurfaceView_13 */
        private boolean f2757i;

        /* renamed from: OplusGLSurfaceView_15 */
        private final int f2758j;

        /* renamed from: OplusGLSurfaceView_5 */
        private final boolean f2759k;

        /* renamed from: PlatformImplementations.kt_3 */
        public IconCompat m2378a() {
            int OplusGLSurfaceView_13;
            if (this.f2754f == null && (OplusGLSurfaceView_13 = this.f2751c) != 0) {
                this.f2754f = IconCompat.m2553a(null, "", OplusGLSurfaceView_13);
            }
            return this.f2754f;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public CharSequence m2379b() {
            return this.f2752d;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public PendingIntent m2380c() {
            return this.f2753e;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public Bundle m2381d() {
            return this.f2749a;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public boolean m2382e() {
            return this.f2757i;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public RemoteInput[] m2383f() {
            return this.f2755g;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int m2384g() {
            return this.f2758j;
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean m2385h() {
            return this.f2759k;
        }

        /* renamed from: OplusGLSurfaceView_13 */
        public RemoteInput[] m2386i() {
            return this.f2756h;
        }

        /* renamed from: OplusGLSurfaceView_15 */
        public boolean m2387j() {
            return this.f2750b;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: androidx.core.app.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_3 */
    public static final class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private PendingIntent f2761a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private PendingIntent f2762b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private IconCompat f2763c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f2764d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f2765e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f2766f;

        /* renamed from: PlatformImplementations.kt_3 */
        public PendingIntent m2391a() {
            return this.f2761a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public PendingIntent m2392b() {
            return this.f2762b;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public IconCompat m2393c() {
            return this.f2763c;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int m2394d() {
            return this.f2764d;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int m2395e() {
            return this.f2765e;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public boolean m2396f() {
            return (this.f2766f & 1) != 0;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public boolean m2397g() {
            return (this.f2766f & 2) != 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static Notification.BubbleMetadata m2390a(IntrinsicsJvm.kt_3 cVar) {
            if (cVar == null) {
                return null;
            }
            Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(cVar.m2396f()).setDeleteIntent(cVar.m2392b()).setIcon(cVar.m2393c().m2564d()).setIntent(cVar.m2391a()).setSuppressNotification(cVar.m2397g());
            if (cVar.m2394d() != 0) {
                suppressNotification.setDesiredHeight(cVar.m2394d());
            }
            if (cVar.m2395e() != 0) {
                suppressNotification.setDesiredHeightResId(cVar.m2395e());
            }
            return suppressNotification.build();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bundle m2377a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return NotificationCompatJellybean.m2423a(notification);
        }
        return null;
    }
}
