<?php
// Cria ou abre o arquivo // w altera os dados, a acrescenta dados novos.
// $arquivo = fopen("dados.txt","a");

// Escreve no arquivo
// fwrite($arquivo,"\nOitava linha.");

// Fecha o arquivo
// fclose($arquivo);

// // Abre o arquivo para leitura
$arquivo = fopen("dados.txt","r");

// Le o arquivo
// $conteudo = fread($arquivo,filesize("dados.txt"));

// Exibe linha a linha do arquivo
// echo nl2br($conteudo);

while(($linha = fgets($arquivo)) !== false){

    echo "<br>" . $linha;
    $array = explode(",", $linha);
    print_r($array);
    
}

fclose($arquivo);

?>