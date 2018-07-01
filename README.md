<h2 align="center">
  
   <br>
    <h1>Play Swagger</h1>
   <br>
  <h4 align="center">CRUD application to show you, how you can user <a href="https://www.playframework.com/">Play<a/> <a href="https://github.com/swagger-api/swagger-play/tree/master/play-2.6/swagger-play">Swagger<a/> and <a href="http://reactivemongo.org/">ReactiveMongo<a/>
  : to create API's and document them.
  
</h2>


### How to run this app
You need
* MongoDB Installed and running on your machine(cd to bin directory of mongo and run  
```./mongod``` this will start the mongo database server) 
* SBT( Simple Build Tool)

 In your computer's terminal cd(change directory) to the application folder and the then type 
```sbt ~run```
 
Then open your favourite browser and go to

```localhost:9000/api-docs```

From the  Swagger-UI interface you can perform all the CRUD operations.

### Testing this application
In the tests directory there are tests written with the [ScalaTest](http://www.scalatest.org/) library.  
To launch them just type ```~test``` in a running SBT session or simply type ```sbt ~test```

.

Author: [Dan Kamau](kamaudan.github.io/)
