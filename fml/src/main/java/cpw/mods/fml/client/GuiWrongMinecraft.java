/*
 * Forge Mod Loader
 * Copyright (c) 2012-2013 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * Contributors:
 *     cpw - implementation
 */

package cpw.mods.fml.client;

import net.minecraft.client.gui.GuiErrorScreen;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.WrongMinecraftVersionException;

public class GuiWrongMinecraft extends GuiErrorScreen
{
    private WrongMinecraftVersionException wrongMC;
    public GuiWrongMinecraft(WrongMinecraftVersionException wrongMC)
    {
        super(null,null);
        this.wrongMC = wrongMC;
    }
    @Override
    public void initGui()
    {
        super.initGui();
        this.buttonList.clear();
    }
    @Override
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.drawDefaultBackground();
        int offset = 75;
        this.drawCenteredString(this.fontRendererObj, net.minecraft.client.resources.I18n.format("adv.fml.error.title"), this.width / 2, offset, 0xFFFFFF);
        offset+=10;
        this.drawCenteredString(this.fontRendererObj, net.minecraft.client.resources.I18n.format("adv.fml.error.wrongMinecraft.1", Loader.instance().getMinecraftModContainer().getVersion()), this.width / 2, offset, 0xFFFFFF);
        offset+=5;
        offset+=10;
        this.drawCenteredString(this.fontRendererObj, net.minecraft.client.resources.I18n.format("adv.fml.error.wrongMinecraft.2", wrongMC.mod.getName(), wrongMC.mod.getModId(), wrongMC.mod.acceptableMinecraftVersionRange()), this.width / 2, offset, 0xEEEEEE);
        offset+=20;
        this.drawCenteredString(this.fontRendererObj, net.minecraft.client.resources.I18n.format("adv.fml.error.more"), this.width / 2, offset, 0xFFFFFF);
    }
}
