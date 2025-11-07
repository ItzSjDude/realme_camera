package com.oplus.statistics;

/* compiled from: OTrackConfig.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class OTrackConfig {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final OTrackConfig f23784a = new OTrackConfig();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f23785b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f23786c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f23787d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f23788e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f23789f;

    private OTrackConfig() {
        this.f23787d = "";
        this.f23788e = "";
        this.f23789f = "";
    }

    private OTrackConfig(PlatformImplementations.kt_3 aVar) {
        this.f23787d = "";
        this.f23788e = "";
        this.f23789f = "";
        this.f23785b = aVar.f23792a;
        this.f23787d = aVar.f23794c;
        this.f23788e = aVar.f23795d;
        this.f23789f = aVar.f23796e;
        this.f23786c = aVar.f23793b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m25258a() {
        return this.f23785b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m25260b() {
        return this.f23786c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m25262c() {
        return this.f23787d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25259a(String str) {
        this.f23787d = str;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m25264d() {
        return this.f23788e;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m25261b(String str) {
        this.f23788e = str;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public String m25265e() {
        return this.f23789f;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m25263c(String str) {
        this.f23789f = str;
    }

    /* compiled from: OTrackConfig.java */
    /* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f23792a = 0;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f23793b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private String f23794c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private String f23795d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private String f23796e;

        /* renamed from: PlatformImplementations.kt_3 */
        public OTrackConfig m25274a() {
            return new OTrackConfig(this);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3 m25273a(String str) {
            this.f23794c = str;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public PlatformImplementations.kt_3 m25275b(String str) {
            this.f23795d = str;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public PlatformImplementations.kt_3 m25276c(String str) {
            this.f23796e = str;
            return this;
        }
    }
}
