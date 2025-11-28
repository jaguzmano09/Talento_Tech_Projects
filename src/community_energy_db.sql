-- Tabla COMMUNITIES
CREATE TABLE communities (
  community_id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(150),
  region VARCHAR(100),
  poblacion INT,
  anyo_inicio INT,
  meta_energia_MW DECIMAL(10,2)
) ENGINE=InnoDB;

-- Tabla HOUSEHOLDS
CREATE TABLE households (
  household_id INT PRIMARY KEY AUTO_INCREMENT,
  community_id INT,
  direccion VARCHAR(200),
  num_residentes INT,
  nivel_socioeco VARCHAR(10),
  FOREIGN KEY (community_id) REFERENCES communities (community_id)
) ENGINE=InnoDB;

-- Tabla ENERGY_PROJECTS
CREATE TABLE energy_projects (
  project_id INT PRIMARY KEY AUTO_INCREMENT,
  community_id INT,
  tipo_proyecto VARCHAR(100),
  capacidad_MW DECIMAL(10,2),
  fecha_lanzamiento DATE,
  estado VARCHAR(50),
  FOREIGN KEY (community_id) REFERENCES communities (community_id)
) ENGINE=InnoDB;

-- Tabla EQUIPMENTS
CREATE TABLE equipments (
  equipment_id INT PRIMARY KEY AUTO_INCREMENT,
  project_id INT,
  tipo_equipo VARCHAR(100),
  fabricante VARCHAR(100),
  fecha_instalacion DATE,
  capacidad_kW DECIMAL(10,2),
  FOREIGN KEY (project_id) REFERENCES energy_projects (project_id)
) ENGINE=InnoDB;

-- Tabla GENERATION_RECORDS
CREATE TABLE generation_records (
  gen_record_id INT PRIMARY KEY AUTO_INCREMENT,
  equipment_id INT,
  fecha_registro DATE,
  generacion_kWh DECIMAL(12,2),
  exportacion_red_kWh DECIMAL(12,2),
  FOREIGN KEY (equipment_id) REFERENCES equipments (equipment_id)
) ENGINE=InnoDB;

-- Tabla CONSUMPTION_RECORDS
CREATE TABLE consumption_records (
  cons_record_id INT PRIMARY KEY AUTO_INCREMENT,
  household_id INT,
  fecha_registro DATE,
  consumo_kWh DECIMAL(12,2),
  importacion_red_kWh DECIMAL(12,2),
  FOREIGN KEY (household_id) REFERENCES households (household_id)
) ENGINE=InnoDB;

-- Tabla TRAINING_SESSIONS
CREATE TABLE training_sessions (
  session_id INT PRIMARY KEY AUTO_INCREMENT,
  community_id INT,
  tema VARCHAR(200),
  fecha_sesion DATE,
  num_asistentes INT,
  FOREIGN KEY (community_id) REFERENCES communities (community_id)
) ENGINE=InnoDB;

-- Tabla STATE_INCENTIVES
CREATE TABLE state_incentives (
  incentive_id INT PRIMARY KEY AUTO_INCREMENT,
  project_id INT,
  tipo_incentivo VARCHAR(100),
  monto_USD DECIMAL(12,2),
  fecha_aprobacion DATE,
  FOREIGN KEY (project_id) REFERENCES energy_projects (project_id)
) ENGINE=InnoDB;

-- COMMUNITIES
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 1', 'Antioquia', 1889, 2017, 1.98);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 2', 'Cundinamarca', 3795, 2013, 0.58);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 3', 'Valle del Cauca', 2642, 2021, 1.3);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 4', 'Atlántico', 3138, 2021, 0.95);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 5', 'Santander', 3019, 2013, 2.95);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 6', 'Bolívar', 3043, 2019, 3.17);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 7', 'Nariño', 3794, 2014, 2.67);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 8', 'Tolima', 1574, 2014, 3.25);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 9', 'Caldas', 677, 2018, 2.13);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 10', 'Quindío', 1009, 2019, 1.05);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 11', 'Risaralda', 689, 2014, 2.35);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 12', 'Huila', 2428, 2015, 0.67);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 13', 'Meta', 3054, 2020, 0.54);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 14', 'Cesar', 995, 2021, 2.18);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 15', 'Boyacá', 1230, 2020, 0.73);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 16', 'Magdalena', 2281, 2020, 2.38);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 17', 'Sucre', 3449, 2017, 2.96);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 18', 'La Guajira', 3120, 2018, 3.0);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 19', 'Arauca', 2480, 2015, 1.39);
INSERT INTO communities VALUES (NULL, 'Comunidad Solar 20', 'Chocó', 2938, 2021, 1.48);

