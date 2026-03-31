$(document).ready(() => {

    $("h1").text("Calculadora");
    $("h1").css("color", "#198ADF");
    
    $("#btn1").click(() => {
        // alert("Clicado");
        let n1 = parseInt($("#n1").val());
        let n2 = parseInt($("#n2").val());
        $(".paragrafo").text(n1 + n2);
    });

    $(".paragrafo").click(() => {
        $(".paragrafo").addClass('borda');
    })
});