CREATE SEQUENCE S_ROOM_ID START WITH 1 INCREMENT BY 50;
CREATE TABLE T_ROOMS(
    ROOM_ID NUMERIC(10,0) PRIMARY KEY,
    ROOM_NUMBER VARCHAR(30) NOT NULL
);