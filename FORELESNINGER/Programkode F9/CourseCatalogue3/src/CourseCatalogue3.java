/* Course.java
 * Klassen Course med attributtene courseCode, courseName og nrOfStudents.
 * nrOfStudents kan endres.
 */
class Course {
    private final String courseCode;  // entydig
    private final String courseName;
    private int nrOfStudents = 0;  // endres med metoden setAntStud()
    // konstruktøren
    public Course(String courseCode, String courseName) {
        if (courseCode == null || courseCode.trim().equals("")
                || courseName == null || courseCode.trim().equals("")) {
            throw new IllegalArgumentException("CourseCode og courseName må oppgis.");
        }
        this.courseCode = courseCode.trim();
        this.courseName = courseName.trim();
    }
    // getmetoder
    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getNrOfStudents() {
        return nrOfStudents;
    }
    // setmetoder
    public void setNrOfStudents(int newNrOfStudents) {
        if (newNrOfStudents < 0) {
            throw new IllegalArgumentException("Antall studenter kan ikke være negativt.");
        }
        nrOfStudents = newNrOfStudents;
    }
    // equals metode (To objekter er definert som like dersom de har samme fagkode)
    public boolean equals(Object obj) {
        if (!(obj instanceof Course)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Course c = (Course) obj;
        return (courseCode.equals(c.getCourseCode()));
    }
    // toString metode
    public String toString() {
        return "Kode: " + courseCode + ", Navn: " + courseName + ", " + nrOfStudents + " studenter.";
    }
} // end class Course

// Klassen CourceCatalogue.java. Klasse for å vedlikeholde en kurskatalog
class CourseCatalogue3 {
    private Course[] courses = new Course[3];  // lite for testformål
    private int nrOfCourses = 0;

    // Vi benytter standardkonstruktøren for å opprette objekter av klassen
// Registrerer nytt kurs. Returnerer false hvis fag med denne koden eksisterer fra før.
    public boolean registerNewCourse(String courseCode, String courseName) {
        if (findCourseGivenCode(courseCode) != null) {
            return false;   // RETUR. Fag er allerede registrert.
        }
        if (nrOfCourses == courses.length) {
            expandTable();  // hjelpemetode nederst i klassen
        }
        courses[nrOfCourses] = new Course(courseCode, courseName);
        nrOfCourses++;
        return true;
    }

    // Returnerer antall kurs registrert.
    public int findNrOfCourses() {
        return nrOfCourses;
    }

    // Returnerer fag med bestemt indeks. Returnerer null hvis ugyldig indeks.
    public Course findCourseGivenIndex(int index) {
        return (index >= 0 && index < nrOfCourses) ? courses[index] : null;
    }

    // Returnerer kurs med gitt kurskode. Returnerer null hvis kurs ikke finnes.
    public Course findCourseGivenCode(String courseCode) {
        if (courseCode != null) {
            for (int i = 0; i < nrOfCourses; i++) {
                if (courses[i].getCourseCode().equals(courseCode.trim())) {
                    return courses[i];
                }
            }
        }
        return null;
    }

    // Oppdaterer antall studenter på bestemt kurs. Returnerer false hvis kurset ikke finnes.
    public boolean updateNrOfStudents(String courseCode, int nrOfStudents) {
        Course c = findCourseGivenCode(courseCode);
        if (c != null) {
            c.setNrOfStudents(nrOfStudents);
            return true;
        } else {
            return false;
        }
    }

    // Sletter et kurs fra katalogen. Returnerer false hvis kurset ikke finnes.
    public boolean deleteCourse(String courseCode) {
        if (courseCode != null) {
            for (int i = 0; i < nrOfCourses; i++) {
                if (courses[i].getCourseCode().equals(courseCode.trim())) { // faget er funnet
                    /* Sletter ved å sette fagene[i] lik siste element i tabellen og reduserer antFag */
                    courses[i] = courses[nrOfCourses - 1];
                    nrOfCourses--;
                    return true;
                }
            }
        }
        return false; // fag ikke funnet, sletter ingenting
    }

