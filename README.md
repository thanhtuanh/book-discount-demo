# 📘 Book Discount Demo

Ein einfaches Java-Projekt zur Demonstration von **Test-Driven Development (TDD)** und **Continuous Integration (CI)** mit Jenkins.

---

## ✅ Features

- Java 17 + Maven
- Testgetriebene Entwicklung mit JUnit 5
- Bereit für Continuous Integration mit Jenkins (Jenkinsfile enthalten)
- Simuliert eine Rabattfunktion für Bücher

---

## 🔧 Technologien

| Bereich         | Technologie     |
|----------------|-----------------|
| Sprache         | Java 17         |
| Build Tool      | Maven           |
| Testing         | JUnit 5         |
| CI              | Jenkins         |

---

## 🚀 Projektstruktur

```
book-discount-demo/
├── Jenkinsfile                 # CI-Pipeline für Jenkins
├── pom.xml                    # Maven-Konfiguration
└── src/
    ├── main/java/com/example/demo/Book.java
    └── test/java/com/example/demo/BookTest.java
```

---

## 🧪 Test Driven Development (TDD)

Der Test `BookTest.java` wird **zuerst geschrieben** und testet die Rabattberechnung:

```java
@Test
void shouldApplyDiscountCorrectly() {
    Book book = new Book("Java TDD", 100.0);
    double result = book.applyDiscount(10);
    assertEquals(90.0, result);
}
```

Dann wird die Methode in `Book.java` implementiert:

```java
public double applyDiscount(double percent) {
    return price - (price * percent / 100);
}
```

---

## 🔄 Continuous Integration (CI) mit Jenkins

Der Build wird bei jedem Git-Push automatisch mit Jenkins ausgeführt:

```groovy
pipeline {
    agent any
    tools {
        jdk 'jdk-17'
        maven 'maven-3.9'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Archive Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
```

---

## ▶️ Projekt lokal starten

```bash
# Tests ausführen
mvn test
```

---

## 📦 CI einrichten in Jenkins

1. Repository in GitHub anlegen
2. Neues Pipeline-Projekt in Jenkins anlegen
3. Git-Repo und Branch verknüpfen
4. Jenkinsfile verwenden (automatisch erkannt)

---

## 👨‍💻 Autor

**Duc Thanh Nguyen**  
Senior Fullstack Java Entwickler  
🔗 [GitHub: thanhtuanh](https://github.com/thanhtuanh)

---

## 📝 Lizenz

Dieses Projekt ist frei verwendbar zu Lern- und Demonstrationszwecken.
