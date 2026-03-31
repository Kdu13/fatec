<?php
    require('funcoes.php');

    if($_SERVER['REQUEST_METHOD'] === 'POST' && !empty($_POST['txtn1']) && !empty($_POST['txtn2'])) {

        if(!empty($_POST['txtnome'])){

        $nm = $_POST['txtnome'];
        $n1 = $_POST['txtn1'];
        $n2 = $_POST['txtn2'];

        saudacao($nm);
        echo '<br>Sua média é: ' . media($n1, $n2);

        // echo media(7,6);    Também pode ser usado.
        // $m = media(7,6);    Também pode ser usado.
    }
    else{
        erro();
    }

    

}

?>