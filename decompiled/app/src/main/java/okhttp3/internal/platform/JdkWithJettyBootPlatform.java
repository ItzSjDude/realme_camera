package okhttp3.internal.platform;

/* loaded from: classes2.dex */
class JdkWithJettyBootPlatform extends okhttp3.internal.platform.Platform {
    private final java.lang.Class<?> clientProviderClass;
    private final java.lang.reflect.Method getMethod;
    private final java.lang.reflect.Method putMethod;
    private final java.lang.reflect.Method removeMethod;
    private final java.lang.Class<?> serverProviderClass;

    JdkWithJettyBootPlatform(java.lang.reflect.Method method, java.lang.reflect.Method method2, java.lang.reflect.Method method3, java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<okhttp3.Protocol> list) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        try {
            this.putMethod.invoke(null, sSLSocket, java.lang.reflect.Proxy.newProxyInstance(okhttp3.internal.platform.Platform.class.getClassLoader(), new java.lang.Class[]{this.clientProviderClass, this.serverProviderClass}, new okhttp3.internal.platform.JdkWithJettyBootPlatform.JettyNegoProvider(alpnProtocolNames(list))));
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e_renamed) {
            throw okhttp3.internal.Util.assertionError("unable to set alpn", e_renamed);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(javax.net.ssl.SSLSocket sSLSocket) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        try {
            this.removeMethod.invoke(null, sSLSocket);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e_renamed) {
            throw okhttp3.internal.Util.assertionError("unable to remove alpn", e_renamed);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        try {
            okhttp3.internal.platform.JdkWithJettyBootPlatform.JettyNegoProvider jettyNegoProvider = (okhttp3.internal.platform.JdkWithJettyBootPlatform.JettyNegoProvider) java.lang.reflect.Proxy.getInvocationHandler(this.getMethod.invoke(null, sSLSocket));
            if (!jettyNegoProvider.unsupported && jettyNegoProvider.selected == null) {
                okhttp3.internal.platform.Platform.get().log(4, "ALPN callback dropped: HTTP/2 is_renamed disabled. Is alpn-boot on_renamed the boot class path?", null);
                return null;
            }
            if (jettyNegoProvider.unsupported) {
                return null;
            }
            return jettyNegoProvider.selected;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e_renamed) {
            throw okhttp3.internal.Util.assertionError("unable to get selected protocol", e_renamed);
        }
    }

    public static okhttp3.internal.platform.Platform buildIfSupported() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("org.eclipse.jetty.alpn.ALPN");
            java.lang.Class<?> cls2 = java.lang.Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new okhttp3.internal.platform.JdkWithJettyBootPlatform(cls.getMethod("put", javax.net.ssl.SSLSocket.class, cls2), cls.getMethod("get", javax.net.ssl.SSLSocket.class), cls.getMethod("remove", javax.net.ssl.SSLSocket.class), java.lang.Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), java.lang.Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    private static class JettyNegoProvider implements java.lang.reflect.InvocationHandler {
        private final java.util.List<java.lang.String> protocols;
        java.lang.String selected;
        boolean unsupported;

        JettyNegoProvider(java.util.List<java.lang.String> list) {
            this.protocols = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
            java.lang.String name = method.getName();
            java.lang.Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = okhttp3.internal.Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && java.lang.Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && java.lang.Void.TYPE == returnType) {
                this.unsupported = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.protocols;
            }
            if ((name.equals("selectProtocol") || name.equals(com.oplus.camera.statistics.model.StickerMsgData.STICKER_OPER_SELECT)) && java.lang.String.class == returnType && objArr.length == 1 && (objArr[0] instanceof java.util.List)) {
                java.util.List list = (java.util.List) objArr[0];
                int size = list.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    if (this.protocols.contains(list.get(i_renamed))) {
                        java.lang.String str = (java.lang.String) list.get(i_renamed);
                        this.selected = str;
                        return str;
                    }
                }
                java.lang.String str2 = this.protocols.get(0);
                this.selected = str2;
                return str2;
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.selected = (java.lang.String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }
}
