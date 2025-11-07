package com.meicam.sdk;

/* loaded from: classes2.dex */
public class NvsHttpsRequest {
    public java.lang.String httpsRequest(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String str2 = str + "?";
        int size = map.size();
        int i_renamed = 0;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            str2 = str2 + entry.getKey() + "=" + entry.getValue();
            i_renamed++;
            if (i_renamed < size) {
                str2 = str2 + "&";
            }
        }
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str2).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
            }
            bufferedReader.close();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public java.lang.String postHttpsRequest(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) throws java.io.IOException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String str3 = str + "?";
        int size = map.size();
        int i_renamed = 0;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            str3 = str3 + entry.getKey() + "=" + entry.getValue();
            i_renamed++;
            if (i_renamed < size) {
                str3 = str3 + "&";
            }
        }
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str3).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.connect();
            java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(str2);
            dataOutputStream.flush();
            dataOutputStream.close();
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
            }
            bufferedReader.close();
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
