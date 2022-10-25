package me.jwt007.maven.plugins.banner;

import java.io.IOException;

import com.soebes.itf.jupiter.extension.MavenGoal;
import com.soebes.itf.jupiter.extension.MavenJupiterExtension;
import com.soebes.itf.jupiter.extension.MavenProject;
import com.soebes.itf.jupiter.extension.MavenTest;
import com.soebes.itf.jupiter.maven.MavenExecutionResult;

@MavenJupiterExtension
@MavenProject
public class BannerMojoTestIT {

  @MavenTest
  public void banner(MavenExecutionResult result) throws IOException {

    System.out.println("Running banner test.");

  }

}