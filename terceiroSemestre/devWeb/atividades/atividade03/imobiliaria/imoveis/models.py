from django.db import models


class Corretor(models.Model):
    nome = models.CharField(max_length=100)
    email = models.EmailField(unique=True)
    telefone = models.CharField(max_length=20)

    class Meta:
        verbose_name_plural = "Corretores"
        ordering = ["nome"]

    def __str__(self):
        return self.nome


class Imovel(models.Model):
    class Tipo(models.TextChoices):
        CASA = "casa", "Casa"
        APARTAMENTO = "apartamento", "Apartamento"
        TERRENO = "terreno", "Terreno"

    class Finalidade(models.TextChoices):
        VENDA = "venda", "Venda"
        ALUGUEL = "aluguel", "Aluguel"

    titulo = models.CharField("título", max_length=150)
    descricao = models.TextField("descrição")
    tipo = models.CharField(max_length=20, choices=Tipo.choices)
    finalidade = models.CharField(max_length=20, choices=Finalidade.choices)
    preco = models.DecimalField("preço", max_digits=12, decimal_places=2)
    cidade = models.CharField(max_length=100)
    quartos = models.PositiveIntegerField("quartos", default=0)
    imagem = models.ImageField(upload_to="imoveis/", blank=True, null=True)
    corretor = models.ForeignKey(
        Corretor,
        on_delete=models.PROTECT,
        related_name="imoveis",
        verbose_name="corretor responsável",
    )
    data_cadastro = models.DateTimeField("data de cadastro", auto_now_add=True)

    class Meta:
        verbose_name_plural = "Imóveis"
        ordering = ["-data_cadastro"]

    def __str__(self):
        return self.titulo
