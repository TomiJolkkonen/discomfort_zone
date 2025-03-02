package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite nhltietokanta-ohjelmalle
 * @author Tomi Jolkkonen
 * @version 22.3.2020
 */
@RunWith(Suite.class)
@SuiteClasses({
    kerho.test.PelaajaTest.class,
    kerho.test.PelaajatTest.class,
    kerho.test.JoukkueTest.class,
    kerho.test.JoukkueetTest.class,
    kerho.test.NHLtietokantaTest.class
    })
public class AllTests {
 //
}
