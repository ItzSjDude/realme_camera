package org.junit.runner.manipulation;

/* loaded from: classes2.dex */
public abstract class Filter {
    public static final org.junit.runner.manipulation.Filter ALL = new org.junit.runner.manipulation.Filter() { // from class: org.junit.runner.manipulation.Filter.1
        @Override // org.junit.runner.manipulation.Filter
        public void apply(java.lang.Object obj) throws org.junit.runner.manipulation.NoTestsRemainException {
        }

        @Override // org.junit.runner.manipulation.Filter
        public java.lang.String describe() {
            return "all tests";
        }

        @Override // org.junit.runner.manipulation.Filter
        public org.junit.runner.manipulation.Filter intersect(org.junit.runner.manipulation.Filter filter) {
            return filter;
        }

        @Override // org.junit.runner.manipulation.Filter
        public boolean shouldRun(org.junit.runner.Description description) {
            return true;
        }
    };

    public abstract java.lang.String describe();

    public abstract boolean shouldRun(org.junit.runner.Description description);

    public static org.junit.runner.manipulation.Filter matchMethodDescription(final org.junit.runner.Description description) {
        return new org.junit.runner.manipulation.Filter() { // from class: org.junit.runner.manipulation.Filter.2
            @Override // org.junit.runner.manipulation.Filter
            public boolean shouldRun(org.junit.runner.Description description2) {
                if (description2.isTest()) {
                    return description.equals(description2);
                }
                java.util.Iterator<org.junit.runner.Description> it = description2.getChildren().iterator();
                while (it.hasNext()) {
                    if (shouldRun(it.next())) {
                        return true;
                    }
                }
                return false;
            }

            @Override // org.junit.runner.manipulation.Filter
            public java.lang.String describe() {
                return java.lang.String.format("Method %s_renamed", description.getDisplayName());
            }
        };
    }

    public void apply(java.lang.Object obj) throws org.junit.runner.manipulation.NoTestsRemainException {
        if (obj instanceof org.junit.runner.manipulation.Filterable) {
            ((org.junit.runner.manipulation.Filterable) obj).filter(this);
        }
    }

    public org.junit.runner.manipulation.Filter intersect(final org.junit.runner.manipulation.Filter filter) {
        return (filter == this || filter == ALL) ? this : new org.junit.runner.manipulation.Filter() { // from class: org.junit.runner.manipulation.Filter.3
            @Override // org.junit.runner.manipulation.Filter
            public boolean shouldRun(org.junit.runner.Description description) {
                return this.shouldRun(description) && filter.shouldRun(description);
            }

            @Override // org.junit.runner.manipulation.Filter
            public java.lang.String describe() {
                return this.describe() + " and " + filter.describe();
            }
        };
    }
}
