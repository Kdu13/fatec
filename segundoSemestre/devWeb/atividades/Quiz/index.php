<?php
$quiz = [
    "Naruto" => [
        [
            'pergunta' => 'Qual o nome da técnica proibida que Naruto aprende no início da história?',
            'opcoes' => ['Rasengan', 'Chidori', 'Kage Bunshin no Jutsu', 'Kuchiyose no Jutsu', 'Hiraishin no Jutsu'],
            'resposta_correta' => 'Kage Bunshin no Jutsu'
        ],

        [
            'pergunta' => 'Quem foi o primeiro Jinchūriki da Kurama (Raposa de Nove Caudas)?',
            'opcoes' => ['Mito Uzumaki', 'Kushina Uzumaki', 'Hashirama Senju', 'Minato Namikaze', 'Tobirama Senju'],
            'resposta_correta' => 'Mito Uzumaki'
        ],

        [
            'pergunta' => 'Durante a Quarta Guerra Ninja, quem foi o responsável por reviver Madara Uchiha?',
            'opcoes' => ['Kabuto Yakushi', 'Orochimaru', 'Black Zetsu', 'Obito Uchiha', 'Nagato'],
            'resposta_correta' => 'Kabuto Yakushi'
        ],

        [
            'pergunta' => 'Qual desses personagens nunca foi oficialmente um Hokage?',
            'opcoes' => ['Tobirama Senju', 'Hiruzen Sarutobi', 'Danzo Shimura', 'Tsunade Senju', 'Kakashi Hatake'],
            'resposta_correta' => 'Danzo Shimura'
        ],

        [
            'pergunta' => 'Qual o verdadeiro objetivo da Akatsuki, revelado apenas mais tarde na história?',
            'opcoes' => ['Conquistar as vilas ninjas', 'Vingar o clã Uchiha', 'Capturar todos os bijuus', 'Criar uma arma para forçar a paz mundial', 'Destruir Konoha'],
            'resposta_correta' => 'Criar uma arma para forçar a paz mundial'
        ],
    ],

    "Cavaleiros do Zodiaco" => [
        [
            'pergunta' => 'Qual Cavaleiro de Ouro sacrificou sua vida para destruir o Muro das Lamentações na saga de Hades?',
            'opcoes' => ['Shaka de Virgem', 'Saga de Gêmeos', 'Aiolia de Leão', 'Todos os Cavaleiros de Ouro', 'Camus de Aquário'],
            'resposta_correta' => 'Todos os Cavaleiros de Ouro'
        ],

        [
            'pergunta' => 'Na saga de Asgard, qual deus manipulava Hilda de Polaris através do Anel de Nibelungo?',
            'opcoes' => ['Odin', 'Thor', 'Loki', 'Poseidon', 'Fenrir'],
            'resposta_correta' => 'Poseidon'
        ],

        [
            'pergunta' => 'Quem é a reencarnação da deusa Atena na série?',
            'opcoes' => ['Saori Kido', 'Esmeralda', 'Marin', 'Shina', 'Hilda de Polaris'],
            'resposta_correta' => 'Saori Kido'
        ],

        [
            'pergunta' => 'Na saga de Hades, qual foi o único Cavaleiro de Ouro a atravessar os Campos Elísios junto com os de Bronze?',
            'opcoes' => ['Aiolia de Leão', 'Shaka de Virgem', 'Shion de Áries', 'Orfeu de Lira', 'Nenhum'],
            'resposta_correta' => 'Nenhum'
        ],

        [
            'pergunta' => 'Qual Cavaleiro de Ouro tinha a fama de ser o mais próximo de um deus entre os 88 Cavaleiros de Atena?',
            'opcoes' => ['Shaka de Virgem', 'Saga de Gêmeos', 'Aiolia de Leão', 'Mu de Áries', 'Dohko de Libra'],
            'resposta_correta' => 'Shaka de Virgem'
        ],
    ],

    "Dragon Ball" => [
        [
            'pergunta' => 'Quando foi lançado o primeiro episódio de Dragon Ball no Brasil?',
            'opcoes' => ['1996', '1986', '1999', '1995'],
            'resposta_correta' => '1996'
        ],
        [
            'pergunta' => 'Qual o nome do primeiro filho de Goku?',
            'opcoes' => ['Gohan', 'Goten', 'Trunks', 'Uub'],
            'resposta_correta' => 'Gohan'
        ],
        [
            'pergunta' => 'Qual o nome do planeta onde Goku enfrentou Freeza em Dragon Ball Z?',
            'opcoes' => ['Terra', 'Planeta Vegeta', 'Namekusei', 'Sadala'],
            'resposta_correta' => 'Namekusei'
        ],
        [
            'pergunta' => 'Quem derrotou Cell?',
            'opcoes' => ['Goku', 'Vegeta', 'Trunks', 'Gohan'],
            'resposta_correta' => 'Gohan'
        ],
        [
            'pergunta' => 'Quantas vezes o Kuririn morreu durante a obra?',
            'opcoes' => ['3', '2', '4', '5'],
            'resposta_correta' => '3'
        ]
    ]
];

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['respostas'])) {
    $categoria = $_POST['categoria'];
    $respostas = $_POST['respostas'];
    $perguntas = $quiz[$categoria];
    $pontuacao = 0;

    foreach ($respostas as $indice => $resposta) {
        if ($resposta === $perguntas[$indice]['resposta_correta']) {
            $pontuacao++;
        }
    }

    $porcentagem = round(($pontuacao / count($perguntas)) * 100, 1);
    $mensagem = '';

    if ($porcentagem >= 80) {
        $mensagem = 'Excelente trabalho!';
    } else if ($porcentagem >= 60) {
        $mensagem = 'Muito bem!';
    } else if ($porcentagem >= 40) {
        $mensagem = 'Bom esforço!';
    } else {
        $mensagem = 'Continue estudando!';
    }

    echo "<!DOCTYPE html>";
    echo "<html lang='pt-br'>";
    echo "<head>";
    echo "<meta charset='UTF-8'>";
    echo "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
    echo "<link rel='stylesheet' href='styles.css'>";
    echo "<link rel='stylesheet' href='responsivo.css'>";
    echo "<title>Resultado - Kadu Quiz</title>";
    echo "</head>";
    echo "<body>";

    echo "<div class='resultado'>";
    echo "<h2>Resultado do Quiz - $categoria</h2>";
    echo "<p>$mensagem</p>";
    echo "<p>Você acertou <strong>$pontuacao</strong> de <strong>" . count($perguntas) . "</strong> perguntas!</p>";
    echo "<p>$porcentagem%</p>";
    echo "<a href='?' class='btn-voltar'>Fazer outro quiz</a>";
    echo "</div>";

    echo "<div class='correcao'>";
    echo "<h3>Correção:</h3>";
    foreach ($perguntas as $indice => $pergunta) {
        $resposta_usuario = $respostas[$indice];
        $resposta_correta = $pergunta['resposta_correta'];
        $correto = ($resposta_usuario === $resposta_correta);

        echo "<div class='questao-correcao " . ($correto ? 'correta' : 'incorreta') . "'>";
        echo "<p><strong>Pergunta " . ($indice + 1) . ":</strong> " . $pergunta['pergunta'] . "</p>";
        echo "<p><strong>Sua resposta:</strong> $resposta_usuario</p>";
        if (!$correto) {
            echo "<p><strong>Resposta correta:</strong> $resposta_correta</p>";
        }
        echo "</div>";
    }
    echo "</div>";

    echo "</body>";
    echo "</html>";
} else if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['categoria'])) {
    $categoria = $_POST['categoria'];
    $perguntas = $quiz[$categoria];

    echo "<!DOCTYPE html>";
    echo "<html lang='pt-br'>";
    echo "<head>";
    echo "<meta charset='UTF-8'>";
    echo "<meta name='viewport' content='width=device-width, initial-scale=1.0'>";
    echo "<link rel='stylesheet' href='styles.css'>";
    echo "<link rel='stylesheet' href='responsivo.css'>";
    echo "<title>Quiz - $categoria</title>";
    echo "</head>";
    echo "<body>";

    echo "<div class='quiz-container'>";
    echo "<h2>Quiz - $categoria</h2>";
    echo "<div class='progresso'>";
    echo "</div>";
    echo "<br><form action='#' method='post'>";
    echo "<input type='hidden' name='categoria' value='$categoria'>";

    foreach ($perguntas as $indice => $pergunta) {
        echo "<div class='pergunta'>";
        echo "<h3>Pergunta " . ($indice + 1) . ": " . $pergunta['pergunta'] . "</h3>";

        foreach ($pergunta['opcoes'] as $opcao) {
            echo "<label>";
            echo "<input type='radio' name='respostas[$indice]' value='$opcao' required>";
            echo " $opcao";
            echo "</label>";
        }
        echo "</div>";
    }

    echo "<button type='submit' class='btn-enviar'>Finalizar Quiz</button>";
    echo "</form>";
    echo "</div>";

    echo "</body>";
    echo "</html>";
} else {
?>

    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="responsivo.css">
        <title>Kadu Quiz</title>
    </head>

    <body>
        <div class="container">
            <h1>Kadu Quiz</h1>
            <form method="post" class="categoria-form">
                <label for="categoria">Selecione uma categoria:</label>
                <select name="categoria" id="categoria" required>
                    <option value="" disabled selected>-- Escolha uma categoria --</option>
                    <?php
                    $temas = array_keys($quiz);
                    sort($temas);
                    foreach ($temas as $categoria) {
                        echo "<option value='$categoria'>$categoria</option>";
                    }
                    ?>
                </select>
                <button type="submit">Iniciar Quiz</button>
            </form>
        </div>
    </body>

    </html>

<?php
}
?>