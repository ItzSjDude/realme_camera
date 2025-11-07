package com.oplus.p125c.p126a.p131c;

import com.android.providers.downloads.Downloads;
import java.util.regex.Pattern;
import p061c.C0983h;
import p061c.Lazy.kt;
import p061c.p070f.p071a.Functions.kt_20;
import p061c.p070f.p072b.Lambda.kt;

/* compiled from: ProjectManager.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public final class ProjectManager.kt {

    /* compiled from: ProjectManager.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public static final PlatformImplementations.kt_3 f10527a = new PlatformImplementations.kt_3();

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static final Lazy.kt f10528b = C0983h.m5339a(ProjectManager.kt_3.INSTANCE);

        /* renamed from: PlatformImplementations.kt_3 */
        public final Pattern m9454a() {
            return (Pattern) f10528b.getValue();
        }

        private PlatformImplementations.kt_3() {
        }

        /* compiled from: ProjectManager.kt */
        /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3$PlatformImplementations.kt_3, reason: collision with other inner class name */
        static final class ProjectManager.kt_3 extends Lambda.kt implements Functions.kt_20<Pattern> {
            public static final ProjectManager.kt_3 INSTANCE = new ProjectManager.kt_3();

            ProjectManager.kt_3() {
                super(0);
            }

            @Override // p061c.p070f.p071a.Functions.kt_20
            public final Pattern invoke() {
                return Pattern.compile("(?OplusGLSurfaceView_13)(DCIM/Camera/Cshot/)([1-9][0-9]*)/");
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final String[] m9455b() {
            return new String[]{"_id", "relative_path"};
        }
    }

    /* compiled from: ProjectManager.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    public static final class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public static final IntrinsicsJvm.kt_4 f10529a = new IntrinsicsJvm.kt_4();

        private IntrinsicsJvm.kt_4() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final String[] m9456a() {
            return new String[]{"_id", Downloads.Impl._DATA, "orientation", "date_modified", "media_type", "relative_path", "width", "height", "mime_type"};
        }
    }

    /* compiled from: ProjectManager.kt */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_3 */
    public static final class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public static final IntrinsicsJvm.kt_3 f10530a = new IntrinsicsJvm.kt_3();

        private IntrinsicsJvm.kt_3() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final String[] m9457a() {
            return new String[]{"media_id"};
        }
    }
}
