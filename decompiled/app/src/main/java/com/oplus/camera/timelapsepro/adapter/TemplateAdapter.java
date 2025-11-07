package com.oplus.camera.timelapsepro.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.R;
import com.oplus.camera.timelapsepro.p170a.TemplateInfo;

/* compiled from: TemplateAdapter.java */
/* renamed from: com.oplus.camera.timelapsepro.adapter.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class TemplateAdapter extends BaseAdapter<TemplateViewHolder, TemplateInfo> {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PlatformImplementations.kt_3 f16755f;

    /* compiled from: TemplateAdapter.java */
    /* renamed from: com.oplus.camera.timelapsepro.adapter.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17498a(int OplusGLSurfaceView_13, TemplateInfo c3057k);
    }

    public TemplateAdapter(Context context) {
        super(context, R.layout.item_time_lapse_pro_template);
        this.f16755f = null;
    }

    @Override // com.oplus.camera.timelapsepro.adapter.BaseAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17470a() {
        this.f16755f = null;
        super.mo17470a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.BaseAdapter
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void mo17471a(int OplusGLSurfaceView_13, TemplateViewHolder templateViewHolder, TemplateInfo c3057k) {
        ViewGroup.LayoutParams layoutParams = templateViewHolder.mIconSelect.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = templateViewHolder.mIconBg.getLayoutParams();
        RecyclerView.C0694j c0694j = (RecyclerView.C0694j) templateViewHolder.itemView.getLayoutParams();
        int i2 = this.f16750c;
        if (i2 == 1) {
            templateViewHolder.mIconBg.setSelected(true);
            layoutParams.width = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_48dp);
            layoutParams.height = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_48dp);
            layoutParams2.width = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_40dp);
            layoutParams2.height = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_40dp);
            c0694j.height = this.f16748a.getResources().getDimensionPixelOffset(R.dimen.template_item_h_full);
        } else if (i2 == 2 || i2 == 3) {
            templateViewHolder.mIconBg.setSelected(false);
            layoutParams.width = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_54dp);
            layoutParams.height = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_54dp);
            layoutParams2.width = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_46dp);
            layoutParams2.height = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_46dp);
            c0694j.height = this.f16748a.getResources().getDimensionPixelOffset(R.dimen.template_item_h);
        } else if (i2 == 4) {
            templateViewHolder.mIconBg.setSelected(!this.f16752e);
            layoutParams.width = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_54dp);
            layoutParams.height = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_54dp);
            layoutParams2.width = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_46dp);
            layoutParams2.height = this.f16748a.getResources().getDimensionPixelSize(R.dimen.template_vec_size_46dp);
            c0694j.height = this.f16748a.getResources().getDimensionPixelOffset(R.dimen.template_item_h);
        }
        templateViewHolder.setSelected(c3057k.m17468c(), OplusGLSurfaceView_13 == 0);
        templateViewHolder.setImageSource(c3057k.m17465a());
        templateViewHolder.setName(c3057k.m17467b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.BaseAdapter
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void mo17479a(int OplusGLSurfaceView_13, TemplateViewHolder templateViewHolder) {
        super.mo17479a(OplusGLSurfaceView_13, (int) templateViewHolder);
        templateViewHolder.setItemTouchListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.BaseAdapter
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public void mo17477b(int OplusGLSurfaceView_13, TemplateViewHolder templateViewHolder) {
        super.mo17477b(OplusGLSurfaceView_13, (int) templateViewHolder);
        PlatformImplementations.kt_3 aVar = this.f16755f;
        if (aVar != null) {
            aVar.mo17498a(OplusGLSurfaceView_13, (TemplateInfo) this.f16749b.get(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17493a(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = this.f16755f;
        if (aVar != null) {
            aVar.mo17498a(OplusGLSurfaceView_13, (TemplateInfo) this.f16749b.get(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17496a(PlatformImplementations.kt_3 aVar) {
        this.f16755f = aVar;
    }
}
