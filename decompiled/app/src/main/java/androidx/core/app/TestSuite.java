package androidx.core.app;

/* compiled from: NotificationCompatBuilder.java */
/* loaded from: classes.dex */
class i_renamed implements androidx.core.app.g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.app.Notification.Builder f841a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.core.app.h_renamed.d_renamed f842b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.RemoteViews f843c;
    private android.widget.RemoteViews d_renamed;
    private final java.util.List<android.os.Bundle> e_renamed = new java.util.ArrayList();
    private final android.os.Bundle f_renamed = new android.os.Bundle();
    private int g_renamed;
    private android.widget.RemoteViews h_renamed;

    i_renamed(androidx.core.app.h_renamed.d_renamed dVar) {
        this.f842b = dVar;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.f841a = new android.app.Notification.Builder(dVar.f835a, dVar.I_renamed);
        } else {
            this.f841a = new android.app.Notification.Builder(dVar.f835a);
        }
        android.app.Notification notification = dVar.P_renamed;
        this.f841a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.h_renamed).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.d_renamed).setContentText(dVar.e_renamed).setContentInfo(dVar.j_renamed).setContentIntent(dVar.f_renamed).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.g_renamed, (notification.flags & 128) != 0).setLargeIcon(dVar.i_renamed).setNumber(dVar.k_renamed).setProgress(dVar.r_renamed, dVar.s_renamed, dVar.t_renamed);
        if (android.os.Build.VERSION.SDK_INT < 21) {
            this.f841a.setSound(notification.sound, notification.audioStreamType);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            this.f841a.setSubText(dVar.p_renamed).setUsesChronometer(dVar.n_renamed).setPriority(dVar.l_renamed);
            java.util.Iterator<androidx.core.app.h_renamed.a_renamed> it = dVar.f836b.iterator();
            while (it.hasNext()) {
                a_renamed(it.next());
            }
            if (dVar.B_renamed != null) {
                this.f_renamed.putAll(dVar.B_renamed);
            }
            if (android.os.Build.VERSION.SDK_INT < 20) {
                if (dVar.x_renamed) {
                    this.f_renamed.putBoolean("android.support.localOnly", true);
                }
                if (dVar.u_renamed != null) {
                    this.f_renamed.putString("android.support.groupKey", dVar.u_renamed);
                    if (dVar.v_renamed) {
                        this.f_renamed.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f_renamed.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (dVar.w_renamed != null) {
                    this.f_renamed.putString("android.support.sortKey", dVar.w_renamed);
                }
            }
            this.f843c = dVar.F_renamed;
            this.d_renamed = dVar.G_renamed;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            this.f841a.setShowWhen(dVar.m_renamed);
            if (android.os.Build.VERSION.SDK_INT < 21 && dVar.R_renamed != null && !dVar.R_renamed.isEmpty()) {
                this.f_renamed.putStringArray("android.people", (java.lang.String[]) dVar.R_renamed.toArray(new java.lang.String[dVar.R_renamed.size()]));
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            this.f841a.setLocalOnly(dVar.x_renamed).setGroup(dVar.u_renamed).setGroupSummary(dVar.v_renamed).setSortKey(dVar.w_renamed);
            this.g_renamed = dVar.M_renamed;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.f841a.setCategory(dVar.A_renamed).setColor(dVar.C_renamed).setVisibility(dVar.D_renamed).setPublicVersion(dVar.E_renamed).setSound(notification.sound, notification.audioAttributes);
            java.util.Iterator<java.lang.String> it2 = dVar.R_renamed.iterator();
            while (it2.hasNext()) {
                this.f841a.addPerson(it2.next());
            }
            this.h_renamed = dVar.H_renamed;
            if (dVar.f837c.size() > 0) {
                android.os.Bundle bundle = dVar.a_renamed().getBundle("android.car.EXTENSIONS");
                bundle = bundle == null ? new android.os.Bundle() : bundle;
                android.os.Bundle bundle2 = new android.os.Bundle();
                for (int i_renamed = 0; i_renamed < dVar.f837c.size(); i_renamed++) {
                    bundle2.putBundle(java.lang.Integer.toString(i_renamed), androidx.core.app.j_renamed.a_renamed(dVar.f837c.get(i_renamed)));
                }
                bundle.putBundle("invisible_actions", bundle2);
                dVar.a_renamed().putBundle("android.car.EXTENSIONS", bundle);
                this.f_renamed.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            this.f841a.setExtras(dVar.B_renamed).setRemoteInputHistory(dVar.q_renamed);
            if (dVar.F_renamed != null) {
                this.f841a.setCustomContentView(dVar.F_renamed);
            }
            if (dVar.G_renamed != null) {
                this.f841a.setCustomBigContentView(dVar.G_renamed);
            }
            if (dVar.H_renamed != null) {
                this.f841a.setCustomHeadsUpContentView(dVar.H_renamed);
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.f841a.setBadgeIconType(dVar.J_renamed).setShortcutId(dVar.K_renamed).setTimeoutAfter(dVar.L_renamed).setGroupAlertBehavior(dVar.M_renamed);
            if (dVar.z_renamed) {
                this.f841a.setColorized(dVar.y_renamed);
            }
            if (!android.text.TextUtils.isEmpty(dVar.I_renamed)) {
                this.f841a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            this.f841a.setAllowSystemGeneratedContextualActions(dVar.N_renamed);
            this.f841a.setBubbleMetadata(androidx.core.app.h_renamed.c_renamed.a_renamed(dVar.O_renamed));
        }
        if (dVar.Q_renamed) {
            if (this.f842b.v_renamed) {
                this.g_renamed = 2;
            } else {
                this.g_renamed = 1;
            }
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                if (android.text.TextUtils.isEmpty(this.f842b.u_renamed)) {
                    this.f841a.setGroup("silent");
                }
                this.f841a.setGroupAlertBehavior(this.g_renamed);
            }
        }
    }

    @Override // androidx.core.app.g_renamed
    public android.app.Notification.Builder a_renamed() {
        return this.f841a;
    }

    public android.app.Notification b_renamed() {
        android.os.Bundle bundleA;
        android.widget.RemoteViews remoteViewsD;
        android.widget.RemoteViews remoteViewsC;
        androidx.core.app.h_renamed.e_renamed eVar = this.f842b.o_renamed;
        if (eVar != null) {
            eVar.a_renamed(this);
        }
        android.widget.RemoteViews remoteViewsB = eVar != null ? eVar.b_renamed(this) : null;
        android.app.Notification notificationC = c_renamed();
        if (remoteViewsB != null) {
            notificationC.contentView = remoteViewsB;
        } else if (this.f842b.F_renamed != null) {
            notificationC.contentView = this.f842b.F_renamed;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16 && eVar != null && (remoteViewsC = eVar.c_renamed(this)) != null) {
            notificationC.bigContentView = remoteViewsC;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21 && eVar != null && (remoteViewsD = this.f842b.o_renamed.d_renamed(this)) != null) {
            notificationC.headsUpContentView = remoteViewsD;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16 && eVar != null && (bundleA = androidx.core.app.h_renamed.a_renamed(notificationC)) != null) {
            eVar.a_renamed(bundleA);
        }
        return notificationC;
    }

    private void a_renamed(androidx.core.app.h_renamed.a_renamed aVar) {
        android.app.Notification.Action.Builder builder;
        android.os.Bundle bundle;
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            androidx.core.graphics.drawable.IconCompat iconCompatA = aVar.a_renamed();
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                builder = new android.app.Notification.Action.Builder(iconCompatA != null ? iconCompatA.d_renamed() : null, aVar.b_renamed(), aVar.c_renamed());
            } else {
                builder = new android.app.Notification.Action.Builder(iconCompatA != null ? iconCompatA.b_renamed() : 0, aVar.b_renamed(), aVar.c_renamed());
            }
            if (aVar.f_renamed() != null) {
                for (android.app.RemoteInput remoteInput : androidx.core.app.k_renamed.a_renamed(aVar.f_renamed())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (aVar.d_renamed() != null) {
                bundle = new android.os.Bundle(aVar.d_renamed());
            } else {
                bundle = new android.os.Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e_renamed());
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.e_renamed());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g_renamed());
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.g_renamed());
            }
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(aVar.h_renamed());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.j_renamed());
            builder.addExtras(bundle);
            this.f841a.addAction(builder.build());
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            this.e_renamed.add(androidx.core.app.j_renamed.a_renamed(this.f841a, aVar));
        }
    }

    protected android.app.Notification c_renamed() {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return this.f841a.build();
        }
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            android.app.Notification notificationBuild = this.f841a.build();
            if (this.g_renamed != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.g_renamed == 2) {
                    a_renamed(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.g_renamed == 1) {
                    a_renamed(notificationBuild);
                }
            }
            return notificationBuild;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            this.f841a.setExtras(this.f_renamed);
            android.app.Notification notificationBuild2 = this.f841a.build();
            android.widget.RemoteViews remoteViews = this.f843c;
            if (remoteViews != null) {
                notificationBuild2.contentView = remoteViews;
            }
            android.widget.RemoteViews remoteViews2 = this.d_renamed;
            if (remoteViews2 != null) {
                notificationBuild2.bigContentView = remoteViews2;
            }
            android.widget.RemoteViews remoteViews3 = this.h_renamed;
            if (remoteViews3 != null) {
                notificationBuild2.headsUpContentView = remoteViews3;
            }
            if (this.g_renamed != 0) {
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) != 0 && this.g_renamed == 2) {
                    a_renamed(notificationBuild2);
                }
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) == 0 && this.g_renamed == 1) {
                    a_renamed(notificationBuild2);
                }
            }
            return notificationBuild2;
        }
        if (android.os.Build.VERSION.SDK_INT >= 20) {
            this.f841a.setExtras(this.f_renamed);
            android.app.Notification notificationBuild3 = this.f841a.build();
            android.widget.RemoteViews remoteViews4 = this.f843c;
            if (remoteViews4 != null) {
                notificationBuild3.contentView = remoteViews4;
            }
            android.widget.RemoteViews remoteViews5 = this.d_renamed;
            if (remoteViews5 != null) {
                notificationBuild3.bigContentView = remoteViews5;
            }
            if (this.g_renamed != 0) {
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) != 0 && this.g_renamed == 2) {
                    a_renamed(notificationBuild3);
                }
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) == 0 && this.g_renamed == 1) {
                    a_renamed(notificationBuild3);
                }
            }
            return notificationBuild3;
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            android.util.SparseArray<android.os.Bundle> sparseArrayA = androidx.core.app.j_renamed.a_renamed(this.e_renamed);
            if (sparseArrayA != null) {
                this.f_renamed.putSparseParcelableArray("android.support.actionExtras", sparseArrayA);
            }
            this.f841a.setExtras(this.f_renamed);
            android.app.Notification notificationBuild4 = this.f841a.build();
            android.widget.RemoteViews remoteViews6 = this.f843c;
            if (remoteViews6 != null) {
                notificationBuild4.contentView = remoteViews6;
            }
            android.widget.RemoteViews remoteViews7 = this.d_renamed;
            if (remoteViews7 != null) {
                notificationBuild4.bigContentView = remoteViews7;
            }
            return notificationBuild4;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            android.app.Notification notificationBuild5 = this.f841a.build();
            android.os.Bundle bundleA = androidx.core.app.h_renamed.a_renamed(notificationBuild5);
            android.os.Bundle bundle = new android.os.Bundle(this.f_renamed);
            for (java.lang.String str : this.f_renamed.keySet()) {
                if (bundleA.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            bundleA.putAll(bundle);
            android.util.SparseArray<android.os.Bundle> sparseArrayA2 = androidx.core.app.j_renamed.a_renamed(this.e_renamed);
            if (sparseArrayA2 != null) {
                androidx.core.app.h_renamed.a_renamed(notificationBuild5).putSparseParcelableArray("android.support.actionExtras", sparseArrayA2);
            }
            android.widget.RemoteViews remoteViews8 = this.f843c;
            if (remoteViews8 != null) {
                notificationBuild5.contentView = remoteViews8;
            }
            android.widget.RemoteViews remoteViews9 = this.d_renamed;
            if (remoteViews9 != null) {
                notificationBuild5.bigContentView = remoteViews9;
            }
            return notificationBuild5;
        }
        return this.f841a.getNotification();
    }

    private void a_renamed(android.app.Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
