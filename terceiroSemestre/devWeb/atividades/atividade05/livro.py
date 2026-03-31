class Livro:
    def __init__(self, titulo, autor, ano, disponivel):
        self.titulo = titulo
        self.autor = autor
        self.ano = ano
        self.disponivel = disponivel

    def emprestar(self):
        if self.disponivel:
            self.disponivel = False
            return "Livro emprestado"
        else:
            return "Livro indisponível"

    def devolver(self):
        if not self.disponivel:
            self.disponivel = True
            return "Livro devolvido"
        else:
            return "Livro ja está disponível"

    def __str__(self):
        return f"Titulo: {self.titulo}\nAutor: {self.autor}\nAno: {self.ano}\nDisponível: {'Sim' if self.disponivel else 'Não'}"



class Livro_Digital(Livro):
    def __init__(self, titulo, autor, ano, disponivel, tamanho_arquivo):
        super().__init__(titulo, autor, ano, disponivel)
        self.tamanho_arquivo = tamanho_arquivo

    def __str__(self):
        return f'{super().__str__()}\nTamanho do Arquivo: {self.tamanho_arquivo} MBs'