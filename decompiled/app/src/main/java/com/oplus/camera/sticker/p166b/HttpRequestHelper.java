package com.oplus.camera.sticker.p166b;

import android.content.Context;
import com.oplus.camera.CameraLog;
import com.oplus.camera.p153l.MyRegionAdapter;
import com.oplus.camera.sticker.p167c.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: HttpRequestHelper.java */
/* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class HttpRequestHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f16195a;

    /* compiled from: HttpRequestHelper.java */
    /* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo16792a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo16793a(String str);
    }

    /* compiled from: HttpRequestHelper.java */
    /* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public enum IntrinsicsJvm.kt_4 {
        GET,
        POST
    }

    /* compiled from: HttpRequestHelper.java */
    /* renamed from: com.oplus.camera.sticker.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo16718a(String str);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo16719a(ResponseBody responseBody);
    }

    public HttpRequestHelper(Context context) {
        this.f16195a = null;
        this.f16195a = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m16785a(Context context, int OplusGLSurfaceView_13) {
        return m16784a(context) + m16782a(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m16784a(Context context) {
        return MyRegionAdapter.m14510a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m16782a(int OplusGLSurfaceView_13) {
        return "/multi_app/all_sticker.pb?audit_status=" + OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static OkHttpClient m16783a() {
        return OkHttpClientHelper.m16794a().m16795b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Request m16787a(IntrinsicsJvm.kt_4 bVar, String str, Map<String, String> map, RequestBody requestBody) {
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (bVar == IntrinsicsJvm.kt_4.POST) {
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    builderUrl.addHeader(entry.getKey(), entry.getValue());
                }
            }
            if (requestBody != null) {
                builderUrl.post(requestBody);
            }
        } else {
            builderUrl.get();
        }
        return builderUrl.build();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public RequestBody m16788a(byte[] bArr) {
        return RequestBody.create(MediaType.parse("application/x-protobuf"), bArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16790a(Request request, IntrinsicsJvm.kt_3 cVar) {
        m16789a(m16786a(request), cVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16789a(Call call, final IntrinsicsJvm.kt_3 cVar) {
        call.enqueue(new Callback() { // from class: com.oplus.camera.sticker.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.1
            @Override // okhttp3.Callback
            public void onFailure(Call call2, IOException iOException) {
                String message = iOException.getMessage();
                IntrinsicsJvm.kt_3 cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.mo16718a(message);
                }
                CameraLog.m12959b("HttpRequestHelper", "asyncRequest, onFailure, errMsg: " + message);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call2, Response response) throws IOException {
                try {
                    try {
                    } catch (Exception COUIBaseListPopupWindow_8) {
                        String message = COUIBaseListPopupWindow_8.getMessage();
                        if (cVar != null) {
                            cVar.mo16718a(message);
                        }
                        CameraLog.m12959b("HttpRequestHelper", "asyncRequest, onResponse exception! errorMsg: " + message);
                        if (response == null) {
                            return;
                        }
                    }
                    if (response == null) {
                        CameraLog.m12966e("HttpRequestHelper", "asyncRequest, onResponse, null response");
                        if (cVar != null) {
                            cVar.mo16718a("null response");
                        }
                        if (response != null) {
                            response.close();
                            return;
                        }
                        return;
                    }
                    if (response.isSuccessful()) {
                        if (cVar != null) {
                            cVar.mo16719a(response.body());
                        }
                    } else {
                        String strMessage = response.message();
                        if (cVar != null) {
                            cVar.mo16718a(strMessage);
                        }
                        CameraLog.m12959b("HttpRequestHelper", "asyncRequest, onResponse not successful! resMsg: " + strMessage);
                    }
                    if (response == null) {
                        return;
                    }
                    response.close();
                } catch (Throwable th) {
                    if (response != null) {
                        response.close();
                    }
                    throw th;
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16791a(Request request, final String str, final PlatformImplementations.kt_3 aVar) {
        m16783a().newCall(request).enqueue(new Callback() { // from class: com.oplus.camera.sticker.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                String message = iOException.getMessage();
                PlatformImplementations.kt_3 aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.mo16793a(message);
                }
                CameraLog.m12959b("HttpRequestHelper", "downloadFile, onFailure, errMsg: " + message);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws Throwable {
                StringBuilder sb;
                if (response.isSuccessful()) {
                    InputStream inputStreamByteStream = response.body().byteStream();
                    FileOutputStream fileOutputStream = null;
                    try {
                        try {
                            byte[] bArr = new byte[2048];
                            CameraLog.m12959b("HttpRequestHelper", "downloadFile, totalLen: " + response.body().contentLength() + ", destFilePath: " + str);
                            File file = new File(str);
                            if (FileUtils.m16813a(file)) {
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int OplusGLSurfaceView_13 = inputStreamByteStream.read(bArr);
                                        if (OplusGLSurfaceView_13 == -1) {
                                            break;
                                        } else {
                                            fileOutputStream2.write(bArr, 0, OplusGLSurfaceView_13);
                                        }
                                    } catch (IOException COUIBaseListPopupWindow_8) {
                                        COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                                        fileOutputStream = fileOutputStream2;
                                        CameraLog.m12966e("HttpRequestHelper", "downloadFile, onResponse, exception, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
                                        if (inputStreamByteStream != null) {
                                            try {
                                                inputStreamByteStream.close();
                                            } catch (IOException e2) {
                                                CameraLog.m12966e("HttpRequestHelper", "downloadFile, onResponse, exception, ie: " + e2);
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                                return;
                                            } catch (IOException e3) {
                                                COUIBaseListPopupWindow_8 = e3;
                                                sb = new StringBuilder();
                                                sb.append("downloadFile, onResponse, exception, fose: ");
                                                sb.append(COUIBaseListPopupWindow_8);
                                                CameraLog.m12966e("HttpRequestHelper", sb.toString());
                                            }
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        if (inputStreamByteStream != null) {
                                            try {
                                                inputStreamByteStream.close();
                                            } catch (IOException e4) {
                                                CameraLog.m12966e("HttpRequestHelper", "downloadFile, onResponse, exception, ie: " + e4);
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                                throw th;
                                            } catch (IOException e5) {
                                                CameraLog.m12966e("HttpRequestHelper", "downloadFile, onResponse, exception, fose: " + e5);
                                                throw th;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                fileOutputStream2.flush();
                                if (aVar != null) {
                                    aVar.mo16792a();
                                }
                                fileOutputStream = fileOutputStream2;
                            } else {
                                CameraLog.m12967f("HttpRequestHelper", "downloadFile, delete exit file fail! destFilePath: " + str);
                            }
                            if (inputStreamByteStream != null) {
                                try {
                                    inputStreamByteStream.close();
                                } catch (IOException e6) {
                                    CameraLog.m12966e("HttpRequestHelper", "downloadFile, onResponse, exception, ie: " + e6);
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                    COUIBaseListPopupWindow_8 = e7;
                                    sb = new StringBuilder();
                                    sb.append("downloadFile, onResponse, exception, fose: ");
                                    sb.append(COUIBaseListPopupWindow_8);
                                    CameraLog.m12966e("HttpRequestHelper", sb.toString());
                                }
                            }
                        } catch (IOException e8) {
                            COUIBaseListPopupWindow_8 = e8;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    String strMessage = response.message();
                    PlatformImplementations.kt_3 aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.mo16793a(strMessage);
                    }
                    CameraLog.m12959b("HttpRequestHelper", "downloadFile, onResponse not successful! resMsg: " + strMessage);
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Call m16786a(Request request) {
        return m16783a().newCall(request);
    }
}
