from perguntas import perguntas


class Quiz:
    def __init__(self, nome):
        self.nome = nome
        self.pontuacao = 0

    def iniciarQuiz(self):
        print(f"\nBem-vindo ao Quiz, {self.nome}!\n")

        for pergunta in perguntas:
            self.perguntar(pergunta)

        self.resultadoFinal()

    def perguntar(self, pergunta):
        print(pergunta["enunciado"])

        for alternativa in pergunta["alternativas"]:
            print(alternativa)

        resposta = input("Sua resposta: ").upper()
        self.responder(resposta, pergunta["resposta"])

    def responder(self, resposta_usuario, resposta_correta):
        if resposta_usuario == resposta_correta:
            print("Correto!\n")
            self.pontuacao += 1
        else:
            print(f"Errado! Resposta correta: {resposta_correta}\n")

    def resultadoFinal(self):
        print(f"\nPontuação final: {self.pontuacao}/35")

        if self.pontuacao >= 30:
            print("Excelente!")
        elif self.pontuacao >= 20:
            print("Bom desempenho!")
        else:
            print("Precisa estudar mais!")