-- HOUSEHOLDS
INSERT INTO households VALUES (NULL, 16, 'Av Principal', 4, '4');
INSERT INTO households VALUES (NULL, 17, 'Calle 21B', 6, '5');
INSERT INTO households VALUES (NULL, 1, 'Mz 5 Casa 10', 3, '2');
INSERT INTO households VALUES (NULL, 16, 'Cra 52 #45-12', 6, '1');
INSERT INTO households VALUES (NULL, 11, 'Vereda El Sol', 3, '4');
INSERT INTO households VALUES (NULL, 2, 'Calle Central', 4, '6');
INSERT INTO households VALUES (NULL, 9, 'Carrera 4', 3, '2');
INSERT INTO households VALUES (NULL, 6, 'Brr Nvo Amanecer', 2, '3');
INSERT INTO households VALUES (NULL, 4, 'Finca El Lago', 2, '5');
INSERT INTO households VALUES (NULL, 19, 'Mz 3 Lote1', 2, '4');
INSERT INTO households VALUES (NULL, 16, 'Cra 7 #21-9', 5, '2');
INSERT INTO households VALUES (NULL, 19, 'Av Esperanza', 3, '1');
INSERT INTO households VALUES (NULL, 11, 'Calle 20 Sur', 3, '1');
INSERT INTO households VALUES (NULL, 18, 'Cra 1 E', 3, '1');
INSERT INTO households VALUES (NULL, 10, 'Finca Las Palmas', 4, '5');
INSERT INTO households VALUES (NULL, 19, 'Mz 8 Casa 14', 3, '2');
INSERT INTO households VALUES (NULL, 17, 'Villa del Rio', 2, '6');
INSERT INTO households VALUES (NULL, 10, 'Mirador de la Loma', 2, '5');
INSERT INTO households VALUES (NULL, 7, 'Sector Los Pinos', 2, '3');
INSERT INTO households VALUES (NULL, 4, 'Vereda La Frontera', 5, '4');

-- ENERGY_PROJECTS
INSERT INTO energy_projects VALUES (NULL, 19, 'biomasa', 1.9, '2017-12-01', 'operativo');
INSERT INTO energy_projects VALUES (NULL, 14, 'hidroeléctrico', 3.02, '2021-06-01', 'en construcción');
INSERT INTO energy_projects VALUES (NULL, 2, 'hidroeléctrico', 2.9, '2015-06-01', 'en construcción');
INSERT INTO energy_projects VALUES (NULL, 9, 'eólica', 2.89, '2017-08-01', 'operativo');
INSERT INTO energy_projects VALUES (NULL, 9, 'solar', 0.42, '2021-12-01', 'en construcción');
INSERT INTO energy_projects VALUES (NULL, 15, 'eólica', 3.17, '2020-10-01', 'en construcción');
INSERT INTO energy_projects VALUES (NULL, 5, 'hidroeléctrico', 1.38, '2018-08-01', 'en construcción');
INSERT INTO energy_projects VALUES (NULL, 8, 'biomasa', 1.64, '2016-05-01', 'operativo');
INSERT INTO energy_projects VALUES (NULL, 5, 'biomasa', 0.82, '2015-05-01', 'planeación');
INSERT INTO energy_projects VALUES (NULL, 10, 'biomasa', 1.06, '2016-07-01', 'planeación');
INSERT INTO energy_projects VALUES (NULL, 14, 'hidroeléctrico', 1.64, '2020-05-01', 'operativo');
INSERT INTO energy_projects VALUES (NULL, 11, 'biomasa', 2.2, '2015-08-01', 'planeación');
INSERT INTO energy_projects VALUES (NULL, 6, 'solar', 5.87, '2017-01-01', 'operativo');
INSERT INTO energy_projects VALUES (NULL, 2, 'hidroeléctrico', 0.42, '2017-12-01', 'en construcción');
INSERT INTO energy_projects VALUES (NULL, 8, 'solar', 2.36, '2021-10-01', 'planeación');
INSERT INTO energy_projects VALUES (NULL, 1, 'solar', 1.16, '2020-06-01', 'operativo');
INSERT INTO energy_projects VALUES (NULL, 7, 'biomasa', 1.43, '2015-12-01', 'operativo');
INSERT INTO energy_projects VALUES (NULL, 7, 'solar', 0.94, '2015-12-01', 'planeación');
INSERT INTO energy_projects VALUES (NULL, 18, 'hidroeléctrico', 3.44, '2016-12-01', 'planeación');
INSERT INTO energy_projects VALUES (NULL, 11, 'hidroeléctrico', 2.43, '2015-11-01', 'en construcción');

