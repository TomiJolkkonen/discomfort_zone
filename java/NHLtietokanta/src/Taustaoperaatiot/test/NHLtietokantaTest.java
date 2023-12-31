package Taustaoperaatiot.test;
// Generated by ComTest BEGIN
import NHLtietokanta.SailoException;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
import Taustaoperaatiot.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2020.04.23 13:02:39 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class NHLtietokantaTest {


  // Generated by ComTest BEGIN  // NHLtietokanta: 16
   private NHLtietokanta nhltietokanta; 
   private Pelaaja sidney1; 
   private Pelaaja sidney2; 
   private int jid1; 
   private int jid2; 
   private Joukkue pittsburghpenguins21; 
   private Joukkue pittsburghpenguins11; 
   private Joukkue pittsburghpenguins22; 
   private Joukkue pittsburghpenguins12; 
   private Joukkue pittsburghpenguins23; 

   public void alustaNHLtietokanta() {
     nhltietokanta = new NHLtietokanta(); 
     sidney1 = new Pelaaja(); sidney1.dummyPelaaja(); sidney1.rekisteroi(); 
     sidney2 = new Pelaaja(); sidney2.dummyPelaaja(); sidney2.rekisteroi(); 
     jid1 = sidney1.getPelaajaID(); 
     jid2 = sidney2.getPelaajaID(); 
     pittsburghpenguins21 = new Joukkue(jid2); pittsburghpenguins21.dummyJoukkue(); 
     pittsburghpenguins11 = new Joukkue(jid1); pittsburghpenguins11.dummyJoukkue(); 
     pittsburghpenguins22 = new Joukkue(jid2); pittsburghpenguins22.dummyJoukkue(); 
     pittsburghpenguins12 = new Joukkue(jid1); pittsburghpenguins12.dummyJoukkue(); 
     pittsburghpenguins23 = new Joukkue(jid2); pittsburghpenguins23.dummyJoukkue(); 
     try {
     nhltietokanta.lisaa(sidney1); 
     nhltietokanta.lisaa(sidney2); 
     nhltietokanta.lisaa(pittsburghpenguins21); 
     nhltietokanta.lisaa(pittsburghpenguins11); 
     nhltietokanta.lisaa(pittsburghpenguins22); 
     nhltietokanta.lisaa(pittsburghpenguins12); 
     nhltietokanta.lisaa(pittsburghpenguins23); 
     } catch ( Exception e) {
        System.err.println(e.getMessage()); 
     }
   }
  // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testLisaa81 */
  @Test
  public void testLisaa81() {    // NHLtietokanta: 81
    alustaNHLtietokanta(); 
    assertEquals("From: NHLtietokanta line: 83", 2, nhltietokanta.etsiPelaaja("*",0).size()); 
    nhltietokanta.lisaa(sidney1); 
    assertEquals("From: NHLtietokanta line: 85", 3, nhltietokanta.etsiPelaaja("*",0).size()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** 
   * testKorvaaTaiLisaa126 
   * @throws SailoException when error
   */
  @Test
  public void testKorvaaTaiLisaa126() throws SailoException {    // NHLtietokanta: 126
    alustaNHLtietokanta(); 
    assertEquals("From: NHLtietokanta line: 129", 2, nhltietokanta.etsiPelaaja("*",0).size()); 
    nhltietokanta.korvaaTaiLisaa(sidney1); 
    assertEquals("From: NHLtietokanta line: 131", 2, nhltietokanta.etsiPelaaja("*",0).size()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testEtsiPelaaja210 */
  @Test
  public void testEtsiPelaaja210() {    // NHLtietokanta: 210
    alustaNHLtietokanta(); 
    Pelaaja jasen3 = new Pelaaja(); jasen3.rekisteroi(); 
    jasen3.aseta(1,"Susi Sepe"); 
    nhltietokanta.lisaa(jasen3); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** 
   * testLueTiedostosta243 
   * @throws SailoException when error
   */
  @Test
  public void testLueTiedostosta243() throws SailoException {    // NHLtietokanta: 243
    String hakemisto = "testikelmit"; 
    File dir = new File(hakemisto); 
    File ftied  = new File(hakemisto+"/pelaajat.dat"); 
    File fhtied = new File(hakemisto+"/joukkueet.dat"); 
    dir.mkdir(); 
    ftied.delete(); 
    fhtied.delete(); 
    nhltietokanta = new NHLtietokanta();  // tiedostoja ei ole, tulee poikkeus 
    try {
        nhltietokanta.lueTiedostosta(hakemisto);
    } catch (Taustaoperaatiot.SailoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
    fail("NHLtietokanta: 257 Did not throw SailoException");
    alustaNHLtietokanta(); 
    nhltietokanta.setTiedosto(hakemisto);  // nimi annettava koska uusi poisti sen
    try {
        nhltietokanta.tallenna();
    } catch (Taustaoperaatiot.SailoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
    nhltietokanta = new NHLtietokanta(); 
    try {
        nhltietokanta.lueTiedostosta(hakemisto);
    } catch (Taustaoperaatiot.SailoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
    try {
        nhltietokanta.tallenna();
    } catch (Taustaoperaatiot.SailoException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }  // tekee molemmista .bak
    assertEquals("From: NHLtietokanta line: 264", true, ftied.delete()); 
    assertEquals("From: NHLtietokanta line: 265", true, fhtied.delete()); 
    File fbak = new File(hakemisto+"/nimet.bak"); 
    File fhbak = new File(hakemisto+"/harrastukset.bak"); 
    assertEquals("From: NHLtietokanta line: 268", true, fbak.delete()); 
    assertEquals("From: NHLtietokanta line: 269", true, fhbak.delete()); 
    assertEquals("From: NHLtietokanta line: 270", true, dir.delete()); 
  } // Generated by ComTest END
}