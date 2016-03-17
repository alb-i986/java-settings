package me.alb_i986.settings.core.retrievers;

/**
 * A
 * <ol>
 *     <li>{@link EnvSettingRetriever}</li>
 *     <li>{@link SystemPropertySettingRetriever}</li>
 *     <li>{@link FileSettingRetriever}</li>
 * </ol>
 *
 * @author ascotto
 */
public class DefaultHierarchicalSettingRetriever extends HierarchicalSettingRetriever {

    public DefaultHierarchicalSettingRetriever() {
        super(new FileSettingRetriever(),
                new SystemPropertySettingRetriever(),
                new EnvSettingRetriever());
    }
}
