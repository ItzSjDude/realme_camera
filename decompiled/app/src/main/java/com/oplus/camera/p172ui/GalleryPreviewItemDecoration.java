package com.oplus.camera.p172ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: GalleryPreviewItemDecoration.java */
/* renamed from: com.oplus.camera.ui.OplusGLSurfaceView_14 */
/* loaded from: classes2.dex */
public class GalleryPreviewItemDecoration extends RecyclerView.AbstractC0692h {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f18860a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f18861b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f18862c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f18863d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Context f18864e;

    public GalleryPreviewItemDecoration(Context context, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f18860a = 0;
        this.f18861b = 0;
        this.f18862c = 0;
        this.f18863d = 0;
        this.f18864e = null;
        this.f18864e = context;
        this.f18860a = OplusGLSurfaceView_13;
        this.f18863d = i3;
        this.f18861b = i2;
        this.f18862c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0692h
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0704t c0704t) {
        super.getItemOffsets(rect, view, recyclerView, c0704t);
        rect.left = this.f18860a;
        rect.right = this.f18861b;
        rect.top = this.f18862c;
        rect.bottom = this.f18863d;
    }
}
