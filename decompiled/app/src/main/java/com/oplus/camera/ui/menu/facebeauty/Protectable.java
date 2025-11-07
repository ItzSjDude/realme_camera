package com.oplus.camera.ui.menu.facebeauty;

/* compiled from: FaceBeautyAdapter.java */
/* loaded from: classes2.dex */
public class c_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.oplus.camera.ui.menu.facebeauty.c_renamed.a_renamed> {
    private android.content.Context d_renamed;
    private java.util.List<com.oplus.camera.ui.menu.facebeauty.b_renamed> e_renamed;
    private android.graphics.Paint h_renamed;
    private int i_renamed;
    private float j_renamed;
    private float k_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.view.animation.PathInterpolator f6409a = new android.view.animation.PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.view.animation.PathInterpolator f6410b = new android.view.animation.PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6411c = -3;
    private com.oplus.camera.ui.menu.facebeauty.f_renamed.a_renamed f_renamed = null;
    private android.view.View.OnClickListener g_renamed = null;
    private boolean l_renamed = false;
    private boolean m_renamed = false;
    private androidx.recyclerview.widget.RecyclerView.i_renamed n_renamed = null;
    private float o_renamed = 0.0f;
    private int p_renamed = 0;
    private android.animation.AnimatorSet q_renamed = null;

