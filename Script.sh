#!/bin/bash

rm -r "Datos Censo 2017"

wget https://datosabiertos.ine.cl/datasets/187198-microdatos-censo-2017-viviendas.download/

mv -v index.html Viviendas.zip

wget https://datosabiertos.ine.cl/datasets/187199-microdatos-censo-2017-personas.download/

mv -v index.html Personas.zip

wget https://datosabiertos.ine.cl/datasets/187197-microdatos-censo-2017-hogares.download/

mv -v index.html Hogares.zip

mkdir "Datos Censo 2017"

mv -v Hogares.zip "Datos Censo 2017"

mv -v Personas.zip "Datos Censo 2017"

mv -v Viviendas.zip "Datos Censo 2017"

cd Dat*

unzip Hogares.zip

unzip Personas.zip

unzip Viviendas.zip

rm Hogares.zip

rm Personas.zip

rm Viviendas.zip

cd ..

git clone https://github.com/RodrigoCC-dev/ProyectoINE_backend.git

cd Proy*

mvn clean test package

cd target

sudo cp *.war /opt/tomcat/webapps/Proyecto-INE.war

sudo systemctl restart tomcat8