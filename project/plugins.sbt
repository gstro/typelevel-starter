addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.8")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.4.1")
addSbtPlugin("com.typesafe.sbt" % "sbt-license-report" % "1.2.0")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.4.3")
addSbtPlugin("net.vonbuchholtz" % "sbt-dependency-check" % "1.3.3")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")

addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.4.3")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.7")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.0.4")

addSbtPlugin("org.duhemm" % "sbt-errors-summary" % "0.6.3")
addCompilerPlugin("io.tryp" % "splain" % "0.4.1" cross CrossVersion.patch)
addSbtCoursier