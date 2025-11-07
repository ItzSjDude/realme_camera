package com.oplus.camera.longexposure;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.p034f.BidiFormatter;
import androidx.core.p034f.TextDirectionHeuristicsCompat;
import androidx.core.p034f.TextUtilsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.widget.GuideTextView;
import java.util.List;
import java.util.Locale;

/* compiled from: LongExposureBottomGuideAdapter.java */
/* renamed from: com.oplus.camera.longexposure.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class LongExposureBottomGuideAdapter extends RecyclerView.AbstractC0685a<PlatformImplementations.kt_3> {

    /* renamed from: PlatformImplementations.kt_3 */
    private List<LongExposureBottomGuideItem> f14524a;

    public LongExposureBottomGuideAdapter(List<LongExposureBottomGuideItem> list) {
        this.f14524a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PlatformImplementations.kt_3 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.long_exposure_bottom_guide_item, viewGroup, false));
        aVar.setIsRecyclable(true);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13) {
        LongExposureBottomGuideItem c2798b = this.f14524a.get(OplusGLSurfaceView_13);
        if (aVar.f14525a != null) {
            aVar.f14525a.setText(c2798b.m14558a());
            m14555a(aVar.f14525a);
        }
        if (aVar.f14526b != null) {
            aVar.f14526b.setText(c2798b.m14559b());
        }
        if (aVar.f14527c != null) {
            aVar.f14527c.setImageDrawable(c2798b.m14560c());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        return this.f14524a.size();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14555a(TextView textView) {
        String string;
        int iIndexOf;
        try {
            if (1 != TextUtilsCompat.m2525a(Locale.getDefault()) || textView == null || textView.getText() == null || (iIndexOf = (string = textView.getText().toString()).indexOf(40)) <= 0 || iIndexOf >= string.length()) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            String strSubstring = string.substring(0, iIndexOf);
            String strSubstring2 = string.substring(iIndexOf);
            stringBuffer.append(strSubstring);
            stringBuffer.append(strSubstring2);
            textView.setText(BidiFormatter.m2481a(true).m2488a(stringBuffer, TextDirectionHeuristicsCompat.f2926e));
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("LongExposureBottomGuideAdapter", " setRtlProfessionalTitleText error : " + COUIBaseListPopupWindow_8.toString());
        }
    }

    /* compiled from: LongExposureBottomGuideAdapter.java */
    /* renamed from: com.oplus.camera.longexposure.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0707w {

        /* renamed from: PlatformImplementations.kt_3 */
        GuideTextView f14525a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        GuideTextView f14526b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        ImageView f14527c;

        public PlatformImplementations.kt_3(View view) {
            super(view);
            this.f14525a = (GuideTextView) view.findViewById(R.id_renamed.long_exposure_scene_title);
            this.f14526b = (GuideTextView) view.findViewById(R.id_renamed.long_exposure_scene_description);
            this.f14527c = (ImageView) view.findViewById(R.id_renamed.iv_long_exposure_scene);
        }
    }
}
