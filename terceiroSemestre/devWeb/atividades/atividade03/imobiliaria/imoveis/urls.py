from django.urls import path

from . import views

urlpatterns = [
    path("", views.listar_imoveis, name="listar_imoveis"),
    path("cadastrar/", views.cadastrar_imovel, name="cadastrar_imovel"),
    path("<int:pk>/editar/", views.editar_imovel, name="editar_imovel"),
    path("<int:pk>/excluir/", views.excluir_imovel, name="excluir_imovel"),
]
