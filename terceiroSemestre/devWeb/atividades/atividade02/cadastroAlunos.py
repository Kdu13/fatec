alunos = []
disciplinas = set()
turma = ("Desenvolvimento de Software Multiplataforma", 2026)


def cadastrar_aluno():
    print("\n--- CADASTRAR ALUNO ---")

    nome = input("Nome: ")
    idade = int(input("Idade: "))
    cidade = input("Cidade: ")

    aluno = {
        "nome": nome,
        "idade": idade,
        "cidade": cidade,
        "notas": []
    }

    alunos.append(aluno)

    print("Aluno cadastrado!")


def listar_alunos():
    print("\n--- ALUNOS ---")

    if len(alunos) == 0:
        print("Nenhum aluno cadastrado.")
    else:
        for i in range(len(alunos)):
            aluno = alunos[i]

            print("\nAluno", i + 1)
            print("Nome:", aluno["nome"])
            print("Idade:", aluno["idade"])
            print("Cidade:", aluno["cidade"])
            print("Notas:", aluno["notas"])


def registrar_notas():
    print("\n--- REGISTRAR NOTAS ---")

    if len(alunos) == 0:
        print("Nenhum aluno cadastrado.")
        return

    listar_alunos()

    numero = int(input("\nDigite o número do aluno: "))

    if numero < 1 or numero > len(alunos):
        print("Aluno inválido.")
        return

    aluno = alunos[numero - 1]

    quantidade = int(input("Quantas notas deseja adicionar? "))

    for i in range(quantidade):
        nota = float(input("Digite a nota: "))
        aluno["notas"].append(nota)

    print("Notas adicionadas!")


def calcular_media():
    print("\n--- CALCULAR MÉDIA ---")

    if len(alunos) == 0:
        print("Nenhum aluno cadastrado.")
        return

    listar_alunos()

    numero = int(input("\nDigite o número do aluno: "))

    if numero < 1 or numero > len(alunos):
        print("Aluno inválido.")
        return

    aluno = alunos[numero - 1]

    if len(aluno["notas"]) == 0:
        print("Esse aluno não possui notas.")
        return

    soma = 0

    for nota in aluno["notas"]:
        soma += nota

    media = soma / len(aluno["notas"])

    print("\nAluno:", aluno["nome"])
    print("Média:", round(media, 2))

    if media >= 6:
        print("Aprovado!")
    else:
        print("Reprovado!")


def cadastrar_disciplina():
    print("\n--- CADASTRAR DISCIPLINA ---")

    disciplina = input("Nome da disciplina: ")

    if disciplina in disciplinas:
        print("Essa disciplina já está cadastrada.")
    else:
        disciplinas.add(disciplina)
        print("Disciplina cadastrada!")


def listar_disciplinas():
    print("\n--- DISCIPLINAS ---")

    if len(disciplinas) == 0:
        print("Nenhuma disciplina cadastrada.")
    else:
        for disciplina in disciplinas:
            print("-", disciplina)


def informar_turma():
    print("\n--- DADOS DA TURMA ---")
    print("Curso:", turma[0])
    print("Ano:", turma[1])


while True:
    print("\n==============================")
    print("     SISTEMA DE ALUNOS")
    print("==============================")
    print("1 - Cadastrar aluno")
    print("2 - Listar alunos")
    print("3 - Registrar notas")
    print("4 - Calcular média")
    print("5 - Cadastrar disciplina")
    print("6 - Listar disciplinas")
    print("7 - Informar dados da turma")
    print("0 - Encerrar")
    print("==============================")

    opcao = input("Escolha uma opção: ")

    if opcao == "1":
        cadastrar_aluno()

    elif opcao == "2":
        listar_alunos()

    elif opcao == "3":
        registrar_notas()

    elif opcao == "4":
        calcular_media()

    elif opcao == "5":
        cadastrar_disciplina()

    elif opcao == "6":
        listar_disciplinas()

    elif opcao == "7":
        informar_turma()

    elif opcao == "0":
        print("Programa encerrado!")
        break

    else:
        print("Opção inválida.")