package me.jwt007.maven.plugins.banner;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public final class BuildProperties {

  private static final String BUILD_PROPERTIES_FILE_PATH = "mavenBuild.properties";

  private static final Properties PROPERTIES = loadProperties();

  public static String property(String key) {
    return PROPERTIES.getProperty(key);
  }

  public static String projectGroupId() {
    return property("project.groupId");
  }

  public static String projectArtifactId() {
    return property("project.artifactId");
  }

  public static String projectVersion() {
    return property("project.version");
  }

  private static Properties loadProperties() {

    final Properties properties = new Properties();

    try (InputStream inputStream = getBuildPropertiesFileResourceURL().openStream()) {

      properties.load(inputStream);

    } catch (IOException ex) {

      throw new IOError(ex);

    }

    return properties;

  }

  private static URL getBuildPropertiesFileResourceURL() {

    final URL buildPropertiesFileResourceURL =
      BuildProperties.class
        .getClassLoader()
        .getResource(BUILD_PROPERTIES_FILE_PATH);

    if (buildPropertiesFileResourceURL != null) {
      return buildPropertiesFileResourceURL;
    } else {
      throw new IOError(new FileNotFoundException("Build properties file not found: " + BUILD_PROPERTIES_FILE_PATH));
    }

  }

}
