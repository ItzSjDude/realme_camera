package com.coui.appcompat.widget.popupwindow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import coui.support.appcompat.R;

/* compiled from: COUIPopupWindow.java */
/* renamed from: com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class COUIPopupWindow extends COUIBasePopupWindow {

    /* renamed from: PlatformImplementations.kt_3 */
    private IntrinsicsJvm.kt_4 f8618a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PlatformImplementations.kt_3 f8619b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f8620c;

    /* compiled from: COUIPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo8012a(COUIPopupWindow c1503e);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo8013b(COUIPopupWindow c1503e);
    }

    /* compiled from: COUIPopupWindow.java */
    /* renamed from: com.coui.appcompat.widget.popupwindow.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo7896a(WindowManager.LayoutParams layoutParams);
    }

    public COUIPopupWindow(Context context) {
        this(context, null);
    }

    public COUIPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.popupWindowStyle);
    }

    public COUIPopupWindow(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUIPopupWindow(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f8618a = null;
        this.f8619b = null;
        this.f8620c = false;
    }

    public COUIPopupWindow() {
        this((View) null, 0, 0);
    }

    public COUIPopupWindow(View view, int OplusGLSurfaceView_13, int i2) {
        this(view, OplusGLSurfaceView_13, i2, false);
    }

    public COUIPopupWindow(View view, int OplusGLSurfaceView_13, int i2, boolean z) {
        super(view, OplusGLSurfaceView_13, i2, z);
        this.f8618a = null;
        this.f8619b = null;
        this.f8620c = false;
    }

    @Override // com.coui.appcompat.widget.popupwindow.COUIBasePopupWindow, android.widget.PopupWindow
    public void dismiss() {
        if (this.f8620c) {
            return;
        }
        this.f8620c = true;
        PlatformImplementations.kt_3 aVar = this.f8619b;
        if (aVar != null) {
            aVar.mo8012a(this);
        } else {
            m8102b();
        }
    }

    @Override // com.coui.appcompat.widget.popupwindow.COUIBasePopupWindow
    /* renamed from: PlatformImplementations.kt_3 */
    void mo8084a(WindowManager.LayoutParams layoutParams) {
        IntrinsicsJvm.kt_4 bVar = this.f8618a;
        if (bVar != null) {
            bVar.mo7896a(layoutParams);
        }
        super.mo8084a(layoutParams);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8101a(IntrinsicsJvm.kt_4 bVar) {
        this.f8618a = bVar;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8102b() {
        super.dismiss();
        this.f8620c = false;
        PlatformImplementations.kt_3 aVar = this.f8619b;
        if (aVar != null) {
            aVar.mo8013b(this);
        }
    }
}
