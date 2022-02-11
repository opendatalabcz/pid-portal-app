-- Users --
insert into users (email, name, password, role, username)
    values ('email@mail.com', 'name', '$2a$10$dh2e/ujIGyCgCK0P9C9a4OvHEXwDxzk6LVFyEqH9zGeSkdk2MW0oS', 'USER', 'username');
insert into users (email, name, password, role, username)
    values ('gal@mail.com', 'gal', '$2a$10$dh2e/ujIGyCgCK0P9C9a4OvHEXwDxzk6LVFyEqH9zGeSkdk2MW0oS', 'USER', 'gal');

-- Service --
insert into services (uid, end_time, monday, tuesday, wednesday, thursday, friday, saturday, sunday, created_time, modified_time)
    values ('1111100-1', {ts '2012-09-17 18:47:52.69'}, true, true, true, true, true, true, true, {ts '2012-09-17 18:47:52.69'}, {ts '2012-09-17 18:47:52.69'});

-- Stops --
insert into stops (uid, name, lat, lon, zone_id, wheelchair, parent_station)
    values('U1072Z1P','Václavské náměstí', 50.08167, 14.42528, 'P', 1, 'parent station');
insert into stops (uid, name, lat, lon, zone_id, wheelchair, parent_station)
    values ('U1072Z2P','Václavské náměstí', 50.08196, 14.42572, 'P', 1, 'parent location');
insert into stops (uid, name, lat, lon, zone_id, wheelchair, parent_station)
    values ('U203Z2P', 'Jindřišská', 50.08532, 14.43078,  'P', 1, 'parent location');
insert into stops (uid, name, lat, lon, zone_id, wheelchair, parent_station)
    values ('U142Z2P', 'Hlavní nádraží',  50.08569, 14.43593, 'P', 1, 'parent location');

-- Route --
insert into routes (uid, long_name, short_name, desc, agency, color, text_color, type, url, is_night, shape_id)
    values ('L9', 'Sídliště Řepy - Spojovací', '9', '0', '99', '7A0603', 'FFFFFF', '0', 'https://pid.cz/linka/9', false, 'L9V2');
INSERT INTO routes (uid,long_name,short_name,desc,agency,color,text_color,type,url,is_night,shape_id) VALUES
('L6','Palmovka - Kubánské náměstí','6','0','99','7A0603','FFFFFF','0','https://pid.cz/linka/6',false,'L6V2');

-- Trips --
insert into trips (uid, route_id, service_id, shape_id, direction, exceptional, headsign, wheelchair, bikes_allowed, block_id)
    values ('9_6952_211202', 'L9', '1111100-1', 'L9V2', 0, 0, 'Spojovací', true, true,  '');
insert into trips (uid, route_id, service_id, shape_id, direction, exceptional, headsign, wheelchair, bikes_allowed, block_id)
    values ('9_6952_211203', 'L9', '1111100-1', 'L9V2', 0, 0, 'Spojovací', true, true,  '');
insert into trips (uid, route_id, service_id, shape_id, direction, exceptional, headsign, wheelchair, bikes_allowed, block_id)
    values ('9_6952_211204', 'L9', '1111100-1', 'L9V2', 0, 0, 'Spojovací', true, true,  '');
insert into trips (uid, route_id, service_id, shape_id, direction, exceptional, headsign, wheelchair, bikes_allowed, block_id)
    values ('9_6952_211205', 'L9', '1111100-1', 'L9V2', 0, 0, 'Spojovací', true, true,  '');
insert into trips (uid, route_id, service_id, shape_id, direction, exceptional, headsign, wheelchair, bikes_allowed, block_id)
    values ('9_6952_211206', 'L9', '1111100-1', 'L9V2', 0, 0, 'Spojovací', true, true,  '');

INSERT INTO public.trips (uid,route_id,service_id,shape_id,direction,exceptional,headsign,wheelchair,bikes_allowed,block_id) VALUES
('6_998_220103','L6','1111100-1','L6V2',1,0,'Palmovka',true,true,'block id'),
('6_5350_220103','L6','1111100-1','L6V2',1,0,'Palmovka',true,true,'block id'),
('6_5347_220103','L6','1111100-1','L6V2',1,0,'Palmovka',true,true,'block id'),
('6_5342_220103','L6','1111100-1','L6V2',1,0,'Palmovka',true,true,'block id'),
('6_5340_220103','L6','1111100-1','L6V2',1,0,'Palmovka',true,true,'block id'),
('6_5335_220103','L6','1111100-1','L6V2',1,0,'Palmovka',true,true,'block id');

