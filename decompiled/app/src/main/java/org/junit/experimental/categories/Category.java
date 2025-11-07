package org.junit.experimental.categories;

@java.lang.annotation.Inherited
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@org.junit.validator.ValidateWith(org.junit.experimental.categories.CategoryValidator.class)
/* loaded from: classes2.dex */
public @interface Category {
    java.lang.Class<?>[] value();
}
