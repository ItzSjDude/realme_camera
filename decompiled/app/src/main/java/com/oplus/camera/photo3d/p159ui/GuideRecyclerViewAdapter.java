package com.oplus.camera.photo3d.p159ui;

import android.content.Context;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.widget.GuideTextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GuideRecyclerViewAdapter.java */
/* renamed from: com.oplus.camera.photo3d.ui.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class GuideRecyclerViewAdapter extends RecyclerView.AbstractC0685a<RecyclerView.AbstractC0707w> {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f15263a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private List<GuideItem> f15264b = new ArrayList(4);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private SparseArray<PlatformImplementations.kt_3> f15265c = new SparseArray<>(3);

    public GuideRecyclerViewAdapter(Context context) {
        this.f15263a = context;
        m15266a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15266a() {
        this.f15264b.add(new GuideItem(R.string.scene_dolly_zoom_title, R.string.scene_dolly_zoom_subtitle, R.drawable.cover_dolly_zoom, Uri.parse("android.resource://" + this.f15263a.getPackageName() + "/" + R.raw.guide_dolly_zoom)));
        this.f15264b.add(new GuideItem(R.string.scene_circle_title, R.string.scene_circle_subtitle, R.drawable.cover_circle, Uri.parse("android.resource://" + this.f15263a.getPackageName() + "/" + R.raw.guide_circle)));
        this.f15264b.add(new GuideItem(R.string.scene_swing_title, R.string.scene_swing_subtitle, R.drawable.cover_swing, Uri.parse("android.resource://" + this.f15263a.getPackageName() + "/" + R.raw.guide_swing)));
        this.f15264b.add(new GuideItem(R.string.scene_portrait_title, R.string.scene_portrait_subtitle, R.drawable.cover_portrait, Uri.parse("android.resource://" + this.f15263a.getPackageName() + "/" + R.raw.guide_portrait)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemViewType(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 1) {
            return 1;
        }
        return OplusGLSurfaceView_13 >= m15267b() + 1 ? 2 : 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public RecyclerView.AbstractC0707w onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        if (1 == OplusGLSurfaceView_13) {
            return new IntrinsicsJvm.kt_3(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.guide_header_item_3d_photo_layout, viewGroup, false));
        }
        if (2 == OplusGLSurfaceView_13) {
            return new IntrinsicsJvm.kt_4(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.guide_footer_item_3d_photo_layout, viewGroup, false));
        }
        return new PlatformImplementations.kt_3(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.guide_content_item_3d_photo_layout, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public void onBindViewHolder(RecyclerView.AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (3 == abstractC0707w.getItemViewType()) {
            final int i2 = OplusGLSurfaceView_13 - 1;
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) abstractC0707w;
            GuideItem c2870a = this.f15264b.get(i2);
            aVar.f15268a.setText(c2870a.m15260a());
            aVar.f15269b.setText(c2870a.m15261b());
            aVar.f15270c.setVideoCover(c2870a.m15262c());
            aVar.f15270c.setVideoURI(c2870a.m15263d());
            aVar.f15270c.setSelected(c2870a.m15264e());
            aVar.f15270c.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.photo3d.ui.IntrinsicsJvm.kt_4.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws IllegalStateException {
                    int i3 = 0;
                    while (i3 < GuideRecyclerViewAdapter.this.f15265c.size()) {
                        CameraLog.m12959b("VideoItemAdapter", "onClick, position: " + i2 + ", OplusGLSurfaceView_13: " + i3);
                        ((PlatformImplementations.kt_3) GuideRecyclerViewAdapter.this.f15265c.get(i3)).f15270c.setSelected(i2 == i3);
                        i3++;
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        return m15267b() + 1 + 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m15267b() {
        return this.f15264b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public void onViewAttachedToWindow(RecyclerView.AbstractC0707w abstractC0707w) {
        super.onViewAttachedToWindow(abstractC0707w);
        if (3 == abstractC0707w.getItemViewType()) {
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) abstractC0707w;
            this.f15265c.put(aVar.getLayoutPosition() - 1, aVar);
            aVar.f15270c.m15259b();
        }
    }

    /* compiled from: GuideRecyclerViewAdapter.java */
    /* renamed from: com.oplus.camera.photo3d.ui.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0707w {

        /* renamed from: PlatformImplementations.kt_3 */
        GuideTextView f15268a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        GuideTextView f15269b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        GuideVideoItemView f15270c;

        public PlatformImplementations.kt_3(View view) {
            super(view);
            this.f15268a = (GuideTextView) view.findViewById(R.id_renamed.guide_item_title);
            this.f15269b = (GuideTextView) view.findViewById(R.id_renamed.guide_item_subtitle);
            this.f15270c = (GuideVideoItemView) view.findViewById(R.id_renamed.guide_video_item);
            this.f15270c.setRatio(0.5625d);
        }
    }

    /* compiled from: GuideRecyclerViewAdapter.java */
    /* renamed from: com.oplus.camera.photo3d.ui.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_3 */
    public class IntrinsicsJvm.kt_3 extends RecyclerView.AbstractC0707w {
        public IntrinsicsJvm.kt_3(View view) {
            super(view);
        }
    }

    /* compiled from: GuideRecyclerViewAdapter.java */
    /* renamed from: com.oplus.camera.photo3d.ui.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    public class IntrinsicsJvm.kt_4 extends RecyclerView.AbstractC0707w {
        public IntrinsicsJvm.kt_4(View view) {
            super(view);
        }
    }
}
