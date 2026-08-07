import random

def nums_aleatorios():
    numeros = []
    i = 1
    while i <= 5:
        num = random.randint(1, 10)

        if num not in numeros:
            numeros.append(num)
            i += 1
    return numeros

def acertos(pc, user):
    pontos = 0

    for n in user:
        if n in pc:
            pontos += 1
    return pontos

listaPc = []
x = 1

while x<= 5:
    num = int(input("Digite um número entre 1 e 10: "))
    if num not in listaPc:
        listaPc.append(num)
        x += 1

numPc = nums_aleatorios()
print("Números Sorteados:", numPc, "\n")
pontuacao = acertos(numPc, listaPc)
print("Você fez ", pontuacao, "ponto(s)!")