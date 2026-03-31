class Usuario:
    def __init__(self, nome, matricula, livros_emprestados = []):
        self.nome = nome
        self.matricula = matricula
        self.livros_emprestados = livros_emprestados

    def pegar_emprestado(self, livro):
        if livro.emprestar() == "Livro emprestado":
            self.livros_emprestados.append(livro)
            return "\nLivro emprestado com sucesso"
        else:
            return "\nLivro não disponível"

    def devolver_livro(self, livro):
        if livro in self.livros_emprestados:
            livro.devolver()
            self.livros_emprestados.remove(livro)
            return "\nLivro devolvido com sucesso"
        else:
            return "\nLivro não está emprestado por este usuário"

    def __str__(self):
        return f'Nome: {self.nome}\nMatricula: {self.matricula}\nLivros Emprestados: {len(self.livros_emprestados)}'