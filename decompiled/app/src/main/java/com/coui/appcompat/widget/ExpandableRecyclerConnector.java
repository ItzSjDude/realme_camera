package com.coui.appcompat.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.AbsListView;
import androidx.recyclerview.widget.COUILinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
class ExpandableRecyclerConnector extends RecyclerView.AbstractC0685a {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private COUIExpandableRecyclerAdapter f7875e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f7877g;

    /* renamed from: OplusGLSurfaceView_15 */
    private COUIExpandableRecyclerView f7880j;

    /* renamed from: PlatformImplementations.kt_3 */
    private SparseArray<C1443e> f7871a = new SparseArray<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private SparseArray<C1442d> f7872b = new SparseArray<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private SparseArray<List<RecyclerView.AbstractC0707w>> f7873c = new SparseArray<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private SparseArray<List<RecyclerView.AbstractC0707w>> f7874d = new SparseArray<>();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f7878h = Integer.MAX_VALUE;

    /* renamed from: OplusGLSurfaceView_13 */
    private final RecyclerView.AbstractC0687c f7879i = new C1444f();

    /* renamed from: OplusGLSurfaceView_5 */
    private SparseArray<Integer> f7881k = new SparseArray<>();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ArrayList<GroupMetadata> f7876f = new ArrayList<>();

