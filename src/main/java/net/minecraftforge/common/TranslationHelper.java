package net.minecraftforge.common;

import net.minecraft.client.resources.I18n;
import cpw.mods.fml.common.Loader;
import org.apache.commons.lang3.text.WordUtils;

public class TranslationHelper
{
    public static String addDeclension(int number, String translateString, Object... params)
    {
        String s = "";

        if (number % 10 == 1) s = I18n.format(translateString + ".1", params);
        if (number % 10 >= 2 && number % 10 <= 4) s = I18n.format(translateString + ".2", params);
        if (number % 10 >= 5 || number % 10 == 0 || (number >= 11 && number <= 14)) s = I18n.format(translateString + ".3", params);

        return s;
    }

    public static String checkTranslation(String fresh, String original)
    {
        return (I18n.format(fresh).equals(fresh)) ? original : I18n.format(fresh);
    }

    public static String translateBrandings(String s)
    {
        if (s.contains("loaded") || s.contains("загружен")) // very dumb check, but it works :/
            s = addDeclension(Loader.instance().getModList().size(), "adv.fml.format.mod", Loader.instance().getModList().size(), Loader.instance().getActiveModList().size());

        if (s.contains("Optifine"))
            s = s.replace("OptiFine_", "").replace("U", "Ultra").replace("_", " ");

        return s;
    }

    public static String translateBiome(String biomeName)
    {
        String biomeTrimmed = WordUtils.uncapitalize(biomeName.replaceAll("\\s", ""));
        return checkTranslation("adv.biome." + biomeTrimmed, biomeName);
    }
}
