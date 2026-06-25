# Arvore Binaria de Busca

Projeto Java que implementa uma Arvore Binaria de Busca (BST) com interface interativa via console.
Desenvolvido com arquitetura em camadas: Model, DAO, BO e Menu.

---

## Estrutura do Projeto

```
src/
|-- model/
|   `-- Node.java
|-- dao/
|   `-- ArvoreBinariaDAO.java
|-- bo/
|   `-- ArvoreBinariaBO.java
`-- menu/
    |-- Main.java
    |-- Menu.java
    `-- Visualizador.java
```

## Camadas

### model
Contem a classe de dados que representa um no da arvore.

- **Node.java** — Armazena o valor inteiro e as referencias para os nos esquerdo e direito.

### dao (Data Access Object)
Camada responsavel pelas operacoes diretas na estrutura da arvore. Nao exibe mensagens ao usuario.

- **ArvoreBinariaDAO.java**
  - `adicionarNo(int valor)` — Insere um novo no na posicao correta
  - `deletarNo(int valor)` — Remove um no tratando os 3 casos (folha, 1 filho, 2 filhos)
  - `localizarNo(int valor)` — Retorna o no com o valor informado
  - `localizarNoPai(int valor)` — Retorna o no pai do valor informado
  - `contemNo(int valor)` — Verifica se o valor existe na arvore

### bo (Business Object)
Camada de regras de negocio. Faz validacoes antes de chamar o DAO e calcula metricas da arvore.

- **ArvoreBinariaBO.java**
  - `adicionarValor(int valor)` — Valida duplicidade e delega ao DAO
  - `deletarValor(int valor)` — Valida existencia e delega ao DAO
  - `pesquisarValor(int valor)` — Busca um valor e informa o resultado
  - `valorExiste(int valor)` — Retorno booleano de existencia
  - `obterAltura()` — Calcula a altura da arvore
  - `obterQuantidadeDeNos()` — Conta todos os nos
  - `obterQuantidadeDeFolhas()` — Conta apenas os nos folha

### menu
Camada de interface com o usuario. Controla a navegacao, exibicao e entrada de dados.

- **Main.java** — Ponto de entrada. Inicializa os objetos DAO, BO, Visualizador e Menu.
- **Menu.java** — Menu principal e submenus de visualizacao e percursos.
- **Visualizador.java** — Desenho da arvore no console, percursos (em ordem, pre-ordem, pos-ordem) e relatorio completo.

---

## Funcionalidades

| Opcao | Descricao |
|-------|-----------|
| 1 | Inserir um valor na arvore |
| 2 | Excluir um valor da arvore |
| 3 | Buscar se um valor existe |
| 4 | Visualizar a estrutura da arvore ou por niveis |
| 5 | Executar percursos (em ordem, pre-ordem, pos-ordem) |
| 6 | Gerar relatorio completo com estrutura, percursos e metricas |
| 0 | Encerrar o programa |

---

## Como Executar

### Pelo NetBeans
1. Abrir o NetBeans
2. **File > Open Project** e selecionar a pasta `TrabalhoJJ`
3. Pressionar **F6** para executar

### Pela Linha de Comando
```bash
javac -encoding UTF-8 -d build/classes src/model/*.java src/dao/*.java src/bo/*.java src/menu/*.java
java -cp build/classes menu.Main
```

---

## Exemplo de Uso

```
  +----------------------------------------------+
  |       ARVORE BINARIA DE BUSCA - v3.0         |
  +----------------------------------------------+

  Digite o valor da raiz: 50
  [OK] Arvore criada com raiz 50

  +----------------------------------------------+
  |              MENU PRINCIPAL                  |
  +----------------------------------------------+
  |                                              |
  |   [1] Inserir Valor                          |
  |   [2] Excluir Valor                          |
  |   [3] Buscar Valor                           |
  |   [4] Visualizar Arvore                      |
  |   [5] Percursos                              |
  |   [6] Metricas e Relatorio                   |
  |   [0] Encerrar                               |
  |                                              |
  +----------------------------------------------+
  >> Escolha:
```

---

## Tecnologias

- Java 17
- Apache NetBeans (IDE)
- Projeto Ant (build.xml)
