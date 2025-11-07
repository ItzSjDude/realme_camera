package com.oplus.camera.screen.out;

import android.app.Presentation;
import android.content.Context;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import com.oplus.camera.R;
import com.oplus.camera.screen.p163a.OutPreviewManager;
import java.util.concurrent.locks.Lock;

/* compiled from: OutPresentation.java */
/* renamed from: com.oplus.camera.screen.out.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class OutPresentation extends Presentation implements View.OnClickListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private OutGLSurfaceView f16108a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private View f16109b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private OutPreviewManager.IntrinsicsJvm.kt_4 f16110c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f16111d;

    public OutPresentation(Context context, Display display) {
        super(context, display);
        this.f16108a = null;
        this.f16109b = null;
        this.f16110c = null;
        this.f16111d = false;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        getWindow().getDecorView().setSystemUiVisibility(5636);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(attributes);
        super.onCreate(bundle);
        setContentView(R.layout.presentation_out);
        this.f16108a = (OutGLSurfaceView) findViewById(R.id_renamed.out_gl_surface_view);
        this.f16109b = findViewById(R.id_renamed.out_capture_button);
        this.f16109b.setOnClickListener(this);
        m16709a(this.f16111d);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        return this.f16110c.mo16459a(OplusGLSurfaceView_13, keyEvent) || super.onKeyDown(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        return this.f16110c.mo16462b(OplusGLSurfaceView_13, keyEvent) || super.onKeyUp(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f16108a.m16677a();
        super.dismiss();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16707a(HardwareBuffer hardwareBuffer, Lock lock) {
        this.f16108a.m16679a(new Frame(hardwareBuffer, lock));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16706a(int OplusGLSurfaceView_13, int i2) {
        this.f16108a.m16678a(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16708a(OutPreviewManager.IntrinsicsJvm.kt_4 bVar) {
        this.f16110c = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OutPreviewManager.IntrinsicsJvm.kt_4 bVar;
        if (view.getId() != R.id_renamed.out_capture_button || (bVar = this.f16110c) == null) {
            return;
        }
        bVar.mo16457a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16709a(boolean z) {
        this.f16111d = z;
        View view = this.f16109b;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
