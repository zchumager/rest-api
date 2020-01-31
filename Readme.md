run mysql: mysql.server start

Due to an error present on JDK 8 the line below should be added into VM Options
--add-opens java.base/jdk.internal.loader=ALL-UNNAMED

1 - Open Configuration Window: Run -> Edit Configurations -> Configuration -> VM Options
2 - Add in VM Options: --add-opens java.base/jdk.internal.loader=ALL-UNNAMED

Build Project: 
./gradlew build
java -jar build/libs rest-api-1.0-SNAPSHOT.jar

Note: jar file generated in build/libs is not working so project should be run using 
the play button of intellijIDEA