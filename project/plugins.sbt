addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.15")
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.4")
//addSbtPlugin("com.softwaremill.clippy" % "plugin-sbt" % "0.5.3")
addSbtPlugin("org.duhemm" % "sbt-errors-summary" % "0.6.3")
addSbtPlugin("net.vonbuchholtz" % "sbt-dependency-check" % "0.2.10")
addSbtPlugin("com.typesafe.sbt" % "sbt-license-report" % "1.2.0")

addCompilerPlugin("io.tryp" % "splain" % "0.3.5" cross CrossVersion.patch)
addSbtCoursier