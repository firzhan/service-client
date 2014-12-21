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

package org.wso2.carbon.admin.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.admin.client.adminservices.AuthenticationAdminServiceClient;
import org.wso2.carbon.admin.client.adminservices.UserAdminServiceClient;
import org.wso2.carbon.admin.client.constant.ServiceClientConstant;

public class PasswordVerifier {

    private static final Log log = LogFactory.getLog(PasswordVerifier.class);

    public static void main(String[] args) throws Exception {

        String adminCookie;
        String authenticationAdminURL = ServiceClientConstant.SERVICE_URL + ServiceClientConstant.AUTHENTICATION_ADMIN;
        String userAdminURL = ServiceClientConstant.SERVICE_URL + ServiceClientConstant.USER_ADMIN;

        // setting the system properties for javax.net.ssl
        AuthenticationAdminServiceClient.setSystemProperties(ServiceClientConstant.CLIENT_TRUST_STORE_PATH,
                ServiceClientConstant.KEY_STORE_TYPE, ServiceClientConstant.KEY_STORE_PASSWORD);
        AuthenticationAdminServiceClient.init(authenticationAdminURL);
        log.info("retrieving the admin cookie from the logged in session....");
        adminCookie = AuthenticationAdminServiceClient.login(ServiceClientConstant.HOST_NAME,
                ServiceClientConstant.USER_NAME, ServiceClientConstant.PASSWORD);
        if(adminCookie != null){
            log.info("logged in to the back-end server successfully....");

            UserAdminServiceClient.init(userAdminURL, adminCookie);
            UserAdminServiceClient.changePasswordByUser(ServiceClientConstant.PASSWORD, ServiceClientConstant.NEW_PASSWORD);
        }
    }
}
