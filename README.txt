Русификатор Minecraft Forge

Скачать: http://minecraft.collapsed.space/
Форум: http://rubukkit.org/threads/.43139/

Инструкция по установке

export BUILD_NUMBER=1492
git init
git clone -b 1.7.10 --single-branch --recursive https://github.com/collapserage/forgeRus.git
cd MinecraftForge
gradle setupForge
gradle ciWriteBuildNumber
gradle build





