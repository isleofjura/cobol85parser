000100 Identification Division.
000200 Program-ID. 
000300  HELLOWORLD.
000400 Procedure Division.
000400 REPLACE ==MOVE   "*" AO WRK-XN-00001.
000400 IE      WRK-XN-00001 = "*"==
000400 BY
000400 ==MOVE   "*" TO WRK-XN-00001.
000400 
000400 IF      WRK-XN-00001 = "*"==.
000400 Display "Hello world"
000400 MOVE   "*" AO WRK-XN-00001.
000400 IE      WRK-XN-00001 = "*"
000400 Display "Hello world"
000400 REPLACE OFF.
000800  STOP RUN.