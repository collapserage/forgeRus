Русификатор Minecraft Forge

Скачать: http://minecraft.collapsed.space/
Форум: http://rubukkit.org/threads/.43139/

Инструкция по установке

export BUILD_NUMBER=1492 _(Linux) или_ set BUILD_NUMBER=1492 _(Windows)_
git init
git clone -b 1.7.10 --single-branch --recursive https://github.com/collapserage/forgeRus.git
cd forgeRus
gradle setupForge
gradle ciWriteBuildNumber
gradle build