    // Hjelpemetode for å "utvide" tabellen */
    private void expandTable() {
        Course[] newTable = new Course[courses.length + 2];  // ny og større tabell
        for (int i = 0; i < courses.length; i++) {  // kopierer data over til ny tabell
            newTable[i] = courses[i];
        }
        courses = newTable;
    }

    // Bygger opp en resultatstreng ved å sende toString()-meldingen til hvert enkelt fagobjekt.
// Legger inn linjeskift mellom hvert fag.
    public String toString() {
        String result = "";
        for (int i = 0; i < nrOfCourses; i++) {
            result += courses[i].toString() + "\n";
        }
        return result;
    }

// Testprogram for klassen. Ett testsett per metode.
// Tester med tom katalog og katalog med fire fag, slik at utvidTabell() blir prøvd.

    public static void main(String[] args) {
        System.out.println("Totalt antall tester: 6");

        CourseCatalogue3 kat0 = new CourseCatalogue3(); // tom katalog
        CourseCatalogue3 kat = new CourseCatalogue3(); // blir fylt med fire fag
        boolean ok1 = kat.registerNewCourse("LC191D", "Videregående programmering");
        boolean ok2 = kat.registerNewCourse("LV172D", "Programmering i Java");
        boolean ok3 = kat.registerNewCourse("LO347D", "Web-applikasjoner");
        boolean ok4 = kat.registerNewCourse("LV172D", "Programmering i Java");
        boolean ok5 = kat.registerNewCourse("LC331D", "IT, miljø og samfunn");
        if (ok1 && ok2 && ok3 && !ok4 && ok5) {
            System.out.println("Kurskatalog: Test 1 vellykket");
        }
        if (kat.findNrOfCourses() == 4 && kat0.findNrOfCourses() == 0) {
            System.out.println("Kurskatalog: Test 2 vellykket");
        }
        Course c1 = kat.findCourseGivenIndex(2);
        Course c2 = kat.findCourseGivenIndex(4);
        Course cc1 = kat0.findCourseGivenIndex(0);
        if (c1.getCourseCode().equals("LO347D") && c2 == null && cc1 == null) {
            System.out.println("Kurskatalog: Test 3 vellykket");
        }
        Course c3 = kat.findCourseGivenCode("LC191D");
        Course c4 = kat.findCourseGivenCode("LC331D");
        Course c5 = kat.findCourseGivenCode("LO331D");
        Course cc2 = kat0.findCourseGivenCode("LC191D");
        if (c3.getCourseName().equals("Videregående programmering")
                && c4.getCourseName().equals("IT, miljø og samfunn") && c5 == null && cc2 == null) {
            System.out.println("Kurskatalog: Test 4 vellykket");
        }

        boolean ok6 = kat.updateNrOfStudents("LC191D", 30);
        boolean ok7 = kat.updateNrOfStudents("LV191D", 30);
        boolean okk1 = kat0.updateNrOfStudents("LV191D", 30);
        Course f6 = kat.findCourseGivenCode("LC191D");
        if (ok6 && !ok7 && f6.getNrOfStudents() == 30 && !okk1) {
            System.out.println("Kurskatalog: Test 5 vellykket");
        }

        boolean ok8 = kat.deleteCourse("LC331D");  // nå er det tre fag igjen
        boolean okk2 = kat0.deleteCourse("LC191D");
        kat0.registerNewCourse("LC191D", "Videregående programmering");
        boolean okk3 = kat0.deleteCourse("LC191D");  // sletter ett fag
        if (ok8 && kat.findNrOfCourses() == 3 && !okk2 && okk3 && kat0.findNrOfCourses() == 0) {
            System.out.println("Kurskatalog: Test 6 vellykket");
        }
    }
}
