package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.Preference;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import coui.support.appcompat.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUIRecommendedPreference extends Preference {

    /* renamed from: PlatformImplementations.kt_3 */
    private List<C1326c> f6975a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float f6976b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f6977c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private COUIRecommendedDrawable f6978d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f6979e;

    /* renamed from: com.coui.appcompat.preference.COUIRecommendedPreference$PlatformImplementations.kt_3 */
    public interface InterfaceC1324a {
        /* renamed from: PlatformImplementations.kt_3 */
        void m6917a(View view);
    }

    public COUIRecommendedPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiRecommendedPreferenceStyle);
    }

    public COUIRecommendedPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUIRecommendedPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        m3811a(R.layout.coui_recommended_preference_layout);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIRecommendedPreference, OplusGLSurfaceView_13, 0);
        this.f6976b = typedArrayObtainStyledAttributes.getDimension(R.styleable.COUIRecommendedPreference_recommendedCardBgRadius, m3800K().getResources().getDimension(R.dimen.recommended_preference_list_card_radius));
        this.f6977c = typedArrayObtainStyledAttributes.getColor(R.styleable.COUIRecommendedPreference_recommendedCardBgColor, m3800K().getResources().getColor(R.color.bottom_recommended_recycler_view_bg));
        this.f6978d = new COUIRecommendedDrawable(this.f6976b, this.f6977c);
        this.f6979e = typedArrayObtainStyledAttributes.getString(R.styleable.COUIRecommendedPreference_recommendedHeaderTitle);
        if (this.f6979e == null) {
            this.f6979e = m3800K().getResources().getString(R.string.bottom_recommended_header_title);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        RecyclerView recyclerView = (RecyclerView) c0668l.itemView;
        recyclerView.setBackground(this.f6978d);
        RecyclerView.AbstractC0685a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(m3800K()));
            recyclerView.setAdapter(new C1325b(m3800K(), this.f6975a, this.f6979e));
        } else {
            ((C1325b) adapter).m6920a(this.f6975a, this.f6979e);
        }
        recyclerView.setFocusable(false);
    }

    /* renamed from: com.coui.appcompat.preference.COUIRecommendedPreference$IntrinsicsJvm.kt_4 */
    private static class C1325b extends RecyclerView.AbstractC0685a<C1327d> {

        /* renamed from: PlatformImplementations.kt_3 */
        private Context f6980a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private List<C1326c> f6981b = new ArrayList();

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        public int getItemViewType(int OplusGLSurfaceView_13) {
            return OplusGLSurfaceView_13 == 0 ? 0 : 1;
        }

        public C1325b(Context context, List<C1326c> list, String str) {
            this.f6980a = context;
            m6920a(list, str);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m6920a(List<C1326c> list, String str) {
            this.f6981b.clear();
            if (list != null) {
                this.f6981b.addAll(list);
                this.f6981b.add(0, new C1326c(str));
            }
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public C1327d onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 0) {
                return new C1327d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recommended_head_textview, viewGroup, false));
            }
            return new C1327d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recommended_common_textview, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(C1327d c1327d, int OplusGLSurfaceView_13) {
            final C1326c c1326c = this.f6981b.get(OplusGLSurfaceView_13);
            c1327d.f6986a.setText(c1326c.f6984a);
            if (OplusGLSurfaceView_13 <= 0) {
                if (OplusGLSurfaceView_13 == 0) {
                    c1327d.f6987b.setClickable(false);
                }
            } else {
                if (OplusGLSurfaceView_13 == getItemCount() - 1) {
                    c1327d.f6987b.setPaddingRelative(c1327d.f6987b.getPaddingStart(), c1327d.f6987b.getPaddingTop(), c1327d.f6987b.getPaddingEnd(), this.f6980a.getResources().getDimensionPixelOffset(R.dimen.recommended_recyclerView_padding_bottom));
                    c1327d.f6987b.setBackgroundAnimationDrawable(this.f6980a.getDrawable(R.drawable.coui_recommended_last_bg));
                }
                c1327d.f6987b.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUIRecommendedPreference.IntrinsicsJvm.kt_4.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (c1326c.f6985b != null) {
                            c1326c.f6985b.m6917a(view);
                        }
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        public int getItemCount() {
            return this.f6981b.size();
        }
    }

    /* renamed from: com.coui.appcompat.preference.COUIRecommendedPreference$IntrinsicsJvm.kt_3 */
    public static class C1326c {

        /* renamed from: PlatformImplementations.kt_3 */
        private String f6984a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private InterfaceC1324a f6985b;

        public C1326c(String str) {
            this.f6984a = str;
        }
    }

    /* renamed from: com.coui.appcompat.preference.COUIRecommendedPreference$IntrinsicsJvm.kt_5 */
    private static class C1327d extends RecyclerView.AbstractC0707w {

        /* renamed from: PlatformImplementations.kt_3 */
        private TextView f6986a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private ListSelectedItemLayout f6987b;

        public C1327d(View view) {
            super(view);
            this.f6987b = (ListSelectedItemLayout) view;
            this.f6986a = (TextView) view.findViewById(R.id_renamed.txt_content);
            this.f6987b.setClickable(true);
        }
    }
}
