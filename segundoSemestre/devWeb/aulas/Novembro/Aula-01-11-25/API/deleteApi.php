<?php
$resposta = null;

if($_SERVER['REQUEST_METHOD'] === 'POST') {
    $id = $_POST['id'];

    //Contexto da requisição HTTP
    $opcoes = [
        'http' => [
            'method' => 'DELETE',
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
    <title>DELETE</title>
</head>

<body>
    
    <h1>Deletar Produto</h1>
    <form action="#" method="post">
        <label>ID:</label><br>
        <input type="number" name="id" required/><br><br>
        <input type="submit" value="Deletar"/><br>
    </form>

    <?php
        if($resposta) {
            echo "<h2>Resposta da API:</h2>";
            echo $resposta;
        }
    ?>

</body>

</html>