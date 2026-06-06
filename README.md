# fullstack-cop-java-agent

## Pré-requis

- **JDK 25** — utiliser [Scoop](https://github.com/ScoopInstaller/scoop) sur Windows ou [SDKMAN](https://sdkman.io/) sur macOS/Linux/WSL
- **Maven 3.9.x** — déjà inclus via le wrapper `mvnw` ; sinon utiliser le même gestionnaire que pour le JDK
- **Ollama** — [https://ollama.com/](https://ollama.com/)

### Vérifier Java

```bash
java -version
```

### Vérifier Ollama

```
ollama ls
```

Exemple de sortie :

```
NAME    ID    SIZE    MODIFIED
...
```

## Lancement

```bash
./mvnw quarkus:dev
```
