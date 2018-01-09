-- 权限表 --
CREATE TABLE permission (
  pid int(11) not null auto_increment,
  name varchar(255) not null default,
  url VARCHAR(255) default '',
  PRIMARY KEY (pid)
);

CREATE TABLE user (
  uid int(11) not NULL auto_increment,
  username varchar(255) not NULL,
  password varchar(255) not NULL,
  PRIMARY KEY (uid)
);

CREATE TABLE role (
  rid int(11) not NULL auto_increment,
  name varchar(255) not NULL,
  PRIMARY KEY (rid)
);

CREATE TABLE permission_role(
  rid INT(11) NOT NULL ,
  pid INT(11) NOT NULL ,
  KEY idx_rid (rid),
  KEY idx_pid (pid)
);

CREATE TABLE user_role(
  uid INT(11) NOT NULL ,
  rid INT(11) NOT NULL ,
  KEY idx_uid (uid),
  KEY idx_rid (rid)
);