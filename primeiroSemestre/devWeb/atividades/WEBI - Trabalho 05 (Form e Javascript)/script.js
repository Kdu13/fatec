const links = document.querySelectorAll('header a');
    const Pagina_atual = window.location.pathname.split("/").pop();

    links.forEach(link => {
        if (link.getAttribute("href") === Pagina_atual) {
            link.classList.add("active");
        }
    });