DROP DATABASE IF EXISTS ums_portal;
DROP USER IF EXISTS `ums_portal_admin`@`localhost`;
CREATE DATABASE IF NOT EXISTS ums_portal CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `ums_portal_admin`@`localhost` IDENTIFIED WITH mysql_native_password BY 'ums_portal_admin_Y2022';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW, CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `ums_portal`.* TO `ums_portal_admin`@`localhost`;
FLUSH PRIVILEGES;