-- EQUIPMENTS
INSERT INTO equipments VALUES (NULL, 9, 'inversor', 'Vestas', '2017-06-01', 71.83);
INSERT INTO equipments VALUES (NULL, 6, 'inversor', 'Jinko Solar', '2016-01-01', 45.06);
INSERT INTO equipments VALUES (NULL, 5, 'batería', 'Enphase', '2017-04-01', 21.51);
INSERT INTO equipments VALUES (NULL, 17, 'inversor', 'Solis', '2018-04-01', 44.91);
INSERT INTO equipments VALUES (NULL, 11, 'panel_solar', 'Trina', '2019-06-01', 66.41);
INSERT INTO equipments VALUES (NULL, 9, 'turbina_eolica', 'Enphase', '2020-01-01', 56.47);
INSERT INTO equipments VALUES (NULL, 6, 'inversor', 'Vestas', '2020-10-01', 72.14);
INSERT INTO equipments VALUES (NULL, 1, 'turbina_eolica', 'ABB', '2019-03-01', 28.36);
INSERT INTO equipments VALUES (NULL, 7, 'inversor', 'Jinko Solar', '2018-08-01', 36.95);
INSERT INTO equipments VALUES (NULL, 1, 'inversor', 'Vestas', '2017-11-01', 32.75);
INSERT INTO equipments VALUES (NULL, 3, 'batería', 'Trina', '2016-12-01', 35.65);
INSERT INTO equipments VALUES (NULL, 20, 'inversor', 'Solis', '2017-08-01', 9.03);
INSERT INTO equipments VALUES (NULL, 10, 'batería', 'Trina', '2017-12-01', 36.53);
INSERT INTO equipments VALUES (NULL, 18, 'batería', 'Solis', '2019-05-01', 13.59);
INSERT INTO equipments VALUES (NULL, 17, 'turbina_eolica', 'Vestas', '2017-04-01', 40.35);
INSERT INTO equipments VALUES (NULL, 2, 'panel_solar', 'Huawei', '2020-06-01', 22.34);
INSERT INTO equipments VALUES (NULL, 15, 'batería', 'Canadian Solar', '2020-02-01', 44.95);
INSERT INTO equipments VALUES (NULL, 2, 'turbina_eolica', 'ABB', '2020-03-01', 29.39);
INSERT INTO equipments VALUES (NULL, 3, 'turbina_eolica', 'SMA', '2017-08-01', 25.91);
INSERT INTO equipments VALUES (NULL, 2, 'batería', 'SMA', '2016-07-01', 38.94);

