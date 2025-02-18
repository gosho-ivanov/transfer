package OOP_NEW_YEAR.Second_Term.Day_01;

public class Films {
    private Film[] films;

    public Films() {
        this.films = new Film[5];
    }

    public Film[] getFilms() {
        return films;
    }

    public void setFilms(Film[] films) {
        this.films = films;
    }

    public void addFilm(Film film){
        for (Film f:films){
            if (f == null){
                f = film;
            }
        }
    }

    public void checkForDoubles(Film film){
        for (int i = 0; i < 5; i++) {
            if (this.films[i] == null) break;
            else if (film.getName().equals(this.films[i].getName())){
                System.out.println("The movie you provided already exists in the film array.");
            }
        }
    }

    public void getFilmsByProducer(String producer){
        if (producer.equals("")){
            for (Film f:films){
                System.out.println(f.toString());
            }
        } else {
            for (Film film:films){
                if (film.getProducer().equals(producer)){
                    System.out.println(film.toString());
                }
            }
        }
    }

    public void getFilmWithHighestBudget(){
        int maxBudget = 0;
        int indexOfMxBudget = -1;
        int currentIndex = 0;
        for (Film film:films){
            if (film.getBudget() > maxBudget){
                maxBudget = film.getBudget();
                indexOfMxBudget = currentIndex;
                currentIndex++;
            }
        }
        System.out.println(this.films[indexOfMxBudget].toString());
    }

    public double getAvgFilmBudgetByProducer(String producer){
        int totalBudget = 0;
        int totalFilms = 0;
        if (producer.equals("")){
            for (Film film:films){
                if (film != null) {
                    totalBudget += film.getBudget();
                    totalFilms++;
                }
            }
        } else {
            for (Film film:films){
                if (film!=null){
                    if (film.getProducer().equals(producer)){
                        totalBudget+=film.getBudget();
                        totalFilms++;
                    }
                }
            }
        }
        return (double) totalBudget/totalFilms;
    }
}
