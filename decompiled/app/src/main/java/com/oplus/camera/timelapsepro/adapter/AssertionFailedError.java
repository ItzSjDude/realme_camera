package com.oplus.camera.timelapsepro.adapter;

/* compiled from: TemplateAdapter.java */
/* loaded from: classes2.dex */
public class b_renamed extends com.oplus.camera.timelapsepro.adapter.a_renamed<com.oplus.camera.timelapsepro.adapter.TemplateViewHolder, com.oplus.camera.timelapsepro.a_renamed.k_renamed> {
    private com.oplus.camera.timelapsepro.adapter.b_renamed.a_renamed f_renamed;

    /* compiled from: TemplateAdapter.java */
    public interface a_renamed {
        void a_renamed(int i_renamed, com.oplus.camera.timelapsepro.a_renamed.k_renamed kVar);
    }

    public b_renamed(android.content.Context context) {
        super(context, com.oplus.camera.R_renamed.layout.item_time_lapse_pro_template);
        this.f_renamed = null;
    }

    @Override // com.oplus.camera.timelapsepro.adapter.a_renamed
    public void a_renamed() {
        this.f_renamed = null;
        super.a_renamed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.a_renamed
    public void a_renamed(int i_renamed, com.oplus.camera.timelapsepro.adapter.TemplateViewHolder templateViewHolder, com.oplus.camera.timelapsepro.a_renamed.k_renamed kVar) {
        android.view.ViewGroup.LayoutParams layoutParams = templateViewHolder.mIconSelect.getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutParams2 = templateViewHolder.mIconBg.getLayoutParams();
        androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) templateViewHolder.itemView.getLayoutParams();
        int i2 = this.f5657c;
        if (i2 == 1) {
            templateViewHolder.mIconBg.setSelected(true);
            layoutParams.width = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_48dp);
            layoutParams.height = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_48dp);
            layoutParams2.width = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_40dp);
            layoutParams2.height = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_40dp);
            jVar.height = this.f5655a.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.template_item_h_full);
        } else if (i2 == 2 || i2 == 3) {
            templateViewHolder.mIconBg.setSelected(false);
            layoutParams.width = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_54dp);
            layoutParams.height = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_54dp);
            layoutParams2.width = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_46dp);
            layoutParams2.height = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_46dp);
            jVar.height = this.f5655a.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.template_item_h);
        } else if (i2 == 4) {
            templateViewHolder.mIconBg.setSelected(!this.e_renamed);
            layoutParams.width = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_54dp);
            layoutParams.height = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_54dp);
            layoutParams2.width = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_46dp);
            layoutParams2.height = this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.template_vec_size_46dp);
            jVar.height = this.f5655a.getResources().getDimensionPixelOffset(com.oplus.camera.R_renamed.dimen.template_item_h);
        }
        templateViewHolder.setSelected(kVar.c_renamed(), i_renamed == 0);
        templateViewHolder.setImageSource(kVar.a_renamed());
        templateViewHolder.setName(kVar.b_renamed());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.a_renamed
    public void a_renamed(int i_renamed, com.oplus.camera.timelapsepro.adapter.TemplateViewHolder templateViewHolder) {
        super.a_renamed(i_renamed, (int) templateViewHolder);
        templateViewHolder.setItemTouchListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.a_renamed
    public void b_renamed(int i_renamed, com.oplus.camera.timelapsepro.adapter.TemplateViewHolder templateViewHolder) {
        super.b_renamed(i_renamed, (int) templateViewHolder);
        com.oplus.camera.timelapsepro.adapter.b_renamed.a_renamed aVar = this.f_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed, (com.oplus.camera.timelapsepro.a_renamed.k_renamed) this.f5656b.get(i_renamed));
        }
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.timelapsepro.adapter.b_renamed.a_renamed aVar = this.f_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed, (com.oplus.camera.timelapsepro.a_renamed.k_renamed) this.f5656b.get(i_renamed));
        }
    }

    public void a_renamed(com.oplus.camera.timelapsepro.adapter.b_renamed.a_renamed aVar) {
        this.f_renamed = aVar;
    }
}
