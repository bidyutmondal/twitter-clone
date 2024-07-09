# twitter-clone


Setting up the docker instances

sudo docker compose up -d

sudo docker exec -t auth-postgres psql -U authuser -d auth_db
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(100) NOT NULL
);

sudo docker exec -t user-management-postgres psql -U usermgmtuser -d user_management_db
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE 
);


