let contador = 0;
let intervalo = null;

setInterval(() => {
    let dia = new Date();
    document.getElementById("data").textContent = dia.getHours() + ":"
                                                  + dia.getMinutes() + ":" 
                                                  + dia.getSeconds();
}, 1000)

const iniciar = () => {
    if(intervalo) return;
    intervalo = setInterval(() => {
        contador++;
                                            //.innerHTML - Tambem pode ser usado 
        document.getElementById("cronometro").textContent = contador;
        document.body.classList.toggle("cor");
        // document.getElementById("data").textContent = dia.getHours() + ":"
        //                                              + dia.getMinutes() + ":" 
        //                                              + dia.getSeconds();
        // document.getElementById("data").textContent = dia.toTimeString();
    }, 1000)
}

const parar = () => {
    clearInterval(intervalo);
    intervalo = null;
}

const zerar = () => {
    document.getElementById("mensagem").textContent = "Em 3 segundos o tempo vai zerar..."
    setTimeout(() => {
        parar();
        contador = 0;
        document.getElementById("cronometro").textContent = contador;
        document.getElementById("mensagem").textContent = "";
    }, 3000);
}