package com.oplus.camera.p172ui.modepanel;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: ModeAdapter.java */
/* renamed from: com.oplus.camera.ui.modepanel.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class ModeAdapter extends BaseModeInfoAdapter<PlatformImplementations.kt_3> {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f20568b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f20569c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20570d;

    public ModeAdapter(Activity activity) {
        super(activity);
        this.f20568b = 0;
        this.f20569c = R.layout.item_headline;
        this.f20570d = 0;
        this.f20570d = activity.getResources().getDimensionPixelOffset(R.dimen.vertical_headline_text_max_width);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PlatformImplementations.kt_3 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        return new PlatformImplementations.kt_3(LayoutInflater.from(this.f20497a).inflate(this.f20569c, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public void onBindViewHolder(RecyclerView.AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) abstractC0707w;
        if (aVar == null || aVar.f20572b == null) {
            return;
        }
        ModeInfo c3353k = m21774b().get(OplusGLSurfaceView_13);
        m21902a(aVar, c3353k.m21919a());
        aVar.f20572b.setTextColor(c3353k.m21933g() ? this.f20497a.getColor(R.color.color_white_with_full_percent_transparency) : this.f20497a.getColor(R.color.color_white_with_10_percent_transparency));
        aVar.f20572b.setTypeface(Util.m24411c(true));
        aVar.itemView.setVisibility(c3353k.m21930e());
        m21905a(aVar);
        m21903b(aVar);
        aVar.itemView.setTag(R.id_renamed.tag_recycle_view_mode_info, c3353k);
    }

    /* compiled from: ModeAdapter.java */
    /* renamed from: com.oplus.camera.ui.modepanel.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    protected class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0707w {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private TextView f20572b;

        public PlatformImplementations.kt_3(View view) {
            super(view);
            this.f20572b = (TextView) view.findViewById(R.id_renamed.item_mode);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m21906c(int OplusGLSurfaceView_13) {
        this.f20568b = OplusGLSurfaceView_13;
        if (OplusGLSurfaceView_13 == 1) {
            this.f20569c = R.layout.item_headline_vertical;
        } else {
            this.f20569c = R.layout.item_headline;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m21903b(PlatformImplementations.kt_3 aVar) {
        if (this.f20568b == 1) {
            GradientDrawable gradientDrawable = (GradientDrawable) aVar.f20572b.getBackground();
            gradientDrawable.setColor(this.f20497a.getColor(R.color.color_white_with_10_percent_transparency));
            aVar.f20572b.setBackground(gradientDrawable);
        } else {
            GradientDrawable gradientDrawable2 = (GradientDrawable) aVar.itemView.getBackground();
            gradientDrawable2.setColor(this.f20497a.getColor(R.color.color_white_with_10_percent_transparency));
            aVar.itemView.setBackground(gradientDrawable2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21905a(PlatformImplementations.kt_3 aVar) throws Resources.NotFoundException {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) aVar.itemView.getLayoutParams();
        Resources resources = this.f20497a.getResources();
        int OplusGLSurfaceView_13 = this.f20568b;
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 4) {
                int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.fold_headline_recycle_view_item_padding_left_right);
                marginLayoutParams.setMarginStart(dimensionPixelOffset);
                marginLayoutParams.setMarginEnd(dimensionPixelOffset);
                aVar.itemView.setLayoutParams(marginLayoutParams);
                return;
            }
            return;
        }
        marginLayoutParams.topMargin = resources.getDimensionPixelOffset(R.dimen.mode_edit_head_line_vertical_item_gap);
        aVar.itemView.setLayoutParams(marginLayoutParams);
        String strSubstring = (String) aVar.f20572b.getText();
        if (strSubstring.contains("\OplusGLSurfaceView_11")) {
            String strSubstring2 = strSubstring.substring(0, strSubstring.indexOf("\OplusGLSurfaceView_11"));
            strSubstring = strSubstring.substring(strSubstring.indexOf("\OplusGLSurfaceView_11") + 1);
            if (strSubstring2.length() > strSubstring.length()) {
                strSubstring = strSubstring2;
            }
            aVar.f20572b.setBackground(this.f20497a.getResources().getDrawable(R.drawable.vertical_mode_edit_bg_double_line_drawable));
        }
        int dimensionPixelOffset2 = (resources.getDimensionPixelOffset(R.dimen.mode_edit_head_line_vertical_width) - ((int) aVar.f20572b.getPaint().measureText(strSubstring))) / 2;
        if (dimensionPixelOffset2 < resources.getDimensionPixelSize(R.dimen.headline_recycle_view_vertical_text_padding_left_right)) {
            aVar.f20572b.setPaddingRelative(dimensionPixelOffset2, aVar.f20572b.getPaddingTop(), dimensionPixelOffset2, aVar.f20572b.getPaddingBottom());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m21902a(PlatformImplementations.kt_3 aVar, String str) {
        if (this.f20568b != 1) {
            aVar.f20572b.setText(str);
            return;
        }
        TextPaint paint = aVar.f20572b.getPaint();
        if (paint == null) {
            aVar.f20572b.setText(str);
            return;
        }
        if (paint.measureText(str) <= this.f20570d) {
            aVar.f20572b.setText(str);
            return;
        }
        if (str.contains(" ") && paint.measureText(str.substring(0, str.indexOf(" "))) < this.f20570d) {
            aVar.f20572b.setText(str.replaceFirst("\\s", "\OplusGLSurfaceView_11"));
            return;
        }
        int OplusGLSurfaceView_13 = 1;
        while (OplusGLSurfaceView_13 < str.length() && paint.measureText(str.substring(0, OplusGLSurfaceView_13)) < this.f20570d) {
            OplusGLSurfaceView_13++;
        }
        int i2 = OplusGLSurfaceView_13 - 1;
        String strSubstring = str.substring(0, i2);
        if (paint.measureText(str.substring(i2)) <= this.f20570d) {
            aVar.f20572b.setText(new StringBuffer(str).insert(i2, "\OplusGLSurfaceView_11").toString());
            return;
        }
        int i3 = i2 + 1;
        while (i3 < str.length()) {
            if (paint.measureText(str.substring(i2, i3) + "...") >= this.f20570d) {
                break;
            } else {
                i3++;
            }
        }
        aVar.f20572b.setText(strSubstring + str.substring(i2, i3 - 1) + "...");
    }
}