-- Vehicle --
insert into vehicles (trip_id, next_stop_id, last_stop_id, origin_route_name, cis_line_id, cis_trip_number, start_timestamp, last_modified_timestamp, lat, lon, speed, dist_traveled, tracking, bearing, trip_sequence_id, delay, delay_last_stop, is_canceled, last_stop_departure, next_stop_arrival, vehicle_type, agency_name, scheduled_agency_name, registration_number, all_position)
    values ('9_6952_211202', 'U142Z2P', 'U203Z2P', '9', 'cis_line_id', 1, {ts '2022-01-05 8:00:00.00'}, {ts '2022-01-05 11:02:00.00'}, 50.085971, 14.433276, 35, 0.0, true, 0, 0, 1, 1, false, {ts '2022-01-05 11:01:00.00'}, {ts '2022-01-05 12:01:00.00'}, 2, 'agencyName', 'scheduledAgencyName', 'registrationNumber', 0);

insert into vehicles (trip_id, next_stop_id, last_stop_id, origin_route_name, cis_line_id, cis_trip_number, start_timestamp, last_modified_timestamp, lat, lon, speed, dist_traveled, tracking, bearing, trip_sequence_id, delay, delay_last_stop, is_canceled, last_stop_departure, next_stop_arrival, vehicle_type, agency_name, scheduled_agency_name, registration_number, all_position)
    values ('9_6952_211203', 'U203Z2P', 'U1072Z2P', '9', 'cis_line_id', 1, {ts '2022-01-05 8:00:00.00'}, {ts '2022-01-05 11:02:00.00'}, 50.084030, 14.428493, 35, 0.0, true, 0, 0, 1, 1, false, {ts '2022-01-05 11:01:00.00'}, {ts '2022-01-05 12:01:00.00'}, 2, 'agencyName', 'scheduledAgencyName', 'registrationNumber', 0);


-- Shape --
-- insert into shapes (uid, pt_sequence, lat, lon, dist_traveled)
--     values ('L9V2', 184, 50.08377, 14.42812, 11.17199);
-- insert into shapes (uid, pt_sequence, lat, lon, dist_traveled)
--     values ('L9V2', 185, 50.08434, 14.42896, 11.25945);
-- insert into shapes (uid, pt_sequence, lat, lon, dist_traveled)
--     values ('L9V2', 186, 50.08453, 14.4292, 11.28636);
-- insert into shapes (uid, pt_sequence, lat, lon, dist_traveled)
--     values ('L9V2', 245, 50.08695, 14.46968, 14.79415);

INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.065203,14.298871,0.0,1),
('L9V2',50.06527,14.299158,0.021899,2),
('L9V2',50.065582,14.299954,0.088559,3),
('L9V2',50.065713,14.300367,0.121551,4),
('L9V2',50.065773,14.300566,0.137311,5),
('L9V2',50.06579,14.301612,0.21219,6),
('L9V2',50.065766,14.302643,0.286042,7),
('L9V2',50.06575,14.303623,0.356281,8),
('L9V2',50.065737,14.304427,0.413835,9),
('L9V2',50.065703,14.305412,0.484445,10);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.065637,14.305967,0.524818,11),
('L9V2',50.06551,14.30623,0.548386,12),
('L9V2',50.064619,14.307827,0.69971,13),
('L9V2',50.06458,14.308012,0.713642,14),
('L9V2',50.0645,14.309407,0.813882,15),
('L9V2',50.064482,14.309721,0.836453,16),
('L9V2',50.064445,14.310183,0.869777,17),
('L9V2',50.06433,14.310753,0.912603,18),
('L9V2',50.064144,14.31114,0.947181,19),
('L9V2',50.063958,14.311497,0.980032,20);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.063683,14.311993,1.026848,21),
('L9V2',50.063458,14.312396,1.06507,22),
('L9V2',50.062841,14.313435,1.166329,23),
('L9V2',50.063063,14.314278,1.23155,24),
('L9V2',50.063344,14.314935,1.288053,25),
('L9V2',50.063645,14.315577,1.34488,26),
('L9V2',50.064006,14.316279,1.409201,27),
('L9V2',50.064049,14.316371,1.417359,28),
('L9V2',50.064327,14.316951,1.4691,29),
('L9V2',50.064618,14.317685,1.530846,30);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.064759,14.318099,1.564341,31),
('L9V2',50.064891,14.318604,1.603389,32),
('L9V2',50.065003,14.319233,1.650132,33),
('L9V2',50.065096,14.319894,1.698507,34),
('L9V2',50.065128,14.320216,1.721859,35),
('L9V2',50.065156,14.321677,1.826488,36),
('L9V2',50.065153,14.322753,1.903568,37),
('L9V2',50.065186,14.323337,1.945531,38),
('L9V2',50.065252,14.323675,1.970797,39),
('L9V2',50.065299,14.324013,1.995522,40);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.065421,14.324595,2.039397,41),
('L9V2',50.065632,14.325161,2.086236,42),
('L9V2',50.066163,14.326277,2.185566,43),
('L9V2',50.066245,14.326439,2.200349,44),
('L9V2',50.066404,14.32675,2.228736,45),
('L9V2',50.066594,14.327224,2.268767,46),
('L9V2',50.066706,14.327761,2.309159,47),
('L9V2',50.066779,14.32836,2.352791,48),
('L9V2',50.066831,14.328851,2.388452,49),
('L9V2',50.066983,14.329357,2.428369,50);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.067154,14.329816,2.466329,51),
('L9V2',50.067306,14.330367,2.509267,52),
('L9V2',50.067418,14.330981,2.554951,53),
('L9V2',50.0675,14.331534,2.595553,54),
('L9V2',50.067554,14.332256,2.647597,55),
('L9V2',50.067596,14.333609,2.744563,56),
('L9V2',50.067649,14.334977,2.842685,57),
('L9V2',50.067704,14.336519,2.953275,58),
('L9V2',50.067731,14.337306,3.009678,59),
('L9V2',50.06777,14.337928,3.054428,60);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.067897,14.341455,3.307299,61),
('L9V2',50.067911,14.341849,3.335513,62),
('L9V2',50.067937,14.342852,3.407383,63),
('L9V2',50.068062,14.346665,3.680733,64),
('L9V2',50.068174,14.35009,3.926199,65),
('L9V2',50.068256,14.351976,4.061562,66),
('L9V2',50.068298,14.352559,4.103517,67),
('L9V2',50.068334,14.352919,4.129631,68),
('L9V2',50.068386,14.35327,4.155393,69),
('L9V2',50.06857,14.354291,4.231305,70);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.069211,14.357829,4.494426,71),
('L9V2',50.069413,14.358951,4.57784,72),
('L9V2',50.069499,14.359915,4.64745,73),
('L9V2',50.069549,14.360646,4.700106,74),
('L9V2',50.069584,14.361815,4.783891,75),
('L9V2',50.069616,14.362919,4.863026,76),
('L9V2',50.069669,14.364769,4.995592,77),
('L9V2',50.069824,14.366839,5.144737,78),
('L9V2',50.070016,14.369328,5.324157,79),
('L9V2',50.07005,14.369965,5.369952,80);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.07008,14.370498,5.408254,81),
('L9V2',50.070078,14.370631,5.417774,82),
('L9V2',50.07007,14.371206,5.458954,83),
('L9V2',50.070047,14.371771,5.499455,84),
('L9V2',50.07003,14.372274,5.535506,85),
('L9V2',50.069999,14.372715,5.567292,86),
('L9V2',50.069996,14.373259,5.606228,87),
('L9V2',50.07005,14.373524,5.626139,88),
('L9V2',50.07005,14.37353,5.62658,89),
('L9V2',50.070465,14.375134,5.750274,90);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.070542,14.375695,5.791383,91),
('L9V2',50.070579,14.376209,5.828397,92),
('L9V2',50.070483,14.377372,5.912331,93),
('L9V2',50.070424,14.377935,5.953136,94),
('L9V2',50.070536,14.3786,6.002361,95),
('L9V2',50.070717,14.379998,6.104487,96),
('L9V2',50.070743,14.380193,6.118703,97),
('L9V2',50.0708,14.380942,6.172712,98),
('L9V2',50.070925,14.382009,6.25035,99),
('L9V2',50.070984,14.382561,6.290368,100);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.071356,14.385152,6.480436,101),
('L9V2',50.071617,14.387195,6.629523,102),
('L9V2',50.071624,14.387252,6.6337,103),
('L9V2',50.071752,14.388382,6.715755,104),
('L9V2',50.071907,14.389519,6.798972,105),
('L9V2',50.07216,14.391439,6.939261,106),
('L9V2',50.072307,14.393276,7.071783,107),
('L9V2',50.072325,14.393505,7.088274,108),
('L9V2',50.072356,14.394062,7.128324,109),
('L9V2',50.072376,14.395919,7.26129,110);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.072263,14.397347,7.364223,111),
('L9V2',50.072151,14.397674,7.390809,112),
('L9V2',50.072129,14.397746,7.39646,113),
('L9V2',50.072081,14.397888,7.407967,114),
('L9V2',50.071995,14.398097,7.425708,115),
('L9V2',50.07193,14.398292,7.441448,116),
('L9V2',50.071882,14.398437,7.453067,117),
('L9V2',50.071756,14.399366,7.521074,118),
('L9V2',50.071708,14.399743,7.548588,119),
('L9V2',50.071793,14.40091,7.632612,120);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.071904,14.402663,7.758711,121),
('L9V2',50.071965,14.403626,7.827991,122),
('L9V2',50.071975,14.403776,7.838767,123),
('L9V2',50.072073,14.404065,7.862176,124),
('L9V2',50.073149,14.403806,7.983193,125),
('L9V2',50.073566,14.403802,8.029583,126),
('L9V2',50.074073,14.403792,8.086018,127),
('L9V2',50.074467,14.403735,8.130064,128),
('L9V2',50.074919,14.403808,8.180512,129),
('L9V2',50.075437,14.403923,8.238753,130);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.076258,14.404109,8.331055,131),
('L9V2',50.076363,14.404133,8.342873,132),
('L9V2',50.076694,14.404175,8.379751,133),
('L9V2',50.07693,14.404181,8.406057,134),
('L9V2',50.078246,14.40428,8.552566,135),
('L9V2',50.078489,14.40424,8.579709,136),
('L9V2',50.078836,14.404182,8.618607,137),
('L9V2',50.078976,14.404321,8.637046,138),
('L9V2',50.079341,14.404652,8.684056,139),
('L9V2',50.079435,14.404787,8.698269,140);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.079981,14.404698,8.759302,141),
('L9V2',50.080535,14.404606,8.821371,142),
('L9V2',50.080562,14.404602,8.824323,143),
('L9V2',50.080804,14.404564,8.851341,144),
('L9V2',50.081172,14.404528,8.892451,145),
('L9V2',50.081214,14.406127,9.00698,146),
('L9V2',50.081246,14.406994,9.069181,147),
('L9V2',50.081267,14.407949,9.137541,148),
('L9V2',50.081278,14.408483,9.175751,149),
('L9V2',50.081298,14.409113,9.220928,150);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.081301,14.409564,9.253177,151),
('L9V2',50.081325,14.410546,9.323526,152),
('L9V2',50.081389,14.413005,9.499662,153),
('L9V2',50.081404,14.413274,9.518995,154),
('L9V2',50.081414,14.413787,9.555707,155),
('L9V2',50.081419,14.414066,9.575697,156),
('L9V2',50.081433,14.414808,9.628822,157),
('L9V2',50.081436,14.414884,9.634277,158),
('L9V2',50.081454,14.415348,9.667558,159),
('L9V2',50.081557,14.416005,9.71594,160);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.081635,14.416403,9.745751,161),
('L9V2',50.081955,14.417661,9.842524,162),
('L9V2',50.082357,14.419159,9.958686,163),
('L9V2',50.081168,14.419644,10.095365,164),
('L9V2',50.081143,14.419654,10.098316,165),
('L9V2',50.080468,14.419827,10.174342,166),
('L9V2',50.079185,14.419579,10.318182,167),
('L9V2',50.079148,14.420193,10.36233,168),
('L9V2',50.079143,14.420336,10.372528,169),
('L9V2',50.079141,14.421012,10.42091,170);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.07914,14.421027,10.422025,171),
('L9V2',50.079145,14.422098,10.49868,172),
('L9V2',50.079457,14.422553,10.546314,173),
('L9V2',50.079822,14.423082,10.601758,174),
('L9V2',50.080062,14.423385,10.636175,175),
('L9V2',50.080118,14.423456,10.644208,176),
('L9V2',50.080523,14.423933,10.700777,177),
('L9V2',50.08069,14.42418,10.726389,178),
('L9V2',50.081686,14.425377,10.866403,179),
('L9V2',50.081972,14.425691,10.905424,180);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.082279,14.426026,10.947063,181),
('L9V2',50.082376,14.426104,10.95927,182),
('L9V2',50.082492,14.426178,10.973162,183),
('L9V2',50.083771,14.428119,11.171991,184),
('L9V2',50.084344,14.428956,11.25945,185),
('L9V2',50.084529,14.429198,11.286357,186),
('L9V2',50.084967,14.429951,11.359028,187),
('L9V2',50.085353,14.430749,11.430452,188),
('L9V2',50.085412,14.430872,11.441393,189),
('L9V2',50.085578,14.431414,11.484404,190);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.085717,14.432062,11.533241,191),
('L9V2',50.086116,14.434008,11.679395,192),
('L9V2',50.086137,14.434078,11.684946,193),
('L9V2',50.086206,14.434313,11.703446,194),
('L9V2',50.086239,14.434687,11.730446,195),
('L9V2',50.085774,14.435995,11.837452,196),
('L9V2',50.085658,14.43632,11.864032,197),
('L9V2',50.085626,14.436468,11.875212,198),
('L9V2',50.085609,14.436697,11.891705,199),
('L9V2',50.085663,14.436996,11.913908,200);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.085915,14.43738,11.953113,201),
('L9V2',50.086135,14.437713,11.987318,202),
('L9V2',50.086229,14.437961,12.007934,203),
('L9V2',50.086239,14.438171,12.022967,204),
('L9V2',50.086159,14.438498,12.048027,205),
('L9V2',50.085888,14.439134,12.102589,206),
('L9V2',50.08542,14.439996,12.183311,207),
('L9V2',50.085272,14.44038,12.215326,208),
('L9V2',50.08521,14.440704,12.239492,209),
('L9V2',50.085204,14.441044,12.263823,210);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.085233,14.441475,12.29484,211),
('L9V2',50.085208,14.442016,12.333673,212),
('L9V2',50.085151,14.443424,12.434673,213),
('L9V2',50.085057,14.444305,12.498563,214),
('L9V2',50.084963,14.445339,12.57325,215),
('L9V2',50.08485,14.446592,12.663821,216),
('L9V2',50.084796,14.447111,12.701464,217),
('L9V2',50.08475,14.447516,12.730875,218),
('L9V2',50.084608,14.448787,12.823222,219),
('L9V2',50.08445,14.450076,12.917142,220);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.084379,14.450712,12.963316,221),
('L9V2',50.084309,14.45115,12.995627,222),
('L9V2',50.084123,14.452741,13.111368,223),
('L9V2',50.084045,14.453173,13.143382,224),
('L9V2',50.083989,14.453489,13.16691,225),
('L9V2',50.082631,14.455175,13.36019,226),
('L9V2',50.082508,14.456047,13.424096,227),
('L9V2',50.082452,14.456494,13.456643,228),
('L9V2',50.082436,14.456744,13.47465,229),
('L9V2',50.082422,14.456993,13.492558,230);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.082454,14.457325,13.51656,231),
('L9V2',50.082486,14.457657,13.540562,232),
('L9V2',50.082493,14.457728,13.545748,233),
('L9V2',50.082615,14.459019,13.639106,234),
('L9V2',50.08298,14.461968,13.854006,235),
('L9V2',50.083255,14.463708,13.982249,236),
('L9V2',50.083523,14.465381,14.105648,237),
('L9V2',50.083765,14.466893,14.21712,238),
('L9V2',50.084234,14.469809,14.432236,239),
('L9V2',50.084268,14.470018,14.447663,240);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.084379,14.470708,14.498595,241),
('L9V2',50.084874,14.470498,14.555716,242),
('L9V2',50.085617,14.470197,14.641068,243),
('L9V2',50.085735,14.47015,14.654618,244),
('L9V2',50.086952,14.469676,14.79415,245),
('L9V2',50.08789,14.469192,14.904104,246),
('L9V2',50.088403,14.468929,14.964142,247),
('L9V2',50.089087,14.468576,15.044344,248),
('L9V2',50.089367,14.468431,15.077163,249),
('L9V2',50.090349,14.467892,15.192938,250);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.09049,14.468859,15.263854,251),
('L9V2',50.090708,14.470076,15.354261,252),
('L9V2',50.09113,14.472425,15.52879,253),
('L9V2',50.091323,14.473513,15.609495,254),
('L9V2',50.091515,14.474526,15.685064,255),
('L9V2',50.091612,14.475037,15.723219,256),
('L9V2',50.091917,14.478196,15.951748,257),
('L9V2',50.092077,14.479735,16.063322,258),
('L9V2',50.092209,14.481009,16.155638,259),
('L9V2',50.092238,14.481288,16.175844,260);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.092364,14.482575,16.269004,261),
('L9V2',50.092455,14.483876,16.362639,262),
('L9V2',50.092514,14.485576,16.484449,263),
('L9V2',50.092513,14.485839,16.503264,264),
('L9V2',50.092511,14.486944,16.58236,265),
('L9V2',50.0925,14.488233,16.67458,266),
('L9V2',50.092414,14.490027,16.803326,267),
('L9V2',50.092274,14.491317,16.896937,268),
('L9V2',50.092183,14.492488,16.981311,269),
('L9V2',50.092169,14.492674,16.994677,270);
INSERT INTO public.shapes (uid,lat,lon,dist_traveled,pt_sequence) VALUES
('L9V2',50.092008,14.494894,17.154545,271),
('L9V2',50.091897,14.496874,17.296808,272),
('L9V2',50.091801,14.498549,17.417113,273),
('L9V2',50.091632,14.498923,17.449817,274),
('L9V2',50.091514,14.499256,17.477053,275),
('L9V2',50.091469,14.499374,17.486842,276);


