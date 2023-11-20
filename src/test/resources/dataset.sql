insert into usuario values ("admin", 001, "$2a$10$vUvR1xXVwDxLP9KjdbJmhOASLgRWaycfvUqyoIj8Sa93Ol.FMnyYC", "adminUno@gmail.com");
insert into usuario values ("admin", 002, "passwordAdminDos", "adminDos@gmail.com");
insert into usuario values ("admin", 033, "passwordAdminTres", "adminTres@gmail.com");
insert into usuario values ("admin", 034, "passwordAdminCuatro", "adminCuatro@gmail.com");
insert into usuario values ("admin", 035, "passwordAdminCinco", "adminCinco@gmail.com");

insert into usuario values ("paciente", 005, "$2a$10$bILaCW9CACiAFy2v6dogSOqTnm.0Tr1s2Ptawf3VSzLoACxfxPtA2", "pacienteUno@gmail.com");
insert into usuario values ("paciente", 006, "passwordPacienteDos", "pacienteDos@gmail.com");
insert into usuario values ("paciente", 067, "passwordPacienteTres", "pacienteTres@gmail.com");
insert into usuario values ("paciente", 068, "passwordPacienteCuatro", "pacienteCuatro@gmail.com");
insert into usuario values ("paciente", 069, "passwordPacienteCinco", "pacienteCinco@gmail.com");

insert into usuario values ("medico", 003, "$2a$10$hXGoRvgh8QIhzJOAoxh90ewM5zdbnndtjtid0UqZDuP.s.xdTsOX2", "medicoUno@gmail.com");
insert into usuario values ("medico", 004, "passwordMedicoDos", "medicoDos@gmail.com");
insert into usuario values ("medico", 045, "passwordMedicoTres", "medicoTres@gmail.com");
insert into usuario values ("medico", 046, "passwordMedicoCuatro", "medicoCuatro@gmail.com");
insert into usuario values ("medico", 047, "passwordMedicoCinco", "medicoCinco@gmail.com");


insert into administrador values ("DavidAdmin", 001);
insert into administrador values ("MatiasAdmin", 002);
insert into administrador values ("ValeriaAdmin", 033);
insert into administrador values ("CarlosAdmin", 034);
insert into administrador values ("JuanAdmin", 035);


insert into persona values("1004871090", "Armenia", "fotoPacienteUno", "PacienteUno", "3225205639", 005);
insert into persona values("1004871091", "Bogota", "fotoPacienteDos", "PacienteDos", "3225205680", 006);
insert into persona values("1004871094", "Cali", "fotoPacienteTres", "PacienteTres", "3225205683", 067);
insert into persona values("1004871095", "Medellin", "fotoPacienteCuatro", "PacienteCuatro", "3225205684", 068);
insert into persona values("1004871096", "Barranquilla", "fotoPacienteCinco", "PacienteCinco", "3225205686", 069);


insert into persona values("1004871092", "Pereira", "fotoMedicoUno", "MedicoUno", "3225205682", 003);
insert into persona values("1004871093", "Ibague", "fotoMedicoDos", "MedicoDos", "3225205685", 004);
insert into persona values("1004871097", "Bucaramanga", "fotoMedicoTres", "MedicoTres", "3225205687", 045);
insert into persona values("1004871098", "Cartagena", "fotoMedicoCuatro", "MedicoCuatro", "3225205688", 046);
insert into persona values("1004871099", "Santa Marta", "fotoMedicoCinco", "MedicoCinco", "3225205689", 047);

insert into paciente values ("Penicilina", 0, "2005-10-18 20:30:00", 0, 005);
insert into paciente values ("Oxigeno", 0, "2002-10-11 20:30:00", 0, 006);
insert into paciente values ("Aspirina", 0, "2005-10-18 20:30:00", 0, 067);
insert into paciente values ("Paracetamol", 0, "2005-10-18 20:30:00", 0, 068);
insert into paciente values ("Ibuprofeno", 0, "2005-10-18 20:30:00", 0, 069);

insert into medico values (0,0,0,003);
insert into medico values (1,1,1,004);
insert into medico values (0,1,1,045);
insert into medico values (1,0,0,046);
insert into medico values (1,0,1,047);


insert into cita values (1000, 0, "2005-11-18 20:30:00", "2023-10-18 20:30:00", "13:30:00", "Consulta", 003, 005);
insert into cita values (1001, 0, "2005-11-18 20:30:00", "2023-10-18 20:30:00", "13:30:00", "ConsultaDos", 004, 006);
insert into cita values (1002, 0, "2005-11-18 20:30:00", "2023-10-18 20:30:00", "13:30:00", "ConsultaTres", 045, 067);
insert into cita values (1003, 0, "2005-11-18 20:30:00", "2023-10-18 20:30:00", "13:30:00", "ConsultaCuatro", 046, 068);
insert into cita values (1004, 0, "2005-11-18 20:30:00", "2023-10-18 20:30:00", "13:30:00", "ConsultaCinco", 047, 069);

insert into pqrs values (2000, "Queja",0, "2023-10-18 20:30:00",0, 001,1000);
insert into pqrs values (2001, "Peticion",0, "2023-10-18 20:30:00",0, 002,1001);
insert into pqrs values (2002, "Reclamo",0, "2023-10-18 20:30:00",0, 033,1002);
insert into pqrs values (2003, "Sugerencia",0, "2023-10-18 20:30:00",0, 034,1003);
insert into pqrs values (2004, "Queja",0, "2023-10-18 20:30:00",0, 035,1004);

insert into mensaje_pqrs values (3000, "2023-10-18 20:30:00", "MensajeUno", 3000, 2000);
insert into mensaje_pqrs values (3001, "2023-10-18 20:30:00", "MensajeDos", 3001, 2001);
insert into mensaje_pqrs values (3002, "2023-10-18 20:30:00", "MensajeTres", 3002, 2002);
insert into mensaje_pqrs values (3003, "2023-10-18 20:30:00", "MensajeCuatro", 3003, 2003);
insert into mensaje_pqrs values (3004, "2023-10-18 20:30:00", "MensajeCinco", 3004, 2004);

insert into atencion_medica values (4000, "Dolores", "Se remite a", "Dolores", "Acetaminofen", 1000);
insert into atencion_medica values (4001, "Dolores", "Se remite a", "Dolores", "Acetaminofen", 1001);
insert into atencion_medica values (4002, "Dolores", "Se remite a", "Dolores", "Acetaminofen", 1002);
insert into atencion_medica values (4003, "Dolores", "Se remite a", "Dolores", "Acetaminofen", 1003);
insert into atencion_medica values (4004, "Dolores", "Se remite a", "Dolores", "Acetaminofen", 1004);

insert into dia_libre values (5000, "2023-10-18 20:30:00", 003);
insert into dia_libre values (5001, "2023-10-18 20:30:00", 004);
insert into dia_libre values (5002, "2023-10-18 20:30:00", 045);
insert into dia_libre values (5003, "2023-10-18 20:30:00", 046);
insert into dia_libre values (5004, "2023-10-18 20:30:00", 047);
