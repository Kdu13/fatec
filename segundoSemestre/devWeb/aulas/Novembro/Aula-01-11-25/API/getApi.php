<?php
  $resposta = file_get_contents('https://fakestoreapi.com/products');
  
  $produtos = json_decode($resposta, true);

  if($produtos && is_array($produtos)) {
    foreach ($produtos as $produto) {
      echo "<hr><br>";
      echo "<img src='" . $produto['image'] . "' width='100px'>";
      echo "<br>ID: " . $produto['id'];
      echo "<br>Título: " . $produto['title'];
      echo "<br>Preço: $" . $produto['price'];
  }
  } else {
      echo "Erro ao obter os produtos da API.";
  }
?>