import time

agenda = {
    "Carlos": {
        "telefone": "123456789"
        },
    "Caio": {
        "telefone": "987654321"
        },
    "Pedro": {
        "telefone": "555555555"
        },
    "Geovanny": {
        "telefone": "111111111"
        }
}

while True:
    print("\nAGENDA TELEFÔNICA")
    print("1 - Cadastrar contato")
    print("2 - Buscar contato")
    print("3 - Excluir contato")
    print("4 - Listar contatos")
    print("5 - Sair")

    opcao = input("Escolha uma opção: ")

    if opcao == "1":
        nome = input("Digite o nome do contato: ")
        telefone = input("Digite o telefone: ")

        if nome in agenda:
            print("Contato já existe! Telefone será atualizado.")

        agenda[nome] = {"telefone": telefone}
        print("Contato salvo com sucesso!")
        time.sleep(1)

    elif opcao == "2":
        nome = input("Digite o nome para buscar: ")

        if nome in agenda:
            print(f"Telefone de {nome}: {agenda[nome]['telefone']}")
            
        else:
            print("Contato não encontrado.") 
        time.sleep(1)

    elif opcao == "3":
        nome = input("Digite o nome do contato para excluir: ")

        if nome in agenda:
            del agenda[nome]
            print("Contato removido com sucesso!")
        else:
            print("Contato não encontrado.")
        time.sleep(1)

    elif opcao == "4":
        if len(agenda) == 0:
            print("Agenda vazia.")
        else:
            print("\nLista de Contatos:")
            for nome, dados in agenda.items():
                print(f"{nome} - {dados['telefone']}")
        time.sleep(1)

    elif opcao == "5":
        print("Encerrando o programa...")
        time.sleep(1)
        break

    else:
        print("Opção inválida! Tente novamente.")