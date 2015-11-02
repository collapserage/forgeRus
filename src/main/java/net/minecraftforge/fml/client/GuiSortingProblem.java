package net.minecraftforge.fml.client;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.toposort.ModSortingException;
import net.minecraftforge.fml.common.toposort.ModSortingException.SortingExceptionData;

public class GuiSortingProblem extends GuiScreen {
    private SortingExceptionData<ModContainer> failedList;

    public GuiSortingProblem(ModSortingException modSorting)
    {
        this.failedList = modSorting.getExceptionData();
    }

    @Override
    public void initGui()
    {
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        int offset = Math.max(85 - (failedList.getVisitedNodes().size() + 3) * 10, 10);
        this.drawCenteredString(this.fontRendererObj, net.minecraft.client.resources.I18n.format("adv.fml.error.title"), this.width / 2, offset, 0xFFFFFF);
        offset+=10;
        this.drawCenteredString(this.fontRendererObj, net.minecraft.client.resources.I18n.format("adv.fml.error.sorting.1"), this.width / 2, offset, 0xFFFFFF);
        offset+=10;
        this.drawCenteredString(this.fontRendererObj, net.minecraft.client.resources.I18n.format("adv.fml.error.sorting.2", failedList.getFirstBadNode()), this.width / 2, offset, 0xFFFFFF);
        offset+=10;
        this.drawCenteredString(this.fontRendererObj, net.minecraft.client.resources.I18n.format("adv.fml.error.sorting.3"), this.width / 2, offset, 0xFFFFFF);
        offset+=5;
        for (ModContainer mc : failedList.getVisitedNodes())
        {
            offset+=10;
            this.drawCenteredString(this.fontRendererObj, net.minecraft.client.resources.I18n.format("adv.fml.error.sorting.4", mc.toString(), mc.getDependants(), mc.getDependencies()), this.width / 2, offset, 0xEEEEEE);
        }
        offset+=20;
        this.drawCenteredString(this.fontRendererObj, net.minecraft.client.resources.I18n.format("adv.fml.error.more"), this.width / 2, offset, 0xFFFFFF);
    }

}
