from decimal import Decimal, InvalidOperation

from django.contrib import messages
from django.shortcuts import get_object_or_404, redirect, render

from .forms import ImovelForm
from .models import Imovel


def listar_imoveis(request):
    imoveis = Imovel.objects.select_related("corretor")

    titulo = request.GET.get("titulo", "").strip()
    tipo = request.GET.get("tipo", "")
    finalidade = request.GET.get("finalidade", "")
    cidade = request.GET.get("cidade", "").strip()
    preco_max = request.GET.get("preco_max", "").strip().replace(",", ".")
    quartos = request.GET.get("quartos", "").strip()

    if titulo:
        imoveis = imoveis.filter(titulo__icontains=titulo)
    if tipo:
        imoveis = imoveis.filter(tipo=tipo)
    if finalidade:
        imoveis = imoveis.filter(finalidade=finalidade)
    if cidade:
        imoveis = imoveis.filter(cidade__icontains=cidade)
    if preco_max:
        try:
            imoveis = imoveis.filter(preco__lte=Decimal(preco_max))
        except InvalidOperation:
            pass
    if quartos.isdigit():
        imoveis = imoveis.filter(quartos=int(quartos))

    contexto = {
        "imoveis": imoveis,
        "tipos": Imovel.Tipo.choices,
        "finalidades": Imovel.Finalidade.choices,
    }
    return render(request, "imoveis/listar.html", contexto)


def cadastrar_imovel(request):
    if request.method == "POST":
        form = ImovelForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            messages.success(request, "Imóvel cadastrado com sucesso.")
            return redirect("cadastrar_imovel")
    else:
        form = ImovelForm()

    return render(
        request,
        "imoveis/form.html",
        {"form": form, "titulo_pagina": "Cadastrar imóvel", "botao": "Cadastrar imóvel"},
    )


def editar_imovel(request, pk):
    imovel = get_object_or_404(Imovel, pk=pk)

    if request.method == "POST":
        form = ImovelForm(request.POST, request.FILES, instance=imovel)
        if form.is_valid():
            form.save()
            messages.success(request, "Alterações salvas.")
            return redirect("listar_imoveis")
    else:
        form = ImovelForm(instance=imovel)

    return render(
        request,
        "imoveis/form.html",
        {"form": form, "titulo_pagina": "Editar imóvel", "botao": "Salvar alterações"},
    )


def excluir_imovel(request, pk):
    imovel = get_object_or_404(Imovel, pk=pk)

    if request.method == "POST":
        if imovel.imagem:
            imovel.imagem.delete(save=False)  # remove o arquivo da pasta media
        imovel.delete()
        messages.success(request, "Imóvel excluído.")
        return redirect("listar_imoveis")

    return render(request, "imoveis/confirmar_exclusao.html", {"imovel": imovel})
