package me.alb_i986.settings.core.retrievers;

import java.util.Arrays;
import java.util.List;

/**
 * @author ascotto
 */
public class HierarchicalSettingRetriever implements SettingRetriever {

    private final List<SettingRetriever> retrievers;

    /**
     * The first retriever is gonna override all of the next ones.
     *
     * @param retrievers the list of retrievers needs to be sorted ascending by
     */
    public HierarchicalSettingRetriever(SettingRetriever... retrievers) {
        this.retrievers = Arrays.asList(retrievers);
    }

    @Override
    public String retrieve(String key) {
        for (SettingRetriever retriever : retrievers) {
            String value = retriever.retrieve(key);
            if (value != null) {
                return value;
            }
        }
        return null;
    }
}
