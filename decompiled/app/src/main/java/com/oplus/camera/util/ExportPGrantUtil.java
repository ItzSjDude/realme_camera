package com.oplus.camera.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.dialog.panel.COUIBottomSheetDialog;
import com.coui.appcompat.widget.COUIButton;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.modepanel.NonFlingRecycleView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ExportPGrantUtil.java */
/* renamed from: com.oplus.camera.util.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class ExportPGrantUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23066a = "COUIBaseListPopupWindow_11";

    /* compiled from: ExportPGrantUtil.java */
    /* renamed from: com.oplus.camera.util.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12686a(AppCompatDialog dialogC0208f);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo12687a(AppCompatDialog dialogC0208f, boolean z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24539a(Activity activity, String str, IntrinsicsJvm.kt_4 bVar) {
        if (TextUtils.isEmpty(str)) {
            CameraLog.m12954a(f23066a, "showPermissionGrantDialog, permission: " + str);
            return;
        }
        m24540a(activity, new String[]{str}, bVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24540a(Activity activity, String[] strArr, final IntrinsicsJvm.kt_4 bVar) {
        if (activity == null) {
            return;
        }
        if (strArr == null || strArr.length == 0) {
            CameraLog.m12954a(f23066a, "showPermissionGrantDialog, permissions is empty..");
            return;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        if (arrayList.contains("android.permission.READ_EXTERNAL_STORAGE") && arrayList.contains("android.permission.READ_EXTERNAL_STORAGE")) {
            arrayList.remove("android.permission.READ_EXTERNAL_STORAGE");
        }
        if (arrayList.contains("android.permission.ACCESS_COARSE_LOCATION") && arrayList.contains("android.permission.ACCESS_FINE_LOCATION")) {
            arrayList.remove("android.permission.ACCESS_COARSE_LOCATION");
        }
        final IntrinsicsJvm.kt_3 cVar = new IntrinsicsJvm.kt_3(activity, R.style.DefaultBottomSheetDialog);
        cVar.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.oplus.camera.util.-$$Lambda$COUIBaseListPopupWindow_11$4vnD3yW_VK533aRjgqPk4qeg1tc
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
                return ExportPGrantUtil.m24542a(bVar, cVar, dialogInterface, OplusGLSurfaceView_13, keyEvent);
            }
        });
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.camera_pg_dialog_content_layout, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id_renamed.pg_content_layout);
        NonFlingRecycleView nonFlingRecycleView = (NonFlingRecycleView) viewInflate.findViewById(R.id_renamed.pg_recycleview);
        nonFlingRecycleView.setLayoutManager(new LinearLayoutManager(activity));
        nonFlingRecycleView.setAdapter(new PlatformImplementations.kt_3(activity, arrayList));
        COUIButton cOUIButton = (COUIButton) viewInflate.findViewById(R.id_renamed.btn_confirm);
        TextView textView = (TextView) viewInflate.findViewById(R.id_renamed.txt_exit);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id_renamed.txt_title);
        cOUIButton.setText(R.string.camera_permissition_grant_sure);
        textView.setText(R.string.camera_permissition_grant_cancel);
        textView2.setText(R.string.camera_permissition_dialog_title);
        cOUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.util.-$$Lambda$COUIBaseListPopupWindow_11$WRorQWtfTQjxLDiCnnZlozI6OOw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportPGrantUtil.m24544b(bVar, cVar, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.util.-$$Lambda$COUIBaseListPopupWindow_11$es9lHb36pszNyH7sNZVKxPrGh1I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportPGrantUtil.m24541a(bVar, cVar, view);
            }
        });
        if (Util.m24498u()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewInflate.getLayoutParams();
            layoutParams.width = Util.m24194V();
            layoutParams.bottomMargin = (int) activity.getResources().getDimension(R.dimen.full_page_statement_margin_bottom);
            layoutParams.addRule(14);
            viewInflate.setLayoutParams(layoutParams);
            viewFindViewById.setBackgroundResource(R.drawable.folder_pg_dialog_bg);
        } else {
            viewFindViewById.setBackgroundResource(R.drawable.pg_dialog_bg);
        }
        viewInflate.setForceDarkAllowed(true);
        cVar.m6814c(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.setCancelable(false);
        cVar.supportRequestWindowFeature(1);
        cVar.getWindow().setBackgroundDrawable(new ColorDrawable(activity.getColor(R.color.color_black_with_40_percent_transparency)));
        cVar.getWindow().setNavigationBarColor(activity.getColor(R.color.camera_white));
        cVar.setContentView(viewInflate);
        cVar.getBehavior().setDraggable(false);
        cVar.m6812c().getDragView().setVisibility(4);
        cVar.m6804a(new ColorDrawable(0));
        cVar.show();
        if (bVar != null) {
            bVar.mo12686a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ boolean m24542a(IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_3 cVar, DialogInterface dialogInterface, int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (OplusGLSurfaceView_13 != 4) {
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar.mo12687a(cVar, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ void m24544b(IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_3 cVar, View view) {
        if (bVar != null) {
            bVar.mo12687a(cVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m24541a(IntrinsicsJvm.kt_4 bVar, IntrinsicsJvm.kt_3 cVar, View view) {
        if (bVar != null) {
            bVar.mo12687a(cVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public static String m24545c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1888586689:
                    if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -406040016:
                    if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 463403621:
                    if (str.equals("android.permission.CAMERA")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1365911975:
                    if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1831139720:
                    if (str.equals("android.permission.RECORD_AUDIO")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                return context.getString(R.string.camera_permission_name_camera);
            }
            if (c2 == 1 || c2 == 2) {
                return context.getString(R.string.camera_permission_name_storage);
            }
            if (c2 == 3) {
                return context.getString(R.string.camera_permission_name_microphone);
            }
            if (c2 == 4 || c2 == 5) {
                return context.getString(R.string.camera_permission_name_location);
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public static String m24546d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1888586689:
                    if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -406040016:
                    if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 463403621:
                    if (str.equals("android.permission.CAMERA")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1365911975:
                    if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1831139720:
                    if (str.equals("android.permission.RECORD_AUDIO")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                return context.getString(R.string.camera_permission_usage_camera);
            }
            if (c2 == 1 || c2 == 2) {
                return context.getString(R.string.group_custom_detail_message_storage);
            }
            if (c2 == 3) {
                return context.getString(R.string.group_custom_detail_message_mic_new);
            }
            if (c2 == 4 || c2 == 5) {
                return context.getString(R.string.group_custom_detail_message_location);
            }
        }
        return "";
    }

    /* compiled from: ExportPGrantUtil.java */
    /* renamed from: com.oplus.camera.util.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0685a<ExportPGrantUtil_4> {

        /* renamed from: PlatformImplementations.kt_3 */
        private Context f23067a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private List<String> f23068b;

        public PlatformImplementations.kt_3(Context context, List<String> list) {
            this.f23067a = context;
            this.f23068b = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public ExportPGrantUtil_4 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
            return new ExportPGrantUtil_4(LayoutInflater.from(this.f23067a).inflate(R.layout.camera_pg_item_layout, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ExportPGrantUtil_4 c4130a, int OplusGLSurfaceView_13) {
            String strM24545c = ExportPGrantUtil.m24545c(this.f23067a, this.f23068b.get(OplusGLSurfaceView_13));
            String strM24546d = ExportPGrantUtil.m24546d(this.f23067a, this.f23068b.get(OplusGLSurfaceView_13));
            c4130a.f23069a.setText(strM24545c);
            c4130a.f23070b.setText(strM24546d);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
        public int getItemCount() {
            List<String> list = this.f23068b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* compiled from: ExportPGrantUtil.java */
        /* renamed from: com.oplus.camera.util.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3$PlatformImplementations.kt_3, reason: collision with other inner class name */
        public class ExportPGrantUtil_4 extends RecyclerView.AbstractC0707w {

            /* renamed from: PlatformImplementations.kt_3 */
            TextView f23069a;

            /* renamed from: IntrinsicsJvm.kt_4 */
            TextView f23070b;

            public ExportPGrantUtil_4(View view) {
                super(view);
                this.f23069a = (TextView) view.findViewById(R.id_renamed.pg_item_title_tv);
                this.f23070b = (TextView) view.findViewById(R.id_renamed.pg_item_title_desc);
            }
        }
    }

    /* compiled from: ExportPGrantUtil.java */
    /* renamed from: com.oplus.camera.util.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_3 */
    static class IntrinsicsJvm.kt_3 extends COUIBottomSheetDialog {
        public IntrinsicsJvm.kt_3(Context context, int OplusGLSurfaceView_13) {
            super(context, OplusGLSurfaceView_13);
        }

        @Override // com.coui.appcompat.dialog.panel.COUIBottomSheetDialog, android.app.Dialog, android.view.Window.Callback
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            getWindow().setNavigationBarColor(getContext().getColor(R.color.camera_white));
        }
    }
}
