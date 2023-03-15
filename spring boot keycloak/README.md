# Spring Security using Keycloak (POC) 🚀 :pig: :coffee:
## &nbsp;&nbsp;&nbsp;&nbsp; 1. SpringBoot 2 Keycloak Client 
## &nbsp;&nbsp;&nbsp;&nbsp; 2. Keycloak Client Postman Collection




# KeyCloak Server 🚀 :pig: :coffee:

## &nbsp;&nbsp;&nbsp;&nbsp; 1. Installation

&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;1.1. Create folder to your desired drive example RMS_SECURITY.

&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 1.2. Download the docker-compose.yml to the directory created RMS_SECURITY.

&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 1.3. Using command line  run "docker-compose up -d" inside RMS_SECURITY.

&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 1.4. Notice this will create KEYCLOAK folder inside the RMS_SECURITY to save all the settings.

&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  1.5. Using browser input "http://localhost:6060/auth" and login using username: admin / password: admin.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ![image](https://user-images.githubusercontent.com/34267928/224467676-f9cb7344-f899-42d6-8b59-37682598f4df.png)


## &nbsp;&nbsp;&nbsp;&nbsp; 2. Configuring Keycloak

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.1. Create realm Click "Add Realm" button and supply the information illustrated.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224467776-dfd736e9-a2e4-49a9-a0e2-a2af1ed97779.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224467869-05fbd7fb-020a-499b-8e74-3f68ece682c0.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224467916-7a0c87fa-5753-4e7a-ab98-ce7e69b16530.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  2.2. Create client by selecting "Clients" and click "Create" button.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224469203-e9921d92-a70b-43fb-a5a2-c33082dfdafe.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224468254-062d1a7b-7c41-42b2-8813-c25ab97ec114.png)
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224468199-57c7a233-1a4f-4241-8958-d00b3a503456.png)
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.3. Create client role by selecting "Roles" Tab and click "Add Role" button.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224469480-fc22f813-a110-44df-b15a-16242dd9450b.png)
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224469505-51b55d89-0d5d-47b1-968f-c5bcb4f6c5be.png)
   
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224469525-86cee5ab-febb-464d-b0aa-46d696b24528.png)
   
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224469570-ab6b86c2-b1be-44c4-9ffc-3349b06bb8c1.png)
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.4. View "Credentials" tab.
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224469626-e3a54548-1b08-4ab1-97bd-2333adf9972e.png)
   
   
## &nbsp;&nbsp;&nbsp;&nbsp; 3. Creating Real Role
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.1. Select "Roles" from the menu and click "Add Role" button.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224469785-fd1f90e6-57e9-4a15-834b-44bbd685df09.png)
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224469832-4ec497fa-5d45-4f7a-8875-aa6b0d19acb9.png)
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224469966-35799ca0-1cf4-468f-a6dd-a1945a0ceb9d.png)
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.2. Repeat for step 1 for "User Role

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224470095-16bdb529-169e-4cba-8d60-002f6abd4ca0.png)


## &nbsp;&nbsp;&nbsp;&nbsp; 4. Creating Users
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.1. Select "Users" from the menu and click "Add user" button.
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224470192-1a127930-2f9d-46ce-8ea4-828ab6eba871.png)
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224470264-76efa5c2-c58b-43bc-ae34-c73062d2eb8d.png)
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224470403-2a3d9a94-fd74-4e4c-8265-be15b3fa1947.png)
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224470474-2b435219-dbb0-4095-87e0-ca99fdd31017.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.2. Repeat for step 1 for "User".

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224470565-35853f90-29af-4bb6-8e06-1829a1a2845c.png)
   

## &nbsp;&nbsp;&nbsp;&nbsp; 5. Testing Keycloak Server

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.1. Get available endpoints from Keycloak.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224467532-5ba75ccb-32d6-42ef-95cd-0820553c215f.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.2. Get the "token_enpoint".

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224467482-3eeb9317-9e0a-42b6-a6f1-45b4baf4b6dd.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.3. Get "secret" from keycloak.
 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224467438-2ba484b8-53f1-4e96-b87d-47b21fd765da.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.4. Using "Postman" supply all needed information and hit send. View the keycloak response.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224467390-3b15d3ff-fb66-4557-aa5d-9a0035449f90.png)
   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5.5. Go to "https://jwt.io" and use the "access_token" to decode the JWT.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ![image](https://user-images.githubusercontent.com/34267928/224471226-75ca2fec-fa86-4a64-a4c3-291314f2db5b.png)

