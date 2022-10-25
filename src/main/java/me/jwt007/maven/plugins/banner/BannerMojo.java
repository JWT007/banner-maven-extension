package me.jwt007.maven.plugins.banner;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

@Mojo(name = BannerMojo.GOAL,
      defaultPhase = LifecyclePhase.INITIALIZE,
      requiresDependencyCollection = ResolutionScope.RUNTIME,
      threadSafe = true)
public class BannerMojo extends AbstractMojo {

  public static final String GOAL = "banner";

  @Parameter(defaultValue = "${project}", readonly = true, required = true)
  private MavenProject project;

  public synchronized void execute() {

    System.out.println("Executing BannerMojo:: "
                       + BuildProperties.projectGroupId()
                       + ":"
                       + BuildProperties.projectArtifactId()
                       + ":"
                       + BuildProperties.projectVersion()
                       + ":"
                       + GOAL);

  }

}
