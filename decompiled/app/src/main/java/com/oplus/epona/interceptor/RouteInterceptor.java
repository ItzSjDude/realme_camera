package com.oplus.epona.interceptor;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.exoplayer2.C1547C;
import com.oplus.epona.Call;
import com.oplus.epona.Constants;
import com.oplus.epona.Epona;
import com.oplus.epona.Interceptor;
import com.oplus.epona.Request;
import com.oplus.epona.Response;
import com.oplus.epona.route.RouteData;
import com.oplus.epona.route.RouteInfo;
import com.oplus.epona.utils.Logger;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class RouteInterceptor implements Interceptor {
    private static final String FRAGMENT_V4 = "androidx.fragment.app.Fragment";
    private static final String FRAGMENT_X = "androidx.fragment.app.Fragment";
    private static final String TAG = "RouteInterceptor";

    @Override // com.oplus.epona.Interceptor
    public void intercept(Interceptor.Chain chain) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Request request = chain.request();
        String componentName = request.getComponentName();
        RouteInfo routeInfoFindRoute = Epona.findRoute(componentName);
        if (routeInfoFindRoute == null) {
            chain.proceed();
            return;
        }
        String string = request.getBundle().getString(Constants.REQUEST_CALLING_PACKAGE_NAME_KEY);
        Object[] objArr = new Object[2];
        if (string == null) {
            string = "";
        }
        objArr[0] = string;
        objArr[1] = componentName;
        Logger.m24999d(TAG, "Caller(%s).Component(%s): found.", objArr);
        Call.Callback callback = chain.callback();
        int routeType = routeInfoFindRoute.getRouteType();
        if (routeType == 0) {
            navigateActivity(request, routeInfoFindRoute);
            callback.onReceive(Response.newResponse(null));
        } else {
            if (routeType == 1) {
                Object objNavigateFragment = navigateFragment(request, routeInfoFindRoute);
                if (objNavigateFragment == null) {
                    callback.onReceive(Response.errorResponse("Fetch fragment instance not found."));
                    return;
                }
                Response responseNewResponse = Response.newResponse(new Bundle());
                responseNewResponse.setData(objNavigateFragment);
                callback.onReceive(responseNewResponse);
                return;
            }
            callback.onReceive(Response.errorResponse("Route type not found."));
        }
    }

    private void navigateActivity(Request request, RouteInfo routeInfo) {
        RouteData routeData = request.getRouteData();
        if (routeData == null || routeData.getContext() == null) {
            Context context = Epona.getContext();
            Intent intent = new Intent(context, routeInfo.getClazz());
            intent.putExtras(request.getBundle());
            intent.setFlags(C1547C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
            return;
        }
        Context context2 = routeData.getContext();
        Intent intent2 = new Intent(context2, routeInfo.getClazz());
        intent2.putExtras(request.getBundle());
        int requestCode = routeData.getRequestCode();
        if (requestCode >= 0 && (context2 instanceof Activity)) {
            ((Activity) context2).startActivityForResult(intent2, requestCode);
        } else {
            context2.startActivity(intent2);
        }
    }

    private Object navigateFragment(Request request, RouteInfo routeInfo) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = routeInfo.getClazz().getConstructor(new Class[0]).newInstance(new Object[0]);
            if (objNewInstance instanceof Fragment) {
                ((Fragment) objNewInstance).setArguments(request.getBundle());
                return objNewInstance;
            }
            if (Class.forName("androidx.fragment.app.Fragment").isInstance(objNewInstance)) {
                Class.forName("androidx.fragment.app.Fragment").getMethod("setArguments", Bundle.class).invoke(objNewInstance, request.getBundle());
                return objNewInstance;
            }
            if (!Class.forName("androidx.fragment.app.Fragment").isInstance(objNewInstance)) {
                return null;
            }
            Class.forName("androidx.fragment.app.Fragment").getMethod("setArguments", Bundle.class).invoke(objNewInstance, request.getBundle());
            return objNewInstance;
        } catch (Exception COUIBaseListPopupWindow_8) {
            Logger.m25000e(TAG, "Fetch fragment instance error with Component(%s), message:%s", request.getComponentName(), COUIBaseListPopupWindow_8.toString());
            return null;
        }
    }
}
