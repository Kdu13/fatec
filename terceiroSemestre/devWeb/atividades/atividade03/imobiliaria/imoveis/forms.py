from django import forms

from .models import Imovel


class ImovelForm(forms.ModelForm):
    class Meta:
        model = Imovel
        fields = [
            "titulo",
            "descricao",
            "tipo",
            "finalidade",
            "preco",
            "cidade",
            "quartos",
            "imagem",
            "corretor",
        ]
        widgets = {
            "descricao": forms.Textarea(attrs={"rows": 4}),
        }

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.fields["tipo"].choices = [("", "Selecione")] + list(Imovel.Tipo.choices)
        self.fields["finalidade"].choices = [("", "Selecione")] + list(Imovel.Finalidade.choices)
        self.fields["corretor"].empty_label = "Selecione"
