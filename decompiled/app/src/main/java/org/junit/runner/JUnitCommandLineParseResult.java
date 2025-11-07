package org.junit.runner;

/* loaded from: classes2.dex */
class JUnitCommandLineParseResult {
    private final java.util.List<java.lang.String> filterSpecs = new java.util.ArrayList();
    private final java.util.List<java.lang.Class<?>> classes = new java.util.ArrayList();
    private final java.util.List<java.lang.Throwable> parserErrors = new java.util.ArrayList();

    JUnitCommandLineParseResult() {
    }

    public java.util.List<java.lang.String> getFilterSpecs() {
        return java.util.Collections.unmodifiableList(this.filterSpecs);
    }

    public java.util.List<java.lang.Class<?>> getClasses() {
        return java.util.Collections.unmodifiableList(this.classes);
    }

    public static org.junit.runner.JUnitCommandLineParseResult parse(java.lang.String[] strArr) {
        org.junit.runner.JUnitCommandLineParseResult jUnitCommandLineParseResult = new org.junit.runner.JUnitCommandLineParseResult();
        jUnitCommandLineParseResult.parseArgs(strArr);
        return jUnitCommandLineParseResult;
    }

    private void parseArgs(java.lang.String[] strArr) {
        parseParameters(parseOptions(strArr));
    }

    java.lang.String[] parseOptions(java.lang.String... strArr) {
        java.lang.String strSubstring;
        int i_renamed = 0;
        while (true) {
            if (i_renamed == strArr.length) {
                break;
            }
            java.lang.String str = strArr[i_renamed];
            if (str.equals("--")) {
                return copyArray(strArr, i_renamed + 1, strArr.length);
            }
            if (str.startsWith("--")) {
                if (str.startsWith("--filter=") || str.equals("--filter")) {
                    if (str.equals("--filter")) {
                        i_renamed++;
                        if (i_renamed < strArr.length) {
                            strSubstring = strArr[i_renamed];
                        } else {
                            this.parserErrors.add(new org.junit.runner.JUnitCommandLineParseResult.CommandLineParserError(str + " value not specified"));
                            break;
                        }
                    } else {
                        strSubstring = str.substring(str.indexOf(61) + 1);
                    }
                    this.filterSpecs.add(strSubstring);
                } else {
                    this.parserErrors.add(new org.junit.runner.JUnitCommandLineParseResult.CommandLineParserError("JUnit knows nothing about the " + str + " option"));
                }
                i_renamed++;
            } else {
                return copyArray(strArr, i_renamed, strArr.length);
            }
        }
        return new java.lang.String[0];
    }

    private java.lang.String[] copyArray(java.lang.String[] strArr, int i_renamed, int i2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (i_renamed != i2) {
            arrayList.add(strArr[i_renamed]);
            i_renamed++;
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    void parseParameters(java.lang.String[] strArr) {
        for (java.lang.String str : strArr) {
            try {
                this.classes.add(org.junit.internal.Classes.getClass(str));
            } catch (java.lang.ClassNotFoundException e_renamed) {
                this.parserErrors.add(new java.lang.IllegalArgumentException("Could not find class [" + str + "]", e_renamed));
            }
        }
    }

    private org.junit.runner.Request errorReport(java.lang.Throwable th) {
        return org.junit.runner.Request.errorReport(org.junit.runner.JUnitCommandLineParseResult.class, th);
    }

    public org.junit.runner.Request createRequest(org.junit.runner.Computer computer) {
        if (this.parserErrors.isEmpty()) {
            java.util.List<java.lang.Class<?>> list = this.classes;
            return applyFilterSpecs(org.junit.runner.Request.classes(computer, (java.lang.Class[]) list.toArray(new java.lang.Class[list.size()])));
        }
        return errorReport(new org.junit.runners.model.InitializationError(this.parserErrors));
    }

    private org.junit.runner.Request applyFilterSpecs(org.junit.runner.Request request) {
        try {
            java.util.Iterator<java.lang.String> it = this.filterSpecs.iterator();
            while (it.hasNext()) {
                request = request.filterWith(org.junit.runner.FilterFactories.createFilterFromFilterSpec(request, it.next()));
            }
            return request;
        } catch (org.junit.runner.FilterFactory.FilterNotCreatedException e_renamed) {
            return errorReport(e_renamed);
        }
    }

    public static class CommandLineParserError extends java.lang.Exception {
        private static final long serialVersionUID = 1;

        public CommandLineParserError(java.lang.String str) {
            super(str);
        }
    }
}
