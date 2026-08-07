class Biblioteca:
    def __init__(self):
        self.livros = []
        self.usuarios = []

    def adicionar_livro(self, livro):
        self.livros.append(livro)
        return "Livro adicionado com sucesso"

    def cadastrar_usuario(self, usuario):
        self.usuarios.append(usuario)
        return "Usuário cadastrado com sucesso"

    def listar_livros(self):
        for livro in self.livros:
            print(livro)          

    def listar_usuarios(self):
        for usuario in self.usuarios:
            print(usuario)

    def __str__(self):
        return f'Biblioteca com {len(self.livros)} livros e {len(self.usuarios)} usuários cadastrados'