package com.oplus.camera.algovisualization;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;
import com.coui.appcompat.widget.toolbar.COUIToolbar;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.p172ui.menu.APSVisualizationDialog;

/* compiled from: NetworkAuthenticationUtils.java */
/* renamed from: com.oplus.camera.algovisualization.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class NetworkAuthenticationUtils {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private COUIToolbar f12523c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Context f12524d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f12525e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f12526f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f12527g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f12528h;

    /* renamed from: OplusGLSurfaceView_13 */
    private String f12529i;

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f12521a = 8;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final long f12522b = AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;

    /* renamed from: OplusGLSurfaceView_15 */
    private long[] f12530j = new long[8];

    public NetworkAuthenticationUtils(COUIToolbar cOUIToolbar, Context context, String str, String str2, String str3, String str4, String str5) {
        this.f12523c = null;
        this.f12524d = null;
        this.f12525e = "";
        this.f12526f = "";
        this.f12527g = "";
        this.f12528h = "";
        this.f12529i = "";
        this.f12523c = cOUIToolbar;
        this.f12524d = context;
        this.f12525e = str;
        this.f12526f = str2;
        this.f12527g = str3;
        this.f12528h = str4;
        this.f12529i = str5;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11633a() {
        this.f12523c.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.algovisualization.COUIBaseListPopupWindow_10.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                System.arraycopy(NetworkAuthenticationUtils.this.f12530j, 1, NetworkAuthenticationUtils.this.f12530j, 0, NetworkAuthenticationUtils.this.f12530j.length - 1);
                NetworkAuthenticationUtils.this.f12530j[NetworkAuthenticationUtils.this.f12530j.length - 1] = SystemClock.uptimeMillis();
                if (NetworkAuthenticationUtils.this.f12530j[0] >= SystemClock.uptimeMillis() - AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    SharedPreferences sharedPreferences = NetworkAuthenticationUtils.this.f12524d.getSharedPreferences(NetworkAuthenticationUtils.this.f12525e, 0);
                    if (sharedPreferences.getBoolean(NetworkAuthenticationUtils.this.f12526f, false)) {
                        Toast.makeText(NetworkAuthenticationUtils.this.f12524d, NetworkAuthenticationUtils.this.f12528h, 0).show();
                    } else {
                        new APSVisualizationDialog(NetworkAuthenticationUtils.this.f12524d, sharedPreferences, NetworkAuthenticationUtils.this.f12526f, NetworkAuthenticationUtils.this.f12529i, NetworkAuthenticationUtils.this.f12527g).show();
                    }
                    NetworkAuthenticationUtils.this.f12530j = new long[8];
                }
            }
        });
    }
}
