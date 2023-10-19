insert into usuario values ("admin", 001, "$2a$10$vUvR1xXVwDxLP9KjdbJmhOASLgRWaycfvUqyoIj8Sa93Ol.FMnyYC", "adminUno@gmail.com");
insert into usuario values ("admin", 002, "passwordAdminDos", "adminDos@gmail.com");

insert into usuario values ("paciente", 005, "passwordPacienteUno", "pacienteUno@gmail.com");
insert into usuario values ("paciente", 006, "passwordPacienteDos", "pacienteDos@gmail.com");

insert into usuario values("medico", 003, "passwordMedicoUno", "medicoUno@gmail.com");
insert into usuario values ("medico", 004, "passwordMedicoDos", "medicoDos@gmail.com");


insert into administrador values ("DavidAdmin", 001);
insert into administrador values ("MatiasAdmin", 002);

insert into persona values("1004871090", "Armenia", "fotoPacienteUno", "PacienteUno", "3225205639", 005);
insert into persona values("1004871091", "Bogota", "fotoPacienteDos", "PacienteDos", "3225205680", 006);
insert into persona values("1004871092", "Pereira", "fotoMedicoUno", "MedicoUno", "3225205682", 003);
insert into persona values("1004871093", "Ibague", "fotoMedicoDos", "MedicoDos", "3225205685", 004);

insert into paciente values ("Penicilina", 0, "2005-10-18 20:30:00", 0, 005);
insert into paciente values ("Oxigeno", 0, "2002-10-11 20:30:00", 0, 006);

insert into medico values (0,0,0,003);
insert into medico values (1,1,1,004);


insert into cita values (1000, 0, "2005-11-18 20:30:00", "2023-10-18 20:30:00", "13:30:00", "Consulta", 003, 005);
insert into cita values (1001, 0, "2005-11-18 20:30:00", "2023-10-18 20:30:00", "13:30:00", "ConsultaDos", 004, 006);

insert into pqrs values (2000, "Queja",0, "2023-10-18 20:30:00",0, 001,1000);
insert into pqrs values (2001, "Peticion",0, "2023-10-18 20:30:00",0, 002,1001);

insert into mensaje_pqrs values (3000, "2023-10-18 20:30:00", "MensajeUno", 3000, 2000);
insert into mensaje_pqrs values (3001, "2023-10-18 20:30:00", "MensajeDos", 3001, 2001);