lista = [20, 56, 47, 69]
print(lista)
print('Elementos: ',len(lista))
print(lista[1])
print(lista[-1])

lista[-2] = 50 # substitui o elemento na posição -2
print(lista)

lista.insert(-2, 50) # insere o elemento 50 na posição -2 e empurra o 47 e outros números para as próximas posições
print(lista)

lista.append(80) # adiciona o elemento 80 no final da lista
print(lista)

lista2 = ["a", "b", "c"]
lista.extend(lista2) # adiciona os elementos da lista2 no final da lista
print(lista)

lista.remove('b') # remove diretamente pelo elemento 'b' da lista
print(lista)

lista.pop(-1) # remove pelo índice -1, ou seja, o último elemento da lista
print(lista)

del lista [-1] # remove o elemento da posição -1, ou seja, o último elemento da lista
print(lista)

# del lista -- apaga a lista inteira da memória

lista.sort() # ordena a lista em ordem crescente
print(lista)

# lista.clear() # limpa a lista, ou seja, remove todos os elementos da lista, mas a lista continua existindo na memória
# print(lista)

for item in lista:
    print(item)

listas = [['a', 'b'], [10, 20]] # lista de listas, ou seja, cada elemento da lista é outra lista
print(listas[0][1]) # acessa a primeira lista na posição 0, e o elemento na posição 1 dessa lista, que é 'b'

