const coords = [-24.2861, -46.9566]

const streetLayer = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
  maxZoom: 19,
  attribution: '&copy; OpenStreetMap'
})

const satelliteLayer = L.tileLayer('https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}', {
  maxZoom: 21,
  attribution: 'Tiles &copy; Esri'
})

const map = L.map('map', {
  center: coords,
  zoom: 15,
  maxZoom: 21,
  doubleClickZoom: true,
  scrollWheelZoom: true,
  layers: [streetLayer]
})

L.marker(coords).addTo(map).bindPopup('<b>Minha Localização</b>')

L.control.layers({
  'Satélite': satelliteLayer,
  'Mapa': streetLayer
}).addTo(map)

const MIN_LOADING_TIME = 300
const startTime = performance.now()

window.onload = () => {
  const elapsed = performance.now() - startTime
  const wait = Math.max(MIN_LOADING_TIME - elapsed, 0)

  setTimeout(() => {
    document.getElementById('loadingOverlay').classList.add('hidden')
    window.scrollTo({ top: 0, behavior: 'smooth' })
  }, wait)
}


document.addEventListener('DOMContentLoaded', () => {
  const mapaTitulo = Array.from(document.querySelectorAll('h2')).find(h2 => h2.textContent.trim() === 'Mapa')

  if (mapaTitulo) {
    mapaTitulo.style.cursor = 'pointer'
    mapaTitulo.addEventListener('click', () => {
      const url = 'https://www.google.com/maps?q=-24.2861,-46.9566'
      window.open(url, '_blank')
    })
  }
})