import requests
from bs4 import BeautifulSoup

pokemon_names = open("pokemon_names.txt", "r").read().split("\n")

pokemon_number = 1

# Iterate over all 151 pokémons
for pokemon_name in pokemon_names:   
    url = "https://bulbapedia.bulbagarden.net/wiki/" + pokemon_name + "_(Pok%C3%A9mon)"
    html_doc = requests.get(url).text
    soup = BeautifulSoup(html_doc, 'html.parser')
    
    images = soup.find_all("img")
    
    # Iterate over the website images to find the image of the wanted pokémon
    for image in images:
        if (image["alt"] == pokemon_name):
            image = requests.get("https:" + image["src"])
            
            open(str(pokemon_number) + ".png", "wb").write(image.content)

            pokemon_number += 1

            break
