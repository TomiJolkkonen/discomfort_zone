package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Kaikki testit koottuna
 * @author Tomi Jolkkonen, tomi.j.jolkkonen@ßtudent.jyu.fi
 * @version 25.3.2020
 */
@RunWith(Suite.class)
@SuiteClasses({
    Taustaoperaatiot.test.PelaajaTest.class,
    Taustaoperaatiot.test.PelaajatTest.class,
    Taustaoperaatiot.test.JoukkueTest.class,
    Taustaoperaatiot.test.JoukkueetTest.class,
    Taustaoperaatiot.test.NHLtietokantaTest.class
    })
public class AllTests {
 //
}
