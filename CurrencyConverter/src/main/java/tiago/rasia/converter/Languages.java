package tiago.rasia.converter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rasia
 */
public class Languages {
    
        /*
        private static Map<String, String> languageMap = new HashMap<>();
        // Add English
        languageMap.put("enUS", "English");
        // Add Brazilian Portuguese
        languageMap.put("ptBR", "Português do Brasil");
        // Add Spanish
        languageMap.put("esES", "Español");
        */

    public static Map<String,String> getLanguage(String language) {
        
        if (language.compareToIgnoreCase("ptBR") == 0) 
            return getPtBr();
        else if (language.compareToIgnoreCase("esES") == 0)
            return getEsES();
        
        // Ingles como idioma default
        return getEnUS(); 
    }        
    
    
    private static Map<String,String> getEnUS() {
        
        Map<String,String> LanguageMap = new HashMap<>();
        
        LanguageMap.put("jLabelTop", "Converter");
        LanguageMap.put("jPanelCurrency", "Currency");
        LanguageMap.put("jPanelRomanNumber", "Roman Number");
        LanguageMap.put("jPanelTime", "Time");
        
        LanguageMap.put("jLabelFrom", "From:");
        LanguageMap.put("jLabelTo", "To:");
        
        LanguageMap.put("jLabelDecimalNumber", "Decimal Number");
        LanguageMap.put("jLabelRomanNumber", "Roman Number");
        
        LanguageMap.put("BRL", "BRL - Brazilian Real");
        LanguageMap.put("USD", "USD - US Dollar");
        LanguageMap.put("EUR", "EUR - Euro");
        LanguageMap.put("GBP", "GBP - Pound Sterling");
        LanguageMap.put("ARS", "ARS - Argentine Peso");
        LanguageMap.put("CLP", "CLP - Chilean Peso");
        
        LanguageMap.put("", "");
        
        
        return LanguageMap;
    }    
    
    // todos idiomas recebem o conjunto default (enUS) e susbistitem o conteudo pelo idioma desejado
    //garantindo que se alguma tradução estiver faltando o texto não vai deixar de ser exibido 
    private static Map<String,String> getPtBr() {
        
        Map<String,String> LanguageMap = getEnUS();
        
        LanguageMap.put("jLabelTop", "Conversor");
        LanguageMap.put("jPanelCurrency", "Moeda");
        LanguageMap.put("jPanelRomanNumber", "Número Romano");
        LanguageMap.put("jPanelTime", "Horário");
        
        LanguageMap.put("jLabelFrom", "De:");
        LanguageMap.put("jLabelTo", "Para:");
        
        LanguageMap.put("jLabelDecimalNumber", "Número Decimal");
        LanguageMap.put("jLabelRomanNumber", "Número Romano");
        
        LanguageMap.put("BRL", "BRL - Real Brasileiro");
        LanguageMap.put("USD", "USD - Dólar Americano");
        LanguageMap.put("EUR", "EUR - Euro");
        LanguageMap.put("GBP", "GBP - Libras Esterlinas");
        LanguageMap.put("ARS", "ARS - Peso Argentino");
        LanguageMap.put("CLP", "CLP - Peso Chileno");
        
        return LanguageMap;
    }      
    
    // todos idiomas recebem o conjunto default (enUS) e susbistitem o conteudo pelo idioma desejado
    //garantindo que se alguma tradução estiver faltando o texto não vai deixar de ser exibido 
    private static Map<String,String> getEsES() {
        Map<String,String> LanguageMap = getEnUS();
        
        LanguageMap.put("jLabelTop", "Convertidor");
        LanguageMap.put("jPanelCurrency", "Divisa");
        LanguageMap.put("jPanelRomanNumber", "Número Romano");
        LanguageMap.put("jPanelTime", "Time");
        
        LanguageMap.put("jLabelFrom", "De:");
        LanguageMap.put("jLabelTo", "Para:");
        
        LanguageMap.put("jLabelDecimalNumber", "Número Decimal");
        LanguageMap.put("jLabelRomanNumber", "Número Romano");
        
        LanguageMap.put("BRL", "BRL - Real Brasileño");
        LanguageMap.put("USD", "USD - Dólar Americano");
        LanguageMap.put("EUR", "EUR - Euro");
        LanguageMap.put("GBP", "GBP - Libras Esterlinas");
        LanguageMap.put("ARS", "ARS - Peso Argentino");
        LanguageMap.put("CLP", "CLP - Peso Chileno");
        
        return LanguageMap;
    }  
    
}
