name := "embeddedpostgres-postgres-background-threads"
scalaVersion := "2.13.6"
libraryDependencies ++= Seq(
  "io.zonky.test"     % "embedded-postgres" % "1.2.10",
  "com.mattbertolini" % "liquibase-slf4j"   % "4.0.0",
  "org.liquibase"     % "liquibase-core"    % "4.2.2",
  "org.slf4j"         % "slf4j-api"         % "1.7.31",
  "ch.qos.logback"    % "logback-core"      % "1.2.3",
  "ch.qos.logback"    % "logback-classic"   % "1.2.3",
  "junit"             % "junit"             % "4.12",
  "com.novocode"      % "junit-interface"   % "0.11",
).map(_ % Test)