class Artist extends Act {
    Artist(String name, String country) {
        super(name, country);
    }

    @Override
    public boolean equals(Object obj) {
        Artist artist = (Artist) obj;

        return getName().equals(artist.getName()) && getCountry().equals(artist.getCountry());
    }
}