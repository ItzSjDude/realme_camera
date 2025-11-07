package com.oplus.camera.sticker.b_renamed;

/* compiled from: HttpRequestHelper.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f5429a;

    /* compiled from: HttpRequestHelper.java */
    /* renamed from: com.oplus.camera.sticker.b_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface HttpRequestHelper_2 {
        void a_renamed();

        void a_renamed(java.lang.String str);
    }

    /* compiled from: HttpRequestHelper.java */
    public enum b_renamed {
        GET,
        POST
    }

    /* compiled from: HttpRequestHelper.java */
    public interface c_renamed {
        void a_renamed(java.lang.String str);

        void a_renamed(okhttp3.ResponseBody responseBody);
    }

    public a_renamed(android.content.Context context) {
        this.f5429a = null;
        this.f5429a = context;
    }

    public java.lang.String a_renamed(android.content.Context context, int i_renamed) {
        return a_renamed(context) + a_renamed(i_renamed);
    }

    public java.lang.String a_renamed(android.content.Context context) {
        return com.oplus.camera.l_renamed.a_renamed.a_renamed(context);
    }

    private java.lang.String a_renamed(int i_renamed) {
        return "/multi_app/all_sticker.pb?audit_status=" + i_renamed;
    }

    private static okhttp3.OkHttpClient a_renamed() {
        return com.oplus.camera.sticker.b_renamed.b_renamed.a_renamed().b_renamed();
    }

    public okhttp3.Request a_renamed(com.oplus.camera.sticker.b_renamed.a_renamed.b_renamed bVar, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, okhttp3.RequestBody requestBody) {
        okhttp3.Request.Builder builderUrl = new okhttp3.Request.Builder().url(str);
        if (bVar == com.oplus.camera.sticker.b_renamed.a_renamed.b_renamed.POST) {
            if (map != null && !map.isEmpty()) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
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

    public okhttp3.RequestBody a_renamed(byte[] bArr) {
        return okhttp3.RequestBody.create(okhttp3.MediaType.parse("application/x_renamed-protobuf"), bArr);
    }

    public void a_renamed(okhttp3.Request request, com.oplus.camera.sticker.b_renamed.a_renamed.c_renamed cVar) {
        a_renamed(a_renamed(request), cVar);
    }

    public void a_renamed(okhttp3.Call call, final com.oplus.camera.sticker.b_renamed.a_renamed.c_renamed cVar) {
        call.enqueue(new okhttp3.Callback() { // from class: com.oplus.camera.sticker.b_renamed.a_renamed.1
            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call2, java.io.IOException iOException) {
                java.lang.String message = iOException.getMessage();
                com.oplus.camera.sticker.b_renamed.a_renamed.c_renamed cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.a_renamed(message);
                }
                com.oplus.camera.e_renamed.b_renamed("HttpRequestHelper", "asyncRequest, onFailure, errMsg: " + message);
            }

            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call2, okhttp3.Response response) throws java.io.IOException {
                try {
                    try {
                    } catch (java.lang.Exception e_renamed) {
                        java.lang.String message = e_renamed.getMessage();
                        if (cVar != null) {
                            cVar.a_renamed(message);
                        }
                        com.oplus.camera.e_renamed.b_renamed("HttpRequestHelper", "asyncRequest, onResponse exception! errorMsg: " + message);
                        if (response == null) {
                            return;
                        }
                    }
                    if (response == null) {
                        com.oplus.camera.e_renamed.e_renamed("HttpRequestHelper", "asyncRequest, onResponse, null response");
                        if (cVar != null) {
                            cVar.a_renamed("null response");
                        }
                        if (response != null) {
                            response.close();
                            return;
                        }
                        return;
                    }
                    if (response.isSuccessful()) {
                        if (cVar != null) {
                            cVar.a_renamed(response.body());
                        }
                    } else {
                        java.lang.String strMessage = response.message();
                        if (cVar != null) {
                            cVar.a_renamed(strMessage);
                        }
                        com.oplus.camera.e_renamed.b_renamed("HttpRequestHelper", "asyncRequest, onResponse not successful! resMsg: " + strMessage);
                    }
                    if (response == null) {
                        return;
                    }
                    response.close();
                } catch (java.lang.Throwable th) {
                    if (response != null) {
                        response.close();
                    }
                    throw th;
                }
            }
        });
    }

    public void a_renamed(okhttp3.Request request, final java.lang.String str, final com.oplus.camera.sticker.b_renamed.a_renamed.HttpRequestHelper_2 interfaceC0116a) {
        a_renamed().newCall(request).enqueue(new okhttp3.Callback() { // from class: com.oplus.camera.sticker.b_renamed.a_renamed.2
            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
                java.lang.String message = iOException.getMessage();
                com.oplus.camera.sticker.b_renamed.a_renamed.HttpRequestHelper_2 interfaceC0116a2 = interfaceC0116a;
                if (interfaceC0116a2 != null) {
                    interfaceC0116a2.a_renamed(message);
                }
                com.oplus.camera.e_renamed.b_renamed("HttpRequestHelper", "downloadFile, onFailure, errMsg: " + message);
            }

            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.lang.Throwable {
                java.lang.StringBuilder sb;
                if (response.isSuccessful()) {
                    java.io.InputStream inputStreamByteStream = response.body().byteStream();
                    java.io.FileOutputStream fileOutputStream = null;
                    try {
                        try {
                            byte[] bArr = new byte[2048];
                            com.oplus.camera.e_renamed.b_renamed("HttpRequestHelper", "downloadFile, totalLen: " + response.body().contentLength() + ", destFilePath: " + str);
                            java.io.File file = new java.io.File(str);
                            if (com.oplus.camera.sticker.c_renamed.b_renamed.a_renamed(file)) {
                                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                                while (true) {
                                    try {
                                        int i_renamed = inputStreamByteStream.read(bArr);
                                        if (i_renamed == -1) {
                                            break;
                                        } else {
                                            fileOutputStream2.write(bArr, 0, i_renamed);
                                        }
                                    } catch (java.io.IOException e_renamed) {
                                        e_renamed = e_renamed;
                                        fileOutputStream = fileOutputStream2;
                                        com.oplus.camera.e_renamed.e_renamed("HttpRequestHelper", "downloadFile, onResponse, exception, e_renamed: " + e_renamed);
                                        if (inputStreamByteStream != null) {
                                            try {
                                                inputStreamByteStream.close();
                                            } catch (java.io.IOException e2) {
                                                com.oplus.camera.e_renamed.e_renamed("HttpRequestHelper", "downloadFile, onResponse, exception, ie: " + e2);
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                                return;
                                            } catch (java.io.IOException e3) {
                                                e_renamed = e3;
                                                sb = new java.lang.StringBuilder();
                                                sb.append("downloadFile, onResponse, exception, fose: ");
                                                sb.append(e_renamed);
                                                com.oplus.camera.e_renamed.e_renamed("HttpRequestHelper", sb.toString());
                                            }
                                        }
                                        return;
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        if (inputStreamByteStream != null) {
                                            try {
                                                inputStreamByteStream.close();
                                            } catch (java.io.IOException e4) {
                                                com.oplus.camera.e_renamed.e_renamed("HttpRequestHelper", "downloadFile, onResponse, exception, ie: " + e4);
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                                throw th;
                                            } catch (java.io.IOException e5) {
                                                com.oplus.camera.e_renamed.e_renamed("HttpRequestHelper", "downloadFile, onResponse, exception, fose: " + e5);
                                                throw th;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                fileOutputStream2.flush();
                                if (interfaceC0116a != null) {
                                    interfaceC0116a.a_renamed();
                                }
                                fileOutputStream = fileOutputStream2;
                            } else {
                                com.oplus.camera.e_renamed.f_renamed("HttpRequestHelper", "downloadFile, delete exit file fail! destFilePath: " + str);
                            }
                            if (inputStreamByteStream != null) {
                                try {
                                    inputStreamByteStream.close();
                                } catch (java.io.IOException e6) {
                                    com.oplus.camera.e_renamed.e_renamed("HttpRequestHelper", "downloadFile, onResponse, exception, ie: " + e6);
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (java.io.IOException e7) {
                                    e_renamed = e7;
                                    sb = new java.lang.StringBuilder();
                                    sb.append("downloadFile, onResponse, exception, fose: ");
                                    sb.append(e_renamed);
                                    com.oplus.camera.e_renamed.e_renamed("HttpRequestHelper", sb.toString());
                                }
                            }
                        } catch (java.io.IOException e8) {
                            e_renamed = e8;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                } else {
                    java.lang.String strMessage = response.message();
                    com.oplus.camera.sticker.b_renamed.a_renamed.HttpRequestHelper_2 interfaceC0116a2 = interfaceC0116a;
                    if (interfaceC0116a2 != null) {
                        interfaceC0116a2.a_renamed(strMessage);
                    }
                    com.oplus.camera.e_renamed.b_renamed("HttpRequestHelper", "downloadFile, onResponse not successful! resMsg: " + strMessage);
                }
            }
        });
    }

    public okhttp3.Call a_renamed(okhttp3.Request request) {
        return a_renamed().newCall(request);
    }
}
