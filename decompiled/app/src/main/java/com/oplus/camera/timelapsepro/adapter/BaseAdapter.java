package com.oplus.camera.timelapsepro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.timelapsepro.adapter.BaseViewHolder;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseAdapter.java */
/* renamed from: com.oplus.camera.timelapsepro.adapter.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class BaseAdapter<VH extends BaseViewHolder, T> extends RecyclerView.AbstractC0685a<VH> {

    /* renamed from: PlatformImplementations.kt_3 */
    protected Context f16748a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected List<T> f16749b = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected int f16750c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected int f16751d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean f16752e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private long f16753f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f16754g;

    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo17479a(int OplusGLSurfaceView_13, VH vh) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract void mo17471a(int OplusGLSurfaceView_13, VH vh, T t);

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo17477b(int OplusGLSurfaceView_13, VH vh) {
    }

    public BaseAdapter(Context context, int OplusGLSurfaceView_13) {
        this.f16748a = context;
        this.f16754g = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo17470a() {
        this.f16748a = null;
        this.f16749b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public VH onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        return (VH) m17485a(this.f16754g != 0 ? LayoutInflater.from(this.f16748a).inflate(this.f16754g, viewGroup, false) : m17491b());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected View m17491b() {
        return new RelativeLayout(this.f16748a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private VH m17485a(View view) {
        try {
            ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
            if (parameterizedType == null) {
                return null;
            }
            return (VH) ((Class) parameterizedType.getActualTypeArguments()[0]).getConstructor(View.class).newInstance(view);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final VH vh, final int OplusGLSurfaceView_13) {
        mo17471a(OplusGLSurfaceView_13, (int) vh, (VH) this.f16749b.get(OplusGLSurfaceView_13));
        if (this.f16749b.size() > 0) {
            mo17479a(OplusGLSurfaceView_13, (int) vh);
            vh.setItemClickCallback(new View.OnClickListener() { // from class: com.oplus.camera.timelapsepro.adapter.-$$Lambda$PlatformImplementations.kt_3$M4ON2kimgP3u2ohzJrZxc0WNbvM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.COUIBaseListPopupWindow_12$0.m17486a(OplusGLSurfaceView_13, vh, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m17486a(int OplusGLSurfaceView_13, BaseViewHolder baseViewHolder, View view) {
        if (100 < System.currentTimeMillis() - this.f16753f || System.currentTimeMillis() <= this.f16753f) {
            this.f16753f = System.currentTimeMillis();
            mo17477b(OplusGLSurfaceView_13, baseViewHolder);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17488a(BaseScreenMode abstractC2934a, int OplusGLSurfaceView_13, int i2) {
        this.f16750c = OplusGLSurfaceView_13;
        this.f16751d = i2;
        this.f16752e = abstractC2934a.mo16631r() && abstractC2934a.mo16630q();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        return this.f16749b.size();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17490a(List<T> list) {
        this.f16749b = list;
        notifyDataSetChanged();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<T> m17492c() {
        return this.f16749b;
    }
}
