const calcular = () => {
    const resultado = document.getElementById("resultado");
    const nome = document.getElementById("nome").value;
    const tipo_contrato = document.getElementsByClassName("tipo_contrato");
    const beneficios = document.querySelectorAll(".Beneficios");
    const cargo = parseInt(document.querySelector("#Cargo").value);

    let porcentagem_desconto = 0;
    let valores_desconto = 0;
    let salario_liquido = 0;
    let valores_beneficio = 0;
//Pegar % de desconto selecionada
    for (let i = 0; i < tipo_contrato.length; i++) {
        if (tipo_contrato[i].checked) {
            porcentagem_desconto = tipo_contrato[i].value;
        }
    }
//Pegar os valores dos beneficios selecionados
    let x = 0;
    while (x < beneficios.length) {
        if (beneficios[x].checked) {
            valores_beneficio += parseInt(beneficios[x].value)
        }
        x++;
    }
//valores_desconto - seria o desconto sobre o valor total
//salario_liquido - seria o o desconto sobre o valor do salario e depois soma com os beneficios
    valores_desconto = cargo * (porcentagem_desconto / 100)
    salario_liquido = (cargo - valores_desconto) + valores_beneficio


//Mostrar tudo na tela
    resultado.innerHTML =
        "<p><b>Funcionário:</b> " + nome + "</p>" +
        "<p><b>Salário Base: </b>R$" + cargo.toFixed(2).replace(".",",")  + "</p>" +
        "<p><b>Benefícios: </b>R$" + valores_beneficio.toFixed(2).replace(".",",") + "</p>" +
        "<p><b>Descontos (" + porcentagem_desconto + "%): </b>" + valores_desconto.toFixed(2).replace(".",",") + "</p>" +
        "<p><b>Salário Líquido:  </b><i>R$" + salario_liquido.toFixed(2).replace(".",",") + "</i></p>";
}