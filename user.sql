
create table if not exists user (id int auto_increment, 
				   username varchar(100),
				   password varchar(100),
				   realname varchar(200),
				   created_at datetime,
				   last_login_at datetime,
				   is_active tinyint,
				   status tinyint, 
				   primary key(id), index(username), index(is_active), index(status)
);


create table if not exists attendance (id int auto_increment,
					   user_id int,
					   checkin_time datetime,
					   type tinyint, 
					   primary key(id), 
					   index(type),
					   constraint attendance_userid foreign key(user_id) references user(id)
);

create table if not exists notepad (id int auto_increment,
				   user_id int,
				   title varchar(100),
				   content varchar(200),
				   create_time datetime,
				   last_edit_time datetime,
				   status tinyint, 
				   primary key(id), 
				   index(status),
				   constraint notepad_id foreign key(user_id) references user(id) 
);


create table if not exists absence (id int auto_increment,
				   user_id int,
				   start_time datetime,
				   end_time datetime,
				   status tinyint, 
				   created_at datetime,
				   primary key(id), 
				   index(status),
				   constraint leave_userid foreign key(user_id) references user(id) 
);