insert into institution(id,code,description)
values(1,'Verbio','Institución Verbio');

insert into permission(id,code,description)
values(1,'MOD_PROD','Permiso para modificar productos');

insert into role(id,code,description)
values(1,'ADMIN','Administrador');

insert into role_permission(id,permission_id,role_id)
values(1,1,1);

insert into person(id,name,first_name,last_name,legal_id,phone,email,date_of_birth,institution_id)
values(1,'Alejandro','Ciudad','Camprubí','1111111','2222222','aciudad@mail.com','1981-01-01 00:00:00',1);


insert into users(id,login,password,alternate_id,sign_up_date,leaving_date,leaving_cause,language,person_id,type_of_user)
values(1,'admin','1','','2019-01-01 00:00:00',null,null,'es',1,'ADMIN');


insert into user_role(id,user_id,role_id)
values(1,1,1);



    