<style>
    body {
        background-color: gray;
    }
</style>

<?php
interface metodos
{
    public function valorHE();
    public function saudacao();
}

//CLASSE ABSTRATA
abstract class Funcionario implements metodos
{

    //ATRIBUTOS
    protected $nome;
    protected $salarioBase;

    //ATRIBUTO ESTATICO
    protected static $totalFunc = 0;

    //METODOS 
    public function __construct($nome, $salarioBase)
    {
        $this->nome = $nome;
        $this->salarioBase = $salarioBase;
        self::$totalFunc++;
    }

    public function mostrarFuncionario()
    {
        echo "Nome: " . $this->nome . " <br>Salario base: R$ " . $this->salarioBase;
    }

    public function exibirFuncao()
    {
        echo "<h1>FUNCIONÁRIO</h1>";
    }

    //METODO ABSTRATO
    abstract public function calcSalario();

    //METODO ESTATICO
    public static function mostraTotalFunc(){
        return self::$totalFunc;
    }

    //GET E SET:
    //  public function getNome() {
    //      return $this->nome;
    //  }

    //  public function setNome($nm) {
    //      $this->nome = $nm;
    //  }

}
//HERANÇA
class Desenvolvedor extends Funcionario
{
    private $horaExtra;

    public function __construct($nome, $salarioBase, $horaExtra)
    {
        parent::__construct($nome, $salarioBase);
        $this->horaExtra = $horaExtra;
    }

    //POLIMORFISMO
    public function calcSalario()
    {
        return $this->salarioBase + ($this->horaExtra * 50);
    }

    public function exibirFuncao()
    {
        echo "<h1>DESENVOLVEDOR</h1>";
    }

    //FUNÇÕES DA INTERFACE
    public function valorHE()
    {
        return $this->horaExtra;
    }

    public function saudacao()
    {
        return "Seja bem-vindo!";
    }
}

//OBJETOS
//$f1 = new Funcionario("Maria", 5000.98); 
// $f1->setNome("Maria") ;
// echo "Funcionario(a): ". $f1->getNome();

$d1 = new Desenvolvedor("Mario", 5000.42, 50);
$d2 = new Desenvolvedor("Maria", 3000.42, 50);
$d3 = new Desenvolvedor("Mariana", 2500.42, 50);
echo $d1->saudacao();
$d1->exibirFuncao();
$d1->mostrarFuncionario();
echo "<br>Salário final: R$ " . $d1->calcSalario();
echo "<br>Valor da hora extra: R$ " . $d1->valorHE();
echo "<br>Total de funcionários: " . Funcionario::mostraTotalFunc();

?>