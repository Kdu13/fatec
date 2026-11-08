# Cadastro de Produtos com Spring Boot e Thymeleaf

## Descrição e objetivos

Aplicação web simples para cadastrar, consultar, filtrar e remover produtos. O projeto acompanha a atividade 08 - Thymeleaf e demonstra o fluxo MVC de um formulário HTML até o processamento no servidor e a exibição dos dados em uma página dinâmica.

Os dados ficam em uma lista Java na memória. Não há banco de dados; os cadastros são apagados quando a aplicação é reiniciada.

## Tecnologias usadas

- Java 21
- Spring Boot 4.1.2
- Spring Web MVC
- Thymeleaf
- Maven e Maven Wrapper
- Bootstrap 4.6.2

## Estrutura de pastas

```text
cadastro-produtos/
├── pom.xml
├── mvnw
├── README.md
└── src/
    ├── main/
    │   ├── java/br/edu/fatec/cadastroprodutos/
    │   │   ├── CadastroProdutosApplication.java
    │   │   ├── controller/ProdutoController.java
    │   │   ├── model/Produto.java
    │   │   └── service/ProdutoService.java
    │   └── resources/
    │       ├── application.properties
    │       └── templates/
    │           ├── cadastrar.html
    │           └── lista.html
    └── test/
        └── java/br/edu/fatec/cadastroprodutos/
            └── CadastroProdutosApplicationTests.java
```

## Como executar

É necessário ter o JDK 21. Na pasta raiz do projeto, execute:

```bash
./mvnw spring-boot:run
```

Também é possível abrir o projeto em uma IDE, localizar `CadastroProdutosApplication.java` e executar essa classe como uma aplicação Java/Spring Boot.

Com o servidor iniciado, acesse [http://localhost:8080](http://localhost:8080). O Bootstrap é carregado pela CDN, portanto os estilos externos dependem de conexão com a internet.

## Funcionamento e rotas

| Método e rota | Funcionamento |
| --- | --- |
| `GET /` | Redireciona para `/cadastrar`. |
| `GET /cadastrar` | Exibe o formulário vazio de cadastro. |
| `POST /cadastrar` | Recebe os dados do produto; se o preço for negativo, mostra um erro no formulário. Caso contrário, salva pelo Service e redireciona para `/lista`. |
| `GET /lista` | Exibe a lista de produtos. Aceita o parâmetro opcional `busca` para filtrar por nome ou categoria, sem diferenciar maiúsculas de minúsculas. |
| `POST /remover/{id}` | Remove o produto identificado pelo ID e redireciona para `/lista`. |

## Como a página Thymeleaf funciona

O Thymeleaf renderiza os templates HTML no servidor com os valores enviados pelo Controller. Os arquivos continuam usando HTML comum e acrescentam atributos `th:*` para ligar a página aos objetos Java.

1. **Controller envia dados à View:** em `GET /cadastrar`, o Controller cria um `Produto` vazio e chama `Model.addAttribute("produto", produto)`. Também envia as categorias permitidas com `Model.addAttribute("categorias", CATEGORIAS)`. Em `GET /lista`, envia os produtos encontrados, o termo de busca e a quantidade total com `Model.addAttribute`.
2. **Formulário ligado ao objeto:** em `cadastrar.html`, `th:object="${produto}"` escolhe o objeto do Model usado pelo formulário. Os campos `th:field="*{nome}"`, `th:field="*{preco}"`, `th:field="*{categoria}"` e `th:field="*{descricao}"` vinculam cada entrada à propriedade correspondente e geram os atributos HTML `name`, `id` e `value` necessários.
3. **POST preenche o objeto:** ao enviar o formulário, `th:action="@{/cadastrar}"` direciona os dados a `POST /cadastrar`. O parâmetro `@ModelAttribute Produto produto` faz o Spring criar/preencher o objeto usando os setters, como `setNome`, `setPreco` e `setCategoria`.
4. **Armazenamento no Service:** se o preço não for negativo, o Controller chama `ProdutoService.adicionar(produto)`. O Service atribui um ID e guarda o produto em uma lista Java. Essa lista vive somente enquanto a aplicação está em execução.
5. **Redirecionamento e nova consulta:** após salvar, o Controller responde com `redirect:/lista` (padrão PRG: Post/Redirect/Get). O navegador então faz uma nova requisição `GET /lista`; o Controller pede ao Service a lista completa ou filtrada e a adiciona ao Model.
6. **Renderização da tabela:** `th:each="produto, iterStat : ${produtos}"` cria uma linha por produto; `iterStat.count` exibe a posição. `th:text` coloca os valores do produto nas células, inclusive o preço formatado em reais. `th:if` mostra a mensagem quando a lista filtrada está vazia, e `th:unless` mostra a tabela quando existem resultados.

O ciclo completo é: **formulário → POST → Controller → validação e lista no Service → redirect → GET `/lista` → Model → template Thymeleaf renderizado**. Como não há banco de dados, a lista é zerada ao reiniciar o servidor.

## Exercícios implementados

- **Nível 1:** adicionado o atributo `descricao` ao produto e ao formulário/tabela; aplicado CSS básico nas duas páginas; exibida a quantidade total de produtos cadastrados abaixo da tabela.
- **Nível 2:** categoria selecionada em dropdown com Eletrônico, Vestuário, Alimento e Outros; preço negativo rejeitado com mensagem; coluna “Ações” com botão “Remover”.
- **Nível 3:** lista e operações movidas para a classe `@Service` `ProdutoService`; adicionada busca por nome ou categoria.
- Exercício 18 (H2/JPA) não implementado, conforme indicado como opcional.

## Fluxo MVC

```text
Navegador
   │ GET /cadastrar
   ▼
ProdutoController ── Model (produto, categorias) ──► cadastrar.html
   ▲                                                   │
   │                                                   │ POST /cadastrar
   │                                                   ▼
   └──────── redirect:/lista ◄── ProdutoService ◄── Controller
                                      │                 ▲
                                      │ GET /lista      │
                                      ▼                 │
                                 lista de produtos ── Model
                                                        │
                                                        ▼
                                                    lista.html
                                                        │
                                       busca ou POST remover
```
