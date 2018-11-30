create table OAUTH_CLIENT_DETAILS
(
    client_id VARCHAR(255) constraint PK_CLIENT_DETAILS primary key,
    resource_ids VARCHAR(255),
    client_secret VARCHAR(255),
    scope VARCHAR(255),
    authorized_grant_types VARCHAR(255),
    web_server_redirect_uri VARCHAR(255),
    authorities VARCHAR(255),
    access_token_validity INT,
    refresh_token_validity INT,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(255)
);
create table OAUTH_ACCESS_TOKEN
(
    token_id VARCHAR(255),
    token BLOB,
    authentication_id VARCHAR(255) constraint PK_ACCESS_TOKEN primary key,
    user_name VARCHAR(255),
    client_id VARCHAR(255),
    authentication BLOB,
    refresh_token VARCHAR(255)
);
create table OAUTH_REFRESH_TOKEN
(
    token_id VARCHAR(255),
    token BLOB,
    authentication BLOB
);
create table OAUTH_CLIENT_TOKEN
(
    token_id VARCHAR(255),
    token BLOB,
    authentication_id VARCHAR(255) constraint PK_CLIENT_TOKEN primary key,
    user_name  VARCHAR(255),
    client_id  VARCHAR(255)
);
create table OAUTH_CODE
(
    code VARCHAR(255),
    authentication BLOB
);
