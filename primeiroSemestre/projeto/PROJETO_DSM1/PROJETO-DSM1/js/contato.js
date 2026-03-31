function enviarWhatsApp() {
  const nome = document.getElementById('nome').value.trim().toUpperCase()
  const email = document.getElementById('email').value.trim()
  const modelo = document.getElementById('modelo').value.trim().toUpperCase()
  const problema = document.getElementById('problema').value.trim().toUpperCase()

  if (!nome || !email || !modelo || !problema) {
    alert("Por favor, preencha todos os campos antes de enviar a mensagem.")
    return
  }

  const mensagem =
    `Olá tudo bom? Gostaria de realizar um serviço.\n` +
    `\nProblema: ${problema}. ` +
    `\nAparelho: ${modelo}. ` +
    `\nMeu nome: ${nome}. ` +
    `\nMeu e-mail: ${email}.`

  const url = `https://wa.me/5513991290815?text=${encodeURIComponent(mensagem)}`
  window.open(url, '_blank')
}

$(document).ready(function() {
  $('.contato-botoes a').hover(
    function() {
      $(this).find('.btn-text').css({
        opacity: 1,
        transform: 'translateX(0)',
        pointerEvents: 'auto'
      })
      $(this).find('.bola').css({
        transform: 'scale(1.1)',
        filter: 'brightness(1.05)'
      })
    },
    function() {
      $(this).find('.btn-text').css({
        opacity: 0,
        transform: 'translateX(-20px)',
        pointerEvents: 'none'
      })
      $(this).find('.bola').css({
        transform: 'scale(1)',
        filter: 'brightness(1)'
      })
    }
  )
})
