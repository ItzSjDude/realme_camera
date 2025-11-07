package com.oplus.camera.timelapsepro.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.menu.facebeauty.TabContainerTextView;
import com.oplus.camera.timelapsepro.p170a.SubMenuInfo;

/* loaded from: classes2.dex */
public class SubSettingAdapter extends BaseAdapter<SubSettingHolder, SubMenuInfo> {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private InterfaceC3063a f16746f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16747g;

    /* renamed from: com.oplus.camera.timelapsepro.adapter.SubSettingAdapter$PlatformImplementations.kt_3 */
    public interface InterfaceC3063a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17484a(int OplusGLSurfaceView_13, SubMenuInfo c3056j);
    }

    public SubSettingAdapter(Context context) {
        super(context, R.layout.item_time_lapse_pro_sub_setting);
        this.f16746f = null;
        this.f16747g = 0;
    }

    @Override // com.oplus.camera.timelapsepro.adapter.BaseAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17470a() {
        this.f16746f = null;
        super.mo17470a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.BaseAdapter
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void mo17471a(int OplusGLSurfaceView_13, SubSettingHolder subSettingHolder, SubMenuInfo c3056j) throws Resources.NotFoundException {
        boolean z = false;
        ((RecyclerView.C0694j) subSettingHolder.name.getLayoutParams()).leftMargin = 0;
        ((RecyclerView.C0694j) subSettingHolder.name.getLayoutParams()).rightMargin = 0;
        if (this.f16750c == 1) {
            subSettingHolder.name.setMaxWidth(this.f16748a.getResources().getDimensionPixelSize(R.dimen.setting_item_w_full_max));
            if (this.f16747g > 0) {
                int width = subSettingHolder.name.getWidth();
                int i2 = this.f16747g;
                if (width < i2) {
                    int width2 = (i2 - subSettingHolder.name.getWidth()) / 2;
                    if (width2 < 0) {
                        width2 = 0;
                    }
                    ((RecyclerView.C0694j) subSettingHolder.name.getLayoutParams()).leftMargin = width2;
                    ((RecyclerView.C0694j) subSettingHolder.name.getLayoutParams()).rightMargin = width2;
                }
            }
        }
        m17478a(subSettingHolder.name.getWidth());
        subSettingHolder.name.setText(c3056j.f16735a);
        TabContainerTextView tabContainerTextView = subSettingHolder.name;
        if (1 == this.f16750c || (4 == this.f16750c && !this.f16752e)) {
            z = true;
        }
        tabContainerTextView.setLightBgColor(z);
        subSettingHolder.name.setSelected(c3056j.f16736b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.BaseAdapter
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void mo17479a(int OplusGLSurfaceView_13, SubSettingHolder subSettingHolder) {
        super.mo17479a(OplusGLSurfaceView_13, (int) subSettingHolder);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17478a(int OplusGLSurfaceView_13) {
        this.f16747g = Math.max(this.f16747g, OplusGLSurfaceView_13);
    }

    public static class SubSettingHolder extends BaseViewHolder {
        final TabContainerTextView name;

        public SubSettingHolder(View view) {
            super(view);
            this.name = (TabContainerTextView) view.findViewById(R.id_renamed.sub_menu_name);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.BaseAdapter
    /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
    public void mo17477b(int OplusGLSurfaceView_13, SubSettingHolder subSettingHolder) {
        super.mo17477b(OplusGLSurfaceView_13, (int) subSettingHolder);
        InterfaceC3063a interfaceC3063a = this.f16746f;
        if (interfaceC3063a != null) {
            interfaceC3063a.mo17484a(OplusGLSurfaceView_13, (SubMenuInfo) this.f16749b.get(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17482a(InterfaceC3063a interfaceC3063a) {
        this.f16746f = interfaceC3063a;
    }
}
