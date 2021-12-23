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
    values ('U203Z2P', 'Jindřišská', 14.43078, 50.08532, 'P', 1, 'parent location');
insert into stops (uid, name, lat, lon, zone_id, wheelchair, parent_station)
    values ('U142Z2P', 'Hlavní nádraží', 14.43593, 50.08569, 'P', 1, 'parent location');

-- Route --
insert into routes (uid, long_name, short_name, desc, agency, color, text_color, type, url, is_night)
    values ('L9', 'Sídliště Řepy - Spojovací', '9', '', '99', '7A0603', 'FFFFFF', '0', 'https://pid.cz/linka/9', false);


-- Trips --
insert into trips (uid, route_id, service_id, shape_id, direction, exceptional, headsign, wheelchair, bikes_allowed, block_id)
    values ('9_6952_211202', 'L9', '1111100-1', 'L9V2', 0, 0, 'Spojovací', true, true,  '');

-- TripStops --
insert into trip_stops (trip_id, stop_id, index, arrival)
    values ('9_6952_211202', 'U1072Z2P', 1, {ts '2012-09-17 18:47:52.69'});
insert into trip_stops (trip_id, stop_id, index, arrival)
    values ('9_6952_211202', 'U203Z2P', 2, {ts '2012-09-17 18:47:52.69'});
insert into trip_stops (trip_id, stop_id, index, arrival)
    values ('9_6952_211202', 'U142Z2P', 3, {ts '2012-09-17 18:47:52.69'});


-- FavouriteRoutes --
insert into users_favourite_routes (user_id, favourite_routes_uid)
    values (1, 'L9');

-- FavouriteTrips --
insert into users_favourite_trips (user_id, favourite_trips_uid)
    values (1, '9_6952_211202');
