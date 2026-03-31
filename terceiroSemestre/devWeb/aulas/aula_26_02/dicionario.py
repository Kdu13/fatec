aluno = {
    "id" : "0001",
    "nome" : "Carlos"
}
print(aluno)

aluno["curso"] = "DSM"
print(aluno)

del aluno["curso"]
# del aluno
print(aluno)

aluno.update({"nome": "Carlos Eduardo"})
# aluno.update({"name": "Carlos Eduardo Correia"})

if "id" in aluno:
    print("A chave id existe")
else:
    print("A chave id não existe")


print(aluno)
print(aluno["nome"])
print(aluno.values())
print(aluno.keys())
print(aluno.items())

for chave, valor in aluno.items():
    print(f'{chave} - {valor}')


alunos = {
    "aluno1" : {
    "id" : "0001",
    "nome" : "Carlos"
},
"aluno2" : {
    "id" : "0002",
    "nome" : "Rosangela"
}
}
print(alunos)
print(alunos["aluno1"]["nome"])