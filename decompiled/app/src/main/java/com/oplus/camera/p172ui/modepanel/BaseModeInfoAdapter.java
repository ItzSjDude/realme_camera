package com.oplus.camera.p172ui.modepanel;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.AbstractC0707w;
import com.oplus.camera.screen.p163a.OutCaptureManager;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseModeInfoAdapter.java */
/* renamed from: com.oplus.camera.ui.modepanel.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public abstract class BaseModeInfoAdapter<V extends RecyclerView.AbstractC0707w> extends RecyclerView.AbstractC0685a {

    /* renamed from: PlatformImplementations.kt_3 */
    protected Activity f20497a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ArrayList<ModeInfo> f20498b = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ArrayList<ModeInfo> f20499c = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ArrayList<Integer> f20500d = new ArrayList<>();

    public BaseModeInfoAdapter(Activity activity) {
        this.f20497a = null;
        this.f20497a = activity;
        Util.m24489q(this.f20497a);
        this.f20500d.add(20);
        this.f20500d.add(21);
        this.f20500d.add(5);
        this.f20500d.add(22);
        this.f20500d.add(25);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ArrayList<ModeInfo> m21767a() {
        this.f20499c.clear();
        Iterator<ModeInfo> it = this.f20498b.iterator();
        while (it.hasNext()) {
            ModeInfo next = it.next();
            if (this.f20500d.contains(Integer.valueOf(next.m21922b()))) {
                this.f20499c.add(next);
            }
        }
        return this.f20499c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21772a(List<ModeInfo> list) {
        this.f20498b.clear();
        this.f20498b.addAll(list);
        m21767a();
        notifyDataSetChanged();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21770a(int OplusGLSurfaceView_13, ModeInfo c3353k) {
        m21771a(OplusGLSurfaceView_13, Collections.singletonList(c3353k));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21771a(int OplusGLSurfaceView_13, List<ModeInfo> list) {
        m21775b(OplusGLSurfaceView_13, list);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m21775b(int OplusGLSurfaceView_13, List<? extends ModeInfo> list) {
        if (OutCaptureManager.m16423g()) {
            this.f20498b.addAll(m21766c(OplusGLSurfaceView_13), list);
        } else {
            this.f20498b.addAll(OplusGLSurfaceView_13, list);
        }
        m21767a();
        notifyItemInserted(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21769a(int OplusGLSurfaceView_13, int i2) {
        if (OutCaptureManager.m16423g()) {
            this.f20498b.add(m21766c(i2), this.f20498b.remove(m21766c(OplusGLSurfaceView_13)));
        } else {
            ArrayList<ModeInfo> arrayList = this.f20498b;
            arrayList.add(i2, arrayList.remove(OplusGLSurfaceView_13));
        }
        m21767a();
        notifyItemMoved(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21768a(int OplusGLSurfaceView_13) {
        if (OutCaptureManager.m16423g()) {
            this.f20498b.remove(m21766c(OplusGLSurfaceView_13));
        } else {
            this.f20498b.remove(OplusGLSurfaceView_13);
        }
        m21767a();
        notifyItemRangeRemoved(OplusGLSurfaceView_13, 1);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m21766c(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f20499c.size()) {
            return this.f20498b.size();
        }
        return this.f20498b.indexOf(this.f20499c.get(OplusGLSurfaceView_13));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<ModeInfo> m21774b() {
        return OutCaptureManager.m16423g() ? this.f20499c : this.f20498b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public List<ModeInfo> m21776c() {
        return this.f20498b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public ModeInfo m21773b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < m21774b().size()) {
            return m21774b().get(OplusGLSurfaceView_13);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        return m21774b().size();
    }
}
