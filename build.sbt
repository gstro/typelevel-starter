name := "typelevel-starter"

version := "0.1"

scalaVersion := "2.13.1"

lazy val CatsEffectVersion = "2.0.0"
lazy val Fs2Version        = "2.0.1"
lazy val Http4sVersion     = "0.21.0-M5"
lazy val CirceVersion      = "0.12.2"
lazy val DoobieVersion     = "0.8.4"
lazy val FlywayVersion     = "6.0.4"
lazy val RefinedVersion    = "0.9.10"
lazy val PureConfigVersion = "0.12.1"
lazy val LogbackVersion    = "1.2.3"
lazy val ScalaTestVersion  = "3.0.8"
lazy val ScalaCheckVersion = "1.14.1"

libraryDependencies ++= Seq(
  // http
  "org.http4s"            %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s"            %% "http4s-circe"        % Http4sVersion,
  "org.http4s"            %% "http4s-dsl"          % Http4sVersion,

  // effects and streaming
  "org.typelevel"         %% "cats-effect"         % CatsEffectVersion,
  "co.fs2"                %% "fs2-core"            % Fs2Version,

  // json
  "org.http4s"            %% "http4s-circe"        % Http4sVersion,
  "io.circe"              %% "circe-core"          % CirceVersion,
  "io.circe"              %% "circe-generic"       % CirceVersion,

  // database
  "org.flywaydb"          %  "flyway-core"         % FlywayVersion,
  "org.tpolecat"          %% "doobie-core"         % DoobieVersion,
  "org.tpolecat"          %% "doobie-postgres"     % DoobieVersion,
  "org.tpolecat"          %% "doobie-hikari"       % DoobieVersion,

  // config
  "com.github.pureconfig" %% "pureconfig"          % PureConfigVersion,
//  "com.github.pureconfig" %% "pureconfig-http4s"   % PureConfigVersion,
  "eu.timepit"            %% "refined-pureconfig"  % RefinedVersion,

  // logging
  "ch.qos.logback"        %  "logback-classic"     % LogbackVersion,

  // tests
  "org.scalatest"         %% "scalatest"           % ScalaTestVersion  % Test,
  "org.scalacheck"        %% "scalacheck"          % ScalaCheckVersion % Test,
  "org.tpolecat"          %% "doobie-scalatest"    % DoobieVersion     % Test
)

// Recommended Scalac Flags
// https://tpolecat.github.io/2017/04/25/scalac-flags.html
scalacOptions ++= Seq(
  "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
  "-encoding", "utf-8",                // Specify character encoding used by source files.
  "-explaintypes",                     // Explain type errors in more detail.
  "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials",            // Existential types (besides wildcard types) can be written and inferred
  "-language:experimental.macros",     // Allow macro definition (besides implementation and application)
  "-language:higherKinds",             // Allow higher-kinded types
  "-language:implicitConversions",     // Allow definition of implicit functions called views
  "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
  "-Xcheckinit",                       // Wrap field accessors to throw an exception on uninitialized access.
  "-Xfatal-warnings",                  // Fail the compilation if there are any warnings.
  "-Xlint:adapted-args",               // Warn if an argument list is modified to match the receiver.
  "-Xlint:constant",                   // Evaluation of a constant arithmetic expression results in an error.
  "-Xlint:delayedinit-select",         // Selecting member of DelayedInit.
  "-Xlint:doc-detached",               // A Scaladoc comment appears to be detached from its element.
  "-Xlint:inaccessible",               // Warn about inaccessible types in method signatures.
  "-Xlint:infer-any",                  // Warn when a type argument is inferred to be `Any`.
  "-Xlint:missing-interpolator",       // A string literal appears to be missing an interpolator id.
  "-Xlint:nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
  "-Xlint:nullary-unit",               // Warn when nullary methods return Unit.
  "-Xlint:option-implicit",            // Option.apply used implicit view.
  "-Xlint:package-object-classes",     // Class or object defined in package object.
  "-Xlint:poly-implicit-overload",     // Parameterized overloaded implicit methods are not visible as view bounds.
  "-Xlint:private-shadow",             // A private field (or class parameter) shadows a superclass field.
  "-Xlint:stars-align",                // Pattern sequence wildcard must align with sequence component.
  "-Xlint:type-parameter-shadow",      // A local type parameter shadows a type already in scope.
  "-Ywarn-dead-code",                  // Warn when dead code is identified.
  "-Ywarn-extra-implicit",             // Warn when more than one implicit parameter section is defined.
  "-Ywarn-numeric-widen",              // Warn when numerics are widened.
  "-Ywarn-unused:implicits",           // Warn if an implicit parameter is unused.
  "-Ywarn-unused:imports",             // Warn if an import selector is not referenced.
  "-Ywarn-unused:locals",              // Warn if a local definition is unused.
  "-Ywarn-unused:params",              // Warn if a value parameter is unused.
  "-Ywarn-unused:patvars",             // Warn if a variable bound in a pattern is unused.
  "-Ywarn-unused:privates",            // Warn if a private member is unused.
  "-Ywarn-value-discard",              // Warn when non-Unit expression results are unused.

  "-Xmacro-settings:materialize-derivations" // better pureconfig error messages
)

libraryDependencies += "com.github.pureconfig" %% "pureconfig-cats-effect" % "0.12.1"

scalacOptions in (Compile, console) --= Seq("-Ywarn-unused:imports", "-Xfatal-warnings")

//clippyColorsEnabled := true

Compile / run / fork := true

// Use development.conf only for local dev,
// application.conf will be packaged for deployment
Test / run / javaOptions += "-Dconfig.file=development.conf"

enablePlugins(DockerPlugin)