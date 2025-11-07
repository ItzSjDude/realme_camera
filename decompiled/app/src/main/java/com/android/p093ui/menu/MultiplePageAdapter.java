package com.android.p093ui.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: MultiplePageAdapter.java */
/* renamed from: com.android.ui.menu.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class MultiplePageAdapter extends RecyclerView.AbstractC0685a<PlatformImplementations.kt_3> {

    /* renamed from: PlatformImplementations.kt_3 */
    private static int f6008a = 2;

    public MultiplePageAdapter(Context context) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PlatformImplementations.kt_3 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        return new PlatformImplementations.kt_3(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_pager_multiple_page_guides, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13) {
        CameraLog.m12967f("MultiplePageAdapter", "onBindViewHolder, position:" + OplusGLSurfaceView_13);
        if (OplusGLSurfaceView_13 == 0) {
            if (Util.m24353ap()) {
                aVar.f6013e = R.raw.guide_gesture_capture_anim_dark;
            } else {
                aVar.f6013e = R.raw.guide_gesture_capture_anim_light;
            }
            aVar.f6011c.setText(R.string.camera_gesture_shutter_title);
            aVar.f6012d.setText(R.string.hint_gesture_capture);
        } else {
            if (Util.m24353ap()) {
                aVar.f6013e = R.raw.guide_touch_screen_to_capture_anim_dark;
            } else {
                aVar.f6013e = R.raw.guide_touch_screen_to_capture_anim_light;
            }
            aVar.f6011c.setText(R.string.camera_tap_shutter_title);
            aVar.f6012d.setText(R.string.camera_tap_screen_shutter_summary);
        }
        aVar.f6010b.setAnimation(aVar.f6013e);
        aVar.f6010b.setForceDarkAllowed(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(PlatformImplementations.kt_3 aVar) {
        aVar.f6010b.m5518e();
        super.onViewDetachedFromWindow(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(PlatformImplementations.kt_3 aVar) {
        super.onViewAttachedToWindow(aVar);
        aVar.f6010b.m5507a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        return f6008a;
    }

    /* compiled from: MultiplePageAdapter.java */
    /* renamed from: com.android.ui.menu.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0707w {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private LottieAnimationView f6010b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private TextView f6011c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private TextView f6012d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f6013e;

        public PlatformImplementations.kt_3(View view) {
            super(view);
            this.f6010b = null;
            this.f6011c = null;
            this.f6012d = null;
            this.f6013e = 0;
            this.f6010b = (LottieAnimationView) view.findViewById(R.id_renamed.anim_guide);
            this.f6011c = (TextView) view.findViewById(R.id_renamed.guide_page_title);
            this.f6012d = (TextView) view.findViewById(R.id_renamed.guide_page_instruction);
        }
    }
}
