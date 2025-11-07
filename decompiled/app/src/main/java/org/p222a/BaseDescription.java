package org.p222a;

import java.util.Iterator;
import org.p222a.p224b.ArrayIterator;
import org.p222a.p224b.SelfDescribingValueIterator;

/* compiled from: BaseDescription.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class BaseDescription implements Description {
    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo26021a(char c2);

    @Override // org.p222a.Description
    /* renamed from: PlatformImplementations.kt_3 */
    public Description mo26018a(String str) {
        mo26022b(str);
        return this;
    }

    @Override // org.p222a.Description
    /* renamed from: PlatformImplementations.kt_3 */
    public Description mo26020a(SelfDescribing interfaceC4041h) {
        interfaceC4041h.describeTo(this);
        return this;
    }

    @Override // org.p222a.Description
    /* renamed from: PlatformImplementations.kt_3 */
    public Description mo26017a(Object obj) {
        if (obj == null) {
            mo26022b("null");
        } else if (obj instanceof String) {
            m26016c((String) obj);
        } else if (obj instanceof Character) {
            mo26021a('\"');
            m26015b(((Character) obj).charValue());
            mo26021a('\"');
        } else if (obj instanceof Short) {
            mo26021a('<');
            mo26022b(m26013b(obj));
            mo26022b("s>");
        } else if (obj instanceof Long) {
            mo26021a('<');
            mo26022b(m26013b(obj));
            mo26022b("L>");
        } else if (obj instanceof Float) {
            mo26021a('<');
            mo26022b(m26013b(obj));
            mo26022b("F>");
        } else if (obj.getClass().isArray()) {
            m26012a("[", ", ", "]", new ArrayIterator(obj));
        } else {
            mo26021a('<');
            mo26022b(m26013b(obj));
            mo26021a('>');
        }
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m26013b(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception unused) {
            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private <T> Description m26012a(String str, String str2, String str3, Iterator<T> it) {
        return m26014b(str, str2, str3, new SelfDescribingValueIterator(it));
    }

    @Override // org.p222a.Description
    /* renamed from: PlatformImplementations.kt_3 */
    public Description mo26019a(String str, String str2, String str3, Iterable<? extends SelfDescribing> iterable) {
        return m26014b(str, str2, str3, iterable.iterator());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Description m26014b(String str, String str2, String str3, Iterator<? extends SelfDescribing> it) {
        mo26022b(str);
        boolean z = false;
        while (it.hasNext()) {
            if (z) {
                mo26022b(str2);
            }
            mo26020a(it.next());
            z = true;
        }
        mo26022b(str3);
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo26022b(String str) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < str.length(); OplusGLSurfaceView_13++) {
            mo26021a(str.charAt(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m26016c(String str) {
        mo26021a('\"');
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < str.length(); OplusGLSurfaceView_13++) {
            m26015b(str.charAt(OplusGLSurfaceView_13));
        }
        mo26021a('\"');
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m26015b(char c2) {
        if (c2 == '\t') {
            mo26022b("\\t");
            return;
        }
        if (c2 == '\OplusGLSurfaceView_11') {
            mo26022b("\\OplusGLSurfaceView_11");
            return;
        }
        if (c2 == '\r') {
            mo26022b("\\r");
        } else if (c2 == '\"') {
            mo26022b("\\\"");
        } else {
            mo26021a(c2);
        }
    }
}
