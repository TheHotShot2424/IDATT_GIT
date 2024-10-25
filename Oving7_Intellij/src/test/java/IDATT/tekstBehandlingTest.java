package IDATT;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class tekstBehandlingTest {


  @Test
  void antallOrd() {
    //arrange
    var tekstBehandling = new tekstBehandling("Hællæ"); //istedenfor datatype tekstBehandling, kan java forstå dette ved bare bruke "var"
    //act og assert
    assertEquals(5, tekstBehandling.antallOrd());
  }

  @Test
  void gjennomsnittligOrdlengde() {
    var tekstBehandling = new tekstBehandling("Fån dei dei"); //istedenfor datatype tekstBehandling, kan java forstå dette ved bare bruke "var"
    assertTrue(tekstBehandling.gjennomsnittligOrdlengde() == 3);
  }

  @Test
  void ordPerPeriode() {
    var tekstBehandling = new tekstBehandling("Æin fin dag. Ikkje sant eller?");
    assertEquals(3,tekstBehandling.ordPerPeriode());
  }

  @Test
  void bytteOrd() {
    var tekstBehandling = new tekstBehandling("Wild wind whirled");
    assertEquals("Wild størm whirled", tekstBehandling.bytteOrd("wind","størm"));
  }
}