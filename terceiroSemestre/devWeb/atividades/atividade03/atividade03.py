num1 = int(input("Digite o primeiro número:"))
num2 = int(input("Digite o segundo número:"))

def ehPrimo(numero):
    if numero < 2:
        return False

    for i in range(2, numero):
        if numero % i == 0:
            return False

    return True

contador = 0
menorNumeroPrimo = None
maiorNumeroPrimo = None
numero = num1

while numero < num2:
    if ehPrimo(numero):
        contador += 1
        if menorNumeroPrimo is None:
            menorNumeroPrimo = numero

        maiorNumeroPrimo = numero
    numero += 1

print("Quantidade de números primos entre", num1, "e", num2, ":", contador)
if contador > 0:
    print("Menor número primo:", menorNumeroPrimo)
    print("Maior número primo:", maiorNumeroPrimo)
else:
    print("Não há números primos entre", num1, "e", num2)