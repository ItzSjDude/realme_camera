package com.oplus.camera.p172ui.beauty3d;

import java.util.Stack;

/* compiled from: Beauty3DEditStack.java */
/* renamed from: com.oplus.camera.ui.beauty3d.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class Beauty3DEditStack {

    /* renamed from: PlatformImplementations.kt_3 */
    private Stack<Beauty3DEditAction> f17637a = new Stack<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Stack<Beauty3DEditAction> f17638b = new Stack<>();

    /* renamed from: PlatformImplementations.kt_3 */
    public Beauty3DEditAction m18575a() {
        if (this.f17637a.size() < 0) {
            return null;
        }
        return this.f17637a.pop();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Beauty3DEditAction m18577b() {
        if (this.f17638b.size() < 0) {
            return null;
        }
        return this.f17638b.pop();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Beauty3DEditAction m18576a(Beauty3DEditAction c3135b) {
        return this.f17637a.push(c3135b);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Beauty3DEditAction m18578b(Beauty3DEditAction c3135b) {
        return this.f17638b.push(c3135b);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m18579c() {
        return this.f17637a.size();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m18580d() {
        return this.f17638b.size();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m18581e() {
        while (!this.f17638b.isEmpty()) {
            this.f17638b.pop();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m18582f() {
        while (!this.f17637a.isEmpty()) {
            this.f17637a.pop();
        }
        while (!this.f17638b.isEmpty()) {
            this.f17638b.pop();
        }
    }
}
