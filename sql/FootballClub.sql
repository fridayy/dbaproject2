#DBJPA Project Table - Krenn/Hierhold
CREATE TABLE nation (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  name      varchar(120) NOT NULL UNIQUE, 
  alphacode varchar(3) NOT NULL UNIQUE, 
  PRIMARY KEY (id), 
  UNIQUE INDEX (id)) engine=InnoDB;
CREATE TABLE position (
  id           int(10) NOT NULL AUTO_INCREMENT, 
  name         varchar(120) NOT NULL UNIQUE, 
  abbreviation varchar(3) NOT NULL UNIQUE, 
  PRIMARY KEY (id), 
  UNIQUE INDEX (id)) engine=InnoDB;
CREATE TABLE team (
  id           int(10) NOT NULL AUTO_INCREMENT, 
  name         varchar(120) NOT NULL UNIQUE, 
  abbreviation varchar(5) NOT NULL, 
  PRIMARY KEY (id), 
  UNIQUE INDEX (id)) engine=InnoDB;
CREATE TABLE `function` (
  operative_person_id int(10) NOT NULL, 
  id                  int(10) NOT NULL AUTO_INCREMENT, 
  title               varchar(120) NOT NULL UNIQUE, 
  PRIMARY KEY (id), 
  UNIQUE INDEX (id)) engine=InnoDB;
CREATE TABLE player (
  person_id    int(10) NOT NULL, 
  jerseynumber int(2) NOT NULL, 
  height       int(3), 
  weight       int(3), 
  nation_id     int(10), 
  PRIMARY KEY (person_id)) engine=InnoDB;
CREATE TABLE person (
  id          int(10) NOT NULL AUTO_INCREMENT,
  DType       varchar(20), #this is used for JPA inheritance purposes.
  firstname   varchar(120) NOT NULL, 
  lastname    varchar(120) NOT NULL, 
  dateofbirth date NOT NULL, 
  gender      char(1) NOT NULL, 
  address     varchar(255) NOT NULL, 
  email       varchar(255) NOT NULL, 
  phonenumber varchar(22) NOT NULL, 
  PRIMARY KEY (id), 
  UNIQUE INDEX (id)) engine=InnoDB;
CREATE TABLE coach (
  person_id int(10) NOT NULL, 
  role      varchar(120), 
  PRIMARY KEY (person_id)) engine=InnoDB;
CREATE TABLE operative (
  person_id int(10) NOT NULL, 
  office    varchar(20) NOT NULL, 
  PRIMARY KEY (person_id)) engine=InnoDB;
CREATE TABLE player_position (
  player_person_id int(10) NOT NULL, 
  position_id      int(10) NOT NULL, 
  PRIMARY KEY (player_person_id, 
  position_id)) engine=InnoDB;
CREATE TABLE player_team (
  player_person_id int(10) NOT NULL, 
  team_id          int(10) NOT NULL, 
  PRIMARY KEY (player_person_id, 
  team_id)) engine=InnoDB;
CREATE TABLE coach_team (
  coach_person_id int(10) NOT NULL, 
  team_id         int(10) NOT NULL, 
  PRIMARY KEY (coach_person_id, 
  team_id)) engine=InnoDB;
ALTER TABLE coach ADD INDEX FKcoach694300 (person_id), ADD CONSTRAINT FKcoach694300 FOREIGN KEY (person_id) REFERENCES person (id);
ALTER TABLE operative ADD INDEX FKoperative178656 (person_id), ADD CONSTRAINT FKoperative178656 FOREIGN KEY (person_id) REFERENCES person (id);
ALTER TABLE `function` ADD INDEX FKfunction680046 (operative_person_id), ADD CONSTRAINT FKfunction680046 FOREIGN KEY (operative_person_id) REFERENCES operative (person_id);
ALTER TABLE player ADD INDEX FKplayer280014 (person_id), ADD CONSTRAINT FKplayer280014 FOREIGN KEY (person_id) REFERENCES person (id) ON DELETE CASCADE;
ALTER TABLE player_position ADD INDEX FKplayer_pos71205 (player_person_id), ADD CONSTRAINT FKplayer_pos71205 FOREIGN KEY (player_person_id) REFERENCES player (person_id) ON DELETE CASCADE;
ALTER TABLE player_position ADD INDEX FKplayer_pos820051 (position_id), ADD CONSTRAINT FKplayer_pos820051 FOREIGN KEY (position_id) REFERENCES position (id) ON DELETE CASCADE;
ALTER TABLE player_team ADD INDEX FKplayer_tea722799 (player_person_id), ADD CONSTRAINT FKplayer_tea722799 FOREIGN KEY (player_person_id) REFERENCES player (person_id) ON DELETE CASCADE;
ALTER TABLE player_team ADD INDEX FKplayer_tea30546 (team_id), ADD CONSTRAINT FKplayer_tea30546 FOREIGN KEY (team_id) REFERENCES team (id) ON DELETE CASCADE;
ALTER TABLE coach_team ADD INDEX FKcoach_team777331 (coach_person_id), ADD CONSTRAINT FKcoach_team777331 FOREIGN KEY (coach_person_id) REFERENCES coach (person_id) ON DELETE CASCADE;
ALTER TABLE coach_team ADD INDEX FKcoach_team48327 (team_id), ADD CONSTRAINT FKcoach_team48327 FOREIGN KEY (team_id) REFERENCES team (id) ON DELETE CASCADE;
ALTER TABLE player ADD INDEX FKplayer118316 (nation_id), ADD CONSTRAINT FKplayer118316 FOREIGN KEY (nation_id) REFERENCES nation (id) ON DELETE SET NULL;
