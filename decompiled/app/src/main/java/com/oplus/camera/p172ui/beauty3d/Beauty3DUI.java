package com.oplus.camera.p172ui.beauty3d;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p140d.Beauty3DEditHelper;
import com.oplus.camera.p172ui.preview.PreviewFrameLayout;
import com.oplus.camera.util.Util;
import java.util.HashMap;

/* compiled from: Beauty3DUI.java */
/* renamed from: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class Beauty3DUI {

    /* renamed from: PlatformImplementations.kt_3 */
    private Activity f17792a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Beauty3DGuideScanUI f17793b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Beauty3DEditUI f17794c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Beauty3DEditHelper f17795d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PlatformImplementations.kt_3 f17796e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RelativeLayout f17797f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ViewGroup f17798g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private PopupWindow f17799h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private Beauty3DGuideScanListener f17800i = new Beauty3DGuideScanListener() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_11.1
        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DGuideScanListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18659a() {
            if (Beauty3DUI.this.f17796e != null) {
                Beauty3DUI.this.f17796e.mo12862a();
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DGuideScanListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo18662b() {
            if (Beauty3DUI.this.f17796e != null) {
                Beauty3DUI.this.f17796e.mo12865b();
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DGuideScanListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18660a(String str, int[] iArr) {
            if (Beauty3DUI.this.f17796e != null) {
                Beauty3DUI.this.f17796e.mo12863a(str, iArr);
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DGuideScanListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18661a(boolean z) {
            CameraLog.m12954a("Beauty3DUI", "onScanCancel, isUserCancel: " + z);
            if (Beauty3DUI.this.f17796e != null) {
                Beauty3DUI.this.f17796e.mo12864a(z);
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.Beauty3DGuideScanListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo18663c() {
            if (Beauty3DUI.this.f17796e != null) {
                Beauty3DUI.this.f17796e.mo12872i();
            }
        }
    };

    /* renamed from: OplusGLSurfaceView_15 */
    private OnEdit3DViewListener f17801j = new OnEdit3DViewListener() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_11.2
        @Override // com.oplus.camera.p172ui.beauty3d.OnEdit3DViewListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18750a(String str, int[] iArr) {
            if (Beauty3DUI.this.f17796e != null) {
                Beauty3DUI.this.f17796e.mo12863a(str, iArr);
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.OnEdit3DViewListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18749a() {
            if (Beauty3DUI.this.f17796e != null) {
                Beauty3DUI.this.m18744h();
                Beauty3DUI.this.f17796e.mo12866c();
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.OnEdit3DViewListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo18751b() {
            CameraLog.m12954a("Beauty3DUI", "onSave");
            if (Beauty3DUI.this.f17795d != null) {
                Beauty3DUI.this.f17795d.m12806d();
            }
            if (Beauty3DUI.this.f17796e != null) {
                Beauty3DUI.this.f17796e.mo12868e();
            }
        }

        @Override // com.oplus.camera.p172ui.beauty3d.OnEdit3DViewListener
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo18752c() {
            if (Beauty3DUI.this.f17796e != null) {
                Beauty3DUI.this.f17796e.mo12867d();
            }
        }
    };

    /* compiled from: Beauty3DUI.java */
    /* renamed from: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12862a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo12863a(String str, int[] iArr);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo12864a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo12865b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo12866c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo12867d();

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo12868e();

        /* renamed from: COUIBaseListPopupWindow_12 */
        void mo12869f();

        /* renamed from: COUIBaseListPopupWindow_11 */
        void mo12870g();

        /* renamed from: COUIBaseListPopupWindow_10 */
        void mo12871h();

        /* renamed from: OplusGLSurfaceView_13 */
        void mo12872i();
    }

    public Beauty3DUI(Activity activity) {
        this.f17792a = null;
        this.f17792a = activity;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18727a(PlatformImplementations.kt_3 aVar) {
        this.f17798g = (ViewGroup) this.f17792a.findViewById(R.id_renamed.camera);
        this.f17797f = (PreviewFrameLayout) this.f17792a.findViewById(R.id_renamed.frame_layout);
        this.f17796e = aVar;
        this.f17793b = new Beauty3DGuideScanUI(this.f17792a, this.f17797f, this.f17798g);
        this.f17793b.m18700a(this.f17800i);
        this.f17794c = new Beauty3DEditUI(this.f17792a, this.f17801j, this.f17797f);
        this.f17795d = new Beauty3DEditHelper(this.f17792a, this.f17794c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18726a(int OplusGLSurfaceView_13, boolean z, int i2, int i3) {
        if (this.f17793b.m18710b()) {
            return;
        }
        this.f17793b.m18708b(OplusGLSurfaceView_13, z, i2, i3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18725a(int OplusGLSurfaceView_13, boolean z) {
        this.f17793b.m18696a(OplusGLSurfaceView_13, z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18732b(int OplusGLSurfaceView_13, boolean z, int i2, int i3) {
        this.f17793b.m18697a(OplusGLSurfaceView_13, z, i2, i3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18730a(boolean z) {
        m18733b(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18724a(int OplusGLSurfaceView_13, int i2, boolean z) {
        Beauty3DEditUI viewOnClickListenerC3137d = this.f17794c;
        if (viewOnClickListenerC3137d != null) {
            viewOnClickListenerC3137d.m18633b(OplusGLSurfaceView_13, this.f17795d.m12802a());
        }
        PlatformImplementations.kt_3 aVar = this.f17796e;
        if (aVar != null) {
            aVar.mo12869f();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18722a() {
        Beauty3DEditHelper c2673a = this.f17795d;
        if (c2673a != null) {
            c2673a.m12804b();
        }
        Beauty3DEditUI viewOnClickListenerC3137d = this.f17794c;
        if (viewOnClickListenerC3137d != null) {
            viewOnClickListenerC3137d.m18645j();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18731b() {
        Beauty3DGuideScanUI viewOnClickListenerC3139f = this.f17793b;
        if (viewOnClickListenerC3139f != null) {
            viewOnClickListenerC3139f.m18695a(0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18733b(boolean z) {
        Beauty3DGuideScanUI viewOnClickListenerC3139f = this.f17793b;
        if (viewOnClickListenerC3139f != null) {
            viewOnClickListenerC3139f.m18704a(z, true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m18737c() {
        Beauty3DGuideScanUI viewOnClickListenerC3139f = this.f17793b;
        if (viewOnClickListenerC3139f != null) {
            return viewOnClickListenerC3139f.m18705a();
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m18738d() {
        Beauty3DGuideScanUI viewOnClickListenerC3139f = this.f17793b;
        if (viewOnClickListenerC3139f != null && viewOnClickListenerC3139f.m18710b()) {
            this.f17793b.m18715e();
        } else {
            Beauty3DEditUI viewOnClickListenerC3137d = this.f17794c;
            if (viewOnClickListenerC3137d != null) {
                viewOnClickListenerC3137d.m18628a(false);
            }
        }
        m18746j();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m18740e() {
        Beauty3DGuideScanUI viewOnClickListenerC3139f = this.f17793b;
        if (viewOnClickListenerC3139f != null) {
            viewOnClickListenerC3139f.m18714d();
        }
        Beauty3DEditUI viewOnClickListenerC3137d = this.f17794c;
        if (viewOnClickListenerC3137d != null) {
            viewOnClickListenerC3137d.m18647l();
        }
        this.f17793b = null;
        this.f17794c = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18723a(int OplusGLSurfaceView_13) {
        Beauty3DGuideScanUI viewOnClickListenerC3139f = this.f17793b;
        if (viewOnClickListenerC3139f != null) {
            viewOnClickListenerC3139f.m18706b(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18729a(String str, int[] iArr) throws Resources.NotFoundException {
        Beauty3DEditHelper c2673a = this.f17795d;
        if (c2673a != null) {
            c2673a.m12803a(str, iArr);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m18734b(int OplusGLSurfaceView_13) {
        Beauty3DEditUI viewOnClickListenerC3137d;
        CameraLog.m12954a("Beauty3DUI", "onBackPressed, status: " + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 >= 1 && OplusGLSurfaceView_13 <= 4) {
            m18730a(true);
            return true;
        }
        if (OplusGLSurfaceView_13 <= 6 || OplusGLSurfaceView_13 > 10 || (viewOnClickListenerC3137d = this.f17794c) == null || this.f17796e == null) {
            return false;
        }
        viewOnClickListenerC3137d.m18628a(true);
        this.f17796e.mo12867d();
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18735c(int OplusGLSurfaceView_13, boolean z, int i2, int i3) {
        Beauty3DGuideScanUI viewOnClickListenerC3139f = this.f17793b;
        if (viewOnClickListenerC3139f != null) {
            viewOnClickListenerC3139f.m18713c(OplusGLSurfaceView_13, z, i2, i3);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18728a(Integer num) {
        Beauty3DGuideScanUI viewOnClickListenerC3139f = this.f17793b;
        if (viewOnClickListenerC3139f != null) {
            viewOnClickListenerC3139f.m18701a(num);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m18742f() {
        Beauty3DEditUI viewOnClickListenerC3137d = this.f17794c;
        if (viewOnClickListenerC3137d != null) {
            viewOnClickListenerC3137d.m18644i();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18736c(boolean z) {
        Beauty3DEditUI viewOnClickListenerC3137d = this.f17794c;
        if (viewOnClickListenerC3137d != null) {
            viewOnClickListenerC3137d.m18637c(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m18739d(boolean z) {
        Beauty3DGuideScanUI viewOnClickListenerC3139f = this.f17793b;
        if (viewOnClickListenerC3139f != null) {
            viewOnClickListenerC3139f.m18709b(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public HashMap<String, int[]> m18743g() {
        Beauty3DEditUI viewOnClickListenerC3137d = this.f17794c;
        if (viewOnClickListenerC3137d != null) {
            return viewOnClickListenerC3137d.m18652q();
        }
        return null;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m18744h() {
        Beauty3DEditHelper c2673a = this.f17795d;
        if (c2673a != null) {
            c2673a.m12807e();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m18745i() {
        if (this.f17799h == null) {
            this.f17799h = m18719a(new View.OnClickListener() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_11.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CameraLog.m12954a("Beauty3DUI", "onClick, beauty3d edit");
                    Beauty3DUI.this.m18746j();
                    if (Beauty3DUI.this.f17796e != null) {
                        Beauty3DUI.this.f17796e.mo12870g();
                    }
                }
            }, new View.OnClickListener() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_11.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CameraLog.m12954a("Beauty3DUI", "onClick, beauty3d data delete");
                    Beauty3DUI.this.m18746j();
                    if (Beauty3DUI.this.f17796e != null) {
                        Beauty3DUI.this.f17796e.mo12871h();
                    }
                }
            });
        }
        if (this.f17799h.isShowing()) {
            return;
        }
        try {
            int screenWidth = (Util.getScreenWidth() / 2) - (this.f17799h.getWidth() / 2);
            if (screenWidth <= 0) {
                screenWidth = 0;
            }
            this.f17799h.showAtLocation(this.f17798g, 83, screenWidth, this.f17792a.getResources().getDimensionPixelSize(R.dimen.bubble_type_beauty3d_edit_offset_y));
        } catch (WindowManager.BadTokenException COUIBaseListPopupWindow_8) {
            if (this.f17799h.isShowing()) {
                this.f17799h.dismiss();
            }
            CameraLog.m12966e("Beauty3DUI", "showEditChooseMenu, exception: " + COUIBaseListPopupWindow_8.getMessage());
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m18746j() {
        PopupWindow popupWindow = this.f17799h;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.f17799h.dismiss();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PopupWindow m18719a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        View viewInflate = LayoutInflater.from(this.f17792a).inflate(R.layout.beauty3d_edit_choose_menu, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id_renamed.edit);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id_renamed.delete);
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_11.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!view.isEnabled()) {
                    return false;
                }
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    view.setAlpha(0.5f);
                } else if (actionMasked == 1) {
                    view.setAlpha(1.0f);
                }
                return false;
            }
        };
        imageView.setOnClickListener(onClickListener);
        imageView.setOnTouchListener(onTouchListener);
        imageView2.setOnClickListener(onClickListener2);
        imageView2.setOnTouchListener(onTouchListener);
        PopupWindow popupWindow = new PopupWindow(this.f17792a);
        popupWindow.setWidth(this.f17792a.getResources().getDimensionPixelSize(R.dimen.beauty3d_edit_choose_menu_width));
        popupWindow.setHeight(-2);
        popupWindow.setContentView(viewInflate);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(false);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setAnimationStyle(R.style.PopupWindowStyle);
        return popupWindow;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m18741e(final boolean z) {
        CameraLog.m12954a("Beauty3DUI", "enableEditChooseMenu enable: " + z);
        PopupWindow popupWindow = this.f17799h;
        if (popupWindow != null) {
            popupWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_11.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return !z;
                }
            });
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public int m18747k() {
        Beauty3DEditUI viewOnClickListenerC3137d = this.f17794c;
        if (viewOnClickListenerC3137d != null) {
            return viewOnClickListenerC3137d.m18650o();
        }
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m18748l() {
        Beauty3DGuideScanUI viewOnClickListenerC3139f = this.f17793b;
        if (viewOnClickListenerC3139f != null) {
            viewOnClickListenerC3139f.m18718h();
        }
    }
}