    public c_renamed(android.content.Context context) {
        this.d_renamed = null;
        this.e_renamed = null;
        this.h_renamed = null;
        this.i_renamed = 0;
        this.j_renamed = 0.0f;
        this.k_renamed = 0.0f;
        com.oplus.camera.e_renamed.c_renamed("FaceBeautyAdapter", "FaceBeautyAdapter, init FaceBeautyAdapter, this: " + this);
        this.e_renamed = new java.util.ArrayList();
        this.d_renamed = context;
        this.i_renamed = context.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_item_text_size);
        this.j_renamed = r6.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_item_width) - (r6.getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.face_beauty_menu_item_text_padding_start) * 2);
        this.h_renamed = new android.graphics.Paint();
        this.h_renamed.setTypeface(com.oplus.camera.util.Util.c_renamed(false));
        this.h_renamed.setTextSize(this.i_renamed);
        this.k_renamed = this.i_renamed;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public void onAttachedToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.n_renamed = recyclerView.getLayoutManager();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public void onDetachedFromRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.n_renamed = null;
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public void a_renamed(com.oplus.camera.ui.menu.facebeauty.f_renamed.a_renamed aVar) {
        this.f_renamed = aVar;
    }

    public void a_renamed(android.view.View.OnClickListener onClickListener) {
        this.g_renamed = onClickListener;
    }

    public void a_renamed(final boolean z_renamed, boolean z2) {
        if (this.l_renamed == z_renamed) {
            return;
        }
        this.l_renamed = z_renamed;
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.n_renamed;
        if (iVar != null) {
            final android.view.View viewFindViewByPosition = iVar.findViewByPosition(0);
            if (viewFindViewByPosition != null) {
                android.animation.AnimatorSet animatorSet = this.q_renamed;
                if (animatorSet != null && animatorSet.isStarted()) {
                    this.q_renamed.cancel();
                }
                android.widget.ImageView imageView = (android.widget.ImageView) viewFindViewByPosition.findViewById(com.oplus.camera.R_renamed.id_renamed.iv_face_beauty_custom_reset);
                this.q_renamed = new android.animation.AnimatorSet();
                float[] fArr = new float[2];
                fArr[0] = z_renamed ? 1.0f : 0.3f;
                fArr[1] = z_renamed ? 0.3f : 1.0f;
                android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(imageView, "alpha", fArr);
                objectAnimatorOfFloat.setDuration(250L);
                objectAnimatorOfFloat.setInterpolator(this.f6410b);
                android.animation.AnimatorSet.Builder builderPlay = this.q_renamed.play(objectAnimatorOfFloat);
                if (z2) {
                    android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 360.0f);
                    objectAnimatorOfFloat2.setDuration(500L);
                    objectAnimatorOfFloat2.setInterpolator(this.f6409a);
                    builderPlay.with(objectAnimatorOfFloat2);
                } else {
                    imageView.setRotation(0.0f);
                }
                this.q_renamed.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.c_renamed.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        viewFindViewByPosition.setSelected(z_renamed);
                    }
                });
                this.q_renamed.start();
                return;
            }
            notifyItemChanged(0);
            return;
        }
        notifyDataSetChanged();
    }

    public void a_renamed(boolean z_renamed) {
        this.m_renamed = z_renamed;
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.n_renamed;
        if (iVar != null) {
            android.view.View viewFindViewByPosition = iVar.findViewByPosition(1);
            if (viewFindViewByPosition != null) {
                viewFindViewByPosition.setSelected(z_renamed);
                return;
            }
            return;
        }
        notifyDataSetChanged();
    }

    public void a_renamed(int i_renamed) {
        this.p_renamed = i_renamed;
    }

    public void a_renamed(java.util.List<com.oplus.camera.ui.menu.facebeauty.b_renamed> list) {
        java.util.Iterator<com.oplus.camera.ui.menu.facebeauty.b_renamed> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (this.h_renamed.measureText(this.d_renamed.getString(it.next().a_renamed())) > this.j_renamed) {
                this.k_renamed = this.i_renamed * 0.8f;
                break;
            }
        }
        if (!this.e_renamed.isEmpty()) {
            this.e_renamed.clear();
        }
        this.e_renamed.addAll(list);
        notifyDataSetChanged();
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("FaceBeautyAdapter", "onSelectPositionChange, this: " + this + ", newSelectIndex: " + i_renamed + ", mSelectIndex: " + this.f6411c);
        int i2 = this.f6411c;
        if (i2 == i_renamed) {
            return;
        }
        androidx.recyclerview.widget.RecyclerView.i_renamed iVar = this.n_renamed;
        if (iVar != null) {
            android.view.View viewFindViewByPosition = iVar.findViewByPosition(i2);
            android.view.View viewFindViewByPosition2 = this.n_renamed.findViewByPosition(i_renamed);
            int i3 = this.f6411c;
            this.f6411c = i_renamed;
            if (viewFindViewByPosition != null) {
                viewFindViewByPosition.setSelected(false);
            } else if (i3 > 0) {
                notifyItemChanged(i3);
            }
            if (viewFindViewByPosition2 != null) {
                viewFindViewByPosition2.setSelected(true);
                return;
            } else {
                if (i_renamed > 0) {
                    notifyItemChanged(i_renamed);
                    return;
                }
                return;
            }
        }
        this.f6411c = i_renamed;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.ui.menu.facebeauty.c_renamed.a_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        int i2;
        boolean z_renamed = 1 == this.p_renamed;
        int i3 = z_renamed ? com.oplus.camera.R_renamed.layout.face_beauty_menu_item_vertical : com.oplus.camera.R_renamed.layout.face_beauty_menu_item;
        if (i_renamed == 1) {
            i3 = com.oplus.camera.R_renamed.layout.face_beauty_makeup_item;
        } else if (i_renamed != 2) {
            if (i_renamed == 3) {
                i2 = z_renamed ? com.oplus.camera.R_renamed.layout.face_beauty_custom_reset_vertical : com.oplus.camera.R_renamed.layout.face_beauty_custom_reset;
            } else if (i_renamed == 4) {
                i2 = z_renamed ? com.oplus.camera.R_renamed.layout.face_beauty_custom_none_vertical : com.oplus.camera.R_renamed.layout.face_beauty_custom_none;
            }
            i3 = i2;
        } else {
            i3 = com.oplus.camera.R_renamed.layout.face_beauty_makeup_item_none;
        }
        return new com.oplus.camera.ui.menu.facebeauty.c_renamed.a_renamed(android.view.LayoutInflater.from(this.d_renamed).inflate(i3, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(com.oplus.camera.ui.menu.facebeauty.c_renamed.a_renamed aVar) {
        super.onViewDetachedFromWindow(aVar);
        android.animation.AnimatorSet animatorSet = this.q_renamed;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.q_renamed.cancel();
        }
        this.q_renamed = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemViewType(int i_renamed) {
        return this.e_renamed.get(i_renamed).c_renamed();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.oplus.camera.ui.menu.facebeauty.c_renamed.a_renamed aVar, int i_renamed) {
        boolean z_renamed;
        android.view.View viewA;
        boolean z2;
        com.oplus.camera.ui.menu.facebeauty.b_renamed bVarC = c_renamed(i_renamed);
        if (bVarC == null) {
            return;
        }
        int itemViewType = getItemViewType(i_renamed);
        android.widget.TextView textView = null;
        if (itemViewType == 0) {
            textView = (android.widget.TextView) aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.tv_face_beauty_custom_item);
            z_renamed = i_renamed == this.f6411c;
            viewA = aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.ll_face_beauty_custom_view);
            android.widget.ImageView imageView = (android.widget.ImageView) aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.iv_face_beauty_custom_item);
            if (imageView != null && bVarC.b_renamed() > 0) {
                imageView.setImageResource(bVarC.b_renamed());
            }
        } else if (itemViewType == 1) {
            android.widget.TextView textView2 = (android.widget.TextView) aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.face_beauty_makeup_item_text);
            z_renamed = i_renamed == this.f6411c;
            com.oplus.camera.ui.inverse.InverseMakeupItemView inverseMakeupItemView = (com.oplus.camera.ui.inverse.InverseMakeupItemView) aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.face_beauty_makeup_image);
            if (inverseMakeupItemView != null) {
                inverseMakeupItemView.setCornerMark(bVarC.d_renamed());
                if (bVarC.b_renamed() > 0) {
                    inverseMakeupItemView.setImageResource(bVarC.b_renamed());
                }
            }
            textView = textView2;
            viewA = null;
        } else if (itemViewType != 2) {
            if (itemViewType == 3) {
                textView = (android.widget.TextView) aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.tv_face_beauty_custom_reset);
                android.widget.ImageView imageView2 = (android.widget.ImageView) aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.iv_face_beauty_custom_reset);
                viewA = aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.ll_face_beauty_custom_reset);
                z2 = this.l_renamed;
                if (imageView2 != null && bVarC.b_renamed() > 0) {
                    imageView2.setImageResource(bVarC.b_renamed());
                    imageView2.setAlpha(z2 ? 0.3f : 1.0f);
                }
                if (this.g_renamed != null) {
                    aVar.itemView.setOnClickListener(this.g_renamed);
                }
            } else if (itemViewType != 4) {
                viewA = null;
                z_renamed = false;
            } else {
                textView = (android.widget.TextView) aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.tv_face_beauty_custom_none);
                android.widget.ImageView imageView3 = (android.widget.ImageView) aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.iv_face_beauty_custom_none);
                viewA = aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.ll_face_beauty_custom_view);
                z2 = this.m_renamed;
                if (imageView3 != null && bVarC.b_renamed() > 0) {
                    imageView3.setImageResource(bVarC.b_renamed());
                }
                if (this.g_renamed != null) {
                    aVar.itemView.setOnClickListener(this.g_renamed);
                }
            }
            z_renamed = z2;
        } else {
            textView = (android.widget.TextView) aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.makeup_none_text);
            z_renamed = i_renamed == this.f6411c;
            viewA = aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.ll_makeup_none_item_bg);
            android.widget.ImageView imageView4 = (android.widget.ImageView) aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.makeup_none_image);
            if (imageView4 != null && bVarC.b_renamed() > 0) {
                imageView4.setImageResource(bVarC.b_renamed());
            }
        }
        com.oplus.camera.ui.menu.facebeauty.FaceBeautyItemFrame faceBeautyItemFrame = (com.oplus.camera.ui.menu.facebeauty.FaceBeautyItemFrame) aVar.a_renamed(com.oplus.camera.R_renamed.id_renamed.face_beauty_item_frame);
        if (faceBeautyItemFrame != null) {
            faceBeautyItemFrame.a_renamed(z_renamed, false);
        }
        aVar.itemView.setSelected(z_renamed);
        if (textView != null && bVarC.a_renamed() > 0) {
            textView.setTypeface(com.oplus.camera.util.Util.c_renamed(true));
            textView.setText(this.d_renamed.getString(bVarC.a_renamed()));
        }
        if (viewA != null) {
            a_renamed(viewA, textView != null && com.oplus.camera.ui.inverse.e_renamed.INS.isInverseColor(textView.getContext().hashCode()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(android.view.View r5, boolean r6) {
        /*
            r4 = this;
            if (r5 != 0) goto L3_renamed
            return
        L3_renamed:
            boolean r0 = com.oplus.camera.util.Util.t_renamed()
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L38
            int r0 = r4.p_renamed
            if (r3 != r0) goto L27
            int r4 = com.oplus.camera.util.Util.H_renamed()
            if (r4 == r1) goto L20
            int r4 = com.oplus.camera.util.Util.H_renamed()
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
            com.oplus.camera.ui.menu.facebeauty.f_renamed$a_renamed r4 = r4.f_renamed
            if (r4 == 0) goto L35
            boolean r4 = r4.d_renamed()
            if (r4 == 0) goto L35
            goto L41
        L35:
            r2 = r6 ^ 1
            goto L41
        L38:
            int r4 = com.oplus.camera.util.Util.H_renamed()
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.facebeauty.c_renamed.a_renamed(android.view.View, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        java.util.List<com.oplus.camera.ui.menu.facebeauty.b_renamed> list = this.e_renamed;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public com.oplus.camera.ui.menu.facebeauty.b_renamed c_renamed(int i_renamed) {
        if (i_renamed < 0 || i_renamed > getItemCount()) {
            return null;
        }
        return this.e_renamed.get(i_renamed);
    }

    public int a_renamed() {
        com.oplus.camera.e_renamed.b_renamed("FaceBeautyAdapter", "getSelectIndex, this: " + this + ", mSelectIndex:" + this.f6411c);
        return this.f6411c;
    }

    /* compiled from: FaceBeautyAdapter.java */
    public class a_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed implements android.view.View.OnClickListener {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.util.SparseArray<android.view.View> f6416b;

        public a_renamed(android.view.View view) {
            super(view);
            this.f6416b = new android.util.SparseArray<>();
            view.setOnClickListener(this);
        }

        public final android.view.View a_renamed(int i_renamed) {
            android.view.View view = this.f6416b.get(i_renamed);
            if (view != null) {
                return view;
            }
            android.view.View viewFindViewById = this.itemView.findViewById(i_renamed);
            this.f6416b.put(i_renamed, viewFindViewById);
            return viewFindViewById;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            if (com.oplus.camera.ui.menu.facebeauty.c_renamed.this.f_renamed == null || !com.oplus.camera.ui.menu.facebeauty.c_renamed.this.f_renamed.a_renamed()) {
                return;
            }
            com.oplus.camera.ui.menu.facebeauty.c_renamed.this.f_renamed.a_renamed(view, getLayoutPosition());
        }
    }
}