    public ExpandableRecyclerConnector(COUIExpandableRecyclerAdapter interfaceC1452f, COUIExpandableRecyclerView cOUIExpandableRecyclerView) {
        this.f7880j = cOUIExpandableRecyclerView;
        m7496a(interfaceC1452f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7496a(COUIExpandableRecyclerAdapter interfaceC1452f) {
        COUIExpandableRecyclerAdapter interfaceC1452f2 = this.f7875e;
        if (interfaceC1452f2 != null) {
            interfaceC1452f2.m7647a(this.f7879i);
        }
        this.f7875e = interfaceC1452f;
        setHasStableIds(this.f7875e.m7648a());
        interfaceC1452f.m7654b(this.f7879i);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private C1443e m7490f(int OplusGLSurfaceView_13) {
        C1443e c1443e = this.f7871a.get(OplusGLSurfaceView_13);
        if (c1443e != null) {
            return c1443e;
        }
        C1443e c1443e2 = new C1443e();
        this.f7871a.put(OplusGLSurfaceView_13, c1443e2);
        return c1443e2;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m7491g(int OplusGLSurfaceView_13) {
        C1443e c1443eM7490f = m7490f(OplusGLSurfaceView_13);
        if (c1443eM7490f.f7902a && c1443eM7490f.f7903b) {
            return false;
        }
        c1443eM7490f.f7902a = true;
        c1443eM7490f.f7903b = true;
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m7498a(int OplusGLSurfaceView_13) {
        ExpandableRecyclerPosition c1530xM8244a = ExpandableRecyclerPosition.m8244a(2, OplusGLSurfaceView_13, -1, -1);
        C1445g c1445gM7495a = m7495a(c1530xM8244a);
        c1530xM8244a.m8247a();
        View viewFindViewByPosition = ((COUILinearLayoutManager) this.f7880j.getLayoutManager()).findViewByPosition(c1445gM7495a.f7909a.f8868c);
        if (c1445gM7495a != null && viewFindViewByPosition != null && viewFindViewByPosition.getBottom() >= this.f7880j.getHeight() - this.f7880j.getPaddingBottom()) {
            int i2 = c1445gM7495a.f7910b.flPos;
            this.f7876f.remove(c1445gM7495a.f7910b);
            m7486a(false, false);
            notifyItemChanged(i2);
            this.f7875e.m7657c(c1445gM7495a.f7910b.gPos);
            return false;
        }
        C1443e c1443eM7490f = m7490f(OplusGLSurfaceView_13);
        if (c1443eM7490f.f7902a && c1443eM7490f.f7903b) {
            c1443eM7490f.f7903b = false;
            m7488b(c1443eM7490f.f7905d, c1445gM7495a.f7910b.flPos, OplusGLSurfaceView_13, c1443eM7490f.f7906e);
            return false;
        }
        if (c1443eM7490f.f7902a && !c1443eM7490f.f7903b) {
            m7483a(c1443eM7490f.f7905d, c1445gM7495a.f7910b.flPos, OplusGLSurfaceView_13, c1443eM7490f.f7904c);
            c1443eM7490f.f7903b = true;
            return false;
        }
        c1443eM7490f.f7902a = true;
        c1443eM7490f.f7903b = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m7492h(int OplusGLSurfaceView_13) {
        C1443e c1443eM7490f = m7490f(OplusGLSurfaceView_13);
        c1443eM7490f.f7902a = false;
        c1443eM7490f.f7906e = -1;
        m7489d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7489d() {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f7874d.size(); OplusGLSurfaceView_13++) {
            List<RecyclerView.AbstractC0707w> listValueAt = this.f7874d.valueAt(OplusGLSurfaceView_13);
            int iKeyAt = this.f7874d.keyAt(OplusGLSurfaceView_13);
            List<RecyclerView.AbstractC0707w> arrayList = this.f7873c.get(iKeyAt);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f7873c.put(iKeyAt, arrayList);
            }
            arrayList.addAll(listValueAt);
        }
        this.f7874d.clear();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    C1445g m7500b(int OplusGLSurfaceView_13) {
        int i2;
        ArrayList<GroupMetadata> arrayList = this.f7876f;
        int size = arrayList.size();
        int i3 = size - 1;
        if (size == 0) {
            return C1445g.m7517a(OplusGLSurfaceView_13, 2, OplusGLSurfaceView_13, -1, null, 0);
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 <= i3) {
            int i6 = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i6);
            if (OplusGLSurfaceView_13 > groupMetadata.lastChildFlPos) {
                i4 = i6 + 1;
            } else if (OplusGLSurfaceView_13 < groupMetadata.flPos) {
                i3 = i6 - 1;
            } else {
                if (OplusGLSurfaceView_13 == groupMetadata.flPos) {
                    return C1445g.m7517a(OplusGLSurfaceView_13, 2, groupMetadata.gPos, -1, groupMetadata, i6);
                }
                if (OplusGLSurfaceView_13 <= groupMetadata.lastChildFlPos) {
                    return C1445g.m7517a(OplusGLSurfaceView_13, 1, groupMetadata.gPos, OplusGLSurfaceView_13 - (groupMetadata.flPos + 1), groupMetadata, i6);
                }
            }
            i5 = i6;
        }
        if (i4 > i5) {
            GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
            i2 = (OplusGLSurfaceView_13 - groupMetadata2.lastChildFlPos) + groupMetadata2.gPos;
        } else if (i3 < i5) {
            i4 = i3 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i4);
            i2 = groupMetadata3.gPos - (groupMetadata3.flPos - OplusGLSurfaceView_13);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return C1445g.m7517a(OplusGLSurfaceView_13, 2, i2, -1, null, i4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    C1445g m7495a(ExpandableRecyclerPosition c1530x) {
        ArrayList<GroupMetadata> arrayList = this.f7876f;
        int size = arrayList.size();
        int OplusGLSurfaceView_13 = size - 1;
        if (size == 0) {
            return C1445g.m7517a(c1530x.f8866a, c1530x.f8869d, c1530x.f8866a, c1530x.f8867b, null, 0);
        }
        int i2 = 0;
        int i3 = 0;
        while (i3 <= OplusGLSurfaceView_13) {
            int i4 = ((OplusGLSurfaceView_13 - i3) / 2) + i3;
            GroupMetadata groupMetadata = arrayList.get(i4);
            if (c1530x.f8866a > groupMetadata.gPos) {
                i3 = i4 + 1;
            } else if (c1530x.f8866a < groupMetadata.gPos) {
                OplusGLSurfaceView_13 = i4 - 1;
            } else if (c1530x.f8866a == groupMetadata.gPos) {
                if (c1530x.f8869d == 2) {
                    return C1445g.m7517a(groupMetadata.flPos, c1530x.f8869d, c1530x.f8866a, c1530x.f8867b, groupMetadata, i4);
                }
                if (c1530x.f8869d == 1) {
                    return C1445g.m7517a(groupMetadata.flPos + c1530x.f8867b + 1, c1530x.f8869d, c1530x.f8866a, c1530x.f8867b, groupMetadata, i4);
                }
                return null;
            }
            i2 = i4;
        }
        if (c1530x.f8869d != 2) {
            return null;
        }
        if (i3 > i2) {
            GroupMetadata groupMetadata2 = arrayList.get(i3 - 1);
            return C1445g.m7517a(groupMetadata2.lastChildFlPos + (c1530x.f8866a - groupMetadata2.gPos), c1530x.f8869d, c1530x.f8866a, c1530x.f8867b, null, i3);
        }
        if (OplusGLSurfaceView_13 >= i2) {
            return null;
        }
        int i5 = OplusGLSurfaceView_13 + 1;
        GroupMetadata groupMetadata3 = arrayList.get(i5);
        return C1445g.m7517a(groupMetadata3.flPos - (groupMetadata3.gPos - c1530x.f8866a), c1530x.f8869d, c1530x.f8866a, c1530x.f8867b, null, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        return this.f7875e.m7650b() + this.f7877g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public long getItemId(int OplusGLSurfaceView_13) {
        long jM7643a;
        C1445g c1445gM7500b = m7500b(OplusGLSurfaceView_13);
        long jM7658d = this.f7875e.m7658d(c1445gM7500b.f7909a.f8866a);
        if (c1445gM7500b.f7909a.f8869d == 2) {
            jM7643a = this.f7875e.m7642a(jM7658d);
        } else if (c1445gM7500b.f7909a.f8869d == 1) {
            jM7643a = this.f7875e.m7643a(jM7658d, this.f7875e.m7651b(c1445gM7500b.f7909a.f8866a, c1445gM7500b.f7909a.f8867b));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        c1445gM7500b.m7520a();
        return jM7643a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected ViewGroup.LayoutParams m7494a() {
        return new AbsListView.LayoutParams(-1, -2, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public void onBindViewHolder(RecyclerView.AbstractC0707w abstractC0707w, final int OplusGLSurfaceView_13) {
        C1445g c1445gM7500b = m7500b(OplusGLSurfaceView_13);
        int i2 = c1445gM7500b.f7909a.f8866a;
        C1443e c1443eM7490f = m7490f(i2);
        abstractC0707w.itemView.setOnClickListener(null);
        if (c1445gM7500b.f7909a.f8869d == 2) {
            this.f7875e.m7646a(i2, c1445gM7500b.m7521b(), abstractC0707w);
            abstractC0707w.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.widget.ExpandableRecyclerConnector.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ExpandableRecyclerConnector.this.f7880j.m7127a(view, OplusGLSurfaceView_13);
                }
            });
        } else {
            if (c1443eM7490f.f7902a) {
                C1440b c1440b = (C1440b) abstractC0707w.itemView;
                c1440b.m7509a();
                int iM7479a = m7479a(c1443eM7490f.f7903b, i2, c1440b);
                c1443eM7490f.f7904c = iM7479a;
                c1443eM7490f.f7905d = c1440b;
                Object tag = c1440b.getTag();
                int iIntValue = tag != null ? ((Integer) tag).intValue() : 0;
                if (c1443eM7490f.f7903b && iIntValue != 1) {
                    m7483a(c1440b, OplusGLSurfaceView_13, i2, iM7479a);
                } else if (!c1443eM7490f.f7903b && iIntValue != 2) {
                    m7488b(c1440b, OplusGLSurfaceView_13, i2, iM7479a);
                } else {
                    Log.COUIBaseListPopupWindow_8("ExpandRecyclerConnector", "onBindViewHolder: state is no match:" + iIntValue);
                }
            } else if (c1445gM7500b.f7909a.f8869d == 1) {
                this.f7875e.m7645a(i2, c1445gM7500b.f7909a.f8867b, c1445gM7500b.f7910b.lastChildFlPos == OplusGLSurfaceView_13, abstractC0707w);
                if (this.f7875e.m7649a(i2, c1445gM7500b.f7909a.f8867b)) {
                    abstractC0707w.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.widget.ExpandableRecyclerConnector.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ExpandableRecyclerConnector.this.f7880j.m7127a(view, OplusGLSurfaceView_13);
                        }
                    });
                }
            } else {
                throw new RuntimeException("Flat list position is of unknown type");
            }
        }
        c1445gM7500b.m7520a();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    int m7503c(int OplusGLSurfaceView_13) {
        if (m7490f(OplusGLSurfaceView_13).f7902a) {
            return 1;
        }
        return this.f7875e.m7641a(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7482a(RecyclerView.AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13, int i2) {
        int iM7487b = m7487b(OplusGLSurfaceView_13, i2);
        List<RecyclerView.AbstractC0707w> arrayList = this.f7874d.get(iM7487b);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(abstractC0707w);
        this.f7874d.put(iM7487b, arrayList);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private RecyclerView.AbstractC0707w m7480a(int OplusGLSurfaceView_13, int i2) {
        List<RecyclerView.AbstractC0707w> list = this.f7873c.get(m7487b(OplusGLSurfaceView_13, i2));
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7479a(boolean z, int OplusGLSurfaceView_13, C1440b c1440b) {
        int bottom;
        int childCount = this.f7880j.getLayoutManager().getChildCount();
        int bottom2 = childCount > 0 ? this.f7880j.getLayoutManager().getChildAt(childCount - 1).getBottom() : 0;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f7880j.getWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (z && this.f7880j.getLayoutParams().height == -2) {
            bottom = this.f7880j.getContext().getResources().getDisplayMetrics().heightPixels;
        } else {
            bottom = this.f7880j.getBottom();
        }
        int iM7641a = this.f7875e.m7641a(OplusGLSurfaceView_13);
        int measuredHeight = 0;
        for (int i2 = 0; i2 < iM7641a; i2++) {
            RecyclerView.AbstractC0707w abstractC0707wM7480a = m7480a(OplusGLSurfaceView_13, i2);
            if (abstractC0707wM7480a == null) {
                abstractC0707wM7480a = this.f7875e.m7652b(this.f7880j, m7487b(OplusGLSurfaceView_13, i2));
            }
            m7482a(abstractC0707wM7480a, OplusGLSurfaceView_13, i2);
            View view = abstractC0707wM7480a.itemView;
            this.f7875e.m7645a(OplusGLSurfaceView_13, i2, false, abstractC0707wM7480a);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = m7494a();
                view.setLayoutParams(layoutParams);
            }
            int i3 = layoutParams.height;
            int iMakeMeasureSpec3 = i3 > 0 ? View.MeasureSpec.makeMeasureSpec(i3, 1073741824) : iMakeMeasureSpec2;
            view.setLayoutDirection(this.f7880j.getLayoutDirection());
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec3);
            measuredHeight += view.getMeasuredHeight();
            c1440b.m7510a(view);
            if ((!z && measuredHeight + bottom2 > bottom) || (z && measuredHeight > (bottom - bottom2) * 2)) {
                break;
            }
        }
        return measuredHeight;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7483a(final C1440b c1440b, final int OplusGLSurfaceView_13, final int i2, int i3) {
        Log.IntrinsicsJvm.kt_5("ExpandRecyclerConnector", "expandAnimationStart:" + OplusGLSurfaceView_13 + " ,groupPos:" + i2 + " , height:" + i3);
        C1443e c1443eM7490f = m7490f(i2);
        C1442d c1442d = this.f7872b.get(i2);
        if (c1442d == null) {
            c1442d = new C1442d(this.f7880j, 400L, new PathInterpolator(0.3f, 0.0f, 0.0f, 1.0f));
            this.f7872b.put(i2, c1442d);
        } else {
            c1442d.removeAllListeners();
            c1442d.cancel();
        }
        c1442d.m7516a(true, OplusGLSurfaceView_13 == getItemCount() - 1, OplusGLSurfaceView_13, c1440b, c1443eM7490f, c1443eM7490f.f7906e == -1 ? 0 : c1443eM7490f.f7906e, i3);
        c1442d.addListener(new AbstractC1441c() { // from class: com.coui.appcompat.widget.ExpandableRecyclerConnector.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C1440b c1440b2 = c1440b;
                if (c1440b2 != null) {
                    c1440b2.m7509a();
                    ExpandableRecyclerConnector.this.m7492h(i2);
                    ExpandableRecyclerConnector.this.m7486a(true, true);
                    ExpandableRecyclerConnector expandableRecyclerConnector = ExpandableRecyclerConnector.this;
                    expandableRecyclerConnector.notifyItemRangeChanged(OplusGLSurfaceView_13 - 1, (expandableRecyclerConnector.getItemCount() - OplusGLSurfaceView_13) + 1);
                    c1440b.setTag(0);
                }
            }
        });
        c1442d.start();
        c1440b.setTag(1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7488b(final C1440b c1440b, int OplusGLSurfaceView_13, final int i2, int i3) {
        Log.IntrinsicsJvm.kt_5("ExpandRecyclerConnector", "collapseAnimationStart:" + OplusGLSurfaceView_13 + " ,groupPos:" + i2 + " , height:" + i3);
        C1443e c1443eM7490f = m7490f(i2);
        C1442d c1442d = this.f7872b.get(i2);
        if (c1442d == null) {
            c1442d = new C1442d(this.f7880j, 400L, new PathInterpolator(0.3f, 0.0f, 0.0f, 1.0f));
            this.f7872b.put(i2, c1442d);
        } else {
            c1442d.removeAllListeners();
            c1442d.cancel();
        }
        boolean z = OplusGLSurfaceView_13 == getItemCount() - 1;
        if (c1443eM7490f.f7906e != -1) {
            i3 = c1443eM7490f.f7906e;
        }
        c1442d.m7516a(false, z, OplusGLSurfaceView_13, c1440b, c1443eM7490f, i3, 0);
        c1442d.addListener(new AbstractC1441c() { // from class: com.coui.appcompat.widget.ExpandableRecyclerConnector.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C1440b c1440b2 = c1440b;
                if (c1440b2 != null) {
                    c1440b2.m7509a();
                    ExpandableRecyclerConnector.this.m7492h(i2);
                    ExpandableRecyclerConnector.this.m7505d(i2);
                    c1440b.setTag(0);
                }
            }
        });
        c1442d.start();
        c1440b.setTag(2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public RecyclerView.AbstractC0707w onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == Integer.MIN_VALUE) {
            return new C1439a(new C1440b(viewGroup.getContext()));
        }
        if (this.f7881k.get(OplusGLSurfaceView_13).intValue() == 2) {
            return this.f7875e.m7644a(viewGroup, OplusGLSurfaceView_13);
        }
        if (this.f7881k.get(OplusGLSurfaceView_13).intValue() == 1) {
            return this.f7875e.m7652b(viewGroup, OplusGLSurfaceView_13);
        }
        throw new RuntimeException("Flat list position is of unknown type");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7501b() {
        m7486a(true, true);
        notifyItemRangeChanged(0, getItemCount());
    }

    /* renamed from: com.coui.appcompat.widget.ExpandableRecyclerConnector$PlatformImplementations.kt_3 */
    static class C1439a extends RecyclerView.AbstractC0707w {
        public C1439a(View view) {
            super(view);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        }
    }

    /* renamed from: com.coui.appcompat.widget.ExpandableRecyclerConnector$IntrinsicsJvm.kt_4 */
    private static class C1440b extends View {

        /* renamed from: PlatformImplementations.kt_3 */
        private List<View> f7893a;

        public C1440b(Context context) {
            super(context);
            this.f7893a = new ArrayList();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7510a(View view) {
            this.f7893a.add(view);
        }

        @Override // android.view.View
        protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            int i5 = i4 - i2;
            int size = this.f7893a.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                View view = this.f7893a.get(i7);
                int measuredHeight = view.getMeasuredHeight();
                i6 += measuredHeight;
                view.layout(OplusGLSurfaceView_13, i2, view.getMeasuredWidth() + OplusGLSurfaceView_13, measuredHeight + i2);
                if (i6 > i5) {
                    return;
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7509a() {
            this.f7893a.clear();
        }

        @Override // android.view.View
        public void dispatchDraw(Canvas canvas) {
            canvas.save();
            int size = this.f7893a.size();
            int OplusGLSurfaceView_13 = 0;
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.f7893a.get(i2);
                canvas.save();
                int measuredHeight = view.getMeasuredHeight();
                OplusGLSurfaceView_13 += measuredHeight;
                canvas.clipRect(0, 0, getWidth(), measuredHeight);
                view.draw(canvas);
                canvas.restore();
                canvas.translate(0.0f, measuredHeight);
                if (OplusGLSurfaceView_13 > canvas.getHeight()) {
                    break;
                }
            }
            canvas.restore();
        }
    }

    /* renamed from: com.coui.appcompat.widget.ExpandableRecyclerConnector$IntrinsicsJvm.kt_5 */
    private static class C1442d extends ValueAnimator {

        /* renamed from: PlatformImplementations.kt_3 */
        private WeakReference<COUIExpandableRecyclerView> f7894a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean f7895b;

        public C1442d(COUIExpandableRecyclerView cOUIExpandableRecyclerView, long OplusGLSurfaceView_15, TimeInterpolator timeInterpolator) {
            this.f7894a = new WeakReference<>(cOUIExpandableRecyclerView);
            setDuration(OplusGLSurfaceView_15);
            setInterpolator(timeInterpolator);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7516a(final boolean z, final boolean z2, final int OplusGLSurfaceView_13, final View view, final C1443e c1443e, int i2, int i3) {
            Log.IntrinsicsJvm.kt_5("ExpandRecyclerConnector", "setParam: " + z + ", isLastChild:" + z2 + " ,flatPos:" + OplusGLSurfaceView_13 + " ,start:" + i2 + " ,end:" + i3);
            this.f7895b = true;
            setIntValues(i2, i3);
            removeAllUpdateListeners();
            addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.ExpandableRecyclerConnector.IntrinsicsJvm.kt_5.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int i4;
                    COUIExpandableRecyclerView cOUIExpandableRecyclerView = (COUIExpandableRecyclerView) C1442d.this.f7894a.get();
                    if (cOUIExpandableRecyclerView == null) {
                        C1442d.this.m7512a();
                        return;
                    }
                    int iFindFirstVisibleItemPosition = ((COUILinearLayoutManager) cOUIExpandableRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                    int iFindLastVisibleItemPosition = ((COUILinearLayoutManager) cOUIExpandableRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    if (C1442d.this.f7895b || z2 || (iFindFirstVisibleItemPosition <= (i4 = OplusGLSurfaceView_13) && iFindLastVisibleItemPosition >= i4)) {
                        if (!C1442d.this.f7895b && !z2 && z && OplusGLSurfaceView_13 == iFindLastVisibleItemPosition) {
                            Log.IntrinsicsJvm.kt_5("ExpandRecyclerConnector", "onAnimationUpdate2: " + iFindLastVisibleItemPosition + "," + OplusGLSurfaceView_13);
                            C1442d.this.m7512a();
                            return;
                        }
                        if (view != null) {
                            if (C1442d.this.f7895b || !z2 || !z || view.getBottom() <= cOUIExpandableRecyclerView.getBottom()) {
                                C1442d.this.f7895b = false;
                                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                c1443e.f7906e = iIntValue;
                                view.getLayoutParams().height = iIntValue;
                                cOUIExpandableRecyclerView.requestLayout();
                                return;
                            }
                            Log.IntrinsicsJvm.kt_5("ExpandRecyclerConnector", "onAnimationUpdate3: " + view.getBottom() + "," + cOUIExpandableRecyclerView.getBottom());
                            C1442d.this.m7512a();
                            return;
                        }
                        Log.IntrinsicsJvm.kt_5("ExpandRecyclerConnector", "onAnimationUpdate4: view == null");
                        C1442d.this.m7512a();
                        return;
                    }
                    Log.IntrinsicsJvm.kt_5("ExpandRecyclerConnector", "onAnimationUpdate1: " + iFindFirstVisibleItemPosition + "," + iFindLastVisibleItemPosition + "," + OplusGLSurfaceView_13);
                    C1442d.this.m7512a();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m7512a() {
            removeAllUpdateListeners();
            end();
        }
    }

    /* renamed from: com.coui.appcompat.widget.ExpandableRecyclerConnector$IntrinsicsJvm.kt_3 */
    private static abstract class AbstractC1441c implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        private AbstractC1441c() {
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m7487b(int OplusGLSurfaceView_13, int i2) {
        return this.f7875e.m7656c(OplusGLSurfaceView_13, i2) + this.f7875e.m7655c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemViewType(int OplusGLSurfaceView_13) {
        int iM7487b;
        C1445g c1445gM7500b = m7500b(OplusGLSurfaceView_13);
        ExpandableRecyclerPosition c1530x = c1445gM7500b.f7909a;
        if (c1530x.f8869d == 2) {
            iM7487b = this.f7875e.m7659e(c1530x.f8866a);
        } else {
            iM7487b = m7490f(c1530x.f8866a).f7902a ? Integer.MIN_VALUE : m7487b(c1530x.f8866a, c1530x.f8867b);
        }
        this.f7881k.put(iM7487b, Integer.valueOf(c1530x.f8869d));
        c1445gM7500b.m7520a();
        return iM7487b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m7486a(boolean z, boolean z2) {
        int iM7503c;
        ArrayList<GroupMetadata> arrayList = this.f7876f;
        int size = arrayList.size();
        this.f7877g = 0;
        if (z2) {
            int OplusGLSurfaceView_13 = size;
            boolean z3 = false;
            for (int i2 = size - 1; i2 >= 0; i2--) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int iM7493a = m7493a(groupMetadata.gId, groupMetadata.gPos);
                if (iM7493a != groupMetadata.gPos) {
                    if (iM7493a == -1) {
                        arrayList.remove(i2);
                        OplusGLSurfaceView_13--;
                    }
                    groupMetadata.gPos = iM7493a;
                    if (!z3) {
                        z3 = true;
                    }
                }
            }
            if (z3) {
                Collections.sort(arrayList);
            }
            size = OplusGLSurfaceView_13;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            GroupMetadata groupMetadata2 = arrayList.get(i5);
            if (groupMetadata2.lastChildFlPos == -1 || z) {
                iM7503c = m7503c(groupMetadata2.gPos);
            } else {
                iM7503c = groupMetadata2.lastChildFlPos - groupMetadata2.flPos;
            }
            this.f7877g += iM7503c;
            int i6 = i4 + (groupMetadata2.gPos - i3);
            i3 = groupMetadata2.gPos;
            groupMetadata2.flPos = i6;
            i4 = i6 + iM7503c;
            groupMetadata2.lastChildFlPos = i4;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean m7505d(int OplusGLSurfaceView_13) {
        ExpandableRecyclerPosition c1530xM8244a = ExpandableRecyclerPosition.m8244a(2, OplusGLSurfaceView_13, -1, -1);
        C1445g c1445gM7495a = m7495a(c1530xM8244a);
        c1530xM8244a.m8247a();
        if (c1445gM7495a == null) {
            return false;
        }
        return m7499a(c1445gM7495a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m7499a(C1445g c1445g) {
        if (c1445g.f7910b == null) {
            return false;
        }
        this.f7876f.remove(c1445g.f7910b);
        m7486a(false, false);
        notifyItemRangeChanged(0, getItemCount());
        this.f7875e.m7657c(c1445g.f7910b.gPos);
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean m7506e(int OplusGLSurfaceView_13) {
        ExpandableRecyclerPosition c1530xM8244a = ExpandableRecyclerPosition.m8244a(2, OplusGLSurfaceView_13, -1, -1);
        C1445g c1445gM7495a = m7495a(c1530xM8244a);
        c1530xM8244a.m8247a();
        if (c1445gM7495a == null) {
            return false;
        }
        return m7502b(c1445gM7495a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m7502b(C1445g c1445g) {
        if (c1445g.f7909a.f8866a < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.f7878h == 0 || c1445g.f7910b != null) {
            return false;
        }
        if (this.f7876f.size() >= this.f7878h) {
            GroupMetadata groupMetadata = this.f7876f.get(0);
            int iIndexOf = this.f7876f.indexOf(groupMetadata);
            m7505d(groupMetadata.gPos);
            if (c1445g.f7911c > iIndexOf) {
                c1445g.f7911c--;
            }
        }
        GroupMetadata groupMetadataObtain = GroupMetadata.obtain(-1, -1, c1445g.f7909a.f8866a, this.f7875e.m7658d(c1445g.f7909a.f8866a));
        View viewFindViewByPosition = ((COUILinearLayoutManager) this.f7880j.getLayoutManager()).findViewByPosition(c1445g.f7909a.f8868c);
        if (viewFindViewByPosition != null && viewFindViewByPosition.getBottom() >= this.f7880j.getHeight() - this.f7880j.getPaddingBottom()) {
            this.f7876f.add(c1445g.f7911c, groupMetadataObtain);
            m7486a(false, false);
            this.f7875e.m7653b(groupMetadataObtain.gPos);
            notifyItemChanged(groupMetadataObtain.flPos);
            return false;
        }
        if (!m7491g(groupMetadataObtain.gPos)) {
            return false;
        }
        this.f7876f.add(c1445g.f7911c, groupMetadataObtain);
        m7486a(false, false);
        notifyItemRangeChanged(0, getItemCount());
        this.f7875e.m7653b(groupMetadataObtain.gPos);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    ArrayList<GroupMetadata> m7504c() {
        return this.f7876f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m7497a(ArrayList<GroupMetadata> arrayList) {
        COUIExpandableRecyclerAdapter interfaceC1452f;
        if (arrayList == null || (interfaceC1452f = this.f7875e) == null) {
            return;
        }
        int iM7650b = interfaceC1452f.m7650b();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).gPos >= iM7650b) {
                return;
            }
        }
        this.f7876f = arrayList;
        m7486a(true, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m7493a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
        int iM7650b = this.f7875e.m7650b();
        if (iM7650b == 0 || OplusGLSurfaceView_15 == Long.MIN_VALUE) {
            return -1;
        }
        int i2 = iM7650b - 1;
        int iMin = Math.min(i2, Math.max(0, OplusGLSurfaceView_13));
        long jUptimeMillis = SystemClock.uptimeMillis() + 100;
        COUIExpandableRecyclerAdapter interfaceC1452f = this.f7875e;
        if (interfaceC1452f == null) {
            return -1;
        }
        int i3 = iMin;
        int i4 = i3;
        boolean z = false;
        while (SystemClock.uptimeMillis() <= jUptimeMillis) {
            if (interfaceC1452f.m7658d(iMin) != OplusGLSurfaceView_15) {
                boolean z2 = i3 == i2;
                boolean z3 = i4 == 0;
                if (z2 && z3) {
                    break;
                }
                if (z3 || (z && !z2)) {
                    i3++;
                    z = false;
                    iMin = i3;
                } else if (z2 || (!z && !z3)) {
                    i4--;
                    z = true;
                    iMin = i4;
                }
            } else {
                return iMin;
            }
        }
        return -1;
    }

    /* renamed from: com.coui.appcompat.widget.ExpandableRecyclerConnector$COUIBaseListPopupWindow_12 */
    protected class C1444f extends RecyclerView.AbstractC0687c {
        protected C1444f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onChanged() {
            ExpandableRecyclerConnector.this.m7486a(true, true);
            ExpandableRecyclerConnector.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onItemRangeChanged(int OplusGLSurfaceView_13, int i2) {
            ExpandableRecyclerConnector.this.m7486a(true, true);
            ExpandableRecyclerConnector.this.notifyItemRangeChanged(OplusGLSurfaceView_13, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onItemRangeChanged(int OplusGLSurfaceView_13, int i2, Object obj) {
            onItemRangeChanged(OplusGLSurfaceView_13, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onItemRangeInserted(int OplusGLSurfaceView_13, int i2) {
            ExpandableRecyclerConnector.this.m7486a(true, true);
            ExpandableRecyclerConnector.this.notifyItemRangeInserted(OplusGLSurfaceView_13, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onItemRangeRemoved(int OplusGLSurfaceView_13, int i2) {
            ExpandableRecyclerConnector.this.m7486a(true, true);
            ExpandableRecyclerConnector.this.notifyItemRangeRemoved(OplusGLSurfaceView_13, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public void onItemRangeMoved(int OplusGLSurfaceView_13, int i2, int i3) {
            ExpandableRecyclerConnector.this.m7486a(true, true);
            ExpandableRecyclerConnector.this.notifyItemMoved(OplusGLSurfaceView_13, i2);
        }
    }

    static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.coui.appcompat.widget.ExpandableRecyclerConnector.GroupMetadata.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public GroupMetadata[] newArray(int OplusGLSurfaceView_13) {
                return new GroupMetadata[OplusGLSurfaceView_13];
            }
        };
        static final int REFRESH = -1;
        int flPos;
        long gId;
        int gPos;
        int lastChildFlPos;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private GroupMetadata() {
        }

        static GroupMetadata obtain(int OplusGLSurfaceView_13, int i2, int i3, long OplusGLSurfaceView_15) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.flPos = OplusGLSurfaceView_13;
            groupMetadata.lastChildFlPos = i2;
            groupMetadata.gPos = i3;
            groupMetadata.gId = OplusGLSurfaceView_15;
            return groupMetadata;
        }

        @Override // java.lang.Comparable
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.gPos - groupMetadata.gPos;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            parcel.writeInt(this.flPos);
            parcel.writeInt(this.lastChildFlPos);
            parcel.writeInt(this.gPos);
            parcel.writeLong(this.gId);
        }
    }

    /* renamed from: com.coui.appcompat.widget.ExpandableRecyclerConnector$COUIBaseListPopupWindow_11 */
    public static class C1445g {

        /* renamed from: IntrinsicsJvm.kt_5 */
        private static ArrayList<C1445g> f7908d = new ArrayList<>(5);

        /* renamed from: PlatformImplementations.kt_3 */
        public ExpandableRecyclerPosition f7909a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public GroupMetadata f7910b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f7911c;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m7518c() {
            ExpandableRecyclerPosition c1530x = this.f7909a;
            if (c1530x != null) {
                c1530x.m8247a();
                this.f7909a = null;
            }
            this.f7910b = null;
            this.f7911c = 0;
        }

        private C1445g() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        static C1445g m7517a(int OplusGLSurfaceView_13, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            C1445g c1445gM7519d = m7519d();
            c1445gM7519d.f7909a = ExpandableRecyclerPosition.m8244a(i2, i3, i4, OplusGLSurfaceView_13);
            c1445gM7519d.f7910b = groupMetadata;
            c1445gM7519d.f7911c = i5;
            return c1445gM7519d;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private static C1445g m7519d() {
            synchronized (f7908d) {
                if (f7908d.size() > 0) {
                    C1445g c1445gRemove = f7908d.remove(0);
                    c1445gRemove.m7518c();
                    return c1445gRemove;
                }
                return new C1445g();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7520a() {
            m7518c();
            synchronized (f7908d) {
                if (f7908d.size() < 5) {
                    f7908d.add(this);
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean m7521b() {
            return this.f7910b != null;
        }
    }

    /* renamed from: com.coui.appcompat.widget.ExpandableRecyclerConnector$COUIBaseListPopupWindow_8 */
    private static class C1443e {

        /* renamed from: PlatformImplementations.kt_3 */
        boolean f7902a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean f7903b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f7904c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        C1440b f7905d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f7906e;

        private C1443e() {
            this.f7902a = false;
            this.f7903b = false;
            this.f7904c = -1;
            this.f7906e = -1;
        }
    }
}
