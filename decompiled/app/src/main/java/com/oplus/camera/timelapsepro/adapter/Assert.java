package com.oplus.camera.timelapsepro.adapter;

/* loaded from: classes2.dex */
public class SubSettingAdapter extends com.oplus.camera.timelapsepro.adapter.a_renamed<com.oplus.camera.timelapsepro.adapter.SubSettingAdapter.SubSettingHolder, com.oplus.camera.timelapsepro.a_renamed.j_renamed> {
    private com.oplus.camera.timelapsepro.adapter.SubSettingAdapter.a_renamed f_renamed;
    private int g_renamed;

    public interface a_renamed {
        void a_renamed(int i_renamed, com.oplus.camera.timelapsepro.a_renamed.j_renamed jVar);
    }

    public SubSettingAdapter(android.content.Context context) {
        super(context, com.oplus.camera.R_renamed.layout.item_time_lapse_pro_sub_setting);
        this.f_renamed = null;
        this.g_renamed = 0;
    }

    @Override // com.oplus.camera.timelapsepro.adapter.a_renamed
    public void a_renamed() {
        this.f_renamed = null;
        super.a_renamed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.a_renamed
    public void a_renamed(int i_renamed, com.oplus.camera.timelapsepro.adapter.SubSettingAdapter.SubSettingHolder subSettingHolder, com.oplus.camera.timelapsepro.a_renamed.j_renamed jVar) throws android.content.res.Resources.NotFoundException {
        boolean z_renamed = false;
        ((androidx.recyclerview.widget.RecyclerView.j_renamed) subSettingHolder.name.getLayoutParams()).leftMargin = 0;
        ((androidx.recyclerview.widget.RecyclerView.j_renamed) subSettingHolder.name.getLayoutParams()).rightMargin = 0;
        if (this.f5657c == 1) {
            subSettingHolder.name.setMaxWidth(this.f5655a.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.setting_item_w_full_max));
            if (this.g_renamed > 0) {
                int width = subSettingHolder.name.getWidth();
                int i2 = this.g_renamed;
                if (width < i2) {
                    int width2 = (i2 - subSettingHolder.name.getWidth()) / 2;
                    if (width2 < 0) {
                        width2 = 0;
                    }
                    ((androidx.recyclerview.widget.RecyclerView.j_renamed) subSettingHolder.name.getLayoutParams()).leftMargin = width2;
                    ((androidx.recyclerview.widget.RecyclerView.j_renamed) subSettingHolder.name.getLayoutParams()).rightMargin = width2;
                }
            }
        }
        a_renamed(subSettingHolder.name.getWidth());
        subSettingHolder.name.setText(jVar.f5650a);
        com.oplus.camera.ui.menu.facebeauty.TabContainerTextView tabContainerTextView = subSettingHolder.name;
        if (1 == this.f5657c || (4 == this.f5657c && !this.e_renamed)) {
            z_renamed = true;
        }
        tabContainerTextView.setLightBgColor(z_renamed);
        subSettingHolder.name.setSelected(jVar.f5651b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.a_renamed
    public void a_renamed(int i_renamed, com.oplus.camera.timelapsepro.adapter.SubSettingAdapter.SubSettingHolder subSettingHolder) {
        super.a_renamed(i_renamed, (int) subSettingHolder);
    }

    public void a_renamed(int i_renamed) {
        this.g_renamed = java.lang.Math.max(this.g_renamed, i_renamed);
    }

    public static class SubSettingHolder extends com.oplus.camera.timelapsepro.adapter.BaseViewHolder {
        final com.oplus.camera.ui.menu.facebeauty.TabContainerTextView name;

        public SubSettingHolder(android.view.View view) {
            super(view);
            this.name = (com.oplus.camera.ui.menu.facebeauty.TabContainerTextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.sub_menu_name);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.a_renamed
    public void b_renamed(int i_renamed, com.oplus.camera.timelapsepro.adapter.SubSettingAdapter.SubSettingHolder subSettingHolder) {
        super.b_renamed(i_renamed, (int) subSettingHolder);
        com.oplus.camera.timelapsepro.adapter.SubSettingAdapter.a_renamed aVar = this.f_renamed;
        if (aVar != null) {
            aVar.a_renamed(i_renamed, (com.oplus.camera.timelapsepro.a_renamed.j_renamed) this.f5656b.get(i_renamed));
        }
    }

    public void a_renamed(com.oplus.camera.timelapsepro.adapter.SubSettingAdapter.a_renamed aVar) {
        this.f_renamed = aVar;
    }
}
