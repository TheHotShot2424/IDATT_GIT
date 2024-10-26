package IDATT;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

//@TestInstance(Lifecycle.PER_CLASS) //Denne linjen ville instansiert klassen med en gang, slik at det ikke trengs static mer på @BeforeAll og @AfterAll
class tekstBehandlingTest {

  tekstBehandling tekstBehandling; //må ha denne for BeforeEach som bruker denne som objekt-mal og kopierer fra denne

  @BeforeAll
  public static void starterForst(){ //executer før insance av test-klassen er lagd. Derfor må være static
    System.out.println("Dette bør printe før noen tester har startet");
  }

  @BeforeEach
  public void setup(){ //før hver test. Et nytt objekt lages for hver test.
    tekstBehandling = new tekstBehandling("Wild wind whirled. Vakkert.");
  }

  @Test
  @DisplayName("Mange tester for antallOrd metode")
  void sjekkerAntallOrdGir5NaarStringEr5() {
    //arrange:
    // - alt gjort i BeforeEach
    //act og assert:
    assertFalse(tekstBehandling.antallOrd() == -1);
    assertEquals(27, tekstBehandling.antallOrd());
  }

  @Test
  @DisplayName("Testing av gjennomsnittligOrdlengde-metode - kun for WINDOWS")
  @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Enabled only on Windows") //deaktiverer test avhengig av hvilken OS du bruker
  void gjennomsnittligOrdlengde() {
    assertTrue(tekstBehandling.gjennomsnittligOrdlengde() == 5.5);
  }

  @Test
  @DisplayName("Testing av ordPerPeriode-metode")
  @Disabled //skru den av
  void ordPerPeriode() {
    Assumptions.assumeTrue("Mor di"=="Mor di"); //setter en antakelse før faktiske testen kjører. Den aborteres hvis ikke tilfredsstilt.
    assertEquals(2,tekstBehandling.ordPerPeriode());
  }

  @DisplayName("Testing av bytteOrd-metode - test 5 ganger")
  @RepeatedTest(value = 5,          //gjentar en test. Passer om det er randomness tilknyttet til testen.
      name = "Gjentar ordbyttet {currentRepetition} av {totalRepetitions}")
  void bytteOrd() {
    assertEquals("Wild størm whirled. Vakkert.", tekstBehandling.bytteOrd("wind","størm"));
  }


  @AfterEach
  public void afterEach(){
    System.out.println("Testen er gjort");
  }

  @AfterAll
  public static void afterAll(){
    System.out.println("Testene er fullført");
  }
}