-- GENERATION_RECORDS
INSERT INTO generation_records VALUES (NULL, 18, '2020-03-15', 3434.81, 193.25);
INSERT INTO generation_records VALUES (NULL, 17, '2021-10-15', 4307.38, 827.9);
INSERT INTO generation_records VALUES (NULL, 19, '2020-10-15', 2113.52, 446.71);
INSERT INTO generation_records VALUES (NULL, 1, '2021-08-15', 100.52, 563.74);
INSERT INTO generation_records VALUES (NULL, 16, '2021-04-15', 3586.53, 326.37);
INSERT INTO generation_records VALUES (NULL, 13, '2020-04-15', 1982.2, 396.12);
INSERT INTO generation_records VALUES (NULL, 18, '2020-11-15', 737.86, 86.97);
INSERT INTO generation_records VALUES (NULL, 11, '2021-12-15', 2961.87, 878.47);
INSERT INTO generation_records VALUES (NULL, 3, '2021-12-15', 1709.92, 68.27);
INSERT INTO generation_records VALUES (NULL, 4, '2020-04-15', 3468.1, 145.02);
INSERT INTO generation_records VALUES (NULL, 17, '2021-03-15', 971.16, 82.62);
INSERT INTO generation_records VALUES (NULL, 20, '2021-01-15', 1103.33, 671.37);
INSERT INTO generation_records VALUES (NULL, 3, '2021-06-15', 4820.45, 975.39);
INSERT INTO generation_records VALUES (NULL, 18, '2020-03-15', 3578.76, 557.27);
INSERT INTO generation_records VALUES (NULL, 9, '2020-06-15', 1118.84, 143.25);
INSERT INTO generation_records VALUES (NULL, 17, '2020-11-15', 3089.39, 648.33);
INSERT INTO generation_records VALUES (NULL, 20, '2021-10-15', 4111.74, 160.35);
INSERT INTO generation_records VALUES (NULL, 16, '2021-02-15', 2798.95, 838.58);
INSERT INTO generation_records VALUES (NULL, 12, '2021-10-15', 789.72, 730.79);
INSERT INTO generation_records VALUES (NULL, 5, '2020-09-15', 3168.1, 505.06);

-- CONSUMPTION_RECORDS (CORREGIDO)
INSERT INTO consumption_records VALUES (NULL, 1, '2017-11-15', 206.11, 57.54);
INSERT INTO consumption_records VALUES (NULL, 2, '2021-05-15', 316.92, 39.93);
INSERT INTO consumption_records VALUES (NULL, 3, '2018-07-15', 138.37, 17.8);
INSERT INTO consumption_records VALUES (NULL, 4, '2017-05-15', 108.01, 53.31);
INSERT INTO consumption_records VALUES (NULL, 5, '2021-05-15', 276.35, 45.4);
INSERT INTO consumption_records VALUES (NULL, 6, '2016-12-15', 96.38, 58.5);
INSERT INTO consumption_records VALUES (NULL, 7, '2018-04-15', 348.06, 20.62);
INSERT INTO consumption_records VALUES (NULL, 8, '2020-02-15', 146.37, 19.17);
INSERT INTO consumption_records VALUES (NULL, 9, '2017-11-15', 184.32, 36.24);
INSERT INTO consumption_records VALUES (NULL, 10, '2018-10-15', 223.9, 24.56);
INSERT INTO consumption_records VALUES (NULL, 11, '2018-10-15', 279.67, 16.97);
INSERT INTO consumption_records VALUES (NULL, 12, '2017-05-15', 180.56, 28.32);
INSERT INTO consumption_records VALUES (NULL, 13, '2021-10-15', 231.38, 49.26);
INSERT INTO consumption_records VALUES (NULL, 14, '2018-01-15', 151.9, 35.71);
INSERT INTO consumption_records VALUES (NULL, 15, '2020-04-15', 273.65, 12.32);
INSERT INTO consumption_records VALUES (NULL, 16, '2020-06-15', 278.34, 18.53);
INSERT INTO consumption_records VALUES (NULL, 17, '2019-07-15', 110.17, 57.44);
INSERT INTO consumption_records VALUES (NULL, 18, '2017-02-15', 389.35, 50.42);
INSERT INTO consumption_records VALUES (NULL, 19, '2020-11-15', 184.43, 14.88);
INSERT INTO consumption_records VALUES (NULL, 20, '2018-08-15', 302.11, 32.01);

