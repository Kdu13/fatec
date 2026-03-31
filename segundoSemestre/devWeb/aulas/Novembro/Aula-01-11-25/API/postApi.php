<?php

if($_SERVER['REQUEST_METHOD'] === 'POST') {
    $titulo = $_POST['titulo'];
    $preco = $_POST['preco'];

    $produto = json_encode([
        'title' => $titulo,
        'price' => $preco
    ]);

    //Contexto da requisição HTTP
    $opcoes = [
        'http' => [
            'method' => 'POST',
            'header' => "Content-Type: application/json\r\n",
            'content' => $produto,
            'ignore_errors' => true
        ]
    ];

    $contexto = stream_context_create($opcoes);
    $resposta = file_get_contents('https://fakestoreapi.com/products', false, $contexto);

    echo $resposta;
}
else {


?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>POST</title>
</head>
<body>
    
    <h1>Cadastrar Produto</h1>
    <form action="#" method="post">
        <label>Título:</label><br>
        <input type="text" name="titulo" required/><br><br>
        <label>Preço:</label><br>
        <input type="number" name="preco" step="0.01" required/><br><br>
        <input type="submit" value="Cadastrar"/><br>
    </form>
    <?php
        
        if($produto) {
            
        ?>
        <p> ID: <?php echo $produto['id']; ?> </p>
        <p> Título: <?php echo $produto['title']; ?> </p>
        
    <?php
        }
    ?>

    <?php 
        } 
    ?>
    
</body>
</html>