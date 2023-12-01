INSERT INTO usuarios (username,password,enable,nombre,apellido,email) VALUES ('gustavo','$2a$10$2amnJ9keFesYS/BYH.iql.izrfuEaR6scZE0N2qjsRXXRnR/f4QPu',1,'Gustavo','Rodriguez','gustavo@uanl.com');
INSERT INTO usuarios (username,password,enable,nombre,apellido,email) VALUES ('nissan','$2a$10$UVoZ1ObMIy6C9qGzCS3F/.KLflMKW0JHUuSDDwbaAOWeITurS675O',1,'Nissan','Gtr','nissan@uanl.com');

INSERT INTO roles (nombre) VALUES('ROLE_USER');
INSERT INTO roles (nombre) VALUES('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id,roles_id)VALUES(1,1);
INSERT INTO usuarios_to_roles (user_id,roles_id)VALUES(2,2);
INSERT INTO usuarios_to_roles (user_id,roles_id)VALUES(2,1);