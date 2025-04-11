const API_KEY =
  "https://superheroapi.com/api.php/15ee6cb7b7ca8180af1dafe94266a5fd";

window.onload = function () {
  loadBattle();
};

function loadBattle() {
  const id1 = getRandom();
  let id2 = getRandom();

  while (id2 === id1) {
    id2 = getRandom();
  }

  Promise.all([getHeroData(id1), getHeroData(id2)]).then(([hero1, hero2]) => {
    displayBattle(hero1, hero2);
  });
}

function getRandom() {
  return Math.floor(Math.random() * 731) + 1;
}

function getHeroData(id) {
  const url = `${API_KEY}/${id}`;
  return new Promise((resolve) => {
    callApi(url, (status, data) => {
      if (data.response === "error") {
        resolve(getHeroData(getRandom()));
        return;
      }

      const powerstats = data.powerstats || {};
      const stats = {
        intelligence: parseInt(powerstats.intelligence) || 0,
        strength: parseInt(powerstats.strength) || 0,
        speed: parseInt(powerstats.speed) || 0,
        durability: parseInt(powerstats.durability) || 0,
        power: parseInt(powerstats.power) || 0,
        combat: parseInt(powerstats.combat) || 0,
      };

      const total = Object.values(stats).reduce((sum, val) => sum + val, 0);

      const image =
        data.image?.url ||
        "https://via.placeholder.com/400x600?text=Hero+Image+Not+Found";

      resolve({
        name: data.name || "Herói Desconhecido",
        image,
        stats,
        total,
      });
    });
  });
}

function displayBattle(hero1, hero2) {
  const content = document.getElementById("content");
  content.innerHTML = "";

  const winner =
    hero1.total > hero2.total
      ? "hero1"
      : hero2.total > hero1.total
      ? "hero2"
      : "draw";

  [hero1, hero2].forEach((hero, index) => {
    const isWinner =
      (index === 0 && winner === "hero1") ||
      (index === 1 && winner === "hero2");

    const card = document.createElement("article");
    card.className = "card" + (isWinner ? " winner" : "");

    card.innerHTML = `
      <img src="${hero.image}" alt="Imagem de ${hero.name}" />
      <h1>${hero.name}</h1>
      ${Object.entries(hero.stats)
        .map(
          ([key, value]) => `
        <p>
          ${capitalize(key)}:
          <span style="display:inline-block; height:10px; background-color:${getColorForStat(
            key
          )}; width:${value}%;"></span>
          ${value}
        </p>`
        )
        .join("")}
      <h3>Total: ${hero.total}</h3>
    `;

    content.appendChild(card);
  });

  if (winner === "draw") {
    const result = document.createElement("div");
    result.className = "draw-msg";
    result.innerText = "Empate!";
    content.appendChild(result);
  }
}

function capitalize(str) {
  return str.charAt(0).toUpperCase() + str.slice(1);
}

function getColorForStat(stat) {
  const colors = {
    intelligence: "#F9B32F",
    strength: "#FF7C6C",
    speed: "#22A7F0",
    durability: "#3EDC81",
    power: "#AB69C6",
    combat: "#9CAAB9",
  };
  return colors[stat] || "#ccc";
}

function callApi(url, callback) {
  const xhr = new XMLHttpRequest();
  xhr.responseType = "json";
  xhr.open("GET", url, true);
  xhr.onload = function () {
    if (xhr.status === 200) {
      callback(xhr.status, xhr.response);
    } else {
      console.error("Erro:", xhr.status, xhr.statusText);
    }
  };
  xhr.onerror = function () {
    console.error("Erro de rede ao tentar fazer a requisição.");
  };
  xhr.send();
}
