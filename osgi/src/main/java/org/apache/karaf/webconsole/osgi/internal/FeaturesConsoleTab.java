package org.apache.karaf.webconsole.osgi.internal;

import org.apache.karaf.webconsole.core.ConsoleTab;

import java.util.HashMap;
import java.util.Map;

public class FeaturesConsoleTab implements ConsoleTab {

    private static final long serialVersionUID = 1L;

    public String getLabel() {
        return "Features";
    }

    public Class getModuleHomePage() {
        return FeaturesPage.class;
    }

    public Map<String, Class> getItems() {
        Map<String, Class> features = new HashMap<String, Class>();
        features.put("Features List", FeaturesPage.class);
        features.put("Feature repoz", RepositoriesPage.class);
        return features;
    }

}
