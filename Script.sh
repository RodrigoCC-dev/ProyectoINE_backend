#!/bin/bash


rm -rf Datos_Censo_2017

mkdir Datos_Censo_2017

wget https://datosabiertos.ine.cl/datasets/187198-microdatos-censo-2017-viviendas.download/

mv -v index.html Viviendas.zip

wget https://datosabiertos.ine.cl/datasets/187199-microdatos-censo-2017-personas.download/

mv -v index.html Personas.zip

wget https://datosabiertos.ine.cl/datasets/187197-microdatos-censo-2017-hogares.download/

mv -v index.html Hogares.zip

mv -v Hogares.zip Datos_Censo_2017

mv -v Personas.zip Datos_Censo_2017

mv -v Viviendas.zip Datos_Censo_2017

cp -v ~/ProyectoINE_backend/src/main/resources/static/Division_Politica-Chile.csv Datos_Censo_2017/Division_Politica-Chile.csv

cd Dat*

unzip Hogares.zip

unzip Personas.zip

unzip Viviendas.zip

rm -v Hogares.zip

rm -v Personas.zip

rm -v Viviendas.zip

cd ~/Proy*

mvn clean test package

cd target

sudo cp *.war /var/lib/tomcat8/webapps/Proyecto-INE.war

cd ../..

sudo rm -rf ProyectoINE_backend

sudo service tomcat8 restart