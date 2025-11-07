package com.oplus.epona.interceptor;

/* loaded from: classes2.dex */
public class RouteInterceptor implements com.oplus.epona.Interceptor {
    private static final java.lang.String FRAGMENT_V4 = "androidx.fragment.app.Fragment";
    private static final java.lang.String FRAGMENT_X = "androidx.fragment.app.Fragment";
    private static final java.lang.String TAG = "RouteInterceptor";

    @Override // com.oplus.epona.Interceptor
    public void intercept(com.oplus.epona.Interceptor.Chain chain) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.oplus.epona.Request request = chain.request();
        java.lang.String componentName = request.getComponentName();
        com.oplus.epona.route.RouteInfo routeInfoFindRoute = com.oplus.epona.Epona.findRoute(componentName);
        if (routeInfoFindRoute == null) {
            chain.proceed();
            return;
        }
        java.lang.String string = request.getBundle().getString(com.oplus.epona.Constants.REQUEST_CALLING_PACKAGE_NAME_KEY);
        java.lang.Object[] objArr = new java.lang.Object[2];
        if (string == null) {
            string = "";
        }
        objArr[0] = string;
        objArr[1] = componentName;
        com.oplus.epona.utils.Logger.d_renamed(TAG, "Caller(%s_renamed).Component(%s_renamed): found.", objArr);
        com.oplus.epona.Call.Callback callback = chain.callback();
        int routeType = routeInfoFindRoute.getRouteType();
        if (routeType == 0) {
            navigateActivity(request, routeInfoFindRoute);
            callback.onReceive(com.oplus.epona.Response.newResponse(null));
        } else {
            if (routeType == 1) {
                java.lang.Object objNavigateFragment = navigateFragment(request, routeInfoFindRoute);
                if (objNavigateFragment == null) {
                    callback.onReceive(com.oplus.epona.Response.errorResponse("Fetch fragment instance not found."));
                    return;
                }
                com.oplus.epona.Response responseNewResponse = com.oplus.epona.Response.newResponse(new android.os.Bundle());
                responseNewResponse.setData(objNavigateFragment);
                callback.onReceive(responseNewResponse);
                return;
            }
            callback.onReceive(com.oplus.epona.Response.errorResponse("Route type not found."));
        }
    }

    private void navigateActivity(com.oplus.epona.Request request, com.oplus.epona.route.RouteInfo routeInfo) {
        com.oplus.epona.route.RouteData routeData = request.getRouteData();
        if (routeData == null || routeData.getContext() == null) {
            android.content.Context context = com.oplus.epona.Epona.getContext();
            android.content.Intent intent = new android.content.Intent(context, routeInfo.getClazz());
            intent.putExtras(request.getBundle());
            intent.setFlags(com.google.android.exoplayer2.C_renamed.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
            return;
        }
        android.content.Context context2 = routeData.getContext();
        android.content.Intent intent2 = new android.content.Intent(context2, routeInfo.getClazz());
        intent2.putExtras(request.getBundle());
        int requestCode = routeData.getRequestCode();
        if (requestCode >= 0 && (context2 instanceof android.app.Activity)) {
            ((android.app.Activity) context2).startActivityForResult(intent2, requestCode);
        } else {
            context2.startActivity(intent2);
        }
    }

    private java.lang.Object navigateFragment(com.oplus.epona.Request request, com.oplus.epona.route.RouteInfo routeInfo) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        try {
            java.lang.Object objNewInstance = routeInfo.getClazz().getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
            if (objNewInstance instanceof android.app.Fragment) {
                ((android.app.Fragment) objNewInstance).setArguments(request.getBundle());
                return objNewInstance;
            }
            if (java.lang.Class.forName("androidx.fragment.app.Fragment").isInstance(objNewInstance)) {
                java.lang.Class.forName("androidx.fragment.app.Fragment").getMethod("setArguments", android.os.Bundle.class).invoke(objNewInstance, request.getBundle());
                return objNewInstance;
            }
            if (!java.lang.Class.forName("androidx.fragment.app.Fragment").isInstance(objNewInstance)) {
                return null;
            }
            java.lang.Class.forName("androidx.fragment.app.Fragment").getMethod("setArguments", android.os.Bundle.class).invoke(objNewInstance, request.getBundle());
            return objNewInstance;
        } catch (java.lang.Exception e_renamed) {
            com.oplus.epona.utils.Logger.e_renamed(TAG, "Fetch fragment instance error with Component(%s_renamed), message:%s_renamed", request.getComponentName(), e_renamed.toString());
            return null;
        }
    }
}
