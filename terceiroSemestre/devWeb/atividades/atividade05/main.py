from livro import Livro, Livro_Digital
from usuario import Usuario
from biblioteca import Biblioteca

biblioteca = Biblioteca()

while True:
    print("\nBiblioteca Virtual")
    print("1 - Cadastrar livro")
    print("2 - Cadastrar usuário")
    print("3 - Realizar empréstimo")
    print("4 - Devolver livro")
    print("5 - Listar livros disponíveis")
    print("6 - Sair")

    opcao = input("\nEscolha uma opção: ")

    if opcao == "1":
        titulo = input("Título do livro: ")
        autor = input("Autor do livro: ")
        ano = input("Ano de publicação: ")
        disponivel = True
        tipo = input("Tipo do livro (físico/digital): ")

        if tipo.lower() == "digital":
            tamanho_arquivo = input("Tamanho do arquivo (MBs): ")
            livro = Livro_Digital(titulo, autor, ano, disponivel, tamanho_arquivo)
        else:
            livro = Livro(titulo, autor, ano, disponivel)

        biblioteca.adicionar_livro(livro)
        print("\nLivro cadastrado com sucesso!")

    elif opcao == "2":
        nome = input("Nome do usuário: ")
        matricula = input("Matrícula do usuário: ")
        usuario = Usuario(nome, matricula)
        biblioteca.cadastrar_usuario(usuario)
        print("\nUsuário cadastrado com sucesso!")

    elif opcao == "3":
        nome_usuario = input("Nome do usuário: ")
        titulo_livro = input("Título do livro: ")

        usuario = None
        for u in biblioteca.usuarios:
            if u.nome == nome_usuario:
                usuario = u
                break

        livro = None
        for l in biblioteca.livros:
            if l.titulo == titulo_livro:
                livro = l
                break

        if usuario and livro:
            print(usuario.pegar_emprestado(livro))
        else:
            print("Usuário ou livro não encontrado.")

    elif opcao == "4":
        nome_usuario = input("Nome do usuário: ")
        titulo_livro = input("Título do livro: ")

        usuario = None
        for u in biblioteca.usuarios:
            if u.nome == nome_usuario:
                usuario = u
                break

        livro = None
        for l in biblioteca.livros:
            if l.titulo == titulo_livro:
                livro = l
                break

        if usuario and livro:
            print(usuario.devolver_livro(livro))
        else:
            print("Usuário ou livro não encontrado.")

    elif opcao == "5":
        print("\nLivros disponíveis:")
        for livro in biblioteca.livros:
            if livro.disponivel:
                print("\n",livro)

    else:
        print("Saindo do programa...")
        break