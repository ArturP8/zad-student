import java.util.ArrayList;
class Student {
     String imie;
     String nazwisko;
     double ocena;
     char plec;
     String kierunek;
     static ArrayList<Student> studenci = new ArrayList<>();
    public Student(String imie, String nazwisko, double ocena, char plec, String kierunek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena = ocena;
        this.plec = plec;
        this.kierunek = kierunek;
        studenci.add(this);
        WyswietlInformacje();
    }
    public void WyswietlInformacje() {
        System.out.println("Imię: " + imie + ", Nazwisko: " + nazwisko + ", Ocena: " + ocena +
                ", Płeć: " + plec + ", Kierunek: " + kierunek);
    }
    public void ZmienKierunek(String nowyKierunek) {
        this.kierunek = nowyKierunek;
        System.out.println("Zmieniono kierunek.");
        WyswietlInformacje();
    }
    public void ZmienOcene(double nowaOcena) {
        this.ocena = nowaOcena;
        System.out.println("Zmieniono ocenę.");
        WyswietlInformacje();
    }
    public double ObliczSredniaOcen() {
        return this.ocena;
    }
    public void ZmienImie(String noweImie) {
        this.imie = noweImie;
        System.out.println("Zmieniono imię.");
    }
    public void ZmienNazwisko(String noweNazwisko) {
        this.nazwisko = noweNazwisko;
        System.out.println("Zmieniono nazwisko.");
    }
    public boolean SprawdzZaliczenie() {
        return this.ocena >= 3.0;
    }
    public void UstawPlec(char nowaPlec) {
        this.plec = nowaPlec;
        System.out.println("Zmieniono płeć.");
    }
    public static void WyswietlSredniaOcenaKierunku(String kierunek) {
        double sumaOcen = 0;
        int liczbaStudentow = 0;

        for (Student student : studenci) {
            if (student.kierunek.equals(kierunek)) {
                sumaOcen += student.ocena;
                liczbaStudentow++;
            }
        }
        if (liczbaStudentow > 0) {
            double srednia = sumaOcen / liczbaStudentow;
            System.out.println("Średnia ocena dla kierunku " + kierunek + ": " + srednia);
        } else {
            System.out.println("Brak studentów na kierunku: " + kierunek);
        }
    }
    public static void main(String[] args) {
        Student s1 = new Student("adam", "nowak", 4.5, 'M', "polski");
        Student s2 = new Student("Anna", "jablko", 3.8, 'F', "niemiecki");
        Student s3 = new Student("Piotr", "winiarski", 2.9, 'M', "Matematyka");

        s1.ZmienOcene(5.0);
        s2.ZmienKierunek("Matematyka");

        WyswietlSredniaOcenaKierunku("Informatyka");

        System.out.println("Czy " + s1.imie + " zaliczył? " + s1.SprawdzZaliczenie());
    }
}