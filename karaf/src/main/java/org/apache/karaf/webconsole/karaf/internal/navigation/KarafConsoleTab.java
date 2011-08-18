package org.apache.karaf.webconsole.karaf.internal.navigation;

import org.apache.karaf.webconsole.core.navigation.ConsoleTab;
import org.apache.karaf.webconsole.karaf.internal.feature.FeaturesPage;
import org.apache.karaf.webconsole.karaf.internal.repository.RepositoriesPage;
import org.apache.wicket.Page;

import java.util.HashMap;
import java.util.Map;

public class KarafConsoleTab implements ConsoleTab {

    public String getLabel() {
        return "karaf";
    }

    public Class<? extends Page> getModuleHomePage() {
        return FeaturesPage.class;
    }

    public Map<String, Class<? extends Page>> getItems() {
        Map<String, Class<? extends Page>> features = new HashMap<String, Class<? extends Page>>();
        features.put("Repositories list", RepositoriesPage.class);
        features.put("Features list", FeaturesPage.class);
        return features;
    }

}