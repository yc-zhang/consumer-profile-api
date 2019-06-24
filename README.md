# consumer-profile-api

## Stylecheck / Test / Coverage

```bash
sbt clean scalastyle test:scalastyle testOnly coverageReport
```

After build the report could be found at [target/scala-2.12](target/scala-2.12).

## Package & Run

Use `sbt-native-packager` to create a universal package.

```bash
sbt universal:packageBin
```

And run it locally:

```bash
./target/universal/stage/bin/consumer-profile-api
```

You can also use sbt to run the program like:

```bash
sbt run
```

To verify everything goes well you need:

```bash
curl -i http://0.0.0.0:8080/helloworld
```

## Docker support

We will use docker to support people who want to develop this program in any 
platform or os, so that we introduce `docker-compose` to setup local env.
Also we will use that for testing and package, in short if you have docker 
on your laptop, you don't need java or scala to support your develop work.  

And a the program will release in docker image, of course.

### Spells
```bash
# Run server in container
docker-compose up dev

# Into a dev environment
docker-compose run dev bash

# in docker env
# run style check etc...
./sbt clean scalastyle test:scalastyle testOnly coverageReport

# and package
./sbt universal:packageBin
```  
