package net.minecraftforge.common;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.common.Loader;
import org.apache.commons.lang3.text.WordUtils;

public class TranslationHelper
{
    public static String addDeclension(int number, String[] translate)
    {
        String s = "";
        if (number % 10 == 1) s = translate[0];
        if (number % 10 >= 2 && number % 10 <= 4) s = translate[1];
        if (number % 10 >= 5 || number % 10 == 0 || (number >= 11 && number <= 14)) s = translate[2];
        return s;
    }

    public static String checkTranslation(String fresh, String original)
    {
        return (I18n.format(fresh).equals(fresh)) ? original : I18n.format(fresh);
    }

    public static String translateBrandings(String s)
    {
        if (s.contains("loaded") || s.contains("загружен")) { // very dumb check, but it works :/
            int modCount = Loader.instance().getModList().size();
            int aModCount = Loader.instance().getActiveModList().size();
            String params[] = {
                I18n.format("adv.fml.format.mod.1", modCount, aModCount),
                I18n.format("adv.fml.format.mod.2", modCount, aModCount),
                I18n.format("adv.fml.format.mod.3", modCount, aModCount)
            };
            s = addDeclension(modCount, params);
        } else if (s.contains("Optifine")) s = s.replace("OptiFine_", "").replace("U", "Ultra").replace("_", " ");
        return s;
    }

    public static String translateBiome(String biomeName)
    {
        String biomeTrimmed = WordUtils.uncapitalize(biomeName.replaceAll("\\s", ""));
        return checkTranslation("adv.biome." + biomeTrimmed, biomeName);
    }
}
