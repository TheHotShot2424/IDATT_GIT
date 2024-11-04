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
class CourseCatalogue2 {
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

    /* Oppgave 1a */
    public int findTotNrOfStudents() {
        int sum = 0;
        for (int i = 0; i < nrOfCourses; i++) {
            sum += courses[i].getNrOfStudents();
        }
        return sum;
    }

    /* Oppgave 1b */
    private int findMaxNrOfStudents() {
        if (nrOfCourses > 0) {
            int max = courses[0].getNrOfStudents();
            for (int i = 1; i < nrOfCourses; i++) {
                if (courses[i].getNrOfStudents() > max) {
                    max = courses[i].getNrOfStudents();
                }
            }
            return max;
        }
        return 0; // ingen fag registrert
    }

    /* Oppgave 1c */
    public Course[] findBiggestCourse() {
        int max = findMaxNrOfStudents();   // hjelpemetode, se nedenfor
        Course[] courseMax = new Course[nrOfCourses];
        int nrOfCoursesEqualsMax = 0;
        for (int i = 0; i < nrOfCourses; i++) {
            if (courses[i].getNrOfStudents() == max) {
                courseMax[nrOfCoursesEqualsMax] = courses[i];
                nrOfCoursesEqualsMax++;
            }
        }
        Course[] nyTab = new Course[nrOfCoursesEqualsMax];
        for (int i = 0; i < nrOfCoursesEqualsMax; i++) {
            nyTab[i] = courseMax[i];
        }
        return nyTab;
    }

// Testprogram for klassen. Ett testsett per metode.
// Tester med tom katalog og katalog med fire fag, slik at utvidTabell() blir prøvd.

    public static void main(String[] args) {
        System.out.println("Totalt antall tester: 4");

        CourseCatalogue2 cat0 = new CourseCatalogue2(); // tom katalog
        Course[] course0 = cat0.findBiggestCourse();
        if (course0.length == 0) {
            System.out.println("Test 1 is a success");
        }
        if (cat0.findTotNrOfStudents() == 0) {
            System.out.println("Test 2 is a success");

            CourseCatalogue2 cat = new CourseCatalogue2(); // blir fylt med fem fag
            boolean ok1 = cat.registerNewCourse("LC191D", "Videregående programmering");
            boolean ok2 = cat.registerNewCourse("LV172D", "Programmering i Java");
            boolean ok3 = cat.registerNewCourse("LO347D", "Web-applikasjoner");
            boolean ok4 = cat.registerNewCourse("LO172D", "Programmering i Java");
            boolean ok5 = cat.registerNewCourse("LC331D", "IT, miljø og samfunn");

            cat.updateNrOfStudents("LC191D", 20);
            cat.updateNrOfStudents("LV172D", 30);
            cat.updateNrOfStudents("LO347D", 20);
            cat.updateNrOfStudents("LO172D", 30);
            cat.updateNrOfStudents("LC331D", 30);

            Course[] course = cat.findBiggestCourse();

            if (course.length == 3 && course[0].getCourseCode().equals("LV172D")
                    && course[1].getCourseCode().equals("LO172D")
                    && course[2].getCourseCode().equals("LC331D")) {
                System.out.println("Test 3 is a success");
            }

            if (cat.findTotNrOfStudents() == 130) {
                System.out.println("Test 4 is a success");
            }
        }
    }
}