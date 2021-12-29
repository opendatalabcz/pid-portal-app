-- Users --
insert into users (email, name, password, role, username)
    values ('email@mail.com', 'name', '$2a$10$dh2e/ujIGyCgCK0P9C9a4OvHEXwDxzk6LVFyEqH9zGeSkdk2MW0oS', 'USER', 'username');

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
    values ('L9', 'Sídliště Řepy - Spojovací', '9', '', '99', '7A0603', 'FFFFFF', '0', 'https://pid.cz/linka/9', false, 'L9V2');



-- Trips --
insert into trips (uid, route_id, service_id, shape_id, direction, exceptional, headsign, wheelchair, bikes_allowed, block_id)
    values ('9_6952_211202', 'L9', '1111100-1', 'L9V2', 0, 0, 'Spojovací', true, true,  '');

-- Vehicle --
insert into vehicles (trip_id, next_stop_id, last_stop_id, origin_route_name, cis_line_id, cis_trip_number, start_timestamp, last_modified_timestamp, lat, lon, speed, dist_traveled, tracking, bearing, trip_sequence_id, delay, delay_last_stop, is_canceled, last_stop_departure, next_stop_arrival, vehicle_type, agency_name, scheduled_agency_name, registration_number, all_position)
    values ('9_6952_211202', 'U203Z2P', 'U1072Z2P', '9', 'cis_line_id', 1, {ts '2012-09-17 18:47:52.69'}, {ts '2012-09-17 18:47:52.69'}, 50.08199, 14.42579, 35, 0.0, true, 0, 0, 1, 1, false, {ts '2012-09-17 18:47:52.69'}, {ts '2012-09-17 18:47:52.69'}, 2, 'agencyName', 'scheduledAgencyName', 'registrationNumber', 0);

-- Shape --
insert into shapes (uid, pt_sequence, lat, lon, dist_traveled)
    values ('L9V2', 184, 50.08377, 14.42812, 11.17199);
insert into shapes (uid, pt_sequence, lat, lon, dist_traveled)
    values ('L9V2', 185, 50.08434, 14.42896, 11.25945);
insert into shapes (uid, pt_sequence, lat, lon, dist_traveled)
    values ('L9V2', 186, 50.08453, 14.4292, 11.28636);
insert into shapes (uid, pt_sequence, lat, lon, dist_traveled)
    values ('L9V2', 245, 50.08695, 14.46968, 14.79415);

-- TripStops --
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211202', 'U1072Z2P', 1, 0, {ts '2012-09-17 18:47:52.69'});
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211202', 'U203Z2P', 2, 0, {ts '2012-09-17 18:47:52.69'});
insert into trip_stops (trip_id, stop_id, index, day_of_week, arrival)
    values ('9_6952_211202', 'U142Z2P', 3, 0, {ts '2012-09-17 18:47:52.69'});


-- FavouriteRoutes --
insert into users_favourite_routes (user_id, favourite_routes_uid)
    values (1, 'L9');

-- FavouriteTrips --
insert into users_favourite_trips (user_id, favourite_trips_uid)
    values (1, '9_6952_211202');
