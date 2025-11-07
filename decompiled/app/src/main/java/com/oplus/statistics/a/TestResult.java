package com.oplus.statistics.a_renamed;

/* compiled from: PageVisitAgent.java */
/* loaded from: classes2.dex */
public class h_renamed {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed() {
        return "onPause() called without context.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String b_renamed() {
        return "onPause() called without context.";
    }

    public void a_renamed(android.content.Context context) {
        if (context != null) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            final java.lang.String strC = c_renamed(context);
            com.oplus.statistics.f_renamed.d_renamed.c_renamed("PageVisitAgent", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.a_renamed.-$$Lambda$h_renamed$B4C3w8A9ynJ4zvmU7fQmaG2l3l0
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.a_renamed.h_renamed.b_renamed(strC);
                }
            });
            com.oplus.statistics.e_renamed.c_renamed.a_renamed(new com.oplus.statistics.a_renamed.h_renamed.a_renamed(context, strC, jCurrentTimeMillis, 1));
            return;
        }
        com.oplus.statistics.f_renamed.d_renamed.a_renamed("PageVisitAgent", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.a_renamed.-$$Lambda$h_renamed$hc7iXLbKF6RJqMq58q1GDgGeiYI
            @Override // com.oplus.statistics.f_renamed.e_renamed
            public final java.lang.Object get() {
                return com.oplus.statistics.a_renamed.h_renamed.b_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String b_renamed(java.lang.String str) {
        return "onPause: " + str;
    }

    public void b_renamed(android.content.Context context) {
        if (context != null) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            final java.lang.String strC = c_renamed(context);
            com.oplus.statistics.f_renamed.d_renamed.c_renamed("PageVisitAgent", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.a_renamed.-$$Lambda$h_renamed$yOZM8e6tsI6gFdnGuWU7Ki3nPks
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.a_renamed.h_renamed.a_renamed(strC);
                }
            });
            com.oplus.statistics.e_renamed.c_renamed.a_renamed(new com.oplus.statistics.a_renamed.h_renamed.a_renamed(context, strC, jCurrentTimeMillis, 0));
            return;
        }
        com.oplus.statistics.f_renamed.d_renamed.a_renamed("PageVisitAgent", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.a_renamed.-$$Lambda$h_renamed$ju3cYqQ4JP7qmC4WfCW9B6Dp4V4
            @Override // com.oplus.statistics.f_renamed.e_renamed
            public final java.lang.Object get() {
                return com.oplus.statistics.a_renamed.h_renamed.a_renamed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed(java.lang.String str) {
        return "onResume: " + str;
    }

    private static java.lang.String c_renamed(android.content.Context context) {
        return context != null ? context.getClass().getSimpleName() : "";
    }

    private static void d_renamed(android.content.Context context) {
        java.lang.String strA = com.oplus.statistics.d_renamed.b_renamed.a_renamed(context);
        int iE = com.oplus.statistics.d_renamed.b_renamed.e_renamed(context);
        if (!android.text.TextUtils.isEmpty(strA)) {
            com.oplus.statistics.b_renamed.h_renamed hVar = new com.oplus.statistics.b_renamed.h_renamed(context);
            hVar.b_renamed(strA);
            hVar.a_renamed(iE);
            hVar.a_renamed(com.oplus.statistics.f_renamed.f_renamed.a_renamed());
            com.oplus.statistics.c_renamed.d_renamed.a_renamed().a_renamed(context, hVar);
        }
        com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, 0);
        com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c_renamed(android.content.Context context, java.lang.String str, long j_renamed) {
        org.json.JSONArray jSONArray;
        long jB = com.oplus.statistics.d_renamed.b_renamed.b_renamed(context);
        int i_renamed = (int) ((j_renamed - jB) / 1000);
        if (str.equals(com.oplus.statistics.d_renamed.b_renamed.d_renamed(context)) && i_renamed >= 0 && -1 != jB) {
            try {
                java.lang.String strA = com.oplus.statistics.d_renamed.b_renamed.a_renamed(context);
                int iE = com.oplus.statistics.d_renamed.b_renamed.e_renamed(context);
                if (!android.text.TextUtils.isEmpty(strA)) {
                    jSONArray = new org.json.JSONArray(strA);
                    if (jSONArray.length() >= 10) {
                        d_renamed(context);
                        jSONArray = new org.json.JSONArray();
                    }
                } else {
                    jSONArray = new org.json.JSONArray();
                }
                org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                jSONArray2.put(str);
                jSONArray2.put(i_renamed);
                jSONArray.put(jSONArray2);
                com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, iE + i_renamed);
                com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, jSONArray.toString());
            } catch (org.json.JSONException e_renamed) {
                e_renamed.getClass();
                com.oplus.statistics.f_renamed.d_renamed.a_renamed("PageVisitAgent", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.a_renamed.-$$Lambda$q9taOxukEbW7Hxy8kaVM8axwvF0
                    @Override // com.oplus.statistics.f_renamed.e_renamed
                    public final java.lang.Object get() {
                        return e_renamed.toString();
                    }
                });
            } catch (java.lang.Exception e2) {
                e2.getClass();
                com.oplus.statistics.f_renamed.d_renamed.a_renamed("PageVisitAgent", new com.oplus.statistics.a_renamed.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e2));
                com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, "");
                com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, 0);
            }
        }
        com.oplus.statistics.d_renamed.b_renamed.b_renamed(context, j_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d_renamed(android.content.Context context, java.lang.String str, long j_renamed) {
        long jC = com.oplus.statistics.d_renamed.b_renamed.c_renamed(context);
        long jH = com.oplus.statistics.d_renamed.b_renamed.h_renamed(context) * 1000;
        if (j_renamed - com.oplus.statistics.d_renamed.b_renamed.b_renamed(context) >= jH && (-1 == jC || jC >= j_renamed || j_renamed - jC >= jH)) {
            com.oplus.statistics.a_renamed.a_renamed.a_renamed(context);
            d_renamed(context);
        }
        com.oplus.statistics.d_renamed.b_renamed.a_renamed(context, j_renamed);
        com.oplus.statistics.d_renamed.b_renamed.b_renamed(context, str);
    }

    /* compiled from: PageVisitAgent.java */
    private static final class a_renamed implements java.lang.Runnable {

        /* renamed from: a_renamed, reason: collision with root package name */
        private android.content.Context f7638a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.String f7639b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private long f7640c;
        private int d_renamed;

        public a_renamed(android.content.Context context, java.lang.String str, long j_renamed, int i_renamed) {
            this.f7638a = context;
            this.f7639b = str;
            this.f7640c = j_renamed;
            this.d_renamed = i_renamed;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i_renamed = this.d_renamed;
            if (i_renamed == 0) {
                com.oplus.statistics.a_renamed.h_renamed.d_renamed(this.f7638a, this.f7639b, this.f7640c);
            } else {
                if (i_renamed != 1) {
                    return;
                }
                com.oplus.statistics.a_renamed.h_renamed.c_renamed(this.f7638a, this.f7639b, this.f7640c);
            }
        }
    }
}
