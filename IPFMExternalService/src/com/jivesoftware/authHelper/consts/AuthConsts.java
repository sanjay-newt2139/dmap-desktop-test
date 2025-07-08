package com.jivesoftware.authHelper.consts;

import java.io.File;

public class AuthConsts {

    public static final String BROWSER_USER_AGENT_VALUE = "Mozilla/5.0 (Macintosh; " + // DMAP Comment : Dead Code Detected - The Following Field has no reference BROWSER_USER_AGENT_VALUE
            "Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, " +
            "like Gecko) Chrome/34.0.1847.131 Safari/537.36";
    public static final String HTTP_DEFAULT_HEADERS = "http.default-headers"; // DMAP Comment : Dead Code Detected - The Following Field has no reference HTTP_DEFAULT_HEADERS
    public static final String USER_AGENT = "User-Agent"; // DMAP Comment : Dead Code Detected - The Following Field has no reference USER_AGENT
    public static final String NEGOTIATE = "Negotiate"; // DMAP Comment : Dead Code Detected - The Following Field has no reference NEGOTIATE
    public static final String FORMS_BASED_AUTH_ACCEPTED_HEADER = "X-FORMS_BASED_AUTH_ACCEPTED"; // DMAP Comment : Dead Code Detected - The Following Field has no reference FORMS_BASED_AUTH_ACCEPTED_HEADER
    public static final String REALM = "java.security.krb5.realm"; // DMAP Comment : Dead Code Detected - The Following Field has no reference REALM
    public static final String KDC = "java.security.krb5.kdc"; // DMAP Comment : Dead Code Detected - The Following Field has no reference KDC
    public static final String USE_SUBJECT_CREDS = "javax.security.auth.useSubjectCredsOnly"; // DMAP Comment : Dead Code Detected - The Following Field has no reference USE_SUBJECT_CREDS
    public static final String HTTPS_SCHEMA = "https"; // DMAP Comment : Dead Code Detected - The Following Field has no reference HTTPS_SCHEMA
    public static final int HTTPS_PORT = 443; // DMAP Comment : Dead Code Detected - The Following Field has no reference HTTPS_PORT
    public static final String DEFAULT_STORE_PASSWORD = "changit"; // DMAP Comment : Dead Code Detected - The Following Field has no reference DEFAULT_STORE_PASSWORD
    public static final String JRE_HOME = System.getProperties().getProperty("java.home");
    public static final String DEFAULT_TRUST_STORE_PATH = // DMAP Comment : Dead Code Detected - The Following Field has no reference DEFAULT_TRUST_STORE_PATH
            JRE_HOME + File.separator + "lib" + File.separator + "security" + File.separator + "cacerts";
    public static final String CONTENT_ENCODING_HEADER = "Content-Encoding"; // DMAP Comment : Dead Code Detected - The Following Field has no reference CONTENT_ENCODING_HEADER
    public static final String GZIP = "gzip"; // DMAP Comment : Dead Code Detected - The Following Field has no reference GZIP
}
