package com.oplus.camera.doubleexposure;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.widget.RoundRingImageView;
import java.util.List;

/* compiled from: EffectMenuAdapter.java */
/* renamed from: com.oplus.camera.doubleexposure.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class EffectMenuAdapter extends RecyclerView.AbstractC0685a<PlatformImplementations.kt_3> {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f13189a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private List<EffectType> f13190b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private EffectType f13191c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private IntrinsicsJvm.kt_4 f13192d = null;

    /* compiled from: EffectMenuAdapter.java */
    /* renamed from: com.oplus.camera.doubleexposure.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12921a(EffectType c2687f);
    }

    public EffectMenuAdapter(Context context, List<EffectType> list) {
        this.f13189a = null;
        this.f13190b = null;
        this.f13189a = context;
        this.f13190b = list;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12920a(IntrinsicsJvm.kt_4 bVar) {
        this.f13192d = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PlatformImplementations.kt_3 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(LayoutInflater.from(this.f13189a).inflate(R.layout.item_effect_menu, (ViewGroup) null, false));
        aVar.setIsRecyclable(false);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13) {
        final EffectType c2687f = this.f13190b.get(OplusGLSurfaceView_13);
        aVar.f13195a.setBitmap(BitmapFactory.decodeResource(this.f13189a.getResources(), c2687f.m12924b()));
        aVar.f13195a.setParam(c2687f);
        if (c2687f.m12926d()) {
            this.f13191c = c2687f;
        }
        aVar.f13195a.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.doubleexposure.COUIBaseListPopupWindow_8.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c2687f.m12926d()) {
                    return;
                }
                c2687f.m12923a(true);
                if (EffectMenuAdapter.this.f13191c != null) {
                    EffectMenuAdapter.this.f13191c.m12923a(false);
                }
                EffectMenuAdapter.this.f13191c = c2687f;
                EffectMenuAdapter.this.notifyDataSetChanged();
                if (EffectMenuAdapter.this.f13192d != null) {
                    EffectMenuAdapter.this.f13192d.mo12921a(c2687f);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        List<EffectType> list = this.f13190b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* compiled from: EffectMenuAdapter.java */
    /* renamed from: com.oplus.camera.doubleexposure.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0707w {

        /* renamed from: PlatformImplementations.kt_3 */
        RoundRingImageView f13195a;

        public PlatformImplementations.kt_3(View view) {
            super(view);
            this.f13195a = (RoundRingImageView) view.findViewById(R.id_renamed.bgIv);
        }
    }
}
