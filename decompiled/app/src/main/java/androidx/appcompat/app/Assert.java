package androidx.appcompat.app;

/* loaded from: classes.dex */
public class AppCompatViewInflater {
    private static final java.lang.String LOG_TAG = "AppCompatViewInflater";
    private final java.lang.Object[] mConstructorArgs = new java.lang.Object[2];
    private static final java.lang.Class<?>[] sConstructorSignature = {android.content.Context.class, android.util.AttributeSet.class};
    private static final int[] sOnClickAttrs = {android.R_renamed.attr.onClick};
    private static final java.lang.String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final java.util.Map<java.lang.String, java.lang.reflect.Constructor<? extends android.view.View>> sConstructorMap = new androidx.collection.ArrayMap();

    protected android.view.View createView(android.content.Context context, java.lang.String str, android.util.AttributeSet attributeSet) {
        return null;
    }

    final android.view.View createView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet, boolean z_renamed, boolean z2, boolean z3, boolean z4) {
        android.content.Context context2;
        android.view.View viewCreateTextView;
        context2 = (!z_renamed || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = themifyContext(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = androidx.appcompat.widget.ao_renamed.a_renamed(context2);
        }
        switch (str) {
            case "TextView":
                viewCreateTextView = createTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "ImageView":
                viewCreateTextView = createImageView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "Button":
                viewCreateTextView = createButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "EditText":
                viewCreateTextView = createEditText(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "Spinner":
                viewCreateTextView = createSpinner(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "ImageButton":
                viewCreateTextView = createImageButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "CheckBox":
                viewCreateTextView = createCheckBox(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "RadioButton":
                viewCreateTextView = createRadioButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "CheckedTextView":
                viewCreateTextView = createCheckedTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "AutoCompleteTextView":
                viewCreateTextView = createAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "MultiAutoCompleteTextView":
                viewCreateTextView = createMultiAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "RatingBar":
                viewCreateTextView = createRatingBar(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "SeekBar":
                viewCreateTextView = createSeekBar(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            case "ToggleButton":
                viewCreateTextView = createToggleButton(context2, attributeSet);
                verifyNotNull(viewCreateTextView, str);
                break;
            default:
                viewCreateTextView = createView(context2, str, attributeSet);
                break;
        }
        if (viewCreateTextView == null && context != context2) {
            viewCreateTextView = createViewFromTag(context2, str, attributeSet);
        }
        if (viewCreateTextView != null) {
            checkOnClickListener(viewCreateTextView, attributeSet);
        }
        return viewCreateTextView;
    }

    protected androidx.appcompat.widget.AppCompatTextView createTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatTextView(context, attributeSet);
    }

    protected androidx.appcompat.widget.AppCompatImageView createImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatImageView(context, attributeSet);
    }

    protected androidx.appcompat.widget.f_renamed createButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.f_renamed(context, attributeSet);
    }

    protected androidx.appcompat.widget.j_renamed createEditText(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.j_renamed(context, attributeSet);
    }

    protected androidx.appcompat.widget.AppCompatSpinner createSpinner(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatSpinner(context, attributeSet);
    }

    protected androidx.appcompat.widget.l_renamed createImageButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.l_renamed(context, attributeSet);
    }

    protected androidx.appcompat.widget.AppCompatCheckBox createCheckBox(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.AppCompatCheckBox(context, attributeSet);
    }

    protected androidx.appcompat.widget.q_renamed createRadioButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.q_renamed(context, attributeSet);
    }

    protected androidx.appcompat.widget.g_renamed createCheckedTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.g_renamed(context, attributeSet);
    }

    protected androidx.appcompat.widget.d_renamed createAutoCompleteTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.d_renamed(context, attributeSet);
    }

    protected androidx.appcompat.widget.n_renamed createMultiAutoCompleteTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.n_renamed(context, attributeSet);
    }

    protected androidx.appcompat.widget.r_renamed createRatingBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.r_renamed(context, attributeSet);
    }

    protected androidx.appcompat.widget.s_renamed createSeekBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.s_renamed(context, attributeSet);
    }

    protected androidx.appcompat.widget.x_renamed createToggleButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.x_renamed(context, attributeSet);
    }

    private void verifyNotNull(android.view.View view, java.lang.String str) {
        if (view != null) {
            return;
        }
        throw new java.lang.IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    private android.view.View createViewFromTag(android.content.Context context, java.lang.String str, android.util.AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return createViewByPrefix(context, str, null);
            }
            for (int i_renamed = 0; i_renamed < sClassPrefixList.length; i_renamed++) {
                android.view.View viewCreateViewByPrefix = createViewByPrefix(context, str, sClassPrefixList[i_renamed]);
                if (viewCreateViewByPrefix != null) {
                    return viewCreateViewByPrefix;
                }
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        } finally {
            java.lang.Object[] objArr = this.mConstructorArgs;
            objArr[0] = null;
            objArr[1] = null;
        }
    }

    private void checkOnClickListener(android.view.View view, android.util.AttributeSet attributeSet) {
        android.content.Context context = view.getContext();
        if (context instanceof android.content.ContextWrapper) {
            if (android.os.Build.VERSION.SDK_INT < 15 || androidx.core.h_renamed.v_renamed.E_renamed(view)) {
                android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
                java.lang.String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new androidx.appcompat.app.AppCompatViewInflater.a_renamed(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    private android.view.View createViewByPrefix(android.content.Context context, java.lang.String str, java.lang.String str2) throws android.view.InflateException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException {
        java.lang.String str3;
        java.lang.reflect.Constructor<? extends android.view.View> constructor = sConstructorMap.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (java.lang.Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = java.lang.Class.forName(str3, false, context.getClassLoader()).asSubclass(android.view.View.class).getConstructor(sConstructorSignature);
            sConstructorMap.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.mConstructorArgs);
    }

    private static android.content.Context themifyContext(android.content.Context context, android.util.AttributeSet attributeSet, boolean z_renamed, boolean z2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R_renamed.styleable.View, 0, 0);
        int resourceId = z_renamed ? typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R_renamed.styleable.View_theme, 0)) != 0) {
            android.util.Log.i_renamed(LOG_TAG, "app:theme is_renamed now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof androidx.appcompat.view.d_renamed) && ((androidx.appcompat.view.d_renamed) context).getThemeResId() == resourceId) ? context : new androidx.appcompat.view.d_renamed(context, resourceId) : context;
    }

    private static class a_renamed implements android.view.View.OnClickListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final android.view.View f261a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.lang.String f262b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.lang.reflect.Method f263c;
        private android.content.Context d_renamed;

        public a_renamed(android.view.View view, java.lang.String str) {
            this.f261a = view;
            this.f262b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (this.f263c == null) {
                a_renamed(this.f261a.getContext(), this.f262b);
            }
            try {
                this.f263c.invoke(this.d_renamed, view);
            } catch (java.lang.IllegalAccessException e_renamed) {
                throw new java.lang.IllegalStateException("Could not execute non-public method for android:onClick", e_renamed);
            } catch (java.lang.reflect.InvocationTargetException e2) {
                throw new java.lang.IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        private void a_renamed(android.content.Context context, java.lang.String str) {
            java.lang.String str2;
            java.lang.reflect.Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f262b, android.view.View.class)) != null) {
                        this.f263c = method;
                        this.d_renamed = context;
                        return;
                    }
                } catch (java.lang.NoSuchMethodException unused) {
                }
                context = context instanceof android.content.ContextWrapper ? ((android.content.ContextWrapper) context).getBaseContext() : null;
            }
            int id_renamed = this.f261a.getId();
            if (id_renamed == -1) {
                str2 = "";
            } else {
                str2 = " with id_renamed '" + this.f261a.getContext().getResources().getResourceEntryName(id_renamed) + "'";
            }
            throw new java.lang.IllegalStateException("Could not find method " + this.f262b + "(View) in_renamed a_renamed parent or ancestor Context for android:onClick attribute defined on_renamed view " + this.f261a.getClass() + str2);
        }
    }
}
