from random import randint

print("Bem-vindo ao Jokenpo!")

nome = input("Digite seu nome: ")

while True:
    jogador = input("Escolha Pedra, Papel ou Tesoura: ").lower()

    if jogador != "pedra" and jogador != "papel" and jogador != "tesoura":
        print("Opção inválida")
        continue

    pc = randint(0, 2)

    if pc == 0:
        computador = "pedra"
    elif pc == 1:
        computador = "papel"
    else:
        computador = "tesoura"

    print("Computador escolheu:", computador)

    if jogador == computador:
        print("Empate!")
    elif jogador == "pedra" and computador == "tesoura":
        print(nome, "venceu!")
    elif jogador == "papel" and computador == "pedra":
        print(nome, "venceu!")
    elif jogador == "tesoura" and computador == "papel":
        print(nome, "venceu!")
    else:
        print("Computador venceu!")

    resposta = input("Jogar novamente? (Sim/Não): ").lower()

    if resposta == "não" or resposta == "n":
        break

print("Fim de jogo!")