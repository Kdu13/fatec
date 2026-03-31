<?php

session_start();

//Apaga as variaveis de sessão
session_unset();

//Destrói a sessão
session_destroy();

header('Location: index.php');

?>