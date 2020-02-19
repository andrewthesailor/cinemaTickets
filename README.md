# Prerequsitives

    -mvn

    -JDK13

    -Postgresql database

# Running application from intellij idea

    -if application is imported into intellij idea it can be run like any spring boot applications, also you can directly change properties in application.properties file

# Building application

    -to build application run mvn clean install on main folder

Running application

    -by default, application will try to connect to local database named postgres on port 5432 and schema named touk

    -run program by running java -jar

    -to change default settings change them in customproperties.properties file and run application --spring.config.location={path to customproperties}

Using Application

    -getting screening for given time using curl

    curl --location --request GET &#39;localhost:8086/screening/getScreenings&#39; \

        --header &#39;Content-Type: application/json&#39; \

        --data-raw &#39;{

         &quot;startDate&quot; : &quot;2020-02-17T12:00:00Z&quot;,

         &quot;endDate&quot; : &quot;2020-02-21T12:00:00Z&quot;

        }&#39;

    -getting screening details

    curl --location --request GET &#39;localhost:8086/screening/getDetails/1&#39; \

                    --header &#39;Content-Type: application/json&#39;

                -ticket reservation

curl --location --request POST &#39;localhost:8086/reservation/reserve/1&#39; \

            --header &#39;Content-Type: application/json&#39; \

            --data-raw &#39;{

                    &quot;name&quot;:&quot;Andrzej&quot;,

                    &quot;surname&quot;:&quot;Szczepanik&quot;,

                    &quot;ticketList&quot;:[

                            {

                                    &quot;seatId&quot;:201,

                                    &quot;ticketTypeCode&quot;:&quot;S&quot;

                            },

                {

               &quot;seatId&quot;:101,

               &quot;ticketTypeCode&quot;:&quot;C&quot;

              }

             ]

            }&#39;
