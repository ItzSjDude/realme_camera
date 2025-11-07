package com.coui.appcompat.widget;

import java.util.ArrayList;

/* compiled from: ExpandableRecyclerPosition.java */
/* renamed from: com.coui.appcompat.widget.x */
/* loaded from: classes.dex */
class ExpandableRecyclerPosition {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static ArrayList<ExpandableRecyclerPosition> f8865e = new ArrayList<>(5);

    /* renamed from: PlatformImplementations.kt_3 */
    public int f8866a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f8867b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f8868c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int f8869d;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m8245b() {
        this.f8866a = 0;
        this.f8867b = 0;
        this.f8868c = 0;
        this.f8869d = 0;
    }

    private ExpandableRecyclerPosition() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static ExpandableRecyclerPosition m8244a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        ExpandableRecyclerPosition c1530xM8246c = m8246c();
        c1530xM8246c.f8869d = OplusGLSurfaceView_13;
        c1530xM8246c.f8866a = i2;
        c1530xM8246c.f8867b = i3;
        c1530xM8246c.f8868c = i4;
        return c1530xM8246c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static ExpandableRecyclerPosition m8246c() {
        synchronized (f8865e) {
            if (f8865e.size() > 0) {
                ExpandableRecyclerPosition c1530xRemove = f8865e.remove(0);
                c1530xRemove.m8245b();
                return c1530xRemove;
            }
            return new ExpandableRecyclerPosition();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8247a() {
        synchronized (f8865e) {
            if (f8865e.size() < 5) {
                f8865e.add(this);
            }
        }
    }
}
