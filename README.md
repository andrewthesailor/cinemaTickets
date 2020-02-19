##Prerequsitives
    -mvn
    -JDK13
    -Postgresql database
#Running application from intellij idea
    -if application is imported into intellij idea it can be run like any spring boot applications, also you can directly change properties in application.properties file
##Building application
    -to build application run mvn clean install on main folder
##Running application
    -by default application will try to connect to local database named postgres on port 5432 and schema named touk
    -run program by running java -jar 
    -to change default settings change them in customproperties.properties file and run application --spring.config.location={path to customproperties}
##Using Application
    -getting screening for given time using curl 
    curl --location --request GET 'localhost:8086/screening/getScreenings' \
        --header 'Content-Type: application/json' \
        --data-raw '{
        	"startDate" : "2020-02-17T12:00:00Z",
        	"endDate" : "2020-02-21T12:00:00Z"
        }'
    -getting screening details 
    curl --location --request GET 'localhost:8086/screening/getDetails/1' \
                    --header 'Content-Type: application/json'
                -ticket reservation curl --location --request POST 'localhost:8086/reservation/reserve/1' \
            --header 'Content-Type: application/json' \
            --data-raw '{
            	"name":"Andrzej",
            	"surname":"Szczepanik",
            	"ticketList":[
            		{
            			"seatId":201,
            			"ticketTypeCode":"S"
            		},
            				{
            			"seatId":101,
            			"ticketTypeCode":"C"
            		}
            	]
            }'