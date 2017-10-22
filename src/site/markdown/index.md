# Camel workshop

This project holds all kinds of Camel routes

All things should work in the end :-) if you can follow instructions ...

The only reason to integrate with spring-boot is that it bootstraps easily and we can start playing immediately.

This project works best when run in combination with docker. I've included a `docker-compose.yml`  
file providing all needed 'middleware'. This enables actually testing the ftp protocol or jms, mq and stuff.  
You can read more about that in the usage section.

If all went well there is also a RaspberryPi available as test middleware. 
It might be fun to try to send messages to the pi that can be picked up by another...

Have fun!