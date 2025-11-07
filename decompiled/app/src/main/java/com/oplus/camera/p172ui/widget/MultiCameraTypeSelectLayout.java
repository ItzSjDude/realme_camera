package com.oplus.camera.p172ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotateMoreItem;
import com.oplus.camera.util.Util;

/* compiled from: MultiCameraTypeSelectLayout.java */
/* renamed from: com.oplus.camera.ui.widget.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class MultiCameraTypeSelectLayout extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private RotateMoreItem f22754a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private RotateMoreItem f22755b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RotateMoreItem f22756c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f22757d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f22758e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f22759f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PlatformImplementations.kt_3 f22760g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f22761h;

    /* compiled from: MultiCameraTypeSelectLayout.java */
    /* renamed from: com.oplus.camera.ui.widget.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        void onTypeChanged(int OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24088b() {
    }

    public MultiCameraTypeSelectLayout(Context context, int OplusGLSurfaceView_13) {
        super(context);
        this.f22754a = null;
        this.f22755b = null;
        this.f22756c = null;
        this.f22757d = 0;
        this.f22758e = 0;
        this.f22759f = 1;
        this.f22760g = null;
        this.f22761h = 0;
        this.f22761h = OplusGLSurfaceView_13;
        m24082c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m24082c() {
        LayoutInflater.from(getContext()).inflate(1 == this.f22761h ? R.layout.multi_video_type_select_layout_vertical : R.layout.multi_video_type_select_layout, (ViewGroup) this, true);
        setClipChildren(false);
        this.f22754a = (RotateMoreItem) findViewById(R.id_renamed.view_half_half);
        this.f22754a.setText(getResources().getString(R.string.camera_mode_multi_video_type_pip_rect_half));
        this.f22755b = (RotateMoreItem) findViewById(R.id_renamed.view_pip_cir);
        this.f22755b.setText(getResources().getString(R.string.camera_mode_multi_video_type_pip_cir));
        this.f22756c = (RotateMoreItem) findViewById(R.id_renamed.view_pip_rec);
        this.f22756c.setText(getResources().getString(R.string.camera_mode_multi_video_type_pip_rect));
        m24084e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24086a(int OplusGLSurfaceView_13, boolean z) {
        int i2 = this.f22758e;
        if (i2 == OplusGLSurfaceView_13) {
            return;
        }
        this.f22757d = i2;
        this.f22758e = OplusGLSurfaceView_13;
        this.f22754a.m18355a(this.f22757d, this.f22758e);
        this.f22755b.m18355a(this.f22757d, this.f22758e);
        this.f22756c.m18355a(this.f22757d, this.f22758e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24085a() {
        m24088b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24087a(View view) {
        RotateMoreItem rotateMoreItem = this.f22754a;
        rotateMoreItem.setFrameShow(rotateMoreItem.getId() == view.getId());
        RotateMoreItem rotateMoreItem2 = this.f22755b;
        rotateMoreItem2.setFrameShow(rotateMoreItem2.getId() == view.getId());
        RotateMoreItem rotateMoreItem3 = this.f22756c;
        rotateMoreItem3.setFrameShow(rotateMoreItem3.getId() == view.getId());
        switch (view.getId()) {
            case R.id_renamed.view_half_half /* 2131297309 */:
                m24081a(0);
                m24083d();
                break;
            case R.id_renamed.view_pip_cir /* 2131297314 */:
                m24081a(1);
                m24083d();
                break;
            case R.id_renamed.view_pip_rec /* 2131297315 */:
                m24081a(2);
                m24083d();
                break;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m24083d() {
        this.f22754a.postInvalidate();
        this.f22755b.postInvalidate();
        this.f22756c.postInvalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24081a(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("MultiCameraTypeSelectLayout", "changeType, mSelectedType: " + this.f22759f + ", type: " + OplusGLSurfaceView_13);
        if (this.f22759f != OplusGLSurfaceView_13) {
            this.f22759f = OplusGLSurfaceView_13;
            PlatformImplementations.kt_3 aVar = this.f22760g;
            if (aVar != null) {
                aVar.onTypeChanged(this.f22759f);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m24084e() {
        this.f22754a.setImage(Util.m24216a(getContext(), R.drawable.multi_video_type_top_bottom_normal));
        this.f22755b.setImage(Util.m24216a(getContext(), R.drawable.multi_video_type_pip_cir_normal));
        this.f22756c.setImage(Util.m24216a(getContext(), R.drawable.multi_video_type_pip_rect_normal));
        int iM2254c = ContextCompat.m2254c(getContext(), R.color.couiWhite);
        this.f22754a.setTextColor(iM2254c);
        this.f22755b.setTextColor(iM2254c);
        this.f22756c.setTextColor(iM2254c);
    }

    public void setOnTypeChangeListener(PlatformImplementations.kt_3 aVar) {
        this.f22760g = aVar;
    }

    public void setType(int OplusGLSurfaceView_13) {
        this.f22759f = OplusGLSurfaceView_13;
        this.f22754a.setFrameShow(OplusGLSurfaceView_13 == 0);
        this.f22755b.setFrameShow(OplusGLSurfaceView_13 == 1);
        this.f22756c.setFrameShow(OplusGLSurfaceView_13 == 2);
    }
}
