CREATE TABLE muse_song (SONG_ID BIGINT NOT NULL, song_audio_link VARCHAR(255), song_lyrics VARCHAR(255), song_title VARCHAR(255), SONG_WRITER LONGBLOB, PRIMARY KEY (SONG_ID))
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
