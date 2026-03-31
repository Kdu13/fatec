limite = 23
peso_total = 0
lista_itens = ""

nome = input("Digite o nome do mochileiro: ")

item = input("Digite o nome do item (ou 'fim' para encerrar): ")

while item != "fim":

    peso = float(input("Digite o peso do item em kg: "))

    if peso_total + peso <= limite:
        peso_total = peso_total + peso
        lista_itens = lista_itens + item + "\n"
        print("Item adicionado!")
    else:
        print("Não há espaço suficiente na mochila.")

    item = input("Digite outro item (ou 'fim' para encerrar): ")

print("Nome do mochileiro:", nome)
print("Peso total:", peso_total, "kg")
print("Espaço restante:", limite - peso_total, "kg")
print("Itens adicionados:")
print(lista_itens)
