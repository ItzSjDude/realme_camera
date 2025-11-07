package com.oplus.camera.timelapsepro.adapter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.R;
import com.oplus.camera.timelapsepro.ParameterItem;
import com.oplus.camera.timelapsepro.p170a.ProParameter;

/* loaded from: classes2.dex */
public class ParamsAdapter extends BaseAdapter<ParamsHolder, ProParameter> {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final ProParameter.IntrinsicsJvm.kt_4 f16743f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private InterfaceC3061a f16744g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private InterfaceC3062b f16745h;

    /* renamed from: com.oplus.camera.timelapsepro.adapter.ParamsAdapter$PlatformImplementations.kt_3 */
    public interface InterfaceC3061a {
        void clickItem(int OplusGLSurfaceView_13, ProParameter abstractC3051e);
    }

    /* renamed from: com.oplus.camera.timelapsepro.adapter.ParamsAdapter$IntrinsicsJvm.kt_4 */
    public interface InterfaceC3062b {
        void onValueChanged(int OplusGLSurfaceView_13, int i2);
    }

    public ParamsAdapter(Context context) {
        super(context, R.layout.item_time_lapse_pro_params);
        this.f16743f = new ProParameter.IntrinsicsJvm.kt_4() { // from class: com.oplus.camera.timelapsepro.adapter.-$$Lambda$ParamsAdapter$hmX2B9795Eoq8y9ecknbxT_K6XI
            @Override // com.oplus.camera.timelapsepro.p170a.ProParameter.IntrinsicsJvm.kt_4
            public final void onValueChange(int OplusGLSurfaceView_13, int i2) {
                this.COUIBaseListPopupWindow_12$0.m17469a(OplusGLSurfaceView_13, i2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m17469a(int OplusGLSurfaceView_13, int i2) {
        InterfaceC3062b interfaceC3062b = this.f16745h;
        if (interfaceC3062b != null) {
            interfaceC3062b.onValueChanged(OplusGLSurfaceView_13, i2);
        }
    }

    @Override // com.oplus.camera.timelapsepro.adapter.BaseAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17470a() {
        this.f16744g = null;
        this.f16745h = null;
        super.mo17470a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.BaseAdapter
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void mo17471a(int OplusGLSurfaceView_13, ParamsHolder paramsHolder, ProParameter abstractC3051e) {
        ((RecyclerView.C0694j) paramsHolder.item.getLayoutParams()).topMargin = (OplusGLSurfaceView_13 == 0 && 1 == this.f16750c) ? this.f16748a.getResources().getDimensionPixelOffset(R.dimen.time_lapse_pro_params_item_margin_top_vertical) : 0;
        paramsHolder.item.m17388a(this.f16750c, this.f16751d, this.f16752e);
        paramsHolder.item.m17389a(abstractC3051e, (OplusGLSurfaceView_13 == 0 || 3 == OplusGLSurfaceView_13) ? null : this.f16743f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(ParamsHolder paramsHolder) {
        super.onViewDetachedFromWindow(paramsHolder);
        paramsHolder.item.m17387a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.oplus.camera.timelapsepro.adapter.BaseAdapter
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void mo17477b(int OplusGLSurfaceView_13, ParamsHolder paramsHolder) {
        super.mo17477b(OplusGLSurfaceView_13, paramsHolder);
        if (OplusGLSurfaceView_13 == 0) {
            paramsHolder.item.m17390b();
        }
        InterfaceC3061a interfaceC3061a = this.f16744g;
        if (interfaceC3061a != null) {
            interfaceC3061a.clickItem(OplusGLSurfaceView_13, (ProParameter) this.f16749b.get(OplusGLSurfaceView_13));
        }
    }

    static class ParamsHolder extends BaseViewHolder {
        final ParameterItem item;

        public ParamsHolder(View view) {
            super(view);
            this.item = (ParameterItem) view.findViewById(R.id_renamed.item);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17475a(InterfaceC3061a interfaceC3061a) {
        this.f16744g = interfaceC3061a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17476a(InterfaceC3062b interfaceC3062b) {
        this.f16745h = interfaceC3062b;
    }
}
