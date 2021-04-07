# scala-native-cli-example

Build OS native CLI application with scala and GraalVM.

## Build & Run

1. sdk install java 21.0.0.r11-grl
2. sdk use java 21.0.0.r11-grl
3. mvn -DbuildArgs=--no-server clean verify
4. ./target/scala-native-cli-example -h
5. ./target/scala-native-cli-example -a=MD5 target/scala-native-cli-example

The produced executable application only be 8.9MB on Mac.
