package com.oplus.camera.longexposure;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.widget.RoundImageView;
import com.oplus.camera.util.Util;
import java.util.List;

/* compiled from: LongExposureEffectMenuAdapter.java */
/* renamed from: com.oplus.camera.longexposure.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class LongExposureEffectMenuAdapter extends RecyclerView.AbstractC0685a<IntrinsicsJvm.kt_4> {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f14533a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private List<LongExposureSceneItem> f14534b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PlatformImplementations.kt_3 f14535c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f14536d = true;

    /* compiled from: LongExposureEffectMenuAdapter.java */
    /* renamed from: com.oplus.camera.longexposure.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo14568a(LongExposureSceneItem c2806j);
    }

    public LongExposureEffectMenuAdapter(Context context, List<LongExposureSceneItem> list) {
        this.f14533a = null;
        this.f14533a = context;
        this.f14534b = list;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14565a(PlatformImplementations.kt_3 aVar) {
        this.f14535c = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public IntrinsicsJvm.kt_4 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.long_exposure_effect_menu_item, viewGroup, false));
        bVar.setIsRecyclable(true);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final IntrinsicsJvm.kt_4 bVar, final int OplusGLSurfaceView_13) {
        final LongExposureSceneItem c2806j = this.f14534b.get(OplusGLSurfaceView_13);
        if (this.f14536d) {
            if (bVar.f14544d != null) {
                bVar.f14544d.setText(c2806j.m14644b());
                bVar.f14544d.setTextSize(0, this.f14533a.getResources().getDimension(R.dimen.long_exposure_item_text_size));
                bVar.f14544d.setTypeface(Util.m24411c(true));
                bVar.f14544d.setShadowLayer(this.f14533a.getResources().getDimension(R.dimen.long_exposure_scene_text_radius_shadow), 0.0f, 0.0f, this.f14533a.getResources().getColor(R.color.color_black_with_30_percent_transparency));
            }
            if (bVar.f14543c != null) {
                bVar.f14543c.setBitmap(BitmapFactory.decodeResource(this.f14533a.getResources(), c2806j.m14645c()));
                bVar.f14543c.setMRadius(this.f14533a.getResources().getDimension(R.dimen.long_exposure_effect_menu_inner_radius));
            }
            if (c2806j.m14646d()) {
                bVar.itemView.setSelected(true);
            } else {
                bVar.itemView.setSelected(false);
            }
        }
        bVar.f14541a.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.longexposure.IntrinsicsJvm.kt_3.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                CameraLog.m12954a("LongExposureEffectMenuAdapter", "mBaseView, event: " + motionEvent.getAction());
                if (LongExposureEffectMenuAdapter.this.f14536d) {
                    if (1 == motionEvent.getAction()) {
                        c2806j.m14643a(true);
                        for (int i2 = 0; i2 < LongExposureEffectMenuAdapter.this.f14534b.size(); i2++) {
                            if (OplusGLSurfaceView_13 != i2) {
                                ((LongExposureSceneItem) LongExposureEffectMenuAdapter.this.f14534b.get(i2)).m14643a(false);
                            }
                        }
                        LongExposureEffectMenuAdapter.this.notifyDataSetChanged();
                        if (LongExposureEffectMenuAdapter.this.f14535c != null) {
                            LongExposureEffectMenuAdapter.this.f14535c.mo14568a(c2806j);
                        }
                    }
                    bVar.f14541a.onTouchEvent(motionEvent);
                }
                return true;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        return this.f14534b.size();
    }

    /* compiled from: LongExposureEffectMenuAdapter.java */
    /* renamed from: com.oplus.camera.longexposure.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    public class IntrinsicsJvm.kt_4 extends RecyclerView.AbstractC0707w {

        /* renamed from: PlatformImplementations.kt_3 */
        LongExposureItemBaseView f14541a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        LongExposureItemFrame f14542b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        RoundImageView f14543c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        TextView f14544d;

        public IntrinsicsJvm.kt_4(View view) {
            super(view);
            this.f14541a = (LongExposureItemBaseView) view.findViewById(R.id_renamed.long_exposure_item_base);
            this.f14542b = (LongExposureItemFrame) view.findViewById(R.id_renamed.long_exposure_item_frame);
            this.f14543c = (RoundImageView) view.findViewById(R.id_renamed.long_exposure_item_iv);
            this.f14544d = (TextView) view.findViewById(R.id_renamed.long_exposure_item_text);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14567a(boolean z) {
        this.f14536d = z;
    }
}
