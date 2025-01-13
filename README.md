📖 Projektbeschreibung
Dieses Projekt demonstriert die Erstellung und Ausführung eines kleinen Regressionstests für die Webseite Swag Labs. Es wurde mithilfe von Java, Selenium, Cucumber und Maven entwickelt und bietet eine Einführung in die Automatisierung von Webtests.

🚀 Features
Automatisierte UI-Tests für die Webseite Swag Labs.
Verwendung von Cucumber für BDD (Behavior Driven Development).
Testszenarien basieren auf Gherkin-Syntax.
Integration mit Selenium WebDriver für Browser-Interaktionen.
Build-Management und Abhängigkeitsverwaltung mit Maven.

🛠️ Voraussetzungen
Um dieses Projekt lokal auszuführen, benötigst du:
Java 11 oder höher
Maven 3.6 oder höher
Eine IDE wie IntelliJ IDEA oder Eclipse
Ein Webbrowser (z. B. Chrome)
ChromeDriver (für Chrome-Tests)

📂 Projektstruktur
cucumber-Swag-Labs/  
├── src/main/java          # Hauptquellcode  
├── src/test/java          # Testfälle und Step-Definitionen  
├── src/test/resources     # Gherkin-Feature-Dateien  
├── pom.xml                # Maven-Konfigurationsdatei  
└── README.md              # Projektbeschreibung  

Installation und Ausführung
1. Repository klonen:

bash
git clone https://github.com/Maria-Fadel/cucumber-Swag-Labs.git
cd cucumber-Swag-Labs  

2. Abhängigkeiten installieren:
mvn clean install  

3. Tests ausführen:
mvn clean test  
