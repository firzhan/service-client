service-client
==============

A sample for service-client generation

1- Extract the service-client.zip and navigate to the service-client folder. 

1- Update the location of client-truststore.jks in the org.wso2.carbon.admin.client.constant.ServiceClientConstant class. 
    You can find the default client-trustore.jks file inside <CARBON_HOME>/repository/resources/security. 

    You have to update the variable "CLIENT_TRUST_STORE_PATH" with your own location of client-truststore.jks file. 

2- Update the "USER_NAME", "PASSWORD" and "NEW_PASSWORD" variables in the same class 

3- Again navigate to the service-client folder and execute the POM file using "mvn clean install" command. 
