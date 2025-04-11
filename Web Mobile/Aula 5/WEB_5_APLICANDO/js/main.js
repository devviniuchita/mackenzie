const container = document.getElementById("countries-container");

fetch("https://restcountries.com/v3.1/all")
  .then((response) => response.json())
  .then((data) => {
    data.forEach((country) => {
      const name = country.name.common || "Sem nome";
      const capital = country.capital ? country.capital[0] : "Sem capital";
      const population = country.population.toLocaleString();
      const flag = country.flags.png;
      const mapLink = country.maps.googleMaps;

      const card = document.createElement("div");
      card.className = "card";

      card.innerHTML = `
        <img src="${flag}" alt="Bandeira de ${name}">
        <div class="info">
          <p><span>Nome:</span> ${name}</p>
          <p><span>Capital:</span> ${capital}</p>
          <p><span>População:</span> ${population}</p>
          <p><span>Mapa:</span> <a href="${mapLink}" target="_blank">Acessar Mapa</a></p>
        </div>
      `;

      container.appendChild(card);
    });
  })
  .catch((error) => {
    container.innerHTML = `<p>Erro ao carregar países: ${error}</p>`;
  });
