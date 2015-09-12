#Русификатор Minecraft Forge

Скачать: http://minecraft.collapsed.space/  
Форум: http://rubukkit.org/threads/.43139/

##Как установить исходники

Ставим git и gradle, затем набираем следующие команды

1. export BUILD_NUMBER=1492 *(Linux) или* set BUILD_NUMBER=1492 *(Windows)*  
2. git init  
3. git clone -b 1.7.10 --single-branch --depth 1 https://github.com/collapserage/forgeRus.git  
4. cd forgeRus  
5. gradle setupForge  
6. gradle ciWriteBuildNumber  

После изменения исходников делаем *gradle build*
