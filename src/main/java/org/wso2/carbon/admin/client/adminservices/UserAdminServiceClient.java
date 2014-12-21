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

package org.wso2.carbon.admin.client.adminservices;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.wso2.carbon.admin.client.exception.AdminServicesClientException;
import org.wso2.carbon.user.mgt.stub.UserAdminStub;
import org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.rmi.RemoteException;


public class UserAdminServiceClient {

    private static final Log log = LogFactory.getLog(UserAdminServiceClient.class);
    private static UserAdminStub userAdminStub;

    public static void init(String backEndServerURL, String cookie) throws AdminServicesClientException{
        try {
            userAdminStub = new UserAdminStub (backEndServerURL);
        } catch (AxisFault axisFault) {
            String errMsg = "Axis2 soap faul occurred in userAdminStub";
            throw new AdminServicesClientException(errMsg, axisFault);
        }
        ServiceClient client = userAdminStub._getServiceClient();
        Options option = client.getOptions();
        option.setManageSession(true);
        option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING, cookie);
    }

    public static void changePasswordByUser(String oldPassword, String newPassword) throws
            AdminServicesClientException {
        try {
            userAdminStub.changePasswordByUser(oldPassword, newPassword);
            log.info("Password changed successfully");
        }catch (RemoteException e){
            String errMsg = "Establishing Connection Failed with back end when changing the password";
            throw new AdminServicesClientException(errMsg, e);
        }catch (UserAdminUserAdminException e){
            String errMsg = "Password update failed";
            throw new AdminServicesClientException(errMsg, e);
        }
    }
}
