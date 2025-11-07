package org.p222a;

import java.io.IOException;

/* compiled from: StringDescription.java */
/* renamed from: org.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class StringDescription extends BaseDescription {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Appendable f24798b;

    public StringDescription() {
        this(new StringBuilder());
    }

    public StringDescription(Appendable appendable) {
        this.f24798b = appendable;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m26072b(SelfDescribing interfaceC4041h) {
        return new StringDescription().mo26020a(interfaceC4041h).toString();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static String m26073c(SelfDescribing interfaceC4041h) {
        return m26072b(interfaceC4041h);
    }

    @Override // org.p222a.BaseDescription
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo26022b(String str) throws IOException {
        try {
            this.f24798b.append(str);
        } catch (IOException COUIBaseListPopupWindow_8) {
            throw new RuntimeException("Could not write description", COUIBaseListPopupWindow_8);
        }
    }

    @Override // org.p222a.BaseDescription
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo26021a(char c2) throws IOException {
        try {
            this.f24798b.append(c2);
        } catch (IOException COUIBaseListPopupWindow_8) {
            throw new RuntimeException("Could not write description", COUIBaseListPopupWindow_8);
        }
    }

    public String toString() {
        return this.f24798b.toString();
    }
}
