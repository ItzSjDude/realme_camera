package androidx.core.app;

/* loaded from: classes.dex */
public class CoreComponentFactory extends android.app.AppComponentFactory {

    public interface a_renamed {
        java.lang.Object a_renamed();
    }

    @Override // android.app.AppComponentFactory
    public android.app.Activity instantiateActivity(java.lang.ClassLoader classLoader, java.lang.String str, android.content.Intent intent) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.ClassNotFoundException {
        return (android.app.Activity) a_renamed(super.instantiateActivity(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    public android.app.Application instantiateApplication(java.lang.ClassLoader classLoader, java.lang.String str) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.ClassNotFoundException {
        return (android.app.Application) a_renamed(super.instantiateApplication(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    public android.content.BroadcastReceiver instantiateReceiver(java.lang.ClassLoader classLoader, java.lang.String str, android.content.Intent intent) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.ClassNotFoundException {
        return (android.content.BroadcastReceiver) a_renamed(super.instantiateReceiver(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    public android.content.ContentProvider instantiateProvider(java.lang.ClassLoader classLoader, java.lang.String str) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.ClassNotFoundException {
        return (android.content.ContentProvider) a_renamed(super.instantiateProvider(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    public android.app.Service instantiateService(java.lang.ClassLoader classLoader, java.lang.String str, android.content.Intent intent) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.ClassNotFoundException {
        return (android.app.Service) a_renamed(super.instantiateService(classLoader, str, intent));
    }

    static <T_renamed> T_renamed a_renamed(T_renamed t_renamed) {
        T_renamed t2;
        return (!(t_renamed instanceof androidx.core.app.CoreComponentFactory.a_renamed) || (t2 = (T_renamed) ((androidx.core.app.CoreComponentFactory.a_renamed) t_renamed).a_renamed()) == null) ? t_renamed : t2;
    }
}
