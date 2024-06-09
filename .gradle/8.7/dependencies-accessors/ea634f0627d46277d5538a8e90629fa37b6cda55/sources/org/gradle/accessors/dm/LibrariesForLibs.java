package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final DeLibraryAccessors laccForDeLibraryAccessors = new DeLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>folialib</b> with <b>com.tcoded:FoliaLib</b> coordinates and
     * with version reference <b>folialib</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getFolialib() {
        return create("folialib");
    }

    /**
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>de</b>
     */
    public DeLibraryAccessors getDe() {
        return laccForDeLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComMojangLibraryAccessors laccForComMojangLibraryAccessors = new ComMojangLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.mojang</b>
         */
        public ComMojangLibraryAccessors getMojang() {
            return laccForComMojangLibraryAccessors;
        }

    }

    public static class ComMojangLibraryAccessors extends SubDependencyFactory {

        public ComMojangLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>authlib</b> with <b>com.mojang:authlib</b> coordinates and
         * with version reference <b>com.mojang.authlib</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAuthlib() {
            return create("com.mojang.authlib");
        }

    }

    public static class DeLibraryAccessors extends SubDependencyFactory {
        private final DeTr7zwLibraryAccessors laccForDeTr7zwLibraryAccessors = new DeTr7zwLibraryAccessors(owner);

        public DeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>de.tr7zw</b>
         */
        public DeTr7zwLibraryAccessors getTr7zw() {
            return laccForDeTr7zwLibraryAccessors;
        }

    }

    public static class DeTr7zwLibraryAccessors extends SubDependencyFactory {
        private final DeTr7zwItemLibraryAccessors laccForDeTr7zwItemLibraryAccessors = new DeTr7zwItemLibraryAccessors(owner);

        public DeTr7zwLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>de.tr7zw.item</b>
         */
        public DeTr7zwItemLibraryAccessors getItem() {
            return laccForDeTr7zwItemLibraryAccessors;
        }

    }

    public static class DeTr7zwItemLibraryAccessors extends SubDependencyFactory {
        private final DeTr7zwItemNbtLibraryAccessors laccForDeTr7zwItemNbtLibraryAccessors = new DeTr7zwItemNbtLibraryAccessors(owner);

        public DeTr7zwItemLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>de.tr7zw.item.nbt</b>
         */
        public DeTr7zwItemNbtLibraryAccessors getNbt() {
            return laccForDeTr7zwItemNbtLibraryAccessors;
        }

    }

    public static class DeTr7zwItemNbtLibraryAccessors extends SubDependencyFactory {

        public DeTr7zwItemNbtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>de.tr7zw:item-nbt-api</b> coordinates and
         * with version reference <b>de.tr7zw.item.nbt.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("de.tr7zw.item.nbt.api");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgSpigotmcLibraryAccessors laccForOrgSpigotmcLibraryAccessors = new OrgSpigotmcLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.spigotmc</b>
         */
        public OrgSpigotmcLibraryAccessors getSpigotmc() {
            return laccForOrgSpigotmcLibraryAccessors;
        }

    }

    public static class OrgSpigotmcLibraryAccessors extends SubDependencyFactory {
        private final OrgSpigotmcSpigotLibraryAccessors laccForOrgSpigotmcSpigotLibraryAccessors = new OrgSpigotmcSpigotLibraryAccessors(owner);

        public OrgSpigotmcLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.spigotmc.spigot</b>
         */
        public OrgSpigotmcSpigotLibraryAccessors getSpigot() {
            return laccForOrgSpigotmcSpigotLibraryAccessors;
        }

    }

    public static class OrgSpigotmcSpigotLibraryAccessors extends SubDependencyFactory {

        public OrgSpigotmcSpigotLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.spigotmc:spigot-api</b> coordinates and
         * with version reference <b>org.spigotmc.spigot.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("org.spigotmc.spigot.api");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final DeVersionAccessors vaccForDeVersionAccessors = new DeVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>folialib</b> with value <b>0.3.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getFolialib() { return getVersion("folialib"); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.de</b>
         */
        public DeVersionAccessors getDe() {
            return vaccForDeVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComMojangVersionAccessors vaccForComMojangVersionAccessors = new ComMojangVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.mojang</b>
         */
        public ComMojangVersionAccessors getMojang() {
            return vaccForComMojangVersionAccessors;
        }

    }

    public static class ComMojangVersionAccessors extends VersionFactory  {

        public ComMojangVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.mojang.authlib</b> with value <b>1.5.21</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAuthlib() { return getVersion("com.mojang.authlib"); }

    }

    public static class DeVersionAccessors extends VersionFactory  {

        private final DeTr7zwVersionAccessors vaccForDeTr7zwVersionAccessors = new DeTr7zwVersionAccessors(providers, config);
        public DeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.de.tr7zw</b>
         */
        public DeTr7zwVersionAccessors getTr7zw() {
            return vaccForDeTr7zwVersionAccessors;
        }

    }

    public static class DeTr7zwVersionAccessors extends VersionFactory  {

        private final DeTr7zwItemVersionAccessors vaccForDeTr7zwItemVersionAccessors = new DeTr7zwItemVersionAccessors(providers, config);
        public DeTr7zwVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.de.tr7zw.item</b>
         */
        public DeTr7zwItemVersionAccessors getItem() {
            return vaccForDeTr7zwItemVersionAccessors;
        }

    }

    public static class DeTr7zwItemVersionAccessors extends VersionFactory  {

        private final DeTr7zwItemNbtVersionAccessors vaccForDeTr7zwItemNbtVersionAccessors = new DeTr7zwItemNbtVersionAccessors(providers, config);
        public DeTr7zwItemVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.de.tr7zw.item.nbt</b>
         */
        public DeTr7zwItemNbtVersionAccessors getNbt() {
            return vaccForDeTr7zwItemNbtVersionAccessors;
        }

    }

    public static class DeTr7zwItemNbtVersionAccessors extends VersionFactory  {

        public DeTr7zwItemNbtVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>de.tr7zw.item.nbt.api</b> with value <b>2.12.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("de.tr7zw.item.nbt.api"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgSpigotmcVersionAccessors vaccForOrgSpigotmcVersionAccessors = new OrgSpigotmcVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.spigotmc</b>
         */
        public OrgSpigotmcVersionAccessors getSpigotmc() {
            return vaccForOrgSpigotmcVersionAccessors;
        }

    }

    public static class OrgSpigotmcVersionAccessors extends VersionFactory  {

        private final OrgSpigotmcSpigotVersionAccessors vaccForOrgSpigotmcSpigotVersionAccessors = new OrgSpigotmcSpigotVersionAccessors(providers, config);
        public OrgSpigotmcVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.spigotmc.spigot</b>
         */
        public OrgSpigotmcSpigotVersionAccessors getSpigot() {
            return vaccForOrgSpigotmcSpigotVersionAccessors;
        }

    }

    public static class OrgSpigotmcSpigotVersionAccessors extends VersionFactory  {

        public OrgSpigotmcSpigotVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.spigotmc.spigot.api</b> with value <b>1.19.4-R0.1-SNAPSHOT</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("org.spigotmc.spigot.api"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
