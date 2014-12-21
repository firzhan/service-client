/**
 *  Copyright (c) 2014 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.admin.client.constant;

public class ServiceClientConstant {

    public static final String CLIENT_TRUST_STORE_PATH = "/home/firzhan/key-store/client-truststore.jks";

    public static final String HOST_NAME = "localhost";
    public static final String HTTPS_PORT = "9443";
    public static final String SERVICE_URL = "https://" + HOST_NAME + ":" + HTTPS_PORT + "/services/";
    public static final String USER_NAME = "test2";
    public static final String PASSWORD = "test123";
    public static final String NEW_PASSWORD = "test12345";
    public static final String KEY_STORE_PASSWORD = "wso2carbon";
    public static final String KEY_STORE_TYPE = "jks";

    public static final String AUTHENTICATION_ADMIN = "AuthenticationAdmin";
    public static final String USER_ADMIN = "UserAdmin";


    private ServiceClientConstant() {

    }
}