-- TripStops --
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211202', 'U1072Z2P', 1, 0, PARSEDATETIME('10:00', 'HH:MM'));
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211202', 'U203Z2P', 2, 0, PARSEDATETIME('11:00', 'HH:MM'));
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211202', 'U142Z2P', 3, 0, PARSEDATETIME('12:00', 'HH:MM'));

insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211203', 'U1072Z2P', 1, 0, PARSEDATETIME('11:00', 'HH:MM'));
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211203', 'U203Z2P', 2, 0, PARSEDATETIME('12:00', 'HH:MM'));
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211203', 'U142Z2P', 3, 0, PARSEDATETIME('13:00', 'HH:MM'));

insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211204', 'U1072Z2P', 1, 0, PARSEDATETIME('16:00', 'HH:MM'));
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211204', 'U203Z2P', 2, 0, PARSEDATETIME('17:00', 'HH:MM'));
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211204', 'U142Z2P', 3, 0, PARSEDATETIME('18:00', 'HH:MM'));

insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211205', 'U1072Z2P', 1, 0, PARSEDATETIME('19:00', 'HH:MM'));
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211205', 'U203Z2P', 2, 0, PARSEDATETIME('20:00', 'HH:MM'));
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211205', 'U142Z2P', 3, 0, PARSEDATETIME('21:00', 'HH:MM'));

insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211206', 'U1072Z2P', 1, 0, PARSEDATETIME('22:00', 'HH:MM'));
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211206', 'U203Z2P', 2, 0, PARSEDATETIME('23:00', 'HH:MM'));
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211206', 'U142Z2P', 3, 0, PARSEDATETIME('23:30', 'HH:MM'));


-- FavouriteRoutes --
insert into users_favourite_routes (user_id, route_id)
    values (1, 'L9');

-- FavouriteTrips --
insert into users_favourite_trips (user_id, trip_id)
    values (1, '9_6952_211202');

-- Delay --
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-01', '9_6952_211202', 'U1072Z2P', 1);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-02', '9_6952_211202', 'U1072Z2P', 5);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-03', '9_6952_211202', 'U1072Z2P', 3);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-04', '9_6952_211202', 'U1072Z2P', 0);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-05', '9_6952_211202', 'U1072Z2P', 1);

insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-01', '9_6952_211202', 'U203Z2P', 1);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-02', '9_6952_211202', 'U203Z2P', 2);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-03', '9_6952_211202', 'U203Z2P', 2);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-04', '9_6952_211202', 'U203Z2P', 0);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-05', '9_6952_211202', 'U203Z2P', 1);


insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-02-01', '9_6952_211202', 'U142Z2P', 1);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-02-02', '9_6952_211202', 'U142Z2P', 2);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-02-03', '9_6952_211202', 'U142Z2P', 2);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-02-04', '9_6952_211202', 'U142Z2P', 0);


insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-01', '9_6952_211202', 'U142Z2P', 1);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-02', '9_6952_211202', 'U142Z2P', 2);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-03', '9_6952_211202', 'U142Z2P', 2);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-04', '9_6952_211202', 'U142Z2P', 0);
insert into delay (dated, trip_id, stop_id, delay_min)
values ('2022-01-05', '9_6952_211202', 'U142Z2P', 1);



