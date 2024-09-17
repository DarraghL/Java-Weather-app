# Java Weather App

This is a JavaFX application that displays weather information for various locations in Ireland.

## Prerequisites

Before you begin, ensure you have met the following requirements:

* You have installed Java Development Kit (JDK) 21 or later.
* You have installed Apache Maven 3.6.0 or later.

## Installing Java Weather App

To install the Java Weather App, follow these steps:

1. Clone the repository:
   git clone https://github.com/DarraghL/Java-Weather-app.git

2. Navigate to the project directory:
   cd Java-Weather-app

## Running Java Weather App

To run the Java Weather App, follow these steps:

1. Ensure you have the JavaFX SDK installed. You can download it from [OpenJFX](https://openjfx.io/).

2. Set the PATH_TO_FX environment variable to point to your JavaFX SDK lib directory:
   Replace `/path/to/javafx-sdk-21` with the actual path to your JavaFX SDK.

3. Compile and run the project:
   mvn clean javafx:run
   
If you encounter the "JavaFX runtime components are missing" error, use this command instead:
java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml -jar target/JavaFXShell-1.0-SNAPSHOT.jar
   
  
   
