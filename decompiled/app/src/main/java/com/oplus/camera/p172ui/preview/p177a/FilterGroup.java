package com.oplus.camera.p172ui.preview.p177a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: FilterGroup.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class FilterGroup {

    /* renamed from: PlatformImplementations.kt_3 */
    public List<String> f21247a = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<String> f21248b = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<Integer> f21249c = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_5 */
    public List<Integer> f21250d = new ArrayList();

    /* renamed from: COUIBaseListPopupWindow_8 */
    public List<String> f21251e = this.f21248b;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public List<Integer> f21252f = this.f21250d;

    /* renamed from: PlatformImplementations.kt_3 */
    public List<String> m22561a(boolean z) {
        return z ? this.f21247a : this.f21248b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<Integer> m22566b(boolean z) {
        return z ? this.f21249c : this.f21250d;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22565a(String str, Integer num) {
        m22571d(str, num);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22568b(String str, Integer num) {
        m22570c(str, num);
        m22571d(str, num);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22563a(int OplusGLSurfaceView_13, String str, Integer num) {
        m22567b(OplusGLSurfaceView_13, str, num);
        m22569c(OplusGLSurfaceView_13, str, num);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m22570c(String str, Integer num) {
        this.f21247a.add(str);
        this.f21249c.add(num);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22567b(int OplusGLSurfaceView_13, String str, Integer num) {
        this.f21247a.add(OplusGLSurfaceView_13, str);
        this.f21249c.add(OplusGLSurfaceView_13, num);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m22571d(String str, Integer num) {
        this.f21248b.add(str);
        this.f21250d.add(num);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m22569c(int OplusGLSurfaceView_13, String str, Integer num) {
        this.f21248b.add(OplusGLSurfaceView_13, str);
        this.f21250d.add(OplusGLSurfaceView_13, num);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22562a(int OplusGLSurfaceView_13) {
        this.f21248b.remove(OplusGLSurfaceView_13);
        this.f21250d.remove(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22564a(FilterGroup c3412i, boolean z, boolean z2) {
        if (z) {
            this.f21248b.addAll(c3412i.f21248b);
            this.f21250d.addAll(c3412i.f21250d);
        }
        if (z2) {
            this.f21247a.addAll(c3412i.f21247a);
            this.f21249c.addAll(c3412i.f21249c);
        }
    }
}
