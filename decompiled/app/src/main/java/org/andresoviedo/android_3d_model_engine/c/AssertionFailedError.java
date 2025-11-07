package org.andresoviedo.android_3d_model_engine.c_renamed;

/* compiled from: LoaderTask.java */
/* loaded from: classes2.dex */
public abstract class b_renamed extends android.os.AsyncTask<java.lang.Void, java.lang.String, java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed>> implements org.andresoviedo.android_3d_model_engine.c_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected final java.net.URI f7985a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final org.andresoviedo.android_3d_model_engine.c_renamed.a_renamed f7986b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.app.ProgressDialog f7987c;

    protected abstract java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> a_renamed() throws java.lang.Exception;

    protected abstract void b_renamed(java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> list) throws java.lang.Exception;

    public b_renamed(android.app.Activity activity, java.net.URI uri, org.andresoviedo.android_3d_model_engine.c_renamed.a_renamed aVar) {
        this.f7985a = uri;
        this.f7987c = new android.app.ProgressDialog(activity);
        this.f7986b = aVar;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> doInBackground(java.lang.Void... voidArr) {
        try {
            this.f7986b.p_renamed();
            java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> listA = a_renamed();
            b_renamed(listA);
            this.f7986b.a_renamed(listA);
            return listA;
        } catch (java.lang.Exception e_renamed) {
            this.f7986b.a_renamed(e_renamed);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(java.lang.String... strArr) {
        super.onProgressUpdate(strArr);
        this.f7987c.setMessage(strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c_renamed, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> list) {
        super.onPostExecute(list);
        if (this.f7987c.isShowing()) {
            this.f7987c.dismiss();
        }
    }

    @Override // org.andresoviedo.android_3d_model_engine.c_renamed.a_renamed
    public void p_renamed() {
        this.f7986b.p_renamed();
    }

    @Override // org.andresoviedo.android_3d_model_engine.c_renamed.a_renamed
    public void a_renamed(java.lang.Exception exc) {
        this.f7986b.a_renamed(exc);
    }

    @Override // org.andresoviedo.android_3d_model_engine.c_renamed.a_renamed
    public void a_renamed(java.util.List<org.andresoviedo.android_3d_model_engine.b_renamed.g_renamed> list) {
        this.f7986b.a_renamed(list);
    }
}
