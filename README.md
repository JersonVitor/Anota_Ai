# Anota Aí

![Plataforma](https://img.shields.io/badge/Plataforma-Android%20-blue)
![Linguagem](https://img.shields.io/badge/Linguagem-Kotlin%20-purple)
![Framework](https://img.shields.io/badge/Framework-Jetpack%20Compose%20-orange)
![Licença](https://img.shields.io/badge/Licença-MIT-green)

"Um aplicativo para fazer anotações, como um bloco de notas, projetado para auxiliar com armazenamento de informações textuais e de suporte a edição para facilitar a usabilidade do aplicativo."

## 📱 Funcionalidades

- [x] **Adicionar Notas**: Adicionar novas notas, podendo colocar cores, título e descrição .
- [x] **Editar Notas**: Poder editar notas recém adicionadas.
- [x] **Apagar Notas**: Apagar uma ou um conjunto de notas.
- [x] **Mudar visibilidade**: Alternar a visibilidade entre Grid e Lista.

## 🔧 Tecnologias Utilizadas

- **Linguagem:** Kotlin/Java (para Android)
- **Frameworks/Bibliotecas:** Jetpack Compose, Dagger Hilt, Room, Compose Foundation, Splashscreen

## 🚀 Como Executar o Projeto

### Pré-requisitos

- [ ] Android Studio instalado
- [ ] Emulador ou dispositivo físico configurado
- [ ] [Outras dependências necessárias]

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/usuario/nome-do-repositorio.git
2. Abra o projeto no Android Studio.
3. Instale as dependências (se necessário).
4. Execute o aplicativo no emulador ou dispositivo físico.

## 🗂️ Estrutura do Projeto

```plaintext
📂 nome-do-repositorio/
├── 📁 app/
│   ├── 📁 src/
│   │   ├── 📁 main/
│   │   │   ├── 📁 java/com/jerson/anotaai/
│   │   │   |   ├── 📁 data              # Acesso ao Banco de Dados
│   │   │   |   ├── 📁 domain/           # Intermediário entre data e presentation
│   │   │   |   |   ├── 📁 model         # Modelos de representação do Banco de Dados
│   │   │   |   |   ├── 📁 repository    # Regra de Negócioss
│   │   │   |   |   ├── 📁 use_cases     # Casos de usos   
│   │   │   |   ├── 📁 presentation      # Parte de visualização
│   │   │   |   |   ├── 📁 navGraph      # Modelos de representação do Banco de Dados
│   │   │   |   |   ├── 📁 screens       # Telas com suas respetivas ViewModels, States e Events
│   │   │   |   ├── 📁 di                # Módulos de injeção
│   │   │   ├── 📁 res/            # Arquivos de recursos (layouts, strings, drawables, etc.)
│   │   │   ├── AndroidManifest.xml  # Configurações do aplicativo
├── 📁 build/                      # Arquivos gerados durante a build
├── 📄 build.gradle                # Configurações do Gradle
├── 📄 settings.gradle             # Configuração do projeto Gradle
````
##🤝 Contribuições
Contribuições são sempre bem-vindas! Siga os passos abaixo para contribuir:

Faça um fork do projeto.

1. Crie uma branch para sua feature:
```bash
git checkout -b minha-feature
````
2. Faça commit das suas mudanças:
```bash
git commit -m "Adicionei minha feature"
````
3. Faça push para a branch:
```bash
git push origin minha-feature
````
4. Abra um Pull Request no repositório original.

##📝 Licença
Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para mais informações.

##📬 Contato
Se tiver dúvidas, entre em contato:
- Email: jersonvitor2016@gmail.com
- LinkedIn: www.linkedin.com/in/jerson-vitor-872384185

