package com.areport.Config;

import java.util.HashMap;
import java.util.Map;

import com.areport.PublicPath;
import com.areport.StoragePath;

public class Config {

    public static String monetaryItem = "EUR";

    public static Map<String, String> lang = new HashMap<>();
    static {
        lang.put("0", "en");
        lang.put("1", "bs-Latn-BA");
        lang.put("2", "ba");
    }

    public static Map<String, String> confSet = new HashMap<>();
    static {
        confSet.put("lab-codes", "lab-codes");
        confSet.put("rend", "rend");
        confSet.put("def", "def");
        confSet.put("pre", "pre");
        confSet.put("tab", "tab");
    }

    public static Map<String, String> moduleSet = new HashMap<>();
    static {
        moduleSet.put("pre", "pre");
        moduleSet.put("rend", "rend");
        moduleSet.put("lab-codes", "lab-codes");
    }

    public static Map<String, String> createInstance = new HashMap<>();
    static {
        createInstance.put("rend", "rend");
        createInstance.put("def", "def");
    }

    public static String owner = "www.eba.europa.eu";

    public static String publicDir() {
        return StoragePath.appPublicTaxDir();
    }

    public static String prefixOwner = "fba";

    public static String setLogoPath() {
        return PublicPath.imagesLogoPath();
    }

    public static Map<String, Map<String, String>> owners() {
        Map<String, Map<String, String>> owners = new HashMap<>();
        owners.put("fba", new HashMap<>());
        owners.get("fba").put("namespace", "http://www.fba.ba");
        owners.get("fba").put("officialLocation", "http://www.fba.ba/xbrl");
        owners.get("fba").put("prefix", "fba");
        owners.get("fba").put("copyright", "(C) FBA");

        owners.put("eba", new HashMap<>());
        owners.get("eba").put("namespace", "http://www.eba.europa.eu/xbrl/crr");
        owners.get("eba").put("officialLocation", "http://www.eba.europa.eu/eu/fr/xbrl/crr");
        owners.get("eba").put("prefix", "eba");
        owners.get("eba").put("copyright", "(C) EBA");

        owners.put("audt", new HashMap<>());
        owners.get("audt").put("namespace", "http://www.auditchain.finance/");
        owners.get("audt").put("officialLocation", "http://www.auditchain.finance/fr/dpm");
        owners.get("audt").put("prefix", "audt");
        owners.get("audt").put("copyright", "(C) Auditchain");

        return owners;
    }

    public static String tmpPdfDir() {
        return StoragePath.logsDir();
    }
}