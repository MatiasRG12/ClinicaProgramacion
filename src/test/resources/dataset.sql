insert into usuario values ("medico",123456789,"password","correo@correo.com");
insert into usuario values ("medico",987654321,"password2","correo2@correo.com");
insert into usuario values ("paciente",1004871090,"password3","david@correo.com");
insert into usuario values ("paciente",1005478101,"password4","matias@correo.com");
insert into usuario values ("admin",1004871091,"password5","davidAdmin@correo.com");
insert into usuario values ("admin",1005478102,"password5","matiasAdmin@correo.com");
insert into usuario values ("medico",1004871093,"password6","davidMedico@correo.com");

insert into persona values ("123456789","Armenia","foto","Pepe","3225205639",123456789);
insert into persona values ("987654321","Pereira","foto2","Pepe2","3225205638",987654321);
insert into persona values ("1004871090","Armenia","fotoDavid","DavidPersona","3225205639",1004871090);
insert into persona values ("1005478101","Calarca","fotoMatias","MatiasPersona","3225205638",1005478101);
insert into persona values ("1004871093","Armenia","fotoDavidMedico","DavidMedicoPersona","3225205639",1004871093);


insert into medico values (0,0,0,"123456789");
insert into medico values (1,1,1,"987654321");
insert into medico values (2,0,0,"1004871093");

insert into administrador values ("DavidAdmin",1004871091);
insert into administrador values ("Matias",1005478102);

insert into paciente values ("Penicilina", 0, "2002-11-10 20:30:00", 0, 1004871090);
insert into paciente values ("Oxigeno", 1, "2002-11-10 20:30:00", 1, 1005478101);

insert into cita values (963, 0, "2023-10-18 20:30:00", "2023-10-18 13:30:00", "13:30:00", "Dolor general", 1004871093, 1004871090);
insert into cita values (159, 0, "2023-10-18 20:30:00", "2023-10-18 13:30:00", "13:30:00", "Dolor general", 1004871093, 1005478101);

insert into pqrs values (123,"Ensayo pqrs",0,"2023-10-18 14:30:00",0,1004871091,963);
insert into pqrs values (987,"Ensayo pqrs2",1,"2023-10-18 15:35:00",0,1005478102,159);

insert into mensaje_pqrs values (753,"2023-10-18 20:30:00","Ensayo mensaje pqrs",753,123);
insert into mensaje_pqrs values (357,"2023-10-18 20:30:00","Ensayo mensaje pqrs2",357,987);