-- TRAINING_SESSIONS
INSERT INTO training_sessions VALUES (NULL, 17, 'Gestión comunitaria', '2017-07-05', 33);
INSERT INTO training_sessions VALUES (NULL, 8, 'Instalación de paneles solares', '2021-10-13', 113);
INSERT INTO training_sessions VALUES (NULL, 18, 'Fuentes energéticas renovables', '2018-04-23', 10);
INSERT INTO training_sessions VALUES (NULL, 8, 'Instalación de paneles solares', '2019-11-20', 92);
INSERT INTO training_sessions VALUES (NULL, 8, 'Fuentes energéticas renovables', '2018-07-22', 97);
INSERT INTO training_sessions VALUES (NULL, 19, 'Normas seguridad laboral', '2021-07-05', 108);
INSERT INTO training_sessions VALUES (NULL, 9, 'Incentivos fiscales', '2019-10-26', 94);
INSERT INTO training_sessions VALUES (NULL, 5, 'Medición y monitoreo', '2018-08-09', 53);
INSERT INTO training_sessions VALUES (NULL, 17, 'Incentivos fiscales', '2018-11-22', 97);
INSERT INTO training_sessions VALUES (NULL, 15, 'Mantenimiento de equipos', '2020-06-04', 42);
INSERT INTO training_sessions VALUES (NULL, 16, 'Incentivos fiscales', '2019-01-04', 27);
INSERT INTO training_sessions VALUES (NULL, 10, 'Instalación de paneles solares', '2017-03-05', 12);
INSERT INTO training_sessions VALUES (NULL, 16, 'Autoconsumo', '2018-08-02', 116);
INSERT INTO training_sessions VALUES (NULL, 20, 'Fuentes energéticas renovables', '2021-11-18', 65);
INSERT INTO training_sessions VALUES (NULL, 9, 'Gestión comunitaria', '2017-05-04', 58);
INSERT INTO training_sessions VALUES (NULL, 13, 'Eficiencia energética', '2019-08-25', 82);
INSERT INTO training_sessions VALUES (NULL, 17, 'Normas seguridad laboral', '2020-07-04', 108);
INSERT INTO training_sessions VALUES (NULL, 10, 'Autoconsumo', '2018-07-17', 107);
INSERT INTO training_sessions VALUES (NULL, 16, 'Mantenimiento de equipos', '2021-01-21', 92);
INSERT INTO training_sessions VALUES (NULL, 10, 'Incentivos fiscales', '2019-07-04', 81);

-- STATE_INCENTIVES
INSERT INTO state_incentives VALUES (NULL, 7, 'subsidio', 14542.06, '2020-02-11');
INSERT INTO state_incentives VALUES (NULL, 1, 'subsidio', 8046.19, '2018-08-15');
INSERT INTO state_incentives VALUES (NULL, 3, 'bono', 13096.78, '2021-02-08');
INSERT INTO state_incentives VALUES (NULL, 11, 'reintegro', 4374.31, '2020-09-10');
INSERT INTO state_incentives VALUES (NULL, 3, 'crédito_blando', 9474.46, '2020-09-23');
INSERT INTO state_incentives VALUES (NULL, 4, 'subsidio', 7539.73, '2021-08-03');
INSERT INTO state_incentives VALUES (NULL, 13, 'bono', 10464.93, '2021-05-15');
INSERT INTO state_incentives VALUES (NULL, 4, 'exención fiscal', 8768.26, '2018-08-05');
INSERT INTO state_incentives VALUES (NULL, 6, 'crédito_blando', 14642.87, '2021-03-26');
INSERT INTO state_incentives VALUES (NULL, 1, 'reintegro', 13616.62, '2019-11-19');
INSERT INTO state_incentives VALUES (NULL, 9, 'subsidio', 3940.69, '2018-05-12');
INSERT INTO state_incentives VALUES (NULL, 13, 'subsidio', 6688.55, '2021-05-01');
INSERT INTO state_incentives VALUES (NULL, 10, 'bono', 4716.27, '2019-08-08');
INSERT INTO state_incentives VALUES (NULL, 6, 'crédito_blando', 9754.16, '2020-09-08');
INSERT INTO state_incentives VALUES (NULL, 20, 'bono', 6540.91, '2021-09-01');
INSERT INTO state_incentives VALUES (NULL, 16, 'reintegro', 3459.52, '2019-03-10');
INSERT INTO state_incentives VALUES (NULL, 15, 'subsidio', 9112.02, '2021-04-06');
INSERT INTO state_incentives VALUES (NULL, 4, 'exención fiscal', 10403.89, '2020-12-05');
INSERT INTO state_incentives VALUES (NULL, 12, 'subsidio', 12094.97, '2020-11-11');
INSERT INTO state_incentives VALUES (NULL, 16, 'reintegro', 8660.96, '2020-03-08');

