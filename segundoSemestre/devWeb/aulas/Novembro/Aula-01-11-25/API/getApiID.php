<?php

$produto = null;

if($_SERVER['REQUEST_METHOD'] === 'POST') {
    $id = $_POST['id'];
    $resposta = file_get_contents("https://fakestoreapi.com/products/{$id}");
    $produto = json_decode($resposta, true);
}


?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GET ID</title>
</head>
<body>
    <h1>Pesquisar Produto</h1>
    <form action="#" method="post">
        <label>ID</label><br><br>
        <input type="number" name="id" required/><br><br>
        <input type="submit" value="Buscar"/><br>
    </form>

    <?php
        if($produto) {
            
        ?>
        <p> ID: <?php echo $produto['id']; ?> </p>
        <p> Título: <?php echo $produto['title']; ?> </p>
    <?php
        }
    ?>
</body>
</html>