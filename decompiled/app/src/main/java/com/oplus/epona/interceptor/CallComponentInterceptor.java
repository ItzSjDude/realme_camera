package com.oplus.epona.interceptor;

import com.oplus.epona.Call;
import com.oplus.epona.Constants;
import com.oplus.epona.DynamicProvider;
import com.oplus.epona.Epona;
import com.oplus.epona.Interceptor;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.utils.Logger;

/* loaded from: classes2.dex */
public class CallComponentInterceptor implements Interceptor {
    private static final String TAG = "CallComponentInterceptor";

    @Override // com.oplus.epona.Interceptor
    public void intercept(Interceptor.Chain chain) {
        final Request request = chain.request();
        DynamicProvider dynamicProviderFindComponent = Epona.findComponent(request.getComponentName());
        if (dynamicProviderFindComponent != null) {
            final Call.Callback callback = chain.callback();
            final String string = request.getBundle().getString(Constants.REQUEST_CALLING_PACKAGE_NAME_KEY);
            if (chain.isAsync()) {
                dynamicProviderFindComponent.onCall(request, new Call.Callback() { // from class: com.oplus.epona.interceptor.-$$Lambda$CallComponentInterceptor$HaJXnDRGJuYEbcrwzxOpJHODCQM
                    @Override // com.oplus.epona.Call.Callback
                    public final void onReceive(Response response) {
                        CallComponentInterceptor.lambda$intercept$0(string, request, callback, response);
                    }
                });
                return;
            }
            Response responseOnCall = dynamicProviderFindComponent.onCall(request);
            Object[] objArr = new Object[4];
            if (string == null) {
                string = "";
            }
            objArr[0] = string;
            objArr[1] = request.getComponentName();
            objArr[2] = request.getActionName();
            objArr[3] = responseOnCall;
            Logger.m24999d(TAG, "Caller(%s).Component(%s).Action(%s) response : %s", objArr);
            callback.onReceive(responseOnCall);
            return;
        }
        chain.proceed();
    }

    static /* synthetic */ void lambda$intercept$0(String str, Request request, Call.Callback callback, Response response) {
        Object[] objArr = new Object[4];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        objArr[1] = request.getComponentName();
        objArr[2] = request.getActionName();
        objArr[3] = response;
        Logger.m24999d(TAG, "Caller(%s).Component(%s).Action(%s) response : %s", objArr);
        callback.onReceive(response);
    }
}
