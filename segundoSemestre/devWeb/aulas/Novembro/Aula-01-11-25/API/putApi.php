<?php

$resposta = null;

if($_SERVER['REQUEST_METHOD'] === 'POST') {
    $id = $_POST['id'];
    $titulo = $_POST['titulo'];
    $preco = $_POST['preco'];

    $produto = json_encode([
        'title' => $titulo,
        'price' => $preco
    ]);

    //Contexto da requisição HTTP
    $opcoes = [
        'http' => [
            'method' => 'PUT',
            'header' => "Content-Type: application/json\r\n",
            'content' => $produto,
            'ignore_errors' => true
        ]
    ];

    $contexto = stream_context_create($opcoes);
    $resposta = file_get_contents("https://fakestoreapi.com/products/{$id}", false, $contexto);
}


?>



<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PUT</title>
</head>
<body>
    
    <h1>Atualizar Produto</h1>
    <form action="#" method="post">
        <label>ID:</label><br>
        <input type="number" name="id" required/><br><br>
        <label>Título:</label><br>
        <input type="text" name="titulo" required/><br><br>
        <label>Preço:</label><br>
        <input type="number" name="preco" step="0.01" required/><br><br>
        <input type="submit" value="Atualizar"/><br>
    </form>
    

    <?php
        if($resposta) {
            echo "<h2>Resposta da API:</h2>";
            echo $resposta;
        }
    ?>

</body>
</html>