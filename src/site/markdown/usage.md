# Usage

## Prerequisites

* docker (native) installed
* docker-compose installed
* java 8 installed
* maven 3+ installed
* a sense of adventure :-)
* a good OS like linux or macOs :-)

## Run

In order to be able to run the demo you first need to start
the docker containers from the docker-compose file.

Then you can run application by starting CamelDemoApplication from the IDE
or with maven:

```bash
docker-compose up -d
mvn clean package spring-boot:run
```

## What will happen

A scenario something like the one below will play out... it changes as I add new demo's but you'll get the drift:

* a HelloWorld file is located here: `test-data/startingPoint/HelloWorld.txt`
* this file will be copied by the FileCopyRoute to the `test-data/SimpleJmsRoute` folder
* The SimpleJmsRoute_1 listens here and routes the file to ActiveMQ Queue SimpleJmsRoute
* The SimpleJmsRoute_2 listens here and routes the message to the `test-data/ftp/admin` folder and prints the content of the body to console
* the FtpToFtpRoute will see this because that is the volume "mounted" by the ftp docker container for the admin user. 
* The FtpToFtpRoute will copy the file to the ftp `user` account through the ftp protocol
* it will also move the file in the `admin` account to a .camel folder
* The FtpToFileRoute will see the file in the ftp `user` account and copy it to `target/FtpToFileRoute`
* it will also move the file in the `user` account to .camel in its home folder
* the log will also print out something like:

```text
2017-04-13 22:11:25.048  INFO 5473 --- [/startingPoint/] SimpleFileCopyRoute                      : Found file [HelloWorld.txt] and copying it to: /Users/ivonet/dev/camel-demo/test-data/SimpleJmsRoute/
2017-04-13 22:11:25.192  INFO 5473 --- [SimpleJmsRoute]] nl.ivonet.route.jms.SimpleJmsRoute       : Hello, world!
2017-04-13 22:11:25.666  INFO 5473 --- [localhost:11021] FtpToFtpRoute                            : Found file [HelloWorld.txt] and cp-ing it to the ftp user: user
2017-04-13 22:11:26.169  INFO 5473 --- [localhost:11021] FtpToFileRoute                           : Found file [HelloWorld.txt] and copying it to: /Users/ivonet/dev/camel-demo/target/
```

The whole idea of the above thing is to play around with routes as to get familiar with it.

The scenario above is outdated because lots more has been implemented but it is a good place to start. 
Just follow the routes further and you will see it all happening...

# docker

The `docker-compose.yml` file in this project has been tuned to work for this camel-demo project.
So some volumes have been mounted with a specific goal.

## Start / Stop docker-compose

Start:

```bash
docker-compose up [-d]
```

the -d option will start in daemon mode

Stop:

```bash
docker-compose down [-v]
```

the -v option will also remove the docker volumes created. You can do this any time you want. It might even be preferable in this
project as you can then see everything happening from the beginning state.


# FTP docker image

In order to demo the ftp routes in this project an ftp server has been configured in the docker-compose file.
This ftp server mounts 'native local' folders in the `test-data/ftp` folder but it will also actually enable 
the ftp protocol. So the FtpTo*Routes really talk ftp in the demo.

You will be able to see what happens on your native file system though. Please look at the ftp config in the 
docker-compose file to see how that works.

## FTP User

This project has two users pre-configured:

* USER: admin / PWD: secret
* USER: user / PWD: secret

Their home folders reside in `test-data/ftp` and the users have been saved in `docker/ftp/passwd/pureftpd.passwd` file as described below.

### FTP Create your own user

You can add your own user(s) if you want to play:

First you need to start the ivonet/ftp docker container:

```bash
docker run --rm --name ftp \
   -v $(pwd)/docker/ftp/passwd:/etc/pure-ftpd/passwd \
   -v $(pwd)/target/ftpusers:/home/ftpusers/ \
   -p 11021:21 \
   -p 30000-30009:30000-30009 \
   ivonet/ftp
```

Then you need to enter the running image:

```bash
docker exec -it ftp /bin/bash
pure-pw useradd USERHERE \
   -f /etc/pure-ftpd/passwd/pureftpd.passwd \
   -m -u ftpuser \
   -d /home/ftpusers/USERHERE
```

Exit the image with logout and stop the image with ctrl-c or

```bash
docker stop ftp
```

## ActiveMQ docker image

For this demo ActiveMQ has been chosen as the JMS provider and Message Queue middleware.

* [Console](http://localhost:8161) (admin:secret)
* read more about this image [here](https://hub.docker.com/r/ivonet/activemq/)

## Mysql docker image

To make looking at the results of what happens to to de db `phpmyadmin` has also been included.

* [Console](http://localhost:8888) (root:secret)
* read more about this image [here](https://hub.docker.com/r/ivonet/mysql/)
* this images looks in `docker/mysql/setup` for initializing sql scripts when the first `docker-compose up` is done
