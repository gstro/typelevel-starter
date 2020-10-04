addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.13")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.7.5")
addSbtPlugin("com.typesafe.sbt" % "sbt-license-report" % "1.2.0")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.5.1")
addSbtPlugin("net.vonbuchholtz" % "sbt-dependency-check" % "1.3.3")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")

addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.4.10")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.21")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")

addSbtPlugin("org.duhemm" % "sbt-errors-summary" % "0.6.3")
addCompilerPlugin("io.tryp" % "splain" % "0.5.7" cross CrossVersion.patch)
addSbtCoursier