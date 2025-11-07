package com.oplus.camera.p172ui.menu.facebeauty;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseMakeupItemView;
import com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyCustomMenu;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FaceBeautyAdapter.java */
/* renamed from: com.oplus.camera.ui.menu.facebeauty.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class FaceBeautyAdapter extends RecyclerView.AbstractC0685a<PlatformImplementations.kt_3> {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Context f19234d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private List<BeautyMenuItem> f19235e;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Paint f19238h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f19239i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f19240j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f19241k;

    /* renamed from: PlatformImplementations.kt_3 */
    private final PathInterpolator f19231a = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final PathInterpolator f19232b = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f19233c = -3;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private FaceBeautyCustomMenu.PlatformImplementations.kt_3 f19236f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private View.OnClickListener f19237g = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f19242l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f19243m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    private RecyclerView.AbstractC0693i f19244n = null;

    /* renamed from: o */
    private float f19245o = 0.0f;

    /* renamed from: p */
    private int f19246p = 0;

    /* renamed from: q */
    private AnimatorSet f19247q = null;

    public FaceBeautyAdapter(Context context) {
        this.f19234d = null;
        this.f19235e = null;
        this.f19238h = null;
        this.f19239i = 0;
        this.f19240j = 0.0f;
        this.f19241k = 0.0f;
        CameraLog.m12962c("FaceBeautyAdapter", "FaceBeautyAdapter, init FaceBeautyAdapter, this: " + this);
        this.f19235e = new ArrayList();
        this.f19234d = context;
        this.f19239i = context.getResources().getDimensionPixelSize(R.dimen.face_beauty_item_text_size);
        this.f19240j = r6.getDimensionPixelSize(R.dimen.face_beauty_item_width) - (r6.getDimensionPixelSize(R.dimen.face_beauty_menu_item_text_padding_start) * 2);
        this.f19238h = new Paint();
        this.f19238h.setTypeface(Util.m24411c(false));
        this.f19238h.setTextSize(this.f19239i);
        this.f19241k = this.f19239i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f19244n = recyclerView.getLayoutManager();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f19244n = null;
        super.onDetachedFromRecyclerView(recyclerView);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20540a(FaceBeautyCustomMenu.PlatformImplementations.kt_3 aVar) {
        this.f19236f = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20537a(View.OnClickListener onClickListener) {
        this.f19237g = onClickListener;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20543a(final boolean z, boolean z2) {
        if (this.f19242l == z) {
            return;
        }
        this.f19242l = z;
        RecyclerView.AbstractC0693i abstractC0693i = this.f19244n;
        if (abstractC0693i != null) {
            final View viewFindViewByPosition = abstractC0693i.findViewByPosition(0);
            if (viewFindViewByPosition != null) {
                AnimatorSet animatorSet = this.f19247q;
                if (animatorSet != null && animatorSet.isStarted()) {
                    this.f19247q.cancel();
                }
                ImageView imageView = (ImageView) viewFindViewByPosition.findViewById(R.id_renamed.iv_face_beauty_custom_reset);
                this.f19247q = new AnimatorSet();
                float[] fArr = new float[2];
                fArr[0] = z ? 1.0f : 0.3f;
                fArr[1] = z ? 0.3f : 1.0f;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "alpha", fArr);
                objectAnimatorOfFloat.setDuration(250L);
                objectAnimatorOfFloat.setInterpolator(this.f19232b);
                AnimatorSet.Builder builderPlay = this.f19247q.play(objectAnimatorOfFloat);
                if (z2) {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
                    objectAnimatorOfFloat2.setDuration(500L);
                    objectAnimatorOfFloat2.setInterpolator(this.f19231a);
                    builderPlay.with(objectAnimatorOfFloat2);
                } else {
                    imageView.setRotation(0.0f);
                }
                this.f19247q.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.IntrinsicsJvm.kt_3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        viewFindViewByPosition.setSelected(z);
                    }
                });
                this.f19247q.start();
                return;
            }
            notifyItemChanged(0);
            return;
        }
        notifyDataSetChanged();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20542a(boolean z) {
        this.f19243m = z;
        RecyclerView.AbstractC0693i abstractC0693i = this.f19244n;
        if (abstractC0693i != null) {
            View viewFindViewByPosition = abstractC0693i.findViewByPosition(1);
            if (viewFindViewByPosition != null) {
                viewFindViewByPosition.setSelected(z);
                return;
            }
            return;
        }
        notifyDataSetChanged();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20536a(int OplusGLSurfaceView_13) {
        this.f19246p = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20541a(List<BeautyMenuItem> list) {
        Iterator<BeautyMenuItem> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (this.f19238h.measureText(this.f19234d.getString(it.next().m20528a())) > this.f19240j) {
                this.f19241k = this.f19239i * 0.8f;
                break;
            }
        }
        if (!this.f19235e.isEmpty()) {
            this.f19235e.clear();
        }
        this.f19235e.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20544b(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("FaceBeautyAdapter", "onSelectPositionChange, this: " + this + ", newSelectIndex: " + OplusGLSurfaceView_13 + ", mSelectIndex: " + this.f19233c);
        int i2 = this.f19233c;
        if (i2 == OplusGLSurfaceView_13) {
            return;
        }
        RecyclerView.AbstractC0693i abstractC0693i = this.f19244n;
        if (abstractC0693i != null) {
            View viewFindViewByPosition = abstractC0693i.findViewByPosition(i2);
            View viewFindViewByPosition2 = this.f19244n.findViewByPosition(OplusGLSurfaceView_13);
            int i3 = this.f19233c;
            this.f19233c = OplusGLSurfaceView_13;
            if (viewFindViewByPosition != null) {
                viewFindViewByPosition.setSelected(false);
            } else if (i3 > 0) {
                notifyItemChanged(i3);
            }
            if (viewFindViewByPosition2 != null) {
                viewFindViewByPosition2.setSelected(true);
                return;
            } else {
                if (OplusGLSurfaceView_13 > 0) {
                    notifyItemChanged(OplusGLSurfaceView_13);
                    return;
                }
                return;
            }
        }
        this.f19233c = OplusGLSurfaceView_13;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PlatformImplementations.kt_3 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        int i2;
        boolean z = 1 == this.f19246p;
        int i3 = z ? R.layout.face_beauty_menu_item_vertical : R.layout.face_beauty_menu_item;
        if (OplusGLSurfaceView_13 == 1) {
            i3 = R.layout.face_beauty_makeup_item;
        } else if (OplusGLSurfaceView_13 != 2) {
            if (OplusGLSurfaceView_13 == 3) {
                i2 = z ? R.layout.face_beauty_custom_reset_vertical : R.layout.face_beauty_custom_reset;
            } else if (OplusGLSurfaceView_13 == 4) {
                i2 = z ? R.layout.face_beauty_custom_none_vertical : R.layout.face_beauty_custom_none;
            }
            i3 = i2;
        } else {
            i3 = R.layout.face_beauty_makeup_item_none;
        }
        return new PlatformImplementations.kt_3(LayoutInflater.from(this.f19234d).inflate(i3, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(PlatformImplementations.kt_3 aVar) {
        super.onViewDetachedFromWindow(aVar);
        AnimatorSet animatorSet = this.f19247q;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f19247q.cancel();
        }
        this.f19247q = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemViewType(int OplusGLSurfaceView_13) {
        return this.f19235e.get(OplusGLSurfaceView_13).m20530c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13) {
        boolean z;
        View viewM20546a;
        boolean z2;
        BeautyMenuItem c3256bM20545c = m20545c(OplusGLSurfaceView_13);
        if (c3256bM20545c == null) {
            return;
        }
        int itemViewType = getItemViewType(OplusGLSurfaceView_13);
        TextView textView = null;
        if (itemViewType == 0) {
            textView = (TextView) aVar.m20546a(R.id_renamed.tv_face_beauty_custom_item);
            z = OplusGLSurfaceView_13 == this.f19233c;
            viewM20546a = aVar.m20546a(R.id_renamed.ll_face_beauty_custom_view);
            ImageView imageView = (ImageView) aVar.m20546a(R.id_renamed.iv_face_beauty_custom_item);
            if (imageView != null && c3256bM20545c.m20529b() > 0) {
                imageView.setImageResource(c3256bM20545c.m20529b());
            }
        } else if (itemViewType == 1) {
            TextView textView2 = (TextView) aVar.m20546a(R.id_renamed.face_beauty_makeup_item_text);
            z = OplusGLSurfaceView_13 == this.f19233c;
            InverseMakeupItemView inverseMakeupItemView = (InverseMakeupItemView) aVar.m20546a(R.id_renamed.face_beauty_makeup_image);
            if (inverseMakeupItemView != null) {
                inverseMakeupItemView.setCornerMark(c3256bM20545c.m20531d());
                if (c3256bM20545c.m20529b() > 0) {
                    inverseMakeupItemView.setImageResource(c3256bM20545c.m20529b());
                }
            }
            textView = textView2;
            viewM20546a = null;
        } else if (itemViewType != 2) {
            if (itemViewType == 3) {
                textView = (TextView) aVar.m20546a(R.id_renamed.tv_face_beauty_custom_reset);
                ImageView imageView2 = (ImageView) aVar.m20546a(R.id_renamed.iv_face_beauty_custom_reset);
                viewM20546a = aVar.m20546a(R.id_renamed.ll_face_beauty_custom_reset);
                z2 = this.f19242l;
                if (imageView2 != null && c3256bM20545c.m20529b() > 0) {
                    imageView2.setImageResource(c3256bM20545c.m20529b());
                    imageView2.setAlpha(z2 ? 0.3f : 1.0f);
                }
                if (this.f19237g != null) {
                    aVar.itemView.setOnClickListener(this.f19237g);
                }
            } else if (itemViewType != 4) {
                viewM20546a = null;
                z = false;
            } else {
                textView = (TextView) aVar.m20546a(R.id_renamed.tv_face_beauty_custom_none);
                ImageView imageView3 = (ImageView) aVar.m20546a(R.id_renamed.iv_face_beauty_custom_none);
                viewM20546a = aVar.m20546a(R.id_renamed.ll_face_beauty_custom_view);
                z2 = this.f19243m;
                if (imageView3 != null && c3256bM20545c.m20529b() > 0) {
                    imageView3.setImageResource(c3256bM20545c.m20529b());
                }
                if (this.f19237g != null) {
                    aVar.itemView.setOnClickListener(this.f19237g);
                }
            }
            z = z2;
        } else {
            textView = (TextView) aVar.m20546a(R.id_renamed.makeup_none_text);
            z = OplusGLSurfaceView_13 == this.f19233c;
            viewM20546a = aVar.m20546a(R.id_renamed.ll_makeup_none_item_bg);
            ImageView imageView4 = (ImageView) aVar.m20546a(R.id_renamed.makeup_none_image);
            if (imageView4 != null && c3256bM20545c.m20529b() > 0) {
                imageView4.setImageResource(c3256bM20545c.m20529b());
            }
        }
        FaceBeautyItemFrame faceBeautyItemFrame = (FaceBeautyItemFrame) aVar.m20546a(R.id_renamed.face_beauty_item_frame);
        if (faceBeautyItemFrame != null) {
            faceBeautyItemFrame.m20493a(z, false);
        }
        aVar.itemView.setSelected(z);
        if (textView != null && c3256bM20545c.m20528a() > 0) {
            textView.setTypeface(Util.m24411c(true));
            textView.setText(this.f19234d.getString(c3256bM20545c.m20528a()));
        }
        if (viewM20546a != null) {
            m20533a(viewM20546a, textView != null && InverseManager.INS.isInverseColor(textView.getContext().hashCode()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0025  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m20533a(android.view.View r5, boolean r6) {
        /*
            r4 = this;
            if (r5 != 0) goto L3
            return
        L3:
            boolean r0 = com.oplus.camera.util.Util.m24495t()
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L38
            int r0 = r4.f19246p
            if (r3 != r0) goto L27
            int r4 = com.oplus.camera.util.Util.m24178H()
            if (r4 == r1) goto L20
            int r4 = com.oplus.camera.util.Util.m24178H()
            r0 = 6
            if (r4 != r0) goto L1e
            goto L20
        L1e:
            r4 = r2
            goto L21
        L20:
            r4 = r3
        L21:
            if (r6 != 0) goto L41
            if (r4 != 0) goto L41
        L25:
            r2 = r3
            goto L41
        L27:
            r1 = 4
            if (r1 != r0) goto L41
            com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 r4 = r4.f19236f
            if (r4 == 0) goto L35
            boolean r4 = r4.mo20631d()
            if (r4 == 0) goto L35
            goto L41
        L35:
            r2 = r6 ^ 1
            goto L41
        L38:
            int r4 = com.oplus.camera.util.Util.m24178H()
            if (r4 != r1) goto L41
            if (r6 != 0) goto L41
            goto L25
        L41:
            if (r2 == 0) goto L47
            r4 = 2131231718(0x7f0803e6, float:1.8079525E38)
            goto L4a
        L47:
            r4 = 2131231716(0x7f0803e4, float:1.807952E38)
        L4a:
            r5.setBackgroundResource(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyAdapter.m20533a(android.view.View, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        List<BeautyMenuItem> list = this.f19235e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public BeautyMenuItem m20545c(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > getItemCount()) {
            return null;
        }
        return this.f19235e.get(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m20534a() {
        CameraLog.m12959b("FaceBeautyAdapter", "getSelectIndex, this: " + this + ", mSelectIndex:" + this.f19233c);
        return this.f19233c;
    }

    /* compiled from: FaceBeautyAdapter.java */
    /* renamed from: com.oplus.camera.ui.menu.facebeauty.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0707w implements View.OnClickListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final SparseArray<View> f19252b;

        public PlatformImplementations.kt_3(View view) {
            super(view);
            this.f19252b = new SparseArray<>();
            view.setOnClickListener(this);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final View m20546a(int OplusGLSurfaceView_13) {
            View view = this.f19252b.get(OplusGLSurfaceView_13);
            if (view != null) {
                return view;
            }
            View viewFindViewById = this.itemView.findViewById(OplusGLSurfaceView_13);
            this.f19252b.put(OplusGLSurfaceView_13, viewFindViewById);
            return viewFindViewById;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FaceBeautyAdapter.this.f19236f == null || !FaceBeautyAdapter.this.f19236f.m20630a()) {
                return;
            }
            FaceBeautyAdapter.this.f19236f.mo20629a(view, getLayoutPosition());
        }
    }
}
