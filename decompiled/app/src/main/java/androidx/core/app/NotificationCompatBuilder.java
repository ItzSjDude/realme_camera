package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatBuilder.java */
/* renamed from: androidx.core.app.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Notification.Builder f2815a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final NotificationCompat.IntrinsicsJvm.kt_5 f2816b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RemoteViews f2817c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RemoteViews f2818d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final List<Bundle> f2819e = new ArrayList();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Bundle f2820f = new Bundle();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f2821g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private RemoteViews f2822h;

    NotificationCompatBuilder(NotificationCompat.IntrinsicsJvm.kt_5 dVar) {
        this.f2816b = dVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2815a = new Notification.Builder(dVar.f2785a, dVar.f2775I);
        } else {
            this.f2815a = new Notification.Builder(dVar.f2785a);
        }
        Notification notification = dVar.f2782P;
        this.f2815a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f2792h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f2788d).setContentText(dVar.f2789e).setContentInfo(dVar.f2794j).setContentIntent(dVar.f2790f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f2791g, (notification.flags & 128) != 0).setLargeIcon(dVar.f2793i).setNumber(dVar.f2795k).setProgress(dVar.f2802r, dVar.f2803s, dVar.f2804t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f2815a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2815a.setSubText(dVar.f2800p).setUsesChronometer(dVar.f2798n).setPriority(dVar.f2796l);
            Iterator<NotificationCompat.PlatformImplementations.kt_3> it = dVar.f2786b.iterator();
            while (it.hasNext()) {
                m2419a(it.next());
            }
            if (dVar.f2768B != null) {
                this.f2820f.putAll(dVar.f2768B);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (dVar.f2808x) {
                    this.f2820f.putBoolean("android.support.localOnly", true);
                }
                if (dVar.f2805u != null) {
                    this.f2820f.putString("android.support.groupKey", dVar.f2805u);
                    if (dVar.f2806v) {
                        this.f2820f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f2820f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (dVar.f2807w != null) {
                    this.f2820f.putString("android.support.sortKey", dVar.f2807w);
                }
            }
            this.f2817c = dVar.f2772F;
            this.f2818d = dVar.f2773G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2815a.setShowWhen(dVar.f2797m);
            if (Build.VERSION.SDK_INT < 21 && dVar.f2784R != null && !dVar.f2784R.isEmpty()) {
                this.f2820f.putStringArray("android.people", (String[]) dVar.f2784R.toArray(new String[dVar.f2784R.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f2815a.setLocalOnly(dVar.f2808x).setGroup(dVar.f2805u).setGroupSummary(dVar.f2806v).setSortKey(dVar.f2807w);
            this.f2821g = dVar.f2779M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2815a.setCategory(dVar.f2767A).setColor(dVar.f2769C).setVisibility(dVar.f2770D).setPublicVersion(dVar.f2771E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = dVar.f2784R.iterator();
            while (it2.hasNext()) {
                this.f2815a.addPerson(it2.next());
            }
            this.f2822h = dVar.f2774H;
            if (dVar.f2787c.size() > 0) {
                Bundle bundle = dVar.m2400a().getBundle("android.car.EXTENSIONS");
                bundle = bundle == null ? new Bundle() : bundle;
                Bundle bundle2 = new Bundle();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < dVar.f2787c.size(); OplusGLSurfaceView_13++) {
                    bundle2.putBundle(Integer.toString(OplusGLSurfaceView_13), NotificationCompatJellybean.m2424a(dVar.f2787c.get(OplusGLSurfaceView_13)));
                }
                bundle.putBundle("invisible_actions", bundle2);
                dVar.m2400a().putBundle("android.car.EXTENSIONS", bundle);
                this.f2820f.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2815a.setExtras(dVar.f2768B).setRemoteInputHistory(dVar.f2801q);
            if (dVar.f2772F != null) {
                this.f2815a.setCustomContentView(dVar.f2772F);
            }
            if (dVar.f2773G != null) {
                this.f2815a.setCustomBigContentView(dVar.f2773G);
            }
            if (dVar.f2774H != null) {
                this.f2815a.setCustomHeadsUpContentView(dVar.f2774H);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2815a.setBadgeIconType(dVar.f2776J).setShortcutId(dVar.f2777K).setTimeoutAfter(dVar.f2778L).setGroupAlertBehavior(dVar.f2779M);
            if (dVar.f2810z) {
                this.f2815a.setColorized(dVar.f2809y);
            }
            if (!TextUtils.isEmpty(dVar.f2775I)) {
                this.f2815a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2815a.setAllowSystemGeneratedContextualActions(dVar.f2780N);
            this.f2815a.setBubbleMetadata(NotificationCompat.IntrinsicsJvm.kt_3.m2390a(dVar.f2781O));
        }
        if (dVar.f2783Q) {
            if (this.f2816b.f2806v) {
                this.f2821g = 2;
            } else {
                this.f2821g = 1;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.f2816b.f2805u)) {
                    this.f2815a.setGroup("silent");
                }
                this.f2815a.setGroupAlertBehavior(this.f2821g);
            }
        }
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    /* renamed from: PlatformImplementations.kt_3 */
    public Notification.Builder mo2376a() {
        return this.f2815a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Notification m2420b() {
        Bundle bundleM2377a;
        RemoteViews remoteViewsM2417d;
        RemoteViews remoteViewsM2416c;
        NotificationCompat.COUIBaseListPopupWindow_8 eVar = this.f2816b.f2799o;
        if (eVar != null) {
            eVar.mo2389a(this);
        }
        RemoteViews remoteViewsM2415b = eVar != null ? eVar.m2415b(this) : null;
        Notification notificationM2421c = m2421c();
        if (remoteViewsM2415b != null) {
            notificationM2421c.contentView = remoteViewsM2415b;
        } else if (this.f2816b.f2772F != null) {
            notificationM2421c.contentView = this.f2816b.f2772F;
        }
        if (Build.VERSION.SDK_INT >= 16 && eVar != null && (remoteViewsM2416c = eVar.m2416c(this)) != null) {
            notificationM2421c.bigContentView = remoteViewsM2416c;
        }
        if (Build.VERSION.SDK_INT >= 21 && eVar != null && (remoteViewsM2417d = this.f2816b.f2799o.m2417d(this)) != null) {
            notificationM2421c.headsUpContentView = remoteViewsM2417d;
        }
        if (Build.VERSION.SDK_INT >= 16 && eVar != null && (bundleM2377a = NotificationCompat.m2377a(notificationM2421c)) != null) {
            eVar.m2413a(bundleM2377a);
        }
        return notificationM2421c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2419a(NotificationCompat.PlatformImplementations.kt_3 aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 20) {
            IconCompat iconCompatM2378a = aVar.m2378a();
            if (Build.VERSION.SDK_INT >= 23) {
                builder = new Notification.Action.Builder(iconCompatM2378a != null ? iconCompatM2378a.m2564d() : null, aVar.m2379b(), aVar.m2380c());
            } else {
                builder = new Notification.Action.Builder(iconCompatM2378a != null ? iconCompatM2378a.m2562b() : 0, aVar.m2379b(), aVar.m2380c());
            }
            if (aVar.m2383f() != null) {
                for (RemoteInput remoteInput : RemoteInput.m2429a(aVar.m2383f())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (aVar.m2381d() != null) {
                bundle = new Bundle(aVar.m2381d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.m2382e());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.m2382e());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.m2384g());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.m2384g());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(aVar.m2385h());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.m2387j());
            builder.addExtras(bundle);
            this.f2815a.addAction(builder.build());
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2819e.add(NotificationCompatJellybean.m2422a(this.f2815a, aVar));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected Notification m2421c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f2815a.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification notificationBuild = this.f2815a.build();
            if (this.f2821g != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.f2821g == 2) {
                    m2418a(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.f2821g == 1) {
                    m2418a(notificationBuild);
                }
            }
            return notificationBuild;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2815a.setExtras(this.f2820f);
            Notification notificationBuild2 = this.f2815a.build();
            RemoteViews remoteViews = this.f2817c;
            if (remoteViews != null) {
                notificationBuild2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f2818d;
            if (remoteViews2 != null) {
                notificationBuild2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f2822h;
            if (remoteViews3 != null) {
                notificationBuild2.headsUpContentView = remoteViews3;
            }
            if (this.f2821g != 0) {
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) != 0 && this.f2821g == 2) {
                    m2418a(notificationBuild2);
                }
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) == 0 && this.f2821g == 1) {
                    m2418a(notificationBuild2);
                }
            }
            return notificationBuild2;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f2815a.setExtras(this.f2820f);
            Notification notificationBuild3 = this.f2815a.build();
            RemoteViews remoteViews4 = this.f2817c;
            if (remoteViews4 != null) {
                notificationBuild3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f2818d;
            if (remoteViews5 != null) {
                notificationBuild3.bigContentView = remoteViews5;
            }
            if (this.f2821g != 0) {
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) != 0 && this.f2821g == 2) {
                    m2418a(notificationBuild3);
                }
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) == 0 && this.f2821g == 1) {
                    m2418a(notificationBuild3);
                }
            }
            return notificationBuild3;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> sparseArrayM2426a = NotificationCompatJellybean.m2426a(this.f2819e);
            if (sparseArrayM2426a != null) {
                this.f2820f.putSparseParcelableArray("android.support.actionExtras", sparseArrayM2426a);
            }
            this.f2815a.setExtras(this.f2820f);
            Notification notificationBuild4 = this.f2815a.build();
            RemoteViews remoteViews6 = this.f2817c;
            if (remoteViews6 != null) {
                notificationBuild4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f2818d;
            if (remoteViews7 != null) {
                notificationBuild4.bigContentView = remoteViews7;
            }
            return notificationBuild4;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Notification notificationBuild5 = this.f2815a.build();
            Bundle bundleM2377a = NotificationCompat.m2377a(notificationBuild5);
            Bundle bundle = new Bundle(this.f2820f);
            for (String str : this.f2820f.keySet()) {
                if (bundleM2377a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            bundleM2377a.putAll(bundle);
            SparseArray<Bundle> sparseArrayM2426a2 = NotificationCompatJellybean.m2426a(this.f2819e);
            if (sparseArrayM2426a2 != null) {
                NotificationCompat.m2377a(notificationBuild5).putSparseParcelableArray("android.support.actionExtras", sparseArrayM2426a2);
            }
            RemoteViews remoteViews8 = this.f2817c;
            if (remoteViews8 != null) {
                notificationBuild5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f2818d;
            if (remoteViews9 != null) {
                notificationBuild5.bigContentView = remoteViews9;
            }
            return notificationBuild5;
        }
        return this.f2815a.getNotification();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2418a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
