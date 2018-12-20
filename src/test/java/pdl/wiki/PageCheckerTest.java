package pdl.wiki;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * Classe de test pour la classe PageChecker
 */
public class PageCheckerTest
{

    /**
     * V�rifie si la page test�e existe
     */
    @Test
    public void existingPagesTest_withHttps()
    {
        Map<String, Integer> urlMap = new HashMap<>();
        urlMap.put("https://fr.wikipedia.org/wiki/Jeux_olympiques_d'été", 2);
        urlMap.put("https://fr.wikipedia.org/wiki/Wikipédia:Accueil_principal", 0);
        urlMap.put("https://fr.wikipedia.org/wiki/Jeux_olympiques", 0);
        urlMap.put("https://fr.wikipedia.org/wiki/Jeux_olympiques_d'hiver", 4);
        urlMap.put("https://fr.wikipedia.org/wiki/Jean_Capdouze", 1);
        for (Map.Entry set : urlMap.entrySet())
        {
            assertEquals((int) set.getValue(), PageChecker.urlCheck(set.getKey().toString()).size());
        }
    }

    /**
     * V�rifie si une page test�e sans http peut �tre test�e
     * (la fonction ajoute elle m�me le http manquant)
     */
    @Test
    public void existingPagesTest_WithoutHttps()
    {
        Map<String, Integer> urlMap = new HashMap<>();
        urlMap.put("http://fr.wikipedia.org/wiki/Jeux_olympiques_d'été", 2);
        urlMap.put("fr.wikipedia.org/wiki/Jeux_olympiques_d'été", 2);
        urlMap.put("http://fr.wikipedia.org/wiki/Wikipédia:Accueil_principal", 0);
        urlMap.put("fr.wikipedia.org/wiki/Wikipédia:Accueil_principal", 0);
        urlMap.put("http://fr.wikipedia.org/wiki/Jeux_olympiques", 0);
        urlMap.put("fr.wikipedia.org/wiki/Jeux_olympiques", 0);
        urlMap.put("http://fr.wikipedia.org/wiki/Jeux_olympiques_d'hiver", 4);
        urlMap.put("fr.wikipedia.org/wiki/Jeux_olympiques_d'hiver", 4);
        urlMap.put("http://fr.wikipedia.org/wiki/Jean_Capdouze", 1);
        urlMap.put("fr.wikipedia.org/wiki/Jean_Capdouze", 1);
        for (Map.Entry set : urlMap.entrySet())
        {
            assertEquals((int) set.getValue(), PageChecker.urlCheck(set.getKey().toString()).size());
        }
    }

    /**
     * V�rifie si la page est valide ou non
     */
    @Test
    public void pageNotValid()
    {
        List<String> urlToTest = new ArrayList<>();
        urlToTest.add("https://forum.xda-developers.com/");
        urlToTest.add("https://fr.wikipedia.com/");
        urlToTest.add("https://github.com/vad101010/PDLProject");
        urlToTest.add("https://www.google.fr/");
        for (String url : urlToTest)
        {
            assertNull(PageChecker.urlCheck(url));
        }
    }

}