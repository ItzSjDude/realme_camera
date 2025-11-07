package com.oplus.camera.photo3d.p159ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.longexposure.LongExposureItemBaseView;
import com.oplus.camera.longexposure.LongExposureItemFrame;
import com.oplus.camera.util.Util;
import java.util.List;

/* compiled from: SceneMenuAdapter.java */
/* renamed from: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class SceneMenuAdapter extends RecyclerView.AbstractC0685a<IntrinsicsJvm.kt_4> {

    /* renamed from: PlatformImplementations.kt_3 */
    private List<SceneItem> f15307a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f15308b = true;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Context f15309c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PlatformImplementations.kt_3 f15310d;

    /* compiled from: SceneMenuAdapter.java */
    /* renamed from: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15294a(SceneItem c2873d);
    }

    public SceneMenuAdapter(Context context, List<SceneItem> list) {
        this.f15309c = context;
        this.f15307a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public IntrinsicsJvm.kt_4 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.camera_3d_photo_scene_menu_item, viewGroup, false));
        bVar.setIsRecyclable(true);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final IntrinsicsJvm.kt_4 bVar, final int OplusGLSurfaceView_13) {
        if (!this.f15308b) {
            CameraLog.m12959b("EffectMenuAdapter", "onBindViewHolder, return for not enable");
            return;
        }
        final SceneItem c2873d = this.f15307a.get(OplusGLSurfaceView_13);
        bVar.f15316b.setText(c2873d.m15279b());
        bVar.f15316b.setTextSize(0, this.f15309c.getResources().getDimension(R.dimen.long_exposure_item_text_size));
        bVar.f15316b.setTypeface(Util.m24411c(true));
        bVar.f15316b.setShadowLayer(this.f15309c.getResources().getDimension(R.dimen.long_exposure_scene_text_radius_shadow), 0.0f, 0.0f, this.f15309c.getResources().getColor(R.color.color_black_with_30_percent_transparency));
        bVar.f15315a.setGifResource(c2873d.m15280c());
        bVar.f15315a.setSelected(c2873d.m15281d());
        bVar.itemView.setSelected(c2873d.m15281d());
        bVar.f15317c.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_12.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                CameraLog.m12954a("EffectMenuAdapter", "mBaseView, event: " + motionEvent.getAction());
                if (SceneMenuAdapter.this.f15308b) {
                    if (1 == motionEvent.getAction()) {
                        c2873d.m15278a(true);
                        for (int i2 = 0; i2 < SceneMenuAdapter.this.f15307a.size(); i2++) {
                            if (OplusGLSurfaceView_13 != i2) {
                                ((SceneItem) SceneMenuAdapter.this.f15307a.get(i2)).m15278a(false);
                            }
                        }
                        SceneMenuAdapter.this.notifyDataSetChanged();
                        if (SceneMenuAdapter.this.f15310d != null) {
                            SceneMenuAdapter.this.f15310d.mo15294a(c2873d);
                        }
                    }
                    bVar.f15317c.onTouchEvent(motionEvent);
                }
                return true;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        List<SceneItem> list = this.f15307a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* compiled from: SceneMenuAdapter.java */
    /* renamed from: com.oplus.camera.photo3d.ui.COUIBaseListPopupWindow_12$IntrinsicsJvm.kt_4 */
    public class IntrinsicsJvm.kt_4 extends RecyclerView.AbstractC0707w {

        /* renamed from: PlatformImplementations.kt_3 */
        GifView f15315a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        TextView f15316b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        LongExposureItemBaseView f15317c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        LongExposureItemFrame f15318d;

        public IntrinsicsJvm.kt_4(View view) {
            super(view);
            this.f15317c = (LongExposureItemBaseView) view.findViewById(R.id_renamed.camera_3d_photo_item_base);
            this.f15318d = (LongExposureItemFrame) view.findViewById(R.id_renamed.camera_3d_photo_item_frame);
            this.f15315a = (GifView) view.findViewById(R.id_renamed.camera_3d_photo_item_gif);
            this.f15316b = (TextView) view.findViewById(R.id_renamed.camera_3d_photo_item_text);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15300a(PlatformImplementations.kt_3 aVar) {
        this.f15310d = aVar;
    }
}
