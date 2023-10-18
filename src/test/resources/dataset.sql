insert into usuario values ("medico",123,"password","medicoCorreo@gmail.com");
insert into usuario values ("medico",987,"password2","medicoCorreo2@gmail.com");
insert into usuario values ("paciente",1001,"password3","david@gmail.com");
insert into usuario values ("paciente",1002,"password4","matias@gmail.com");
insert into usuario values ("admin",1003,"$2a$10$eu.JtteDW44o2QQRupbDH.HIUg75kLVp3McNL3SWYi5ZeXjyi4WqO","davidAdmin@gmail.com");
insert into usuario values ("admin",1004,"password5","matiasAdmin@gmail.com");
insert into usuario values ("medico",1005,"password6","davidMedico@gmail.com");

insert into persona values ("123456789","Armenia","foto","Pepe","3225205639",123);
insert into persona values ("987654321","Pereira","foto2","Pepe2","3225205638",987);
insert into persona values ("1004871090","Armenia","fotoDavid","DavidPersona","3225205639",1001);
insert into persona values ("1005478101","Calarca","fotoMatias","MatiasPersona","3225205638",1002);
insert into persona values ("1004871093","Armenia","fotoDavidMedico","DavidMedicoPersona","3225205639",1005);


insert into medico values (0,0,0,123);
insert into medico values (1,1,1,987);
insert into medico values (2,0,0,1005);

insert into administrador values ("DavidAdmin",1003);
insert into administrador values ("Matias",1004);

insert into paciente values ("Penicilina", 0, "2002-11-10 20:30:00", 0, 1001);
insert into paciente values ("Oxigeno", 1, "2002-11-10 20:30:00", 1, 1002);

insert into cita values (963, 0, "2023-10-18 20:30:00", "2023-10-18 13:30:00", "13:30:00", "Dolor general", 123, 1001);
insert into cita values (159, 0, "2023-10-18 20:30:00", "2023-10-18 13:30:00", "13:30:00", "Dolor general", 987, 1002);

insert into pqrs values (123,"Ensayo pqrs",0,"2023-10-18 14:30:00",0,1003,963);
insert into pqrs values (987,"Ensayo pqrs2",1,"2023-10-18 15:35:00",0,1004,159);

insert into mensaje_pqrs values (753,"2023-10-18 20:30:00","Ensayo mensaje pqrs",753,123);
insert into mensaje_pqrs values (357,"2023-10-18 20:30:00","Ensayo mensaje pqrs2",357,987);


