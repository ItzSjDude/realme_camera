package com.oplus.camera.p172ui.modepanel;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotateMoreItem;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: MoreModeAdapter.java */
/* renamed from: com.oplus.camera.ui.modepanel.o */
/* loaded from: classes2.dex */
public class MoreModeAdapter extends BaseModeInfoAdapter<IntrinsicsJvm.kt_4> {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final String f20622b = "o";

    /* renamed from: IntrinsicsJvm.kt_3 */
    private PlatformImplementations.kt_3 f20623c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20624d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f20625e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f20626f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f20627g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f20628h;

    /* compiled from: MoreModeAdapter.java */
    /* renamed from: com.oplus.camera.ui.modepanel.o$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo21993a(int OplusGLSurfaceView_13);
    }

    public MoreModeAdapter(Activity activity, int OplusGLSurfaceView_13) {
        super(activity);
        this.f20623c = null;
        this.f20624d = 0;
        this.f20626f = false;
        this.f20627g = R.layout.more_mode_item;
        this.f20628h = 0;
        this.f20625e = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21987a(ArrayList<ModeInfo> arrayList, boolean z) {
        super.m21772a(arrayList);
        if (z) {
            this.f20624d = this.f20625e;
            return;
        }
        int OplusGLSurfaceView_13 = this.f20625e;
        if (OplusGLSurfaceView_13 == 0) {
            this.f20624d = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21986a(PlatformImplementations.kt_3 aVar) {
        this.f20623c = aVar;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21989c(int OplusGLSurfaceView_13) {
        int i2 = this.f20625e;
        if (i2 == OplusGLSurfaceView_13) {
            return;
        }
        this.f20624d = i2;
        this.f20625e = OplusGLSurfaceView_13;
        if (this.f20626f) {
            return;
        }
        notifyDataSetChanged();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21991d(int OplusGLSurfaceView_13) {
        this.f20624d = OplusGLSurfaceView_13;
        this.f20625e = OplusGLSurfaceView_13;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public IntrinsicsJvm.kt_4 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        CameraLog.m12959b(f20622b, "onCreateViewHolder, mMoreModeItemID: " + this.f20627g);
        return new IntrinsicsJvm.kt_4(LayoutInflater.from(this.f20497a).inflate(this.f20627g, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public void onBindViewHolder(RecyclerView.AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13) {
        m21982a((IntrinsicsJvm.kt_4) abstractC0707w, OplusGLSurfaceView_13, Collections.EMPTY_LIST);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21982a(IntrinsicsJvm.kt_4 bVar, int OplusGLSurfaceView_13, List list) {
        if (bVar.f20630b == null) {
            return;
        }
        ModeInfo c3353kB = m21773b(OplusGLSurfaceView_13);
        bVar.f20630b.setImage(Util.m24216a(this.f20497a.getBaseContext(), c3353kB.m21925c()));
        if (-1 == c3353kB.m21928d() || this.f20626f) {
            bVar.f20630b.setSubscriptHint(null);
        } else if (!bVar.f20630b.m18356a()) {
            bVar.f20630b.setSubscriptHintRTL(1 == this.f20497a.getApplicationContext().getResources().getConfiguration().getLayoutDirection());
            bVar.f20630b.setSubscriptHint(BitmapFactory.decodeResource(this.f20497a.getResources(), c3353kB.m21928d()));
        }
        if (this.f20626f) {
            bVar.f20630b.m18355a(bVar.f20630b.getTargetDegree() != 0 ? this.f20625e : 0, 0);
        } else {
            bVar.f20630b.m18355a(this.f20624d, this.f20625e);
        }
        bVar.f20630b.setText(c3353kB.m21919a());
        bVar.itemView.setVisibility(c3353kB.m21930e());
        bVar.itemView.setTag(R.id_renamed.tag_recycle_view_mode_info, c3353kB);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21988a(boolean z) {
        this.f20626f = z;
    }

    /* compiled from: MoreModeAdapter.java */
    /* renamed from: com.oplus.camera.ui.modepanel.o$IntrinsicsJvm.kt_4 */
    public class IntrinsicsJvm.kt_4 extends RecyclerView.AbstractC0707w implements View.OnClickListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private RotateMoreItem f20630b;

        public IntrinsicsJvm.kt_4(View view) {
            super(view);
            this.f20630b = (RotateMoreItem) view.findViewById(R.id_renamed.more_item);
            view.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MoreModeAdapter.this.f20626f) {
                return;
            }
            MoreModeAdapter.this.f20623c.mo21993a(((ModeInfo) view.getTag(R.id_renamed.tag_recycle_view_mode_info)).m21922b());
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m21992e(int OplusGLSurfaceView_13) {
        this.f20628h = OplusGLSurfaceView_13;
        CameraLog.m12959b(f20622b, "setLayoutMode: " + this.f20628h);
        if (OplusGLSurfaceView_13 == 1) {
            this.f20627g = R.layout.more_mode_item_vertical;
        } else {
            this.f20627g = R.layout.more_mode_item;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m21990d() {
        this.f20497a = null;
        this.f20623c = null;
    }
}
